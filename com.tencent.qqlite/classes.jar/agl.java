import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class agl
  implements Handler.Callback
{
  public agl(Conversation paramConversation) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: aload_1
    //   3: getfield 26	android/os/Message:what	I
    //   6: ldc 27
    //   8: if_icmpne +16 -> 24
    //   11: aload_0
    //   12: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   15: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   18: bipush 7
    //   20: iconst_0
    //   21: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   24: aload_1
    //   25: getfield 26	android/os/Message:what	I
    //   28: ldc 38
    //   30: if_icmpeq +18 -> 48
    //   33: aload_0
    //   34: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   37: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   40: invokevirtual 47	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   43: ifne +5 -> 48
    //   46: iconst_1
    //   47: ireturn
    //   48: aload_1
    //   49: getfield 26	android/os/Message:what	I
    //   52: lookupswitch	default:+268->320, 1009:+279->331, 1010:+359->411, 1014:+1109->1161, 1016:+1119->1171, 1017:+1150->1202, 1019:+1469->1521, 1020:+1160->1212, 1023:+424->476, 1024:+1488->1540, 1025:+270->322, 1030:+1510->1562, 1035:+-6->46, 10000:+1169->1221, 10001:+303->355, 10002:+335->387, 1134010:+745->797, 1134011:+771->823, 1134012:+920->972, 1134013:+971->1023, 1134014:+1039->1091, 1134015:+877->929, 1134018:+589->641, 1134019:+628->680, 1134020:+709->761, 1134021:+797->849, 1134022:+822->874, 1134024:+847->899, 1134026:+1519->1571, 11340003:+563->615, 11340004:+719->771, 11340006:+1057->1109, 11340007:+1083->1135
    //   321: ireturn
    //   322: aload_0
    //   323: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   326: invokestatic 49	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   329: iconst_1
    //   330: ireturn
    //   331: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   334: ifeq +11 -> 345
    //   337: ldc 56
    //   339: iconst_2
    //   340: ldc 58
    //   342: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: aload_0
    //   346: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   349: lconst_0
    //   350: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   353: iconst_1
    //   354: ireturn
    //   355: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +11 -> 369
    //   361: ldc 56
    //   363: iconst_2
    //   364: ldc 67
    //   366: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload_0
    //   370: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   373: aload_1
    //   374: invokevirtual 70	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   377: aload_0
    //   378: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   381: iconst_1
    //   382: invokestatic 73	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   385: iconst_1
    //   386: ireturn
    //   387: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +11 -> 401
    //   393: ldc 56
    //   395: iconst_2
    //   396: ldc 75
    //   398: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: aload_0
    //   402: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   405: aload_1
    //   406: invokevirtual 70	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   409: iconst_1
    //   410: ireturn
    //   411: aload_0
    //   412: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   415: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   418: invokevirtual 77	com/tencent/mobileqq/activity/recent/BannerManager:a	()Z
    //   421: ifeq +29 -> 450
    //   424: aload_0
    //   425: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   428: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   431: bipush 12
    //   433: iconst_2
    //   434: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   437: aload_0
    //   438: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   441: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   444: aload_1
    //   445: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   448: iconst_1
    //   449: ireturn
    //   450: aload_0
    //   451: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   454: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   457: bipush 12
    //   459: iconst_0
    //   460: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   463: aload_0
    //   464: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   467: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   470: aconst_null
    //   471: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   474: iconst_1
    //   475: ireturn
    //   476: invokestatic 83	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   479: aload_0
    //   480: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   483: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   486: invokevirtual 86	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   489: ifeq +58 -> 547
    //   492: aload_0
    //   493: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   496: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   499: bipush 11
    //   501: invokevirtual 89	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)I
    //   504: iconst_2
    //   505: if_icmpeq -459 -> 46
    //   508: aload_0
    //   509: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   512: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   515: bipush 11
    //   517: iconst_2
    //   518: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   521: aload_0
    //   522: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   525: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   528: aload_1
    //   529: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   532: invokestatic 83	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   535: aload_0
    //   536: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   539: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   542: invokevirtual 92	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   545: iconst_1
    //   546: ireturn
    //   547: invokestatic 83	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	()Lcom/tencent/mobileqq/phonelogin/PhoneNumLoginImpl;
    //   550: aload_0
    //   551: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   554: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   557: aload_0
    //   558: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   561: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   564: invokevirtual 95	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   567: invokevirtual 98	com/tencent/mobileqq/phonelogin/PhoneNumLoginImpl:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Z
    //   570: ifeq -524 -> 46
    //   573: aload_0
    //   574: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   577: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   580: bipush 11
    //   582: invokevirtual 89	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)I
    //   585: iconst_2
    //   586: if_icmpne -540 -> 46
    //   589: aload_0
    //   590: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   593: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   596: bipush 11
    //   598: iconst_0
    //   599: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   602: aload_0
    //   603: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   606: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   609: aload_1
    //   610: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   613: iconst_1
    //   614: ireturn
    //   615: aload_0
    //   616: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   619: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   622: bipush 7
    //   624: iconst_2
    //   625: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   628: aload_0
    //   629: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   632: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   635: aload_1
    //   636: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   639: iconst_1
    //   640: ireturn
    //   641: aload_0
    //   642: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   645: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   648: bipush 9
    //   650: iconst_2
    //   651: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   654: aload_0
    //   655: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   658: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   661: bipush 7
    //   663: iconst_0
    //   664: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   667: aload_0
    //   668: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   671: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   674: aload_1
    //   675: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   678: iconst_1
    //   679: ireturn
    //   680: aload_0
    //   681: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   684: invokestatic 101	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   687: ifnull +22 -> 709
    //   690: aload_0
    //   691: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   694: invokestatic 101	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   697: invokevirtual 106	com/tencent/mobileqq/activity/UpgradeTipsDialog:dismiss	()V
    //   700: aload_0
    //   701: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   704: aconst_null
    //   705: invokestatic 109	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   708: pop
    //   709: aload_0
    //   710: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   713: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   716: bipush 9
    //   718: iconst_0
    //   719: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   722: aload_0
    //   723: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   726: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   729: aload_1
    //   730: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   733: iconst_1
    //   734: ireturn
    //   735: astore 5
    //   737: aload_0
    //   738: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   741: aconst_null
    //   742: invokestatic 109	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   745: pop
    //   746: goto -37 -> 709
    //   749: astore_1
    //   750: aload_0
    //   751: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   754: aconst_null
    //   755: invokestatic 109	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;)Lcom/tencent/mobileqq/activity/UpgradeTipsDialog;
    //   758: pop
    //   759: aload_1
    //   760: athrow
    //   761: aload_0
    //   762: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   765: aload_1
    //   766: invokestatic 112	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   769: iconst_1
    //   770: ireturn
    //   771: aload_0
    //   772: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   775: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   778: bipush 7
    //   780: iconst_0
    //   781: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   784: aload_0
    //   785: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   788: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   791: aload_1
    //   792: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   795: iconst_1
    //   796: ireturn
    //   797: aload_0
    //   798: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   801: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   804: bipush 14
    //   806: iconst_2
    //   807: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   810: aload_0
    //   811: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   814: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   817: aload_1
    //   818: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   821: iconst_1
    //   822: ireturn
    //   823: aload_0
    //   824: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   827: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   830: bipush 14
    //   832: iconst_0
    //   833: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   836: aload_0
    //   837: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   840: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   843: aload_1
    //   844: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   847: iconst_1
    //   848: ireturn
    //   849: aload_0
    //   850: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   853: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   856: iconst_3
    //   857: iconst_2
    //   858: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   861: aload_0
    //   862: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   865: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   868: aload_1
    //   869: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   872: iconst_1
    //   873: ireturn
    //   874: aload_0
    //   875: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   878: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   881: iconst_3
    //   882: iconst_0
    //   883: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   886: aload_0
    //   887: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   890: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   893: aload_1
    //   894: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   897: iconst_1
    //   898: ireturn
    //   899: aload_1
    //   900: getfield 115	android/os/Message:arg1	I
    //   903: istore_2
    //   904: aload_0
    //   905: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   908: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   911: iconst_4
    //   912: iload_2
    //   913: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   916: aload_0
    //   917: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   920: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   923: aload_1
    //   924: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   927: iconst_1
    //   928: ireturn
    //   929: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   932: ifeq +11 -> 943
    //   935: ldc 56
    //   937: iconst_2
    //   938: ldc 117
    //   940: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   943: aload_0
    //   944: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   947: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   950: iconst_5
    //   951: iconst_0
    //   952: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   955: invokestatic 122	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   958: iconst_0
    //   959: invokevirtual 126	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   962: aload_0
    //   963: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   966: aload_1
    //   967: invokevirtual 70	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   970: iconst_1
    //   971: ireturn
    //   972: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   975: ifeq +11 -> 986
    //   978: ldc 56
    //   980: iconst_2
    //   981: ldc 128
    //   983: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   986: aload_0
    //   987: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   990: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   993: iconst_5
    //   994: iconst_0
    //   995: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   998: invokestatic 122	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   1001: iconst_0
    //   1002: invokevirtual 126	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   1005: aload_0
    //   1006: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1009: aload_1
    //   1010: invokevirtual 70	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   1013: aload_0
    //   1014: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1017: iconst_1
    //   1018: invokestatic 73	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   1021: iconst_1
    //   1022: ireturn
    //   1023: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1026: ifeq +11 -> 1037
    //   1029: ldc 56
    //   1031: iconst_2
    //   1032: ldc 130
    //   1034: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1037: aload_0
    //   1038: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1041: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1044: iconst_5
    //   1045: invokevirtual 133	com/tencent/mobileqq/activity/recent/BannerManager:a	(I)Z
    //   1048: ifne +26 -> 1074
    //   1051: aload_0
    //   1052: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1055: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1058: iconst_5
    //   1059: iconst_2
    //   1060: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1063: aload_0
    //   1064: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1067: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1070: aload_1
    //   1071: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1074: invokestatic 122	com/tencent/mobileqq/managers/LoadingStateManager:a	()Lcom/tencent/mobileqq/managers/LoadingStateManager;
    //   1077: iconst_1
    //   1078: invokevirtual 126	com/tencent/mobileqq/managers/LoadingStateManager:b	(Z)V
    //   1081: aload_0
    //   1082: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1085: iconst_1
    //   1086: invokestatic 73	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   1089: iconst_1
    //   1090: ireturn
    //   1091: aload_0
    //   1092: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1095: aconst_null
    //   1096: invokevirtual 70	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;)V
    //   1099: aload_0
    //   1100: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1103: iconst_1
    //   1104: invokestatic 73	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)V
    //   1107: iconst_1
    //   1108: ireturn
    //   1109: aload_0
    //   1110: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1113: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1116: bipush 12
    //   1118: iconst_0
    //   1119: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1122: aload_0
    //   1123: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1126: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1129: aload_1
    //   1130: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1133: iconst_1
    //   1134: ireturn
    //   1135: aload_0
    //   1136: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1139: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1142: bipush 12
    //   1144: iconst_2
    //   1145: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1148: aload_0
    //   1149: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1152: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1155: aload_1
    //   1156: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1159: iconst_1
    //   1160: ireturn
    //   1161: aload_0
    //   1162: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1165: lconst_0
    //   1166: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   1169: iconst_1
    //   1170: ireturn
    //   1171: aload_0
    //   1172: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1175: iconst_0
    //   1176: invokestatic 136	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)Z
    //   1179: pop
    //   1180: aload_0
    //   1181: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1184: invokestatic 139	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   1187: ifnull -1141 -> 46
    //   1190: aload_0
    //   1191: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1194: invokestatic 139	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   1197: invokevirtual 144	com/tencent/mobileqq/fpsreport/FPSSwipListView:B	()V
    //   1200: iconst_1
    //   1201: ireturn
    //   1202: aload_0
    //   1203: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1206: lconst_0
    //   1207: invokevirtual 65	com/tencent/mobileqq/activity/Conversation:a	(J)V
    //   1210: iconst_1
    //   1211: ireturn
    //   1212: aload_0
    //   1213: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1216: invokestatic 146	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   1219: iconst_1
    //   1220: ireturn
    //   1221: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   1224: aload_0
    //   1225: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1228: invokestatic 155	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)J
    //   1231: lsub
    //   1232: invokestatic 161	java/lang/Math:abs	(J)J
    //   1235: lstore_3
    //   1236: invokestatic 164	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   1239: ifeq +45 -> 1284
    //   1242: ldc 56
    //   1244: iconst_4
    //   1245: new 166	java/lang/StringBuilder
    //   1248: dup
    //   1249: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1252: ldc 169
    //   1254: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1257: aload_1
    //   1258: getfield 115	android/os/Message:arg1	I
    //   1261: invokevirtual 176	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1264: ldc 178
    //   1266: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1269: lload_3
    //   1270: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1273: ldc 183
    //   1275: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1278: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1281: invokestatic 62	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1284: lload_3
    //   1285: lconst_0
    //   1286: lcmp
    //   1287: ifge +325 -> 1612
    //   1290: invokestatic 54	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1293: ifeq +48 -> 1341
    //   1296: ldc 56
    //   1298: iconst_2
    //   1299: new 166	java/lang/StringBuilder
    //   1302: dup
    //   1303: invokespecial 167	java/lang/StringBuilder:<init>	()V
    //   1306: ldc 188
    //   1308: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1311: lload_3
    //   1312: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1315: ldc 178
    //   1317: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1320: aload_0
    //   1321: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1324: invokestatic 155	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)J
    //   1327: invokevirtual 181	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1330: ldc 183
    //   1332: invokevirtual 173	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1335: invokevirtual 186	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1338: invokestatic 191	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1341: aload_0
    //   1342: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1345: getfield 194	com/tencent/mobileqq/activity/Conversation:b	J
    //   1348: lconst_1
    //   1349: ladd
    //   1350: lstore_3
    //   1351: aload_1
    //   1352: getfield 198	android/os/Message:obj	Ljava/lang/Object;
    //   1355: checkcast 200	java/util/List
    //   1358: astore 5
    //   1360: aload_1
    //   1361: getfield 203	android/os/Message:arg2	I
    //   1364: iconst_1
    //   1365: if_icmpeq +83 -> 1448
    //   1368: lload_3
    //   1369: aload_0
    //   1370: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1373: getfield 194	com/tencent/mobileqq/activity/Conversation:b	J
    //   1376: lcmp
    //   1377: ifge +71 -> 1448
    //   1380: aload_0
    //   1381: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1384: aload 5
    //   1386: putfield 206	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1389: invokestatic 210	android/os/Message:obtain	()Landroid/os/Message;
    //   1392: astore_1
    //   1393: aload_1
    //   1394: sipush 10000
    //   1397: putfield 26	android/os/Message:what	I
    //   1400: aload_1
    //   1401: aload_0
    //   1402: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1405: getfield 206	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1408: putfield 198	android/os/Message:obj	Ljava/lang/Object;
    //   1411: aload_1
    //   1412: iconst_0
    //   1413: putfield 115	android/os/Message:arg1	I
    //   1416: aload_1
    //   1417: iconst_1
    //   1418: putfield 203	android/os/Message:arg2	I
    //   1421: aload_0
    //   1422: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1425: getfield 213	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   1428: aload_1
    //   1429: aload_0
    //   1430: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1433: getfield 194	com/tencent/mobileqq/activity/Conversation:b	J
    //   1436: lload_3
    //   1437: lsub
    //   1438: ldc2_w 214
    //   1441: ladd
    //   1442: invokevirtual 221	android/os/Handler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   1445: pop
    //   1446: iconst_1
    //   1447: ireturn
    //   1448: aload_1
    //   1449: getfield 203	android/os/Message:arg2	I
    //   1452: iconst_1
    //   1453: if_icmpne +54 -> 1507
    //   1456: aload 5
    //   1458: aload_0
    //   1459: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1462: getfield 206	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1465: if_acmpne +37 -> 1502
    //   1468: iconst_1
    //   1469: istore_2
    //   1470: iload_2
    //   1471: ifeq -1425 -> 46
    //   1474: aload_0
    //   1475: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1478: iconst_0
    //   1479: aload_0
    //   1480: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1483: getfield 206	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1486: invokevirtual 224	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   1489: aload_0
    //   1490: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1493: invokestatic 152	java/lang/System:currentTimeMillis	()J
    //   1496: invokestatic 227	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;J)J
    //   1499: pop2
    //   1500: iconst_1
    //   1501: ireturn
    //   1502: iconst_0
    //   1503: istore_2
    //   1504: goto -34 -> 1470
    //   1507: aload_0
    //   1508: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1511: aload 5
    //   1513: putfield 206	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_JavaUtilList	Ljava/util/List;
    //   1516: iconst_1
    //   1517: istore_2
    //   1518: goto -48 -> 1470
    //   1521: aload_1
    //   1522: getfield 198	android/os/Message:obj	Ljava/lang/Object;
    //   1525: checkcast 200	java/util/List
    //   1528: astore_1
    //   1529: aload_0
    //   1530: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1533: iconst_1
    //   1534: aload_1
    //   1535: invokevirtual 224	com/tencent/mobileqq/activity/Conversation:a	(ILjava/util/List;)V
    //   1538: iconst_1
    //   1539: ireturn
    //   1540: aload_0
    //   1541: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1544: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1547: ifnull -1501 -> 46
    //   1550: aload_0
    //   1551: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1554: getfield 41	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1557: invokevirtual 230	com/tencent/mobileqq/app/QQAppInterface:y	()V
    //   1560: iconst_1
    //   1561: ireturn
    //   1562: aload_0
    //   1563: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1566: invokestatic 233	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   1569: iconst_1
    //   1570: ireturn
    //   1571: aload_0
    //   1572: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1575: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1578: astore 5
    //   1580: invokestatic 238	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Lcom/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService;
    //   1583: invokevirtual 239	com/tencent/mobileqq/filemanager/fileviewer/FileViewMusicService:a	()Z
    //   1586: ifeq +5 -> 1591
    //   1589: iconst_2
    //   1590: istore_2
    //   1591: aload 5
    //   1593: bipush 16
    //   1595: iload_2
    //   1596: invokevirtual 37	com/tencent/mobileqq/activity/recent/BannerManager:a	(II)V
    //   1599: aload_0
    //   1600: getfield 12	agl:a	Lcom/tencent/mobileqq/activity/Conversation;
    //   1603: getfield 32	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_ComTencentMobileqqActivityRecentBannerManager	Lcom/tencent/mobileqq/activity/recent/BannerManager;
    //   1606: aload_1
    //   1607: invokevirtual 78	com/tencent/mobileqq/activity/recent/BannerManager:a	(Landroid/os/Message;)V
    //   1610: iconst_1
    //   1611: ireturn
    //   1612: goto -261 -> 1351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1615	0	this	agl
    //   0	1615	1	paramMessage	android.os.Message
    //   1	1595	2	i	int
    //   1235	202	3	l	long
    //   735	1	5	localException	java.lang.Exception
    //   1358	234	5	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   690	700	735	java/lang/Exception
    //   690	700	749	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     agl
 * JD-Core Version:    0.7.0.1
 */