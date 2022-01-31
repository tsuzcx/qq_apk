package com.tencent.securemodule;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.securemodule.impl.SecureService;
import org.apache.http.params.HttpParams;

public class y
{
  HttpParams a = null;
  boolean b = false;
  String c = null;
  int d = 0;
  public a e = null;
  
  protected final void a(int paramInt, Bundle paramBundle)
  {
    if (this.e != null)
    {
      if (paramInt != 1) {
        break label26;
      }
      SecureService.a(this.e.a, "1000026", paramBundle);
    }
    label26:
    while (paramInt != 2) {
      return;
    }
    SecureService.a(this.e.a, "1000025", paramBundle);
  }
  
  public static final class a
  {
    public a() {}
    
    public a(SecureService paramSecureService) {}
    
    public static void a(Context paramContext, int paramInt, String paramString)
    {
      paramContext = paramContext.getSharedPreferences("secure_config", 0).edit();
      paramContext.putString(String.format("%5d", new Object[] { Integer.valueOf(paramInt) }), paramString);
      paramContext.commit();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.y
 * JD-Core Version:    0.7.0.1
 */