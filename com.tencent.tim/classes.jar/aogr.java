import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.SingleLineTextView;
import java.io.File;

public class aogr
{
  private TypedValue a = new TypedValue();
  public boolean cLD;
  protected String ckF = "";
  private final Object fc = new Object();
  protected boolean mEnable = true;
  
  private TypedValue a()
  {
    TypedValue localTypedValue = null;
    synchronized (this.fc)
    {
      if (this.a != null)
      {
        localTypedValue = this.a;
        this.a = null;
      }
      ??? = localTypedValue;
      if (localTypedValue == null) {
        ??? = new TypedValue();
      }
      return ???;
    }
  }
  
  public static void a(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    int i = paramView.getPaddingTop();
    int j = paramView.getPaddingLeft();
    int k = paramView.getPaddingRight();
    int m = paramView.getPaddingBottom();
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(j, i, k, m);
  }
  
  private void a(String paramString, ColorStateList paramColorStateList)
  {
    BaseApplicationImpl.sImageCache.put(paramString, new Pair(paramColorStateList, Integer.valueOf(100)));
  }
  
  private void b(TypedValue paramTypedValue)
  {
    synchronized (this.fc)
    {
      if (this.a == null) {
        this.a = paramTypedValue;
      }
      return;
    }
  }
  
  private void e(String paramString, Drawable paramDrawable)
  {
    int i = paramDrawable.getIntrinsicHeight();
    int j = paramDrawable.getIntrinsicWidth();
    BaseApplicationImpl.sImageCache.put(paramString, new Pair(paramDrawable, Integer.valueOf(i * j * 4)));
  }
  
  private Object j(String paramString)
  {
    paramString = (Pair)BaseApplicationImpl.sImageCache.get(paramString);
    if (paramString == null) {
      return null;
    }
    return paramString.first;
  }
  
