package com.tencent.mobileqq.extendfriend;

import android.content.Context;
import android.text.TextUtils;
import anot;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.qphone.base.util.QLog;

public class ExtendFriendPublicFragmentActivity
  extends PublicFragmentActivity
{
  private static volatile long JZ;
  
  private static void Ng(int paramInt)
  {
    String str = "";
    Object localObject = "";
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.c();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null))
    {
      localObject = localSosoLbsInfo.a;
      if (!TextUtils.isEmpty(((SosoInterface.SosoLocation)localObject).city)) {
        str = ((SosoInterface.SosoLocation)localObject).city;
      }
      localObject = String.format("%s;%s", new Object[] { Double.valueOf(((SosoInterface.SosoLocation)localObject).cd), Double.valueOf(((SosoInterface.SosoLocation)localObject).ce) });
    }
    for (;;)
    {
      anot.a(null, "dc00898", "", "", "0X800AD99", "0X800AD99", paramInt, 0, "", "", str, (String)localObject);
      return;
      str = "";
    }
  }
  
  public static void ao(Context paramContext, int paramInt)
  {
    f(paramContext, paramInt, true);
  }
  
  public static void ek(Context paramContext)
  {
    f(paramContext, 0, true);
  }
  
  public static void f(Context paramContext, int paramInt, boolean paramBoolean)
  {
    QLog.d("ExtendFriendPublicFragmentActivity", 2, String.format("launchExtendFriendFragment context=%s source=%s freqCtrl=%s", new Object[] { paramContext, Integer.valueOf(paramInt), Boolean.valueOf(paramBoolean) }));
    long l = System.currentTimeMillis();
    if ((paramBoolean) && (l - JZ < 1000L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendPublicFragmentActivity", 2, "launchExtendFriendFragment launch too often.");
      }
      return;
    }
    JZ = l;
    PublicFragmentActivity.start(paramContext, ExtendFriendFragment.class);
    Ng(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.ExtendFriendPublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */