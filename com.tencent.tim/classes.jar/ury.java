import android.os.Handler.Callback;
import com.tencent.mobileqq.activity.Conversation;

public class ury
  implements Handler.Callback
{
  public ury(Conversation paramConversation) {}
  
  /* Error */
  public boolean handleMessage(android.os.Message paramMessage)
  {
    // Byte code:
    //   0: iconst_2
    //   1: istore_2
    //   2: iconst_0
    //   3: istore 4
    //   5: iconst_0
    //   6: istore_3
    //   7: aload_1
    //   8: getfield 26	android/os/Message:what	I
    //   11: ldc 27
    //   13: if_icmpne +16 -> 29
    //   16: aload_0
    //   17: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   20: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   23: bipush 12
    //   25: iconst_0
    //   26: invokevirtual 39	aahb:gm	(II)V
    //   29: aload_1
    //   30: getfield 26	android/os/Message:what	I
    //   33: ldc 40
    //   35: if_icmpeq +18 -> 53
    //   38: aload_0
    //   39: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   42: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   45: invokevirtual 50	com/tencent/mobileqq/app/QQAppInterface:isLogin	()Z
    //   48: ifne +5 -> 53
    //   51: iconst_1
    //   52: ireturn
    //   53: aload_1
    //   54: getfield 26	android/os/Message:what	I
    //   57: lookupswitch	default:+755->812, 1009:+766->823, 1010:+801->858, 1014:+2922->2979, 1016:+2932->2989, 1017:+2999->3056, 1019:+3330->3387, 1020:+3009->3066, 1023:+1181->1238, 1024:+3349->3406, 1025:+757->814, 1027:+1198->1255, 1030:+3373->3430, 1032:+2810->2867, 1033:+2838->2895, 1035:+3480->3537, 1038:+3489->3546, 1039:+3517->3574, 1040:+2866->2923, 1041:+2894->2951, 1042:+3601->3658, 1044:+3630->3687, 1048:+3652->3709, 1049:+3545->3602, 1050:+3573->3630, 1052:+3729->3786, 1053:+3774->3831, 1054:+-6->51, 1055:+3803->3860, 1059:+4423->4480, 1060:+4441->4498, 1061:+4458->4515, 1062:+877->934, 1063:+1092->1149, 1064:+1148->1205, 1067:+4471->4528, 1068:+4088->4145, 1069:+3980->4037, 1070:+4196->4253, 1071:+4480->4537, 1072:+4541->4598, 1073:+4550->4607, 10000:+3018->3075, 10001:+790->847, 10002:+790->847, 10003:+790->847, 1134010:+1787->1844, 1134011:+1850->1907, 1134012:+2747->2804, 1134013:+2773->2830, 1134014:+2799->2856, 1134015:+2721->2778, 1134018:+1352->1409, 1134019:+1533->1590, 1134020:+1616->1673, 1134021:+2518->2575, 1134022:+2546->2603, 1134024:+2688->2745, 1134025:+3382->3439, 1134026:+3434->3491, 1134027:+1934->1991, 1134028:+1991->2048, 1134030:+3783->3840, 1134039:+2278->2335, 1134040:+2335->2392, 1134041:+2363->2420, 1134042:+2420->2477, 1134043:+2019->2076, 1134044:+2047->2104, 1134045:+1626->1683, 1134047:+1636->1693, 1134048:+1653->1710, 1134049:+2448->2505, 1134050:+2490->2547, 1134051:+2075->2132, 1134052:+2127->2184, 1134053:+2171->2228, 1134054:+-6->51, 1134057:+1670->1727, 1134058:+1687->1744, 1134059:+1878->1935, 1134060:+1906->1963, 1134061:+4229->4286, 1134062:+4263->4320, 1134063:+4352->4409, 1134064:+4413->4470, 1134065:+1815->1872, 1134066:+2574->2631, 1134067:+2631->2688, 1134068:+4275->4332, 1134200:+3855->3912, 1134201:+3901->3958, 11340003:+1221->1278, 11340004:+1759->1816
    //   813: ireturn
    //   814: aload_0
    //   815: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   818: invokestatic 52	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   821: iconst_1
    //   822: ireturn
    //   823: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   826: ifeq +11 -> 837
    //   829: ldc 59
    //   831: iconst_2
    //   832: ldc 61
    //   834: invokestatic 65	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   837: aload_0
    //   838: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   841: lconst_0
    //   842: invokevirtual 69	com/tencent/mobileqq/activity/Conversation:fI	(J)V
    //   845: iconst_1
    //   846: ireturn
    //   847: aload_0
    //   848: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   851: aload_1
    //   852: iconst_1
    //   853: invokevirtual 72	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   856: iconst_1
    //   857: ireturn
    //   858: aload_0
    //   859: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   862: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   865: invokevirtual 75	aahb:Wp	()Z
    //   868: ifeq +38 -> 906
    //   871: aload_0
    //   872: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   875: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   878: bipush 21
    //   880: iconst_2
    //   881: invokevirtual 39	aahb:gm	(II)V
    //   884: aload_0
    //   885: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   888: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   891: bipush 21
    //   893: aload_1
    //   894: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   897: aload_0
    //   898: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   901: invokestatic 82	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   904: iconst_1
    //   905: ireturn
    //   906: aload_0
    //   907: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   910: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   913: bipush 21
    //   915: iconst_0
    //   916: invokevirtual 39	aahb:gm	(II)V
    //   919: aload_0
    //   920: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   923: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   926: bipush 21
    //   928: aconst_null
    //   929: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   932: iconst_1
    //   933: ireturn
    //   934: aload_1
    //   935: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   938: astore 9
    //   940: aload 9
    //   942: ifnonnull +72 -> 1014
    //   945: aload_0
    //   946: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   949: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   952: invokevirtual 89	aahb:Wo	()Z
    //   955: ifeq +31 -> 986
    //   958: aload_0
    //   959: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   962: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   965: bipush 20
    //   967: iconst_2
    //   968: invokevirtual 39	aahb:gm	(II)V
    //   971: aload_0
    //   972: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   975: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   978: bipush 20
    //   980: aload_1
    //   981: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   984: iconst_1
    //   985: ireturn
    //   986: aload_0
    //   987: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   990: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   993: bipush 20
    //   995: iconst_0
    //   996: invokevirtual 39	aahb:gm	(II)V
    //   999: aload_0
    //   1000: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1003: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1006: bipush 20
    //   1008: aconst_null
    //   1009: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1012: iconst_1
    //   1013: ireturn
    //   1014: aload 9
    //   1016: instanceof 91
    //   1019: ifeq -968 -> 51
    //   1022: aload 9
    //   1024: checkcast 91	[Landroid/view/View;
    //   1027: checkcast 91	[Landroid/view/View;
    //   1030: astore 9
    //   1032: aload 9
    //   1034: arraylength
    //   1035: iconst_3
    //   1036: if_icmpne -985 -> 51
    //   1039: aload 9
    //   1041: iconst_0
    //   1042: aaload
    //   1043: astore_1
    //   1044: aload 9
    //   1046: iconst_1
    //   1047: aaload
    //   1048: astore 10
    //   1050: aload 9
    //   1052: iconst_2
    //   1053: aaload
    //   1054: astore 9
    //   1056: aload_1
    //   1057: ifnull -1006 -> 51
    //   1060: aload_1
    //   1061: invokevirtual 97	android/view/View:getParent	()Landroid/view/ViewParent;
    //   1064: ifnonnull -1013 -> 51
    //   1067: aload_0
    //   1068: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1071: getfield 101	com/tencent/mobileqq/activity/Conversation:gv	Landroid/widget/RelativeLayout;
    //   1074: ldc 102
    //   1076: invokevirtual 108	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1079: astore 10
    //   1081: aload 10
    //   1083: ifnull +15 -> 1098
    //   1086: aload_0
    //   1087: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1090: getfield 101	com/tencent/mobileqq/activity/Conversation:gv	Landroid/widget/RelativeLayout;
    //   1093: aload 10
    //   1095: invokevirtual 112	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1098: aload_0
    //   1099: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1102: invokestatic 115	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1105: ifnull +24 -> 1129
    //   1108: aload_0
    //   1109: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1112: invokestatic 115	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/mini/entry/MiniAppPullInterface;
    //   1115: invokeinterface 120 1 0
    //   1120: ifeq +9 -> 1129
    //   1123: aload_1
    //   1124: bipush 8
    //   1126: invokevirtual 124	android/view/View:setVisibility	(I)V
    //   1129: aload 9
    //   1131: ifnull -1080 -> 51
    //   1134: aload 9
    //   1136: new 126	urz
    //   1139: dup
    //   1140: aload_0
    //   1141: invokespecial 129	urz:<init>	(Lury;)V
    //   1144: invokevirtual 133	android/view/View:setOnClickListener	(Landroid/view/View$OnClickListener;)V
    //   1147: iconst_1
    //   1148: ireturn
    //   1149: aload_0
    //   1150: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1153: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1156: ifnull +13 -> 1169
    //   1159: aload_0
    //   1160: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1163: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1166: invokevirtual 136	aahb:cuo	()V
    //   1169: aload_0
    //   1170: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1173: getfield 101	com/tencent/mobileqq/activity/Conversation:gv	Landroid/widget/RelativeLayout;
    //   1176: ldc 102
    //   1178: invokevirtual 108	android/widget/RelativeLayout:findViewById	(I)Landroid/view/View;
    //   1181: astore_1
    //   1182: aload_1
    //   1183: ifnull -1132 -> 51
    //   1186: aload_1
    //   1187: bipush 8
    //   1189: invokevirtual 124	android/view/View:setVisibility	(I)V
    //   1192: aload_0
    //   1193: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1196: getfield 101	com/tencent/mobileqq/activity/Conversation:gv	Landroid/widget/RelativeLayout;
    //   1199: aload_1
    //   1200: invokevirtual 112	android/widget/RelativeLayout:removeView	(Landroid/view/View;)V
    //   1203: iconst_1
    //   1204: ireturn
    //   1205: aload_1
    //   1206: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   1209: astore_1
    //   1210: aload_1
    //   1211: ifnull -1160 -> 51
    //   1214: aload_1
    //   1215: instanceof 138
    //   1218: ifeq -1167 -> 51
    //   1221: new 140	com/tencent/mobileqq/activity/Conversation$1$2
    //   1224: dup
    //   1225: aload_0
    //   1226: aload_1
    //   1227: checkcast 138	java/lang/String
    //   1230: invokespecial 143	com/tencent/mobileqq/activity/Conversation$1$2:<init>	(Lury;Ljava/lang/String;)V
    //   1233: invokestatic 149	com/tencent/mobileqq/app/ThreadManagerV2:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   1236: iconst_1
    //   1237: ireturn
    //   1238: invokestatic 155	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1241: new 157	com/tencent/mobileqq/activity/Conversation$1$3
    //   1244: dup
    //   1245: aload_0
    //   1246: invokespecial 158	com/tencent/mobileqq/activity/Conversation$1$3:<init>	(Lury;)V
    //   1249: invokevirtual 164	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1252: pop
    //   1253: iconst_1
    //   1254: ireturn
    //   1255: aload_0
    //   1256: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1259: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1262: invokestatic 169	aeaq:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laeaq;
    //   1265: aload_0
    //   1266: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1269: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1272: aload_1
    //   1273: invokevirtual 172	aeaq:a	(Laahb;Landroid/os/Message;)V
    //   1276: iconst_1
    //   1277: ireturn
    //   1278: invokestatic 177	aqap:a	()Laqap;
    //   1281: invokevirtual 180	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   1284: astore 9
    //   1286: aload 9
    //   1288: getfield 185	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig;
    //   1291: ifnull -1240 -> 51
    //   1294: aload_0
    //   1295: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1298: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1301: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1304: astore 10
    //   1306: aload 10
    //   1308: ldc 191
    //   1310: lconst_0
    //   1311: invokeinterface 197 4 0
    //   1316: lstore 5
    //   1318: new 199	java/util/Date
    //   1321: dup
    //   1322: invokespecial 200	java/util/Date:<init>	()V
    //   1325: invokevirtual 204	java/util/Date:getTime	()J
    //   1328: lstore 7
    //   1330: lload 7
    //   1332: lload 5
    //   1334: lsub
    //   1335: aload 9
    //   1337: getfield 185	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig;
    //   1340: getfield 210	com/tencent/mobileqq/upgrade/NewUpgradeConfig:dialog	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig$a;
    //   1343: getfield 215	com/tencent/mobileqq/upgrade/NewUpgradeConfig$a:aCm	I
    //   1346: bipush 24
    //   1348: imul
    //   1349: bipush 60
    //   1351: imul
    //   1352: bipush 60
    //   1354: imul
    //   1355: sipush 1000
    //   1358: imul
    //   1359: i2l
    //   1360: lcmp
    //   1361: ifle -1310 -> 51
    //   1364: aload_0
    //   1365: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1368: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1371: bipush 12
    //   1373: iconst_2
    //   1374: invokevirtual 39	aahb:gm	(II)V
    //   1377: aload_0
    //   1378: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1381: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1384: bipush 12
    //   1386: aload_1
    //   1387: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1390: aload 10
    //   1392: invokeinterface 219 1 0
    //   1397: ldc 191
    //   1399: lload 7
    //   1401: invokeinterface 225 4 0
    //   1406: pop
    //   1407: iconst_1
    //   1408: ireturn
    //   1409: invokestatic 177	aqap:a	()Laqap;
    //   1412: invokevirtual 180	aqap:b	()Lcom/tencent/mobileqq/upgrade/UpgradeDetailWrapper;
    //   1415: astore 9
    //   1417: aload 9
    //   1419: getfield 185	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig;
    //   1422: ifnull -1371 -> 51
    //   1425: aload_0
    //   1426: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1429: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1432: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   1435: astore 10
    //   1437: aload 10
    //   1439: ldc 191
    //   1441: lconst_0
    //   1442: invokeinterface 197 4 0
    //   1447: lstore 5
    //   1449: new 199	java/util/Date
    //   1452: dup
    //   1453: invokespecial 200	java/util/Date:<init>	()V
    //   1456: invokevirtual 204	java/util/Date:getTime	()J
    //   1459: lstore 7
    //   1461: lload 7
    //   1463: lload 5
    //   1465: lsub
    //   1466: aload 9
    //   1468: getfield 185	com/tencent/mobileqq/upgrade/UpgradeDetailWrapper:b	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig;
    //   1471: getfield 210	com/tencent/mobileqq/upgrade/NewUpgradeConfig:dialog	Lcom/tencent/mobileqq/upgrade/NewUpgradeConfig$a;
    //   1474: getfield 215	com/tencent/mobileqq/upgrade/NewUpgradeConfig$a:aCm	I
    //   1477: bipush 24
    //   1479: imul
    //   1480: bipush 60
    //   1482: imul
    //   1483: bipush 60
    //   1485: imul
    //   1486: sipush 1000
    //   1489: imul
    //   1490: i2l
    //   1491: lcmp
    //   1492: ifle +64 -> 1556
    //   1495: aload_0
    //   1496: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1499: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1502: bipush 14
    //   1504: iconst_2
    //   1505: invokevirtual 39	aahb:gm	(II)V
    //   1508: aload_0
    //   1509: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1512: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1515: bipush 12
    //   1517: iconst_0
    //   1518: invokevirtual 39	aahb:gm	(II)V
    //   1521: aload_0
    //   1522: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1525: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1528: bipush 14
    //   1530: aload_1
    //   1531: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1534: aload 10
    //   1536: invokeinterface 219 1 0
    //   1541: ldc 191
    //   1543: lload 7
    //   1545: invokeinterface 225 4 0
    //   1550: invokeinterface 228 1 0
    //   1555: pop
    //   1556: aload_1
    //   1557: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   1560: ifnull -1509 -> 51
    //   1563: aload_1
    //   1564: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   1567: instanceof 230
    //   1570: ifeq -1519 -> 51
    //   1573: aload_1
    //   1574: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   1577: checkcast 230	com/tencent/mobileqq/upgrade/activity/UpgradeActivity
    //   1580: astore_1
    //   1581: invokestatic 177	aqap:a	()Laqap;
    //   1584: aload_1
    //   1585: invokevirtual 234	aqap:ft	(Landroid/content/Context;)V
    //   1588: iconst_1
    //   1589: ireturn
    //   1590: aload_0
    //   1591: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1594: invokestatic 237	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   1597: ifnull +22 -> 1619
    //   1600: aload_0
    //   1601: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1604: invokestatic 237	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   1607: invokevirtual 242	com/tencent/mobileqq/upgrade/UpgradeTipsDialog:dismiss	()V
    //   1610: aload_0
    //   1611: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1614: aconst_null
    //   1615: invokestatic 245	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   1618: pop
    //   1619: aload_0
    //   1620: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1623: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1626: bipush 14
    //   1628: iconst_0
    //   1629: invokevirtual 39	aahb:gm	(II)V
    //   1632: aload_0
    //   1633: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1636: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1639: bipush 14
    //   1641: aload_1
    //   1642: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1645: iconst_1
    //   1646: ireturn
    //   1647: astore 9
    //   1649: aload_0
    //   1650: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1653: aconst_null
    //   1654: invokestatic 245	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   1657: pop
    //   1658: goto -39 -> 1619
    //   1661: astore_1
    //   1662: aload_0
    //   1663: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1666: aconst_null
    //   1667: invokestatic 245	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;)Lcom/tencent/mobileqq/upgrade/UpgradeTipsDialog;
    //   1670: pop
    //   1671: aload_1
    //   1672: athrow
    //   1673: aload_0
    //   1674: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1677: aload_1
    //   1678: invokestatic 248	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1681: iconst_1
    //   1682: ireturn
    //   1683: aload_0
    //   1684: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1687: aload_1
    //   1688: invokestatic 250	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;Landroid/os/Message;)V
    //   1691: iconst_1
    //   1692: ireturn
    //   1693: invokestatic 155	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1696: new 252	com/tencent/mobileqq/activity/Conversation$1$4
    //   1699: dup
    //   1700: aload_0
    //   1701: invokespecial 253	com/tencent/mobileqq/activity/Conversation$1$4:<init>	(Lury;)V
    //   1704: invokevirtual 164	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1707: pop
    //   1708: iconst_1
    //   1709: ireturn
    //   1710: invokestatic 155	com/tencent/mobileqq/app/ThreadManager:getSubThreadHandler	()Lmqq/os/MqqHandler;
    //   1713: new 255	com/tencent/mobileqq/activity/Conversation$1$5
    //   1716: dup
    //   1717: aload_0
    //   1718: invokespecial 256	com/tencent/mobileqq/activity/Conversation$1$5:<init>	(Lury;)V
    //   1721: invokevirtual 164	mqq/os/MqqHandler:post	(Ljava/lang/Runnable;)Z
    //   1724: pop
    //   1725: iconst_1
    //   1726: ireturn
    //   1727: new 258	com/tencent/mobileqq/activity/Conversation$1$6
    //   1730: dup
    //   1731: aload_0
    //   1732: invokespecial 259	com/tencent/mobileqq/activity/Conversation$1$6:<init>	(Lury;)V
    //   1735: bipush 8
    //   1737: aconst_null
    //   1738: iconst_1
    //   1739: invokestatic 262	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   1742: iconst_1
    //   1743: ireturn
    //   1744: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1747: ifeq +12 -> 1759
    //   1750: ldc 59
    //   1752: iconst_2
    //   1753: ldc_w 264
    //   1756: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1759: aload_0
    //   1760: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1763: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1766: invokestatic 271	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;
    //   1769: astore 9
    //   1771: aload 9
    //   1773: invokevirtual 274	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:auT	()V
    //   1776: aload_0
    //   1777: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1780: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1783: aload 9
    //   1785: invokestatic 278	com/tencent/mobileqq/upgrade/UpgradeTIMWrapper:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/mobileqq/upgrade/UpgradeTIMWrapper;)V
    //   1788: aload_0
    //   1789: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1792: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1795: bipush 26
    //   1797: iconst_0
    //   1798: invokevirtual 39	aahb:gm	(II)V
    //   1801: aload_0
    //   1802: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1805: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1808: bipush 26
    //   1810: aload_1
    //   1811: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1814: iconst_1
    //   1815: ireturn
    //   1816: aload_0
    //   1817: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1820: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1823: bipush 12
    //   1825: iconst_0
    //   1826: invokevirtual 39	aahb:gm	(II)V
    //   1829: aload_0
    //   1830: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1833: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1836: bipush 12
    //   1838: aload_1
    //   1839: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1842: iconst_1
    //   1843: ireturn
    //   1844: aload_0
    //   1845: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1848: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1851: bipush 36
    //   1853: iconst_2
    //   1854: invokevirtual 39	aahb:gm	(II)V
    //   1857: aload_0
    //   1858: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1861: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1864: bipush 36
    //   1866: aload_1
    //   1867: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1870: iconst_1
    //   1871: ireturn
    //   1872: aload_1
    //   1873: ifnull -1822 -> 51
    //   1876: aload_0
    //   1877: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1880: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1883: bipush 10
    //   1885: aload_1
    //   1886: getfield 281	android/os/Message:arg1	I
    //   1889: invokevirtual 39	aahb:gm	(II)V
    //   1892: aload_0
    //   1893: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1896: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1899: bipush 10
    //   1901: aload_1
    //   1902: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1905: iconst_1
    //   1906: ireturn
    //   1907: aload_0
    //   1908: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1911: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1914: bipush 36
    //   1916: iconst_0
    //   1917: invokevirtual 39	aahb:gm	(II)V
    //   1920: aload_0
    //   1921: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1924: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1927: bipush 36
    //   1929: aload_1
    //   1930: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1933: iconst_1
    //   1934: ireturn
    //   1935: aload_0
    //   1936: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1939: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1942: bipush 34
    //   1944: iconst_2
    //   1945: invokevirtual 39	aahb:gm	(II)V
    //   1948: aload_0
    //   1949: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1952: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1955: bipush 34
    //   1957: aload_1
    //   1958: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1961: iconst_1
    //   1962: ireturn
    //   1963: aload_0
    //   1964: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1967: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1970: bipush 34
    //   1972: iconst_0
    //   1973: invokevirtual 39	aahb:gm	(II)V
    //   1976: aload_0
    //   1977: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1980: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   1983: bipush 34
    //   1985: aload_1
    //   1986: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   1989: iconst_1
    //   1990: ireturn
    //   1991: aload_0
    //   1992: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   1995: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   1998: ldc_w 286
    //   2001: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2004: ifeq +16 -> 2020
    //   2007: aload_0
    //   2008: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2011: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2014: ldc_w 286
    //   2017: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   2020: aload_0
    //   2021: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2024: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2027: bipush 28
    //   2029: iconst_2
    //   2030: invokevirtual 39	aahb:gm	(II)V
    //   2033: aload_0
    //   2034: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2037: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2040: bipush 28
    //   2042: aload_1
    //   2043: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2046: iconst_1
    //   2047: ireturn
    //   2048: aload_0
    //   2049: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2052: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2055: bipush 28
    //   2057: iconst_0
    //   2058: invokevirtual 39	aahb:gm	(II)V
    //   2061: aload_0
    //   2062: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2065: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2068: bipush 28
    //   2070: aload_1
    //   2071: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2074: iconst_1
    //   2075: ireturn
    //   2076: aload_0
    //   2077: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2080: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2083: bipush 32
    //   2085: iconst_2
    //   2086: invokevirtual 39	aahb:gm	(II)V
    //   2089: aload_0
    //   2090: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2093: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2096: bipush 32
    //   2098: aload_1
    //   2099: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2102: iconst_1
    //   2103: ireturn
    //   2104: aload_0
    //   2105: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2108: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2111: bipush 32
    //   2113: iconst_0
    //   2114: invokevirtual 39	aahb:gm	(II)V
    //   2117: aload_0
    //   2118: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2121: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2124: bipush 32
    //   2126: aload_1
    //   2127: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2130: iconst_1
    //   2131: ireturn
    //   2132: aload_1
    //   2133: getfield 281	android/os/Message:arg1	I
    //   2136: iconst_1
    //   2137: if_icmpeq +16 -> 2153
    //   2140: aload_0
    //   2141: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2144: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2147: bipush 33
    //   2149: iconst_2
    //   2150: invokevirtual 39	aahb:gm	(II)V
    //   2153: aload_0
    //   2154: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2157: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2160: bipush 33
    //   2162: aload_1
    //   2163: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2166: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2169: ifeq -2118 -> 51
    //   2172: ldc_w 295
    //   2175: iconst_2
    //   2176: ldc_w 297
    //   2179: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2182: iconst_1
    //   2183: ireturn
    //   2184: aload_0
    //   2185: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2188: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2191: bipush 33
    //   2193: iconst_0
    //   2194: invokevirtual 39	aahb:gm	(II)V
    //   2197: aload_0
    //   2198: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2201: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2204: bipush 33
    //   2206: aload_1
    //   2207: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2210: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2213: ifeq -2162 -> 51
    //   2216: ldc_w 295
    //   2219: iconst_2
    //   2220: ldc_w 299
    //   2223: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   2226: iconst_1
    //   2227: ireturn
    //   2228: aload_0
    //   2229: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2232: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2235: sipush 153
    //   2238: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2241: checkcast 305	abhh
    //   2244: astore 9
    //   2246: aconst_null
    //   2247: invokestatic 311	abmt:B	(Ljava/lang/Object;)Z
    //   2250: ifeq +9 -> 2259
    //   2253: aload 9
    //   2255: iconst_1
    //   2256: putfield 315	abhh:bCK	Z
    //   2259: aload_0
    //   2260: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2263: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2266: getfield 318	com/tencent/mobileqq/app/QQAppInterface:bJc	Z
    //   2269: ifeq +10 -> 2279
    //   2272: aconst_null
    //   2273: invokestatic 311	abmt:B	(Ljava/lang/Object;)Z
    //   2276: ifeq +19 -> 2295
    //   2279: aload 9
    //   2281: ifnull -2230 -> 51
    //   2284: aload 9
    //   2286: iconst_1
    //   2287: putfield 321	abhh:bCJ	Z
    //   2290: iconst_1
    //   2291: ireturn
    //   2292: astore_1
    //   2293: iconst_1
    //   2294: ireturn
    //   2295: invokestatic 326	com/tencent/mobileqq/app/FrameHelperActivity:ZW	()Z
    //   2298: ifeq +10 -> 2308
    //   2301: iconst_1
    //   2302: invokestatic 330	com/tencent/mobileqq/app/FrameHelperActivity:EO	(Z)V
    //   2305: invokestatic 333	com/tencent/mobileqq/app/FrameHelperActivity:cuA	()V
    //   2308: aload_0
    //   2309: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2312: getfield 336	com/tencent/mobileqq/activity/Conversation:gw	Landroid/widget/RelativeLayout;
    //   2315: aload_1
    //   2316: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   2319: checkcast 138	java/lang/String
    //   2322: invokestatic 340	abmt:o	(Landroid/view/View;Ljava/lang/String;)V
    //   2325: aload_0
    //   2326: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2329: iconst_1
    //   2330: putfield 343	com/tencent/mobileqq/activity/Conversation:aUP	Z
    //   2333: iconst_1
    //   2334: ireturn
    //   2335: aload_0
    //   2336: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2339: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2342: ldc_w 344
    //   2345: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2348: ifeq +16 -> 2364
    //   2351: aload_0
    //   2352: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2355: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2358: ldc_w 344
    //   2361: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   2364: aload_0
    //   2365: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2368: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2371: bipush 29
    //   2373: iconst_2
    //   2374: invokevirtual 39	aahb:gm	(II)V
    //   2377: aload_0
    //   2378: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2381: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2384: bipush 29
    //   2386: aload_1
    //   2387: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2390: iconst_1
    //   2391: ireturn
    //   2392: aload_0
    //   2393: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2396: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2399: bipush 29
    //   2401: iconst_0
    //   2402: invokevirtual 39	aahb:gm	(II)V
    //   2405: aload_0
    //   2406: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2409: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2412: bipush 29
    //   2414: aload_1
    //   2415: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2418: iconst_1
    //   2419: ireturn
    //   2420: aload_0
    //   2421: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2424: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2427: ldc_w 345
    //   2430: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2433: ifeq +16 -> 2449
    //   2436: aload_0
    //   2437: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2440: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2443: ldc_w 345
    //   2446: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   2449: aload_0
    //   2450: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2453: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2456: bipush 30
    //   2458: iconst_2
    //   2459: invokevirtual 39	aahb:gm	(II)V
    //   2462: aload_0
    //   2463: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2466: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2469: bipush 30
    //   2471: aload_1
    //   2472: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2475: iconst_1
    //   2476: ireturn
    //   2477: aload_0
    //   2478: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2481: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2484: bipush 30
    //   2486: iconst_0
    //   2487: invokevirtual 39	aahb:gm	(II)V
    //   2490: aload_0
    //   2491: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2494: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2497: bipush 30
    //   2499: aload_1
    //   2500: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2503: iconst_1
    //   2504: ireturn
    //   2505: aload_0
    //   2506: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2509: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2512: ldc_w 346
    //   2515: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2518: ifeq +16 -> 2534
    //   2521: aload_0
    //   2522: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2525: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2528: ldc_w 346
    //   2531: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   2534: aload_0
    //   2535: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2538: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2541: aload_1
    //   2542: invokevirtual 350	aahb:aH	(Landroid/os/Message;)V
    //   2545: iconst_1
    //   2546: ireturn
    //   2547: aload_0
    //   2548: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2551: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2554: bipush 31
    //   2556: iconst_0
    //   2557: invokevirtual 39	aahb:gm	(II)V
    //   2560: aload_0
    //   2561: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2564: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2567: bipush 31
    //   2569: aload_1
    //   2570: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2573: iconst_1
    //   2574: ireturn
    //   2575: aload_0
    //   2576: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2579: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2582: bipush 7
    //   2584: iconst_2
    //   2585: invokevirtual 39	aahb:gm	(II)V
    //   2588: aload_0
    //   2589: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2592: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2595: bipush 7
    //   2597: aload_1
    //   2598: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2601: iconst_1
    //   2602: ireturn
    //   2603: aload_0
    //   2604: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2607: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2610: bipush 7
    //   2612: iconst_0
    //   2613: invokevirtual 39	aahb:gm	(II)V
    //   2616: aload_0
    //   2617: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2620: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2623: bipush 7
    //   2625: aload_1
    //   2626: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2629: iconst_1
    //   2630: ireturn
    //   2631: aload_0
    //   2632: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2635: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2638: ldc_w 351
    //   2641: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2644: ifeq +16 -> 2660
    //   2647: aload_0
    //   2648: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2651: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2654: ldc_w 351
    //   2657: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   2660: aload_0
    //   2661: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2664: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2667: bipush 41
    //   2669: iconst_2
    //   2670: invokevirtual 39	aahb:gm	(II)V
    //   2673: aload_0
    //   2674: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2677: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2680: bipush 41
    //   2682: aload_1
    //   2683: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2686: iconst_1
    //   2687: ireturn
    //   2688: aload_0
    //   2689: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2692: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2695: ldc_w 352
    //   2698: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   2701: ifeq +16 -> 2717
    //   2704: aload_0
    //   2705: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2708: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   2711: ldc_w 352
    //   2714: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   2717: aload_0
    //   2718: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2721: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2724: bipush 41
    //   2726: iconst_0
    //   2727: invokevirtual 39	aahb:gm	(II)V
    //   2730: aload_0
    //   2731: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2734: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2737: bipush 41
    //   2739: aload_1
    //   2740: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2743: iconst_1
    //   2744: ireturn
    //   2745: aload_1
    //   2746: getfield 281	android/os/Message:arg1	I
    //   2749: istore_2
    //   2750: aload_0
    //   2751: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2754: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2757: bipush 8
    //   2759: iload_2
    //   2760: invokevirtual 39	aahb:gm	(II)V
    //   2763: aload_0
    //   2764: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2767: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2770: bipush 8
    //   2772: aload_1
    //   2773: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2776: iconst_1
    //   2777: ireturn
    //   2778: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2781: ifeq +12 -> 2793
    //   2784: ldc 59
    //   2786: iconst_2
    //   2787: ldc_w 354
    //   2790: invokestatic 65	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2793: aload_0
    //   2794: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2797: aload_1
    //   2798: iconst_0
    //   2799: invokevirtual 72	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2802: iconst_1
    //   2803: ireturn
    //   2804: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2807: ifeq +12 -> 2819
    //   2810: ldc 59
    //   2812: iconst_2
    //   2813: ldc_w 356
    //   2816: invokestatic 65	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2819: aload_0
    //   2820: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2823: aload_1
    //   2824: iconst_1
    //   2825: invokevirtual 72	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2828: iconst_1
    //   2829: ireturn
    //   2830: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2833: ifeq +12 -> 2845
    //   2836: ldc 59
    //   2838: iconst_2
    //   2839: ldc_w 358
    //   2842: invokestatic 65	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2845: aload_0
    //   2846: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2849: aload_1
    //   2850: iconst_1
    //   2851: invokevirtual 72	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2854: iconst_1
    //   2855: ireturn
    //   2856: aload_0
    //   2857: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2860: aconst_null
    //   2861: iconst_1
    //   2862: invokevirtual 72	com/tencent/mobileqq/activity/Conversation:a	(Landroid/os/Message;Z)V
    //   2865: iconst_1
    //   2866: ireturn
    //   2867: aload_0
    //   2868: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2871: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2874: bipush 22
    //   2876: iconst_2
    //   2877: invokevirtual 39	aahb:gm	(II)V
    //   2880: aload_0
    //   2881: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2884: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2887: bipush 22
    //   2889: aload_1
    //   2890: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2893: iconst_1
    //   2894: ireturn
    //   2895: aload_0
    //   2896: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2899: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2902: bipush 22
    //   2904: iconst_0
    //   2905: invokevirtual 39	aahb:gm	(II)V
    //   2908: aload_0
    //   2909: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2912: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2915: bipush 22
    //   2917: aload_1
    //   2918: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2921: iconst_1
    //   2922: ireturn
    //   2923: aload_0
    //   2924: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2927: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2930: bipush 6
    //   2932: iconst_2
    //   2933: invokevirtual 39	aahb:gm	(II)V
    //   2936: aload_0
    //   2937: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2940: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2943: bipush 6
    //   2945: aload_1
    //   2946: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2949: iconst_1
    //   2950: ireturn
    //   2951: aload_0
    //   2952: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2955: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2958: bipush 6
    //   2960: iconst_0
    //   2961: invokevirtual 39	aahb:gm	(II)V
    //   2964: aload_0
    //   2965: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2968: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   2971: bipush 6
    //   2973: aload_1
    //   2974: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   2977: iconst_1
    //   2978: ireturn
    //   2979: aload_0
    //   2980: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2983: lconst_0
    //   2984: invokevirtual 69	com/tencent/mobileqq/activity/Conversation:fI	(J)V
    //   2987: iconst_1
    //   2988: ireturn
    //   2989: aload_0
    //   2990: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   2993: iconst_0
    //   2994: putfield 361	com/tencent/mobileqq/activity/Conversation:aUR	Z
    //   2997: aload_0
    //   2998: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3001: invokestatic 364	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3004: ifnull +13 -> 3017
    //   3007: aload_0
    //   3008: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3011: invokestatic 364	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   3014: invokevirtual 369	com/tencent/mobileqq/fpsreport/FPSSwipListView:springBackOverScrollHeaderView	()V
    //   3017: aload_0
    //   3018: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3021: getfield 373	com/tencent/mobileqq/activity/Conversation:FM	J
    //   3024: lconst_0
    //   3025: lcmp
    //   3026: ifle +20 -> 3046
    //   3029: ldc_w 375
    //   3032: invokestatic 380	android/os/SystemClock:uptimeMillis	()J
    //   3035: aload_0
    //   3036: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3039: getfield 373	com/tencent/mobileqq/activity/Conversation:FM	J
    //   3042: lsub
    //   3043: invokestatic 386	aqmq:br	(Ljava/lang/String;J)V
    //   3046: aload_0
    //   3047: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3050: lconst_0
    //   3051: putfield 373	com/tencent/mobileqq/activity/Conversation:FM	J
    //   3054: iconst_1
    //   3055: ireturn
    //   3056: aload_0
    //   3057: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3060: lconst_0
    //   3061: invokevirtual 69	com/tencent/mobileqq/activity/Conversation:fI	(J)V
    //   3064: iconst_1
    //   3065: ireturn
    //   3066: aload_0
    //   3067: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3070: invokevirtual 389	com/tencent/mobileqq/activity/Conversation:bMt	()V
    //   3073: iconst_1
    //   3074: ireturn
    //   3075: invokestatic 394	java/lang/System:currentTimeMillis	()J
    //   3078: aload_0
    //   3079: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3082: getfield 397	com/tencent/mobileqq/activity/Conversation:FO	J
    //   3085: lsub
    //   3086: invokestatic 403	java/lang/Math:abs	(J)J
    //   3089: lstore 5
    //   3091: invokestatic 406	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   3094: ifeq +49 -> 3143
    //   3097: ldc 59
    //   3099: iconst_4
    //   3100: new 408	java/lang/StringBuilder
    //   3103: dup
    //   3104: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   3107: ldc_w 411
    //   3110: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3113: aload_1
    //   3114: getfield 281	android/os/Message:arg1	I
    //   3117: invokevirtual 418	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3120: ldc_w 420
    //   3123: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3126: lload 5
    //   3128: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3131: ldc_w 425
    //   3134: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3137: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3140: invokestatic 65	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3143: lload 5
    //   3145: lconst_0
    //   3146: lcmp
    //   3147: ifge +1472 -> 4619
    //   3150: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3153: ifeq +52 -> 3205
    //   3156: ldc 59
    //   3158: iconst_2
    //   3159: new 408	java/lang/StringBuilder
    //   3162: dup
    //   3163: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   3166: ldc_w 431
    //   3169: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3172: lload 5
    //   3174: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3177: ldc_w 420
    //   3180: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3183: aload_0
    //   3184: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3187: getfield 397	com/tencent/mobileqq/activity/Conversation:FO	J
    //   3190: invokevirtual 423	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   3193: ldc_w 425
    //   3196: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3199: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3202: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3205: aload_0
    //   3206: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3209: getfield 434	com/tencent/mobileqq/activity/Conversation:uC	J
    //   3212: lconst_1
    //   3213: ladd
    //   3214: lstore 5
    //   3216: aload_1
    //   3217: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   3220: checkcast 436	java/util/List
    //   3223: astore 9
    //   3225: aload_1
    //   3226: getfield 439	android/os/Message:arg2	I
    //   3229: iconst_1
    //   3230: if_icmpeq +85 -> 3315
    //   3233: lload 5
    //   3235: aload_0
    //   3236: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3239: getfield 434	com/tencent/mobileqq/activity/Conversation:uC	J
    //   3242: lcmp
    //   3243: ifge +72 -> 3315
    //   3246: aload_0
    //   3247: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3250: aload 9
    //   3252: putfield 443	com/tencent/mobileqq/activity/Conversation:qE	Ljava/util/List;
    //   3255: invokestatic 447	android/os/Message:obtain	()Landroid/os/Message;
    //   3258: astore_1
    //   3259: aload_1
    //   3260: sipush 10000
    //   3263: putfield 26	android/os/Message:what	I
    //   3266: aload_1
    //   3267: aload_0
    //   3268: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3271: getfield 443	com/tencent/mobileqq/activity/Conversation:qE	Ljava/util/List;
    //   3274: putfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   3277: aload_1
    //   3278: iconst_0
    //   3279: putfield 281	android/os/Message:arg1	I
    //   3282: aload_1
    //   3283: iconst_1
    //   3284: putfield 439	android/os/Message:arg2	I
    //   3287: aload_0
    //   3288: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3291: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   3294: aload_1
    //   3295: aload_0
    //   3296: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3299: getfield 434	com/tencent/mobileqq/activity/Conversation:uC	J
    //   3302: lload 5
    //   3304: lsub
    //   3305: ldc2_w 448
    //   3308: ladd
    //   3309: invokevirtual 453	mqq/os/MqqHandler:sendMessageDelayed	(Landroid/os/Message;J)Z
    //   3312: pop
    //   3313: iconst_1
    //   3314: ireturn
    //   3315: aload_1
    //   3316: getfield 439	android/os/Message:arg2	I
    //   3319: iconst_1
    //   3320: if_icmpne +53 -> 3373
    //   3323: aload 9
    //   3325: aload_0
    //   3326: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3329: getfield 443	com/tencent/mobileqq/activity/Conversation:qE	Ljava/util/List;
    //   3332: if_acmpne +36 -> 3368
    //   3335: iconst_1
    //   3336: istore_2
    //   3337: iload_2
    //   3338: ifeq -3287 -> 51
    //   3341: aload_0
    //   3342: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3345: iconst_0
    //   3346: aload_0
    //   3347: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3350: getfield 443	com/tencent/mobileqq/activity/Conversation:qE	Ljava/util/List;
    //   3353: invokevirtual 457	com/tencent/mobileqq/activity/Conversation:F	(ILjava/util/List;)V
    //   3356: aload_0
    //   3357: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3360: invokestatic 394	java/lang/System:currentTimeMillis	()J
    //   3363: putfield 397	com/tencent/mobileqq/activity/Conversation:FO	J
    //   3366: iconst_1
    //   3367: ireturn
    //   3368: iconst_0
    //   3369: istore_2
    //   3370: goto -33 -> 3337
    //   3373: aload_0
    //   3374: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3377: aload 9
    //   3379: putfield 443	com/tencent/mobileqq/activity/Conversation:qE	Ljava/util/List;
    //   3382: iconst_1
    //   3383: istore_2
    //   3384: goto -47 -> 3337
    //   3387: aload_1
    //   3388: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   3391: checkcast 436	java/util/List
    //   3394: astore_1
    //   3395: aload_0
    //   3396: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3399: iconst_1
    //   3400: aload_1
    //   3401: invokevirtual 457	com/tencent/mobileqq/activity/Conversation:F	(ILjava/util/List;)V
    //   3404: iconst_1
    //   3405: ireturn
    //   3406: aload_0
    //   3407: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3410: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3413: ifnull -3362 -> 51
    //   3416: aload_0
    //   3417: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3420: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3423: iconst_1
    //   3424: iconst_0
    //   3425: invokevirtual 461	com/tencent/mobileqq/app/QQAppInterface:ba	(ZI)V
    //   3428: iconst_1
    //   3429: ireturn
    //   3430: aload_0
    //   3431: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3434: invokestatic 463	com/tencent/mobileqq/activity/Conversation:c	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3437: iconst_1
    //   3438: ireturn
    //   3439: aload_0
    //   3440: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3443: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3446: astore 9
    //   3448: iload_3
    //   3449: istore_2
    //   3450: aload_0
    //   3451: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3454: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3457: invokevirtual 466	com/tencent/mobileqq/app/QQAppInterface:a	()Lavhc;
    //   3460: invokevirtual 472	avhc:PC	()I
    //   3463: ifeq +5 -> 3468
    //   3466: iconst_2
    //   3467: istore_2
    //   3468: aload 9
    //   3470: bipush 38
    //   3472: iload_2
    //   3473: invokevirtual 39	aahb:gm	(II)V
    //   3476: aload_0
    //   3477: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3480: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3483: bipush 38
    //   3485: aload_1
    //   3486: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3489: iconst_1
    //   3490: ireturn
    //   3491: aload_0
    //   3492: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3495: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3498: astore 9
    //   3500: invokestatic 477	agrt:a	()Lagrt;
    //   3503: invokevirtual 480	agrt:isPlaying	()Z
    //   3506: ifeq +26 -> 3532
    //   3509: aload 9
    //   3511: bipush 39
    //   3513: iload_2
    //   3514: invokevirtual 39	aahb:gm	(II)V
    //   3517: aload_0
    //   3518: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3521: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3524: bipush 39
    //   3526: aload_1
    //   3527: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3530: iconst_1
    //   3531: ireturn
    //   3532: iconst_0
    //   3533: istore_2
    //   3534: goto -25 -> 3509
    //   3537: aload_0
    //   3538: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3541: invokevirtual 483	com/tencent/mobileqq/activity/Conversation:bMG	()V
    //   3544: iconst_1
    //   3545: ireturn
    //   3546: aload_0
    //   3547: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3550: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3553: bipush 24
    //   3555: iconst_2
    //   3556: invokevirtual 39	aahb:gm	(II)V
    //   3559: aload_0
    //   3560: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3563: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3566: bipush 24
    //   3568: aload_1
    //   3569: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3572: iconst_1
    //   3573: ireturn
    //   3574: aload_0
    //   3575: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3578: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3581: bipush 24
    //   3583: iconst_0
    //   3584: invokevirtual 39	aahb:gm	(II)V
    //   3587: aload_0
    //   3588: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3591: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3594: bipush 24
    //   3596: aload_1
    //   3597: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3600: iconst_1
    //   3601: ireturn
    //   3602: aload_0
    //   3603: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3606: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3609: bipush 25
    //   3611: iconst_2
    //   3612: invokevirtual 39	aahb:gm	(II)V
    //   3615: aload_0
    //   3616: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3619: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3622: bipush 25
    //   3624: aload_1
    //   3625: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3628: iconst_1
    //   3629: ireturn
    //   3630: aload_0
    //   3631: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3634: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3637: bipush 25
    //   3639: iconst_0
    //   3640: invokevirtual 39	aahb:gm	(II)V
    //   3643: aload_0
    //   3644: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3647: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3650: bipush 25
    //   3652: aload_1
    //   3653: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3656: iconst_1
    //   3657: ireturn
    //   3658: aload_0
    //   3659: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3662: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3665: iconst_5
    //   3666: aload_1
    //   3667: getfield 281	android/os/Message:arg1	I
    //   3670: invokevirtual 39	aahb:gm	(II)V
    //   3673: aload_0
    //   3674: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3677: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3680: iconst_5
    //   3681: aload_1
    //   3682: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3685: iconst_1
    //   3686: ireturn
    //   3687: aload_0
    //   3688: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3691: getfield 486	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aajg	Laajg;
    //   3694: ifnull -3643 -> 51
    //   3697: aload_0
    //   3698: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3701: getfield 486	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aajg	Laajg;
    //   3704: invokevirtual 491	aajg:cuM	()V
    //   3707: iconst_1
    //   3708: ireturn
    //   3709: aload_0
    //   3710: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3713: getfield 495	com/tencent/mobileqq/activity/Conversation:k	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3716: ifnull -3665 -> 51
    //   3719: aload_1
    //   3720: getfield 281	android/os/Message:arg1	I
    //   3723: iconst_1
    //   3724: if_icmpne +38 -> 3762
    //   3727: iconst_1
    //   3728: istore_2
    //   3729: iload_2
    //   3730: ifeq +37 -> 3767
    //   3733: new 497	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo
    //   3736: dup
    //   3737: invokespecial 498	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:<init>	()V
    //   3740: astore_1
    //   3741: aload_1
    //   3742: getfield 502	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo:red_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3745: iconst_0
    //   3746: invokevirtual 507	com/tencent/mobileqq/pb/PBUInt32Field:set	(I)V
    //   3749: aload_0
    //   3750: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3753: getfield 495	com/tencent/mobileqq/activity/Conversation:k	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3756: aload_1
    //   3757: invokevirtual 512	com/tencent/mobileqq/redtouch/RedTouch:c	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$RedTypeInfo;)V
    //   3760: iconst_1
    //   3761: ireturn
    //   3762: iconst_0
    //   3763: istore_2
    //   3764: goto -35 -> 3729
    //   3767: aload_0
    //   3768: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3771: getfield 495	com/tencent/mobileqq/activity/Conversation:k	Lcom/tencent/mobileqq/redtouch/RedTouch;
    //   3774: new 514	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo
    //   3777: dup
    //   3778: invokespecial 515	com/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo:<init>	()V
    //   3781: invokevirtual 519	com/tencent/mobileqq/redtouch/RedTouch:e	(Lcom/tencent/pb/getbusiinfo/BusinessInfoCheckUpdate$AppInfo;)V
    //   3784: iconst_1
    //   3785: ireturn
    //   3786: aload_0
    //   3787: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3790: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3793: astore 9
    //   3795: aload_1
    //   3796: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   3799: ifnonnull +27 -> 3826
    //   3802: iload 4
    //   3804: istore_2
    //   3805: aload 9
    //   3807: iconst_3
    //   3808: iload_2
    //   3809: invokevirtual 39	aahb:gm	(II)V
    //   3812: aload_0
    //   3813: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3816: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3819: iconst_3
    //   3820: aload_1
    //   3821: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   3824: iconst_1
    //   3825: ireturn
    //   3826: iconst_2
    //   3827: istore_2
    //   3828: goto -23 -> 3805
    //   3831: aload_0
    //   3832: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3835: invokestatic 82	com/tencent/mobileqq/activity/Conversation:b	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   3838: iconst_1
    //   3839: ireturn
    //   3840: aload_0
    //   3841: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3844: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3847: bipush 10
    //   3849: invokevirtual 523	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   3852: checkcast 525	ackv
    //   3855: invokevirtual 528	ackv:cMf	()V
    //   3858: iconst_1
    //   3859: ireturn
    //   3860: ldc 59
    //   3862: ldc_w 530
    //   3865: invokestatic 535	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   3868: aload_0
    //   3869: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3872: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3875: ifnull +20 -> 3895
    //   3878: aload_0
    //   3879: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3882: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3885: sipush 181
    //   3888: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   3891: checkcast 537	pmb
    //   3894: astore_1
    //   3895: new 539	com/tencent/mobileqq/activity/Conversation$1$7
    //   3898: dup
    //   3899: aload_0
    //   3900: invokespecial 540	com/tencent/mobileqq/activity/Conversation$1$7:<init>	(Lury;)V
    //   3903: bipush 8
    //   3905: aconst_null
    //   3906: iconst_1
    //   3907: invokestatic 262	com/tencent/mobileqq/app/ThreadManager:post	(Ljava/lang/Runnable;ILcom/tencent/mobileqq/app/ThreadExcutor$IThreadListener;Z)V
    //   3910: iconst_1
    //   3911: ireturn
    //   3912: aload_0
    //   3913: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3916: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3919: invokevirtual 542	aahb:b	()Lmqq/os/MqqHandler;
    //   3922: astore 9
    //   3924: aload 9
    //   3926: ifnull -3875 -> 51
    //   3929: aload 9
    //   3931: sipush 200
    //   3934: invokevirtual 546	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   3937: astore 10
    //   3939: aload 10
    //   3941: aload_1
    //   3942: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   3945: putfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   3948: aload 9
    //   3950: aload 10
    //   3952: invokevirtual 549	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   3955: pop
    //   3956: iconst_1
    //   3957: ireturn
    //   3958: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3961: ifeq +30 -> 3991
    //   3964: ldc_w 551
    //   3967: iconst_2
    //   3968: new 408	java/lang/StringBuilder
    //   3971: dup
    //   3972: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   3975: ldc_w 553
    //   3978: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3981: aload_1
    //   3982: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3985: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3988: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3991: aload_0
    //   3992: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   3995: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   3998: invokevirtual 542	aahb:b	()Lmqq/os/MqqHandler;
    //   4001: astore 9
    //   4003: aload 9
    //   4005: ifnull -3954 -> 51
    //   4008: aload 9
    //   4010: sipush 201
    //   4013: invokevirtual 546	mqq/os/MqqHandler:obtainMessage	(I)Landroid/os/Message;
    //   4016: astore 10
    //   4018: aload 10
    //   4020: aload_1
    //   4021: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   4024: putfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   4027: aload 9
    //   4029: aload 10
    //   4031: invokevirtual 549	mqq/os/MqqHandler:sendMessage	(Landroid/os/Message;)Z
    //   4034: pop
    //   4035: iconst_1
    //   4036: ireturn
    //   4037: invokestatic 561	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4040: ifne +38 -> 4078
    //   4043: iconst_0
    //   4044: invokestatic 565	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4047: ifne +31 -> 4078
    //   4050: aload_0
    //   4051: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4054: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4057: sipush 1069
    //   4060: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4063: aload_0
    //   4064: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4067: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4070: sipush 1068
    //   4073: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4076: iconst_1
    //   4077: ireturn
    //   4078: aload_0
    //   4079: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4082: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4085: sipush 1068
    //   4088: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4091: ifeq +16 -> 4107
    //   4094: aload_0
    //   4095: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4098: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4101: sipush 1068
    //   4104: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4107: aload_0
    //   4108: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4111: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4114: iconst_0
    //   4115: invokevirtual 568	aahb:Cm	(Z)V
    //   4118: aload_0
    //   4119: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4122: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4125: invokevirtual 542	aahb:b	()Lmqq/os/MqqHandler;
    //   4128: ifnull -4077 -> 51
    //   4131: aload_0
    //   4132: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4135: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4138: iconst_m1
    //   4139: aconst_null
    //   4140: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   4143: iconst_1
    //   4144: ireturn
    //   4145: invokestatic 561	com/tencent/mobileqq/theme/ThemeUtil:isDefaultTheme	()Z
    //   4148: ifne +38 -> 4186
    //   4151: iconst_0
    //   4152: invokestatic 565	com/tencent/mobileqq/theme/ThemeUtil:isSimpleDayTheme	(Z)Z
    //   4155: ifne +31 -> 4186
    //   4158: aload_0
    //   4159: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4162: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4165: sipush 1069
    //   4168: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4171: aload_0
    //   4172: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4175: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4178: sipush 1068
    //   4181: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4184: iconst_1
    //   4185: ireturn
    //   4186: aload_0
    //   4187: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4190: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4193: sipush 1069
    //   4196: invokevirtual 290	mqq/os/MqqHandler:hasMessages	(I)Z
    //   4199: ifeq +16 -> 4215
    //   4202: aload_0
    //   4203: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4206: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4209: sipush 1069
    //   4212: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4215: aload_0
    //   4216: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4219: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4222: iconst_1
    //   4223: invokevirtual 568	aahb:Cm	(Z)V
    //   4226: aload_0
    //   4227: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4230: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4233: invokevirtual 542	aahb:b	()Lmqq/os/MqqHandler;
    //   4236: ifnull -4185 -> 51
    //   4239: aload_0
    //   4240: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4243: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4246: iconst_m1
    //   4247: aconst_null
    //   4248: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   4251: iconst_1
    //   4252: ireturn
    //   4253: aload_0
    //   4254: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4257: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4260: sipush 1070
    //   4263: invokevirtual 293	mqq/os/MqqHandler:removeMessages	(I)V
    //   4266: aload_0
    //   4267: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4270: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4273: bipush 36
    //   4275: invokevirtual 303	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4278: checkcast 570	altq
    //   4281: invokevirtual 573	altq:dJH	()V
    //   4284: iconst_1
    //   4285: ireturn
    //   4286: aload_0
    //   4287: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4290: getfield 576	com/tencent/mobileqq/activity/Conversation:mIsForeground	Z
    //   4293: ifeq -4242 -> 51
    //   4296: aload_0
    //   4297: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4300: getfield 285	com/tencent/mobileqq/activity/Conversation:g	Lmqq/os/MqqHandler;
    //   4303: ldc_w 577
    //   4306: getstatic 582	anor:dKO	I
    //   4309: sipush 1000
    //   4312: imul
    //   4313: i2l
    //   4314: invokevirtual 586	mqq/os/MqqHandler:sendEmptyMessageDelayed	(IJ)Z
    //   4317: pop
    //   4318: iconst_1
    //   4319: ireturn
    //   4320: aload_0
    //   4321: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4324: getfield 44	com/tencent/mobileqq/activity/Conversation:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4327: invokestatic 590	anor:dV	(Lcom/tencent/mobileqq/app/QQAppInterface;)V
    //   4330: iconst_1
    //   4331: ireturn
    //   4332: aload_1
    //   4333: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   4336: instanceof 592
    //   4339: ifeq -4288 -> 51
    //   4342: aload_0
    //   4343: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4346: getfield 595	com/tencent/mobileqq/activity/Conversation:isDestroy	Z
    //   4349: ifne -4298 -> 51
    //   4352: aload_1
    //   4353: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   4356: checkcast 592	[Ljava/lang/String;
    //   4359: checkcast 592	[Ljava/lang/String;
    //   4362: astore 10
    //   4364: aload 10
    //   4366: arraylength
    //   4367: iconst_3
    //   4368: if_icmpne -4317 -> 51
    //   4371: aload 10
    //   4373: iconst_0
    //   4374: aaload
    //   4375: astore_1
    //   4376: aload 10
    //   4378: iconst_1
    //   4379: aaload
    //   4380: astore 9
    //   4382: aload 10
    //   4384: iconst_2
    //   4385: aaload
    //   4386: astore 10
    //   4388: new 597	com/tencent/mobileqq/activity/Conversation$e
    //   4391: dup
    //   4392: aload_0
    //   4393: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4396: aload_1
    //   4397: aload 9
    //   4399: aload 10
    //   4401: invokespecial 600	com/tencent/mobileqq/activity/Conversation$e:<init>	(Lcom/tencent/mobileqq/activity/Conversation;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   4404: invokevirtual 603	com/tencent/mobileqq/activity/Conversation$e:invoke	()V
    //   4407: iconst_1
    //   4408: ireturn
    //   4409: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4412: ifeq +32 -> 4444
    //   4415: ldc 59
    //   4417: iconst_2
    //   4418: new 408	java/lang/StringBuilder
    //   4421: dup
    //   4422: invokespecial 409	java/lang/StringBuilder:<init>	()V
    //   4425: ldc_w 605
    //   4428: invokevirtual 415	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4431: aload_1
    //   4432: getfield 86	android/os/Message:obj	Ljava/lang/Object;
    //   4435: invokevirtual 556	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   4438: invokevirtual 429	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4441: invokestatic 266	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4444: aload_0
    //   4445: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4448: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4451: iconst_2
    //   4452: iconst_2
    //   4453: invokevirtual 39	aahb:gm	(II)V
    //   4456: aload_0
    //   4457: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4460: getfield 33	com/tencent/mobileqq/activity/Conversation:jdField_a_of_type_Aahb	Laahb;
    //   4463: iconst_2
    //   4464: aload_1
    //   4465: invokevirtual 79	aahb:d	(ILandroid/os/Message;)V
    //   4468: iconst_1
    //   4469: ireturn
    //   4470: aload_0
    //   4471: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4474: iconst_1
    //   4475: invokestatic 608	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;I)V
    //   4478: iconst_1
    //   4479: ireturn
    //   4480: aload_0
    //   4481: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4484: ldc_w 609
    //   4487: invokevirtual 610	com/tencent/mobileqq/activity/Conversation:findViewById	(I)Landroid/view/View;
    //   4490: checkcast 612	android/widget/TextView
    //   4493: invokestatic 617	lf:d	(Landroid/widget/TextView;)V
    //   4496: iconst_1
    //   4497: ireturn
    //   4498: aload_0
    //   4499: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4502: ldc_w 609
    //   4505: invokevirtual 610	com/tencent/mobileqq/activity/Conversation:findViewById	(I)Landroid/view/View;
    //   4508: bipush 8
    //   4510: invokevirtual 124	android/view/View:setVisibility	(I)V
    //   4513: iconst_1
    //   4514: ireturn
    //   4515: new 619	com/tencent/mobileqq/activity/Conversation$1$8
    //   4518: dup
    //   4519: aload_0
    //   4520: invokespecial 620	com/tencent/mobileqq/activity/Conversation$1$8:<init>	(Lury;)V
    //   4523: invokestatic 621	com/tencent/mobileqq/app/ThreadManager:executeOnSubThread	(Ljava/lang/Runnable;)V
    //   4526: iconst_1
    //   4527: ireturn
    //   4528: aload_0
    //   4529: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4532: invokestatic 623	com/tencent/mobileqq/activity/Conversation:d	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4535: iconst_1
    //   4536: ireturn
    //   4537: invokestatic 628	aekv:needShowMiniAppFullScreen	()Z
    //   4540: ifeq +58 -> 4598
    //   4543: invokestatic 57	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4546: ifeq +12 -> 4558
    //   4549: ldc 59
    //   4551: iconst_2
    //   4552: ldc_w 630
    //   4555: invokestatic 65	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4558: aload_0
    //   4559: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4562: iconst_1
    //   4563: invokestatic 633	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;Z)Z
    //   4566: pop
    //   4567: aload_0
    //   4568: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4571: invokestatic 636	android/os/SystemClock:elapsedRealtime	()J
    //   4574: invokestatic 639	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;J)J
    //   4577: pop2
    //   4578: aload_0
    //   4579: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4582: invokestatic 364	com/tencent/mobileqq/activity/Conversation:a	(Lcom/tencent/mobileqq/activity/Conversation;)Lcom/tencent/mobileqq/fpsreport/FPSSwipListView;
    //   4585: iconst_0
    //   4586: invokevirtual 642	com/tencent/mobileqq/fpsreport/FPSSwipListView:setSelection	(I)V
    //   4589: aload_0
    //   4590: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4593: invokestatic 644	com/tencent/mobileqq/activity/Conversation:e	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4596: iconst_1
    //   4597: ireturn
    //   4598: aload_0
    //   4599: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4602: invokestatic 647	com/tencent/mobileqq/activity/Conversation:f	(Lcom/tencent/mobileqq/activity/Conversation;)V
    //   4605: iconst_1
    //   4606: ireturn
    //   4607: aload_0
    //   4608: getfield 12	ury:this$0	Lcom/tencent/mobileqq/activity/Conversation;
    //   4611: invokevirtual 650	com/tencent/mobileqq/activity/Conversation:a	()Lcom/tencent/mobileqq/app/BaseActivity;
    //   4614: invokestatic 656	abdi:n	(Lcom/tencent/mobileqq/app/BaseActivity;)V
    //   4617: iconst_1
    //   4618: ireturn
    //   4619: goto -1403 -> 3216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4622	0	this	ury
    //   0	4622	1	paramMessage	android.os.Message
    //   1	3827	2	i	int
    //   6	3443	3	j	int
    //   3	3800	4	k	int
    //   1316	1987	5	l1	long
    //   1328	216	7	l2	long
    //   938	529	9	localObject1	Object
    //   1647	1	9	localException	java.lang.Exception
    //   1769	2629	9	localObject2	Object
    //   1048	3352	10	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   1600	1610	1647	java/lang/Exception
    //   1600	1610	1661	finally
    //   2228	2259	2292	java/lang/Exception
    //   2259	2279	2292	java/lang/Exception
    //   2284	2290	2292	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ury
 * JD-Core Version:    0.7.0.1
 */