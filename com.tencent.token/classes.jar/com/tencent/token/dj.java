package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.h;

public class dj
  implements dc
{
  public long a = 0L;
  public dh b = null;
  private Handler d = null;
  private gg e = null;
  
  static
  {
    if (!dj.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
  }
  
  public dj()
  {
    d();
  }
  
  public void a()
  {
    if (this.d == null) {
      return;
    }
    this.d.sendEmptyMessage(10);
  }
  
  public void a(int paramInt)
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putInt("serTime", paramInt);
    localMessage.what = 13;
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void a(int paramInt, String paramString)
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("error", paramString);
    localMessage.what = 9;
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void a(Handler paramHandler)
  {
    this.d = paramHandler;
  }
  
  public void a(String paramString)
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramString);
    localMessage.what = 14;
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void b()
  {
    if (this.d == null) {
      return;
    }
    this.d.sendEmptyMessage(12);
  }
  
  public void b(int paramInt, String paramString)
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("error", paramString);
    localMessage.what = 11;
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void b(String paramString)
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("ucSmsPort", paramString);
    localMessage.what = 1;
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void c()
  {
    if (this.d == null) {
      return;
    }
    this.d.sendEmptyMessage(15);
  }
  
  public void c(String paramString)
  {
    if (this.d == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramString);
    localMessage.what = 2;
    localMessage.setData(localBundle);
    this.d.sendMessage(localMessage);
  }
  
  public void d()
  {
    try
    {
      this.e = gf.a();
      if ((!c) && (this.e == null)) {
        throw new AssertionError();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      h.c("RESULT_ERROR!!!" + localException.getMessage());
      return;
    }
    this.b = new dh(this);
    this.b.a(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.dj
 * JD-Core Version:    0.7.0.1
 */