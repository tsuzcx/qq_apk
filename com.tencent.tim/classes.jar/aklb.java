import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.notification.modularize.OnlineModulePushReceiverKt.sam.java_lang_Runnable.0;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime.Status;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TAG", "", "cachedNotifyIdMap", "Ljava/util/concurrent/ConcurrentHashMap;", "", "cancelAllPush", "", "isAppBackground", "", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "joinProcessesAsString", "processes", "", "Landroid/app/ActivityManager$RunningAppProcessInfo;", "needShieldPush", "runAsync", "run", "Lkotlin/Function0;", "AQQLiteApp_release"}, k=2, mv={1, 1, 16})
public final class aklb
{
  private static final ConcurrentHashMap<Integer, Integer> gs = new ConcurrentHashMap();
  
  @NotNull
  public static final String J(@NotNull List<? extends ActivityManager.RunningAppProcessInfo> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "processes");
    Object localObject = (Iterable)paramList;
    paramList = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)((Iterator)localObject).next();
      paramList.add("name: " + localRunningAppProcessInfo.processName + " imp: " + localRunningAppProcessInfo.importance + " pid: " + localRunningAppProcessInfo.pid);
    }
    return CollectionsKt.joinToString$default((Iterable)paramList, null, null, null, 0, null, null, 63, null);
  }
  
  public static final void a(@NotNull Function0<Unit> paramFunction0)
  {
    Intrinsics.checkParameterIsNotNull(paramFunction0, "run");
    if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
    {
      ThreadManagerV2.executeOnSubThread((Runnable)new OnlineModulePushReceiverKt.sam.java_lang_Runnable.0(paramFunction0));
      return;
    }
    paramFunction0.invoke();
  }
  
  public static final boolean bj(@NotNull QQAppInterface paramQQAppInterface)
  {
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    if (Build.VERSION.SDK_INT > 19)
    {
      BaseApplication localBaseApplication = BaseApplication.context;
      Object localObject1 = localBaseApplication.getSystemService("activity");
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.app.ActivityManager");
      }
      localObject1 = ((ActivityManager)localObject1).getRunningAppProcesses();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "procList");
      Object localObject2 = (Iterable)localObject1;
      localObject1 = (Collection)new ArrayList();
      localObject2 = ((Iterable)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = ((Iterator)localObject2).next();
        ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localObject3;
        if (paramQQAppInterface.isAppOnForeground((Context)localBaseApplication, localRunningAppProcessInfo.processName)) {
          ((Collection)localObject1).add(localObject3);
        }
      }
      paramQQAppInterface = (List)localObject1;
      if (QLog.isColorLevel()) {
        QLog.d("OnlineModulePushReceiver", 2, new Object[] { "isAppBackground: called. ", "foreProcesses: " + J(paramQQAppInterface) });
      }
      return paramQQAppInterface.isEmpty();
    }
    boolean bool = qec.u(paramQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("OnlineModulePushReceiver", 2, new Object[] { "isAppBackground: kitkat called. ", "foreground: " + bool });
    }
    return !bool;
  }
  
  public static final boolean bk(@NotNull QQAppInterface paramQQAppInterface)
  {
    boolean bool2 = false;
    Intrinsics.checkParameterIsNotNull(paramQQAppInterface, "app");
    boolean bool3 = FriendsStatusUtil.bc((Context)paramQQAppInterface.getApp());
    if (paramQQAppInterface.getOnlineStatus() == AppRuntime.Status.dnd) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnlineModulePushReceiver", 2, new Object[] { "needShieldPush: called. ", "canNotDisturb: " + bool3 + "  dndStatus: " + bool1 });
      }
      if ((bool3) || (bool1)) {
        bool2 = true;
      }
      return bool2;
    }
  }
  
  public static final void dBF()
  {
    Object localObject = gs.keySet();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "cachedNotifyIdMap.keys");
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      QQNotificationManager localQQNotificationManager = QQNotificationManager.getInstance();
      Intrinsics.checkExpressionValueIsNotNull(localInteger, "it");
      localQQNotificationManager.cancel("OnlineModulePushReceiver", localInteger.intValue());
    }
    gs.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aklb
 * JD-Core Version:    0.7.0.1
 */