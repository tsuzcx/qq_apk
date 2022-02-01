package com.tencent.mobileqq.richstatus;

import PersonalState.BusiReqHead;
import PersonalState.ReqGetHotState;
import PersonalState.ReqGetSameStateList;
import PersonalState.stRishState;
import acff;
import ajpf;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import aqgz;
import aqoj;
import com.qq.taf.jce.JceStruct;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.pb.signature.SigActPb.Platform;
import com.tencent.pb.signature.SigActPb.ReqBody;
import com.tencent.pb.signature.SigActPb.RspBody;
import com.tencent.pb.signature.SigActPb.SigauthReq;
import com.tencent.pb.signature.SigActPb.SigauthRsp;
import com.tencent.pb.signature.SigActPb.SigauthRsp.TipsInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
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
  public static void Q(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 2);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.getCurrentAccountUin());
    localNewIntent.putExtra("k_sync_ss", paramBoolean);
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  static PersonalState.LBSInfo a(QQAppInterface paramQQAppInterface)
  {
    SosoInterface.aj(60000L, StatusServlet.class.getSimpleName());
    Object localObject1 = ajpf.a();
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
  
  private void a(Bundle paramBundle, SigActPb.RspBody paramRspBody, String paramString)
    throws InvalidProtocolBufferMicroException
  {
    if (paramRspBody.auth_rsp.tips_info.has())
    {
      SigActPb.SigauthRsp.TipsInfo localTipsInfo = new SigActPb.SigauthRsp.TipsInfo();
      localTipsInfo.mergeFrom(((SigActPb.SigauthRsp.TipsInfo)paramRspBody.auth_rsp.tips_info.get()).toByteArray());
      boolean bool = localTipsInfo.valid.get();
      if (QLog.isColorLevel()) {
        QLog.d("Signature", 2, "CMD_RICH_STATUS_AUTH ret = " + localTipsInfo.ret.get() + " valid = " + bool);
      }
      paramBundle.putBoolean("valid", bool);
      if (bool)
      {
        paramBundle.putInt("ret", localTipsInfo.ret.get());
        paramBundle.putInt("type", localTipsInfo.type.get());
        paramBundle.putString("titleWording", localTipsInfo.title_wording.get());
        paramBundle.putString("wording", localTipsInfo.wording.get());
        paramBundle.putString("rightBtnWording", localTipsInfo.right_btn_wording.get());
        paramBundle.putString("leftBtnWording", localTipsInfo.left_btn_wording.get());
        paramBundle.putString("vipType", localTipsInfo.vip_type.get());
        paramBundle.putInt("vipMonth", localTipsInfo.vip_month.get());
        paramBundle.putString("url", localTipsInfo.url.get());
      }
      if (QLog.isColorLevel()) {
        QLog.i("StatusServlet", 2, "CMD_RICH_STATUS_AUTH parseSigAuthTipsInfo " + paramString + " data=" + paramBundle);
      }
    }
  }
  
  private byte[] a(List<byte[]> paramList, byte paramByte)
  {
    Object localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1359);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    Object localObject2 = paramList.iterator();
    int i = 7;
    byte[] arrayOfByte;
    if (((Iterator)localObject2).hasNext())
    {
      arrayOfByte = (byte[])((Iterator)localObject2).next();
      if (arrayOfByte == null) {
        break label227;
      }
      i = arrayOfByte.length + (i + 2) + 4;
    }
    label227:
    for (;;)
    {
      break;
      localObject2 = ByteBuffer.allocate(i);
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
  
  public static void dM(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.shuo", 2, "getSyncShuoShuo");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), StatusServlet.class);
    localNewIntent.putExtra("k_cmd", 1);
    localNewIntent.putExtra("k_uin", paramQQAppInterface.getCurrentAccountUin());
    paramQQAppInterface.startServlet(localNewIntent);
  }
  
  private byte[] z(byte[] paramArrayOfByte)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1295);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(29);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfByte.length + 2);
    localByteBuffer.put((byte)0).put((byte)paramArrayOfByte.length).put(paramArrayOfByte);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfByte = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localObject = ByteBuffer.allocate(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).putInt(paramArrayOfByte.length + 4);
    ((ByteBuffer)localObject).put(paramArrayOfByte);
    return ((ByteBuffer)localObject).array();
  }
  
  byte[] a(long paramLong, int paramInt1, int paramInt2)
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1343);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(27);
    localByteBuffer.putLong(paramLong).put((byte)2).putInt(paramInt1).putInt(paramInt2).putInt(0).putInt(0).putShort((short)6);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  byte[] a(boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    int j = 1;
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1301);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(2);
    ByteBuffer localByteBuffer1 = ByteBuffer.allocate(11);
    ByteBuffer localByteBuffer2 = localByteBuffer1.put((byte)2).putInt(293615363);
    if (paramBoolean1)
    {
      i = 1;
      localByteBuffer2.put((byte)i);
      if (!paramBoolean2) {
        break label155;
      }
    }
    label155:
    for (int i = j;; i = 0)
    {
      localByteBuffer1.put((byte)i).putInt((int)paramLong);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer1.array()));
      localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
      localByteBuffer1 = ByteBuffer.allocate(localObject.length + 4);
      localByteBuffer1.putInt(localObject.length + 4);
      localByteBuffer1.put((byte[])localObject);
      return localByteBuffer1.array();
      i = 0;
      break;
    }
  }
  
  /* Error */
  public void onReceive(Intent paramIntent, com.tencent.qphone.base.remote.FromServiceMsg paramFromServiceMsg)
  {
    // Byte code:
    //   0: aload_1
    //   1: ldc 27
    //   3: iconst_0
    //   4: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   7: istore 4
    //   9: aload_2
    //   10: invokevirtual 410	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: istore 8
    //   15: new 247	android/os/Bundle
    //   18: dup
    //   19: invokespecial 411	android/os/Bundle:<init>	()V
    //   22: astore 14
    //   24: aload_0
    //   25: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   28: bipush 15
    //   30: invokevirtual 421	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   33: checkcast 423	amhj
    //   36: astore 13
    //   38: aload 13
    //   40: ifnonnull +1878 -> 1918
    //   43: iload 8
    //   45: istore 9
    //   47: iload 4
    //   49: bipush 7
    //   51: if_icmpne +152 -> 203
    //   54: iload 8
    //   56: ifeq +706 -> 762
    //   59: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   62: dup
    //   63: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   66: astore 13
    //   68: aload 13
    //   70: aload_2
    //   71: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   74: invokestatic 430	aqnv:J	([B)[B
    //   77: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   80: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   83: astore 13
    //   85: iload 8
    //   87: istore 9
    //   89: aload 13
    //   91: ifnull +90 -> 181
    //   94: iload 8
    //   96: istore 9
    //   98: aload 13
    //   100: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   103: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   106: ifeq +75 -> 181
    //   109: aload 13
    //   111: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: istore_3
    //   118: iload_3
    //   119: ifne +560 -> 679
    //   122: aload 13
    //   124: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   127: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   130: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   133: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   136: astore 13
    //   138: aload 13
    //   140: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   143: istore_3
    //   144: iload_3
    //   145: ifne +487 -> 632
    //   148: aload 14
    //   150: ldc_w 447
    //   153: aload 13
    //   155: invokevirtual 367	java/nio/ByteBuffer:array	()[B
    //   158: invokevirtual 451	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   161: aload 14
    //   163: ldc_w 453
    //   166: aload_1
    //   167: ldc_w 453
    //   170: iconst_0
    //   171: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   174: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   177: iload 8
    //   179: istore 9
    //   181: iload 9
    //   183: istore 8
    //   185: aload_0
    //   186: aload_1
    //   187: iload 4
    //   189: iload 8
    //   191: aload 14
    //   193: ldc_w 455
    //   196: invokevirtual 459	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   199: iload 8
    //   201: istore 9
    //   203: iload 4
    //   205: bipush 9
    //   207: if_icmpne +4277 -> 4484
    //   210: iload 9
    //   212: ifeq +983 -> 1195
    //   215: aload_2
    //   216: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   219: arraylength
    //   220: iconst_4
    //   221: isub
    //   222: istore_3
    //   223: iload_3
    //   224: newarray byte
    //   226: astore 15
    //   228: aload 15
    //   230: iconst_0
    //   231: aload_2
    //   232: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   235: iconst_4
    //   236: iload_3
    //   237: invokestatic 465	aqoj:copyData	([BI[BII)V
    //   240: new 168	com/tencent/pb/signature/SigActPb$RspBody
    //   243: dup
    //   244: invokespecial 466	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   247: astore 13
    //   249: aload 13
    //   251: aload 15
    //   253: invokevirtual 467	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   256: pop
    //   257: aload 13
    //   259: getfield 468	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   262: invokevirtual 229	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   265: istore_3
    //   266: iload_3
    //   267: ifne +583 -> 850
    //   270: aload 13
    //   272: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   275: getfield 471	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   278: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   281: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   284: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   287: astore 13
    //   289: aload 13
    //   291: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   294: istore_3
    //   295: iload_3
    //   296: ifne +494 -> 790
    //   299: aload 14
    //   301: ldc_w 447
    //   304: aload 13
    //   306: invokevirtual 367	java/nio/ByteBuffer:array	()[B
    //   309: invokevirtual 451	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   312: aload 14
    //   314: ldc_w 453
    //   317: aload_1
    //   318: ldc_w 453
    //   321: iconst_0
    //   322: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   325: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   328: iload 9
    //   330: istore 8
    //   332: iload 8
    //   334: istore 9
    //   336: aload_0
    //   337: aload_1
    //   338: iload 4
    //   340: iload 9
    //   342: aload 14
    //   344: ldc_w 455
    //   347: invokevirtual 459	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   350: iload 9
    //   352: istore 8
    //   354: iload 4
    //   356: iconst_4
    //   357: if_icmpne +981 -> 1338
    //   360: new 6	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   363: dup
    //   364: invokespecial 472	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   367: astore 13
    //   369: aload 13
    //   371: aload_1
    //   372: ldc_w 474
    //   375: iconst_0
    //   376: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   379: putfield 477	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   382: aload 13
    //   384: aload_1
    //   385: ldc_w 479
    //   388: ldc_w 480
    //   391: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   394: putfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   397: aload 13
    //   399: iconst_0
    //   400: putfield 487	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   403: aload 14
    //   405: ldc_w 489
    //   408: aload 13
    //   410: invokevirtual 493	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   413: aload_2
    //   414: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   417: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   420: astore 15
    //   422: aload 15
    //   424: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   427: iconst_4
    //   428: isub
    //   429: newarray byte
    //   431: astore 16
    //   433: aload 15
    //   435: aload 16
    //   437: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   440: pop
    //   441: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   444: dup
    //   445: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   448: aload 16
    //   450: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   453: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   456: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   459: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   462: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   465: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   468: astore 16
    //   470: aload 16
    //   472: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   475: pop
    //   476: aload 16
    //   478: invokevirtual 502	java/nio/ByteBuffer:getLong	()J
    //   481: lstore 11
    //   483: aload 16
    //   485: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   488: pop
    //   489: aload 16
    //   491: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   494: pop
    //   495: aload 16
    //   497: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   500: istore 5
    //   502: aload 16
    //   504: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   507: pop
    //   508: aload 16
    //   510: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   513: ifeq +708 -> 1221
    //   516: iconst_1
    //   517: istore 8
    //   519: aload 16
    //   521: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   524: istore 6
    //   526: aload 13
    //   528: new 97	java/util/ArrayList
    //   531: dup
    //   532: iload 6
    //   534: invokespecial 508	java/util/ArrayList:<init>	(I)V
    //   537: putfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   540: aload_0
    //   541: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   544: checkcast 18	com/tencent/mobileqq/app/QQAppInterface
    //   547: astore 15
    //   549: iconst_0
    //   550: istore_3
    //   551: iload_3
    //   552: iload 6
    //   554: if_icmpge +1003 -> 1557
    //   557: aload 16
    //   559: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   562: newarray byte
    //   564: astore 17
    //   566: aload 16
    //   568: aload 17
    //   570: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   573: pop
    //   574: aload 16
    //   576: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   579: newarray byte
    //   581: astore 18
    //   583: aload 16
    //   585: aload 18
    //   587: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   590: pop
    //   591: aload 16
    //   593: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   596: pop
    //   597: aload 16
    //   599: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   602: istore 7
    //   604: aload 16
    //   606: aload 16
    //   608: invokevirtual 514	java/nio/ByteBuffer:position	()I
    //   611: bipush 8
    //   613: iadd
    //   614: invokevirtual 517	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   617: pop
    //   618: iload 7
    //   620: iload 5
    //   622: if_icmple +605 -> 1227
    //   625: iload_3
    //   626: iconst_1
    //   627: iadd
    //   628: istore_3
    //   629: goto -78 -> 551
    //   632: aconst_null
    //   633: ldc_w 519
    //   636: ldc_w 521
    //   639: new 213	java/lang/StringBuilder
    //   642: dup
    //   643: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   646: ldc_w 523
    //   649: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   652: iload_3
    //   653: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   656: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: aconst_null
    //   660: fconst_0
    //   661: invokestatic 528	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   664: ldc_w 519
    //   667: ldc_w 521
    //   670: invokestatic 533	aqrh:is	(Ljava/lang/String;Ljava/lang/String;)V
    //   673: iconst_0
    //   674: istore 8
    //   676: goto -499 -> 177
    //   679: iconst_0
    //   680: istore 9
    //   682: aconst_null
    //   683: ldc_w 519
    //   686: ldc_w 535
    //   689: new 213	java/lang/StringBuilder
    //   692: dup
    //   693: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   696: ldc_w 523
    //   699: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   702: iload_3
    //   703: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   706: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: aconst_null
    //   710: fconst_0
    //   711: invokestatic 528	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   714: goto -533 -> 181
    //   717: astore 13
    //   719: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   722: ifeq +34 -> 756
    //   725: ldc_w 537
    //   728: iconst_2
    //   729: new 213	java/lang/StringBuilder
    //   732: dup
    //   733: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   736: ldc_w 539
    //   739: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: aload 13
    //   744: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   747: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   750: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   753: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   756: iconst_0
    //   757: istore 9
    //   759: goto -578 -> 181
    //   762: aconst_null
    //   763: ldc_w 519
    //   766: ldc_w 544
    //   769: aload_2
    //   770: invokevirtual 547	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   773: aconst_null
    //   774: fconst_0
    //   775: invokestatic 528	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   778: ldc_w 519
    //   781: ldc_w 544
    //   784: invokestatic 533	aqrh:is	(Ljava/lang/String;Ljava/lang/String;)V
    //   787: goto -602 -> 185
    //   790: iconst_0
    //   791: istore 8
    //   793: aload 14
    //   795: ldc_w 549
    //   798: iload_3
    //   799: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   802: goto -470 -> 332
    //   805: astore 13
    //   807: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   810: ifeq +34 -> 844
    //   813: ldc_w 537
    //   816: iconst_2
    //   817: new 213	java/lang/StringBuilder
    //   820: dup
    //   821: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   824: ldc_w 539
    //   827: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   830: aload 13
    //   832: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   835: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   841: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   844: iconst_0
    //   845: istore 9
    //   847: goto -511 -> 336
    //   850: aconst_null
    //   851: ldc_w 552
    //   854: ldc_w 554
    //   857: new 213	java/lang/StringBuilder
    //   860: dup
    //   861: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   864: ldc_w 523
    //   867: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   870: iload_3
    //   871: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   874: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   877: aconst_null
    //   878: fconst_0
    //   879: invokestatic 528	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   882: ldc_w 552
    //   885: iload_3
    //   886: invokestatic 557	aqrh:gt	(Ljava/lang/String;I)V
    //   889: aload 14
    //   891: ldc_w 559
    //   894: iload_3
    //   895: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   898: iload_3
    //   899: ldc_w 560
    //   902: if_icmpne +22 -> 924
    //   905: aload 14
    //   907: ldc_w 562
    //   910: aload 13
    //   912: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   915: getfield 563	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   918: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   921: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   924: aload 13
    //   926: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   929: getfield 566	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   932: invokevirtual 567	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   935: ifeq +22 -> 957
    //   938: aload 14
    //   940: ldc_w 569
    //   943: aload 13
    //   945: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   948: getfield 566	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   951: invokevirtual 229	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   954: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   957: aload 13
    //   959: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   962: getfield 178	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   965: invokevirtual 183	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:has	()Z
    //   968: ifeq +221 -> 1189
    //   971: new 180	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   974: dup
    //   975: invokespecial 184	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:<init>	()V
    //   978: astore 15
    //   980: aload 15
    //   982: aload 13
    //   984: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   987: getfield 178	com/tencent/pb/signature/SigActPb$SigauthRsp:tips_info	Lcom/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo;
    //   990: invokevirtual 188	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   993: checkcast 180	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo
    //   996: invokevirtual 192	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:toByteArray	()[B
    //   999: invokevirtual 196	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1002: pop
    //   1003: aload 15
    //   1005: getfield 200	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:valid	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   1008: invokevirtual 204	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   1011: istore 8
    //   1013: aload 14
    //   1015: ldc 245
    //   1017: iload 8
    //   1019: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1022: iload 8
    //   1024: ifeq +131 -> 1155
    //   1027: aload 14
    //   1029: ldc_w 258
    //   1032: aload 15
    //   1034: getfield 261	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1037: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1040: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1043: aload 14
    //   1045: ldc_w 266
    //   1048: aload 15
    //   1050: getfield 270	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:title_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1053: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1056: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1059: aload 14
    //   1061: ldc_w 280
    //   1064: aload 15
    //   1066: getfield 282	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1069: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1072: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1075: aload 14
    //   1077: ldc_w 284
    //   1080: aload 15
    //   1082: getfield 287	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:right_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1085: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1088: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1091: aload 14
    //   1093: ldc_w 289
    //   1096: aload 15
    //   1098: getfield 292	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:left_btn_wording	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1101: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1104: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1107: aload 14
    //   1109: ldc_w 294
    //   1112: aload 15
    //   1114: getfield 297	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_type	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1117: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1120: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1123: aload 14
    //   1125: ldc_w 299
    //   1128: aload 15
    //   1130: getfield 302	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:vip_month	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1133: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1136: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   1139: aload 14
    //   1141: ldc_w 304
    //   1144: aload 15
    //   1146: getfield 306	com/tencent/pb/signature/SigActPb$SigauthRsp$TipsInfo:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   1149: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   1152: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   1155: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1158: ifeq +31 -> 1189
    //   1161: ldc_w 308
    //   1164: iconst_2
    //   1165: new 213	java/lang/StringBuilder
    //   1168: dup
    //   1169: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1172: ldc_w 571
    //   1175: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1178: aload 14
    //   1180: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   1183: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1186: invokestatic 318	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1189: iconst_0
    //   1190: istore 8
    //   1192: goto -860 -> 332
    //   1195: aconst_null
    //   1196: ldc_w 552
    //   1199: ldc_w 573
    //   1202: aload_2
    //   1203: invokevirtual 547	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1206: aconst_null
    //   1207: fconst_0
    //   1208: invokestatic 528	aqri:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1211: ldc_w 552
    //   1214: iconst_m1
    //   1215: invokestatic 557	aqrh:gt	(Ljava/lang/String;I)V
    //   1218: goto -882 -> 336
    //   1221: iconst_0
    //   1222: istore 8
    //   1224: goto -705 -> 519
    //   1227: aload 18
    //   1229: invokestatic 579	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1232: astore 18
    //   1234: aload 18
    //   1236: iload 7
    //   1238: i2l
    //   1239: putfield 582	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   1242: aload 18
    //   1244: aload 17
    //   1246: putfield 585	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1249: aload 18
    //   1251: getfield 585	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1254: ifnull +20 -> 1274
    //   1257: aload 18
    //   1259: new 587	java/lang/String
    //   1262: dup
    //   1263: aload 18
    //   1265: getfield 585	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   1268: invokespecial 590	java/lang/String:<init>	([B)V
    //   1271: putfield 594	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1274: aload 13
    //   1276: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1279: aload 18
    //   1281: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1284: pop
    //   1285: goto -660 -> 625
    //   1288: astore 13
    //   1290: iconst_0
    //   1291: istore 9
    //   1293: aload 13
    //   1295: invokevirtual 597	java/lang/Exception:printStackTrace	()V
    //   1298: iload 9
    //   1300: istore 8
    //   1302: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1305: ifeq +19 -> 1324
    //   1308: ldc_w 537
    //   1311: iconst_2
    //   1312: aload 13
    //   1314: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1317: invokestatic 600	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1320: iload 9
    //   1322: istore 8
    //   1324: aload_0
    //   1325: aload_1
    //   1326: iload 4
    //   1328: iload 8
    //   1330: aload 14
    //   1332: ldc_w 455
    //   1335: invokevirtual 459	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1338: iload 4
    //   1340: bipush 8
    //   1342: if_icmpne +3139 -> 4481
    //   1345: iload 8
    //   1347: ifeq +3131 -> 4478
    //   1350: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1353: dup
    //   1354: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1357: astore 13
    //   1359: aload 13
    //   1361: aload_2
    //   1362: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1365: invokestatic 430	aqnv:J	([B)[B
    //   1368: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1371: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1374: astore 13
    //   1376: aload 13
    //   1378: ifnull +3097 -> 4475
    //   1381: aload 13
    //   1383: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1386: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   1389: ifeq +3086 -> 4475
    //   1392: aload 13
    //   1394: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1397: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1400: ifne +395 -> 1795
    //   1403: aload 13
    //   1405: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1408: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1411: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1414: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1417: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   1420: istore_3
    //   1421: iload_3
    //   1422: ifne +367 -> 1789
    //   1425: iconst_1
    //   1426: istore 8
    //   1428: aload_0
    //   1429: aload_1
    //   1430: iload 4
    //   1432: iload 8
    //   1434: aload 14
    //   1436: ldc_w 455
    //   1439: invokevirtual 459	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1442: iload 4
    //   1444: iconst_1
    //   1445: if_icmpeq +9 -> 1454
    //   1448: iload 4
    //   1450: iconst_2
    //   1451: if_icmpne +105 -> 1556
    //   1454: aload_2
    //   1455: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1458: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1461: astore_2
    //   1462: aload_2
    //   1463: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   1466: iconst_4
    //   1467: isub
    //   1468: newarray byte
    //   1470: astore 13
    //   1472: aload_2
    //   1473: aload 13
    //   1475: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   1478: pop
    //   1479: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1482: dup
    //   1483: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   1486: aload 13
    //   1488: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   1491: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   1494: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   1497: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   1500: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   1503: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1506: astore_2
    //   1507: aload_2
    //   1508: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   1511: istore_3
    //   1512: aload_2
    //   1513: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   1516: i2l
    //   1517: lstore 11
    //   1519: aload_2
    //   1520: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   1523: iconst_1
    //   1524: if_icmpne +322 -> 1846
    //   1527: iconst_1
    //   1528: istore 9
    //   1530: goto +2957 -> 4487
    //   1533: aload 14
    //   1535: ldc 42
    //   1537: iload 10
    //   1539: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   1542: aload_0
    //   1543: aload_1
    //   1544: iload 4
    //   1546: iload 9
    //   1548: aload 14
    //   1550: ldc_w 455
    //   1553: invokevirtual 459	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1556: return
    //   1557: aload 13
    //   1559: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1562: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   1565: ifeq +88 -> 1653
    //   1568: aload 13
    //   1570: getfield 477	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   1573: ifne +80 -> 1653
    //   1576: aload 13
    //   1578: getfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   1581: ldc_w 480
    //   1584: if_icmpne +69 -> 1653
    //   1587: aload_0
    //   1588: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   1591: bipush 51
    //   1593: invokevirtual 421	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   1596: checkcast 605	acff
    //   1599: lload 11
    //   1601: invokestatic 609	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1604: invokevirtual 613	acff:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   1607: astore 16
    //   1609: aload 16
    //   1611: ifnull +42 -> 1653
    //   1614: aload 16
    //   1616: invokevirtual 619	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1619: ifnull +34 -> 1653
    //   1622: aload 16
    //   1624: invokevirtual 619	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1627: invokevirtual 620	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   1630: ifne +23 -> 1653
    //   1633: aload 13
    //   1635: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1638: aload 16
    //   1640: invokevirtual 619	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   1643: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   1646: pop
    //   1647: aload 13
    //   1649: iconst_1
    //   1650: putfield 487	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   1653: aload 15
    //   1655: bipush 41
    //   1657: invokevirtual 624	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   1660: checkcast 626	com/tencent/mobileqq/app/SignatureHandler
    //   1663: astore 16
    //   1665: aload 13
    //   1667: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1670: invokevirtual 106	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   1673: astore 17
    //   1675: aload 17
    //   1677: invokeinterface 112 1 0
    //   1682: ifeq +42 -> 1724
    //   1685: aload 17
    //   1687: invokeinterface 116 1 0
    //   1692: checkcast 575	com/tencent/mobileqq/richstatus/RichStatus
    //   1695: astore 18
    //   1697: aload 16
    //   1699: ifnull -24 -> 1675
    //   1702: aload 16
    //   1704: lload 11
    //   1706: invokestatic 609	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1709: aload 18
    //   1711: getfield 594	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   1714: sipush 255
    //   1717: iconst_1
    //   1718: invokevirtual 630	com/tencent/mobileqq/app/SignatureHandler:c	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   1721: goto -46 -> 1675
    //   1724: aload 13
    //   1726: iload 8
    //   1728: putfield 633	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   1731: aload 15
    //   1733: bipush 58
    //   1735: invokevirtual 634	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1738: checkcast 636	com/tencent/mobileqq/app/SignatureManager
    //   1741: astore 16
    //   1743: iload 9
    //   1745: istore 8
    //   1747: aload 16
    //   1749: ifnull -425 -> 1324
    //   1752: iload 9
    //   1754: istore 8
    //   1756: aload 15
    //   1758: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1761: lload 11
    //   1763: invokestatic 640	java/lang/Long:toString	(J)Ljava/lang/String;
    //   1766: invokevirtual 643	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1769: ifeq -445 -> 1324
    //   1772: aload 16
    //   1774: aload 13
    //   1776: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   1779: invokevirtual 647	com/tencent/mobileqq/app/SignatureManager:jh	(Ljava/util/List;)V
    //   1782: iload 9
    //   1784: istore 8
    //   1786: goto -462 -> 1324
    //   1789: iconst_0
    //   1790: istore 8
    //   1792: goto -364 -> 1428
    //   1795: iconst_0
    //   1796: istore 8
    //   1798: goto -370 -> 1428
    //   1801: astore 13
    //   1803: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1806: ifeq +34 -> 1840
    //   1809: ldc_w 537
    //   1812: iconst_2
    //   1813: new 213	java/lang/StringBuilder
    //   1816: dup
    //   1817: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   1820: ldc_w 539
    //   1823: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1826: aload 13
    //   1828: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   1831: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1834: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1837: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1840: iconst_0
    //   1841: istore 8
    //   1843: goto -415 -> 1428
    //   1846: iconst_0
    //   1847: istore 9
    //   1849: goto +2638 -> 4487
    //   1852: iload 9
    //   1854: istore 10
    //   1856: iload 8
    //   1858: istore 9
    //   1860: iload 4
    //   1862: iconst_2
    //   1863: if_icmpne -330 -> 1533
    //   1866: aload_1
    //   1867: ldc 42
    //   1869: iconst_0
    //   1870: invokevirtual 651	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   1873: istore 10
    //   1875: iload 8
    //   1877: istore 9
    //   1879: goto -346 -> 1533
    //   1882: astore_2
    //   1883: iconst_0
    //   1884: istore 8
    //   1886: aload_2
    //   1887: invokevirtual 597	java/lang/Exception:printStackTrace	()V
    //   1890: iload 8
    //   1892: istore 9
    //   1894: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1897: ifeq -355 -> 1542
    //   1900: ldc_w 537
    //   1903: iconst_2
    //   1904: aload_2
    //   1905: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1908: invokestatic 600	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   1911: iload 8
    //   1913: istore 9
    //   1915: goto -373 -> 1542
    //   1918: iload 4
    //   1920: tableswitch	default:+52 -> 1972, 1:+67->1987, 2:+67->1987, 3:+790->2710, 4:+220->2140, 5:+903->2823, 6:+1319->3239, 7:+1796->3716, 8:+2403->4323, 9:+1973->3893
    //   1973: aload_1
    //   1974: iload 4
    //   1976: iload 8
    //   1978: aload 14
    //   1980: ldc_w 455
    //   1983: invokevirtual 459	com/tencent/mobileqq/richstatus/StatusServlet:notifyObserver	(Landroid/content/Intent;IZLandroid/os/Bundle;Ljava/lang/Class;)V
    //   1986: return
    //   1987: aload_2
    //   1988: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   1991: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   1994: astore_2
    //   1995: aload_2
    //   1996: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   1999: iconst_4
    //   2000: isub
    //   2001: newarray byte
    //   2003: astore 13
    //   2005: aload_2
    //   2006: aload 13
    //   2008: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2011: pop
    //   2012: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2015: dup
    //   2016: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2019: aload 13
    //   2021: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2024: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2027: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2030: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2033: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2036: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2039: astore_2
    //   2040: aload_2
    //   2041: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   2044: istore_3
    //   2045: aload_2
    //   2046: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2049: i2l
    //   2050: lstore 11
    //   2052: aload_2
    //   2053: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   2056: iconst_1
    //   2057: if_icmpne +2466 -> 4523
    //   2060: iconst_1
    //   2061: istore 9
    //   2063: goto +2442 -> 4505
    //   2066: aload 14
    //   2068: ldc 42
    //   2070: iload 10
    //   2072: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2075: iload 9
    //   2077: istore 8
    //   2079: goto -107 -> 1972
    //   2082: iload 9
    //   2084: istore 10
    //   2086: iload 8
    //   2088: istore 9
    //   2090: iload 4
    //   2092: iconst_2
    //   2093: if_icmpne -27 -> 2066
    //   2096: aload_1
    //   2097: ldc 42
    //   2099: iconst_0
    //   2100: invokevirtual 651	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2103: istore 10
    //   2105: iload 8
    //   2107: istore 9
    //   2109: goto -43 -> 2066
    //   2112: astore_2
    //   2113: aload_2
    //   2114: invokevirtual 597	java/lang/Exception:printStackTrace	()V
    //   2117: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2120: ifeq +14 -> 2134
    //   2123: ldc_w 537
    //   2126: iconst_2
    //   2127: aload_2
    //   2128: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2131: invokestatic 600	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2134: iconst_0
    //   2135: istore 8
    //   2137: goto -165 -> 1972
    //   2140: new 6	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory
    //   2143: dup
    //   2144: invokespecial 472	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:<init>	()V
    //   2147: astore 13
    //   2149: aload 13
    //   2151: aload_1
    //   2152: ldc_w 474
    //   2155: iconst_0
    //   2156: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2159: putfield 477	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2162: aload 13
    //   2164: aload_1
    //   2165: ldc_w 479
    //   2168: ldc_w 480
    //   2171: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2174: putfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2177: aload 13
    //   2179: iconst_0
    //   2180: putfield 487	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2183: aload 14
    //   2185: ldc_w 489
    //   2188: aload 13
    //   2190: invokevirtual 493	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2193: aload_2
    //   2194: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2197: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2200: astore_2
    //   2201: aload_2
    //   2202: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2205: iconst_4
    //   2206: isub
    //   2207: newarray byte
    //   2209: astore 15
    //   2211: aload_2
    //   2212: aload 15
    //   2214: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2217: pop
    //   2218: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2221: dup
    //   2222: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2225: aload 15
    //   2227: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2230: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2233: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2236: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2239: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2242: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2245: astore 15
    //   2247: aload 15
    //   2249: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   2252: pop
    //   2253: aload 15
    //   2255: invokevirtual 502	java/nio/ByteBuffer:getLong	()J
    //   2258: lstore 11
    //   2260: aload 15
    //   2262: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   2265: pop
    //   2266: aload 15
    //   2268: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2271: pop
    //   2272: aload 15
    //   2274: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2277: istore 5
    //   2279: aload 15
    //   2281: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2284: pop
    //   2285: aload 15
    //   2287: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   2290: ifeq +2246 -> 4536
    //   2293: iconst_1
    //   2294: istore 9
    //   2296: aload 15
    //   2298: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   2301: istore 6
    //   2303: aload 13
    //   2305: new 97	java/util/ArrayList
    //   2308: dup
    //   2309: iload 6
    //   2311: invokespecial 508	java/util/ArrayList:<init>	(I)V
    //   2314: putfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2317: aload_0
    //   2318: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2321: checkcast 18	com/tencent/mobileqq/app/QQAppInterface
    //   2324: astore_2
    //   2325: iconst_0
    //   2326: istore_3
    //   2327: iload_3
    //   2328: iload 6
    //   2330: if_icmpge +163 -> 2493
    //   2333: aload 15
    //   2335: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   2338: newarray byte
    //   2340: astore 16
    //   2342: aload 15
    //   2344: aload 16
    //   2346: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2349: pop
    //   2350: aload 15
    //   2352: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   2355: newarray byte
    //   2357: astore 17
    //   2359: aload 15
    //   2361: aload 17
    //   2363: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2366: pop
    //   2367: aload 15
    //   2369: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2372: pop
    //   2373: aload 15
    //   2375: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   2378: istore 7
    //   2380: aload 15
    //   2382: aload 15
    //   2384: invokevirtual 514	java/nio/ByteBuffer:position	()I
    //   2387: bipush 8
    //   2389: iadd
    //   2390: invokevirtual 517	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   2393: pop
    //   2394: iload 7
    //   2396: iload 5
    //   2398: if_icmple +6 -> 2404
    //   2401: goto +2128 -> 4529
    //   2404: aload 17
    //   2406: invokestatic 579	com/tencent/mobileqq/richstatus/RichStatus:parseStatus	([B)Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2409: astore 17
    //   2411: aload 17
    //   2413: iload 7
    //   2415: i2l
    //   2416: putfield 582	com/tencent/mobileqq/richstatus/RichStatus:time	J
    //   2419: aload 17
    //   2421: aload 16
    //   2423: putfield 585	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2426: aload 17
    //   2428: getfield 585	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2431: ifnull +20 -> 2451
    //   2434: aload 17
    //   2436: new 587	java/lang/String
    //   2439: dup
    //   2440: aload 17
    //   2442: getfield 585	com/tencent/mobileqq/richstatus/RichStatus:key	[B
    //   2445: invokespecial 590	java/lang/String:<init>	([B)V
    //   2448: putfield 594	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2451: aload 13
    //   2453: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2456: aload 17
    //   2458: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2461: pop
    //   2462: goto +2067 -> 4529
    //   2465: astore_2
    //   2466: aload_2
    //   2467: invokevirtual 597	java/lang/Exception:printStackTrace	()V
    //   2470: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2473: ifeq +14 -> 2487
    //   2476: ldc_w 537
    //   2479: iconst_2
    //   2480: aload_2
    //   2481: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   2484: invokestatic 600	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   2487: iconst_0
    //   2488: istore 8
    //   2490: goto -518 -> 1972
    //   2493: aload 13
    //   2495: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2498: invokevirtual 603	java/util/ArrayList:isEmpty	()Z
    //   2501: ifeq +88 -> 2589
    //   2504: aload 13
    //   2506: getfield 477	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:startTime	I
    //   2509: ifne +80 -> 2589
    //   2512: aload 13
    //   2514: getfield 483	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:endTime	I
    //   2517: ldc_w 480
    //   2520: if_icmpne +69 -> 2589
    //   2523: aload_0
    //   2524: invokevirtual 415	com/tencent/mobileqq/richstatus/StatusServlet:getAppRuntime	()Lmqq/app/AppRuntime;
    //   2527: bipush 51
    //   2529: invokevirtual 421	mqq/app/AppRuntime:getManager	(I)Lmqq/manager/Manager;
    //   2532: checkcast 605	acff
    //   2535: lload 11
    //   2537: invokestatic 609	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2540: invokevirtual 613	acff:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   2543: astore 15
    //   2545: aload 15
    //   2547: ifnull +42 -> 2589
    //   2550: aload 15
    //   2552: invokevirtual 619	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2555: ifnull +34 -> 2589
    //   2558: aload 15
    //   2560: invokevirtual 619	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2563: invokevirtual 620	com/tencent/mobileqq/richstatus/RichStatus:isEmpty	()Z
    //   2566: ifne +23 -> 2589
    //   2569: aload 13
    //   2571: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2574: aload 15
    //   2576: invokevirtual 619	com/tencent/mobileqq/data/Card:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   2579: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2582: pop
    //   2583: aload 13
    //   2585: iconst_1
    //   2586: putfield 487	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:isAddFromCard	Z
    //   2589: aload_2
    //   2590: bipush 41
    //   2592: invokevirtual 624	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Laccg;
    //   2595: checkcast 626	com/tencent/mobileqq/app/SignatureHandler
    //   2598: astore 15
    //   2600: aload 13
    //   2602: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2605: invokevirtual 106	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   2608: astore 16
    //   2610: aload 16
    //   2612: invokeinterface 112 1 0
    //   2617: ifeq +42 -> 2659
    //   2620: aload 16
    //   2622: invokeinterface 116 1 0
    //   2627: checkcast 575	com/tencent/mobileqq/richstatus/RichStatus
    //   2630: astore 17
    //   2632: aload 15
    //   2634: ifnull -24 -> 2610
    //   2637: aload 15
    //   2639: lload 11
    //   2641: invokestatic 609	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2644: aload 17
    //   2646: getfield 594	com/tencent/mobileqq/richstatus/RichStatus:feedsId	Ljava/lang/String;
    //   2649: sipush 255
    //   2652: iconst_1
    //   2653: invokevirtual 630	com/tencent/mobileqq/app/SignatureHandler:c	(Ljava/lang/String;Ljava/lang/String;IZ)V
    //   2656: goto -46 -> 2610
    //   2659: aload 13
    //   2661: iload 9
    //   2663: putfield 633	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:over	Z
    //   2666: aload_2
    //   2667: bipush 58
    //   2669: invokevirtual 634	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   2672: checkcast 636	com/tencent/mobileqq/app/SignatureManager
    //   2675: astore 15
    //   2677: aload 15
    //   2679: ifnull +28 -> 2707
    //   2682: aload_2
    //   2683: invokevirtual 37	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   2686: lload 11
    //   2688: invokestatic 640	java/lang/Long:toString	(J)Ljava/lang/String;
    //   2691: invokevirtual 643	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   2694: ifeq +13 -> 2707
    //   2697: aload 15
    //   2699: aload 13
    //   2701: getfield 511	com/tencent/mobileqq/richstatus/StatusServlet$RspGetHistory:richStatus	Ljava/util/ArrayList;
    //   2704: invokevirtual 647	com/tencent/mobileqq/app/SignatureManager:jh	(Ljava/util/List;)V
    //   2707: goto -735 -> 1972
    //   2710: aload 14
    //   2712: ldc_w 653
    //   2715: aload_1
    //   2716: ldc_w 653
    //   2719: iconst_1
    //   2720: invokevirtual 651	android/content/Intent:getBooleanExtra	(Ljava/lang/String;Z)Z
    //   2723: invokevirtual 251	android/os/Bundle:putBoolean	(Ljava/lang/String;Z)V
    //   2726: aload 14
    //   2728: ldc_w 655
    //   2731: aload_1
    //   2732: ldc_w 655
    //   2735: iconst_m1
    //   2736: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   2739: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   2742: new 657	com/qq/jce/wup/UniPacket
    //   2745: dup
    //   2746: iconst_1
    //   2747: invokespecial 660	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   2750: astore 13
    //   2752: aload 13
    //   2754: ldc_w 662
    //   2757: invokevirtual 666	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   2760: aload 13
    //   2762: aload_2
    //   2763: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2766: invokevirtual 669	com/qq/jce/wup/UniPacket:decode	([B)V
    //   2769: aload 13
    //   2771: ldc_w 671
    //   2774: new 673	PersonalState/RespGetSameStateList
    //   2777: dup
    //   2778: invokespecial 674	PersonalState/RespGetSameStateList:<init>	()V
    //   2781: invokevirtual 678	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   2784: checkcast 673	PersonalState/RespGetSameStateList
    //   2787: astore_2
    //   2788: aload_2
    //   2789: getfield 682	PersonalState/RespGetSameStateList:oHead	LPersonalState/BusiRespHead;
    //   2792: getfield 687	PersonalState/BusiRespHead:iReplyCode	I
    //   2795: ifne +15 -> 2810
    //   2798: aload 14
    //   2800: ldc_w 689
    //   2803: aload_2
    //   2804: invokevirtual 493	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   2807: goto -835 -> 1972
    //   2810: iconst_0
    //   2811: istore 8
    //   2813: goto -6 -> 2807
    //   2816: astore_2
    //   2817: iconst_0
    //   2818: istore 8
    //   2820: goto -848 -> 1972
    //   2823: iload 8
    //   2825: ifeq -853 -> 1972
    //   2828: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2831: dup
    //   2832: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   2835: astore 13
    //   2837: aload 13
    //   2839: aload_2
    //   2840: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   2843: invokestatic 430	aqnv:J	([B)[B
    //   2846: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2849: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   2852: astore_2
    //   2853: aload_2
    //   2854: ifnull +368 -> 3222
    //   2857: aload_2
    //   2858: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2861: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   2864: ifeq +358 -> 3222
    //   2867: aload_2
    //   2868: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2871: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2874: istore_3
    //   2875: iload_3
    //   2876: ifne +331 -> 3207
    //   2879: aload_2
    //   2880: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   2883: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   2886: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   2889: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   2892: astore_2
    //   2893: aload_2
    //   2894: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   2897: istore_3
    //   2898: iload_3
    //   2899: ifne +239 -> 3138
    //   2902: aload_2
    //   2903: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   2906: istore 5
    //   2908: new 97	java/util/ArrayList
    //   2911: dup
    //   2912: invokespecial 98	java/util/ArrayList:<init>	()V
    //   2915: astore 13
    //   2917: iconst_0
    //   2918: istore_3
    //   2919: iload_3
    //   2920: iload 5
    //   2922: if_icmpge +90 -> 3012
    //   2925: aload_2
    //   2926: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   2929: newarray byte
    //   2931: astore 15
    //   2933: aload_2
    //   2934: aload 15
    //   2936: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   2939: pop
    //   2940: aload 13
    //   2942: new 587	java/lang/String
    //   2945: dup
    //   2946: aload 15
    //   2948: invokespecial 590	java/lang/String:<init>	([B)V
    //   2951: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   2954: pop
    //   2955: iload_3
    //   2956: iconst_1
    //   2957: iadd
    //   2958: istore_3
    //   2959: goto -40 -> 2919
    //   2962: astore_2
    //   2963: aload_2
    //   2964: invokevirtual 690	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   2967: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2970: ifeq +33 -> 3003
    //   2973: ldc_w 537
    //   2976: iconst_2
    //   2977: new 213	java/lang/StringBuilder
    //   2980: dup
    //   2981: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   2984: ldc_w 539
    //   2987: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2990: aload_2
    //   2991: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   2994: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2997: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3000: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3003: iconst_0
    //   3004: istore 8
    //   3006: aload 13
    //   3008: astore_2
    //   3009: goto -156 -> 2853
    //   3012: new 97	java/util/ArrayList
    //   3015: dup
    //   3016: invokespecial 98	java/util/ArrayList:<init>	()V
    //   3019: astore 15
    //   3021: new 97	java/util/ArrayList
    //   3024: dup
    //   3025: invokespecial 98	java/util/ArrayList:<init>	()V
    //   3028: astore 16
    //   3030: aload_2
    //   3031: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   3034: istore 6
    //   3036: iconst_0
    //   3037: istore_3
    //   3038: iload_3
    //   3039: iload 6
    //   3041: if_icmpge +53 -> 3094
    //   3044: aload_2
    //   3045: invokevirtual 506	java/nio/ByteBuffer:getShort	()S
    //   3048: newarray byte
    //   3050: astore 17
    //   3052: aload_2
    //   3053: aload 17
    //   3055: invokevirtual 498	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   3058: pop
    //   3059: aload 15
    //   3061: new 587	java/lang/String
    //   3064: dup
    //   3065: aload 17
    //   3067: invokespecial 590	java/lang/String:<init>	([B)V
    //   3070: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3073: pop
    //   3074: aload 16
    //   3076: aload_2
    //   3077: invokevirtual 496	java/nio/ByteBuffer:getInt	()I
    //   3080: invokestatic 695	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3083: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3086: pop
    //   3087: iload_3
    //   3088: iconst_1
    //   3089: iadd
    //   3090: istore_3
    //   3091: goto -53 -> 3038
    //   3094: iload 5
    //   3096: ifle +16 -> 3112
    //   3099: aload 14
    //   3101: ldc_w 697
    //   3104: aload 13
    //   3106: invokevirtual 701	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3109: goto +1433 -> 4542
    //   3112: aload 14
    //   3114: ldc_w 697
    //   3117: aload 15
    //   3119: invokevirtual 701	android/os/Bundle:putStringArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3122: aload 14
    //   3124: ldc_w 703
    //   3127: aload 16
    //   3129: invokevirtual 706	android/os/Bundle:putIntegerArrayList	(Ljava/lang/String;Ljava/util/ArrayList;)V
    //   3132: iconst_0
    //   3133: istore 8
    //   3135: goto +1407 -> 4542
    //   3138: iconst_0
    //   3139: istore 8
    //   3141: aload 14
    //   3143: ldc_w 708
    //   3146: iload_3
    //   3147: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3150: goto +1392 -> 4542
    //   3153: astore_2
    //   3154: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3157: ifeq +33 -> 3190
    //   3160: ldc_w 537
    //   3163: iconst_2
    //   3164: new 213	java/lang/StringBuilder
    //   3167: dup
    //   3168: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   3171: ldc_w 710
    //   3174: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3177: aload_2
    //   3178: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   3181: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3184: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3187: invokestatic 600	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   3190: iconst_0
    //   3191: istore 8
    //   3193: aload 14
    //   3195: ldc_w 708
    //   3198: sipush -1002
    //   3201: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3204: goto +1338 -> 4542
    //   3207: iconst_0
    //   3208: istore 8
    //   3210: aload 14
    //   3212: ldc_w 708
    //   3215: iload_3
    //   3216: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3219: goto +1323 -> 4542
    //   3222: iconst_0
    //   3223: istore 8
    //   3225: aload 14
    //   3227: ldc_w 708
    //   3230: sipush -1001
    //   3233: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3236: goto +1306 -> 4542
    //   3239: new 657	com/qq/jce/wup/UniPacket
    //   3242: dup
    //   3243: iconst_1
    //   3244: invokespecial 660	com/qq/jce/wup/UniPacket:<init>	(Z)V
    //   3247: astore 15
    //   3249: aload 15
    //   3251: ldc_w 662
    //   3254: invokevirtual 666	com/qq/jce/wup/UniPacket:setEncodeName	(Ljava/lang/String;)V
    //   3257: aload 15
    //   3259: aload_2
    //   3260: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3263: invokevirtual 669	com/qq/jce/wup/UniPacket:decode	([B)V
    //   3266: aload 15
    //   3268: ldc_w 712
    //   3271: new 714	PersonalState/RespGetHotState
    //   3274: dup
    //   3275: invokespecial 715	PersonalState/RespGetHotState:<init>	()V
    //   3278: invokevirtual 678	com/qq/jce/wup/UniPacket:getByClass	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   3281: checkcast 714	PersonalState/RespGetHotState
    //   3284: astore 15
    //   3286: aload 15
    //   3288: getfield 716	PersonalState/RespGetHotState:oHead	LPersonalState/BusiRespHead;
    //   3291: getfield 687	PersonalState/BusiRespHead:iReplyCode	I
    //   3294: ifne +400 -> 3694
    //   3297: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3300: ifeq +159 -> 3459
    //   3303: new 213	java/lang/StringBuilder
    //   3306: dup
    //   3307: ldc_w 718
    //   3310: invokespecial 720	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   3313: astore 16
    //   3315: aload 16
    //   3317: ldc_w 722
    //   3320: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3323: astore 17
    //   3325: aload 15
    //   3327: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3330: ifnonnull +102 -> 3432
    //   3333: ldc_w 727
    //   3336: astore_2
    //   3337: aload 17
    //   3339: aload_2
    //   3340: invokevirtual 315	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3343: ldc_w 729
    //   3346: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3349: pop
    //   3350: aload 15
    //   3352: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3355: ifnull +92 -> 3447
    //   3358: aload 15
    //   3360: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3363: invokevirtual 730	java/util/ArrayList:size	()I
    //   3366: ifle +81 -> 3447
    //   3369: aload 15
    //   3371: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3374: invokevirtual 106	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3377: astore_2
    //   3378: aload_2
    //   3379: invokeinterface 112 1 0
    //   3384: ifeq +63 -> 3447
    //   3387: aload_2
    //   3388: invokeinterface 116 1 0
    //   3393: checkcast 732	PersonalState/HotRishState
    //   3396: astore 17
    //   3398: aload 16
    //   3400: ldc_w 734
    //   3403: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3406: aload 17
    //   3408: getfield 737	PersonalState/HotRishState:iActId	I
    //   3411: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3414: ldc_w 739
    //   3417: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3420: aload 17
    //   3422: getfield 742	PersonalState/HotRishState:iDataId	I
    //   3425: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3428: pop
    //   3429: goto -51 -> 3378
    //   3432: aload 15
    //   3434: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3437: invokevirtual 730	java/util/ArrayList:size	()I
    //   3440: invokestatic 695	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3443: astore_2
    //   3444: goto -107 -> 3337
    //   3447: ldc_w 744
    //   3450: iconst_2
    //   3451: aload 16
    //   3453: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3456: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3459: new 97	java/util/ArrayList
    //   3462: dup
    //   3463: bipush 6
    //   3465: invokespecial 508	java/util/ArrayList:<init>	(I)V
    //   3468: astore_2
    //   3469: aload 15
    //   3471: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3474: ifnull +208 -> 3682
    //   3477: aload 15
    //   3479: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3482: invokevirtual 730	java/util/ArrayList:size	()I
    //   3485: ifle +197 -> 3682
    //   3488: aload 13
    //   3490: ifnull +82 -> 3572
    //   3493: aload 13
    //   3495: invokevirtual 746	amhj:c	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   3498: astore 16
    //   3500: aload 15
    //   3502: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3505: invokevirtual 730	java/util/ArrayList:size	()I
    //   3508: iconst_1
    //   3509: isub
    //   3510: istore_3
    //   3511: iload_3
    //   3512: iflt +60 -> 3572
    //   3515: aload 15
    //   3517: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3520: iload_3
    //   3521: invokevirtual 749	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3524: checkcast 732	PersonalState/HotRishState
    //   3527: astore 17
    //   3529: aload 17
    //   3531: getfield 737	PersonalState/HotRishState:iActId	I
    //   3534: aload 16
    //   3536: getfield 752	com/tencent/mobileqq/richstatus/RichStatus:actionId	I
    //   3539: if_icmpne +26 -> 3565
    //   3542: aload 17
    //   3544: getfield 742	PersonalState/HotRishState:iDataId	I
    //   3547: aload 16
    //   3549: getfield 755	com/tencent/mobileqq/richstatus/RichStatus:dataId	I
    //   3552: if_icmpne +13 -> 3565
    //   3555: aload 15
    //   3557: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3560: iload_3
    //   3561: invokevirtual 758	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   3564: pop
    //   3565: iload_3
    //   3566: iconst_1
    //   3567: isub
    //   3568: istore_3
    //   3569: goto -58 -> 3511
    //   3572: iconst_0
    //   3573: istore_3
    //   3574: iload_3
    //   3575: bipush 6
    //   3577: if_icmpge +24 -> 3601
    //   3580: aload_2
    //   3581: aload 15
    //   3583: getfield 725	PersonalState/RespGetHotState:vHostRichSateList	Ljava/util/ArrayList;
    //   3586: iload_3
    //   3587: invokevirtual 749	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3590: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3593: pop
    //   3594: iload_3
    //   3595: iconst_1
    //   3596: iadd
    //   3597: istore_3
    //   3598: goto -24 -> 3574
    //   3601: new 213	java/lang/StringBuilder
    //   3604: dup
    //   3605: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   3608: astore 15
    //   3610: aload_2
    //   3611: invokevirtual 106	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   3614: astore 16
    //   3616: aload 16
    //   3618: invokeinterface 112 1 0
    //   3623: ifeq +49 -> 3672
    //   3626: aload 16
    //   3628: invokeinterface 116 1 0
    //   3633: checkcast 732	PersonalState/HotRishState
    //   3636: astore 17
    //   3638: aload 15
    //   3640: aload 17
    //   3642: getfield 737	PersonalState/HotRishState:iActId	I
    //   3645: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3648: ldc_w 739
    //   3651: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3654: aload 17
    //   3656: getfield 742	PersonalState/HotRishState:iDataId	I
    //   3659: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3662: ldc_w 760
    //   3665: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3668: pop
    //   3669: goto -53 -> 3616
    //   3672: aload 13
    //   3674: aload 15
    //   3676: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3679: invokevirtual 763	amhj:PD	(Ljava/lang/String;)V
    //   3682: aload 14
    //   3684: ldc_w 765
    //   3687: aload_2
    //   3688: invokevirtual 493	android/os/Bundle:putSerializable	(Ljava/lang/String;Ljava/io/Serializable;)V
    //   3691: goto -1719 -> 1972
    //   3694: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3697: ifeq +13 -> 3710
    //   3700: ldc_w 744
    //   3703: iconst_2
    //   3704: ldc_w 767
    //   3707: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3710: iconst_0
    //   3711: istore 8
    //   3713: goto -1741 -> 1972
    //   3716: iload 8
    //   3718: ifeq -1746 -> 1972
    //   3721: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3724: dup
    //   3725: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   3728: astore 13
    //   3730: aload 13
    //   3732: aload_2
    //   3733: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3736: invokestatic 430	aqnv:J	([B)[B
    //   3739: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3742: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   3745: astore_2
    //   3746: iload 8
    //   3748: istore 9
    //   3750: aload_2
    //   3751: ifnull +80 -> 3831
    //   3754: iload 8
    //   3756: istore 9
    //   3758: aload_2
    //   3759: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3762: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3765: ifeq +66 -> 3831
    //   3768: aload_2
    //   3769: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3772: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3775: ifne +69 -> 3844
    //   3778: aload_2
    //   3779: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3782: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3785: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   3788: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   3791: astore_2
    //   3792: aload_2
    //   3793: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   3796: ifne +42 -> 3838
    //   3799: aload 14
    //   3801: ldc_w 447
    //   3804: aload_2
    //   3805: invokevirtual 367	java/nio/ByteBuffer:array	()[B
    //   3808: invokevirtual 451	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   3811: aload 14
    //   3813: ldc_w 453
    //   3816: aload_1
    //   3817: ldc_w 453
    //   3820: iconst_0
    //   3821: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3824: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   3827: iload 8
    //   3829: istore 9
    //   3831: iload 9
    //   3833: istore 8
    //   3835: goto -1863 -> 1972
    //   3838: iconst_0
    //   3839: istore 9
    //   3841: goto -10 -> 3831
    //   3844: iconst_0
    //   3845: istore 9
    //   3847: goto -16 -> 3831
    //   3850: astore_2
    //   3851: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3854: ifeq +33 -> 3887
    //   3857: ldc_w 537
    //   3860: iconst_2
    //   3861: new 213	java/lang/StringBuilder
    //   3864: dup
    //   3865: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   3868: ldc_w 539
    //   3871: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3874: aload_2
    //   3875: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   3878: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3881: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3884: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   3887: iconst_0
    //   3888: istore 9
    //   3890: goto -59 -> 3831
    //   3893: iload 8
    //   3895: ifeq -1923 -> 1972
    //   3898: aload_1
    //   3899: ldc_w 453
    //   3902: iconst_0
    //   3903: invokevirtual 405	android/content/Intent:getIntExtra	(Ljava/lang/String;I)I
    //   3906: istore_3
    //   3907: aload_2
    //   3908: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3911: arraylength
    //   3912: iconst_4
    //   3913: isub
    //   3914: istore 5
    //   3916: iload 5
    //   3918: newarray byte
    //   3920: astore 13
    //   3922: aload 13
    //   3924: iconst_0
    //   3925: aload_2
    //   3926: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   3929: iconst_4
    //   3930: iload 5
    //   3932: invokestatic 465	aqoj:copyData	([BI[BII)V
    //   3935: new 168	com/tencent/pb/signature/SigActPb$RspBody
    //   3938: dup
    //   3939: invokespecial 466	com/tencent/pb/signature/SigActPb$RspBody:<init>	()V
    //   3942: astore 15
    //   3944: aload 15
    //   3946: aload 13
    //   3948: invokevirtual 467	com/tencent/pb/signature/SigActPb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3951: pop
    //   3952: aload 15
    //   3954: getfield 468	com/tencent/pb/signature/SigActPb$RspBody:ret	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3957: invokevirtual 229	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3960: istore 5
    //   3962: aload 15
    //   3964: getfield 770	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3967: invokevirtual 771	com/tencent/mobileqq/pb/PBStringField:has	()Z
    //   3970: ifeq +582 -> 4552
    //   3973: aload 15
    //   3975: getfield 770	com/tencent/pb/signature/SigActPb$RspBody:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3978: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3981: astore_2
    //   3982: iload 5
    //   3984: ifne +206 -> 4190
    //   3987: aload 15
    //   3989: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   3992: getfield 471	com/tencent/pb/signature/SigActPb$SigauthRsp:result	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3995: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3998: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4001: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4004: astore 13
    //   4006: aload 13
    //   4008: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   4011: istore 5
    //   4013: iload 5
    //   4015: ifne +116 -> 4131
    //   4018: aload 14
    //   4020: ldc_w 447
    //   4023: aload 13
    //   4025: invokevirtual 367	java/nio/ByteBuffer:array	()[B
    //   4028: invokevirtual 451	android/os/Bundle:putByteArray	(Ljava/lang/String;[B)V
    //   4031: aload_2
    //   4032: astore 13
    //   4034: iload 8
    //   4036: istore 9
    //   4038: iload_3
    //   4039: iconst_1
    //   4040: if_icmpne +21 -> 4061
    //   4043: aload_0
    //   4044: aload 14
    //   4046: aload 15
    //   4048: ldc_w 773
    //   4051: invokespecial 775	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4054: iload 8
    //   4056: istore 9
    //   4058: aload_2
    //   4059: astore 13
    //   4061: aload 13
    //   4063: ifnull +13 -> 4076
    //   4066: aload 14
    //   4068: ldc_w 777
    //   4071: aload 13
    //   4073: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4076: aload 14
    //   4078: ldc_w 453
    //   4081: iload_3
    //   4082: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4085: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4088: ifeq +457 -> 4545
    //   4091: ldc_w 308
    //   4094: iconst_2
    //   4095: ldc_w 779
    //   4098: iconst_3
    //   4099: anewarray 781	java/lang/Object
    //   4102: dup
    //   4103: iconst_0
    //   4104: iload 9
    //   4106: invokestatic 786	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   4109: aastore
    //   4110: dup
    //   4111: iconst_1
    //   4112: iload_3
    //   4113: invokestatic 695	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   4116: aastore
    //   4117: dup
    //   4118: iconst_2
    //   4119: aload 13
    //   4121: aastore
    //   4122: invokestatic 790	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   4125: invokestatic 318	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4128: goto +417 -> 4545
    //   4131: aload 14
    //   4133: ldc_w 549
    //   4136: iload 5
    //   4138: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4141: invokestatic 795	aesn:c	()Lcom/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig;
    //   4144: astore 16
    //   4146: aload_2
    //   4147: astore 13
    //   4149: aload_2
    //   4150: invokestatic 800	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4153: ifeq +406 -> 4559
    //   4156: aload 16
    //   4158: ldc_w 802
    //   4161: new 213	java/lang/StringBuilder
    //   4164: dup
    //   4165: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   4168: ldc_w 523
    //   4171: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4174: iload 5
    //   4176: invokevirtual 232	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4179: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4182: invokevirtual 808	com/tencent/mobileqq/config/business/qvip/SSOErrorInfoMapConfig:getErrorInfo	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   4185: astore 13
    //   4187: goto +372 -> 4559
    //   4190: iconst_0
    //   4191: istore 9
    //   4193: aload 14
    //   4195: ldc_w 559
    //   4198: iload 5
    //   4200: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4203: iload 5
    //   4205: ldc_w 560
    //   4208: if_icmpne +22 -> 4230
    //   4211: aload 14
    //   4213: ldc_w 562
    //   4216: aload 15
    //   4218: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4221: getfield 563	com/tencent/pb/signature/SigActPb$SigauthRsp:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4224: invokevirtual 274	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4227: invokevirtual 278	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   4230: aload 15
    //   4232: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4235: getfield 566	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4238: invokevirtual 567	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   4241: ifeq +22 -> 4263
    //   4244: aload 14
    //   4246: ldc_w 569
    //   4249: aload 15
    //   4251: getfield 172	com/tencent/pb/signature/SigActPb$RspBody:auth_rsp	Lcom/tencent/pb/signature/SigActPb$SigauthRsp;
    //   4254: getfield 566	com/tencent/pb/signature/SigActPb$SigauthRsp:authfailed_appid	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   4257: invokevirtual 229	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   4260: invokevirtual 256	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   4263: aload_0
    //   4264: aload 14
    //   4266: aload 15
    //   4268: ldc_w 810
    //   4271: invokespecial 775	com/tencent/mobileqq/richstatus/StatusServlet:a	(Landroid/os/Bundle;Lcom/tencent/pb/signature/SigActPb$RspBody;Ljava/lang/String;)V
    //   4274: aload_2
    //   4275: astore 13
    //   4277: goto -216 -> 4061
    //   4280: astore_2
    //   4281: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4284: ifeq +33 -> 4317
    //   4287: ldc_w 537
    //   4290: iconst_2
    //   4291: new 213	java/lang/StringBuilder
    //   4294: dup
    //   4295: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   4298: ldc_w 539
    //   4301: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4304: aload_2
    //   4305: invokevirtual 550	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   4308: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4311: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4314: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4317: iconst_0
    //   4318: istore 8
    //   4320: goto -2348 -> 1972
    //   4323: iload 8
    //   4325: ifeq -2353 -> 1972
    //   4328: new 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4331: dup
    //   4332: invokespecial 323	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   4335: astore 13
    //   4337: aload 13
    //   4339: aload_2
    //   4340: invokevirtual 426	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   4343: invokestatic 430	aqnv:J	([B)[B
    //   4346: invokevirtual 431	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4349: checkcast 322	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   4352: astore_2
    //   4353: iload 8
    //   4355: istore 9
    //   4357: aload_2
    //   4358: ifnull +55 -> 4413
    //   4361: iload 8
    //   4363: istore 9
    //   4365: aload_2
    //   4366: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4369: invokevirtual 435	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4372: ifeq +41 -> 4413
    //   4375: aload_2
    //   4376: getfield 434	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4379: invokevirtual 264	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4382: ifne +44 -> 4426
    //   4385: aload_2
    //   4386: getfield 364	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   4389: invokevirtual 438	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   4392: invokevirtual 439	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   4395: invokestatic 442	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   4398: invokevirtual 445	java/nio/ByteBuffer:get	()B
    //   4401: istore_3
    //   4402: iload_3
    //   4403: ifne +17 -> 4420
    //   4406: iconst_1
    //   4407: istore 8
    //   4409: iload 8
    //   4411: istore 9
    //   4413: iload 9
    //   4415: istore 8
    //   4417: goto -2445 -> 1972
    //   4420: iconst_0
    //   4421: istore 8
    //   4423: goto -14 -> 4409
    //   4426: iconst_0
    //   4427: istore 9
    //   4429: goto -16 -> 4413
    //   4432: astore_2
    //   4433: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4436: ifeq +33 -> 4469
    //   4439: ldc_w 537
    //   4442: iconst_2
    //   4443: new 213	java/lang/StringBuilder
    //   4446: dup
    //   4447: invokespecial 214	java/lang/StringBuilder:<init>	()V
    //   4450: ldc_w 539
    //   4453: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4456: aload_2
    //   4457: invokevirtual 542	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   4460: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4463: invokevirtual 240	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4466: invokestatic 244	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   4469: iconst_0
    //   4470: istore 9
    //   4472: goto -59 -> 4413
    //   4475: goto -3047 -> 1428
    //   4478: goto -3050 -> 1428
    //   4481: goto -3039 -> 1442
    //   4484: goto -4134 -> 350
    //   4487: iload_3
    //   4488: ifeq -2636 -> 1852
    //   4491: iconst_0
    //   4492: istore 8
    //   4494: iload 9
    //   4496: istore 10
    //   4498: iload 8
    //   4500: istore 9
    //   4502: goto -2969 -> 1533
    //   4505: iload_3
    //   4506: ifeq -2424 -> 2082
    //   4509: iconst_0
    //   4510: istore 8
    //   4512: iload 9
    //   4514: istore 10
    //   4516: iload 8
    //   4518: istore 9
    //   4520: goto -2454 -> 2066
    //   4523: iconst_0
    //   4524: istore 9
    //   4526: goto -21 -> 4505
    //   4529: iload_3
    //   4530: iconst_1
    //   4531: iadd
    //   4532: istore_3
    //   4533: goto -2206 -> 2327
    //   4536: iconst_0
    //   4537: istore 9
    //   4539: goto -2243 -> 2296
    //   4542: goto -2570 -> 1972
    //   4545: iload 9
    //   4547: istore 8
    //   4549: goto -2577 -> 1972
    //   4552: ldc_w 523
    //   4555: astore_2
    //   4556: goto -574 -> 3982
    //   4559: iconst_0
    //   4560: istore 8
    //   4562: aload 13
    //   4564: astore_2
    //   4565: goto -534 -> 4031
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	4568	0	this	StatusServlet
    //   0	4568	1	paramIntent	Intent
    //   0	4568	2	paramFromServiceMsg	com.tencent.qphone.base.remote.FromServiceMsg
    //   117	4416	3	i	int
    //   7	2087	4	j	int
    //   500	3709	5	k	int
    //   524	2518	6	m	int
    //   602	1812	7	n	int
    //   13	4548	8	bool1	boolean
    //   45	4501	9	bool2	boolean
    //   1537	2978	10	bool3	boolean
    //   481	2206	11	l	long
    //   36	491	13	localObject1	Object
    //   717	26	13	localInvalidProtocolBufferMicroException1	InvalidProtocolBufferMicroException
    //   805	470	13	localException1	Exception
    //   1288	25	13	localException2	Exception
    //   1357	418	13	localObject2	Object
    //   1801	26	13	localInvalidProtocolBufferMicroException2	InvalidProtocolBufferMicroException
    //   2003	2560	13	localObject3	Object
    //   22	4243	14	localBundle	Bundle
    //   226	4041	15	localObject4	Object
    //   431	3726	16	localObject5	Object
    //   564	3091	17	localObject6	Object
    //   581	1129	18	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   68	85	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   98	118	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	144	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   148	177	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   632	673	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   682	714	717	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   215	266	805	java/lang/Exception
    //   270	295	805	java/lang/Exception
    //   299	328	805	java/lang/Exception
    //   793	802	805	java/lang/Exception
    //   850	898	805	java/lang/Exception
    //   905	924	805	java/lang/Exception
    //   924	957	805	java/lang/Exception
    //   957	1022	805	java/lang/Exception
    //   1027	1155	805	java/lang/Exception
    //   1155	1189	805	java/lang/Exception
    //   360	516	1288	java/lang/Exception
    //   519	549	1288	java/lang/Exception
    //   557	618	1288	java/lang/Exception
    //   1227	1274	1288	java/lang/Exception
    //   1274	1285	1288	java/lang/Exception
    //   1557	1609	1288	java/lang/Exception
    //   1614	1653	1288	java/lang/Exception
    //   1653	1675	1288	java/lang/Exception
    //   1675	1697	1288	java/lang/Exception
    //   1702	1721	1288	java/lang/Exception
    //   1724	1743	1288	java/lang/Exception
    //   1756	1782	1288	java/lang/Exception
    //   1359	1376	1801	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1381	1421	1801	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   1454	1527	1882	java/lang/Exception
    //   1533	1542	1882	java/lang/Exception
    //   1866	1875	1882	java/lang/Exception
    //   1987	2060	2112	java/lang/Exception
    //   2066	2075	2112	java/lang/Exception
    //   2096	2105	2112	java/lang/Exception
    //   2140	2293	2465	java/lang/Exception
    //   2296	2325	2465	java/lang/Exception
    //   2333	2394	2465	java/lang/Exception
    //   2404	2451	2465	java/lang/Exception
    //   2451	2462	2465	java/lang/Exception
    //   2493	2545	2465	java/lang/Exception
    //   2550	2589	2465	java/lang/Exception
    //   2589	2610	2465	java/lang/Exception
    //   2610	2632	2465	java/lang/Exception
    //   2637	2656	2465	java/lang/Exception
    //   2659	2677	2465	java/lang/Exception
    //   2682	2707	2465	java/lang/Exception
    //   2710	2807	2816	java/lang/Exception
    //   2837	2853	2962	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   2879	2898	3153	java/lang/Exception
    //   2902	2917	3153	java/lang/Exception
    //   2925	2955	3153	java/lang/Exception
    //   3012	3036	3153	java/lang/Exception
    //   3044	3087	3153	java/lang/Exception
    //   3099	3109	3153	java/lang/Exception
    //   3112	3132	3153	java/lang/Exception
    //   3141	3150	3153	java/lang/Exception
    //   3730	3746	3850	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3758	3827	3850	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   3898	3982	4280	java/lang/Exception
    //   3987	4013	4280	java/lang/Exception
    //   4018	4031	4280	java/lang/Exception
    //   4043	4054	4280	java/lang/Exception
    //   4066	4076	4280	java/lang/Exception
    //   4076	4128	4280	java/lang/Exception
    //   4131	4146	4280	java/lang/Exception
    //   4149	4187	4280	java/lang/Exception
    //   4193	4203	4280	java/lang/Exception
    //   4211	4230	4280	java/lang/Exception
    //   4230	4263	4280	java/lang/Exception
    //   4263	4274	4280	java/lang/Exception
    //   4337	4353	4432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4365	4402	4432	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = (AppInterface)getAppRuntime();
    int i = paramIntent.getIntExtra("k_cmd", 0);
    Object localObject2;
    int j;
    Object localObject3;
    switch (i)
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
        if (i == 2) {}
        for (boolean bool = true;; bool = false)
        {
          paramPacket.putSendData(a(bool, paramIntent.getBooleanExtra("k_sync_ss", false), Long.parseLong((String)localObject1)));
          paramIntent = "OidbSvc.0x515_2";
          break;
        }
        localObject1 = "OidbSvc.0x53f_2";
        localObject2 = paramIntent.getStringExtra("k_uin");
        i = paramIntent.getIntExtra("k_end_time", 2147483647);
        j = paramIntent.getIntExtra("k_start_time", 0);
        paramPacket.putSendData(a(Long.parseLong((String)localObject2), Integer.valueOf(j).intValue(), Integer.valueOf(i).intValue()));
        paramIntent = (Intent)localObject1;
      }
    case 3: 
      localObject2 = new ReqGetSameStateList();
      ((ReqGetSameStateList)localObject2).oHead = new BusiReqHead();
      ((ReqGetSameStateList)localObject2).vCookie = paramIntent.getByteArrayExtra("k_cookie");
      if (((ReqGetSameStateList)localObject2).vCookie == null) {
        ((ReqGetSameStateList)localObject2).vCookie = new byte[0];
      }
      localObject3 = new RichStatus("");
      ((RichStatus)localObject3).actionText = "foo";
      ((RichStatus)localObject3).actionId = paramIntent.getIntExtra("k_action", 0);
      ((RichStatus)localObject3).dataText = "foo";
      ((RichStatus)localObject3).dataId = paramIntent.getIntExtra("k_data", 0);
      ((ReqGetSameStateList)localObject2).oSelfRishState = new stRishState(((RichStatus)localObject3).encode(), 0L);
      localObject1 = ((acff)((AppInterface)localObject1).getManager(51)).b(((AppInterface)localObject1).getCurrentAccountUin());
      if (localObject1 != null) {
        if (((Card)localObject1).shGender != 0) {
          break;
        }
      }
      break;
    }
    label1048:
    for (i = 0;; i = 2)
    {
      for (;;)
      {
        ((ReqGetSameStateList)localObject2).eSelfSex = i;
        ((ReqGetSameStateList)localObject2).iPageSize = 50;
        ((ReqGetSameStateList)localObject2).oLbsInfo = a(null);
        ((ReqGetSameStateList)localObject2).eFetchSex = paramIntent.getIntExtra("k_fetch_sex", -1);
        paramIntent = paramIntent.getStringExtra("k_uin");
        if (!TextUtils.isEmpty(paramIntent)) {}
        try
        {
          ((ReqGetSameStateList)localObject2).lFriendUin = Long.parseLong(paramIntent);
          paramPacket.setServantName("PersonalStateSvc");
          paramPacket.setFuncName("ReqGetSameStateList");
          paramPacket.addRequestPacket("ReqGetSameStateList", (JceStruct)localObject2);
          paramIntent = "PersonalStateSvc.ReqGetSameStateList";
          break;
          if (((Card)localObject1).shGender != 1) {
            break label1048;
          }
          i = 1;
        }
        catch (Exception paramIntent)
        {
          for (;;)
          {
            paramIntent.printStackTrace();
          }
        }
      }
      localObject2 = paramIntent.getStringArrayListExtra("k_status_key");
      localObject1 = new ArrayList();
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((List)localObject1).add(((String)((Iterator)localObject2).next()).getBytes());
        }
      }
      paramPacket.putSendData(a((List)localObject1, (byte)paramIntent.getIntExtra("k_status_flag", 1)));
      paramIntent = "OidbSvc.0x54f_0";
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
      localObject1 = "OidbSvc.0x50f_29";
      paramPacket.putSendData(z(paramIntent.getByteArrayExtra("k_data")));
      paramIntent = (Intent)localObject1;
      break;
      localObject1 = "OidbSvc.0x510_0";
      paramIntent = new oidb_sso.OIDBSSOPkg();
      paramIntent.uint32_command.set(1296);
      paramIntent.uint32_service_type.set(0);
      paramIntent.bytes_bodybuffer.set(ByteStringMicro.EMPTY);
      paramIntent = paramIntent.toByteArray();
      localObject2 = ByteBuffer.allocate(paramIntent.length + 4);
      ((ByteBuffer)localObject2).putInt(paramIntent.length + 4);
      ((ByteBuffer)localObject2).put(paramIntent);
      paramPacket.putSendData(((ByteBuffer)localObject2).array());
      paramIntent = (Intent)localObject1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("StatusServlet", 2, "clearRichStatus...");
      paramIntent = (Intent)localObject1;
      break;
      i = paramIntent.getIntExtra("k_tpl_id", 0);
      j = paramIntent.getIntExtra("k_font_id", 0);
      int k = paramIntent.getIntExtra("k_sign_len", 2);
      localObject2 = paramIntent.getByteArrayExtra("k_sign_data");
      int m = paramIntent.getIntExtra("k_source", 0);
      paramIntent = new SigActPb.Platform();
      paramIntent.platform.set(109L);
      paramIntent.mqqver.set("3.4.4");
      paramIntent.osver.set(aqgz.getDeviceOSVersion());
      localObject3 = new SigActPb.SigauthReq();
      ((SigActPb.SigauthReq)localObject3).uin_disable.set(Long.parseLong(((AppInterface)localObject1).getCurrentAccountUin()));
      ((SigActPb.SigauthReq)localObject3).itemid.set(i);
      ((SigActPb.SigauthReq)localObject3).fontid.set(j);
      ((SigActPb.SigauthReq)localObject3).data.set(ByteStringMicro.copyFrom((byte[])localObject2));
      ((SigActPb.SigauthReq)localObject3).len.set(k);
      localObject1 = new SigActPb.ReqBody();
      ((SigActPb.ReqBody)localObject1).cmd.set(2);
      ((SigActPb.ReqBody)localObject1).plf.set(paramIntent);
      ((SigActPb.ReqBody)localObject1).auth_req.set((MessageMicro)localObject3);
      ((SigActPb.ReqBody)localObject1).seq.set(System.currentTimeMillis());
      ((SigActPb.ReqBody)localObject1).source.set(m);
      paramIntent = ((SigActPb.ReqBody)localObject1).toByteArray();
      localObject1 = new byte[paramIntent.length + 4];
      aqoj.DWord2Byte((byte[])localObject1, 0, paramIntent.length + 4);
      aqoj.b((byte[])localObject1, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData((byte[])localObject1);
      if (QLog.isColorLevel())
      {
        QLog.d("StatusServlet", 2, "Signature.auth");
        paramIntent = "Signature.auth";
        break;
      }
      paramIntent = "Signature.auth";
      break;
    }
  }
  
  public static class RspGetHistory
    implements Serializable
  {
    public int endTime;
    public boolean isAddFromCard;
    public boolean over;
    public ArrayList<RichStatus> richStatus;
    public int startTime;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.StatusServlet
 * JD-Core Version:    0.7.0.1
 */