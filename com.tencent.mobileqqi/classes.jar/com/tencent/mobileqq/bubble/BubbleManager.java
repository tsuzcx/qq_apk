package com.tencent.mobileqq.bubble;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderFactory.DownloadConfig;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import fkt;
import fku;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BubbleManager
  implements Manager
{
  public static final String a;
  public static final Lock a;
  public static final String b = "%04d.png";
  public static final String c = "bubble_info";
  public static final String d = "file:///android_assets/bubbles/";
  public static final String e = "aio_user_bg_nor.9.png";
  public static final String f = "aio_user_pic_nor.9.png";
  public static final String g = "chat_bubble_thumbnail.png";
  protected static final String h = "Bubble_download_succ";
  protected static final String i = "Bubble_download_cancel";
  protected static final String j = "Bubble_download";
  public static final String k = "bubble_local.cfg";
  public static final String l = "id";
  public static final String m = "version";
  public static final String n = "update";
  public static final String o = "full_download";
  public static final String p = "updatelist";
  private static final String q = "http://imgcache.qq.com/club/item/avatar/zip/%1$d/a%2$d/%3$s";
  private static final String r = "http://imgcache.qq.com/club/item/avatar/json/%1$d/a%2$d/%3$s";
  float jdField_a_of_type_Float = 1.0F;
  protected Context a;
  protected Handler a;
  protected AppInterface a;
  public BubbleManager.BubbleInfoLruCache a;
  public BubbleManager.LruLinkedHashMap a;
  DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new fkt(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  private DownloaderFactory.DownloadConfig jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = null;
  private DownloaderFactory jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = null;
  public IPCDownloadListener a;
  private Boolean jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
  JSONArray jdField_a_of_type_OrgJsonJSONArray = null;
  DownloadListener b = new fku(this, "param_WIFIBubbleDownloadFlow", "param_XGBubbleDownloadFlow");
  
  static
  {
    jdField_a_of_type_JavaLangString = BubbleManager.class.getSimpleName();
    jdField_a_of_type_JavaUtilConcurrentLocksLock = new ReentrantLock();
  }
  
  public BubbleManager(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = null;
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = null;
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = null;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache = new BubbleManager.BubbleInfoLruCache(this, 10);
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap = new BubbleManager.LruLinkedHashMap(this, 6);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig = new DownloaderFactory.DownloadConfig(1, 2, true);
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory = ((DownloaderFactory)paramAppInterface.getManager(43));
    paramAppInterface = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics();
    if (paramAppInterface.density == 160.0F) {}
    for (float f1 = 1.0F;; f1 = paramAppInterface.density)
    {
      this.jdField_a_of_type_Float = f1;
      this.jdField_a_of_type_OrgJsonJSONArray = a();
      return;
    }
  }
  
  private int a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.equals("T")) {
        if (paramBoolean) {}
      }
      do
      {
        return 3;
        return 4;
        if (paramString.equals("L"))
        {
          if (!paramBoolean) {
            return 2;
          }
          return 7;
        }
        if (paramString.equals("TL"))
        {
          if (!paramBoolean) {
            return 0;
          }
          return 5;
        }
        if (!paramString.equals("B")) {
          break;
        }
      } while (paramBoolean);
      return 4;
      if (paramString.equals("BL"))
      {
        if (!paramBoolean) {
          return 1;
        }
        return 6;
      }
      if (paramString.equals("R"))
      {
        if (!paramBoolean) {
          return 7;
        }
        return 2;
      }
      if (paramString.equals("TR"))
      {
        if (!paramBoolean) {
          return 5;
        }
        return 0;
      }
      if (paramString.equals("BR"))
      {
        if (!paramBoolean) {
          return 6;
        }
        return 1;
      }
    }
    return -1;
  }
  
  private Rect a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    Rect localRect = new Rect();
    localRect.set((int)(paramInt1 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt2 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt3 / 2.0F * this.jdField_a_of_type_Float), (int)(paramInt4 / 2.0F * this.jdField_a_of_type_Float));
    return localRect;
  }
  
  private AnimationConfig a(int paramInt, String paramString)
  {
    Object localObject = a(paramInt, true);
    if (localObject == null) {
      return null;
    }
    if ("voice".equals(paramString)) {
      return ((BubbleConfig)localObject).jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if ("height".equals(paramString)) {
      return ((BubbleConfig)localObject).jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig;
    }
    if (((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList != null)
    {
      localObject = ((BubbleConfig)localObject).jdField_a_of_type_JavaUtilArrayList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        AnimationConfig localAnimationConfig = (AnimationConfig)((Iterator)localObject).next();
        if (localAnimationConfig.jdField_a_of_type_JavaLangString.equals(paramString)) {
          return localAnimationConfig;
        }
      }
    }
    return null;
  }
  
  private AnimationConfig a(int paramInt, JSONObject paramJSONObject)
  {
    AnimationConfig localAnimationConfig = new AnimationConfig();
    localAnimationConfig.e = paramInt;
    if (paramJSONObject.has("version")) {
      localAnimationConfig.d = paramJSONObject.getInt("version");
    }
    JSONArray localJSONArray = paramJSONObject.getJSONArray("rect");
    localAnimationConfig.jdField_a_of_type_ArrayOfInt = new int[4];
    paramInt = 0;
    while (paramInt < localJSONArray.length())
    {
      localAnimationConfig.jdField_a_of_type_ArrayOfInt[paramInt] = localJSONArray.getInt(paramInt);
      paramInt += 1;
    }
    if (paramJSONObject.has("cycle_count")) {
      localAnimationConfig.f = paramJSONObject.getInt("cycle_count");
    }
    if (paramJSONObject.has("count")) {
      localAnimationConfig.g = paramJSONObject.getInt("count");
    }
    if (paramJSONObject.has("zip_name")) {
      localAnimationConfig.jdField_a_of_type_JavaLangString = paramJSONObject.getString("zip_name");
    }
    if (paramJSONObject.has("second_zip_name")) {
      localAnimationConfig.jdField_b_of_type_JavaLangString = paramJSONObject.getString("second_zip_name");
    }
    if (paramJSONObject.has("align")) {
      localAnimationConfig.c = paramJSONObject.getString("align");
    }
    localAnimationConfig.h = paramJSONObject.getInt("time");
    return localAnimationConfig;
  }
  
  /* Error */
  private BubbleConfig a(int paramInt, String paramString)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4: ifeq +5 -> 9
    //   7: aconst_null
    //   8: areturn
    //   9: aload_0
    //   10: aload_2
    //   11: invokespecial 336	com/tencent/mobileqq/bubble/BubbleManager:a	(Ljava/lang/String;)Ljava/lang/String;
    //   14: astore_2
    //   15: aload_2
    //   16: invokestatic 194	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   19: ifne -12 -> 7
    //   22: getstatic 341	android/os/Build$VERSION:SDK_INT	I
    //   25: bipush 10
    //   27: if_icmpgt +717 -> 744
    //   30: aload_2
    //   31: invokevirtual 342	java/lang/String:length	()I
    //   34: iconst_1
    //   35: if_icmple +709 -> 744
    //   38: aload_2
    //   39: iconst_0
    //   40: invokevirtual 346	java/lang/String:charAt	(I)C
    //   43: ldc_w 347
    //   46: if_icmpne +698 -> 744
    //   49: aload_2
    //   50: iconst_1
    //   51: invokevirtual 351	java/lang/String:substring	(I)Ljava/lang/String;
    //   54: astore_2
    //   55: new 232	com/tencent/mobileqq/bubble/BubbleConfig
    //   58: dup
    //   59: iload_1
    //   60: invokespecial 354	com/tencent/mobileqq/bubble/BubbleConfig:<init>	(I)V
    //   63: astore 6
    //   65: new 268	org/json/JSONObject
    //   68: dup
    //   69: aload_2
    //   70: invokespecial 357	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   73: astore 7
    //   75: aload 6
    //   77: aload 7
    //   79: ldc_w 359
    //   82: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   85: putfield 361	com/tencent/mobileqq/bubble/BubbleConfig:j	Ljava/lang/String;
    //   88: aload 6
    //   90: aload 7
    //   92: ldc 45
    //   94: invokevirtual 276	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   97: putfield 363	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_Int	I
    //   100: aload 7
    //   102: ldc_w 365
    //   105: invokevirtual 272	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   108: ifeq +62 -> 170
    //   111: aload 7
    //   113: ldc_w 365
    //   116: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   119: astore 5
    //   121: aload 5
    //   123: astore_2
    //   124: aload 5
    //   126: ldc_w 367
    //   129: invokevirtual 370	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifeq +10 -> 142
    //   135: aload 5
    //   137: iconst_2
    //   138: invokevirtual 351	java/lang/String:substring	(I)Ljava/lang/String;
    //   141: astore_2
    //   142: aload 6
    //   144: new 372	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 375
    //   154: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: aload_2
    //   158: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   164: invokestatic 387	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   167: putfield 389	com/tencent/mobileqq/bubble/BubbleConfig:c	I
    //   170: aload 7
    //   172: ldc_w 391
    //   175: invokevirtual 272	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   178: ifeq +62 -> 240
    //   181: aload 7
    //   183: ldc_w 391
    //   186: invokevirtual 310	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   189: astore 5
    //   191: aload 5
    //   193: astore_2
    //   194: aload 5
    //   196: ldc_w 367
    //   199: invokevirtual 370	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   202: ifeq +10 -> 212
    //   205: aload 5
    //   207: iconst_2
    //   208: invokevirtual 351	java/lang/String:substring	(I)Ljava/lang/String;
    //   211: astore_2
    //   212: aload 6
    //   214: new 372	java/lang/StringBuilder
    //   217: dup
    //   218: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   221: ldc_w 375
    //   224: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: aload_2
    //   228: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 387	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   237: putfield 392	com/tencent/mobileqq/bubble/BubbleConfig:d	I
    //   240: aload 7
    //   242: ldc_w 394
    //   245: invokevirtual 272	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   248: ifeq +21 -> 269
    //   251: aload 6
    //   253: aload 7
    //   255: ldc_w 394
    //   258: invokevirtual 398	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   261: ldc 45
    //   263: invokevirtual 276	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   266: putfield 399	com/tencent/mobileqq/bubble/BubbleConfig:e	I
    //   269: aload 7
    //   271: ldc_w 401
    //   274: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   277: astore_2
    //   278: aload 6
    //   280: iconst_2
    //   281: newarray int
    //   283: dup
    //   284: iconst_0
    //   285: aload_2
    //   286: iconst_0
    //   287: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   290: iastore
    //   291: dup
    //   292: iconst_1
    //   293: aload_2
    //   294: iconst_1
    //   295: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   298: iastore
    //   299: putfield 402	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ArrayOfInt	[I
    //   302: aload 7
    //   304: ldc_w 404
    //   307: invokevirtual 272	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   310: ifeq +29 -> 339
    //   313: aload_0
    //   314: iconst_0
    //   315: aload 7
    //   317: ldc_w 404
    //   320: invokevirtual 398	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   323: invokespecial 406	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   326: astore_2
    //   327: aload_2
    //   328: ldc 230
    //   330: putfield 261	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   333: aload 6
    //   335: aload_2
    //   336: putfield 235	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   339: aload 7
    //   341: ldc_w 408
    //   344: invokevirtual 272	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   347: ifeq +68 -> 415
    //   350: aload 7
    //   352: ldc_w 408
    //   355: invokevirtual 398	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   358: astore 5
    //   360: aload_0
    //   361: iconst_2
    //   362: aload 5
    //   364: invokespecial 406	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   367: astore_2
    //   368: aload 5
    //   370: ldc_w 410
    //   373: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   376: astore 5
    //   378: aload_2
    //   379: iconst_2
    //   380: newarray int
    //   382: dup
    //   383: iconst_0
    //   384: aload 5
    //   386: iconst_0
    //   387: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   390: iastore
    //   391: dup
    //   392: iconst_1
    //   393: aload 5
    //   395: iconst_1
    //   396: invokevirtual 296	org/json/JSONArray:getInt	(I)I
    //   399: iastore
    //   400: putfield 412	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfInt	[I
    //   403: aload_2
    //   404: ldc 237
    //   406: putfield 261	com/tencent/mobileqq/bubble/AnimationConfig:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   409: aload 6
    //   411: aload_2
    //   412: putfield 239	com/tencent/mobileqq/bubble/BubbleConfig:jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig	Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   415: aload 7
    //   417: ldc_w 414
    //   420: invokevirtual 272	org/json/JSONObject:has	(Ljava/lang/String;)Z
    //   423: ifeq +253 -> 676
    //   426: aload 7
    //   428: ldc_w 414
    //   431: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   434: astore_2
    //   435: new 244	java/util/ArrayList
    //   438: dup
    //   439: invokespecial 415	java/util/ArrayList:<init>	()V
    //   442: astore 5
    //   444: iconst_0
    //   445: istore_3
    //   446: iload_3
    //   447: aload_2
    //   448: invokevirtual 293	org/json/JSONArray:length	()I
    //   451: if_icmpge +218 -> 669
    //   454: aload_2
    //   455: iload_3
    //   456: invokevirtual 418	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   459: astore 8
    //   461: aload_0
    //   462: iconst_1
    //   463: aload 8
    //   465: invokespecial 406	com/tencent/mobileqq/bubble/BubbleManager:a	(ILorg/json/JSONObject;)Lcom/tencent/mobileqq/bubble/AnimationConfig;
    //   468: astore 7
    //   470: aload 8
    //   472: ldc_w 420
    //   475: invokevirtual 284	org/json/JSONObject:getJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   478: astore 8
    //   480: aload 7
    //   482: aload 8
    //   484: invokevirtual 293	org/json/JSONArray:length	()I
    //   487: anewarray 198	java/lang/String
    //   490: putfield 423	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   493: iconst_0
    //   494: istore 4
    //   496: iload 4
    //   498: aload 8
    //   500: invokevirtual 293	org/json/JSONArray:length	()I
    //   503: if_icmpge +151 -> 654
    //   506: aload 7
    //   508: getfield 423	com/tencent/mobileqq/bubble/AnimationConfig:jdField_b_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   511: iload 4
    //   513: aload 8
    //   515: iload 4
    //   517: invokevirtual 425	org/json/JSONArray:getString	(I)Ljava/lang/String;
    //   520: aastore
    //   521: iload 4
    //   523: iconst_1
    //   524: iadd
    //   525: istore 4
    //   527: goto -31 -> 496
    //   530: astore_2
    //   531: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq -364 -> 170
    //   537: getstatic 82	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   540: iconst_2
    //   541: ldc_w 432
    //   544: invokestatic 435	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: goto -377 -> 170
    //   550: astore_2
    //   551: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   554: ifeq -547 -> 7
    //   557: getstatic 82	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   560: iconst_2
    //   561: new 372	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 437
    //   571: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iload_1
    //   575: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   578: ldc_w 442
    //   581: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   587: invokestatic 445	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   590: aconst_null
    //   591: areturn
    //   592: astore_2
    //   593: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   596: ifeq -356 -> 240
    //   599: getstatic 82	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   602: iconst_2
    //   603: ldc_w 447
    //   606: invokestatic 435	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: goto -369 -> 240
    //   612: astore_2
    //   613: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq -609 -> 7
    //   619: getstatic 82	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   622: iconst_2
    //   623: new 372	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   630: ldc_w 437
    //   633: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   636: iload_1
    //   637: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   640: ldc_w 449
    //   643: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   649: invokestatic 445	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   652: aconst_null
    //   653: areturn
    //   654: aload 5
    //   656: aload 7
    //   658: invokevirtual 452	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   661: pop
    //   662: iload_3
    //   663: iconst_1
    //   664: iadd
    //   665: istore_3
    //   666: goto -220 -> 446
    //   669: aload 6
    //   671: aload 5
    //   673: putfield 242	com/tencent/mobileqq/bubble/BubbleConfig:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   676: aload 6
    //   678: areturn
    //   679: astore_2
    //   680: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   683: ifeq -676 -> 7
    //   686: getstatic 82	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   689: iconst_2
    //   690: new 372	java/lang/StringBuilder
    //   693: dup
    //   694: invokespecial 373	java/lang/StringBuilder:<init>	()V
    //   697: ldc_w 437
    //   700: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: iload_1
    //   704: invokevirtual 440	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   707: ldc_w 454
    //   710: invokevirtual 379	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: aload_2
    //   714: invokevirtual 457	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   717: invokevirtual 382	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   720: invokestatic 445	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   723: aconst_null
    //   724: areturn
    //   725: astore_2
    //   726: invokestatic 430	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   729: ifeq -722 -> 7
    //   732: getstatic 82	com/tencent/mobileqq/bubble/BubbleManager:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   735: iconst_2
    //   736: ldc_w 459
    //   739: invokestatic 445	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: aconst_null
    //   743: areturn
    //   744: goto -689 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	747	0	this	BubbleManager
    //   0	747	1	paramInt	int
    //   0	747	2	paramString	String
    //   445	221	3	i1	int
    //   494	32	4	i2	int
    //   119	553	5	localObject1	Object
    //   63	614	6	localBubbleConfig	BubbleConfig
    //   73	584	7	localObject2	Object
    //   459	55	8	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   142	170	530	java/lang/Exception
    //   9	55	550	java/io/FileNotFoundException
    //   55	121	550	java/io/FileNotFoundException
    //   124	142	550	java/io/FileNotFoundException
    //   142	170	550	java/io/FileNotFoundException
    //   170	191	550	java/io/FileNotFoundException
    //   194	212	550	java/io/FileNotFoundException
    //   212	240	550	java/io/FileNotFoundException
    //   240	269	550	java/io/FileNotFoundException
    //   269	339	550	java/io/FileNotFoundException
    //   339	415	550	java/io/FileNotFoundException
    //   415	444	550	java/io/FileNotFoundException
    //   446	493	550	java/io/FileNotFoundException
    //   496	521	550	java/io/FileNotFoundException
    //   531	547	550	java/io/FileNotFoundException
    //   593	609	550	java/io/FileNotFoundException
    //   654	662	550	java/io/FileNotFoundException
    //   669	676	550	java/io/FileNotFoundException
    //   212	240	592	java/lang/Exception
    //   9	55	612	java/io/IOException
    //   55	121	612	java/io/IOException
    //   124	142	612	java/io/IOException
    //   142	170	612	java/io/IOException
    //   170	191	612	java/io/IOException
    //   194	212	612	java/io/IOException
    //   212	240	612	java/io/IOException
    //   240	269	612	java/io/IOException
    //   269	339	612	java/io/IOException
    //   339	415	612	java/io/IOException
    //   415	444	612	java/io/IOException
    //   446	493	612	java/io/IOException
    //   496	521	612	java/io/IOException
    //   531	547	612	java/io/IOException
    //   593	609	612	java/io/IOException
    //   654	662	612	java/io/IOException
    //   669	676	612	java/io/IOException
    //   9	55	679	org/json/JSONException
    //   55	121	679	org/json/JSONException
    //   124	142	679	org/json/JSONException
    //   142	170	679	org/json/JSONException
    //   170	191	679	org/json/JSONException
    //   194	212	679	org/json/JSONException
    //   212	240	679	org/json/JSONException
    //   240	269	679	org/json/JSONException
    //   269	339	679	org/json/JSONException
    //   339	415	679	org/json/JSONException
    //   415	444	679	org/json/JSONException
    //   446	493	679	org/json/JSONException
    //   496	521	679	org/json/JSONException
    //   531	547	679	org/json/JSONException
    //   593	609	679	org/json/JSONException
    //   654	662	679	org/json/JSONException
    //   669	676	679	org/json/JSONException
    //   9	55	725	java/lang/Exception
    //   55	121	725	java/lang/Exception
    //   124	142	725	java/lang/Exception
    //   170	191	725	java/lang/Exception
    //   194	212	725	java/lang/Exception
    //   240	269	725	java/lang/Exception
    //   269	339	725	java/lang/Exception
    //   339	415	725	java/lang/Exception
    //   415	444	725	java/lang/Exception
    //   446	493	725	java/lang/Exception
    //   496	521	725	java/lang/Exception
    //   531	547	725	java/lang/Exception
    //   593	609	725	java/lang/Exception
    //   654	662	725	java/lang/Exception
    //   669	676	725	java/lang/Exception
  }
  
  private BubbleInfo.CommonAttrs a(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    AnimationConfig localAnimationConfig = a(paramInt, paramString);
    if (localAnimationConfig == null) {
      return null;
    }
    Object localObject2 = new BubbleInfo.CommonAttrs();
    ((BubbleInfo.CommonAttrs)localObject2).c = localAnimationConfig.g;
    ((BubbleInfo.CommonAttrs)localObject2).e = localAnimationConfig.h;
    ((BubbleInfo.CommonAttrs)localObject2).d = localAnimationConfig.f;
    Object localObject1;
    if (((BubbleInfo.CommonAttrs)localObject2).d <= 1)
    {
      ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_Boolean = true;
      File localFile = new File(a(paramInt, false), localAnimationConfig.jdField_a_of_type_JavaLangString);
      localObject1 = new String[localAnimationConfig.g];
      i1 = 0;
      label111:
      if (i1 >= localObject1.length) {
        break label547;
      }
      localObject1[i1] = (localFile.getAbsolutePath() + File.separatorChar + String.format("%04d.png", new Object[] { Integer.valueOf(i1 + 1) }));
      boolean bool = new File(localObject1[i1]).exists();
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleSource|pngs[" + i1 + "]=" + localObject1[i1] + ",isFileExists=" + bool);
      }
      if (bool) {
        break label450;
      }
    }
    label547:
    for (int i1 = 1;; i1 = 0)
    {
      if ((paramBoolean1) && ((i1 != 0) || (b(paramInt, localAnimationConfig.jdField_a_of_type_JavaLangString).booleanValue())))
      {
        paramString = String.format("http://imgcache.qq.com/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip" });
        localObject1 = new File(a(paramInt, true), localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("name", localAnimationConfig.jdField_a_of_type_JavaLangString + ".zip");
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(paramInt, paramString, (File)localObject1, this.b, (Bundle)localObject2);
        return null;
        ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_Boolean = false;
        break;
        label450:
        i1 += 1;
        break label111;
      }
      if (i1 != 0) {
        return null;
      }
      if (localObject1.length > 0) {}
      for (;;)
      {
        ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_ArrayOfJavaLangString = ((String[])localObject1);
        ((BubbleInfo.CommonAttrs)localObject2).jdField_b_of_type_JavaLangString = paramString;
        ((BubbleInfo.CommonAttrs)localObject2).f = a(localAnimationConfig.c, paramBoolean2);
        ((BubbleInfo.CommonAttrs)localObject2).jdField_a_of_type_AndroidGraphicsRect = a(localAnimationConfig.jdField_a_of_type_ArrayOfInt[0], localAnimationConfig.jdField_a_of_type_ArrayOfInt[1], localAnimationConfig.jdField_a_of_type_ArrayOfInt[2], localAnimationConfig.jdField_a_of_type_ArrayOfInt[3]);
        return localObject2;
        localObject1 = null;
      }
    }
  }
  
  private Boolean a(String paramString)
  {
    if ((paramString == null) || (paramString.length() == 0)) {
      return Boolean.valueOf(true);
    }
    paramString = paramString.split(",");
    int i1 = 0;
    String[] arrayOfString;
    while (i1 < paramString.length)
    {
      arrayOfString = paramString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (Long.parseLong(arrayOfString[1]) == 1L)) {
        return Boolean.valueOf(false);
      }
      i1 += 1;
    }
    i1 = 0;
    while (i1 < paramString.length)
    {
      arrayOfString = paramString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (Long.parseLong(arrayOfString[3]) == 0L)) {
        return Boolean.valueOf(false);
      }
      i1 += 1;
    }
    return Boolean.valueOf(true);
  }
  
  /* Error */
  private Boolean a(JSONArray paramJSONArray)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +10 -> 11
    //   4: iconst_0
    //   5: invokestatic 104	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   8: astore_1
    //   9: aload_1
    //   10: areturn
    //   11: new 474	java/io/File
    //   14: dup
    //   15: aload_0
    //   16: invokevirtual 565	com/tencent/mobileqq/bubble/BubbleManager:a	()Ljava/io/File;
    //   19: ldc 39
    //   21: invokespecial 480	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   24: astore_2
    //   25: aload_2
    //   26: invokevirtual 503	java/io/File:exists	()Z
    //   29: ifeq +8 -> 37
    //   32: aload_2
    //   33: invokevirtual 568	java/io/File:delete	()Z
    //   36: pop
    //   37: new 570	java/io/RandomAccessFile
    //   40: dup
    //   41: aload_2
    //   42: ldc_w 572
    //   45: invokespecial 573	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   48: astore_3
    //   49: aload_3
    //   50: astore_2
    //   51: aload_3
    //   52: aload_1
    //   53: invokevirtual 574	org/json/JSONArray:toString	()Ljava/lang/String;
    //   56: invokevirtual 578	java/lang/String:getBytes	()[B
    //   59: invokevirtual 582	java/io/RandomAccessFile:write	([B)V
    //   62: aload_3
    //   63: astore_2
    //   64: aload_3
    //   65: invokevirtual 585	java/io/RandomAccessFile:close	()V
    //   68: iconst_1
    //   69: invokestatic 104	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   72: astore_2
    //   73: aload_2
    //   74: astore_1
    //   75: aload_3
    //   76: ifnull -67 -> 9
    //   79: aload_3
    //   80: invokevirtual 585	java/io/RandomAccessFile:close	()V
    //   83: aload_2
    //   84: areturn
    //   85: astore_1
    //   86: aload_1
    //   87: invokevirtual 588	java/io/IOException:printStackTrace	()V
    //   90: aload_2
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_3
    //   95: aload_3
    //   96: astore_2
    //   97: aload_1
    //   98: invokevirtual 589	java/io/FileNotFoundException:printStackTrace	()V
    //   101: aload_3
    //   102: ifnull +7 -> 109
    //   105: aload_3
    //   106: invokevirtual 585	java/io/RandomAccessFile:close	()V
    //   109: iconst_0
    //   110: invokestatic 104	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   113: areturn
    //   114: astore_1
    //   115: aload_1
    //   116: invokevirtual 588	java/io/IOException:printStackTrace	()V
    //   119: goto -10 -> 109
    //   122: astore_1
    //   123: aconst_null
    //   124: astore_3
    //   125: aload_3
    //   126: astore_2
    //   127: aload_1
    //   128: invokevirtual 588	java/io/IOException:printStackTrace	()V
    //   131: aload_3
    //   132: ifnull -23 -> 109
    //   135: aload_3
    //   136: invokevirtual 585	java/io/RandomAccessFile:close	()V
    //   139: goto -30 -> 109
    //   142: astore_1
    //   143: aload_1
    //   144: invokevirtual 588	java/io/IOException:printStackTrace	()V
    //   147: goto -38 -> 109
    //   150: astore_1
    //   151: aconst_null
    //   152: astore_2
    //   153: aload_2
    //   154: ifnull +7 -> 161
    //   157: aload_2
    //   158: invokevirtual 585	java/io/RandomAccessFile:close	()V
    //   161: aload_1
    //   162: athrow
    //   163: astore_2
    //   164: aload_2
    //   165: invokevirtual 588	java/io/IOException:printStackTrace	()V
    //   168: goto -7 -> 161
    //   171: astore_1
    //   172: goto -19 -> 153
    //   175: astore_1
    //   176: goto -51 -> 125
    //   179: astore_1
    //   180: goto -85 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	BubbleManager
    //   0	183	1	paramJSONArray	JSONArray
    //   24	134	2	localObject	Object
    //   163	2	2	localIOException	IOException
    //   48	88	3	localRandomAccessFile	java.io.RandomAccessFile
    // Exception table:
    //   from	to	target	type
    //   79	83	85	java/io/IOException
    //   37	49	92	java/io/FileNotFoundException
    //   105	109	114	java/io/IOException
    //   37	49	122	java/io/IOException
    //   135	139	142	java/io/IOException
    //   37	49	150	finally
    //   157	161	163	java/io/IOException
    //   51	62	171	finally
    //   64	68	171	finally
    //   97	101	171	finally
    //   127	131	171	finally
    //   51	62	175	java/io/IOException
    //   64	68	175	java/io/IOException
    //   51	62	179	java/io/FileNotFoundException
    //   64	68	179	java/io/FileNotFoundException
  }
  
  private String a(String paramString)
  {
    paramString = new FileReader(paramString);
    char[] arrayOfChar = new char[1024];
    StringBuilder localStringBuilder = new StringBuilder();
    for (;;)
    {
      int i1 = paramString.read(arrayOfChar);
      if (i1 <= 0) {
        break;
      }
      localStringBuilder.append(arrayOfChar, 0, i1);
    }
    paramString.close();
    return localStringBuilder.toString();
  }
  
  private String a(String paramString, int paramInt, String[] paramArrayOfString)
  {
    int i1 = 0;
    while (i1 < paramArrayOfString.length)
    {
      String[] arrayOfString = paramArrayOfString[i1].split("\\|");
      if ((arrayOfString.length == 4) && (arrayOfString[0].equalsIgnoreCase(paramString)))
      {
        if (paramInt > Long.parseLong(arrayOfString[2]))
        {
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
          return paramString + "|1|" + paramInt + "|0,";
        }
        return paramArrayOfString[i1] + ",";
      }
      i1 += 1;
    }
    return paramString + "|1|" + paramInt + "|0,";
  }
  
  private String a(String paramString1, String paramString2, int paramInt)
  {
    if ((paramString1 == null) || (paramString1.length() == 0)) {
      return paramString2 + "|0|" + paramInt + "|1,";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    paramString1 = paramString1.split(",");
    int i1 = 0;
    if (i1 < paramString1.length)
    {
      String[] arrayOfString = paramString1[i1].split("\\|");
      if (arrayOfString.length != 4) {}
      for (;;)
      {
        i1 += 1;
        break;
        if (arrayOfString[0].equalsIgnoreCase(paramString2)) {
          localStringBuffer.append(paramString2 + "|0|" + paramInt + "|1,");
        } else {
          localStringBuffer.append(paramString1[i1] + ",");
        }
      }
    }
    if (localStringBuffer.length() == 0) {
      return paramString2 + "|0|" + paramInt + "|1,";
    }
    return localStringBuffer.toString();
  }
  
  private JSONObject a(BubbleConfig paramBubbleConfig, int paramInt, Boolean paramBoolean)
  {
    JSONObject localJSONObject = new JSONObject();
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      int i2;
      try
      {
        localJSONObject.put("id", paramBubbleConfig.jdField_a_of_type_Int);
        localJSONObject.put("update", paramInt);
        localJSONObject.put("version", paramBubbleConfig.jdField_b_of_type_Int);
        if (!paramBoolean.booleanValue()) {
          break label426;
        }
        i1 = 1;
        localJSONObject.put("full_download", i1);
        localStringBuffer.append("static|" + paramInt + "|" + paramBubbleConfig.e + "|" + i1 + ",");
        if (paramBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig != null) {
          localStringBuffer.append("voice|" + paramInt + "|" + paramBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.d + "|" + i1 + ",");
        }
        if (paramBubbleConfig.jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig != null) {
          localStringBuffer.append("height|" + paramInt + "|" + paramBubbleConfig.jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig.d + "|" + i1 + ",");
        }
        if (paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList != null)
        {
          i2 = 0;
          if (i2 < paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList.size())
          {
            paramBoolean = (AnimationConfig)paramBubbleConfig.jdField_a_of_type_JavaUtilArrayList.get(i2);
            if ((paramBoolean.jdField_a_of_type_JavaLangString.equalsIgnoreCase("static")) || (paramBoolean.jdField_a_of_type_JavaLangString.equalsIgnoreCase("voice")) || (paramBoolean.jdField_a_of_type_JavaLangString.equalsIgnoreCase("height"))) {
              break label417;
            }
            localStringBuffer.append(paramBoolean.jdField_a_of_type_JavaLangString + "|" + paramInt + "|" + paramBoolean.d + "|" + i1 + ",");
            break label417;
          }
        }
        localJSONObject.put("updatelist", localStringBuffer);
        return localJSONObject;
      }
      catch (JSONException paramBubbleConfig)
      {
        paramBubbleConfig.printStackTrace();
        return null;
      }
      label417:
      i2 += 1;
      continue;
      label426:
      int i1 = 0;
    }
  }
  
  private void a(int paramInt)
  {
    File localFile1 = b();
    Object localObject = Integer.toString(paramInt);
    localFile1 = new File(localFile1, (String)localObject);
    if (localFile1.exists())
    {
      File[] arrayOfFile1 = localFile1.listFiles();
      paramInt = 0;
      if (paramInt < arrayOfFile1.length)
      {
        File localFile2 = arrayOfFile1[paramInt];
        if (localFile2.isDirectory())
        {
          File[] arrayOfFile2 = localFile2.listFiles();
          if (arrayOfFile2 != null)
          {
            int i2 = arrayOfFile2.length;
            int i1 = 0;
            while (i1 < i2)
            {
              arrayOfFile2[i1].delete();
              i1 += 1;
            }
            localFile2.delete();
          }
        }
        for (;;)
        {
          paramInt += 1;
          break;
          arrayOfFile1[paramInt].delete();
        }
      }
      localFile1.delete();
    }
    localObject = new File(c(), (String)localObject);
    if (((File)localObject).exists()) {
      ((File)localObject).delete();
    }
  }
  
  private void a(String paramString1, int paramInt, String paramString2)
  {
    String str = Integer.toString(NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext));
    if (paramString2 != null) {}
    for (;;)
    {
      ReportController.b(null, "CliOper", "", "", "Bubble", paramString1, 0, 1, String.valueOf(paramInt), str, paramString2, "");
      return;
      paramString2 = "unknow";
    }
  }
  
  private boolean a(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = a(paramInt, paramBoolean);
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = new ArrayList();
    Object localObject3 = new HashMap();
    Object localObject4;
    if (((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i1 = 0;
      while (i1 < ((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.size())
      {
        localObject4 = (AnimationConfig)((BubbleConfig)localObject1).jdField_a_of_type_JavaUtilArrayList.get(i1);
        int i2 = 0;
        while (i2 < ((AnimationConfig)localObject4).jdField_b_of_type_ArrayOfJavaLangString.length)
        {
          String str = localObject4.jdField_b_of_type_ArrayOfJavaLangString[i2];
          ((ArrayList)localObject2).add(str);
          ((HashMap)localObject3).put(str, ((AnimationConfig)localObject4).jdField_a_of_type_JavaLangString);
          i2 += 1;
        }
        i1 += 1;
      }
    }
    localObject1 = new BubbleInfo(paramInt, "", "", "", ((BubbleConfig)localObject1).c, ((BubbleConfig)localObject1).d, (String[])((ArrayList)localObject2).toArray(new String[0]), null, 0, 0, null, null, (HashMap)localObject3);
    boolean bool1;
    if (paramBoolean)
    {
      bool1 = b(paramInt, "static").booleanValue();
      boolean bool2 = false;
      if (!bool1) {
        bool2 = a((BubbleInfo)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "createBubbleInfo bubbleId=" + paramInt + " hasUpdate=" + bool1 + ",isCheckOk=" + bool2 + ",autoAsyncDownload=" + paramBoolean);
      }
      if (bool2) {
        break label487;
      }
      if (paramBoolean)
      {
        if (!a(paramInt)) {
          break label461;
        }
        localObject1 = "all.zip";
      }
    }
    for (localObject2 = new File(a(paramInt, true), "all.zip");; localObject2 = new File(a(paramInt, true), "static.zip"))
    {
      localObject3 = String.format("http://imgcache.qq.com/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), localObject1 });
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleInfo bubbleId=" + paramInt + " will down " + (String)localObject1 + ",dstFile path=" + ((File)localObject2).getAbsolutePath());
      }
      localObject4 = new Bundle();
      ((Bundle)localObject4).putString("name", (String)localObject1);
      this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(paramInt, (String)localObject3, (File)localObject2, this.b, (Bundle)localObject4);
      return false;
      bool1 = false;
      break;
      label461:
      localObject1 = "static.zip";
    }
    label487:
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.put(Integer.valueOf(paramInt), localObject1);
    return true;
  }
  
  private boolean a(BubbleInfo paramBubbleInfo)
  {
    if (paramBubbleInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleInfo is null");
      }
      return false;
    }
    if ((!TextUtils.isEmpty(paramBubbleInfo.d)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(paramBubbleInfo.jdField_b_of_type_JavaLangString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleId=" + paramBubbleInfo.jdField_a_of_type_Int + ",chkStaticSrcAndUpdate is ok | not empty");
      }
      return true;
    }
    String str3 = a(paramBubbleInfo.jdField_a_of_type_Int, false).getAbsolutePath() + File.separatorChar + "static" + File.separatorChar;
    String str1 = str3 + "aio_user_bg_nor.9.png";
    String str2 = str3 + "aio_user_pic_nor.9.png";
    str3 = str3 + "chat_bubble_thumbnail.png";
    Object localObject = new ArrayList();
    ((List)localObject).add(str1);
    ((List)localObject).add(str2);
    ((List)localObject).add(str3);
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str4 = (String)((Iterator)localObject).next();
      if (!new File(str4).exists())
      {
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|file is not exists,bubbleId=" + paramBubbleInfo.jdField_a_of_type_Int + ",strFilePath=" + str4);
        }
        return false;
      }
    }
    paramBubbleInfo.d = str3;
    paramBubbleInfo.jdField_a_of_type_JavaLangString = str1;
    paramBubbleInfo.jdField_b_of_type_JavaLangString = str2;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "checkBubbleStaticSource|bubbleId=" + paramBubbleInfo.jdField_a_of_type_Int + ",chkStaticSrcAndUpdate is ok");
    }
    return true;
  }
  
  public Drawable a(int paramInt)
  {
    Object localObject = (Pair)BaseApplicationImpl.a.get("bubble_thumb_" + paramInt);
    if (localObject != null) {
      return ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(this.jdField_a_of_type_AndroidContentContext.getResources());
    }
    if (paramInt < 1) {
      return null;
    }
    BubbleInfo localBubbleInfo = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
    localObject = localBubbleInfo;
    if (localBubbleInfo == null)
    {
      localObject = localBubbleInfo;
      if (a(paramInt, true)) {
        localObject = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
      }
    }
    if ((localObject != null) && (!TextUtils.isEmpty(((BubbleInfo)localObject).d)))
    {
      localObject = BubbleInfo.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, ((BubbleInfo)localObject).d);
      if (localObject != null)
      {
        BaseApplicationImpl.a.put("bubble_thumb_" + paramInt, new Pair(((Drawable)((Pair)localObject).first).getConstantState(), ((Pair)localObject).second));
        return (Drawable)((Pair)localObject).first;
      }
    }
    if (0 == 0) {
      return this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837759);
    }
    return null;
  }
  
  public BubbleConfig a(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = (BubbleConfig)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject2 = a(paramInt, false).getAbsolutePath() + File.separatorChar + "config.json";
      localObject1 = a(paramInt, (String)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleConfig bubbleId=" + paramInt + ",filePath=" + (String)localObject2 + ",bubbleConfig=" + localObject1);
      }
      if (localObject1 == null) {
        break label194;
      }
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt), localObject1);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleConfig bubbleId=" + paramInt + ",autoDownload=" + paramBoolean + ",bubbleConfig=" + localObject1);
      }
      return localObject1;
      label194:
      if (paramBoolean)
      {
        localObject2 = String.format("http://imgcache.qq.com/club/item/avatar/json/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), "config.json" });
        File localFile = new File(a(paramInt, true), "config.json");
        Bundle localBundle = new Bundle();
        localBundle.putString("name", "config.json");
        this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(paramInt, (String)localObject2, localFile, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener, localBundle);
      }
    }
  }
  
  public BubbleInfo a(int paramInt)
  {
    Object localObject;
    if (paramInt < 1) {
      localObject = null;
    }
    do
    {
      BubbleInfo localBubbleInfo;
      do
      {
        return localObject;
        localBubbleInfo = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
        if (localBubbleInfo == null) {
          break;
        }
        localObject = localBubbleInfo;
      } while (!QLog.isColorLevel());
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getBubbleInfo bubbleId=" + paramInt + " from cache");
      return localBubbleInfo;
      localObject = localBubbleInfo;
    } while (!a(paramInt, true));
    return (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
  }
  
  public Pair a(int paramInt, AnimationConfig paramAnimationConfig, boolean paramBoolean)
  {
    boolean bool = false;
    if ((paramAnimationConfig == null) || (TextUtils.isEmpty(paramAnimationConfig.jdField_a_of_type_JavaLangString))) {
      return null;
    }
    BubbleInfo.CommonAttrs localCommonAttrs = a(paramInt, paramAnimationConfig.jdField_a_of_type_JavaLangString, paramBoolean, false);
    if (localCommonAttrs == null) {
      return null;
    }
    if (paramAnimationConfig.jdField_a_of_type_JavaLangString.equals(paramAnimationConfig.jdField_b_of_type_JavaLangString)) {
      bool = true;
    }
    return new Pair(localCommonAttrs, a(paramInt, paramAnimationConfig.jdField_b_of_type_JavaLangString, paramBoolean, bool));
  }
  
  public Pair a(int paramInt, String paramString, Pair paramPair)
  {
    Object localObject = paramPair;
    if (paramPair == null)
    {
      paramString = a(paramInt, a(paramInt, paramString), true);
      localObject = paramString;
      if (paramString != null)
      {
        paramPair = (BubbleInfo)this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.get(Integer.valueOf(paramInt));
        localObject = paramString;
        if (paramPair != null)
        {
          paramPair.jdField_a_of_type_JavaUtilList.add(paramString);
          localObject = paramString;
        }
      }
    }
    return localObject;
  }
  
  public File a()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public File a(int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separatorChar + "bubble_info" + File.separatorChar + "unzip_temp" + File.separatorChar + paramInt;
    File localFile = new File(str);
    if (localFile.exists()) {
      FileUtils.a(str);
    }
    localFile.mkdirs();
    return localFile;
  }
  
  public File a(int paramInt, boolean paramBoolean)
  {
    String str = a().getAbsolutePath();
    Object localObject = str;
    if (paramBoolean) {
      localObject = str + "/temp";
    }
    localObject = new File((String)localObject + File.separatorChar + paramInt);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    return localObject;
  }
  
  public Boolean a(int paramInt)
  {
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
      return Boolean.valueOf(false);
    }
    if (!new File(a(), Integer.toString(paramInt)).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "bubble dir does not exist id:" + paramInt);
      }
      return Boolean.valueOf(false);
    }
    int i1 = 0;
    for (;;)
    {
      if (i1 < this.jdField_a_of_type_OrgJsonJSONArray.length()) {
        try
        {
          JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
          if (localJSONObject.getInt("id") == paramInt)
          {
            if (localJSONObject.getInt("full_download") == 1) {}
            for (boolean bool = true;; bool = false) {
              return Boolean.valueOf(bool);
            }
          }
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          i1 += 1;
        }
      }
    }
    return Boolean.valueOf(false);
  }
  
  public Boolean a(int paramInt, String paramString)
  {
    Object localObject1 = a(paramInt, false).getAbsolutePath() + File.separatorChar + "config.json";
    BubbleConfig localBubbleConfig = a(paramInt, (String)localObject1);
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "setUpdateInfo|bubbleId=" + paramInt + ",filePath=" + (String)localObject1 + ",config=" + localBubbleConfig);
    }
    if (localBubbleConfig != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.put(Integer.valueOf(paramInt), localBubbleConfig);
      if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
        return Boolean.valueOf(false);
      }
    }
    else
    {
      return Boolean.valueOf(false);
    }
    localObject1 = Boolean.valueOf(false);
    Object localObject2 = localObject1;
    Object localObject4;
    int i1;
    if ("json".equals(paramString))
    {
      localObject4 = new StringBuffer();
      i1 = 0;
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (i1 < this.jdField_a_of_type_OrgJsonJSONArray.length()) {}
      for (;;)
      {
        Object localObject5;
        int i2;
        Object localObject6;
        try
        {
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(true);
          localObject2 = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
          if (((JSONObject)localObject2).getInt("id") != paramInt) {
            break label888;
          }
          localObject1 = Boolean.valueOf(true);
          localObject5 = ((JSONObject)localObject2).getString("updatelist").split(",");
          ((StringBuffer)localObject4).append(a("static", localBubbleConfig.e, (String[])localObject5));
          if (localBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig != null) {
            ((StringBuffer)localObject4).append(a("voice", localBubbleConfig.jdField_a_of_type_ComTencentMobileqqBubbleAnimationConfig.d, (String[])localObject5));
          }
          if (localBubbleConfig.jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig != null) {
            ((StringBuffer)localObject4).append(a("height", localBubbleConfig.jdField_b_of_type_ComTencentMobileqqBubbleAnimationConfig.d, (String[])localObject5));
          }
          if (localBubbleConfig.jdField_a_of_type_JavaUtilArrayList != null)
          {
            i2 = 0;
            if (i2 < localBubbleConfig.jdField_a_of_type_JavaUtilArrayList.size())
            {
              localObject6 = (AnimationConfig)localBubbleConfig.jdField_a_of_type_JavaUtilArrayList.get(i2);
              if ((((AnimationConfig)localObject6).jdField_a_of_type_JavaLangString.equalsIgnoreCase("static")) || (((AnimationConfig)localObject6).jdField_a_of_type_JavaLangString.equalsIgnoreCase("voice")) || (((AnimationConfig)localObject6).jdField_a_of_type_JavaLangString.equalsIgnoreCase("height"))) {
                break label891;
              }
              ((StringBuffer)localObject4).append(a(((AnimationConfig)localObject6).jdField_a_of_type_JavaLangString, ((AnimationConfig)localObject6).d, (String[])localObject5));
              break label891;
            }
          }
          if (localBubbleConfig.jdField_b_of_type_Int > ((JSONObject)localObject2).getInt("version"))
          {
            if (this.jdField_a_of_type_JavaLangBoolean.booleanValue() == true) {
              ((JSONObject)localObject2).put("version", localBubbleConfig.jdField_b_of_type_Int);
            }
          }
          else
          {
            ((JSONObject)localObject2).put("updatelist", localObject4);
            break;
          }
          ((JSONObject)localObject2).put("update", 1);
          ((JSONObject)localObject2).put("full_download", 0);
          continue;
          if (paramString != null) {
            break label653;
          }
        }
        catch (JSONException paramString)
        {
          paramString.printStackTrace();
          return Boolean.valueOf(false);
        }
        localObject1 = localObject2;
        i1 = 0;
        for (;;)
        {
          localObject2 = localObject1;
          if (i1 >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
            break label832;
          }
          try
          {
            localObject4 = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
            localObject2 = localObject1;
            if (((JSONObject)localObject4).getInt("id") == paramInt)
            {
              localObject2 = a(localBubbleConfig, 0, Boolean.valueOf(true));
              ((JSONObject)localObject4).put("update", ((JSONObject)localObject2).getInt("update"));
              ((JSONObject)localObject4).put("updatelist", ((JSONObject)localObject2).getString("updatelist"));
              ((JSONObject)localObject4).put("version", ((JSONObject)localObject2).getInt("version"));
              ((JSONObject)localObject4).put("full_download", ((JSONObject)localObject2).getInt("full_download"));
              localObject2 = Boolean.valueOf(true);
            }
          }
          catch (JSONException localJSONException2)
          {
            for (;;)
            {
              localJSONException2.printStackTrace();
              localObject3 = localObject1;
            }
          }
          i1 += 1;
          localObject1 = localObject2;
        }
        Object localObject3;
        label653:
        localObject1 = localObject3;
        i1 = 0;
        for (;;)
        {
          localObject3 = localObject1;
          if (i1 >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
            break label832;
          }
          localObject3 = localObject1;
          try
          {
            localObject5 = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
            localObject4 = localObject1;
            localObject3 = localObject1;
            if (((JSONObject)localObject5).getInt("id") == paramInt)
            {
              localObject3 = localObject1;
              localObject1 = Boolean.valueOf(true);
              localObject3 = localObject1;
              localObject6 = a(((JSONObject)localObject5).getString("updatelist"), paramString, ((JSONObject)localObject5).getInt("version"));
              localObject3 = localObject1;
              ((JSONObject)localObject5).put("updatelist", localObject6);
              localObject4 = localObject1;
              localObject3 = localObject1;
              if (a((String)localObject6).booleanValue() == true)
              {
                localObject3 = localObject1;
                ((JSONObject)localObject5).put("update", 0);
                localObject3 = localObject1;
                ((JSONObject)localObject5).put("full_download", 1);
                localObject4 = localObject1;
              }
            }
          }
          catch (JSONException localJSONException1)
          {
            for (;;)
            {
              localJSONException1.printStackTrace();
              localObject4 = localObject3;
            }
          }
          i1 += 1;
          localObject1 = localObject4;
        }
        label832:
        if (!localObject3.booleanValue())
        {
          Boolean localBoolean = Boolean.valueOf(true);
          if (paramString != null) {
            localBoolean = Boolean.valueOf(false);
          }
          paramString = a(localBubbleConfig, 0, localBoolean);
          if (paramString != null) {
            this.jdField_a_of_type_OrgJsonJSONArray.put(paramString);
          }
        }
        return a(this.jdField_a_of_type_OrgJsonJSONArray);
        label888:
        break;
        label891:
        i2 += 1;
      }
      i1 += 1;
    }
  }
  
  public JSONArray a()
  {
    Object localObject1 = new File(a(), "bubble_local.cfg");
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = a(((File)localObject1).getAbsolutePath());
        if (localObject1 != null)
        {
          localObject1 = new JSONArray((String)localObject1);
          Object localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = new JSONArray();
          }
          return localObject3;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = null;
    }
  }
  
  public JSONObject a(int paramInt)
  {
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      if (a(paramInt).booleanValue())
      {
        localJSONObject2.put("status", 3);
        localJSONObject2.put("progress", 100);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", this.jdField_a_of_type_AndroidContentContext.getString(2131559217));
      }
      for (;;)
      {
        localJSONObject2.put("id", paramInt);
        localJSONObject1.put("data", localJSONObject2);
        if (QLog.isColorLevel()) {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "queryInfo bubbleId=" + paramInt + ",json=" + localJSONObject1.toString());
        }
        return localJSONObject1;
        Object localObject = String.format("http://imgcache.qq.com/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), "all.zip" });
        localObject = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a((String)localObject);
        if (localObject == null) {
          break;
        }
        switch (((DownloadTask)localObject).jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.get())
        {
        case 0: 
        case 1: 
          localJSONObject2.put("status", 1);
          localJSONObject1.put("result", 0);
          localJSONObject1.put("message", this.jdField_a_of_type_AndroidContentContext.getString(2131559220));
          localJSONObject2.put("progress", ((DownloadTask)localObject).jdField_a_of_type_Float);
        }
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
        continue;
        localJSONException.put("status", 2);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", this.jdField_a_of_type_AndroidContentContext.getString(2131559218));
        continue;
        localJSONException.put("status", 1);
        localJSONObject1.put("result", -1);
        localJSONObject1.put("message", this.jdField_a_of_type_AndroidContentContext.getString(2131559219));
        continue;
        localJSONException.put("status", 1);
        localJSONException.put("progress", 0);
        localJSONObject1.put("result", 0);
        localJSONObject1.put("message", this.jdField_a_of_type_AndroidContentContext.getString(2131559221));
      }
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "startDownload id=" + paramInt);
    }
    Bundle localBundle = new Bundle();
    if (paramString != null)
    {
      localBundle.putInt("srcType", 3);
      localBundle.putString("callbackId", paramString);
    }
    if (a(paramInt).booleanValue()) {
      if ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener != null) && (paramString != null)) {
        this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramInt, 3, localBundle);
      }
    }
    do
    {
      return;
      if (NetworkUtil.e(this.jdField_a_of_type_AndroidContentContext)) {
        break;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener == null) || (paramString == null));
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener.onDone(paramInt, 5, localBundle);
    return;
    paramString = String.format("http://imgcache.qq.com/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), "all.zip" });
    File localFile = new File(c(), paramInt + ".zip");
    localBundle.putString("name", "all.zip");
    this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(paramInt, paramString, localFile, this.b, localBundle);
  }
  
  public void a(IPCDownloadListener paramIPCDownloadListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqVipIPCDownloadListener = paramIPCDownloadListener;
  }
  
  public boolean a(int paramInt)
  {
    boolean bool2 = false;
    boolean bool3 = DownloaderFactory.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.a().getApplicationContext());
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (!a(paramInt).booleanValue()) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "bubbleId=" + paramInt + ",isQualityNetwork=" + bool3 + ",canFullDown=" + bool1);
    }
    return bool1;
  }
  
  public File b()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir(), "bubble_info");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public Boolean b(int paramInt, String paramString)
  {
    int i1 = 0;
    if (this.jdField_a_of_type_OrgJsonJSONArray == null) {
      return Boolean.valueOf(true);
    }
    if (paramString == null) {}
    for (;;)
    {
      try
      {
        if (i1 >= this.jdField_a_of_type_OrgJsonJSONArray.length()) {
          break label193;
        }
        paramString = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
        if (paramString.getInt("id") != paramInt) {
          break label198;
        }
        if (paramString.getInt("update") == 1) {
          return Boolean.valueOf(true);
        }
        return Boolean.valueOf(false);
      }
      catch (JSONException paramString)
      {
        Object localObject;
        int i2;
        String[] arrayOfString;
        paramString.printStackTrace();
      }
      if (i1 < this.jdField_a_of_type_OrgJsonJSONArray.length())
      {
        localObject = this.jdField_a_of_type_OrgJsonJSONArray.getJSONObject(i1);
        if (((JSONObject)localObject).getInt("id") == paramInt)
        {
          localObject = ((JSONObject)localObject).getString("updatelist").split(",");
          i2 = 0;
          if (i2 < localObject.length)
          {
            arrayOfString = localObject[i2].split("\\|");
            if (arrayOfString[0].equals(paramString))
            {
              if (Long.parseLong(arrayOfString[1]) == 1L) {
                return Boolean.valueOf(true);
              }
              return Boolean.valueOf(false);
            }
            i2 += 1;
            continue;
          }
        }
        i1 += 1;
      }
      else
      {
        label193:
        return Boolean.valueOf(true);
        label198:
        i1 += 1;
        continue;
        i1 = 0;
      }
    }
  }
  
  public JSONObject b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "stopDownload id=" + paramInt);
    }
    String str = String.format("http://imgcache.qq.com/club/item/avatar/zip/%1$d/a%2$d/%3$s", new Object[] { Integer.valueOf(paramInt % 10), Integer.valueOf(paramInt), "all.zip" });
    int i1 = this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory.a(this.jdField_a_of_type_ComTencentMobileqqVipDownloaderFactory$DownloadConfig).a(false, str);
    localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("status", i1);
      if (i1 == 0) {}
      for (str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559222);; str = this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559223))
      {
        localJSONObject.put("message", str);
        localJSONObject.put("id", paramInt);
        localJSONObject.put("result", 0);
        return localJSONObject;
      }
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
  }
  
  public boolean b(int paramInt)
  {
    try
    {
      File localFile2 = new File(c(), paramInt + ".zip");
      File localFile3 = b();
      try
      {
        File localFile1 = a(paramInt);
        ZipUtils.a(localFile2, localFile1.getAbsolutePath() + File.separatorChar);
        localFile2 = new File(localFile3.getAbsolutePath() + File.separatorChar + paramInt);
        if (localFile2.exists()) {
          a(paramInt);
        }
        FileUtils.a(localFile1, localFile2);
        FileUtils.a(localFile1.getAbsolutePath());
        bool = true;
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.e(jdField_a_of_type_JavaLangString, 2, "unzip bubble resource failure,bubbleId=" + paramInt, localIOException);
          }
          boolean bool = false;
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "unzipBubbleResource bubbleId=" + paramInt + " ret=" + bool);
      }
      return bool;
    }
    finally {}
  }
  
  public File c()
  {
    File localFile = new File(this.jdField_a_of_type_AndroidContentContext.getFilesDir().getAbsolutePath() + File.separatorChar + "bubble_info" + File.separatorChar + "temp");
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    return localFile;
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "onDestroy...");
    }
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$BubbleInfoLruCache.clear();
    this.jdField_a_of_type_ComTencentMobileqqBubbleBubbleManager$LruLinkedHashMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.bubble.BubbleManager
 * JD-Core Version:    0.7.0.1
 */