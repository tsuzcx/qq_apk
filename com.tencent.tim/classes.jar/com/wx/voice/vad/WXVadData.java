package com.wx.voice.vad;

import java.util.ArrayList;

public class WXVadData
{
  public int RET_STATE;
  public long blocksize;
  public ArrayList<WXVadSeg> offline_odata;
  public short[] online_odata;
  
  public void OfflineOutDataAdd(WXVadSeg paramWXVadSeg)
  {
    this.offline_odata.add(paramWXVadSeg);
  }
  
  public void OfflineOutDataInit()
  {
    this.offline_odata = new ArrayList();
  }
  
  public void OutDataInit(int paramInt)
  {
    this.online_odata = new short[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.wx.voice.vad.WXVadData
 * JD-Core Version:    0.7.0.1
 */