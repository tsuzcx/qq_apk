package com.tencent.token.ui;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.ajr;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.su;
import com.tencent.token.tt;
import com.tencent.token.wg;
import com.tencent.token.xv;
import com.tencent.token.zi;

public class SmsContentTipActivity
  extends BaseActivity
  implements Runnable
{
  private View btnLayout;
  private TextView errorTip;
  private boolean isReadyModSetMB = false;
  private String mA2 = "";
  private int mBindRetryTimes = 0;
  Runnable mBindRunnable = new Runnable()
  {
    public final void run()
    {
      if (!SmsContentTipActivity.this.mIsTimeTask) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("send bind seq request:");
      localStringBuilder.append(SmsContentTipActivity.this.mBindRetryTimes);
      xv.a(localStringBuilder.toString());
      int i;
      if (SmsContentTipActivity.this.mVerifyType != null) {
        i = SmsContentTipActivity.this.mVerifyType.verifyTypeId;
      } else {
        i = 0;
      }
      su.a().a(0L, Long.parseLong(SmsContentTipActivity.this.mUin), SmsContentTipActivity.this.mSceneId, i, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$108(SmsContentTipActivity.this);
    }
  };
  private String mCountryCode;
  private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener()
  {
    public final void onCancel(DialogInterface paramAnonymousDialogInterface)
    {
      SmsContentTipActivity.this.unbindResult();
    }
  };
  private DialogInterface.OnClickListener mDialogFinishListener = new DialogInterface.OnClickListener()
  {
    public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      SmsContentTipActivity.this.dismissDialog();
    }
  };
  @SuppressLint({"HandlerLeak"})
  Handler mHandler = new Handler()
  {
    /* Error */
    public final void handleMessage(Message paramAnonymousMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   4: ifnull +2222 -> 2226
      //   7: aload_0
      //   8: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   11: ifnull +14 -> 25
      //   14: aload_0
      //   15: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   18: invokevirtual 28	com/tencent/token/ui/SmsContentTipActivity:isFinishing	()Z
      //   21: ifeq +4 -> 25
      //   24: return
      //   25: new 30	java/lang/StringBuilder
      //   28: dup
      //   29: ldc 32
      //   31: invokespecial 35	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   34: astore 5
      //   36: aload 5
      //   38: aload_1
      //   39: getfield 41	android/os/Message:what	I
      //   42: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   45: pop
      //   46: aload 5
      //   48: ldc 47
      //   50: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   53: pop
      //   54: aload 5
      //   56: aload_0
      //   57: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   60: invokestatic 54	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   63: invokevirtual 57	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   66: pop
      //   67: aload 5
      //   69: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   72: invokestatic 66	com/tencent/token/xv:c	(Ljava/lang/String;)V
      //   75: aload_1
      //   76: getfield 41	android/os/Message:what	I
      //   79: lookupswitch	default:+2154->2233, 3:+1828->1907, 4:+1803->1882, 9:+1689->1768, 10:+1661->1740, 13:+1625->1704, 15:+1566->1645, 3012:+1039->1118, 3026:+890->969, 3068:+407->486, 4001:+180->259, 4004:+890->969, 4097:+129->208, 4098:+129->208, 4104:+121->200
      //   201: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   204: invokestatic 69	com/tencent/token/ui/SmsContentTipActivity:access$1300	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   207: return
      //   208: aload_1
      //   209: getfield 73	android/os/Message:obj	Ljava/lang/Object;
      //   212: checkcast 75	[B
      //   215: checkcast 75	[B
      //   218: astore 5
      //   220: aload_1
      //   221: getfield 78	android/os/Message:arg1	I
      //   224: ifne +27 -> 251
      //   227: aload 5
      //   229: ifnull +22 -> 251
      //   232: aload 5
      //   234: arraylength
      //   235: ifle +16 -> 251
      //   238: aload_0
      //   239: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   242: aload 5
      //   244: invokestatic 83	com/tencent/token/aay:a	([B)Ljava/lang/String;
      //   247: invokestatic 87	com/tencent/token/ui/SmsContentTipActivity:access$802	(Lcom/tencent/token/ui/SmsContentTipActivity;Ljava/lang/String;)Ljava/lang/String;
      //   250: pop
      //   251: aload_0
      //   252: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   255: invokestatic 69	com/tencent/token/ui/SmsContentTipActivity:access$1300	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   258: return
      //   259: aload_0
      //   260: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   263: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   266: aload_0
      //   267: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   270: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   273: aload_0
      //   274: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   277: invokestatic 96	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   280: aload_1
      //   281: getfield 78	android/os/Message:arg1	I
      //   284: ifne +171 -> 455
      //   287: aload_0
      //   288: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   291: iconst_1
      //   292: invokestatic 100	com/tencent/token/ui/SmsContentTipActivity:access$2102	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   295: pop
      //   296: invokestatic 105	com/tencent/token/tt:a	()Lcom/tencent/token/tt;
      //   299: aload_0
      //   300: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   303: invokestatic 109	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   306: invokevirtual 112	com/tencent/token/tt:a	(Lcom/tencent/token/core/bean/QQUser;)Z
      //   309: pop
      //   310: invokestatic 105	com/tencent/token/tt:a	()Lcom/tencent/token/tt;
      //   313: invokevirtual 115	com/tencent/token/tt:h	()V
      //   316: invokestatic 105	com/tencent/token/tt:a	()Lcom/tencent/token/tt;
      //   319: pop
      //   320: invokestatic 118	com/tencent/token/tt:b	()V
      //   323: invokestatic 123	com/tencent/token/tx:a	()Lcom/tencent/token/tx;
      //   326: getfield 127	com/tencent/token/tx:f	Lcom/tencent/token/abi;
      //   329: aload_0
      //   330: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   333: invokestatic 109	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   336: getfield 133	com/tencent/token/core/bean/QQUser:mUin	J
      //   339: invokevirtual 138	com/tencent/token/abi:a	(J)V
      //   342: invokestatic 143	com/tencent/token/tv:a	()Lcom/tencent/token/tv;
      //   345: getfield 144	com/tencent/token/tv:f	Lcom/tencent/token/abi;
      //   348: aload_0
      //   349: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   352: invokestatic 109	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   355: getfield 133	com/tencent/token/core/bean/QQUser:mUin	J
      //   358: invokevirtual 138	com/tencent/token/abi:a	(J)V
      //   361: iconst_1
      //   362: putstatic 150	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   365: aload_0
      //   366: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   369: astore_1
      //   370: new 30	java/lang/StringBuilder
      //   373: dup
      //   374: invokespecial 151	java/lang/StringBuilder:<init>	()V
      //   377: astore 5
      //   379: aload 5
      //   381: aload_0
      //   382: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   385: ldc 152
      //   387: invokevirtual 156	com/tencent/token/ui/SmsContentTipActivity:getString	(I)Ljava/lang/String;
      //   390: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   393: pop
      //   394: aload 5
      //   396: aload_0
      //   397: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   400: invokestatic 109	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   403: getfield 159	com/tencent/token/core/bean/QQUser:mRealUin	J
      //   406: invokestatic 164	java/lang/Long:toString	(J)Ljava/lang/String;
      //   409: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   412: pop
      //   413: aload 5
      //   415: aload_0
      //   416: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   419: ldc 165
      //   421: invokevirtual 156	com/tencent/token/ui/SmsContentTipActivity:getString	(I)Ljava/lang/String;
      //   424: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   427: pop
      //   428: aload_1
      //   429: iconst_0
      //   430: aload 5
      //   432: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   435: ldc 166
      //   437: aload_0
      //   438: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   441: invokestatic 170	com/tencent/token/ui/SmsContentTipActivity:access$2200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/content/DialogInterface$OnClickListener;
      //   444: aload_0
      //   445: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   448: invokestatic 174	com/tencent/token/ui/SmsContentTipActivity:access$2300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/content/DialogInterface$OnCancelListener;
      //   451: invokevirtual 178	com/tencent/token/ui/SmsContentTipActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;)V
      //   454: return
      //   455: aload_1
      //   456: getfield 73	android/os/Message:obj	Ljava/lang/Object;
      //   459: checkcast 180	com/tencent/token/xt
      //   462: astore_1
      //   463: aload_0
      //   464: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   467: invokevirtual 184	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   470: aload_1
      //   471: invokestatic 187	com/tencent/token/xt:a	(Landroid/content/res/Resources;Lcom/tencent/token/xt;)V
      //   474: aload_0
      //   475: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   478: aload_1
      //   479: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   482: invokestatic 194	com/tencent/token/ui/SmsContentTipActivity:access$2400	(Lcom/tencent/token/ui/SmsContentTipActivity;Ljava/lang/String;)V
      //   485: return
      //   486: aload_1
      //   487: getfield 78	android/os/Message:arg1	I
      //   490: ifne +312 -> 802
      //   493: aload_0
      //   494: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   497: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   500: ifne +42 -> 542
      //   503: invokestatic 203	com/tencent/token/su:a	()Lcom/tencent/token/su;
      //   506: aload_0
      //   507: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   510: invokestatic 207	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   513: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   516: aload_0
      //   517: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   520: invokestatic 215	com/tencent/token/ui/SmsContentTipActivity:access$1700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/UpgradeDeterminResult;
      //   523: getfield 220	com/tencent/token/core/bean/UpgradeDeterminResult:bindType	I
      //   526: ldc 222
      //   528: ldc 222
      //   530: aload_0
      //   531: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   534: getfield 226	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   537: invokevirtual 229	com/tencent/token/su:c	(JILjava/lang/String;Ljava/lang/String;Landroid/os/Handler;)I
      //   540: pop
      //   541: return
      //   542: aload_0
      //   543: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   546: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   549: bipush 6
      //   551: if_icmpne +39 -> 590
      //   554: invokestatic 203	com/tencent/token/su:a	()Lcom/tencent/token/su;
      //   557: astore_1
      //   558: aload_0
      //   559: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   562: invokestatic 109	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   565: pop
      //   566: aload_1
      //   567: aload_0
      //   568: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   571: invokestatic 109	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   574: getfield 159	com/tencent/token/core/bean/QQUser:mRealUin	J
      //   577: iconst_1
      //   578: aload_0
      //   579: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   582: getfield 226	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   585: invokevirtual 232	com/tencent/token/su:a	(JILandroid/os/Handler;)I
      //   588: pop
      //   589: return
      //   590: aload_0
      //   591: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   594: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   597: bipush 7
      //   599: if_icmpne +48 -> 647
      //   602: new 234	android/content/Intent
      //   605: dup
      //   606: aload_0
      //   607: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   610: ldc 236
      //   612: invokespecial 239	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   615: astore_1
      //   616: aload_1
      //   617: ldc 241
      //   619: iconst_1
      //   620: invokevirtual 245	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
      //   623: pop
      //   624: aload_1
      //   625: ldc 246
      //   627: invokevirtual 250	android/content/Intent:setFlags	(I)Landroid/content/Intent;
      //   630: pop
      //   631: aload_0
      //   632: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   635: aload_1
      //   636: invokevirtual 254	com/tencent/token/ui/SmsContentTipActivity:startActivity	(Landroid/content/Intent;)V
      //   639: aload_0
      //   640: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   643: invokevirtual 257	com/tencent/token/ui/SmsContentTipActivity:finish	()V
      //   646: return
      //   647: aload_0
      //   648: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   651: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   654: bipush 8
      //   656: if_icmpne +1569 -> 2225
      //   659: aload_0
      //   660: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   663: invokestatic 261	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   666: aload_0
      //   667: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   670: invokestatic 264	com/tencent/token/ui/SmsContentTipActivity:access$1800	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   673: invokestatic 270	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   676: invokevirtual 275	com/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem:a	(Ljava/lang/Integer;)Z
      //   679: ifne +53 -> 732
      //   682: invokestatic 280	com/tencent/token/zi:a	()Lcom/tencent/token/zi;
      //   685: aload_0
      //   686: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   689: aload_0
      //   690: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   693: invokestatic 284	com/tencent/token/ui/SmsContentTipActivity:access$1900	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult;
      //   696: aload_0
      //   697: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   700: invokestatic 261	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   703: aload_0
      //   704: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   707: invokestatic 261	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   710: aload_0
      //   711: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   714: invokestatic 264	com/tencent/token/ui/SmsContentTipActivity:access$1800	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   717: invokevirtual 287	com/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem:a	(I)I
      //   720: iconst_0
      //   721: aload_0
      //   722: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   725: getfield 226	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   728: invokevirtual 290	com/tencent/token/zi:a	(Landroid/app/Activity;Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult;Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;IZLandroid/os/Handler;)V
      //   731: return
      //   732: aload_0
      //   733: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   736: invokestatic 284	com/tencent/token/ui/SmsContentTipActivity:access$1900	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult;
      //   739: invokevirtual 294	com/tencent/token/core/bean/DeterminVerifyFactorsResult:b	()Z
      //   742: ifeq +52 -> 794
      //   745: invokestatic 203	com/tencent/token/su:a	()Lcom/tencent/token/su;
      //   748: aload_0
      //   749: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   752: invokestatic 297	com/tencent/token/ui/SmsContentTipActivity:access$2000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   755: getfield 159	com/tencent/token/core/bean/QQUser:mRealUin	J
      //   758: aload_0
      //   759: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   762: invokestatic 261	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   765: getfield 300	com/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem:verifyTypeId	I
      //   768: aload_0
      //   769: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   772: invokestatic 303	com/tencent/token/ui/SmsContentTipActivity:access$600	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   775: aload_0
      //   776: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   779: invokestatic 306	com/tencent/token/ui/SmsContentTipActivity:access$700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   782: aload_0
      //   783: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   786: getfield 226	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   789: invokevirtual 308	com/tencent/token/su:b	(JILjava/lang/String;Ljava/lang/String;Landroid/os/Handler;)I
      //   792: pop
      //   793: return
      //   794: aload_0
      //   795: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   798: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   801: return
      //   802: aload_1
      //   803: getfield 73	android/os/Message:obj	Ljava/lang/Object;
      //   806: checkcast 180	com/tencent/token/xt
      //   809: astore_1
      //   810: aload_0
      //   811: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   814: invokevirtual 184	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   817: aload_1
      //   818: invokestatic 187	com/tencent/token/xt:a	(Landroid/content/res/Resources;Lcom/tencent/token/xt;)V
      //   821: aload_0
      //   822: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   825: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   828: ifeq +15 -> 843
      //   831: aload_0
      //   832: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   835: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   838: bipush 8
      //   840: if_icmpne +40 -> 880
      //   843: aload_1
      //   844: getfield 310	com/tencent/token/xt:a	I
      //   847: sipush 146
      //   850: if_icmpne +30 -> 880
      //   853: aload_0
      //   854: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   857: invokestatic 313	com/tencent/token/ui/SmsContentTipActivity:access$100	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   860: iconst_4
      //   861: if_icmpge +19 -> 880
      //   864: aload_0
      //   865: aload_0
      //   866: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   869: getfield 317	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   872: ldc2_w 318
      //   875: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   878: pop
      //   879: return
      //   880: aload_0
      //   881: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   884: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   887: bipush 6
      //   889: if_icmpne +40 -> 929
      //   892: aload_1
      //   893: getfield 310	com/tencent/token/xt:a	I
      //   896: sipush 146
      //   899: if_icmpne +30 -> 929
      //   902: aload_0
      //   903: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   906: invokestatic 326	com/tencent/token/ui/SmsContentTipActivity:access$1000	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   909: iconst_4
      //   910: if_icmpge +19 -> 929
      //   913: aload_0
      //   914: aload_0
      //   915: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   918: getfield 329	com/tencent/token/ui/SmsContentTipActivity:mUnBindRunnable	Ljava/lang/Runnable;
      //   921: ldc2_w 318
      //   924: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   927: pop
      //   928: return
      //   929: aload_0
      //   930: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   933: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   936: aload_0
      //   937: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   940: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   943: iconst_0
      //   944: invokevirtual 339	android/widget/TextView:setVisibility	(I)V
      //   947: aload_0
      //   948: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   951: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   954: aload_1
      //   955: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   958: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   961: aload_0
      //   962: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   965: invokestatic 96	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   968: return
      //   969: aload_0
      //   970: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   973: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   976: aload_0
      //   977: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   980: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   983: aload_1
      //   984: getfield 78	android/os/Message:arg1	I
      //   987: ifne +11 -> 998
      //   990: aload_0
      //   991: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   994: invokestatic 346	com/tencent/token/ui/SmsContentTipActivity:access$1400	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   997: return
      //   998: aload_1
      //   999: getfield 73	android/os/Message:obj	Ljava/lang/Object;
      //   1002: checkcast 180	com/tencent/token/xt
      //   1005: astore_1
      //   1006: aload_0
      //   1007: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1010: invokevirtual 184	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   1013: aload_1
      //   1014: invokestatic 187	com/tencent/token/xt:a	(Landroid/content/res/Resources;Lcom/tencent/token/xt;)V
      //   1017: new 30	java/lang/StringBuilder
      //   1020: dup
      //   1021: ldc_w 348
      //   1024: invokespecial 35	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   1027: astore 5
      //   1029: aload 5
      //   1031: aload_1
      //   1032: getfield 310	com/tencent/token/xt:a	I
      //   1035: invokevirtual 45	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1038: pop
      //   1039: aload 5
      //   1041: ldc_w 350
      //   1044: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1047: pop
      //   1048: aload 5
      //   1050: aload_1
      //   1051: getfield 352	com/tencent/token/xt:b	Ljava/lang/String;
      //   1054: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1057: pop
      //   1058: aload 5
      //   1060: ldc_w 350
      //   1063: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1066: pop
      //   1067: aload 5
      //   1069: aload_1
      //   1070: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   1073: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1076: pop
      //   1077: aload 5
      //   1079: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1082: invokestatic 66	com/tencent/token/xv:c	(Ljava/lang/String;)V
      //   1085: aload_0
      //   1086: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1089: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1092: iconst_0
      //   1093: invokevirtual 339	android/widget/TextView:setVisibility	(I)V
      //   1096: aload_0
      //   1097: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1100: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1103: aload_1
      //   1104: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   1107: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1110: aload_0
      //   1111: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1114: invokestatic 96	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1117: return
      //   1118: aload_0
      //   1119: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1122: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1125: aload_0
      //   1126: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1129: iconst_0
      //   1130: invokestatic 355	com/tencent/token/ui/SmsContentTipActivity:access$2502	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   1133: pop
      //   1134: aload_1
      //   1135: getfield 78	android/os/Message:arg1	I
      //   1138: ifne +392 -> 1530
      //   1141: aload_0
      //   1142: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1145: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1148: aload_0
      //   1149: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1152: ldc_w 356
      //   1155: invokevirtual 359	com/tencent/token/ui/SmsContentTipActivity:setContentView	(I)V
      //   1158: aload_0
      //   1159: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1162: getfield 363	com/tencent/token/ui/SmsContentTipActivity:mBackArrow	Landroid/view/View;
      //   1165: iconst_4
      //   1166: invokevirtual 366	android/view/View:setVisibility	(I)V
      //   1169: aload_0
      //   1170: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1173: iconst_1
      //   1174: invokestatic 369	com/tencent/token/ui/SmsContentTipActivity:access$2602	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   1177: pop
      //   1178: aload_0
      //   1179: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1182: invokestatic 372	com/tencent/token/ui/SmsContentTipActivity:access$2700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   1185: ifnull +30 -> 1215
      //   1188: aload_0
      //   1189: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1192: invokestatic 372	com/tencent/token/ui/SmsContentTipActivity:access$2700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   1195: invokevirtual 378	java/lang/String:length	()I
      //   1198: ifle +17 -> 1215
      //   1201: aload_0
      //   1202: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1205: aload_0
      //   1206: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1209: invokestatic 372	com/tencent/token/ui/SmsContentTipActivity:access$2700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   1212: invokevirtual 381	com/tencent/token/ui/SmsContentTipActivity:setTitle	(Ljava/lang/CharSequence;)V
      //   1215: aload_1
      //   1216: getfield 73	android/os/Message:obj	Ljava/lang/Object;
      //   1219: checkcast 383	org/json/JSONObject
      //   1222: astore 6
      //   1224: aconst_null
      //   1225: astore 7
      //   1227: aload 6
      //   1229: ldc_w 385
      //   1232: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1235: astore 5
      //   1237: aload 6
      //   1239: ldc_w 390
      //   1242: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1245: astore_1
      //   1246: aload 6
      //   1248: ldc_w 392
      //   1251: invokevirtual 388	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1254: astore 6
      //   1256: goto +32 -> 1288
      //   1259: astore 6
      //   1261: goto +18 -> 1279
      //   1264: astore 6
      //   1266: aconst_null
      //   1267: astore_1
      //   1268: goto +11 -> 1279
      //   1271: astore 6
      //   1273: aconst_null
      //   1274: astore 5
      //   1276: aload 5
      //   1278: astore_1
      //   1279: aload 6
      //   1281: invokevirtual 395	org/json/JSONException:printStackTrace	()V
      //   1284: aload 7
      //   1286: astore 6
      //   1288: aload 5
      //   1290: ifnull +39 -> 1329
      //   1293: aload 5
      //   1295: invokevirtual 378	java/lang/String:length	()I
      //   1298: ifle +31 -> 1329
      //   1301: aload_0
      //   1302: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1305: ldc_w 396
      //   1308: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1311: checkcast 335	android/widget/TextView
      //   1314: astore 7
      //   1316: aload 7
      //   1318: aload 5
      //   1320: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1323: aload 7
      //   1325: iconst_0
      //   1326: invokevirtual 339	android/widget/TextView:setVisibility	(I)V
      //   1329: aload_0
      //   1330: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1333: ldc_w 401
      //   1336: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1339: new 8	com/tencent/token/ui/SmsContentTipActivity$4$1
      //   1342: dup
      //   1343: aload_0
      //   1344: invokespecial 404	com/tencent/token/ui/SmsContentTipActivity$4$1:<init>	(Lcom/tencent/token/ui/SmsContentTipActivity$4;)V
      //   1347: invokevirtual 408	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   1350: aload_0
      //   1351: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1354: ldc_w 409
      //   1357: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1360: astore 5
      //   1362: aload_0
      //   1363: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1366: invokestatic 412	com/tencent/token/ui/SmsContentTipActivity:access$500	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1369: iconst_1
      //   1370: if_icmpne +47 -> 1417
      //   1373: aload_0
      //   1374: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1377: ldc_w 413
      //   1380: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1383: checkcast 335	android/widget/TextView
      //   1386: ldc_w 414
      //   1389: invokevirtual 416	android/widget/TextView:setText	(I)V
      //   1392: aload 5
      //   1394: bipush 8
      //   1396: invokevirtual 366	android/view/View:setVisibility	(I)V
      //   1399: aload_0
      //   1400: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1403: ldc_w 396
      //   1406: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1409: bipush 8
      //   1411: invokevirtual 366	android/view/View:setVisibility	(I)V
      //   1414: goto +105 -> 1519
      //   1417: aload_0
      //   1418: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1421: ldc_w 413
      //   1424: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1427: checkcast 335	android/widget/TextView
      //   1430: ldc_w 417
      //   1433: invokevirtual 416	android/widget/TextView:setText	(I)V
      //   1436: aload_1
      //   1437: ifnull +75 -> 1512
      //   1440: aload 6
      //   1442: ifnull +70 -> 1512
      //   1445: aload_1
      //   1446: invokevirtual 378	java/lang/String:length	()I
      //   1449: ifle +63 -> 1512
      //   1452: aload 6
      //   1454: invokevirtual 378	java/lang/String:length	()I
      //   1457: ifle +55 -> 1512
      //   1460: aload 5
      //   1462: iconst_0
      //   1463: invokevirtual 366	android/view/View:setVisibility	(I)V
      //   1466: aload_0
      //   1467: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1470: ldc_w 418
      //   1473: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1476: checkcast 335	android/widget/TextView
      //   1479: astore 5
      //   1481: aload_0
      //   1482: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1485: ldc_w 419
      //   1488: invokevirtual 400	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1491: checkcast 335	android/widget/TextView
      //   1494: astore 7
      //   1496: aload 5
      //   1498: aload_1
      //   1499: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1502: aload 7
      //   1504: aload 6
      //   1506: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1509: goto +10 -> 1519
      //   1512: aload 5
      //   1514: bipush 8
      //   1516: invokevirtual 366	android/view/View:setVisibility	(I)V
      //   1519: invokestatic 424	com/tencent/token/abh:a	()Lcom/tencent/token/abh;
      //   1522: invokevirtual 425	com/tencent/token/abh:b	()V
      //   1525: iconst_1
      //   1526: putstatic 150	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   1529: return
      //   1530: aload_1
      //   1531: getfield 73	android/os/Message:obj	Ljava/lang/Object;
      //   1534: checkcast 180	com/tencent/token/xt
      //   1537: astore_1
      //   1538: aload_1
      //   1539: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   1542: ifnull +13 -> 1555
      //   1545: aload_1
      //   1546: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   1549: invokevirtual 378	java/lang/String:length	()I
      //   1552: ifne +14 -> 1566
      //   1555: aload_0
      //   1556: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1559: invokevirtual 184	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   1562: aload_1
      //   1563: invokestatic 187	com/tencent/token/xt:a	(Landroid/content/res/Resources;Lcom/tencent/token/xt;)V
      //   1566: aload_1
      //   1567: getfield 310	com/tencent/token/xt:a	I
      //   1570: sipush 146
      //   1573: if_icmpne +39 -> 1612
      //   1576: aload_0
      //   1577: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1580: invokestatic 428	com/tencent/token/ui/SmsContentTipActivity:access$900	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1583: iconst_4
      //   1584: if_icmpge +28 -> 1612
      //   1587: aload_0
      //   1588: aload_0
      //   1589: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1592: getfield 431	com/tencent/token/ui/SmsContentTipActivity:mSetModMobileRunnable	Ljava/lang/Runnable;
      //   1595: ldc2_w 318
      //   1598: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   1601: pop
      //   1602: aload_0
      //   1603: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1606: iconst_1
      //   1607: invokestatic 355	com/tencent/token/ui/SmsContentTipActivity:access$2502	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   1610: pop
      //   1611: return
      //   1612: aload_0
      //   1613: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1616: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1619: iconst_0
      //   1620: invokevirtual 339	android/widget/TextView:setVisibility	(I)V
      //   1623: aload_0
      //   1624: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1627: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1630: aload_1
      //   1631: getfield 190	com/tencent/token/xt:c	Ljava/lang/String;
      //   1634: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1637: aload_0
      //   1638: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1641: invokestatic 96	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1644: return
      //   1645: aload_0
      //   1646: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1649: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1652: ldc_w 433
      //   1655: invokestatic 66	com/tencent/token/xv:c	(Ljava/lang/String;)V
      //   1658: aload_0
      //   1659: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1662: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1665: aload_0
      //   1666: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1669: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1672: iconst_0
      //   1673: invokevirtual 339	android/widget/TextView:setVisibility	(I)V
      //   1676: aload_0
      //   1677: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1680: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1683: aload_0
      //   1684: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1687: ldc_w 434
      //   1690: invokevirtual 156	com/tencent/token/ui/SmsContentTipActivity:getString	(I)Ljava/lang/String;
      //   1693: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1696: aload_0
      //   1697: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1700: invokestatic 96	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1703: return
      //   1704: aload_1
      //   1705: invokevirtual 438	android/os/Message:getData	()Landroid/os/Bundle;
      //   1708: ldc_w 440
      //   1711: invokevirtual 446	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   1714: istore_2
      //   1715: invokestatic 452	java/lang/System:currentTimeMillis	()J
      //   1718: lstore_3
      //   1719: ldc_w 454
      //   1722: iload_2
      //   1723: i2l
      //   1724: ldc2_w 455
      //   1727: lmul
      //   1728: lload_3
      //   1729: lsub
      //   1730: invokestatic 458	java/lang/String:valueOf	(J)Ljava/lang/String;
      //   1733: invokevirtual 461	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   1736: invokestatic 463	com/tencent/token/xv:b	(Ljava/lang/String;)V
      //   1739: return
      //   1740: aload_0
      //   1741: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1744: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1747: ldc_w 465
      //   1750: invokestatic 66	com/tencent/token/xv:c	(Ljava/lang/String;)V
      //   1753: aload_0
      //   1754: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1757: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1760: aload_0
      //   1761: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1764: invokestatic 346	com/tencent/token/ui/SmsContentTipActivity:access$1400	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1767: return
      //   1768: aload_0
      //   1769: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1772: invokestatic 54	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   1775: ifne +4 -> 1779
      //   1778: return
      //   1779: aload_1
      //   1780: invokevirtual 438	android/os/Message:getData	()Landroid/os/Bundle;
      //   1783: astore_1
      //   1784: aload_1
      //   1785: ldc_w 467
      //   1788: invokevirtual 446	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   1791: istore_2
      //   1792: aload_1
      //   1793: ldc_w 469
      //   1796: invokevirtual 470	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1799: astore_1
      //   1800: iconst_1
      //   1801: iload_2
      //   1802: if_icmpne +30 -> 1832
      //   1805: aload_0
      //   1806: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1809: invokestatic 313	com/tencent/token/ui/SmsContentTipActivity:access$100	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1812: iconst_4
      //   1813: if_icmpge +19 -> 1832
      //   1816: aload_0
      //   1817: aload_0
      //   1818: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1821: getfield 317	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   1824: ldc2_w 318
      //   1827: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   1830: pop
      //   1831: return
      //   1832: aload_0
      //   1833: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1836: invokevirtual 90	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1839: ldc_w 472
      //   1842: invokestatic 66	com/tencent/token/xv:c	(Ljava/lang/String;)V
      //   1845: aload_0
      //   1846: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1849: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1852: aload_0
      //   1853: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1856: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1859: iconst_0
      //   1860: invokevirtual 339	android/widget/TextView:setVisibility	(I)V
      //   1863: aload_0
      //   1864: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1867: invokestatic 333	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1870: aload_1
      //   1871: invokevirtual 343	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1874: aload_0
      //   1875: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1878: invokestatic 96	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1881: return
      //   1882: aload_0
      //   1883: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1886: invokestatic 54	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   1889: ifne +4 -> 1893
      //   1892: return
      //   1893: ldc_w 474
      //   1896: invokestatic 66	com/tencent/token/xv:c	(Ljava/lang/String;)V
      //   1899: aload_0
      //   1900: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1903: invokevirtual 93	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1906: return
      //   1907: aload_0
      //   1908: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1911: invokestatic 54	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   1914: ifne +4 -> 1918
      //   1917: return
      //   1918: aload_0
      //   1919: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1922: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1925: ifeq +275 -> 2200
      //   1928: aload_0
      //   1929: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1932: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1935: bipush 7
      //   1937: if_icmpne +6 -> 1943
      //   1940: goto +260 -> 2200
      //   1943: aload_0
      //   1944: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1947: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1950: iconst_3
      //   1951: if_icmpeq +91 -> 2042
      //   1954: aload_0
      //   1955: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1958: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1961: iconst_4
      //   1962: if_icmpne +6 -> 1968
      //   1965: goto +77 -> 2042
      //   1968: aload_0
      //   1969: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1972: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1975: bipush 6
      //   1977: if_icmpne +28 -> 2005
      //   1980: aload_0
      //   1981: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1984: iconst_0
      //   1985: invokestatic 478	com/tencent/token/ui/SmsContentTipActivity:access$1002	(Lcom/tencent/token/ui/SmsContentTipActivity;I)I
      //   1988: pop
      //   1989: aload_0
      //   1990: aload_0
      //   1991: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1994: getfield 329	com/tencent/token/ui/SmsContentTipActivity:mUnBindRunnable	Ljava/lang/Runnable;
      //   1997: ldc2_w 318
      //   2000: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   2003: pop
      //   2004: return
      //   2005: aload_0
      //   2006: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2009: invokestatic 198	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   2012: bipush 8
      //   2014: if_icmpne +211 -> 2225
      //   2017: aload_0
      //   2018: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2021: iconst_0
      //   2022: invokestatic 481	com/tencent/token/ui/SmsContentTipActivity:access$102	(Lcom/tencent/token/ui/SmsContentTipActivity;I)I
      //   2025: pop
      //   2026: aload_0
      //   2027: aload_0
      //   2028: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2031: getfield 317	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   2034: ldc2_w 318
      //   2037: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   2040: pop
      //   2041: return
      //   2042: invokestatic 487	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
      //   2045: invokestatic 492	com/tencent/token/ss:a	(Landroid/content/Context;)Lcom/tencent/token/ss;
      //   2048: astore_1
      //   2049: aload_1
      //   2050: aload_0
      //   2051: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2054: invokestatic 207	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   2057: invokestatic 211	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   2060: invokevirtual 495	com/tencent/token/ss:a	(J)[B
      //   2063: astore 5
      //   2065: ldc_w 497
      //   2068: aload 5
      //   2070: invokestatic 500	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
      //   2073: invokevirtual 461	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
      //   2076: invokestatic 502	com/tencent/token/xv:a	(Ljava/lang/String;)V
      //   2079: aload 5
      //   2081: ifnull +67 -> 2148
      //   2084: aload 5
      //   2086: arraylength
      //   2087: ifle +61 -> 2148
      //   2090: new 30	java/lang/StringBuilder
      //   2093: dup
      //   2094: invokespecial 151	java/lang/StringBuilder:<init>	()V
      //   2097: astore 6
      //   2099: aload 6
      //   2101: aload_0
      //   2102: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2105: invokestatic 207	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   2108: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2111: pop
      //   2112: aload_1
      //   2113: aload 6
      //   2115: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2118: ldc2_w 503
      //   2121: invokevirtual 507	com/tencent/token/ss:a	(Ljava/lang/String;J)Z
      //   2124: ifne +24 -> 2148
      //   2127: aload_0
      //   2128: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2131: aload 5
      //   2133: invokestatic 83	com/tencent/token/aay:a	([B)Ljava/lang/String;
      //   2136: invokestatic 87	com/tencent/token/ui/SmsContentTipActivity:access$802	(Lcom/tencent/token/ui/SmsContentTipActivity;Ljava/lang/String;)Ljava/lang/String;
      //   2139: pop
      //   2140: aload_0
      //   2141: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2144: invokestatic 69	com/tencent/token/ui/SmsContentTipActivity:access$1300	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   2147: return
      //   2148: invokestatic 487	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
      //   2151: invokestatic 492	com/tencent/token/ss:a	(Landroid/content/Context;)Lcom/tencent/token/ss;
      //   2154: astore_1
      //   2155: new 30	java/lang/StringBuilder
      //   2158: dup
      //   2159: invokespecial 151	java/lang/StringBuilder:<init>	()V
      //   2162: astore 5
      //   2164: aload 5
      //   2166: aload_0
      //   2167: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2170: invokestatic 207	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   2173: invokevirtual 50	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2176: pop
      //   2177: aload_1
      //   2178: aload 5
      //   2180: invokevirtual 61	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2183: aload_0
      //   2184: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2187: getfield 226	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   2190: ldc2_w 503
      //   2193: bipush 64
      //   2195: invokevirtual 510	com/tencent/token/ss:a	(Ljava/lang/String;Landroid/os/Handler;JI)I
      //   2198: pop
      //   2199: return
      //   2200: aload_0
      //   2201: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2204: iconst_0
      //   2205: invokestatic 481	com/tencent/token/ui/SmsContentTipActivity:access$102	(Lcom/tencent/token/ui/SmsContentTipActivity;I)I
      //   2208: pop
      //   2209: aload_0
      //   2210: aload_0
      //   2211: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2214: getfield 317	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   2217: ldc2_w 318
      //   2220: invokevirtual 323	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   2223: pop
      //   2224: return
      //   2225: return
      //   2226: return
      //   2227: astore_1
      //   2228: aload_1
      //   2229: invokevirtual 511	java/lang/Exception:printStackTrace	()V
      //   2232: return
      //   2233: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2234	0	this	4
      //   0	2234	1	paramAnonymousMessage	Message
      //   1714	89	2	i	int
      //   1718	11	3	l	long
      //   34	2145	5	localObject1	Object
      //   1222	33	6	localObject2	Object
      //   1259	1	6	localJSONException1	org.json.JSONException
      //   1264	1	6	localJSONException2	org.json.JSONException
      //   1271	9	6	localJSONException3	org.json.JSONException
      //   1286	828	6	localObject3	Object
      //   1225	278	7	localTextView	TextView
      // Exception table:
      //   from	to	target	type
      //   1246	1256	1259	org/json/JSONException
      //   1237	1246	1264	org/json/JSONException
      //   1227	1237	1271	org/json/JSONException
      //   0	24	2227	java/lang/Exception
      //   25	200	2227	java/lang/Exception
      //   200	207	2227	java/lang/Exception
      //   208	227	2227	java/lang/Exception
      //   232	251	2227	java/lang/Exception
      //   251	258	2227	java/lang/Exception
      //   259	454	2227	java/lang/Exception
      //   455	485	2227	java/lang/Exception
      //   486	541	2227	java/lang/Exception
      //   542	589	2227	java/lang/Exception
      //   590	646	2227	java/lang/Exception
      //   647	731	2227	java/lang/Exception
      //   732	793	2227	java/lang/Exception
      //   794	801	2227	java/lang/Exception
      //   802	843	2227	java/lang/Exception
      //   843	879	2227	java/lang/Exception
      //   880	928	2227	java/lang/Exception
      //   929	968	2227	java/lang/Exception
      //   969	997	2227	java/lang/Exception
      //   998	1117	2227	java/lang/Exception
      //   1118	1215	2227	java/lang/Exception
      //   1215	1224	2227	java/lang/Exception
      //   1227	1237	2227	java/lang/Exception
      //   1237	1246	2227	java/lang/Exception
      //   1246	1256	2227	java/lang/Exception
      //   1279	1284	2227	java/lang/Exception
      //   1293	1329	2227	java/lang/Exception
      //   1329	1414	2227	java/lang/Exception
      //   1417	1436	2227	java/lang/Exception
      //   1445	1509	2227	java/lang/Exception
      //   1512	1519	2227	java/lang/Exception
      //   1519	1529	2227	java/lang/Exception
      //   1530	1555	2227	java/lang/Exception
      //   1555	1566	2227	java/lang/Exception
      //   1566	1611	2227	java/lang/Exception
      //   1612	1644	2227	java/lang/Exception
      //   1645	1703	2227	java/lang/Exception
      //   1704	1739	2227	java/lang/Exception
      //   1740	1767	2227	java/lang/Exception
      //   1768	1778	2227	java/lang/Exception
      //   1779	1800	2227	java/lang/Exception
      //   1805	1831	2227	java/lang/Exception
      //   1832	1881	2227	java/lang/Exception
      //   1882	1892	2227	java/lang/Exception
      //   1893	1906	2227	java/lang/Exception
      //   1907	1917	2227	java/lang/Exception
      //   1918	1940	2227	java/lang/Exception
      //   1943	1965	2227	java/lang/Exception
      //   1968	2004	2227	java/lang/Exception
      //   2005	2041	2227	java/lang/Exception
      //   2042	2079	2227	java/lang/Exception
      //   2084	2147	2227	java/lang/Exception
      //   2148	2199	2227	java/lang/Exception
      //   2200	2224	2227	java/lang/Exception
    }
  };
  private boolean mIsActiveSuccess = false;
  private boolean mIsModSetSucc = false;
  private boolean mIsRunning = true;
  private boolean mIsTimeTask = false;
  private boolean mIsUnbindSuccess = false;
  private String mMobile;
  private int mOpType;
  private int mPageId;
  private ProgressBar mPb;
  private int mSceneId;
  Runnable mSetModMobileRunnable = new Runnable()
  {
    public final void run()
    {
      xv.c("send mod set mbmobile");
      su.a().a(0L, SmsContentTipActivity.this.mOpType, SmsContentTipActivity.this.mMobile, SmsContentTipActivity.this.mCountryCode, SmsContentTipActivity.this.mA2, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$908(SmsContentTipActivity.this);
    }
  };
  private int mSetRetryTimes = 0;
  private String mSmsPort;
  private long mTimeConter;
  private String mTitle;
  private String mUin;
  private int mUnBindRetryTimes = 0;
  Runnable mUnBindRunnable = new Runnable()
  {
    public final void run()
    {
      StringBuilder localStringBuilder = new StringBuilder("send unbind seq request:");
      localStringBuilder.append(SmsContentTipActivity.this.mUnBindRetryTimes);
      xv.a(localStringBuilder.toString());
      if (!SmsContentTipActivity.this.mIsTimeTask) {
        return;
      }
      su.a().a(SmsContentTipActivity.this.mUserToUnbind.mUin, SmsContentTipActivity.this.mUserToUnbind.mRealUin, 1005, 0, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$1008(SmsContentTipActivity.this);
    }
  };
  private UpgradeDeterminResult mUpDetermin = null;
  private QQUser mUser = null;
  private QQUser mUserToUnbind = null;
  private int mVerifyFactorId;
  private DeterminVerifyFactorsResult mVerifyResult;
  private DeterminVerifyFactorsResult.VerifyTypeItem mVerifyType;
  private TextView mobileNum;
  private TextView okText;
  private TextView smsContent;
  private int upSmsSceneId;
  private TextView useTip;
  private String useTipContent;
  
  private void displaySucc()
  {
    resetBtn();
    dismissDialog();
    Object localObject = tt.a().d(this.mUser.mRealUin);
    if (localObject != null) {
      tt.a().a((QQUser)localObject);
    }
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    DeterminVerifyFactorsResult localDeterminVerifyFactorsResult = this.mVerifyResult;
    if ((localDeterminVerifyFactorsResult != null) && (localDeterminVerifyFactorsResult.mScene == 2)) {
      ((Intent)localObject).putExtra("mSourceId", 1);
    }
    startActivity((Intent)localObject);
    finish();
  }
  
  private void gotoSetMobile()
  {
    this.mSetRetryTimes = 0;
    this.mHandler.postDelayed(this.mSetModMobileRunnable, 10000L);
    this.isReadyModSetMB = true;
  }
  
  private void initView()
  {
    this.useTip = ((TextView)findViewById(2131166257));
    this.smsContent = ((TextView)findViewById(2131166041));
    this.mobileNum = ((TextView)findViewById(2131165759));
    this.errorTip = ((TextView)findViewById(2131166139));
    this.okText = ((TextView)findViewById(2131166116));
    this.btnLayout = findViewById(2131165338);
    this.mPb = ((ProgressBar)findViewById(2131165828));
    int i = this.upSmsSceneId;
    if ((i != 0) && (i != 7))
    {
      if ((i != 3) && (i != 4))
      {
        if (i == 6) {
          this.useTipContent = String.format(getString(2131493680), new Object[] { this.mUserToUnbind.mMobileMask });
        } else if (i == 8) {
          this.useTipContent = String.format(getString(2131493680), new Object[] { this.mMobile });
        }
      }
      else {
        this.useTipContent = String.format(getString(2131493680), new Object[] { this.mMobile });
      }
    }
    else
    {
      String str = this.mUpDetermin.mMobileMask;
      if ((str == null) || (str.length() == 0)) {
        break label362;
      }
      this.useTipContent = String.format(getString(2131493680), new Object[] { this.mUpDetermin.mMobileMask });
    }
    if (this.upSmsSceneId == 8)
    {
      this.mobileNum.setText(this.mVerifyResult.mSMSChannel);
      this.smsContent.setText(this.mVerifyResult.mSMSContent);
    }
    else
    {
      this.mobileNum.setText(wg.d);
      this.smsContent.setText(wg.e);
    }
    this.useTip.setText(this.useTipContent);
    this.btnLayout.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        SmsContentTipActivity.this.mPb.setVisibility(0);
        SmsContentTipActivity.this.okText.setText(SmsContentTipActivity.this.getResources().getString(2131493274));
        SmsContentTipActivity.this.btnLayout.setClickable(false);
        SmsContentTipActivity.this.errorTip.setVisibility(4);
        if ((SmsContentTipActivity.this.upSmsSceneId == 0) || (SmsContentTipActivity.this.upSmsSceneId == 7))
        {
          SmsContentTipActivity.access$3202(SmsContentTipActivity.this, false);
          paramAnonymousView = SmsContentTipActivity.this;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(SmsContentTipActivity.this.mUser.mRealUin);
          SmsContentTipActivity.access$302(paramAnonymousView, localStringBuilder.toString());
        }
        SmsContentTipActivity.this.startTimeTask();
        SmsContentTipActivity.this.mHandler.sendEmptyMessage(3);
      }
    });
    return;
    label362:
    finish();
  }
  
  private void resetBtn()
  {
    this.mPb.setVisibility(4);
    this.okText.setText(getResources().getString(2131493266));
    this.btnLayout.setClickable(true);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131493664, paramString, 2131493041, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if (((this.mIsModSetSucc) || (this.mIsUnbindSuccess) || (this.mIsActiveSuccess)) && (paramKeyEvent.getAction() == 0)) {
        if (paramKeyEvent.getKeyCode() == 4) {
          break label156;
        }
      }
      if (this.isReadyModSetMB)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append("---isReadyModSetMB:");
        localStringBuilder.append(this.isReadyModSetMB);
        localStringBuilder.append("\n----removeCallbacks(mSetModMobileRunnable)");
        xv.c(localStringBuilder.toString());
        this.mHandler.removeCallbacks(this.mSetModMobileRunnable);
        this.isReadyModSetMB = false;
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
      xv.c(localStringBuilder.toString());
      return true;
    }
    label156:
    return true;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setNeverShowLockVerifyView();
    this.upSmsSceneId = getIntent().getIntExtra("up_sms_scene_id", -1);
    int i = this.upSmsSceneId;
    if ((i != 0) && (i != 7))
    {
      if ((i != 3) && (i != 4))
      {
        if (i == 6)
        {
          this.mUserToUnbind = ((QQUser)getIntent().getSerializableExtra("user_to_unbind"));
          if (this.mUserToUnbind == null) {
            finish();
          }
        }
        else if (i == 8)
        {
          this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
          this.mVerifyResult = ((DeterminVerifyFactorsResult)getIntent().getSerializableExtra("intent.determin_factors_result"));
          this.mVerifyType = ((DeterminVerifyFactorsResult.VerifyTypeItem)getIntent().getSerializableExtra("intent.determin_verify_type"));
          this.mVerifyFactorId = getIntent().getIntExtra("intent.determin_verify_factor_id", -1);
          if (this.mUser != null)
          {
            paramBundle = this.mVerifyResult;
            if (paramBundle != null)
            {
              if ((paramBundle != null) && (paramBundle.mScene == 2)) {
                setNeverShowLockVerifyView();
              }
              this.mSceneId = 1007;
              this.mMobile = this.mVerifyResult.mMobileMask;
              paramBundle = new StringBuilder();
              paramBundle.append(this.mUser.mRealUin);
              this.mUin = paramBundle.toString();
              this.mSmsPort = this.mVerifyResult.mSMSChannel;
              this.mCountryCode = "+86";
              break label466;
            }
          }
          finish();
        }
      }
      else
      {
        this.mMobile = getIntent().getStringExtra("mobile");
        this.mSmsPort = getIntent().getStringExtra("sms_port");
        this.mCountryCode = getIntent().getStringExtra("area_code");
        this.mOpType = getIntent().getIntExtra("op_type", 1);
        this.mPageId = getIntent().getIntExtra("page_id", 10);
        this.mUser = tt.a().k.b();
        if (this.mUser == null)
        {
          finish();
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append(this.mUser.mRealUin);
        this.mUin = paramBundle.toString();
      }
    }
    else
    {
      this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
      this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
      this.mSceneId = getIntent().getIntExtra("scene_id", 1004);
      if ((this.mUser == null) || (this.mUpDetermin == null)) {
        break label547;
      }
    }
    label466:
    setContentView(2131296459);
    initView();
    new Thread(this).start();
    if ((getIntent() != null) && (getIntent().getStringExtra("title") != null) && (getIntent().getStringExtra("title").length() > 0))
    {
      this.mTitle = getIntent().getStringExtra("title");
      setTitle(this.mTitle);
    }
    return;
    label547:
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    zi.b();
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  protected void onStop()
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
          xv.c("removeTimeTask removeTimeTask");
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
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131493812, 2131492948, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        xv.c("removeTimeTask showProgressDialog");
        SmsContentTipActivity.this.removeTimeTask();
      }
    });
  }
  
  public void startTimeTask()
  {
    this.mTimeConter = System.currentTimeMillis();
    this.mIsTimeTask = true;
  }
  
  void unbindResult()
  {
    finish();
    AccountPageActivity.mNeedRefreshEval = true;
    tt.a();
    tt.b();
    tt.a().j = false;
    Intent localIntent = new Intent(this, IndexActivity.class);
    localIntent.putExtra("index_from", 16);
    localIntent.putExtra("snap", true);
    localIntent.addFlags(67108864);
    localIntent.addFlags(536870912);
    startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SmsContentTipActivity
 * JD-Core Version:    0.7.0.1
 */