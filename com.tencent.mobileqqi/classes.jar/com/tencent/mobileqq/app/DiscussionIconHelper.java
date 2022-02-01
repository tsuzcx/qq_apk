package com.tencent.mobileqq.app;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import fbo;
import fbp;
import fbq;
import fbr;
import fbs;
import fbt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

public class DiscussionIconHelper
  extends FriendListObserver
  implements Handler.Callback
{
  private static final byte jdField_a_of_type_Byte = 1;
  public static final int a = 5;
  static final String jdField_a_of_type_JavaLangString = "Q.qqhead.dih";
  private static final boolean jdField_a_of_type_Boolean = false;
  private static final byte jdField_b_of_type_Byte = 2;
  public static final int b = 4;
  private static final byte c = 3;
  private static int d = 72;
  private static final int e = 9527;
  private static final int f = 300;
  private static final int g = 8;
  private static final int h = 3600000;
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private fbp jdField_a_of_type_Fbp = null;
  private fbt jdField_a_of_type_Fbt;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Comparator jdField_a_of_type_JavaUtilComparator = new fbo(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int i = 60000;
  private int j = 90000;
  
  public DiscussionIconHelper(String paramString, DiscussionHandler paramDiscussionHandler)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create DiscussionIconHelper For [" + this.jdField_b_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_Fbt = new fbt(paramDiscussionHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = paramDiscussionHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new fbq(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this);
  }
  
  private Pair a(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return Pair.create(Boolean.valueOf(false), null);
    }
    boolean bool = true;
    float f2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getResources().getDisplayMetrics().density;
    float f1 = f2;
    if (f2 < 1.0F) {
      f1 = 1.0F;
    }
    int n = (int)(50.0F * f1 + 0.5D);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDiscussionIcon density=" + f1 + ";imageWidth=" + n);
    }
    paramString1 = paramString1.split(";");
    if (paramString1.length > 5) {}
    Bitmap[] arrayOfBitmap;
    for (int k = 5;; k = paramString1.length)
    {
      arrayOfBitmap = new Bitmap[k];
      int m = 0;
      while (m < k)
      {
        String str = paramString1[m];
        Pair localPair = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(str, 0, 0);
        if (!((Boolean)localPair.first).booleanValue())
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.dih", 2, "getScaledFaceBitmap fail, disUin=" + paramString2 + ", uin=" + str);
          }
          paramArrayList.remove(str);
          bool = false;
        }
        arrayOfBitmap[m] = ((Bitmap)localPair.second);
        m += 1;
      }
    }
    try
    {
      paramString1 = a(n, arrayOfBitmap);
      return Pair.create(Boolean.valueOf(bool), paramString1);
    }
    catch (Throwable paramString1)
    {
      for (;;)
      {
        bool = false;
        paramString1 = null;
      }
    }
  }
  
  private fbr a(String paramString, boolean paramBoolean1, fbr paramfbr, boolean paramBoolean2)
  {
    Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
    Object localObject2 = ((DiscussionManager)localObject1).b(paramString);
    label89:
    Object localObject3;
    Object localObject4;
    if (QLog.isColorLevel())
    {
      if ((localObject2 == null) || (((ArrayList)localObject2).size() == 0)) {
        QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is empty...");
      }
    }
    else
    {
      if ((localObject2 != null) && (((ArrayList)localObject2).size() != 0)) {
        break label453;
      }
      paramfbr.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject2, paramString, paramBoolean2);
      paramfbr.jdField_a_of_type_JavaLangString = ((String)localObject3);
      if (paramBoolean1)
      {
        localObject1 = ((DiscussionManager)localObject1).a(paramString);
        if (localObject1 != null)
        {
          localObject4 = ((DiscussionInfo)localObject1).faceUinSet;
          if (((localObject4 != null) && (!"".equals(((String)localObject4).trim()))) || ((localObject3 != null) && (!"".equals(((String)localObject3).trim())))) {
            break label465;
          }
          paramBoolean1 = false;
        }
      }
    }
    for (;;)
    {
      paramfbr.jdField_a_of_type_Boolean = paramBoolean1;
      if (QLog.isColorLevel())
      {
        localObject2 = ((DiscussionInfo)localObject1).discussionName;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() > 3) {
            localObject1 = ((String)localObject2).substring(0, 2) + "." + ((String)localObject2).charAt(((String)localObject2).length() - 1);
          }
        }
        QLog.d("Q.qqhead.dih", 2, "getDiscussionIconInfo. disUin=" + paramString + ", isChanged=" + paramBoolean1 + ", name=" + (String)localObject1 + ", faceUinSet=" + (String)localObject4 + ", newFaceUinSet=" + (String)localObject3);
      }
      return paramfbr;
      localObject3 = new StringBuilder();
      localObject4 = ((ArrayList)localObject2).iterator();
      if (((Iterator)localObject4).hasNext())
      {
        String str = (String)((Iterator)localObject4).next();
        if ((str != null) && (str.length() > 5)) {
          ((StringBuilder)localObject3).append(str.substring(0, 4));
        }
        for (;;)
        {
          ((StringBuilder)localObject3).append(";");
          break;
          ((StringBuilder)localObject3).append(str);
        }
      }
      QLog.d("Q.qqhead.dih", 2, "discussionUin=" + paramString + " memberUinList is:" + ((StringBuilder)localObject3).toString());
      break;
      label453:
      paramfbr.jdField_a_of_type_Int = ((ArrayList)localObject2).size();
      break label89;
      label465:
      if ((localObject3 != null) && (!((String)localObject3).equals(localObject4))) {
        paramBoolean1 = true;
      } else if ((localObject4 != null) && (!((String)localObject4).equals(localObject3))) {
        paramBoolean1 = true;
      } else if ((paramfbr.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(paramfbr.jdField_b_of_type_JavaLangString))) {
        paramBoolean1 = true;
      } else {
        paramBoolean1 = false;
      }
    }
  }
  
  private String a(ArrayList paramArrayList, String paramString, boolean paramBoolean)
  {
    int m = 0;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramString = new StringBuilder(128);
      paramArrayList = (ArrayList)paramArrayList.clone();
      String[] arrayOfString = new String[paramArrayList.size()];
      int k = 0;
      while (k < arrayOfString.length)
      {
        arrayOfString[k] = ((String)paramArrayList.get(k));
        k += 1;
      }
      Arrays.sort(arrayOfString, this.jdField_a_of_type_JavaUtilComparator);
      int n = 0;
      k = m;
      m = n;
      for (;;)
      {
        if (k < arrayOfString.length)
        {
          paramString.append(arrayOfString[k]).append(";");
          m += 1;
          if ((!paramBoolean) || (!a()) || (m < 4)) {
            break label147;
          }
        }
        label147:
        while (m >= 5) {
          return paramString.toString();
        }
        k += 1;
      }
    }
    return " ";
  }
  
  private void a(String paramString, fbr paramfbr, boolean paramBoolean)
  {
    if (paramfbr.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramfbr.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramfbr.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject1 = b(paramfbr.jdField_a_of_type_JavaLangString, paramString, paramfbr.jdField_a_of_type_JavaUtilArrayList);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      paramfbr.jdField_b_of_type_Int += 1;
      str = a(paramfbr.jdField_a_of_type_JavaUtilArrayList, paramString, paramBoolean);
      paramfbr.jdField_b_of_type_JavaLangString = str;
      localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(48);
      if (localObject1 == null) {
        break label510;
      }
    }
    label510:
    for (localObject1 = ((DiscussionManager)localObject1).a(paramString);; localObject1 = null)
    {
      Object localObject2;
      if (localObject1 != null)
      {
        ((DiscussionInfo)localObject1).faceUinSet = str;
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        ((EntityManager)localObject2).a((Entity)localObject1);
        ((EntityManager)localObject2).a();
      }
      if ((paramfbr.jdField_a_of_type_JavaUtilArrayList.size() >= paramfbr.jdField_a_of_type_Int) && (bool2)) {
        paramfbr.jdField_a_of_type_Byte = 3;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(bool1, bool2, paramString);
      if (!QLog.isColorLevel()) {
        break;
      }
      if (localObject1 != null)
      {
        localObject2 = ((DiscussionInfo)localObject1).discussionName;
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          localObject1 = localObject2;
          if (((String)localObject2).length() <= 3) {}
        }
      }
      for (localObject1 = ((String)localObject2).substring(0, 2) + "." + ((String)localObject2).charAt(((String)localObject2).length() - 1);; localObject1 = null)
      {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: " + paramString + ", name=" + (String)localObject1 + ", state=" + paramfbr.jdField_a_of_type_Byte + ", iconCount=" + paramfbr.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramfbr.jdField_a_of_type_Int + ", isComplete=" + bool2 + ", faceUinSet=" + paramfbr.jdField_a_of_type_JavaLangString + ", newFaceUinSet=" + str);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramfbr.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramfbr.jdField_a_of_type_Int);
        return;
      }
    }
  }
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        long l = System.currentTimeMillis();
        fbr localfbr;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localfbr = (fbr)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localfbr.jdField_a_of_type_Byte == 3)
          {
            k = 1;
            if (((k == 0) && (l - localfbr.jdField_a_of_type_Long < this.j)) || ((k != 0) && (!paramBoolean) && (l - localfbr.jdField_a_of_type_Long < 3600000L))) {
              return false;
            }
            localfbr.a(localfbr.jdField_a_of_type_Byte);
            localfbr.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localfbr);
            return true;
          }
        }
        else
        {
          localfbr = new fbr(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localfbr);
        }
      }
      int k = 0;
    }
  }
  
  /* Error */
  private Pair b(String paramString1, String paramString2, ArrayList paramArrayList)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +7 -> 8
    //   4: aload_2
    //   5: ifnonnull +15 -> 20
    //   8: iconst_0
    //   9: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   12: iconst_0
    //   13: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   16: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   19: areturn
    //   20: aload_0
    //   21: getfield 129	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler	Lcom/tencent/mobileqq/app/DiscussionHandler;
    //   24: getfield 111	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   27: bipush 101
    //   29: aload_2
    //   30: invokevirtual 429	com/tencent/mobileqq/app/QQAppInterface:b	(ILjava/lang/String;)Ljava/lang/String;
    //   33: astore 8
    //   35: aload_0
    //   36: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   39: bipush 101
    //   41: aload_2
    //   42: iconst_1
    //   43: invokevirtual 432	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;B)Ljava/lang/String;
    //   46: astore 7
    //   48: new 434	java/io/File
    //   51: dup
    //   52: aload 8
    //   54: invokespecial 436	java/io/File:<init>	(Ljava/lang/String;)V
    //   57: astore 8
    //   59: aload_1
    //   60: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   63: invokevirtual 149	java/lang/String:length	()I
    //   66: ifgt +49 -> 115
    //   69: aload 8
    //   71: invokevirtual 439	java/io/File:exists	()Z
    //   74: ifeq +17 -> 91
    //   77: aload 8
    //   79: invokevirtual 442	java/io/File:isFile	()Z
    //   82: ifeq +9 -> 91
    //   85: aload 8
    //   87: invokevirtual 445	java/io/File:delete	()Z
    //   90: pop
    //   91: aload_0
    //   92: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   95: aload 7
    //   97: invokestatic 450	com/tencent/mobileqq/utils/ImageUtil:d	()Landroid/graphics/Bitmap;
    //   100: invokevirtual 453	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   103: iconst_1
    //   104: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   107: iconst_1
    //   108: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   111: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   114: areturn
    //   115: aload_0
    //   116: aload_1
    //   117: aload_2
    //   118: aload_3
    //   119: invokespecial 455	com/tencent/mobileqq/app/DiscussionIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Landroid/util/Pair;
    //   122: astore_1
    //   123: aload_1
    //   124: getfield 220	android/util/Pair:second	Ljava/lang/Object;
    //   127: checkcast 198	android/graphics/Bitmap
    //   130: astore_2
    //   131: aload_1
    //   132: getfield 204	android/util/Pair:first	Ljava/lang/Object;
    //   135: checkcast 151	java/lang/Boolean
    //   138: invokevirtual 207	java/lang/Boolean:booleanValue	()Z
    //   141: istore 5
    //   143: aload_2
    //   144: ifnonnull +24 -> 168
    //   147: iconst_0
    //   148: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   151: iconst_0
    //   152: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   155: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   158: areturn
    //   159: astore_1
    //   160: iconst_1
    //   161: istore 5
    //   163: aconst_null
    //   164: astore_2
    //   165: goto -22 -> 143
    //   168: aload 8
    //   170: invokevirtual 439	java/io/File:exists	()Z
    //   173: ifne +9 -> 182
    //   176: aload 8
    //   178: invokevirtual 458	java/io/File:createNewFile	()Z
    //   181: pop
    //   182: new 460	java/io/FileOutputStream
    //   185: dup
    //   186: aload 8
    //   188: invokespecial 463	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   191: astore_1
    //   192: aload_2
    //   193: getstatic 469	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   196: bipush 90
    //   198: aload_1
    //   199: invokevirtual 473	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   202: istore 6
    //   204: aload_1
    //   205: invokevirtual 476	java/io/FileOutputStream:flush	()V
    //   208: aload_0
    //   209: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   212: aload 7
    //   214: aload_2
    //   215: invokevirtual 453	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   218: iload 6
    //   220: istore 4
    //   222: aload_1
    //   223: ifnull +11 -> 234
    //   226: aload_1
    //   227: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   230: iload 6
    //   232: istore 4
    //   234: iload 4
    //   236: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   239: iload 5
    //   241: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   244: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   247: areturn
    //   248: astore_1
    //   249: aload_1
    //   250: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   253: iload 6
    //   255: istore 4
    //   257: goto -23 -> 234
    //   260: astore_1
    //   261: aconst_null
    //   262: astore_1
    //   263: aload_1
    //   264: ifnull +50 -> 314
    //   267: aload_1
    //   268: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   271: iconst_0
    //   272: istore 4
    //   274: goto -40 -> 234
    //   277: astore_1
    //   278: aload_1
    //   279: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   282: goto -11 -> 271
    //   285: astore_2
    //   286: aconst_null
    //   287: astore_1
    //   288: aload_1
    //   289: ifnull +7 -> 296
    //   292: aload_1
    //   293: invokevirtual 479	java/io/FileOutputStream:close	()V
    //   296: aload_2
    //   297: athrow
    //   298: astore_1
    //   299: aload_1
    //   300: invokevirtual 482	java/io/IOException:printStackTrace	()V
    //   303: goto -7 -> 296
    //   306: astore_2
    //   307: goto -19 -> 288
    //   310: astore_2
    //   311: goto -48 -> 263
    //   314: iconst_0
    //   315: istore 4
    //   317: goto -83 -> 234
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	320	0	this	DiscussionIconHelper
    //   0	320	1	paramString1	String
    //   0	320	2	paramString2	String
    //   0	320	3	paramArrayList	ArrayList
    //   220	96	4	bool1	boolean
    //   141	99	5	bool2	boolean
    //   202	52	6	bool3	boolean
    //   46	167	7	str	String
    //   33	154	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   115	143	159	java/lang/Throwable
    //   226	230	248	java/io/IOException
    //   168	182	260	java/lang/Throwable
    //   182	192	260	java/lang/Throwable
    //   267	271	277	java/io/IOException
    //   168	182	285	finally
    //   182	192	285	finally
    //   292	296	298	java/io/IOException
    //   192	218	306	finally
    //   192	218	310	java/lang/Throwable
  }
  
  private void f(String paramString)
  {
    this.jdField_a_of_type_Fbt.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Fbt.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Fbt.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: invokestatic 505	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 506	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6: ldc_w 507
    //   9: invokestatic 513	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore 4
    //   14: iload_1
    //   15: aload_2
    //   16: aload 4
    //   18: fconst_1
    //   19: invokestatic 518	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
    //   22: astore_2
    //   23: aload_2
    //   24: astore_3
    //   25: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +38 -> 66
    //   31: aload_2
    //   32: astore_3
    //   33: aload_2
    //   34: ifnonnull +32 -> 66
    //   37: ldc 14
    //   39: iconst_2
    //   40: new 79	java/lang/StringBuilder
    //   43: dup
    //   44: invokespecial 80	java/lang/StringBuilder:<init>	()V
    //   47: ldc_w 520
    //   50: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 523	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload_2
    //   65: astore_3
    //   66: aload_3
    //   67: areturn
    //   68: astore 4
    //   70: aconst_null
    //   71: astore_2
    //   72: aload_2
    //   73: astore_3
    //   74: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   77: ifeq -11 -> 66
    //   80: ldc 14
    //   82: iconst_2
    //   83: aload 4
    //   85: invokevirtual 526	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_2
    //   92: areturn
    //   93: astore 4
    //   95: aconst_null
    //   96: astore_2
    //   97: aload_2
    //   98: astore_3
    //   99: invokestatic 77	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   102: ifeq -36 -> 66
    //   105: ldc 14
    //   107: iconst_2
    //   108: aload 4
    //   110: invokevirtual 527	java/lang/Error:toString	()Ljava/lang/String;
    //   113: invokestatic 525	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload_2
    //   117: areturn
    //   118: astore 4
    //   120: goto -23 -> 97
    //   123: astore 4
    //   125: goto -53 -> 72
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	DiscussionIconHelper
    //   0	128	1	paramInt	int
    //   0	128	2	paramArrayOfBitmap	Bitmap[]
    //   24	75	3	arrayOfBitmap	Bitmap[]
    //   12	42	4	localBitmap	Bitmap
    //   68	16	4	localException1	java.lang.Exception
    //   93	16	4	localError1	java.lang.Error
    //   118	1	4	localError2	java.lang.Error
    //   123	1	4	localException2	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	23	68	java/lang/Exception
    //   0	23	93	java/lang/Error
    //   25	31	118	java/lang/Error
    //   37	64	118	java/lang/Error
    //   25	31	123	java/lang/Exception
    //   37	64	123	java/lang/Exception
  }
  
  protected void a(boolean paramBoolean, String paramString)
  {
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)localIterator.next();
        fbr localfbr = (fbr)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
        if ((localfbr != null) && (localfbr.jdField_a_of_type_JavaLangString != null) && (localfbr.jdField_a_of_type_Byte != 3))
        {
          String str2 = localfbr.jdField_a_of_type_JavaLangString;
          if ((paramBoolean) && (str2.contains(paramString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            localfbr.jdField_a_of_type_JavaUtilArrayList.add(paramString);
            f(str1);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "DiscussionIconHelper release.");
    }
    if (this.jdField_a_of_type_Fbp != null) {
      this.jdField_a_of_type_Fbp.jdField_a_of_type_Boolean = false;
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notifyAll();
      synchronized (this.jdField_a_of_type_JavaUtilHashMap)
      {
        Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          fbr localfbr = (fbr)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if ((localfbr != null) && (localfbr.jdField_a_of_type_Byte != 3)) {
            this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(false, true, str);
          }
        }
      }
    }
    this.jdField_a_of_type_JavaUtilHashMap.clear();
  }
  
  public void b(String paramString)
  {
    boolean bool = a(paramString, true);
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "createDisIcon: " + paramString + ", isNeedToDo=" + bool);
    }
    if (bool) {
      f(paramString);
    }
  }
  
  public void c(String paramString)
  {
    boolean bool = a(paramString, false);
    if (bool)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "checkDisIcon: " + paramString + ", isNeedToDo=" + bool);
      }
      paramString = new fbs(this, 1, paramString);
      ThreadManager.a().post(paramString);
    }
  }
  
  public void d(String paramString)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilHashtable.containsKey(paramString)) && (l - ((Long)this.jdField_a_of_type_JavaUtilHashtable.get(paramString)).longValue() < this.i))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "refreshDisIcon repeat: " + paramString);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "refreshDisIcon: " + paramString);
    }
    this.jdField_a_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(l));
    paramString = new fbs(this, 3, paramString);
    ThreadManager.a().post(paramString);
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "removeDiscussion: " + paramString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilHashMap)
    {
      this.jdField_a_of_type_JavaUtilHashMap.remove(paramString);
      return;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      paramMessage = new fbs(this, 2, (String)paramMessage.obj);
      ThreadManager.a().post(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionIconHelper
 * JD-Core Version:    0.7.0.1
 */