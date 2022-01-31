package com.tencent.mobileqq.pic;

import com.tencent.mobileqq.activity.PredownloadTest.ConfigInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import java.util.HashMap;

public abstract interface PreDownloadStrategy
{
  public abstract PredownloadTest.ConfigInfo a();
  
  public abstract HashMap a();
  
  public abstract void a(long paramLong, int paramInt);
  
  public abstract void a(PredownloadTest.ConfigInfo paramConfigInfo);
  
  public abstract void a(QQAppInterface paramQQAppInterface);
  
  public abstract void a(MessageForPic paramMessageForPic);
  
  public abstract void a(MessageForPic paramMessageForPic, long paramLong);
  
  public abstract boolean a(long paramLong, int paramInt1, int paramInt2);
  
  public abstract boolean[] a(int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pic.PreDownloadStrategy
 * JD-Core Version:    0.7.0.1
 */