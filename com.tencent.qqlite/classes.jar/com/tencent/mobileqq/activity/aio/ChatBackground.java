package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChatBackground
{
  public static final int a = -1;
  public static final int b = -10395552;
  public static final String b = "_is_c2c_set";
  public ColorStateList a;
  public Drawable a;
  public String a;
  
  public static int a(Bitmap paramBitmap)
  {
    int i = 0;
    if (paramBitmap != null)
    {
      int j = paramBitmap.getWidth();
      int n = paramBitmap.getHeight();
      int[] arrayOfInt = new int[n];
      paramBitmap.getPixels(arrayOfInt, 0, 1, j / 2, 0, 1, n);
      j = 0;
      int k = 0;
      int m = 0;
      while (i < n)
      {
        int i1 = arrayOfInt[i];
        m += Color.red(i1);
        k += Color.green(i1);
        j += Color.blue(i1);
        i += 1;
      }
      if ((j + (m + k)) / n / 3 > 220) {
        return -10395552;
      }
      return -1;
    }
    return -10395552;
  }
  
  /* Error */
  private static void a(Context paramContext, ChatBackground paramChatBackground, String paramString)
  {
    // Byte code:
    //   0: getstatic 56	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   3: astore_2
    //   4: aload_0
    //   5: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   8: ldc 63
    //   10: invokevirtual 69	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   13: astore 5
    //   15: aload 5
    //   17: instanceof 71
    //   20: ifeq +136 -> 156
    //   23: aload 5
    //   25: checkcast 71	android/graphics/drawable/BitmapDrawable
    //   28: invokevirtual 75	android/graphics/drawable/BitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   31: astore 4
    //   33: aload 5
    //   35: checkcast 71	android/graphics/drawable/BitmapDrawable
    //   38: invokevirtual 79	android/graphics/drawable/BitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   41: astore_2
    //   42: aload 5
    //   44: checkcast 71	android/graphics/drawable/BitmapDrawable
    //   47: invokevirtual 82	android/graphics/drawable/BitmapDrawable:getGravity	()I
    //   50: istore_3
    //   51: aload 4
    //   53: ifnonnull +71 -> 124
    //   56: new 84	java/util/HashMap
    //   59: dup
    //   60: invokespecial 85	java/util/HashMap:<init>	()V
    //   63: astore 5
    //   65: aload 5
    //   67: ldc 87
    //   69: ldc 89
    //   71: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload 5
    //   77: ldc 95
    //   79: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   82: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   85: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   88: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   91: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   94: pop
    //   95: aload_0
    //   96: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   99: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   102: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   105: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   108: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   111: ldc 122
    //   113: iconst_0
    //   114: lconst_1
    //   115: lconst_0
    //   116: aload 5
    //   118: ldc 124
    //   120: iconst_0
    //   121: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   124: aload 4
    //   126: ifnull +16 -> 142
    //   129: aload_2
    //   130: getstatic 56	android/graphics/Shader$TileMode:REPEAT	Landroid/graphics/Shader$TileMode;
    //   133: if_acmpeq +9 -> 142
    //   136: iload_3
    //   137: bipush 48
    //   139: if_icmpeq +56 -> 195
    //   142: aload_1
    //   143: aload_0
    //   144: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   147: ldc 63
    //   149: invokevirtual 69	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   152: putfield 129	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   155: return
    //   156: aload 5
    //   158: instanceof 131
    //   161: ifeq +258 -> 419
    //   164: aload 5
    //   166: checkcast 131	com/tencent/theme/SkinnableBitmapDrawable
    //   169: invokevirtual 132	com/tencent/theme/SkinnableBitmapDrawable:getBitmap	()Landroid/graphics/Bitmap;
    //   172: astore 4
    //   174: aload 5
    //   176: checkcast 131	com/tencent/theme/SkinnableBitmapDrawable
    //   179: invokevirtual 133	com/tencent/theme/SkinnableBitmapDrawable:getTileModeX	()Landroid/graphics/Shader$TileMode;
    //   182: astore_2
    //   183: aload 5
    //   185: checkcast 131	com/tencent/theme/SkinnableBitmapDrawable
    //   188: invokevirtual 134	com/tencent/theme/SkinnableBitmapDrawable:getGravity	()I
    //   191: istore_3
    //   192: goto -141 -> 51
    //   195: new 136	com/tencent/mobileqq/drawable/ChatBackgroundDrawable
    //   198: dup
    //   199: aload_0
    //   200: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   203: aload 4
    //   205: invokespecial 139	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   208: astore_2
    //   209: aload_2
    //   210: iload_3
    //   211: invokevirtual 143	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:setGravity	(I)V
    //   214: aload_1
    //   215: aload_2
    //   216: putfield 129	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   219: return
    //   220: astore_2
    //   221: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   224: ifeq +13 -> 237
    //   227: ldc 151
    //   229: iconst_2
    //   230: aload_2
    //   231: invokevirtual 154	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   234: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: aload_1
    //   238: aload_0
    //   239: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   242: ldc 159
    //   244: invokevirtual 69	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   247: putfield 129	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   250: new 84	java/util/HashMap
    //   253: dup
    //   254: invokespecial 85	java/util/HashMap:<init>	()V
    //   257: astore_1
    //   258: aload_1
    //   259: ldc 87
    //   261: ldc 161
    //   263: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   266: pop
    //   267: aload_1
    //   268: ldc 95
    //   270: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   273: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   276: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   279: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   282: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   285: pop
    //   286: aload_0
    //   287: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   290: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   293: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   296: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   299: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   302: ldc 122
    //   304: iconst_0
    //   305: lconst_1
    //   306: lconst_0
    //   307: aload_1
    //   308: ldc 124
    //   310: iconst_0
    //   311: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   314: return
    //   315: astore_0
    //   316: return
    //   317: astore_2
    //   318: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   321: ifeq +13 -> 334
    //   324: ldc 163
    //   326: iconst_2
    //   327: aload_2
    //   328: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   331: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   334: aload_1
    //   335: aload_0
    //   336: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   339: ldc 159
    //   341: invokevirtual 69	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   344: putfield 129	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   347: new 84	java/util/HashMap
    //   350: dup
    //   351: invokespecial 85	java/util/HashMap:<init>	()V
    //   354: astore_1
    //   355: aload_1
    //   356: ldc 87
    //   358: ldc 166
    //   360: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   363: pop
    //   364: aload_1
    //   365: ldc 95
    //   367: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   370: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   373: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   376: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   379: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   382: pop
    //   383: aload_0
    //   384: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   387: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   390: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   393: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   396: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   399: ldc 122
    //   401: iconst_0
    //   402: lconst_1
    //   403: lconst_0
    //   404: aload_1
    //   405: ldc 124
    //   407: iconst_0
    //   408: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   411: return
    //   412: astore_0
    //   413: return
    //   414: astore 5
    //   416: goto -292 -> 124
    //   419: bipush 119
    //   421: istore_3
    //   422: aconst_null
    //   423: astore 4
    //   425: goto -374 -> 51
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	428	0	paramContext	Context
    //   0	428	1	paramChatBackground	ChatBackground
    //   0	428	2	paramString	String
    //   50	372	3	i	int
    //   31	393	4	localBitmap	Bitmap
    //   13	171	5	localObject	Object
    //   414	1	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   0	51	220	java/lang/OutOfMemoryError
    //   56	124	220	java/lang/OutOfMemoryError
    //   129	136	220	java/lang/OutOfMemoryError
    //   142	155	220	java/lang/OutOfMemoryError
    //   156	192	220	java/lang/OutOfMemoryError
    //   195	219	220	java/lang/OutOfMemoryError
    //   250	314	315	java/lang/Exception
    //   0	51	317	java/lang/Exception
    //   129	136	317	java/lang/Exception
    //   142	155	317	java/lang/Exception
    //   156	192	317	java/lang/Exception
    //   195	219	317	java/lang/Exception
    //   347	411	412	java/lang/Exception
    //   56	124	414	java/lang/Exception
  }
  
  public static final void a(Context paramContext, String paramString)
  {
    paramContext.getSharedPreferences("chat_background_path_" + paramString, 0).edit().clear().commit();
  }
  
  public static final void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0).edit();
    if (paramString2 == null) {
      paramContext.putString("chat_uniform_bg", paramString3);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString2, paramString3);
    }
  }
  
  /* Error */
  public static final boolean a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean, ChatBackground paramChatBackground)
  {
    // Byte code:
    //   0: aload_0
    //   1: new 169	java/lang/StringBuilder
    //   4: dup
    //   5: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   8: ldc 172
    //   10: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: aload_1
    //   14: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   20: iconst_0
    //   21: invokevirtual 183	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   24: astore 10
    //   26: aload 10
    //   28: aload_2
    //   29: aconst_null
    //   30: invokeinterface 209 3 0
    //   35: astore_2
    //   36: aload_2
    //   37: astore_1
    //   38: aload_2
    //   39: ifnonnull +1102 -> 1141
    //   42: aload 10
    //   44: ldc 200
    //   46: aconst_null
    //   47: invokeinterface 209 3 0
    //   52: astore_2
    //   53: aload_2
    //   54: astore_1
    //   55: aload_2
    //   56: ifnonnull +1085 -> 1141
    //   59: ldc 211
    //   61: astore 8
    //   63: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   66: ifeq +29 -> 95
    //   69: ldc 213
    //   71: iconst_2
    //   72: new 169	java/lang/StringBuilder
    //   75: dup
    //   76: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   79: ldc 215
    //   81: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload 8
    //   86: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   92: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload 4
    //   97: getfield 220	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   100: aload 8
    //   102: if_acmpeq +995 -> 1097
    //   105: ldc 124
    //   107: aload 8
    //   109: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   112: ifne +23 -> 135
    //   115: ldc 211
    //   117: aload 8
    //   119: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   122: ifne +13 -> 135
    //   125: ldc 228
    //   127: aload 8
    //   129: invokevirtual 226	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   132: ifeq +35 -> 167
    //   135: aload 4
    //   137: ldc 211
    //   139: putfield 220	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   142: aload 4
    //   144: aload_0
    //   145: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   148: ldc 229
    //   150: invokevirtual 233	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   153: putfield 235	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   156: aload_0
    //   157: aload 4
    //   159: aload 8
    //   161: invokestatic 237	com/tencent/mobileqq/activity/aio/ChatBackground:a	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/ChatBackground;Ljava/lang/String;)V
    //   164: goto +983 -> 1147
    //   167: getstatic 240	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   170: aload 8
    //   172: invokevirtual 246	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   175: ifnull +357 -> 532
    //   178: getstatic 240	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   181: aload 8
    //   183: invokevirtual 246	android/support/v4/util/MQLruCache:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   186: checkcast 22	android/graphics/Bitmap
    //   189: astore_1
    //   190: aload_1
    //   191: astore_2
    //   192: aload_1
    //   193: ifnonnull +943 -> 1136
    //   196: new 248	java/io/File
    //   199: dup
    //   200: aload 8
    //   202: invokespecial 251	java/io/File:<init>	(Ljava/lang/String;)V
    //   205: astore_2
    //   206: aload_2
    //   207: ifnull +17 -> 224
    //   210: aload_2
    //   211: invokevirtual 254	java/io/File:exists	()Z
    //   214: ifeq +10 -> 224
    //   217: aload_2
    //   218: invokevirtual 257	java/io/File:isFile	()Z
    //   221: ifne +325 -> 546
    //   224: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   227: ifeq +30 -> 257
    //   230: ldc 213
    //   232: iconst_2
    //   233: new 169	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   240: ldc_w 259
    //   243: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload 8
    //   248: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 218	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   257: new 84	java/util/HashMap
    //   260: dup
    //   261: invokespecial 85	java/util/HashMap:<init>	()V
    //   264: astore_2
    //   265: aload_2
    //   266: ldc 87
    //   268: ldc_w 261
    //   271: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   274: pop
    //   275: aload_2
    //   276: ldc 95
    //   278: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   281: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   284: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   287: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   290: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   293: pop
    //   294: aload_0
    //   295: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   298: astore 9
    //   300: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   303: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   306: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   309: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   312: astore 11
    //   314: aload_1
    //   315: ifnull +222 -> 537
    //   318: iconst_1
    //   319: istore_3
    //   320: aload 9
    //   322: aload 11
    //   324: ldc 122
    //   326: iload_3
    //   327: lconst_1
    //   328: lconst_0
    //   329: aload_2
    //   330: ldc 124
    //   332: iconst_0
    //   333: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   336: aload_1
    //   337: ifnull +695 -> 1032
    //   340: getstatic 240	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_AndroidSupportV4UtilMQLruCache	Landroid/support/v4/util/MQLruCache;
    //   343: aload 8
    //   345: aload_1
    //   346: invokevirtual 262	android/support/v4/util/MQLruCache:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   349: pop
    //   350: aload 4
    //   352: aload 8
    //   354: putfield 220	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   357: aload 4
    //   359: new 136	com/tencent/mobileqq/drawable/ChatBackgroundDrawable
    //   362: dup
    //   363: aload_0
    //   364: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   367: aload_1
    //   368: invokespecial 139	com/tencent/mobileqq/drawable/ChatBackgroundDrawable:<init>	(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V
    //   371: putfield 129	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   374: new 169	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 264
    //   384: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload 8
    //   389: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   392: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: astore_2
    //   396: aload 10
    //   398: aload_2
    //   399: invokeinterface 268 2 0
    //   404: ifeq +588 -> 992
    //   407: aload 4
    //   409: aload 10
    //   411: aload_2
    //   412: ldc 9
    //   414: invokeinterface 272 3 0
    //   419: invokestatic 277	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   422: putfield 235	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   425: goto +722 -> 1147
    //   428: astore_1
    //   429: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   432: ifeq +14 -> 446
    //   435: ldc_w 279
    //   438: iconst_2
    //   439: aload_1
    //   440: invokevirtual 154	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   443: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload 4
    //   448: aload_0
    //   449: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   452: ldc 159
    //   454: invokevirtual 69	android/content/res/Resources:getDrawable	(I)Landroid/graphics/drawable/Drawable;
    //   457: putfield 129	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidGraphicsDrawableDrawable	Landroid/graphics/drawable/Drawable;
    //   460: new 84	java/util/HashMap
    //   463: dup
    //   464: invokespecial 85	java/util/HashMap:<init>	()V
    //   467: astore_1
    //   468: aload_1
    //   469: ldc 87
    //   471: ldc_w 281
    //   474: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   477: pop
    //   478: aload_1
    //   479: ldc 95
    //   481: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   484: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   487: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   490: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   493: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   496: pop
    //   497: aload_0
    //   498: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   501: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   504: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   507: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   510: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   513: ldc 122
    //   515: iconst_0
    //   516: lconst_1
    //   517: lconst_0
    //   518: aload_1
    //   519: ldc 124
    //   521: iconst_0
    //   522: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   525: goto +622 -> 1147
    //   528: astore_0
    //   529: goto +618 -> 1147
    //   532: aconst_null
    //   533: astore_1
    //   534: goto -344 -> 190
    //   537: iconst_0
    //   538: istore_3
    //   539: goto -219 -> 320
    //   542: astore_2
    //   543: goto -207 -> 336
    //   546: new 283	android/graphics/BitmapFactory$Options
    //   549: dup
    //   550: invokespecial 284	android/graphics/BitmapFactory$Options:<init>	()V
    //   553: astore 11
    //   555: aload 11
    //   557: getstatic 290	android/graphics/Bitmap$Config:RGB_565	Landroid/graphics/Bitmap$Config;
    //   560: putfield 293	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   563: aload 11
    //   565: iconst_1
    //   566: putfield 297	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   569: aload 8
    //   571: aload 11
    //   573: invokestatic 302	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   576: pop
    //   577: aload_0
    //   578: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   581: invokevirtual 306	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   584: getfield 311	android/util/DisplayMetrics:heightPixels	I
    //   587: aload_0
    //   588: ldc_w 312
    //   591: invokestatic 317	com/tencent/mobileqq/utils/DisplayUtils:a	(Landroid/content/Context;F)F
    //   594: f2i
    //   595: isub
    //   596: istore 6
    //   598: aload_0
    //   599: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   602: invokevirtual 306	android/content/res/Resources:getDisplayMetrics	()Landroid/util/DisplayMetrics;
    //   605: getfield 320	android/util/DisplayMetrics:widthPixels	I
    //   608: istore 7
    //   610: iload 6
    //   612: istore 5
    //   614: iload 6
    //   616: sipush 400
    //   619: if_icmpge +530 -> 1149
    //   622: sipush 400
    //   625: istore 5
    //   627: goto +522 -> 1149
    //   630: aload 11
    //   632: getfield 323	android/graphics/BitmapFactory$Options:outHeight	I
    //   635: iload 6
    //   637: idiv
    //   638: i2d
    //   639: invokestatic 329	java/lang/Math:ceil	(D)D
    //   642: d2i
    //   643: istore 5
    //   645: aload 11
    //   647: getfield 332	android/graphics/BitmapFactory$Options:outWidth	I
    //   650: iload 7
    //   652: idiv
    //   653: i2d
    //   654: invokestatic 329	java/lang/Math:ceil	(D)D
    //   657: d2i
    //   658: istore 6
    //   660: iload 5
    //   662: iconst_1
    //   663: if_icmpgt +9 -> 672
    //   666: iload 6
    //   668: iconst_1
    //   669: if_icmple +314 -> 983
    //   672: iload 5
    //   674: iload 6
    //   676: if_icmple +297 -> 973
    //   679: aload 11
    //   681: iload 5
    //   683: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   686: aload 11
    //   688: iconst_0
    //   689: putfield 297	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   692: aload 8
    //   694: aload 11
    //   696: invokestatic 338	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   699: astore 9
    //   701: aload 9
    //   703: getfield 343	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   706: astore_1
    //   707: new 84	java/util/HashMap
    //   710: dup
    //   711: invokespecial 85	java/util/HashMap:<init>	()V
    //   714: astore_2
    //   715: aload_2
    //   716: ldc 87
    //   718: new 169	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 345
    //   728: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: aload 9
    //   733: getfield 347	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   736: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   739: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   742: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   745: pop
    //   746: aload_2
    //   747: ldc 95
    //   749: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   752: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   755: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   758: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   761: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   764: pop
    //   765: aload_0
    //   766: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   769: astore 12
    //   771: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   774: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   777: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   780: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   783: astore 13
    //   785: aload_1
    //   786: ifnull +383 -> 1169
    //   789: iconst_1
    //   790: istore_3
    //   791: aload 12
    //   793: aload 13
    //   795: ldc 122
    //   797: iload_3
    //   798: lconst_1
    //   799: lconst_0
    //   800: aload_2
    //   801: ldc 124
    //   803: iconst_0
    //   804: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   807: aload_1
    //   808: astore_2
    //   809: aload 9
    //   811: getfield 347	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   814: iconst_1
    //   815: if_icmpne +321 -> 1136
    //   818: aload 11
    //   820: getfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   823: iconst_2
    //   824: imul
    //   825: istore 5
    //   827: aload 9
    //   829: astore_2
    //   830: iload 5
    //   832: bipush 32
    //   834: if_icmpgt +35 -> 869
    //   837: aload 11
    //   839: iload 5
    //   841: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   844: aload 8
    //   846: aload 11
    //   848: invokestatic 338	com/tencent/mobileqq/util/BitmapManager:a	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Lcom/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult;
    //   851: astore_2
    //   852: aload_2
    //   853: getfield 343	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:a	Landroid/graphics/Bitmap;
    //   856: astore_1
    //   857: aload_2
    //   858: getfield 347	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   861: istore 6
    //   863: iload 6
    //   865: iconst_1
    //   866: if_icmpeq +308 -> 1174
    //   869: new 84	java/util/HashMap
    //   872: dup
    //   873: invokespecial 85	java/util/HashMap:<init>	()V
    //   876: astore 9
    //   878: aload 9
    //   880: ldc 87
    //   882: new 169	java/lang/StringBuilder
    //   885: dup
    //   886: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   889: ldc_w 352
    //   892: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: aload_2
    //   896: getfield 347	com/tencent/mobileqq/util/BitmapManager$BitmapDecodeResult:e	I
    //   899: invokevirtual 350	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   902: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   905: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   908: pop
    //   909: aload 9
    //   911: ldc 95
    //   913: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   916: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   919: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   922: invokestatic 111	com/tencent/mobileqq/theme/ThemeUtil:getUserCurrentThemeId	(Lcom/tencent/common/app/AppInterface;)Ljava/lang/String;
    //   925: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   928: pop
    //   929: aload_0
    //   930: invokestatic 116	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   933: astore_2
    //   934: getstatic 100	com/tencent/common/app/BaseApplicationImpl:jdField_a_of_type_ComTencentCommonAppBaseApplicationImpl	Lcom/tencent/common/app/BaseApplicationImpl;
    //   937: invokevirtual 103	com/tencent/common/app/BaseApplicationImpl:a	()Lmqq/app/AppRuntime;
    //   940: checkcast 105	com/tencent/mobileqq/app/QQAppInterface
    //   943: invokevirtual 120	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   946: astore 11
    //   948: aload_1
    //   949: ifnull +234 -> 1183
    //   952: iconst_1
    //   953: istore_3
    //   954: aload_2
    //   955: aload 11
    //   957: ldc 122
    //   959: iload_3
    //   960: lconst_1
    //   961: lconst_0
    //   962: aload 9
    //   964: ldc 124
    //   966: iconst_0
    //   967: invokevirtual 127	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   970: goto -634 -> 336
    //   973: aload 11
    //   975: iload 6
    //   977: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   980: goto -294 -> 686
    //   983: aload 11
    //   985: iconst_1
    //   986: putfield 335	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   989: goto -303 -> 686
    //   992: aload_1
    //   993: invokestatic 354	com/tencent/mobileqq/activity/aio/ChatBackground:a	(Landroid/graphics/Bitmap;)I
    //   996: istore 5
    //   998: aload 4
    //   1000: iload 5
    //   1002: invokestatic 277	android/content/res/ColorStateList:valueOf	(I)Landroid/content/res/ColorStateList;
    //   1005: putfield 235	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   1008: aload 10
    //   1010: invokeinterface 189 1 0
    //   1015: aload_2
    //   1016: iload 5
    //   1018: invokeinterface 358 3 0
    //   1023: invokeinterface 197 1 0
    //   1028: pop
    //   1029: goto +118 -> 1147
    //   1032: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1035: ifeq +30 -> 1065
    //   1038: ldc 213
    //   1040: iconst_2
    //   1041: new 169	java/lang/StringBuilder
    //   1044: dup
    //   1045: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1048: ldc_w 360
    //   1051: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1054: aload 8
    //   1056: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1059: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1062: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1065: aload 4
    //   1067: ldc 211
    //   1069: putfield 220	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1072: aload 4
    //   1074: aload_0
    //   1075: invokevirtual 62	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   1078: ldc 229
    //   1080: invokevirtual 233	android/content/res/Resources:getColorStateList	(I)Landroid/content/res/ColorStateList;
    //   1083: putfield 235	com/tencent/mobileqq/activity/aio/ChatBackground:jdField_a_of_type_AndroidContentResColorStateList	Landroid/content/res/ColorStateList;
    //   1086: aload_0
    //   1087: aload 4
    //   1089: aload 8
    //   1091: invokestatic 237	com/tencent/mobileqq/activity/aio/ChatBackground:a	(Landroid/content/Context;Lcom/tencent/mobileqq/activity/aio/ChatBackground;Ljava/lang/String;)V
    //   1094: goto +53 -> 1147
    //   1097: invokestatic 149	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1100: ifeq +30 -> 1130
    //   1103: ldc 213
    //   1105: iconst_2
    //   1106: new 169	java/lang/StringBuilder
    //   1109: dup
    //   1110: invokespecial 170	java/lang/StringBuilder:<init>	()V
    //   1113: ldc_w 362
    //   1116: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1119: aload 8
    //   1121: invokevirtual 176	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: invokevirtual 179	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1127: invokestatic 158	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1130: iconst_0
    //   1131: ireturn
    //   1132: astore_2
    //   1133: goto -326 -> 807
    //   1136: aload_2
    //   1137: astore_1
    //   1138: goto -802 -> 336
    //   1141: aload_1
    //   1142: astore 8
    //   1144: goto -1081 -> 63
    //   1147: iconst_1
    //   1148: ireturn
    //   1149: iload 5
    //   1151: istore 6
    //   1153: iload 5
    //   1155: sipush 300
    //   1158: if_icmpge -528 -> 630
    //   1161: sipush 300
    //   1164: istore 6
    //   1166: goto -536 -> 630
    //   1169: iconst_0
    //   1170: istore_3
    //   1171: goto -380 -> 791
    //   1174: iload 5
    //   1176: iconst_2
    //   1177: imul
    //   1178: istore 5
    //   1180: goto -350 -> 830
    //   1183: iconst_0
    //   1184: istore_3
    //   1185: goto -231 -> 954
    //   1188: astore_2
    //   1189: goto -853 -> 336
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1192	0	paramContext	Context
    //   0	1192	1	paramString1	String
    //   0	1192	2	paramString2	String
    //   0	1192	3	paramBoolean	boolean
    //   0	1192	4	paramChatBackground	ChatBackground
    //   612	567	5	i	int
    //   596	569	6	j	int
    //   608	45	7	k	int
    //   61	1082	8	str1	String
    //   298	665	9	localObject1	Object
    //   24	985	10	localSharedPreferences	SharedPreferences
    //   312	672	11	localObject2	Object
    //   769	23	12	localStatisticCollector	com.tencent.mobileqq.statistics.StatisticCollector
    //   783	11	13	str2	String
    // Exception table:
    //   from	to	target	type
    //   105	135	428	java/lang/OutOfMemoryError
    //   135	164	428	java/lang/OutOfMemoryError
    //   167	190	428	java/lang/OutOfMemoryError
    //   196	206	428	java/lang/OutOfMemoryError
    //   210	224	428	java/lang/OutOfMemoryError
    //   224	257	428	java/lang/OutOfMemoryError
    //   257	314	428	java/lang/OutOfMemoryError
    //   320	336	428	java/lang/OutOfMemoryError
    //   340	425	428	java/lang/OutOfMemoryError
    //   546	610	428	java/lang/OutOfMemoryError
    //   630	660	428	java/lang/OutOfMemoryError
    //   679	686	428	java/lang/OutOfMemoryError
    //   686	707	428	java/lang/OutOfMemoryError
    //   707	785	428	java/lang/OutOfMemoryError
    //   791	807	428	java/lang/OutOfMemoryError
    //   809	827	428	java/lang/OutOfMemoryError
    //   837	863	428	java/lang/OutOfMemoryError
    //   869	948	428	java/lang/OutOfMemoryError
    //   954	970	428	java/lang/OutOfMemoryError
    //   973	980	428	java/lang/OutOfMemoryError
    //   983	989	428	java/lang/OutOfMemoryError
    //   992	1029	428	java/lang/OutOfMemoryError
    //   1032	1065	428	java/lang/OutOfMemoryError
    //   1065	1094	428	java/lang/OutOfMemoryError
    //   460	525	528	java/lang/Exception
    //   257	314	542	java/lang/Exception
    //   320	336	542	java/lang/Exception
    //   707	785	1132	java/lang/Exception
    //   791	807	1132	java/lang/Exception
    //   869	948	1188	java/lang/Exception
    //   954	970	1188	java/lang/Exception
  }
  
  public static final void b(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences("chat_background_path_" + paramString1, 0);
    paramString1 = paramContext.edit();
    if (paramString2 == null)
    {
      paramString1.putString("chat_uniform_bg", paramString3);
      paramString2 = paramContext.getAll();
      if (paramString2 != null)
      {
        paramString2 = paramString2.keySet().iterator();
        while (paramString2.hasNext())
        {
          String str1 = (String)paramString2.next();
          if (Pattern.compile("[0-9]*").matcher(str1).matches())
          {
            String str2 = paramContext.getString(str1, "null");
            boolean bool = paramContext.getBoolean(str1 + "_is_c2c_set", false);
            if ((str2 == null) || (str2.trim().length() == 0) || (str2.equals("null")) || (str2.equals("none")) || (!bool)) {
              paramString1.putString(str1, paramString3);
            }
          }
        }
      }
    }
    else
    {
      paramString1.putString(paramString2, paramString3);
      if (!paramString3.equals("null")) {
        break label254;
      }
      paramString1.putBoolean(paramString2 + "_is_c2c_set", false);
    }
    for (;;)
    {
      paramString1.commit();
      return;
      label254:
      paramString1.putBoolean(paramString2 + "_is_c2c_set", true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ChatBackground
 * JD-Core Version:    0.7.0.1
 */