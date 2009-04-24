/*
 *  FontConstructor.java
 *  Transform Utilities
 *
 * Copyright (c) 2001-2009 Flagstone Software Ltd. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice, this
 *    list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright notice, 
 *    this list of conditions and the following disclaimer in the documentation 
 *    and/or other materials provided with the distribution.
 *  * Neither the name of Flagstone Software Ltd. nor the names of its contributors 
 *    may be used to endorse or promote products derived from this software 
 *    without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND 
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED 
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. 
 * IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, 
 * INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, 
 * BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, 
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF 
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE 
 * OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED 
 * OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.flagstone.transform.util.font;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 */
public final class FontRegistry
{
	private static Map<FontEncoding, FontProvider> providers = new LinkedHashMap<FontEncoding, FontProvider>();

	static {
		for (FontEncoding encoding : FontEncoding.values()) {
			registerProvider(encoding, encoding.getProvider());
		}
	}
	/**
	 * Register an FontDecoder to handle images in the specified format. The 
	 * image formats currently supported are defined in the {@link FontInfo} class.
	 * 
	 * @param encoding the string identifying the image format. 
	 * @param decoder any class that implements the FontDecoder interface.
	 */
	public static void registerProvider(FontEncoding encoding, FontProvider decoder)
	{
		providers.put(encoding, decoder);
	}
	
	public static FontDecoder getFontProvider(FontEncoding encoding) {
		
    	if (providers.containsKey(encoding)) {
    		return providers.get(encoding).newDecoder();
    	} else {
    		throw new IllegalArgumentException();
    	}
	}
}