  protected void A(View paramView, int paramInt1, int paramInt2)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof TextView)) {
      ((TextView)localView).setTextColor(a(paramView.getContext(), paramInt2));
    }
    while (!(localView instanceof SingleLineTextView)) {
      return;
    }
    ((SingleLineTextView)localView).setTextColor(a(paramView.getContext(), paramInt2));
  }
  
  protected void B(View paramView, int paramInt1, int paramInt2)
  {
    paramView = paramView.findViewById(paramInt1);
    if (paramView != null) {
      paramView.setBackgroundDrawable(h(paramView.getContext(), paramInt2));
    }
  }
  
  public void RP(String paramString)
  {
    this.ckF = paramString;
  }
  
  /* Error */
  protected ColorStateList a(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 138	aogr:azB	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: getfield 21	aogr:ckF	Ljava/lang/String;
    //   11: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: iload_2
    //   22: invokevirtual 156	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: new 158	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: getfield 21	aogr:ckF	Ljava/lang/String;
    //   40: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 172	aogr:j	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +15 -> 70
    //   58: aload_3
    //   59: instanceof 174
    //   62: ifeq +8 -> 70
    //   65: aload_3
    //   66: checkcast 174	android/content/res/ColorStateList
    //   69: areturn
    //   70: aload_0
    //   71: invokespecial 176	aogr:a	()Landroid/util/TypedValue;
    //   74: astore_3
    //   75: aload_1
    //   76: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   79: iload_2
    //   80: aload_3
    //   81: iconst_1
    //   82: invokevirtual 180	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   85: aload_3
    //   86: getfield 184	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   89: checkcast 186	java/lang/String
    //   92: astore 4
    //   94: aload_0
    //   95: aload_3
    //   96: invokespecial 188	aogr:b	(Landroid/util/TypedValue;)V
    //   99: aload 4
    //   101: ifnull +192 -> 293
    //   104: new 158	java/lang/StringBuilder
    //   107: dup
    //   108: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   111: aload_0
    //   112: getfield 21	aogr:ckF	Ljava/lang/String;
    //   115: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   118: ldc 190
    //   120: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: aload 4
    //   125: aload 4
    //   127: ldc 192
    //   129: invokevirtual 196	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   132: iconst_1
    //   133: iadd
    //   134: invokevirtual 200	java/lang/String:substring	(I)Ljava/lang/String;
    //   137: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: astore_3
    //   144: new 202	java/io/File
    //   147: dup
    //   148: aload_3
    //   149: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   152: invokevirtual 207	java/io/File:exists	()Z
    //   155: ifeq +138 -> 293
    //   158: new 209	com/tencent/theme/AndroidXmlResourceParser
    //   161: dup
    //   162: invokespecial 210	com/tencent/theme/AndroidXmlResourceParser:<init>	()V
    //   165: astore 5
    //   167: new 212	java/io/FileInputStream
    //   170: dup
    //   171: new 202	java/io/File
    //   174: dup
    //   175: aload_3
    //   176: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   179: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   182: astore 4
    //   184: aload 4
    //   186: astore_3
    //   187: aload 5
    //   189: aload 4
    //   191: ldc 217
    //   193: invokeinterface 223 3 0
    //   198: aload 4
    //   200: astore_3
    //   201: invokestatic 229	com/tencent/theme/SkinEngine:getInstances	()Lcom/tencent/theme/SkinEngine;
    //   204: aload_1
    //   205: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   208: aload 5
    //   210: iconst_1
    //   211: invokestatic 235	com/tencent/theme/SkinnableColorStateList:createFromXml	(Lcom/tencent/theme/SkinEngine;Landroid/content/res/Resources;Lorg/xmlpull/v1/XmlPullParser;Z)Lcom/tencent/theme/SkinnableColorStateList;
    //   214: astore 5
    //   216: aload 4
    //   218: astore_3
    //   219: aload_0
    //   220: new 158	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   227: aload_0
    //   228: getfield 21	aogr:ckF	Ljava/lang/String;
    //   231: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: iload_2
    //   235: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   238: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: aload 5
    //   243: invokespecial 237	aogr:a	(Ljava/lang/String;Landroid/content/res/ColorStateList;)V
    //   246: aload 5
    //   248: astore_1
    //   249: aload 4
    //   251: ifnull -225 -> 26
    //   254: aload 4
    //   256: invokevirtual 242	java/io/InputStream:close	()V
    //   259: aload 5
    //   261: areturn
    //   262: astore_1
    //   263: aload_1
    //   264: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   267: aload 5
    //   269: areturn
    //   270: astore 5
    //   272: aconst_null
    //   273: astore 4
    //   275: aload 4
    //   277: astore_3
    //   278: aload 5
    //   280: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   283: aload 4
    //   285: ifnull +8 -> 293
    //   288: aload 4
    //   290: invokevirtual 242	java/io/InputStream:close	()V
    //   293: aload_1
    //   294: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   297: iload_2
    //   298: invokevirtual 156	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   301: areturn
    //   302: astore_3
    //   303: aload_3
    //   304: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   307: goto -14 -> 293
    //   310: astore 5
    //   312: aconst_null
    //   313: astore 4
    //   315: aload 4
    //   317: astore_3
    //   318: aload 5
    //   320: invokevirtual 246	org/xmlpull/v1/XmlPullParserException:printStackTrace	()V
    //   323: aload 4
    //   325: ifnull -32 -> 293
    //   328: aload 4
    //   330: invokevirtual 242	java/io/InputStream:close	()V
    //   333: goto -40 -> 293
    //   336: astore_3
    //   337: aload_3
    //   338: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   341: goto -48 -> 293
    //   344: astore_1
    //   345: aconst_null
    //   346: astore_3
    //   347: aload_3
    //   348: ifnull +7 -> 355
    //   351: aload_3
    //   352: invokevirtual 242	java/io/InputStream:close	()V
    //   355: aload_1
    //   356: athrow
    //   357: astore_3
    //   358: aload_3
    //   359: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   362: goto -7 -> 355
    //   365: astore_1
    //   366: goto -19 -> 347
    //   369: astore 5
    //   371: goto -56 -> 315
    //   374: astore 5
    //   376: goto -101 -> 275
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	379	0	this	aogr
    //   0	379	1	paramContext	Context
    //   0	379	2	paramInt	int
    //   53	225	3	localObject1	Object
    //   302	2	3	localIOException1	java.io.IOException
    //   317	1	3	localObject2	Object
    //   336	2	3	localIOException2	java.io.IOException
    //   346	6	3	localObject3	Object
    //   357	2	3	localIOException3	java.io.IOException
    //   92	237	4	localObject4	Object
    //   165	103	5	localObject5	Object
    //   270	9	5	localIOException4	java.io.IOException
    //   310	9	5	localXmlPullParserException1	org.xmlpull.v1.XmlPullParserException
    //   369	1	5	localXmlPullParserException2	org.xmlpull.v1.XmlPullParserException
    //   374	1	5	localIOException5	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   254	259	262	java/io/IOException
    //   158	184	270	java/io/IOException
    //   288	293	302	java/io/IOException
    //   158	184	310	org/xmlpull/v1/XmlPullParserException
    //   328	333	336	java/io/IOException
    //   158	184	344	finally
    //   351	355	357	java/io/IOException
    //   187	198	365	finally
    //   201	216	365	finally
    //   219	246	365	finally
    //   278	283	365	finally
    //   318	323	365	finally
    //   187	198	369	org/xmlpull/v1/XmlPullParserException
    //   201	216	369	org/xmlpull/v1/XmlPullParserException
    //   219	246	369	org/xmlpull/v1/XmlPullParserException
    //   187	198	374	java/io/IOException
    //   201	216	374	java/io/IOException
    //   219	246	374	java/io/IOException
  }
  
  /* Error */
  protected Drawable a(Context paramContext, int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 138	aogr:azB	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: getfield 21	aogr:ckF	Ljava/lang/String;
    //   11: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: iload_2
    //   22: invokevirtual 253	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: new 158	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: getfield 21	aogr:ckF	Ljava/lang/String;
    //   40: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 172	aogr:j	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore 4
    //   55: aload 4
    //   57: ifnull +17 -> 74
    //   60: aload 4
    //   62: instanceof 86
    //   65: ifeq +9 -> 74
    //   68: aload 4
    //   70: checkcast 86	android/graphics/drawable/Drawable
    //   73: areturn
    //   74: aload_0
    //   75: invokespecial 176	aogr:a	()Landroid/util/TypedValue;
    //   78: astore 5
    //   80: aload_1
    //   81: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   84: iload_2
    //   85: aload 5
    //   87: iconst_1
    //   88: invokevirtual 180	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   91: aload 5
    //   93: getfield 184	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   96: checkcast 186	java/lang/String
    //   99: astore 6
    //   101: aload_0
    //   102: aload 5
    //   104: invokespecial 188	aogr:b	(Landroid/util/TypedValue;)V
    //   107: aload 6
    //   109: ifnull +187 -> 296
    //   112: new 202	java/io/File
    //   115: dup
    //   116: new 158	java/lang/StringBuilder
    //   119: dup
    //   120: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   123: aload_0
    //   124: getfield 21	aogr:ckF	Ljava/lang/String;
    //   127: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc 192
    //   132: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_3
    //   136: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   145: astore_3
    //   146: aload_3
    //   147: invokevirtual 207	java/io/File:exists	()Z
    //   150: ifeq +146 -> 296
    //   153: new 255	android/graphics/Rect
    //   156: dup
    //   157: invokespecial 256	android/graphics/Rect:<init>	()V
    //   160: astore 7
    //   162: new 258	java/io/BufferedInputStream
    //   165: dup
    //   166: new 212	java/io/FileInputStream
    //   169: dup
    //   170: aload_3
    //   171: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   174: invokespecial 261	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   177: astore 4
    //   179: aload 4
    //   181: astore_3
    //   182: aload 5
    //   184: sipush 480
    //   187: putfield 265	android/util/TypedValue:density	I
    //   190: aload 4
    //   192: astore_3
    //   193: aload_1
    //   194: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   197: aload 5
    //   199: aload 4
    //   201: aload 6
    //   203: aconst_null
    //   204: aload 7
    //   206: iconst_1
    //   207: invokestatic 271	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   210: aload_1
    //   211: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   214: invokevirtual 277	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   217: astore 5
    //   219: aload 4
    //   221: astore_3
    //   222: aload_0
    //   223: new 158	java/lang/StringBuilder
    //   226: dup
    //   227: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   230: aload_0
    //   231: getfield 21	aogr:ckF	Ljava/lang/String;
    //   234: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: iload_2
    //   238: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: aload 5
    //   246: invokespecial 279	aogr:e	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   249: aload 5
    //   251: astore_1
    //   252: aload 4
    //   254: ifnull -228 -> 26
    //   257: aload 4
    //   259: invokevirtual 242	java/io/InputStream:close	()V
    //   262: aload 5
    //   264: areturn
    //   265: astore_1
    //   266: aload_1
    //   267: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   270: aload 5
    //   272: areturn
    //   273: astore 5
    //   275: aconst_null
    //   276: astore 4
    //   278: aload 4
    //   280: astore_3
    //   281: aload 5
    //   283: invokevirtual 280	java/lang/OutOfMemoryError:printStackTrace	()V
    //   286: aload 4
    //   288: ifnull +8 -> 296
    //   291: aload 4
    //   293: invokevirtual 242	java/io/InputStream:close	()V
    //   296: aload_1
    //   297: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   300: iload_2
    //   301: invokevirtual 253	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   304: areturn
    //   305: astore_3
    //   306: aload_3
    //   307: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   310: goto -14 -> 296
    //   313: astore 5
    //   315: aconst_null
    //   316: astore 4
    //   318: aload 4
    //   320: astore_3
    //   321: aload 5
    //   323: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   326: aload 4
    //   328: ifnull -32 -> 296
    //   331: aload 4
    //   333: invokevirtual 242	java/io/InputStream:close	()V
    //   336: goto -40 -> 296
    //   339: astore_3
    //   340: aload_3
    //   341: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   344: goto -48 -> 296
    //   347: astore_1
    //   348: aconst_null
    //   349: astore_3
    //   350: aload_3
    //   351: ifnull +7 -> 358
    //   354: aload_3
    //   355: invokevirtual 242	java/io/InputStream:close	()V
    //   358: aload_1
    //   359: athrow
    //   360: astore_3
    //   361: aload_3
    //   362: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   365: goto -7 -> 358
    //   368: astore_1
    //   369: goto -19 -> 350
    //   372: astore 5
    //   374: goto -56 -> 318
    //   377: astore 5
    //   379: goto -101 -> 278
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	382	0	this	aogr
    //   0	382	1	paramContext	Context
    //   0	382	2	paramInt	int
    //   0	382	3	paramString	String
    //   53	279	4	localObject1	Object
    //   78	193	5	localObject2	Object
    //   273	9	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   313	9	5	localIOException1	java.io.IOException
    //   372	1	5	localIOException2	java.io.IOException
    //   377	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   99	103	6	str	String
    //   160	45	7	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   257	262	265	java/io/IOException
    //   162	179	273	java/lang/OutOfMemoryError
    //   291	296	305	java/io/IOException
    //   162	179	313	java/io/IOException
    //   331	336	339	java/io/IOException
    //   162	179	347	finally
    //   354	358	360	java/io/IOException
    //   182	190	368	finally
    //   193	219	368	finally
    //   222	249	368	finally
    //   281	286	368	finally
    //   321	326	368	finally
    //   182	190	372	java/io/IOException
    //   193	219	372	java/io/IOException
    //   222	249	372	java/io/IOException
    //   182	190	377	java/lang/OutOfMemoryError
    //   193	219	377	java/lang/OutOfMemoryError
    //   222	249	377	java/lang/OutOfMemoryError
  }
  
  public StateListDrawable a(Context paramContext, int paramInt1, int paramInt2)
  {
    Drawable localDrawable = h(paramContext, paramInt1);
    paramContext = h(paramContext, paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[] { 16842919 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  protected void a(View paramView, int paramInt1, int paramInt2, String paramString)
  {
    paramView = paramView.findViewById(paramInt1);
    if (paramView != null) {
      paramView.setBackgroundDrawable(a(paramView.getContext(), paramInt2, paramString));
    }
  }
  
  public boolean azB()
  {
    return (this.cLD) && (this.mEnable);
  }
  
  protected void b(View paramView, int paramInt1, int paramInt2, String paramString)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof ImageView)) {
      ((ImageView)localView).setImageDrawable(a(paramView.getContext(), paramInt2, paramString));
    }
  }
  
  protected void e(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = paramView.findViewById(paramInt1);
    if ((localView instanceof ImageView)) {
      ((ImageView)localView).setImageDrawable(a(paramView.getContext(), paramInt2, paramInt3));
    }
  }
  
  protected void f(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    View localView = paramView.findViewById(paramInt1);
    if (localView != null) {
      localView.setBackgroundDrawable(a(paramView.getContext(), paramInt2, paramInt3));
    }
  }
  
  /* Error */
  protected Drawable h(Context paramContext, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 138	aogr:azB	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_0
    //   8: getfield 21	aogr:ckF	Ljava/lang/String;
    //   11: invokestatic 144	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   14: ifeq +14 -> 28
    //   17: aload_1
    //   18: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   21: iload_2
    //   22: invokevirtual 253	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   25: astore_1
    //   26: aload_1
    //   27: areturn
    //   28: aload_0
    //   29: new 158	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   36: aload_0
    //   37: getfield 21	aogr:ckF	Ljava/lang/String;
    //   40: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: iload_2
    //   44: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   47: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 172	aogr:j	(Ljava/lang/String;)Ljava/lang/Object;
    //   53: astore_3
    //   54: aload_3
    //   55: ifnull +15 -> 70
    //   58: aload_3
    //   59: instanceof 86
    //   62: ifeq +8 -> 70
    //   65: aload_3
    //   66: checkcast 86	android/graphics/drawable/Drawable
    //   69: areturn
    //   70: aload_0
    //   71: invokespecial 176	aogr:a	()Landroid/util/TypedValue;
    //   74: astore 5
    //   76: aload_1
    //   77: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   80: iload_2
    //   81: aload 5
    //   83: iconst_1
    //   84: invokevirtual 180	android/content/res/Resources:getValue	(ILandroid/util/TypedValue;Z)V
    //   87: aload 5
    //   89: getfield 184	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   92: checkcast 186	java/lang/String
    //   95: astore 6
    //   97: aload_0
    //   98: aload 5
    //   100: invokespecial 188	aogr:b	(Landroid/util/TypedValue;)V
    //   103: aload 6
    //   105: ifnull +198 -> 303
    //   108: new 202	java/io/File
    //   111: dup
    //   112: new 158	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   119: aload_0
    //   120: getfield 21	aogr:ckF	Ljava/lang/String;
    //   123: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: ldc_w 306
    //   129: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload 6
    //   134: aload 6
    //   136: ldc 192
    //   138: invokevirtual 196	java/lang/String:lastIndexOf	(Ljava/lang/String;)I
    //   141: iconst_1
    //   142: iadd
    //   143: invokevirtual 200	java/lang/String:substring	(I)Ljava/lang/String;
    //   146: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   152: invokespecial 204	java/io/File:<init>	(Ljava/lang/String;)V
    //   155: astore_3
    //   156: aload_3
    //   157: invokevirtual 207	java/io/File:exists	()Z
    //   160: ifeq +143 -> 303
    //   163: new 255	android/graphics/Rect
    //   166: dup
    //   167: invokespecial 256	android/graphics/Rect:<init>	()V
    //   170: astore 7
    //   172: aload 5
    //   174: sipush 480
    //   177: putfield 265	android/util/TypedValue:density	I
    //   180: new 258	java/io/BufferedInputStream
    //   183: dup
    //   184: new 212	java/io/FileInputStream
    //   187: dup
    //   188: aload_3
    //   189: invokespecial 215	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   192: invokespecial 261	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   195: astore 4
    //   197: aload 4
    //   199: astore_3
    //   200: aload_1
    //   201: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   204: aload 5
    //   206: aload 4
    //   208: aload 6
    //   210: aconst_null
    //   211: aload 7
    //   213: iconst_1
    //   214: invokestatic 271	com/tencent/theme/ResourcesFactory:createImageFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;Landroid/graphics/Rect;Z)Lcom/tencent/theme/BaseConstantState;
    //   217: aload_1
    //   218: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   221: invokevirtual 277	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   224: astore 5
    //   226: aload 4
    //   228: astore_3
    //   229: aload_0
    //   230: new 158	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 159	java/lang/StringBuilder:<init>	()V
    //   237: aload_0
    //   238: getfield 21	aogr:ckF	Ljava/lang/String;
    //   241: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: iload_2
    //   245: invokevirtual 166	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   248: invokevirtual 170	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   251: aload 5
    //   253: invokespecial 279	aogr:e	(Ljava/lang/String;Landroid/graphics/drawable/Drawable;)V
    //   256: aload 5
    //   258: astore_1
    //   259: aload 4
    //   261: ifnull -235 -> 26
    //   264: aload 4
    //   266: invokevirtual 242	java/io/InputStream:close	()V
    //   269: aload 5
    //   271: areturn
    //   272: astore_1
    //   273: aload_1
    //   274: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   277: aload 5
    //   279: areturn
    //   280: astore 5
    //   282: aconst_null
    //   283: astore 4
    //   285: aload 4
    //   287: astore_3
    //   288: aload 5
    //   290: invokevirtual 280	java/lang/OutOfMemoryError:printStackTrace	()V
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 242	java/io/InputStream:close	()V
    //   303: aload_1
    //   304: invokevirtual 150	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   307: iload_2
    //   308: invokevirtual 253	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   311: areturn
    //   312: astore_3
    //   313: aload_3
    //   314: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   317: goto -14 -> 303
    //   320: astore 5
    //   322: aconst_null
    //   323: astore 4
    //   325: aload 4
    //   327: astore_3
    //   328: aload 5
    //   330: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   333: aload 4
    //   335: ifnull -32 -> 303
    //   338: aload 4
    //   340: invokevirtual 242	java/io/InputStream:close	()V
    //   343: goto -40 -> 303
    //   346: astore_3
    //   347: aload_3
    //   348: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   351: goto -48 -> 303
    //   354: astore_1
    //   355: aconst_null
    //   356: astore_3
    //   357: aload_3
    //   358: ifnull +7 -> 365
    //   361: aload_3
    //   362: invokevirtual 242	java/io/InputStream:close	()V
    //   365: aload_1
    //   366: athrow
    //   367: astore_3
    //   368: aload_3
    //   369: invokevirtual 245	java/io/IOException:printStackTrace	()V
    //   372: goto -7 -> 365
    //   375: astore_1
    //   376: goto -19 -> 357
    //   379: astore 5
    //   381: goto -56 -> 325
    //   384: astore 5
    //   386: goto -101 -> 285
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	389	0	this	aogr
    //   0	389	1	paramContext	Context
    //   0	389	2	paramInt	int
    //   53	235	3	localObject1	Object
    //   312	2	3	localIOException1	java.io.IOException
    //   327	1	3	localObject2	Object
    //   346	2	3	localIOException2	java.io.IOException
    //   356	6	3	localObject3	Object
    //   367	2	3	localIOException3	java.io.IOException
    //   195	144	4	localBufferedInputStream	java.io.BufferedInputStream
    //   74	204	5	localObject4	Object
    //   280	9	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   320	9	5	localIOException4	java.io.IOException
    //   379	1	5	localIOException5	java.io.IOException
    //   384	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   95	114	6	str	String
    //   170	42	7	localRect	android.graphics.Rect
    // Exception table:
    //   from	to	target	type
    //   264	269	272	java/io/IOException
    //   180	197	280	java/lang/OutOfMemoryError
    //   298	303	312	java/io/IOException
    //   180	197	320	java/io/IOException
    //   338	343	346	java/io/IOException
    //   180	197	354	finally
    //   361	365	367	java/io/IOException
    //   200	226	375	finally
    //   229	256	375	finally
    //   288	293	375	finally
    //   328	333	375	finally
    //   200	226	379	java/io/IOException
    //   229	256	379	java/io/IOException
    //   200	226	384	java/lang/OutOfMemoryError
    //   229	256	384	java/lang/OutOfMemoryError
  }
  
  protected Drawable i(Context paramContext, int paramInt)
  {
    if ((!azB()) || (TextUtils.isEmpty(this.ckF))) {
      return paramContext.getResources().getDrawable(paramInt);
    }
    Object localObject1 = j(this.ckF + paramInt);
    if ((localObject1 != null) && ((localObject1 instanceof Drawable))) {
      return (Drawable)localObject1;
    }
    localObject1 = a();
    paramContext.getResources().getValue(paramInt, (TypedValue)localObject1, true);
    Object localObject2 = (String)((TypedValue)localObject1).string;
    b((TypedValue)localObject1);
    if (localObject2 != null)
    {
      localObject1 = this.ckF + "/drawable-xxhdpi/" + ((String)localObject2).substring(((String)localObject2).lastIndexOf("/") + 1);
      if (new File((String)localObject1).exists())
      {
        localObject2 = new BitmapFactory.Options();
        ((BitmapFactory.Options)localObject2).inDensity = 480;
        ((BitmapFactory.Options)localObject2).inTargetDensity = paramContext.getResources().getDisplayMetrics().densityDpi;
        aqcu.a locala = new aqcu.a();
        aqcu.a((String)localObject1, (BitmapFactory.Options)localObject2, locala);
        if (locala.iResult == 0)
        {
          paramContext = new afeh(paramContext.getResources(), locala.bmp);
          e(this.ckF + paramInt, paramContext);
          return paramContext;
        }
        QLog.e("SkinDrawable", 1, (String)localObject1 + " decodeFail: " + locala.iResult);
      }
    }
    return paramContext.getResources().getDrawable(paramInt);
  }
  
  protected String om(String paramString)
  {
    return this.ckF + "/anim/" + paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aogr
 * JD-Core Version:    0.7.0.1
 */