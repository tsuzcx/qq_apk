package com.tencent.mobileqq.app.face;

import accg;
import acdt;
import acdu;
import acfd;
import acms;
import acpr;
import ajdo.a;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import apuh;
import aqdm;
import aqgz;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import jkm;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

public class GroupIconHelper
  extends acfd
  implements ajdo.a, Handler.Callback
{
  private static boolean bJQ;
  private accg jdField_a_of_type_Accg;
  private CheckDisIconThread jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread;
  private b jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$b;
  AtomicInteger aG = new AtomicInteger(0);
  private Set<String> bW;
  private Set<String> bX;
  private Object cG = new Object();
  private int cyR = 60000;
  private int cyS = 90000;
  int cyT;
  private HashMap<String, a> jk;
  private String qY;
  private Hashtable<String, Long> s;
  ConcurrentLinkedQueue<GenerateIconRunner> x = new ConcurrentLinkedQueue();
  
  public GroupIconHelper(String paramString, accg paramaccg)
  {
    this.qY = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create GroupIconHelper For [" + this.qY + "]");
    }
    paramString = paramaccg.app;
    this.jk = new HashMap();
    this.s = new Hashtable();
    this.bW = new HashSet();
    this.bX = new HashSet();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$b = new b(paramString.getApp().getMainLooper(), this, null);
    this.jdField_a_of_type_Accg = paramaccg;
    paramString.execute(new CheckIsLowPerformanceMachineRunner());
    ThreadManagerV2.executeOnSubThread(new GroupIconHelper.1(this, paramString));
    if ((this.jdField_a_of_type_Accg instanceof acdt))
    {
      this.cyT = 101;
      return;
    }
    this.cyT = 113;
  }
  
  private void FT(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$b.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$b.obtainMessage(9527, paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$b.sendMessageDelayed(paramString, 300L);
  }
  
  private Pair<Boolean, Bitmap> a(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if ((paramString1 == null) || (paramString1.length() <= 1))
    {
      i = 1;
      if (!paramBoolean2) {
        return Pair.create(Boolean.valueOf(false), null);
      }
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool = true;
    float f2 = BaseApplicationImpl.getApplication().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    int k = (int)(50.0F * f1 + 0.5D);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f1 + ";imageWidth=" + k + ",hasPstnIcon: " + paramBoolean1 + ", hasRealPhoneUser: " + paramBoolean2);
    }
    if (i == 0) {}
    for (String[] arrayOfString = paramString1.split(";");; arrayOfString = null)
    {
      i = 0;
      int j;
      if (arrayOfString != null)
      {
        if (arrayOfString.length > 4) {
          i = 4;
        }
      }
      else
      {
        if ((i >= 4) || (!paramBoolean1)) {
          break label536;
        }
        paramString1 = jkm.a(localQQAppInterface, paramString2, 3000, 4 - i);
        if ((paramString1 == null) || (paramString1.size() <= 0)) {
          break label529;
        }
        j = paramString1.size();
      }
      for (;;)
      {
        synchronized (this.bW)
        {
          this.bW.add(paramString2);
          j += i;
          ??? = new Bitmap[j];
          j = 0;
          paramBoolean1 = bool;
          if (j < i)
          {
            String str = arrayOfString[j];
            Pair localPair = localQQAppInterface.a(str, (byte)5, 0, 0);
            if (!((Boolean)localPair.first).booleanValue())
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + paramString2 + ", uin=" + str);
              }
              paramArrayList.remove(str);
              paramBoolean1 = false;
            }
            ???[j] = ((Bitmap)localPair.second);
            j += 1;
            continue;
            i = arrayOfString.length;
          }
        }
        if ((paramString1 != null) && (paramString1.size() > 0))
        {
          j = 0;
          while (j < paramString1.size())
          {
            ???[(j + i)] = ((Bitmap)paramString1.get(j));
            j += 1;
          }
        }
        try
        {
          paramString1 = a(k, (Bitmap[])???);
          return Pair.create(Boolean.valueOf(paramBoolean1), paramString1);
        }
        catch (Throwable paramString1)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon fail, disUin=" + paramString2 + ", throwable : " + paramString1.toString());
            }
            paramBoolean1 = false;
            paramString1 = null;
          }
        }
        label529:
        j = i;
        continue;
        label536:
        paramString1 = null;
        j = i;
      }
    }
  }
  
  /* Error */
  private Pair<Boolean, Boolean> a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, String paramString3, QQAppInterface paramQQAppInterface, byte paramByte, String paramString4, File paramFile, boolean paramBoolean4, Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 17
    //   3: aconst_null
    //   4: astore 16
    //   6: aconst_null
    //   7: astore 18
    //   9: iload_3
    //   10: ifeq +297 -> 307
    //   13: iconst_1
    //   14: istore 13
    //   16: iload 13
    //   18: istore 5
    //   20: aload 18
    //   22: astore 10
    //   24: aload 17
    //   26: astore 14
    //   28: aload 16
    //   30: astore 15
    //   32: aload_0
    //   33: getfield 131	com/tencent/mobileqq/app/face/GroupIconHelper:bX	Ljava/util/Set;
    //   36: ifnull +50 -> 86
    //   39: aload 17
    //   41: astore 14
    //   43: aload 16
    //   45: astore 15
    //   47: aload_0
    //   48: getfield 131	com/tencent/mobileqq/app/face/GroupIconHelper:bX	Ljava/util/Set;
    //   51: astore 10
    //   53: aload 17
    //   55: astore 14
    //   57: aload 16
    //   59: astore 15
    //   61: aload 10
    //   63: monitorenter
    //   64: aload_0
    //   65: getfield 131	com/tencent/mobileqq/app/face/GroupIconHelper:bX	Ljava/util/Set;
    //   68: aload_2
    //   69: invokeinterface 279 2 0
    //   74: pop
    //   75: aload 10
    //   77: monitorexit
    //   78: aload 18
    //   80: astore 10
    //   82: iload 13
    //   84: istore 5
    //   86: aload 10
    //   88: astore 14
    //   90: aload 10
    //   92: astore 15
    //   94: invokestatic 320	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   97: ifeq +90 -> 187
    //   100: aload 10
    //   102: astore 14
    //   104: aload 10
    //   106: astore 15
    //   108: ldc 89
    //   110: iconst_4
    //   111: new 91	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 92	java/lang/StringBuilder:<init>	()V
    //   118: ldc_w 322
    //   121: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: iload 5
    //   126: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   129: ldc_w 324
    //   132: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_2
    //   136: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 324
    //   142: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_1
    //   146: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 324
    //   152: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: aload 6
    //   157: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: ldc_w 326
    //   163: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload_3
    //   167: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 328
    //   173: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: iload 4
    //   178: invokevirtual 255	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   187: iload 8
    //   189: iconst_3
    //   190: if_icmpne +273 -> 463
    //   193: aload 10
    //   195: astore 14
    //   197: aload 10
    //   199: astore 15
    //   201: aload 12
    //   203: bipush 50
    //   205: bipush 50
    //   207: invokestatic 335	com/tencent/mobileqq/app/QQAppInterface:getCircleFaceBitmap	(Landroid/graphics/Bitmap;II)Landroid/graphics/Bitmap;
    //   210: astore_1
    //   211: aload 10
    //   213: astore 14
    //   215: aload 10
    //   217: astore 15
    //   219: aload 7
    //   221: aload 9
    //   223: aload_1
    //   224: iconst_2
    //   225: invokevirtual 339	com/tencent/mobileqq/app/QQAppInterface:putBitmapToCache	(Ljava/lang/String;Landroid/graphics/Bitmap;B)V
    //   228: iload 5
    //   230: istore_3
    //   231: aload 10
    //   233: ifnull +11 -> 244
    //   236: aload 10
    //   238: invokevirtual 344	java/io/BufferedOutputStream:close	()V
    //   241: iload 5
    //   243: istore_3
    //   244: iload_3
    //   245: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   248: iload 11
    //   250: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   253: invokestatic 211	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   256: astore_2
    //   257: aload_2
    //   258: areturn
    //   259: astore_1
    //   260: aload 10
    //   262: monitorexit
    //   263: aload 17
    //   265: astore 14
    //   267: aload 16
    //   269: astore 15
    //   271: aload_1
    //   272: athrow
    //   273: astore_1
    //   274: iconst_0
    //   275: istore 4
    //   277: iload 4
    //   279: istore_3
    //   280: aload 14
    //   282: ifnull -38 -> 244
    //   285: aload 14
    //   287: invokevirtual 344	java/io/BufferedOutputStream:close	()V
    //   290: iload 4
    //   292: istore_3
    //   293: goto -49 -> 244
    //   296: astore_1
    //   297: aload_1
    //   298: invokevirtual 347	java/lang/Throwable:printStackTrace	()V
    //   301: iload 4
    //   303: istore_3
    //   304: goto -60 -> 244
    //   307: aload 10
    //   309: ifnonnull +76 -> 385
    //   312: aload 17
    //   314: astore 14
    //   316: aload 16
    //   318: astore 15
    //   320: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   323: ifeq +20 -> 343
    //   326: aload 17
    //   328: astore 14
    //   330: aload 16
    //   332: astore 15
    //   334: ldc 89
    //   336: iconst_2
    //   337: ldc_w 349
    //   340: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   343: aload 17
    //   345: astore 14
    //   347: aload 16
    //   349: astore 15
    //   351: iload 5
    //   353: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   356: iconst_0
    //   357: invokestatic 205	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   360: invokestatic 211	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   363: astore_1
    //   364: aload_1
    //   365: astore_2
    //   366: iconst_0
    //   367: ifeq -110 -> 257
    //   370: new 351	java/lang/NullPointerException
    //   373: dup
    //   374: invokespecial 352	java/lang/NullPointerException:<init>	()V
    //   377: athrow
    //   378: astore_2
    //   379: aload_2
    //   380: invokevirtual 347	java/lang/Throwable:printStackTrace	()V
    //   383: aload_1
    //   384: areturn
    //   385: aload 17
    //   387: astore 14
    //   389: aload 16
    //   391: astore 15
    //   393: aload 10
    //   395: invokevirtual 357	java/io/File:exists	()Z
    //   398: ifne +17 -> 415
    //   401: aload 17
    //   403: astore 14
    //   405: aload 16
    //   407: astore 15
    //   409: aload 10
    //   411: invokevirtual 360	java/io/File:createNewFile	()Z
    //   414: pop
    //   415: aload 17
    //   417: astore 14
    //   419: aload 16
    //   421: astore 15
    //   423: new 341	java/io/BufferedOutputStream
    //   426: dup
    //   427: new 362	java/io/FileOutputStream
    //   430: dup
    //   431: aload 10
    //   433: invokespecial 365	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   436: invokespecial 368	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   439: astore 10
    //   441: aload 12
    //   443: getstatic 374	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   446: bipush 90
    //   448: aload 10
    //   450: invokevirtual 378	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   453: istore 5
    //   455: aload 10
    //   457: invokevirtual 381	java/io/BufferedOutputStream:flush	()V
    //   460: goto -374 -> 86
    //   463: aload 12
    //   465: astore_1
    //   466: iload 8
    //   468: iconst_1
    //   469: if_icmpne -258 -> 211
    //   472: aload 10
    //   474: astore 14
    //   476: aload 10
    //   478: astore 15
    //   480: aload 12
    //   482: getstatic 386	aqhu:dZk	I
    //   485: bipush 50
    //   487: bipush 50
    //   489: invokestatic 389	com/tencent/mobileqq/app/QQAppInterface:b	(Landroid/graphics/Bitmap;III)Landroid/graphics/Bitmap;
    //   492: astore_1
    //   493: goto -282 -> 211
    //   496: astore_1
    //   497: aload_1
    //   498: invokevirtual 347	java/lang/Throwable:printStackTrace	()V
    //   501: iload 5
    //   503: istore_3
    //   504: goto -260 -> 244
    //   507: astore_1
    //   508: aload 15
    //   510: astore 10
    //   512: aload 10
    //   514: ifnull +8 -> 522
    //   517: aload 10
    //   519: invokevirtual 344	java/io/BufferedOutputStream:close	()V
    //   522: aload_1
    //   523: athrow
    //   524: astore_2
    //   525: aload_2
    //   526: invokevirtual 347	java/lang/Throwable:printStackTrace	()V
    //   529: goto -7 -> 522
    //   532: astore_1
    //   533: goto -21 -> 512
    //   536: astore_1
    //   537: aload 10
    //   539: astore 14
    //   541: goto -267 -> 274
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	544	0	this	GroupIconHelper
    //   0	544	1	paramString1	String
    //   0	544	2	paramString2	String
    //   0	544	3	paramBoolean1	boolean
    //   0	544	4	paramBoolean2	boolean
    //   0	544	5	paramBoolean3	boolean
    //   0	544	6	paramString3	String
    //   0	544	7	paramQQAppInterface	QQAppInterface
    //   0	544	8	paramByte	byte
    //   0	544	9	paramString4	String
    //   0	544	10	paramFile	File
    //   0	544	11	paramBoolean4	boolean
    //   0	544	12	paramBitmap	Bitmap
    //   14	69	13	bool	boolean
    //   26	514	14	localObject1	Object
    //   30	479	15	localObject2	Object
    //   4	416	16	localObject3	Object
    //   1	415	17	localObject4	Object
    //   7	72	18	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   64	78	259	finally
    //   260	263	259	finally
    //   32	39	273	java/lang/Throwable
    //   47	53	273	java/lang/Throwable
    //   61	64	273	java/lang/Throwable
    //   94	100	273	java/lang/Throwable
    //   108	187	273	java/lang/Throwable
    //   201	211	273	java/lang/Throwable
    //   219	228	273	java/lang/Throwable
    //   271	273	273	java/lang/Throwable
    //   320	326	273	java/lang/Throwable
    //   334	343	273	java/lang/Throwable
    //   351	364	273	java/lang/Throwable
    //   393	401	273	java/lang/Throwable
    //   409	415	273	java/lang/Throwable
    //   423	441	273	java/lang/Throwable
    //   480	493	273	java/lang/Throwable
    //   285	290	296	java/lang/Throwable
    //   370	378	378	java/lang/Throwable
    //   236	241	496	java/lang/Throwable
    //   32	39	507	finally
    //   47	53	507	finally
    //   61	64	507	finally
    //   94	100	507	finally
    //   108	187	507	finally
    //   201	211	507	finally
    //   219	228	507	finally
    //   271	273	507	finally
    //   320	326	507	finally
    //   334	343	507	finally
    //   351	364	507	finally
    //   393	401	507	finally
    //   409	415	507	finally
    //   423	441	507	finally
    //   480	493	507	finally
    //   517	522	524	java/lang/Throwable
    //   441	460	532	finally
    //   441	460	536	java/lang/Throwable
  }
  
  private a a(String paramString, boolean paramBoolean1, a parama, boolean paramBoolean2)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject1;
    if (this.cyT == 101)
    {
      localObject1 = ((acdu)localQQAppInterface.getManager(53)).A(paramString);
      if (QLog.isColorLevel())
      {
        if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
          break label227;
        }
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
      label87:
      if ((localObject1 != null) && (((ArrayList)localObject1).size() != 0)) {
        break label358;
      }
    }
    label227:
    label358:
    for (parama.faceCount = 0;; parama.faceCount = ((ArrayList)localObject1).size())
    {
      localObject1 = b((ArrayList)localObject1, paramBoolean2);
      parama.faceUinSet = ((String)localObject1);
      a(paramString, paramBoolean1, parama, localQQAppInterface, (String)localObject1);
      return parama;
      localObject1 = (TroopManager)localQQAppInterface.getManager(52);
      Object localObject2 = ((TroopManager)localObject1).D(paramString);
      Object localObject3 = ((TroopManager)localObject1).c(paramString);
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject1 = localObject2;
      if (((ArrayList)localObject2).size() != 0) {
        break;
      }
      localObject1 = localObject2;
      if (((TroopInfo)localObject3).wMemberNum <= 1) {
        break;
      }
      localObject1 = localObject2;
      if (this.jdField_a_of_type_Accg == null) {
        break;
      }
      ((acms)this.jdField_a_of_type_Accg).hS(Long.parseLong(paramString));
      localObject1 = localObject2;
      break;
      localObject2 = new StringBuilder();
      localObject3 = ((ArrayList)localObject1).iterator();
      if (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if ((str != null) && (str.length() > 5)) {
          ((StringBuilder)localObject2).append(str.substring(0, 4));
        }
        for (;;)
        {
          ((StringBuilder)localObject2).append(";");
          break;
          ((StringBuilder)localObject2).append(str);
        }
      }
      QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is:" + ((StringBuilder)localObject2).toString());
      break label87;
    }
  }
  
  public static ArrayList<String> a(ArrayList<String> paramArrayList, TroopInfo paramTroopInfo)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (paramTroopInfo == null))
    {
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins memberUinList is null");
      return paramArrayList;
    }
    if (paramTroopInfo == null)
    {
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins troopInfo is null");
      return paramArrayList;
    }
    paramArrayList = (ArrayList)paramArrayList.clone();
    String str = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    apuh.mT(paramArrayList);
    if (paramTroopInfo.wMemberNumClient <= 4) {
      if (!paramArrayList.contains(str)) {
        paramArrayList.add(str);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, discussionUin=" + paramTroopInfo.troopuin + ",NumClient=" + paramTroopInfo.wMemberNumClient + ",memberUinSize=" + paramArrayList);
      }
      return paramArrayList;
      paramArrayList.remove(str);
    }
  }
  
  private void a(GenerateIconRunner paramGenerateIconRunner)
  {
    this.x.offer(paramGenerateIconRunner);
    runNext();
  }
  
  private void a(String paramString, a parama, boolean paramBoolean)
  {
    if (parama.aX == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + parama.tR.size() + ", totalCount=" + parama.faceCount);
      }
      return;
    }
    Object localObject1 = b(parama.faceUinSet, paramString, parama.tR, parama.bJR, parama.bJT);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    Object localObject2 = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      parama.cyU += 1;
      str = b(parama.tR, paramBoolean);
      parama.bqx = str;
      localObject1 = null;
      if (this.cyT == 101)
      {
        localObject1 = (acdu)((QQAppInterface)localObject2).getManager(53);
        if (localObject1 == null) {
          break label642;
        }
      }
    }
    label642:
    for (localObject1 = ((acdu)localObject1).a(paramString);; localObject1 = null)
    {
      Object localObject3;
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = str;
        localObject3 = ((QQAppInterface)localObject2).a().createEntityManager();
        ((EntityManager)localObject3).update((Entity)localObject1);
        ((EntityManager)localObject3).close();
        if (QLog.isColorLevel()) {
          localObject1 = ((DiscussionInfo)localObject1).discussionName;
        }
      }
      for (;;)
      {
        if ((parama.tR.size() >= parama.faceCount) && (bool2)) {
          parama.aX = 3;
        }
        if ((this.jdField_a_of_type_Accg instanceof acdt)) {
          if (parama.bJR) {
            ((acdt)this.jdField_a_of_type_Accg).k(bool1, bool2, jy(paramString));
          }
        }
        for (;;)
        {
          if (!QLog.isColorLevel()) {
            break label572;
          }
          localObject2 = localObject1;
          if (localObject1 != null)
          {
            localObject2 = localObject1;
            if (((String)localObject1).length() > 3) {
              localObject2 = ((String)localObject1).substring(0, 2) + "." + ((String)localObject1).charAt(((String)localObject1).length() - 1);
            }
          }
          QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: uin=" + paramString + ", name=" + (String)localObject2 + ", isComplete=" + bool2 + ", newFaceUinSet=" + str + parama.toString());
          return;
          localObject3 = (TroopManager)((QQAppInterface)localObject2).getManager(52);
          TroopInfo localTroopInfo = ((TroopManager)localObject3).c(paramString);
          if (localTroopInfo == null) {
            break;
          }
          localTroopInfo.mHeaderUinsOld = str;
          ((TroopManager)localObject3).i(localTroopInfo);
          localObject1 = localTroopInfo.getTroopName();
          break;
          ((acdt)this.jdField_a_of_type_Accg).k(bool1, bool2, paramString);
          ((QQAppInterface)localObject2).k(101, paramString, 0, ((QQAppInterface)localObject2).getCustomFaceFilePath(101, paramString, 0));
          continue;
          if ((this.jdField_a_of_type_Accg instanceof acms))
          {
            ((acms)this.jdField_a_of_type_Accg).l(bool1, bool2, paramString);
            ((QQAppInterface)localObject2).k(113, paramString, 0, ((QQAppInterface)localObject2).getCustomFaceFilePath(113, paramString, 0));
          }
        }
        label572:
        break;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + parama.tR.size() + ", totalCount=" + parama.faceCount);
        return;
        localObject1 = null;
      }
    }
  }
  
  private void a(String paramString1, boolean paramBoolean, a parama, QQAppInterface paramQQAppInterface, String paramString2)
  {
    Object localObject2;
    if (paramBoolean)
    {
      localObject2 = null;
      if (this.cyT != 101) {
        break label89;
      }
      paramString1 = ((acdu)paramQQAppInterface.getManager(53)).a(paramString1);
      if (paramString1 == null) {
        break label216;
      }
    }
    label216:
    for (paramString1 = paramString1.faceUinSet;; paramString1 = null)
    {
      Object localObject1 = paramString1;
      if (((localObject1 == null) || ("".equals(((String)localObject1).trim()))) && ((paramString2 == null) || ("".equals(paramString2.trim())))) {
        paramBoolean = false;
      }
      for (;;)
      {
        parama.isChanged = paramBoolean;
        return;
        label89:
        localObject1 = localObject2;
        if (this.cyT != 113) {
          break;
        }
        paramString1 = ((TroopManager)paramQQAppInterface.getManager(52)).c(paramString1);
        localObject1 = localObject2;
        if (paramString1 == null) {
          break;
        }
        localObject1 = paramString1.mHeaderUinsOld;
        break;
        if ((paramString2 != null) && (!paramString2.equals(localObject1))) {
          paramBoolean = true;
        } else if ((localObject1 != null) && (!((String)localObject1).equals(paramString2))) {
          paramBoolean = true;
        } else if ((parama.aX == 2) && (paramString2 != null) && (!paramString2.equals(parama.bqx)) && (parama.bnK)) {
          paramBoolean = true;
        } else {
          paramBoolean = false;
        }
      }
    }
  }
  
  private boolean a(String paramString1, boolean paramBoolean1, boolean paramBoolean2, QQAppInterface paramQQAppInterface, String paramString2, File paramFile)
  {
    if ((paramString1 != null) && (paramString1.trim().length() <= 0))
    {
      if ((paramFile != null) && (paramFile.exists()) && (paramFile.isFile())) {
        paramFile.delete();
      }
      if ((!paramBoolean1) || ((paramBoolean1) && (!paramBoolean2)))
      {
        paramString1 = null;
        if (this.cyT == 101) {
          paramString1 = aqhu.aN();
        }
        for (;;)
        {
          if (paramString1 != null) {
            paramQQAppInterface.putBitmapToCache(paramString2, paramString1, (byte)2);
          }
          return true;
          if (this.cyT == 113) {
            paramString1 = aqhu.aN();
          }
        }
      }
    }
    return false;
  }
  
  public static boolean abX()
  {
    return bJQ;
  }
  
  public static ArrayList<String> ac(ArrayList<String> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()))
    {
      QLog.d("Q.qqhead.dih", 2, "handleDiscussionSecHeadUins memberUinList is null");
      return paramArrayList;
    }
    ArrayList localArrayList = (ArrayList)paramArrayList.clone();
    int i = paramArrayList.size();
    paramArrayList = BaseApplicationImpl.getApplication().getRuntime().getAccount();
    if (i <= 4) {
      if (!localArrayList.contains(paramArrayList)) {
        localArrayList.add(paramArrayList);
      }
    }
    for (;;)
    {
      paramArrayList = localArrayList;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.qqhead.dih", 2, "handleNewGroupSecHeadUins, memberUinSize=" + localArrayList.size());
      return localArrayList;
      localArrayList.remove(paramArrayList);
    }
  }
  
  private Pair<Boolean, Boolean> b(String paramString1, String paramString2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramString2 == null) || ((paramString1 == null) && (!paramBoolean2))) {
      return Pair.create(Boolean.valueOf(false), Boolean.valueOf(false));
    }
    String str1 = null;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    if (!paramBoolean1) {
      str1 = localQQAppInterface.getCustomFaceFilePath(this.cyT, paramString2, 0);
    }
    byte b = aqdm.c((byte)1);
    String str2 = localQQAppInterface.getFaceBitmapCacheKey(this.cyT, paramString2, b, 0);
    if (paramBoolean1) {
      str2 = localQQAppInterface.getFaceBitmapCacheKey(1001, jy(paramString2), b, 0);
    }
    File localFile = null;
    if (!TextUtils.isEmpty(str1)) {
      localFile = new File(str1);
    }
    if (a(paramString1, paramBoolean1, paramBoolean2, localQQAppInterface, str2, localFile)) {
      return Pair.create(Boolean.valueOf(true), Boolean.valueOf(true));
    }
    boolean bool1 = true;
    try
    {
      Pair localPair = a(paramString1, paramString2, paramArrayList, paramBoolean1, paramBoolean2);
      paramArrayList = (Bitmap)localPair.second;
      boolean bool2 = ((Boolean)localPair.first).booleanValue();
      bool1 = bool2;
    }
    catch (Throwable paramArrayList)
    {
      for (;;)
      {
        paramArrayList = null;
      }
    }
    if (paramArrayList == null) {
      return Pair.create(Boolean.valueOf(false), Boolean.valueOf(false));
    }
    return a(paramString1, paramString2, paramBoolean1, paramBoolean2, false, str1, localQQAppInterface, b, str2, localFile, bool1, paramArrayList);
  }
  
  public static String b(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    int j = 0;
    StringBuilder localStringBuilder;
    int i;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localStringBuilder = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      i = 0;
      while (i < arrayOfString.length)
      {
        arrayOfString[i] = ((String)paramArrayList.get(i));
        i += 1;
      }
      Arrays.sort(arrayOfString, d());
      int k = 0;
      i = j;
      j = k;
      if (i < arrayOfString.length)
      {
        localStringBuilder.append(arrayOfString[i]).append(";");
        j += 1;
        if ((!paramBoolean) || (!abX()) || (j < 4)) {
          break label178;
        }
      }
    }
    label128:
    for (paramArrayList = localStringBuilder.toString();; paramArrayList = " ")
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "createFaceUinSet, ret=" + paramArrayList + ",sureChanged=" + paramBoolean);
      }
      return paramArrayList;
      label178:
      if (j >= 4) {
        break label128;
      }
      i += 1;
      break;
    }
  }
  
  public static Comparator<String> d()
  {
    return new acpr();
  }
  
  public static String jy(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===getPstnDiscussionUin discussionUin is null ===");
      return null;
    }
    return paramString + "_" + 1001;
  }
  
  public static String jz(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is null ===");
      return null;
    }
    int i = paramString.indexOf("_");
    if ((i < 0) || (i > paramString.length()))
    {
      QLog.i("Q.qqhead.dih", 1, "===getDiscussionUinFromPstn pstnDiscussionUin is invalid, pstnDiscussionUin | " + paramString);
      return null;
    }
    return paramString.substring(0, i);
  }
  
  public static boolean kH(String paramString)
  {
    boolean bool = true;
    if ((paramString == null) || (paramString.length() == 0))
    {
      QLog.i("Q.qqhead.dih", 1, "===isPstnDiscussionUin discussionUin is null ===");
      bool = false;
    }
    while (paramString.contains("_1001")) {
      return bool;
    }
    return false;
  }
  
  private void runNext()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "runNext: mRunningTaskNum=" + this.aG.get() + ", queueSize=" + this.x.size());
    }
    if (this.aG.get() < 3)
    {
      GenerateIconRunner localGenerateIconRunner = (GenerateIconRunner)this.x.poll();
      if (localGenerateIconRunner != null)
      {
        this.aG.incrementAndGet();
        ThreadManager.post(localGenerateIconRunner, 10, null, true);
      }
    }
  }
  
  private boolean y(String paramString, boolean paramBoolean)
  {
    label390:
    for (;;)
    {
      synchronized (this.jk)
      {
        long l = System.currentTimeMillis();
        a locala;
        if (this.jk.containsKey(paramString))
        {
          locala = (a)this.jk.get(paramString);
          if (locala.aX == 3)
          {
            bool = true;
            if (((!bool) && (l - locala.startTime < this.cyS)) || ((bool) && (!paramBoolean) && (l - locala.startTime < 3600000L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo notDo, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",startTime=" + locala.startTime + ",state=" + locala.aX);
              }
              return false;
            }
            if ((QLog.isColorLevel()) && (!bool)) {
              QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo reset, disUin=" + paramString + ",isFromCreate=" + paramBoolean + ",isRealCreated=" + bool + ",state=" + locala.aX);
            }
            locala.i(locala.aX);
            if (kH(paramString))
            {
              QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
              locala.bJR = true;
              locala.bJT = jkm.a(localQQAppInterface, jz(paramString), 3000);
            }
            locala.startTime = l;
            this.jk.put(paramString, locala);
            return true;
          }
        }
        else
        {
          locala = new a(null);
          this.jk.put(paramString, locala);
          if (!QLog.isColorLevel()) {
            break label390;
          }
          QLog.d("Q.qqhead.dih", 2, "putDiscussionIconInfo  not hit, disUin=" + paramString);
        }
      }
      boolean bool = false;
    }
  }
  
  public void FP(String paramString)
  {
    boolean bool = y(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + paramString + ", isNeedToDo=" + bool);
    }
    if (bool) {
      FT(paramString);
    }
  }
  
  public void FQ(String paramString)
  {
    boolean bool = y(paramString, false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + paramString + ", isNeedToDo=" + bool);
      }
      a(new GenerateIconRunner(1, paramString));
    }
  }
  
  public void FR(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.s.containsKey(paramString)) && (l - ((Long)this.s.get(paramString)).longValue() < this.cyR)) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon repeat: " + paramString);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + paramString);
      }
      this.s.put(paramString, Long.valueOf(l));
      a(new GenerateIconRunner(3, paramString));
    } while ((this.bX == null) || (!this.bX.contains(paramString)));
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "refreshDisIcon mDisCallUinSet has it " + paramString);
    }
    synchronized (this.bX)
    {
      this.bX.remove(paramString);
      FU(paramString);
      return;
    }
  }
  
  public void FS(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "removeDiscussion: " + paramString);
    }
    synchronized (this.jk)
    {
      this.jk.remove(paramString);
      return;
    }
  }
  
  public void FU(String paramString)
  {
    String str = jy(paramString);
    if (this.jk.containsKey(str))
    {
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      FS(str);
      localQQAppInterface.ED(localQQAppInterface.getFaceBitmapCacheKey(1001, jy(paramString), (byte)1, 0));
      FP(str);
    }
  }
  
  public void FV(String paramString)
  {
    ??? = jkm.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramString, 3000);
    if (((??? == null) || (((String)???).length() == 0)) && (this.bW.contains(paramString))) {}
    synchronized (this.bW)
    {
      this.bW.remove(paramString);
      FU(paramString);
      return;
    }
  }
  
  public void T(boolean paramBoolean, int paramInt) {}
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: iload_1
    //   1: aload_2
    //   2: invokestatic 871	aqeq:b	(I[Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   5: astore_2
    //   6: aload_2
    //   7: astore_3
    //   8: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +20 -> 31
    //   14: aload_2
    //   15: astore_3
    //   16: aload_2
    //   17: ifnonnull +14 -> 31
    //   20: ldc 89
    //   22: iconst_2
    //   23: ldc_w 873
    //   26: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   29: aload_2
    //   30: astore_3
    //   31: aload_3
    //   32: areturn
    //   33: astore 4
    //   35: aconst_null
    //   36: astore_2
    //   37: aload_2
    //   38: astore_3
    //   39: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   42: ifeq -11 -> 31
    //   45: ldc 89
    //   47: iconst_2
    //   48: aload 4
    //   50: invokevirtual 874	java/lang/Exception:toString	()Ljava/lang/String;
    //   53: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_2
    //   57: areturn
    //   58: astore 4
    //   60: aconst_null
    //   61: astore_2
    //   62: aload_2
    //   63: astore_3
    //   64: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   67: ifeq -36 -> 31
    //   70: ldc 89
    //   72: iconst_2
    //   73: aload 4
    //   75: invokevirtual 875	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   78: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   81: aload_2
    //   82: areturn
    //   83: astore 4
    //   85: aconst_null
    //   86: astore_2
    //   87: aload_2
    //   88: astore_3
    //   89: invokestatic 87	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   92: ifeq -61 -> 31
    //   95: ldc 89
    //   97: iconst_2
    //   98: aload 4
    //   100: invokevirtual 876	java/lang/Error:toString	()Ljava/lang/String;
    //   103: invokestatic 331	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   106: aload_2
    //   107: areturn
    //   108: astore 4
    //   110: goto -23 -> 87
    //   113: astore 4
    //   115: goto -53 -> 62
    //   118: astore 4
    //   120: goto -83 -> 37
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	123	0	this	GroupIconHelper
    //   0	123	1	paramInt	int
    //   0	123	2	paramArrayOfBitmap	Bitmap[]
    //   7	82	3	arrayOfBitmap	Bitmap[]
    //   33	16	4	localException1	Exception
    //   58	16	4	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   83	16	4	localError1	java.lang.Error
    //   108	1	4	localError2	java.lang.Error
    //   113	1	4	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   118	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   0	6	33	java/lang/Exception
    //   0	6	58	java/lang/OutOfMemoryError
    //   0	6	83	java/lang/Error
    //   8	14	108	java/lang/Error
    //   20	29	108	java/lang/Error
    //   8	14	113	java/lang/OutOfMemoryError
    //   20	29	113	java/lang/OutOfMemoryError
    //   8	14	118	java/lang/Exception
    //   20	29	118	java/lang/Exception
  }
  
  public void eH(long paramLong) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = (String)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "handleMessage ACTION_GENERATE_DISCUSSION: groupUin=" + paramMessage);
      }
      a(new GenerateIconRunner(2, paramMessage));
    }
  }
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead isSuccess | " + paramBoolean + ", uin=");
    }
    label417:
    label420:
    label423:
    label429:
    for (;;)
    {
      ArrayList localArrayList;
      synchronized (this.jk)
      {
        Iterator localIterator = this.jk.keySet().iterator();
        localArrayList = null;
        if (localIterator.hasNext())
        {
          String str1 = (String)localIterator.next();
          localObject = this.jk.get(str1);
          if ((localObject == null) || (!(localObject instanceof a))) {
            break label423;
          }
          localObject = (a)localObject;
          if ((localObject == null) || (((a)localObject).faceUinSet == null)) {
            continue;
          }
          if (((a)localObject).bJR)
          {
            str2 = ((a)localObject).faceUinSet;
            if ((!paramBoolean) || (!str2.contains(paramString))) {
              break label420;
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead pstn: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            if (((a)localObject).aX != 3)
            {
              ((a)localObject).tR.add(paramString);
              FT(str1);
              break label429;
            }
            if (localArrayList != null) {
              break label417;
            }
            localArrayList = new ArrayList();
            localArrayList.add(str1);
            break label429;
          }
          if (((a)localObject).aX == 3) {
            continue;
          }
          String str2 = ((a)localObject).faceUinSet;
          if ((!paramBoolean) || (!str2.contains(paramString))) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
          }
          ((a)localObject).tR.add(paramString);
          FT(str1);
        }
      }
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        paramString = localArrayList.iterator();
        while (paramString.hasNext()) {
          FU(jz((String)paramString.next()));
        }
      }
      return;
      continue;
      break label429;
      Object localObject = null;
    }
  }
  
  public void release()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "GroupIconHelper release.");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper$CheckDisIconThread.isRunning = false;
    }
    synchronized (this.cG)
    {
      this.cG.notifyAll();
      synchronized (this.jk)
      {
        this.jk.notifyAll();
        Iterator localIterator = this.jk.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          Object localObject4 = this.jk.get(str);
          if ((localObject4 != null) && ((localObject4 instanceof a)))
          {
            localObject4 = (a)localObject4;
            if ((localObject4 != null) && (((a)localObject4).aX != 3) && ((this.jdField_a_of_type_Accg instanceof acdt))) {
              ((acdt)this.jdField_a_of_type_Accg).k(false, true, str);
            }
          }
        }
      }
    }
    this.jk.clear();
    ??? = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    PhoneContactManagerImp localPhoneContactManagerImp = (PhoneContactManagerImp)((QQAppInterface)???).getManager(11);
    if (localPhoneContactManagerImp != null) {
      localPhoneContactManagerImp.b(this);
    }
    ((QQAppInterface)???).removeObserver(this);
    this.jdField_a_of_type_Accg = null;
  }
  
  public void sc(int paramInt) {}
  
  public void sd(int paramInt) {}
  
  public void se(int paramInt)
  {
    if ((paramInt == 1) && (this.bW != null)) {
      for (;;)
      {
        synchronized (this.bW)
        {
          if (this.bW.size() > 0)
          {
            ArrayList localArrayList = new ArrayList(this.bW);
            int i = localArrayList.size();
            paramInt = 0;
            if (paramInt < i)
            {
              String str = (String)localArrayList.get(paramInt);
              if ((str != null) && (str.length() != 0)) {
                FU(str);
              }
            }
            else
            {
              this.bW.clear();
            }
          }
          else
          {
            return;
          }
        }
        paramInt += 1;
      }
    }
  }
  
  class CheckDisIconThread
    implements Runnable
  {
    public boolean isRunning = true;
    
    private CheckDisIconThread() {}
    
    private int a(int paramInt, long paramLong, ArrayList<Pair<String, GroupIconHelper.a>> paramArrayList, ArrayList<String> paramArrayList1, String paramString, GroupIconHelper.a parama)
    {
      boolean bool2 = false;
      boolean bool1 = false;
      int i;
      if ((parama.aX == 1) && (paramLong - parama.startTime >= GroupIconHelper.a(GroupIconHelper.this)))
      {
        paramArrayList1 = paramString;
        if (GroupIconHelper.kH(paramString)) {
          paramArrayList1 = GroupIconHelper.jz(paramString);
        }
        i = parama.tR.size();
        parama.aX = 2;
        if (i > 0)
        {
          if (parama.bqx == null) {
            break label299;
          }
          paramString = GroupIconHelper.b(parama.tR, false);
          if (!parama.bqx.equals(paramString)) {
            break label299;
          }
        }
      }
      for (;;)
      {
        bool2 = bool1;
        if (bool1)
        {
          paramArrayList.add(Pair.create(paramArrayList1, parama));
          GroupIconHelper.a(GroupIconHelper.this).remove(paramArrayList1);
          bool2 = bool1;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "CheckDisIcon expired: " + paramArrayList1 + ", isTryCreate: " + bool2 + parama.toString());
        }
        i = paramInt + 1;
        do
        {
          return i;
          if ((parama.aX == 2) && (paramLong - parama.startTime >= GroupIconHelper.b(GroupIconHelper.this)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "CheckDisIcon timeout: " + paramString + parama.toString());
            }
            paramArrayList1.add(paramString);
            return paramInt + 1;
          }
          i = paramInt;
        } while (parama.aX == 3);
        return paramInt + 1;
        label299:
        bool1 = true;
      }
    }
    
    public void run()
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread start.");
      }
      for (;;)
      {
        if (this.isRunning)
        {
          int i = 0;
          long l = System.currentTimeMillis();
          Object localObject2 = new ArrayList();
          ArrayList localArrayList1 = new ArrayList();
          for (;;)
          {
            String str;
            GroupIconHelper.a locala;
            synchronized (GroupIconHelper.a(GroupIconHelper.this))
            {
              Iterator localIterator = GroupIconHelper.a(GroupIconHelper.this).keySet().iterator();
              if (!localIterator.hasNext()) {
                break;
              }
              str = (String)localIterator.next();
              locala = (GroupIconHelper.a)GroupIconHelper.a(GroupIconHelper.this).get(str);
              if ((locala != null) && (locala.cyU >= 8))
              {
                if ((GroupIconHelper.a(GroupIconHelper.this) instanceof acdt)) {
                  ((acdt)GroupIconHelper.a(GroupIconHelper.this)).k(false, true, str);
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
                QLog.d("Q.qqhead.dih", 2, "CheckDisIcon, maxCreateCnt: " + str + ",crateIconCount=" + locala.cyU);
              }
            }
            if ((locala != null) && (!locala.bnK))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.dih", 2, "CheckDisIcon isFromCreate: " + str + ",fromCreate is false");
              }
            }
            else if ((locala != null) && (locala.faceUinSet != null) && (locala.aX != 3)) {
              i = a(i, l, (ArrayList)localObject2, localArrayList2, str, locala);
            }
          }
          int j;
          if ((this.isRunning) && (localObject2 != null))
          {
            j = 0;
            while ((j < ((ArrayList)localObject2).size()) && (this.isRunning))
            {
              ??? = (Pair)((ArrayList)localObject2).get(j);
              GroupIconHelper.a(GroupIconHelper.this, (String)((Pair)???).first, (GroupIconHelper.a)((Pair)???).second, true);
              j += 1;
            }
          }
          if ((this.isRunning) && (localArrayList2 != null))
          {
            j = 0;
            while ((j < localArrayList2.size()) && (this.isRunning))
            {
              localObject2 = (String)localArrayList2.get(j);
              GroupIconHelper.this.FQ((String)localObject2);
              j += 1;
            }
          }
          if (i != 0) {
            break label502;
          }
        }
        synchronized (GroupIconHelper.a(GroupIconHelper.this))
        {
          GroupIconHelper.a(GroupIconHelper.this, null);
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "CheckDisIconThread exit. isRunning=" + this.isRunning);
          }
          return;
          label502:
          if (!this.isRunning) {}
        }
      }
      try
      {
        label542:
        synchronized (GroupIconHelper.a(GroupIconHelper.this))
        {
          GroupIconHelper.a(GroupIconHelper.this).wait(GroupIconHelper.a(GroupIconHelper.this) / 10);
        }
        localObject4 = finally;
        throw localObject4;
      }
      catch (InterruptedException localInterruptedException)
      {
        break label542;
      }
    }
  }
  
  class CheckIsLowPerformanceMachineRunner
    implements Runnable
  {
    CheckIsLowPerformanceMachineRunner() {}
    
    public void run()
    {
      long l = aqgz.getCpuFrequency();
      int i = aqgz.getCpuNumber();
      if ((l != 0L) && (l < 1024L) && (i <= 1)) {
        GroupIconHelper.aZ(true);
      }
    }
  }
  
  class GenerateIconRunner
    implements Runnable
  {
    private String QE;
    private boolean bJR;
    private int type = 2;
    
    public GenerateIconRunner(int paramInt, String paramString)
    {
      this.type = paramInt;
      this.QE = paramString;
      if (GroupIconHelper.kH(paramString))
      {
        this.QE = GroupIconHelper.jz(paramString);
        this.bJR = true;
      }
    }
    
    private void a(GroupIconHelper.a parama)
    {
      parama = GroupIconHelper.a(GroupIconHelper.this, this.QE, true, parama, false);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CheckAndCreateDisIcon Done: " + this.QE + ", isChanged=" + parama.isChanged);
      }
      if (parama.isChanged)
      {
        if (parama.bJR) {
          GroupIconHelper.a(GroupIconHelper.this, GroupIconHelper.jy(this.QE));
        }
      }
      else {
        return;
      }
      GroupIconHelper.a(GroupIconHelper.this, this.QE);
    }
    
    private void a(GroupIconHelper.a arg1, int paramInt)
    {
      if ((paramInt >= ???.faceCount) || ((???.aX == 1) && (paramInt >= 4) && (???.faceCount > 4)) || ((???.aX == 2) && (paramInt > 0)) || (???.bJT))
      {
        GroupIconHelper.a(GroupIconHelper.this, this.QE, ???, false);
        if (paramInt >= ???.faceCount) {
          GroupIconHelper.a(GroupIconHelper.this).remove(this.QE);
        }
      }
      if ((paramInt < ???.faceCount) && (GroupIconHelper.a(GroupIconHelper.this) == null)) {
        synchronized (GroupIconHelper.a(GroupIconHelper.this))
        {
          if (GroupIconHelper.a(GroupIconHelper.this) == null)
          {
            GroupIconHelper.a(GroupIconHelper.this, new GroupIconHelper.CheckDisIconThread(GroupIconHelper.this, null));
            ThreadManager.post(GroupIconHelper.a(GroupIconHelper.this), 8, null, false);
          }
          return;
        }
      }
    }
    
    private void a(GroupIconHelper.a parama, QQAppInterface paramQQAppInterface)
    {
      parama.bnK = true;
      if (!parama.bJS)
      {
        parama.bJS = true;
        parama.tR.clear();
        if ((parama.faceUinSet != null) && (parama.faceUinSet.length() > 1))
        {
          String[] arrayOfString = parama.faceUinSet.split(";");
          if (arrayOfString != null)
          {
            int j = arrayOfString.length;
            int i = 0;
            if (i < j)
            {
              String str = arrayOfString[i];
              if ((str == null) || (str.length() == 0)) {}
              for (;;)
              {
                i += 1;
                break;
                if (!paramQQAppInterface.isFaceFileExist(1, str, 0)) {
                  ((FriendListHandler)paramQQAppInterface.getBusinessHandler(1)).a(str, (byte)0, (byte)2);
                } else {
                  parama.tR.add(str);
                }
              }
            }
          }
        }
      }
      try
      {
        QLog.d("Q.qqhead.dih", 1, "TYPE_CREAT. disUin=" + this.QE + parama.toString());
        return;
      }
      catch (Exception parama)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e("Q.qqhead.dih", 2, "TYPE_CREAT", parama);
      }
    }
    
    private void cz(QQAppInterface paramQQAppInterface)
    {
      boolean bool = true;
      GroupIconHelper.a locala = new GroupIconHelper.a(GroupIconHelper.this, null);
      locala = GroupIconHelper.a(GroupIconHelper.this, this.QE, true, locala, true);
      if (locala.isChanged) {
        if (GroupIconHelper.a(GroupIconHelper.this).containsKey(this.QE))
        {
          GroupIconHelper.this.FS(this.QE);
          GroupIconHelper.this.FP(this.QE);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + this.QE + ", isChanged=" + locala.isChanged + ", isCreated=" + bool);
        }
        return;
        File localFile = new File(paramQQAppInterface.getCustomFaceFilePath(GroupIconHelper.this.cyT, this.QE, 0));
        if ((localFile != null) && (localFile.exists())) {
          localFile.delete();
        }
        if (paramQQAppInterface != null) {
          paramQQAppInterface.y(GroupIconHelper.this.cyT, this.QE, 0);
        }
        GroupIconHelper.a(GroupIconHelper.this).remove(this.QE);
        bool = false;
        continue;
        GroupIconHelper.a(GroupIconHelper.this).remove(this.QE);
        bool = false;
      }
    }
    
    public void hW()
    {
      if (this.QE == null) {}
      for (;;)
      {
        return;
        GroupIconHelper.a locala1 = (GroupIconHelper.a)GroupIconHelper.a(GroupIconHelper.this).get(this.QE);
        if (this.bJR) {
          locala1 = (GroupIconHelper.a)GroupIconHelper.a(GroupIconHelper.this).get(GroupIconHelper.jy(this.QE));
        }
        while ((locala1 != null) || (this.type == 3))
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
          switch (this.type)
          {
          default: 
            return;
          case 1: 
            a(locala1);
            return;
          case 2: 
            String str2 = this.QE;
            GroupIconHelper.a locala2 = locala1;
            if (locala1 != null) {
              locala2 = locala1;
            }
            try
            {
              if (locala1.faceUinSet == null) {
                locala2 = GroupIconHelper.a(GroupIconHelper.this, this.QE, false, locala1, true);
              }
              if (locala2 == null)
              {
                QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. iconinfo is null, disUin=" + this.QE);
                return;
              }
            }
            finally {}
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "TYPE_CREAT. disUin=" + this.QE + " ,isSyncFace=" + locala2.bJS + ", faceUinSet=" + locala2.faceUinSet);
            }
            a(locala2, localQQAppInterface);
            if ((locala2.aX == 2) && (locala2.bqx != null))
            {
              String str1 = GroupIconHelper.b(locala2.tR, false);
              if (locala2.bqx.equals(str1)) {
                return;
              }
            }
            a(locala2, locala2.tR.size());
            return;
          }
          cz(localQQAppInterface);
          return;
        }
      }
    }
    
    public void run()
    {
      hW();
      GroupIconHelper.this.aG.decrementAndGet();
      GroupIconHelper.a(GroupIconHelper.this);
    }
  }
  
  class a
  {
    public byte aX = 1;
    public boolean bJR;
    public boolean bJS;
    public boolean bJT;
    public boolean bnK;
    public String bqx;
    public int cyU;
    public int faceCount;
    public String faceUinSet;
    public boolean isChanged;
    public long startTime;
    public ArrayList<String> tR = new ArrayList();
    
    private a() {}
    
    public void i(byte paramByte)
    {
      if (paramByte == 3)
      {
        this.isChanged = false;
        this.aX = 1;
        this.bJS = false;
        this.faceUinSet = null;
        this.faceCount = 0;
        this.cyU = 0;
        this.bqx = null;
        this.tR.clear();
        this.bJR = false;
        this.bJT = false;
        this.bnK = false;
      }
      while (paramByte != 2) {
        return;
      }
      this.bJS = false;
      this.bnK = true;
    }
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("\nGroupIconInfo");
      localStringBuilder.append("\n |-").append("isChanged:").append(this.isChanged);
      localStringBuilder.append("\n |-").append("state:").append(this.aX);
      localStringBuilder.append("\n |-").append("isSyncFace:").append(this.bJS);
      localStringBuilder.append("\n |-").append("startTime:").append(this.startTime);
      localStringBuilder.append("\n |-").append("faceUinSet:").append(this.faceUinSet);
      localStringBuilder.append("\n |-").append("faceCount:").append(this.faceCount);
      localStringBuilder.append("\n |-").append("crateIconCount:").append(this.cyU);
      localStringBuilder.append("\n |-").append("lastCreatedFaceUinSet:").append(this.bqx);
      localStringBuilder.append("\n |-").append("isPstnIcon:").append(this.bJR);
      localStringBuilder.append("\n |-").append("hasRealPstnUser:").append(this.bJT);
      localStringBuilder.append("\n |-").append("isFromCreate:").append(this.bnK);
      try
      {
        localStringBuilder.append("\n |-").append("memberFaceList:").append(this.tR);
        label243:
        return localStringBuilder.toString();
      }
      catch (Exception localException)
      {
        break label243;
      }
    }
  }
  
  static class b
    extends MqqHandler
  {
    private WeakReference<Handler.Callback> mWeakReferCallBack;
    
    private b(Looper paramLooper, Handler.Callback paramCallback)
    {
      super();
      this.mWeakReferCallBack = new WeakReference(paramCallback);
    }
    
    public void handleMessage(Message paramMessage)
    {
      Handler.Callback localCallback = (Handler.Callback)this.mWeakReferCallBack.get();
      if (localCallback != null) {
        localCallback.handleMessage(paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.GroupIconHelper
 * JD-Core Version:    0.7.0.1
 */