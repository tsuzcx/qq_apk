import QQService.EVIPSPEC;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.VasUtils.1;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.os.MqqHandler;

public final class aqnl
{
  public static String TAG = "VasUtils";
  private static int eab = 1000;
  
  public static boolean B(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      QLog.e(TAG, 1, "unCompressSo fail zipPath = " + paramString1 + " dstPath = " + paramString2);
    }
    for (;;)
    {
      return false;
      if (!new File(paramString1).exists())
      {
        QLog.e(TAG, 1, "unCompressSo fail src file not exists");
        return false;
      }
      String str = paramString2 + File.separator + "unzip_temp/";
      try
      {
        aqhq.W(paramString1, str, false);
        paramString1 = new File(str + paramString3);
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "unCompressSo tempfile = " + paramString1.getAbsolutePath());
        }
        if (!paramString1.exists())
        {
          QLog.e(TAG, 1, "unCompressSo fail so file not exists");
          return false;
        }
      }
      catch (IOException paramString1)
      {
        QLog.e(TAG, 1, "unCompressSo IOException: ", paramString1);
        return false;
      }
      paramString2 = paramString2 + File.separator + paramString3;
      paramString3 = new File(paramString2);
      boolean bool;
      if (paramString3.exists())
      {
        bool = paramString3.delete();
        QLog.d(TAG, 1, "unCompressSo so already exists, delete old so result = " + bool);
      }
      while (bool)
      {
        bool = paramString1.renameTo(paramString3);
        QLog.d(TAG, 1, "unCompressSo rename temp so to real path result = " + bool + "realpath = " + paramString2);
        return bool;
        bool = true;
      }
    }
  }
  
  public static void H(AppInterface paramAppInterface)
  {
    MqqHandler localMqqHandler = paramAppInterface.getHandler(ChatActivity.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "refreshAIO");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), eab);
    }
    localMqqHandler = paramAppInterface.getHandler(ChatHistoryBubbleListForTroopFragment.class);
    if (localMqqHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "refresh troop history");
      }
      localMqqHandler.removeMessages(16711697);
      localMqqHandler.sendMessageDelayed(localMqqHandler.obtainMessage(16711697), eab);
    }
    paramAppInterface = paramAppInterface.getHandler(MiniChatActivity.class);
    if (paramAppInterface != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "refresh miniAIO");
      }
      paramAppInterface.removeMessages(8);
      paramAppInterface.sendMessageDelayed(paramAppInterface.obtainMessage(8), eab);
    }
  }
  
  private static String J(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getCurrentNickname();
      paramQQAppInterface = str;
      if (TextUtils.isEmpty(str)) {
        paramQQAppInterface = "亲爱的用户";
      }
      return paramQQAppInterface;
    }
    return "";
  }
  
  public static Drawable a(String paramString, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    return a(paramString, false, false, paramURLDrawableListener, paramDrawable);
  }
  
  public static Drawable a(String paramString, boolean paramBoolean1, boolean paramBoolean2, URLDrawable.URLDrawableListener paramURLDrawableListener, Drawable paramDrawable)
  {
    Object localObject5 = null;
    Object localObject4 = null;
    Object localObject1 = paramDrawable;
    Object localObject2;
    Object localObject3;
    if (paramDrawable == null)
    {
      localObject2 = localObject5;
      localObject3 = paramDrawable;
    }
    for (;;)
    {
      try
      {
        localObject1 = new ColorDrawable(-1513240);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.URLDrawableOptions.obtain();
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mFailedDrawable = ((Drawable)localObject1);
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable.mLoadingDrawable = ((Drawable)localObject1);
        if (!paramBoolean1) {
          continue;
        }
      }
      catch (Exception paramURLDrawableListener)
      {
        QLog.e(TAG, 1, "getIPSiteDrawable error url = " + paramString + "error msg = " + paramURLDrawableListener);
        localObject1 = localObject3;
        paramDrawable = (Drawable)localObject2;
        continue;
        if (!paramBoolean2) {
          continue;
        }
        try
        {
          paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IPSITE_GAME_IMAGE", paramString), paramDrawable);
        }
        catch (Exception paramDrawable)
        {
          localObject2 = localObject5;
          localObject3 = localObject1;
          QLog.e(TAG, 1, "getIPSiteDrawable error = " + paramDrawable);
          paramDrawable = localObject4;
        }
        continue;
        localObject2 = localObject5;
        localObject3 = localObject1;
        paramDrawable = URLDrawable.getDrawable(paramString, paramDrawable);
        continue;
        return paramDrawable;
        if (paramDrawable != null) {
          continue;
        }
      }
      try
      {
        paramDrawable = URLDrawable.getDrawable(new URL("protocol_vas_extension_image", "COMIC_IP_SITE_ROUND_IMAGE", paramString), paramDrawable);
        if (paramDrawable != null)
        {
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          if (paramDrawable.getTag() == null)
          {
            localObject2 = paramDrawable;
            localObject3 = localObject1;
            paramDrawable.setTag(Integer.valueOf(0));
          }
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setURLDrawableListener(paramURLDrawableListener);
          localObject2 = paramDrawable;
          localObject3 = localObject1;
          paramDrawable.setAutoDownload(true);
        }
      }
      catch (Exception paramDrawable)
      {
        localObject2 = localObject5;
        localObject3 = localObject1;
        QLog.e(TAG, 1, "getIPSiteDrawable error = " + paramDrawable);
        paramDrawable = localObject4;
      }
    }
    return localObject1;
  }
  
  /* Error */
  public static SpannableString a(QQAppInterface paramQQAppInterface, com.tencent.imcore.message.QQMessageFacade.Message paramMessage, boolean paramBoolean)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aload 8
    //   5: astore 6
    //   7: aload_1
    //   8: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:mExJsonObject	Lorg/json/JSONObject;
    //   11: ifnull +187 -> 198
    //   14: new 243	org/json/JSONObject
    //   17: dup
    //   18: new 243	org/json/JSONObject
    //   21: dup
    //   22: aload_1
    //   23: getfield 241	com/tencent/imcore/message/QQMessageFacade$Message:mExJsonObject	Lorg/json/JSONObject;
    //   26: ldc 245
    //   28: ldc 155
    //   30: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   33: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   36: ldc 252
    //   38: ldc 155
    //   40: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   43: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   46: astore 6
    //   48: aload 6
    //   50: ldc 254
    //   52: aconst_null
    //   53: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   56: astore_1
    //   57: aload 6
    //   59: ldc_w 256
    //   62: ldc_w 258
    //   65: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   68: astore 6
    //   70: aload_1
    //   71: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   74: istore 5
    //   76: iload 5
    //   78: ifeq +5 -> 83
    //   81: aconst_null
    //   82: astore_1
    //   83: aload_1
    //   84: astore 7
    //   86: aload 6
    //   88: astore_1
    //   89: aload_0
    //   90: invokestatic 260	aqnl:J	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   93: astore_0
    //   94: aload 8
    //   96: astore 6
    //   98: aload 7
    //   100: ifnull +98 -> 198
    //   103: aload 7
    //   105: ldc_w 262
    //   108: invokevirtual 268	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   111: istore_3
    //   112: aload_0
    //   113: invokevirtual 272	java/lang/String:length	()I
    //   116: iload_3
    //   117: iadd
    //   118: istore 4
    //   120: aload 7
    //   122: ldc_w 262
    //   125: aload_0
    //   126: invokevirtual 276	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   129: astore_0
    //   130: iload_3
    //   131: iconst_m1
    //   132: if_icmple +95 -> 227
    //   135: new 278	android/text/SpannableString
    //   138: dup
    //   139: aload_0
    //   140: invokespecial 281	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   143: astore_0
    //   144: aload_0
    //   145: astore 6
    //   147: aload_1
    //   148: ifnull +50 -> 198
    //   151: aload_0
    //   152: astore 6
    //   154: iload_2
    //   155: ifeq +43 -> 198
    //   158: aload_0
    //   159: new 283	android/text/style/StyleSpan
    //   162: dup
    //   163: iconst_1
    //   164: invokespecial 284	android/text/style/StyleSpan:<init>	(I)V
    //   167: iload_3
    //   168: iload 4
    //   170: bipush 18
    //   172: invokevirtual 288	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   175: aload_0
    //   176: new 290	android/text/style/ForegroundColorSpan
    //   179: dup
    //   180: aload_1
    //   181: invokestatic 295	android/graphics/Color:parseColor	(Ljava/lang/String;)I
    //   184: invokespecial 296	android/text/style/ForegroundColorSpan:<init>	(I)V
    //   187: iload_3
    //   188: iload 4
    //   190: bipush 18
    //   192: invokevirtual 288	android/text/SpannableString:setSpan	(Ljava/lang/Object;III)V
    //   195: aload_0
    //   196: astore 6
    //   198: aload 6
    //   200: areturn
    //   201: astore 7
    //   203: aconst_null
    //   204: astore 6
    //   206: aconst_null
    //   207: astore_1
    //   208: aload 7
    //   210: invokevirtual 299	org/json/JSONException:printStackTrace	()V
    //   213: aload 6
    //   215: astore 7
    //   217: goto -128 -> 89
    //   220: astore_1
    //   221: aload_1
    //   222: invokevirtual 300	java/lang/IllegalArgumentException:printStackTrace	()V
    //   225: aload_0
    //   226: areturn
    //   227: new 278	android/text/SpannableString
    //   230: dup
    //   231: aload_0
    //   232: invokespecial 281	android/text/SpannableString:<init>	(Ljava/lang/CharSequence;)V
    //   235: areturn
    //   236: astore 7
    //   238: aload_1
    //   239: astore 6
    //   241: aconst_null
    //   242: astore_1
    //   243: goto -35 -> 208
    //   246: astore 9
    //   248: aload_1
    //   249: astore 7
    //   251: aload 6
    //   253: astore_1
    //   254: aload 7
    //   256: astore 6
    //   258: aload 9
    //   260: astore 7
    //   262: goto -54 -> 208
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	265	0	paramQQAppInterface	QQAppInterface
    //   0	265	1	paramMessage	com.tencent.imcore.message.QQMessageFacade.Message
    //   0	265	2	paramBoolean	boolean
    //   111	77	3	i	int
    //   118	71	4	j	int
    //   74	3	5	bool	boolean
    //   5	252	6	localObject1	Object
    //   84	37	7	localMessage	com.tencent.imcore.message.QQMessageFacade.Message
    //   201	8	7	localJSONException1	org.json.JSONException
    //   215	1	7	localObject2	Object
    //   236	1	7	localJSONException2	org.json.JSONException
    //   249	12	7	localObject3	Object
    //   1	94	8	localObject4	Object
    //   246	13	9	localJSONException3	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   14	57	201	org/json/JSONException
    //   158	195	220	java/lang/IllegalArgumentException
    //   57	70	236	org/json/JSONException
    //   70	76	246	org/json/JSONException
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt, String paramString)
  {
    a(paramActivity, paramAppInterface, paramInt, paramString, -1, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    a(paramActivity, paramAppInterface, paramInt1, paramString, paramInt2, -1, -1, null);
  }
  
  public static void a(Activity paramActivity, AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2, int paramInt3, int paramInt4, Bundle paramBundle)
  {
    String str2 = "signature_1";
    Intent localIntent = new Intent(paramActivity, QQBrowserActivity.class);
    localIntent.putExtra("fragmentStyle", 3);
    Object localObject1 = "";
    Object localObject2;
    String str1;
    if (paramInt1 == 0)
    {
      localObject2 = localObject1;
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("signUrl");
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject2;
        str1 = str2;
        if (((String)localObject2).contains(".qq.com")) {}
      }
      else
      {
        localObject1 = aqqj.getUrl("signatureEntrance");
        str1 = str2;
      }
      localObject2 = new StringBuilder((String)localObject1);
      if (!((String)localObject1).contains("?")) {
        break label344;
      }
      ((StringBuilder)localObject2).append("&signatureEdit=1");
      label125:
      if (paramInt3 > -1)
      {
        ((StringBuilder)localObject2).append("&templateId=");
        ((StringBuilder)localObject2).append(paramInt3);
      }
      if (paramInt4 > -1)
      {
        ((StringBuilder)localObject2).append("&fontId=");
        ((StringBuilder)localObject2).append(paramInt4);
      }
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "openSignatureEdit: url= " + ((StringBuilder)localObject2).toString());
      }
      localIntent.putExtra("url", ((StringBuilder)localObject2).toString());
      localIntent.putExtra("isTransparentTitle", true);
      localIntent.putExtra("via", paramString);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      if (paramBundle != null) {
        localIntent.putExtra("sign_extra", paramBundle);
      }
      if (paramInt2 != -1) {
        break label356;
      }
      paramActivity.startActivity(localIntent);
    }
    for (;;)
    {
      if (paramAppInterface != null) {
        VasWebviewUtil.reportCommercialDrainage(paramAppInterface.getCurrentAccountUin(), "signature", str1, paramString, 1, 0, 0, "", "", "");
      }
      return;
      str1 = str2;
      if (paramInt1 != 1) {
        break;
      }
      localObject1 = aqqj.getUrl("signatureDIYEntrance");
      localIntent.putExtra("open_diy", true);
      str1 = "signature_5";
      break;
      label344:
      ((StringBuilder)localObject2).append("?signatureEdit=1");
      break label125;
      label356:
      paramActivity.startActivityForResult(localIntent, paramInt2);
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, XListView paramXListView)
  {
    if (paramQQAppInterface != null) {}
    for (BubbleManager localBubbleManager = (BubbleManager)paramQQAppInterface.getManager(44);; localBubbleManager = null)
    {
      if ((paramXListView != null) && (localBubbleManager != null))
      {
        int i = paramXListView.getChildCount() - 1;
        while (i >= 0)
        {
          Object localObject = paramXListView.getChildAt(i);
          if ((localObject instanceof BaseChatItemLayout))
          {
            BaseBubbleBuilder.e locale = (BaseBubbleBuilder.e)wja.a((View)localObject);
            localObject = wja.a((View)localObject);
            if ((localObject != null) && (((ChatMessage)localObject).needVipBubble()) && (locale != null) && (locale.b != null) && (locale.b.bubbleId == adyd.c.bubbleId) && (localBubbleManager.bV(acle.Q(((ChatMessage)localObject).vipBubbleID)))) {
              return true;
            }
            if ((localObject != null) && (((ku)paramQQAppInterface.getManager(42)).a(locale, (ChatMessage)localObject))) {
              return true;
            }
          }
          else if ((localObject != null) && ((wja.a((View)localObject) instanceof xmj.a)))
          {
            return true;
          }
          i -= 1;
        }
      }
      return false;
    }
  }
  
  /* Error */
  public static byte[] a(byte[] paramArrayOfByte, tencent.im.msg.im_msg_body.GeneralFlags paramGeneralFlags, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aload_1
    //   4: ifnull +295 -> 299
    //   7: aload_1
    //   8: getfield 487	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   11: invokevirtual 492	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   14: ifeq +285 -> 299
    //   17: new 494	tencent/im/msg/hummer/resv/generalflags$ResvAttr
    //   20: dup
    //   21: invokespecial 495	tencent/im/msg/hummer/resv/generalflags$ResvAttr:<init>	()V
    //   24: astore 4
    //   26: aload 4
    //   28: aload_1
    //   29: getfield 487	tencent/im/msg/im_msg_body$GeneralFlags:bytes_pb_reserve	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   32: invokevirtual 499	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   35: invokevirtual 505	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   38: invokevirtual 509	tencent/im/msg/hummer/resv/generalflags$ResvAttr:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload 4
    //   44: getfield 512	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   47: invokevirtual 492	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   50: ifeq +244 -> 294
    //   53: new 243	org/json/JSONObject
    //   56: dup
    //   57: new 243	org/json/JSONObject
    //   60: dup
    //   61: aload 4
    //   63: getfield 512	tencent/im/msg/hummer/resv/generalflags$ResvAttr:bytes_oac_msg_extend	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   66: invokevirtual 499	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   69: invokevirtual 515	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   72: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   75: ldc 252
    //   77: ldc 155
    //   79: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   82: invokespecial 250	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   85: astore_1
    //   86: aload_1
    //   87: ldc_w 517
    //   90: aload_1
    //   91: ldc 254
    //   93: aconst_null
    //   94: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   97: invokevirtual 249	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   100: astore_1
    //   101: aload_1
    //   102: invokestatic 30	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   105: istore_3
    //   106: iload_3
    //   107: ifeq +5 -> 112
    //   110: aconst_null
    //   111: astore_1
    //   112: aload 5
    //   114: astore 4
    //   116: aload_1
    //   117: ifnull +139 -> 256
    //   120: aload 5
    //   122: astore 4
    //   124: aload_0
    //   125: arraylength
    //   126: ifle +130 -> 256
    //   129: invokestatic 523	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   132: invokevirtual 527	com/tencent/common/app/BaseApplicationImpl:getRuntime	()Lmqq/app/AppRuntime;
    //   135: astore 4
    //   137: aload 4
    //   139: instanceof 148
    //   142: ifeq +149 -> 291
    //   145: aload_1
    //   146: ldc_w 262
    //   149: aload 4
    //   151: checkcast 148	com/tencent/mobileqq/app/QQAppInterface
    //   154: invokestatic 260	aqnl:J	(Lcom/tencent/mobileqq/app/QQAppInterface;)Ljava/lang/String;
    //   157: invokevirtual 276	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   160: astore_1
    //   161: new 264	java/lang/String
    //   164: dup
    //   165: aload_0
    //   166: iload_2
    //   167: invokestatic 532	ansi:d	([BI)[B
    //   170: ldc_w 534
    //   173: invokespecial 537	java/lang/String:<init>	([BLjava/lang/String;)V
    //   176: astore_0
    //   177: aload 5
    //   179: astore 4
    //   181: aload_0
    //   182: ldc_w 539
    //   185: invokevirtual 333	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +68 -> 256
    //   191: getstatic 17	aqnl:TAG	Ljava/lang/String;
    //   194: iconst_1
    //   195: new 32	java/lang/StringBuilder
    //   198: dup
    //   199: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   202: ldc_w 541
    //   205: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 544	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   218: aload_0
    //   219: ldc_w 546
    //   222: new 32	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 539
    //   232: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_1
    //   236: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: ldc_w 548
    //   242: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokevirtual 551	java/lang/String:replaceFirst	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   251: invokevirtual 554	java/lang/String:getBytes	()[B
    //   254: astore 4
    //   256: aload 4
    //   258: areturn
    //   259: astore 4
    //   261: aconst_null
    //   262: astore_1
    //   263: getstatic 17	aqnl:TAG	Ljava/lang/String;
    //   266: iconst_1
    //   267: aload 4
    //   269: iconst_0
    //   270: anewarray 4	java/lang/Object
    //   273: invokestatic 557	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   276: goto -164 -> 112
    //   279: astore_0
    //   280: aload_0
    //   281: invokevirtual 558	java/io/UnsupportedEncodingException:printStackTrace	()V
    //   284: aconst_null
    //   285: areturn
    //   286: astore 4
    //   288: goto -25 -> 263
    //   291: goto -130 -> 161
    //   294: aconst_null
    //   295: astore_1
    //   296: goto -184 -> 112
    //   299: aconst_null
    //   300: astore_1
    //   301: goto -189 -> 112
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	304	0	paramArrayOfByte	byte[]
    //   0	304	1	paramGeneralFlags	tencent.im.msg.im_msg_body.GeneralFlags
    //   0	304	2	paramInt	int
    //   105	2	3	bool	boolean
    //   24	233	4	localObject1	Object
    //   259	9	4	localException1	Exception
    //   286	1	4	localException2	Exception
    //   1	177	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   26	101	259	java/lang/Exception
    //   161	177	279	java/io/UnsupportedEncodingException
    //   181	256	279	java/io/UnsupportedEncodingException
    //   101	106	286	java/lang/Exception
  }
  
  /* Error */
  public static int af(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_2
    //   2: ldc 2
    //   4: monitorenter
    //   5: new 55	java/io/File
    //   8: dup
    //   9: new 32	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   16: aload_0
    //   17: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   20: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   23: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: aload_1
    //   27: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokespecial 58	java/io/File:<init>	(Ljava/lang/String;)V
    //   36: astore 4
    //   38: aload 4
    //   40: invokevirtual 62	java/io/File:exists	()Z
    //   43: istore_3
    //   44: iload_3
    //   45: ifne +8 -> 53
    //   48: ldc 2
    //   50: monitorexit
    //   51: iload_2
    //   52: ireturn
    //   53: new 32	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   60: aload_0
    //   61: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: getstatic 67	java/io/File:separator	Ljava/lang/String;
    //   67: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: aload_1
    //   71: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   74: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   77: invokestatic 565	java/lang/System:load	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: goto -34 -> 48
    //   85: astore_0
    //   86: ldc_w 567
    //   89: iconst_1
    //   90: new 32	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 35	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 569
    //   100: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: invokevirtual 572	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   107: invokevirtual 41	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: invokestatic 53	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   116: aload 4
    //   118: invokevirtual 96	java/io/File:delete	()Z
    //   121: pop
    //   122: iconst_2
    //   123: istore_2
    //   124: goto -76 -> 48
    //   127: astore_0
    //   128: ldc 2
    //   130: monitorexit
    //   131: aload_0
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	paramString1	String
    //   0	133	1	paramString2	String
    //   1	123	2	i	int
    //   43	2	3	bool	boolean
    //   36	81	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   53	80	85	java/lang/Throwable
    //   5	44	127	finally
    //   53	80	127	finally
    //   86	122	127	finally
  }
  
  public static void cT(Context paramContext, String paramString)
  {
    if (paramContext == null) {
      return;
    }
    ((BaseActivity)paramContext).runOnUiThread(new VasUtils.1(paramContext, paramString));
  }
  
  public static void eC(QQAppInterface paramQQAppInterface)
  {
    int i3 = 1;
    anec localanec = (anec)paramQQAppInterface.getManager(12);
    int i;
    int j;
    label51:
    int k;
    label65:
    int m;
    label80:
    int n;
    label95:
    int i1;
    label110:
    int i2;
    label125:
    boolean bool;
    if (localanec != null)
    {
      if (localanec.ee("100005.100001") == -1) {
        break label263;
      }
      i = 1;
      if (i != 0)
      {
        if (localanec.ee("100005.100003") == -1) {
          break label268;
        }
        j = 1;
        if (localanec.ee("100005.100002") == -1) {
          break label273;
        }
        k = 1;
        if (localanec.ee("100005.100006") == -1) {
          break label278;
        }
        m = 1;
        if (localanec.ee("100005.100018") == -1) {
          break label284;
        }
        n = 1;
        if (localanec.ee("100005.100020") == -1) {
          break label290;
        }
        i1 = 1;
        if (localanec.ee("100005.100021") == -1) {
          break label296;
        }
        i2 = 1;
        bool = ((ku)paramQQAppInterface.getManager(42)).cy;
        if (!bool) {
          break label312;
        }
        if (localanec.ee("100005.100011") == -1) {
          break label302;
        }
        i = 1;
      }
    }
    for (;;)
    {
      label158:
      if (((bool) && (j == 0) && (k == 0) && (m == 0) && (i == 0) && (n == 0) && (i1 == 0) && (i2 == 0)) || ((!bool) && (j == 0) && (k == 0) && (m == 0) && (n == 0) && (i1 == 0) && (i2 == 0))) {
        if (localanec.ee("100005") == -1) {
          break label307;
        }
      }
      label263:
      label268:
      label273:
      label278:
      label284:
      label290:
      label296:
      label302:
      label307:
      for (i = i3;; i = 0)
      {
        if (i != 0) {
          ((altq)paramQQAppInterface.getManager(36)).OS("100005");
        }
        return;
        i = 0;
        break;
        j = 0;
        break label51;
        k = 0;
        break label65;
        m = 0;
        break label80;
        n = 0;
        break label95;
        i1 = 0;
        break label110;
        i2 = 0;
        break label125;
        i = 0;
        break label158;
      }
      label312:
      i = 0;
    }
  }
  
  public static SpannableString f(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      String[] arrayOfString = paramString.split(" ");
      paramString = new SpannableString(paramString);
      int i = 0;
      while (i < arrayOfString.length)
      {
        String str = arrayOfString[i];
        if (isNumeric(str))
        {
          int k = i - 1;
          int j = 0;
          while (k >= 0)
          {
            j = j + arrayOfString[k].length() + 1;
            k -= 1;
          }
          k = str.length();
          paramString.setSpan(new ForegroundColorSpan(-15550475), j, k + j, 33);
        }
        i += 1;
      }
      return paramString;
    }
    return new SpannableString("");
  }
  
  public static String getSoDir()
  {
    return BaseApplicationImpl.getApplication().getFilesDir().getAbsolutePath() + File.separator + "vas_so" + File.separator;
  }
  
  public static int getStatusBarHeight(Context paramContext)
  {
    int i = 0;
    int j = paramContext.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (j > 0) {
      i = paramContext.getResources().getDimensionPixelSize(j);
    }
    return i;
  }
  
  private static boolean isNumeric(String paramString)
  {
    return Pattern.compile("^[-\\+]?[\\d]*$").matcher(paramString).matches();
  }
  
  public static void onAIODestroy()
  {
    ahxo.a().clearCache();
    ETTextView.clearCache();
    if ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))
    {
      Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      ahxs localahxs = (ahxs)((QQAppInterface)localObject).getManager(219);
      if (localahxs != null) {
        localahxs.onAIODestroy();
      }
      localObject = (ku)((QQAppInterface)localObject).getManager(42);
      if (localObject != null) {
        ((ku)localObject).onAIODestroy();
      }
    }
  }
  
  public static boolean qR()
  {
    long l = aqgz.getSystemTotalMemory();
    if (l < 1073741824L)
    {
      QLog.d(TAG, 1, "isLowDevice: totalMemory below 1G: " + l / 1024L / 1024L + "M");
      return true;
    }
    Runtime localRuntime = Runtime.getRuntime();
    float f1 = (float)localRuntime.maxMemory();
    float f2 = (float)(localRuntime.totalMemory() - localRuntime.freeMemory());
    float f3 = f2 / f1 * 100.0F;
    if (f3 > 85.0F)
    {
      QLog.e(TAG, 1, "isLowDevice: used: " + f2 + " max: " + f1 + " percent: " + f3);
      return true;
    }
    return false;
  }
  
  public static int r(QQAppInterface paramQQAppInterface, String paramString)
  {
    paramQQAppInterface = ((acff)paramQQAppInterface.getManager(51)).e(paramString);
    if (paramQQAppInterface != null)
    {
      boolean bool = paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_QQVIP);
      if (paramQQAppInterface.isServiceEnabled(EVIPSPEC.E_SP_SUPERVIP))
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_SUPERVIP) == 1) {
          return 22;
        }
        return 5;
      }
      if (bool)
      {
        if (paramQQAppInterface.getServiceType(EVIPSPEC.E_SP_QQVIP) == 1) {
          return 21;
        }
        return 4;
      }
    }
    return 1;
  }
  
  public static abstract class a
  {
    public int eac;
    
    public a(int paramInt)
    {
      this.eac = paramInt;
    }
    
    public abstract void onClick();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqnl
 * JD-Core Version:    0.7.0.1
 */