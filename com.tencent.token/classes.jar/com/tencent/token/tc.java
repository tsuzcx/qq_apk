package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

public class tc
  implements sv
{
  public long a = 0L;
  public ta b = null;
  private Handler d = null;
  private ajk e = null;
  
  public tc()
  {
    try
    {
      this.e = ajj.a();
      if ((!c) && (this.e == null)) {
        throw new AssertionError();
      }
      this.b = new ta(this);
      this.b.a = this.e;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("RESULT_ERROR!!!");
      localStringBuilder.append(localException.getMessage());
      xj.c(localStringBuilder.toString());
    }
  }
  
  public final void a()
  {
    Handler localHandler = this.d;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(10);
  }
  
  public final void a(int paramInt)
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
  
  public final void a(int paramInt, String paramString)
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
  
  public final void a(String paramString)
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
  
  public final void b()
  {
    Handler localHandler = this.d;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(12);
  }
  
  public final void b(int paramInt, String paramString)
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
  
  public final void b(String paramString)
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
  
  public final void c()
  {
    Handler localHandler = this.d;
    if (localHandler == null) {
      return;
    }
    localHandler.sendEmptyMessage(15);
  }
  
  public final void c(String paramString)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.tc
 * JD-Core Version:    0.7.0.1
 */