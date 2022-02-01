package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.g;

public class cm
  implements cf
{
  public long a = 0L;
  public ck b = null;
  private Handler d = null;
  private ew e = null;
  
  public cm()
  {
    d();
  }
  
  public void a()
  {
    Handler localHandler = this.d;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(10);
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
    Handler localHandler = this.d;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(12);
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
    Handler localHandler = this.d;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(15);
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
      this.e = ev.a();
      if ((!c) && (this.e == null)) {
        throw new AssertionError();
      }
      this.b = new ck(this);
      this.b.a(this.e);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RESULT_ERROR!!!");
      localStringBuilder.append(localException.getMessage());
      g.c(localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.cm
 * JD-Core Version:    0.7.0.1
 */