package com.tencent.qapmsdk.common.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.util.SparseArray;
import com.tencent.qapmsdk.common.logger.Logger;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AppInfo;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class AppInfo
{
  public static final Companion Companion = new Companion(null);
  private static final String TAG = "QAPM_common_AppInfo";
  @NotNull
  private static final Lazy pid$delegate = LazyKt.lazy((Function0)AppInfo.Companion.pid.2.INSTANCE);
  private static final SparseArray<String> processMap = new SparseArray();
  
  @JvmStatic
  public static final long getPssMemory(@Nullable Application paramApplication, int paramInt)
  {
    return Companion.getPssMemory(paramApplication, paramInt);
  }
  
  @JvmStatic
  public static final boolean hasPermissions(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
  {
    return Companion.hasPermissions(paramContext, paramArrayOfString);
  }
  
  @JvmStatic
  @NotNull
  public static final String obtainProcessName(@Nullable Context paramContext)
  {
    return Companion.obtainProcessName(paramContext);
  }
  
  @JvmStatic
  @NotNull
  public static final String obtainProcessPackageName(@Nullable Context paramContext)
  {
    return Companion.obtainProcessPackageName(paramContext);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/util/AppInfo$Companion;", "", "()V", "TAG", "", "pid", "", "getPid", "()I", "pid$delegate", "Lkotlin/Lazy;", "processMap", "Landroid/util/SparseArray;", "getPssMemory", "", "app", "Landroid/app/Application;", "pId", "hasPermissions", "", "ctx", "Landroid/content/Context;", "permissionList", "", "(Landroid/content/Context;[Ljava/lang/String;)Z", "obtainProcessName", "obtainProcessNameByCmdline", "obtainProcessNameBySysService", "obtainProcessPackageName", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final String obtainProcessNameByCmdline(int paramInt)
    {
      Object localObject = FileUtil.Companion.readOutputFromFile("/proc/" + paramInt + "/cmdline");
      if (((CharSequence)StringUtil.Companion.replaceBlank((String)localObject)).length() == 0) {}
      for (int i = 1; i != 0; i = 0) {
        return null;
      }
      localObject = StringUtil.Companion.replaceBlank((String)localObject).subSequence(0, StringsKt.getLastIndex((CharSequence)localObject));
      Appendable localAppendable = (Appendable)new StringBuilder();
      int k = ((CharSequence)localObject).length();
      i = 0;
      if (i < k)
      {
        char c = ((CharSequence)localObject).charAt(i);
        if (c > 0) {}
        for (int j = 1;; j = 0)
        {
          if (j != 0) {
            localAppendable.append(c);
          }
          i += 1;
          break;
        }
      }
      localObject = (CharSequence)localAppendable;
      AppInfo.access$getProcessMap$cp().put(paramInt, localObject.toString());
      return localObject.toString();
    }
    
    private final String obtainProcessNameBySysService(int paramInt, Context paramContext)
    {
      Object localObject2 = null;
      if (paramContext != null)
      {
        String str = (String)null;
        Object localObject1 = paramContext.getSystemService("activity");
        paramContext = (Context)localObject1;
        if (!(localObject1 instanceof ActivityManager)) {
          paramContext = null;
        }
        paramContext = (ActivityManager)paramContext;
        if (paramContext != null)
        {
          localObject1 = paramContext.getRunningAppProcesses();
          paramContext = str;
          if (localObject1 != null) {
            localObject1 = ((Iterable)localObject1).iterator();
          }
        }
        label143:
        label146:
        for (;;)
        {
          paramContext = localObject2;
          if (((Iterator)localObject1).hasNext())
          {
            paramContext = ((Iterator)localObject1).next();
            if (((ActivityManager.RunningAppProcessInfo)paramContext).pid != paramInt) {
              break label143;
            }
          }
          for (int i = 1;; i = 0)
          {
            if (i == 0) {
              break label146;
            }
            localObject1 = (ActivityManager.RunningAppProcessInfo)paramContext;
            paramContext = str;
            if (localObject1 != null)
            {
              paramContext = ((ActivityManager.RunningAppProcessInfo)localObject1).processName;
              AppInfo.access$getProcessMap$cp().put(paramInt, paramContext);
            }
            return paramContext;
            localObject1 = null;
            break;
          }
        }
      }
      return null;
    }
    
    public final int getPid()
    {
      Lazy localLazy = AppInfo.access$getPid$cp();
      Object localObject = AppInfo.Companion;
      localObject = $$delegatedProperties[0];
      return ((Number)localLazy.getValue()).intValue();
    }
    
    @JvmStatic
    public final long getPssMemory(@Nullable Application paramApplication, int paramInt)
    {
      Object localObject = null;
      if (paramApplication != null) {}
      try
      {
        paramApplication = paramApplication.getApplicationContext();
        if (paramApplication == null) {
          break label93;
        }
        paramApplication = paramApplication.getSystemService("activity");
        if ((paramApplication instanceof ActivityManager)) {
          break label126;
        }
        paramApplication = localObject;
      }
      catch (Exception paramApplication)
      {
        for (;;)
        {
          label93:
          label108:
          Logger.INSTANCE.exception("QAPM_common_AppInfo", (Throwable)paramApplication);
          continue;
          continue;
          if (paramInt == 0) {
            paramInt = 1;
          }
        }
      }
      paramApplication = (ActivityManager)paramApplication;
      if (paramApplication != null)
      {
        paramApplication = paramApplication.getProcessMemoryInfo(new int[] { paramInt });
        if (paramApplication != null)
        {
          if (paramApplication.length == 0)
          {
            paramInt = 1;
            break label129;
          }
          for (;;)
          {
            if (paramInt == 0) {
              break label108;
            }
            paramApplication = paramApplication[0];
            Intrinsics.checkExpressionValueIsNotNull(paramApplication, "myMemoryInfo[0]");
            paramInt = paramApplication.getTotalPss();
            return paramInt * 1024;
            paramApplication = null;
            break;
            paramInt = 0;
            break label129;
            paramInt = 0;
          }
        }
      }
      return 0L;
    }
    
    /* Error */
    @JvmStatic
    public final boolean hasPermissions(@Nullable Context paramContext, @NotNull String[] paramArrayOfString)
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore 8
      //   3: iconst_0
      //   4: istore 6
      //   6: iconst_0
      //   7: istore 7
      //   9: aload_2
      //   10: ldc 253
      //   12: invokestatic 256	kotlin/jvm/internal/Intrinsics:checkParameterIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   15: aload_1
      //   16: ifnull +91 -> 107
      //   19: aload_1
      //   20: invokevirtual 257	android/content/Context:getApplicationContext	()Landroid/content/Context;
      //   23: astore 9
      //   25: aload 9
      //   27: ldc_w 259
      //   30: invokestatic 230	kotlin/jvm/internal/Intrinsics:checkExpressionValueIsNotNull	(Ljava/lang/Object;Ljava/lang/String;)V
      //   33: aload 9
      //   35: invokevirtual 263	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   38: astore_1
      //   39: iload 8
      //   41: istore 6
      //   43: aload_1
      //   44: ifnull +63 -> 107
      //   47: aload 9
      //   49: invokevirtual 266	android/content/Context:getPackageName	()Ljava/lang/String;
      //   52: astore 9
      //   54: ldc 6
      //   56: monitorenter
      //   57: aload_2
      //   58: arraylength
      //   59: istore 5
      //   61: iconst_0
      //   62: istore 4
      //   64: iload 4
      //   66: iload 5
      //   68: if_icmpge +73 -> 141
      //   71: aload_2
      //   72: iload 4
      //   74: aaload
      //   75: astore 10
      //   77: aload_1
      //   78: aload 10
      //   80: aload 9
      //   82: invokevirtual 272	android/content/pm/PackageManager:checkPermission	(Ljava/lang/String;Ljava/lang/String;)I
      //   85: istore_3
      //   86: iload_3
      //   87: ifne +23 -> 110
      //   90: iconst_1
      //   91: istore_3
      //   92: iload_3
      //   93: ifne +39 -> 132
      //   96: iload 7
      //   98: istore 6
      //   100: getstatic 277	kotlin/Unit:INSTANCE	Lkotlin/Unit;
      //   103: astore_1
      //   104: ldc 6
      //   106: monitorexit
      //   107: iload 6
      //   109: ireturn
      //   110: iconst_0
      //   111: istore_3
      //   112: goto -20 -> 92
      //   115: astore 10
      //   117: getstatic 241	com/tencent/qapmsdk/common/logger/Logger:INSTANCE	Lcom/tencent/qapmsdk/common/logger/Logger;
      //   120: ldc 243
      //   122: aload 10
      //   124: invokevirtual 249	com/tencent/qapmsdk/common/logger/Logger:exception	(Ljava/lang/String;Ljava/lang/Throwable;)V
      //   127: iconst_0
      //   128: istore_3
      //   129: goto -37 -> 92
      //   132: iload 4
      //   134: iconst_1
      //   135: iadd
      //   136: istore 4
      //   138: goto -74 -> 64
      //   141: iconst_1
      //   142: istore 6
      //   144: goto -44 -> 100
      //   147: astore_1
      //   148: ldc 6
      //   150: monitorexit
      //   151: aload_1
      //   152: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	153	0	this	Companion
      //   0	153	1	paramContext	Context
      //   0	153	2	paramArrayOfString	String[]
      //   85	44	3	i	int
      //   62	75	4	j	int
      //   59	10	5	k	int
      //   4	139	6	bool1	boolean
      //   7	90	7	bool2	boolean
      //   1	39	8	bool3	boolean
      //   23	58	9	localObject	Object
      //   75	4	10	str	String
      //   115	8	10	localThrowable	Throwable
      // Exception table:
      //   from	to	target	type
      //   77	86	115	java/lang/Throwable
      //   57	61	147	finally
      //   77	86	147	finally
      //   100	104	147	finally
      //   117	127	147	finally
    }
    
    @JvmStatic
    @NotNull
    public final String obtainProcessName(@Nullable Context paramContext)
    {
      String str = (String)AppInfo.access$getProcessMap$cp().get(((Companion)this).getPid());
      if (str != null) {
        if (str == null) {
          break label49;
        }
      }
      for (;;)
      {
        if (str == null) {
          break label68;
        }
        return str;
        str = ((Companion)this).obtainProcessNameByCmdline(((Companion)this).getPid());
        break;
        label49:
        str = ((Companion)this).obtainProcessNameBySysService(((Companion)this).getPid(), paramContext);
      }
      label68:
      return "";
    }
    
    @JvmStatic
    @NotNull
    public final String obtainProcessPackageName(@Nullable Context paramContext)
    {
      return (String)StringsKt.split$default((CharSequence)StringsKt.split$default((CharSequence)((Companion)this).obtainProcessName(paramContext), new String[] { "&" }, false, 0, 6, null).get(0), new String[] { ":" }, false, 0, 6, null).get(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.AppInfo
 * JD-Core Version:    0.7.0.1
 */