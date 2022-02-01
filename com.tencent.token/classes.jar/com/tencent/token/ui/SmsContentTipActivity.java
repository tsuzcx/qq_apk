package com.tencent.token.ui;

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
import com.tencent.token.cc;
import com.tencent.token.cd;
import com.tencent.token.cn;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult.VerifyTypeItem;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.UpgradeDeterminResult;
import com.tencent.token.core.protocolcenter.protocol.ProtoGetSMSChannel;
import com.tencent.token.cs;
import com.tencent.token.global.g;

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
    public void run()
    {
      if (!SmsContentTipActivity.this.mIsTimeTask) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send bind seq request:");
      localStringBuilder.append(SmsContentTipActivity.this.mBindRetryTimes);
      g.a(localStringBuilder.toString());
      cd.c().n();
      int i;
      if (SmsContentTipActivity.this.mVerifyType != null) {
        i = SmsContentTipActivity.this.mVerifyType.a();
      } else {
        i = 0;
      }
      cc.a().a(0L, Long.parseLong(SmsContentTipActivity.this.mUin), SmsContentTipActivity.this.mSceneId, i, SmsContentTipActivity.this.mHandler);
      SmsContentTipActivity.access$108(SmsContentTipActivity.this);
    }
  };
  private String mCountryCode;
  private DialogInterface.OnCancelListener mDialogCancelListener = new DialogInterface.OnCancelListener()
  {
    public void onCancel(DialogInterface paramAnonymousDialogInterface)
    {
      SmsContentTipActivity.this.unbindResult();
    }
  };
  private DialogInterface.OnClickListener mDialogFinishListener = new DialogInterface.OnClickListener()
  {
    public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
    {
      SmsContentTipActivity.this.dismissDialog();
    }
  };
  Handler mHandler = new Handler()
  {
    /* Error */
    public void handleMessage(Message paramAnonymousMessage)
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   4: ifnull +2295 -> 2299
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
      //   29: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   32: astore 5
      //   34: aload 5
      //   36: ldc 33
      //   38: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   41: pop
      //   42: aload 5
      //   44: aload_1
      //   45: getfield 43	android/os/Message:what	I
      //   48: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   51: pop
      //   52: aload 5
      //   54: ldc 48
      //   56: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   59: pop
      //   60: aload 5
      //   62: aload_0
      //   63: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   66: invokestatic 52	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   69: invokevirtual 55	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   72: pop
      //   73: aload 5
      //   75: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   78: invokestatic 65	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   81: aload_1
      //   82: getfield 43	android/os/Message:what	I
      //   85: lookupswitch	default:+2221->2306, 3:+1860->1945, 4:+1835->1920, 9:+1721->1806, 10:+1693->1778, 13:+1632->1717, 15:+1573->1658, 3012:+1046->1131, 3026:+891->976, 3068:+408->493, 4001:+182->267, 4004:+891->976, 4097:+131->216, 4098:+131->216, 4104:+123->208
      //   209: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   212: invokestatic 68	com/tencent/token/ui/SmsContentTipActivity:access$1300	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   215: return
      //   216: aload_1
      //   217: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   220: checkcast 74	[B
      //   223: checkcast 74	[B
      //   226: astore 5
      //   228: aload_1
      //   229: getfield 77	android/os/Message:arg1	I
      //   232: ifne +27 -> 259
      //   235: aload 5
      //   237: ifnull +22 -> 259
      //   240: aload 5
      //   242: arraylength
      //   243: ifle +16 -> 259
      //   246: aload_0
      //   247: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   250: aload 5
      //   252: invokestatic 82	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
      //   255: invokestatic 86	com/tencent/token/ui/SmsContentTipActivity:access$802	(Lcom/tencent/token/ui/SmsContentTipActivity;Ljava/lang/String;)Ljava/lang/String;
      //   258: pop
      //   259: aload_0
      //   260: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   263: invokestatic 68	com/tencent/token/ui/SmsContentTipActivity:access$1300	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   266: return
      //   267: aload_0
      //   268: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   271: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   274: aload_0
      //   275: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   278: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   281: aload_0
      //   282: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   285: invokestatic 95	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   288: aload_1
      //   289: getfield 77	android/os/Message:arg1	I
      //   292: ifne +170 -> 462
      //   295: aload_0
      //   296: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   299: iconst_1
      //   300: invokestatic 99	com/tencent/token/ui/SmsContentTipActivity:access$2102	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   303: pop
      //   304: invokestatic 104	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
      //   307: aload_0
      //   308: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   311: invokestatic 108	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   314: invokevirtual 112	com/tencent/token/cs:b	(Lcom/tencent/token/core/bean/QQUser;)Z
      //   317: pop
      //   318: invokestatic 104	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
      //   321: invokevirtual 115	com/tencent/token/cs:n	()V
      //   324: invokestatic 104	com/tencent/token/cs:a	()Lcom/tencent/token/cs;
      //   327: invokevirtual 117	com/tencent/token/cs:b	()V
      //   330: invokestatic 122	com/tencent/token/cw:a	()Lcom/tencent/token/cw;
      //   333: getfield 126	com/tencent/token/cw:f	Lcom/tencent/token/dl;
      //   336: aload_0
      //   337: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   340: invokestatic 108	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   343: getfield 132	com/tencent/token/core/bean/QQUser:mUin	J
      //   346: invokevirtual 137	com/tencent/token/dl:a	(J)V
      //   349: invokestatic 142	com/tencent/token/cu:a	()Lcom/tencent/token/cu;
      //   352: getfield 143	com/tencent/token/cu:f	Lcom/tencent/token/dl;
      //   355: aload_0
      //   356: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   359: invokestatic 108	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   362: getfield 132	com/tencent/token/core/bean/QQUser:mUin	J
      //   365: invokevirtual 137	com/tencent/token/dl:a	(J)V
      //   368: iconst_1
      //   369: putstatic 149	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   372: aload_0
      //   373: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   376: astore_1
      //   377: new 30	java/lang/StringBuilder
      //   380: dup
      //   381: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   384: astore 5
      //   386: aload 5
      //   388: aload_0
      //   389: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   392: ldc 150
      //   394: invokevirtual 154	com/tencent/token/ui/SmsContentTipActivity:getString	(I)Ljava/lang/String;
      //   397: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   400: pop
      //   401: aload 5
      //   403: aload_0
      //   404: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   407: invokestatic 108	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   410: getfield 157	com/tencent/token/core/bean/QQUser:mRealUin	J
      //   413: invokestatic 162	java/lang/Long:toString	(J)Ljava/lang/String;
      //   416: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   419: pop
      //   420: aload 5
      //   422: aload_0
      //   423: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   426: ldc 163
      //   428: invokevirtual 154	com/tencent/token/ui/SmsContentTipActivity:getString	(I)Ljava/lang/String;
      //   431: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   434: pop
      //   435: aload_1
      //   436: iconst_0
      //   437: aload 5
      //   439: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   442: ldc 164
      //   444: aload_0
      //   445: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   448: invokestatic 168	com/tencent/token/ui/SmsContentTipActivity:access$2200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/content/DialogInterface$OnClickListener;
      //   451: aload_0
      //   452: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   455: invokestatic 172	com/tencent/token/ui/SmsContentTipActivity:access$2300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/content/DialogInterface$OnCancelListener;
      //   458: invokevirtual 176	com/tencent/token/ui/SmsContentTipActivity:showUserDialog	(ILjava/lang/String;ILandroid/content/DialogInterface$OnClickListener;Landroid/content/DialogInterface$OnCancelListener;)V
      //   461: return
      //   462: aload_1
      //   463: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   466: checkcast 178	com/tencent/token/global/e
      //   469: astore_1
      //   470: aload_0
      //   471: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   474: invokevirtual 182	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   477: aload_1
      //   478: invokestatic 185	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   481: aload_0
      //   482: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   485: aload_1
      //   486: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   489: invokestatic 192	com/tencent/token/ui/SmsContentTipActivity:access$2400	(Lcom/tencent/token/ui/SmsContentTipActivity;Ljava/lang/String;)V
      //   492: return
      //   493: aload_1
      //   494: getfield 77	android/os/Message:arg1	I
      //   497: ifne +312 -> 809
      //   500: aload_0
      //   501: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   504: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   507: ifne +42 -> 549
      //   510: invokestatic 201	com/tencent/token/cc:a	()Lcom/tencent/token/cc;
      //   513: aload_0
      //   514: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   517: invokestatic 205	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   520: invokestatic 209	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   523: aload_0
      //   524: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   527: invokestatic 213	com/tencent/token/ui/SmsContentTipActivity:access$1700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/UpgradeDeterminResult;
      //   530: invokevirtual 218	com/tencent/token/core/bean/UpgradeDeterminResult:f	()I
      //   533: ldc 220
      //   535: ldc 220
      //   537: aload_0
      //   538: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   541: getfield 224	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   544: invokevirtual 227	com/tencent/token/cc:c	(JILjava/lang/String;Ljava/lang/String;Landroid/os/Handler;)I
      //   547: pop
      //   548: return
      //   549: aload_0
      //   550: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   553: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   556: bipush 6
      //   558: if_icmpne +39 -> 597
      //   561: invokestatic 201	com/tencent/token/cc:a	()Lcom/tencent/token/cc;
      //   564: aload_0
      //   565: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   568: invokestatic 108	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   571: getfield 132	com/tencent/token/core/bean/QQUser:mUin	J
      //   574: aload_0
      //   575: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   578: invokestatic 108	com/tencent/token/ui/SmsContentTipActivity:access$1100	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   581: getfield 157	com/tencent/token/core/bean/QQUser:mRealUin	J
      //   584: iconst_1
      //   585: aload_0
      //   586: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   589: getfield 224	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   592: invokevirtual 230	com/tencent/token/cc:a	(JJILandroid/os/Handler;)I
      //   595: pop
      //   596: return
      //   597: aload_0
      //   598: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   601: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   604: bipush 7
      //   606: if_icmpne +48 -> 654
      //   609: new 232	android/content/Intent
      //   612: dup
      //   613: aload_0
      //   614: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   617: ldc 234
      //   619: invokespecial 237	android/content/Intent:<init>	(Landroid/content/Context;Ljava/lang/Class;)V
      //   622: astore_1
      //   623: aload_1
      //   624: ldc 239
      //   626: iconst_1
      //   627: invokevirtual 243	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
      //   630: pop
      //   631: aload_1
      //   632: ldc 244
      //   634: invokevirtual 248	android/content/Intent:setFlags	(I)Landroid/content/Intent;
      //   637: pop
      //   638: aload_0
      //   639: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   642: aload_1
      //   643: invokevirtual 252	com/tencent/token/ui/SmsContentTipActivity:startActivity	(Landroid/content/Intent;)V
      //   646: aload_0
      //   647: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   650: invokevirtual 255	com/tencent/token/ui/SmsContentTipActivity:finish	()V
      //   653: return
      //   654: aload_0
      //   655: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   658: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   661: bipush 8
      //   663: if_icmpne +1642 -> 2305
      //   666: aload_0
      //   667: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   670: invokestatic 259	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   673: aload_0
      //   674: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   677: invokestatic 262	com/tencent/token/ui/SmsContentTipActivity:access$1800	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   680: invokestatic 268	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   683: invokevirtual 273	com/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem:a	(Ljava/lang/Integer;)Z
      //   686: ifne +53 -> 739
      //   689: invokestatic 278	com/tencent/token/ui/u:a	()Lcom/tencent/token/ui/u;
      //   692: aload_0
      //   693: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   696: aload_0
      //   697: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   700: invokestatic 282	com/tencent/token/ui/SmsContentTipActivity:access$1900	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult;
      //   703: aload_0
      //   704: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   707: invokestatic 259	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   710: aload_0
      //   711: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   714: invokestatic 259	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   717: aload_0
      //   718: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   721: invokestatic 262	com/tencent/token/ui/SmsContentTipActivity:access$1800	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   724: invokevirtual 285	com/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem:a	(I)I
      //   727: iconst_0
      //   728: aload_0
      //   729: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   732: getfield 224	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   735: invokevirtual 288	com/tencent/token/ui/u:a	(Landroid/app/Activity;Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult;Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;IZLandroid/os/Handler;)V
      //   738: return
      //   739: aload_0
      //   740: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   743: invokestatic 282	com/tencent/token/ui/SmsContentTipActivity:access$1900	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult;
      //   746: invokevirtual 292	com/tencent/token/core/bean/DeterminVerifyFactorsResult:b	()Z
      //   749: ifeq +52 -> 801
      //   752: invokestatic 201	com/tencent/token/cc:a	()Lcom/tencent/token/cc;
      //   755: aload_0
      //   756: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   759: invokestatic 295	com/tencent/token/ui/SmsContentTipActivity:access$2000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/QQUser;
      //   762: getfield 157	com/tencent/token/core/bean/QQUser:mRealUin	J
      //   765: aload_0
      //   766: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   769: invokestatic 259	com/tencent/token/ui/SmsContentTipActivity:access$200	(Lcom/tencent/token/ui/SmsContentTipActivity;)Lcom/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem;
      //   772: invokevirtual 297	com/tencent/token/core/bean/DeterminVerifyFactorsResult$VerifyTypeItem:a	()I
      //   775: aload_0
      //   776: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   779: invokestatic 300	com/tencent/token/ui/SmsContentTipActivity:access$600	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   782: aload_0
      //   783: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   786: invokestatic 303	com/tencent/token/ui/SmsContentTipActivity:access$700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   789: aload_0
      //   790: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   793: getfield 224	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   796: invokevirtual 305	com/tencent/token/cc:b	(JILjava/lang/String;Ljava/lang/String;Landroid/os/Handler;)I
      //   799: pop
      //   800: return
      //   801: aload_0
      //   802: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   805: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   808: return
      //   809: aload_1
      //   810: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   813: checkcast 178	com/tencent/token/global/e
      //   816: astore_1
      //   817: aload_0
      //   818: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   821: invokevirtual 182	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   824: aload_1
      //   825: invokestatic 185	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   828: aload_0
      //   829: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   832: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   835: ifeq +15 -> 850
      //   838: aload_0
      //   839: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   842: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   845: bipush 8
      //   847: if_icmpne +40 -> 887
      //   850: aload_1
      //   851: getfield 307	com/tencent/token/global/e:a	I
      //   854: sipush 146
      //   857: if_icmpne +30 -> 887
      //   860: aload_0
      //   861: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   864: invokestatic 310	com/tencent/token/ui/SmsContentTipActivity:access$100	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   867: iconst_4
      //   868: if_icmpge +19 -> 887
      //   871: aload_0
      //   872: aload_0
      //   873: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   876: getfield 314	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   879: ldc2_w 315
      //   882: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   885: pop
      //   886: return
      //   887: aload_0
      //   888: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   891: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   894: bipush 6
      //   896: if_icmpne +40 -> 936
      //   899: aload_1
      //   900: getfield 307	com/tencent/token/global/e:a	I
      //   903: sipush 146
      //   906: if_icmpne +30 -> 936
      //   909: aload_0
      //   910: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   913: invokestatic 323	com/tencent/token/ui/SmsContentTipActivity:access$1000	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   916: iconst_4
      //   917: if_icmpge +19 -> 936
      //   920: aload_0
      //   921: aload_0
      //   922: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   925: getfield 326	com/tencent/token/ui/SmsContentTipActivity:mUnBindRunnable	Ljava/lang/Runnable;
      //   928: ldc2_w 315
      //   931: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   934: pop
      //   935: return
      //   936: aload_0
      //   937: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   940: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   943: aload_0
      //   944: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   947: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   950: iconst_0
      //   951: invokevirtual 336	android/widget/TextView:setVisibility	(I)V
      //   954: aload_0
      //   955: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   958: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   961: aload_1
      //   962: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   965: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   968: aload_0
      //   969: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   972: invokestatic 95	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   975: return
      //   976: aload_0
      //   977: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   980: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   983: aload_0
      //   984: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   987: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   990: aload_1
      //   991: getfield 77	android/os/Message:arg1	I
      //   994: ifne +11 -> 1005
      //   997: aload_0
      //   998: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1001: invokestatic 343	com/tencent/token/ui/SmsContentTipActivity:access$1400	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1004: return
      //   1005: aload_1
      //   1006: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   1009: checkcast 178	com/tencent/token/global/e
      //   1012: astore_1
      //   1013: aload_0
      //   1014: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1017: invokevirtual 182	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   1020: aload_1
      //   1021: invokestatic 185	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   1024: new 30	java/lang/StringBuilder
      //   1027: dup
      //   1028: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   1031: astore 5
      //   1033: aload 5
      //   1035: ldc_w 345
      //   1038: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1041: pop
      //   1042: aload 5
      //   1044: aload_1
      //   1045: getfield 307	com/tencent/token/global/e:a	I
      //   1048: invokevirtual 46	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   1051: pop
      //   1052: aload 5
      //   1054: ldc_w 347
      //   1057: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1060: pop
      //   1061: aload 5
      //   1063: aload_1
      //   1064: getfield 349	com/tencent/token/global/e:b	Ljava/lang/String;
      //   1067: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1070: pop
      //   1071: aload 5
      //   1073: ldc_w 347
      //   1076: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1079: pop
      //   1080: aload 5
      //   1082: aload_1
      //   1083: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1086: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1089: pop
      //   1090: aload 5
      //   1092: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1095: invokestatic 65	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   1098: aload_0
      //   1099: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1102: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1105: iconst_0
      //   1106: invokevirtual 336	android/widget/TextView:setVisibility	(I)V
      //   1109: aload_0
      //   1110: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1113: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1116: aload_1
      //   1117: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1120: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1123: aload_0
      //   1124: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1127: invokestatic 95	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1130: return
      //   1131: aload_0
      //   1132: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1135: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1138: aload_0
      //   1139: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1142: iconst_0
      //   1143: invokestatic 352	com/tencent/token/ui/SmsContentTipActivity:access$2502	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   1146: pop
      //   1147: aload_1
      //   1148: getfield 77	android/os/Message:arg1	I
      //   1151: ifne +392 -> 1543
      //   1154: aload_0
      //   1155: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1158: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1161: aload_0
      //   1162: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1165: ldc_w 353
      //   1168: invokevirtual 356	com/tencent/token/ui/SmsContentTipActivity:setContentView	(I)V
      //   1171: aload_0
      //   1172: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1175: getfield 360	com/tencent/token/ui/SmsContentTipActivity:mBackArrow	Landroid/view/View;
      //   1178: iconst_4
      //   1179: invokevirtual 363	android/view/View:setVisibility	(I)V
      //   1182: aload_0
      //   1183: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1186: iconst_1
      //   1187: invokestatic 366	com/tencent/token/ui/SmsContentTipActivity:access$2602	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   1190: pop
      //   1191: aload_0
      //   1192: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1195: invokestatic 369	com/tencent/token/ui/SmsContentTipActivity:access$2700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   1198: ifnull +30 -> 1228
      //   1201: aload_0
      //   1202: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1205: invokestatic 369	com/tencent/token/ui/SmsContentTipActivity:access$2700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   1208: invokevirtual 374	java/lang/String:length	()I
      //   1211: ifle +17 -> 1228
      //   1214: aload_0
      //   1215: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1218: aload_0
      //   1219: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1222: invokestatic 369	com/tencent/token/ui/SmsContentTipActivity:access$2700	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   1225: invokevirtual 377	com/tencent/token/ui/SmsContentTipActivity:setTitle	(Ljava/lang/CharSequence;)V
      //   1228: aload_1
      //   1229: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   1232: checkcast 379	org/json/JSONObject
      //   1235: astore 6
      //   1237: aconst_null
      //   1238: astore 7
      //   1240: aload 6
      //   1242: ldc_w 381
      //   1245: invokevirtual 384	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1248: astore 5
      //   1250: aload 6
      //   1252: ldc_w 386
      //   1255: invokevirtual 384	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1258: astore_1
      //   1259: aload 6
      //   1261: ldc_w 388
      //   1264: invokevirtual 384	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1267: astore 6
      //   1269: goto +32 -> 1301
      //   1272: astore 6
      //   1274: goto +18 -> 1292
      //   1277: astore 6
      //   1279: aconst_null
      //   1280: astore_1
      //   1281: goto +11 -> 1292
      //   1284: astore 6
      //   1286: aconst_null
      //   1287: astore 5
      //   1289: aload 5
      //   1291: astore_1
      //   1292: aload 6
      //   1294: invokevirtual 391	org/json/JSONException:printStackTrace	()V
      //   1297: aload 7
      //   1299: astore 6
      //   1301: aload 5
      //   1303: ifnull +39 -> 1342
      //   1306: aload 5
      //   1308: invokevirtual 374	java/lang/String:length	()I
      //   1311: ifle +31 -> 1342
      //   1314: aload_0
      //   1315: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1318: ldc_w 392
      //   1321: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1324: checkcast 332	android/widget/TextView
      //   1327: astore 7
      //   1329: aload 7
      //   1331: aload 5
      //   1333: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1336: aload 7
      //   1338: iconst_0
      //   1339: invokevirtual 336	android/widget/TextView:setVisibility	(I)V
      //   1342: aload_0
      //   1343: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1346: ldc_w 397
      //   1349: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1352: new 8	com/tencent/token/ui/SmsContentTipActivity$4$1
      //   1355: dup
      //   1356: aload_0
      //   1357: invokespecial 400	com/tencent/token/ui/SmsContentTipActivity$4$1:<init>	(Lcom/tencent/token/ui/SmsContentTipActivity$4;)V
      //   1360: invokevirtual 404	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
      //   1363: aload_0
      //   1364: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1367: ldc_w 405
      //   1370: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1373: astore 5
      //   1375: aload_0
      //   1376: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1379: invokestatic 408	com/tencent/token/ui/SmsContentTipActivity:access$500	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1382: iconst_1
      //   1383: if_icmpne +47 -> 1430
      //   1386: aload_0
      //   1387: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1390: ldc_w 409
      //   1393: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1396: checkcast 332	android/widget/TextView
      //   1399: ldc_w 410
      //   1402: invokevirtual 412	android/widget/TextView:setText	(I)V
      //   1405: aload 5
      //   1407: bipush 8
      //   1409: invokevirtual 363	android/view/View:setVisibility	(I)V
      //   1412: aload_0
      //   1413: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1416: ldc_w 392
      //   1419: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1422: bipush 8
      //   1424: invokevirtual 363	android/view/View:setVisibility	(I)V
      //   1427: goto +105 -> 1532
      //   1430: aload_0
      //   1431: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1434: ldc_w 409
      //   1437: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1440: checkcast 332	android/widget/TextView
      //   1443: ldc_w 413
      //   1446: invokevirtual 412	android/widget/TextView:setText	(I)V
      //   1449: aload_1
      //   1450: ifnull +75 -> 1525
      //   1453: aload 6
      //   1455: ifnull +70 -> 1525
      //   1458: aload_1
      //   1459: invokevirtual 374	java/lang/String:length	()I
      //   1462: ifle +63 -> 1525
      //   1465: aload 6
      //   1467: invokevirtual 374	java/lang/String:length	()I
      //   1470: ifle +55 -> 1525
      //   1473: aload 5
      //   1475: iconst_0
      //   1476: invokevirtual 363	android/view/View:setVisibility	(I)V
      //   1479: aload_0
      //   1480: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1483: ldc_w 414
      //   1486: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1489: checkcast 332	android/widget/TextView
      //   1492: astore 5
      //   1494: aload_0
      //   1495: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1498: ldc_w 415
      //   1501: invokevirtual 396	com/tencent/token/ui/SmsContentTipActivity:findViewById	(I)Landroid/view/View;
      //   1504: checkcast 332	android/widget/TextView
      //   1507: astore 7
      //   1509: aload 5
      //   1511: aload_1
      //   1512: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1515: aload 7
      //   1517: aload 6
      //   1519: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1522: goto +10 -> 1532
      //   1525: aload 5
      //   1527: bipush 8
      //   1529: invokevirtual 363	android/view/View:setVisibility	(I)V
      //   1532: invokestatic 420	com/tencent/token/dk:a	()Lcom/tencent/token/dk;
      //   1535: invokevirtual 421	com/tencent/token/dk:b	()V
      //   1538: iconst_1
      //   1539: putstatic 149	com/tencent/token/ui/AccountPageActivity:mNeedRefreshEval	Z
      //   1542: return
      //   1543: aload_1
      //   1544: getfield 72	android/os/Message:obj	Ljava/lang/Object;
      //   1547: checkcast 178	com/tencent/token/global/e
      //   1550: astore_1
      //   1551: aload_1
      //   1552: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1555: ifnull +13 -> 1568
      //   1558: aload_1
      //   1559: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1562: invokevirtual 374	java/lang/String:length	()I
      //   1565: ifne +14 -> 1579
      //   1568: aload_0
      //   1569: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1572: invokevirtual 182	com/tencent/token/ui/SmsContentTipActivity:getResources	()Landroid/content/res/Resources;
      //   1575: aload_1
      //   1576: invokestatic 185	com/tencent/token/global/e:a	(Landroid/content/res/Resources;Lcom/tencent/token/global/e;)V
      //   1579: aload_1
      //   1580: getfield 307	com/tencent/token/global/e:a	I
      //   1583: sipush 146
      //   1586: if_icmpne +39 -> 1625
      //   1589: aload_0
      //   1590: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1593: invokestatic 424	com/tencent/token/ui/SmsContentTipActivity:access$900	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1596: iconst_4
      //   1597: if_icmpge +28 -> 1625
      //   1600: aload_0
      //   1601: aload_0
      //   1602: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1605: getfield 427	com/tencent/token/ui/SmsContentTipActivity:mSetModMobileRunnable	Ljava/lang/Runnable;
      //   1608: ldc2_w 315
      //   1611: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   1614: pop
      //   1615: aload_0
      //   1616: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1619: iconst_1
      //   1620: invokestatic 352	com/tencent/token/ui/SmsContentTipActivity:access$2502	(Lcom/tencent/token/ui/SmsContentTipActivity;Z)Z
      //   1623: pop
      //   1624: return
      //   1625: aload_0
      //   1626: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1629: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1632: iconst_0
      //   1633: invokevirtual 336	android/widget/TextView:setVisibility	(I)V
      //   1636: aload_0
      //   1637: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1640: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1643: aload_1
      //   1644: getfield 188	com/tencent/token/global/e:c	Ljava/lang/String;
      //   1647: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1650: aload_0
      //   1651: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1654: invokestatic 95	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1657: return
      //   1658: aload_0
      //   1659: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1662: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1665: ldc_w 429
      //   1668: invokestatic 65	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   1671: aload_0
      //   1672: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1675: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1678: aload_0
      //   1679: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1682: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1685: iconst_0
      //   1686: invokevirtual 336	android/widget/TextView:setVisibility	(I)V
      //   1689: aload_0
      //   1690: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1693: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1696: aload_0
      //   1697: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1700: ldc_w 430
      //   1703: invokevirtual 154	com/tencent/token/ui/SmsContentTipActivity:getString	(I)Ljava/lang/String;
      //   1706: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1709: aload_0
      //   1710: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1713: invokestatic 95	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1716: return
      //   1717: aload_1
      //   1718: invokevirtual 434	android/os/Message:getData	()Landroid/os/Bundle;
      //   1721: ldc_w 436
      //   1724: invokevirtual 442	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   1727: istore_2
      //   1728: invokestatic 448	java/lang/System:currentTimeMillis	()J
      //   1731: lstore_3
      //   1732: iload_2
      //   1733: i2l
      //   1734: ldc2_w 449
      //   1737: lmul
      //   1738: lload_3
      //   1739: lsub
      //   1740: lstore_3
      //   1741: invokestatic 455	com/tencent/token/cd:c	()Lcom/tencent/token/cd;
      //   1744: lload_3
      //   1745: invokevirtual 456	com/tencent/token/cd:a	(J)V
      //   1748: new 30	java/lang/StringBuilder
      //   1751: dup
      //   1752: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   1755: astore_1
      //   1756: aload_1
      //   1757: ldc_w 458
      //   1760: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   1763: pop
      //   1764: aload_1
      //   1765: lload_3
      //   1766: invokevirtual 461	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
      //   1769: pop
      //   1770: aload_1
      //   1771: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   1774: invokestatic 463	com/tencent/token/global/g:b	(Ljava/lang/String;)V
      //   1777: return
      //   1778: aload_0
      //   1779: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1782: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1785: ldc_w 465
      //   1788: invokestatic 65	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   1791: aload_0
      //   1792: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1795: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1798: aload_0
      //   1799: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1802: invokestatic 343	com/tencent/token/ui/SmsContentTipActivity:access$1400	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1805: return
      //   1806: aload_0
      //   1807: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1810: invokestatic 52	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   1813: ifne +4 -> 1817
      //   1816: return
      //   1817: aload_1
      //   1818: invokevirtual 434	android/os/Message:getData	()Landroid/os/Bundle;
      //   1821: astore_1
      //   1822: aload_1
      //   1823: ldc_w 467
      //   1826: invokevirtual 442	android/os/Bundle:getInt	(Ljava/lang/String;)I
      //   1829: istore_2
      //   1830: aload_1
      //   1831: ldc_w 469
      //   1834: invokevirtual 470	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
      //   1837: astore_1
      //   1838: iconst_1
      //   1839: iload_2
      //   1840: if_icmpne +30 -> 1870
      //   1843: aload_0
      //   1844: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1847: invokestatic 310	com/tencent/token/ui/SmsContentTipActivity:access$100	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1850: iconst_4
      //   1851: if_icmpge +19 -> 1870
      //   1854: aload_0
      //   1855: aload_0
      //   1856: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1859: getfield 314	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   1862: ldc2_w 315
      //   1865: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   1868: pop
      //   1869: return
      //   1870: aload_0
      //   1871: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1874: invokevirtual 89	com/tencent/token/ui/SmsContentTipActivity:dismissDialog	()V
      //   1877: ldc_w 472
      //   1880: invokestatic 65	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   1883: aload_0
      //   1884: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1887: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1890: aload_0
      //   1891: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1894: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1897: iconst_0
      //   1898: invokevirtual 336	android/widget/TextView:setVisibility	(I)V
      //   1901: aload_0
      //   1902: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1905: invokestatic 330	com/tencent/token/ui/SmsContentTipActivity:access$1500	(Lcom/tencent/token/ui/SmsContentTipActivity;)Landroid/widget/TextView;
      //   1908: aload_1
      //   1909: invokevirtual 340	android/widget/TextView:setText	(Ljava/lang/CharSequence;)V
      //   1912: aload_0
      //   1913: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1916: invokestatic 95	com/tencent/token/ui/SmsContentTipActivity:access$1600	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   1919: return
      //   1920: aload_0
      //   1921: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1924: invokestatic 52	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   1927: ifne +4 -> 1931
      //   1930: return
      //   1931: ldc_w 474
      //   1934: invokestatic 65	com/tencent/token/global/g:c	(Ljava/lang/String;)V
      //   1937: aload_0
      //   1938: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1941: invokevirtual 92	com/tencent/token/ui/SmsContentTipActivity:removeTimeTask	()V
      //   1944: return
      //   1945: aload_0
      //   1946: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1949: invokestatic 52	com/tencent/token/ui/SmsContentTipActivity:access$000	(Lcom/tencent/token/ui/SmsContentTipActivity;)Z
      //   1952: ifne +4 -> 1956
      //   1955: return
      //   1956: aload_0
      //   1957: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1960: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1963: ifeq +311 -> 2274
      //   1966: aload_0
      //   1967: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1970: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1973: bipush 7
      //   1975: if_icmpne +6 -> 1981
      //   1978: goto +296 -> 2274
      //   1981: aload_0
      //   1982: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1985: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1988: iconst_3
      //   1989: if_icmpeq +91 -> 2080
      //   1992: aload_0
      //   1993: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   1996: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   1999: iconst_4
      //   2000: if_icmpne +6 -> 2006
      //   2003: goto +77 -> 2080
      //   2006: aload_0
      //   2007: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2010: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   2013: bipush 6
      //   2015: if_icmpne +28 -> 2043
      //   2018: aload_0
      //   2019: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2022: iconst_0
      //   2023: invokestatic 478	com/tencent/token/ui/SmsContentTipActivity:access$1002	(Lcom/tencent/token/ui/SmsContentTipActivity;I)I
      //   2026: pop
      //   2027: aload_0
      //   2028: aload_0
      //   2029: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2032: getfield 326	com/tencent/token/ui/SmsContentTipActivity:mUnBindRunnable	Ljava/lang/Runnable;
      //   2035: ldc2_w 315
      //   2038: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   2041: pop
      //   2042: return
      //   2043: aload_0
      //   2044: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2047: invokestatic 196	com/tencent/token/ui/SmsContentTipActivity:access$1200	(Lcom/tencent/token/ui/SmsContentTipActivity;)I
      //   2050: bipush 8
      //   2052: if_icmpne +253 -> 2305
      //   2055: aload_0
      //   2056: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2059: iconst_0
      //   2060: invokestatic 481	com/tencent/token/ui/SmsContentTipActivity:access$102	(Lcom/tencent/token/ui/SmsContentTipActivity;I)I
      //   2063: pop
      //   2064: aload_0
      //   2065: aload_0
      //   2066: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2069: getfield 314	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   2072: ldc2_w 315
      //   2075: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   2078: pop
      //   2079: return
      //   2080: invokestatic 486	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
      //   2083: invokestatic 491	com/tencent/token/ca:a	(Landroid/content/Context;)Lcom/tencent/token/ca;
      //   2086: astore_1
      //   2087: aload_1
      //   2088: aload_0
      //   2089: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2092: invokestatic 205	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   2095: invokestatic 209	java/lang/Long:parseLong	(Ljava/lang/String;)J
      //   2098: invokevirtual 494	com/tencent/token/ca:b	(J)[B
      //   2101: astore 5
      //   2103: new 30	java/lang/StringBuilder
      //   2106: dup
      //   2107: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   2110: astore 6
      //   2112: aload 6
      //   2114: ldc_w 496
      //   2117: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2120: pop
      //   2121: aload 6
      //   2123: aload 5
      //   2125: invokevirtual 499	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   2128: pop
      //   2129: aload 6
      //   2131: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2134: invokestatic 501	com/tencent/token/global/g:a	(Ljava/lang/String;)V
      //   2137: aload 5
      //   2139: ifnull +75 -> 2214
      //   2142: aload 5
      //   2144: arraylength
      //   2145: ifle +69 -> 2214
      //   2148: new 30	java/lang/StringBuilder
      //   2151: dup
      //   2152: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   2155: astore 6
      //   2157: aload 6
      //   2159: ldc 220
      //   2161: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2164: pop
      //   2165: aload 6
      //   2167: aload_0
      //   2168: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2171: invokestatic 205	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   2174: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2177: pop
      //   2178: aload_1
      //   2179: aload 6
      //   2181: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2184: ldc2_w 502
      //   2187: invokevirtual 506	com/tencent/token/ca:b	(Ljava/lang/String;J)Z
      //   2190: ifne +24 -> 2214
      //   2193: aload_0
      //   2194: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2197: aload 5
      //   2199: invokestatic 82	com/tencent/token/utils/l:a	([B)Ljava/lang/String;
      //   2202: invokestatic 86	com/tencent/token/ui/SmsContentTipActivity:access$802	(Lcom/tencent/token/ui/SmsContentTipActivity;Ljava/lang/String;)Ljava/lang/String;
      //   2205: pop
      //   2206: aload_0
      //   2207: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2210: invokestatic 68	com/tencent/token/ui/SmsContentTipActivity:access$1300	(Lcom/tencent/token/ui/SmsContentTipActivity;)V
      //   2213: return
      //   2214: invokestatic 486	com/tencent/token/global/RqdApplication:n	()Landroid/content/Context;
      //   2217: invokestatic 491	com/tencent/token/ca:a	(Landroid/content/Context;)Lcom/tencent/token/ca;
      //   2220: astore_1
      //   2221: new 30	java/lang/StringBuilder
      //   2224: dup
      //   2225: invokespecial 31	java/lang/StringBuilder:<init>	()V
      //   2228: astore 5
      //   2230: aload 5
      //   2232: ldc 220
      //   2234: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2237: pop
      //   2238: aload 5
      //   2240: aload_0
      //   2241: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2244: invokestatic 205	com/tencent/token/ui/SmsContentTipActivity:access$300	(Lcom/tencent/token/ui/SmsContentTipActivity;)Ljava/lang/String;
      //   2247: invokevirtual 37	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   2250: pop
      //   2251: aload_1
      //   2252: aload 5
      //   2254: invokevirtual 59	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   2257: aload_0
      //   2258: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2261: getfield 224	com/tencent/token/ui/SmsContentTipActivity:mHandler	Landroid/os/Handler;
      //   2264: ldc2_w 502
      //   2267: bipush 64
      //   2269: invokevirtual 509	com/tencent/token/ca:a	(Ljava/lang/String;Landroid/os/Handler;JI)I
      //   2272: pop
      //   2273: return
      //   2274: aload_0
      //   2275: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2278: iconst_0
      //   2279: invokestatic 481	com/tencent/token/ui/SmsContentTipActivity:access$102	(Lcom/tencent/token/ui/SmsContentTipActivity;I)I
      //   2282: pop
      //   2283: aload_0
      //   2284: aload_0
      //   2285: getfield 14	com/tencent/token/ui/SmsContentTipActivity$4:a	Lcom/tencent/token/ui/SmsContentTipActivity;
      //   2288: getfield 314	com/tencent/token/ui/SmsContentTipActivity:mBindRunnable	Ljava/lang/Runnable;
      //   2291: ldc2_w 315
      //   2294: invokevirtual 320	com/tencent/token/ui/SmsContentTipActivity$4:postDelayed	(Ljava/lang/Runnable;J)Z
      //   2297: pop
      //   2298: return
      //   2299: return
      //   2300: astore_1
      //   2301: aload_1
      //   2302: invokevirtual 510	java/lang/Exception:printStackTrace	()V
      //   2305: return
      //   2306: return
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	2307	0	this	4
      //   0	2307	1	paramAnonymousMessage	Message
      //   1727	114	2	i	int
      //   1731	35	3	l	long
      //   32	2221	5	localObject1	Object
      //   1235	33	6	localObject2	Object
      //   1272	1	6	localJSONException1	org.json.JSONException
      //   1277	1	6	localJSONException2	org.json.JSONException
      //   1284	9	6	localJSONException3	org.json.JSONException
      //   1299	881	6	localObject3	Object
      //   1238	278	7	localTextView	TextView
      // Exception table:
      //   from	to	target	type
      //   1259	1269	1272	org/json/JSONException
      //   1250	1259	1277	org/json/JSONException
      //   1240	1250	1284	org/json/JSONException
      //   0	24	2300	java/lang/Exception
      //   25	208	2300	java/lang/Exception
      //   208	215	2300	java/lang/Exception
      //   216	235	2300	java/lang/Exception
      //   240	259	2300	java/lang/Exception
      //   259	266	2300	java/lang/Exception
      //   267	461	2300	java/lang/Exception
      //   462	492	2300	java/lang/Exception
      //   493	548	2300	java/lang/Exception
      //   549	596	2300	java/lang/Exception
      //   597	653	2300	java/lang/Exception
      //   654	738	2300	java/lang/Exception
      //   739	800	2300	java/lang/Exception
      //   801	808	2300	java/lang/Exception
      //   809	850	2300	java/lang/Exception
      //   850	886	2300	java/lang/Exception
      //   887	935	2300	java/lang/Exception
      //   936	975	2300	java/lang/Exception
      //   976	1004	2300	java/lang/Exception
      //   1005	1130	2300	java/lang/Exception
      //   1131	1228	2300	java/lang/Exception
      //   1228	1237	2300	java/lang/Exception
      //   1240	1250	2300	java/lang/Exception
      //   1250	1259	2300	java/lang/Exception
      //   1259	1269	2300	java/lang/Exception
      //   1292	1297	2300	java/lang/Exception
      //   1306	1342	2300	java/lang/Exception
      //   1342	1427	2300	java/lang/Exception
      //   1430	1449	2300	java/lang/Exception
      //   1458	1522	2300	java/lang/Exception
      //   1525	1532	2300	java/lang/Exception
      //   1532	1542	2300	java/lang/Exception
      //   1543	1568	2300	java/lang/Exception
      //   1568	1579	2300	java/lang/Exception
      //   1579	1624	2300	java/lang/Exception
      //   1625	1657	2300	java/lang/Exception
      //   1658	1716	2300	java/lang/Exception
      //   1717	1732	2300	java/lang/Exception
      //   1741	1777	2300	java/lang/Exception
      //   1778	1805	2300	java/lang/Exception
      //   1806	1816	2300	java/lang/Exception
      //   1817	1838	2300	java/lang/Exception
      //   1843	1869	2300	java/lang/Exception
      //   1870	1919	2300	java/lang/Exception
      //   1920	1930	2300	java/lang/Exception
      //   1931	1944	2300	java/lang/Exception
      //   1945	1955	2300	java/lang/Exception
      //   1956	1978	2300	java/lang/Exception
      //   1981	2003	2300	java/lang/Exception
      //   2006	2042	2300	java/lang/Exception
      //   2043	2079	2300	java/lang/Exception
      //   2080	2137	2300	java/lang/Exception
      //   2142	2213	2300	java/lang/Exception
      //   2214	2273	2300	java/lang/Exception
      //   2274	2298	2300	java/lang/Exception
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
    public void run()
    {
      g.c("send mod set mbmobile");
      cc.a().a(0L, SmsContentTipActivity.this.mOpType, SmsContentTipActivity.this.mMobile, SmsContentTipActivity.this.mCountryCode, SmsContentTipActivity.this.mA2, SmsContentTipActivity.this.mHandler);
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
    public void run()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("send unbind seq request:");
      localStringBuilder.append(SmsContentTipActivity.this.mUnBindRetryTimes);
      g.a(localStringBuilder.toString());
      if (!SmsContentTipActivity.this.mIsTimeTask) {
        return;
      }
      cd.c().n();
      cc.a().a(SmsContentTipActivity.this.mUserToUnbind.mUin, SmsContentTipActivity.this.mUserToUnbind.mRealUin, 1005, 0, SmsContentTipActivity.this.mHandler);
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
    Object localObject = cs.a().d(this.mUser.mRealUin);
    if (localObject != null) {
      cs.a().b((QQUser)localObject);
    }
    cd.c().n();
    localObject = new Intent(this, VerifySuccActivity.class);
    ((Intent)localObject).putExtra("mRealUin", this.mUser.mRealUin);
    DeterminVerifyFactorsResult localDeterminVerifyFactorsResult = this.mVerifyResult;
    if ((localDeterminVerifyFactorsResult != null) && (localDeterminVerifyFactorsResult.c() == 2)) {
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
    this.useTip = ((TextView)findViewById(2131166202));
    this.smsContent = ((TextView)findViewById(2131165999));
    this.mobileNum = ((TextView)findViewById(2131165737));
    this.errorTip = ((TextView)findViewById(2131166091));
    this.okText = ((TextView)findViewById(2131166068));
    this.btnLayout = findViewById(2131165329);
    this.mPb = ((ProgressBar)findViewById(2131165805));
    int i = this.upSmsSceneId;
    if ((i != 0) && (i != 7))
    {
      if ((i != 3) && (i != 4))
      {
        if (i == 6) {
          this.useTipContent = String.format(getString(2131493670), new Object[] { this.mUserToUnbind.mMobileMask });
        } else if (i == 8) {
          this.useTipContent = String.format(getString(2131493670), new Object[] { this.mMobile });
        }
      }
      else {
        this.useTipContent = String.format(getString(2131493670), new Object[] { this.mMobile });
      }
    }
    else
    {
      String str = this.mUpDetermin.b();
      if ((str == null) || (str.length() == 0)) {
        break label362;
      }
      this.useTipContent = String.format(getString(2131493670), new Object[] { this.mUpDetermin.b() });
    }
    if (this.upSmsSceneId == 8)
    {
      this.mobileNum.setText(this.mVerifyResult.e());
      this.smsContent.setText(this.mVerifyResult.d());
    }
    else
    {
      this.mobileNum.setText(ProtoGetSMSChannel.d);
      this.smsContent.setText(ProtoGetSMSChannel.e);
    }
    this.useTip.setText(this.useTipContent);
    this.btnLayout.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        SmsContentTipActivity.this.mPb.setVisibility(0);
        SmsContentTipActivity.this.okText.setText(SmsContentTipActivity.this.getResources().getString(2131493272));
        SmsContentTipActivity.this.btnLayout.setClickable(false);
        SmsContentTipActivity.this.errorTip.setVisibility(4);
        if ((SmsContentTipActivity.this.upSmsSceneId == 0) || (SmsContentTipActivity.this.upSmsSceneId == 7))
        {
          SmsContentTipActivity.access$3202(SmsContentTipActivity.this, false);
          paramAnonymousView = SmsContentTipActivity.this;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(SmsContentTipActivity.this.mUser.mRealUin);
          localStringBuilder.append("");
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
    this.okText.setText(getResources().getString(2131493264));
    this.btnLayout.setClickable(true);
  }
  
  private void showFailDialog(String paramString)
  {
    showUserDialog(2131493654, paramString, 2131493040, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    try
    {
      if (((this.mIsModSetSucc) || (this.mIsUnbindSuccess) || (this.mIsActiveSuccess)) && (paramKeyEvent.getAction() == 0)) {
        if (paramKeyEvent.getKeyCode() == 4) {
          break label161;
        }
      }
      if (this.isReadyModSetMB)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(this);
        localStringBuilder.append("---isReadyModSetMB:");
        localStringBuilder.append(this.isReadyModSetMB);
        localStringBuilder.append("\n----removeCallbacks(mSetModMobileRunnable)");
        g.c(localStringBuilder.toString());
        this.mHandler.removeCallbacks(this.mSetModMobileRunnable);
        this.isReadyModSetMB = false;
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
    label161:
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
              if ((paramBundle != null) && (paramBundle.c() == 2)) {
                setNeverShowLockVerifyView();
              }
              this.mSceneId = 1007;
              this.mMobile = this.mVerifyResult.g();
              paramBundle = new StringBuilder();
              paramBundle.append(this.mUser.mRealUin);
              paramBundle.append("");
              this.mUin = paramBundle.toString();
              this.mSmsPort = this.mVerifyResult.e();
              this.mCountryCode = "+86";
              break label477;
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
        this.mUser = cs.a().e();
        if (this.mUser == null)
        {
          finish();
          return;
        }
        paramBundle = new StringBuilder();
        paramBundle.append(this.mUser.mRealUin);
        paramBundle.append("");
        this.mUin = paramBundle.toString();
      }
    }
    else
    {
      this.mUser = ((QQUser)getIntent().getSerializableExtra("intent.qquser"));
      this.mUpDetermin = ((UpgradeDeterminResult)getIntent().getSerializableExtra("intent.upgradedetermin"));
      this.mSceneId = getIntent().getIntExtra("scene_id", 1004);
      if ((this.mUser == null) || (this.mUpDetermin == null)) {
        break label558;
      }
    }
    label477:
    setContentView(2131296445);
    initView();
    new Thread(this).start();
    if ((getIntent() != null) && (getIntent().getStringExtra("title") != null) && (getIntent().getStringExtra("title").length() > 0))
    {
      this.mTitle = getIntent().getStringExtra("title");
      setTitle(this.mTitle);
    }
    return;
    label558:
    finish();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    this.mIsRunning = false;
    u.c();
  }
  
  protected void onResume()
  {
    super.onResume();
    cd.c().a.a(this.mHandler);
  }
  
  protected void onStop()
  {
    super.onStop();
    cd.c().a.a(null);
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
  
  public void showProgressDialog()
  {
    showProDialog(this, 2131493802, 2131492947, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        g.c("removeTimeTask showProgressDialog");
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
    cs.a().b();
    cs.a().k = false;
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