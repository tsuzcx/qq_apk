package com.tencent.open.filedownload.ui;

import acfp;
import android.content.Context;
import android.util.AttributeSet;
import anot;
import asap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class WhiteListDownloadButton
  extends ApkFileDownloadButton
{
  public WhiteListDownloadButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WhiteListDownloadButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public WhiteListDownloadButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    emr();
  }
  
  protected void dC(String paramString, boolean paramBoolean)
  {
    QQAppInterface localQQAppInterface;
    if ((paramBoolean) && (("900".equals(paramString)) || ("400".equals(paramString))))
    {
      localQQAppInterface = ((BaseActivity)getContext()).app;
      if (this.c.name != null) {
        break label70;
      }
    }
    label70:
    for (paramString = "";; paramString = this.c.name)
    {
      anot.a(localQQAppInterface, "dc00898", "", "", "0X8009AC6", "0X8009AC6", 0, 0, "", "", paramString, "");
      return;
    }
  }
  
  protected String gx(int paramInt)
  {
    if (paramInt == 4) {
      return acfp.m(2131716934);
    }
    return acfp.m(2131716935);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.filedownload.ui.WhiteListDownloadButton
 * JD-Core Version:    0.7.0.1
 */