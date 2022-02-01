import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;

public class aurk
{
  public static void a(QQAppInterface paramQQAppInterface, aevs paramaevs, int paramInt1, int paramInt2)
  {
    try
    {
      if (paramaevs.a.strPkgName.equals("com.android.ReadInJoy")) {
        c(paramQQAppInterface, "0X80098E6", "" + eN(paramInt1), "" + paramInt2, "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, MainFragment paramMainFragment, acep paramacep, int paramInt)
  {
    try
    {
      if ((((paramacep instanceof ReadinjoyTabFrame)) || (paramInt == MainFragment.bIq)) && ((ReadinjoyTabFrame)paramMainFragment.a(ReadinjoyTabFrame.class) != null) && (paramInt == MainFragment.bIq) && (paramMainFragment.getActivity().getIntent().getIntExtra("launch_from", 5) == 6)) {
        c(paramQQAppInterface, "0X80098E2", "", "", "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    if (paramRecentUser != null) {
      try
      {
        if (paramRecentUser.getType() == 1008)
        {
          if (!"2173223560".equals(paramRecentBaseData.qx())) {
            break label145;
          }
          c(paramQQAppInterface, "0X80098E0", "" + paramRecentBaseData.mUnreadFlag, "" + paramRecentBaseData.mUnreadNum, "", "");
        }
        while (paramRecentUser.getType() == 7220)
        {
          c(paramQQAppInterface, "0X80098DF", "" + paramRecentBaseData.mUnreadFlag, "" + paramRecentBaseData.mUnreadNum, "", "");
          return;
          label145:
          if (acbn.blP.equals(paramRecentBaseData.qx())) {
            c(paramQQAppInterface, "0X80098F2", "" + paramRecentBaseData.mUnreadFlag, "" + paramRecentBaseData.mUnreadNum, "", "");
          }
        }
        return;
      }
      catch (Throwable paramQQAppInterface)
      {
        if (QLog.isColorLevel()) {
          QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
        }
      }
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    try
    {
      if (((paramBaseActivity instanceof ReadInJoyNewFeedsActivity)) && (paramBaseActivity.getIntent().getIntExtra("launch_from", 5) == 6)) {
        c(paramQQAppInterface, "0X80098E2", "", "", "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser != null) {}
    try
    {
      if (paramRecentUser.getType() == 7220) {
        c(paramQQAppInterface, "0X80098E3", "", "", "", "");
      }
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  public static void c(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    anot.a(paramQQAppInterface, "dc00898", "", "", paramString1, paramString1, 0, 0, paramString2, paramString3, paramString4, paramString5);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, int paramInt, long paramLong)
  {
    if (paramInt == 7220) {}
    try
    {
      c(paramQQAppInterface, "0X80098E4", "" + paramLong, "", "", "");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
    }
  }
  
  private static int eN(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return 2;
    case 1: 
      return 3;
    case 2: 
      return 1;
    case 3: 
      return 6;
    }
    return 7;
  }
  
  public static void o(QQAppInterface paramQQAppInterface, MessageRecord paramMessageRecord)
  {
    try
    {
      if ((paramMessageRecord.istroop == 7220) || ((paramMessageRecord.istroop == 1008) && (acbn.blw.equals(paramMessageRecord.frienduin))))
      {
        c(paramQQAppInterface, "0X80098E5", "" + paramMessageRecord.msgUid, "", "", "");
        return;
      }
      if (paramMessageRecord.istroop == 10007)
      {
        ahtc.g(paramQQAppInterface, paramMessageRecord.frienduin, 10006, 1);
        return;
      }
    }
    catch (Throwable paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQKRPUtil", 2, paramQQAppInterface, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aurk
 * JD-Core Version:    0.7.0.1
 */