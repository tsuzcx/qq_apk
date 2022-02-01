package com.tencent.android.tpush;

import android.content.Context;
import com.tencent.android.tpush.common.i;
import com.tencent.tpns.baseapi.base.PushPreferences;

final class XGPush4Msdk$1
  implements Runnable
{
  XGPush4Msdk$1(Context paramContext) {}
  
  public void run()
  {
    if (!i.b(PushPreferences.getString(this.a, XGPush4Msdk.a(this.a), null))) {
      PushPreferences.remove(this.a, XGPush4Msdk.a(this.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.XGPush4Msdk.1
 * JD-Core Version:    0.7.0.1
 */