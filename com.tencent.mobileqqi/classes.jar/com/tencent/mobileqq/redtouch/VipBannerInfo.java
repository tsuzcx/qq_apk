package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import gfv;

public class VipBannerInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public long a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public String b;
  public String c;
  public int e;
  public int f;
  
  public static void a(Context paramContext)
  {
    paramContext.getSharedPreferences("mobileQQi", 0).edit().putBoolean("new_red_point_received", true).commit();
  }
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(15) != 0)) {}
    Object localObject;
    RedTouchManager localRedTouchManager;
    do
    {
      do
      {
        do
        {
          return;
          localObject = paramConversation.a().getSharedPreferences("mobileQQi", 0);
        } while (!((SharedPreferences)localObject).getBoolean("new_red_point_received", false));
        ((SharedPreferences)localObject).edit().putBoolean("new_red_point_received", false).commit();
        localObject = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      } while (localObject == null);
      localRedTouchManager = (RedTouchManager)paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(34);
    } while (localRedTouchManager == null);
    ThreadManager.a().post(new gfv(localRedTouchManager, paramConversation, (Handler)localObject));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(15) != 0))
    {
      paramConversation = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      if (paramConversation != null)
      {
        paramConversation.removeMessages(9);
        paramConversation.sendEmptyMessage(9);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.VipBannerInfo
 * JD-Core Version:    0.7.0.1
 */