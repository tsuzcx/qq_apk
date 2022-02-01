package com.tencent.biz.pubaccount.NativeAd.util;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.ad.utils.ReadInJoyAdPingUrlUtil;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import jzk;
import jzn;
import kbs;
import kkw;
import kmy;
import knd;
import knj;
import mqq.app.NewIntent;
import ods;
import org.json.JSONException;
import org.json.JSONObject;

public final class NativeAdUtils$3
  implements Runnable
{
  public NativeAdUtils$3(JSONObject paramJSONObject1, String paramString1, int paramInt1, int paramInt2, int paramInt3, Context paramContext, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, int paramInt4, JSONObject paramJSONObject2, JSONObject paramJSONObject3, Bundle paramBundle, String paramString2, long paramLong, JSONObject paramJSONObject4, JSONObject paramJSONObject5, JSONObject paramJSONObject6, AppInterface paramAppInterface, boolean paramBoolean) {}
  
  public void run()
  {
    int j = 0;
    new JSONObject();
    JSONObject localJSONObject;
    if (this.K == null) {
      localJSONObject = new JSONObject();
    }
    Object localObject3;
    for (;;)
    {
      try
      {
        localJSONObject.put("uin", this.val$uin);
        localJSONObject.put("type", this.val$type);
        localJSONObject.put("ts", System.currentTimeMillis());
        localJSONObject.put("origin", this.aGD);
        localJSONObject.put("sub_origin", this.aGE);
        localJSONObject.put("oudid", "1");
        localJSONObject.put("device_info", jzk.c(this.val$context));
        localJSONObject.put("ad_info", jzk.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo, this.Aa));
        if (this.L != null)
        {
          localJSONObject.put("video_info", this.L);
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "video_info ad videoInfo = " + this.L.toString());
          }
        }
        if (this.M != null) {
          localJSONObject.put("device_report_info", this.M);
        }
        if (this.val$type == jzk.aEL)
        {
          localObject2 = new JSONObject();
          if (this.x != null)
          {
            ((JSONObject)localObject2).put("type_id", jzk.aGn);
            ((JSONObject)localObject2).put("tel", this.x.getString(jzk.Vj, ""));
            ((JSONObject)localObject2).put("txt", this.x.getString(jzk.Vk, ""));
            localJSONObject.put("neg_info", localObject2);
          }
        }
        else
        {
          if (ods.ac(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
          {
            new JSONObject();
            if (this.N != null) {
              break label850;
            }
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("type", kmy.cX(this.aGD));
            ((JSONObject)localObject2).put("interaction_report_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdInteractionReportUrl);
            ((JSONObject)localObject2).put("effect_url", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdEffectUrl);
            localJSONObject.put("ugc_card_info", localObject2);
          }
          localObject2 = new JSONObject();
          if ((knd.q(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickType == 2) && (this.O != null))
          {
            ((JSONObject)localObject2).put("material_group", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.materialGroup));
            ((JSONObject)localObject2).put("slide_mode", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJB) + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJC);
            ((JSONObject)localObject2).put("click_type", String.valueOf(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.clickType));
            this.O.put("click_info_report", String.valueOf(localObject2));
            localObject3 = (JSONObject)localJSONObject.opt("ad_info");
            if (localObject3 != null)
            {
              ((JSONObject)localObject3).put("click_pos", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJD);
              localJSONObject.put("ad_info", localObject3);
            }
          }
          if (knd.r(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
          {
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJE != 3) {
              break label859;
            }
            ((JSONObject)localObject2).put("is_transparent", "1");
            if (this.val$type != jzk.aEJ) {
              break label887;
            }
            jzk.a(null, "0X8009819", "0X8009819", 0, 0, "", "", "", knj.iw());
            if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJE != 1) {
              ((JSONObject)localObject2).put("volumn", this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aas);
            }
            if (this.O != null) {
              this.O.put("click_info_report", String.valueOf(localObject2));
            }
          }
          if (this.P != null) {
            localJSONObject.put("article_info", this.P);
          }
          if (this.O != null) {
            localJSONObject.put("func_ext_info", this.O);
          }
          localObject3 = localJSONObject.toString();
          if (QLog.isColorLevel()) {
            QLog.d("NativeAdUtils", 2, "report json = " + (String)localObject3);
          }
          boolean bool = TextUtils.isEmpty((CharSequence)localObject3);
          if (!bool) {
            break;
          }
          return;
          localJSONObject = this.K;
          continue;
        }
        ((JSONObject)localObject2).put("type_id", jzk.aGm);
        if (TextUtils.isEmpty(this.Vn))
        {
          ((JSONObject)localObject2).put("neg_ids", String.valueOf(this.rf));
          continue;
        }
        ((JSONObject)localObject2).put("neg_ids", this.Vn);
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        return;
      }
      continue;
      label850:
      localObject2 = this.N;
      continue;
      label859:
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJE == 2)
      {
        ((JSONObject)localObject2).put("is_transparent", "");
        continue;
        label887:
        if (this.val$type == jzk.aEK)
        {
          if (this.O != null) {
            this.O.put("exposure_info_report", String.valueOf(localObject2));
          }
          jzk.a(null, "0X8008C80", "0X8008C80", 0, 0, "", "", "", knj.iw());
        }
      }
    }
    if (this.val$type == jzk.aFk)
    {
      ReadInJoyAdPingUrlUtil.Q(localJSONException);
      return;
    }
    Object localObject1 = new WebSsoBody.WebSsoRequestBody();
    ((WebSsoBody.WebSsoRequestBody)localObject1).data.set((String)localObject3);
    Object localObject2 = new NewIntent(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), kbs.class);
    ((NewIntent)localObject2).putExtra("cmd", "KdAdReportSsoSvr.kandian_ad_report_new");
    ((NewIntent)localObject2).putExtra("data", ((WebSsoBody.WebSsoRequestBody)localObject1).toByteArray());
    ((NewIntent)localObject2).setObserver(new jzn(this));
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.startServlet((NewIntent)localObject2);
    int i = j;
    if (knd.r(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo))
    {
      i = j;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null)
      {
        if ((!knj.a().g(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJA)) || (this.val$type != jzk.aEK)) {
          break label1284;
        }
        i = 1;
        break label1286;
      }
    }
    label1284:
    label1286:
    for (;;)
    {
      if ((this.Aa != jzk.aGk) && (!jzk.b(this.val$type, this.aGD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo)) && (!this.acZ) && (i == 0))
      {
        jzk.b(this.val$type, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.jdField_a_of_type_ComTencentBizPubaccountVideoAdInfo);
        if ((knd.r(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo)) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo != null)) {
          knj.a().V(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdAid, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdvertisementExtInfo.aJA);
        }
      }
      localObject2 = "";
      localObject1 = localObject2;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo != null)
      {
        localObject1 = localObject2;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId)) {
          localObject1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo.mAdViewId;
        }
      }
      jzk.a(null, "0X8009E3E", "0X8009E3E", 0, 0, String.valueOf(this.aGD), String.valueOf(this.val$type), (String)localObject1, (String)localObject3);
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils.3
 * JD-Core Version:    0.7.0.1
 */