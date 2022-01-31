import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.CleanCache;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class zwq
  implements Runnable
{
  private int jdField_a_of_type_Int;
  
  public zwq(CleanCache paramCleanCache) {}
  
  /* Error */
  private int a(File paramFile)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 26	java/io/File:exists	()Z
    //   4: ifeq +504 -> 508
    //   7: aload_1
    //   8: invokevirtual 29	java/io/File:isDirectory	()Z
    //   11: ifeq +497 -> 508
    //   14: aload_1
    //   15: invokevirtual 33	java/io/File:listFiles	()[Ljava/io/File;
    //   18: astore 13
    //   20: aload 13
    //   22: ifnonnull +5 -> 27
    //   25: iconst_0
    //   26: ireturn
    //   27: aload 13
    //   29: arraylength
    //   30: istore 4
    //   32: lconst_0
    //   33: lstore 7
    //   35: aload_1
    //   36: getstatic 38	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Ljava/io/File;
    //   39: if_acmpne +40 -> 79
    //   42: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   45: ifeq +34 -> 79
    //   48: ldc 45
    //   50: iconst_2
    //   51: new 47	java/lang/StringBuilder
    //   54: dup
    //   55: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   58: ldc 50
    //   60: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: iload 4
    //   65: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: ldc 59
    //   70: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   76: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   79: iload 4
    //   81: sipush 2000
    //   84: if_icmple +412 -> 496
    //   87: aload 13
    //   89: new 69	zwt
    //   92: dup
    //   93: aload_0
    //   94: invokespecial 72	zwt:<init>	(Lzwq;)V
    //   97: invokestatic 78	java/util/Arrays:sort	([Ljava/lang/Object;Ljava/util/Comparator;)V
    //   100: aload 13
    //   102: arraylength
    //   103: istore 6
    //   105: iconst_0
    //   106: istore 5
    //   108: iload 4
    //   110: istore_3
    //   111: lload 7
    //   113: lstore 9
    //   115: iload_3
    //   116: istore_2
    //   117: iload 5
    //   119: iload 6
    //   121: if_icmpge +41 -> 162
    //   124: aload 13
    //   126: iload 5
    //   128: aaload
    //   129: astore 14
    //   131: lload 7
    //   133: aload 14
    //   135: invokevirtual 82	java/io/File:length	()J
    //   138: ladd
    //   139: lstore 7
    //   141: aload 14
    //   143: invokevirtual 85	java/io/File:delete	()Z
    //   146: pop
    //   147: iload_3
    //   148: iconst_1
    //   149: isub
    //   150: istore_2
    //   151: iload_2
    //   152: sipush 500
    //   155: if_icmpgt +148 -> 303
    //   158: lload 7
    //   160: lstore 9
    //   162: iload 4
    //   164: sipush 500
    //   167: isub
    //   168: istore_3
    //   169: invokestatic 90	java/lang/System:currentTimeMillis	()J
    //   172: lstore 11
    //   174: aload 13
    //   176: arraylength
    //   177: istore 4
    //   179: iload 4
    //   181: iload_2
    //   182: isub
    //   183: istore 4
    //   185: iload_3
    //   186: istore_2
    //   187: iload 4
    //   189: aload 13
    //   191: arraylength
    //   192: if_icmpge +145 -> 337
    //   195: aload 13
    //   197: iload 4
    //   199: aaload
    //   200: astore 14
    //   202: lload 9
    //   204: lstore 7
    //   206: iload_2
    //   207: istore_3
    //   208: aload 14
    //   210: invokevirtual 26	java/io/File:exists	()Z
    //   213: ifeq +278 -> 491
    //   216: lload 9
    //   218: lstore 7
    //   220: iload_2
    //   221: istore_3
    //   222: aload 14
    //   224: invokevirtual 93	java/io/File:isFile	()Z
    //   227: ifeq +264 -> 491
    //   230: lload 11
    //   232: aload 14
    //   234: invokevirtual 96	java/io/File:lastModified	()J
    //   237: lsub
    //   238: ldc2_w 97
    //   241: lcmp
    //   242: ifle +95 -> 337
    //   245: lload 9
    //   247: aload 14
    //   249: invokevirtual 82	java/io/File:length	()J
    //   252: ladd
    //   253: lstore 9
    //   255: aload 14
    //   257: invokevirtual 85	java/io/File:delete	()Z
    //   260: pop
    //   261: iload_2
    //   262: iconst_1
    //   263: iadd
    //   264: istore_2
    //   265: lload 9
    //   267: lstore 7
    //   269: iload_2
    //   270: istore_3
    //   271: iload 4
    //   273: sipush 200
    //   276: irem
    //   277: ifne +214 -> 491
    //   280: ldc2_w 99
    //   283: invokestatic 106	java/lang/Thread:sleep	(J)V
    //   286: lload 9
    //   288: lstore 7
    //   290: iload 4
    //   292: iconst_1
    //   293: iadd
    //   294: istore 4
    //   296: lload 7
    //   298: lstore 9
    //   300: goto -113 -> 187
    //   303: iload_2
    //   304: sipush 200
    //   307: irem
    //   308: ifne +9 -> 317
    //   311: ldc2_w 99
    //   314: invokestatic 106	java/lang/Thread:sleep	(J)V
    //   317: iload 5
    //   319: iconst_1
    //   320: iadd
    //   321: istore 5
    //   323: iload_2
    //   324: istore_3
    //   325: goto -214 -> 111
    //   328: astore 14
    //   330: lload 9
    //   332: lstore 7
    //   334: goto -44 -> 290
    //   337: iload_2
    //   338: istore_3
    //   339: aload_1
    //   340: getstatic 38	com/tencent/mobileqq/transfile/URLDrawableHelper:a	Ljava/io/File;
    //   343: if_acmpne +141 -> 484
    //   346: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   349: ifeq +46 -> 395
    //   352: ldc 45
    //   354: iconst_2
    //   355: new 47	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   362: ldc 108
    //   364: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: iload_2
    //   368: invokevirtual 57	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   371: ldc 110
    //   373: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: lload 9
    //   378: ldc2_w 111
    //   381: ldiv
    //   382: ldc2_w 111
    //   385: ldiv
    //   386: invokevirtual 115	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   389: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   392: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   395: iload_2
    //   396: istore_3
    //   397: iload_2
    //   398: ifle +86 -> 484
    //   401: aload_0
    //   402: getfield 13	zwq:jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   405: invokestatic 121	com/tencent/mobileqq/app/automator/step/CleanCache:b	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)Lcom/tencent/mobileqq/app/automator/Automator;
    //   408: getfield 126	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   411: invokevirtual 131	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   414: invokestatic 136	com/tencent/mobileqq/utils/SharedPreUtils:a	(Ljava/lang/String;)J
    //   417: lstore 7
    //   419: invokestatic 141	com/tencent/mobileqq/msf/core/NetConnInfoCenter:getServerTime	()J
    //   422: ldc2_w 142
    //   425: ldiv
    //   426: lstore 9
    //   428: lload 7
    //   430: lconst_0
    //   431: lcmp
    //   432: ifeq +34 -> 466
    //   435: lload 9
    //   437: lload 7
    //   439: lcmp
    //   440: ifle +26 -> 466
    //   443: invokestatic 149	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   446: invokestatic 154	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   449: aconst_null
    //   450: ldc 156
    //   452: iconst_1
    //   453: lload 9
    //   455: lload 7
    //   457: lsub
    //   458: iload_2
    //   459: i2l
    //   460: aconst_null
    //   461: ldc 158
    //   463: invokevirtual 161	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;)V
    //   466: aload_0
    //   467: getfield 13	zwq:jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   470: invokestatic 164	com/tencent/mobileqq/app/automator/step/CleanCache:c	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)Lcom/tencent/mobileqq/app/automator/Automator;
    //   473: getfield 126	com/tencent/mobileqq/app/automator/Automator:a	Lcom/tencent/common/app/AppInterface;
    //   476: invokevirtual 131	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   479: invokestatic 167	com/tencent/mobileqq/utils/SharedPreUtils:a	(Ljava/lang/String;)V
    //   482: iload_2
    //   483: istore_3
    //   484: iload_3
    //   485: ireturn
    //   486: astore 14
    //   488: goto -171 -> 317
    //   491: iload_3
    //   492: istore_2
    //   493: goto -203 -> 290
    //   496: iconst_0
    //   497: istore_3
    //   498: iload 4
    //   500: istore_2
    //   501: lload 7
    //   503: lstore 9
    //   505: goto -336 -> 169
    //   508: iconst_0
    //   509: istore_3
    //   510: goto -26 -> 484
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	513	0	this	zwq
    //   0	513	1	paramFile	File
    //   116	385	2	i	int
    //   110	400	3	j	int
    //   30	469	4	k	int
    //   106	216	5	m	int
    //   103	19	6	n	int
    //   33	469	7	l1	long
    //   113	391	9	l2	long
    //   172	59	11	l3	long
    //   18	178	13	arrayOfFile	File[]
    //   129	127	14	localFile	File
    //   328	1	14	localInterruptedException1	java.lang.InterruptedException
    //   486	1	14	localInterruptedException2	java.lang.InterruptedException
    // Exception table:
    //   from	to	target	type
    //   280	286	328	java/lang/InterruptedException
    //   311	317	486	java/lang/InterruptedException
  }
  
  private int a(File[] paramArrayOfFile, int paramInt)
  {
    int i = 0;
    for (;;)
    {
      int j = paramInt;
      if (i < paramArrayOfFile.length)
      {
        File localFile = paramArrayOfFile[i];
        if (localFile.exists()) {
          localFile.delete();
        }
        paramArrayOfFile[i] = null;
        paramInt += 1;
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache->delRemainQQHead. delete QQHead,filePath=" + localFile.getAbsolutePath());
        }
        if (paramInt >= this.jdField_a_of_type_Int) {
          j = paramInt;
        }
      }
      else
      {
        return j;
      }
      i += 1;
    }
  }
  
  private void a()
  {
    int j = 0;
    int i = 0;
    long l1 = System.currentTimeMillis();
    Object localObject1 = new File(AppConstants.aK + "shortvideo");
    int m;
    int k;
    if ((((File)localObject1).exists()) && (((File)localObject1).isDirectory()))
    {
      localObject1 = ((File)localObject1).listFiles();
      if (localObject1 != null)
      {
        int n = localObject1.length;
        m = n;
        if (n > 2000)
        {
          Arrays.sort((Object[])localObject1, new zwu(this));
          int i1 = localObject1.length;
          k = 0;
          j = i;
          m = n;
          if (k < i1)
          {
            Object localObject2 = localObject1[k];
            j = i;
            if (localObject2 == null) {
              break label323;
            }
            j = i;
            if (!localObject2.isDirectory()) {
              break label323;
            }
            j = i;
            if (localObject2.getName().equals("thumbs")) {
              break label323;
            }
            if (QLog.isColorLevel()) {
              QLog.d("QQInitHandler", 2, "delShortVideoCache ===> deleteCount=" + i + ", delete dir=" + localObject2.getAbsolutePath());
            }
            FileUtils.a(localObject2.getAbsolutePath());
            i += 1;
            if (i < n - 1000) {
              break label305;
            }
            m = n;
            j = i;
          }
        }
      }
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "delShortVideoCache(), totalCount=" + m + ", deleteCount= " + j + ", targetDeleteCount=" + (m - 1000) + ", cost: " + (l2 - l1) + " ms");
      }
      return;
      label305:
      j = i;
      if (i % 200 == 0) {}
      try
      {
        Thread.sleep(100L);
        j = i;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          label323:
          j = i;
        }
      }
      k += 1;
      i = j;
      break;
      m = 0;
    }
  }
  
  /* Error */
  private File[] a(File[] paramArrayOfFile)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 10
    //   9: iconst_0
    //   10: istore 5
    //   12: aload_0
    //   13: getfield 13	zwq:jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   16: invokestatic 221	com/tencent/mobileqq/app/automator/step/CleanCache:d	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)Lcom/tencent/mobileqq/app/automator/Automator;
    //   19: getfield 224	com/tencent/mobileqq/app/automator/Automator:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   22: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   25: invokevirtual 236	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   28: astore 7
    //   30: aload 7
    //   32: iconst_0
    //   33: ldc 238
    //   35: invokevirtual 243	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   38: iconst_2
    //   39: anewarray 197	java/lang/String
    //   42: dup
    //   43: iconst_0
    //   44: ldc 245
    //   46: aastore
    //   47: dup
    //   48: iconst_1
    //   49: ldc 247
    //   51: aastore
    //   52: ldc 249
    //   54: iconst_1
    //   55: anewarray 197	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: ldc 251
    //   62: aastore
    //   63: aconst_null
    //   64: aconst_null
    //   65: aconst_null
    //   66: aconst_null
    //   67: invokevirtual 256	com/tencent/mobileqq/persistence/EntityManager:a	(ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   70: astore 8
    //   72: aload 10
    //   74: astore 9
    //   76: aload 8
    //   78: ifnull +100 -> 178
    //   81: aload 10
    //   83: astore 9
    //   85: aload 8
    //   87: invokeinterface 261 1 0
    //   92: ifeq +86 -> 178
    //   95: new 263	java/util/HashMap
    //   98: dup
    //   99: aload 8
    //   101: invokeinterface 267 1 0
    //   106: invokespecial 270	java/util/HashMap:<init>	(I)V
    //   109: astore 9
    //   111: aload 8
    //   113: iconst_0
    //   114: invokeinterface 274 2 0
    //   119: astore 10
    //   121: aload 8
    //   123: iconst_1
    //   124: invokeinterface 278 2 0
    //   129: istore_2
    //   130: aload_0
    //   131: getfield 13	zwq:jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache	Lcom/tencent/mobileqq/app/automator/step/CleanCache;
    //   134: invokestatic 281	com/tencent/mobileqq/app/automator/step/CleanCache:e	(Lcom/tencent/mobileqq/app/automator/step/CleanCache;)Lcom/tencent/mobileqq/app/automator/Automator;
    //   137: getfield 224	com/tencent/mobileqq/app/automator/Automator:b	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   140: astore 11
    //   142: iload_2
    //   143: iconst_4
    //   144: if_icmpne +413 -> 557
    //   147: iconst_1
    //   148: istore 6
    //   150: aload 9
    //   152: aload 11
    //   154: iload 6
    //   156: aload 10
    //   158: iconst_1
    //   159: invokevirtual 284	com/tencent/mobileqq/app/QQAppInterface:a	(ZLjava/lang/String;Z)Ljava/lang/String;
    //   162: aload 10
    //   164: invokevirtual 288	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   167: pop
    //   168: aload 8
    //   170: invokeinterface 291 1 0
    //   175: ifne -64 -> 111
    //   178: aload 7
    //   180: new 47	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 293
    //   190: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: ldc 238
    //   195: invokevirtual 243	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   198: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 295
    //   204: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokevirtual 298	com/tencent/mobileqq/persistence/EntityManager:b	(Ljava/lang/String;)Z
    //   213: pop
    //   214: aload 9
    //   216: ifnull +347 -> 563
    //   219: aload 9
    //   221: invokevirtual 301	java/util/HashMap:size	()I
    //   224: ifle +339 -> 563
    //   227: iconst_0
    //   228: istore_3
    //   229: iconst_0
    //   230: istore_2
    //   231: iload_2
    //   232: istore 4
    //   234: iload_3
    //   235: aload_1
    //   236: arraylength
    //   237: if_icmpge +101 -> 338
    //   240: aload_1
    //   241: iload_3
    //   242: aaload
    //   243: astore 10
    //   245: aload 10
    //   247: invokevirtual 173	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   250: astore 11
    //   252: iload_2
    //   253: istore 4
    //   255: aload 9
    //   257: aload 11
    //   259: invokevirtual 304	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   262: ifeq +285 -> 547
    //   265: aload 10
    //   267: invokevirtual 26	java/io/File:exists	()Z
    //   270: ifeq +9 -> 279
    //   273: aload 10
    //   275: invokevirtual 85	java/io/File:delete	()Z
    //   278: pop
    //   279: aload_1
    //   280: iload_3
    //   281: aconst_null
    //   282: aastore
    //   283: invokestatic 43	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   286: ifeq +256 -> 542
    //   289: ldc 45
    //   291: iconst_2
    //   292: new 47	java/lang/StringBuilder
    //   295: dup
    //   296: invokespecial 48	java/lang/StringBuilder:<init>	()V
    //   299: ldc_w 306
    //   302: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 9
    //   307: aload 11
    //   309: invokevirtual 310	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   312: checkcast 197	java/lang/String
    //   315: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: ldc_w 312
    //   321: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload 11
    //   326: invokevirtual 54	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: invokevirtual 63	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   332: invokestatic 67	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   335: goto +207 -> 542
    //   338: aload_1
    //   339: astore 9
    //   341: iload 4
    //   343: ifle +59 -> 402
    //   346: aload_1
    //   347: arraylength
    //   348: iload 4
    //   350: isub
    //   351: anewarray 22	java/io/File
    //   354: astore 9
    //   356: iconst_0
    //   357: istore_2
    //   358: iload 5
    //   360: istore_3
    //   361: iload_3
    //   362: aload_1
    //   363: arraylength
    //   364: if_icmpge +38 -> 402
    //   367: iload_2
    //   368: aload 9
    //   370: arraylength
    //   371: if_icmpge +31 -> 402
    //   374: aload_1
    //   375: iload_3
    //   376: aaload
    //   377: ifnull +162 -> 539
    //   380: iload_2
    //   381: iconst_1
    //   382: iadd
    //   383: istore 4
    //   385: aload 9
    //   387: iload_2
    //   388: aload_1
    //   389: iload_3
    //   390: aaload
    //   391: aastore
    //   392: iload 4
    //   394: istore_2
    //   395: iload_3
    //   396: iconst_1
    //   397: iadd
    //   398: istore_3
    //   399: goto -38 -> 361
    //   402: aload 8
    //   404: ifnull +10 -> 414
    //   407: aload 8
    //   409: invokeinterface 315 1 0
    //   414: aload 9
    //   416: astore 10
    //   418: aload 7
    //   420: ifnull +12 -> 432
    //   423: aload 7
    //   425: invokevirtual 317	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   428: aload 9
    //   430: astore 10
    //   432: aload 10
    //   434: areturn
    //   435: astore 7
    //   437: aconst_null
    //   438: astore 7
    //   440: aload 7
    //   442: ifnull +10 -> 452
    //   445: aload 7
    //   447: invokeinterface 315 1 0
    //   452: aload_1
    //   453: astore 10
    //   455: aload 8
    //   457: ifnull -25 -> 432
    //   460: aload 8
    //   462: invokevirtual 317	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   465: aload_1
    //   466: areturn
    //   467: astore_1
    //   468: aconst_null
    //   469: astore 8
    //   471: aload 9
    //   473: astore 7
    //   475: aload 8
    //   477: ifnull +10 -> 487
    //   480: aload 8
    //   482: invokeinterface 315 1 0
    //   487: aload 7
    //   489: ifnull +8 -> 497
    //   492: aload 7
    //   494: invokevirtual 317	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   497: aload_1
    //   498: athrow
    //   499: astore_1
    //   500: aconst_null
    //   501: astore 8
    //   503: goto -28 -> 475
    //   506: astore_1
    //   507: goto -32 -> 475
    //   510: astore 8
    //   512: aload 7
    //   514: astore 8
    //   516: aconst_null
    //   517: astore 7
    //   519: goto -79 -> 440
    //   522: astore 9
    //   524: aload 7
    //   526: astore 9
    //   528: aload 8
    //   530: astore 7
    //   532: aload 9
    //   534: astore 8
    //   536: goto -96 -> 440
    //   539: goto -144 -> 395
    //   542: iload_2
    //   543: iconst_1
    //   544: iadd
    //   545: istore 4
    //   547: iload_3
    //   548: iconst_1
    //   549: iadd
    //   550: istore_3
    //   551: iload 4
    //   553: istore_2
    //   554: goto -323 -> 231
    //   557: iconst_0
    //   558: istore 6
    //   560: goto -410 -> 150
    //   563: iconst_0
    //   564: istore 4
    //   566: goto -228 -> 338
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	569	0	this	zwq
    //   0	569	1	paramArrayOfFile	File[]
    //   129	425	2	i	int
    //   228	323	3	j	int
    //   232	333	4	k	int
    //   10	349	5	m	int
    //   148	411	6	bool	boolean
    //   28	396	7	localEntityManager	EntityManager
    //   435	1	7	localException1	Exception
    //   438	93	7	localObject1	Object
    //   1	501	8	localCursor	android.database.Cursor
    //   510	1	8	localException2	Exception
    //   514	21	8	localObject2	Object
    //   4	468	9	localObject3	Object
    //   522	1	9	localException3	Exception
    //   526	7	9	localObject4	Object
    //   7	447	10	localObject5	Object
    //   140	185	11	localObject6	Object
    // Exception table:
    //   from	to	target	type
    //   12	30	435	java/lang/Exception
    //   12	30	467	finally
    //   30	72	499	finally
    //   85	111	506	finally
    //   111	142	506	finally
    //   150	178	506	finally
    //   178	214	506	finally
    //   219	227	506	finally
    //   234	240	506	finally
    //   245	252	506	finally
    //   255	279	506	finally
    //   283	335	506	finally
    //   346	356	506	finally
    //   361	374	506	finally
    //   30	72	510	java/lang/Exception
    //   85	111	522	java/lang/Exception
    //   111	142	522	java/lang/Exception
    //   150	178	522	java/lang/Exception
    //   178	214	522	java/lang/Exception
    //   219	227	522	java/lang/Exception
    //   234	240	522	java/lang/Exception
    //   245	252	522	java/lang/Exception
    //   255	279	522	java/lang/Exception
    //   283	335	522	java/lang/Exception
    //   346	356	522	java/lang/Exception
    //   361	374	522	java/lang/Exception
  }
  
  private File[] a(File[] paramArrayOfFile, int paramInt)
  {
    int m = 0;
    EntityManager localEntityManager = null;
    localObject2 = localEntityManager;
    for (;;)
    {
      try
      {
        localObject3 = new LinkedList();
        localObject2 = localEntityManager;
        localEntityManager = CleanCache.f(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).b.getEntityManagerFactory().createEntityManager();
        localObject2 = localEntityManager;
      }
      catch (Exception localException)
      {
        Object localObject4;
        Object localObject5;
        int k;
        Object localObject3 = paramArrayOfFile;
        if (localObject2 == null) {
          continue;
        }
        ((EntityManager)localObject2).a();
        return paramArrayOfFile;
      }
      finally
      {
        Object localObject1 = null;
        if (localObject1 != null) {
          localObject1.a();
        }
      }
      try
      {
        localObject4 = (ArrayList)localEntityManager.a(Friends.class, false, "groupid>=?", new String[] { "0" }, null, null, null, null);
        if (localObject4 != null)
        {
          localObject2 = localEntityManager;
          if (((ArrayList)localObject4).size() != 0)
          {
            i = 0;
            localObject2 = localEntityManager;
            if (i < ((ArrayList)localObject4).size())
            {
              localObject2 = localEntityManager;
              localObject5 = (Friends)((ArrayList)localObject4).get(i);
              localObject2 = localEntityManager;
              ((LinkedList)localObject3).add(CleanCache.g(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).b.a(false, ((Friends)localObject5).uin, true));
              i += 1;
              continue;
            }
          }
        }
        localObject2 = localEntityManager;
        localObject4 = (ArrayList)localEntityManager.a(TroopInfo.class, false, null, null, null, null, null, null);
        if (localObject4 == null) {
          break label600;
        }
        localObject2 = localEntityManager;
        if (((ArrayList)localObject4).size() <= 0) {
          break label600;
        }
        i = 0;
        localObject2 = localEntityManager;
        if (i >= ((ArrayList)localObject4).size()) {
          break label600;
        }
        localObject2 = localEntityManager;
        localObject5 = (TroopInfo)((ArrayList)localObject4).get(i);
        localObject2 = localEntityManager;
        ((LinkedList)localObject3).add(CleanCache.h(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).b.a(true, ((TroopInfo)localObject5).troopuin, true));
        i += 1;
        continue;
      }
      finally
      {
        continue;
        continue;
        j = 0;
        i = 0;
        continue;
      }
      k = i;
      localObject2 = localEntityManager;
      if (j < paramArrayOfFile.length)
      {
        localObject4 = paramArrayOfFile[j];
        localObject2 = localEntityManager;
        localObject5 = ((File)localObject4).getAbsolutePath();
        k = i;
        localObject2 = localEntityManager;
        if (!((LinkedList)localObject3).contains(localObject5))
        {
          k = i;
          localObject2 = localEntityManager;
          if (((String)localObject5).indexOf("discussion_") < 0)
          {
            k = i;
            localObject2 = localEntityManager;
            if (((String)localObject5).indexOf("sys_") < 0)
            {
              localObject2 = localEntityManager;
              if (((File)localObject4).exists())
              {
                localObject2 = localEntityManager;
                ((File)localObject4).delete();
              }
              paramArrayOfFile[j] = null;
              i += 1;
              localObject2 = localEntityManager;
              if (QLog.isColorLevel())
              {
                localObject2 = localEntityManager;
                QLog.d("QQInitHandler", 2, "onCleanCache->delSecondaryQQHead. delete QQHead,filePath=" + ((File)localObject4).getAbsolutePath());
              }
              k = i;
              localObject2 = localEntityManager;
              if (paramInt + i >= this.jdField_a_of_type_Int) {
                k = i;
              }
            }
          }
        }
      }
      else
      {
        localObject2 = paramArrayOfFile;
        if (k <= 0) {
          continue;
        }
        localObject2 = localEntityManager;
        localObject3 = new File[paramArrayOfFile.length - k];
        paramInt = 0;
        i = m;
        localObject2 = localEntityManager;
        if (i >= paramArrayOfFile.length) {
          continue;
        }
        localObject2 = localEntityManager;
        if (paramInt >= localObject3.length) {
          continue;
        }
        if (paramArrayOfFile[i] == null) {
          break label597;
        }
        j = paramInt + 1;
        localObject3[paramInt] = paramArrayOfFile[i];
        paramInt = j;
        i += 1;
        continue;
      }
      j += 1;
      i = k;
    }
    localObject2 = localObject3;
    localObject3 = localObject2;
    if (localEntityManager != null)
    {
      localEntityManager.a();
      localObject3 = localObject2;
    }
    return localObject3;
  }
  
  public void run()
  {
    int m = 0;
    int j;
    Object localObject2;
    int k;
    int i1;
    try
    {
      String[] arrayOfString = new String[2];
      arrayOfString[0] = AppConstants.bn;
      arrayOfString[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
      j = arrayOfString.length;
      i = 0;
      if (i >= j) {
        break label384;
      }
      localObject2 = new File(arrayOfString[i]);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break label868;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 == null) || (localObject2.length <= 3000)) {
        break label868;
      }
      k = localObject2.length;
      n = localObject2.length;
      this.jdField_a_of_type_Int = (k - 2500);
      localObject2 = a((File[])localObject2);
      n = n - localObject2.length + 0;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache. after delTemporaryQQHead. totalCount=" + k + ", currNeedDelCount=" + this.jdField_a_of_type_Int + ", delCount=" + n);
      }
      if (n >= this.jdField_a_of_type_Int) {
        break label868;
      }
      Arrays.sort((Object[])localObject2, new zwr(this));
      i1 = localObject2.length;
      localObject2 = a((File[])localObject2, n);
      n += i1 - localObject2.length;
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 2, "onCleanCache. after delSecondaryQQHead. totalCount=" + k + ", currNeedDelCount=" + this.jdField_a_of_type_Int + ", delCount=" + n);
      }
      if (n >= this.jdField_a_of_type_Int) {
        break label868;
      }
      n = a((File[])localObject2, n);
      if (!QLog.isColorLevel()) {
        break label868;
      }
      QLog.d("QQInitHandler", 2, "onCleanCache. after delRemainQQHead. totalCount=" + k + ", currNeedDelCount=" + this.jdField_a_of_type_Int + ", delCount=" + n);
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    label368:
    CleanCache.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache).a(40001, true, null);
    return;
    label384:
    Object localObject1 = new String[2];
    localObject1[0] = AppConstants.bp;
    localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_stranger/";
    int n = localObject1.length;
    int i = 0;
    label411:
    if (i < n)
    {
      localObject2 = new File(localObject1[i]);
      if ((!((File)localObject2).exists()) || (!((File)localObject2).isDirectory())) {
        break label896;
      }
      localObject2 = ((File)localObject2).listFiles();
      if ((localObject2 == null) || (localObject2.length <= 300)) {
        break label896;
      }
      Arrays.sort((Object[])localObject2, new zws(this));
      i1 = localObject2.length;
      j = 0;
      k = 0;
    }
    for (;;)
    {
      if (j < i1)
      {
        Object localObject3 = localObject2[j];
        if (!localObject3.exists()) {
          break label875;
        }
        localObject3.delete();
      }
      for (;;)
      {
        if (!QLog.isColorLevel()) {
          break label896;
        }
        QLog.d("QQInitHandler", 2, "onCleanCache. delete stranger head...");
        break label896;
        localObject1 = new File[7];
        localObject1[0] = URLDrawableHelper.a;
        localObject1[1] = new File(AppConstants.aK + "photo");
        localObject1[2] = new File(AppConstants.aK + this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache.a() + "/ptt/");
        localObject1[3] = new File(AppConstants.aK + "shortvideo/thumbs");
        localObject1[4] = new File(AppConstants.aK + "ptv_template");
        localObject1[5] = new File(AppConstants.aK + "head/" + File.separator + "_dynamic");
        localObject1[6] = new File(AppConstants.aK + "AR_MAP");
        k = localObject1.length;
        j = 0;
        i = m;
        while (i < k)
        {
          j += a(localObject1[i]);
          i += 1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 2, "onCleanCache. delete " + j + " cache file(s)");
        }
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache.e();
        a();
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache.d();
        CleanCache.a(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorStepCleanCache);
        break label368;
        label868:
        i += 1;
        break;
        label875:
        localObject2[j] = null;
        k += 1;
        if (i1 - k > 20) {
          break label903;
        }
      }
      label896:
      i += 1;
      break label411;
      label903:
      j += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zwq
 * JD-Core Version:    0.7.0.1
 */