package com.oasisfeng.condom;

import android.content.Intent;
import android.support.annotation.Keep;

@Keep
public abstract interface OutboundJudge
{
  public abstract boolean shouldAllow(OutboundType paramOutboundType, Intent paramIntent, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.oasisfeng.condom.OutboundJudge
 * JD-Core Version:    0.7.0.1
 */