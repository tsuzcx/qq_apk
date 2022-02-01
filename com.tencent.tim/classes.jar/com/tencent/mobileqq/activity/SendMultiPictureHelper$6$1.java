package com.tencent.mobileqq.activity;

import agkh;
import aqiw;
import aqju;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import vtm;
import vtm.a;
import vts;

public class SendMultiPictureHelper$6$1
  implements Runnable
{
  public SendMultiPictureHelper$6$1(vts paramvts) {}
  
  public void run()
  {
    if (aqiw.isNetSupport(this.a.this$0.mActivity)) {
      return;
    }
    this.a.this$0.bao = true;
    vtm.a(this.a.this$0);
    this.a.this$0.mApp.a().deleteObserver(this.a.this$0.c);
    int i = 1;
    while (i < this.a.this$0.pz.size())
    {
      this.a.this$0.a((vtm.a)this.a.this$0.pz.get(i), this.a.this$0.mType, this.a.this$0.aPS, this.a.this$0.mUin);
      this.a.this$0.mDialog.setMessage(String.format(this.a.this$0.aPU, new Object[] { Integer.valueOf(this.a.this$0.mCurrentIndex + i), Integer.valueOf(this.a.this$0.mTotalSize), Integer.valueOf(0) }));
      i += 1;
    }
    this.a.this$0.bKx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.SendMultiPictureHelper.6.1
 * JD-Core Version:    0.7.0.1
 */