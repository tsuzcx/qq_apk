package com.tencent.biz.pubaccount.readinjoy.channelCover;

import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kct;
import kxm;
import nce.a;
import org.json.JSONObject;

public final class ChannelCoverView$3
  implements Runnable
{
  public ChannelCoverView$3(ChannelCoverInfo paramChannelCoverInfo, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    str = "";
    try
    {
      localObject = new JSONObject();
      if (this.c != null) {
        ((JSONObject)localObject).put("channel_id", this.c.mChannelCoverId);
      }
      ((JSONObject)localObject).put("network_type", kct.ib());
      ((JSONObject)localObject).put("version", kct.XU);
      ((JSONObject)localObject).put("os", "1");
      ((JSONObject)localObject).put("imei", kxm.iT());
      ((JSONObject)localObject).put("imsi", kxm.iU());
      ((JSONObject)localObject).put("kandian_mode_new", kct.nd());
      ((JSONObject)localObject).put("kandian_mode", kxm.nR());
      ((JSONObject)localObject).put("entrance", nce.a.dx(this.aLm));
      localObject = ((JSONObject)localObject).toString();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = str;
        if (QLog.isColorLevel())
        {
          QLog.d("ChannelCoverView", 2, "ERROR Exception=" + localException.getMessage());
          localObject = str;
        }
      }
    }
    kbp.a(null, "", this.abS, this.abS, 0, 0, this.VO, this.VP, this.VQ, (String)localObject, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelCover.ChannelCoverView.3
 * JD-Core Version:    0.7.0.1
 */