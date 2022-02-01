package com.tencent.msfmqpsdkbridge;

import android.text.TextUtils;
import arnw.a;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class MSFCodec
  implements arnw.a
{
  private String mCmd;
  
  public MSFCodec(String paramString)
  {
    this.mCmd = paramString;
  }
  
  public Object decode(Object paramObject)
  {
    return ((FromServiceMsg)paramObject).getWupBuffer();
  }
  
  public Object encode(Object paramObject)
  {
    if ((paramObject == null) || (TextUtils.isEmpty(this.mCmd))) {
      return null;
    }
    Object localObject = "";
    AppRuntime localAppRuntime = MobileQQ.getMobileQQ().waitAppRuntime(null);
    if (localAppRuntime != null) {
      localObject = localAppRuntime.getAccount();
    }
    localObject = new ToServiceMsg("mobileqq.service", (String)localObject, this.mCmd);
    ((ToServiceMsg)localObject).putWupBuffer((byte[])paramObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.msfmqpsdkbridge.MSFCodec
 * JD-Core Version:    0.7.0.1
 */