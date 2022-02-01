import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.process.data.CmGameManager.2;
import com.tencent.mobileqq.apollo.process.data.CmGameManager.3;
import com.tencent.mobileqq.apollo.process.data.CmGameManager.GameEventReceiver.1;
import com.tencent.mobileqq.apollo.store.ApolloDiyTextActivity;
import com.tencent.mobileqq.apollo.store.ApolloGameActivity;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.app.MobileQQ;
import mqq.manager.Manager;
import org.json.JSONArray;

public class aboz
  implements Manager
{
  public static final Class[] e = { ApolloGameActivity.class, ApolloDiyTextActivity.class };
  private CopyOnWriteArrayList<abos> I = new CopyOnWriteArrayList();
  private abkj a;
  private ApolloCmdChannel b;
  private boolean bEA;
  private boolean bEy = true;
  private boolean bEz;
  private Set<Integer> bG = new HashSet();
  public int cqA;
  private int cqz;
  private ConcurrentHashMap<Integer, String> dq = new ConcurrentHashMap();
  private Runnable ft = new CmGameManager.2(this);
  private AppInterface mApp;
  protected BroadcastReceiver mBroadcastReceiver;
  public List<aboz.b> wt = new CopyOnWriteArrayList();
  
  public aboz(AppInterface paramAppInterface)
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] created.");
    this.mApp = paramAppInterface;
    this.b = new ApolloCmdChannel(abmt.getAppInterface());
    this.mBroadcastReceiver = new aboz.a();
    paramAppInterface = new IntentFilter();
    paramAppInterface.addAction("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
    try
    {
      if (this.mApp != null) {
        this.mApp.getApplication().registerReceiver(this.mBroadcastReceiver, paramAppInterface, "com.tencent.tim.msg.permission.pushnotify", null);
      }
      ThreadManager.excute(this.ft, 64, null, true);
      return;
    }
    catch (Throwable paramAppInterface)
    {
      for (;;)
      {
        QLog.e("cmgame_process.CmGameManager", 1, paramAppInterface, new Object[0]);
      }
    }
  }
  
  private void cDT()
  {
    if (this.mApp == null) {
      return;
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.sApplication.getSharedPreferences("apollo_sp", 4);
    this.cqz = localSharedPreferences.getInt("sp_key_exit_game_guide_count_limit", 0);
    if (localSharedPreferences.getInt("sp_key_exit_show_game_box_guide", 0) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      this.bEz = bool;
      localSharedPreferences = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentAccountUin(), 4);
      this.cqA = localSharedPreferences.getInt("sp_key_exit_game_guide_count", 0);
      cDW();
      if (this.cqA >= this.cqz) {
        this.bEy = false;
      }
      if (this.bEy)
      {
        WindowManager localWindowManager = (WindowManager)BaseApplicationImpl.getApplication().getSystemService("window");
        if (localWindowManager != null)
        {
          int i = localWindowManager.getDefaultDisplay().getWidth();
          if (i <= 480)
          {
            this.bEy = false;
            QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "initGameExitData current display not should show game exit guide width:", Integer.valueOf(i) });
          }
        }
        if (localSharedPreferences.contains("exit_game_guide_today_" + ApolloUtil.rt())) {
          this.bEy = false;
        }
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "initGameExitData mGameExitCurrentCount:", Integer.valueOf(this.cqA), ",mGameExitLimitCount:", Integer.valueOf(this.cqz), ",mShouldShowGameGuide:", Boolean.valueOf(this.bEy), ",mShouldShowGameBoxGuide:", Boolean.valueOf(this.bEz) });
      return;
    }
  }
  
  private void cDV()
  {
    Object localObject1 = this.mApp.getApp().getSharedPreferences("apollo_sp" + this.mApp.getCurrentAccountUin(), 4);
    String str1 = "exit_game_guide_today_" + ApolloUtil.rt();
    SharedPreferences.Editor localEditor = ((SharedPreferences)localObject1).edit();
    if (((SharedPreferences)localObject1).contains(str1)) {
      QLog.e("cmgame_process.CmGameManager", 1, "recordTodayCount today has show");
    }
    for (;;)
    {
      localEditor.commit();
      this.bEy = false;
      return;
      Object localObject2 = ((SharedPreferences)localObject1).getAll();
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((Map)localObject2).entrySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject2).next();
          String str2 = (String)localEntry.getKey();
          if ((str2 != null) && (str2.startsWith("exit_game_guide_today_"))) {
            ((List)localObject1).add(localEntry.getKey());
          }
        }
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext()) {
          localEditor.remove((String)((Iterator)localObject1).next());
        }
      }
      localEditor.putInt(str1, 1);
    }
  }
  
  private void cDW()
  {
    int i = 0;
    String[] arrayOfString = new String[4];
    arrayOfString[0] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play.png";
    arrayOfString[1] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_play_landscape.png";
    arrayOfString[2] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus.png";
    arrayOfString[3] = "https://cmshow.gtimg.cn/client/img/cmgame_framwork_guide_plus_landscape.png";
    while (i < arrayOfString.length)
    {
      abtn.jz(arrayOfString[i]);
      i += 1;
    }
  }
  
  private void cDX()
  {
    int i = 0;
    if ((this.mApp == null) || (this.mApp.getApp() == null)) {}
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences("cmgame_sp", 4).getString(this.mApp.getCurrentAccountUin() + "_" + "cmgame_sp_dev_game_list", "");
      if (QLog.isColorLevel()) {
        QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "initDevGameList get gameList:", localObject });
      }
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        continue;
      }
      if (((String)localObject).equals("1"))
      {
        this.bG.add(Integer.valueOf(1));
        return;
      }
      try
      {
        localObject = new JSONArray((String)localObject);
        while (i < ((JSONArray)localObject).length())
        {
          this.bG.add(Integer.valueOf(((JSONArray)localObject).getInt(i)));
          i += 1;
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("cmgame_process.CmGameManager", 1, "initDevGameList e:", localException);
      }
    }
  }
  
  public void DX(boolean paramBoolean)
  {
    this.bEA = paramBoolean;
  }
  
  public boolean YR()
  {
    if (this.cqA < this.cqz) {}
    for (int i = 1;; i = 0)
    {
      if ((i != 0) && (QLog.isColorLevel())) {
        QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "isShowGameExitGuide GameExitCurrentCount:", Integer.valueOf(this.cqA), ",mGameExitLimitCount:", Integer.valueOf(this.cqz), ",mShouldShowGameGuide:", Boolean.valueOf(this.bEy) });
      }
      return i & this.bEy;
    }
  }
  
  public boolean YS()
  {
    return this.bEz;
  }
  
  /* Error */
  public abkj a()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 397	aboz:bEA	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifne +9 -> 17
    //   11: aconst_null
    //   12: astore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: aload_2
    //   16: areturn
    //   17: aload_0
    //   18: getfield 404	aboz:a	Labkj;
    //   21: ifnonnull +29 -> 50
    //   24: aload_0
    //   25: new 406	abkj
    //   28: dup
    //   29: invokespecial 407	abkj:<init>	()V
    //   32: putfield 404	aboz:a	Labkj;
    //   35: invokestatic 255	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   38: ifeq +12 -> 50
    //   41: ldc 85
    //   43: iconst_2
    //   44: ldc_w 409
    //   47: invokestatic 411	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 404	aboz:a	Labkj;
    //   54: astore_2
    //   55: goto -42 -> 13
    //   58: astore_2
    //   59: aload_0
    //   60: monitorexit
    //   61: aload_2
    //   62: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	63	0	this	aboz
    //   6	2	1	bool	boolean
    //   12	43	2	localabkj	abkj
    //   58	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	58	finally
    //   17	50	58	finally
    //   50	55	58	finally
  }
  
  public abos a(int paramInt1, int paramInt2)
  {
    if (paramInt1 <= 0) {}
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameManager", 2, "[getLauncher], invalid gameId.");
        }
        localabos = null;
        return localabos;
      }
      finally {}
      abos localabos = new abos(paramInt1);
      localabos.cpN = paramInt2;
      this.I.add(0, localabos);
      QLog.i("cmgame_process.CmGameManager", 1, "add a new launcher, gameId:" + paramInt1 + ",total size:" + this.I.size());
    }
  }
  
  public ApolloCmdChannel a()
  {
    return this.b;
  }
  
  public abos b(int paramInt)
  {
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      abos localabos = (abos)localIterator.next();
      if ((localabos != null) && (paramInt == localabos.getGameId())) {
        return localabos;
      }
    }
    return null;
  }
  
  /* Error */
  public abos b(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	aboz:I	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 438	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 4
    //   11: aload 4
    //   13: invokeinterface 308 1 0
    //   18: ifeq +91 -> 109
    //   21: aload 4
    //   23: invokeinterface 312 1 0
    //   28: checkcast 416	abos
    //   31: astore_3
    //   32: aload_3
    //   33: ifnull -22 -> 11
    //   36: iload_1
    //   37: aload_3
    //   38: invokevirtual 441	abos:getGameId	()I
    //   41: if_icmpne -30 -> 11
    //   44: iload_2
    //   45: aload_3
    //   46: getfield 422	abos:cpN	I
    //   49: if_icmpne -38 -> 11
    //   52: aload_0
    //   53: getfield 62	aboz:I	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   56: aload_3
    //   57: invokevirtual 443	java/util/concurrent/CopyOnWriteArrayList:remove	(Ljava/lang/Object;)Z
    //   60: ifeq -49 -> 11
    //   63: ldc 85
    //   65: iconst_1
    //   66: new 186	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 187	java/lang/StringBuilder:<init>	()V
    //   73: ldc_w 445
    //   76: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: iload_1
    //   80: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   83: ldc_w 432
    //   86: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 62	aboz:I	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   93: invokevirtual 435	java/util/concurrent/CopyOnWriteArrayList:size	()I
    //   96: invokevirtual 430	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 93	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_3
    //   108: areturn
    //   109: aconst_null
    //   110: astore_3
    //   111: goto -6 -> 105
    //   114: astore_3
    //   115: aload_0
    //   116: monitorexit
    //   117: aload_3
    //   118: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	aboz
    //   0	119	1	paramInt1	int
    //   0	119	2	paramInt2	int
    //   31	80	3	localabos	abos
    //   114	4	3	localObject	Object
    //   9	13	4	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   2	11	114	finally
    //   11	32	114	finally
    //   36	105	114	finally
  }
  
  /* Error */
  public abos b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	aboz:I	Ljava/util/concurrent/CopyOnWriteArrayList;
    //   6: invokevirtual 438	java/util/concurrent/CopyOnWriteArrayList:iterator	()Ljava/util/Iterator;
    //   9: astore 6
    //   11: aload 6
    //   13: invokeinterface 308 1 0
    //   18: ifeq +49 -> 67
    //   21: aload 6
    //   23: invokeinterface 312 1 0
    //   28: checkcast 416	abos
    //   31: astore 5
    //   33: aload 5
    //   35: ifnull -24 -> 11
    //   38: aload 5
    //   40: invokevirtual 449	abos:b	()Lcom/tencent/mobileqq/apollo/ApolloSurfaceView;
    //   43: astore 7
    //   45: aload 7
    //   47: ifnull -36 -> 11
    //   50: aload 7
    //   52: invokevirtual 455	com/tencent/mobileqq/apollo/ApolloSurfaceView:getLuaState	()J
    //   55: lstore_3
    //   56: lload_3
    //   57: lload_1
    //   58: lcmp
    //   59: ifne -48 -> 11
    //   62: aload_0
    //   63: monitorexit
    //   64: aload 5
    //   66: areturn
    //   67: aconst_null
    //   68: astore 5
    //   70: goto -8 -> 62
    //   73: astore 5
    //   75: aload_0
    //   76: monitorexit
    //   77: aload 5
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	aboz
    //   0	80	1	paramLong	long
    //   55	2	3	l	long
    //   31	38	5	localabos	abos
    //   73	5	5	localObject	Object
    //   9	13	6	localIterator	Iterator
    //   43	8	7	localApolloSurfaceView	com.tencent.mobileqq.apollo.ApolloSurfaceView
    // Exception table:
    //   from	to	target	type
    //   2	11	73	finally
    //   11	33	73	finally
    //   38	45	73	finally
    //   50	56	73	finally
  }
  
  public void b(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    cDS();
    QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityCreate activity" + paramActivity + " mRunningTaskList.size():" + this.wt.size());
    if ((paramStartCheckParam != null) && (paramActivity != null)) {
      if (paramStartCheckParam.gameId != 3112) {}
    }
    label254:
    for (;;)
    {
      return;
      Iterator localIterator = this.wt.iterator();
      aboz.b localb;
      while (localIterator.hasNext())
      {
        localb = (aboz.b)localIterator.next();
        if ((localb != null) && (localb.b.gameId == paramStartCheckParam.gameId))
        {
          localb.auG = 1;
          localb.mActivityRef = new WeakReference(paramActivity);
          QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityCreate foundTask" + localb);
        }
      }
      for (;;)
      {
        if (localb != null) {
          break label254;
        }
        if (paramStartCheckParam != null) {
          QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "onGameActivityCreate but no found gameId:", Integer.valueOf(paramStartCheckParam.gameId) });
        }
        if (paramActivity == null) {
          break;
        }
        localb = new aboz.b();
        localb.b = paramStartCheckParam;
        localb.bhk = paramActivity.getClass().getSimpleName();
        localb.auG = 1;
        localb.mActivityRef = new WeakReference(paramActivity);
        this.wt.add(localb);
        return;
        localb = null;
      }
    }
  }
  
  public void bQ(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "ssoCmdRule gameId: " + paramInt + ", rule: ", paramString });
    }
    if ((paramInt > 0) && (!TextUtils.isEmpty(paramString))) {
      this.dq.put(Integer.valueOf(paramInt), paramString);
    }
  }
  
  public abos c()
  {
    Iterator localIterator = this.I.iterator();
    while (localIterator.hasNext())
    {
      abos localabos = (abos)localIterator.next();
      if ((localabos != null) && (!abmt.hP(localabos.getGameId())) && (!abmt.hQ(localabos.getGameId()))) {
        return localabos;
      }
    }
    return null;
  }
  
  public void c(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityResume activity" + paramActivity + " mRunningTaskList.size():" + this.wt.size());
    if ((paramStartCheckParam != null) && (paramActivity != null)) {
      if (paramStartCheckParam.gameId != 3112) {}
    }
    for (;;)
    {
      return;
      Iterator localIterator = this.wt.iterator();
      aboz.b localb;
      while (localIterator.hasNext())
      {
        localb = (aboz.b)localIterator.next();
        if ((localb != null) && (localb.b.gameId == paramStartCheckParam.gameId))
        {
          localb.auG = 2;
          localb.mActivityRef = new WeakReference(paramActivity);
          localb.Oi = System.currentTimeMillis();
          QLog.d("cmgame_process.CmGameManager", 1, "onGameActivityResume foundTask" + localb);
        }
      }
      for (paramActivity = localb; (paramActivity == null) && (paramStartCheckParam != null); paramActivity = null)
      {
        QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "onGameActivityResume but no found gameId:", Integer.valueOf(paramStartCheckParam.gameId) });
        return;
      }
    }
  }
  
  public void cDS()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameManager", 1, "checkValidGameTask");
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.wt.iterator();
    while (localIterator.hasNext())
    {
      aboz.b localb = (aboz.b)localIterator.next();
      if (localb != null) {
        if (localb.mActivityRef == null)
        {
          localArrayList.add(localb);
          QLog.e("cmgame_process.CmGameManager", 1, "checkValidGameTask remove invalid 1 gameTask:" + localb.b);
        }
        else
        {
          if (localb.mActivityRef.get() == null) {
            localArrayList.add(localb);
          }
          QLog.e("cmgame_process.CmGameManager", 1, "checkValidGameTask remove invalid 2 gameTask:" + localb.b);
        }
      }
    }
    this.wt.removeAll(localArrayList);
  }
  
  public void cDU()
  {
    this.cqA += 1;
    ThreadManager.excute(new CmGameManager.3(this), 64, null, true);
  }
  
  public void d(Activity paramActivity, CmGameStartChecker.StartCheckParam paramStartCheckParam)
  {
    if ((paramStartCheckParam != null) && (paramActivity != null))
    {
      if (paramStartCheckParam.gameId == 3112) {
        return;
      }
      Iterator localIterator = this.wt.iterator();
      while (localIterator.hasNext())
      {
        paramActivity = (aboz.b)localIterator.next();
        if ((paramActivity != null) && (paramActivity.b.gameId == paramStartCheckParam.gameId))
        {
          paramActivity.auG = 5;
          paramActivity.mActivityRef = null;
        }
      }
    }
    for (;;)
    {
      if (paramActivity == null)
      {
        if (paramStartCheckParam == null) {
          break;
        }
        QLog.e("cmgame_process.CmGameManager", 1, new Object[] { "onGameActivityDestroy but no found gameId:", paramStartCheckParam.gameId + " mRunningTaskList.size():" + this.wt.size() });
        return;
      }
      this.wt.remove(paramActivity);
      QLog.i("cmgame_process.CmGameManager", 1, "onGameActivityDestroy remove foundTask:" + paramActivity + " mRunningTaskList.size():" + this.wt.size());
      return;
      paramActivity = null;
    }
  }
  
  public List<aboz.b> dG()
  {
    ArrayList localArrayList = new ArrayList(this.wt);
    Collections.sort(localArrayList, new abpa(this));
    return localArrayList;
  }
  
  public String df(int paramInt)
  {
    if (this.dq.get(Integer.valueOf(paramInt)) != null) {
      return (String)this.dq.get(Integer.valueOf(paramInt));
    }
    return "^(apollo_game_[_a-zA-Z0-9.]*|apollo_aio_game[_a-zA-Z0-9.]*)";
  }
  
  public boolean hT(int paramInt)
  {
    return (this.bG.contains(Integer.valueOf(1))) || (this.bG.contains(Integer.valueOf(paramInt)));
  }
  
  public void onDestroy()
  {
    QLog.i("cmgame_process.CmGameManager", 1, "[CmGameManager] destroyed.");
    try
    {
      if (this.mBroadcastReceiver != null) {
        this.mApp.getApplication().unregisterReceiver(this.mBroadcastReceiver);
      }
      ablo.destroy();
      if (this.a != null) {
        this.a.onDestroy();
      }
      this.bEA = false;
      return;
    }
    catch (Exception localException)
    {
      QLog.e("cmgame_process.CmGameManager", 1, "[doDestroy] exception=", localException);
    }
  }
  
  public static class a
    extends BroadcastReceiver
  {
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      if (paramIntent == null) {
        QLog.e("cmgame_process.CmGameManager", 1, "[onReceive] intent null");
      }
      do
      {
        do
        {
          return;
          paramContext = paramIntent.getAction();
          if (QLog.isColorLevel()) {
            QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] action=", paramContext });
          }
        } while ((!"com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT".equals(paramContext)) || (!"apolloGameWebMessage".equals(paramIntent.getStringExtra("event"))));
        paramContext = paramIntent.getStringExtra("data");
        if (QLog.isColorLevel()) {
          QLog.d("cmgame_process.CmGameManager", 2, new Object[] { "[onReceive] data=", paramContext });
        }
      } while (TextUtils.isEmpty(paramContext));
      ThreadManagerV2.excute(new CmGameManager.GameEventReceiver.1(this, paramContext), 16, null, false);
    }
  }
  
  public static class b
  {
    public long Oi;
    public int auG;
    public CmGameStartChecker.StartCheckParam b;
    public String bhk;
    public WeakReference<Activity> mActivityRef;
    
    public String toString()
    {
      StringBuffer localStringBuffer = new StringBuffer("GameRunningTask{");
      localStringBuffer.append("mStartCheckParam=").append(this.b);
      localStringBuffer.append(", mActivityRef=").append(this.mActivityRef);
      localStringBuffer.append(", mActivityState=").append(this.auG);
      localStringBuffer.append('}');
      return localStringBuffer.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aboz
 * JD-Core Version:    0.7.0.1
 */