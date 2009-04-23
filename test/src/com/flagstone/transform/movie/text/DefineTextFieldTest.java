/*
 * PlaceTest.java
 * Transform
 *
 * Copyright (c) 2009 Flagstone Software Ltd. All rights reserved.
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
package com.flagstone.transform.movie.text;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

import com.flagstone.transform.ColorTransform;
import com.flagstone.transform.CoordTransform;
import com.flagstone.transform.coder.CoderException;
import com.flagstone.transform.coder.Context;
import com.flagstone.transform.coder.SWFDecoder;
import com.flagstone.transform.coder.SWFEncoder;
import com.flagstone.transform.text.DefineTextField;

@SuppressWarnings( { 
	"PMD.LocalVariableCouldBeFinal",
	"PMD.JUnitAssertionsShouldIncludeMessage" 
})
public final class DefineTextFieldTest {
	
	private transient DefineTextField fixture;
	
	private transient final byte[] encoded = new byte[] { 0x06, 0x01, 
			0x01, 0x00, 0x02, 0x00, 0x06, 0x50};
	
	private transient final byte[] extended = new byte[] { 0x7F, 0x01, 
			0x06, 0x00, 0x00, 0x00, 0x01, 0x00, 0x02, 0x00, 0x06, 0x50};

	@Test @Ignore
	public void checkCopy() {
		//fixture = new DefineTextField(identifier, layer, transform, colorTransform);
		DefineTextField copy = fixture.copy();

		assertNotSame(fixture, copy);
	}
	
	@Test @Ignore
	public void encodeCoordTransform() throws CoderException {		
		SWFEncoder encoder = new SWFEncoder(encoded.length);		
		Context context = new Context();

		//fixture = new DefineTextField(identifier, layer, transform);
		assertEquals(encoded.length, fixture.prepareToEncode(encoder, context));
		fixture.encode(encoder, context);
		
		assertTrue(encoder.eof());
	}

	@Test @Ignore
	public void decode() throws CoderException {
		SWFDecoder decoder = new SWFDecoder(encoded);
		Context context = new Context();

		fixture = new DefineTextField(decoder, context);
		
		assertTrue(decoder.eof());
	}
	
	@Test @Ignore
	public void decodeExtended() throws CoderException {
		SWFDecoder decoder = new SWFDecoder(extended);
		Context context = new Context();

		fixture = new DefineTextField(decoder, context);
		
		assertTrue(decoder.eof());
	}
}
