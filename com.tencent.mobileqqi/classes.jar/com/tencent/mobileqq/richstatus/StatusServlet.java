package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import android.content.Intent;
import android.text.TextUtils;
import com.qq.taf.jce.JceStruct;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.NewIntent;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class StatusServlet
  extends MSFServlet
{
  static final int a = 1;
  public static final String a = "PersonalStateSvc.ReqGetHotState";
  static final int b = 2;
  public static final String b = "k_cmd";
  static final int jdField_c_of_type_Int = 3;
  static final String jdField_c_of_type_JavaLangString = "k_sync_ss";
  static final int jdField_d_of_type_Int = 4;
  static final String jdField_d_of_type_JavaLangString = "k_resp_mate";
  static final int jdField_e_of_type_Int = 5;
  static final String jdField_e_of_type_JavaLangString = "k_fetch_sex";
  static final int jdField_f_of_type_Int = 6;
  static final String jdField_f_of_type_JavaLangString = "k_is_first";
  private static final int jdField_g_of_type_Int = 50;
  static final String jdField_g_of_type_JavaLangString = "k_action";
  static final String h = "k_data";
  static final String i = "k_end_time";
  static final String j = "k_start_time";
  static final String k = "k_status_key";
  static final String l = "k_status_flag";
  static final String m = "k_error_code";
  static final String n = "k_resp_hot_status";
  private static final String o = "OidbSvc.0x515_2";
  private static final String p = "OidbSvc.0x53f_1";
  private static final String q = "OidbSvc.0x54f_0";
  private static final String r = "PersonalStateSvc.ReqGetSameStateList";
  private static final String s = "k_uin";
  private static final String t = "k_cookie";
  
  static PersonalState.LBSInfo a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface.a();
    Object localObject1 = paramQQAppInterface.a();
    paramQQAppInterface = null;
    if (localObject1 != null)
    {
      paramQQAppInterface = ((NearbyGroup.LBSInfo)localObject1).stGps;
      paramQQAppInterface = new PersonalState.GPS(paramQQAppInterface.iLat, paramQQAppInterface.iLon, paramQQAppInterface.iAlt, paramQQAppInterface.eType);
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = ((NearbyGroup.LBSInfo)localObject1).vWifis.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (NearbyGroup.Wifi)((Iterator)localObject2).next();
        localArrayList.add(new PersonalState.Wifi(((NearbyGroup.Wifi)localObject3).lMac, ((NearbyGroup.Wifi)localObject3).shRssi));
      }
      localObject2 = new ArrayList();
      localObject1 = ((NearbyGroup.LBSInfo)localObject1).vCells.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (NearbyGroup.Cell)((Iterator)localObject1).next();
        ((ArrayList)localObject2).add(new PersonalState.Cell(((NearbyGroup.Cell)localObject3).shMcc, ((NearbyGroup.Cell)localObject3).shMnc, ((NearbyGroup.Cell)localObject3).iLac, ((NearbyGroup.Cell)localObject3).iCellId, ((NearbyGroup.Cell)localObject3).shRssi));
      }
      paramQQAppInterface = new PersonalState.LBSInfo(paramQQAppInterface, localArrayList, (ArrayList)localObject2);
    }
    return paramQQAppInterface;
  }
  
  static void a(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 4);
    localNewIntent.putExtra("k_start_time", paramInt1);
    localNewIntent.putExtra("k_end_time", paramInt2);
    localNewIntent.putExtra("k_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.a());
    localNewIntent.putExtra("k_sync_ss", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, String paramString, byte[] paramArrayOfByte)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 3);
    localNewIntent.putExtra("k_is_first", paramBoolean);
    localNewIntent.putExtra("k_cookie", paramArrayOfByte);
    localNewIntent.putExtra("k_fetch_sex", paramInt1);
    localNewIntent.putExtra("k_action", paramInt2);
    localNewIntent.putExtra("k_data", paramInt3);
    localNewIntent.putExtra("k_uin", paramString);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] a(List paramList, byte paramByte)
  {
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1359);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    Object localObject2 = paramList.iterator();
    int i1 = 7;
    byte[] arrayOfByte;
    if (((Iterator)localObject2).hasNext())
    {
      arrayOfByte = (byte[])((Iterator)localObject2).next();
      if (arrayOfByte == null) {
        break label227;
      }
      i1 = arrayOfByte.length + (i1 + 2) + 4;
    }
    label227:
    for (;;)
    {
      break;
      localObject2 = ByteBuffer.allocate(i1);
      ((ByteBuffer)localObject2).putInt(0);
      ((ByteBuffer)localObject2).put(paramByte);
      ((ByteBuffer)localObject2).putShort((short)paramList.size());
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        arrayOfByte = (byte[])paramList.next();
        if (arrayOfByte != null)
        {
          ((ByteBuffer)localObject2).putShort((short)arrayOfByte.length);
          ((ByteBuffer)localObject2).put(arrayOfByte);
          ((ByteBuffer)localObject2).putInt(0);
        }
      }
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      paramList = ((oidb_sso.OIDBSSOPkg)localObject1).toByteArray();
      localObject1 = ByteBuffer.allocate(paramList.length + 4);
      ((ByteBuffer)localObject1).putInt(paramList.length + 4);
      ((ByteBuffer)localObject1).put(paramList);
      return ((ByteBuffer)localObject1).array();
    }
  }
  
  static void b(QQAppInterface paramQQAppInterface)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.a(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 6);
    if (QLog.isColorLevel()) {
      QLog.d("get_hot_rich_status", 2, "StatusServlet.getHotRichStatus()");
    }
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  byte[] a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1343);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(27);
    localByteBuffer.putLong(paramLong).put((byte)2).putInt(paramInt1).putInt(paramInt2).putInt(0).putInt(0).putShort((short)20);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  byte[] a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int i2 = 1;
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1301);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(11);
    ByteBuffer localByteBuffer2 = localByteBuffer1.put((byte)2).putInt(293615363);
    if (paramBoolean1)
    {
      i1 = 1;
      localByteBuffer2.put((byte)i1);
      if (!paramBoolean2) {
        break label155;
      }
    }
    label155:
    for (int i1 = i2;; i1 = 0)
    {
      localByteBuffer1.put((byte)i1).putInt((int)paramLong);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer1.array()));
      localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      localByteBuffer1 = ByteBuffer.allocate(localObject.length + 4);
      localByteBuffer1.putInt(localObject.length + 4);
      localByteBuffer1.put((byte[])localObject);
      return localByteBuffer1.array();
      i1 = 0;
      break;
    }
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 14
    //   3: iconst_0
    //   4: invokevirtual 310	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore 5
    //   9: aload_2
    //   10: invokevirtual 315	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 8
    //   15: aload_0
    //   16: invokevirtual 319	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   19: bipush 13
    //   21: invokevirtual 325	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   24: checkcast 327	com/tencent/mobileqq/richstatus/StatusManager
    //   27: astore 13
    //   29: aload 13
    //   31: ifnonnull +4 -> 35
    //   34: return
    //   35: new 329	android/os/Bundle
    //   38: dup
    //   39: invokespecial 330	android/os/Bundle:<init>	()V
    //   42: astore 14
    //   44: iload 5
    //   46: tableswitch	default:+38 -> 84, 1:+53->99, 2:+53->99, 3:+609->655, 4:+206->252, 5:+717->763, 6:+1076->1122
    //   85: aload_1
    //   86: iload 5
    //   88: iload 8
    //   90: aload 14
    //   92: ldc_w 332
    //   95: invokevirtual 336	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   98: return
    //   99: aload_2
    //   100: invokevirtual 339	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   103: invokestatic 342	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   106: astore_2
    //   107: aload_2
    //   108: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   111: iconst_4
    //   112: isub
    //   113: newarray byte
    //   115: astore 13
    //   117: aload_2
    //   118: aload 13
    //   120: invokevirtual 348	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   123: pop
    //   124: new 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   127: dup
    //   128: invokespecial 216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   131: aload 13
    //   133: invokevirtual 352	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   139: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   142: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   145: invokevirtual 356	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   148: invokestatic 342	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   151: astore_2
    //   152: aload_2
    //   153: invokevirtual 359	java/nio/ByteBuffer:get	()B
    //   156: istore_3
    //   157: aload_2
    //   158: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   161: i2l
    //   162: lstore 11
    //   164: aload_2
    //   165: invokevirtual 359	java/nio/ByteBuffer:get	()B
    //   168: iconst_1
    //   169: if_icmpne +1447 -> 1616
    //   172: iconst_1
    //   173: istore 9
    //   175: goto +1423 -> 1598
    //   178: aload 14
    //   180: ldc 18
    //   182: iload 10
    //   184: invokevirtual 363	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   187: iload 9
    //   189: istore 8
    //   191: goto -107 -> 84
    //   194: iload 9
    //   196: istore 10
    //   198: iload 8
    //   200: istore 9
    //   202: iload 5
    //   204: iconst_2
    //   205: if_icmpne -27 -> 178
    //   208: aload_1
    //   209: ldc 18
    //   211: iconst_0
    //   212: invokevirtual 367	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   215: istore 10
    //   217: iload 8
    //   219: istore 9
    //   221: goto -43 -> 178
    //   224: astore_2
    //   225: aload_2
    //   226: invokevirtual 370	java/lang/Exception:printStackTrace	()V
    //   229: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   232: ifeq +14 -> 246
    //   235: ldc_w 372
    //   238: iconst_2
    //   239: aload_2
    //   240: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   243: invokestatic 378	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   246: iconst_0
    //   247: istore 8
    //   249: goto -165 -> 84
    //   252: new 380	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   255: dup
    //   256: invokespecial 381	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   259: astore 13
    //   261: aload 13
    //   263: aload_1
    //   264: ldc 43
    //   266: iconst_0
    //   267: invokevirtual 310	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   270: putfield 384	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   273: aload 13
    //   275: aload_1
    //   276: ldc 40
    //   278: ldc_w 385
    //   281: invokevirtual 310	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   284: putfield 388	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   287: aload 13
    //   289: iconst_0
    //   290: putfield 392	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   293: aload 14
    //   295: ldc 37
    //   297: aload 13
    //   299: invokevirtual 396	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   302: aload_2
    //   303: invokevirtual 339	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   306: invokestatic 342	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   309: astore_2
    //   310: aload_2
    //   311: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   314: iconst_4
    //   315: isub
    //   316: newarray byte
    //   318: astore 15
    //   320: aload_2
    //   321: aload 15
    //   323: invokevirtual 348	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   326: pop
    //   327: new 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   330: dup
    //   331: invokespecial 216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   334: aload 15
    //   336: invokevirtual 352	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   339: checkcast 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   342: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   345: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   348: invokevirtual 356	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   351: invokestatic 342	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   354: astore_2
    //   355: aload_2
    //   356: invokevirtual 359	java/nio/ByteBuffer:get	()B
    //   359: pop
    //   360: aload_2
    //   361: invokevirtual 400	java/nio/ByteBuffer:getLong	()J
    //   364: lstore 11
    //   366: aload_2
    //   367: invokevirtual 359	java/nio/ByteBuffer:get	()B
    //   370: pop
    //   371: aload_2
    //   372: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   375: pop
    //   376: aload_2
    //   377: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   380: istore 4
    //   382: aload_2
    //   383: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   386: pop
    //   387: aload_2
    //   388: invokevirtual 359	java/nio/ByteBuffer:get	()B
    //   391: ifeq +1238 -> 1629
    //   394: iconst_1
    //   395: istore 9
    //   397: aload_2
    //   398: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   401: istore 6
    //   403: aload 13
    //   405: new 114	java/util/ArrayList
    //   408: dup
    //   409: iload 6
    //   411: invokespecial 406	java/util/ArrayList:<init>	(I)V
    //   414: putfield 409	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   417: iconst_0
    //   418: istore_3
    //   419: iload_3
    //   420: iload 6
    //   422: if_icmpge +130 -> 552
    //   425: aload_2
    //   426: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   429: newarray byte
    //   431: astore 15
    //   433: aload_2
    //   434: aload 15
    //   436: invokevirtual 348	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   439: pop
    //   440: aload_2
    //   441: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   444: newarray byte
    //   446: astore 16
    //   448: aload_2
    //   449: aload 16
    //   451: invokevirtual 348	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   454: pop
    //   455: aload_2
    //   456: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   459: pop
    //   460: aload_2
    //   461: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   464: istore 7
    //   466: aload_2
    //   467: aload_2
    //   468: invokevirtual 412	java/nio/ByteBuffer:position	()I
    //   471: bipush 8
    //   473: iadd
    //   474: invokevirtual 415	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   477: pop
    //   478: iload 7
    //   480: iload 4
    //   482: if_icmple +6 -> 488
    //   485: goto +1137 -> 1622
    //   488: aload 16
    //   490: invokestatic 420	com/tencent/mobileqq/richstatus/RichStatus:a	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   493: astore 16
    //   495: aload 16
    //   497: iload 7
    //   499: i2l
    //   500: putfield 422	com/tencent/mobileqq/richstatus/RichStatus:jdField_a_of_type_Long	J
    //   503: aload 16
    //   505: aload 15
    //   507: putfield 424	com/tencent/mobileqq/richstatus/RichStatus:jdField_a_of_type_ArrayOfByte	[B
    //   510: aload 13
    //   512: getfield 409	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   515: aload 16
    //   517: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   520: pop
    //   521: goto +1101 -> 1622
    //   524: astore_2
    //   525: aload_2
    //   526: invokevirtual 370	java/lang/Exception:printStackTrace	()V
    //   529: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +14 -> 546
    //   535: ldc_w 372
    //   538: iconst_2
    //   539: aload_2
    //   540: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   543: invokestatic 378	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: iconst_0
    //   547: istore 8
    //   549: goto -465 -> 84
    //   552: aload 13
    //   554: getfield 409	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   557: invokevirtual 427	java/util/ArrayList:isEmpty	()Z
    //   560: ifeq +85 -> 645
    //   563: aload 13
    //   565: getfield 384	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   568: ifne +77 -> 645
    //   571: aload 13
    //   573: getfield 388	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   576: ldc_w 385
    //   579: if_icmpne +66 -> 645
    //   582: aload_0
    //   583: invokevirtual 319	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   586: bipush 8
    //   588: invokevirtual 325	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   591: checkcast 429	com/tencent/mobileqq/model/FriendManager
    //   594: lload 11
    //   596: invokestatic 435	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   599: invokeinterface 438 2 0
    //   604: astore_2
    //   605: aload_2
    //   606: ifnull +39 -> 645
    //   609: aload_2
    //   610: invokevirtual 444	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   613: ifnull +32 -> 645
    //   616: aload_2
    //   617: invokevirtual 444	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   620: invokevirtual 446	com/tencent/mobileqq/richstatus/RichStatus:a	()Z
    //   623: ifne +22 -> 645
    //   626: aload 13
    //   628: getfield 409	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   631: aload_2
    //   632: invokevirtual 444	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   635: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   638: pop
    //   639: aload 13
    //   641: iconst_1
    //   642: putfield 392	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   645: aload 13
    //   647: iload 9
    //   649: putfield 449	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   652: goto -568 -> 84
    //   655: aload 14
    //   657: ldc 30
    //   659: aload_1
    //   660: ldc 30
    //   662: iconst_1
    //   663: invokevirtual 367	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   666: invokevirtual 363	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   669: aload 14
    //   671: ldc 26
    //   673: aload_1
    //   674: ldc 26
    //   676: iconst_m1
    //   677: invokevirtual 310	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   680: invokevirtual 452	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   683: new 454	com/qq/jce/wup/UniPacket
    //   686: dup
    //   687: iconst_1
    //   688: invokespecial 457	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   691: astore 13
    //   693: aload 13
    //   695: ldc_w 459
    //   698: invokevirtual 463	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   701: aload 13
    //   703: aload_2
    //   704: invokevirtual 339	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   707: invokevirtual 467	com/qq/jce/wup/UniPacket:decode	([B)V
    //   710: aload 13
    //   712: ldc_w 469
    //   715: new 471	PersonalState/RespGetSameStateList
    //   718: dup
    //   719: invokespecial 472	PersonalState/RespGetSameStateList:<init>	()V
    //   722: invokevirtual 476	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   725: checkcast 471	PersonalState/RespGetSameStateList
    //   728: astore_2
    //   729: aload_2
    //   730: getfield 480	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   733: getfield 485	PersonalState/BusiRespHead:iReplyCode	I
    //   736: ifne +14 -> 750
    //   739: aload 14
    //   741: ldc 22
    //   743: aload_2
    //   744: invokevirtual 396	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   747: goto -663 -> 84
    //   750: iconst_0
    //   751: istore 8
    //   753: goto -6 -> 747
    //   756: astore_2
    //   757: iconst_0
    //   758: istore 8
    //   760: goto -676 -> 84
    //   763: iload 8
    //   765: ifeq -681 -> 84
    //   768: new 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   771: dup
    //   772: invokespecial 216	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   775: astore 13
    //   777: aload 13
    //   779: aload_2
    //   780: invokevirtual 339	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   783: invokestatic 490	com/tencent/mobileqq/utils/WupUtil:b	([B)[B
    //   786: invokevirtual 352	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   789: checkcast 215	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   792: astore_2
    //   793: aload_2
    //   794: ifnull +312 -> 1106
    //   797: aload_2
    //   798: getfield 493	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   801: invokevirtual 496	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   804: ifeq +302 -> 1106
    //   807: aload_2
    //   808: getfield 493	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   811: invokevirtual 498	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   814: istore_3
    //   815: iload_3
    //   816: ifne +276 -> 1092
    //   819: aload_2
    //   820: getfield 262	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   823: invokevirtual 355	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   826: invokevirtual 356	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   829: invokestatic 342	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   832: astore 15
    //   834: aload 15
    //   836: invokevirtual 359	java/nio/ByteBuffer:get	()B
    //   839: istore_3
    //   840: iload_3
    //   841: ifne +184 -> 1025
    //   844: aload 15
    //   846: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   849: istore 6
    //   851: iconst_0
    //   852: istore_3
    //   853: aconst_null
    //   854: astore_2
    //   855: iload_3
    //   856: iload 6
    //   858: if_icmpge +75 -> 933
    //   861: aload 15
    //   863: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   866: newarray byte
    //   868: astore_2
    //   869: aload 15
    //   871: aload_2
    //   872: invokevirtual 348	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   875: pop
    //   876: iload_3
    //   877: iconst_1
    //   878: iadd
    //   879: istore_3
    //   880: goto -25 -> 855
    //   883: astore_2
    //   884: aload_2
    //   885: invokevirtual 499	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   888: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   891: ifeq +33 -> 924
    //   894: ldc_w 372
    //   897: iconst_2
    //   898: new 501	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 502	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 504
    //   908: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_2
    //   912: invokevirtual 509	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   915: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   924: iconst_0
    //   925: istore 8
    //   927: aload 13
    //   929: astore_2
    //   930: goto -137 -> 793
    //   933: aload 15
    //   935: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   938: istore 7
    //   940: aconst_null
    //   941: astore 13
    //   943: iconst_0
    //   944: istore 4
    //   946: iconst_0
    //   947: istore_3
    //   948: iload_3
    //   949: iload 7
    //   951: if_icmpge +34 -> 985
    //   954: aload 15
    //   956: invokevirtual 404	java/nio/ByteBuffer:getShort	()S
    //   959: newarray byte
    //   961: astore 13
    //   963: aload 15
    //   965: aload 13
    //   967: invokevirtual 348	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   970: pop
    //   971: aload 15
    //   973: invokevirtual 345	java/nio/ByteBuffer:getInt	()I
    //   976: istore 4
    //   978: iload_3
    //   979: iconst_1
    //   980: iadd
    //   981: istore_3
    //   982: goto -34 -> 948
    //   985: iload 6
    //   987: ifle +14 -> 1001
    //   990: aload 14
    //   992: ldc 46
    //   994: aload_2
    //   995: invokevirtual 516	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   998: goto +637 -> 1635
    //   1001: aload 14
    //   1003: ldc 46
    //   1005: aload 13
    //   1007: invokevirtual 516	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   1010: aload 14
    //   1012: ldc 52
    //   1014: iload 4
    //   1016: invokevirtual 452	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1019: iconst_0
    //   1020: istore 8
    //   1022: goto +613 -> 1635
    //   1025: iconst_0
    //   1026: istore 8
    //   1028: aload 14
    //   1030: ldc 52
    //   1032: iload_3
    //   1033: invokevirtual 452	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1036: goto +599 -> 1635
    //   1039: astore_2
    //   1040: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1043: ifeq +33 -> 1076
    //   1046: ldc_w 372
    //   1049: iconst_2
    //   1050: new 501	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 502	java/lang/StringBuilder:<init>	()V
    //   1057: ldc_w 518
    //   1060: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1063: aload_2
    //   1064: invokevirtual 375	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1067: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 378	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1076: iconst_0
    //   1077: istore 8
    //   1079: aload 14
    //   1081: ldc 52
    //   1083: sipush -1002
    //   1086: invokevirtual 452	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1089: goto +546 -> 1635
    //   1092: iconst_0
    //   1093: istore 8
    //   1095: aload 14
    //   1097: ldc 52
    //   1099: iload_3
    //   1100: invokevirtual 452	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1103: goto +532 -> 1635
    //   1106: iconst_0
    //   1107: istore 8
    //   1109: aload 14
    //   1111: ldc 52
    //   1113: sipush -1001
    //   1116: invokevirtual 452	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1119: goto +516 -> 1635
    //   1122: new 454	com/qq/jce/wup/UniPacket
    //   1125: dup
    //   1126: iconst_1
    //   1127: invokespecial 457	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   1130: astore 15
    //   1132: aload 15
    //   1134: ldc_w 459
    //   1137: invokevirtual 463	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   1140: aload 15
    //   1142: aload_2
    //   1143: invokevirtual 339	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1146: invokevirtual 467	com/qq/jce/wup/UniPacket:decode	([B)V
    //   1149: aload 15
    //   1151: ldc_w 520
    //   1154: new 522	PersonalState/RespGetHotState
    //   1157: dup
    //   1158: invokespecial 523	PersonalState/RespGetHotState:<init>	()V
    //   1161: invokevirtual 476	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1164: checkcast 522	PersonalState/RespGetHotState
    //   1167: astore 15
    //   1169: aload 15
    //   1171: getfield 524	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   1174: getfield 485	PersonalState/BusiRespHead:iReplyCode	I
    //   1177: ifne +399 -> 1576
    //   1180: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1183: ifeq +159 -> 1342
    //   1186: new 501	java/lang/StringBuilder
    //   1189: dup
    //   1190: ldc_w 526
    //   1193: invokespecial 528	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1196: astore 16
    //   1198: aload 16
    //   1200: ldc_w 530
    //   1203: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: astore 17
    //   1208: aload 15
    //   1210: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1213: ifnonnull +102 -> 1315
    //   1216: ldc_w 535
    //   1219: astore_2
    //   1220: aload 17
    //   1222: aload_2
    //   1223: invokevirtual 538	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1226: ldc_w 540
    //   1229: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: pop
    //   1233: aload 15
    //   1235: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1238: ifnull +92 -> 1330
    //   1241: aload 15
    //   1243: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1246: invokevirtual 541	java/util/ArrayList:size	()I
    //   1249: ifle +81 -> 1330
    //   1252: aload 15
    //   1254: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1257: invokevirtual 123	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1260: astore_2
    //   1261: aload_2
    //   1262: invokeinterface 129 1 0
    //   1267: ifeq +63 -> 1330
    //   1270: aload_2
    //   1271: invokeinterface 133 1 0
    //   1276: checkcast 543	PersonalState/HotRishState
    //   1279: astore 17
    //   1281: aload 16
    //   1283: ldc_w 545
    //   1286: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1289: aload 17
    //   1291: getfield 548	PersonalState/HotRishState:iActId	I
    //   1294: invokevirtual 551	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1297: ldc_w 553
    //   1300: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1303: aload 17
    //   1305: getfield 556	PersonalState/HotRishState:iDataId	I
    //   1308: invokevirtual 551	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1311: pop
    //   1312: goto -51 -> 1261
    //   1315: aload 15
    //   1317: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1320: invokevirtual 541	java/util/ArrayList:size	()I
    //   1323: invokestatic 561	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   1326: astore_2
    //   1327: goto -107 -> 1220
    //   1330: ldc_w 286
    //   1333: iconst_2
    //   1334: aload 16
    //   1336: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1339: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1342: new 114	java/util/ArrayList
    //   1345: dup
    //   1346: bipush 6
    //   1348: invokespecial 406	java/util/ArrayList:<init>	(I)V
    //   1351: astore_2
    //   1352: aload 15
    //   1354: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1357: ifnull +208 -> 1565
    //   1360: aload 15
    //   1362: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1365: invokevirtual 541	java/util/ArrayList:size	()I
    //   1368: ifle +197 -> 1565
    //   1371: aload 13
    //   1373: ifnull +82 -> 1455
    //   1376: aload 13
    //   1378: invokevirtual 563	com/tencent/mobileqq/richstatus/StatusManager:a	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1381: astore 16
    //   1383: aload 15
    //   1385: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1388: invokevirtual 541	java/util/ArrayList:size	()I
    //   1391: iconst_1
    //   1392: isub
    //   1393: istore_3
    //   1394: iload_3
    //   1395: iflt +60 -> 1455
    //   1398: aload 15
    //   1400: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1403: iload_3
    //   1404: invokevirtual 566	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1407: checkcast 543	PersonalState/HotRishState
    //   1410: astore 17
    //   1412: aload 17
    //   1414: getfield 548	PersonalState/HotRishState:iActId	I
    //   1417: aload 16
    //   1419: getfield 568	com/tencent/mobileqq/richstatus/RichStatus:b	I
    //   1422: if_icmpne +26 -> 1448
    //   1425: aload 17
    //   1427: getfield 556	PersonalState/HotRishState:iDataId	I
    //   1430: aload 16
    //   1432: getfield 570	com/tencent/mobileqq/richstatus/RichStatus:jdField_c_of_type_Int	I
    //   1435: if_icmpne +13 -> 1448
    //   1438: aload 15
    //   1440: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1443: iload_3
    //   1444: invokevirtual 573	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   1447: pop
    //   1448: iload_3
    //   1449: iconst_1
    //   1450: isub
    //   1451: istore_3
    //   1452: goto -58 -> 1394
    //   1455: iconst_0
    //   1456: istore_3
    //   1457: iload_3
    //   1458: bipush 6
    //   1460: if_icmpge +24 -> 1484
    //   1463: aload_2
    //   1464: aload 15
    //   1466: getfield 533	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   1469: iload_3
    //   1470: invokevirtual 566	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1473: invokevirtual 152	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1476: pop
    //   1477: iload_3
    //   1478: iconst_1
    //   1479: iadd
    //   1480: istore_3
    //   1481: goto -24 -> 1457
    //   1484: new 501	java/lang/StringBuilder
    //   1487: dup
    //   1488: invokespecial 502	java/lang/StringBuilder:<init>	()V
    //   1491: astore 15
    //   1493: aload_2
    //   1494: invokevirtual 123	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1497: astore 16
    //   1499: aload 16
    //   1501: invokeinterface 129 1 0
    //   1506: ifeq +49 -> 1555
    //   1509: aload 16
    //   1511: invokeinterface 133 1 0
    //   1516: checkcast 543	PersonalState/HotRishState
    //   1519: astore 17
    //   1521: aload 15
    //   1523: aload 17
    //   1525: getfield 548	PersonalState/HotRishState:iActId	I
    //   1528: invokevirtual 551	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1531: ldc_w 553
    //   1534: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1537: aload 17
    //   1539: getfield 556	PersonalState/HotRishState:iDataId	I
    //   1542: invokevirtual 551	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1545: ldc_w 575
    //   1548: invokevirtual 508	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1551: pop
    //   1552: goto -53 -> 1499
    //   1555: aload 13
    //   1557: aload 15
    //   1559: invokevirtual 512	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1562: invokevirtual 577	com/tencent/mobileqq/richstatus/StatusManager:a	(Ljava/lang/String;)V
    //   1565: aload 14
    //   1567: ldc 55
    //   1569: aload_2
    //   1570: invokevirtual 396	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   1573: goto -1489 -> 84
    //   1576: invokestatic 284	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1579: ifeq +13 -> 1592
    //   1582: ldc_w 286
    //   1585: iconst_2
    //   1586: ldc_w 579
    //   1589: invokestatic 291	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1592: iconst_0
    //   1593: istore 8
    //   1595: goto -1511 -> 84
    //   1598: iload_3
    //   1599: ifeq -1405 -> 194
    //   1602: iconst_0
    //   1603: istore 8
    //   1605: iload 9
    //   1607: istore 10
    //   1609: iload 8
    //   1611: istore 9
    //   1613: goto -1435 -> 178
    //   1616: iconst_0
    //   1617: istore 9
    //   1619: goto -21 -> 1598
    //   1622: iload_3
    //   1623: iconst_1
    //   1624: iadd
    //   1625: istore_3
    //   1626: goto -1207 -> 419
    //   1629: iconst_0
    //   1630: istore 9
    //   1632: goto -1235 -> 397
    //   1635: goto -1551 -> 84
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1638	0	this	StatusServlet
    //   0	1638	1	paramIntent	Intent
    //   0	1638	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   156	1470	3	i1	int
    //   380	635	4	i2	int
    //   7	199	5	i3	int
    //   401	585	6	i4	int
    //   464	488	7	i5	int
    //   13	1597	8	bool1	boolean
    //   173	1458	9	bool2	boolean
    //   182	1426	10	bool3	boolean
    //   162	433	11	l1	long
    //   27	1529	13	localObject1	Object
    //   42	1524	14	localBundle	android.os.Bundle
    //   318	1240	15	localObject2	Object
    //   446	1064	16	localObject3	Object
    //   1206	332	17	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   99	172	224	java/lang/Exception
    //   178	187	224	java/lang/Exception
    //   208	217	224	java/lang/Exception
    //   252	394	524	java/lang/Exception
    //   397	417	524	java/lang/Exception
    //   425	478	524	java/lang/Exception
    //   488	521	524	java/lang/Exception
    //   552	605	524	java/lang/Exception
    //   609	645	524	java/lang/Exception
    //   645	652	524	java/lang/Exception
    //   655	747	756	java/lang/Exception
    //   777	793	883	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   819	840	1039	java/lang/Exception
    //   844	851	1039	java/lang/Exception
    //   861	876	1039	java/lang/Exception
    //   933	940	1039	java/lang/Exception
    //   954	978	1039	java/lang/Exception
    //   990	998	1039	java/lang/Exception
    //   1001	1019	1039	java/lang/Exception
    //   1028	1036	1039	java/lang/Exception
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    int i1 = 0;
    Object localObject2 = (QQAppInterface)getAppRuntime();
    int i2 = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject1;
    Object localObject3;
    switch (i2)
    {
    default: 
      paramIntent = null;
    case 2: 
    case 1: 
    case 4: 
      for (;;)
      {
        if (paramIntent != null) {
          paramPacket.setSSOCommand(paramIntent);
        }
        return;
        paramPacket.setTimeout(10000L);
        localObject1 = paramIntent.getStringExtra("k_uin");
        if (i2 == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramPacket.putSendData(a(bool, paramIntent.getBooleanExtra("k_sync_ss", false), Long.parseLong((String)localObject1)));
          paramIntent = "OidbSvc.0x515_2";
          break;
        }
        localObject1 = "OidbSvc.0x53f_1";
        localObject2 = paramIntent.getStringExtra("k_uin");
        i1 = paramIntent.getIntExtra("k_end_time", 2147483647);
        i2 = paramIntent.getIntExtra("k_start_time", 0);
        paramPacket.putSendData(a(Long.parseLong((String)localObject2), Integer.valueOf(i2).intValue(), Integer.valueOf(i1).intValue()));
        paramIntent = (Intent)localObject1;
      }
    case 3: 
      localObject1 = new ReqGetSameStateList();
      ((ReqGetSameStateList)localObject1).oHead = new BusiReqHead();
      ((ReqGetSameStateList)localObject1).vCookie = paramIntent.getByteArrayExtra("k_cookie");
      if (((ReqGetSameStateList)localObject1).vCookie == null) {
        ((ReqGetSameStateList)localObject1).vCookie = new byte[0];
      }
      localObject3 = new RichStatus("");
      ((RichStatus)localObject3).jdField_c_of_type_JavaLangString = "foo";
      ((RichStatus)localObject3).b = paramIntent.getIntExtra("k_action", 0);
      ((RichStatus)localObject3).d = "foo";
      ((RichStatus)localObject3).jdField_c_of_type_Int = paramIntent.getIntExtra("k_data", 0);
      ((ReqGetSameStateList)localObject1).oSelfRishState = new stRishState(((RichStatus)localObject3).a(), 0L);
      localObject3 = ((FriendsManager)((QQAppInterface)localObject2).getManager(46)).a(((QQAppInterface)localObject2).a());
      if (localObject3 != null) {
        if (((Card)localObject3).shGender != 0) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        ((ReqGetSameStateList)localObject1).eSelfSex = i1;
        ((ReqGetSameStateList)localObject1).iPageSize = 50;
        ((ReqGetSameStateList)localObject1).oLbsInfo = a((QQAppInterface)localObject2);
        ((ReqGetSameStateList)localObject1).eFetchSex = paramIntent.getIntExtra("k_fetch_sex", -1);
        paramIntent = paramIntent.getStringExtra("k_uin");
        if (!TextUtils.isEmpty(paramIntent)) {}
        try
        {
          ((ReqGetSameStateList)localObject1).lFriendUin = Long.parseLong(paramIntent);
          paramPacket.setServantName("PersonalStateSvc");
          paramPacket.setFuncName("ReqGetSameStateList");
          paramPacket.addRequestPacket("ReqGetSameStateList", (JceStruct)localObject1);
          paramIntent = "PersonalStateSvc.ReqGetSameStateList";
          break;
          if (((Card)localObject3).shGender != 1) {
            break label577;
          }
          i1 = 1;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
      localObject1 = "OidbSvc.0x54f_0";
      localObject2 = paramIntent.getByteArrayExtra("k_status_key");
      i1 = paramIntent.getIntExtra("k_status_flag", 1);
      paramIntent = new ArrayList();
      paramIntent.add(localObject2);
      paramPacket.putSendData(a(paramIntent, (byte)i1));
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "PersonalStateSvc.ReqGetHotState";
      paramIntent = new ReqGetHotState();
      paramIntent.oHead = new BusiReqHead();
      paramPacket.setServantName("PersonalStateSvc");
      paramPacket.setFuncName("ReqGetHotState");
      paramPacket.addRequestPacket("ReqGetHotState", paramIntent);
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("get_hot_rich_status", 2, "StatusServlet.onSend()");
      paramIntent = (Intent)localObject1;
      break;
      label577:
      i1 = 2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */