package com.tencent.mobileqq.apollo.store;

import abhh;
import android.os.Bundle;
import android.text.TextUtils;
import aqmu;
import auru;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloPandora;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.pb.webssoagent.WebSSOAgent.UniSsoServerRsp;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

class ApolloBoxEnterView$3
  implements Runnable
{
  ApolloBoxEnterView$3(ApolloBoxEnterView paramApolloBoxEnterView, Bundle paramBundle) {}
  
  public void run()
  {
    try
    {
      if (ApolloBoxEnterView.a(this.this$0) == null) {
        return;
      }
      localQQAppInterface = (QQAppInterface)ApolloBoxEnterView.a(this.this$0).get();
      if (localQQAppInterface == null) {
        return;
      }
      Object localObject2 = this.val$bundle.getByteArray("extra_data");
      str = this.val$bundle.getString("extra_callbackid");
      localObject1 = new WebSSOAgent.UniSsoServerRsp();
      ((WebSSOAgent.UniSsoServerRsp)localObject1).mergeFrom((byte[])localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxEnterView", 2, "handleQueryPandora ret: " + ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() + ", msg: " + ((WebSSOAgent.UniSsoServerRsp)localObject1).errmsg.get());
      }
      if (0L != ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get()) {
        return;
      }
      localObject2 = new JSONObject(((WebSSOAgent.UniSsoServerRsp)localObject1).rspdata.get()).optJSONObject("data");
      if (QLog.isColorLevel()) {
        QLog.d("ApolloBoxEnterView", 2, "handleQueryPandora ret: " + ((WebSSOAgent.UniSsoServerRsp)localObject1).ret.get() + ", dataObj: " + localObject2);
      }
      if (localObject2 == null) {
        return;
      }
      JSONObject localJSONObject = ((JSONObject)localObject2).optJSONObject("drawerData");
      if (localJSONObject == null) {
        return;
      }
      localabhh = (abhh)localQQAppInterface.getManager(153);
      localObject2 = localabhh.a(str + "", true);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ApolloPandora();
        ((ApolloPandora)localObject1).uin = (str + "");
      }
      ((ApolloPandora)localObject1).checkPoint = localJSONObject.optLong("checkpoint");
      ((ApolloPandora)localObject1).queryInterval = localJSONObject.optInt("queryInterval");
      ((ApolloPandora)localObject1).updateTime = System.currentTimeMillis();
      ((ApolloPandora)localObject1).mBoxTipUrl = localJSONObject.optString("iconUrl");
      if ((QLog.isColorLevel()) && (TextUtils.isEmpty(((ApolloPandora)localObject1).mBoxTipUrl))) {
        ((ApolloPandora)localObject1).mBoxTipUrl = "https://cmshow.gtimg.cn/client/zip/box_gif_2016_11_13.zip";
      }
      ((ApolloPandora)localObject1).boxType = ((short)localJSONObject.optInt("objType"));
      ((ApolloPandora)localObject1).boxSubType = ((short)localJSONObject.optInt("objSubType"));
      if (TextUtils.isEmpty(((ApolloPandora)localObject1).mBoxTipUrl)) {
        break label552;
      }
      ((ApolloPandora)localObject1).canSteal = 1;
      ((ApolloPandora)localObject1).hadStolen = 0;
    }
    catch (Exception localException)
    {
      QQAppInterface localQQAppInterface;
      String str;
      Object localObject1;
      abhh localabhh;
      while (QLog.isColorLevel())
      {
        QLog.e("ApolloBoxEnterView", 2, "handleQueryPandora failed ", localException);
        return;
        label552:
        localException.canSteal = 0;
      }
    }
    localabhh.a((ApolloPandora)localObject1);
    if ((ApolloBoxEnterView.a(this.this$0) != null) && (ApolloBoxEnterView.a(this.this$0).equals(String.valueOf(str))))
    {
      ApolloBoxEnterView.a(this.this$0, (ApolloPandora)localObject1);
      ApolloBoxEnterView.a(this.this$0).sendEmptyMessage(255);
    }
    if (QLog.isColorLevel())
    {
      QLog.d("ApolloBoxEnterView", 2, "handleQueryPandora canSteal: " + ((ApolloPandora)localObject1).canSteal + ", hadStolen: " + ((ApolloPandora)localObject1).hadStolen + ",boxType:" + ((ApolloPandora)localObject1).boxType + ", checkPoint: " + aqmu.m(localQQAppInterface.getApp(), ((ApolloPandora)localObject1).checkPoint * 1000L));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBoxEnterView.3
 * JD-Core Version:    0.7.0.1
 */