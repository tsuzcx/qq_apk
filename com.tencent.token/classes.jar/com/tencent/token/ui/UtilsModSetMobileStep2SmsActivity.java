package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.token.ahg;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.sa;
import com.tencent.token.sz;
import com.tencent.token.xa;

public class UtilsModSetMobileStep2SmsActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  private boolean isCurrentMobile = true;
  private String mA2 = "";
  private int mBindRetryTimes = 0;
  private String mCountryCode;
  @SuppressLint({"HandlerLeak"})
  private Handler mHandler = new Handler()
  {
    /* Error */
    public final void handleMessage(Message paramAnonymousMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   4: invokevirtual 24	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:isFinishing	()Z
      //   7: ifeq +4 -> 11
      //   10: return
      //   11: aload_1
      //   12: getfield 30	android/os/Message:what	I
      //   15: istore_2
      //   16: aconst_null
      //   17: astore 5
      //   19: iload_2
      //   20: lookupswitch	default:+76->96, 3:+1005->1025, 4:+980->1000, 15:+946->966, 3012:+510->530, 3019:+129->149, 4097:+85->105, 4098:+85->105, 4104:+77->97
      //   97: aload_0
      //   98: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   101: invokestatic 33	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   104: return
      //   105: aload_1
      //   106: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   109: checkcast 39	[B
      //   112: astore_3
      //   113: aload_1
      //   114: getfield 42	android/os/Message:arg1	I
      //   117: ifne +24 -> 141
      //   120: aload_3
      //   121: ifnull +20 -> 141
      //   124: aload_3
      //   125: arraylength
      //   126: ifle +15 -> 141
      //   129: aload_0
      //   130: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   133: aload_3
      //   134: invokestatic 47	com/tencent/token/aac:a	([B)Ljava/lang/String;
      //   137: invokestatic 51	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   140: pop
      //   141: aload_0
      //   142: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   145: invokestatic 33	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   148: return
      //   149: aload_1
      //   150: getfield 42	android/os/Message:arg1	I
      //   153: ifne +324 -> 477
      //   156: aload_0
      //   157: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   160: getstatic 57	com/tencent/token/vm:d	Ljava/lang/String;
      //   163: invokestatic 60	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$602	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   166: pop
      //   167: aload_0
      //   168: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   171: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   174: ifnull +279 -> 453
      //   177: aload_0
      //   178: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   181: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   184: invokevirtual 70	java/lang/String:length	()I
      //   187: ifgt +6 -> 193
      //   190: goto +263 -> 453
      //   193: getstatic 73	com/tencent/token/vm:e	Ljava/lang/String;
      //   196: ifnull +233 -> 429
      //   199: getstatic 73	com/tencent/token/vm:e	Ljava/lang/String;
      //   202: invokevirtual 70	java/lang/String:length	()I
      //   205: ifgt +6 -> 211
      //   208: goto +221 -> 429
      //   211: new 75	java/lang/StringBuilder
      //   214: dup
      //   215: ldc 77
      //   217: invokespecial 80	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   220: astore_1
      //   221: aload_1
      //   222: aload_0
      //   223: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   226: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   229: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   232: pop
      //   233: aload_1
      //   234: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   237: invokestatic 93	com/tencent/token/xa:c	(Ljava/lang/String;)V
      //   240: aload_0
      //   241: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   244: invokestatic 97	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$700	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Z
      //   247: ifeq +27 -> 274
      //   250: aload_0
      //   251: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   254: astore_1
      //   255: aload_1
      //   256: aload_1
      //   257: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   260: getstatic 73	com/tencent/token/vm:e	Ljava/lang/String;
      //   263: invokevirtual 101	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:sendUpSmsBySMSAPP	(Ljava/lang/String;Ljava/lang/String;)V
      //   266: aload_0
      //   267: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   270: invokevirtual 104	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showProgressDialog	()V
      //   273: return
      //   274: aload_0
      //   275: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   278: invokevirtual 107	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   281: new 109	android/content/Intent
      //   284: dup
      //   285: aload_0
      //   286: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   289: ldc 111
      //   291: invokespecial 114	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   294: astore_1
      //   295: aload_1
      //   296: ldc 116
      //   298: aload_0
      //   299: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   302: invokestatic 119	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   305: invokevirtual 123	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   308: pop
      //   309: aload_1
      //   310: ldc 125
      //   312: aload_0
      //   313: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   316: invokestatic 128	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$800	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   319: invokevirtual 123	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   322: pop
      //   323: aload_1
      //   324: ldc 130
      //   326: aload_0
      //   327: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   330: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   333: invokevirtual 123	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   336: pop
      //   337: aload_1
      //   338: ldc 132
      //   340: aload_0
      //   341: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   344: invokestatic 135	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$200	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   347: invokevirtual 123	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   350: pop
      //   351: aload_1
      //   352: ldc 137
      //   354: aload_0
      //   355: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   358: invokestatic 141	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   361: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   364: pop
      //   365: aload_1
      //   366: ldc 146
      //   368: aload_0
      //   369: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   372: invokestatic 149	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$900	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   375: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   378: pop
      //   379: aload_0
      //   380: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   383: invokestatic 141	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   386: iconst_1
      //   387: if_icmpne +14 -> 401
      //   390: aload_1
      //   391: ldc 151
      //   393: iconst_4
      //   394: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   397: pop
      //   398: goto +22 -> 420
      //   401: aload_0
      //   402: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   405: invokestatic 141	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   408: iconst_3
      //   409: if_icmpne +11 -> 420
      //   412: aload_1
      //   413: ldc 151
      //   415: iconst_3
      //   416: invokevirtual 144	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   419: pop
      //   420: aload_0
      //   421: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   424: aload_1
      //   425: invokevirtual 155	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:startActivity	(Landroid/content/Intent;)V
      //   428: return
      //   429: aload_0
      //   430: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   433: astore_1
      //   434: aload_1
      //   435: ldc 156
      //   437: aload_1
      //   438: invokevirtual 160	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   441: ldc 161
      //   443: invokevirtual 167	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   446: ldc 168
      //   448: aconst_null
      //   449: invokevirtual 172	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   452: return
      //   453: aload_0
      //   454: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   457: astore_1
      //   458: aload_1
      //   459: ldc 156
      //   461: aload_1
      //   462: invokevirtual 160	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   465: ldc 173
      //   467: invokevirtual 167	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   470: ldc 168
      //   472: aconst_null
      //   473: invokevirtual 172	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   476: return
      //   477: aload_1
      //   478: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   481: checkcast 175	com/tencent/token/wy
      //   484: astore_1
      //   485: aload_1
      //   486: getfield 177	com/tencent/token/wy:c	Ljava/lang/String;
      //   489: ifnull +13 -> 502
      //   492: aload_1
      //   493: getfield 177	com/tencent/token/wy:c	Ljava/lang/String;
      //   496: invokevirtual 70	java/lang/String:length	()I
      //   499: ifne +14 -> 513
      //   502: aload_0
      //   503: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   506: invokevirtual 160	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   509: aload_1
      //   510: invokestatic 180	com/tencent/token/wy:a	(Landroid/content/res/Resources;Lcom/tencent/token/wy;)V
      //   513: aload_0
      //   514: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   517: ldc 156
      //   519: aload_1
      //   520: getfield 177	com/tencent/token/wy:c	Ljava/lang/String;
      //   523: ldc 168
      //   525: aconst_null
      //   526: invokevirtual 172	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   529: return
      //   530: aload_1
      //   531: getfield 42	android/os/Message:arg1	I
      //   534: ifne +335 -> 869
      //   537: aload_0
      //   538: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   541: invokevirtual 107	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   544: aload_0
      //   545: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   548: ldc 181
      //   550: invokevirtual 185	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:setContentView	(I)V
      //   553: aload_0
      //   554: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   557: getfield 189	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:mBackArrow	Landroid/view/View;
      //   560: iconst_4
      //   561: invokevirtual 194	android/view/View:setVisibility	(I)V
      //   564: aload_0
      //   565: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   568: iconst_1
      //   569: invokestatic 198	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Z)Z
      //   572: pop
      //   573: aload_0
      //   574: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   577: astore_3
      //   578: aload_3
      //   579: aload_3
      //   580: invokestatic 128	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$800	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   583: invokevirtual 202	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:setTitle	(Ljava/lang/CharSequence;)V
      //   586: aload_1
      //   587: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   590: checkcast 204	org/json/JSONObject
      //   593: astore 4
      //   595: aload 4
      //   597: ldc 206
      //   599: invokevirtual 209	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   602: astore_3
      //   603: aload 4
      //   605: ldc 211
      //   607: invokevirtual 209	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   610: astore_1
      //   611: aload 4
      //   613: ldc 213
      //   615: invokevirtual 209	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   618: astore 4
      //   620: goto +30 -> 650
      //   623: astore 4
      //   625: goto +16 -> 641
      //   628: astore 4
      //   630: aconst_null
      //   631: astore_1
      //   632: goto +9 -> 641
      //   635: astore 4
      //   637: aconst_null
      //   638: astore_3
      //   639: aload_3
      //   640: astore_1
      //   641: aload 4
      //   643: invokevirtual 216	org/json/JSONException:printStackTrace	()V
      //   646: aload 5
      //   648: astore 4
      //   650: aload_3
      //   651: ifnull +36 -> 687
      //   654: aload_3
      //   655: invokevirtual 70	java/lang/String:length	()I
      //   658: ifle +29 -> 687
      //   661: aload_0
      //   662: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   665: ldc 217
      //   667: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   670: checkcast 223	android/widget/TextView
      //   673: astore 5
      //   675: aload 5
      //   677: aload_3
      //   678: invokevirtual 226	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   681: aload 5
      //   683: iconst_0
      //   684: invokevirtual 227	android/widget/TextView:setVisibility	(I)V
      //   687: aload_0
      //   688: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   691: ldc 228
      //   693: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   696: aload_0
      //   697: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   700: invokevirtual 232	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   703: aload_0
      //   704: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   707: ldc 233
      //   709: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   712: astore_3
      //   713: aload_0
      //   714: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   717: invokestatic 141	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   720: iconst_1
      //   721: if_icmpne +43 -> 764
      //   724: aload_0
      //   725: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   728: ldc 234
      //   730: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   733: checkcast 223	android/widget/TextView
      //   736: ldc 235
      //   738: invokevirtual 237	android/widget/TextView:setText	(I)V
      //   741: aload_3
      //   742: bipush 8
      //   744: invokevirtual 194	android/view/View:setVisibility	(I)V
      //   747: aload_0
      //   748: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   751: ldc 217
      //   753: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   756: bipush 8
      //   758: invokevirtual 194	android/view/View:setVisibility	(I)V
      //   761: goto +97 -> 858
      //   764: aload_0
      //   765: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   768: ldc 234
      //   770: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   773: checkcast 223	android/widget/TextView
      //   776: ldc 238
      //   778: invokevirtual 237	android/widget/TextView:setText	(I)V
      //   781: aload_1
      //   782: ifnull +70 -> 852
      //   785: aload 4
      //   787: ifnull +65 -> 852
      //   790: aload_1
      //   791: invokevirtual 70	java/lang/String:length	()I
      //   794: ifle +58 -> 852
      //   797: aload 4
      //   799: invokevirtual 70	java/lang/String:length	()I
      //   802: ifle +50 -> 852
      //   805: aload_3
      //   806: iconst_0
      //   807: invokevirtual 194	android/view/View:setVisibility	(I)V
      //   810: aload_0
      //   811: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   814: ldc 239
      //   816: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   819: checkcast 223	android/widget/TextView
      //   822: astore_3
      //   823: aload_0
      //   824: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   827: ldc 240
      //   829: invokevirtual 221	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   832: checkcast 223	android/widget/TextView
      //   835: astore 5
      //   837: aload_3
      //   838: aload_1
      //   839: invokevirtual 226	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   842: aload 5
      //   844: aload 4
      //   846: invokevirtual 226	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   849: goto +9 -> 858
      //   852: aload_3
      //   853: bipush 8
      //   855: invokevirtual 194	android/view/View:setVisibility	(I)V
      //   858: invokestatic 245	com/tencent/token/aal:a	()Lcom/tencent/token/aal;
      //   861: invokevirtual 248	com/tencent/token/aal:b	()V
      //   864: iconst_1
      //   865: putstatic 254	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   868: return
      //   869: aload_1
      //   870: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   873: checkcast 175	com/tencent/token/wy
      //   876: astore_1
      //   877: aload_1
      //   878: getfield 177	com/tencent/token/wy:c	Ljava/lang/String;
      //   881: ifnull +13 -> 894
      //   884: aload_1
      //   885: getfield 177	com/tencent/token/wy:c	Ljava/lang/String;
      //   888: invokevirtual 70	java/lang/String:length	()I
      //   891: ifne +14 -> 905
      //   894: aload_0
      //   895: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   898: invokevirtual 160	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   901: aload_1
      //   902: invokestatic 180	com/tencent/token/wy:a	(Landroid/content/res/Resources;Lcom/tencent/token/wy;)V
      //   905: aload_1
      //   906: getfield 256	com/tencent/token/wy:a	I
      //   909: sipush 146
      //   912: if_icmpne +30 -> 942
      //   915: aload_0
      //   916: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   919: invokestatic 259	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$500	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   922: iconst_4
      //   923: if_icmpge +19 -> 942
      //   926: aload_0
      //   927: aload_0
      //   928: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   931: getfield 263	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:mSetModMobileRunnable	Ljava/lang/Runnable;
      //   934: ldc2_w 264
      //   937: invokevirtual 269	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:postDelayed	(Ljava/lang/Runnable;J)Z
      //   940: pop
      //   941: return
      //   942: aload_0
      //   943: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   946: invokevirtual 107	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   949: aload_0
      //   950: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   953: ldc 156
      //   955: aload_1
      //   956: getfield 177	com/tencent/token/wy:c	Ljava/lang/String;
      //   959: ldc 168
      //   961: aconst_null
      //   962: invokevirtual 172	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   965: return
      //   966: aload_0
      //   967: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   970: invokevirtual 107	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   973: aload_0
      //   974: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   977: invokevirtual 272	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:removeTimeTask	()V
      //   980: aload_0
      //   981: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   984: ldc_w 273
      //   987: invokevirtual 274	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getString	(I)Ljava/lang/String;
      //   990: astore_1
      //   991: aload_0
      //   992: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   995: aload_1
      //   996: invokestatic 278	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1200	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)V
      //   999: return
      //   1000: aload_0
      //   1001: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1004: astore_1
      //   1005: aload_1
      //   1006: ldc 156
      //   1008: aload_1
      //   1009: invokevirtual 160	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   1012: ldc_w 279
      //   1015: invokevirtual 167	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   1018: ldc 168
      //   1020: aconst_null
      //   1021: invokevirtual 172	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   1024: return
      //   1025: invokestatic 285	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
      //   1028: invokestatic 290	com/tencent/token/ry:a	(Landroid/content/Context;)Lcom/tencent/token/ry;
      //   1031: astore_1
      //   1032: aload_1
      //   1033: aload_0
      //   1034: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1037: invokestatic 294	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   1040: invokevirtual 297	com/tencent/token/ry:a	(J)[B
      //   1043: astore_3
      //   1044: ldc_w 299
      //   1047: aload_3
      //   1048: invokestatic 303	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   1051: invokevirtual 306	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1054: invokestatic 308	com/tencent/token/xa:a	(Ljava/lang/String;)V
      //   1057: aload_3
      //   1058: ifnull +65 -> 1123
      //   1061: aload_3
      //   1062: arraylength
      //   1063: ifle +60 -> 1123
      //   1066: new 75	java/lang/StringBuilder
      //   1069: dup
      //   1070: invokespecial 309	java/lang/StringBuilder:<init>	()V
      //   1073: astore 4
      //   1075: aload 4
      //   1077: aload_0
      //   1078: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1081: invokestatic 294	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   1084: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1087: pop
      //   1088: aload_1
      //   1089: aload 4
      //   1091: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1094: ldc2_w 313
      //   1097: invokevirtual 317	com/tencent/token/ry:a	(Ljava/lang/String;J)Z
      //   1100: ifne +23 -> 1123
      //   1103: aload_0
      //   1104: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1107: aload_3
      //   1108: invokestatic 47	com/tencent/token/aac:a	([B)Ljava/lang/String;
      //   1111: invokestatic 51	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   1114: pop
      //   1115: aload_0
      //   1116: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1119: invokestatic 33	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   1122: return
      //   1123: invokestatic 285	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
      //   1126: invokestatic 290	com/tencent/token/ry:a	(Landroid/content/Context;)Lcom/tencent/token/ry;
      //   1129: astore_1
      //   1130: new 75	java/lang/StringBuilder
      //   1133: dup
      //   1134: invokespecial 309	java/lang/StringBuilder:<init>	()V
      //   1137: astore_3
      //   1138: aload_3
      //   1139: aload_0
      //   1140: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1143: invokestatic 294	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   1146: invokevirtual 312	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1149: pop
      //   1150: aload_1
      //   1151: aload_3
      //   1152: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1155: aload_0
      //   1156: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1159: invokestatic 321	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$400	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Landroid/os/Handler;
      //   1162: ldc2_w 313
      //   1165: bipush 64
      //   1167: invokevirtual 324	com/tencent/token/ry:a	(Ljava/lang/String;Landroid/os/Handler;JI)I
      //   1170: pop
      //   1171: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1172	0	this	3
      //   0	1172	1	paramAnonymousMessage	Message
      //   15	5	2	i	int
      //   112	1040	3	localObject1	Object
      //   593	26	4	localObject2	Object
      //   623	1	4	localJSONException1	org.json.JSONException
      //   628	1	4	localJSONException2	org.json.JSONException
      //   635	7	4	localJSONException3	org.json.JSONException
      //   648	442	4	localObject3	Object
      //   17	826	5	localTextView	TextView
      // Exception table:
      //   from	to	target	type
      //   611	620	623	org/json/JSONException
      //   603	611	628	org/json/JSONException
      //   595	603	635	org/json/JSONException
    }
  };
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private int mRetryTimes = 0;
  private String mSMSChannel;
  Runnable mSetModMobileRunnable = new Runnable()
  {
    public final void run()
    {
      xa.c("send mod set mbmobile");
      sa.a().a(0L, UtilsModSetMobileStep2SmsActivity.this.mOpType, UtilsModSetMobileStep2SmsActivity.this.mMobile, UtilsModSetMobileStep2SmsActivity.this.mCountryCode, UtilsModSetMobileStep2SmsActivity.this.mA2, UtilsModSetMobileStep2SmsActivity.this.mHandler);
      UtilsModSetMobileStep2SmsActivity.access$508(UtilsModSetMobileStep2SmsActivity.this);
    }
  };
  private Button mStep2BindBtn;
  private long mTimeConter;
  private String mTitle;
  private long mUin;
  private QQUser mUser;
  
  private void gotoSetMobile()
  {
    this.mRetryTimes = 0;
    this.mHandler.postDelayed(this.mSetModMobileRunnable, 10000L);
  }
  
  private void init()
  {
    Object localObject = this.mUser;
    if (localObject != null) {
      this.mUin = ((QQUser)localObject).mRealUin;
    }
    localObject = getIntent().getExtras();
    if (localObject == null)
    {
      finish();
      return;
    }
    if ((((Bundle)localObject).getInt("op_type", 0) != 0) && (((Bundle)localObject).getString("title") != null) && (((Bundle)localObject).getString("mobile") != null))
    {
      this.mPageId = ((Bundle)localObject).getInt("page_id");
      this.mOpType = ((Bundle)localObject).getInt("op_type", 0);
      this.mMobile = ((Bundle)localObject).getString("mobile");
      this.mTitle = ((Bundle)localObject).getString("title");
      this.mCountryCode = ((Bundle)localObject).getString("area_code");
      setTitle(this.mTitle);
      localObject = new StringBuilder("test mbinfo, positon=, optype=");
      ((StringBuilder)localObject).append(this.mOpType);
      ((StringBuilder)localObject).append(", mobile=");
      ((StringBuilder)localObject).append(this.mMobile);
      ((StringBuilder)localObject).append(", area_code=");
      ((StringBuilder)localObject).append(this.mCountryCode);
      ((StringBuilder)localObject).append(",title=");
      ((StringBuilder)localObject).append(this.mTitle);
      xa.c(((StringBuilder)localObject).toString());
      this.mStep2BindBtn = ((Button)findViewById(2131165773));
      this.mStep2BindBtn.setOnClickListener(this);
      findViewById(2131165355).setOnClickListener(this);
      ((TextView)findViewById(2131165740)).setText(this.mMobile);
      return;
    }
    finish();
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131493656, paramString, 2131493040, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {
        if (paramKeyEvent.getKeyCode() == 4) {
          break label73;
        }
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder("dispatchKeyEvent exception ");
      localStringBuilder.append(this);
      localStringBuilder.append(paramKeyEvent.toString());
      xa.c(localStringBuilder.toString());
      return true;
    }
    label73:
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHandler.sendEmptyMessage(3);
    startTimeTask();
    xa.b("startTimeTask onActivityResult");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165355)
    {
      if (i != 2131165773)
      {
        if (i != 2131166040) {
          return;
        }
        if (this.mOpType == 3)
        {
          paramView = new Intent(this, MyMbSubPageActivity.class);
          paramView.addFlags(67108864);
          startActivity(paramView);
        }
        else
        {
          i = this.mPageId;
          if (i == 10)
          {
            paramView = new Intent(this, IndexActivity.class);
            paramView.putExtra("index_from", 16);
            startActivity(paramView);
          }
          else if (i == 14)
          {
            paramView = new Intent(this, MyMbSubPageActivity.class);
            paramView.putExtra("page_id", this.mPageId);
            paramView.addFlags(67108864);
            startActivity(paramView);
          }
          else if (i == 17)
          {
            paramView = new Intent(this, MyMbSubPageActivity.class);
            paramView.putExtra("page_id", this.mPageId);
            paramView.addFlags(67108864);
            startActivity(paramView);
          }
          else
          {
            startActivity(new Intent(this, IndexActivity.class));
          }
        }
        finish();
        return;
      }
      this.isCurrentMobile = true;
      sa.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
      paramView = new StringBuilder();
      paramView.append(getResources().getString(2131493732));
      paramView.append(this.mTitle);
      paramView.append(getResources().getString(2131493733));
      showProDialog(this, 2131492986, paramView.toString(), null);
      return;
    }
    this.isCurrentMobile = false;
    sa.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
    paramView = new StringBuilder();
    paramView.append(getResources().getString(2131493732));
    paramView.append(this.mTitle);
    paramView.append(getResources().getString(2131493733));
    showProDialog(this, 2131492986, paramView.toString(), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296490);
    this.mUser = sz.a().k.b();
    init();
    new Thread(this).start();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onStop()
  {
    super.onStop();
  }
  
  public void removeTimeTask()
  {
    this.mIsTimeTask = false;
  }
  
  public void run()
  {
    while (this.mIsRunning) {
      if ((this.mIsTimeTask) && (System.currentTimeMillis() - this.mTimeConter > 60000L)) {
        try
        {
          xa.c("removeTimeTask removeTimeTask");
          removeTimeTask();
          Message localMessage = new Message();
          localMessage.what = 15;
          this.mHandler.sendMessage(localMessage);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  public void sendUpSmsBySMSAPP(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:".concat(String.valueOf(paramString1))));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      xa.b(paramString1.toString());
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131493804, 2131492947, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        xa.c("removeTimeTask showProgressDialog");
        UtilsModSetMobileStep2SmsActivity.this.removeTimeTask();
      }
    });
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.UtilsModSetMobileStep2SmsActivity
 * JD-Core Version:    0.7.0.1
 */