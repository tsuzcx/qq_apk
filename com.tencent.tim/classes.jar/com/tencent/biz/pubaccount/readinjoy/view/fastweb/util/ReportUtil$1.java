package com.tencent.biz.pubaccount.readinjoy.view.fastweb.util;

import android.os.Parcel;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import kxm;
import nns;
import org.json.JSONException;
import org.json.JSONObject;

public final class ReportUtil$1
  implements Runnable
{
  public ReportUtil$1(byte[] paramArrayOfByte, long paramLong) {}
  
  public void run()
  {
    ArticleInfo localArticleInfo;
    long l1;
    long l2;
    BaseActivity localBaseActivity;
    try
    {
      Object localObject = Parcel.obtain();
      ((Parcel)localObject).unmarshall(this.bt, 0, this.bt.length);
      ((Parcel)localObject).setDataPosition(0);
      localObject = new ArticleInfo((Parcel)localObject);
      if (localObject == null) {
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
        localArticleInfo = null;
      }
      l1 = NetConnInfoCenter.getServerTime();
      l2 = this.xN;
      localBaseActivity = BaseActivity.sTopActivity;
      localJSONObject = new JSONObject();
      if (localBaseActivity == null) {
        break label148;
      }
    }
    JSONObject localJSONObject = kxm.a(localBaseActivity, localArticleInfo, (int)localArticleInfo.mChannelID, "2");
    label148:
    for (;;)
    {
      try
      {
        localJSONObject.put("rowkey", localArticleInfo.innerUniqueID);
        localJSONObject.put("duration", l1 - l2);
        nns.c(localArticleInfo, "0X800A732", localJSONObject.toString());
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.ReportUtil.1
 * JD-Core Version:    0.7.0.1
 */