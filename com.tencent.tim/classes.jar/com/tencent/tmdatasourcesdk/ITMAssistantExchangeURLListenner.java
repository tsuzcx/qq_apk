package com.tencent.tmdatasourcesdk;

import com.tencent.tmdatasourcesdk.internal.protocol.jce.AppSimpleDetail;
import java.util.ArrayList;

public abstract interface ITMAssistantExchangeURLListenner
{
  public abstract void onExchangedURLSucceed(ArrayList<AppSimpleDetail> paramArrayList, boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmdatasourcesdk.ITMAssistantExchangeURLListenner
 * JD-Core Version:    0.7.0.1
 */