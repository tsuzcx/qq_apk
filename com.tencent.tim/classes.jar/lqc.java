import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.e;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.r;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.NetworkState;
import java.util.ArrayList;
import org.json.JSONObject;

public class lqc
  implements ViewBase.OnClickListener
{
  private int aPw;
  ArticleInfo b;
  Context context;
  
  public lqc(ArticleInfo paramArticleInfo, Context paramContext, int paramInt)
  {
    this.b = paramArticleInfo;
    this.context = paramContext;
    this.aPw = paramInt;
  }
  
  private long getUin()
  {
    long l2 = 0L;
    long l1;
    if ((ndi.K(this.b)) || (this.aPw == 77) || (this.aPw == 78))
    {
      l1 = l2;
      if (TextUtils.isEmpty(this.b.mSubscribeID)) {}
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  try
                  {
                    l1 = Long.parseLong(this.b.mSubscribeID);
                    return l1;
                  }
                  catch (NumberFormatException localNumberFormatException)
                  {
                    localNumberFormatException.printStackTrace();
                    return 0L;
                  }
                  if ((!ndi.ak(this.b)) && (this.aPw != 72) && (this.aPw != 74)) {
                    break;
                  }
                  l1 = l2;
                } while (this.b.mSocialFeedInfo == null);
                l1 = l2;
              } while (this.b.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r == null);
              return this.b.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$r.cuin;
              if (this.aPw != 76) {
                break;
              }
              l1 = l2;
            } while (this.b.mSocialFeedInfo == null);
            l1 = l2;
          } while (this.b.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null);
          return this.b.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
          if ((ndi.P(this.b)) || (this.aPw == 73)) {
            break;
          }
          l1 = l2;
        } while (this.aPw != 75);
        l1 = l2;
      } while (this.b.mSocialFeedInfo == null);
      l1 = l2;
    } while (this.b.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e == null);
    return this.b.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$e.uin;
  }
  
  private void report()
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("algorithm_id", this.b.mAlgorithmID + "");
        localJSONObject.put("folder_status", kxm.aMw);
        localJSONObject.put("feeds_type", kxm.a(this.b));
        localJSONObject.put("time", NetConnInfoCenter.getServerTimeMillis());
        localJSONObject.put("channel_id", "" + this.b.mChannelID);
        if (NetworkState.isWifiConn())
        {
          i = 1;
          localJSONObject.put("network_type", i);
          localJSONObject.put("feeds_source", kxm.f(this.b));
          localJSONObject.put("imei", kxm.iT());
          localJSONObject.put("imsi", kxm.iU());
          localJSONObject.put("idfa", "");
          localJSONObject.put("rowkey", this.b.innerUniqueID);
          localJSONObject.put("comment", this.b.mSocialFeedInfo.ahL);
          if (awit.N(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
            continue;
          }
          i = j;
          localJSONObject.put("reddot_style", i);
          localJSONObject.put("tab_source", "" + kxm.nQ());
          localJSONObject.put("kandian_mode", "" + kxm.nR());
          kbp.a(null, String.valueOf(getUin()), "0X800953E", "0X800953E", 0, 0, String.valueOf(this.b.mSocialFeedInfo.mFeedId), String.valueOf(this.b.mArticleID), String.valueOf(this.b.mStrategyId), localJSONObject.toString(), false);
          return;
        }
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("OnFriendsBiuClickListener", 2, "report error:" + localException.toString());
      }
      i = 2;
      continue;
      i = 0;
    }
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = this.b.multiBiuSameContentList;
    if ((paramViewBase != null) && (!paramViewBase.isEmpty()))
    {
      Intent localIntent = new Intent();
      Bundle localBundle = new Bundle();
      localBundle.putString("articleID", String.valueOf(this.b.mArticleID));
      localBundle.putString("stategyID", String.valueOf(this.b.mStrategyId));
      localBundle.putString("algorithm_id", this.b.mAlgorithmID + "");
      localBundle.putString("feeds_source", kxm.f(this.b));
      localBundle.putString("rowkey", this.b.innerUniqueID + "");
      localBundle.putString("channel_id", "" + this.b.mChannelID);
      localIntent.putParcelableArrayListExtra("friends_biu_list", paramViewBase);
      localIntent.putExtras(localBundle);
      PublicFragmentActivity.b.start(this.context, localIntent, PublicTransFragmentActivity.class, ReadInjoyFriendsBiuComponentFragment.class);
    }
    report();
    if (QLog.isColorLevel()) {
      QLog.d("OnFriendsBiuClickListener", 2, "onClick:" + paramViewBase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lqc
 * JD-Core Version:    0.7.0.1
 */