package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.SkinUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import hfa;
import hfb;
import hfc;

public class AlbumImageProxy
  extends ImageViewTouche
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  static final String jdField_a_of_type_JavaLangString = "AlbumImageProxy";
  private static final int c = -1;
  private static final int d = 0;
  private static final int e = 1;
  private static final int f = 2;
  private int jdField_a_of_type_Int;
  public Handler a;
  private GestureDetector jdField_a_of_type_AndroidViewGestureDetector;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public AlbumImageProxy(QQAppInterface paramQQAppInterface, Context paramContext, AttributeSet paramAttributeSet, String paramString, boolean paramBoolean)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidOsHandler = new hfa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    setHexFileKey(paramString);
    setCacheImageBmp(paramBoolean);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new hfc(this, null));
  }
  
  public AlbumImageProxy(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidOsHandler = new hfa(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Int = paramInt;
    setHexFileKey(paramString);
    setCacheImageBmp(paramBoolean);
    this.jdField_a_of_type_AndroidViewGestureDetector = new GestureDetector(new hfc(this, null));
  }
  
  private Bitmap a(String paramString)
  {
    int i = CardHandler.d(BaseApplication.getContext());
    paramString = CardHandler.a(HexUtil.a(paramString), i);
    try
    {
      paramString = BitmapManager.a(paramString, null);
      if (paramString == null) {}
    }
    catch (OutOfMemoryError localOutOfMemoryError1)
    {
      paramString = null;
      System.gc();
      QLog.w("AlbumImageProxy", 2, localOutOfMemoryError1.toString());
      return paramString;
    }
    catch (Exception localException1)
    {
      paramString = null;
      QLog.w("AlbumImageProxy", 2, localException1.toString());
      return paramString;
    }
    try
    {
      this.jdField_b_of_type_Int = 1;
      return paramString;
    }
    catch (Exception localException2)
    {
      break label88;
    }
    catch (OutOfMemoryError localOutOfMemoryError2)
    {
      break label70;
    }
    if (jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      this.jdField_b_of_type_Int = 0;
      jdField_a_of_type_AndroidGraphicsBitmap = SkinUtils.a(getResources().getDrawable(this.jdField_a_of_type_Int));
    }
    paramString = jdField_a_of_type_AndroidGraphicsBitmap;
    return paramString;
  }
  
  private void a(String paramString)
  {
    int i = CardHandler.c(BaseApplication.getContext());
    if (2 != this.jdField_b_of_type_Int) {
      new hfb(this, paramString, i).start();
    }
  }
  
  /* Error */
  public Bitmap a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload_1
    //   4: invokestatic 84	com/tencent/mobileqq/utils/HexUtil:a	(Ljava/lang/String;)Ljava/lang/String;
    //   7: iload_2
    //   8: invokestatic 87	com/tencent/mobileqq/app/CardHandler:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   11: astore 9
    //   13: new 143	java/io/File
    //   16: dup
    //   17: aload 9
    //   19: invokespecial 145	java/io/File:<init>	(Ljava/lang/String;)V
    //   22: astore 10
    //   24: aload 10
    //   26: invokevirtual 149	java/io/File:exists	()Z
    //   29: ifeq +250 -> 279
    //   32: aload 10
    //   34: invokevirtual 152	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   37: invokestatic 157	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/lang/String;)I
    //   40: istore 5
    //   42: aload_0
    //   43: invokevirtual 100	com/tencent/mobileqq/widget/AlbumImageProxy:getResources	()Landroid/content/res/Resources;
    //   46: invokevirtual 161	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   49: astore 11
    //   51: aload 11
    //   53: getfield 166	android/util/DisplayMetrics:widthPixels	I
    //   56: istore 6
    //   58: aload 11
    //   60: getfield 169	android/util/DisplayMetrics:heightPixels	I
    //   63: istore 7
    //   65: new 171	android/graphics/BitmapFactory$Options
    //   68: dup
    //   69: invokespecial 173	android/graphics/BitmapFactory$Options:<init>	()V
    //   72: astore 11
    //   74: new 175	java/io/FileInputStream
    //   77: dup
    //   78: aload 10
    //   80: invokespecial 178	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   83: astore 10
    //   85: aload 11
    //   87: aload 10
    //   89: iload 6
    //   91: iload 7
    //   93: invokestatic 181	com/tencent/mobileqq/utils/ImageUtil:a	(Ljava/io/InputStream;II)D
    //   96: d2i
    //   97: putfield 184	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   100: aload 10
    //   102: invokevirtual 189	java/io/InputStream:close	()V
    //   105: aload_0
    //   106: getfield 36	com/tencent/mobileqq/widget/AlbumImageProxy:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   109: invokevirtual 194	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   112: new 196	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   119: aload_1
    //   120: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload_2
    //   124: invokevirtual 204	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: invokevirtual 210	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   133: ifnonnull +193 -> 326
    //   136: aload 9
    //   138: aload 11
    //   140: invokestatic 92	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   143: astore 9
    //   145: aload 9
    //   147: astore 8
    //   149: aload 8
    //   151: ifnull +76 -> 227
    //   154: aload_0
    //   155: iconst_2
    //   156: putfield 94	com/tencent/mobileqq/widget/AlbumImageProxy:jdField_b_of_type_Int	I
    //   159: iload 5
    //   161: ifeq +171 -> 332
    //   164: iload 5
    //   166: bipush 90
    //   168: irem
    //   169: ifne +163 -> 332
    //   172: aload 8
    //   174: invokevirtual 216	android/graphics/Bitmap:getWidth	()I
    //   177: i2f
    //   178: fstore_3
    //   179: aload 8
    //   181: invokevirtual 219	android/graphics/Bitmap:getHeight	()I
    //   184: i2f
    //   185: fstore 4
    //   187: new 221	android/graphics/Matrix
    //   190: dup
    //   191: invokespecial 222	android/graphics/Matrix:<init>	()V
    //   194: astore 9
    //   196: aload 9
    //   198: iload 5
    //   200: i2f
    //   201: fload_3
    //   202: fconst_2
    //   203: fdiv
    //   204: fload 4
    //   206: fconst_2
    //   207: fdiv
    //   208: invokevirtual 226	android/graphics/Matrix:setRotate	(FFF)V
    //   211: aload 8
    //   213: iconst_0
    //   214: iconst_0
    //   215: fload_3
    //   216: f2i
    //   217: fload 4
    //   219: f2i
    //   220: aload 9
    //   222: iconst_1
    //   223: invokestatic 230	android/graphics/Bitmap:createBitmap	(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;
    //   226: areturn
    //   227: aload_0
    //   228: aload_1
    //   229: invokespecial 232	com/tencent/mobileqq/widget/AlbumImageProxy:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   232: astore 9
    //   234: aload 9
    //   236: areturn
    //   237: astore 9
    //   239: ldc 9
    //   241: iconst_2
    //   242: new 196	java/lang/StringBuilder
    //   245: dup
    //   246: invokespecial 197	java/lang/StringBuilder:<init>	()V
    //   249: ldc 234
    //   251: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   254: aload 9
    //   256: invokevirtual 121	java/lang/OutOfMemoryError:toString	()Ljava/lang/String;
    //   259: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 205	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 127	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   268: invokestatic 117	java/lang/System:gc	()V
    //   271: aload_0
    //   272: aload_1
    //   273: invokespecial 232	com/tencent/mobileqq/widget/AlbumImageProxy:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   276: astore_1
    //   277: aload_1
    //   278: areturn
    //   279: aload_0
    //   280: aload_1
    //   281: invokespecial 232	com/tencent/mobileqq/widget/AlbumImageProxy:a	(Ljava/lang/String;)Landroid/graphics/Bitmap;
    //   284: astore_1
    //   285: aload_1
    //   286: areturn
    //   287: astore_1
    //   288: aconst_null
    //   289: astore 8
    //   291: aload_1
    //   292: invokevirtual 237	java/io/IOException:printStackTrace	()V
    //   295: aload 8
    //   297: areturn
    //   298: astore_1
    //   299: aconst_null
    //   300: astore_1
    //   301: invokestatic 117	java/lang/System:gc	()V
    //   304: aload_1
    //   305: areturn
    //   306: astore_1
    //   307: aload 8
    //   309: astore_1
    //   310: goto -9 -> 301
    //   313: astore_1
    //   314: goto -23 -> 291
    //   317: astore_1
    //   318: goto -27 -> 291
    //   321: astore 9
    //   323: goto -84 -> 239
    //   326: aconst_null
    //   327: astore 8
    //   329: goto -180 -> 149
    //   332: aload 8
    //   334: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	335	0	this	AlbumImageProxy
    //   0	335	1	paramString	String
    //   0	335	2	paramInt	int
    //   178	38	3	f1	float
    //   185	33	4	f2	float
    //   40	159	5	i	int
    //   56	34	6	j	int
    //   63	29	7	k	int
    //   1	332	8	localObject1	java.lang.Object
    //   11	224	9	localObject2	java.lang.Object
    //   237	18	9	localOutOfMemoryError1	OutOfMemoryError
    //   321	1	9	localOutOfMemoryError2	OutOfMemoryError
    //   22	79	10	localObject3	java.lang.Object
    //   49	90	11	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   105	145	237	java/lang/OutOfMemoryError
    //   24	105	287	java/io/IOException
    //   105	145	287	java/io/IOException
    //   279	285	287	java/io/IOException
    //   24	105	298	java/lang/OutOfMemoryError
    //   279	285	298	java/lang/OutOfMemoryError
    //   239	277	306	java/lang/OutOfMemoryError
    //   154	159	313	java/io/IOException
    //   172	227	313	java/io/IOException
    //   227	234	313	java/io/IOException
    //   239	277	317	java/io/IOException
    //   154	159	321	java/lang/OutOfMemoryError
    //   172	227	321	java/lang/OutOfMemoryError
    //   227	234	321	java/lang/OutOfMemoryError
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return this.jdField_a_of_type_AndroidViewGestureDetector.onTouchEvent(paramMotionEvent);
  }
  
  public void setCacheImageBmp(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(this.jdField_b_of_type_JavaLangString);
      return;
    }
    setImageRotateBitmapResetBase(new RotateBitmap(null, 0), true);
    this.jdField_b_of_type_Int = -1;
  }
  
  public void setHexFileKey(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.AlbumImageProxy
 * JD-Core Version:    0.7.0.1
 */