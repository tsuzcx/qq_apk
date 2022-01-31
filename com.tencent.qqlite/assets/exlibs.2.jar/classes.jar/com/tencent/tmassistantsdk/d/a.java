package com.tencent.tmassistantsdk.d;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantExchangeURLListenner;
import com.tencent.tmassistantsdk.f.k;
import com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetAppSimpleDetailResponse;
import java.util.ArrayList;

public final class a
  extends b
{
  private ITMAssistantExchangeURLListenner b = null;
  
  public a(ITMAssistantExchangeURLListenner paramITMAssistantExchangeURLListenner)
  {
    this.b = paramITMAssistantExchangeURLListenner;
  }
  
  protected final void a(JceStruct paramJceStruct, int paramInt)
  {
    if (paramJceStruct == null) {}
    do
    {
      do
      {
        return;
        if ((this.b == null) || (paramInt != 0)) {
          break;
        }
      } while (!(paramJceStruct instanceof GetAppSimpleDetailResponse));
      paramJceStruct = (GetAppSimpleDetailResponse)paramJceStruct;
      if (paramJceStruct.ret == 0)
      {
        paramJceStruct = paramJceStruct.appSimpleDetailList;
        if ((paramJceStruct != null) && (paramJceStruct.size() > 0))
        {
          this.b.onExchangedURLSucceed(paramJceStruct, true);
          return;
        }
        k.d("GetAppSimpleDetailHttpRequest", " appDetails 为空!!");
        this.b.onExchangedURLSucceed(null, false);
        return;
      }
      k.d("GetAppSimpleDetailHttpRequest", " 后台返回的ret错误，错误值为：" + paramJceStruct.ret);
      this.b.onExchangedURLSucceed(null, false);
      return;
      k.d("GetAppSimpleDetailHttpRequest", " error happened!!");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.d.a
 * JD-Core Version:    0.7.0.1
 */