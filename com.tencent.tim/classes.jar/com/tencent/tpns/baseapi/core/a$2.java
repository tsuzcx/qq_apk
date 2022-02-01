package com.tencent.tpns.baseapi.core;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;

final class a$2
  implements Runnable
{
  a$2(Context paramContext, String paramString) {}
  
  public void run()
  {
    PushPreferences.putString(this.a, "XG_V2_ACCESS_KEY", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.a.2
 * JD-Core Version:    0.7.0.1
 */