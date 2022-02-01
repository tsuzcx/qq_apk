package com.tencent.av.ui;

import android.content.SharedPreferences;
import aqmj;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.qphone.base.util.QLog;
import iiv;
import org.json.JSONException;
import org.json.JSONObject;

class DoubleVideoCtrlUI$6
  implements Runnable
{
  DoubleVideoCtrlUI$6(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void run()
  {
    if (this.this$0.mApp == null) {}
    for (;;)
    {
      return;
      if ((this.this$0.a != null) && (this.this$0.a.b() != null))
      {
        Object localObject = aqmj.g(this.this$0.mApp.getCurrentAccountUin()).getString("AvWeakNet_video_ConfigContent", "");
        if (((String)localObject).length() == 0)
        {
          QLog.d(this.this$0.TAG, 1, "cannot Read AvWeaknetConfig");
          return;
        }
        try
        {
          localObject = new JSONObject((String)localObject);
          if (((JSONObject)localObject).has("ground_glass_switch_android"))
          {
            if (((JSONObject)localObject).getInt("ground_glass_switch_android") == 1) {
              this.this$0.a.b().Rk = true;
            }
            if (((JSONObject)localObject).has("ground_glass_default_interval")) {
              this.this$0.a.b().ann = ((JSONObject)localObject).getInt("ground_glass_default_interval");
            }
            if (((JSONObject)localObject).has("ground_glass_default_timeout_rule")) {
              this.this$0.a.b().ano = ((JSONObject)localObject).getInt("ground_glass_default_timeout_rule");
            }
            QLog.d(this.this$0.TAG, 1, "AsyncReadDoubleGlassConfig mIsGlassCanUse=" + this.this$0.a.b().Rk + ", mCurrentVideoGlassWaitTime=" + this.this$0.a.b().ann + ", mCurrentDefaultTimeOutRule=" + this.this$0.a.b().ano);
            if ((this.this$0.a.b().Rk) && (this.this$0.a.b().ann > 0))
            {
              DoubleVideoCtrlUI.a(this.this$0, true);
              return;
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.DoubleVideoCtrlUI.6
 * JD-Core Version:    0.7.0.1
 */