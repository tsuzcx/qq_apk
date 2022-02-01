package com.tencent.android.tpush.service.util;

import android.content.Context;
import android.net.Uri;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.crosssp.ProviderMessage;

final class f$1
  implements Runnable
{
  f$1(Context paramContext, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      if (f.e(this.a, this.b)) {
        return;
      }
      Uri localUri = Uri.parse("content://" + this.c);
      ProviderMessage.getType(this.a, localUri);
      return;
    }
    catch (Throwable localThrowable)
    {
      TLogger.d("ServiceUtil", "unexpected for start provider for providerUrl:" + this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.service.util.f.1
 * JD-Core Version:    0.7.0.1
 */