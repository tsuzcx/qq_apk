package com.tencent.qqmail.activity.readmail;

import Override;
import android.graphics.Bitmap;
import android.webkit.WebView;
import com.tencent.qqlive.module.videoreport.inject.webview.jsinject.JsInjector;
import com.tencent.qqmail.popularize.JSApiUitil;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController;
import com.tencent.qqmail.utilities.ui.QMScaleWebViewController.QMScaleWebViewClient;
import com.tencent.qqmail.view.QMReadMailView;

class ReadMailFragment$118
  extends QMScaleWebViewController.QMScaleWebViewClient
{
  ReadMailFragment$118(ReadMailFragment paramReadMailFragment, QMScaleWebViewController paramQMScaleWebViewController)
  {
    super(paramQMScaleWebViewController);
  }
  
  @Override
  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    JsInjector.getInstance().onPageStarted(paramWebView);
    super.onPageStarted(paramWebView, paramString, paramBitmap);
  }
  
  public void onSafePageFinished(WebView paramWebView, String paramString)
  {
    if ((ReadMailFragment.access$18300(this.this$0) != null) && (paramString.equals(ReadMailFragment.access$18300(this.this$0))) && (((ReadMailFragment.access$2400(this.this$0) != null) && (ReadMailFragment.access$2400(this.this$0).isInTranslationMode())) || ((ReadMailFragment.access$18400(this.this$0)) && (ReadMailFragment.access$10900(this.this$0) != 0)))) {
      ReadMailFragment.access$18500(this.this$0);
    }
    if (ReadMailFragment.access$18600(this.this$0)) {
      JSApiUitil.initJsApi(paramWebView);
    }
  }
  
  public void onSafePageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    super.onSafePageStarted(paramWebView, paramString, paramBitmap);
  }
  
  /* Error */
  public boolean shouldSafeOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aload_2
    //   6: invokevirtual 91	java/lang/String:trim	()Ljava/lang/String;
    //   9: astore_2
    //   10: iconst_4
    //   11: ldc 93
    //   13: new 95	java/lang/StringBuilder
    //   16: dup
    //   17: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   20: ldc 100
    //   22: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: aload_2
    //   26: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   32: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   39: invokestatic 116	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$14000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Z
    //   42: ifeq +68 -> 110
    //   45: aload_2
    //   46: ldc 118
    //   48: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   51: ifeq +59 -> 110
    //   54: aload_0
    //   55: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   58: invokevirtual 126	com/tencent/qqmail/activity/readmail/ReadMailFragment:getActivity	()Lmoai/fragment/app/FragmentActivity;
    //   61: aload_0
    //   62: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   65: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   68: invokevirtual 136	com/tencent/qqmail/model/uidomain/MailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   71: invokevirtual 142	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   74: aload_2
    //   75: aload_0
    //   76: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   79: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   82: invokevirtual 136	com/tencent/qqmail/model/uidomain/MailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   85: invokevirtual 145	com/tencent/qqmail/model/qmdomain/MailInformation:getSubject	()Ljava/lang/String;
    //   88: iconst_0
    //   89: aconst_null
    //   90: aconst_null
    //   91: invokestatic 151	com/tencent/qqmail/activity/webviewexplorer/SubscribeWebViewExplorer:createIntent	(Landroid/content/Context;JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   94: astore_1
    //   95: aload_0
    //   96: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   99: aload_1
    //   100: invokevirtual 155	com/tencent/qqmail/activity/readmail/ReadMailFragment:startActivity	(Landroid/content/Intent;)V
    //   103: ldc 157
    //   105: invokestatic 163	com/tencent/qqmail/protocol/DataCollector:logEvent	(Ljava/lang/String;)V
    //   108: iconst_1
    //   109: ireturn
    //   110: aload_2
    //   111: ldc 165
    //   113: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   116: ifeq +49 -> 165
    //   119: aload_0
    //   120: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   123: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   126: invokevirtual 169	com/tencent/qqmail/model/uidomain/MailUI:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   129: invokevirtual 174	com/tencent/qqmail/model/qmdomain/MailStatus:isProtocolMail	()Z
    //   132: ifeq -24 -> 108
    //   135: aload_0
    //   136: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   139: iconst_1
    //   140: invokestatic 178	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$4702	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;Z)Z
    //   143: pop
    //   144: aload_0
    //   145: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   148: invokestatic 181	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$18700	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)V
    //   151: aload_0
    //   152: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   155: invokestatic 185	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$2300	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/utilities/ui/QMScaleWebViewController;
    //   158: ldc 187
    //   160: invokevirtual 192	com/tencent/qqmail/utilities/ui/QMScaleWebViewController:execJs	(Ljava/lang/String;)V
    //   163: iconst_1
    //   164: ireturn
    //   165: aload_2
    //   166: ldc 194
    //   168: invokevirtual 198	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   171: ifeq +35 -> 206
    //   174: aload_0
    //   175: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   178: aload_2
    //   179: invokestatic 202	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$18800	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;Ljava/lang/String;)Ljava/lang/String;
    //   182: ldc 204
    //   184: aload_0
    //   185: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   188: invokestatic 207	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$200	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)I
    //   191: iconst_0
    //   192: invokestatic 212	com/tencent/qqmail/activity/webviewexplorer/WebViewExplorer:createIntent	(Ljava/lang/String;Ljava/lang/String;IZ)Landroid/content/Intent;
    //   195: astore_1
    //   196: aload_0
    //   197: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   200: aload_1
    //   201: invokevirtual 155	com/tencent/qqmail/activity/readmail/ReadMailFragment:startActivity	(Landroid/content/Intent;)V
    //   204: iconst_1
    //   205: ireturn
    //   206: aload_2
    //   207: ldc 214
    //   209: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   212: ifeq +64 -> 276
    //   215: aload_0
    //   216: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   219: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   222: invokevirtual 218	com/tencent/qqmail/model/uidomain/MailUI:getVote	()Lcom/tencent/qqmail/model/qmdomain/MailVote;
    //   225: ifnull -117 -> 108
    //   228: invokestatic 224	com/tencent/qqmail/model/mail/QMMailManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   231: aload_0
    //   232: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   235: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   238: invokevirtual 218	com/tencent/qqmail/model/uidomain/MailUI:getVote	()Lcom/tencent/qqmail/model/qmdomain/MailVote;
    //   241: invokevirtual 228	com/tencent/qqmail/model/mail/QMMailManager:generateGroupVoteResultHtml	(Lcom/tencent/qqmail/model/qmdomain/MailVote;)Ljava/lang/String;
    //   244: astore_1
    //   245: aload_0
    //   246: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   249: invokevirtual 126	com/tencent/qqmail/activity/readmail/ReadMailFragment:getActivity	()Lmoai/fragment/app/FragmentActivity;
    //   252: aload_1
    //   253: aload_0
    //   254: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   257: ldc 229
    //   259: invokevirtual 233	com/tencent/qqmail/activity/readmail/ReadMailFragment:getString	(I)Ljava/lang/String;
    //   262: invokestatic 238	com/tencent/qqmail/activity/readmail/VoteViewExplorer:createIntent	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   265: astore_1
    //   266: aload_0
    //   267: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   270: aload_1
    //   271: invokevirtual 155	com/tencent/qqmail/activity/readmail/ReadMailFragment:startActivity	(Landroid/content/Intent;)V
    //   274: iconst_1
    //   275: ireturn
    //   276: aload_2
    //   277: ldc 240
    //   279: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   282: ifeq +69 -> 351
    //   285: aload_0
    //   286: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   289: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   292: ifnull +35 -> 327
    //   295: aload_0
    //   296: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   299: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   302: invokevirtual 136	com/tencent/qqmail/model/uidomain/MailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   305: ifnull +22 -> 327
    //   308: invokestatic 224	com/tencent/qqmail/model/mail/QMMailManager:sharedInstance	()Lcom/tencent/qqmail/model/mail/QMMailManager;
    //   311: aload_0
    //   312: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   315: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   318: invokevirtual 136	com/tencent/qqmail/model/uidomain/MailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   321: invokevirtual 142	com/tencent/qqmail/model/qmdomain/MailInformation:getId	()J
    //   324: invokevirtual 244	com/tencent/qqmail/model/mail/QMMailManager:deleteMailTranslateContentById	(J)V
    //   327: aload_0
    //   328: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   331: invokestatic 247	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$18900	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)V
    //   334: aload_0
    //   335: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   338: aload_2
    //   339: ldc 240
    //   341: ldc 204
    //   343: invokevirtual 251	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   346: invokestatic 255	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$19000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;Ljava/lang/String;)V
    //   349: iconst_1
    //   350: ireturn
    //   351: aload_2
    //   352: ldc_w 257
    //   355: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   358: ifeq +32 -> 390
    //   361: ldc_w 259
    //   364: invokestatic 163	com/tencent/qqmail/protocol/DataCollector:logEvent	(Ljava/lang/String;)V
    //   367: aload_2
    //   368: invokevirtual 260	java/lang/String:toString	()Ljava/lang/String;
    //   371: ldc_w 257
    //   374: ldc 204
    //   376: invokevirtual 251	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   379: astore_1
    //   380: aload_0
    //   381: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   384: aload_1
    //   385: invokevirtual 263	com/tencent/qqmail/activity/readmail/ReadMailFragment:showTelDialog	(Ljava/lang/String;)V
    //   388: iconst_1
    //   389: ireturn
    //   390: aload_2
    //   391: ldc_w 265
    //   394: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   397: ifeq +32 -> 429
    //   400: ldc_w 259
    //   403: invokestatic 163	com/tencent/qqmail/protocol/DataCollector:logEvent	(Ljava/lang/String;)V
    //   406: aload_2
    //   407: invokevirtual 260	java/lang/String:toString	()Ljava/lang/String;
    //   410: ldc_w 265
    //   413: ldc 204
    //   415: invokevirtual 251	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   418: astore_1
    //   419: aload_0
    //   420: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   423: aload_1
    //   424: invokevirtual 268	com/tencent/qqmail/activity/readmail/ReadMailFragment:showMailToDialog	(Ljava/lang/String;)V
    //   427: iconst_1
    //   428: ireturn
    //   429: aload_2
    //   430: ldc_w 270
    //   433: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   436: ifeq +61 -> 497
    //   439: ldc_w 259
    //   442: invokestatic 163	com/tencent/qqmail/protocol/DataCollector:logEvent	(Ljava/lang/String;)V
    //   445: aload_2
    //   446: invokestatic 276	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   449: ldc_w 270
    //   452: ldc 204
    //   454: invokevirtual 251	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   457: astore_1
    //   458: aload_1
    //   459: ldc_w 278
    //   462: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   465: iconst_0
    //   466: aaload
    //   467: astore_2
    //   468: aload_1
    //   469: ldc_w 278
    //   472: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   475: iconst_1
    //   476: aaload
    //   477: invokestatic 288	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   480: lstore 6
    //   482: aload_0
    //   483: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   486: aload_2
    //   487: lload 6
    //   489: invokestatic 292	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   492: invokevirtual 296	com/tencent/qqmail/activity/readmail/ReadMailFragment:showCalendarDialog	(Ljava/lang/String;Ljava/lang/Long;)V
    //   495: iconst_1
    //   496: ireturn
    //   497: aload_2
    //   498: invokestatic 301	com/tencent/qqmail/calendar/util/QMCalendarUtil:recognizeUrl	(Ljava/lang/String;)[Ljava/lang/String;
    //   501: ifnull +29 -> 530
    //   504: aload_2
    //   505: invokestatic 301	com/tencent/qqmail/calendar/util/QMCalendarUtil:recognizeUrl	(Ljava/lang/String;)[Ljava/lang/String;
    //   508: astore_1
    //   509: aload_0
    //   510: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   513: aload_1
    //   514: iconst_0
    //   515: aaload
    //   516: aload_1
    //   517: iconst_1
    //   518: aaload
    //   519: invokestatic 305	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$19100	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;Ljava/lang/String;Ljava/lang/String;)V
    //   522: iconst_0
    //   523: newarray double
    //   525: invokestatic 311	moai/oss/KvHelper:eventCalendarShareCalendarFollow	([D)V
    //   528: iconst_1
    //   529: ireturn
    //   530: aload_2
    //   531: ldc_w 313
    //   534: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   537: ifne +23 -> 560
    //   540: aload_2
    //   541: ldc_w 315
    //   544: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   547: ifne +13 -> 560
    //   550: aload_2
    //   551: ldc_w 317
    //   554: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   557: ifeq +19 -> 576
    //   560: ldc_w 259
    //   563: invokestatic 163	com/tencent/qqmail/protocol/DataCollector:logEvent	(Ljava/lang/String;)V
    //   566: aload_0
    //   567: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   570: aload_2
    //   571: invokevirtual 320	com/tencent/qqmail/activity/readmail/ReadMailFragment:openUrl	(Ljava/lang/String;)V
    //   574: iconst_1
    //   575: ireturn
    //   576: aload_0
    //   577: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   580: invokevirtual 323	com/tencent/qqmail/activity/readmail/ReadMailFragment:isShareToWXWhileList	()Z
    //   583: ifeq +427 -> 1010
    //   586: aload_2
    //   587: ldc_w 325
    //   590: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   593: ifeq +417 -> 1010
    //   596: new 327	java/util/ArrayList
    //   599: dup
    //   600: invokespecial 328	java/util/ArrayList:<init>	()V
    //   603: astore_1
    //   604: aload_2
    //   605: ldc_w 330
    //   608: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   611: astore 9
    //   613: aload 9
    //   615: arraylength
    //   616: iconst_1
    //   617: if_icmple +351 -> 968
    //   620: aload_2
    //   621: new 95	java/lang/StringBuilder
    //   624: dup
    //   625: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   628: aload 9
    //   630: iconst_0
    //   631: aaload
    //   632: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: ldc_w 330
    //   638: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   641: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   644: ldc 204
    //   646: invokevirtual 251	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   649: ldc_w 332
    //   652: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   655: astore 9
    //   657: aload 9
    //   659: arraylength
    //   660: iconst_5
    //   661: if_icmpne +265 -> 926
    //   664: iconst_0
    //   665: istore_3
    //   666: iload_3
    //   667: aload 9
    //   669: arraylength
    //   670: if_icmpge +40 -> 710
    //   673: aload 9
    //   675: iload_3
    //   676: aaload
    //   677: ldc_w 334
    //   680: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   683: astore_2
    //   684: aload_2
    //   685: arraylength
    //   686: iconst_2
    //   687: if_icmplt +16 -> 703
    //   690: aload_1
    //   691: aload_2
    //   692: iconst_1
    //   693: aaload
    //   694: invokestatic 276	android/net/Uri:decode	(Ljava/lang/String;)Ljava/lang/String;
    //   697: invokeinterface 339 2 0
    //   702: pop
    //   703: iload_3
    //   704: iconst_1
    //   705: iadd
    //   706: istore_3
    //   707: goto -41 -> 666
    //   710: iconst_4
    //   711: ldc 93
    //   713: new 95	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   720: ldc_w 341
    //   723: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: aload_1
    //   727: iconst_0
    //   728: invokeinterface 345 2 0
    //   733: checkcast 45	java/lang/String
    //   736: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   739: ldc_w 347
    //   742: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload_1
    //   746: iconst_1
    //   747: invokeinterface 345 2 0
    //   752: checkcast 45	java/lang/String
    //   755: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: ldc_w 349
    //   761: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   764: aload_1
    //   765: iconst_2
    //   766: invokeinterface 345 2 0
    //   771: checkcast 45	java/lang/String
    //   774: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: ldc_w 351
    //   780: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_1
    //   784: iconst_3
    //   785: invokeinterface 345 2 0
    //   790: checkcast 45	java/lang/String
    //   793: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   796: ldc_w 353
    //   799: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   802: aload_1
    //   803: iconst_4
    //   804: invokeinterface 345 2 0
    //   809: checkcast 45	java/lang/String
    //   812: iconst_0
    //   813: aload_1
    //   814: iconst_4
    //   815: invokeinterface 345 2 0
    //   820: checkcast 45	java/lang/String
    //   823: invokevirtual 357	java/lang/String:length	()I
    //   826: iconst_1
    //   827: isub
    //   828: invokevirtual 361	java/lang/String:substring	(II)Ljava/lang/String;
    //   831: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   837: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   840: aload_0
    //   841: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   844: aload_1
    //   845: iconst_0
    //   846: invokeinterface 345 2 0
    //   851: checkcast 45	java/lang/String
    //   854: invokestatic 366	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   857: invokevirtual 369	java/lang/Integer:intValue	()I
    //   860: aload_1
    //   861: iconst_1
    //   862: invokeinterface 345 2 0
    //   867: checkcast 45	java/lang/String
    //   870: aload_1
    //   871: iconst_2
    //   872: invokeinterface 345 2 0
    //   877: checkcast 45	java/lang/String
    //   880: aload_1
    //   881: iconst_3
    //   882: invokeinterface 345 2 0
    //   887: checkcast 45	java/lang/String
    //   890: aload_1
    //   891: iconst_4
    //   892: invokeinterface 345 2 0
    //   897: checkcast 45	java/lang/String
    //   900: iconst_0
    //   901: aload_1
    //   902: iconst_4
    //   903: invokeinterface 345 2 0
    //   908: checkcast 45	java/lang/String
    //   911: invokevirtual 357	java/lang/String:length	()I
    //   914: iconst_1
    //   915: isub
    //   916: invokevirtual 361	java/lang/String:substring	(II)Ljava/lang/String;
    //   919: bipush 7
    //   921: invokevirtual 373	com/tencent/qqmail/activity/readmail/ReadMailFragment:shareMailToWX	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   924: iconst_1
    //   925: ireturn
    //   926: invokestatic 378	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   929: ldc_w 380
    //   932: iconst_0
    //   933: invokestatic 386	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   936: invokevirtual 389	android/widget/Toast:show	()V
    //   939: bipush 6
    //   941: ldc 93
    //   943: new 95	java/lang/StringBuilder
    //   946: dup
    //   947: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   950: ldc_w 391
    //   953: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   956: aload_2
    //   957: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   960: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   963: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   966: iconst_1
    //   967: ireturn
    //   968: invokestatic 378	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   971: ldc_w 380
    //   974: iconst_0
    //   975: invokestatic 386	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   978: invokevirtual 389	android/widget/Toast:show	()V
    //   981: bipush 6
    //   983: ldc 93
    //   985: new 95	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 391
    //   995: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_2
    //   999: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1002: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1005: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1008: iconst_1
    //   1009: ireturn
    //   1010: aload_2
    //   1011: ldc_w 393
    //   1014: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1017: ifeq +118 -> 1135
    //   1020: aload_0
    //   1021: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1024: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   1027: ifnull +213 -> 1240
    //   1030: aload_0
    //   1031: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1034: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   1037: invokevirtual 136	com/tencent/qqmail/model/uidomain/MailUI:getInformation	()Lcom/tencent/qqmail/model/qmdomain/MailInformation;
    //   1040: invokevirtual 397	com/tencent/qqmail/model/qmdomain/MailInformation:getFrom	()Lcom/tencent/qqmail/model/qmdomain/MailContact;
    //   1043: astore 9
    //   1045: aload 9
    //   1047: ifnull +193 -> 1240
    //   1050: aload 9
    //   1052: invokevirtual 402	com/tencent/qqmail/model/qmdomain/MailContact:getAddress	()Ljava/lang/String;
    //   1055: astore 9
    //   1057: aload_0
    //   1058: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1061: aload 9
    //   1063: invokestatic 406	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$19200	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;Ljava/lang/String;)Z
    //   1066: ifeq +174 -> 1240
    //   1069: new 408	com/tencent/qqmail/schema/SchemaTools
    //   1072: dup
    //   1073: aload_0
    //   1074: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1077: invokevirtual 126	com/tencent/qqmail/activity/readmail/ReadMailFragment:getActivity	()Lmoai/fragment/app/FragmentActivity;
    //   1080: aload_2
    //   1081: invokespecial 411	com/tencent/qqmail/schema/SchemaTools:<init>	(Landroid/content/Context;Ljava/lang/String;)V
    //   1084: astore_1
    //   1085: aload_1
    //   1086: invokevirtual 414	com/tencent/qqmail/schema/SchemaTools:parseParams	()V
    //   1089: aload_1
    //   1090: iconst_0
    //   1091: invokevirtual 418	com/tencent/qqmail/schema/SchemaTools:doAction	(I)Z
    //   1094: istore 8
    //   1096: iconst_3
    //   1097: ldc 93
    //   1099: new 95	java/lang/StringBuilder
    //   1102: dup
    //   1103: invokespecial 98	java/lang/StringBuilder:<init>	()V
    //   1106: ldc_w 420
    //   1109: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1112: aload_2
    //   1113: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: ldc_w 422
    //   1119: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1122: iload 8
    //   1124: invokevirtual 425	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1127: invokevirtual 107	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1130: invokestatic 113	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   1133: iconst_1
    //   1134: ireturn
    //   1135: aload_2
    //   1136: invokevirtual 428	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1139: ldc_w 430
    //   1142: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1145: ifeq +85 -> 1230
    //   1148: aload_0
    //   1149: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1152: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   1155: ifnull +85 -> 1240
    //   1158: aload_0
    //   1159: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1162: invokestatic 130	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$000	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/model/uidomain/MailUI;
    //   1165: invokevirtual 169	com/tencent/qqmail/model/uidomain/MailUI:getStatus	()Lcom/tencent/qqmail/model/qmdomain/MailStatus;
    //   1168: invokevirtual 433	com/tencent/qqmail/model/qmdomain/MailStatus:isAppleIdMail	()Z
    //   1171: ifeq +69 -> 1240
    //   1174: aload_2
    //   1175: invokevirtual 428	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   1178: ldc_w 435
    //   1181: ldc 204
    //   1183: invokevirtual 251	java/lang/String:replace	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    //   1186: invokestatic 366	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   1189: invokevirtual 369	java/lang/Integer:intValue	()I
    //   1192: istore 4
    //   1194: iload 4
    //   1196: istore_3
    //   1197: aload_0
    //   1198: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1201: invokestatic 53	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$2400	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/view/QMReadMailView;
    //   1204: ifnull -1096 -> 108
    //   1207: aload_0
    //   1208: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1211: invokestatic 53	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$2400	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Lcom/tencent/qqmail/view/QMReadMailView;
    //   1214: invokevirtual 437	com/tencent/qqmail/view/QMReadMailView:getStatus	()I
    //   1217: ifeq -1109 -> 108
    //   1220: aload_0
    //   1221: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1224: iload_3
    //   1225: invokestatic 441	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$19300	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;I)V
    //   1228: iconst_1
    //   1229: ireturn
    //   1230: aload_2
    //   1231: ldc_w 443
    //   1234: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1237: ifne -1129 -> 108
    //   1240: aload_0
    //   1241: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1244: invokestatic 446	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$19400	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Z
    //   1247: ifeq +219 -> 1466
    //   1250: aload_2
    //   1251: ldc_w 448
    //   1254: invokevirtual 122	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1257: ifeq +209 -> 1466
    //   1260: aload_2
    //   1261: ldc_w 450
    //   1264: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1267: astore 11
    //   1269: aload 11
    //   1271: arraylength
    //   1272: istore 5
    //   1274: aconst_null
    //   1275: astore 9
    //   1277: aconst_null
    //   1278: astore_1
    //   1279: iload 4
    //   1281: istore_3
    //   1282: aload 9
    //   1284: astore 10
    //   1286: aload_1
    //   1287: astore_2
    //   1288: iload_3
    //   1289: iload 5
    //   1291: if_icmpge +114 -> 1405
    //   1294: aload 11
    //   1296: iload_3
    //   1297: aaload
    //   1298: ldc_w 452
    //   1301: invokevirtual 282	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   1304: astore_2
    //   1305: aload_2
    //   1306: arraylength
    //   1307: iconst_2
    //   1308: if_icmpne +82 -> 1390
    //   1311: aload_2
    //   1312: iconst_0
    //   1313: aaload
    //   1314: ldc_w 454
    //   1317: invokestatic 459	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1320: astore 10
    //   1322: aload_2
    //   1323: iconst_1
    //   1324: aaload
    //   1325: ldc_w 454
    //   1328: invokestatic 459	java/net/URLDecoder:decode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   1331: astore_2
    //   1332: aload 10
    //   1334: ldc_w 461
    //   1337: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1340: ifeq +12 -> 1352
    //   1343: aload 9
    //   1345: astore 10
    //   1347: aload_1
    //   1348: astore_2
    //   1349: goto +183 -> 1532
    //   1352: aload 10
    //   1354: ldc_w 463
    //   1357: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1360: ifeq +11 -> 1371
    //   1363: aload_2
    //   1364: astore 10
    //   1366: aload_1
    //   1367: astore_2
    //   1368: goto +164 -> 1532
    //   1371: aload 10
    //   1373: ldc_w 465
    //   1376: invokevirtual 49	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1379: istore 8
    //   1381: aload 9
    //   1383: astore 10
    //   1385: iload 8
    //   1387: ifne +145 -> 1532
    //   1390: aload 9
    //   1392: astore 10
    //   1394: aload_1
    //   1395: astore_2
    //   1396: goto +136 -> 1532
    //   1399: astore_1
    //   1400: aconst_null
    //   1401: astore 10
    //   1403: aconst_null
    //   1404: astore_2
    //   1405: new 467	com/tencent/qqmail/model/uidomain/ComposeMailUI
    //   1408: dup
    //   1409: invokespecial 468	com/tencent/qqmail/model/uidomain/ComposeMailUI:<init>	()V
    //   1412: astore_1
    //   1413: aload_1
    //   1414: getstatic 474	com/tencent/qqmail/model/uidomain/ComposeMailUI$QMComposeMailType:COMPOSE_TYPE_FEED_BACK	Lcom/tencent/qqmail/model/uidomain/ComposeMailUI$QMComposeMailType;
    //   1417: invokevirtual 478	com/tencent/qqmail/model/uidomain/ComposeMailUI:setType	(Lcom/tencent/qqmail/model/uidomain/ComposeMailUI$QMComposeMailType;)V
    //   1420: aload_1
    //   1421: ldc_w 480
    //   1424: invokestatic 485	com/tencent/qqmail/activity/compose/ComposeFeedbackActivity:createIntent	(Lcom/tencent/qqmail/model/uidomain/ComposeMailUI;Ljava/lang/String;)Landroid/content/Intent;
    //   1427: astore_1
    //   1428: aload_1
    //   1429: ldc_w 487
    //   1432: aload_2
    //   1433: invokevirtual 493	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1436: pop
    //   1437: aload_1
    //   1438: ldc_w 495
    //   1441: aload 10
    //   1443: invokevirtual 493	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   1446: pop
    //   1447: aload_1
    //   1448: ldc_w 497
    //   1451: iconst_1
    //   1452: invokevirtual 500	android/content/Intent:putExtra	(Ljava/lang/String;I)Landroid/content/Intent;
    //   1455: pop
    //   1456: aload_0
    //   1457: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1460: aload_1
    //   1461: invokevirtual 155	com/tencent/qqmail/activity/readmail/ReadMailFragment:startActivity	(Landroid/content/Intent;)V
    //   1464: iconst_1
    //   1465: ireturn
    //   1466: aload_0
    //   1467: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1470: invokestatic 74	com/tencent/qqmail/activity/readmail/ReadMailFragment:access$18600	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;)Z
    //   1473: ifeq +35 -> 1508
    //   1476: aload_2
    //   1477: new 502	com/tencent/qqmail/activity/readmail/ReadMailFragment$118$1
    //   1480: dup
    //   1481: aload_0
    //   1482: aload_1
    //   1483: invokespecial 505	com/tencent/qqmail/activity/readmail/ReadMailFragment$118$1:<init>	(Lcom/tencent/qqmail/activity/readmail/ReadMailFragment$118;Landroid/webkit/WebView;)V
    //   1486: invokestatic 509	com/tencent/qqmail/popularize/JSApiUitil:handleJSRequest	(Ljava/lang/String;Lcom/tencent/qqmail/popularize/JSApiUitil$JSAPIDelegate;)Z
    //   1489: ifne -1381 -> 108
    //   1492: aload_0
    //   1493: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1496: invokevirtual 126	com/tencent/qqmail/activity/readmail/ReadMailFragment:getActivity	()Lmoai/fragment/app/FragmentActivity;
    //   1499: aload_2
    //   1500: iconst_1
    //   1501: iconst_4
    //   1502: invokestatic 515	com/tencent/qqmail/schema/SchemaUtil:handleSchemaAction	(Landroid/content/Context;Ljava/lang/String;II)Z
    //   1505: ifne -1397 -> 108
    //   1508: aload_0
    //   1509: getfield 10	com/tencent/qqmail/activity/readmail/ReadMailFragment$118:this$0	Lcom/tencent/qqmail/activity/readmail/ReadMailFragment;
    //   1512: aload_2
    //   1513: invokevirtual 320	com/tencent/qqmail/activity/readmail/ReadMailFragment:openUrl	(Ljava/lang/String;)V
    //   1516: iconst_1
    //   1517: ireturn
    //   1518: astore_2
    //   1519: aload 9
    //   1521: astore 10
    //   1523: aload_1
    //   1524: astore_2
    //   1525: goto -120 -> 1405
    //   1528: astore_1
    //   1529: goto -332 -> 1197
    //   1532: iload_3
    //   1533: iconst_1
    //   1534: iadd
    //   1535: istore_3
    //   1536: aload_2
    //   1537: astore_1
    //   1538: aload 10
    //   1540: astore 9
    //   1542: goto -260 -> 1282
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1545	0	this	118
    //   0	1545	1	paramWebView	WebView
    //   0	1545	2	paramString	String
    //   4	1532	3	i	int
    //   1	1279	4	j	int
    //   1272	20	5	k	int
    //   480	8	6	l	long
    //   1094	292	8	bool	boolean
    //   611	930	9	localObject1	java.lang.Object
    //   1284	255	10	localObject2	java.lang.Object
    //   1267	28	11	arrayOfString	String[]
    // Exception table:
    //   from	to	target	type
    //   1260	1274	1399	java/lang/Exception
    //   1294	1343	1518	java/lang/Exception
    //   1352	1363	1518	java/lang/Exception
    //   1371	1381	1518	java/lang/Exception
    //   1174	1194	1528	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.readmail.ReadMailFragment.118
 * JD-Core Version:    0.7.0.1
 */