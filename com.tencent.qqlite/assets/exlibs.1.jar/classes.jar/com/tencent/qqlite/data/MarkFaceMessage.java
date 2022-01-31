package com.tencent.qqlite.data;

import java.io.Serializable;

public class MarkFaceMessage
  implements Serializable
{
  public static final long serialVersionUID = 102222L;
  public int cFaceInfo = 1;
  public int cSubType = 3;
  public int dwMSGItemType = 6;
  public int dwTabID;
  public String faceName = null;
  public int imageHeight = 0;
  public int imageWidth = 0;
  public long index = 0L;
  public int mediaType = 0;
  public byte[] mobileparam;
  public byte[] sbfKey;
  public byte[] sbufID;
  public int wSize = 37;
  
  public static MarkFaceMessage copy(com.tencent.mobileqq.data.MarkFaceMessage paramMarkFaceMessage)
  {
    MarkFaceMessage localMarkFaceMessage = new MarkFaceMessage();
    localMarkFaceMessage.index = paramMarkFaceMessage.index;
    localMarkFaceMessage.dwMSGItemType = paramMarkFaceMessage.dwMSGItemType;
    localMarkFaceMessage.cFaceInfo = paramMarkFaceMessage.cFaceInfo;
    localMarkFaceMessage.wSize = paramMarkFaceMessage.wSize;
    localMarkFaceMessage.sbufID = paramMarkFaceMessage.sbufID;
    localMarkFaceMessage.dwTabID = paramMarkFaceMessage.dwTabID;
    localMarkFaceMessage.cSubType = paramMarkFaceMessage.cSubType;
    localMarkFaceMessage.sbfKey = paramMarkFaceMessage.sbfKey;
    localMarkFaceMessage.mediaType = paramMarkFaceMessage.mediaType;
    localMarkFaceMessage.imageWidth = paramMarkFaceMessage.imageWidth;
    localMarkFaceMessage.imageHeight = paramMarkFaceMessage.imageHeight;
    localMarkFaceMessage.mobileparam = paramMarkFaceMessage.mobileparam;
    return localMarkFaceMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.qqlite.data.MarkFaceMessage
 * JD-Core Version:    0.7.0.1
 */