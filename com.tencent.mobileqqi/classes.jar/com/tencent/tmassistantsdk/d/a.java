package com.tencent.tmassistantsdk.d;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantExchangeURLListenner;
import com.tencent.tmassistantsdk.f.j;
import com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailResponse;
import java.util.ArrayList;

public final class a
  extends d
{
  private ITMAssistantExchangeURLListenner b = null;
  
  public a(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    this.b = paramITMAssistantExchangeURLListenner;
  }
  
  protected final void a(JceStruct paramJceStruct1, JceStruct paramJceStruct2, int paramInt)
  {
    if (paramJceStruct2 == null) {}
    do
    {
      do
      {
        return;
        if ((this.b == null) || (paramInt != 0)) {
          break;
        }
      } while (!(paramJceStruct2 instanceof GetAppSimpleDetailResponse));
      paramJceStruct1 = (GetAppSimpleDetailResponse)paramJceStruct2;
      if (paramJceStruct1.ret == 0)
      {
        paramJceStruct1 = paramJceStruct1.appSimpleDetailList;
        if ((paramJceStruct1 != null) && (paramJceStruct1.size() > 0))
        {
          this.b.onExchangedURLSucceed(paramJceStruct1, true);
          return;
        }
        j.d("GetAppSimpleDetailHttpRequest", " appDetails 为空!!");
        this.b.onExchangedURLSucceed(null, false);
        return;
      }
      j.d("GetAppSimpleDetailHttpRequest", " 后台返回的ret错误，错误值为：" + paramJceStruct1.ret);
      this.b.onExchangedURLSucceed(null, false);
      return;
      j.d("GetAppSimpleDetailHttpRequest", " error happened!!");
    } while (this.b == null);
    this.b.onExchangedURLSucceed(null, false);
  }
  
  public final boolean a(ArrayList paramArrayList)
  {
    GetAppSimpleDetailRequest localGetAppSimpleDetailRequest = new GetAppSimpleDetailRequest();
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localGetAppSimpleDetailRequest.appReqList = paramArrayList;
      super.a(localGetAppSimpleDetailRequest);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.d.a
 * JD-Core Version:    0.7.0.1
 */