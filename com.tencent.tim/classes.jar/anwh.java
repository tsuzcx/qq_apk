import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.gaudio.AVNotifyCenter.g;
import com.tencent.av.gaudio.AVNotifyCenter.h;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.GuardProcessExitListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.studyroom.ui.StudyRoomLoadingFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.dynamic.host.DynamicPluginManager;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Vector;
import mqq.manager.Manager;

public class anwh
  implements Manager
{
  private final GuardProcessExitListener jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener = new anwi(this);
  private DynamicPluginManager jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager;
  private volatile long aoa;
  private volatile QQAppInterface mApp;
  private final BroadcastReceiver qqAccountReceiver = new anwj(this);
  
  public anwh(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    registerProcessExitReceiver();
    registerAccountReceiver();
  }
  
  private void registerAccountReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_KICKED");
    localIntentFilter.addAction("mqq.intent.action.EXIT_" + BaseApplicationImpl.getApplication().getPackageName());
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_CHANGED");
    localIntentFilter.addAction("mqq.intent.action.ACCOUNT_EXPIRED");
    localIntentFilter.addAction("mqq.intent.action.LOGOUT");
    localIntentFilter.addAction("mqq.intent.action.LOGIN");
    BaseApplicationImpl.getApplication().registerReceiver(this.qqAccountReceiver, localIntentFilter);
  }
  
  private void registerProcessExitReceiver()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.process.exit");
    BaseApplicationImpl.getApplication().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener, localIntentFilter);
  }
  
  public void a(DynamicPluginManager paramDynamicPluginManager)
  {
    this.jdField_a_of_type_ComTencentShadowDynamicHostDynamicPluginManager = paramDynamicPluginManager;
  }
  
  public void d(Context paramContext, HashMap<String, String> paramHashMap)
  {
    if ((this.mApp.bF()) || (this.mApp.a().um()))
    {
      QLog.d("studyroom.StudyRoomManager", 4, "block because isVideoChatting() && isAvChating()");
      QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    if (this.mApp.a().bG() > 0L)
    {
      QLog.d("studyroom.StudyRoomManager", 4, "block because getChatingRelationId()>0");
      QQToast.a(paramContext, 2131698108, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    Object localObject1 = (HashMap)this.mApp.a().v();
    int j;
    if (localObject1 != null)
    {
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      int i = 0;
      j = i;
      if (!((Iterator)localObject1).hasNext()) {
        break label334;
      }
      Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((localObject2 == null) || (((Map.Entry)localObject2).getKey() == null) || (((Map.Entry)localObject2).getValue() == null)) {
        break label373;
      }
      long l = ((Long)((Map.Entry)localObject2).getKey()).longValue();
      j = ((Integer)((Map.Entry)localObject2).getValue()).intValue();
      if ((j != 2) && (j != 12)) {
        break label373;
      }
      localObject2 = this.mApp.a().a(l, j);
      if ((localObject2 == null) || (((AVNotifyCenter.h)localObject2).memberNum <= 0)) {
        break label373;
      }
      localObject2 = this.mApp.a().a(l);
      if (localObject2 == null) {
        break label373;
      }
      localObject2 = ((Vector)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        AVNotifyCenter.g localg = (AVNotifyCenter.g)((Iterator)localObject2).next();
        if ((localg != null) && (TextUtils.equals(String.valueOf(localg.id), this.mApp.getCurrentUin()))) {
          i = 1;
        }
      }
    }
    label334:
    label373:
    for (;;)
    {
      break;
      j = 0;
      if (j != 0)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "block because group video");
        QQToast.a(paramContext, 2131698109, 1).show(paramContext.getResources().getDimensionPixelSize(2131299627));
        return;
      }
      StudyRoomLoadingFragment.ao(paramHashMap);
      return;
    }
  }
  
  public void fi(Context paramContext)
  {
    anwk localanwk = anwl.a();
    if ((localanwk != null) && (localanwk.azh()) && (aqiw.isWifiEnabled(paramContext)))
    {
      long l = System.currentTimeMillis();
      if (l - this.aoa > 1800000L)
      {
        QLog.d("studyroom.StudyRoomManager", 4, "preDownload");
        this.aoa = l;
        anxf.a(paramContext, new Bundle(), true, new anxf.b());
      }
    }
    else
    {
      return;
    }
    QLog.w("studyroom.StudyRoomManager", 4, "preDownload too fast");
  }
  
  public void onDestroy()
  {
    try
    {
      BaseApplicationImpl.getApplication().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqAppGuardProcessExitListener);
      try
      {
        label10:
        BaseApplicationImpl.getApplication().unregisterReceiver(this.qqAccountReceiver);
        return;
      }
      catch (Exception localException1) {}
    }
    catch (Exception localException2)
    {
      break label10;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anwh
 * JD-Core Version:    0.7.0.1
 */