package com.tencent.biz.pubaccount.readinjoy.view;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.qphone.base.util.QLog;
import kbp;
import kct;
import kxm;
import mfs;
import mua;
import org.json.JSONObject;

class ReadinjoyTabFrame$22
  implements Runnable
{
  ReadinjoyTabFrame$22(ReadinjoyTabFrame paramReadinjoyTabFrame, VideoInfo paramVideoInfo, mfs parammfs) {}
  
  public void run()
  {
    int i = 2;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = kxm.v();
        localJSONObject.put("kandian_mode", kxm.nR());
        if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
        {
          localJSONObject.put("reddot", i);
          localJSONObject.put("kandian_mode_new", kct.nd());
          if ((this.jdField_a_of_type_Mfs.pg() != 1) || (TextUtils.isEmpty(this.jdField_a_of_type_Mfs.jM()))) {
            break label219;
          }
          String str1 = this.jdField_a_of_type_Mfs.jM();
          localJSONObject.put("skin_id", str1);
          if (this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo != null)
          {
            str1 = this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo.Wz;
            localJSONObject.put("rwokey", str1);
            localJSONObject.put("diandianfeeds_type", RecommendFeedsDiandianEntranceManager.a().qE());
            kbp.a(this.this$0.app, "CliOper", "", "", "0X8007DB0", "0X8007DB0", 0, 0, "5", "", "", localJSONObject.toString(), false);
            if (QLog.isColorLevel()) {
              QLog.d("Q.readinjoy.4tab", 2, "reportForVideoEntranceRedDotButtonClicked has finished,  r5: " + localJSONObject.toString());
            }
            if (ReadinjoyTabFrame.a(this.this$0) != null) {
              mua.d(this.jdField_a_of_type_ComTencentBizPubaccountVideoInfo);
            }
          }
          else
          {
            str1 = "";
            continue;
          }
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      i = 1;
      continue;
      label219:
      String str2 = "0";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.22
 * JD-Core Version:    0.7.0.1
 */