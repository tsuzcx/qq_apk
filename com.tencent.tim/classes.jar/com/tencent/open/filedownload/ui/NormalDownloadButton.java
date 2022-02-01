package com.tencent.open.filedownload.ui;

import acfp;
import android.content.Context;
import android.util.AttributeSet;

public class NormalDownloadButton
  extends ApkFileDownloadButton
{
  public NormalDownloadButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public NormalDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public NormalDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected String gw(int paramInt)
  {
    return acfp.m(2131709142);
  }
  
  protected String gx(int paramInt)
  {
    if (paramInt == 4) {
      return acfp.m(2131709143);
    }
    return acfp.m(2131709141);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.NormalDownloadButton
 * JD-Core Version:    0.7.0.1
 */