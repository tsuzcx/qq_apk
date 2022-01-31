package com.tencent.mobileqq.redtouch;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.BannerManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import eai;
import eaj;

public class VipBannerInfo
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public long a;
  public BusinessInfoCheckUpdate.AppInfo a;
  public String a;
  public long b;
  public String b;
  public String c;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  
  public static void a(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("QQLite", 0);
    ThreadManager.a().post(new eai(paramContext));
  }
  
  public static void a(Conversation paramConversation)
  {
    if ((paramConversation == null) || (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(13) != 0)) {}
    SharedPreferences localSharedPreferences;
    Handler localHandler;
    RedTouchManager localRedTouchManager;
    do
    {
      do
      {
        return;
        localSharedPreferences = paramConversation.a().getSharedPreferences("QQLite", 0);
        localHandler = paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a();
      } while (localHandler == null);
      localRedTouchManager = (RedTouchManager)paramConversation.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(32);
    } while (localRedTouchManager == null);
    ThreadManager.a().post(new eaj(localRedTouchManager, localSharedPreferences, paramConversation, localHandler));
  }
  
  public static void b(Conversation paramConversation)
  {
    if ((paramConversation != null) && (paramConversation.jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager.a(13) != 0))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.redtouch.VipBannerInfo
 * JD-Core Version:    0.7.0.1
 */