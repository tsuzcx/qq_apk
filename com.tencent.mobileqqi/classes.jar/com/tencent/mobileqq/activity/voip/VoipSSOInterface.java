package com.tencent.mobileqq.activity.voip;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;

public class VoipSSOInterface
{
  protected QQAppInterface a;
  
  public VoipSSOInterface(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    this.a = paramQQAppInterface;
    ((VoipSSOHandler)this.a.a(42)).a(paramHandler);
  }
  
  public void a()
  {
    ((VoipSSOHandler)this.a.a(42)).a();
  }
  
  public void a(Bundle paramBundle)
  {
    ((VoipSSOHandler)this.a.a(42)).a(paramBundle);
  }
  
  public void a(String paramString)
  {
    ((VoipSSOHandler)this.a.a(42)).a(paramString);
  }
  
  public void b()
  {
    ((VoipSSOHandler)this.a.a(42)).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipSSOInterface
 * JD-Core Version:    0.7.0.1
 */