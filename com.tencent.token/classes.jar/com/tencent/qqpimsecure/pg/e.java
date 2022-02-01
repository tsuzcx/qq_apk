package com.tencent.qqpimsecure.pg;

import Protocol.MGuide.MBundle;
import Protocol.MGuide.MDoraemonRes;
import Protocol.MGuide.MDoraemonZip;
import Protocol.MGuide.MIntent;
import Protocol.MGuide.MSolution;
import Protocol.MMGRAuth.SolutionItem;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqpimsecure.taiji.g;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.locks.ReentrantLock;
import taiji.bg;
import taiji.bj;
import taiji.bn;
import tmsdk.common.module.pgsdk.manager.ITaijiThreadPoolManager;

public class e
{
  private ReentrantLock a = new ReentrantLock();
  private HashSet<String> b = new HashSet();
  private HashSet<String> c = new HashSet();
  
  static MSolution a(Context paramContext, int paramInt)
  {
    if (Build.VERSION.SDK_INT < 8) {
      return null;
    }
    int i = bg.b(paramInt);
    Object localObject1 = g.a(paramContext).a(i);
    if ((localObject1 == null) || (((SolutionItem)localObject1).soluInfo == null)) {}
    for (localObject1 = c.a(paramContext, i); (localObject1 == null) || (((MSolution)localObject1).mJumpIntent == null); localObject1 = (MSolution)bj.a(((SolutionItem)localObject1).soluInfo, new MSolution(), false)) {
      return null;
    }
    Object localObject2 = a(paramContext, (MSolution)localObject1, i);
    if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
      return null;
    }
    int j = ((Integer)((Pair)localObject2).second).intValue();
    if (((MSolution)localObject1).mHelpStyle == 5)
    {
      if ((((MSolution)localObject1).mHelpDoraemonZip == null) || (TextUtils.isEmpty(((MSolution)localObject1).mHelpDoraemonZip.mDoraemonZipUrl)) || (((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList == null) || (((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.isEmpty())) {
        return null;
      }
      localObject2 = b(paramContext, (MSolution)localObject1, i, j);
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        return null;
      }
      paramInt = 0;
      while (paramInt < ((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.size())
      {
        ((MDoraemonRes)((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.get(paramInt)).mFileList.clear();
        ((MDoraemonRes)((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.get(paramInt)).mFileList.addAll((Collection)((ArrayList)localObject2).get(paramInt));
        paramInt += 1;
      }
    }
    if ((((MSolution)localObject1).mHelpImageList != null) && (!((MSolution)localObject1).mHelpImageList.isEmpty()))
    {
      localObject2 = a(paramContext, (MSolution)localObject1, i, j);
      if ((localObject2 == null) || (((ArrayList)localObject2).isEmpty())) {
        return null;
      }
      ((MSolution)localObject1).mHelpImageList = ((ArrayList)localObject2);
    }
    a.a(paramContext, i, 0, j);
    return localObject1;
  }
  
  static Intent a(MSolution paramMSolution)
  {
    if ((paramMSolution == null) || (paramMSolution.mJumpIntent == null)) {
      return null;
    }
    Intent localIntent = new Intent();
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mAction)) {
      localIntent.setAction(paramMSolution.mJumpIntent.mAction);
    }
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mUri)) {
      localIntent.setData(Uri.parse(paramMSolution.mJumpIntent.mUri));
    }
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mType)) {
      localIntent.setType(paramMSolution.mJumpIntent.mType);
    }
    if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mPackage))
    {
      localIntent.setPackage(paramMSolution.mJumpIntent.mPackage);
      if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mClass)) {
        localIntent.setClassName(paramMSolution.mJumpIntent.mPackage, paramMSolution.mJumpIntent.mClass);
      }
    }
    localIntent.setFlags(paramMSolution.mJumpIntent.mFlags);
    Iterator localIterator;
    if (paramMSolution.mJumpIntent.mCategories != null)
    {
      localIterator = paramMSolution.mJumpIntent.mCategories.keySet().iterator();
      while (localIterator.hasNext()) {
        localIntent.addCategory((String)localIterator.next());
      }
    }
    if (paramMSolution.mJumpIntent.mExtras != null) {
      localIterator = paramMSolution.mJumpIntent.mExtras.iterator();
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        MBundle localMBundle = (MBundle)localIterator.next();
        try
        {
          switch (localMBundle.mValueType)
          {
          case 1: 
            localIntent.putExtra(localMBundle.mKey, Integer.parseInt(localMBundle.mValue));
          }
        }
        catch (Throwable localThrowable)
        {
          bn.a("ManualSolutionManager", localThrowable.getMessage());
        }
        continue;
        localIntent.putExtra(localThrowable.mKey, Long.parseLong(localThrowable.mValue));
        continue;
        localIntent.putExtra(localThrowable.mKey, localThrowable.mValue);
        continue;
        localIntent.putExtra(localThrowable.mKey, Boolean.parseBoolean(localThrowable.mValue));
        continue;
        localIntent.putExtra(localThrowable.mKey, Short.parseShort(localThrowable.mValue));
      }
      else
      {
        if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mUidKey)) {
          localIntent.putExtra(paramMSolution.mJumpIntent.mUidKey, Process.myUid());
        }
        return localIntent;
      }
    }
  }
  
  private static Pair<Boolean, Integer> a(Context paramContext, MSolution paramMSolution, int paramInt)
  {
    if (((paramMSolution.mIntentCheck & 0x1) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mAction)))
    {
      bn.d("ManualSolutionManager", "invalid solution, intent action is empty, adapterID:" + paramInt);
      a.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if (((paramMSolution.mIntentCheck & 0x2) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mUri)))
    {
      bn.d("ManualSolutionManager", "invalid solution, intent uri is empty, adapterID:" + paramInt);
      a.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if (((paramMSolution.mIntentCheck & 0x4) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mType)))
    {
      bn.d("ManualSolutionManager", "invalid solution, intent type is empty, adapterID:" + paramInt);
      a.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if ((paramMSolution.mIntentCheck & 0x8) != 0) {
      return b(paramContext, paramMSolution, paramInt);
    }
    return new Pair(Boolean.valueOf(true), Integer.valueOf(0));
  }
  
  private static e a()
  {
    return a.a();
  }
  
  private static ArrayList<String> a(Context paramContext, MSolution paramMSolution, int paramInt1, int paramInt2)
  {
    String str2 = paramContext.getFilesDir() + "/mguide_solution";
    Object localObject1 = new File(str2);
    if (((File)localObject1).exists())
    {
      if ((!((File)localObject1).isDirectory()) && ((!((File)localObject1).delete()) || (!((File)localObject1).mkdir()))) {
        return null;
      }
    }
    else if (!((File)localObject1).mkdir()) {
      return null;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Iterator localIterator = paramMSolution.mHelpImageList.iterator();
    int i = 1;
    String str1;
    if (localIterator.hasNext()) {
      str1 = (String)localIterator.next();
    }
    for (;;)
    {
      String str3;
      File localFile;
      try
      {
        if (!str1.contains("/")) {
          break label407;
        }
        localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          a.a(paramContext, paramInt1, 1, paramInt2);
          return null;
        }
      }
      catch (Throwable localThrowable)
      {
        localObject2 = str1;
        continue;
        str3 = str2 + "/" + localObject2;
        localFile = new File(str3);
        if (localFile == null) {
          break label256;
        }
      }
      if (!localFile.exists())
      {
        label256:
        localArrayList2.add(str3);
        localArrayList3.add(localObject2);
        localArrayList4.add(str1);
        i = 0;
      }
      for (;;)
      {
        break;
        localArrayList1.add(str3);
      }
      if (i == 0)
      {
        if (!paramMSolution.mHelpImageLocal)
        {
          paramInt1 = 0;
          while (paramInt1 < localArrayList4.size())
          {
            a().a(paramContext, (String)localArrayList4.get(paramInt1), (String)localArrayList2.get(paramInt1), str2, true, false);
            paramInt1 += 1;
          }
        }
        paramInt1 = 0;
        while (paramInt1 < localArrayList2.size())
        {
          a().a(paramContext, (String)localArrayList3.get(paramInt1), (String)localArrayList2.get(paramInt1), str2, false);
          paramInt1 += 1;
        }
        return null;
      }
      return localArrayList1;
      label407:
      Object localObject2 = str1;
    }
  }
  
  private void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    paramContext = new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: iconst_0
        //   1: istore_1
        //   2: iconst_0
        //   3: istore_3
        //   4: iconst_0
        //   5: istore_2
        //   6: aconst_null
        //   7: astore 8
        //   9: aload_0
        //   10: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   13: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   16: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   19: aload_0
        //   20: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   23: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   26: aload_0
        //   27: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   30: invokevirtual 58	java/util/HashSet:contains	(Ljava/lang/Object;)Z
        //   33: ifne +908 -> 941
        //   36: new 60	java/io/File
        //   39: dup
        //   40: aload_0
        //   41: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   44: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
        //   47: astore 7
        //   49: aload 7
        //   51: ifnull +17 -> 68
        //   54: aload 7
        //   56: astore 6
        //   58: iload_3
        //   59: istore_1
        //   60: aload 7
        //   62: invokevirtual 67	java/io/File:exists	()Z
        //   65: ifne +55 -> 120
        //   68: iload_3
        //   69: istore_1
        //   70: aload_0
        //   71: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   74: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   77: aload_0
        //   78: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   81: invokevirtual 70	java/util/HashSet:add	(Ljava/lang/Object;)Z
        //   84: pop
        //   85: iconst_1
        //   86: istore_1
        //   87: iconst_1
        //   88: istore_2
        //   89: ldc 72
        //   91: new 74	java/lang/StringBuilder
        //   94: dup
        //   95: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   98: ldc 77
        //   100: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   103: aload_0
        //   104: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   107: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   113: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   116: aload 7
        //   118: astore 6
        //   120: aload_0
        //   121: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   124: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   127: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   130: aload 6
        //   132: astore 7
        //   134: iload_2
        //   135: istore_1
        //   136: iload_1
        //   137: ifeq +254 -> 391
        //   140: ldc 72
        //   142: new 74	java/lang/StringBuilder
        //   145: dup
        //   146: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   149: ldc 95
        //   151: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: aload_0
        //   155: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   158: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   164: invokestatic 97	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   167: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   170: lstore 4
        //   172: new 60	java/io/File
        //   175: dup
        //   176: new 74	java/lang/StringBuilder
        //   179: dup
        //   180: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   183: aload_0
        //   184: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   187: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   190: ldc 105
        //   192: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   195: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   198: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
        //   201: astore 10
        //   203: aload 10
        //   205: invokevirtual 67	java/io/File:exists	()Z
        //   208: ifeq +9 -> 217
        //   211: aload 10
        //   213: invokevirtual 108	java/io/File:delete	()Z
        //   216: pop
        //   217: aload 10
        //   219: invokevirtual 111	java/io/File:createNewFile	()Z
        //   222: pop
        //   223: aload_0
        //   224: getfield 28	com/tencent/qqpimsecure/pg/e$1:b	Landroid/content/Context;
        //   227: invokevirtual 117	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
        //   230: aload_0
        //   231: getfield 30	com/tencent/qqpimsecure/pg/e$1:c	Ljava/lang/String;
        //   234: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   237: astore 6
        //   239: new 125	java/io/FileOutputStream
        //   242: dup
        //   243: aload 10
        //   245: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   248: astore 9
        //   250: sipush 1024
        //   253: newarray byte
        //   255: astore 8
        //   257: aload 6
        //   259: aload 8
        //   261: invokevirtual 134	java/io/InputStream:read	([B)I
        //   264: istore_1
        //   265: iload_1
        //   266: iconst_m1
        //   267: if_icmpeq +261 -> 528
        //   270: aload 9
        //   272: aload 8
        //   274: iconst_0
        //   275: iload_1
        //   276: invokevirtual 140	java/io/OutputStream:write	([BII)V
        //   279: goto -22 -> 257
        //   282: astore 10
        //   284: aload 9
        //   286: astore 8
        //   288: aload 6
        //   290: astore 7
        //   292: aload 10
        //   294: astore 6
        //   296: ldc 72
        //   298: new 74	java/lang/StringBuilder
        //   301: dup
        //   302: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   305: ldc 142
        //   307: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   310: aload_0
        //   311: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   314: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   317: ldc 144
        //   319: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   322: aload 6
        //   324: invokevirtual 147	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   327: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   330: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   333: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   336: aload_0
        //   337: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   340: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   343: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   346: aload_0
        //   347: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   350: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   353: aload_0
        //   354: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   357: invokevirtual 150	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   360: pop
        //   361: aload_0
        //   362: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   365: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   368: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   371: aload 7
        //   373: ifnull +8 -> 381
        //   376: aload 7
        //   378: invokevirtual 153	java/io/InputStream:close	()V
        //   381: aload 8
        //   383: ifnull +8 -> 391
        //   386: aload 8
        //   388: invokevirtual 154	java/io/OutputStream:close	()V
        //   391: aload_0
        //   392: getfield 32	com/tencent/qqpimsecure/pg/e$1:d	Z
        //   395: ifeq +95 -> 490
        //   398: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   401: lstore 4
        //   403: aload_0
        //   404: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   407: aload_0
        //   408: getfield 34	com/tencent/qqpimsecure/pg/e$1:e	Ljava/lang/String;
        //   411: invokestatic 158	taiji/bo:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   414: ldc 72
        //   416: new 74	java/lang/StringBuilder
        //   419: dup
        //   420: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   423: ldc 160
        //   425: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   428: aload_0
        //   429: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   432: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   435: ldc 162
        //   437: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   440: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   443: lload 4
        //   445: lsub
        //   446: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   449: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   452: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   455: aload_0
        //   456: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   459: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   462: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   465: aload_0
        //   466: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   469: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   472: aload_0
        //   473: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   476: invokevirtual 150	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   479: pop
        //   480: aload_0
        //   481: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   484: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   487: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   490: return
        //   491: astore 6
        //   493: aconst_null
        //   494: astore 6
        //   496: aload_0
        //   497: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   500: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   503: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   506: aload 6
        //   508: astore 7
        //   510: goto -374 -> 136
        //   513: astore 6
        //   515: aload_0
        //   516: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   519: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   522: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   525: aload 6
        //   527: athrow
        //   528: aload 9
        //   530: invokevirtual 168	java/io/OutputStream:flush	()V
        //   533: aload 6
        //   535: invokevirtual 153	java/io/InputStream:close	()V
        //   538: aload 9
        //   540: invokevirtual 154	java/io/OutputStream:close	()V
        //   543: aload 10
        //   545: aload 7
        //   547: invokevirtual 172	java/io/File:renameTo	(Ljava/io/File;)Z
        //   550: pop
        //   551: ldc 72
        //   553: new 74	java/lang/StringBuilder
        //   556: dup
        //   557: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   560: ldc 174
        //   562: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   565: aload_0
        //   566: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   569: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   572: ldc 162
        //   574: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   577: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   580: lload 4
        //   582: lsub
        //   583: invokevirtual 165	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   586: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   589: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   592: aload_0
        //   593: getfield 32	com/tencent/qqpimsecure/pg/e$1:d	Z
        //   596: ifne -205 -> 391
        //   599: aload_0
        //   600: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   603: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   606: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   609: aload_0
        //   610: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   613: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   616: aload_0
        //   617: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   620: invokevirtual 150	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   623: pop
        //   624: aload_0
        //   625: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   628: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   631: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   634: goto -243 -> 391
        //   637: astore 7
        //   639: aload_0
        //   640: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   643: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   646: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   649: goto -258 -> 391
        //   652: astore 7
        //   654: aload_0
        //   655: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   658: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   661: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   664: aload 7
        //   666: athrow
        //   667: astore 6
        //   669: aload_0
        //   670: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   673: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   676: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   679: goto -308 -> 371
        //   682: astore 6
        //   684: aload_0
        //   685: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   688: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   691: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   694: aload 6
        //   696: athrow
        //   697: astore 6
        //   699: aload_0
        //   700: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   703: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   706: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   709: return
        //   710: astore 6
        //   712: aload_0
        //   713: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   716: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   719: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   722: aload 6
        //   724: athrow
        //   725: astore 6
        //   727: ldc 72
        //   729: new 74	java/lang/StringBuilder
        //   732: dup
        //   733: invokespecial 75	java/lang/StringBuilder:<init>	()V
        //   736: ldc 176
        //   738: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   741: aload_0
        //   742: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   745: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   748: ldc 144
        //   750: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   753: aload 6
        //   755: invokevirtual 147	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   758: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   761: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   764: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   767: aload_0
        //   768: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   771: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   774: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   777: aload_0
        //   778: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   781: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   784: aload_0
        //   785: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   788: invokevirtual 150	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   791: pop
        //   792: aload_0
        //   793: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   796: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   799: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   802: return
        //   803: astore 6
        //   805: aload_0
        //   806: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   809: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   812: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   815: return
        //   816: astore 6
        //   818: aload_0
        //   819: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   822: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   825: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   828: aload 6
        //   830: athrow
        //   831: astore 6
        //   833: aload_0
        //   834: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   837: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   840: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   843: aload_0
        //   844: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   847: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   850: aload_0
        //   851: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   854: invokevirtual 150	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   857: pop
        //   858: aload_0
        //   859: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   862: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   865: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   868: aload 6
        //   870: athrow
        //   871: astore 7
        //   873: aload_0
        //   874: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   877: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   880: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   883: goto -15 -> 868
        //   886: astore 6
        //   888: aload_0
        //   889: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   892: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   895: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   898: aload 6
        //   900: athrow
        //   901: astore 6
        //   903: goto -522 -> 381
        //   906: astore 6
        //   908: goto -517 -> 391
        //   911: astore 6
        //   913: aconst_null
        //   914: astore 7
        //   916: goto -620 -> 296
        //   919: astore 9
        //   921: aload 6
        //   923: astore 7
        //   925: aload 9
        //   927: astore 6
        //   929: goto -633 -> 296
        //   932: astore 6
        //   934: aload 7
        //   936: astore 6
        //   938: goto -442 -> 496
        //   941: aconst_null
        //   942: astore 6
        //   944: goto -824 -> 120
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	947	0	this	1
        //   1	275	1	i	int
        //   5	130	2	j	int
        //   3	66	3	k	int
        //   170	411	4	l	long
        //   56	267	6	localObject1	Object
        //   491	1	6	localThrowable1	Throwable
        //   494	13	6	localObject2	Object
        //   513	21	6	localObject3	Object
        //   667	1	6	localThrowable2	Throwable
        //   682	13	6	localObject4	Object
        //   697	1	6	localThrowable3	Throwable
        //   710	13	6	localObject5	Object
        //   725	29	6	localThrowable4	Throwable
        //   803	1	6	localThrowable5	Throwable
        //   816	13	6	localObject6	Object
        //   831	38	6	localObject7	Object
        //   886	13	6	localObject8	Object
        //   901	1	6	localThrowable6	Throwable
        //   906	1	6	localThrowable7	Throwable
        //   911	11	6	localThrowable8	Throwable
        //   927	1	6	localObject9	Object
        //   932	1	6	localThrowable9	Throwable
        //   936	7	6	localObject10	Object
        //   47	499	7	localObject11	Object
        //   637	1	7	localThrowable10	Throwable
        //   652	13	7	localObject12	Object
        //   871	1	7	localThrowable11	Throwable
        //   914	21	7	localObject13	Object
        //   7	380	8	localObject14	Object
        //   248	291	9	localFileOutputStream	java.io.FileOutputStream
        //   919	7	9	localThrowable12	Throwable
        //   201	43	10	localFile	File
        //   282	262	10	localThrowable13	Throwable
        // Exception table:
        //   from	to	target	type
        //   250	257	282	java/lang/Throwable
        //   257	265	282	java/lang/Throwable
        //   270	279	282	java/lang/Throwable
        //   528	609	282	java/lang/Throwable
        //   624	634	282	java/lang/Throwable
        //   639	649	282	java/lang/Throwable
        //   654	667	282	java/lang/Throwable
        //   19	49	491	java/lang/Throwable
        //   19	49	513	finally
        //   60	68	513	finally
        //   70	85	513	finally
        //   89	116	513	finally
        //   609	624	637	java/lang/Throwable
        //   609	624	652	finally
        //   346	361	667	java/lang/Throwable
        //   346	361	682	finally
        //   465	480	697	java/lang/Throwable
        //   465	480	710	finally
        //   398	455	725	java/lang/Throwable
        //   777	792	803	java/lang/Throwable
        //   777	792	816	finally
        //   398	455	831	finally
        //   727	767	831	finally
        //   843	858	871	java/lang/Throwable
        //   843	858	886	finally
        //   376	381	901	java/lang/Throwable
        //   386	391	906	java/lang/Throwable
        //   167	217	911	java/lang/Throwable
        //   217	239	911	java/lang/Throwable
        //   239	250	919	java/lang/Throwable
        //   60	68	932	java/lang/Throwable
        //   70	85	932	java/lang/Throwable
        //   89	116	932	java/lang/Throwable
      }
    };
    com.tencent.qqpimsecure.taiji.c.a().d().addTask(paramContext, "Move");
  }
  
  private void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    paramContext = new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: aload_0
        //   4: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   7: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   10: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   13: aload_0
        //   14: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   17: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   20: aload_0
        //   21: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   24: invokevirtual 61	java/util/HashSet:contains	(Ljava/lang/Object;)Z
        //   27: ifne +568 -> 595
        //   30: new 63	java/io/File
        //   33: dup
        //   34: aload_0
        //   35: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   38: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
        //   41: astore_2
        //   42: aload_2
        //   43: ifnull +10 -> 53
        //   46: aload_2
        //   47: invokevirtual 70	java/io/File:exists	()Z
        //   50: ifne +540 -> 590
        //   53: aload_0
        //   54: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   57: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   60: aload_0
        //   61: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   64: invokevirtual 73	java/util/HashSet:add	(Ljava/lang/Object;)Z
        //   67: pop
        //   68: iconst_1
        //   69: istore_1
        //   70: aload_0
        //   71: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   74: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   77: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   80: aload_2
        //   81: astore_3
        //   82: iload_1
        //   83: ifeq +236 -> 319
        //   86: ldc 78
        //   88: new 80	java/lang/StringBuilder
        //   91: dup
        //   92: invokespecial 81	java/lang/StringBuilder:<init>	()V
        //   95: ldc 83
        //   97: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   100: aload_0
        //   101: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   104: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   107: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   110: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   113: new 98	java/net/URL
        //   116: dup
        //   117: aload_0
        //   118: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   121: invokespecial 99	java/net/URL:<init>	(Ljava/lang/String;)V
        //   124: invokevirtual 103	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   127: checkcast 105	java/net/HttpURLConnection
        //   130: astore_2
        //   131: new 63	java/io/File
        //   134: dup
        //   135: new 80	java/lang/StringBuilder
        //   138: dup
        //   139: invokespecial 81	java/lang/StringBuilder:<init>	()V
        //   142: aload_0
        //   143: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   146: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   149: ldc 107
        //   151: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   157: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
        //   160: astore 6
        //   162: aload 6
        //   164: invokevirtual 70	java/io/File:exists	()Z
        //   167: ifeq +9 -> 176
        //   170: aload 6
        //   172: invokevirtual 110	java/io/File:delete	()Z
        //   175: pop
        //   176: aload 6
        //   178: invokevirtual 113	java/io/File:createNewFile	()Z
        //   181: pop
        //   182: aload_2
        //   183: invokevirtual 117	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   186: astore_2
        //   187: new 119	java/io/FileOutputStream
        //   190: dup
        //   191: aload 6
        //   193: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   196: astore 5
        //   198: sipush 4096
        //   201: newarray byte
        //   203: astore 4
        //   205: aload_2
        //   206: aload 4
        //   208: invokevirtual 128	java/io/InputStream:read	([B)I
        //   211: istore_1
        //   212: iload_1
        //   213: iconst_m1
        //   214: if_icmpeq +139 -> 353
        //   217: aload 5
        //   219: aload 4
        //   221: iconst_0
        //   222: iload_1
        //   223: invokevirtual 132	java/io/FileOutputStream:write	([BII)V
        //   226: goto -21 -> 205
        //   229: astore_3
        //   230: aload 5
        //   232: astore_3
        //   233: aload_0
        //   234: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   237: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   240: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   243: aload_0
        //   244: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   247: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   250: aload_0
        //   251: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   254: invokevirtual 135	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   257: pop
        //   258: aload_0
        //   259: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   262: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   265: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   268: aload_2
        //   269: ifnull +7 -> 276
        //   272: aload_2
        //   273: invokevirtual 138	java/io/InputStream:close	()V
        //   276: aload_3
        //   277: ifnull +7 -> 284
        //   280: aload_3
        //   281: invokevirtual 139	java/io/FileOutputStream:close	()V
        //   284: aload_0
        //   285: getfield 35	com/tencent/qqpimsecure/pg/e$2:e	Z
        //   288: ifeq +31 -> 319
        //   291: aload_0
        //   292: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   295: aload_0
        //   296: getfield 37	com/tencent/qqpimsecure/pg/e$2:f	Landroid/content/Context;
        //   299: aload_0
        //   300: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   303: aload_0
        //   304: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   307: aload_0
        //   308: getfield 33	com/tencent/qqpimsecure/pg/e$2:d	Ljava/lang/String;
        //   311: iconst_0
        //   312: aload_0
        //   313: getfield 31	com/tencent/qqpimsecure/pg/e$2:c	Z
        //   316: invokestatic 142	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
        //   319: return
        //   320: astore_2
        //   321: aconst_null
        //   322: astore_2
        //   323: aload_0
        //   324: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   327: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   330: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   333: iconst_0
        //   334: istore_1
        //   335: aload_2
        //   336: astore_3
        //   337: goto -255 -> 82
        //   340: astore_2
        //   341: aload_0
        //   342: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   345: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   348: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   351: aload_2
        //   352: athrow
        //   353: aload 5
        //   355: invokevirtual 145	java/io/FileOutputStream:flush	()V
        //   358: aload_2
        //   359: invokevirtual 138	java/io/InputStream:close	()V
        //   362: aload 5
        //   364: invokevirtual 139	java/io/FileOutputStream:close	()V
        //   367: aload 6
        //   369: aload_3
        //   370: invokevirtual 149	java/io/File:renameTo	(Ljava/io/File;)Z
        //   373: pop
        //   374: ldc 78
        //   376: new 80	java/lang/StringBuilder
        //   379: dup
        //   380: invokespecial 81	java/lang/StringBuilder:<init>	()V
        //   383: ldc 151
        //   385: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   388: aload_0
        //   389: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   392: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   395: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   398: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   401: aload_0
        //   402: getfield 31	com/tencent/qqpimsecure/pg/e$2:c	Z
        //   405: ifeq +68 -> 473
        //   408: ldc 78
        //   410: new 80	java/lang/StringBuilder
        //   413: dup
        //   414: invokespecial 81	java/lang/StringBuilder:<init>	()V
        //   417: ldc 153
        //   419: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   422: aload_0
        //   423: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   426: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   429: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   432: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   435: aload_0
        //   436: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   439: aload_0
        //   440: getfield 33	com/tencent/qqpimsecure/pg/e$2:d	Ljava/lang/String;
        //   443: invokestatic 157	taiji/bo:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   446: ldc 78
        //   448: new 80	java/lang/StringBuilder
        //   451: dup
        //   452: invokespecial 81	java/lang/StringBuilder:<init>	()V
        //   455: ldc 159
        //   457: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   460: aload_0
        //   461: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   464: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   467: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   470: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   473: aload_0
        //   474: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   477: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   480: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   483: aload_0
        //   484: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   487: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   490: aload_0
        //   491: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   494: invokevirtual 135	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   497: pop
        //   498: aload_0
        //   499: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   502: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   505: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   508: return
        //   509: astore_3
        //   510: aload_0
        //   511: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   514: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   517: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   520: return
        //   521: astore_3
        //   522: aload_0
        //   523: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   526: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   529: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   532: aload_3
        //   533: athrow
        //   534: astore 4
        //   536: aload_0
        //   537: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   540: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   543: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   546: goto -278 -> 268
        //   549: astore_2
        //   550: aload_0
        //   551: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   554: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   557: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   560: aload_2
        //   561: athrow
        //   562: astore_2
        //   563: goto -287 -> 276
        //   566: astore_2
        //   567: goto -283 -> 284
        //   570: astore_2
        //   571: aconst_null
        //   572: astore_2
        //   573: aload 4
        //   575: astore_3
        //   576: goto -343 -> 233
        //   579: astore_3
        //   580: aload 4
        //   582: astore_3
        //   583: goto -350 -> 233
        //   586: astore_3
        //   587: goto -264 -> 323
        //   590: iconst_0
        //   591: istore_1
        //   592: goto -522 -> 70
        //   595: iconst_0
        //   596: istore_1
        //   597: aconst_null
        //   598: astore_2
        //   599: goto -529 -> 70
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	602	0	this	2
        //   69	528	1	i	int
        //   41	232	2	localObject1	Object
        //   320	1	2	localThrowable1	Throwable
        //   322	14	2	localObject2	Object
        //   340	19	2	localObject3	Object
        //   549	12	2	localObject4	Object
        //   562	1	2	localThrowable2	Throwable
        //   566	1	2	localThrowable3	Throwable
        //   570	1	2	localThrowable4	Throwable
        //   572	27	2	localObject5	Object
        //   81	1	3	localObject6	Object
        //   229	1	3	localThrowable5	Throwable
        //   232	138	3	localObject7	Object
        //   509	1	3	localThrowable6	Throwable
        //   521	12	3	localObject8	Object
        //   575	1	3	localThrowable7	Throwable
        //   579	1	3	localThrowable8	Throwable
        //   582	1	3	localThrowable9	Throwable
        //   586	1	3	localThrowable10	Throwable
        //   1	219	4	arrayOfByte	byte[]
        //   534	47	4	localThrowable11	Throwable
        //   196	167	5	localFileOutputStream	java.io.FileOutputStream
        //   160	208	6	localFile	File
        // Exception table:
        //   from	to	target	type
        //   198	205	229	java/lang/Throwable
        //   205	212	229	java/lang/Throwable
        //   217	226	229	java/lang/Throwable
        //   353	473	229	java/lang/Throwable
        //   473	483	229	java/lang/Throwable
        //   498	508	229	java/lang/Throwable
        //   510	520	229	java/lang/Throwable
        //   522	534	229	java/lang/Throwable
        //   13	42	320	java/lang/Throwable
        //   13	42	340	finally
        //   46	53	340	finally
        //   53	68	340	finally
        //   483	498	509	java/lang/Throwable
        //   483	498	521	finally
        //   243	258	534	java/lang/Throwable
        //   243	258	549	finally
        //   272	276	562	java/lang/Throwable
        //   280	284	566	java/lang/Throwable
        //   113	176	570	java/lang/Throwable
        //   176	187	570	java/lang/Throwable
        //   187	198	579	java/lang/Throwable
        //   46	53	586	java/lang/Throwable
        //   53	68	586	java/lang/Throwable
      }
    };
    com.tencent.qqpimsecure.taiji.c.a().d().addTask(paramContext, "Download");
  }
  
  private static Pair<Boolean, Integer> b(Context paramContext, MSolution paramMSolution, int paramInt)
  {
    if ((TextUtils.isEmpty(paramMSolution.mJumpIntent.mPackage)) || (TextUtils.isEmpty(paramMSolution.mJumpIntent.mClass)))
    {
      bn.d("ManualSolutionManager", "invalid solution, intent package or class is empty, adapterID:" + paramInt);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    Object localObject2 = new Intent();
    ((Intent)localObject2).setClassName(paramMSolution.mJumpIntent.mPackage, paramMSolution.mJumpIntent.mClass);
    PackageManager localPackageManager = paramContext.getPackageManager();
    for (;;)
    {
      try
      {
        PackageInfo localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramMSolution.mJumpIntent.mPackage, 0);
        if (localPackageInfo == null) {
          break label644;
        }
        i = localPackageInfo.versionCode;
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          localObject2 = localPackageManager.resolveActivity((Intent)localObject2, 0);
          if ((localObject2 == null) || (((ResolveInfo)localObject2).activityInfo == null))
          {
            bn.d("ManualSolutionManager", "invalid solution, intent resolveActivity intentInfo or activityInfo is null, adapterID:" + paramInt);
            a.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
            localThrowable1 = localThrowable1;
            localObject1 = null;
          }
        }
        catch (Throwable localThrowable2)
        {
          Object localObject1;
          Object localObject3 = null;
          continue;
          if ((!paramContext.getPackageName().equals(paramMSolution.mJumpIntent.mPackage)) && (!localObject3.activityInfo.exported))
          {
            bn.d("ManualSolutionManager", "invalid solution, intent activityInfo package is not exported, adapterID:" + paramInt);
            a.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          if ((!TextUtils.isEmpty(localObject3.activityInfo.permission)) && (localPackageManager.checkPermission(localObject3.activityInfo.permission, paramContext.getPackageName()) == -1))
          {
            bn.d("ManualSolutionManager", "invalid solution, intent activityInfo permission is denied, adapterID:" + paramInt);
            a.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          int j = localPackageManager.getApplicationEnabledSetting(paramMSolution.mJumpIntent.mPackage);
          if ((j == 2) || (j == 3) || (j == 4))
          {
            bn.d("ManualSolutionManager", "invalid solution, intent package state is disabled, adapterID:" + paramInt);
            a.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          if ((paramMSolution.mHelpInfoAdapter != null) && (!paramMSolution.mHelpInfoAdapter.isEmpty()))
          {
            if (localObject1 == null)
            {
              bn.d("ManualSolutionManager", "invalid solution, intent pkgInfo is null, adapterID:" + paramInt);
              a.a(paramContext, paramInt, 1, i);
              return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
            }
            if (!paramMSolution.mHelpInfoAdapter.containsKey(Integer.valueOf(i))) {
              break label595;
            }
            paramContext = (String)paramMSolution.mHelpInfoAdapter.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(paramContext)) {
              paramMSolution.mHelpInfo = paramContext;
            }
          }
          return new Pair(Boolean.valueOf(true), Integer.valueOf(i));
        }
      }
      label595:
      bn.d("ManualSolutionManager", "invalid solution, intent pkgVerCode is wrong, adapterID:" + paramInt);
      a.a(paramContext, paramInt, 1, i);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
      label644:
      int i = 0;
    }
  }
  
  private static ArrayList<ArrayList<String>> b(Context paramContext, MSolution paramMSolution, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = new ArrayList();
    String str2 = paramContext.getFilesDir() + "/mguide_solution";
    Object localObject1 = new File(str2);
    if (((File)localObject1).exists())
    {
      if ((!((File)localObject1).isDirectory()) && ((!((File)localObject1).delete()) || (!((File)localObject1).mkdir()))) {
        return null;
      }
    }
    else if (!((File)localObject1).mkdir()) {
      return null;
    }
    String str1 = paramMSolution.mHelpDoraemonZip.mDoraemonZipUrl;
    try
    {
      if (str1.contains("/"))
      {
        localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          a.a(paramContext, paramInt1, 1, paramInt2);
          return null;
        }
      }
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        Object localObject2 = str1;
        continue;
        if (localObject2.contains(".")) {}
        for (Object localObject3 = localObject2.substring(0, localObject2.lastIndexOf("."));; localObject3 = localObject2)
        {
          String str3 = str2 + "/" + localObject2;
          int j = paramMSolution.mHelpDoraemonZip.mDoraemonResList.size();
          int i = 0;
          Object localObject4;
          ArrayList localArrayList2;
          label319:
          Object localObject6;
          if (i < j)
          {
            localObject4 = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i)).mFileList;
            int k = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i)).mDoraemonType;
            if (((k == 1) || (k == 2)) && ((localObject4 == null) || (((ArrayList)localObject4).isEmpty())))
            {
              a.a(paramContext, paramInt1, 1, paramInt2);
              return null;
            }
            localArrayList2 = new ArrayList();
            Iterator localIterator = ((ArrayList)localObject4).iterator();
            if (localIterator.hasNext())
            {
              localObject6 = (String)localIterator.next();
              localObject4 = localObject6;
            }
          }
          for (;;)
          {
            try
            {
              if (((String)localObject6).contains("/")) {
                localObject4 = ((String)localObject6).substring(((String)localObject6).lastIndexOf("/") + 1);
              }
              if (TextUtils.isEmpty((CharSequence)localObject4))
              {
                a.a(paramContext, paramInt1, 1, paramInt2);
                return null;
              }
              localObject4 = str2 + "/" + (String)localObject3 + "/" + (String)localObject4;
              localObject6 = new File((String)localObject4);
              if ((localObject6 == null) || (!((File)localObject6).exists()))
              {
                paramInt1 = 0;
                if (paramInt1 != 0) {
                  continue;
                }
                if (!paramMSolution.mHelpImageLocal)
                {
                  a().a(paramContext, str1, str3, str2, true, true);
                  return null;
                }
              }
              else
              {
                localArrayList2.add(localObject4);
                break label319;
                localArrayList1.add(localArrayList2);
                i += 1;
                break;
              }
              a().a(paramContext, localObject2, str3, str2, true);
              continue;
              return localArrayList1;
            }
            catch (Throwable localThrowable2)
            {
              Object localObject5 = localObject6;
              continue;
            }
            paramInt1 = 1;
          }
        }
        localObject2 = str1;
      }
    }
  }
  
  private static class a
  {
    private static e a = new e(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.qqpimsecure.pg.e
 * JD-Core Version:    0.7.0.1
 */