import com.tencent.mobileqq.activity.ChatSettingForTroop;

public class cdu
  extends Thread
{
  public cdu(ChatSettingForTroop paramChatSettingForTroop) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: invokestatic 28	com/tencent/mobileqq/utils/DBUtils:a	()Lcom/tencent/mobileqq/utils/DBUtils;
    //   6: aload_0
    //   7: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   10: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   13: aload_0
    //   14: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   17: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   20: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   23: aload_0
    //   24: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   27: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   30: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   33: invokevirtual 51	com/tencent/mobileqq/utils/DBUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberCardInfo;
    //   36: astore 5
    //   38: aload 5
    //   40: ifnonnull +721 -> 761
    //   43: invokestatic 28	com/tencent/mobileqq/utils/DBUtils:a	()Lcom/tencent/mobileqq/utils/DBUtils;
    //   46: aload_0
    //   47: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   50: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: aload_0
    //   54: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   57: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   60: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   63: aload_0
    //   64: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   67: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   73: invokevirtual 54	com/tencent/mobileqq/utils/DBUtils:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopMemberInfo;
    //   76: astore 5
    //   78: aload 5
    //   80: ifnull +798 -> 878
    //   83: aload 5
    //   85: getfield 59	com/tencent/mobileqq/data/TroopMemberInfo:troopnick	Ljava/lang/String;
    //   88: astore 4
    //   90: goto +788 -> 878
    //   93: aload_0
    //   94: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   97: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: bipush 19
    //   102: invokevirtual 62	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   105: checkcast 64	com/tencent/mobileqq/app/TroopHandler
    //   108: astore 5
    //   110: aload 4
    //   112: invokestatic 70	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   115: ifne +28 -> 143
    //   118: aload_0
    //   119: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   122: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   125: aload 4
    //   127: putfield 73	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   130: aload_0
    //   131: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   134: getfield 76	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   137: bipush 6
    //   139: invokevirtual 82	android/os/Handler:sendEmptyMessage	(I)Z
    //   142: pop
    //   143: aload 5
    //   145: ifnull +55 -> 200
    //   148: new 84	java/util/ArrayList
    //   151: dup
    //   152: invokespecial 85	java/util/ArrayList:<init>	()V
    //   155: astore 4
    //   157: aload 4
    //   159: aload_0
    //   160: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   163: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   166: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   169: invokevirtual 89	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   172: pop
    //   173: aload 5
    //   175: aload_0
    //   176: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   179: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   182: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   185: aload_0
    //   186: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   189: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   192: getfield 92	com/tencent/mobileqq/troopinfo/TroopInfoData:d	Ljava/lang/String;
    //   195: aload 4
    //   197: invokevirtual 95	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   200: aload_0
    //   201: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   204: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   207: aload_0
    //   208: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   211: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   214: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   217: ldc 97
    //   219: aload_0
    //   220: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   223: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   226: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   229: invokestatic 100	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   232: putfield 104	com/tencent/mobileqq/troopinfo/TroopInfoData:h	I
    //   235: aload_0
    //   236: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   239: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   242: aload_0
    //   243: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   246: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   249: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   252: ldc 106
    //   254: aload_0
    //   255: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   258: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   261: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   264: invokestatic 100	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   267: putfield 109	com/tencent/mobileqq/troopinfo/TroopInfoData:i	I
    //   270: aload_0
    //   271: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   274: getfield 76	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   277: iconst_4
    //   278: invokevirtual 82	android/os/Handler:sendEmptyMessage	(I)Z
    //   281: pop
    //   282: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   285: ifeq +73 -> 358
    //   288: ldc 117
    //   290: iconst_2
    //   291: new 119	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   298: ldc 122
    //   300: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload_0
    //   304: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   307: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   310: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   313: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: ldc 128
    //   318: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: aload_0
    //   322: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   325: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   328: getfield 104	com/tencent/mobileqq/troopinfo/TroopInfoData:h	I
    //   331: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   334: ldc 133
    //   336: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: aload_0
    //   340: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   343: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   346: getfield 109	com/tencent/mobileqq/troopinfo/TroopInfoData:i	I
    //   349: invokevirtual 131	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   352: invokevirtual 136	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   355: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   358: aload 5
    //   360: ifnull +96 -> 456
    //   363: aload_0
    //   364: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   367: invokevirtual 142	com/tencent/mobileqq/activity/ChatSettingForTroop:l	()V
    //   370: aload_0
    //   371: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   374: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   377: getfield 145	com/tencent/mobileqq/troopinfo/TroopInfoData:a	Z
    //   380: ifeq +41 -> 421
    //   383: new 84	java/util/ArrayList
    //   386: dup
    //   387: invokespecial 85	java/util/ArrayList:<init>	()V
    //   390: astore 4
    //   392: aload 4
    //   394: aload_0
    //   395: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   398: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   401: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   404: invokestatic 151	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   407: invokestatic 155	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   410: invokevirtual 89	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   413: pop
    //   414: aload 5
    //   416: aload 4
    //   418: invokevirtual 158	com/tencent/mobileqq/app/TroopHandler:a	(Ljava/util/ArrayList;)V
    //   421: aload_0
    //   422: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   425: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   428: aload_0
    //   429: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   432: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   435: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   438: invokevirtual 161	com/tencent/mobileqq/app/QQAppInterface:d	(Ljava/lang/String;)V
    //   441: aload 5
    //   443: aload_0
    //   444: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   447: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   450: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   453: invokevirtual 164	com/tencent/mobileqq/app/TroopHandler:e	(Ljava/lang/String;)V
    //   456: aload_0
    //   457: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   460: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   463: aload_0
    //   464: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   467: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: aload_0
    //   471: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   474: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   477: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   480: invokevirtual 167	com/tencent/mobileqq/app/QQAppInterface:b	(Ljava/lang/String;)I
    //   483: putfield 170	com/tencent/mobileqq/troopinfo/TroopInfoData:f	I
    //   486: aload_0
    //   487: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   490: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   493: aload_0
    //   494: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   497: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   500: getfield 170	com/tencent/mobileqq/troopinfo/TroopInfoData:f	I
    //   503: putfield 172	com/tencent/mobileqq/troopinfo/TroopInfoData:jdField_g_of_type_Int	I
    //   506: aload_0
    //   507: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   510: getfield 76	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   513: iconst_2
    //   514: invokevirtual 82	android/os/Handler:sendEmptyMessage	(I)Z
    //   517: pop
    //   518: invokestatic 115	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   521: ifeq +11 -> 532
    //   524: ldc 117
    //   526: iconst_2
    //   527: ldc 174
    //   529: invokestatic 139	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: aload_0
    //   533: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   536: aload_0
    //   537: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   540: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   543: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   546: invokevirtual 176	com/tencent/mobileqq/activity/ChatSettingForTroop:b	(Ljava/lang/String;)V
    //   549: aload_0
    //   550: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   553: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   556: aload_0
    //   557: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   560: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   563: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   566: ldc 178
    //   568: aload_0
    //   569: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   572: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   575: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   578: invokestatic 100	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   581: putfield 181	com/tencent/mobileqq/troopinfo/TroopInfoData:k	I
    //   584: aload_0
    //   585: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   588: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   591: iconst_0
    //   592: putfield 184	com/tencent/mobileqq/troopinfo/TroopInfoData:j	I
    //   595: aload_0
    //   596: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   599: getfield 76	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   602: bipush 8
    //   604: invokevirtual 82	android/os/Handler:sendEmptyMessage	(I)Z
    //   607: pop
    //   608: ldc 30
    //   610: monitorenter
    //   611: aload_0
    //   612: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   615: getfield 186	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_Boolean	Z
    //   618: istore_1
    //   619: iload_1
    //   620: ifne +89 -> 709
    //   623: aload_0
    //   624: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   627: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   630: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   633: invokestatic 189	java/lang/Long:valueOf	(Ljava/lang/String;)Ljava/lang/Long;
    //   636: invokevirtual 193	java/lang/Long:longValue	()J
    //   639: lstore_2
    //   640: aload_0
    //   641: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   644: aload_0
    //   645: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   648: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   651: lload_2
    //   652: invokestatic 198	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;J)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   655: invokestatic 201	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;Lcom/tencent/mobileqq/troop/utils/TroopFileManager;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   658: pop
    //   659: aload_0
    //   660: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   663: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   666: ifnull +20 -> 686
    //   669: aload_0
    //   670: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   673: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   676: aload_0
    //   677: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   680: getfield 207	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopDataTroopFileObserver	Lcom/tencent/mobileqq/troop/data/TroopFileObserver;
    //   683: invokevirtual 211	com/tencent/mobileqq/troop/utils/TroopFileManager:registerObserver	(Ljava/lang/Object;)V
    //   686: aload_0
    //   687: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   690: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   693: ifnull +16 -> 709
    //   696: aload_0
    //   697: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   700: invokestatic 204	com/tencent/mobileqq/activity/ChatSettingForTroop:a	(Lcom/tencent/mobileqq/activity/ChatSettingForTroop;)Lcom/tencent/mobileqq/troop/utils/TroopFileManager;
    //   703: iconst_3
    //   704: iconst_0
    //   705: iconst_1
    //   706: invokevirtual 214	com/tencent/mobileqq/troop/utils/TroopFileManager:a	(III)V
    //   709: ldc 30
    //   711: monitorexit
    //   712: aload_0
    //   713: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   716: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   719: aload_0
    //   720: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   723: getfield 34	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   726: invokevirtual 48	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   729: ldc 216
    //   731: aload_0
    //   732: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   735: getfield 37	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_ComTencentMobileqqTroopinfoTroopInfoData	Lcom/tencent/mobileqq/troopinfo/TroopInfoData;
    //   738: getfield 43	com/tencent/mobileqq/troopinfo/TroopInfoData:c	Ljava/lang/String;
    //   741: invokestatic 100	com/tencent/mobileqq/utils/DBUtils:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   744: putfield 218	com/tencent/mobileqq/troopinfo/TroopInfoData:l	I
    //   747: aload_0
    //   748: getfield 10	cdu:a	Lcom/tencent/mobileqq/activity/ChatSettingForTroop;
    //   751: getfield 76	com/tencent/mobileqq/activity/ChatSettingForTroop:jdField_a_of_type_AndroidOsHandler	Landroid/os/Handler;
    //   754: bipush 9
    //   756: invokevirtual 82	android/os/Handler:sendEmptyMessage	(I)Z
    //   759: pop
    //   760: return
    //   761: aload 5
    //   763: getfield 223	com/tencent/mobileqq/data/TroopMemberCardInfo:name	Ljava/lang/String;
    //   766: astore 4
    //   768: goto -675 -> 93
    //   771: astore 4
    //   773: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   776: ifeq -117 -> 659
    //   779: ldc 117
    //   781: iconst_4
    //   782: ldc 228
    //   784: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   787: goto -128 -> 659
    //   790: astore 4
    //   792: ldc 30
    //   794: monitorexit
    //   795: aload 4
    //   797: athrow
    //   798: astore 4
    //   800: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   803: ifeq +78 -> 881
    //   806: ldc 117
    //   808: iconst_4
    //   809: aload 4
    //   811: invokevirtual 231	java/lang/NumberFormatException:toString	()Ljava/lang/String;
    //   814: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   817: return
    //   818: astore 4
    //   820: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   823: ifeq +58 -> 881
    //   826: ldc 117
    //   828: iconst_4
    //   829: aload 4
    //   831: invokevirtual 232	java/lang/IllegalArgumentException:toString	()Ljava/lang/String;
    //   834: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: return
    //   838: astore 4
    //   840: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   843: ifeq +38 -> 881
    //   846: ldc 117
    //   848: iconst_4
    //   849: aload 4
    //   851: invokevirtual 233	java/lang/Exception:toString	()Ljava/lang/String;
    //   854: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   857: return
    //   858: astore 4
    //   860: invokestatic 226	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   863: ifeq +18 -> 881
    //   866: ldc 117
    //   868: iconst_4
    //   869: aload 4
    //   871: invokevirtual 234	java/lang/Error:toString	()Ljava/lang/String;
    //   874: invokestatic 230	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   877: return
    //   878: goto -785 -> 93
    //   881: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	882	0	this	cdu
    //   618	2	1	bool	boolean
    //   639	13	2	l	long
    //   1	766	4	localObject1	java.lang.Object
    //   771	1	4	localNumberFormatException1	java.lang.NumberFormatException
    //   790	6	4	localObject2	java.lang.Object
    //   798	12	4	localNumberFormatException2	java.lang.NumberFormatException
    //   818	12	4	localIllegalArgumentException	java.lang.IllegalArgumentException
    //   838	12	4	localException	java.lang.Exception
    //   858	12	4	localError	java.lang.Error
    //   36	726	5	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   623	659	771	java/lang/NumberFormatException
    //   611	619	790	finally
    //   623	659	790	finally
    //   659	686	790	finally
    //   686	709	790	finally
    //   709	712	790	finally
    //   773	787	790	finally
    //   792	795	790	finally
    //   3	38	798	java/lang/NumberFormatException
    //   43	78	798	java/lang/NumberFormatException
    //   83	90	798	java/lang/NumberFormatException
    //   93	143	798	java/lang/NumberFormatException
    //   148	200	798	java/lang/NumberFormatException
    //   200	358	798	java/lang/NumberFormatException
    //   363	421	798	java/lang/NumberFormatException
    //   421	456	798	java/lang/NumberFormatException
    //   456	532	798	java/lang/NumberFormatException
    //   532	611	798	java/lang/NumberFormatException
    //   712	760	798	java/lang/NumberFormatException
    //   761	768	798	java/lang/NumberFormatException
    //   795	798	798	java/lang/NumberFormatException
    //   3	38	818	java/lang/IllegalArgumentException
    //   43	78	818	java/lang/IllegalArgumentException
    //   83	90	818	java/lang/IllegalArgumentException
    //   93	143	818	java/lang/IllegalArgumentException
    //   148	200	818	java/lang/IllegalArgumentException
    //   200	358	818	java/lang/IllegalArgumentException
    //   363	421	818	java/lang/IllegalArgumentException
    //   421	456	818	java/lang/IllegalArgumentException
    //   456	532	818	java/lang/IllegalArgumentException
    //   532	611	818	java/lang/IllegalArgumentException
    //   712	760	818	java/lang/IllegalArgumentException
    //   761	768	818	java/lang/IllegalArgumentException
    //   795	798	818	java/lang/IllegalArgumentException
    //   3	38	838	java/lang/Exception
    //   43	78	838	java/lang/Exception
    //   83	90	838	java/lang/Exception
    //   93	143	838	java/lang/Exception
    //   148	200	838	java/lang/Exception
    //   200	358	838	java/lang/Exception
    //   363	421	838	java/lang/Exception
    //   421	456	838	java/lang/Exception
    //   456	532	838	java/lang/Exception
    //   532	611	838	java/lang/Exception
    //   712	760	838	java/lang/Exception
    //   761	768	838	java/lang/Exception
    //   795	798	838	java/lang/Exception
    //   3	38	858	java/lang/Error
    //   43	78	858	java/lang/Error
    //   83	90	858	java/lang/Error
    //   93	143	858	java/lang/Error
    //   148	200	858	java/lang/Error
    //   200	358	858	java/lang/Error
    //   363	421	858	java/lang/Error
    //   421	456	858	java/lang/Error
    //   456	532	858	java/lang/Error
    //   532	611	858	java/lang/Error
    //   712	760	858	java/lang/Error
    //   761	768	858	java/lang/Error
    //   795	798	858	java/lang/Error
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cdu
 * JD-Core Version:    0.7.0.1
 */