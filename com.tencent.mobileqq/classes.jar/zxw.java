import android.content.SharedPreferences;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.RegisterProxy;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.MsgAutoMonitorUtil;
import java.util.HashMap;

public class zxw
  extends MessageObserver
{
  private zxw(RegisterProxy paramRegisterProxy) {}
  
  private void h()
  {
    long l1;
    long l2;
    Object localObject;
    if ((RegisterProxy.a(this.a) == 2) && (RegisterProxy.c(this.a) == 2))
    {
      l1 = SystemClock.uptimeMillis();
      RegisterProxy.e(this.a).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c = true;
      RegisterProxy.f(this.a).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true);
      if ((BaseApplicationImpl.sLaunchTime < 0L) && (BaseApplicationImpl.sShowTime < 0L))
      {
        l2 = BaseApplicationImpl.sLaunchTime + l1;
        if (!QLog.isColorLevel()) {
          break label384;
        }
        QLog.i("AutoMonitor", 2, "registerB, cost=" + l2);
        StatisticCollector.a(RegisterProxy.g(this.a).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "prxyRegisterB", true, l2, 0L, null, null);
      }
      if (BaseApplicationImpl.appStartTime > 0L)
      {
        l2 = BaseApplicationImpl.appStartTime;
        if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) || (!BaseApplicationImpl.isFirstLogin)) {
          break label412;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("actLoginType", localObject);
      StatisticCollector.a(RegisterProxy.h(this.a).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "prxyRegisterT", true, l1 - l2, 0L, localHashMap, null);
      if (RegisterProxy.i(this.a).jdField_a_of_type_Long > 0L)
      {
        l1 = System.currentTimeMillis() - RegisterProxy.j(this.a).jdField_a_of_type_Long;
        if (NetworkUtil.g(RegisterProxy.k(this.a).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()))
        {
          boolean bool = RegisterProxy.l(this.a).jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isFirstQQInit", true);
          localObject = new HashMap();
          ((HashMap)localObject).put("param_isFirstInit", String.valueOf(bool));
          StatisticCollector.a(RegisterProxy.m(this.a).jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(null, "prxyRegisterM", RegisterProxy.a(this.a), l1, 0L, (HashMap)localObject, null);
          if (QLog.isColorLevel()) {
            QLog.i("AutoMonitor", 2, "machineStartToStopCircle, cost=" + l1 + ", isfirstQQInit=" + bool);
          }
        }
      }
      return;
      label384:
      Log.i("AutoMonitor", "registerB, cost=" + l2);
      break;
      label412:
      if ((BaseApplicationImpl.isCurrentVersionFirstLaunch) && (!BaseApplicationImpl.isFirstLogin)) {
        localObject = "2";
      } else if ((!BaseApplicationImpl.isCurrentVersionFirstLaunch) && (BaseApplicationImpl.isFirstLogin)) {
        localObject = "3";
      } else {
        localObject = "4";
      }
    }
  }
  
  private void i()
  {
    if (this.a.a()) {
      this.a.a(7);
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2)
  {
    int j = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.e(this.a) + " onGetAllProxyMsgFin:" + paramBoolean + ", timeoutFlag=" + paramLong1 + ", type=" + paramLong2);
    }
    RegisterProxy localRegisterProxy;
    if (paramLong2 == 0L)
    {
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 8L) || (paramLong1 == 4L)) {
        break label218;
      }
      i = 2;
      RegisterProxy.d(localRegisterProxy, i);
      localRegisterProxy = this.a;
      if ((!paramBoolean) || (paramLong1 == 128L) || (paramLong1 == 64L) || (paramLong1 == 32L)) {
        break label224;
      }
      i = 2;
      label144:
      RegisterProxy.c(localRegisterProxy, i);
      this.a.jdField_a_of_type_Long = paramLong1;
      if (MessageHandler.a)
      {
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label230;
        }
        i = 2;
        label179:
        RegisterProxy.b(localRegisterProxy, i);
        localRegisterProxy = this.a;
        if (!paramBoolean) {
          break label236;
        }
      }
    }
    label218:
    label224:
    label230:
    label236:
    for (int i = j;; i = 1)
    {
      RegisterProxy.e(localRegisterProxy, i);
      MessageHandler.a = false;
      i();
      return;
      i = 1;
      break;
      i = 1;
      break label144;
      i = 1;
      break label179;
    }
  }
  
  protected void a(boolean paramBoolean, String[] paramArrayOfString)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.d(this.a) + " on GetTroopMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().h();
    paramArrayOfString = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.d(paramArrayOfString, i);
      i();
      return;
      i = 1;
    }
  }
  
  protected void e(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.a(this.a) + " on GetC2CMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().f();
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      RegisterProxy.b((RegisterProxy)localObject, i);
      if (!MessageHandler.a) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, RegisterProxy.b(this.a) + " on GetDiscussionMsg Fin: Receive empty package set isC2CMsgSuccess true");
      }
      RegisterProxy.a(this.a).jdField_b_of_type_Boolean = true;
      if (MessageHandler.jdField_b_of_type_Boolean) {
        h();
      }
      i();
      return;
    }
    localObject = RegisterProxy.b(this.a);
    if (RegisterProxy.a(this.a) == 2) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).jdField_b_of_type_Boolean = paramBoolean;
      break;
    }
  }
  
  protected void f(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "on RegisterProxy Fin:" + paramBoolean);
    }
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.a(localRegisterProxy, i);
      if (!paramBoolean) {
        break;
      }
      i();
      return;
      i = 1;
    }
    this.a.a(6);
  }
  
  protected void g(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.c(this.a) + " on GetDiscussionMsg Fin:" + paramBoolean);
    }
    MsgAutoMonitorUtil.a().j();
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.c(localRegisterProxy, i);
      i();
      return;
      i = 1;
    }
  }
  
  protected void h(boolean paramBoolean)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.f(this.a) + " on GetPAMsg Fin:" + paramBoolean);
    }
    Object localObject = this.a;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      RegisterProxy.e((RegisterProxy)localObject, i);
      if (!MessageHandler.a) {
        break;
      }
      RegisterProxy.c(this.a).c = true;
      i();
      return;
    }
    localObject = RegisterProxy.d(this.a);
    if (RegisterProxy.b(this.a) == 2) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      ((Automator)localObject).c = paramBoolean;
      break;
    }
  }
  
  protected void i(boolean paramBoolean)
  {
    int i = 2;
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, RegisterProxy.g(this.a) + " on GetFirstGroup Fin:" + paramBoolean);
    }
    RegisterProxy localRegisterProxy = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      RegisterProxy.f(localRegisterProxy, i);
      h();
      return;
      i = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zxw
 * JD-Core Version:    0.7.0.1
 */