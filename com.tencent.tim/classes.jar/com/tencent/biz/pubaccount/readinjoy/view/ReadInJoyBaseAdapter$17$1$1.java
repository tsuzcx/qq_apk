package com.tencent.biz.pubaccount.readinjoy.view;

import android.app.Activity;
import anot;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.plugin.PluginBaseActivity;
import java.util.ArrayList;
import java.util.List;
import kbp;
import kxm;
import lbz;
import ndi;
import ndn;
import ndo;
import odv;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyBaseAdapter$17$1$1
  implements Runnable
{
  public ReadInJoyBaseAdapter$17$1$1(ndo paramndo) {}
  
  public void run()
  {
    this.a.a.this$0.gO.remove(this.a.a.o);
    ndi.a(this.a.a.this$0, true);
    this.a.a.this$0.notifyDataSetChanged();
    int i = 2131701914;
    if (AdvertisementInfo.isAdvertisementInfo(this.a.a.o)) {
      i = 2131701915;
    }
    if ((this.a.a.this$0.mContext instanceof BaseActivity)) {
      QQToast.a(this.a.a.this$0.mContext, -1, this.a.a.this$0.mContext.getString(i), 0).show(((BaseActivity)this.a.a.this$0.mContext).getTitleBarHeight());
    }
    for (;;)
    {
      this.a.a.this$0.a(this.a.a.aKd, this.a.a.o, this.a.kM);
      if (AdvertisementInfo.isAdvertisementInfo(this.a.a.o))
      {
        long l2 = 0L;
        long l1 = l2;
        if (this.a.val$object != null)
        {
          l1 = l2;
          if ((this.a.val$object instanceof DislikeInfo)) {
            l1 = ((DislikeInfo)this.a.val$object).vf;
          }
        }
        lbz.a().a(this.a.a.this$0.mContext, (AdvertisementInfo)this.a.a.o, l1, this.a.kM, false);
      }
      try
      {
        Object localObject = new JSONObject();
        ((JSONObject)localObject).put("time", System.currentTimeMillis() / 1000L);
        ((JSONObject)localObject).put("channel_id", this.a.a.this$0.mChannelID);
        ((JSONObject)localObject).put("tag_num", this.a.kM.size());
        if ((this.a.a.this$0.mContext instanceof BaseActivity))
        {
          ((JSONObject)localObject).put("folder_status", kxm.aMw);
          ((JSONObject)localObject).put("kandian_mode", kxm.nR());
          ((JSONObject)localObject).put("feeds_type", "" + kxm.a(this.a.a.o));
          ((JSONObject)localObject).put("rowkey", odv.r(this.a.a.o));
          localObject = ((JSONObject)localObject).toString();
          kbp.a(null, "", "0X8007059", "0X8007059", 0, 0, "", "", kxm.j(this.a.kM), (String)localObject, false);
        }
        while (!(this.a.a.this$0.mContext instanceof PluginBaseActivity))
        {
          return;
          if (!(this.a.a.this$0.mContext instanceof PluginBaseActivity)) {
            break;
          }
          QQToast.a(this.a.a.this$0.mContext, -1, this.a.a.this$0.mContext.getString(i), 0).show(((PluginBaseActivity)this.a.a.this$0.mContext).getTitleBarHeight());
          break;
        }
        ((JSONObject)localObject).put("folder_status", 1);
        anot.a(null, "CliOper", "", "", "0X8007060", "0X8007060", 0, 0, "", "", "", ((JSONObject)localObject).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter.17.1.1
 * JD-Core Version:    0.7.0.1
 */