import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import org.json.JSONObject;

public class uek
{
  public static int a(int paramInt, boolean paramBoolean)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return 0;
    case 3: 
      if (paramBoolean) {
        return 3;
      }
      return 1;
    case 4: 
      return 2;
    case 5: 
      return 4;
    }
    return 5;
  }
  
  public static int a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    int j = 2;
    int i;
    if ((TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) && (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.g)))
    {
      i = 1;
      if (a(paramContext, paramAdvertisementInfo)) {
        return 1;
      }
    }
    else
    {
      i = 2;
    }
    if (!TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.h)) {
      j = 0;
    }
    for (;;)
    {
      return j;
      if (TextUtils.isEmpty(paramAdvertisementInfo.mAdvertisementSoftInfo.jdField_f_of_type_JavaLangString)) {
        j = i;
      }
    }
  }
  
  public static int a(AdvertisementInfo paramAdvertisementInfo)
  {
    int j = -1;
    int i = j;
    if (paramAdvertisementInfo.mBusiJson != null)
    {
      paramAdvertisementInfo = paramAdvertisementInfo.mBusiJson.optString("article_ad_ext");
      i = j;
      if (TextUtils.isEmpty(paramAdvertisementInfo)) {}
    }
    try
    {
      i = new JSONObject(paramAdvertisementInfo).optInt("para_pos", 0);
      return i;
    }
    catch (Exception paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return -1;
  }
  
  /* Error */
  public static JSONObject a(Context paramContext, AdvertisementInfo paramAdvertisementInfo, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +10 -> 11
    //   4: aload_1
    //   5: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   8: ifnonnull +11 -> 19
    //   11: new 46	org/json/JSONObject
    //   14: dup
    //   15: invokespecial 69	org/json/JSONObject:<init>	()V
    //   18: areturn
    //   19: new 71	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params
    //   22: dup
    //   23: invokespecial 72	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:<init>	()V
    //   26: astore 9
    //   28: aload 9
    //   30: ldc 74
    //   32: putfield 77	com/tencent/gdtad/util/GdtDeviceInfoHelper$Params:businessIdForAidTicketAndTaidTicket	Ljava/lang/String;
    //   35: invokestatic 83	com/tencent/qphone/base/util/BaseApplication:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   38: aload 9
    //   40: invokestatic 89	com/tencent/gdtad/util/GdtDeviceInfoHelper:create	(Landroid/content/Context;Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Params;)Lcom/tencent/gdtad/util/GdtDeviceInfoHelper$Result;
    //   43: astore 9
    //   45: aload_1
    //   46: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   49: getfield 93	uga:jdField_c_of_type_Int	I
    //   52: istore 7
    //   54: aload_0
    //   55: aload_1
    //   56: invokestatic 95	uek:a	(Landroid/content/Context;Lcom/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo;)I
    //   59: istore 8
    //   61: new 46	org/json/JSONObject
    //   64: dup
    //   65: invokespecial 69	org/json/JSONObject:<init>	()V
    //   68: astore_0
    //   69: new 46	org/json/JSONObject
    //   72: dup
    //   73: invokespecial 69	org/json/JSONObject:<init>	()V
    //   76: astore 10
    //   78: aload 9
    //   80: ifnull +41 -> 121
    //   83: aload 9
    //   85: getfield 101	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:deviceInfo	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   88: ifnull +33 -> 121
    //   91: aload 10
    //   93: ldc 103
    //   95: invokestatic 109	ujw:b	()Ljava/lang/String;
    //   98: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   101: pop
    //   102: aload 10
    //   104: ldc 115
    //   106: aload 9
    //   108: getfield 101	com/tencent/gdtad/util/GdtDeviceInfoHelper$Result:deviceInfo	Ltencent/gdt/qq_ad_get$QQAdGet$DeviceInfo;
    //   111: getfield 121	tencent/gdt/qq_ad_get$QQAdGet$DeviceInfo:aid_ticket	Lcom/tencent/mobileqq/pb/PBStringField;
    //   114: invokevirtual 126	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   117: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   120: pop
    //   121: aload 10
    //   123: ldc 128
    //   125: aload_1
    //   126: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   129: getfield 93	uga:jdField_c_of_type_Int	I
    //   132: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   135: pop
    //   136: aload 10
    //   138: ldc 133
    //   140: aload_1
    //   141: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   144: getfield 136	uga:d	I
    //   147: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   150: pop
    //   151: aload 10
    //   153: ldc 138
    //   155: aload_1
    //   156: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   159: getfield 141	uga:e	I
    //   162: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   165: pop
    //   166: aload 10
    //   168: ldc 143
    //   170: aload_1
    //   171: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   174: getfield 146	uga:i	Ljava/lang/String;
    //   177: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   180: pop
    //   181: aload 10
    //   183: ldc 148
    //   185: aload_1
    //   186: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   189: getfield 151	uga:j	Ljava/lang/String;
    //   192: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   195: pop
    //   196: aload 10
    //   198: ldc 153
    //   200: aload_1
    //   201: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   204: getfield 155	uga:jdField_f_of_type_Int	I
    //   207: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   210: pop
    //   211: aload 10
    //   213: ldc 157
    //   215: aload_1
    //   216: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   219: getfield 159	uga:jdField_a_of_type_Int	I
    //   222: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   225: pop
    //   226: aload 10
    //   228: ldc 161
    //   230: aload_1
    //   231: getfield 164	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mRowKey	Ljava/lang/String;
    //   234: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   237: pop
    //   238: aload 10
    //   240: ldc 166
    //   242: aload_1
    //   243: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   246: getfield 169	uga:x	Ljava/lang/String;
    //   249: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   252: pop
    //   253: aload 10
    //   255: ldc 171
    //   257: new 46	org/json/JSONObject
    //   260: dup
    //   261: aload_1
    //   262: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   265: getfield 174	uga:n	Ljava/lang/String;
    //   268: invokespecial 54	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   271: ldc 171
    //   273: invokevirtual 178	org/json/JSONObject:opt	(Ljava/lang/String;)Ljava/lang/Object;
    //   276: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   279: pop
    //   280: iload 4
    //   282: iconst_m1
    //   283: if_icmpeq +13 -> 296
    //   286: aload 10
    //   288: ldc 180
    //   290: iload 4
    //   292: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   295: pop
    //   296: aload 10
    //   298: ldc 182
    //   300: aload_1
    //   301: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   304: getfield 184	uga:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   307: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   310: pop
    //   311: aload 10
    //   313: ldc 186
    //   315: iload 6
    //   317: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   320: pop
    //   321: aload 10
    //   323: ldc 188
    //   325: iload 5
    //   327: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   330: pop
    //   331: iload 7
    //   333: ifne +12 -> 345
    //   336: aload 10
    //   338: ldc 190
    //   340: iconst_1
    //   341: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   344: pop
    //   345: iload 7
    //   347: iconst_3
    //   348: if_icmpne +18 -> 366
    //   351: aload 10
    //   353: ldc 192
    //   355: aload_1
    //   356: getfield 14	com/tencent/biz/pubaccount/readinjoy/struct/AdvertisementInfo:mAdvertisementSoftInfo	Luga;
    //   359: getfield 195	uga:H	Ljava/lang/String;
    //   362: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   365: pop
    //   366: iload_2
    //   367: iconst_1
    //   368: if_icmpne +66 -> 434
    //   371: iload_3
    //   372: ifeq +12 -> 384
    //   375: aload 10
    //   377: ldc 197
    //   379: iload_3
    //   380: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   383: pop
    //   384: aload 10
    //   386: ldc 199
    //   388: iload 8
    //   390: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   393: pop
    //   394: aload 10
    //   396: ldc 201
    //   398: iconst_3
    //   399: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   402: pop
    //   403: aload_0
    //   404: ldc 203
    //   406: aload 10
    //   408: invokevirtual 206	org/json/JSONObject:toString	()Ljava/lang/String;
    //   411: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   414: pop
    //   415: aload_0
    //   416: areturn
    //   417: astore_1
    //   418: aload_1
    //   419: invokevirtual 207	org/json/JSONException:printStackTrace	()V
    //   422: aload_0
    //   423: areturn
    //   424: astore 9
    //   426: aload 9
    //   428: invokevirtual 207	org/json/JSONException:printStackTrace	()V
    //   431: goto -151 -> 280
    //   434: aload 10
    //   436: ldc 209
    //   438: iconst_3
    //   439: invokevirtual 131	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   442: pop
    //   443: aload_0
    //   444: ldc 211
    //   446: aload 10
    //   448: invokevirtual 206	org/json/JSONObject:toString	()Ljava/lang/String;
    //   451: invokevirtual 113	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   454: pop
    //   455: aload_0
    //   456: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	457	0	paramContext	Context
    //   0	457	1	paramAdvertisementInfo	AdvertisementInfo
    //   0	457	2	paramInt1	int
    //   0	457	3	paramInt2	int
    //   0	457	4	paramInt3	int
    //   0	457	5	paramInt4	int
    //   0	457	6	paramInt5	int
    //   52	297	7	i	int
    //   59	330	8	j	int
    //   26	81	9	localObject	Object
    //   424	3	9	localJSONException	org.json.JSONException
    //   76	371	10	localJSONObject	JSONObject
    // Exception table:
    //   from	to	target	type
    //   69	78	417	org/json/JSONException
    //   83	121	417	org/json/JSONException
    //   121	253	417	org/json/JSONException
    //   286	296	417	org/json/JSONException
    //   296	331	417	org/json/JSONException
    //   336	345	417	org/json/JSONException
    //   351	366	417	org/json/JSONException
    //   375	384	417	org/json/JSONException
    //   384	415	417	org/json/JSONException
    //   426	431	417	org/json/JSONException
    //   434	455	417	org/json/JSONException
    //   253	280	424	org/json/JSONException
  }
  
  public static void a(Context paramContext, ImageView paramImageView, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!TextUtils.isEmpty(paramString)) {
      for (;;)
      {
        try
        {
          URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
          localURLDrawableOptions.mRequestWidth = AIOUtils.dp2px(paramInt2, paramContext.getResources());
          localURLDrawableOptions.mRequestHeight = AIOUtils.dp2px(paramInt2, paramContext.getResources());
          if (paramInt3 != -1) {
            localURLDrawableOptions.mUseMemoryCache = false;
          }
          localURLDrawable = URLDrawable.getDrawable(new URL(paramString), localURLDrawableOptions);
          localURLDrawable.setTag(bgxc.b(localURLDrawableOptions.mRequestWidth, localURLDrawableOptions.mRequestHeight, AIOUtils.dp2px(paramInt1, paramContext.getResources())));
          if (paramInt3 != 0) {
            continue;
          }
          localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 1 });
          localURLDrawable.setDecodeHandler(bgxc.k);
        }
        catch (Exception paramContext)
        {
          URLDrawable localURLDrawable;
          if (!QLog.isColorLevel()) {
            return;
          }
          QLog.d("ReadInJoyCommonAdUtils", 2, "后台下发的url格式有问题：" + paramString);
          return;
          localURLDrawable.setDecodeHandler(bgxc.j);
          continue;
        }
        paramImageView.setImageDrawable(localURLDrawable);
        return;
        if (paramInt3 != 1) {
          continue;
        }
        localURLDrawable.setTag(new int[] { 0, 0, paramInt1, 3 });
        localURLDrawable.setDecodeHandler(bgxc.k);
      }
    }
  }
  
  public static void a(ReadInjoyHeaderAdDownloadView.SimpleRoundProgress paramSimpleRoundProgress)
  {
    if (paramSimpleRoundProgress != null)
    {
      paramSimpleRoundProgress.jdField_a_of_type_Int = Color.parseColor("#CCE5E5E5");
      paramSimpleRoundProgress.jdField_b_of_type_Int = Color.parseColor("#FF00CAFC");
      paramSimpleRoundProgress.jdField_a_of_type_Float = AIOUtils.dp2px(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_b_of_type_Float = AIOUtils.dp2px(1.5F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Float = AIOUtils.dp2px(7.0F, paramSimpleRoundProgress.getContext().getResources());
      paramSimpleRoundProgress.jdField_c_of_type_Int = 100;
      paramSimpleRoundProgress.e = 270;
      paramSimpleRoundProgress.d = 0;
      paramSimpleRoundProgress.jdField_f_of_type_Int = 1;
    }
  }
  
  private static boolean a(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    if ((paramAdvertisementInfo == null) || (paramContext == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo == null) || (paramAdvertisementInfo.mAdvertisementSoftInfo.g == null)) {}
    for (;;)
    {
      return false;
      try
      {
        Intent localIntent = new Intent();
        localIntent.setAction("android.intent.action.VIEW");
        localIntent.setData(Uri.parse(paramAdvertisementInfo.mAdvertisementSoftInfo.g));
        paramContext = localIntent.resolveActivityInfo(paramContext.getPackageManager(), 0);
        if (paramContext != null)
        {
          boolean bool = TextUtils.isEmpty(paramContext.packageName);
          if (!bool) {
            return true;
          }
        }
      }
      catch (Exception paramContext) {}
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uek
 * JD-Core Version:    0.7.0.1
 */