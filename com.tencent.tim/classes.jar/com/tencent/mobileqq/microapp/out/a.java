package com.tencent.mobileqq.microapp.out;

import android.os.Bundle;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.observer.BusinessObserver;

public class a
  implements BusinessObserver
{
  public void a(boolean paramBoolean, LBSShare.LocationResp paramLocationResp) {}
  
  public void a(boolean paramBoolean, String paramString) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    paramBundle.getParcelable("req");
    paramBundle = (FromServiceMsg)paramBundle.getParcelable("rsp");
    if (paramInt == 1) {
      if (!paramBoolean) {
        break label90;
      }
    }
    for (;;)
    {
      try
      {
        paramBundle = (LBSShare.LocationResp)new LBSShare.LocationResp().mergeFrom(paramBundle.getWupBuffer());
        a(paramBoolean, paramBundle);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      if (paramInt == 2)
      {
        if (paramBoolean) {}
        for (paramBundle = new String(paramBundle.getWupBuffer());; paramBundle = null)
        {
          a(paramBoolean, paramBundle);
          return;
        }
        label90:
        paramBundle = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.out.a
 * JD-Core Version:    0.7.0.1
 */