package com.tencent.token.ui;

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
import com.tencent.token.cb;
import com.tencent.token.cc;
import com.tencent.token.cm;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cr;
import com.tencent.token.global.g;

public class UtilsModSetMobileStep2SmsActivity
  extends BaseActivity
  implements View.OnClickListener, Runnable
{
  private boolean isCurrentMobile = true;
  private String mA2 = "";
  private int mBindRetryTimes = 0;
  private String mCountryCode;
  private Handler mHandler = new Handler()
  {
    /* Error */
    public void handleMessage(Message paramAnonymousMessage)
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
      //   20: lookupswitch	default:+76->96, 3:+1010->1030, 4:+985->1005, 15:+951->971, 3012:+515->535, 3019:+129->149, 4097:+85->105, 4098:+85->105, 4104:+77->97
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
      //   134: invokestatic 47	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
      //   137: invokestatic 51	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   140: pop
      //   141: aload_0
      //   142: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   145: invokestatic 33	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   148: return
      //   149: aload_1
      //   150: getfield 42	android/os/Message:arg1	I
      //   153: ifne +329 -> 482
      //   156: aload_0
      //   157: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   160: getstatic 57	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:d	Ljava/lang/String;
      //   163: invokestatic 60	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$602	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   166: pop
      //   167: aload_0
      //   168: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   171: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   174: ifnull +284 -> 458
      //   177: aload_0
      //   178: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   181: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   184: invokevirtual 70	java/lang/String:length	()I
      //   187: ifgt +6 -> 193
      //   190: goto +268 -> 458
      //   193: getstatic 73	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:e	Ljava/lang/String;
      //   196: ifnull +238 -> 434
      //   199: getstatic 73	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:e	Ljava/lang/String;
      //   202: invokevirtual 70	java/lang/String:length	()I
      //   205: ifgt +6 -> 211
      //   208: goto +226 -> 434
      //   211: new 75	java/lang/StringBuilder
      //   214: dup
      //   215: invokespecial 76	java/lang/StringBuilder:<init>	()V
      //   218: astore_1
      //   219: aload_1
      //   220: ldc 78
      //   222: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   225: pop
      //   226: aload_1
      //   227: aload_0
      //   228: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   231: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   234: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: pop
      //   238: aload_1
      //   239: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   242: invokestatic 92	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   245: aload_0
      //   246: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   249: invokestatic 96	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$700	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Z
      //   252: ifeq +27 -> 279
      //   255: aload_0
      //   256: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   259: astore_1
      //   260: aload_1
      //   261: aload_1
      //   262: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   265: getstatic 73	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:e	Ljava/lang/String;
      //   268: invokevirtual 100	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:sendUpSmsBySMSAPP	(Ljava/lang/String;Ljava/lang/String;)V
      //   271: aload_0
      //   272: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   275: invokevirtual 103	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showProgressDialog	()V
      //   278: return
      //   279: aload_0
      //   280: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   283: invokevirtual 106	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   286: new 108	android/content/Intent
      //   289: dup
      //   290: aload_0
      //   291: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   294: ldc 110
      //   296: invokespecial 113	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   299: astore_1
      //   300: aload_1
      //   301: ldc 115
      //   303: aload_0
      //   304: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   307: invokestatic 118	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   310: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   313: pop
      //   314: aload_1
      //   315: ldc 124
      //   317: aload_0
      //   318: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   321: invokestatic 127	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$800	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   324: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   327: pop
      //   328: aload_1
      //   329: ldc 129
      //   331: aload_0
      //   332: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   335: invokestatic 64	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   338: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   341: pop
      //   342: aload_1
      //   343: ldc 131
      //   345: aload_0
      //   346: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   349: invokestatic 134	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$200	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   352: invokevirtual 122	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   355: pop
      //   356: aload_1
      //   357: ldc 136
      //   359: aload_0
      //   360: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   363: invokestatic 140	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   366: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   369: pop
      //   370: aload_1
      //   371: ldc 145
      //   373: aload_0
      //   374: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   377: invokestatic 148	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$900	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   380: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   383: pop
      //   384: aload_0
      //   385: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   388: invokestatic 140	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   391: iconst_1
      //   392: if_icmpne +14 -> 406
      //   395: aload_1
      //   396: ldc 150
      //   398: iconst_4
      //   399: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   402: pop
      //   403: goto +22 -> 425
      //   406: aload_0
      //   407: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   410: invokestatic 140	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   413: iconst_3
      //   414: if_icmpne +11 -> 425
      //   417: aload_1
      //   418: ldc 150
      //   420: iconst_3
      //   421: invokevirtual 143	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   424: pop
      //   425: aload_0
      //   426: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   429: aload_1
      //   430: invokevirtual 154	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:startActivity	(Landroid/content/Intent;)V
      //   433: return
      //   434: aload_0
      //   435: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   438: astore_1
      //   439: aload_1
      //   440: ldc 155
      //   442: aload_1
      //   443: invokevirtual 159	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   446: ldc 160
      //   448: invokevirtual 166	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   451: ldc 167
      //   453: aconst_null
      //   454: invokevirtual 171	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   457: return
      //   458: aload_0
      //   459: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   462: astore_1
      //   463: aload_1
      //   464: ldc 155
      //   466: aload_1
      //   467: invokevirtual 159	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   470: ldc 172
      //   472: invokevirtual 166	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   475: ldc 167
      //   477: aconst_null
      //   478: invokevirtual 171	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   481: return
      //   482: aload_1
      //   483: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   486: checkcast 174	com/tencent/token/global/e
      //   489: astore_1
      //   490: aload_1
      //   491: getfield 176	com/tencent/token/global/e:c	Ljava/lang/String;
      //   494: ifnull +13 -> 507
      //   497: aload_1
      //   498: getfield 176	com/tencent/token/global/e:c	Ljava/lang/String;
      //   501: invokevirtual 70	java/lang/String:length	()I
      //   504: ifne +14 -> 518
      //   507: aload_0
      //   508: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   511: invokevirtual 159	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   514: aload_1
      //   515: invokestatic 179	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   518: aload_0
      //   519: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   522: ldc 155
      //   524: aload_1
      //   525: getfield 176	com/tencent/token/global/e:c	Ljava/lang/String;
      //   528: ldc 167
      //   530: aconst_null
      //   531: invokevirtual 171	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   534: return
      //   535: aload_1
      //   536: getfield 42	android/os/Message:arg1	I
      //   539: ifne +335 -> 874
      //   542: aload_0
      //   543: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   546: invokevirtual 106	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   549: aload_0
      //   550: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   553: ldc 180
      //   555: invokevirtual 184	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:setContentView	(I)V
      //   558: aload_0
      //   559: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   562: getfield 188	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:mBackArrow	Landroid/view/View;
      //   565: iconst_4
      //   566: invokevirtual 193	android/view/View:setVisibility	(I)V
      //   569: aload_0
      //   570: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   573: iconst_1
      //   574: invokestatic 197	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Z)Z
      //   577: pop
      //   578: aload_0
      //   579: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   582: astore_3
      //   583: aload_3
      //   584: aload_3
      //   585: invokestatic 127	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$800	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   588: invokevirtual 201	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:setTitle	(Ljava/lang/CharSequence;)V
      //   591: aload_1
      //   592: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   595: checkcast 203	org/json/JSONObject
      //   598: astore 4
      //   600: aload 4
      //   602: ldc 205
      //   604: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   607: astore_3
      //   608: aload 4
      //   610: ldc 210
      //   612: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   615: astore_1
      //   616: aload 4
      //   618: ldc 212
      //   620: invokevirtual 208	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   623: astore 4
      //   625: goto +30 -> 655
      //   628: astore 4
      //   630: goto +16 -> 646
      //   633: astore 4
      //   635: aconst_null
      //   636: astore_1
      //   637: goto +9 -> 646
      //   640: astore 4
      //   642: aconst_null
      //   643: astore_3
      //   644: aload_3
      //   645: astore_1
      //   646: aload 4
      //   648: invokevirtual 215	org/json/JSONException:printStackTrace	()V
      //   651: aload 5
      //   653: astore 4
      //   655: aload_3
      //   656: ifnull +36 -> 692
      //   659: aload_3
      //   660: invokevirtual 70	java/lang/String:length	()I
      //   663: ifle +29 -> 692
      //   666: aload_0
      //   667: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   670: ldc 216
      //   672: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   675: checkcast 222	android/widget/TextView
      //   678: astore 5
      //   680: aload 5
      //   682: aload_3
      //   683: invokevirtual 225	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   686: aload 5
      //   688: iconst_0
      //   689: invokevirtual 226	android/widget/TextView:setVisibility	(I)V
      //   692: aload_0
      //   693: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   696: ldc 227
      //   698: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   701: aload_0
      //   702: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   705: invokevirtual 231	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   708: aload_0
      //   709: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   712: ldc 232
      //   714: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   717: astore_3
      //   718: aload_0
      //   719: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   722: invokestatic 140	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   725: iconst_1
      //   726: if_icmpne +43 -> 769
      //   729: aload_0
      //   730: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   733: ldc 233
      //   735: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   738: checkcast 222	android/widget/TextView
      //   741: ldc 234
      //   743: invokevirtual 236	android/widget/TextView:setText	(I)V
      //   746: aload_3
      //   747: bipush 8
      //   749: invokevirtual 193	android/view/View:setVisibility	(I)V
      //   752: aload_0
      //   753: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   756: ldc 216
      //   758: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   761: bipush 8
      //   763: invokevirtual 193	android/view/View:setVisibility	(I)V
      //   766: goto +97 -> 863
      //   769: aload_0
      //   770: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   773: ldc 233
      //   775: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   778: checkcast 222	android/widget/TextView
      //   781: ldc 237
      //   783: invokevirtual 236	android/widget/TextView:setText	(I)V
      //   786: aload_1
      //   787: ifnull +70 -> 857
      //   790: aload 4
      //   792: ifnull +65 -> 857
      //   795: aload_1
      //   796: invokevirtual 70	java/lang/String:length	()I
      //   799: ifle +58 -> 857
      //   802: aload 4
      //   804: invokevirtual 70	java/lang/String:length	()I
      //   807: ifle +50 -> 857
      //   810: aload_3
      //   811: iconst_0
      //   812: invokevirtual 193	android/view/View:setVisibility	(I)V
      //   815: aload_0
      //   816: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   819: ldc 238
      //   821: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   824: checkcast 222	android/widget/TextView
      //   827: astore_3
      //   828: aload_0
      //   829: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   832: ldc 239
      //   834: invokevirtual 220	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   837: checkcast 222	android/widget/TextView
      //   840: astore 5
      //   842: aload_3
      //   843: aload_1
      //   844: invokevirtual 225	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   847: aload 5
      //   849: aload 4
      //   851: invokevirtual 225	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   854: goto +9 -> 863
      //   857: aload_3
      //   858: bipush 8
      //   860: invokevirtual 193	android/view/View:setVisibility	(I)V
      //   863: invokestatic 244	com/tencent/token/dj:a	()Lcom/tencent/token/dj;
      //   866: invokevirtual 247	com/tencent/token/dj:b	()V
      //   869: iconst_1
      //   870: putstatic 253	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   873: return
      //   874: aload_1
      //   875: getfield 37	android/os/Message:obj	Ljava/lang/Object;
      //   878: checkcast 174	com/tencent/token/global/e
      //   881: astore_1
      //   882: aload_1
      //   883: getfield 176	com/tencent/token/global/e:c	Ljava/lang/String;
      //   886: ifnull +13 -> 899
      //   889: aload_1
      //   890: getfield 176	com/tencent/token/global/e:c	Ljava/lang/String;
      //   893: invokevirtual 70	java/lang/String:length	()I
      //   896: ifne +14 -> 910
      //   899: aload_0
      //   900: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   903: invokevirtual 159	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   906: aload_1
      //   907: invokestatic 179	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   910: aload_1
      //   911: getfield 255	com/tencent/token/global/e:a	I
      //   914: sipush 146
      //   917: if_icmpne +30 -> 947
      //   920: aload_0
      //   921: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   924: invokestatic 258	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$500	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   927: iconst_4
      //   928: if_icmpge +19 -> 947
      //   931: aload_0
      //   932: aload_0
      //   933: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   936: getfield 262	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:mSetModMobileRunnable	Ljava/lang/Runnable;
      //   939: ldc2_w 263
      //   942: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:postDelayed	(Ljava/lang/Runnable;J)Z
      //   945: pop
      //   946: return
      //   947: aload_0
      //   948: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   951: invokevirtual 106	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   954: aload_0
      //   955: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   958: ldc 155
      //   960: aload_1
      //   961: getfield 176	com/tencent/token/global/e:c	Ljava/lang/String;
      //   964: ldc 167
      //   966: aconst_null
      //   967: invokevirtual 171	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   970: return
      //   971: aload_0
      //   972: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   975: invokevirtual 106	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   978: aload_0
      //   979: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   982: invokevirtual 271	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:removeTimeTask	()V
      //   985: aload_0
      //   986: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   989: ldc_w 272
      //   992: invokevirtual 273	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getString	(I)Ljava/lang/String;
      //   995: astore_1
      //   996: aload_0
      //   997: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1000: aload_1
      //   1001: invokestatic 277	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1200	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)V
      //   1004: return
      //   1005: aload_0
      //   1006: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1009: astore_1
      //   1010: aload_1
      //   1011: ldc 155
      //   1013: aload_1
      //   1014: invokevirtual 159	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   1017: ldc_w 278
      //   1020: invokevirtual 166	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   1023: ldc 167
      //   1025: aconst_null
      //   1026: invokevirtual 171	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   1029: return
      //   1030: invokestatic 284	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
      //   1033: invokestatic 289	com/tencent/token/bz:a	(Landroid/content/Context;)Lcom/tencent/token/bz;
      //   1036: astore_1
      //   1037: aload_1
      //   1038: aload_0
      //   1039: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1042: invokestatic 293	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   1045: invokevirtual 296	com/tencent/token/bz:b	(J)[B
      //   1048: astore_3
      //   1049: new 75	java/lang/StringBuilder
      //   1052: dup
      //   1053: invokespecial 76	java/lang/StringBuilder:<init>	()V
      //   1056: astore 4
      //   1058: aload 4
      //   1060: ldc_w 298
      //   1063: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1066: pop
      //   1067: aload 4
      //   1069: aload_3
      //   1070: invokevirtual 301	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   1073: pop
      //   1074: aload 4
      //   1076: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1079: invokestatic 303	com/tencent/token/global/g:a	(Ljava/lang/String;)V
      //   1082: aload_3
      //   1083: ifnull +74 -> 1157
      //   1086: aload_3
      //   1087: arraylength
      //   1088: ifle +69 -> 1157
      //   1091: new 75	java/lang/StringBuilder
      //   1094: dup
      //   1095: invokespecial 76	java/lang/StringBuilder:<init>	()V
      //   1098: astore 4
      //   1100: aload 4
      //   1102: ldc_w 305
      //   1105: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1108: pop
      //   1109: aload 4
      //   1111: aload_0
      //   1112: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1115: invokestatic 293	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   1118: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1121: pop
      //   1122: aload_1
      //   1123: aload 4
      //   1125: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1128: ldc2_w 309
      //   1131: invokevirtual 313	com/tencent/token/bz:b	(Ljava/lang/String;J)Z
      //   1134: ifne +23 -> 1157
      //   1137: aload_0
      //   1138: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1141: aload_3
      //   1142: invokestatic 47	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
      //   1145: invokestatic 51	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   1148: pop
      //   1149: aload_0
      //   1150: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1153: invokestatic 33	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   1156: return
      //   1157: invokestatic 284	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
      //   1160: invokestatic 289	com/tencent/token/bz:a	(Landroid/content/Context;)Lcom/tencent/token/bz;
      //   1163: astore_1
      //   1164: new 75	java/lang/StringBuilder
      //   1167: dup
      //   1168: invokespecial 76	java/lang/StringBuilder:<init>	()V
      //   1171: astore_3
      //   1172: aload_3
      //   1173: ldc_w 305
      //   1176: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1179: pop
      //   1180: aload_3
      //   1181: aload_0
      //   1182: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1185: invokestatic 293	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   1188: invokevirtual 308	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1191: pop
      //   1192: aload_1
      //   1193: aload_3
      //   1194: invokevirtual 86	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1197: aload_0
      //   1198: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1201: invokestatic 317	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$400	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Landroid/os/Handler;
      //   1204: ldc2_w 309
      //   1207: bipush 64
      //   1209: invokevirtual 320	com/tencent/token/bz:a	(Ljava/lang/String;Landroid/os/Handler;JI)I
      //   1212: pop
      //   1213: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1214	0	this	3
      //   0	1214	1	paramAnonymousMessage	Message
      //   15	5	2	i	int
      //   112	1082	3	localObject1	Object
      //   598	26	4	localObject2	Object
      //   628	1	4	localJSONException1	org.json.JSONException
      //   633	1	4	localJSONException2	org.json.JSONException
      //   640	7	4	localJSONException3	org.json.JSONException
      //   653	471	4	localObject3	Object
      //   17	831	5	localTextView	TextView
      // Exception table:
      //   from	to	target	type
      //   616	625	628	org/json/JSONException
      //   608	616	633	org/json/JSONException
      //   600	608	640	org/json/JSONException
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
    public void run()
    {
      g.c("send mod set mbmobile");
      cb.a().a(0L, UtilsModSetMobileStep2SmsActivity.this.mOpType, UtilsModSetMobileStep2SmsActivity.this.mMobile, UtilsModSetMobileStep2SmsActivity.this.mCountryCode, UtilsModSetMobileStep2SmsActivity.this.mA2, UtilsModSetMobileStep2SmsActivity.this.mHandler);
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
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("test mbinfo, positon=, optype=");
      ((StringBuilder)localObject).append(this.mOpType);
      ((StringBuilder)localObject).append(", mobile=");
      ((StringBuilder)localObject).append(this.mMobile);
      ((StringBuilder)localObject).append(", area_code=");
      ((StringBuilder)localObject).append(this.mCountryCode);
      ((StringBuilder)localObject).append(",title=");
      ((StringBuilder)localObject).append(this.mTitle);
      g.c(((StringBuilder)localObject).toString());
      this.mStep2BindBtn = ((Button)findViewById(2131165767));
      this.mStep2BindBtn.setOnClickListener(this);
      findViewById(2131165351).setOnClickListener(this);
      ((TextView)findViewById(2131165734)).setText(this.mMobile);
      return;
    }
    finish();
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131493653, paramString, 2131493039, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {
        if (paramKeyEvent.getKeyCode() == 4) {
          break label77;
        }
      }
      boolean bool = super.dispatchKeyEvent(paramKeyEvent);
      return bool;
    }
    catch (Exception paramKeyEvent)
    {
      paramKeyEvent.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("dispatchKeyEvent exception ");
      localStringBuilder.append(this);
      localStringBuilder.append(paramKeyEvent.toString());
      g.d(localStringBuilder.toString());
      return true;
    }
    label77:
    return true;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHandler.sendEmptyMessage(3);
    startTimeTask();
    g.b("startTimeTask onActivityResult");
  }
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    if (i != 2131165351)
    {
      if (i != 2131165767)
      {
        if (i != 2131166032) {
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
      cb.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
      paramView = new StringBuilder();
      paramView.append(getResources().getString(2131493729));
      paramView.append(this.mTitle);
      paramView.append(getResources().getString(2131493730));
      showProDialog(this, 2131492985, paramView.toString(), null);
      return;
    }
    this.isCurrentMobile = false;
    cb.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
    paramView = new StringBuilder();
    paramView.append(getResources().getString(2131493729));
    paramView.append(this.mTitle);
    paramView.append(getResources().getString(2131493730));
    showProDialog(this, 2131492985, paramView.toString(), null);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296489);
    this.mUser = cr.a().e();
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
    cc.c().a.a(this.mHandler);
  }
  
  public void onStop()
  {
    super.onStop();
    cc.c().a.a(null);
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
          g.c("removeTimeTask removeTimeTask");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("smsto:");
      localStringBuilder.append(paramString1);
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse(localStringBuilder.toString()));
      paramString1.putExtra("sms_body", paramString2);
      startActivityForResult(paramString1, 0);
      return;
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      g.b(paramString1.toString());
    }
  }
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131493801, 2131492946, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.c("removeTimeTask showProgressDialog");
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