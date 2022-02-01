package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public class ComponentContentPgcVideo
  extends ComponentContentBigImageVideo
{
  public ComponentContentPgcVideo(Context paramContext)
  {
    super(paramContext);
  }
  
  public ComponentContentPgcVideo(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public ComponentContentPgcVideo(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  /* Error */
  public void aNf()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: getfield 23	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:a	Lmas;
    //   7: getfield 28	mas:a	Llie;
    //   10: ifnull +314 -> 324
    //   13: aload_0
    //   14: getfield 23	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:a	Lmas;
    //   17: getfield 28	mas:a	Llie;
    //   20: invokeinterface 33 1 0
    //   25: ifnull +299 -> 324
    //   28: aload_0
    //   29: getfield 23	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:a	Lmas;
    //   32: getfield 28	mas:a	Llie;
    //   35: invokeinterface 33 1 0
    //   40: astore 7
    //   42: aload 7
    //   44: ifnull +386 -> 430
    //   47: aload 7
    //   49: getfield 39	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mJsonVideoList	Ljava/lang/String;
    //   52: invokestatic 45	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   55: ifne +375 -> 430
    //   58: new 47	org/json/JSONObject
    //   61: dup
    //   62: aload 7
    //   64: getfield 39	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mJsonVideoList	Ljava/lang/String;
    //   67: invokespecial 50	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   70: ldc 52
    //   72: invokevirtual 56	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   75: astore 6
    //   77: aload 6
    //   79: ifnull +407 -> 486
    //   82: aload 6
    //   84: invokevirtual 62	org/json/JSONArray:length	()I
    //   87: ifle +399 -> 486
    //   90: aload 6
    //   92: iconst_0
    //   93: invokevirtual 66	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   96: astore 6
    //   98: aload 6
    //   100: ifnull +386 -> 486
    //   103: aload 6
    //   105: ldc 68
    //   107: invokevirtual 72	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   110: istore_1
    //   111: aload 6
    //   113: ldc 74
    //   115: invokevirtual 72	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   118: istore_2
    //   119: iload_2
    //   120: ifeq +204 -> 324
    //   123: iload_1
    //   124: ifeq +200 -> 324
    //   127: aload_0
    //   128: invokevirtual 78	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   131: astore 6
    //   133: aload_0
    //   134: invokevirtual 82	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getResources	()Landroid/content/res/Resources;
    //   137: invokevirtual 88	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   140: astore 8
    //   142: aload 8
    //   144: getfield 94	android/util/DisplayMetrics:widthPixels	I
    //   147: aload 8
    //   149: getfield 97	android/util/DisplayMetrics:heightPixels	I
    //   152: invokestatic 103	java/lang/Math:min	(II)I
    //   155: istore_3
    //   156: ldc 104
    //   158: aload_0
    //   159: invokevirtual 82	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getResources	()Landroid/content/res/Resources;
    //   162: invokestatic 110	wja:dp2px	(FLandroid/content/res/Resources;)I
    //   165: istore 4
    //   167: aload_0
    //   168: getfield 114	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:v	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   171: invokevirtual 117	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:getLayoutParams	()Landroid/view/ViewGroup$LayoutParams;
    //   174: astore 8
    //   176: iload_2
    //   177: iload_1
    //   178: invokestatic 123	kxm:X	(II)Z
    //   181: ifne +6 -> 187
    //   184: iconst_1
    //   185: istore 5
    //   187: ldc 125
    //   189: iconst_2
    //   190: new 127	java/lang/StringBuilder
    //   193: dup
    //   194: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   197: ldc 131
    //   199: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: iload 5
    //   204: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   207: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   213: iload 5
    //   215: ifeq +131 -> 346
    //   218: iload_3
    //   219: iload 4
    //   221: iconst_2
    //   222: imul
    //   223: isub
    //   224: istore_2
    //   225: iload_2
    //   226: bipush 9
    //   228: imul
    //   229: bipush 16
    //   231: idiv
    //   232: istore_1
    //   233: aload 8
    //   235: iload_2
    //   236: putfield 152	android/view/ViewGroup$LayoutParams:width	I
    //   239: aload 8
    //   241: iload_1
    //   242: putfield 154	android/view/ViewGroup$LayoutParams:height	I
    //   245: aload 6
    //   247: iload_2
    //   248: putfield 152	android/view/ViewGroup$LayoutParams:width	I
    //   251: aload 6
    //   253: iload_1
    //   254: putfield 154	android/view/ViewGroup$LayoutParams:height	I
    //   257: aload_0
    //   258: getfield 114	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:v	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   261: getstatic 160	android/widget/ImageView$ScaleType:CENTER_CROP	Landroid/widget/ImageView$ScaleType;
    //   264: invokevirtual 164	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setScaleType	(Landroid/widget/ImageView$ScaleType;)V
    //   267: aload_0
    //   268: getfield 114	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:v	Lcom/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView;
    //   271: aload 8
    //   273: invokevirtual 168	com/tencent/biz/pubaccount/readinjoy/view/KandianUrlImageView:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   276: aload_0
    //   277: aload 6
    //   279: invokevirtual 169	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:setLayoutParams	(Landroid/view/ViewGroup$LayoutParams;)V
    //   282: ldc 125
    //   284: iconst_2
    //   285: new 127	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   292: ldc 171
    //   294: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 8
    //   299: getfield 152	android/view/ViewGroup$LayoutParams:width	I
    //   302: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc 176
    //   307: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload 8
    //   312: getfield 154	android/view/ViewGroup$LayoutParams:height	I
    //   315: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   318: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   324: return
    //   325: astore 6
    //   327: iconst_0
    //   328: istore_1
    //   329: ldc 178
    //   331: iconst_2
    //   332: aload 6
    //   334: iconst_0
    //   335: anewarray 180	java/lang/Object
    //   338: invokestatic 183	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   341: iconst_0
    //   342: istore_2
    //   343: goto -224 -> 119
    //   346: aload 7
    //   348: getfield 187	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mChannelID	J
    //   351: lconst_0
    //   352: lcmp
    //   353: ifne +51 -> 404
    //   356: iload_3
    //   357: aload_0
    //   358: invokevirtual 82	com/tencent/biz/pubaccount/readinjoy/rebuild/cmp/ComponentContentPgcVideo:getResources	()Landroid/content/res/Resources;
    //   361: invokestatic 192	kwz:a	(ILandroid/content/res/Resources;)I
    //   364: istore_1
    //   365: ldc 125
    //   367: iconst_2
    //   368: new 127	java/lang/StringBuilder
    //   371: dup
    //   372: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   375: ldc 194
    //   377: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: iload_1
    //   381: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   384: ldc 196
    //   386: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload_1
    //   390: invokevirtual 174	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iload_1
    //   400: istore_2
    //   401: goto -168 -> 233
    //   404: iload_3
    //   405: iload 4
    //   407: iconst_2
    //   408: imul
    //   409: isub
    //   410: bipush 9
    //   412: iadd
    //   413: iconst_2
    //   414: idiv
    //   415: istore_2
    //   416: iload_3
    //   417: iload 4
    //   419: iconst_2
    //   420: imul
    //   421: isub
    //   422: iconst_3
    //   423: idiv
    //   424: iconst_2
    //   425: imul
    //   426: istore_1
    //   427: goto -194 -> 233
    //   430: aload 7
    //   432: ifnonnull +16 -> 448
    //   435: ldc 198
    //   437: astore 6
    //   439: ldc 178
    //   441: iconst_2
    //   442: aload 6
    //   444: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   447: return
    //   448: new 127	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   455: aload 7
    //   457: getfield 39	com/tencent/biz/pubaccount/readinjoy/struct/ArticleInfo:mJsonVideoList	Ljava/lang/String;
    //   460: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   463: ldc 200
    //   465: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: aload 7
    //   470: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   473: invokevirtual 142	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: astore 6
    //   478: goto -39 -> 439
    //   481: astore 6
    //   483: goto -154 -> 329
    //   486: iconst_0
    //   487: istore_1
    //   488: iconst_0
    //   489: istore_2
    //   490: goto -371 -> 119
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	493	0	this	ComponentContentPgcVideo
    //   110	378	1	i	int
    //   118	372	2	j	int
    //   155	267	3	k	int
    //   165	256	4	m	int
    //   1	213	5	bool	boolean
    //   75	203	6	localObject1	java.lang.Object
    //   325	8	6	localJSONException1	org.json.JSONException
    //   437	40	6	str	java.lang.String
    //   481	1	6	localJSONException2	org.json.JSONException
    //   40	429	7	localArticleInfo	com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo
    //   140	171	8	localObject2	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   58	77	325	org/json/JSONException
    //   82	98	325	org/json/JSONException
    //   103	111	325	org/json/JSONException
    //   111	119	481	org/json/JSONException
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560310, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentPgcVideo
 * JD-Core Version:    0.7.0.1
 */