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
    //   877: if_icmpne +3221 -> 4098
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
    //   1937: ifeq +505 -> 2442
    //   1940: getstatic 424	com/tencent/mobileqq/emosm/web/IPCConstants:IPC_CMD_MAP	Ljava/util/HashMap;
    //   1943: aload 11
    //   1945: invokevirtual 433	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   1948: checkcast 435	java/lang/Integer
    //   1951: invokevirtual 438	java/lang/Integer:intValue	()I
    //   1954: tableswitch	default:+46 -> 2000, 1:+47->2001, 2:+-1937->17, 3:+117->2071, 4:+159->2113, 5:+219->2173, 6:+346->2300, 7:+272->2226, 8:+420->2374
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
    //   2071: aload_1
    //   2072: ldc 148
    //   2074: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2077: pop
    //   2078: aload 9
    //   2080: ldc_w 317
    //   2083: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2086: pop
    //   2087: aload_0
    //   2088: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2091: invokestatic 444	com/tencent/mobileqq/emosm/web/MessengerService:access$900	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2094: bipush 38
    //   2096: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2099: checkcast 446	com/etrump/mixlayout/FontManager
    //   2102: aload_0
    //   2103: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2106: getfield 450	com/tencent/mobileqq/emosm/web/MessengerService:mVipIPCDownloadListener	Lcom/tencent/mobileqq/vip/IPCDownloadListener;
    //   2109: invokevirtual 453	com/etrump/mixlayout/FontManager:a	(Lcom/tencent/mobileqq/vip/IPCDownloadListener;)V
    //   2112: return
    //   2113: aload_1
    //   2114: ldc 148
    //   2116: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2119: istore_2
    //   2120: aload_0
    //   2121: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2124: invokestatic 456	com/tencent/mobileqq/emosm/web/MessengerService:access$1000	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2127: bipush 38
    //   2129: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2132: checkcast 446	com/etrump/mixlayout/FontManager
    //   2135: iload_2
    //   2136: invokevirtual 459	com/etrump/mixlayout/FontManager:a	(I)I
    //   2139: pop
    //   2140: new 105	android/os/Bundle
    //   2143: dup
    //   2144: invokespecial 232	android/os/Bundle:<init>	()V
    //   2147: astore_1
    //   2148: aload_1
    //   2149: ldc 148
    //   2151: iload_2
    //   2152: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2155: aload 9
    //   2157: ldc 177
    //   2159: aload_1
    //   2160: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2163: aload_0
    //   2164: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2167: aload 9
    //   2169: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2172: return
    //   2173: aload_1
    //   2174: ldc 148
    //   2176: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2179: istore_2
    //   2180: aload 9
    //   2182: ldc_w 317
    //   2185: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2188: astore_1
    //   2189: aload_0
    //   2190: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2193: invokestatic 462	com/tencent/mobileqq/emosm/web/MessengerService:access$1100	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2196: bipush 40
    //   2198: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2201: checkcast 464	com/tencent/mobileqq/bubble/BubbleManager
    //   2204: astore 8
    //   2206: aload 8
    //   2208: aload_0
    //   2209: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2212: getfield 450	com/tencent/mobileqq/emosm/web/MessengerService:mVipIPCDownloadListener	Lcom/tencent/mobileqq/vip/IPCDownloadListener;
    //   2215: invokevirtual 465	com/tencent/mobileqq/bubble/BubbleManager:a	(Lcom/tencent/mobileqq/vip/IPCDownloadListener;)V
    //   2218: aload 8
    //   2220: iload_2
    //   2221: aload_1
    //   2222: invokevirtual 468	com/tencent/mobileqq/bubble/BubbleManager:c	(ILjava/lang/String;)V
    //   2225: return
    //   2226: aload_1
    //   2227: ldc 148
    //   2229: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2232: istore_2
    //   2233: aload_0
    //   2234: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2237: invokestatic 471	com/tencent/mobileqq/emosm/web/MessengerService:access$1200	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2240: bipush 40
    //   2242: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2245: checkcast 464	com/tencent/mobileqq/bubble/BubbleManager
    //   2248: iload_2
    //   2249: invokevirtual 474	com/tencent/mobileqq/bubble/BubbleManager:c	(I)Lorg/json/JSONObject;
    //   2252: astore_1
    //   2253: new 105	android/os/Bundle
    //   2256: dup
    //   2257: invokespecial 232	android/os/Bundle:<init>	()V
    //   2260: astore 8
    //   2262: aload 8
    //   2264: ldc 148
    //   2266: iload_2
    //   2267: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2270: aload 8
    //   2272: ldc 137
    //   2274: aload_1
    //   2275: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2278: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2281: aload 9
    //   2283: ldc 177
    //   2285: aload 8
    //   2287: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2290: aload_0
    //   2291: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2294: aload 9
    //   2296: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2299: return
    //   2300: aload_1
    //   2301: ldc 148
    //   2303: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2306: istore_2
    //   2307: aload_0
    //   2308: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2311: invokestatic 480	com/tencent/mobileqq/emosm/web/MessengerService:access$1300	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2314: bipush 40
    //   2316: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2319: checkcast 464	com/tencent/mobileqq/bubble/BubbleManager
    //   2322: iload_2
    //   2323: invokevirtual 482	com/tencent/mobileqq/bubble/BubbleManager:a	(I)Lorg/json/JSONObject;
    //   2326: astore_1
    //   2327: new 105	android/os/Bundle
    //   2330: dup
    //   2331: invokespecial 232	android/os/Bundle:<init>	()V
    //   2334: astore 8
    //   2336: aload 8
    //   2338: ldc 148
    //   2340: iload_2
    //   2341: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2344: aload 8
    //   2346: ldc 137
    //   2348: aload_1
    //   2349: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   2352: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2355: aload 9
    //   2357: ldc 177
    //   2359: aload 8
    //   2361: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2364: aload_0
    //   2365: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2368: aload 9
    //   2370: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2373: return
    //   2374: aload_1
    //   2375: ldc_w 484
    //   2378: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   2381: istore_2
    //   2382: aload_0
    //   2383: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2386: invokestatic 487	com/tencent/mobileqq/emosm/web/MessengerService:access$1400	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   2389: bipush 38
    //   2391: invokevirtual 49	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2394: checkcast 446	com/etrump/mixlayout/FontManager
    //   2397: astore_1
    //   2398: iload_2
    //   2399: iconst_1
    //   2400: if_icmpne +36 -> 2436
    //   2403: iconst_1
    //   2404: istore 5
    //   2406: aload_1
    //   2407: iload 5
    //   2409: invokevirtual 489	com/etrump/mixlayout/FontManager:a	(Z)V
    //   2412: aload 9
    //   2414: ldc 177
    //   2416: new 105	android/os/Bundle
    //   2419: dup
    //   2420: invokespecial 232	android/os/Bundle:<init>	()V
    //   2423: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2426: aload_0
    //   2427: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2430: aload 9
    //   2432: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2435: return
    //   2436: iconst_0
    //   2437: istore 5
    //   2439: goto -33 -> 2406
    //   2442: ldc_w 491
    //   2445: aload 11
    //   2447: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2450: ifeq +176 -> 2626
    //   2453: aload 9
    //   2455: ldc_w 493
    //   2458: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2461: astore_1
    //   2462: aload 9
    //   2464: ldc_w 495
    //   2467: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2470: astore 10
    //   2472: aload 9
    //   2474: ldc_w 497
    //   2477: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   2480: lstore 6
    //   2482: aload 9
    //   2484: ldc_w 499
    //   2487: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2490: astore 11
    //   2492: aload 9
    //   2494: ldc_w 501
    //   2497: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2500: astore 12
    //   2502: aload 9
    //   2504: ldc_w 503
    //   2507: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2510: astore 9
    //   2512: new 505	VIP/BaseInfo
    //   2515: dup
    //   2516: invokespecial 506	VIP/BaseInfo:<init>	()V
    //   2519: astore 13
    //   2521: aload 13
    //   2523: aload_1
    //   2524: putfield 509	VIP/BaseInfo:appId	Ljava/lang/String;
    //   2527: aload 13
    //   2529: aload 10
    //   2531: putfield 511	VIP/BaseInfo:nonce	Ljava/lang/String;
    //   2534: aload 13
    //   2536: lload 6
    //   2538: putfield 514	VIP/BaseInfo:timeStamp	J
    //   2541: aload 13
    //   2543: aload 11
    //   2545: putfield 516	VIP/BaseInfo:sig	Ljava/lang/String;
    //   2548: aload 13
    //   2550: aload 12
    //   2552: putfield 518	VIP/BaseInfo:sigType	Ljava/lang/String;
    //   2555: aload 13
    //   2557: ldc_w 520
    //   2560: putfield 523	VIP/BaseInfo:qVersion	Ljava/lang/String;
    //   2563: aload 13
    //   2565: getstatic 528	android/os/Build:MODEL	Ljava/lang/String;
    //   2568: putfield 531	VIP/BaseInfo:phoneModel	Ljava/lang/String;
    //   2571: aload 13
    //   2573: ldc_w 533
    //   2576: putfield 536	VIP/BaseInfo:phoneOS	Ljava/lang/String;
    //   2579: new 538	VIP/ReqGetApiList
    //   2582: dup
    //   2583: invokespecial 539	VIP/ReqGetApiList:<init>	()V
    //   2586: astore_1
    //   2587: aload_1
    //   2588: aload 13
    //   2590: putfield 543	VIP/ReqGetApiList:baseInfo	LVIP/BaseInfo;
    //   2593: aload_1
    //   2594: aload 9
    //   2596: putfield 545	VIP/ReqGetApiList:domain	Ljava/lang/String;
    //   2599: aload 8
    //   2601: aload_0
    //   2602: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2605: invokestatic 549	com/tencent/mobileqq/emosm/web/MessengerService:access$1500	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lcom/tencent/mobileqq/app/QWalletOpenObserver;
    //   2608: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   2611: aload 8
    //   2613: bipush 29
    //   2615: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2618: checkcast 554	com/tencent/mobileqq/app/QWalletOpenHandler
    //   2621: aload_1
    //   2622: invokevirtual 557	com/tencent/mobileqq/app/QWalletOpenHandler:a	(LVIP/ReqGetApiList;)V
    //   2625: return
    //   2626: ldc_w 559
    //   2629: aload 11
    //   2631: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2634: ifeq +160 -> 2794
    //   2637: aload 9
    //   2639: ldc_w 493
    //   2642: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2645: astore_1
    //   2646: aload 9
    //   2648: ldc_w 495
    //   2651: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2654: astore 10
    //   2656: aload 9
    //   2658: ldc_w 497
    //   2661: invokevirtual 168	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   2664: lstore 6
    //   2666: aload 9
    //   2668: ldc_w 499
    //   2671: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2674: astore 11
    //   2676: aload 9
    //   2678: ldc_w 501
    //   2681: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2684: astore 12
    //   2686: new 505	VIP/BaseInfo
    //   2689: dup
    //   2690: invokespecial 506	VIP/BaseInfo:<init>	()V
    //   2693: astore 9
    //   2695: aload 9
    //   2697: aload_1
    //   2698: putfield 509	VIP/BaseInfo:appId	Ljava/lang/String;
    //   2701: aload 9
    //   2703: aload 10
    //   2705: putfield 511	VIP/BaseInfo:nonce	Ljava/lang/String;
    //   2708: aload 9
    //   2710: lload 6
    //   2712: putfield 514	VIP/BaseInfo:timeStamp	J
    //   2715: aload 9
    //   2717: aload 11
    //   2719: putfield 516	VIP/BaseInfo:sig	Ljava/lang/String;
    //   2722: aload 9
    //   2724: aload 12
    //   2726: putfield 518	VIP/BaseInfo:sigType	Ljava/lang/String;
    //   2729: aload 9
    //   2731: ldc_w 520
    //   2734: putfield 523	VIP/BaseInfo:qVersion	Ljava/lang/String;
    //   2737: aload 9
    //   2739: getstatic 528	android/os/Build:MODEL	Ljava/lang/String;
    //   2742: putfield 531	VIP/BaseInfo:phoneModel	Ljava/lang/String;
    //   2745: aload 9
    //   2747: ldc_w 533
    //   2750: putfield 536	VIP/BaseInfo:phoneOS	Ljava/lang/String;
    //   2753: new 561	VIP/ReqGetOpenId
    //   2756: dup
    //   2757: invokespecial 562	VIP/ReqGetOpenId:<init>	()V
    //   2760: astore_1
    //   2761: aload_1
    //   2762: aload 9
    //   2764: putfield 563	VIP/ReqGetOpenId:baseInfo	LVIP/BaseInfo;
    //   2767: aload 8
    //   2769: aload_0
    //   2770: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2773: invokestatic 549	com/tencent/mobileqq/emosm/web/MessengerService:access$1500	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lcom/tencent/mobileqq/app/QWalletOpenObserver;
    //   2776: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   2779: aload 8
    //   2781: bipush 29
    //   2783: invokevirtual 258	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   2786: checkcast 554	com/tencent/mobileqq/app/QWalletOpenHandler
    //   2789: aload_1
    //   2790: invokevirtual 566	com/tencent/mobileqq/app/QWalletOpenHandler:a	(LVIP/ReqGetOpenId;)V
    //   2793: return
    //   2794: ldc_w 568
    //   2797: aload 11
    //   2799: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2802: ifeq +19 -> 2821
    //   2805: aload_1
    //   2806: ldc_w 570
    //   2809: invokevirtual 574	android/os/Bundle:getByteArray	(Ljava/lang/String;)[B
    //   2812: astore_1
    //   2813: invokestatic 75	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	()Lcom/tencent/mobileqq/equipmentlock/EquipLockWebImpl;
    //   2816: aload_1
    //   2817: invokevirtual 577	com/tencent/mobileqq/equipmentlock/EquipLockWebImpl:a	([B)V
    //   2820: return
    //   2821: ldc_w 579
    //   2824: aload 11
    //   2826: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2829: ifeq +18 -> 2847
    //   2832: invokestatic 584	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   2835: aload 8
    //   2837: aload 8
    //   2839: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   2842: iconst_1
    //   2843: invokevirtual 587	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Z)V
    //   2846: return
    //   2847: ldc_w 589
    //   2850: aload 11
    //   2852: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2855: ifeq +136 -> 2991
    //   2858: aload_1
    //   2859: ldc 228
    //   2861: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   2864: astore_1
    //   2865: aload 8
    //   2867: iconst_1
    //   2868: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2871: checkcast 592	mqq/manager/WtloginManager
    //   2874: astore 8
    //   2876: aload 8
    //   2878: ifnull +1212 -> 4090
    //   2881: aload 8
    //   2883: aload_1
    //   2884: ldc2_w 593
    //   2887: invokeinterface 598 4 0
    //   2892: bipush 64
    //   2894: invokestatic 604	oicq/wlogin_sdk/request/WtloginHelper:GetTicketSig	(Loicq/wlogin_sdk/request/WUserSigInfo;I)[B
    //   2897: invokestatic 609	com/tencent/mobileqq/utils/HexUtil:a	([B)Ljava/lang/String;
    //   2900: astore_1
    //   2901: aload_1
    //   2902: astore 8
    //   2904: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2907: ifeq +32 -> 2939
    //   2910: ldc 91
    //   2912: iconst_2
    //   2913: new 128	java/lang/StringBuilder
    //   2916: dup
    //   2917: invokespecial 129	java/lang/StringBuilder:<init>	()V
    //   2920: ldc_w 611
    //   2923: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2926: aload_1
    //   2927: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2930: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2933: invokestatic 614	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2936: aload_1
    //   2937: astore 8
    //   2939: new 105	android/os/Bundle
    //   2942: dup
    //   2943: invokespecial 232	android/os/Bundle:<init>	()V
    //   2946: astore_1
    //   2947: aload_1
    //   2948: ldc_w 616
    //   2951: aload 8
    //   2953: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   2956: aload 9
    //   2958: ldc 177
    //   2960: aload_1
    //   2961: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   2964: aload_0
    //   2965: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   2968: aload 9
    //   2970: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   2973: return
    //   2974: astore 8
    //   2976: ldc_w 387
    //   2979: astore_1
    //   2980: aload 8
    //   2982: invokevirtual 293	java/lang/Exception:printStackTrace	()V
    //   2985: aload_1
    //   2986: astore 8
    //   2988: goto -49 -> 2939
    //   2991: ldc_w 618
    //   2994: aload 11
    //   2996: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2999: ifeq +115 -> 3114
    //   3002: aload_0
    //   3003: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3006: invokestatic 621	com/tencent/mobileqq/emosm/web/MessengerService:access$1600	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3009: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3012: astore_1
    //   3013: aload_1
    //   3014: bipush 43
    //   3016: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3019: checkcast 623	com/tencent/mobileqq/app/FriendsManager
    //   3022: aload_1
    //   3023: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3026: invokevirtual 626	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   3029: astore_1
    //   3030: aload_1
    //   3031: ifnull +78 -> 3109
    //   3034: aload_1
    //   3035: getfield 631	com/tencent/mobileqq/data/Card:templateRet	I
    //   3038: ifeq +54 -> 3092
    //   3041: iconst_m1
    //   3042: istore_2
    //   3043: new 105	android/os/Bundle
    //   3046: dup
    //   3047: invokespecial 232	android/os/Bundle:<init>	()V
    //   3050: astore_1
    //   3051: aload_1
    //   3052: ldc_w 633
    //   3055: lconst_0
    //   3056: invokevirtual 311	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   3059: aload_1
    //   3060: ldc_w 635
    //   3063: lconst_0
    //   3064: invokevirtual 311	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   3067: aload_1
    //   3068: ldc 137
    //   3070: iload_2
    //   3071: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3074: aload 9
    //   3076: ldc 177
    //   3078: aload_1
    //   3079: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3082: aload_0
    //   3083: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3086: aload 9
    //   3088: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3091: return
    //   3092: aload_1
    //   3093: getfield 638	com/tencent/mobileqq/data/Card:lCurrentBgId	J
    //   3096: lstore 6
    //   3098: aload_1
    //   3099: getfield 641	com/tencent/mobileqq/data/Card:lCurrentStyleId	J
    //   3102: lstore 6
    //   3104: iconst_0
    //   3105: istore_2
    //   3106: goto -63 -> 3043
    //   3109: iconst_m1
    //   3110: istore_2
    //   3111: goto -68 -> 3043
    //   3114: ldc_w 643
    //   3117: aload 11
    //   3119: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3122: ifeq +53 -> 3175
    //   3125: aload 8
    //   3127: aload_0
    //   3128: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3131: invokestatic 647	com/tencent/mobileqq/emosm/web/MessengerService:access$1700	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lcom/tencent/mobileqq/app/CardObserver;
    //   3134: invokevirtual 552	com/tencent/mobileqq/app/QQAppInterface:a	(Lcom/tencent/mobileqq/app/BusinessObserver;)V
    //   3137: aload_0
    //   3138: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3141: aload 9
    //   3143: invokestatic 651	com/tencent/mobileqq/emosm/web/MessengerService:access$1802	(Lcom/tencent/mobileqq/emosm/web/MessengerService;Landroid/os/Bundle;)Landroid/os/Bundle;
    //   3146: pop
    //   3147: aload 9
    //   3149: ldc_w 635
    //   3152: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3155: istore_2
    //   3156: aload 9
    //   3158: ldc_w 653
    //   3161: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3164: istore_3
    //   3165: aload 8
    //   3167: iload_2
    //   3168: i2l
    //   3169: iload_3
    //   3170: i2l
    //   3171: invokestatic 656	com/tencent/mobileqq/util/ProfileCardUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JJ)V
    //   3174: return
    //   3175: ldc_w 658
    //   3178: aload 11
    //   3180: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3183: ifeq +46 -> 3229
    //   3186: new 105	android/os/Bundle
    //   3189: dup
    //   3190: invokespecial 232	android/os/Bundle:<init>	()V
    //   3193: astore_1
    //   3194: aload_1
    //   3195: ldc_w 660
    //   3198: aload 8
    //   3200: aload 8
    //   3202: invokevirtual 274	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   3205: invokestatic 665	com/tencent/mobileqq/utils/VipUtils:a	(Lcom/tencent/common/app/AppInterface;Ljava/lang/String;)Ljava/lang/String;
    //   3208: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3211: aload 9
    //   3213: ldc 177
    //   3215: aload_1
    //   3216: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3219: aload_0
    //   3220: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3223: aload 9
    //   3225: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3228: return
    //   3229: ldc_w 667
    //   3232: aload 11
    //   3234: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3237: ifeq +81 -> 3318
    //   3240: new 105	android/os/Bundle
    //   3243: dup
    //   3244: invokespecial 232	android/os/Bundle:<init>	()V
    //   3247: astore_1
    //   3248: aload_0
    //   3249: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3252: invokestatic 670	com/tencent/mobileqq/emosm/web/MessengerService:access$1900	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3255: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3258: invokevirtual 673	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3261: invokevirtual 677	com/tencent/mobileqq/app/message/QQMessageFacade:a	()I
    //   3264: istore_2
    //   3265: aload_0
    //   3266: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3269: invokestatic 680	com/tencent/mobileqq/emosm/web/MessengerService:access$2000	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3272: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3275: invokevirtual 673	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3278: invokevirtual 681	com/tencent/mobileqq/app/message/QQMessageFacade:a	()Ljava/lang/String;
    //   3281: astore 8
    //   3283: aload_1
    //   3284: ldc_w 683
    //   3287: iload_2
    //   3288: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3291: aload_1
    //   3292: ldc_w 685
    //   3295: aload 8
    //   3297: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3300: aload 9
    //   3302: ldc 177
    //   3304: aload_1
    //   3305: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3308: aload_0
    //   3309: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3312: aload 9
    //   3314: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3317: return
    //   3318: ldc_w 687
    //   3321: aload 11
    //   3323: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3326: ifeq +81 -> 3407
    //   3329: new 105	android/os/Bundle
    //   3332: dup
    //   3333: invokespecial 232	android/os/Bundle:<init>	()V
    //   3336: astore_1
    //   3337: aload_0
    //   3338: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3341: invokestatic 690	com/tencent/mobileqq/emosm/web/MessengerService:access$2100	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3344: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3347: invokevirtual 673	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3350: invokevirtual 677	com/tencent/mobileqq/app/message/QQMessageFacade:a	()I
    //   3353: istore_2
    //   3354: aload_0
    //   3355: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3358: invokestatic 693	com/tencent/mobileqq/emosm/web/MessengerService:access$2200	(Lcom/tencent/mobileqq/emosm/web/MessengerService;)Lmqq/app/AppRuntime;
    //   3361: checkcast 28	com/tencent/mobileqq/app/QQAppInterface
    //   3364: invokevirtual 673	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/app/message/QQMessageFacade;
    //   3367: invokevirtual 681	com/tencent/mobileqq/app/message/QQMessageFacade:a	()Ljava/lang/String;
    //   3370: astore 8
    //   3372: aload_1
    //   3373: ldc_w 683
    //   3376: iload_2
    //   3377: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3380: aload_1
    //   3381: ldc_w 685
    //   3384: aload 8
    //   3386: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3389: aload 9
    //   3391: ldc 177
    //   3393: aload_1
    //   3394: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3397: aload_0
    //   3398: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3401: aload 9
    //   3403: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3406: return
    //   3407: ldc_w 695
    //   3410: aload 11
    //   3412: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3415: ifeq +37 -> 3452
    //   3418: new 105	android/os/Bundle
    //   3421: dup
    //   3422: invokespecial 232	android/os/Bundle:<init>	()V
    //   3425: astore_1
    //   3426: aload_1
    //   3427: ldc_w 697
    //   3430: iconst_0
    //   3431: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3434: aload 9
    //   3436: ldc 177
    //   3438: aload_1
    //   3439: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3442: aload_0
    //   3443: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3446: aload 9
    //   3448: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3451: return
    //   3452: ldc_w 699
    //   3455: aload 11
    //   3457: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3460: ifeq +42 -> 3502
    //   3463: new 105	android/os/Bundle
    //   3466: dup
    //   3467: invokespecial 232	android/os/Bundle:<init>	()V
    //   3470: astore_1
    //   3471: aload_1
    //   3472: ldc 242
    //   3474: invokestatic 704	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3477: iconst_0
    //   3478: invokevirtual 707	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	(Z)Ljava/lang/String;
    //   3481: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   3484: aload 9
    //   3486: ldc 177
    //   3488: aload_1
    //   3489: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3492: aload_0
    //   3493: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3496: aload 9
    //   3498: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3501: return
    //   3502: ldc_w 709
    //   3505: aload 11
    //   3507: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3510: ifeq +97 -> 3607
    //   3513: aload 9
    //   3515: ldc 111
    //   3517: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3520: astore_1
    //   3521: iconst_0
    //   3522: istore 5
    //   3524: aload_1
    //   3525: ifnull +41 -> 3566
    //   3528: aload_1
    //   3529: ldc 148
    //   3531: iconst_m1
    //   3532: invokevirtual 712	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   3535: istore_2
    //   3536: aload_1
    //   3537: ldc_w 714
    //   3540: invokevirtual 718	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   3543: istore 5
    //   3545: invokestatic 704	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3548: astore_1
    //   3549: iload 5
    //   3551: ifne +50 -> 3601
    //   3554: iconst_1
    //   3555: istore 5
    //   3557: aload_1
    //   3558: iload_2
    //   3559: iload 5
    //   3561: invokevirtual 721	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	(IZ)Z
    //   3564: istore 5
    //   3566: new 105	android/os/Bundle
    //   3569: dup
    //   3570: invokespecial 232	android/os/Bundle:<init>	()V
    //   3573: astore_1
    //   3574: aload_1
    //   3575: ldc_w 723
    //   3578: iload 5
    //   3580: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3583: aload 9
    //   3585: ldc 177
    //   3587: aload_1
    //   3588: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3591: aload_0
    //   3592: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3595: aload 9
    //   3597: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3600: return
    //   3601: iconst_0
    //   3602: istore 5
    //   3604: goto -47 -> 3557
    //   3607: ldc_w 725
    //   3610: aload 11
    //   3612: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3615: ifeq +56 -> 3671
    //   3618: invokestatic 704	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3621: invokevirtual 728	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lewo;
    //   3624: ifnull +41 -> 3665
    //   3627: iconst_1
    //   3628: istore 5
    //   3630: new 105	android/os/Bundle
    //   3633: dup
    //   3634: invokespecial 232	android/os/Bundle:<init>	()V
    //   3637: astore_1
    //   3638: aload_1
    //   3639: ldc_w 723
    //   3642: iload 5
    //   3644: invokevirtual 253	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   3647: aload 9
    //   3649: ldc 177
    //   3651: aload_1
    //   3652: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3655: aload_0
    //   3656: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3659: aload 9
    //   3661: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3664: return
    //   3665: iconst_0
    //   3666: istore 5
    //   3668: goto -38 -> 3630
    //   3671: ldc_w 730
    //   3674: aload 11
    //   3676: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3679: ifne +14 -> 3693
    //   3682: ldc_w 732
    //   3685: aload 11
    //   3687: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3690: ifeq +50 -> 3740
    //   3693: aload 9
    //   3695: ldc 111
    //   3697: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3700: astore_1
    //   3701: aload_1
    //   3702: ifnull -3685 -> 17
    //   3705: aload_1
    //   3706: ldc 148
    //   3708: iconst_m1
    //   3709: invokevirtual 712	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   3712: istore_2
    //   3713: ldc_w 730
    //   3716: aload 11
    //   3718: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3721: ifeq +11 -> 3732
    //   3724: invokestatic 704	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3727: iload_2
    //   3728: invokevirtual 733	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	(I)V
    //   3731: return
    //   3732: invokestatic 704	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:a	()Lcom/tencent/mobileqq/utils/pathtracker/VipPathTracker;
    //   3735: iload_2
    //   3736: invokevirtual 734	com/tencent/mobileqq/utils/pathtracker/VipPathTracker:b	(I)V
    //   3739: return
    //   3740: ldc_w 736
    //   3743: aload 11
    //   3745: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3748: ifeq +46 -> 3794
    //   3751: aload_1
    //   3752: ldc_w 738
    //   3755: invokevirtual 141	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   3758: istore_2
    //   3759: aload_1
    //   3760: ldc_w 740
    //   3763: invokevirtual 109	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   3766: astore_1
    //   3767: aload 8
    //   3769: bipush 6
    //   3771: invokevirtual 590	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3774: checkcast 742	mqq/manager/VerifyCodeManager
    //   3777: astore 8
    //   3779: aload 8
    //   3781: ifnull -3764 -> 17
    //   3784: aload 8
    //   3786: iload_2
    //   3787: aload_1
    //   3788: invokeinterface 745 3 0
    //   3793: return
    //   3794: ldc_w 747
    //   3797: aload 11
    //   3799: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3802: ifeq +45 -> 3847
    //   3805: aload 8
    //   3807: ldc_w 749
    //   3810: invokevirtual 752	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/Class;)Landroid/os/Handler;
    //   3813: astore_1
    //   3814: aload_1
    //   3815: ifnull +11 -> 3826
    //   3818: aload_1
    //   3819: ldc_w 753
    //   3822: invokevirtual 757	android/os/Handler:sendEmptyMessage	(I)Z
    //   3825: pop
    //   3826: aload 8
    //   3828: ldc_w 759
    //   3831: invokevirtual 752	com/tencent/mobileqq/app/QQAppInterface:a	(Ljava/lang/Class;)Landroid/os/Handler;
    //   3834: astore_1
    //   3835: aload_1
    //   3836: ifnull -3819 -> 17
    //   3839: aload_1
    //   3840: bipush 7
    //   3842: invokevirtual 757	android/os/Handler:sendEmptyMessage	(I)Z
    //   3845: pop
    //   3846: return
    //   3847: ldc_w 761
    //   3850: aload 11
    //   3852: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3855: ifeq +57 -> 3912
    //   3858: aload 9
    //   3860: ldc 111
    //   3862: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3865: astore_1
    //   3866: aload_1
    //   3867: ifnull +12 -> 3879
    //   3870: aload_1
    //   3871: ldc_w 307
    //   3874: lconst_0
    //   3875: invokevirtual 764	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   3878: pop2
    //   3879: new 105	android/os/Bundle
    //   3882: dup
    //   3883: invokespecial 232	android/os/Bundle:<init>	()V
    //   3886: astore_1
    //   3887: aload_1
    //   3888: ldc 137
    //   3890: iconst_m1
    //   3891: invokevirtual 290	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3894: aload 9
    //   3896: ldc 177
    //   3898: aload_1
    //   3899: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   3902: aload_0
    //   3903: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   3906: aload 9
    //   3908: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   3911: return
    //   3912: ldc_w 766
    //   3915: aload 11
    //   3917: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3920: ifeq +14 -> 3934
    //   3923: aload 9
    //   3925: ldc 111
    //   3927: invokevirtual 115	android/os/Bundle:getBundle	(Ljava/lang/String;)Landroid/os/Bundle;
    //   3930: ifnull -3913 -> 17
    //   3933: return
    //   3934: ldc_w 768
    //   3937: aload 11
    //   3939: invokevirtual 123	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3942: ifeq -3925 -> 17
    //   3945: invokestatic 773	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	()Lcom/tencent/mobileqq/transfile/FMTSrvAddrProvider;
    //   3948: bipush 15
    //   3950: invokevirtual 776	com/tencent/mobileqq/transfile/FMTSrvAddrProvider:a	(I)Ljava/util/ArrayList;
    //   3953: astore 8
    //   3955: new 778	org/json/JSONArray
    //   3958: dup
    //   3959: invokespecial 779	org/json/JSONArray:<init>	()V
    //   3962: astore_1
    //   3963: aload 8
    //   3965: ifnull +41 -> 4006
    //   3968: aload 8
    //   3970: invokevirtual 785	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3973: astore 8
    //   3975: aload 8
    //   3977: invokeinterface 790 1 0
    //   3982: ifeq +24 -> 4006
    //   3985: aload_1
    //   3986: aload 8
    //   3988: invokeinterface 794 1 0
    //   3993: checkcast 796	ConfigPush/FileStorageServerListInfo
    //   3996: getfield 799	ConfigPush/FileStorageServerListInfo:sIP	Ljava/lang/String;
    //   3999: invokevirtual 803	org/json/JSONArray:put	(Ljava/lang/Object;)Lorg/json/JSONArray;
    //   4002: pop
    //   4003: goto -28 -> 3975
    //   4006: new 105	android/os/Bundle
    //   4009: dup
    //   4010: invokespecial 232	android/os/Bundle:<init>	()V
    //   4013: astore 8
    //   4015: new 476	org/json/JSONObject
    //   4018: dup
    //   4019: invokespecial 804	org/json/JSONObject:<init>	()V
    //   4022: astore 10
    //   4024: aload 10
    //   4026: ldc 137
    //   4028: iconst_0
    //   4029: invokevirtual 807	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   4032: pop
    //   4033: aload 10
    //   4035: ldc 202
    //   4037: ldc_w 809
    //   4040: invokevirtual 812	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4043: pop
    //   4044: aload 10
    //   4046: ldc_w 814
    //   4049: aload_1
    //   4050: invokevirtual 812	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   4053: pop
    //   4054: aload 8
    //   4056: ldc 137
    //   4058: aload 10
    //   4060: invokevirtual 477	org/json/JSONObject:toString	()Ljava/lang/String;
    //   4063: invokevirtual 238	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4066: aload 9
    //   4068: ldc 177
    //   4070: aload 8
    //   4072: invokevirtual 181	android/os/Bundle:putBundle	(Ljava/lang/String;Landroid/os/Bundle;)V
    //   4075: aload_0
    //   4076: getfield 10	com/tencent/mobileqq/emosm/web/MessengerService$IncomingHandler:this$0	Lcom/tencent/mobileqq/emosm/web/MessengerService;
    //   4079: aload 9
    //   4081: invokevirtual 185	com/tencent/mobileqq/emosm/web/MessengerService:onRespToClient	(Landroid/os/Bundle;)V
    //   4084: return
    //   4085: astore 8
    //   4087: goto -1107 -> 2980
    //   4090: ldc_w 387
    //   4093: astore 8
    //   4095: goto -1156 -> 2939
    //   4098: iconst_0
    //   4099: istore_2
    //   4100: goto -3218 -> 882
    //   4103: astore_1
    //   4104: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4105	0	this	IncomingHandler
    //   0	4105	1	paramMessage	android.os.Message
    //   864	3236	2	i	int
    //   1685	1485	3	j	int
    //   1643	67	4	k	int
    //   805	2862	5	bool	boolean
    //   1213	1890	6	l	long
    //   28	2924	8	localObject1	java.lang.Object
    //   2974	7	8	localException1	java.lang.Exception
    //   2986	1085	8	localObject2	java.lang.Object
    //   4085	1	8	localException2	java.lang.Exception
    //   4093	1	8	str1	java.lang.String
    //   216	3864	9	localObject3	java.lang.Object
    //   67	3992	10	localObject4	java.lang.Object
    //   230	3708	11	str2	java.lang.String
    //   1230	1495	12	str3	java.lang.String
    //   2519	70	13	localBaseInfo	VIP.BaseInfo
    // Exception table:
    //   from	to	target	type
    //   930	983	984	java/lang/Exception
    //   2881	2901	2974	java/lang/Exception
    //   2904	2936	4085	java/lang/Exception
    //   3968	3975	4103	org/json/JSONException
    //   3975	4003	4103	org/json/JSONException
    //   4006	4084	4103	org/json/JSONException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.web.MessengerService.IncomingHandler
 * JD-Core Version:    0.7.0.1
 */