package com.tencent.qqlive.tvkplayer.vinfo.apiinner;

import org.w3c.dom.Document;

public abstract interface ITVKCGIVkeyResponse
{
  public abstract void onVkeyFailure(String paramString1, String paramString2, int paramInt);
  
  public abstract void onVkeySuccess(String paramString1, String paramString2, Document paramDocument);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.tvkplayer.vinfo.apiinner.ITVKCGIVkeyResponse
 * JD-Core Version:    0.7.0.1
 */