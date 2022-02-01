package com.tencent.biz;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import java.util.concurrent.ConcurrentHashMap;
import jml;
import joo;
import jop;

public class AuthorizeConfig$1
  implements Runnable
{
  public AuthorizeConfig$1(jml paramjml) {}
  
  public void run()
  {
    long l = SystemClock.currentThreadTimeMillis();
    if (l > jml.qk + 10000L)
    {
      this.this$0.mContext.getSharedPreferences("domainCmdRight", 4);
      jml.qk = l;
    }
    FlatBuffersParser.updateEnable();
    l = this.this$0.mPref.getLong("lastUpdate", 0L);
    if (l != jml.sLastUpdateTime)
    {
      jml.sLastUpdateTime = l;
      this.this$0.jdField_a_of_type_Jop.ayO();
      this.this$0.jdField_a_of_type_Joo.clear();
      this.this$0.I = null;
      this.this$0.B = null;
      this.this$0.C = null;
      this.this$0.A = null;
      this.this$0.s = null;
      this.this$0.aO.clear();
      this.this$0.aP.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.AuthorizeConfig.1
 * JD-Core Version:    0.7.0.1
 */