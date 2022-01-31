package com.tencent.token;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.tencent.token.global.e;
import com.tencent.token.utils.o;

public class as
  implements al
{
  public long a = 0L;
  public aq b = null;
  public o c = null;
  private Handler e = null;
  private gr f = null;
  
  static
  {
    if (!as.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      d = bool;
      return;
    }
  }
  
  public as()
  {
    try
    {
      this.f = gq.a();
      if ((!d) && (this.f == null)) {
        throw new AssertionError();
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      e.c("RESULT_ERROR!!!" + localException.getMessage());
    }
    for (;;)
    {
      this.c = new o(this);
      return;
      this.b = new aq(this);
      this.b.a(this.f);
    }
  }
  
  public final void a()
  {
    if (this.e == null) {
      return;
    }
    this.e.sendEmptyMessage(10);
  }
  
  public final void a(int paramInt)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putInt("serTime", paramInt);
    localMessage.what = 13;
    localMessage.setData(localBundle);
    this.e.sendMessage(localMessage);
  }
  
  public final void a(int paramInt, String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("error", paramString);
    localMessage.what = 9;
    localMessage.setData(localBundle);
    this.e.sendMessage(localMessage);
  }
  
  public final void a(Handler paramHandler)
  {
    this.e = paramHandler;
  }
  
  public final void a(String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramString);
    localMessage.what = 14;
    localMessage.setData(localBundle);
    this.e.sendMessage(localMessage);
  }
  
  public final void b()
  {
    if (this.e == null) {
      return;
    }
    this.e.sendEmptyMessage(12);
  }
  
  public final void b(int paramInt, String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putInt("errCode", paramInt);
    localBundle.putString("error", paramString);
    localMessage.what = 11;
    localMessage.setData(localBundle);
    this.e.sendMessage(localMessage);
  }
  
  public final void b(String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("ucSmsPort", paramString);
    localMessage.what = 1;
    localMessage.setData(localBundle);
    this.e.sendMessage(localMessage);
  }
  
  public final void c()
  {
    if (this.e == null) {
      return;
    }
    this.e.sendEmptyMessage(15);
  }
  
  public final void c(String paramString)
  {
    if (this.e == null) {
      return;
    }
    Message localMessage = Message.obtain();
    Bundle localBundle = new Bundle();
    localBundle.putString("error", paramString);
    localMessage.what = 2;
    localMessage.setData(localBundle);
    this.e.sendMessage(localMessage);
  }
  
  public final void d()
  {
    if (this.e == null) {
      return;
    }
    this.e.sendEmptyMessage(3);
  }
  
  public final void e()
  {
    if (this.e == null) {
      return;
    }
    this.e.sendEmptyMessage(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.as
 * JD-Core Version:    0.7.0.1
 */