package com.flagstone.transform.filter;

import com.flagstone.transform.coder.CoderException;
import com.flagstone.transform.coder.Context;
import com.flagstone.transform.coder.SWFDecoder;
import com.flagstone.transform.coder.SWFEncoder;

public final class DropShadowFilter implements Filter {

	public DropShadowFilter(DropShadowFilter object) {
		
	}
	
	public DropShadowFilter copy() {
		return new DropShadowFilter(this);	}

	public int prepareToEncode(final SWFEncoder coder, final Context context)
	{
		return 0;
	}

	public void encode(final SWFEncoder coder, final Context context) throws CoderException
	{
	}

	public void decode(final SWFDecoder coder, final Context context) throws CoderException
	{
	}
}
