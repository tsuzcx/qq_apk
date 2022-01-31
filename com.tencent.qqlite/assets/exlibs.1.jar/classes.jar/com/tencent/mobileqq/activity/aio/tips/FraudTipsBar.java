package com.tencent.mobileqq.activity.aio.tips;

import android.app.Activity;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import cbr;
import cbt;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.antiphing.UinFraudInfo;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AntiFraudConfigFileUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;

public class FraudTipsBar
  implements TipsBarTask
{
  private static final String jdField_a_of_type_JavaLangString = FraudTipsBar.class.getSimpleName();
  private static final int b = 0;
  private static final int c = 1;
  private static final int d = 2;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo;
  private TipsManager jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private boolean jdField_a_of_type_Boolean = false;
  
  public FraudTipsBar(QQAppInterface paramQQAppInterface, TipsManager paramTipsManager, Activity paramActivity, SessionInfo paramSessionInfo, Handler paramHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager = paramTipsManager;
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
  }
  
  public int a()
  {
    return 0;
  }
  
  public View a(Object... paramVarArgs)
  {
    View localView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2130903583, null);
    TextView localTextView = (TextView)localView.findViewById(2131298627);
    String str = (String)paramVarArgs[0];
    int i = ((Integer)paramVarArgs[1]).intValue();
    localTextView.setText(str);
    localView.setOnClickListener(new cbt(this, i));
    return localView;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "check() : ");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int != 0) {}
    for (;;)
    {
      return;
      if (this.jdField_a_of_type_Int != 0)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "mAntiFraudTips is showing or has shown");
        return;
      }
      try
      {
        l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
        if (l == 0L) {
          continue;
        }
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          if (UinFraudInfo.a().a(l))
          {
            if (QLog.isColorLevel()) {
              QLog.d(jdField_a_of_type_JavaLangString, 2, "uin cache is out of date, update it! ");
            }
            ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).a("OidbSvc.0x476_146", (int)l, 146);
          }
        }
        int i = UinFraudInfo.a().a(l);
        if (i == 0) {
          continue;
        }
        AntiFraudConfigFileUtil.a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "SecWarningCfg");
        Object localObject = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerWording", 146, i);
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          continue;
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioTipsTipsManager.a(this, new Object[] { localObject, Integer.valueOf(i) })) {
          continue;
        }
        this.jdField_a_of_type_Int = 1;
        ReportController.b(null, "P_CliOper", "Safe_AntiFraud", this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "banner", "display", i, 0, "", "", "", "");
        localObject = new Timer();
        cbr localcbr = new cbr(this);
        String str = AntiFraudConfigFileUtil.a().a("SecWarningCfg", "BannerTTL", 146, i);
        l = 15L;
        try
        {
          i = Integer.parseInt(str);
          l = i;
        }
        catch (Throwable localThrowable2)
        {
          for (;;)
          {
            localThrowable2.printStackTrace();
          }
        }
        l *= 1000L;
        if (l <= 0L) {
          continue;
        }
        ((Timer)localObject).schedule(localcbr, l);
        return;
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          localThrowable1.printStackTrace();
          long l = 0L;
        }
      }
    }
  }
  
  public void a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt != 1000) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onAIOEvent() : TYPE_ON_SHOW =====>");
    }
    a();
  }
  
  public int[] a()
  {
    return null;
  }
  
  public int b()
  {
    return 50;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.tips.FraudTipsBar
 * JD-Core Version:    0.7.0.1
 */