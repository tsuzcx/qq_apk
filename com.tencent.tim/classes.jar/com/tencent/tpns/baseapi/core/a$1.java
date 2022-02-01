package com.tencent.tpns.baseapi.core;

import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;

final class a$1
  implements Runnable
{
  a$1(Context paramContext, long paramLong) {}
  
  public void run()
  {
    PushPreferences.putLong(this.a, "XG_V2_ACCESS_ID", this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tpns.baseapi.core.a.1
 * JD-Core Version:    0.7.0.1
 */