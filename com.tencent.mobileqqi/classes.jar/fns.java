import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emosm.web.MessengerService.EmoDataInfo;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class fns
  implements MessengerService.EmoDataInfo
{
  public fns(EmoticonController paramEmoticonController) {}
  
  /* Error */
  private Bundle a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: iconst_m1
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 7
    //   9: iconst_0
    //   10: istore 12
    //   12: lconst_0
    //   13: lstore 17
    //   15: iconst_0
    //   16: istore 14
    //   18: iconst_0
    //   19: istore 8
    //   21: iconst_m1
    //   22: istore 11
    //   24: iconst_0
    //   25: istore_3
    //   26: aconst_null
    //   27: astore 21
    //   29: aconst_null
    //   30: astore 22
    //   32: new 21	java/util/ArrayList
    //   35: dup
    //   36: invokespecial 22	java/util/ArrayList:<init>	()V
    //   39: astore 19
    //   41: aload 19
    //   43: aload_0
    //   44: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   47: getfield 28	com/tencent/mobileqq/emoticon/EmoticonController:c	Ljava/util/ArrayList;
    //   50: invokevirtual 32	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   53: pop
    //   54: aload 19
    //   56: aload_0
    //   57: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   60: getfield 35	com/tencent/mobileqq/emoticon/EmoticonController:d	Ljava/util/ArrayList;
    //   63: invokevirtual 32	java/util/ArrayList:addAll	(Ljava/util/Collection;)Z
    //   66: pop
    //   67: aload_0
    //   68: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   71: invokestatic 38	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/model/EmoticonManager;
    //   74: aload_1
    //   75: invokeinterface 44 2 0
    //   80: astore 20
    //   82: aload 20
    //   84: ifnull +13 -> 97
    //   87: aload 20
    //   89: getfield 50	com/tencent/mobileqq/data/EmoticonPackage:valid	Z
    //   92: ifeq +467 -> 559
    //   95: iconst_1
    //   96: istore_3
    //   97: iload_2
    //   98: iconst_2
    //   99: if_icmpne +1505 -> 1604
    //   102: iconst_1
    //   103: istore 10
    //   105: aload 19
    //   107: invokevirtual 54	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   110: astore 19
    //   112: iload 14
    //   114: istore 5
    //   116: iload 13
    //   118: istore 4
    //   120: iload 9
    //   122: istore 6
    //   124: aload 19
    //   126: invokeinterface 60 1 0
    //   131: ifeq +1463 -> 1594
    //   134: aload 19
    //   136: invokeinterface 64 1 0
    //   141: checkcast 66	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler
    //   144: astore 20
    //   146: aload 20
    //   148: ifnull -36 -> 112
    //   151: aload_1
    //   152: aload 20
    //   154: getfield 69	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage	Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   157: getfield 73	com/tencent/mobileqq/data/EmoticonPackage:epId	Ljava/lang/String;
    //   160: invokevirtual 79	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   163: ifeq -51 -> 112
    //   166: aload 20
    //   168: invokevirtual 81	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()Z
    //   171: ifeq +437 -> 608
    //   174: iconst_0
    //   175: istore 6
    //   177: aload 20
    //   179: getfield 69	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage	Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   182: getfield 85	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   185: ifeq +15 -> 200
    //   188: iload 8
    //   190: istore_3
    //   191: iload 7
    //   193: istore 4
    //   195: iload_2
    //   196: iconst_2
    //   197: if_icmpne +30 -> 227
    //   200: aload 20
    //   202: getfield 87	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:b	I
    //   205: ifle +359 -> 564
    //   208: aload 20
    //   210: getfield 87	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:b	I
    //   213: aload 20
    //   215: getfield 89	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:jdField_a_of_type_Int	I
    //   218: if_icmpne +346 -> 564
    //   221: bipush 100
    //   223: istore_3
    //   224: iconst_3
    //   225: istore 4
    //   227: iload_3
    //   228: istore 5
    //   230: aload 20
    //   232: getfield 69	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage	Lcom/tencent/mobileqq/data/EmoticonPackage;
    //   235: getfield 85	com/tencent/mobileqq/data/EmoticonPackage:jobType	I
    //   238: iconst_3
    //   239: if_icmpne +1355 -> 1594
    //   242: aload_0
    //   243: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   246: invokestatic 38	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/model/EmoticonManager;
    //   249: aload_1
    //   250: invokeinterface 44 2 0
    //   255: ifnull +344 -> 599
    //   258: aload 20
    //   260: getfield 87	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:b	I
    //   263: ifle +317 -> 580
    //   266: aload 20
    //   268: getfield 87	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:b	I
    //   271: aload 20
    //   273: getfield 89	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:jdField_a_of_type_Int	I
    //   276: if_icmpne +304 -> 580
    //   279: bipush 100
    //   281: istore_3
    //   282: iconst_3
    //   283: istore 4
    //   285: iconst_0
    //   286: istore 5
    //   288: iload 5
    //   290: iconst_m1
    //   291: if_icmpne +1021 -> 1312
    //   294: iload_2
    //   295: iconst_1
    //   296: if_icmpne +338 -> 634
    //   299: aload_0
    //   300: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   303: invokestatic 38	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/model/EmoticonManager;
    //   306: aload_1
    //   307: invokeinterface 44 2 0
    //   312: astore 19
    //   314: aload 19
    //   316: ifnull +1241 -> 1557
    //   319: aload 19
    //   321: getfield 92	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   324: iconst_2
    //   325: if_icmpne +1232 -> 1557
    //   328: aload_0
    //   329: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   332: aload_1
    //   333: invokevirtual 95	com/tencent/mobileqq/emoticon/EmoticonController:a	(Ljava/lang/String;)Z
    //   336: ifeq +291 -> 627
    //   339: aload 19
    //   341: getfield 98	com/tencent/mobileqq/data/EmoticonPackage:updateFlag	I
    //   344: invokestatic 103	com/tencent/mobileqq/emoticonview/EmoticonUtils:a	(I)Z
    //   347: ifeq +272 -> 619
    //   350: iconst_4
    //   351: istore_3
    //   352: iconst_0
    //   353: istore_2
    //   354: lconst_0
    //   355: lstore 15
    //   357: iconst_0
    //   358: istore 4
    //   360: aconst_null
    //   361: astore 20
    //   363: iconst_0
    //   364: istore 6
    //   366: iconst_m1
    //   367: istore 7
    //   369: aconst_null
    //   370: astore 19
    //   372: iload_3
    //   373: istore 5
    //   375: iload_2
    //   376: istore_3
    //   377: iload 7
    //   379: istore_2
    //   380: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   383: ifeq +1077 -> 1460
    //   386: ldc 110
    //   388: iconst_2
    //   389: new 112	java/lang/StringBuilder
    //   392: dup
    //   393: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   396: ldc 115
    //   398: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: iload 6
    //   403: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   406: ldc 124
    //   408: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: iload 5
    //   413: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: ldc 126
    //   418: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   424: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   427: iload 4
    //   429: istore 9
    //   431: iload_2
    //   432: istore 8
    //   434: iload 6
    //   436: istore_2
    //   437: iload 5
    //   439: istore 6
    //   441: iload_3
    //   442: istore 7
    //   444: iload_2
    //   445: istore_3
    //   446: iload_2
    //   447: iconst_m1
    //   448: if_icmpne +11 -> 459
    //   451: iconst_0
    //   452: istore_3
    //   453: iconst_0
    //   454: istore 6
    //   456: iconst_0
    //   457: istore 7
    //   459: new 135	android/os/Bundle
    //   462: dup
    //   463: invokespecial 136	android/os/Bundle:<init>	()V
    //   466: astore 21
    //   468: aload 21
    //   470: ldc 138
    //   472: aload_1
    //   473: invokevirtual 142	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   476: aload 21
    //   478: ldc 144
    //   480: iload_3
    //   481: invokevirtual 148	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   484: aload 21
    //   486: ldc 149
    //   488: iload 6
    //   490: invokevirtual 148	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   493: aload 21
    //   495: ldc 151
    //   497: iload 9
    //   499: invokevirtual 148	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   502: aload 21
    //   504: ldc 153
    //   506: lload 15
    //   508: invokevirtual 157	android/os/Bundle:putLong	(Ljava/lang/String;J)V
    //   511: aload 21
    //   513: ldc 159
    //   515: iload 7
    //   517: invokevirtual 148	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   520: aload 21
    //   522: ldc 161
    //   524: iload 8
    //   526: invokevirtual 148	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   529: aload 21
    //   531: ldc 163
    //   533: iload 10
    //   535: invokevirtual 148	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   538: aload 21
    //   540: ldc 165
    //   542: aload 20
    //   544: invokevirtual 169	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   547: aload 21
    //   549: ldc 171
    //   551: aload 19
    //   553: invokevirtual 169	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   556: aload 21
    //   558: areturn
    //   559: iconst_0
    //   560: istore_3
    //   561: goto -464 -> 97
    //   564: aload 20
    //   566: invokevirtual 174	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()F
    //   569: ldc 175
    //   571: fmul
    //   572: f2i
    //   573: istore_3
    //   574: iconst_2
    //   575: istore 4
    //   577: goto -350 -> 227
    //   580: aload 20
    //   582: invokevirtual 174	com/tencent/mobileqq/emoticon/EmoticonController$ProgressHandler:a	()F
    //   585: ldc 175
    //   587: fmul
    //   588: f2i
    //   589: istore_3
    //   590: iconst_2
    //   591: istore 4
    //   593: iconst_0
    //   594: istore 5
    //   596: goto -308 -> 288
    //   599: iconst_1
    //   600: istore 4
    //   602: iconst_0
    //   603: istore 5
    //   605: goto -317 -> 288
    //   608: iconst_1
    //   609: istore 4
    //   611: iconst_0
    //   612: istore 5
    //   614: iconst_0
    //   615: istore_3
    //   616: goto -328 -> 288
    //   619: bipush 100
    //   621: istore_2
    //   622: iconst_3
    //   623: istore_3
    //   624: goto -270 -> 354
    //   627: iconst_0
    //   628: istore_3
    //   629: iconst_0
    //   630: istore_2
    //   631: goto -277 -> 354
    //   634: iload_2
    //   635: iconst_3
    //   636: if_icmpne +88 -> 724
    //   639: aload_0
    //   640: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   643: invokestatic 38	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/model/EmoticonManager;
    //   646: aload_1
    //   647: invokeinterface 44 2 0
    //   652: astore 19
    //   654: aload 19
    //   656: ifnull +901 -> 1557
    //   659: aload 19
    //   661: getfield 92	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   664: iconst_2
    //   665: if_icmpne +892 -> 1557
    //   668: aload_0
    //   669: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   672: aload_1
    //   673: iconst_1
    //   674: invokestatic 181	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   677: invokevirtual 184	com/tencent/mobileqq/emoticon/EmoticonController:a	(Ljava/lang/String;Ljava/lang/Boolean;)Z
    //   680: ifeq +37 -> 717
    //   683: bipush 100
    //   685: istore_2
    //   686: iconst_3
    //   687: istore_3
    //   688: lconst_0
    //   689: lstore 15
    //   691: iconst_0
    //   692: istore 4
    //   694: iload_3
    //   695: istore 5
    //   697: aconst_null
    //   698: astore 20
    //   700: iconst_0
    //   701: istore 6
    //   703: iconst_m1
    //   704: istore 7
    //   706: iload_2
    //   707: istore_3
    //   708: aconst_null
    //   709: astore 19
    //   711: iload 7
    //   713: istore_2
    //   714: goto -334 -> 380
    //   717: iconst_0
    //   718: istore_3
    //   719: iconst_0
    //   720: istore_2
    //   721: goto -33 -> 688
    //   724: iload_2
    //   725: iconst_2
    //   726: if_icmpne +831 -> 1557
    //   729: aload_0
    //   730: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   733: invokestatic 187	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/app/QQAppInterface;
    //   736: ldc 189
    //   738: invokestatic 194	com/tencent/mobileqq/emoticon/EPluginInstallTask:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)Lcooperation/plugin/PluginInfo;
    //   741: astore 19
    //   743: aload 19
    //   745: ifnull +509 -> 1254
    //   748: aload 19
    //   750: getfield 199	cooperation/plugin/PluginInfo:mState	I
    //   753: iconst_4
    //   754: if_icmpne +500 -> 1254
    //   757: aload 19
    //   759: getfield 203	cooperation/plugin/PluginInfo:mLength	J
    //   762: lstore 15
    //   764: aload_0
    //   765: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   768: invokestatic 38	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/model/EmoticonManager;
    //   771: aload_1
    //   772: invokeinterface 205 2 0
    //   777: astore 19
    //   779: aload 19
    //   781: ifnull +742 -> 1523
    //   784: aload 19
    //   786: getfield 92	com/tencent/mobileqq/data/EmoticonPackage:status	I
    //   789: iconst_2
    //   790: if_icmpne +442 -> 1232
    //   793: aload 19
    //   795: getfield 208	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   798: ifnull +702 -> 1500
    //   801: aload 19
    //   803: getfield 208	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   806: invokevirtual 212	java/lang/String:length	()I
    //   809: ifle +691 -> 1500
    //   812: iload 11
    //   814: istore_3
    //   815: aload 19
    //   817: getfield 208	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   820: invokestatic 218	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   823: istore_2
    //   824: iload_2
    //   825: istore_3
    //   826: aload_0
    //   827: getfield 12	fns:a	Lcom/tencent/mobileqq/emoticon/EmoticonController;
    //   830: invokestatic 38	com/tencent/mobileqq/emoticon/EmoticonController:a	(Lcom/tencent/mobileqq/emoticon/EmoticonController;)Lcom/tencent/mobileqq/model/EmoticonManager;
    //   833: aload 19
    //   835: getfield 208	com/tencent/mobileqq/data/EmoticonPackage:kinId	Ljava/lang/String;
    //   838: invokeinterface 221 2 0
    //   843: checkcast 21	java/util/ArrayList
    //   846: astore 21
    //   848: aload 21
    //   850: ifnull +641 -> 1491
    //   853: iload_2
    //   854: istore_3
    //   855: aload 21
    //   857: invokevirtual 224	java/util/ArrayList:size	()I
    //   860: istore 4
    //   862: iload_2
    //   863: istore_3
    //   864: new 21	java/util/ArrayList
    //   867: dup
    //   868: iload 4
    //   870: invokespecial 227	java/util/ArrayList:<init>	(I)V
    //   873: astore 20
    //   875: new 21	java/util/ArrayList
    //   878: dup
    //   879: iload 4
    //   881: invokespecial 227	java/util/ArrayList:<init>	(I)V
    //   884: astore 19
    //   886: iconst_0
    //   887: istore_3
    //   888: iload_3
    //   889: iload 4
    //   891: if_icmpge +102 -> 993
    //   894: aload 21
    //   896: iload_3
    //   897: invokevirtual 231	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   900: checkcast 233	com/tencent/mobileqq/data/Emoticon
    //   903: astore 22
    //   905: aload 22
    //   907: getfield 234	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   910: aload 22
    //   912: getfield 237	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   915: invokestatic 243	com/tencent/mobileqq/emosm/EmosmUtils:getEmoticonPreviewPath	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   918: astore 23
    //   920: aload 23
    //   922: invokestatic 247	com/tencent/mobileqq/transfile/filebrowser/FileUtils:c	(Ljava/lang/String;)Z
    //   925: ifeq +61 -> 986
    //   928: aload 20
    //   930: aload 23
    //   932: invokevirtual 250	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   935: pop
    //   936: aload 19
    //   938: new 112	java/lang/StringBuilder
    //   941: dup
    //   942: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   945: aload 22
    //   947: getfield 234	com/tencent/mobileqq/data/Emoticon:epId	Ljava/lang/String;
    //   950: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: ldc 252
    //   955: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: aload 22
    //   960: getfield 237	com/tencent/mobileqq/data/Emoticon:eId	Ljava/lang/String;
    //   963: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   966: ldc 252
    //   968: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   971: aload 22
    //   973: getfield 255	com/tencent/mobileqq/data/Emoticon:encryptKey	Ljava/lang/String;
    //   976: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokevirtual 250	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   985: pop
    //   986: iload_3
    //   987: iconst_1
    //   988: iadd
    //   989: istore_3
    //   990: goto -102 -> 888
    //   993: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   996: ifeq +62 -> 1058
    //   999: new 112	java/lang/StringBuilder
    //   1002: dup
    //   1003: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   1006: ldc_w 257
    //   1009: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1012: astore 22
    //   1014: aload 20
    //   1016: ifnonnull +101 -> 1117
    //   1019: iconst_0
    //   1020: istore_3
    //   1021: aload 22
    //   1023: iload_3
    //   1024: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1027: ldc_w 259
    //   1030: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: astore 22
    //   1035: aload 21
    //   1037: ifnonnull +89 -> 1126
    //   1040: iconst_0
    //   1041: istore_3
    //   1042: ldc_w 261
    //   1045: iconst_2
    //   1046: aload 22
    //   1048: iload_3
    //   1049: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1052: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1055: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1058: aload 20
    //   1060: ifnull +24 -> 1084
    //   1063: aload 20
    //   1065: invokevirtual 224	java/util/ArrayList:size	()I
    //   1068: ifeq +16 -> 1084
    //   1071: aload 19
    //   1073: ifnull +11 -> 1084
    //   1076: aload 19
    //   1078: invokevirtual 224	java/util/ArrayList:size	()I
    //   1081: ifne +399 -> 1480
    //   1084: iconst_0
    //   1085: istore_2
    //   1086: aload 20
    //   1088: astore 21
    //   1090: aload 19
    //   1092: astore 22
    //   1094: bipush 100
    //   1096: istore_3
    //   1097: iconst_1
    //   1098: istore 4
    //   1100: iconst_3
    //   1101: istore 5
    //   1103: iconst_0
    //   1104: istore 6
    //   1106: aload 22
    //   1108: astore 19
    //   1110: aload 21
    //   1112: astore 20
    //   1114: goto -734 -> 380
    //   1117: aload 20
    //   1119: invokevirtual 224	java/util/ArrayList:size	()I
    //   1122: istore_3
    //   1123: goto -102 -> 1021
    //   1126: aload 21
    //   1128: invokevirtual 224	java/util/ArrayList:size	()I
    //   1131: istore_3
    //   1132: goto -90 -> 1042
    //   1135: astore 21
    //   1137: aconst_null
    //   1138: astore 20
    //   1140: iload_3
    //   1141: istore_2
    //   1142: aconst_null
    //   1143: astore 19
    //   1145: aload 21
    //   1147: invokevirtual 264	java/lang/Exception:printStackTrace	()V
    //   1150: aload 20
    //   1152: ifnull +32 -> 1184
    //   1155: aload 20
    //   1157: invokevirtual 224	java/util/ArrayList:size	()I
    //   1160: ifeq +24 -> 1184
    //   1163: aload 19
    //   1165: ifnull +19 -> 1184
    //   1168: aload 19
    //   1170: astore 22
    //   1172: aload 20
    //   1174: astore 21
    //   1176: aload 19
    //   1178: invokevirtual 224	java/util/ArrayList:size	()I
    //   1181: ifne -87 -> 1094
    //   1184: iconst_0
    //   1185: istore_2
    //   1186: aload 19
    //   1188: astore 22
    //   1190: aload 20
    //   1192: astore 21
    //   1194: goto -100 -> 1094
    //   1197: astore_1
    //   1198: aconst_null
    //   1199: astore 19
    //   1201: aconst_null
    //   1202: astore 20
    //   1204: aload 20
    //   1206: ifnull +24 -> 1230
    //   1209: aload 20
    //   1211: invokevirtual 224	java/util/ArrayList:size	()I
    //   1214: ifeq +16 -> 1230
    //   1217: aload 19
    //   1219: ifnull +11 -> 1230
    //   1222: aload 19
    //   1224: invokevirtual 224	java/util/ArrayList:size	()I
    //   1227: ifne +3 -> 1230
    //   1230: aload_1
    //   1231: athrow
    //   1232: iconst_1
    //   1233: istore 4
    //   1235: iconst_0
    //   1236: istore_3
    //   1237: aconst_null
    //   1238: astore 19
    //   1240: iconst_0
    //   1241: istore 5
    //   1243: iconst_0
    //   1244: istore 6
    //   1246: iconst_m1
    //   1247: istore_2
    //   1248: aconst_null
    //   1249: astore 20
    //   1251: goto -871 -> 380
    //   1254: iconst_0
    //   1255: istore 6
    //   1257: aload 19
    //   1259: ifnull +29 -> 1288
    //   1262: aload 19
    //   1264: getfield 203	cooperation/plugin/PluginInfo:mLength	J
    //   1267: lstore 15
    //   1269: iconst_0
    //   1270: istore 4
    //   1272: iconst_0
    //   1273: istore 5
    //   1275: aconst_null
    //   1276: astore 20
    //   1278: iconst_m1
    //   1279: istore_2
    //   1280: iconst_0
    //   1281: istore_3
    //   1282: aconst_null
    //   1283: astore 19
    //   1285: goto -905 -> 380
    //   1288: ldc2_w 265
    //   1291: lstore 15
    //   1293: iconst_0
    //   1294: istore 4
    //   1296: iconst_0
    //   1297: istore 5
    //   1299: aconst_null
    //   1300: astore 20
    //   1302: iconst_m1
    //   1303: istore_2
    //   1304: iconst_0
    //   1305: istore_3
    //   1306: aconst_null
    //   1307: astore 19
    //   1309: goto -929 -> 380
    //   1312: iload_3
    //   1313: istore 7
    //   1315: iload 4
    //   1317: istore 6
    //   1319: iload 5
    //   1321: istore_2
    //   1322: iload 11
    //   1324: istore 8
    //   1326: aload 22
    //   1328: astore 19
    //   1330: aload 21
    //   1332: astore 20
    //   1334: lload 17
    //   1336: lstore 15
    //   1338: iload 12
    //   1340: istore 9
    //   1342: invokestatic 108	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1345: ifeq -901 -> 444
    //   1348: ldc 110
    //   1350: iconst_2
    //   1351: new 112	java/lang/StringBuilder
    //   1354: dup
    //   1355: invokespecial 113	java/lang/StringBuilder:<init>	()V
    //   1358: ldc_w 268
    //   1361: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1364: iload 5
    //   1366: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1369: ldc 124
    //   1371: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: iload 4
    //   1376: invokevirtual 122	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1379: ldc 126
    //   1381: invokevirtual 119	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1384: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1387: invokestatic 133	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1390: iload_3
    //   1391: istore 7
    //   1393: iload 4
    //   1395: istore 6
    //   1397: iload 5
    //   1399: istore_2
    //   1400: iload 11
    //   1402: istore 8
    //   1404: aload 22
    //   1406: astore 19
    //   1408: aload 21
    //   1410: astore 20
    //   1412: lload 17
    //   1414: lstore 15
    //   1416: iload 12
    //   1418: istore 9
    //   1420: goto -976 -> 444
    //   1423: astore_1
    //   1424: aconst_null
    //   1425: astore 19
    //   1427: goto -223 -> 1204
    //   1430: astore_1
    //   1431: goto -227 -> 1204
    //   1434: astore_1
    //   1435: goto -231 -> 1204
    //   1438: astore_1
    //   1439: goto -235 -> 1204
    //   1442: astore 21
    //   1444: aconst_null
    //   1445: astore 19
    //   1447: goto -302 -> 1145
    //   1450: astore 21
    //   1452: goto -307 -> 1145
    //   1455: astore 21
    //   1457: goto -312 -> 1145
    //   1460: iload_2
    //   1461: istore 8
    //   1463: iload 6
    //   1465: istore_2
    //   1466: iload_3
    //   1467: istore 7
    //   1469: iload 5
    //   1471: istore 6
    //   1473: iload 4
    //   1475: istore 9
    //   1477: goto -1033 -> 444
    //   1480: aload 19
    //   1482: astore 22
    //   1484: aload 20
    //   1486: astore 21
    //   1488: goto -394 -> 1094
    //   1491: aconst_null
    //   1492: astore 19
    //   1494: aconst_null
    //   1495: astore 20
    //   1497: goto -504 -> 993
    //   1500: aconst_null
    //   1501: astore 19
    //   1503: aconst_null
    //   1504: astore 20
    //   1506: iconst_m1
    //   1507: istore_2
    //   1508: bipush 100
    //   1510: istore_3
    //   1511: iconst_1
    //   1512: istore 4
    //   1514: iconst_3
    //   1515: istore 5
    //   1517: iconst_0
    //   1518: istore 6
    //   1520: goto -1140 -> 380
    //   1523: iconst_1
    //   1524: istore 8
    //   1526: aconst_null
    //   1527: astore 19
    //   1529: iload 4
    //   1531: istore 6
    //   1533: iload 5
    //   1535: istore 7
    //   1537: iconst_m1
    //   1538: istore_2
    //   1539: aconst_null
    //   1540: astore 20
    //   1542: iload 8
    //   1544: istore 4
    //   1546: iload 6
    //   1548: istore 5
    //   1550: iload 7
    //   1552: istore 6
    //   1554: goto -1174 -> 380
    //   1557: lconst_0
    //   1558: lstore 15
    //   1560: iconst_0
    //   1561: istore 8
    //   1563: iload 4
    //   1565: istore 6
    //   1567: aconst_null
    //   1568: astore 20
    //   1570: iload 5
    //   1572: istore 7
    //   1574: iconst_m1
    //   1575: istore_2
    //   1576: aconst_null
    //   1577: astore 19
    //   1579: iload 8
    //   1581: istore 4
    //   1583: iload 6
    //   1585: istore 5
    //   1587: iload 7
    //   1589: istore 6
    //   1591: goto -1211 -> 380
    //   1594: iload 5
    //   1596: istore_3
    //   1597: iload 6
    //   1599: istore 5
    //   1601: goto -1313 -> 288
    //   1604: iload_3
    //   1605: istore 10
    //   1607: goto -1502 -> 105
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1610	0	this	fns
    //   0	1610	1	paramString	String
    //   0	1610	2	paramInt	int
    //   25	1580	3	i	int
    //   118	1464	4	j	int
    //   114	1486	5	k	int
    //   122	1476	6	m	int
    //   7	1581	7	n	int
    //   19	1561	8	i1	int
    //   1	1475	9	i2	int
    //   103	1503	10	i3	int
    //   22	1379	11	i4	int
    //   10	1407	12	i5	int
    //   4	113	13	i6	int
    //   16	97	14	i7	int
    //   355	1204	15	l1	long
    //   13	1400	17	l2	long
    //   39	1539	19	localObject1	Object
    //   80	1489	20	localObject2	Object
    //   27	1100	21	localObject3	Object
    //   1135	11	21	localException1	Exception
    //   1174	235	21	localObject4	Object
    //   1442	1	21	localException2	Exception
    //   1450	1	21	localException3	Exception
    //   1455	1	21	localException4	Exception
    //   1486	1	21	localObject5	Object
    //   30	1453	22	localObject6	Object
    //   918	13	23	str	String
    // Exception table:
    //   from	to	target	type
    //   815	824	1135	java/lang/Exception
    //   826	848	1135	java/lang/Exception
    //   855	862	1135	java/lang/Exception
    //   864	875	1135	java/lang/Exception
    //   815	824	1197	finally
    //   826	848	1197	finally
    //   855	862	1197	finally
    //   864	875	1197	finally
    //   875	886	1423	finally
    //   894	986	1430	finally
    //   993	1014	1434	finally
    //   1021	1035	1434	finally
    //   1042	1058	1434	finally
    //   1117	1123	1434	finally
    //   1126	1132	1434	finally
    //   1145	1150	1438	finally
    //   875	886	1442	java/lang/Exception
    //   894	986	1450	java/lang/Exception
    //   993	1014	1455	java/lang/Exception
    //   1021	1035	1455	java/lang/Exception
    //   1042	1058	1455	java/lang/Exception
    //   1117	1123	1455	java/lang/Exception
    //   1126	1132	1455	java/lang/Exception
  }
  
  public Bundle a()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (ArrayList)EmoticonController.a(this.a).b();
    if (localObject != null)
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        EmoticonPackage localEmoticonPackage = (EmoticonPackage)((Iterator)localObject).next();
        if (localEmoticonPackage.jobType == 0) {
          localArrayList.add(a(localEmoticonPackage.epId, 1));
        } else if (localEmoticonPackage.jobType == 3) {
          localArrayList.add(a(localEmoticonPackage.epId, 3));
        } else if (localEmoticonPackage.jobType == 1) {
          localArrayList.add(a(localEmoticonPackage.epId, 2));
        }
      }
    }
    localObject = new Bundle();
    ((Bundle)localObject).putParcelableArrayList("pkgStatusList", localArrayList);
    return localObject;
  }
  
  public Bundle a(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    int j = paramBundle.getInt("result");
    String str3 = paramBundle.getString("qFace_name");
    int k = paramBundle.getInt("qFace_type");
    String str4 = paramBundle.getString("qFace_author");
    Object localObject = paramBundle.getString("qFace_material_id");
    String str1 = paramBundle.getString("qFace_pack_id");
    String str2 = paramBundle.getString("qFace_md5");
    ArrayList localArrayList1 = paramBundle.getStringArrayList("qFace_eId_arr");
    ArrayList localArrayList2 = paramBundle.getStringArrayList("qFace_shortcut_arr");
    if (((j == -1) && (localArrayList2 != null) && (localArrayList1 != null) && (localArrayList2.size() == localArrayList1.size()) && (str2 != null)) || (j == 102) || (j == 101)) {}
    for (int i = 1; i == 0; i = 0) {
      return null;
    }
    if (j != -1)
    {
      paramBundle = EmoticonController.a(this.a).a((String)localObject);
      paramBundle.status = 0;
      EmoticonController.a(this.a).a(paramBundle);
      EmoticonController.a(this.a, paramBundle);
      paramBundle = new Bundle();
      paramBundle.putInt("result", 0);
      paramBundle.putString("messge", "");
      return paramBundle;
    }
    EmoticonPackage localEmoticonPackage = EmoticonController.a(this.a).a((String)localObject);
    if (localEmoticonPackage != null)
    {
      paramBundle = null;
      if (localEmoticonPackage.kinId != null) {
        paramBundle = EmoticonController.a(this.a).a(localEmoticonPackage.kinId);
      }
      if (paramBundle != null)
      {
        EmoticonController.a(this.a).b(paramBundle.epId);
        this.a.b(paramBundle);
      }
      localEmoticonPackage.status = 2;
      localEmoticonPackage.kinId = str1;
      localEmoticonPackage.jobType = 1;
      EmoticonController.a(this.a).a(localEmoticonPackage);
    }
    paramBundle = new EmoticonPackage();
    paramBundle.epId = str1;
    paramBundle.author = str4;
    paramBundle.kinId = ((String)localObject);
    paramBundle.jobType = 2;
    paramBundle.name = str3;
    paramBundle.status = 2;
    paramBundle.type = k;
    paramBundle.valid = true;
    EmoticonController.a(this.a).a(paramBundle);
    j = localArrayList2.size();
    i = 0;
    while (i < j)
    {
      str3 = (String)localArrayList1.get(i);
      str4 = (String)localArrayList2.get(i);
      localObject = new Emoticon();
      ((Emoticon)localObject).eId = str3;
      ((Emoticon)localObject).epId = str1;
      ((Emoticon)localObject).jobType = 1;
      ((Emoticon)localObject).name = str4;
      ((Emoticon)localObject).encryptKey = str2;
      EmoticonController.a(this.a).a((Emoticon)localObject);
      i += 1;
    }
    EmoticonController.a(this.a).a(str1);
    this.a.a(paramBundle);
    paramBundle = new Bundle();
    paramBundle.putInt("result", 0);
    paramBundle.putString("messge", "");
    return paramBundle;
  }
  
  public Bundle a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    this.a.a(paramString);
    paramString = new Bundle();
    paramString.putInt("result", 0);
    paramString.putString("messge", "");
    return paramString;
  }
  
  public Bundle b(Bundle paramBundle)
  {
    if (paramBundle == null) {
      return null;
    }
    String str = String.valueOf(paramBundle.getInt("id"));
    int i = paramBundle.getInt("businessType");
    if (this.a.a(str) >= 0.0F)
    {
      paramBundle = null;
      i = 0;
    }
    for (;;)
    {
      if (paramBundle != null) {
        ReportController.b(EmoticonController.a(this.a), "CliOper", "", "", "ep_mall", "Clk_updatepkg_detail", 0, 0, paramBundle.epId, "" + paramBundle.localVersion, "" + paramBundle.latestVersion, "");
      }
      paramBundle = new Bundle();
      paramBundle.putInt("result", i);
      paramBundle.putString("messge", "");
      return paramBundle;
      paramBundle = EmoticonController.a(this.a).b(str);
      if (paramBundle == null)
      {
        EmoticonPackage localEmoticonPackage = EmoticonController.a(this.a).a(str);
        paramBundle = localEmoticonPackage;
        if (localEmoticonPackage == null)
        {
          paramBundle = new EmoticonPackage();
          paramBundle.epId = str;
          paramBundle.wordingId = -1L;
          if (i == 2) {
            paramBundle.jobType = 1;
          }
        }
        else
        {
          label225:
          if (paramBundle.jobType != 1) {
            break label267;
          }
          this.a.d(paramBundle);
        }
        for (;;)
        {
          i = 0;
          break;
          if (i == 3)
          {
            paramBundle.jobType = 3;
            break label225;
          }
          paramBundle.jobType = 0;
          break label225;
          label267:
          paramBundle.isMagicFaceDownloading = false;
          this.a.a(paramBundle, true);
        }
      }
      switch (paramBundle.status)
      {
      case 1: 
      default: 
        i = 1;
        break;
      case 0: 
        if (paramBundle.jobType == 1) {
          this.a.d(paramBundle);
        }
        for (;;)
        {
          i = 0;
          break;
          paramBundle.isMagicFaceDownloading = false;
          this.a.a(paramBundle, true);
        }
      case 2: 
        if (EmoticonUtils.a(paramBundle.updateFlag))
        {
          this.a.a(paramBundle, true);
          i = 0;
        }
        else
        {
          i = 3;
        }
        break;
      case 3: 
        i = 4;
      }
    }
  }
  
  public Bundle c(Bundle paramBundle)
  {
    int i = 1;
    Object localObject = paramBundle.getString("id");
    int k = paramBundle.getInt("businessType");
    if ((paramBundle == null) || (localObject == null) || (((String)localObject).length() == 0)) {
      i = 0;
    }
    for (;;)
    {
      paramBundle = new Bundle();
      if (i != 0)
      {
        localObject = a((String)localObject, k);
        paramBundle.putInt("result", ((Bundle)localObject).getInt("result"));
        paramBundle.putString("messge", "");
        paramBundle.putInt("id", -1);
        paramBundle.putInt("status", ((Bundle)localObject).getInt("status"));
        paramBundle.putInt("pluginStatus", ((Bundle)localObject).getInt("pluginStatus"));
        paramBundle.putLong("pluginSize", ((Bundle)localObject).getLong("pluginSize"));
        paramBundle.putInt("progress", ((Bundle)localObject).getInt("progress"));
        paramBundle.putInt("dynamicEmojiId", ((Bundle)localObject).getInt("dEmojiId"));
        paramBundle.putStringArrayList("dynamicEmojiList", ((Bundle)localObject).getStringArrayList("srcList"));
        paramBundle.putStringArrayList("urlParamsList", ((Bundle)localObject).getStringArrayList("urlParamsList"));
        return paramBundle;
        try
        {
          j = Integer.parseInt((String)localObject);
          if (j == -1) {
            i = 0;
          }
        }
        catch (Exception paramBundle)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("Q.emoji.EmoDown", 2, "clear History. uin:" + EmoticonController.a(this.a).getAccount() + " app=" + String.valueOf(EmoticonController.a(this.a)));
            }
            int j = -1;
          }
        }
      }
    }
    paramBundle.putInt("result", 0);
    paramBundle.putString("messge", "");
    paramBundle.putInt("id", -1);
    paramBundle.putInt("status", 0);
    paramBundle.putInt("pluginStatus", 0);
    paramBundle.putLong("pluginSize", 0L);
    paramBundle.putInt("progress", 0);
    paramBundle.putInt("dynamicEmojiId", -1);
    paramBundle.putStringArrayList("dynamicEmojiList", null);
    paramBundle.putStringArrayList("urlParamsList", null);
    return paramBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     fns
 * JD-Core Version:    0.7.0.1
 */