import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.main.LebaTabRedTouch.1;
import com.tencent.mobileqq.activity.recent.DrawerFrame.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppSetting;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class zjt
{
  private static volatile zjt.b a;
  public SplashActivity a;
  
  public zjt(SplashActivity paramSplashActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = paramSplashActivity;
  }
  
  private boolean Vt()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return false;
    }
    Iterator localIterator = ((altq)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(36)).fV().iterator();
    while (localIterator.hasNext())
    {
      BusinessInfoCheckUpdate.AppSetting localAppSetting = (BusinessInfoCheckUpdate.AppSetting)localIterator.next();
      if (localAppSetting.appid.get() == 1130L) {
        return localAppSetting.setting.get();
      }
    }
    return true;
  }
  
  private awja a()
  {
    if (!Vt()) {
      return null;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return null;
    }
    ReadInJoyManager localReadInJoyManager = (ReadInJoyManager)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(96);
    if (localReadInJoyManager == null) {
      return null;
    }
    return localReadInJoyManager.c();
  }
  
  public static void cpD()
  {
    zjt.b localb = jdField_a_of_type_Zjt$b;
    StringBuilder localStringBuilder = new StringBuilder().append("doQZoneRedPointClickReport: ");
    if (localb == null) {}
    for (String str = "null";; str = zjt.b.a(localb) + " " + zjt.b.a(localb))
    {
      QLog.i("MainAssistObserver.LebaTabRedTouch", 4, str);
      if ((localb != null) && (zjt.b.a(localb) <= 0) && (zjt.b.a(localb))) {
        break;
      }
      LpReportInfo_pf00064.allReport(637, 22, 2);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 21, 2);
  }
  
  public static void cpE()
  {
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "clearReportCache");
    jdField_a_of_type_Zjt$b = null;
  }
  
  /* Error */
  private com.tencent.util.Pair<java.lang.Integer, java.lang.Boolean> d()
  {
    // Byte code:
    //   0: invokestatic 163	anlm:ayn	()Z
    //   3: ifne +9 -> 12
    //   6: invokestatic 168	common/config/service/QzoneConfig:isQQCircleShowLebaEntrance	()Z
    //   9: ifne +5 -> 14
    //   12: aconst_null
    //   13: areturn
    //   14: invokestatic 174	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   17: invokevirtual 178	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   20: bipush 36
    //   22: invokevirtual 181	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   25: checkcast 39	altq
    //   28: astore 4
    //   30: aload 4
    //   32: ldc 183
    //   34: invokevirtual 187	altq:getAppInfoByPath	(Ljava/lang/String;)Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;
    //   37: astore 5
    //   39: aload 5
    //   41: ifnonnull +5 -> 46
    //   44: aconst_null
    //   45: areturn
    //   46: aload 4
    //   48: aconst_null
    //   49: invokevirtual 190	altq:a	(Laltq$b;)I
    //   52: istore_1
    //   53: aload 5
    //   55: getfield 196	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:iNewFlag	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   58: invokevirtual 199	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   61: istore_2
    //   62: iload_2
    //   63: iconst_1
    //   64: if_icmpne +21 -> 85
    //   67: iconst_1
    //   68: istore_3
    //   69: new 201	com/tencent/util/Pair
    //   72: dup
    //   73: iload_1
    //   74: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   77: iload_3
    //   78: invokestatic 212	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   81: invokespecial 215	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   84: areturn
    //   85: iconst_0
    //   86: istore_3
    //   87: goto -18 -> 69
    //   90: astore 4
    //   92: iconst_0
    //   93: istore_1
    //   94: ldc 123
    //   96: iconst_2
    //   97: new 112	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   104: ldc 217
    //   106: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: aload 4
    //   111: invokevirtual 218	java/lang/Exception:toString	()Ljava/lang/String;
    //   114: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 127	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 221	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: iconst_0
    //   124: istore_3
    //   125: goto -56 -> 69
    //   128: astore 4
    //   130: goto -36 -> 94
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	zjt
    //   52	42	1	i	int
    //   61	4	2	j	int
    //   68	57	3	bool	boolean
    //   28	19	4	localaltq	altq
    //   90	20	4	localException1	java.lang.Exception
    //   128	1	4	localException2	java.lang.Exception
    //   37	17	5	localAppInfo	com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo
    // Exception table:
    //   from	to	target	type
    //   30	39	90	java/lang/Exception
    //   46	53	90	java/lang/Exception
    //   53	62	128	java/lang/Exception
  }
  
  private static void gh(int paramInt1, int paramInt2)
  {
    if (!anlm.Vr()) {}
    zjt.b localb;
    do
    {
      return;
      localb = new zjt.b(paramInt1, paramInt2, null);
    } while (localb.equals(jdField_a_of_type_Zjt$b));
    jdField_a_of_type_Zjt$b = localb;
    QLog.i("MainAssistObserver.LebaTabRedTouch", 4, "doQZoneRedPointExposeReport: " + zjt.b.a(localb) + " " + zjt.b.a(localb));
    if (zjt.b.a(localb) > 0)
    {
      LpReportInfo_pf00064.allReport(637, 22, 1);
      return;
    }
    if (zjt.b.a(localb))
    {
      LpReportInfo_pf00064.allReport(637, 21, 1);
      return;
    }
    LpReportInfo_pf00064.allReport(637, 23, 1);
  }
  
  private int yl()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    aneo localaneo = (aneo)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localaneo != null)
    {
      int j = localaneo.jn(1);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "getQZoneMsgCount TYPE_PASSIVE_FEED: " + localaneo.jn(1));
        i = j;
      }
    }
    return i;
  }
  
  private int ym()
  {
    int i = 0;
    if ((this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity == null) || (this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app == null)) {
      return 0;
    }
    aneo localaneo = (aneo)this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.getManager(10);
    if (localaneo != null)
    {
      int j = localaneo.jn(2);
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.d("UndealCount.MainAssistObserver", 2, "isNewQzoneMsgExist TYPE_ACTIVE_FEED: " + localaneo.jn(2) + " TYPE_ZEBRA_ALBUM:" + localaneo.jn(17));
        i = j;
      }
    }
    QLog.d("UndealCount.MainAssistObserver", 1, "isNewQzoneMsgExist: " + i);
    return i;
  }
  
  public Map<Long, LebaPluginInfo> X()
  {
    Object localObject2 = Collections.emptyMap();
    Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity.app.a().dZ();
    Object localObject1 = localObject2;
    if (localObject3 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject3).isEmpty())
      {
        localObject1 = new HashMap();
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (LebaPluginInfo)((Iterator)localObject2).next();
          if (localObject3 != null) {
            ((Map)localObject1).put(Long.valueOf(((LebaPluginInfo)localObject3).uiResId), localObject3);
          }
        }
      }
    }
    return localObject1;
  }
  
  public Runnable a(zjt.c paramc)
  {
    return new LebaTabRedTouch.1(this, paramc);
  }
  
  public void clear()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivitySplashActivity = null;
  }
  
  public static class a
    implements DrawerFrame.a
  {
    public void AD(int paramInt) {}
    
    public void aC(int paramInt, boolean paramBoolean) {}
    
    public void eZ(int paramInt1, int paramInt2) {}
    
    public void fa(int paramInt1, int paramInt2) {}
    
    public void m(int paramInt, float paramFloat) {}
  }
  
  static class b
  {
    private final boolean brw;
    private final int cdz;
    
    private b(int paramInt1, int paramInt2)
    {
      this.cdz = paramInt1;
      if (paramInt2 > 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.brw = bool;
        return;
      }
    }
    
    public boolean equals(Object paramObject)
    {
      if (this == paramObject) {}
      do
      {
        return true;
        if ((paramObject == null) || (getClass() != paramObject.getClass())) {
          return false;
        }
        paramObject = (b)paramObject;
        if (this.cdz != paramObject.cdz) {
          return false;
        }
      } while (this.brw == paramObject.brw);
      return false;
    }
    
    public int hashCode()
    {
      int j = this.cdz;
      if (this.brw) {}
      for (int i = 1;; i = 0) {
        return i + j * 31;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(BusinessInfoCheckUpdate.RedTypeInfo paramRedTypeInfo);
    
    public abstract void onFinish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zjt
 * JD-Core Version:    0.7.0.1
 */