import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class yoe
  extends WebViewPlugin
  implements DialogInterface.OnDismissListener, AdapterView.OnItemClickListener
{
  private ShareActionSheetBuilder a;
  private String aZf;
  private String aZg;
  private String aZh;
  
  public yoe()
  {
    this.mPluginNameSpace = "newLogin";
  }
  
  private List<ShareActionSheetBuilder.ActionSheetItem>[] a()
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 9;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 10;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = acfp.m(2131707477);
    localActionSheetItem.icon = 2130839246;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = BaseApplicationImpl.getApplication().getString(2131698622);
    localActionSheetItem.icon = 2130839246;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return (List[])new ArrayList[] { localArrayList };
  }
  
  private void yU(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    Intent localIntent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:"));
    localIntent.putExtra("sms_body", paramString);
    this.mRuntime.getActivity().startActivity(localIntent);
  }
  
  @QQPermissionDenied(1)
  @TargetApi(23)
  public void denied()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user denied = sms");
    QQToast.a(this.mRuntime.getActivity(), acfp.m(2131707475), 1).show();
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    QLog.d("InvitationFriend", 1, "CheckPermission user grant = sms");
    if (!TextUtils.isEmpty(this.aZh)) {
      yU(this.aZh);
    }
  }
  
  /* Error */
  public boolean handleJsRequest(com.tencent.mobileqq.webview.swift.JsBridgeListener paramJsBridgeListener, String paramString1, String paramString2, String paramString3, String... paramVarArgs)
  {
    // Byte code:
    //   0: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +57 -> 60
    //   6: ldc 133
    //   8: iconst_2
    //   9: new 173	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   16: ldc 176
    //   18: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: aload_2
    //   22: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: ldc 182
    //   27: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: aload 4
    //   32: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: ldc 184
    //   37: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: aload_3
    //   41: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: ldc 186
    //   46: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: aload 5
    //   51: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   54: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 196	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: ldc 20
    //   62: aload_3
    //   63: invokevirtual 201	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   66: ifne +5 -> 71
    //   69: iconst_0
    //   70: ireturn
    //   71: ldc 203
    //   73: aload 4
    //   75: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   78: ifeq +121 -> 199
    //   81: aload 5
    //   83: ifnull +10 -> 93
    //   86: aload 5
    //   88: arraylength
    //   89: iconst_1
    //   90: if_icmpeq +5 -> 95
    //   93: iconst_0
    //   94: ireturn
    //   95: aload 5
    //   97: iconst_0
    //   98: aaload
    //   99: astore_1
    //   100: new 209	org/json/JSONObject
    //   103: dup
    //   104: aload_1
    //   105: invokespecial 211	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   108: astore_1
    //   109: aload_1
    //   110: ldc 213
    //   112: invokevirtual 216	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   115: astore_2
    //   116: aload_0
    //   117: aload_1
    //   118: ldc 218
    //   120: invokevirtual 216	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   123: putfield 220	yoe:aZg	Ljava/lang/String;
    //   126: getstatic 225	android/os/Build$VERSION:SDK_INT	I
    //   129: bipush 23
    //   131: if_icmplt +60 -> 191
    //   134: aload_0
    //   135: getfield 113	yoe:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   138: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   141: ldc 227
    //   143: invokevirtual 231	android/app/Activity:checkSelfPermission	(Ljava/lang/String;)I
    //   146: ifeq +37 -> 183
    //   149: aload_0
    //   150: aload_2
    //   151: putfield 159	yoe:aZh	Ljava/lang/String;
    //   154: aload_0
    //   155: getfield 113	yoe:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   158: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   161: checkcast 233	mqq/app/AppActivity
    //   164: aload_0
    //   165: iconst_1
    //   166: iconst_1
    //   167: anewarray 198	java/lang/String
    //   170: dup
    //   171: iconst_0
    //   172: ldc 227
    //   174: aastore
    //   175: invokevirtual 237	mqq/app/AppActivity:requestPermissions	(Ljava/lang/Object;I[Ljava/lang/String;)V
    //   178: iconst_1
    //   179: ireturn
    //   180: astore_1
    //   181: iconst_0
    //   182: ireturn
    //   183: aload_0
    //   184: aload_2
    //   185: invokespecial 161	yoe:yU	(Ljava/lang/String;)V
    //   188: goto -10 -> 178
    //   191: aload_0
    //   192: aload_2
    //   193: invokespecial 161	yoe:yU	(Ljava/lang/String;)V
    //   196: goto -18 -> 178
    //   199: ldc 239
    //   201: aload 4
    //   203: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   206: ifeq +189 -> 395
    //   209: aload 5
    //   211: ifnull +10 -> 221
    //   214: aload 5
    //   216: arraylength
    //   217: iconst_1
    //   218: if_icmpeq +5 -> 223
    //   221: iconst_0
    //   222: ireturn
    //   223: aload 5
    //   225: iconst_0
    //   226: aaload
    //   227: astore_1
    //   228: aload_0
    //   229: new 209	org/json/JSONObject
    //   232: dup
    //   233: aload_1
    //   234: invokespecial 211	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   237: ldc 218
    //   239: invokevirtual 216	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   242: putfield 241	yoe:aZf	Ljava/lang/String;
    //   245: aload_0
    //   246: getfield 113	yoe:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   249: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   252: astore_1
    //   253: aload_0
    //   254: getfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   257: ifnonnull +15 -> 272
    //   260: aload_0
    //   261: new 245	com/tencent/mobileqq/utils/ShareActionSheetBuilder
    //   264: dup
    //   265: aload_1
    //   266: invokespecial 248	com/tencent/mobileqq/utils/ShareActionSheetBuilder:<init>	(Landroid/content/Context;)V
    //   269: putfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   272: aload_0
    //   273: getfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   276: ldc 249
    //   278: invokestatic 70	acfp:m	(I)Ljava/lang/String;
    //   281: invokevirtual 253	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetTitle	(Ljava/lang/CharSequence;)V
    //   284: aload_0
    //   285: getfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   288: aload_0
    //   289: invokespecial 255	yoe:a	()[Ljava/util/List;
    //   292: invokevirtual 259	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setActionSheetItems	([Ljava/util/List;)V
    //   295: aload_0
    //   296: getfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   299: aload_0
    //   300: invokevirtual 263	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setItemClickListener	(Landroid/widget/AdapterView$OnItemClickListener;)V
    //   303: aload_0
    //   304: getfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   307: aload_0
    //   308: invokevirtual 267	com/tencent/mobileqq/utils/ShareActionSheetBuilder:setOnDismissListener	(Landroid/content/DialogInterface$OnDismissListener;)V
    //   311: aload_1
    //   312: invokevirtual 270	android/app/Activity:isFinishing	()Z
    //   315: ifne +78 -> 393
    //   318: aload_0
    //   319: getfield 243	yoe:a	Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder;
    //   322: invokevirtual 272	com/tencent/mobileqq/utils/ShareActionSheetBuilder:show	()V
    //   325: aconst_null
    //   326: ldc_w 274
    //   329: ldc 55
    //   331: ldc 55
    //   333: ldc_w 276
    //   336: ldc_w 276
    //   339: iconst_0
    //   340: iconst_0
    //   341: ldc 55
    //   343: ldc 55
    //   345: ldc 55
    //   347: ldc 55
    //   349: invokestatic 281	anot:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   352: iconst_1
    //   353: ireturn
    //   354: astore_1
    //   355: iconst_0
    //   356: ireturn
    //   357: astore_1
    //   358: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   361: ifeq -9 -> 352
    //   364: ldc 133
    //   366: iconst_2
    //   367: new 173	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   374: ldc_w 283
    //   377: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: invokevirtual 189	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   384: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: goto -38 -> 352
    //   393: iconst_0
    //   394: ireturn
    //   395: ldc_w 285
    //   398: aload 4
    //   400: invokevirtual 207	java/lang/String:equalsIgnoreCase	(Ljava/lang/String;)Z
    //   403: ifeq -225 -> 178
    //   406: invokestatic 171	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   409: ifeq +12 -> 421
    //   412: ldc 133
    //   414: iconst_2
    //   415: ldc_w 287
    //   418: invokestatic 141	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload_0
    //   422: getfield 113	yoe:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   425: ifnull +87 -> 512
    //   428: aload_0
    //   429: getfield 113	yoe:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   432: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   435: ifnull +77 -> 512
    //   438: new 90	android/content/Intent
    //   441: dup
    //   442: invokespecial 288	android/content/Intent:<init>	()V
    //   445: astore_1
    //   446: aload_1
    //   447: ldc_w 290
    //   450: invokevirtual 294	android/content/Intent:setAction	(Ljava/lang/String;)Landroid/content/Intent;
    //   453: pop
    //   454: aload_1
    //   455: invokestatic 300	mqq/app/MobileQQ:getContext	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   458: invokevirtual 305	com/tencent/qphone/base/util/BaseApplication:getPackageName	()Ljava/lang/String;
    //   461: invokevirtual 308	android/content/Intent:setPackage	(Ljava/lang/String;)Landroid/content/Intent;
    //   464: pop
    //   465: aload_0
    //   466: getfield 113	yoe:mRuntime	Lcom/tencent/mobileqq/webview/swift/WebViewPlugin$a;
    //   469: invokevirtual 119	com/tencent/mobileqq/webview/swift/WebViewPlugin$a:getActivity	()Landroid/app/Activity;
    //   472: aload_1
    //   473: invokevirtual 311	android/app/Activity:sendBroadcast	(Landroid/content/Intent;)V
    //   476: goto -298 -> 178
    //   479: astore_1
    //   480: ldc 133
    //   482: iconst_1
    //   483: new 173	java/lang/StringBuilder
    //   486: dup
    //   487: invokespecial 174	java/lang/StringBuilder:<init>	()V
    //   490: ldc_w 313
    //   493: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   496: aload_1
    //   497: invokevirtual 316	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   500: invokevirtual 180	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   506: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   509: goto -331 -> 178
    //   512: ldc 133
    //   514: iconst_1
    //   515: ldc_w 321
    //   518: invokestatic 319	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   521: goto -343 -> 178
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	524	0	this	yoe
    //   0	524	1	paramJsBridgeListener	com.tencent.mobileqq.webview.swift.JsBridgeListener
    //   0	524	2	paramString1	String
    //   0	524	3	paramString2	String
    //   0	524	4	paramString3	String
    //   0	524	5	paramVarArgs	String[]
    // Exception table:
    //   from	to	target	type
    //   100	126	180	org/json/JSONException
    //   228	245	354	org/json/JSONException
    //   318	352	357	java/lang/Exception
    //   406	421	479	java/lang/Exception
    //   421	476	479	java/lang/Exception
    //   512	521	479	java/lang/Exception
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    callJs(this.aZf, new String[] { String.valueOf(paramInt) });
    String str = "";
    if (paramInt == 0) {
      str = "0X80096FA";
    }
    for (;;)
    {
      if (!"".equals(str)) {
        anot.a(null, "dc00898", "", "", str, str, 0, 0, "", "", "", "");
      }
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      if (paramInt == 1) {
        str = "0X80096FB";
      } else if (paramInt == 2) {
        str = "0X80096FC";
      } else if (paramInt == 3) {
        str = "0X80096FD";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yoe
 * JD-Core Version:    0.7.0.1
 */