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
    if ((localObject1 != null) && (((SolutionItem)localObject1).soluInfo != null)) {
      localObject1 = (MSolution)bj.a(((SolutionItem)localObject1).soluInfo, new MSolution(), false);
    } else {
      localObject1 = c.a(paramContext, i);
    }
    if (localObject1 != null)
    {
      if (((MSolution)localObject1).mJumpIntent == null) {
        return null;
      }
      Object localObject2 = a(paramContext, (MSolution)localObject1, i);
      if (!((Boolean)((Pair)localObject2).first).booleanValue()) {
        return null;
      }
      int j = ((Integer)((Pair)localObject2).second).intValue();
      if (((MSolution)localObject1).mHelpStyle == 5)
      {
        if ((((MSolution)localObject1).mHelpDoraemonZip != null) && (!TextUtils.isEmpty(((MSolution)localObject1).mHelpDoraemonZip.mDoraemonZipUrl)) && (((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList != null))
        {
          if (((MSolution)localObject1).mHelpDoraemonZip.mDoraemonResList.isEmpty()) {
            return null;
          }
          localObject2 = b(paramContext, (MSolution)localObject1, i, j);
          if (localObject2 != null)
          {
            if (((ArrayList)localObject2).isEmpty()) {
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
        }
        return null;
      }
      if ((((MSolution)localObject1).mHelpImageList != null) && (!((MSolution)localObject1).mHelpImageList.isEmpty()))
      {
        localObject2 = a(paramContext, (MSolution)localObject1, i, j);
        if (localObject2 != null)
        {
          if (((ArrayList)localObject2).isEmpty()) {
            return null;
          }
          ((MSolution)localObject1).mHelpImageList = ((ArrayList)localObject2);
        }
        else
        {
          return null;
        }
      }
      a.a(paramContext, i, 0, j);
      return localObject1;
    }
    return null;
  }
  
  static Intent a(MSolution paramMSolution)
  {
    Intent localIntent;
    Iterator localIterator;
    if ((paramMSolution != null) && (paramMSolution.mJumpIntent != null))
    {
      localIntent = new Intent();
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
          case 6: 
            localIntent.putExtra(localMBundle.mKey, Short.parseShort(localMBundle.mValue));
          }
        }
        catch (Throwable localThrowable)
        {
          bn.a("ManualSolutionManager", localThrowable.getMessage());
        }
        localIntent.putExtra(localMBundle.mKey, Boolean.parseBoolean(localMBundle.mValue));
        continue;
        localIntent.putExtra(localMBundle.mKey, localMBundle.mValue);
        continue;
        localIntent.putExtra(localMBundle.mKey, Long.parseLong(localMBundle.mValue));
        continue;
        localIntent.putExtra(localMBundle.mKey, Integer.parseInt(localMBundle.mValue));
      }
      else
      {
        if (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mUidKey)) {
          localIntent.putExtra(paramMSolution.mJumpIntent.mUidKey, Process.myUid());
        }
        return localIntent;
        return null;
      }
    }
  }
  
  private static Pair<Boolean, Integer> a(Context paramContext, MSolution paramMSolution, int paramInt)
  {
    if (((paramMSolution.mIntentCheck & 0x1) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mAction)))
    {
      paramMSolution = new StringBuilder();
      paramMSolution.append("invalid solution, intent action is empty, adapterID:");
      paramMSolution.append(paramInt);
      bn.d("ManualSolutionManager", paramMSolution.toString());
      a.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if (((paramMSolution.mIntentCheck & 0x2) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mUri)))
    {
      paramMSolution = new StringBuilder();
      paramMSolution.append("invalid solution, intent uri is empty, adapterID:");
      paramMSolution.append(paramInt);
      bn.d("ManualSolutionManager", paramMSolution.toString());
      a.a(paramContext, paramInt, 1, 0);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
    }
    if (((paramMSolution.mIntentCheck & 0x4) != 0) && (TextUtils.isEmpty(paramMSolution.mJumpIntent.mType)))
    {
      paramMSolution = new StringBuilder();
      paramMSolution.append("invalid solution, intent type is empty, adapterID:");
      paramMSolution.append(paramInt);
      bn.d("ManualSolutionManager", paramMSolution.toString());
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getFilesDir());
    ((StringBuilder)localObject1).append("/mguide_solution");
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str2);
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
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      try
      {
        if (str1.contains("/")) {
          localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
        }
      }
      catch (Throwable localThrowable)
      {
        label191:
        Object localObject2;
        break label191;
      }
      localObject1 = str1;
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        a.a(paramContext, paramInt1, 1, paramInt2);
        return null;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(str2);
      ((StringBuilder)localObject2).append("/");
      ((StringBuilder)localObject2).append((String)localObject1);
      localObject2 = ((StringBuilder)localObject2).toString();
      if (!new File((String)localObject2).exists())
      {
        localArrayList2.add(localObject2);
        localArrayList3.add(localObject1);
        localArrayList4.add(str1);
        i = 0;
      }
      else
      {
        localArrayList1.add(localObject2);
      }
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
  }
  
  private void a(final Context paramContext, final String paramString1, final String paramString2, final String paramString3, final boolean paramBoolean)
  {
    paramContext = new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   4: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   14: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   17: aload_0
        //   18: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   21: invokevirtual 58	java/util/HashSet:contains	(Ljava/lang/Object;)Z
        //   24: ifne +89 -> 113
        //   27: new 60	java/io/File
        //   30: dup
        //   31: aload_0
        //   32: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   35: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
        //   38: astore 5
        //   40: aload 5
        //   42: astore 4
        //   44: aload 5
        //   46: invokevirtual 67	java/io/File:exists	()Z
        //   49: ifne +88 -> 137
        //   52: aload_0
        //   53: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   56: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   59: aload_0
        //   60: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   63: invokevirtual 70	java/util/HashSet:add	(Ljava/lang/Object;)Z
        //   66: pop
        //   67: iconst_1
        //   68: istore_1
        //   69: new 72	java/lang/StringBuilder
        //   72: dup
        //   73: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   76: astore 4
        //   78: aload 4
        //   80: ldc 75
        //   82: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   85: pop
        //   86: aload 4
        //   88: aload_0
        //   89: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   92: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   95: pop
        //   96: ldc 81
        //   98: aload 4
        //   100: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   103: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   106: aload 5
        //   108: astore 4
        //   110: goto +29 -> 139
        //   113: aconst_null
        //   114: astore 4
        //   116: goto +21 -> 137
        //   119: astore 4
        //   121: aload_0
        //   122: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   125: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   128: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   131: aload 4
        //   133: athrow
        //   134: aconst_null
        //   135: astore 4
        //   137: iconst_0
        //   138: istore_1
        //   139: aload_0
        //   140: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   143: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   146: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   149: iload_1
        //   150: ifeq +480 -> 630
        //   153: new 72	java/lang/StringBuilder
        //   156: dup
        //   157: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   160: astore 5
        //   162: aload 5
        //   164: ldc 95
        //   166: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   169: pop
        //   170: aload 5
        //   172: aload_0
        //   173: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   176: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   179: pop
        //   180: ldc 81
        //   182: aload 5
        //   184: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   187: invokestatic 97	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   190: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   193: lstore_2
        //   194: new 72	java/lang/StringBuilder
        //   197: dup
        //   198: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   201: astore 5
        //   203: aload 5
        //   205: aload_0
        //   206: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   209: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   212: pop
        //   213: aload 5
        //   215: ldc 105
        //   217: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   220: pop
        //   221: new 60	java/io/File
        //   224: dup
        //   225: aload 5
        //   227: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   230: invokespecial 63	java/io/File:<init>	(Ljava/lang/String;)V
        //   233: astore 5
        //   235: aload 5
        //   237: invokevirtual 67	java/io/File:exists	()Z
        //   240: ifeq +9 -> 249
        //   243: aload 5
        //   245: invokevirtual 108	java/io/File:delete	()Z
        //   248: pop
        //   249: aload 5
        //   251: invokevirtual 111	java/io/File:createNewFile	()Z
        //   254: pop
        //   255: aload_0
        //   256: getfield 28	com/tencent/qqpimsecure/pg/e$1:b	Landroid/content/Context;
        //   259: invokevirtual 117	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
        //   262: aload_0
        //   263: getfield 30	com/tencent/qqpimsecure/pg/e$1:c	Ljava/lang/String;
        //   266: invokevirtual 123	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
        //   269: astore 6
        //   271: new 125	java/io/FileOutputStream
        //   274: dup
        //   275: aload 5
        //   277: invokespecial 128	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   280: astore 7
        //   282: sipush 1024
        //   285: newarray byte
        //   287: astore 8
        //   289: aload 6
        //   291: aload 8
        //   293: invokevirtual 134	java/io/InputStream:read	([B)I
        //   296: istore_1
        //   297: iload_1
        //   298: iconst_m1
        //   299: if_icmpeq +15 -> 314
        //   302: aload 7
        //   304: aload 8
        //   306: iconst_0
        //   307: iload_1
        //   308: invokevirtual 140	java/io/OutputStream:write	([BII)V
        //   311: goto -22 -> 289
        //   314: aload 7
        //   316: invokevirtual 143	java/io/OutputStream:flush	()V
        //   319: aload 6
        //   321: invokevirtual 146	java/io/InputStream:close	()V
        //   324: aload 7
        //   326: invokevirtual 147	java/io/OutputStream:close	()V
        //   329: aload 5
        //   331: aload 4
        //   333: invokevirtual 151	java/io/File:renameTo	(Ljava/io/File;)Z
        //   336: pop
        //   337: new 72	java/lang/StringBuilder
        //   340: dup
        //   341: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   344: astore 4
        //   346: aload 4
        //   348: ldc 153
        //   350: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   353: pop
        //   354: aload 4
        //   356: aload_0
        //   357: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   360: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   363: pop
        //   364: aload 4
        //   366: ldc 155
        //   368: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   371: pop
        //   372: aload 4
        //   374: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   377: lload_2
        //   378: lsub
        //   379: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   382: pop
        //   383: ldc 81
        //   385: aload 4
        //   387: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   390: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   393: aload_0
        //   394: getfield 32	com/tencent/qqpimsecure/pg/e$1:d	Z
        //   397: ifne +233 -> 630
        //   400: aload_0
        //   401: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   404: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   407: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   410: aload_0
        //   411: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   414: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   417: aload_0
        //   418: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   421: invokevirtual 161	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   424: pop
        //   425: aload_0
        //   426: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   429: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   432: astore 4
        //   434: aload 4
        //   436: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   439: goto +191 -> 630
        //   442: astore 4
        //   444: aload_0
        //   445: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   448: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   451: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   454: aload 4
        //   456: athrow
        //   457: aload_0
        //   458: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   461: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   464: astore 4
        //   466: goto -32 -> 434
        //   469: astore 5
        //   471: aload 7
        //   473: astore 4
        //   475: goto +20 -> 495
        //   478: astore 5
        //   480: aconst_null
        //   481: astore 4
        //   483: goto +12 -> 495
        //   486: astore 5
        //   488: aconst_null
        //   489: astore 6
        //   491: aload 6
        //   493: astore 4
        //   495: new 72	java/lang/StringBuilder
        //   498: dup
        //   499: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   502: astore 7
        //   504: aload 7
        //   506: ldc 163
        //   508: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   511: pop
        //   512: aload 7
        //   514: aload_0
        //   515: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   518: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   521: pop
        //   522: aload 7
        //   524: ldc 165
        //   526: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   529: pop
        //   530: aload 7
        //   532: aload 5
        //   534: invokevirtual 168	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   537: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   540: pop
        //   541: ldc 81
        //   543: aload 7
        //   545: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   548: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   551: aload_0
        //   552: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   555: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   558: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   561: aload_0
        //   562: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   565: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   568: aload_0
        //   569: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   572: invokevirtual 161	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   575: pop
        //   576: goto +18 -> 594
        //   579: astore 4
        //   581: aload_0
        //   582: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   585: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   588: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   591: aload 4
        //   593: athrow
        //   594: aload_0
        //   595: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   598: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   601: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   604: aload 6
        //   606: ifnull +11 -> 617
        //   609: aload 6
        //   611: invokevirtual 146	java/io/InputStream:close	()V
        //   614: goto +3 -> 617
        //   617: aload 4
        //   619: ifnull +11 -> 630
        //   622: aload 4
        //   624: invokevirtual 147	java/io/OutputStream:close	()V
        //   627: goto +3 -> 630
        //   630: aload_0
        //   631: getfield 32	com/tencent/qqpimsecure/pg/e$1:d	Z
        //   634: ifeq +290 -> 924
        //   637: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   640: lstore_2
        //   641: aload_0
        //   642: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   645: aload_0
        //   646: getfield 34	com/tencent/qqpimsecure/pg/e$1:e	Ljava/lang/String;
        //   649: invokestatic 172	taiji/bo:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   652: new 72	java/lang/StringBuilder
        //   655: dup
        //   656: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   659: astore 4
        //   661: aload 4
        //   663: ldc 174
        //   665: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   668: pop
        //   669: aload 4
        //   671: aload_0
        //   672: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   675: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   678: pop
        //   679: aload 4
        //   681: ldc 155
        //   683: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   686: pop
        //   687: aload 4
        //   689: invokestatic 103	java/lang/System:currentTimeMillis	()J
        //   692: lload_2
        //   693: lsub
        //   694: invokevirtual 158	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
        //   697: pop
        //   698: ldc 81
        //   700: aload 4
        //   702: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   705: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   708: aload_0
        //   709: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   712: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   715: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   718: aload_0
        //   719: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   722: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   725: aload_0
        //   726: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   729: invokevirtual 161	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   732: pop
        //   733: goto +18 -> 751
        //   736: astore 4
        //   738: aload_0
        //   739: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   742: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   745: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   748: aload 4
        //   750: athrow
        //   751: aload_0
        //   752: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   755: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   758: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   761: return
        //   762: astore 4
        //   764: goto +104 -> 868
        //   767: astore 4
        //   769: new 72	java/lang/StringBuilder
        //   772: dup
        //   773: invokespecial 73	java/lang/StringBuilder:<init>	()V
        //   776: astore 5
        //   778: aload 5
        //   780: ldc 176
        //   782: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   785: pop
        //   786: aload 5
        //   788: aload_0
        //   789: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   792: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   795: pop
        //   796: aload 5
        //   798: ldc 165
        //   800: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   803: pop
        //   804: aload 5
        //   806: aload 4
        //   808: invokevirtual 168	java/lang/Throwable:getMessage	()Ljava/lang/String;
        //   811: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   814: pop
        //   815: ldc 81
        //   817: aload 5
        //   819: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   822: invokestatic 90	taiji/bn:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   825: aload_0
        //   826: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   829: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   832: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   835: aload_0
        //   836: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   839: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   842: aload_0
        //   843: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   846: invokevirtual 161	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   849: pop
        //   850: goto -99 -> 751
        //   853: astore 4
        //   855: aload_0
        //   856: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   859: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   862: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   865: aload 4
        //   867: athrow
        //   868: aload_0
        //   869: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   872: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   875: invokevirtual 49	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   878: aload_0
        //   879: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   882: invokestatic 52	com/tencent/qqpimsecure/pg/e:b	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   885: aload_0
        //   886: getfield 26	com/tencent/qqpimsecure/pg/e$1:a	Ljava/lang/String;
        //   889: invokevirtual 161	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   892: pop
        //   893: goto +18 -> 911
        //   896: astore 4
        //   898: aload_0
        //   899: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   902: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   905: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   908: aload 4
        //   910: athrow
        //   911: aload_0
        //   912: getfield 24	com/tencent/qqpimsecure/pg/e$1:f	Lcom/tencent/qqpimsecure/pg/e;
        //   915: invokestatic 44	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   918: invokevirtual 93	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   921: aload 4
        //   923: athrow
        //   924: return
        //   925: astore 4
        //   927: goto -793 -> 134
        //   930: astore 4
        //   932: aload 5
        //   934: astore 4
        //   936: goto -799 -> 137
        //   939: astore 4
        //   941: aload 5
        //   943: astore 4
        //   945: goto -806 -> 139
        //   948: astore 4
        //   950: goto -493 -> 457
        //   953: astore 5
        //   955: goto -361 -> 594
        //   958: astore 5
        //   960: goto -343 -> 617
        //   963: astore 4
        //   965: goto -335 -> 630
        //   968: astore 4
        //   970: goto -219 -> 751
        //   973: astore 5
        //   975: goto -64 -> 911
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	978	0	this	1
        //   68	240	1	i	int
        //   193	500	2	l	long
        //   42	73	4	localObject1	Object
        //   119	13	4	localObject2	Object
        //   135	300	4	localObject3	Object
        //   442	13	4	localObject4	Object
        //   464	30	4	localObject5	Object
        //   579	44	4	localObject6	Object
        //   659	42	4	localStringBuilder1	StringBuilder
        //   736	13	4	localObject7	Object
        //   762	1	4	localObject8	Object
        //   767	40	4	localThrowable1	Throwable
        //   853	13	4	localObject9	Object
        //   896	26	4	localObject10	Object
        //   925	1	4	localThrowable2	Throwable
        //   930	1	4	localThrowable3	Throwable
        //   934	1	4	localStringBuilder2	StringBuilder
        //   939	1	4	localThrowable4	Throwable
        //   943	1	4	localStringBuilder3	StringBuilder
        //   948	1	4	localThrowable5	Throwable
        //   963	1	4	localThrowable6	Throwable
        //   968	1	4	localThrowable7	Throwable
        //   38	292	5	localObject11	Object
        //   469	1	5	localThrowable8	Throwable
        //   478	1	5	localThrowable9	Throwable
        //   486	47	5	localThrowable10	Throwable
        //   776	166	5	localStringBuilder4	StringBuilder
        //   953	1	5	localThrowable11	Throwable
        //   958	1	5	localThrowable12	Throwable
        //   973	1	5	localThrowable13	Throwable
        //   269	341	6	localInputStream	java.io.InputStream
        //   280	264	7	localObject12	Object
        //   287	18	8	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   10	40	119	finally
        //   44	67	119	finally
        //   69	106	119	finally
        //   410	425	442	finally
        //   282	289	469	java/lang/Throwable
        //   289	297	469	java/lang/Throwable
        //   302	311	469	java/lang/Throwable
        //   314	410	469	java/lang/Throwable
        //   425	434	469	java/lang/Throwable
        //   434	439	469	java/lang/Throwable
        //   444	457	469	java/lang/Throwable
        //   457	466	469	java/lang/Throwable
        //   271	282	478	java/lang/Throwable
        //   190	249	486	java/lang/Throwable
        //   249	271	486	java/lang/Throwable
        //   561	576	579	finally
        //   718	733	736	finally
        //   637	708	762	finally
        //   769	825	762	finally
        //   637	708	767	java/lang/Throwable
        //   835	850	853	finally
        //   878	893	896	finally
        //   10	40	925	java/lang/Throwable
        //   44	67	930	java/lang/Throwable
        //   69	106	939	java/lang/Throwable
        //   410	425	948	java/lang/Throwable
        //   561	576	953	java/lang/Throwable
        //   609	614	958	java/lang/Throwable
        //   622	627	963	java/lang/Throwable
        //   718	733	968	java/lang/Throwable
        //   835	850	968	java/lang/Throwable
        //   878	893	973	java/lang/Throwable
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
        //   0: aload_0
        //   1: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   4: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   7: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   10: aload_0
        //   11: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   14: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   17: aload_0
        //   18: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   21: invokevirtual 61	java/util/HashSet:contains	(Ljava/lang/Object;)Z
        //   24: ifne +44 -> 68
        //   27: new 63	java/io/File
        //   30: dup
        //   31: aload_0
        //   32: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   35: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
        //   38: astore_2
        //   39: aload_2
        //   40: astore_3
        //   41: aload_2
        //   42: invokevirtual 70	java/io/File:exists	()Z
        //   45: ifne +25 -> 70
        //   48: aload_0
        //   49: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   52: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   55: aload_0
        //   56: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   59: invokevirtual 73	java/util/HashSet:add	(Ljava/lang/Object;)Z
        //   62: pop
        //   63: iconst_1
        //   64: istore_1
        //   65: goto +9 -> 74
        //   68: aconst_null
        //   69: astore_3
        //   70: iconst_0
        //   71: istore_1
        //   72: aload_3
        //   73: astore_2
        //   74: aload_0
        //   75: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   78: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   81: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   84: goto +30 -> 114
        //   87: astore_2
        //   88: aload_0
        //   89: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   92: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   95: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   98: aload_2
        //   99: athrow
        //   100: aconst_null
        //   101: astore_2
        //   102: aload_0
        //   103: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   106: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   109: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   112: iconst_0
        //   113: istore_1
        //   114: iload_1
        //   115: ifeq +476 -> 591
        //   118: new 78	java/lang/StringBuilder
        //   121: dup
        //   122: invokespecial 79	java/lang/StringBuilder:<init>	()V
        //   125: astore_3
        //   126: aload_3
        //   127: ldc 81
        //   129: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   132: pop
        //   133: aload_3
        //   134: aload_0
        //   135: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   138: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   141: pop
        //   142: ldc 87
        //   144: aload_3
        //   145: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   148: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   151: new 98	java/net/URL
        //   154: dup
        //   155: aload_0
        //   156: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   159: invokespecial 99	java/net/URL:<init>	(Ljava/lang/String;)V
        //   162: invokevirtual 103	java/net/URL:openConnection	()Ljava/net/URLConnection;
        //   165: checkcast 105	java/net/HttpURLConnection
        //   168: astore_3
        //   169: new 78	java/lang/StringBuilder
        //   172: dup
        //   173: invokespecial 79	java/lang/StringBuilder:<init>	()V
        //   176: astore 4
        //   178: aload 4
        //   180: aload_0
        //   181: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   184: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   187: pop
        //   188: aload 4
        //   190: ldc 107
        //   192: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   195: pop
        //   196: new 63	java/io/File
        //   199: dup
        //   200: aload 4
        //   202: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   205: invokespecial 66	java/io/File:<init>	(Ljava/lang/String;)V
        //   208: astore 5
        //   210: aload 5
        //   212: invokevirtual 70	java/io/File:exists	()Z
        //   215: ifeq +9 -> 224
        //   218: aload 5
        //   220: invokevirtual 110	java/io/File:delete	()Z
        //   223: pop
        //   224: aload 5
        //   226: invokevirtual 113	java/io/File:createNewFile	()Z
        //   229: pop
        //   230: aload_3
        //   231: invokevirtual 117	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
        //   234: astore_3
        //   235: new 119	java/io/FileOutputStream
        //   238: dup
        //   239: aload 5
        //   241: invokespecial 122	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   244: astore 4
        //   246: sipush 4096
        //   249: newarray byte
        //   251: astore 6
        //   253: aload_3
        //   254: aload 6
        //   256: invokevirtual 128	java/io/InputStream:read	([B)I
        //   259: istore_1
        //   260: iload_1
        //   261: iconst_m1
        //   262: if_icmpeq +15 -> 277
        //   265: aload 4
        //   267: aload 6
        //   269: iconst_0
        //   270: iload_1
        //   271: invokevirtual 132	java/io/FileOutputStream:write	([BII)V
        //   274: goto -21 -> 253
        //   277: aload 4
        //   279: invokevirtual 135	java/io/FileOutputStream:flush	()V
        //   282: aload_3
        //   283: invokevirtual 138	java/io/InputStream:close	()V
        //   286: aload 4
        //   288: invokevirtual 139	java/io/FileOutputStream:close	()V
        //   291: aload 5
        //   293: aload_2
        //   294: invokevirtual 143	java/io/File:renameTo	(Ljava/io/File;)Z
        //   297: pop
        //   298: new 78	java/lang/StringBuilder
        //   301: dup
        //   302: invokespecial 79	java/lang/StringBuilder:<init>	()V
        //   305: astore_2
        //   306: aload_2
        //   307: ldc 145
        //   309: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   312: pop
        //   313: aload_2
        //   314: aload_0
        //   315: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   318: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   321: pop
        //   322: ldc 87
        //   324: aload_2
        //   325: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   328: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   331: aload_0
        //   332: getfield 31	com/tencent/qqpimsecure/pg/e$2:c	Z
        //   335: ifeq +80 -> 415
        //   338: new 78	java/lang/StringBuilder
        //   341: dup
        //   342: invokespecial 79	java/lang/StringBuilder:<init>	()V
        //   345: astore_2
        //   346: aload_2
        //   347: ldc 147
        //   349: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   352: pop
        //   353: aload_2
        //   354: aload_0
        //   355: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   358: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   361: pop
        //   362: ldc 87
        //   364: aload_2
        //   365: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   368: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   371: aload_0
        //   372: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   375: aload_0
        //   376: getfield 33	com/tencent/qqpimsecure/pg/e$2:d	Ljava/lang/String;
        //   379: invokestatic 151	taiji/bo:a	(Ljava/lang/String;Ljava/lang/String;)V
        //   382: new 78	java/lang/StringBuilder
        //   385: dup
        //   386: invokespecial 79	java/lang/StringBuilder:<init>	()V
        //   389: astore_2
        //   390: aload_2
        //   391: ldc 153
        //   393: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   396: pop
        //   397: aload_2
        //   398: aload_0
        //   399: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   402: invokevirtual 85	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   405: pop
        //   406: ldc 87
        //   408: aload_2
        //   409: invokevirtual 91	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   412: invokestatic 96	taiji/bn:c	(Ljava/lang/String;Ljava/lang/String;)V
        //   415: aload_0
        //   416: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   419: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   422: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   425: aload_0
        //   426: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   429: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   432: aload_0
        //   433: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   436: invokevirtual 156	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   439: pop
        //   440: aload_0
        //   441: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   444: astore_2
        //   445: aload_2
        //   446: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   449: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   452: return
        //   453: astore_2
        //   454: aload_0
        //   455: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   458: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   461: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   464: aload_2
        //   465: athrow
        //   466: aload_0
        //   467: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   470: astore_2
        //   471: goto -26 -> 445
        //   474: aconst_null
        //   475: astore_2
        //   476: goto +7 -> 483
        //   479: aconst_null
        //   480: astore_3
        //   481: aload_3
        //   482: astore_2
        //   483: aload_0
        //   484: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   487: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   490: invokevirtual 52	java/util/concurrent/locks/ReentrantLock:lock	()V
        //   493: aload_0
        //   494: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   497: invokestatic 55	com/tencent/qqpimsecure/pg/e:c	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/HashSet;
        //   500: aload_0
        //   501: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   504: invokevirtual 156	java/util/HashSet:remove	(Ljava/lang/Object;)Z
        //   507: pop
        //   508: goto +16 -> 524
        //   511: astore_2
        //   512: aload_0
        //   513: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   516: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   519: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   522: aload_2
        //   523: athrow
        //   524: aload_0
        //   525: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   528: invokestatic 47	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;)Ljava/util/concurrent/locks/ReentrantLock;
        //   531: invokevirtual 76	java/util/concurrent/locks/ReentrantLock:unlock	()V
        //   534: aload_3
        //   535: ifnull +10 -> 545
        //   538: aload_3
        //   539: invokevirtual 138	java/io/InputStream:close	()V
        //   542: goto +3 -> 545
        //   545: aload_2
        //   546: ifnull +10 -> 556
        //   549: aload_2
        //   550: invokevirtual 139	java/io/FileOutputStream:close	()V
        //   553: goto +3 -> 556
        //   556: aload_0
        //   557: getfield 35	com/tencent/qqpimsecure/pg/e$2:e	Z
        //   560: ifeq +31 -> 591
        //   563: aload_0
        //   564: getfield 25	com/tencent/qqpimsecure/pg/e$2:g	Lcom/tencent/qqpimsecure/pg/e;
        //   567: aload_0
        //   568: getfield 37	com/tencent/qqpimsecure/pg/e$2:f	Landroid/content/Context;
        //   571: aload_0
        //   572: getfield 29	com/tencent/qqpimsecure/pg/e$2:b	Ljava/lang/String;
        //   575: aload_0
        //   576: getfield 27	com/tencent/qqpimsecure/pg/e$2:a	Ljava/lang/String;
        //   579: aload_0
        //   580: getfield 33	com/tencent/qqpimsecure/pg/e$2:d	Ljava/lang/String;
        //   583: iconst_0
        //   584: aload_0
        //   585: getfield 31	com/tencent/qqpimsecure/pg/e$2:c	Z
        //   588: invokestatic 159	com/tencent/qqpimsecure/pg/e:a	(Lcom/tencent/qqpimsecure/pg/e;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
        //   591: return
        //   592: astore_2
        //   593: goto -493 -> 100
        //   596: astore_3
        //   597: goto -495 -> 102
        //   600: astore_2
        //   601: goto -122 -> 479
        //   604: astore_2
        //   605: goto -131 -> 474
        //   608: astore_2
        //   609: aload 4
        //   611: astore_2
        //   612: goto -129 -> 483
        //   615: astore_2
        //   616: goto -150 -> 466
        //   619: astore 4
        //   621: goto -97 -> 524
        //   624: astore_3
        //   625: goto -80 -> 545
        //   628: astore_2
        //   629: goto -73 -> 556
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	632	0	this	2
        //   64	207	1	i	int
        //   38	36	2	localObject1	Object
        //   87	12	2	localObject2	Object
        //   101	345	2	localObject3	Object
        //   453	12	2	localObject4	Object
        //   470	13	2	localObject5	Object
        //   511	39	2	localObject6	Object
        //   592	1	2	localThrowable1	Throwable
        //   600	1	2	localThrowable2	Throwable
        //   604	1	2	localThrowable3	Throwable
        //   608	1	2	localThrowable4	Throwable
        //   611	1	2	localObject7	Object
        //   615	1	2	localThrowable5	Throwable
        //   628	1	2	localThrowable6	Throwable
        //   40	499	3	localObject8	Object
        //   596	1	3	localThrowable7	Throwable
        //   624	1	3	localThrowable8	Throwable
        //   176	434	4	localObject9	Object
        //   619	1	4	localThrowable9	Throwable
        //   208	84	5	localFile	File
        //   251	17	6	arrayOfByte	byte[]
        // Exception table:
        //   from	to	target	type
        //   10	39	87	finally
        //   41	63	87	finally
        //   425	440	453	finally
        //   493	508	511	finally
        //   10	39	592	java/lang/Throwable
        //   41	63	596	java/lang/Throwable
        //   151	224	600	java/lang/Throwable
        //   224	235	600	java/lang/Throwable
        //   235	246	604	java/lang/Throwable
        //   246	253	608	java/lang/Throwable
        //   253	260	608	java/lang/Throwable
        //   265	274	608	java/lang/Throwable
        //   277	415	608	java/lang/Throwable
        //   415	425	608	java/lang/Throwable
        //   440	445	608	java/lang/Throwable
        //   445	452	608	java/lang/Throwable
        //   454	466	608	java/lang/Throwable
        //   466	471	608	java/lang/Throwable
        //   425	440	615	java/lang/Throwable
        //   493	508	619	java/lang/Throwable
        //   538	542	624	java/lang/Throwable
        //   549	553	628	java/lang/Throwable
      }
    };
    com.tencent.qqpimsecure.taiji.c.a().d().addTask(paramContext, "Download");
  }
  
  private static Pair<Boolean, Integer> b(Context paramContext, MSolution paramMSolution, int paramInt)
  {
    Object localObject2;
    PackageManager localPackageManager;
    Object localObject1;
    if ((!TextUtils.isEmpty(paramMSolution.mJumpIntent.mPackage)) && (!TextUtils.isEmpty(paramMSolution.mJumpIntent.mClass)))
    {
      localObject2 = new Intent();
      ((Intent)localObject2).setClassName(paramMSolution.mJumpIntent.mPackage, paramMSolution.mJumpIntent.mClass);
      localPackageManager = paramContext.getPackageManager();
      localObject1 = null;
    }
    try
    {
      localPackageInfo = paramContext.getPackageManager().getPackageInfo(paramMSolution.mJumpIntent.mPackage, 0);
    }
    catch (Throwable localThrowable1)
    {
      PackageInfo localPackageInfo;
      label87:
      int i;
      label120:
      break label87;
    }
    localPackageInfo = null;
    if (localPackageInfo != null) {
      i = localPackageInfo.versionCode;
    } else {
      i = 0;
    }
    try
    {
      localObject2 = localPackageManager.resolveActivity((Intent)localObject2, 0);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable2)
    {
      int j;
      break label120;
    }
    if ((localObject1 != null) && (localObject1.activityInfo != null))
    {
      if ((!paramContext.getPackageName().equals(paramMSolution.mJumpIntent.mPackage)) && (!localObject1.activityInfo.exported))
      {
        paramMSolution = new StringBuilder();
        paramMSolution.append("invalid solution, intent activityInfo package is not exported, adapterID:");
        paramMSolution.append(paramInt);
        bn.d("ManualSolutionManager", paramMSolution.toString());
        a.a(paramContext, paramInt, 1, i);
        return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
      }
      if ((!TextUtils.isEmpty(localObject1.activityInfo.permission)) && (localPackageManager.checkPermission(localObject1.activityInfo.permission, paramContext.getPackageName()) == -1))
      {
        paramMSolution = new StringBuilder();
        paramMSolution.append("invalid solution, intent activityInfo permission is denied, adapterID:");
        paramMSolution.append(paramInt);
        bn.d("ManualSolutionManager", paramMSolution.toString());
        a.a(paramContext, paramInt, 1, i);
        return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
      }
      j = localPackageManager.getApplicationEnabledSetting(paramMSolution.mJumpIntent.mPackage);
      if ((j != 2) && (j != 3) && (j != 4))
      {
        if ((paramMSolution.mHelpInfoAdapter != null) && (!paramMSolution.mHelpInfoAdapter.isEmpty()))
        {
          if (localPackageInfo == null)
          {
            paramMSolution = new StringBuilder();
            paramMSolution.append("invalid solution, intent pkgInfo is null, adapterID:");
            paramMSolution.append(paramInt);
            bn.d("ManualSolutionManager", paramMSolution.toString());
            a.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
          if (paramMSolution.mHelpInfoAdapter.containsKey(Integer.valueOf(i)))
          {
            paramContext = (String)paramMSolution.mHelpInfoAdapter.get(Integer.valueOf(i));
            if (!TextUtils.isEmpty(paramContext)) {
              paramMSolution.mHelpInfo = paramContext;
            }
          }
          else
          {
            paramMSolution = new StringBuilder();
            paramMSolution.append("invalid solution, intent pkgVerCode is wrong, adapterID:");
            paramMSolution.append(paramInt);
            bn.d("ManualSolutionManager", paramMSolution.toString());
            a.a(paramContext, paramInt, 1, i);
            return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
          }
        }
        return new Pair(Boolean.valueOf(true), Integer.valueOf(i));
      }
      paramMSolution = new StringBuilder();
      paramMSolution.append("invalid solution, intent package state is disabled, adapterID:");
      paramMSolution.append(paramInt);
      bn.d("ManualSolutionManager", paramMSolution.toString());
      a.a(paramContext, paramInt, 1, i);
      return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
    }
    paramMSolution = new StringBuilder();
    paramMSolution.append("invalid solution, intent resolveActivity intentInfo or activityInfo is null, adapterID:");
    paramMSolution.append(paramInt);
    bn.d("ManualSolutionManager", paramMSolution.toString());
    a.a(paramContext, paramInt, 1, i);
    return new Pair(Boolean.valueOf(false), Integer.valueOf(i));
    paramContext = new StringBuilder();
    paramContext.append("invalid solution, intent package or class is empty, adapterID:");
    paramContext.append(paramInt);
    bn.d("ManualSolutionManager", paramContext.toString());
    return new Pair(Boolean.valueOf(false), Integer.valueOf(0));
  }
  
  private static ArrayList<ArrayList<String>> b(Context paramContext, MSolution paramMSolution, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList1 = new ArrayList();
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramContext.getFilesDir());
    ((StringBuilder)localObject1).append("/mguide_solution");
    String str2 = ((StringBuilder)localObject1).toString();
    localObject1 = new File(str2);
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
      if (str1.contains("/")) {
        localObject1 = str1.substring(str1.lastIndexOf("/") + 1);
      }
    }
    catch (Throwable localThrowable1)
    {
      label139:
      Object localObject2;
      Object localObject3;
      String str3;
      int j;
      int i;
      int k;
      ArrayList localArrayList2;
      Object localObject4;
      break label139;
    }
    localObject1 = str1;
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      a.a(paramContext, paramInt1, 1, paramInt2);
      return null;
    }
    if (((String)localObject1).contains(".")) {
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf("."));
    } else {
      localObject2 = localObject1;
    }
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append(str2);
    ((StringBuilder)localObject3).append("/");
    ((StringBuilder)localObject3).append((String)localObject1);
    str3 = ((StringBuilder)localObject3).toString();
    j = paramMSolution.mHelpDoraemonZip.mDoraemonResList.size();
    i = 0;
    if (i < j)
    {
      localObject3 = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i)).mFileList;
      k = ((MDoraemonRes)paramMSolution.mHelpDoraemonZip.mDoraemonResList.get(i)).mDoraemonType;
      if (((k != 1) && (k != 2)) || ((localObject3 != null) && (!((ArrayList)localObject3).isEmpty())))
      {
        localArrayList2 = new ArrayList();
        localObject3 = ((ArrayList)localObject3).iterator();
        label341:
        if (((Iterator)localObject3).hasNext()) {
          localObject4 = (String)((Iterator)localObject3).next();
        }
      }
    }
    try
    {
      if (((String)localObject4).contains("/")) {
        k = ((String)localObject4).lastIndexOf("/");
      }
    }
    catch (Throwable localThrowable2)
    {
      Object localObject5;
      label402:
      label537:
      break label402;
    }
    try
    {
      localObject5 = ((String)localObject4).substring(k + 1);
      localObject4 = localObject5;
    }
    catch (Throwable localThrowable3)
    {
      break label402;
    }
    if (TextUtils.isEmpty((CharSequence)localObject4)) {
      a.a(paramContext, paramInt1, 1, paramInt2);
    }
    for (;;)
    {
      return null;
      localObject5 = new StringBuilder();
      ((StringBuilder)localObject5).append(str2);
      ((StringBuilder)localObject5).append("/");
      ((StringBuilder)localObject5).append((String)localObject2);
      ((StringBuilder)localObject5).append("/");
      ((StringBuilder)localObject5).append((String)localObject4);
      localObject4 = ((StringBuilder)localObject5).toString();
      if (!new File((String)localObject4).exists())
      {
        paramInt1 = 0;
        break label537;
      }
      localArrayList2.add(localObject4);
      break label341;
      localArrayList1.add(localArrayList2);
      i += 1;
      break;
      a.a(paramContext, paramInt1, 1, paramInt2);
    }
    paramInt1 = 1;
    if (paramInt1 == 0)
    {
      if (!paramMSolution.mHelpImageLocal) {
        a().a(paramContext, str1, str3, str2, true, true);
      } else {
        a().a(paramContext, (String)localObject1, str3, str2, true);
      }
      return null;
    }
    return localArrayList1;
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