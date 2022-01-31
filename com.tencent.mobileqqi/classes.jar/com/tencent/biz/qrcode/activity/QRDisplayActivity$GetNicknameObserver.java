package com.tencent.biz.qrcode.activity;

import android.os.Bundle;
import java.util.List;
import mqq.observer.BusinessObserver;

public class QRDisplayActivity$GetNicknameObserver
  implements BusinessObserver
{
  public QRDisplayActivity$GetNicknameObserver(QRDisplayActivity paramQRDisplayActivity) {}
  
  public void a(boolean paramBoolean, List paramList1, List paramList2) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramBoolean)
    {
      a(paramBoolean, paramBundle.getStringArrayList("nickname_list"), paramBundle.getStringArrayList("uin_list"));
      return;
    }
    this.b.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver
 * JD-Core Version:    0.7.0.1
 */