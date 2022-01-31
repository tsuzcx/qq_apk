package com.tencent.securemodule;

import android.content.Intent;
import com.tencent.securemodule.impl.SecureService;
import java.util.ArrayList;

public final class w
  extends u
{
  private int a = 0;
  
  public w(SecureService paramSecureService) {}
  
  public final void a()
  {
    SecureService.a(this.b, "1000020", null);
  }
  
  public final void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public final void a(ArrayList<r> paramArrayList)
  {
    if (paramArrayList.size() > 0)
    {
      SecureService.a(this.b, "1000022", paramArrayList);
      paramArrayList = new Intent();
      paramArrayList.setAction("1000030");
      this.b.sendBroadcast(paramArrayList);
      return;
    }
    if (this.a != 0) {
      SecureService.a(this.b, "1000023", null);
    }
    for (;;)
    {
      paramArrayList = new Intent();
      paramArrayList.setAction("1000031");
      paramArrayList.putExtra("key_errcode", this.a);
      this.b.sendBroadcast(paramArrayList);
      return;
      SecureService.a(this.b, "1000021", null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.w
 * JD-Core Version:    0.7.0.1
 */