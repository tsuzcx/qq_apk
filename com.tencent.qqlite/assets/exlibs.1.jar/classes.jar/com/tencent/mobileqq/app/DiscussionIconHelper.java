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
import ctf;
import ctg;
import cth;
import cti;
import ctj;
import ctk;
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
  private static final byte jdField_c_of_type_Byte = 3;
  private static int d = 72;
  private static final int e = 9527;
  private static final int f = 300;
  private static final int g = 8;
  private static final int h = 3600000;
  private DiscussionHandler jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ctg jdField_a_of_type_Ctg = null;
  private ctk jdField_a_of_type_Ctk;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private Comparator jdField_a_of_type_JavaUtilComparator = new ctf(this);
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable;
  private boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private int i = 60000;
  private int j = 90000;
  
  public DiscussionIconHelper(String paramString, DiscussionHandler paramDiscussionHandler)
  {
    this.c = paramString;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "Create DiscussionIconHelper For [" + this.c + "]");
    }
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashtable = new Hashtable();
    this.jdField_a_of_type_Ctk = new ctk(paramDiscussionHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getMainLooper(), this, null);
    this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler = paramDiscussionHandler;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cth(this));
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
  
  private cti a(String paramString, boolean paramBoolean1, cti paramcti, boolean paramBoolean2)
  {
    Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
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
      paramcti.jdField_a_of_type_Int = 0;
      localObject3 = a((ArrayList)localObject2, paramString, paramBoolean2);
      paramcti.jdField_a_of_type_JavaLangString = ((String)localObject3);
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
      paramcti.jdField_a_of_type_Boolean = paramBoolean1;
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
      return paramcti;
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
      paramcti.jdField_a_of_type_Int = ((ArrayList)localObject2).size();
      break label89;
      label465:
      if ((localObject3 != null) && (!((String)localObject3).equals(localObject4))) {
        paramBoolean1 = true;
      } else if ((localObject4 != null) && (!((String)localObject4).equals(localObject3))) {
        paramBoolean1 = true;
      } else if ((paramcti.jdField_a_of_type_Byte == 2) && (localObject3 != null) && (!((String)localObject3).equals(paramcti.jdField_b_of_type_JavaLangString))) {
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
  
  private void a(String paramString, cti paramcti, boolean paramBoolean)
  {
    if (paramcti.jdField_a_of_type_Byte == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.dih", 2, "CreateIcon created: " + paramString + ", iconCount=" + paramcti.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramcti.jdField_a_of_type_Int);
      }
      return;
    }
    Object localObject1 = b(paramcti.jdField_a_of_type_JavaLangString, paramString, paramcti.jdField_a_of_type_JavaUtilArrayList);
    boolean bool1 = ((Boolean)((Pair)localObject1).first).booleanValue();
    boolean bool2 = ((Boolean)((Pair)localObject1).second).booleanValue();
    String str;
    if (bool1)
    {
      paramcti.jdField_b_of_type_Int += 1;
      str = a(paramcti.jdField_a_of_type_JavaUtilArrayList, paramString, paramBoolean);
      paramcti.jdField_b_of_type_JavaLangString = str;
      localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(45);
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
      if ((paramcti.jdField_a_of_type_JavaUtilArrayList.size() >= paramcti.jdField_a_of_type_Int) && (bool2)) {
        paramcti.jdField_a_of_type_Byte = 3;
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
        QLog.d("Q.qqhead.dih", 2, "CreateIcon Done: " + paramString + ", name=" + (String)localObject1 + ", state=" + paramcti.jdField_a_of_type_Byte + ", iconCount=" + paramcti.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramcti.jdField_a_of_type_Int + ", isComplete=" + bool2 + ", faceUinSet=" + paramcti.jdField_a_of_type_JavaLangString + ", newFaceUinSet=" + str);
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.qqhead.dih", 2, "CreateIcon fail: " + paramString + ", iconCount=" + paramcti.jdField_a_of_type_JavaUtilArrayList.size() + ", totalCount=" + paramcti.jdField_a_of_type_Int);
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
        cti localcti;
        if (this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramString))
        {
          localcti = (cti)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
          if (localcti.jdField_a_of_type_Byte == 3)
          {
            k = 1;
            if (((k == 0) && (l - localcti.jdField_a_of_type_Long < this.j)) || ((k != 0) && (!paramBoolean) && (l - localcti.jdField_a_of_type_Long < 3600000L))) {
              return false;
            }
            localcti.a(localcti.jdField_a_of_type_Byte);
            localcti.jdField_a_of_type_Long = l;
            this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localcti);
            return true;
          }
        }
        else
        {
          localcti = new cti(this, null);
          this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localcti);
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
    //   30: iconst_0
    //   31: invokevirtual 430	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   34: astore 8
    //   36: aload_0
    //   37: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: bipush 101
    //   42: aload_2
    //   43: iconst_1
    //   44: iconst_0
    //   45: invokevirtual 433	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;BI)Ljava/lang/String;
    //   48: astore 7
    //   50: new 435	java/io/File
    //   53: dup
    //   54: aload 8
    //   56: invokespecial 437	java/io/File:<init>	(Ljava/lang/String;)V
    //   59: astore 8
    //   61: aload_1
    //   62: invokevirtual 269	java/lang/String:trim	()Ljava/lang/String;
    //   65: invokevirtual 149	java/lang/String:length	()I
    //   68: ifgt +49 -> 117
    //   71: aload 8
    //   73: invokevirtual 440	java/io/File:exists	()Z
    //   76: ifeq +17 -> 93
    //   79: aload 8
    //   81: invokevirtual 443	java/io/File:isFile	()Z
    //   84: ifeq +9 -> 93
    //   87: aload 8
    //   89: invokevirtual 446	java/io/File:delete	()Z
    //   92: pop
    //   93: aload_0
    //   94: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   97: aload 7
    //   99: invokestatic 451	com/tencent/mobileqq/utils/ImageUtil:d	()Landroid/graphics/Bitmap;
    //   102: invokevirtual 454	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   105: iconst_1
    //   106: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   109: iconst_1
    //   110: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   116: areturn
    //   117: aload_0
    //   118: aload_1
    //   119: aload_2
    //   120: aload_3
    //   121: invokespecial 456	com/tencent/mobileqq/app/DiscussionIconHelper:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)Landroid/util/Pair;
    //   124: astore_1
    //   125: aload_1
    //   126: getfield 220	android/util/Pair:second	Ljava/lang/Object;
    //   129: checkcast 198	android/graphics/Bitmap
    //   132: astore_2
    //   133: aload_1
    //   134: getfield 204	android/util/Pair:first	Ljava/lang/Object;
    //   137: checkcast 151	java/lang/Boolean
    //   140: invokevirtual 207	java/lang/Boolean:booleanValue	()Z
    //   143: istore 5
    //   145: aload_2
    //   146: ifnonnull +24 -> 170
    //   149: iconst_0
    //   150: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   153: iconst_0
    //   154: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   157: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   160: areturn
    //   161: astore_1
    //   162: iconst_1
    //   163: istore 5
    //   165: aconst_null
    //   166: astore_2
    //   167: goto -22 -> 145
    //   170: aload 8
    //   172: invokevirtual 440	java/io/File:exists	()Z
    //   175: ifne +9 -> 184
    //   178: aload 8
    //   180: invokevirtual 459	java/io/File:createNewFile	()Z
    //   183: pop
    //   184: new 461	java/io/FileOutputStream
    //   187: dup
    //   188: aload 8
    //   190: invokespecial 464	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   193: astore_1
    //   194: aload_2
    //   195: getstatic 470	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   198: bipush 90
    //   200: aload_1
    //   201: invokevirtual 474	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   204: istore 6
    //   206: aload_1
    //   207: invokevirtual 477	java/io/FileOutputStream:flush	()V
    //   210: aload_0
    //   211: getfield 130	com/tencent/mobileqq/app/DiscussionIconHelper:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: aload 7
    //   216: aload_2
    //   217: invokevirtual 454	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    //   220: iload 6
    //   222: istore 4
    //   224: aload_1
    //   225: ifnull +11 -> 236
    //   228: aload_1
    //   229: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   232: iload 6
    //   234: istore 4
    //   236: iload 4
    //   238: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   241: iload 5
    //   243: invokestatic 155	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   246: invokestatic 161	android/util/Pair:create	(Ljava/lang/Object;Ljava/lang/Object;)Landroid/util/Pair;
    //   249: areturn
    //   250: astore_1
    //   251: aload_1
    //   252: invokevirtual 483	java/io/IOException:printStackTrace	()V
    //   255: iload 6
    //   257: istore 4
    //   259: goto -23 -> 236
    //   262: astore_1
    //   263: aconst_null
    //   264: astore_1
    //   265: aload_1
    //   266: ifnull +50 -> 316
    //   269: aload_1
    //   270: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   273: iconst_0
    //   274: istore 4
    //   276: goto -40 -> 236
    //   279: astore_1
    //   280: aload_1
    //   281: invokevirtual 483	java/io/IOException:printStackTrace	()V
    //   284: goto -11 -> 273
    //   287: astore_2
    //   288: aconst_null
    //   289: astore_1
    //   290: aload_1
    //   291: ifnull +7 -> 298
    //   294: aload_1
    //   295: invokevirtual 480	java/io/FileOutputStream:close	()V
    //   298: aload_2
    //   299: athrow
    //   300: astore_1
    //   301: aload_1
    //   302: invokevirtual 483	java/io/IOException:printStackTrace	()V
    //   305: goto -7 -> 298
    //   308: astore_2
    //   309: goto -19 -> 290
    //   312: astore_2
    //   313: goto -48 -> 265
    //   316: iconst_0
    //   317: istore 4
    //   319: goto -83 -> 236
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	322	0	this	DiscussionIconHelper
    //   0	322	1	paramString1	String
    //   0	322	2	paramString2	String
    //   0	322	3	paramArrayList	ArrayList
    //   222	96	4	bool1	boolean
    //   143	99	5	bool2	boolean
    //   204	52	6	bool3	boolean
    //   48	167	7	str	String
    //   34	155	8	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   117	145	161	java/lang/Throwable
    //   228	232	250	java/io/IOException
    //   170	184	262	java/lang/Throwable
    //   184	194	262	java/lang/Throwable
    //   269	273	279	java/io/IOException
    //   170	184	287	finally
    //   184	194	287	finally
    //   294	298	300	java/io/IOException
    //   194	220	308	finally
    //   194	220	312	java/lang/Throwable
  }
  
  private void f(String paramString)
  {
    this.jdField_a_of_type_Ctk.removeMessages(9527, paramString);
    paramString = this.jdField_a_of_type_Ctk.obtainMessage(9527, paramString);
    this.jdField_a_of_type_Ctk.sendMessageDelayed(paramString, 300L);
  }
  
  /* Error */
  public Bitmap a(int paramInt, Bitmap[] paramArrayOfBitmap)
  {
    // Byte code:
    //   0: invokestatic 506	com/tencent/common/app/BaseApplicationImpl:a	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   3: invokevirtual 507	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   6: ldc_w 508
    //   9: invokestatic 514	android/graphics/BitmapFactory:decodeResource	(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;
    //   12: astore 4
    //   14: iload_1
    //   15: aload_2
    //   16: aload 4
    //   18: fconst_1
    //   19: invokestatic 519	com/tencent/mobileqq/util/PuzzleAvatarUtil:a	(I[Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)Landroid/graphics/Bitmap;
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
    //   47: ldc_w 521
    //   50: invokevirtual 86	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload 4
    //   55: invokevirtual 524	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 526	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   85: invokevirtual 527	java/lang/Exception:toString	()Ljava/lang/String;
    //   88: invokestatic 526	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   110: invokevirtual 528	java/lang/Error:toString	()Ljava/lang/String;
    //   113: invokestatic 526	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
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
        cti localcti = (cti)this.jdField_a_of_type_JavaUtilHashMap.get(str1);
        if ((localcti != null) && (localcti.jdField_a_of_type_JavaLangString != null) && (localcti.jdField_a_of_type_Byte != 3))
        {
          String str2 = localcti.jdField_a_of_type_JavaLangString;
          if ((paramBoolean) && (str2.contains(paramString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.dih", 2, "onUpdateCustomHead: disUin=" + str1 + ", uin=" + paramString + ", faceUinSet=" + str2);
            }
            localcti.jdField_a_of_type_JavaUtilArrayList.add(paramString);
            f(str1);
          }
        }
      }
    }
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.dih", 2, "DiscussionIconHelper release.");
    }
    if (this.jdField_a_of_type_Ctg != null) {
      this.jdField_a_of_type_Ctg.jdField_a_of_type_Boolean = false;
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
          cti localcti = (cti)this.jdField_a_of_type_JavaUtilHashMap.get(str);
          if ((localcti != null) && (localcti.jdField_a_of_type_Byte != 3)) {
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
      paramString = new ctj(this, 1, paramString);
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
    paramString = new ctj(this, 3, paramString);
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
      paramMessage = new ctj(this, 2, (String)paramMessage.obj);
      ThreadManager.a().post(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionIconHelper
 * JD-Core Version:    0.7.0.1
 */