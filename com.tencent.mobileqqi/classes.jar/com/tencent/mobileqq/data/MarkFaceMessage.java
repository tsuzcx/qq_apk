package com.tencent.mobileqq.data;

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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MarkFaceMessage
 * JD-Core Version:    0.7.0.1
 */