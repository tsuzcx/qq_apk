package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import anpc;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.HashMap;

class EmoticonPanelController$5
  implements Runnable
{
  EmoticonPanelController$5(EmoticonPanelController paramEmoticonPanelController, int paramInt, long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    String str;
    SharedPreferences localSharedPreferences;
    int i;
    Object localObject;
    if (this.this$0.app != null)
    {
      str = this.this$0.app.getCurrentAccountUin();
      if ((this.this$0.context != null) && (str != null))
      {
        localSharedPreferences = this.this$0.context.getSharedPreferences("emoticon_panel_" + str, 0);
        long l = localSharedPreferences.getLong("sp_key_emoticon_panel_last_report_time", 0L);
        i = localSharedPreferences.getInt("sp_key_emoticon_panel_report_count", 0);
        if (System.currentTimeMillis() - l <= 86400000L) {
          break label269;
        }
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putLong("sp_key_emoticon_panel_last_report_time", System.currentTimeMillis());
        ((SharedPreferences.Editor)localObject).putInt("sp_key_emoticon_panel_report_count", 0);
        ((SharedPreferences.Editor)localObject).apply();
        i = 0;
      }
    }
    label269:
    for (;;)
    {
      if (i < 10)
      {
        localObject = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
        switch (this.cSi)
        {
        }
      }
      for (;;)
      {
        anpc.a(this.this$0.context).collectPerformance(str, (String)localObject, true, this.val$duration, 0L, this.aK, "", false);
        localObject = localSharedPreferences.edit();
        ((SharedPreferences.Editor)localObject).putInt("sp_key_emoticon_panel_report_count", i + 1);
        ((SharedPreferences.Editor)localObject).apply();
        return;
        localObject = "report_AIOEmoticonPanel_OpenFirstTimeInProcess";
        continue;
        localObject = "report_AIOEmoticonPanel_OpenFirstTimeInAIO";
        continue;
        localObject = "report_AIOEmoticonPanel_ReopenInAIO";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.5
 * JD-Core Version:    0.7.0.1
 */