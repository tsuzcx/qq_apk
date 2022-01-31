package com.tencent.mobileqq.emosm.web;

import android.os.Handler;

class MessengerService$IncomingHandler
  extends Handler
{
  MessengerService$IncomingHandler(MessengerService paramMessengerService) {}
  
  /* Error */
  public void handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnull +16 -> 17
    //   4: aload_0
    //   5: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   8: invokestatic 26	com/tencent/mobileqq/emosm/web/MessengerService:access$000	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   11: instanceof 28
    //   14: ifne +4 -> 18
    //   17: return
    //   18: aload_0
    //   19: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   22: invokestatic 31	com/tencent/mobileqq/emosm/web/MessengerService:access$100	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   25: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   28: astore 8
    //   30: aload_1
    //   31: ifnull +21 -> 52
    //   34: aload_1
    //   35: getfield 37	android/os/Message:replyTo	Landroid/os/Messenger;
    //   38: ifnull +14 -> 52
    //   41: aload_0
    //   42: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   45: aload_1
    //   46: getfield 37	android/os/Message:replyTo	Landroid/os/Messenger;
    //   49: putfield 40	com/tencent/mobileqq/emosm/web/MessengerService:mClient	Landroid/os/Messenger;
    //   52: aload_0
    //   53: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   56: invokestatic 43	com/tencent/mobileqq/emosm/web/MessengerService:access$200	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   59: bipush 39
    //   61: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   64: checkcast 51	com/tencent/mobileqq/emoticon/EmojiManager
    //   67: astore 10
    //   69: aload_1
    //   70: getfield 55	android/os/Message:what	I
    //   73: tableswitch	default:+27 -> 100, 1:+33->106, 2:+85->158, 3:+125->198
    //   101: aload_1
    //   102: invokespecial 57	android/os/Handler:handleMessage	(Landroid/os/Message;)V
    //   105: return
    //   106: aload_0
    //   107: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   110: aload_1
    //   111: getfield 37	android/os/Message:replyTo	Landroid/os/Messenger;
    //   114: putfield 40	com/tencent/mobileqq/emosm/web/MessengerService:mClient	Landroid/os/Messenger;
    //   117: aload 8
    //   119: ifnull +23 -> 142
    //   122: aload 10
    //   124: ifnull +18 -> 142
    //   127: aload 10
    //   129: getfield 61	com/tencent/mobileqq/emoticon/EmojiManager:a	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   132: aload_0
    //   133: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   136: getfield 65	com/tencent/mobileqq/emosm/web/MessengerService:mListener	Lcom/tencent/mobileqq/emoticon/EmoticonPackageDownloadListener;
    //   139: invokevirtual 70	com/tencent/mobileqq/emoticon/EmojiListenerManager:a	(Lcom/tencent/mobileqq/emoticon/EmoticonPackageDownloadListener;)V
    //   142: invokestatic 75	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipLockWebImpl;
    //   145: aload 8
    //   147: aload_0
    //   148: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   151: getfield 40	com/tencent/mobileqq/emosm/web/MessengerService:mClient	Landroid/os/Messenger;
    //   154: invokevirtual 78	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Landroid/os/Messenger;)V
    //   157: return
    //   158: aload 8
    //   160: ifnull +23 -> 183
    //   163: aload 10
    //   165: ifnull +18 -> 183
    //   168: aload 10
    //   170: getfield 61	com/tencent/mobileqq/emoticon/EmojiManager:a	Lcom/tencent/mobileqq/emoticon/EmojiListenerManager;
    //   173: aload_0
    //   174: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   177: getfield 65	com/tencent/mobileqq/emosm/web/MessengerService:mListener	Lcom/tencent/mobileqq/emoticon/EmoticonPackageDownloadListener;
    //   180: invokevirtual 81	com/tencent/mobileqq/emoticon/EmojiListenerManager:b	(Lcom/tencent/mobileqq/emoticon/EmoticonPackageDownloadListener;)V
    //   183: invokestatic 75	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipLockWebImpl;
    //   186: invokevirtual 83	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	()V
    //   189: aload_0
    //   190: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   193: aconst_null
    //   194: putfield 40	com/tencent/mobileqq/emosm/web/MessengerService:mClient	Landroid/os/Messenger;
    //   197: return
    //   198: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +11 -> 212
    //   204: ldc 91
    //   206: iconst_2
    //   207: ldc 93
    //   209: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: aload_1
    //   213: invokevirtual 101	android/os/Message:getData	()Landroid/os/Bundle;
    //   216: astore 9
    //   218: aload 9
    //   220: ifnull -203 -> 17
    //   223: aload 9
    //   225: ldc 103
    //   227: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   230: astore 11
    //   232: aload 9
    //   234: ldc 111
    //   236: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   239: astore_1
    //   240: aload 11
    //   242: ldc 117
    //   244: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   247: ifeq +142 -> 389
    //   250: aload 10
    //   252: aload_1
    //   253: invokevirtual 126	com/tencent/mobileqq/emoticon/EmojiManager:b	(Landroid/os/Bundle;)Landroid/os/Bundle;
    //   256: astore_1
    //   257: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   260: ifeq +107 -> 367
    //   263: aload_1
    //   264: ifnull +103 -> 367
    //   267: ldc 91
    //   269: iconst_2
    //   270: new 128	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   277: ldc 131
    //   279: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_1
    //   283: ldc 137
    //   285: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   288: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   291: ldc 146
    //   293: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: aload_1
    //   297: ldc 148
    //   299: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   302: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   305: ldc 150
    //   307: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: aload_1
    //   311: ldc 152
    //   313: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   316: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: ldc 154
    //   321: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: aload_1
    //   325: ldc 156
    //   327: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   330: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   333: ldc 158
    //   335: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: aload_1
    //   339: ldc 160
    //   341: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   344: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   347: ldc 162
    //   349: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: aload_1
    //   353: ldc 164
    //   355: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   358: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   361: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   367: aload_1
    //   368: ifnull +11 -> 379
    //   371: aload 9
    //   373: ldc 177
    //   375: aload_1
    //   376: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   379: aload_0
    //   380: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   383: aload 9
    //   385: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   388: return
    //   389: aload 11
    //   391: ldc 187
    //   393: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   396: ifeq +31 -> 427
    //   399: aload 10
    //   401: invokevirtual 189	com/tencent/mobileqq/emoticon/EmojiManager:a	()Landroid/os/Bundle;
    //   404: astore_1
    //   405: aload_1
    //   406: ifnull +11 -> 417
    //   409: aload 9
    //   411: ldc 177
    //   413: aload_1
    //   414: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   417: aload_0
    //   418: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   421: aload 9
    //   423: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   426: return
    //   427: aload 11
    //   429: ldc 191
    //   431: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   434: ifeq +91 -> 525
    //   437: aload_0
    //   438: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   441: invokestatic 194	com/tencent/mobileqq/emosm/web/MessengerService:access$300	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   444: bipush 39
    //   446: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   449: checkcast 51	com/tencent/mobileqq/emoticon/EmojiManager
    //   452: aload_1
    //   453: invokevirtual 196	com/tencent/mobileqq/emoticon/EmojiManager:a	(Landroid/os/Bundle;)Landroid/os/Bundle;
    //   456: astore_1
    //   457: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +47 -> 507
    //   463: ldc 91
    //   465: iconst_2
    //   466: new 128	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   473: ldc 198
    //   475: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: aload_1
    //   479: ldc 137
    //   481: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   484: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   487: ldc 200
    //   489: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_1
    //   493: ldc 202
    //   495: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   498: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   504: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   507: aload 9
    //   509: ldc 177
    //   511: aload_1
    //   512: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   515: aload_0
    //   516: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   519: aload 9
    //   521: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   524: return
    //   525: aload 11
    //   527: ldc 204
    //   529: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   532: ifeq +99 -> 631
    //   535: aload_0
    //   536: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   539: invokestatic 207	com/tencent/mobileqq/emosm/web/MessengerService:access$400	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   542: bipush 39
    //   544: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   547: checkcast 51	com/tencent/mobileqq/emoticon/EmojiManager
    //   550: aload_1
    //   551: ldc 148
    //   553: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   556: invokestatic 211	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   559: invokevirtual 213	com/tencent/mobileqq/emoticon/EmojiManager:a	(Ljava/lang/String;)Landroid/os/Bundle;
    //   562: astore_1
    //   563: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   566: ifeq +47 -> 613
    //   569: ldc 91
    //   571: iconst_2
    //   572: new 128	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   579: ldc 215
    //   581: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: aload_1
    //   585: ldc 137
    //   587: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   590: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   593: ldc 200
    //   595: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: aload_1
    //   599: ldc 217
    //   601: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   604: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload 9
    //   615: ldc 177
    //   617: aload_1
    //   618: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   621: aload_0
    //   622: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   625: aload 9
    //   627: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   630: return
    //   631: ldc 219
    //   633: aload 11
    //   635: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   638: ifeq +74 -> 712
    //   641: aload 10
    //   643: aload_1
    //   644: invokevirtual 222	com/tencent/mobileqq/emoticon/EmojiManager:c	(Landroid/os/Bundle;)Landroid/os/Bundle;
    //   647: astore_1
    //   648: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   651: ifeq +51 -> 702
    //   654: aload_1
    //   655: ifnull +47 -> 702
    //   658: ldc 91
    //   660: iconst_2
    //   661: new 128	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   668: ldc 224
    //   670: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: aload_1
    //   674: ldc 137
    //   676: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   679: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   682: ldc 200
    //   684: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   687: aload_1
    //   688: ldc 217
    //   690: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   693: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 97	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: aload_0
    //   703: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   706: aload 9
    //   708: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   711: return
    //   712: ldc 226
    //   714: aload 11
    //   716: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   719: ifeq +59 -> 778
    //   722: aload 8
    //   724: iconst_1
    //   725: aload 9
    //   727: ldc 111
    //   729: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   732: ldc 228
    //   734: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   737: iconst_0
    //   738: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   741: astore_1
    //   742: new 105	android/os/Bundle
    //   745: dup
    //   746: invokespecial 232	android/os/Bundle:<init>	()V
    //   749: astore 8
    //   751: aload 8
    //   753: ldc 234
    //   755: aload_1
    //   756: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   759: aload 9
    //   761: ldc 177
    //   763: aload 8
    //   765: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   768: aload_0
    //   769: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   772: aload 9
    //   774: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   777: return
    //   778: ldc 240
    //   780: aload 11
    //   782: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   785: ifeq +56 -> 841
    //   788: aload 8
    //   790: aload 9
    //   792: ldc 111
    //   794: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   797: ldc 242
    //   799: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   802: invokestatic 247	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   805: istore 5
    //   807: new 105	android/os/Bundle
    //   810: dup
    //   811: invokespecial 232	android/os/Bundle:<init>	()V
    //   814: astore_1
    //   815: aload_1
    //   816: ldc 249
    //   818: iload 5
    //   820: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   823: aload 9
    //   825: ldc 177
    //   827: aload_1
    //   828: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   831: aload_0
    //   832: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   835: aload 9
    //   837: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   840: return
    //   841: ldc 255
    //   843: aload 11
    //   845: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   848: ifeq +71 -> 919
    //   851: aload 8
    //   853: bipush 12
    //   855: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   858: checkcast 260	com/tencent/mobileqq/app/SVIPHandler
    //   861: invokevirtual 263	com/tencent/mobileqq/app/SVIPHandler:c	()I
    //   864: istore_2
    //   865: aload 8
    //   867: invokevirtual 267	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   870: invokestatic 272	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   873: astore 9
    //   875: iload_2
    //   876: iconst_3
    //   877: if_icmpne +3182 -> 4059
    //   880: iconst_2
    //   881: istore_2
    //   882: aload 9
    //   884: aload 8
    //   886: aload 8
    //   888: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   891: aload_1
    //   892: ldc_w 276
    //   895: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   898: aload_1
    //   899: ldc_w 278
    //   902: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   905: iconst_0
    //   906: iconst_1
    //   907: aconst_null
    //   908: iload_2
    //   909: invokestatic 211	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   912: aconst_null
    //   913: aconst_null
    //   914: aconst_null
    //   915: invokevirtual 281	com/tencent/mobileqq/statistics/StatisticCollector:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   918: return
    //   919: ldc_w 283
    //   922: aload 11
    //   924: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   927: ifeq +63 -> 990
    //   930: aload_1
    //   931: ldc 148
    //   933: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   936: istore_2
    //   937: aload 8
    //   939: bipush 12
    //   941: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   944: checkcast 260	com/tencent/mobileqq/app/SVIPHandler
    //   947: iload_2
    //   948: invokevirtual 286	com/tencent/mobileqq/app/SVIPHandler:a	(I)V
    //   951: new 105	android/os/Bundle
    //   954: dup
    //   955: invokespecial 232	android/os/Bundle:<init>	()V
    //   958: astore_1
    //   959: aload_1
    //   960: ldc 148
    //   962: iload_2
    //   963: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   966: aload 9
    //   968: ldc 177
    //   970: aload_1
    //   971: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   974: aload_0
    //   975: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   978: aload 9
    //   980: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   983: return
    //   984: astore_1
    //   985: aload_1
    //   986: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   989: return
    //   990: ldc_w 295
    //   993: aload 11
    //   995: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   998: ifeq +50 -> 1048
    //   1001: aload 8
    //   1003: bipush 12
    //   1005: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1008: checkcast 260	com/tencent/mobileqq/app/SVIPHandler
    //   1011: invokevirtual 297	com/tencent/mobileqq/app/SVIPHandler:b	()I
    //   1014: istore_2
    //   1015: new 105	android/os/Bundle
    //   1018: dup
    //   1019: invokespecial 232	android/os/Bundle:<init>	()V
    //   1022: astore_1
    //   1023: aload_1
    //   1024: ldc 148
    //   1026: iload_2
    //   1027: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1030: aload 9
    //   1032: ldc 177
    //   1034: aload_1
    //   1035: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1038: aload_0
    //   1039: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1042: aload 9
    //   1044: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1047: return
    //   1048: ldc 226
    //   1050: aload 11
    //   1052: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1055: ifeq +59 -> 1114
    //   1058: aload 8
    //   1060: iconst_1
    //   1061: aload 9
    //   1063: ldc 111
    //   1065: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1068: ldc 228
    //   1070: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1073: iconst_0
    //   1074: invokevirtual 231	com/tencent/mobileqq/app/QQAppInterface:a	(ILjava/lang/String;I)Ljava/lang/String;
    //   1077: astore_1
    //   1078: new 105	android/os/Bundle
    //   1081: dup
    //   1082: invokespecial 232	android/os/Bundle:<init>	()V
    //   1085: astore 8
    //   1087: aload 8
    //   1089: ldc 234
    //   1091: aload_1
    //   1092: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1095: aload 9
    //   1097: ldc 177
    //   1099: aload 8
    //   1101: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1104: aload_0
    //   1105: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1108: aload 9
    //   1110: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1113: return
    //   1114: ldc 240
    //   1116: aload 11
    //   1118: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1121: ifeq +56 -> 1177
    //   1124: aload 8
    //   1126: aload 9
    //   1128: ldc 111
    //   1130: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   1133: ldc 242
    //   1135: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1138: invokestatic 247	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   1141: istore 5
    //   1143: new 105	android/os/Bundle
    //   1146: dup
    //   1147: invokespecial 232	android/os/Bundle:<init>	()V
    //   1150: astore_1
    //   1151: aload_1
    //   1152: ldc 249
    //   1154: iload 5
    //   1156: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1159: aload 9
    //   1161: ldc 177
    //   1163: aload_1
    //   1164: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1167: aload_0
    //   1168: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1171: aload 9
    //   1173: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1176: return
    //   1177: ldc_w 299
    //   1180: aload 11
    //   1182: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1185: ifeq +225 -> 1410
    //   1188: aload_1
    //   1189: ldc_w 301
    //   1192: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1195: astore 8
    //   1197: aload_1
    //   1198: ldc_w 303
    //   1201: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1204: astore 10
    //   1206: aload_1
    //   1207: ldc_w 305
    //   1210: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1213: lstore 6
    //   1215: aload_1
    //   1216: ldc 148
    //   1218: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1221: astore 11
    //   1223: aload_1
    //   1224: ldc_w 307
    //   1227: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1230: astore 12
    //   1232: new 105	android/os/Bundle
    //   1235: dup
    //   1236: invokespecial 232	android/os/Bundle:<init>	()V
    //   1239: astore_1
    //   1240: aload_1
    //   1241: ldc 148
    //   1243: aload 11
    //   1245: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1248: aload_1
    //   1249: ldc_w 307
    //   1252: aload 12
    //   1254: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1257: aload_1
    //   1258: ldc_w 305
    //   1261: lload 6
    //   1263: invokevirtual 311	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   1266: aload_1
    //   1267: ldc_w 313
    //   1270: iconst_4
    //   1271: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1274: aload_1
    //   1275: ldc_w 315
    //   1278: aload 9
    //   1280: ldc_w 317
    //   1283: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1286: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1289: new 319	com/tencent/mobileqq/vip/DownloadTask
    //   1292: dup
    //   1293: aload 8
    //   1295: new 321	java/io/File
    //   1298: dup
    //   1299: aload 10
    //   1301: invokespecial 324	java/io/File:<init>	(Ljava/lang/String;)V
    //   1304: invokespecial 327	com/tencent/mobileqq/vip/DownloadTask:<init>	(Ljava/lang/String;Ljava/io/File;)V
    //   1307: astore 8
    //   1309: aload 8
    //   1311: iconst_1
    //   1312: putfield 330	com/tencent/mobileqq/vip/DownloadTask:b	Z
    //   1315: lload 6
    //   1317: ldc2_w 331
    //   1320: ldiv
    //   1321: l2i
    //   1322: istore_2
    //   1323: iload_2
    //   1324: sipush 2048
    //   1327: if_icmple +9 -> 1336
    //   1330: aload 8
    //   1332: iload_2
    //   1333: invokevirtual 334	com/tencent/mobileqq/vip/DownloadTask:b	(I)V
    //   1336: aload 8
    //   1338: iconst_0
    //   1339: invokevirtual 337	com/tencent/mobileqq/vip/DownloadTask:b	(Z)V
    //   1342: aload_0
    //   1343: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1346: invokestatic 340	com/tencent/mobileqq/emosm/web/MessengerService:access$500	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   1349: bipush 41
    //   1351: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1354: checkcast 342	com/tencent/mobileqq/vip/DownloaderFactory
    //   1357: iconst_1
    //   1358: invokevirtual 345	com/tencent/mobileqq/vip/DownloaderFactory:a	(I)Lcom/tencent/mobileqq/vip/DownloaderInterface;
    //   1361: aload 8
    //   1363: aload_0
    //   1364: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1367: getfield 349	com/tencent/mobileqq/emosm/web/MessengerService:mThemeDownloadListener	Lcom/tencent/mobileqq/vip/DownloadListener;
    //   1370: aload_1
    //   1371: invokeinterface 354 4 0
    //   1376: new 105	android/os/Bundle
    //   1379: dup
    //   1380: invokespecial 232	android/os/Bundle:<init>	()V
    //   1383: astore_1
    //   1384: aload_1
    //   1385: ldc_w 356
    //   1388: iconst_1
    //   1389: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1392: aload 9
    //   1394: ldc 177
    //   1396: aload_1
    //   1397: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1400: aload_0
    //   1401: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1404: aload 9
    //   1406: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1409: return
    //   1410: ldc_w 358
    //   1413: aload 11
    //   1415: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1418: ifeq +91 -> 1509
    //   1421: aload_1
    //   1422: ifnull -1405 -> 17
    //   1425: new 105	android/os/Bundle
    //   1428: dup
    //   1429: invokespecial 232	android/os/Bundle:<init>	()V
    //   1432: astore 8
    //   1434: aload_1
    //   1435: ldc_w 301
    //   1438: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1441: astore_1
    //   1442: aload_0
    //   1443: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1446: invokestatic 361	com/tencent/mobileqq/emosm/web/MessengerService:access$600	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   1449: bipush 41
    //   1451: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1454: checkcast 342	com/tencent/mobileqq/vip/DownloaderFactory
    //   1457: iconst_1
    //   1458: invokevirtual 345	com/tencent/mobileqq/vip/DownloaderFactory:a	(I)Lcom/tencent/mobileqq/vip/DownloaderInterface;
    //   1461: iconst_0
    //   1462: aload_1
    //   1463: invokeinterface 364 3 0
    //   1468: ifne +35 -> 1503
    //   1471: iconst_1
    //   1472: istore 5
    //   1474: aload 8
    //   1476: ldc_w 366
    //   1479: iload 5
    //   1481: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1484: aload 9
    //   1486: ldc 177
    //   1488: aload 8
    //   1490: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1493: aload_0
    //   1494: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1497: aload 9
    //   1499: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1502: return
    //   1503: iconst_0
    //   1504: istore 5
    //   1506: goto -32 -> 1474
    //   1509: ldc_w 368
    //   1512: aload 11
    //   1514: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1517: ifeq +91 -> 1608
    //   1520: aload_1
    //   1521: ifnull -1504 -> 17
    //   1524: new 105	android/os/Bundle
    //   1527: dup
    //   1528: invokespecial 232	android/os/Bundle:<init>	()V
    //   1531: astore_1
    //   1532: aload 9
    //   1534: ldc_w 301
    //   1537: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1540: astore 8
    //   1542: aload_0
    //   1543: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1546: invokestatic 371	com/tencent/mobileqq/emosm/web/MessengerService:access$700	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   1549: bipush 41
    //   1551: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1554: checkcast 342	com/tencent/mobileqq/vip/DownloaderFactory
    //   1557: iconst_1
    //   1558: invokevirtual 345	com/tencent/mobileqq/vip/DownloaderFactory:a	(I)Lcom/tencent/mobileqq/vip/DownloaderInterface;
    //   1561: iconst_0
    //   1562: aload 8
    //   1564: invokeinterface 364 3 0
    //   1569: ifne +33 -> 1602
    //   1572: iconst_1
    //   1573: istore 5
    //   1575: aload_1
    //   1576: ldc_w 366
    //   1579: iload 5
    //   1581: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1584: aload 9
    //   1586: ldc 177
    //   1588: aload_1
    //   1589: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1592: aload_0
    //   1593: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1596: aload 9
    //   1598: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1601: return
    //   1602: iconst_0
    //   1603: istore 5
    //   1605: goto -30 -> 1575
    //   1608: ldc_w 373
    //   1611: aload 11
    //   1613: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1616: ifeq +140 -> 1756
    //   1619: aload_1
    //   1620: ldc_w 375
    //   1623: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1626: astore 9
    //   1628: aload_1
    //   1629: ldc_w 377
    //   1632: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1635: astore 10
    //   1637: aload_1
    //   1638: ldc 137
    //   1640: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1643: istore 4
    //   1645: aload_1
    //   1646: ldc_w 379
    //   1649: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1652: astore 11
    //   1654: aload_1
    //   1655: ldc_w 381
    //   1658: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1661: astore 12
    //   1663: aload_1
    //   1664: ldc_w 383
    //   1667: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1670: lstore 6
    //   1672: aload 8
    //   1674: bipush 12
    //   1676: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1679: checkcast 260	com/tencent/mobileqq/app/SVIPHandler
    //   1682: invokevirtual 263	com/tencent/mobileqq/app/SVIPHandler:c	()I
    //   1685: istore_3
    //   1686: iload_3
    //   1687: iconst_2
    //   1688: if_icmpne +56 -> 1744
    //   1691: iconst_0
    //   1692: istore_2
    //   1693: aload 8
    //   1695: ldc_w 385
    //   1698: ldc_w 387
    //   1701: ldc_w 387
    //   1704: aload 9
    //   1706: aload 10
    //   1708: iconst_0
    //   1709: iload 4
    //   1711: aload 11
    //   1713: new 128	java/lang/StringBuilder
    //   1716: dup
    //   1717: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   1720: ldc_w 387
    //   1723: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1726: iload_2
    //   1727: invokevirtual 144	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1730: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1733: aload 12
    //   1735: lload 6
    //   1737: invokestatic 390	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1740: invokestatic 395	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   1743: return
    //   1744: iload_3
    //   1745: istore_2
    //   1746: iload_3
    //   1747: iconst_3
    //   1748: if_icmpne -55 -> 1693
    //   1751: iconst_2
    //   1752: istore_2
    //   1753: goto -60 -> 1693
    //   1756: ldc_w 397
    //   1759: aload 11
    //   1761: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1764: ifeq +45 -> 1809
    //   1767: aload_1
    //   1768: ldc_w 399
    //   1771: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1774: astore 8
    //   1776: aload_1
    //   1777: ldc_w 307
    //   1780: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1783: astore_1
    //   1784: aload_0
    //   1785: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1788: invokestatic 402	com/tencent/mobileqq/emosm/web/MessengerService:access$800	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   1791: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   1794: bipush 13
    //   1796: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1799: checkcast 404	com/tencent/mobileqq/app/ThemeHandler
    //   1802: aload 8
    //   1804: aload_1
    //   1805: invokevirtual 406	com/tencent/mobileqq/app/ThemeHandler:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1808: return
    //   1809: ldc_w 408
    //   1812: aload 11
    //   1814: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1817: ifeq +73 -> 1890
    //   1820: new 105	android/os/Bundle
    //   1823: dup
    //   1824: invokespecial 232	android/os/Bundle:<init>	()V
    //   1827: astore 10
    //   1829: aload 8
    //   1831: bipush 12
    //   1833: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1836: checkcast 260	com/tencent/mobileqq/app/SVIPHandler
    //   1839: astore 8
    //   1841: aload_1
    //   1842: ldc 228
    //   1844: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1847: astore_1
    //   1848: aload 8
    //   1850: invokevirtual 263	com/tencent/mobileqq/app/SVIPHandler:c	()I
    //   1853: istore_2
    //   1854: aload 10
    //   1856: ldc 228
    //   1858: aload_1
    //   1859: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1862: aload 10
    //   1864: ldc_w 410
    //   1867: iload_2
    //   1868: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1871: aload 9
    //   1873: ldc 177
    //   1875: aload 10
    //   1877: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   1880: aload_0
    //   1881: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   1884: aload 9
    //   1886: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   1889: return
    //   1890: ldc_w 412
    //   1893: aload 11
    //   1895: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1898: ifeq +31 -> 1929
    //   1901: aload 8
    //   1903: bipush 17
    //   1905: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   1908: checkcast 414	com/tencent/mobileqq/app/TroopHandler
    //   1911: aload_1
    //   1912: ldc_w 416
    //   1915: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1918: aload_1
    //   1919: ldc_w 410
    //   1922: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1925: invokevirtual 418	com/tencent/mobileqq/app/TroopHandler:b	(Ljava/lang/String;I)V
    //   1928: return
    //   1929: getstatic 424	com/tencent/mobileqq/emosm/web/IPCConstants:IPC_CMD_MAP	Ljava/util/HashMap;
    //   1932: aload 11
    //   1934: invokevirtual 429	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   1937: ifeq +489 -> 2426
    //   1940: getstatic 424	com/tencent/mobileqq/emosm/web/IPCConstants:IPC_CMD_MAP	Ljava/util/HashMap;
    //   1943: aload 11
    //   1945: invokevirtual 433	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1948: checkcast 435	java/lang/Integer
    //   1951: invokevirtual 438	java/lang/Integer:intValue	()I
    //   1954: tableswitch	default:+46 -> 2000, 1:+47->2001, 2:+-1937->17, 3:+117->2071, 4:+143->2097, 5:+203->2157, 6:+330->2284, 7:+256->2210, 8:+404->2358
    //   2001: aload_1
    //   2002: ldc 148
    //   2004: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2007: istore_2
    //   2008: aload 8
    //   2010: bipush 12
    //   2012: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2015: checkcast 260	com/tencent/mobileqq/app/SVIPHandler
    //   2018: iload_2
    //   2019: invokevirtual 439	com/tencent/mobileqq/app/SVIPHandler:b	(I)V
    //   2022: new 105	android/os/Bundle
    //   2025: dup
    //   2026: invokespecial 232	android/os/Bundle:<init>	()V
    //   2029: astore_1
    //   2030: aload_1
    //   2031: ldc 148
    //   2033: iload_2
    //   2034: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2037: aload_1
    //   2038: ldc 137
    //   2040: iconst_0
    //   2041: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2044: aload_1
    //   2045: ldc 202
    //   2047: ldc_w 441
    //   2050: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2053: aload 9
    //   2055: ldc 177
    //   2057: aload_1
    //   2058: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2061: aload_0
    //   2062: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2065: aload 9
    //   2067: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2070: return
    //   2071: aload_0
    //   2072: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2075: invokestatic 444	com/tencent/mobileqq/emosm/web/MessengerService:access$900	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2078: bipush 38
    //   2080: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2083: checkcast 446	com/etrump/mixlayout/FontManager
    //   2086: aload_0
    //   2087: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2090: getfield 450	com/tencent/mobileqq/emosm/web/MessengerService:mVipIPCDownloadListener	Lcom/tencent/mobileqq/vip/IPCDownloadListener;
    //   2093: invokevirtual 453	com/etrump/mixlayout/FontManager:a	(Lcom/tencent/mobileqq/vip/IPCDownloadListener;)V
    //   2096: return
    //   2097: aload_1
    //   2098: ldc 148
    //   2100: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2103: istore_2
    //   2104: aload_0
    //   2105: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2108: invokestatic 456	com/tencent/mobileqq/emosm/web/MessengerService:access$1000	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2111: bipush 38
    //   2113: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2116: checkcast 446	com/etrump/mixlayout/FontManager
    //   2119: iload_2
    //   2120: invokevirtual 459	com/etrump/mixlayout/FontManager:a	(I)I
    //   2123: pop
    //   2124: new 105	android/os/Bundle
    //   2127: dup
    //   2128: invokespecial 232	android/os/Bundle:<init>	()V
    //   2131: astore_1
    //   2132: aload_1
    //   2133: ldc 148
    //   2135: iload_2
    //   2136: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2139: aload 9
    //   2141: ldc 177
    //   2143: aload_1
    //   2144: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2147: aload_0
    //   2148: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2151: aload 9
    //   2153: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2156: return
    //   2157: aload_1
    //   2158: ldc 148
    //   2160: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2163: istore_2
    //   2164: aload 9
    //   2166: ldc_w 317
    //   2169: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2172: astore_1
    //   2173: aload_0
    //   2174: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2177: invokestatic 462	com/tencent/mobileqq/emosm/web/MessengerService:access$1100	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2180: bipush 40
    //   2182: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2185: checkcast 464	com/tencent/mobileqq/bubble/BubbleManager
    //   2188: astore 8
    //   2190: aload 8
    //   2192: aload_0
    //   2193: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2196: getfield 450	com/tencent/mobileqq/emosm/web/MessengerService:mVipIPCDownloadListener	Lcom/tencent/mobileqq/vip/IPCDownloadListener;
    //   2199: invokevirtual 465	com/tencent/mobileqq/bubble/BubbleManager:a	(Lcom/tencent/mobileqq/vip/IPCDownloadListener;)V
    //   2202: aload 8
    //   2204: iload_2
    //   2205: aload_1
    //   2206: invokevirtual 468	com/tencent/mobileqq/bubble/BubbleManager:c	(ILjava/lang/String;)V
    //   2209: return
    //   2210: aload_1
    //   2211: ldc 148
    //   2213: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2216: istore_2
    //   2217: aload_0
    //   2218: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2221: invokestatic 471	com/tencent/mobileqq/emosm/web/MessengerService:access$1200	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2224: bipush 40
    //   2226: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2229: checkcast 464	com/tencent/mobileqq/bubble/BubbleManager
    //   2232: iload_2
    //   2233: invokevirtual 474	com/tencent/mobileqq/bubble/BubbleManager:c	(I)Lorg/json/JSONObject;
    //   2236: astore_1
    //   2237: new 105	android/os/Bundle
    //   2240: dup
    //   2241: invokespecial 232	android/os/Bundle:<init>	()V
    //   2244: astore 8
    //   2246: aload 8
    //   2248: ldc 148
    //   2250: iload_2
    //   2251: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2254: aload 8
    //   2256: ldc 137
    //   2258: aload_1
    //   2259: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2262: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2265: aload 9
    //   2267: ldc 177
    //   2269: aload 8
    //   2271: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2274: aload_0
    //   2275: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2278: aload 9
    //   2280: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2283: return
    //   2284: aload_1
    //   2285: ldc 148
    //   2287: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2290: istore_2
    //   2291: aload_0
    //   2292: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2295: invokestatic 480	com/tencent/mobileqq/emosm/web/MessengerService:access$1300	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2298: bipush 40
    //   2300: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2303: checkcast 464	com/tencent/mobileqq/bubble/BubbleManager
    //   2306: iload_2
    //   2307: invokevirtual 482	com/tencent/mobileqq/bubble/BubbleManager:a	(I)Lorg/json/JSONObject;
    //   2310: astore_1
    //   2311: new 105	android/os/Bundle
    //   2314: dup
    //   2315: invokespecial 232	android/os/Bundle:<init>	()V
    //   2318: astore 8
    //   2320: aload 8
    //   2322: ldc 148
    //   2324: iload_2
    //   2325: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2328: aload 8
    //   2330: ldc 137
    //   2332: aload_1
    //   2333: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2336: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2339: aload 9
    //   2341: ldc 177
    //   2343: aload 8
    //   2345: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2348: aload_0
    //   2349: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2352: aload 9
    //   2354: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2357: return
    //   2358: aload_1
    //   2359: ldc_w 484
    //   2362: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2365: istore_2
    //   2366: aload_0
    //   2367: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2370: invokestatic 487	com/tencent/mobileqq/emosm/web/MessengerService:access$1400	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2373: bipush 38
    //   2375: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2378: checkcast 446	com/etrump/mixlayout/FontManager
    //   2381: astore_1
    //   2382: iload_2
    //   2383: iconst_1
    //   2384: if_icmpne +36 -> 2420
    //   2387: iconst_1
    //   2388: istore 5
    //   2390: aload_1
    //   2391: iload 5
    //   2393: invokevirtual 489	com/etrump/mixlayout/FontManager:a	(Z)V
    //   2396: aload 9
    //   2398: ldc 177
    //   2400: new 105	android/os/Bundle
    //   2403: dup
    //   2404: invokespecial 232	android/os/Bundle:<init>	()V
    //   2407: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2410: aload_0
    //   2411: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2414: aload 9
    //   2416: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2419: return
    //   2420: iconst_0
    //   2421: istore 5
    //   2423: goto -33 -> 2390
    //   2426: ldc_w 491
    //   2429: aload 11
    //   2431: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2434: ifeq +176 -> 2610
    //   2437: aload 9
    //   2439: ldc_w 493
    //   2442: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2445: astore_1
    //   2446: aload 9
    //   2448: ldc_w 495
    //   2451: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2454: astore 10
    //   2456: aload 9
    //   2458: ldc_w 497
    //   2461: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   2464: lstore 6
    //   2466: aload 9
    //   2468: ldc_w 499
    //   2471: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2474: astore 11
    //   2476: aload 9
    //   2478: ldc_w 501
    //   2481: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2484: astore 12
    //   2486: aload 9
    //   2488: ldc_w 503
    //   2491: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2494: astore 9
    //   2496: new 505	VIP/BaseInfo
    //   2499: dup
    //   2500: invokespecial 506	VIP/BaseInfo:<init>	()V
    //   2503: astore 13
    //   2505: aload 13
    //   2507: aload_1
    //   2508: putfield 509	VIP/BaseInfo:appId	Ljava/lang/String;
    //   2511: aload 13
    //   2513: aload 10
    //   2515: putfield 511	VIP/BaseInfo:nonce	Ljava/lang/String;
    //   2518: aload 13
    //   2520: lload 6
    //   2522: putfield 514	VIP/BaseInfo:timeStamp	J
    //   2525: aload 13
    //   2527: aload 11
    //   2529: putfield 516	VIP/BaseInfo:sig	Ljava/lang/String;
    //   2532: aload 13
    //   2534: aload 12
    //   2536: putfield 518	VIP/BaseInfo:sigType	Ljava/lang/String;
    //   2539: aload 13
    //   2541: ldc_w 520
    //   2544: putfield 523	VIP/BaseInfo:qVersion	Ljava/lang/String;
    //   2547: aload 13
    //   2549: getstatic 528	android/os/Build:MODEL	Ljava/lang/String;
    //   2552: putfield 531	VIP/BaseInfo:phoneModel	Ljava/lang/String;
    //   2555: aload 13
    //   2557: ldc_w 533
    //   2560: putfield 536	VIP/BaseInfo:phoneOS	Ljava/lang/String;
    //   2563: new 538	VIP/ReqGetApiList
    //   2566: dup
    //   2567: invokespecial 539	VIP/ReqGetApiList:<init>	()V
    //   2570: astore_1
    //   2571: aload_1
    //   2572: aload 13
    //   2574: putfield 543	VIP/ReqGetApiList:baseInfo	LVIP/BaseInfo;
    //   2577: aload_1
    //   2578: aload 9
    //   2580: putfield 545	VIP/ReqGetApiList:domain	Ljava/lang/String;
    //   2583: aload 8
    //   2585: aload_0
    //   2586: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2589: invokestatic 549	com/tencent/mobileqq/emosm/web/MessengerService:access$1500	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lcom/tencent/mobileqq/app/QWalletOpenObserver;
    //   2592: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   2595: aload 8
    //   2597: bipush 29
    //   2599: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2602: checkcast 554	com/tencent/mobileqq/app/QWalletOpenHandler
    //   2605: aload_1
    //   2606: invokevirtual 557	com/tencent/mobileqq/app/QWalletOpenHandler:a	(LVIP/ReqGetApiList;)V
    //   2609: return
    //   2610: ldc_w 559
    //   2613: aload 11
    //   2615: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2618: ifeq +160 -> 2778
    //   2621: aload 9
    //   2623: ldc_w 493
    //   2626: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2629: astore_1
    //   2630: aload 9
    //   2632: ldc_w 495
    //   2635: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2638: astore 10
    //   2640: aload 9
    //   2642: ldc_w 497
    //   2645: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   2648: lstore 6
    //   2650: aload 9
    //   2652: ldc_w 499
    //   2655: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2658: astore 11
    //   2660: aload 9
    //   2662: ldc_w 501
    //   2665: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2668: astore 12
    //   2670: new 505	VIP/BaseInfo
    //   2673: dup
    //   2674: invokespecial 506	VIP/BaseInfo:<init>	()V
    //   2677: astore 9
    //   2679: aload 9
    //   2681: aload_1
    //   2682: putfield 509	VIP/BaseInfo:appId	Ljava/lang/String;
    //   2685: aload 9
    //   2687: aload 10
    //   2689: putfield 511	VIP/BaseInfo:nonce	Ljava/lang/String;
    //   2692: aload 9
    //   2694: lload 6
    //   2696: putfield 514	VIP/BaseInfo:timeStamp	J
    //   2699: aload 9
    //   2701: aload 11
    //   2703: putfield 516	VIP/BaseInfo:sig	Ljava/lang/String;
    //   2706: aload 9
    //   2708: aload 12
    //   2710: putfield 518	VIP/BaseInfo:sigType	Ljava/lang/String;
    //   2713: aload 9
    //   2715: ldc_w 520
    //   2718: putfield 523	VIP/BaseInfo:qVersion	Ljava/lang/String;
    //   2721: aload 9
    //   2723: getstatic 528	android/os/Build:MODEL	Ljava/lang/String;
    //   2726: putfield 531	VIP/BaseInfo:phoneModel	Ljava/lang/String;
    //   2729: aload 9
    //   2731: ldc_w 533
    //   2734: putfield 536	VIP/BaseInfo:phoneOS	Ljava/lang/String;
    //   2737: new 561	VIP/ReqGetOpenId
    //   2740: dup
    //   2741: invokespecial 562	VIP/ReqGetOpenId:<init>	()V
    //   2744: astore_1
    //   2745: aload_1
    //   2746: aload 9
    //   2748: putfield 563	VIP/ReqGetOpenId:baseInfo	LVIP/BaseInfo;
    //   2751: aload 8
    //   2753: aload_0
    //   2754: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2757: invokestatic 549	com/tencent/mobileqq/emosm/web/MessengerService:access$1500	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lcom/tencent/mobileqq/app/QWalletOpenObserver;
    //   2760: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   2763: aload 8
    //   2765: bipush 29
    //   2767: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2770: checkcast 554	com/tencent/mobileqq/app/QWalletOpenHandler
    //   2773: aload_1
    //   2774: invokevirtual 566	com/tencent/mobileqq/app/QWalletOpenHandler:a	(LVIP/ReqGetOpenId;)V
    //   2777: return
    //   2778: ldc_w 568
    //   2781: aload 11
    //   2783: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2786: ifeq +19 -> 2805
    //   2789: aload_1
    //   2790: ldc_w 570
    //   2793: invokevirtual 574	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   2796: astore_1
    //   2797: invokestatic 75	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipLockWebImpl;
    //   2800: aload_1
    //   2801: invokevirtual 577	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	([B)V
    //   2804: return
    //   2805: ldc_w 579
    //   2808: aload 11
    //   2810: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2813: ifeq +18 -> 2831
    //   2816: invokestatic 584	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   2819: aload 8
    //   2821: aload 8
    //   2823: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2826: iconst_1
    //   2827: invokevirtual 587	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)V
    //   2830: return
    //   2831: ldc_w 589
    //   2834: aload 11
    //   2836: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2839: ifeq +136 -> 2975
    //   2842: aload_1
    //   2843: ldc 228
    //   2845: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2848: astore_1
    //   2849: aload 8
    //   2851: iconst_1
    //   2852: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2855: checkcast 592	mqq/manager/WtloginManager
    //   2858: astore 8
    //   2860: aload 8
    //   2862: ifnull +1189 -> 4051
    //   2865: aload 8
    //   2867: aload_1
    //   2868: ldc2_w 593
    //   2871: invokeinterface 598 4 0
    //   2876: bipush 64
    //   2878: invokestatic 604	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   2881: invokestatic 609	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   2884: astore_1
    //   2885: aload_1
    //   2886: astore 8
    //   2888: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2891: ifeq +32 -> 2923
    //   2894: ldc 91
    //   2896: iconst_2
    //   2897: new 128	java/lang/StringBuilder
    //   2900: dup
    //   2901: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2904: ldc_w 611
    //   2907: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2910: aload_1
    //   2911: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2914: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2917: invokestatic 614	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2920: aload_1
    //   2921: astore 8
    //   2923: new 105	android/os/Bundle
    //   2926: dup
    //   2927: invokespecial 232	android/os/Bundle:<init>	()V
    //   2930: astore_1
    //   2931: aload_1
    //   2932: ldc_w 616
    //   2935: aload 8
    //   2937: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2940: aload 9
    //   2942: ldc 177
    //   2944: aload_1
    //   2945: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2948: aload_0
    //   2949: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2952: aload 9
    //   2954: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2957: return
    //   2958: astore 8
    //   2960: ldc_w 387
    //   2963: astore_1
    //   2964: aload 8
    //   2966: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   2969: aload_1
    //   2970: astore 8
    //   2972: goto -49 -> 2923
    //   2975: ldc_w 618
    //   2978: aload 11
    //   2980: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2983: ifeq +103 -> 3086
    //   2986: aload_0
    //   2987: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2990: invokestatic 621	com/tencent/mobileqq/emosm/web/MessengerService:access$1600	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2993: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   2996: astore_1
    //   2997: aload_1
    //   2998: bipush 43
    //   3000: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3003: checkcast 623	com/tencent/mobileqq/app/FriendsManager
    //   3006: aload_1
    //   3007: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3010: invokevirtual 626	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   3013: astore_1
    //   3014: aload_1
    //   3015: ifnull +66 -> 3081
    //   3018: aload_1
    //   3019: getfield 631	com/tencent/mobileqq/data/Card:templateRet	I
    //   3022: ifeq +54 -> 3076
    //   3025: iconst_m1
    //   3026: istore_2
    //   3027: new 105	android/os/Bundle
    //   3030: dup
    //   3031: invokespecial 232	android/os/Bundle:<init>	()V
    //   3034: astore_1
    //   3035: aload_1
    //   3036: ldc_w 633
    //   3039: lconst_0
    //   3040: invokevirtual 311	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   3043: aload_1
    //   3044: ldc_w 635
    //   3047: lconst_0
    //   3048: invokevirtual 311	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   3051: aload_1
    //   3052: ldc 137
    //   3054: iload_2
    //   3055: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3058: aload 9
    //   3060: ldc 177
    //   3062: aload_1
    //   3063: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3066: aload_0
    //   3067: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3070: aload 9
    //   3072: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3075: return
    //   3076: iconst_0
    //   3077: istore_2
    //   3078: goto -51 -> 3027
    //   3081: iconst_m1
    //   3082: istore_2
    //   3083: goto -56 -> 3027
    //   3086: ldc_w 637
    //   3089: aload 11
    //   3091: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3094: ifeq +53 -> 3147
    //   3097: aload 8
    //   3099: aload_0
    //   3100: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3103: invokestatic 641	com/tencent/mobileqq/emosm/web/MessengerService:access$1700	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lcom/tencent/mobileqq/app/CardObserver;
    //   3106: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   3109: aload_0
    //   3110: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3113: aload 9
    //   3115: invokestatic 645	com/tencent/mobileqq/emosm/web/MessengerService:access$1802	(Lcom/tencent/mobileqq/emosm/web/MessengerService;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   3118: pop
    //   3119: aload 9
    //   3121: ldc_w 635
    //   3124: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3127: istore_2
    //   3128: aload 9
    //   3130: ldc_w 647
    //   3133: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3136: istore_3
    //   3137: aload 8
    //   3139: iload_2
    //   3140: i2l
    //   3141: iload_3
    //   3142: i2l
    //   3143: invokestatic 650	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)V
    //   3146: return
    //   3147: ldc_w 652
    //   3150: aload 11
    //   3152: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3155: ifeq +46 -> 3201
    //   3158: new 105	android/os/Bundle
    //   3161: dup
    //   3162: invokespecial 232	android/os/Bundle:<init>	()V
    //   3165: astore_1
    //   3166: aload_1
    //   3167: ldc_w 654
    //   3170: aload 8
    //   3172: aload 8
    //   3174: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3177: invokestatic 659	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   3180: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3183: aload 9
    //   3185: ldc 177
    //   3187: aload_1
    //   3188: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3191: aload_0
    //   3192: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3195: aload 9
    //   3197: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3200: return
    //   3201: ldc_w 661
    //   3204: aload 11
    //   3206: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3209: ifeq +81 -> 3290
    //   3212: new 105	android/os/Bundle
    //   3215: dup
    //   3216: invokespecial 232	android/os/Bundle:<init>	()V
    //   3219: astore_1
    //   3220: aload_0
    //   3221: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3224: invokestatic 664	com/tencent/mobileqq/emosm/web/MessengerService:access$1900	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3227: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3230: invokevirtual 667	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3233: invokevirtual 671	com/tencent/mobileqq/app/message/QQMessageFacade:a	()I
    //   3236: istore_2
    //   3237: aload_0
    //   3238: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3241: invokestatic 674	com/tencent/mobileqq/emosm/web/MessengerService:access$2000	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3244: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3247: invokevirtual 667	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3250: invokevirtual 675	com/tencent/mobileqq/app/message/QQMessageFacade:a	()Ljava/lang/String;
    //   3253: astore 8
    //   3255: aload_1
    //   3256: ldc_w 677
    //   3259: iload_2
    //   3260: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3263: aload_1
    //   3264: ldc_w 679
    //   3267: aload 8
    //   3269: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3272: aload 9
    //   3274: ldc 177
    //   3276: aload_1
    //   3277: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3280: aload_0
    //   3281: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3284: aload 9
    //   3286: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3289: return
    //   3290: ldc_w 681
    //   3293: aload 11
    //   3295: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3298: ifeq +81 -> 3379
    //   3301: new 105	android/os/Bundle
    //   3304: dup
    //   3305: invokespecial 232	android/os/Bundle:<init>	()V
    //   3308: astore_1
    //   3309: aload_0
    //   3310: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3313: invokestatic 684	com/tencent/mobileqq/emosm/web/MessengerService:access$2100	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3316: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3319: invokevirtual 667	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3322: invokevirtual 671	com/tencent/mobileqq/app/message/QQMessageFacade:a	()I
    //   3325: istore_2
    //   3326: aload_0
    //   3327: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3330: invokestatic 687	com/tencent/mobileqq/emosm/web/MessengerService:access$2200	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3333: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3336: invokevirtual 667	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3339: invokevirtual 675	com/tencent/mobileqq/app/message/QQMessageFacade:a	()Ljava/lang/String;
    //   3342: astore 8
    //   3344: aload_1
    //   3345: ldc_w 677
    //   3348: iload_2
    //   3349: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3352: aload_1
    //   3353: ldc_w 679
    //   3356: aload 8
    //   3358: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3361: aload 9
    //   3363: ldc 177
    //   3365: aload_1
    //   3366: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3369: aload_0
    //   3370: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3373: aload 9
    //   3375: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3378: return
    //   3379: ldc_w 689
    //   3382: aload 11
    //   3384: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3387: ifeq +37 -> 3424
    //   3390: new 105	android/os/Bundle
    //   3393: dup
    //   3394: invokespecial 232	android/os/Bundle:<init>	()V
    //   3397: astore_1
    //   3398: aload_1
    //   3399: ldc_w 691
    //   3402: iconst_0
    //   3403: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3406: aload 9
    //   3408: ldc 177
    //   3410: aload_1
    //   3411: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3414: aload_0
    //   3415: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3418: aload 9
    //   3420: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3423: return
    //   3424: ldc_w 693
    //   3427: aload 11
    //   3429: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3432: ifeq +42 -> 3474
    //   3435: new 105	android/os/Bundle
    //   3438: dup
    //   3439: invokespecial 232	android/os/Bundle:<init>	()V
    //   3442: astore_1
    //   3443: aload_1
    //   3444: ldc 242
    //   3446: invokestatic 698	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3449: iconst_0
    //   3450: invokevirtual 701	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	(Z)Ljava/lang/String;
    //   3453: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3456: aload 9
    //   3458: ldc 177
    //   3460: aload_1
    //   3461: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3464: aload_0
    //   3465: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3468: aload 9
    //   3470: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3473: return
    //   3474: ldc_w 703
    //   3477: aload 11
    //   3479: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3482: ifeq +97 -> 3579
    //   3485: aload 9
    //   3487: ldc 111
    //   3489: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3492: astore_1
    //   3493: iconst_0
    //   3494: istore 5
    //   3496: aload_1
    //   3497: ifnull +41 -> 3538
    //   3500: aload_1
    //   3501: ldc 148
    //   3503: iconst_m1
    //   3504: invokevirtual 706	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   3507: istore_2
    //   3508: aload_1
    //   3509: ldc_w 708
    //   3512: invokevirtual 712	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   3515: istore 5
    //   3517: invokestatic 698	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3520: astore_1
    //   3521: iload 5
    //   3523: ifne +50 -> 3573
    //   3526: iconst_1
    //   3527: istore 5
    //   3529: aload_1
    //   3530: iload_2
    //   3531: iload 5
    //   3533: invokevirtual 715	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	(IZ)Z
    //   3536: istore 5
    //   3538: new 105	android/os/Bundle
    //   3541: dup
    //   3542: invokespecial 232	android/os/Bundle:<init>	()V
    //   3545: astore_1
    //   3546: aload_1
    //   3547: ldc_w 717
    //   3550: iload 5
    //   3552: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3555: aload 9
    //   3557: ldc 177
    //   3559: aload_1
    //   3560: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3563: aload_0
    //   3564: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3567: aload 9
    //   3569: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3572: return
    //   3573: iconst_0
    //   3574: istore 5
    //   3576: goto -47 -> 3529
    //   3579: ldc_w 719
    //   3582: aload 11
    //   3584: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3587: ifeq +56 -> 3643
    //   3590: invokestatic 698	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3593: invokevirtual 722	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Leyy;
    //   3596: ifnull +41 -> 3637
    //   3599: iconst_1
    //   3600: istore 5
    //   3602: new 105	android/os/Bundle
    //   3605: dup
    //   3606: invokespecial 232	android/os/Bundle:<init>	()V
    //   3609: astore_1
    //   3610: aload_1
    //   3611: ldc_w 717
    //   3614: iload 5
    //   3616: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3619: aload 9
    //   3621: ldc 177
    //   3623: aload_1
    //   3624: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3627: aload_0
    //   3628: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3631: aload 9
    //   3633: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3636: return
    //   3637: iconst_0
    //   3638: istore 5
    //   3640: goto -38 -> 3602
    //   3643: ldc_w 724
    //   3646: aload 11
    //   3648: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3651: ifne +14 -> 3665
    //   3654: ldc_w 726
    //   3657: aload 11
    //   3659: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3662: ifeq +50 -> 3712
    //   3665: aload 9
    //   3667: ldc 111
    //   3669: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3672: astore_1
    //   3673: aload_1
    //   3674: ifnull -3657 -> 17
    //   3677: aload_1
    //   3678: ldc 148
    //   3680: iconst_m1
    //   3681: invokevirtual 706	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   3684: istore_2
    //   3685: ldc_w 724
    //   3688: aload 11
    //   3690: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3693: ifeq +11 -> 3704
    //   3696: invokestatic 698	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3699: iload_2
    //   3700: invokevirtual 727	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	(I)V
    //   3703: return
    //   3704: invokestatic 698	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3707: iload_2
    //   3708: invokevirtual 728	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:b	(I)V
    //   3711: return
    //   3712: ldc_w 730
    //   3715: aload 11
    //   3717: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3720: ifeq +46 -> 3766
    //   3723: aload_1
    //   3724: ldc_w 732
    //   3727: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3730: istore_2
    //   3731: aload_1
    //   3732: ldc_w 734
    //   3735: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3738: astore_1
    //   3739: aload 8
    //   3741: bipush 6
    //   3743: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3746: checkcast 736	mqq/manager/VerifyCodeManager
    //   3749: astore 8
    //   3751: aload 8
    //   3753: ifnull -3736 -> 17
    //   3756: aload 8
    //   3758: iload_2
    //   3759: aload_1
    //   3760: invokeinterface 739 3 0
    //   3765: return
    //   3766: ldc_w 741
    //   3769: aload 11
    //   3771: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3774: ifeq +45 -> 3819
    //   3777: aload 8
    //   3779: ldc_w 743
    //   3782: invokevirtual 746	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/Class;)Landroid/os/Handler;
    //   3785: astore_1
    //   3786: aload_1
    //   3787: ifnull +11 -> 3798
    //   3790: aload_1
    //   3791: ldc_w 747
    //   3794: invokevirtual 751	android/os/Handler:sendEmptyMessage	(I)Z
    //   3797: pop
    //   3798: aload 8
    //   3800: ldc_w 753
    //   3803: invokevirtual 746	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/Class;)Landroid/os/Handler;
    //   3806: astore_1
    //   3807: aload_1
    //   3808: ifnull -3791 -> 17
    //   3811: aload_1
    //   3812: bipush 7
    //   3814: invokevirtual 751	android/os/Handler:sendEmptyMessage	(I)Z
    //   3817: pop
    //   3818: return
    //   3819: ldc_w 755
    //   3822: aload 11
    //   3824: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3827: ifeq +46 -> 3873
    //   3830: aload 9
    //   3832: ldc 111
    //   3834: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3837: ifnull +3 -> 3840
    //   3840: new 105	android/os/Bundle
    //   3843: dup
    //   3844: invokespecial 232	android/os/Bundle:<init>	()V
    //   3847: astore_1
    //   3848: aload_1
    //   3849: ldc 137
    //   3851: iconst_m1
    //   3852: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3855: aload 9
    //   3857: ldc 177
    //   3859: aload_1
    //   3860: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3863: aload_0
    //   3864: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3867: aload 9
    //   3869: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3872: return
    //   3873: ldc_w 757
    //   3876: aload 11
    //   3878: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3881: ifeq +14 -> 3895
    //   3884: aload 9
    //   3886: ldc 111
    //   3888: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3891: ifnull -3874 -> 17
    //   3894: return
    //   3895: ldc_w 759
    //   3898: aload 11
    //   3900: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3903: ifeq -3886 -> 17
    //   3906: invokestatic 764	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3909: bipush 15
    //   3911: invokevirtual 767	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(I)Ljava/util/ArrayList;
    //   3914: astore 8
    //   3916: new 769	org/json/JSONArray
    //   3919: dup
    //   3920: invokespecial 770	org/json/JSONArray:<init>	()V
    //   3923: astore_1
    //   3924: aload 8
    //   3926: ifnull +41 -> 3967
    //   3929: aload 8
    //   3931: invokevirtual 776	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3934: astore 8
    //   3936: aload 8
    //   3938: invokeinterface 781 1 0
    //   3943: ifeq +24 -> 3967
    //   3946: aload_1
    //   3947: aload 8
    //   3949: invokeinterface 785 1 0
    //   3954: checkcast 787	ConfigPush/FileStorageServerListInfo
    //   3957: getfield 790	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   3960: invokevirtual 794	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   3963: pop
    //   3964: goto -28 -> 3936
    //   3967: new 105	android/os/Bundle
    //   3970: dup
    //   3971: invokespecial 232	android/os/Bundle:<init>	()V
    //   3974: astore 8
    //   3976: new 476	org/json/JSONObject
    //   3979: dup
    //   3980: invokespecial 795	org/json/JSONObject:<init>	()V
    //   3983: astore 10
    //   3985: aload 10
    //   3987: ldc 137
    //   3989: iconst_0
    //   3990: invokevirtual 798	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   3993: pop
    //   3994: aload 10
    //   3996: ldc 202
    //   3998: ldc_w 800
    //   4001: invokevirtual 803	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4004: pop
    //   4005: aload 10
    //   4007: ldc_w 805
    //   4010: aload_1
    //   4011: invokevirtual 803	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4014: pop
    //   4015: aload 8
    //   4017: ldc 137
    //   4019: aload 10
    //   4021: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4024: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4027: aload 9
    //   4029: ldc 177
    //   4031: aload 8
    //   4033: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   4036: aload_0
    //   4037: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   4040: aload 9
    //   4042: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   4045: return
    //   4046: astore 8
    //   4048: goto -1084 -> 2964
    //   4051: ldc_w 387
    //   4054: astore 8
    //   4056: goto -1133 -> 2923
    //   4059: iconst_0
    //   4060: istore_2
    //   4061: goto -3179 -> 882
    //   4064: astore_1
    //   4065: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4066	0	this	IncomingHandler
    //   0	4066	1	paramMessage	android.os.Message
    //   864	3197	2	i	int
    //   1685	1457	3	j	int
    //   1643	67	4	k	int
    //   805	2834	5	bool	boolean
    //   1213	1482	6	l	long
    //   28	2908	8	localObject1	java.lang.Object
    //   2958	7	8	localException1	java.lang.Exception
    //   2970	1062	8	localObject2	java.lang.Object
    //   4046	1	8	localException2	java.lang.Exception
    //   4054	1	8	str1	java.lang.String
    //   216	3825	9	localObject3	java.lang.Object
    //   67	3953	10	localObject4	java.lang.Object
    //   230	3669	11	str2	java.lang.String
    //   1230	1479	12	str3	java.lang.String
    //   2503	70	13	localBaseInfo	VIP.BaseInfo
    // Exception table:
    //   from	to	target	type
    //   930	983	984	java/lang/Exception
    //   2865	2885	2958	java/lang/Exception
    //   2888	2920	4046	java/lang/Exception
    //   3929	3936	4064	org/json/JSONException
    //   3936	3964	4064	org/json/JSONException
    //   3967	4045	4064	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */