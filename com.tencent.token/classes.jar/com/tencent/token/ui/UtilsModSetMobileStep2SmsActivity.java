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
import com.tencent.token.ca;
import com.tencent.token.cb;
import com.tencent.token.cl;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.cq;
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
      //   0: aconst_null
      //   1: astore 5
      //   3: aload_0
      //   4: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   7: invokevirtual 24	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:isFinishing	()Z
      //   10: ifeq +4 -> 14
      //   13: return
      //   14: aload_1
      //   15: getfield 30	android/os/Message:what	I
      //   18: lookupswitch	default:+74->92, 3:+75->93, 4:+605->623, 15:+630->648, 3012:+663->681, 3019:+180->198, 4097:+1102->1120, 4098:+1102->1120, 4104:+1149->1167
      //   93: invokestatic 36	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
      //   96: invokestatic 41	com/tencent/token/by:a	(Landroid/content/Context;)Lcom/tencent/token/by;
      //   99: astore_1
      //   100: aload_1
      //   101: aload_0
      //   102: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   105: invokestatic 45	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   108: invokevirtual 49	com/tencent/token/by:b	(J)[B
      //   111: astore_2
      //   112: new 51	java/lang/StringBuilder
      //   115: dup
      //   116: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   119: ldc 54
      //   121: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   124: aload_2
      //   125: invokevirtual 61	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   128: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   131: invokestatic 70	com/tencent/token/global/g:a	(Ljava/lang/String;)V
      //   134: aload_2
      //   135: ifnull +440 -> 575
      //   138: aload_2
      //   139: arraylength
      //   140: ifle +435 -> 575
      //   143: aload_1
      //   144: new 51	java/lang/StringBuilder
      //   147: dup
      //   148: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   151: ldc 72
      //   153: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   156: aload_0
      //   157: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   160: invokestatic 45	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   163: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   166: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   169: ldc2_w 76
      //   172: invokevirtual 80	com/tencent/token/by:b	(Ljava/lang/String;J)Z
      //   175: ifne +400 -> 575
      //   178: aload_0
      //   179: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   182: aload_2
      //   183: invokestatic 85	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
      //   186: invokestatic 89	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   189: pop
      //   190: aload_0
      //   191: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   194: invokestatic 92	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   197: return
      //   198: aload_1
      //   199: getfield 95	android/os/Message:arg1	I
      //   202: ifne +320 -> 522
      //   205: aload_0
      //   206: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   209: getstatic 101	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:d	Ljava/lang/String;
      //   212: invokestatic 104	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$602	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   215: pop
      //   216: aload_0
      //   217: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   220: invokestatic 108	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   223: ifnull +16 -> 239
      //   226: aload_0
      //   227: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   230: invokestatic 108	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   233: invokevirtual 114	java/lang/String:length	()I
      //   236: ifgt +28 -> 264
      //   239: aload_0
      //   240: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   243: ldc 115
      //   245: aload_0
      //   246: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   249: invokevirtual 119	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   252: ldc 120
      //   254: invokevirtual 126	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   257: ldc 127
      //   259: aconst_null
      //   260: invokevirtual 131	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   263: return
      //   264: getstatic 134	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:e	Ljava/lang/String;
      //   267: ifnull +12 -> 279
      //   270: getstatic 134	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:e	Ljava/lang/String;
      //   273: invokevirtual 114	java/lang/String:length	()I
      //   276: ifgt +28 -> 304
      //   279: aload_0
      //   280: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   283: ldc 115
      //   285: aload_0
      //   286: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   289: invokevirtual 119	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   292: ldc 135
      //   294: invokevirtual 126	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   297: ldc 127
      //   299: aconst_null
      //   300: invokevirtual 131	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   303: return
      //   304: new 51	java/lang/StringBuilder
      //   307: dup
      //   308: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   311: ldc 137
      //   313: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   316: aload_0
      //   317: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   320: invokestatic 108	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   323: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   326: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   329: invokestatic 140	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   332: aload_0
      //   333: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   336: invokestatic 144	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$700	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Z
      //   339: ifeq +28 -> 367
      //   342: aload_0
      //   343: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   346: aload_0
      //   347: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   350: invokestatic 108	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   353: getstatic 134	com/tencent/token/core/protocolcenter/protocol/ProtoGetSMSChannel:e	Ljava/lang/String;
      //   356: invokevirtual 148	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:sendUpSmsBySMSAPP	(Ljava/lang/String;Ljava/lang/String;)V
      //   359: aload_0
      //   360: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   363: invokevirtual 151	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showProgressDialog	()V
      //   366: return
      //   367: aload_0
      //   368: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   371: invokevirtual 154	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   374: new 156	android/content/Intent
      //   377: dup
      //   378: aload_0
      //   379: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   382: ldc 158
      //   384: invokespecial 161	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   387: astore_1
      //   388: aload_1
      //   389: ldc 163
      //   391: aload_0
      //   392: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   395: invokestatic 166	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   398: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   401: pop
      //   402: aload_1
      //   403: ldc 172
      //   405: aload_0
      //   406: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   409: invokestatic 175	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$800	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   412: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   415: pop
      //   416: aload_1
      //   417: ldc 177
      //   419: aload_0
      //   420: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   423: invokestatic 108	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$600	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   426: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   429: pop
      //   430: aload_1
      //   431: ldc 179
      //   433: aload_0
      //   434: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   437: invokestatic 182	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$200	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   440: invokevirtual 170	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
      //   443: pop
      //   444: aload_1
      //   445: ldc 184
      //   447: aload_0
      //   448: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   451: invokestatic 188	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   454: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   457: pop
      //   458: aload_1
      //   459: ldc 193
      //   461: aload_0
      //   462: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   465: invokestatic 196	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$900	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   468: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   471: pop
      //   472: aload_0
      //   473: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   476: invokestatic 188	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   479: iconst_1
      //   480: if_icmpne +20 -> 500
      //   483: aload_1
      //   484: ldc 198
      //   486: iconst_4
      //   487: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   490: pop
      //   491: aload_0
      //   492: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   495: aload_1
      //   496: invokevirtual 202	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:startActivity	(Landroid/content/Intent;)V
      //   499: return
      //   500: aload_0
      //   501: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   504: invokestatic 188	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   507: iconst_3
      //   508: if_icmpne -17 -> 491
      //   511: aload_1
      //   512: ldc 198
      //   514: iconst_3
      //   515: invokevirtual 191	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
      //   518: pop
      //   519: goto -28 -> 491
      //   522: aload_1
      //   523: getfield 206	android/os/Message:obj	Ljava/lang/Object;
      //   526: checkcast 208	com/tencent/token/global/e
      //   529: astore_1
      //   530: aload_1
      //   531: getfield 210	com/tencent/token/global/e:c	Ljava/lang/String;
      //   534: ifnull +13 -> 547
      //   537: aload_1
      //   538: getfield 210	com/tencent/token/global/e:c	Ljava/lang/String;
      //   541: invokevirtual 114	java/lang/String:length	()I
      //   544: ifne +14 -> 558
      //   547: aload_0
      //   548: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   551: invokevirtual 119	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   554: aload_1
      //   555: invokestatic 213	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   558: aload_0
      //   559: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   562: ldc 115
      //   564: aload_1
      //   565: getfield 210	com/tencent/token/global/e:c	Ljava/lang/String;
      //   568: ldc 127
      //   570: aconst_null
      //   571: invokevirtual 131	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   574: return
      //   575: invokestatic 36	com/tencent/token/global/RqdApplication:l	()Landroid/content/Context;
      //   578: invokestatic 41	com/tencent/token/by:a	(Landroid/content/Context;)Lcom/tencent/token/by;
      //   581: new 51	java/lang/StringBuilder
      //   584: dup
      //   585: invokespecial 52	java/lang/StringBuilder:<init>	()V
      //   588: ldc 72
      //   590: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   593: aload_0
      //   594: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   597: invokestatic 45	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)J
      //   600: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   603: invokevirtual 65	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   606: aload_0
      //   607: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   610: invokestatic 217	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$400	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Landroid/os/Handler;
      //   613: ldc2_w 76
      //   616: bipush 64
      //   618: invokevirtual 220	com/tencent/token/by:a	(Ljava/lang/String;Landroid/os/Handler;JI)I
      //   621: pop
      //   622: return
      //   623: aload_0
      //   624: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   627: ldc 115
      //   629: aload_0
      //   630: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   633: invokevirtual 119	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   636: ldc 221
      //   638: invokevirtual 126	android/content/res/Resources:getString	(I)Ljava/lang/String;
      //   641: ldc 127
      //   643: aconst_null
      //   644: invokevirtual 131	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   647: return
      //   648: aload_0
      //   649: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   652: invokevirtual 154	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   655: aload_0
      //   656: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   659: invokevirtual 224	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:removeTimeTask	()V
      //   662: aload_0
      //   663: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   666: ldc 225
      //   668: invokevirtual 226	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getString	(I)Ljava/lang/String;
      //   671: astore_1
      //   672: aload_0
      //   673: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   676: aload_1
      //   677: invokestatic 230	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1200	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)V
      //   680: return
      //   681: aload_1
      //   682: getfield 95	android/os/Message:arg1	I
      //   685: ifne +338 -> 1023
      //   688: aload_0
      //   689: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   692: invokevirtual 154	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   695: aload_0
      //   696: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   699: ldc 231
      //   701: invokevirtual 235	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:setContentView	(I)V
      //   704: aload_0
      //   705: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   708: getfield 239	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:mBackArrow	Landroid/view/View;
      //   711: iconst_4
      //   712: invokevirtual 244	android/view/View:setVisibility	(I)V
      //   715: aload_0
      //   716: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   719: iconst_1
      //   720: invokestatic 248	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Z)Z
      //   723: pop
      //   724: aload_0
      //   725: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   728: aload_0
      //   729: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   732: invokestatic 175	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$800	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)Ljava/lang/String;
      //   735: invokevirtual 252	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:setTitle	(Ljava/lang/CharSequence;)V
      //   738: aload_1
      //   739: getfield 206	android/os/Message:obj	Ljava/lang/Object;
      //   742: checkcast 254	org/json/JSONObject
      //   745: astore_3
      //   746: aload_3
      //   747: ldc_w 256
      //   750: invokevirtual 259	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   753: astore_2
      //   754: aload_3
      //   755: ldc_w 261
      //   758: invokevirtual 259	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   761: astore_1
      //   762: aload_3
      //   763: ldc_w 263
      //   766: invokevirtual 259	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   769: astore_3
      //   770: aload_2
      //   771: astore 4
      //   773: aload_1
      //   774: astore_2
      //   775: aload_3
      //   776: astore_1
      //   777: aload 4
      //   779: ifnull +36 -> 815
      //   782: aload 4
      //   784: invokevirtual 114	java/lang/String:length	()I
      //   787: ifle +28 -> 815
      //   790: aload_0
      //   791: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   794: ldc_w 264
      //   797: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   800: checkcast 270	android/widget/TextView
      //   803: astore_3
      //   804: aload_3
      //   805: aload 4
      //   807: invokevirtual 273	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   810: aload_3
      //   811: iconst_0
      //   812: invokevirtual 274	android/widget/TextView:setVisibility	(I)V
      //   815: aload_0
      //   816: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   819: ldc_w 275
      //   822: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   825: aload_0
      //   826: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   829: invokevirtual 279	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   832: aload_0
      //   833: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   836: ldc_w 280
      //   839: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   842: astore_3
      //   843: aload_0
      //   844: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   847: invokestatic 188	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$000	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   850: iconst_1
      //   851: if_icmpne +74 -> 925
      //   854: aload_0
      //   855: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   858: ldc_w 281
      //   861: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   864: checkcast 270	android/widget/TextView
      //   867: ldc_w 282
      //   870: invokevirtual 284	android/widget/TextView:setText	(I)V
      //   873: aload_3
      //   874: bipush 8
      //   876: invokevirtual 244	android/view/View:setVisibility	(I)V
      //   879: aload_0
      //   880: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   883: ldc_w 264
      //   886: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   889: bipush 8
      //   891: invokevirtual 244	android/view/View:setVisibility	(I)V
      //   894: invokestatic 289	com/tencent/token/di:a	()Lcom/tencent/token/di;
      //   897: invokevirtual 291	com/tencent/token/di:b	()V
      //   900: iconst_1
      //   901: putstatic 297	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   904: return
      //   905: astore_3
      //   906: aconst_null
      //   907: astore_1
      //   908: aconst_null
      //   909: astore_2
      //   910: aload_3
      //   911: invokevirtual 300	org/json/JSONException:printStackTrace	()V
      //   914: aload_2
      //   915: astore 4
      //   917: aload_1
      //   918: astore_2
      //   919: aload 5
      //   921: astore_1
      //   922: goto -145 -> 777
      //   925: aload_0
      //   926: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   929: ldc_w 281
      //   932: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   935: checkcast 270	android/widget/TextView
      //   938: ldc_w 301
      //   941: invokevirtual 284	android/widget/TextView:setText	(I)V
      //   944: aload_2
      //   945: ifnull +69 -> 1014
      //   948: aload_1
      //   949: ifnull +65 -> 1014
      //   952: aload_2
      //   953: invokevirtual 114	java/lang/String:length	()I
      //   956: ifle +58 -> 1014
      //   959: aload_1
      //   960: invokevirtual 114	java/lang/String:length	()I
      //   963: ifle +51 -> 1014
      //   966: aload_3
      //   967: iconst_0
      //   968: invokevirtual 244	android/view/View:setVisibility	(I)V
      //   971: aload_0
      //   972: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   975: ldc_w 302
      //   978: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   981: checkcast 270	android/widget/TextView
      //   984: astore_3
      //   985: aload_0
      //   986: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   989: ldc_w 303
      //   992: invokevirtual 268	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:findViewById	(I)Landroid/view/View;
      //   995: checkcast 270	android/widget/TextView
      //   998: astore 4
      //   1000: aload_3
      //   1001: aload_2
      //   1002: invokevirtual 273	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1005: aload 4
      //   1007: aload_1
      //   1008: invokevirtual 273	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1011: goto -117 -> 894
      //   1014: aload_3
      //   1015: bipush 8
      //   1017: invokevirtual 244	android/view/View:setVisibility	(I)V
      //   1020: goto -126 -> 894
      //   1023: aload_1
      //   1024: getfield 206	android/os/Message:obj	Ljava/lang/Object;
      //   1027: checkcast 208	com/tencent/token/global/e
      //   1030: astore_1
      //   1031: aload_1
      //   1032: getfield 210	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1035: ifnull +13 -> 1048
      //   1038: aload_1
      //   1039: getfield 210	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1042: invokevirtual 114	java/lang/String:length	()I
      //   1045: ifne +14 -> 1059
      //   1048: aload_0
      //   1049: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1052: invokevirtual 119	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:getResources	()Landroid/content/res/Resources;
      //   1055: aload_1
      //   1056: invokestatic 213	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   1059: aload_1
      //   1060: getfield 305	com/tencent/token/global/e:a	I
      //   1063: sipush 146
      //   1066: if_icmpne +30 -> 1096
      //   1069: aload_0
      //   1070: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1073: invokestatic 308	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$500	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)I
      //   1076: iconst_4
      //   1077: if_icmpge +19 -> 1096
      //   1080: aload_0
      //   1081: aload_0
      //   1082: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1085: getfield 312	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:mSetModMobileRunnable	Ljava/lang/Runnable;
      //   1088: ldc2_w 313
      //   1091: invokevirtual 318	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:postDelayed	(Ljava/lang/Runnable;J)Z
      //   1094: pop
      //   1095: return
      //   1096: aload_0
      //   1097: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1100: invokevirtual 154	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:dismissDialog	()V
      //   1103: aload_0
      //   1104: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1107: ldc 115
      //   1109: aload_1
      //   1110: getfield 210	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1113: ldc 127
      //   1115: aconst_null
      //   1116: invokevirtual 131	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;)V
      //   1119: return
      //   1120: aload_1
      //   1121: getfield 206	android/os/Message:obj	Ljava/lang/Object;
      //   1124: checkcast 320	[B
      //   1127: checkcast 320	[B
      //   1130: astore_2
      //   1131: aload_1
      //   1132: getfield 95	android/os/Message:arg1	I
      //   1135: ifne +24 -> 1159
      //   1138: aload_2
      //   1139: ifnull +20 -> 1159
      //   1142: aload_2
      //   1143: arraylength
      //   1144: ifle +15 -> 1159
      //   1147: aload_0
      //   1148: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1151: aload_2
      //   1152: invokestatic 85	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
      //   1155: invokestatic 89	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$302	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;Ljava/lang/String;)Ljava/lang/String;
      //   1158: pop
      //   1159: aload_0
      //   1160: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1163: invokestatic 92	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   1166: return
      //   1167: aload_0
      //   1168: getfield 12	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity$3:a	Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;
      //   1171: invokestatic 92	com/tencent/token/ui/UtilsModSetMobileStep2SmsActivity:access$1100	(Lcom/tencent/token/ui/UtilsModSetMobileStep2SmsActivity;)V
      //   1174: return
      //   1175: astore_3
      //   1176: aconst_null
      //   1177: astore_1
      //   1178: goto -268 -> 910
      //   1181: astore_3
      //   1182: goto -272 -> 910
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1185	0	this	3
      //   0	1185	1	paramAnonymousMessage	Message
      //   111	1041	2	localObject1	Object
      //   745	129	3	localObject2	Object
      //   905	62	3	localJSONException1	org.json.JSONException
      //   984	31	3	localTextView	TextView
      //   1175	1	3	localJSONException2	org.json.JSONException
      //   1181	1	3	localJSONException3	org.json.JSONException
      //   771	235	4	localObject3	Object
      //   1	919	5	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   746	754	905	org/json/JSONException
      //   754	762	1175	org/json/JSONException
      //   762	770	1181	org/json/JSONException
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
      ca.a().a(0L, UtilsModSetMobileStep2SmsActivity.this.mOpType, UtilsModSetMobileStep2SmsActivity.this.mMobile, UtilsModSetMobileStep2SmsActivity.this.mCountryCode, UtilsModSetMobileStep2SmsActivity.this.mA2, UtilsModSetMobileStep2SmsActivity.this.mHandler);
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
    if (this.mUser != null) {
      this.mUin = this.mUser.mRealUin;
    }
    Bundle localBundle = getIntent().getExtras();
    if (localBundle == null)
    {
      finish();
      return;
    }
    if ((localBundle.getInt("op_type", 0) == 0) || (localBundle.getString("title") == null) || (localBundle.getString("mobile") == null))
    {
      finish();
      return;
    }
    this.mPageId = localBundle.getInt("page_id");
    this.mOpType = localBundle.getInt("op_type", 0);
    this.mMobile = localBundle.getString("mobile");
    this.mTitle = localBundle.getString("title");
    this.mCountryCode = localBundle.getString("area_code");
    setTitle(this.mTitle);
    g.c("test mbinfo, positon=, optype=" + this.mOpType + ", mobile=" + this.mMobile + ", area_code=" + this.mCountryCode + ",title=" + this.mTitle);
    this.mStep2BindBtn = ((Button)findViewById(2131558731));
    this.mStep2BindBtn.setOnClickListener(this);
    findViewById(2131558732).setOnClickListener(this);
    ((TextView)findViewById(2131558729)).setText(this.mMobile);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131231509, paramString, 2131230897, new DialogInterface.OnClickListener()new DialogInterface.OnCancelListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    }, new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    boolean bool = true;
    for (;;)
    {
      try
      {
        if ((this.mIsModSetSucc) && (paramKeyEvent.getAction() == 0)) {}
        switch (paramKeyEvent.getKeyCode())
        {
        case 4: 
          bool = super.dispatchKeyEvent(paramKeyEvent);
          return bool;
        }
      }
      catch (Exception paramKeyEvent)
      {
        paramKeyEvent.printStackTrace();
        g.d("dispatchKeyEvent exception " + this + paramKeyEvent.toString());
        return true;
      }
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.mHandler.sendEmptyMessage(3);
    startTimeTask();
    g.b("startTimeTask onActivityResult");
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131558731: 
      this.isCurrentMobile = true;
      ca.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
      showProDialog(this, 2131230843, getResources().getString(2131231585) + this.mTitle + getResources().getString(2131231586), null);
      return;
    case 2131558732: 
      this.isCurrentMobile = false;
      ca.a().a(this.mMobile, 0L, 0, 2, this.mCountryCode, this.mHandler);
      showProDialog(this, 2131230843, getResources().getString(2131231585) + this.mTitle + getResources().getString(2131231586), null);
      return;
    }
    if (this.mOpType == 3)
    {
      paramView = new Intent(this, MyMbSubPageActivity.class);
      paramView.addFlags(67108864);
      startActivity(paramView);
    }
    for (;;)
    {
      finish();
      return;
      if (this.mPageId == 10)
      {
        paramView = new Intent(this, IndexActivity.class);
        paramView.putExtra("index_from", 16);
        startActivity(paramView);
      }
      else if (this.mPageId == 14)
      {
        paramView = new Intent(this, MyMbSubPageActivity.class);
        paramView.putExtra("page_id", this.mPageId);
        paramView.addFlags(67108864);
        startActivity(paramView);
      }
      else if (this.mPageId == 17)
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968808);
    this.mUser = cq.a().e();
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
    cb.c().a.a(this.mHandler);
  }
  
  public void onStop()
  {
    super.onStop();
    cb.c().a.a(null);
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
      paramString1 = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + paramString1));
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
    showProDialog(this, 2131231657, 2131230804, new View.OnClickListener()
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