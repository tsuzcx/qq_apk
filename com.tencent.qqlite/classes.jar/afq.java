import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class afq
  implements Runnable
{
  public afq(ChatSettingForTroop paramChatSettingForTroop) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 30	com/tencent/mobileqq/utils/DBUtils:a	()Lcom/tencent/mobileqq/utils/DBUtils;
    //   6: aload_0
    //   7: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   10: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: aload_0
    //   14: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   17: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   20: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   27: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   33: invokevirtual 53	com/tencent/mobileqq/utils/DBUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberCardInfo;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnonnull +706 -> 746
    //   43: invokestatic 30	com/tencent/mobileqq/utils/DBUtils:a	()Lcom/tencent/mobileqq/utils/DBUtils;
    //   46: aload_0
    //   47: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   50: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: aload_0
    //   54: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   57: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   60: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   67: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   73: invokevirtual 56	com/tencent/mobileqq/utils/DBUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull +783 -> 863
    //   83: aload 5
    //   85: getfield 61	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   88: astore 4
    //   90: goto +773 -> 863
    //   93: aload_0
    //   94: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   97: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: bipush 17
    //   102: invokevirtual 64	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   105: checkcast 66	com/tencent/mobileqq/app/TroopHandler
    //   108: astore 5
    //   110: aload 4
    //   112: invokestatic 72	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +28 -> 143
    //   118: aload_0
    //   119: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   122: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   125: aload 4
    //   127: putfield 75	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   130: aload_0
    //   131: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   134: getfield 78	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   137: bipush 6
    //   139: invokevirtual 84	android/os/Handler:sendEmptyMessage	(I)Z
    //   142: pop
    //   143: aload 5
    //   145: ifnull +55 -> 200
    //   148: new 86	java/util/ArrayList
    //   151: dup
    //   152: invokespecial 87	java/util/ArrayList:<init>	()V
    //   155: astore 4
    //   157: aload 4
    //   159: aload_0
    //   160: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   163: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   166: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   169: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload 5
    //   175: aload_0
    //   176: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   179: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   182: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   189: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   192: getfield 94	com/tencent/mobileqq/troopinfo/TroopInfoData:d	Ljava/lang/String;
    //   195: aload 4
    //   197: invokevirtual 97	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   200: aload_0
    //   201: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   204: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   207: aload_0
    //   208: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   211: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   217: ldc 99
    //   219: aload_0
    //   220: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   223: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   229: invokestatic 102	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   232: putfield 106	com/tencent/mobileqq/troopinfo/TroopInfoData:h	I
    //   235: aload_0
    //   236: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   239: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   242: aload_0
    //   243: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   246: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   252: ldc 108
    //   254: aload_0
    //   255: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   258: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   261: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   264: invokestatic 102	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   267: putfield 111	com/tencent/mobileqq/troopinfo/TroopInfoData:i	I
    //   270: aload_0
    //   271: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   274: getfield 78	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   277: iconst_4
    //   278: invokevirtual 84	android/os/Handler:sendEmptyMessage	(I)Z
    //   281: pop
    //   282: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +73 -> 358
    //   288: ldc 119
    //   290: iconst_2
    //   291: new 121	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 122	java/lang/StringBuilder:<init>	()V
    //   298: ldc 124
    //   300: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   307: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   310: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   313: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 130
    //   318: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   325: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   328: getfield 106	com/tencent/mobileqq/troopinfo/TroopInfoData:h	I
    //   331: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc 135
    //   336: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_0
    //   340: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   343: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   346: getfield 111	com/tencent/mobileqq/troopinfo/TroopInfoData:i	I
    //   349: invokevirtual 133	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: aload 5
    //   360: ifnull +81 -> 441
    //   363: aload_0
    //   364: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   367: invokevirtual 144	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   370: aload_0
    //   371: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   374: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   377: getfield 147	com/tencent/mobileqq/troopinfo/TroopInfoData:a	Z
    //   380: ifeq +41 -> 421
    //   383: new 86	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 87	java/util/ArrayList:<init>	()V
    //   390: astore 4
    //   392: aload 4
    //   394: aload_0
    //   395: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   398: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   401: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   404: invokestatic 153	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   407: invokestatic 157	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   413: pop
    //   414: aload 5
    //   416: aload 4
    //   418: invokevirtual 160	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/util/ArrayList;)V
    //   421: aload_0
    //   422: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   425: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   428: aload_0
    //   429: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   432: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   435: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   438: invokevirtual 163	com/tencent/mobileqq/app/QQAppInterface:c	(Ljava/lang/String;)V
    //   441: aload_0
    //   442: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   445: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   448: aload_0
    //   449: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   452: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   455: aload_0
    //   456: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   459: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   462: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   465: invokevirtual 167	com/tencent/mobileqq/app/QQAppInterface:b	(Ljava/lang/String;)I
    //   468: putfield 170	com/tencent/mobileqq/troopinfo/TroopInfoData:f	I
    //   471: aload_0
    //   472: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   475: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   478: aload_0
    //   479: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   482: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   485: getfield 170	com/tencent/mobileqq/troopinfo/TroopInfoData:f	I
    //   488: putfield 172	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_Int	I
    //   491: aload_0
    //   492: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   495: getfield 78	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   498: iconst_2
    //   499: invokevirtual 84	android/os/Handler:sendEmptyMessage	(I)Z
    //   502: pop
    //   503: invokestatic 117	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +11 -> 517
    //   509: ldc 119
    //   511: iconst_2
    //   512: ldc 174
    //   514: invokestatic 141	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: aload_0
    //   518: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   521: aload_0
    //   522: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   525: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   528: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   531: invokevirtual 176	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(Ljava/lang/String;)V
    //   534: aload_0
    //   535: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   538: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   541: aload_0
    //   542: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   545: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   548: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   551: ldc 178
    //   553: aload_0
    //   554: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   557: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   560: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   563: invokestatic 102	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   566: putfield 181	com/tencent/mobileqq/troopinfo/TroopInfoData:k	I
    //   569: aload_0
    //   570: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   573: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   576: iconst_0
    //   577: putfield 184	com/tencent/mobileqq/troopinfo/TroopInfoData:j	I
    //   580: aload_0
    //   581: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   584: getfield 78	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   587: bipush 8
    //   589: invokevirtual 84	android/os/Handler:sendEmptyMessage	(I)Z
    //   592: pop
    //   593: ldc 32
    //   595: monitorenter
    //   596: aload_0
    //   597: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   600: getfield 186	com/tencent/mobileqq/activity/ChatSettingForTroop:b	Z
    //   603: istore_1
    //   604: iload_1
    //   605: ifne +89 -> 694
    //   608: aload_0
    //   609: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   612: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   615: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   618: invokestatic 189	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   621: invokevirtual 193	java/lang/Long:longValue	()J
    //   624: lstore_2
    //   625: aload_0
    //   626: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   629: aload_0
    //   630: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   633: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   636: lload_2
    //   637: invokestatic 198	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   640: invokestatic 201	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/troop/utils/TroopFileManager;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   643: pop
    //   644: aload_0
    //   645: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   648: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   651: ifnull +20 -> 671
    //   654: aload_0
    //   655: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   658: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   661: aload_0
    //   662: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   665: getfield 207	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver	Lcom/tencent/mobileqq/troop/data/TroopFileObserver;
    //   668: invokevirtual 211	com/tencent/mobileqq/troop/utils/TroopFileManager:registerObserver	(Ljava/lang/Object;)V
    //   671: aload_0
    //   672: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   675: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   678: ifnull +16 -> 694
    //   681: aload_0
    //   682: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   685: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   688: iconst_3
    //   689: iconst_0
    //   690: iconst_1
    //   691: invokevirtual 214	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(III)V
    //   694: ldc 32
    //   696: monitorexit
    //   697: aload_0
    //   698: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   701: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   704: aload_0
    //   705: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   708: getfield 36	com/tencent/mobileqq/activity/ChatSettingForTroop:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   711: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   714: ldc 216
    //   716: aload_0
    //   717: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   720: getfield 39	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   723: getfield 45	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   726: invokestatic 102	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   729: putfield 218	com/tencent/mobileqq/troopinfo/TroopInfoData:l	I
    //   732: aload_0
    //   733: getfield 12	afq:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   736: getfield 78	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   739: bipush 9
    //   741: invokevirtual 84	android/os/Handler:sendEmptyMessage	(I)Z
    //   744: pop
    //   745: return
    //   746: aload 5
    //   748: getfield 223	com/tencent/mobileqq/data/TroopMemberCardInfo:name	Ljava/lang/String;
    //   751: astore 4
    //   753: goto -660 -> 93
    //   756: astore 4
    //   758: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   761: ifeq -117 -> 644
    //   764: ldc 119
    //   766: iconst_4
    //   767: ldc 228
    //   769: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   772: goto -128 -> 644
    //   775: astore 4
    //   777: ldc 32
    //   779: monitorexit
    //   780: aload 4
    //   782: athrow
    //   783: astore 4
    //   785: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   788: ifeq +78 -> 866
    //   791: ldc 119
    //   793: iconst_4
    //   794: aload 4
    //   796: invokevirtual 232	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   799: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   802: return
    //   803: astore 4
    //   805: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   808: ifeq +58 -> 866
    //   811: ldc 119
    //   813: iconst_4
    //   814: aload 4
    //   816: invokevirtual 233	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   819: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   822: return
    //   823: astore 4
    //   825: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   828: ifeq +38 -> 866
    //   831: ldc 119
    //   833: iconst_4
    //   834: aload 4
    //   836: invokevirtual 234	java/lang/Exception:toString	()Ljava/lang/String;
    //   839: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   842: return
    //   843: astore 4
    //   845: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   848: ifeq +18 -> 866
    //   851: ldc 119
    //   853: iconst_4
    //   854: aload 4
    //   856: invokevirtual 235	java/lang/Error:toString	()Ljava/lang/String;
    //   859: invokestatic 231	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   862: return
    //   863: goto -770 -> 93
    //   866: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	867	0	this	afq
    //   603	2	1	bool	boolean
    //   624	13	2	l	long
    //   1	751	4	localObject1	Object
    //   756	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   775	6	4	localObject2	Object
    //   783	12	4	localNumberFormatException2	java.lang.NumberFormatException
    //   803	12	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   823	12	4	localException	java.lang.Exception
    //   843	12	4	localError	java.lang.Error
    //   36	711	5	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   608	644	756	java/lang/NumberFormatException
    //   596	604	775	finally
    //   608	644	775	finally
    //   644	671	775	finally
    //   671	694	775	finally
    //   694	697	775	finally
    //   758	772	775	finally
    //   777	780	775	finally
    //   3	38	783	java/lang/NumberFormatException
    //   43	78	783	java/lang/NumberFormatException
    //   83	90	783	java/lang/NumberFormatException
    //   93	143	783	java/lang/NumberFormatException
    //   148	200	783	java/lang/NumberFormatException
    //   200	358	783	java/lang/NumberFormatException
    //   363	421	783	java/lang/NumberFormatException
    //   421	441	783	java/lang/NumberFormatException
    //   441	517	783	java/lang/NumberFormatException
    //   517	596	783	java/lang/NumberFormatException
    //   697	745	783	java/lang/NumberFormatException
    //   746	753	783	java/lang/NumberFormatException
    //   780	783	783	java/lang/NumberFormatException
    //   3	38	803	java/lang/IllegalArgumentException
    //   43	78	803	java/lang/IllegalArgumentException
    //   83	90	803	java/lang/IllegalArgumentException
    //   93	143	803	java/lang/IllegalArgumentException
    //   148	200	803	java/lang/IllegalArgumentException
    //   200	358	803	java/lang/IllegalArgumentException
    //   363	421	803	java/lang/IllegalArgumentException
    //   421	441	803	java/lang/IllegalArgumentException
    //   441	517	803	java/lang/IllegalArgumentException
    //   517	596	803	java/lang/IllegalArgumentException
    //   697	745	803	java/lang/IllegalArgumentException
    //   746	753	803	java/lang/IllegalArgumentException
    //   780	783	803	java/lang/IllegalArgumentException
    //   3	38	823	java/lang/Exception
    //   43	78	823	java/lang/Exception
    //   83	90	823	java/lang/Exception
    //   93	143	823	java/lang/Exception
    //   148	200	823	java/lang/Exception
    //   200	358	823	java/lang/Exception
    //   363	421	823	java/lang/Exception
    //   421	441	823	java/lang/Exception
    //   441	517	823	java/lang/Exception
    //   517	596	823	java/lang/Exception
    //   697	745	823	java/lang/Exception
    //   746	753	823	java/lang/Exception
    //   780	783	823	java/lang/Exception
    //   3	38	843	java/lang/Error
    //   43	78	843	java/lang/Error
    //   83	90	843	java/lang/Error
    //   93	143	843	java/lang/Error
    //   148	200	843	java/lang/Error
    //   200	358	843	java/lang/Error
    //   363	421	843	java/lang/Error
    //   421	441	843	java/lang/Error
    //   441	517	843	java/lang/Error
    //   517	596	843	java/lang/Error
    //   697	745	843	java/lang/Error
    //   746	753	843	java/lang/Error
    //   780	783	843	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     afq
 * JD-Core Version:    0.7.0.1
 */