package com.tencent.mobileqq.emoji;

import android.content.Context;
import com.tencent.mobileqq.activity.IndividuationSetActivity.EmojiJsBridgeListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.HttpContinueDownloadFileProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import dep;
import deq;
import org.json.JSONException;
import org.json.JSONObject;

public class EmojiJsHandler
{
  public static final int a = 1001;
  public static final String a = "Emoji.EmojiJsHandler";
  public static final int b = 1002;
  public static final int c = 1005;
  public static final int d = 1006;
  public static final int e = 1007;
  public static final int f = 1009;
  public static final int g = 1010;
  public static final int h = 1011;
  public static final int i = 1012;
  public static final int j = 1013;
  public static final int k = 1014;
  public static final int l = 1015;
  public static final int m = 1016;
  public static final int n = 1017;
  public static final int o = 1018;
  public Context a;
  private IndividuationSetActivity.EmojiJsBridgeListener jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener;
  public IphoneTitleBarActivity a;
  QQCustomDialog jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog;
  public QQProgressDialog a;
  public dep a;
  public QQProgressDialog b;
  
  public EmojiJsHandler(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity = ((IphoneTitleBarActivity)paramContext);
  }
  
  private void a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("Emoji.EmojiJsHandler", 2, "EmojiJsHandler reportEmojiDown actionResult=" + paramString);
      }
      String str2 = this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.getAccount();
      int i1 = NetworkUtil.a(this.jdField_a_of_type_AndroidContentContext);
      if (i1 >= 2) {}
      for (String str1 = "2";; str1 = String.valueOf(i1))
      {
        StatisticCollector.a(this.jdField_a_of_type_AndroidContentContext).a(this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app, str2, "emoji_mall", "emoji_download", 0, 1, paramString, null, str1, null, null);
        return;
      }
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Dep == null)
    {
      this.jdField_a_of_type_Dep = new dep(this);
      this.jdField_a_of_type_Dep.addFilter(new Class[] { HttpContinueDownloadFileProcessor.class });
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.a().a(this.jdField_a_of_type_Dep);
    }
  }
  
  public void a(IndividuationSetActivity.EmojiJsBridgeListener paramEmojiJsBridgeListener)
  {
    new deq(this, paramEmojiJsBridgeListener).execute(new Object[0]);
  }
  
  /* Error */
  public void a(JSONObject paramJSONObject, IndividuationSetActivity.EmojiJsBridgeListener paramEmojiJsBridgeListener)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: ldc 163
    //   5: invokevirtual 169	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   8: astore 6
    //   10: aload_1
    //   11: ldc 171
    //   13: invokevirtual 175	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   16: istore_3
    //   17: new 165	org/json/JSONObject
    //   20: dup
    //   21: invokespecial 176	org/json/JSONObject:<init>	()V
    //   24: astore_1
    //   25: aload_0
    //   26: getfield 51	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   29: checkcast 178	com/tencent/mobileqq/app/BaseActivity
    //   32: astore 7
    //   34: invokestatic 182	com/tencent/mobileqq/util/Utils:e	()Z
    //   37: ifne +59 -> 96
    //   40: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   43: ifeq +11 -> 54
    //   46: ldc 10
    //   48: iconst_2
    //   49: ldc 184
    //   51: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   54: aload_1
    //   55: ldc 188
    //   57: bipush 7
    //   59: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   62: pop
    //   63: aload_1
    //   64: ldc 194
    //   66: ldc 184
    //   68: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   71: pop
    //   72: aload_1
    //   73: ldc 199
    //   75: sipush 1005
    //   78: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   81: pop
    //   82: aload_2
    //   83: aload_1
    //   84: invokevirtual 204	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Lorg/json/JSONObject;)V
    //   87: aload_0
    //   88: ldc 104
    //   90: invokespecial 64	com/tencent/mobileqq/emoji/EmojiJsHandler:a	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: return
    //   96: ldc 205
    //   98: invokestatic 210	com/tencent/mobileqq/emoji/EmojiUtil:a	(I)Z
    //   101: ifeq +108 -> 209
    //   104: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   107: ifeq +28 -> 135
    //   110: ldc 10
    //   112: iconst_2
    //   113: new 74	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   120: ldc 212
    //   122: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: iload_3
    //   126: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   135: aload_1
    //   136: ldc 188
    //   138: iconst_3
    //   139: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   142: pop
    //   143: aload_1
    //   144: ldc 194
    //   146: ldc 217
    //   148: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   151: pop
    //   152: aload_1
    //   153: ldc 199
    //   155: sipush 1009
    //   158: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   161: pop
    //   162: aload_2
    //   163: aload_1
    //   164: invokevirtual 204	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Lorg/json/JSONObject;)V
    //   167: goto -74 -> 93
    //   170: astore_1
    //   171: aload_2
    //   172: new 74	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   179: ldc 219
    //   181: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload_1
    //   185: invokevirtual 222	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   188: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   194: invokevirtual 223	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Ljava/lang/String;)V
    //   197: aload_1
    //   198: invokevirtual 224	org/json/JSONException:printStackTrace	()V
    //   201: goto -108 -> 93
    //   204: astore_1
    //   205: aload_0
    //   206: monitorexit
    //   207: aload_1
    //   208: athrow
    //   209: invokestatic 227	com/tencent/mobileqq/util/Utils:b	()J
    //   212: lstore 4
    //   214: lload 4
    //   216: iload_3
    //   217: ldc 228
    //   219: iadd
    //   220: i2l
    //   221: lcmp
    //   222: ifge +129 -> 351
    //   225: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   228: ifeq +48 -> 276
    //   231: ldc 10
    //   233: iconst_2
    //   234: new 74	java/lang/StringBuilder
    //   237: dup
    //   238: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   241: ldc 230
    //   243: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: iload_3
    //   247: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   250: ldc 232
    //   252: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   255: ldc 228
    //   257: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   260: ldc 234
    //   262: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: lload 4
    //   267: invokevirtual 237	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   270: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   273: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   276: aload_1
    //   277: ldc 188
    //   279: iconst_1
    //   280: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   283: pop
    //   284: aload_1
    //   285: ldc 194
    //   287: ldc 239
    //   289: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   292: pop
    //   293: aload_1
    //   294: ldc 199
    //   296: sipush 1006
    //   299: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   302: pop
    //   303: aload_0
    //   304: ldc 104
    //   306: invokespecial 64	com/tencent/mobileqq/emoji/EmojiJsHandler:a	(Ljava/lang/String;)V
    //   309: aload_2
    //   310: aload_1
    //   311: invokevirtual 204	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Lorg/json/JSONObject;)V
    //   314: goto -221 -> 93
    //   317: astore_1
    //   318: aload_2
    //   319: new 74	java/lang/StringBuilder
    //   322: dup
    //   323: invokespecial 75	java/lang/StringBuilder:<init>	()V
    //   326: ldc 241
    //   328: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: aload_1
    //   332: invokevirtual 242	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   335: invokevirtual 81	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   341: invokevirtual 223	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Ljava/lang/String;)V
    //   344: aload_1
    //   345: invokevirtual 125	java/lang/Exception:printStackTrace	()V
    //   348: goto -255 -> 93
    //   351: aload_0
    //   352: getfield 51	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_AndroidContentContext	Landroid/content/Context;
    //   355: invokestatic 245	com/tencent/mobileqq/utils/NetworkUtil:e	(Landroid/content/Context;)Z
    //   358: ifne +52 -> 410
    //   361: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +11 -> 375
    //   367: ldc 10
    //   369: iconst_2
    //   370: ldc 247
    //   372: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: aload_1
    //   376: ldc 188
    //   378: iconst_5
    //   379: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   382: pop
    //   383: aload_1
    //   384: ldc 194
    //   386: ldc 247
    //   388: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   391: pop
    //   392: aload_1
    //   393: ldc 199
    //   395: sipush 1007
    //   398: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   401: pop
    //   402: aload_2
    //   403: aload_1
    //   404: invokevirtual 204	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Lorg/json/JSONObject;)V
    //   407: goto -314 -> 93
    //   410: aload 7
    //   412: ldc 249
    //   414: invokevirtual 253	com/tencent/mobileqq/app/BaseActivity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   417: checkcast 255	android/net/ConnectivityManager
    //   420: invokevirtual 259	android/net/ConnectivityManager:getActiveNetworkInfo	()Landroid/net/NetworkInfo;
    //   423: astore 8
    //   425: aload 8
    //   427: ifnull +139 -> 566
    //   430: aload 8
    //   432: invokestatic 262	com/tencent/mobileqq/utils/NetworkUtil:a	(Landroid/net/NetworkInfo;)Z
    //   435: ifeq +131 -> 566
    //   438: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   441: ifeq +12 -> 453
    //   444: ldc 10
    //   446: iconst_2
    //   447: ldc_w 264
    //   450: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: aload_0
    //   454: new 266	del
    //   457: dup
    //   458: aload_0
    //   459: aload 7
    //   461: ldc_w 267
    //   464: aload_2
    //   465: invokespecial 270	del:<init>	(Lcom/tencent/mobileqq/emoji/EmojiJsHandler;Landroid/content/Context;ILcom/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener;)V
    //   468: putfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   471: aload_0
    //   472: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   475: ldc_w 273
    //   478: invokevirtual 279	com/tencent/mobileqq/utils/QQCustomDialog:setContentView	(I)V
    //   481: aload_0
    //   482: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   485: ldc_w 281
    //   488: invokevirtual 285	com/tencent/mobileqq/utils/QQCustomDialog:setTitle	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   491: pop
    //   492: aload_0
    //   493: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   496: ldc_w 286
    //   499: invokevirtual 290	com/tencent/mobileqq/utils/QQCustomDialog:setMessage	(I)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   502: pop
    //   503: aload_0
    //   504: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   507: iconst_0
    //   508: invokevirtual 294	com/tencent/mobileqq/utils/QQCustomDialog:setCanceledOnTouchOutside	(Z)V
    //   511: aload_0
    //   512: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   515: ldc_w 295
    //   518: new 297	dem
    //   521: dup
    //   522: aload_0
    //   523: aload_2
    //   524: invokespecial 298	dem:<init>	(Lcom/tencent/mobileqq/emoji/EmojiJsHandler;Lcom/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener;)V
    //   527: invokevirtual 302	com/tencent/mobileqq/utils/QQCustomDialog:setNegativeButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   530: pop
    //   531: aload_0
    //   532: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   535: ldc_w 303
    //   538: new 305	den
    //   541: dup
    //   542: aload_0
    //   543: aload 7
    //   545: aload_2
    //   546: aload 6
    //   548: iload_3
    //   549: invokespecial 308	den:<init>	(Lcom/tencent/mobileqq/emoji/EmojiJsHandler;Lcom/tencent/mobileqq/app/BaseActivity;Lcom/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener;Ljava/lang/String;I)V
    //   552: invokevirtual 311	com/tencent/mobileqq/utils/QQCustomDialog:setPositiveButton	(ILandroid/content/DialogInterface$OnClickListener;)Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   555: pop
    //   556: aload_0
    //   557: getfield 272	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog	Lcom/tencent/mobileqq/utils/QQCustomDialog;
    //   560: invokevirtual 314	com/tencent/mobileqq/utils/QQCustomDialog:show	()V
    //   563: goto -470 -> 93
    //   566: aload 7
    //   568: invokevirtual 317	com/tencent/mobileqq/app/BaseActivity:getTransFileControlller	()Lcom/tencent/mobileqq/transfile/TransFileController;
    //   571: astore 7
    //   573: invokestatic 319	com/tencent/mobileqq/emoji/EmojiUtil:a	()Ljava/lang/String;
    //   576: astore 8
    //   578: aload_0
    //   579: aload_2
    //   580: putfield 59	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener	Lcom/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener;
    //   583: aload 7
    //   585: ifnull +82 -> 667
    //   588: aload 7
    //   590: aload 6
    //   592: aload 8
    //   594: iload_3
    //   595: i2l
    //   596: invokevirtual 322	com/tencent/mobileqq/transfile/TransFileController:e	(Ljava/lang/String;Ljava/lang/String;J)Z
    //   599: ifeq +68 -> 667
    //   602: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   605: ifeq +12 -> 617
    //   608: ldc 10
    //   610: iconst_2
    //   611: ldc_w 324
    //   614: invokestatic 186	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload_0
    //   618: new 326	com/tencent/mobileqq/widget/QQProgressDialog
    //   621: dup
    //   622: aload_0
    //   623: getfield 55	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity	Lcom/tencent/mobileqq/app/IphoneTitleBarActivity;
    //   626: aload_0
    //   627: getfield 55	com/tencent/mobileqq/emoji/EmojiJsHandler:jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity	Lcom/tencent/mobileqq/app/IphoneTitleBarActivity;
    //   630: invokevirtual 330	com/tencent/mobileqq/app/IphoneTitleBarActivity:getTitleBarHeight	()I
    //   633: invokespecial 333	com/tencent/mobileqq/widget/QQProgressDialog:<init>	(Landroid/content/Context;I)V
    //   636: putfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   639: aload_0
    //   640: getfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   643: iconst_0
    //   644: invokevirtual 338	com/tencent/mobileqq/widget/QQProgressDialog:setCancelable	(Z)V
    //   647: aload_0
    //   648: getfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   651: ldc_w 339
    //   654: invokevirtual 341	com/tencent/mobileqq/widget/QQProgressDialog:b	(I)V
    //   657: aload_0
    //   658: getfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   661: invokevirtual 342	com/tencent/mobileqq/widget/QQProgressDialog:show	()V
    //   664: goto -571 -> 93
    //   667: aload 7
    //   669: ifnull +31 -> 700
    //   672: aload 7
    //   674: aload 6
    //   676: invokevirtual 345	com/tencent/mobileqq/transfile/TransFileController:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/utils/httputils/IHttpCommunicatorListener;
    //   679: ifnull +21 -> 700
    //   682: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq -592 -> 93
    //   688: ldc 10
    //   690: iconst_2
    //   691: ldc_w 347
    //   694: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   697: goto -604 -> 93
    //   700: invokestatic 72	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   703: ifeq +12 -> 715
    //   706: ldc 10
    //   708: iconst_2
    //   709: ldc_w 349
    //   712: invokestatic 88	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   715: aload_1
    //   716: ldc 188
    //   718: iconst_m1
    //   719: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   722: pop
    //   723: aload_1
    //   724: ldc 194
    //   726: ldc_w 351
    //   729: invokevirtual 197	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   732: pop
    //   733: aload_1
    //   734: ldc 199
    //   736: sipush 1015
    //   739: invokevirtual 192	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   742: pop
    //   743: aload_2
    //   744: aload_1
    //   745: invokevirtual 204	com/tencent/mobileqq/activity/IndividuationSetActivity$EmojiJsBridgeListener:a	(Lorg/json/JSONObject;)V
    //   748: aload_0
    //   749: getfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   752: ifnull -659 -> 93
    //   755: aload_0
    //   756: getfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   759: invokevirtual 354	com/tencent/mobileqq/widget/QQProgressDialog:isShowing	()Z
    //   762: ifeq -669 -> 93
    //   765: aload_0
    //   766: getfield 335	com/tencent/mobileqq/emoji/EmojiJsHandler:b	Lcom/tencent/mobileqq/widget/QQProgressDialog;
    //   769: invokevirtual 357	com/tencent/mobileqq/widget/QQProgressDialog:dismiss	()V
    //   772: goto -679 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	775	0	this	EmojiJsHandler
    //   0	775	1	paramJSONObject	JSONObject
    //   0	775	2	paramEmojiJsBridgeListener	IndividuationSetActivity.EmojiJsBridgeListener
    //   16	579	3	i1	int
    //   212	54	4	l1	long
    //   8	667	6	str	String
    //   32	641	7	localObject1	Object
    //   423	170	8	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	54	170	org/json/JSONException
    //   54	93	170	org/json/JSONException
    //   96	135	170	org/json/JSONException
    //   135	167	170	org/json/JSONException
    //   209	214	170	org/json/JSONException
    //   225	276	170	org/json/JSONException
    //   276	314	170	org/json/JSONException
    //   351	375	170	org/json/JSONException
    //   375	407	170	org/json/JSONException
    //   410	425	170	org/json/JSONException
    //   430	453	170	org/json/JSONException
    //   453	563	170	org/json/JSONException
    //   566	583	170	org/json/JSONException
    //   588	617	170	org/json/JSONException
    //   617	664	170	org/json/JSONException
    //   672	697	170	org/json/JSONException
    //   700	715	170	org/json/JSONException
    //   715	772	170	org/json/JSONException
    //   2	54	204	finally
    //   54	93	204	finally
    //   96	135	204	finally
    //   135	167	204	finally
    //   171	201	204	finally
    //   209	214	204	finally
    //   225	276	204	finally
    //   276	314	204	finally
    //   318	348	204	finally
    //   351	375	204	finally
    //   375	407	204	finally
    //   410	425	204	finally
    //   430	453	204	finally
    //   453	563	204	finally
    //   566	583	204	finally
    //   588	617	204	finally
    //   617	664	204	finally
    //   672	697	204	finally
    //   700	715	204	finally
    //   715	772	204	finally
    //   2	54	317	java/lang/Exception
    //   54	93	317	java/lang/Exception
    //   96	135	317	java/lang/Exception
    //   135	167	317	java/lang/Exception
    //   209	214	317	java/lang/Exception
    //   225	276	317	java/lang/Exception
    //   276	314	317	java/lang/Exception
    //   351	375	317	java/lang/Exception
    //   375	407	317	java/lang/Exception
    //   410	425	317	java/lang/Exception
    //   430	453	317	java/lang/Exception
    //   453	563	317	java/lang/Exception
    //   566	583	317	java/lang/Exception
    //   588	617	317	java/lang/Exception
    //   617	664	317	java/lang/Exception
    //   672	697	317	java/lang/Exception
    //   700	715	317	java/lang/Exception
    //   715	772	317	java/lang/Exception
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Dep != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppIphoneTitleBarActivity.app.a().b(this.jdField_a_of_type_Dep);
    }
  }
  
  public void c()
  {
    try
    {
      a("1");
      JSONObject localJSONObject = new JSONObject();
      TransFileController localTransFileController = ((BaseActivity)this.jdField_a_of_type_AndroidContentContext).getTransFileControlller();
      if (localTransFileController == null)
      {
        localJSONObject.put("what", 1014);
        localJSONObject.put("result", -1);
        localJSONObject.put("message", "getTransfileController error");
        this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a(localJSONObject);
        return;
      }
      ((HttpContinueDownloadFileProcessor)localTransFileController.a("http://i.gtimg.cn/qqshow/admindata/comdata/vip_mobile_theme_lite_night/emoji2.zip")).g();
      localJSONObject.put("result", 0);
      localJSONObject.put("message", "Downloading process paused.");
      localJSONObject.put("what", 1014);
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a(localJSONObject);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a("stopdown emoji JsonException:" + localJSONException.getMessage());
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this.jdField_a_of_type_ComTencentMobileqqActivityIndividuationSetActivity$EmojiJsBridgeListener.a("stopdown emoji Exception:" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoji.EmojiJsHandler
 * JD-Core Version:    0.7.0.1
 */