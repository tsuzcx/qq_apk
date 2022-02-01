package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule;
import com.tencent.biz.pubaccount.readinjoy.model.SelectPositionModule.PositionData;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import kbp;
import kqo;
import kxm;
import kyn;
import lbz;
import lhn;
import org.json.JSONObject;

public final class ChannelCoverView$4
  implements Runnable
{
  public ChannelCoverView$4(ChannelCoverInfo paramChannelCoverInfo, int paramInt1, int paramInt2, int paramInt3, String paramString) {}
  
  public void run()
  {
    int i = 1;
    str = "";
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject();
        ((JSONObject)localObject1).put("folder_status", kxm.aMw);
        if (this.c != null) {
          ((JSONObject)localObject1).put("channel_id", this.c.mChannelCoverId);
        }
        ((JSONObject)localObject1).put("current_channel_id", 0);
        if (NetworkState.isWifiConn()) {
          i = 2;
        }
        ((JSONObject)localObject1).put("network_type", i);
        if (this.aLn != kqo.aLk) {
          continue;
        }
        ((JSONObject)localObject1).put("channel_type", "2");
        if ((this.c == null) || (this.c.mColumnType != 0)) {
          continue;
        }
        ((JSONObject)localObject1).put("content_type", 1);
      }
      catch (Exception localException)
      {
        Object localObject2;
        Object localObject1 = str;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ChannelCoverView", 2, "ERROR Exception=" + localException.getMessage());
        localObject1 = str;
        continue;
        ((JSONObject)localObject1).put("content_type", 2);
        continue;
        ((JSONObject)localObject1).put("channelid_to_mainfeeds", 0);
        continue;
      }
      if (this.aLo != -1) {
        ((JSONObject)localObject1).put("reddot_status", this.aLo);
      }
      if (this.val$location != -1) {
        ((JSONObject)localObject1).put("location", this.val$location + 1);
      }
      if (this.c != null) {
        ((JSONObject)localObject1).put("is_change", kyn.a(kxm.getAppRuntime(), this.c.mChannelCoverId));
      }
      ((JSONObject)localObject1).put("style", 0);
      if ((this.c != null) && (this.c.mChannelCoverId == 41695))
      {
        localObject2 = lbz.a().a();
        if (localObject2 != null)
        {
          localObject2 = ((SelectPositionModule)localObject2).a();
          if (localObject2 != null)
          {
            ((JSONObject)localObject1).put("channel_city", ((SelectPositionModule.PositionData)localObject2).city);
            if (QLog.isColorLevel()) {
              QLog.i("ChannelCoverView", 2, "reportRecommendEvent CHANNEL_ID_LOCAL r5Str = " + localObject1);
            }
          }
        }
      }
      if (this.c != null)
      {
        if ((lhn.oC() != this.c.mChannelCoverId) || (lhn.oC() == 0)) {
          continue;
        }
        ((JSONObject)localObject1).put("channelid_to_mainfeeds", 1);
      }
      localObject1 = ((JSONObject)localObject1).toString();
      if (QLog.isColorLevel()) {
        QLog.d("ChannelCoverView", 2, "reportRecommendEvent T =" + this.abS + "; reportString = " + (String)localObject1);
      }
      kbp.a(null, "", this.abS, this.abS, 0, 0, "", "", "", (String)localObject1, false);
      return;
      if (this.aLn == kqo.aLl) {
        ((JSONObject)localObject1).put("channel_type", "1");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.4
 * JD-Core Version:    0.7.0.1
 */