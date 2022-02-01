package com.tencent.biz.qqstory.app;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import aqoh;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.database.QQStoryEntityManagerFactory;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import pls;
import pma;
import pmb;
import psr;
import psx;
import ram;

@TargetApi(14)
public class QQStoryContext
  implements aqoh
{
  public static boolean aAw = true;
  public static boolean aaG = true;
  public static String ats = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  public static String att = "testserver";
  public static String atu = "last_env";
  protected static BaseApplicationImpl d;
  protected StoryBroadcastReceiver a;
  protected QQStoryCmdHandler a;
  private String atv = "0_1000";
  protected EntityManagerFactory emFactory;
  
  public static QQStoryContext a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return ((pmb)BaseApplicationImpl.getApplication().getRuntime().getManager(181)).a;
    }
    if ((localAppRuntime instanceof ToolAppRuntime))
    {
      localAppRuntime = ((ToolAppRuntime)localAppRuntime).onGetSubRuntime("peak");
      ((PeakAppInterface)localAppRuntime).cKV();
      return ((PeakAppInterface)localAppRuntime).c();
    }
    return ((PeakAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak")).c();
  }
  
  public static QQAppInterface a()
  {
    return (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  }
  
  public static AppInterface c()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return (QQAppInterface)localAppRuntime;
    }
    return (PeakAppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("peak");
  }
  
  public static boolean isNightMode()
  {
    a();
    return ThemeUtil.isNowThemeIsNight(c(), false, null);
  }
  
  public QQStoryCmdHandler a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler;
  }
  
  public void blH()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver == null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver = new StoryBroadcastReceiver();
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver.cx(d);
    }
  }
  
  public void blI()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver != null)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver.cy(d);
      this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext$StoryBroadcastReceiver = null;
    }
  }
  
  public void countFlow(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    c().sendAppDataIncerment(mi(), paramBoolean, paramInt1, paramInt2, paramInt3, paramLong);
  }
  
  public long dE()
  {
    return c().getLongAccountUin();
  }
  
  public boolean eU(String paramString)
  {
    return getCurrentUid().equals(paramString);
  }
  
  public boolean eV(String paramString)
  {
    return mi().equals(paramString);
  }
  
  public BaseApplicationImpl getApplication()
  {
    return d;
  }
  
  public String getCurrentUid()
  {
    if (this.atv.equals("0_1000"))
    {
      this.atv = ((String)((psr)psx.a(10)).c("qqstory_my_union_id", "0_1000"));
      ram.w("Q.qqstory.user.QQStoryRuntime", "get current unionId from sp %s", new Object[] { this.atv });
    }
    return this.atv;
  }
  
  public EntityManagerFactory getEntityManagerFactory()
  {
    Object localObject1 = mi();
    if (localObject1 == null) {
      throw new IllegalStateException("Can not create a entity factory, the account is null.");
    }
    try
    {
      if (this.emFactory == null)
      {
        localObject1 = new QQStoryEntityManagerFactory((String)localObject1);
        ((QQStoryEntityManagerFactory)localObject1).verifyAuthentication();
        this.emFactory = ((EntityManagerFactory)localObject1);
      }
      return this.emFactory;
    }
    finally {}
  }
  
  public String mi()
  {
    return c().getAccount();
  }
  
  /* Error */
  public void onCreate()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 145	com/tencent/biz/qqstory/app/QQStoryContext:d	Lcom/tencent/common/app/BaseApplicationImpl;
    //   6: ifnonnull +65 -> 71
    //   9: iconst_1
    //   10: istore_1
    //   11: iload_1
    //   12: putstatic 71	com/tencent/biz/qqstory/app/QQStoryContext:aAw	Z
    //   15: invokestatic 86	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   18: putstatic 145	com/tencent/biz/qqstory/app/QQStoryContext:d	Lcom/tencent/common/app/BaseApplicationImpl;
    //   21: getstatic 71	com/tencent/biz/qqstory/app/QQStoryContext:aAw	Z
    //   24: ifeq +25 -> 49
    //   27: getstatic 145	com/tencent/biz/qqstory/app/QQStoryContext:d	Lcom/tencent/common/app/BaseApplicationImpl;
    //   30: new 226	pmf
    //   33: dup
    //   34: getstatic 145	com/tencent/biz/qqstory/app/QQStoryContext:d	Lcom/tencent/common/app/BaseApplicationImpl;
    //   37: invokespecial 228	pmf:<init>	(Landroid/content/Context;)V
    //   40: invokestatic 234	com/tribe/async/async/Bosses:initWithBoss	(Landroid/content/Context;Lcom/tribe/async/async/Boss;)V
    //   43: invokestatic 239	ral:a	()Lral;
    //   46: invokestatic 242	ram:a	(Lrak;)V
    //   49: ldc 2
    //   51: monitorexit
    //   52: ldc 195
    //   54: ldc 244
    //   56: invokestatic 247	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   59: aload_0
    //   60: new 249	com/tencent/biz/qqstory/channel/QQStoryCmdHandler
    //   63: dup
    //   64: invokespecial 250	com/tencent/biz/qqstory/channel/QQStoryCmdHandler:<init>	()V
    //   67: putfield 139	com/tencent/biz/qqstory/app/QQStoryContext:jdField_a_of_type_ComTencentBizQqstoryChannelQQStoryCmdHandler	Lcom/tencent/biz/qqstory/channel/QQStoryCmdHandler;
    //   70: return
    //   71: iconst_0
    //   72: istore_1
    //   73: goto -62 -> 11
    //   76: astore_2
    //   77: ldc 2
    //   79: monitorexit
    //   80: aload_2
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	QQStoryContext
    //   10	63	1	bool	boolean
    //   76	5	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   3	9	76	finally
    //   11	49	76	finally
    //   49	52	76	finally
    //   77	80	76	finally
  }
  
  public void qL(String paramString)
  {
    ram.w("Q.qqstory.user.QQStoryRuntime", "update current unionId %s", new Object[] { paramString });
    if ((!this.atv.equals(paramString)) && (!"0_1000".equals(paramString)) && (!TextUtils.isEmpty(paramString)))
    {
      this.atv = paramString;
      ((psr)psx.a(10)).n("qqstory_my_union_id", this.atv);
    }
  }
  
  public static class StoryBroadcastReceiver
    extends BroadcastReceiver
  {
    private static final String TAG = "StoryBroadcastReceiver_" + MobileQQ.processName;
    private boolean registered;
    
    public void cx(Context paramContext)
    {
      if (!this.registered)
      {
        this.registered = true;
        IntentFilter localIntentFilter = new IntentFilter();
        localIntentFilter.addAction("action_fire_create_story");
        localIntentFilter.addAction("action_fire_get_config");
        localIntentFilter.addAction("action_fire_create_video_story");
        paramContext.getApplicationContext().registerReceiver(this, localIntentFilter);
      }
    }
    
    public void cy(Context paramContext)
    {
      if (this.registered)
      {
        this.registered = false;
        paramContext.getApplicationContext().unregisterReceiver(this);
      }
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      ram.b(TAG, "onReceive, [context, intent=%s]", paramIntent);
      paramIntent = paramIntent.getAction();
      if ("action_fire_create_story".equals(paramIntent)) {
        if (TextUtils.equals(paramContext.getPackageName(), MobileQQ.processName)) {
          Bosses.get().postJob(new pls(this, TAG));
        }
      }
      do
      {
        return;
        if ("action_fire_get_config".equals(paramIntent))
        {
          long l = ((psr)psx.a(10)).dJ();
          if (Math.abs(System.currentTimeMillis() - l) > 3600000L)
          {
            ram.d(TAG, "fireGetStoryConfig update story config from server.");
            ((pma)QQStoryContext.a().getBusinessHandler(98)).blO();
            return;
          }
          ram.d(TAG, "fireGetStoryConfig do not need update story config from server.");
          return;
        }
      } while (!"action_fire_create_video_story".equals(paramIntent));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.app.QQStoryContext
 * JD-Core Version:    0.7.0.1
 */