package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;

public class BubbleInfo
{
  private static final boolean a = true;
  private static final String f;
  public static final int g = 0;
  public static final int h = 1;
  public static final int i = 2;
  public static final int j = 3;
  public static final int k = 4;
  public static final int l = 5;
  public static final int m = 6;
  public static final int n = 7;
  public static final int o = 0;
  public static final int p = 1;
  public static final int q = 2;
  public static final int r = 3;
  public int a;
  public BubbleInfo.CommonAttrs a;
  public String a;
  public HashMap a;
  public List a;
  public String[] a;
  public int b;
  public BubbleInfo.CommonAttrs b;
  public String b;
  List jdField_b_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_b_of_type_Boolean = false;
  public int c;
  public String c;
  List jdField_c_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  private int s;
  private int t;
  
  static
  {
    jdField_f_of_type_JavaLangString = BubbleInfo.class.getSimpleName();
  }
  
  public BubbleInfo(int paramInt)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2130839157;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public BubbleInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2130839157;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.s = paramInt2;
    this.t = paramInt3;
  }
  
  public BubbleInfo(int paramInt1, String paramString1, String paramString2, String paramString3, int paramInt2, int paramInt3, String[] paramArrayOfString, BubbleInfo.CommonAttrs paramCommonAttrs1, int paramInt4, int paramInt5, BubbleInfo.CommonAttrs paramCommonAttrs2, List paramList, HashMap paramHashMap)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2130839157;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_d_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_d_of_type_JavaLangString = paramString3;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = paramInt3;
    this.jdField_e_of_type_Int = paramInt4;
    this.jdField_f_of_type_Int = paramInt5;
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList = paramString1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs1;
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs = paramCommonAttrs2;
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    this.jdField_a_of_type_JavaUtilHashMap = paramString1;
  }
  
  private Drawable a(Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("bubbleinfo_").append(paramInt1).append("_bg_").append(paramBoolean1).append("_").append(paramBoolean2);
    Object localObject = (Pair)BaseApplicationImpl.a.get(localStringBuffer.toString());
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      paramContext = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramContext.getResources());
    }
    do
    {
      return paramContext;
      Drawable localDrawable = paramContext.getResources().getDrawable(paramInt2);
      paramContext = paramContext.getResources().getDrawable(paramInt3);
      localObject = new StateListDrawable();
      if (localDrawable != null) {
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, localDrawable);
      }
      if (paramContext != null)
      {
        ((StateListDrawable)localObject).addState(new int[] { 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { -16842910 }, paramContext);
      }
      paramInt1 = SkinUtils.a(localDrawable) + SkinUtils.a(paramContext);
      paramContext = (Context)localObject;
    } while (paramInt1 <= 0);
    BaseApplicationImpl.a.put(localStringBuffer.toString(), new Pair(((StateListDrawable)localObject).getConstantState(), Integer.valueOf(paramInt1)));
    return localObject;
  }
  
  /* Error */
  public static Pair a(com.tencent.common.app.AppInterface paramAppInterface, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: iconst_0
    //   4: istore 4
    //   6: iconst_0
    //   7: istore_3
    //   8: aload_1
    //   9: invokestatic 208	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   12: ifne +362 -> 374
    //   15: aload_1
    //   16: ldc 210
    //   18: invokevirtual 216	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   21: ifeq +197 -> 218
    //   24: iconst_1
    //   25: istore_2
    //   26: aconst_null
    //   27: astore 6
    //   29: aload 6
    //   31: ifnull +11 -> 42
    //   34: aload 6
    //   36: invokevirtual 222	java/io/File:exists	()Z
    //   39: ifne +7 -> 46
    //   42: iload_2
    //   43: ifeq +173 -> 216
    //   46: new 224	android/graphics/Rect
    //   49: dup
    //   50: invokespecial 225	android/graphics/Rect:<init>	()V
    //   53: astore 9
    //   55: new 227	android/graphics/BitmapFactory$Options
    //   58: dup
    //   59: invokespecial 228	android/graphics/BitmapFactory$Options:<init>	()V
    //   62: astore 10
    //   64: aload 10
    //   66: sipush 320
    //   69: putfield 231	android/graphics/BitmapFactory$Options:inDensity	I
    //   72: aload 10
    //   74: aload_0
    //   75: invokevirtual 236	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   78: invokevirtual 239	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   81: invokevirtual 243	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   84: getfield 248	android/util/DisplayMetrics:densityDpi	I
    //   87: putfield 251	android/graphics/BitmapFactory$Options:inTargetDensity	I
    //   90: iload_2
    //   91: ifeq +142 -> 233
    //   94: aload_1
    //   95: astore 6
    //   97: aload_1
    //   98: astore 7
    //   100: aload_1
    //   101: ldc 253
    //   103: invokevirtual 257	java/lang/String:length	()I
    //   106: invokevirtual 261	java/lang/String:substring	(I)Ljava/lang/String;
    //   109: astore_1
    //   110: aload_1
    //   111: astore 6
    //   113: aload_1
    //   114: astore 7
    //   116: aload_0
    //   117: invokevirtual 236	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   120: invokevirtual 265	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   123: invokevirtual 269	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   126: aload_1
    //   127: invokevirtual 275	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   130: astore 8
    //   132: aload_1
    //   133: astore 6
    //   135: aload_1
    //   136: astore 7
    //   138: aload 8
    //   140: aload 9
    //   142: aload 10
    //   144: invokestatic 281	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   147: astore 9
    //   149: aload 9
    //   151: astore 6
    //   153: iload 5
    //   155: istore_2
    //   156: aload 6
    //   158: invokestatic 287	com/tencent/image/Utils:getBitmapSize	(Landroid/graphics/Bitmap;)I
    //   161: istore_3
    //   162: iload_3
    //   163: istore_2
    //   164: iload_3
    //   165: istore 4
    //   167: aload 8
    //   169: invokevirtual 292	java/io/InputStream:close	()V
    //   172: iload_3
    //   173: istore_2
    //   174: aload 6
    //   176: astore 8
    //   178: aload 8
    //   180: ifnonnull +72 -> 252
    //   183: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +30 -> 216
    //   189: getstatic 49	com/tencent/mobileqq/bubble/BubbleInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   192: iconst_2
    //   193: new 299	java/lang/StringBuilder
    //   196: dup
    //   197: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   200: ldc_w 302
    //   203: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload_1
    //   207: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   210: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 309	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: aconst_null
    //   217: areturn
    //   218: new 218	java/io/File
    //   221: dup
    //   222: aload_1
    //   223: invokespecial 312	java/io/File:<init>	(Ljava/lang/String;)V
    //   226: astore 6
    //   228: iconst_0
    //   229: istore_2
    //   230: goto -201 -> 29
    //   233: aload_1
    //   234: astore 6
    //   236: aload_1
    //   237: astore 7
    //   239: new 314	java/io/FileInputStream
    //   242: dup
    //   243: aload_1
    //   244: invokespecial 315	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   247: astore 8
    //   249: goto -117 -> 132
    //   252: invokestatic 297	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   255: ifeq +30 -> 285
    //   258: getstatic 49	com/tencent/mobileqq/bubble/BubbleInfo:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   261: iconst_2
    //   262: new 299	java/lang/StringBuilder
    //   265: dup
    //   266: invokespecial 300	java/lang/StringBuilder:<init>	()V
    //   269: ldc_w 317
    //   272: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: aload_1
    //   276: invokevirtual 305	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   279: invokevirtual 306	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   282: invokestatic 309	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   285: new 319	android/graphics/drawable/BitmapDrawable
    //   288: dup
    //   289: aload_0
    //   290: invokevirtual 236	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   293: invokevirtual 239	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   296: aload 8
    //   298: invokespecial 322	android/graphics/drawable/BitmapDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   301: astore_1
    //   302: aload_1
    //   303: aload_0
    //   304: invokevirtual 236	com/tencent/common/app/AppInterface:a	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   307: invokevirtual 239	com/tencent/qphone/base/util/BaseApplication:getResources	()Landroid/content/res/Resources;
    //   310: invokevirtual 243	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   313: invokevirtual 326	android/graphics/drawable/BitmapDrawable:setTargetDensity	(Landroid/util/DisplayMetrics;)V
    //   316: new 143	com/tencent/util/Pair
    //   319: dup
    //   320: aload_1
    //   321: iload_2
    //   322: invokestatic 190	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   325: invokespecial 193	com/tencent/util/Pair:<init>	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   328: areturn
    //   329: astore_1
    //   330: aconst_null
    //   331: astore 8
    //   333: iload_3
    //   334: istore_2
    //   335: aload 6
    //   337: astore_1
    //   338: goto -160 -> 178
    //   341: astore 7
    //   343: aload 6
    //   345: astore 8
    //   347: goto -169 -> 178
    //   350: astore_1
    //   351: aconst_null
    //   352: astore 8
    //   354: iload_3
    //   355: istore_2
    //   356: aload 7
    //   358: astore_1
    //   359: goto -181 -> 178
    //   362: astore 7
    //   364: aload 6
    //   366: astore 8
    //   368: iload 4
    //   370: istore_2
    //   371: goto -193 -> 178
    //   374: iconst_0
    //   375: istore_2
    //   376: aconst_null
    //   377: astore 6
    //   379: goto -350 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	382	1	paramString	String
    //   25	351	2	i1	int
    //   7	348	3	i2	int
    //   4	365	4	i3	int
    //   1	153	5	i4	int
    //   27	351	6	localObject1	Object
    //   98	140	7	str	String
    //   341	16	7	localOutOfMemoryError	java.lang.OutOfMemoryError
    //   362	1	7	localException	java.lang.Exception
    //   130	237	8	localObject2	Object
    //   53	97	9	localObject3	Object
    //   62	81	10	localOptions	BitmapFactory.Options
    // Exception table:
    //   from	to	target	type
    //   100	110	329	java/lang/OutOfMemoryError
    //   116	132	329	java/lang/OutOfMemoryError
    //   138	149	329	java/lang/OutOfMemoryError
    //   239	249	329	java/lang/OutOfMemoryError
    //   156	162	341	java/lang/OutOfMemoryError
    //   167	172	341	java/lang/OutOfMemoryError
    //   100	110	350	java/lang/Exception
    //   116	132	350	java/lang/Exception
    //   138	149	350	java/lang/Exception
    //   239	249	350	java/lang/Exception
    //   156	162	362	java/lang/Exception
    //   167	172	362	java/lang/Exception
  }
  
  private Pair a(String paramString)
  {
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        Pair localPair = (Pair)localIterator.next();
        if (((BubbleInfo.CommonAttrs)localPair.first).jdField_b_of_type_JavaLangString == paramString) {
          return localPair;
        }
      }
    }
    return null;
  }
  
  private void a(QQAppInterface paramQQAppInterface, View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    paramQQAppInterface = new Rect();
    paramDrawable.getPadding(paramQQAppInterface);
    int i1 = paramView.getPaddingTop();
    int i2 = paramQQAppInterface.top;
    int i3 = paramView.getPaddingLeft();
    int i4 = paramQQAppInterface.left;
    int i5 = paramView.getPaddingRight();
    int i6 = paramQQAppInterface.right;
    int i7 = paramView.getPaddingBottom();
    int i8 = paramQQAppInterface.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(i3 + i4, i1 + i2, i5 + i6, i8 + i7);
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView)
  {
    Object localObject3;
    Object localObject1;
    if ((paramBoolean2) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)))
    {
      localObject3 = "bubblebg://" + this.jdField_a_of_type_Int + "_" + "_" + "local";
      localObject1 = (Pair)BaseApplicationImpl.a.get(localObject3);
      if ((localObject1 != null) && (((Pair)localObject1).first != null))
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_f_of_type_JavaLangString, 2, "getBubbleDrawable from sImageCache...cacheKey=" + (String)localObject3);
        }
        localObject1 = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable(paramQQAppInterface.a().getResources());
        localObject3 = (DecorationVipBubbleDrawable)localObject1;
        if (!paramBoolean1)
        {
          paramBoolean2 = true;
          if (paramBoolean3) {
            break label252;
          }
        }
        label192:
        label252:
        for (paramBoolean3 = true;; paramBoolean3 = false)
        {
          ((DecorationVipBubbleDrawable)localObject3).a(paramBoolean2, paramBoolean3);
          localObject3 = localObject1;
          if (localObject1 == null)
          {
            if (!paramBoolean1) {
              break label544;
            }
            localObject1 = "bubblebg://default_mine";
            localObject1 = (Pair)BaseApplicationImpl.a.get(localObject1);
            if ((localObject1 == null) || (((Pair)localObject1).first == null)) {
              break label552;
            }
            localObject3 = ((Drawable.ConstantState)((Pair)localObject1).first).newDrawable();
          }
          a(paramQQAppInterface, paramView, (Drawable)localObject3);
          BubbleManager.jdField_a_of_type_Boolean = true;
          return localObject3;
          paramBoolean2 = false;
          break;
        }
      }
      if ((new File(this.jdField_a_of_type_JavaLangString).exists()) && (new File(this.jdField_b_of_type_JavaLangString).exists())) {
        if (paramQQAppInterface != null)
        {
          localObject1 = (BubbleManager)paramQQAppInterface.getManager(40);
          label307:
          if ((localObject1 == null) || (!BubbleManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.tryLock())) {
            break label661;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject4;
      try
      {
        localObject1 = paramQQAppInterface.a().getResources();
        Object localObject5 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject5).inDensity = 320;
        ((BitmapFactory.Options)localObject5).inTargetDensity = ((Resources)localObject1).getDisplayMetrics().densityDpi;
        localObject4 = BitmapFactory.decodeFile(this.jdField_a_of_type_JavaLangString, (BitmapFactory.Options)localObject5);
        localObject5 = BitmapFactory.decodeFile(this.jdField_b_of_type_JavaLangString, (BitmapFactory.Options)localObject5);
        byte[] arrayOfByte1 = ((Bitmap)localObject4).getNinePatchChunk();
        byte[] arrayOfByte2 = ((Bitmap)localObject5).getNinePatchChunk();
        if ((arrayOfByte1 == null) || (!NinePatch.isNinePatchChunk(arrayOfByte1)) || (arrayOfByte2 == null) || (!NinePatch.isNinePatchChunk(arrayOfByte2))) {
          break label655;
        }
        localObject1 = new DecorationVipBubbleDrawable((Resources)localObject1, (Bitmap)localObject4, (Bitmap)localObject5, arrayOfByte1, arrayOfByte2);
        if (!paramBoolean1)
        {
          paramBoolean2 = true;
          break label667;
          ((DecorationVipBubbleDrawable)localObject1).a(paramBoolean2, paramBoolean3);
          BaseApplicationImpl.a.put(localObject3, new Pair(((DecorationVipBubbleDrawable)localObject1).getConstantState(), Integer.valueOf(Utils.getBitmapSize((Bitmap)localObject4))));
          BubbleManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
          break;
          localObject1 = null;
          break label307;
        }
        paramBoolean2 = false;
        break label667;
        paramBoolean3 = false;
        continue;
      }
      catch (Throwable localThrowable)
      {
        BubbleManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
        localObject2 = null;
        break;
      }
      finally
      {
        BubbleManager.jdField_a_of_type_JavaUtilConcurrentLocksLock.unlock();
      }
      label544:
      Object localObject2 = "bubblebg://default_friend";
      break label192;
      label552:
      localObject3 = paramQQAppInterface.a().getResources();
      if (paramBoolean1)
      {
        i1 = 2130839267;
        label570:
        localObject2 = ((Resources)localObject3).getDrawable(i1);
        if (!paramBoolean1) {
          break label647;
        }
      }
      label647:
      for (int i1 = 2130839266;; i1 = 2130839213)
      {
        localObject4 = ((Resources)localObject3).getDrawable(i1);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject2);
        ((StateListDrawable)localObject3).addState(new int[] { 16842910 }, (Drawable)localObject4);
        break;
        i1 = 2130839214;
        break label570;
      }
      label655:
      localObject2 = null;
      continue;
      label661:
      localObject2 = null;
      break;
      label667:
      if (!paramBoolean3) {
        paramBoolean3 = true;
      }
    }
  }
  
  public Pair a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    StringBuilder localStringBuilder = null;
    Object localObject1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (BubbleManager)paramQQAppInterface.getManager(40);
      localObject2 = localStringBuilder;
      if (localObject1 != null)
      {
        localObject2 = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Int, true);
        if (localObject2 != null) {
          break label53;
        }
        localObject2 = localStringBuilder;
      }
    }
    label53:
    label86:
    label120:
    do
    {
      do
      {
        return localObject2;
        localObject1 = null;
        break;
        switch (paramInt)
        {
        default: 
          paramQQAppInterface = null;
          localObject2 = localStringBuilder;
        }
      } while (TextUtils.isEmpty(paramQQAppInterface));
      localObject2 = a(paramQQAppInterface);
      if (localObject1 == null) {
        break label290;
      }
      localObject1 = ((BubbleManager)localObject1).a(this.jdField_a_of_type_Int, paramQQAppInterface, (Pair)localObject2);
      localObject2 = localObject1;
    } while (!QLog.isDevelopLevel());
    Object localObject2 = jdField_f_of_type_JavaLangString;
    localStringBuilder = new StringBuilder().append("getAttrs|key=").append(paramQQAppInterface).append(", animAttrs=");
    if (localObject1 == null) {}
    for (paramQQAppInterface = "null";; paramQQAppInterface = "first:" + ((Pair)localObject1).first + ",second:" + ((Pair)localObject1).second)
    {
      QLog.w((String)localObject2, 4, paramQQAppInterface);
      return localObject1;
      if (((BubbleConfig)localObject2).a == null) {
        break;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).a.jdField_b_of_type_JavaLangString;
      break label86;
      if (((BubbleConfig)localObject2).b == null) {
        break;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).b.jdField_b_of_type_JavaLangString;
      break label86;
      paramQQAppInterface = "width";
      if (((BubbleConfig)localObject2).c == null) {
        break label86;
      }
      paramQQAppInterface = ((BubbleConfig)localObject2).c.jdField_b_of_type_JavaLangString;
      break label86;
      if ((this.jdField_a_of_type_JavaUtilHashMap == null) || (this.jdField_a_of_type_JavaUtilHashMap.size() <= 0) || (this.jdField_e_of_type_JavaLangString == null)) {
        break;
      }
      paramQQAppInterface = (String)this.jdField_a_of_type_JavaUtilHashMap.get(this.jdField_e_of_type_JavaLangString);
      break label86;
      label290:
      localObject1 = localObject2;
      if (!QLog.isDevelopLevel()) {
        break label120;
      }
      QLog.w(jdField_f_of_type_JavaLangString, 4, "getAttrs|findCommonAttrsById bubbleManager is null");
      localObject1 = localObject2;
      break label120;
    }
  }
  
  public String a(String paramString)
  {
    if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
      int i2 = arrayOfString.length;
      int i1 = 0;
      while (i1 < i2)
      {
        String str = arrayOfString[i1];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.jdField_e_of_type_JavaLangString = str;
          return str;
        }
        i1 += 1;
      }
    }
    return null;
  }
  
  public void a()
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.clear();
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public void a(View arg1, View paramView2)
  {
    synchronized (this.jdField_b_of_type_JavaUtilList)
    {
      this.jdField_b_of_type_JavaUtilList.remove(???);
    }
    synchronized (this.jdField_c_of_type_JavaUtilList)
    {
      this.jdField_c_of_type_JavaUtilList.remove(paramView2);
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public boolean a()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString));
  }
  
  public boolean a(int paramInt)
  {
    return (this.jdField_e_of_type_Int > 0) && (this.jdField_f_of_type_Int > this.jdField_e_of_type_Int) && (paramInt >= this.jdField_e_of_type_Int) && (paramInt <= this.jdField_f_of_type_Int);
  }
  
  public String toString()
  {
    return "BubbleInfo [bubbleId=" + this.jdField_a_of_type_Int + ",aioUserBgNorResPath=" + this.jdField_a_of_type_JavaLangString + ",aioUserPicNorResPath=" + this.jdField_b_of_type_JavaLangString + ",bubbleThumbnailResPath=" + this.jdField_d_of_type_JavaLangString + ", mTextColor=" + this.jdField_c_of_type_Int + ", mKeyWords=" + Arrays.toString(this.jdField_a_of_type_ArrayOfJavaLangString) + ", currKeyWord=" + this.jdField_e_of_type_JavaLangString + ", mBubbleHeightBegin=" + this.jdField_e_of_type_Int + ", mBubbleHeightEnd=" + this.jdField_f_of_type_Int + ", pttAttrs=" + this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs + ", heightAttrs=" + this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleInfo$CommonAttrs + ", keywordAttrs=" + this.jdField_a_of_type_JavaUtilList + ", keyWorsAnimMap=" + this.jdField_a_of_type_JavaUtilHashMap + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleInfo
 * JD-Core Version:    0.7.0.1
 */