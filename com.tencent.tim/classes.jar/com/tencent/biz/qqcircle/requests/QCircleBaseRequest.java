package com.tencent.biz.qqcircle.requests;

import NS_COMM.COMM.Entry;
import NS_QWEB_PROTOCAL.PROTOCAL.StQWebReq;
import com.tencent.biz.richframework.network.request.VSBaseRequest;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import org.jetbrains.annotations.NotNull;

public abstract class QCircleBaseRequest
  extends VSBaseRequest
{
  @NotNull
  public MessageMicro getRequestWrapper(ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = (PROTOCAL.StQWebReq)super.getRequestWrapper(paramByteStringMicro);
    COMM.Entry localEntry = new COMM.Entry();
    localEntry.key.set("fc-appid");
    localEntry.value.set("92");
    paramByteStringMicro.Extinfo.add(localEntry);
    return paramByteStringMicro;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqcircle.requests.QCircleBaseRequest
 * JD-Core Version:    0.7.0.1
 */