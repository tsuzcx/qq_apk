package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class QPSingleUpdEngine
{
  final int jdField_a_of_type_Int = 10000;
  QPCheckCanRestartThread jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread = null;
  QPSingleUpdReportSig jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig = null;
  QPSingleUpdStateCfg jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg = null;
  QPSinlgeUpdInfo jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo = null;
  QPSupportUpdCfg jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg = null;
  final String jdField_a_of_type_JavaLangString = "QPSingleUpdEngine";
  Socket jdField_a_of_type_JavaNetSocket;
  final int jdField_b_of_type_Int = 600000;
  final String jdField_b_of_type_JavaLangString = "qd-up.m.qq.com";
  final int jdField_c_of_type_Int = 1;
  final String jdField_c_of_type_JavaLangString = "TxSingleUpd.zip";
  final int jdField_d_of_type_Int = 2;
  String jdField_d_of_type_JavaLangString = null;
  final int jdField_e_of_type_Int = 14000;
  String jdField_e_of_type_JavaLangString = null;
  
  public QPSingleUpdEngine(String paramString)
  {
    this.jdField_e_of_type_JavaLangString = paramString;
    paramString = BaseApplication.getContext().getFilesDir();
    this.jdField_d_of_type_JavaLangString = (paramString.getAbsolutePath() + "/TxSingleUpd/");
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg = new QPSupportUpdCfg();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.ReadConfigFile(QPSupportUpdCfg.CFG_FILEPATH);
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg = new QPSingleUpdStateCfg();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo = new QPSinlgeUpdInfo();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig = new QPSingleUpdReportSig();
  }
  
  public static int a(byte[] paramArrayOfByte)
  {
    return paramArrayOfByte[0] & 0xFF | paramArrayOfByte[1] << 8 & 0xFF00 | paramArrayOfByte[2] << 24 >>> 8 | paramArrayOfByte[3] << 24;
  }
  
  public static void a(byte[] paramArrayOfByte)
  {
    int k = paramArrayOfByte.length;
    int j = 0;
    while (j < k / 2)
    {
      int i = paramArrayOfByte[j];
      paramArrayOfByte[j] = paramArrayOfByte[(k - 1 - j)];
      paramArrayOfByte[(k - 1 - j)] = i;
      j += 1;
    }
  }
  
  public static byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF), (byte)(paramInt >> 16 & 0xFF), (byte)(paramInt >>> 24) };
  }
  
  public QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE a()
  {
    Object localObject1 = BaseApplication.getContext();
    BaseApplication.getContext();
    Object localObject2 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
    localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
    localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
    if ((localObject1 != null) && (((NetworkInfo)localObject1).getState() == NetworkInfo.State.CONNECTED)) {
      return QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE.WIFI;
    }
    if ((localObject2 != null) && (((NetworkInfo)localObject2).getState() == NetworkInfo.State.CONNECTED)) {
      return QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE.MOBILEPHONE;
    }
    return QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE.NONE;
  }
  
  public void a()
  {
    QLog.i("QPSingleUpdEngine", 0, "Engine started");
    c();
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a())
    {
      QLog.i("QPSingleUpdEngine", 0, "Today is updated");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c())
    {
      QLog.i("QPSingleUpdEngine", 0, "Today is updated");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.f();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Long = new Date().getTime();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.a = true;
      i();
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a()) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.b() == true) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c == 0L))
    {
      QLog.i("QPSingleUpdEngine", 0, "there is another Update thread is running");
      return;
    }
    if ((!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a()) && (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.b()))
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.d();
    }
    if ((!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a()) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Long > 0L) && (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c > 0L))
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.d();
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.e();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.updateCfgHash();
    boolean bool1 = false;
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int > 0)
      {
        bool1 = a();
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a();
        if (!bool1) {}
      }
      else
      {
        if (bool1) {
          break;
        }
        i();
        return;
      }
      Thread.sleep(600000L);
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d = true;
    if (!j())
    {
      QLog.i("QPSingleUpdEngine", 0, "the ClientFile is Already the highest version");
      i();
      return;
    }
    QLog.i("QPSingleUpdEngine", 0, "Need to Update");
    bool1 = false;
    int i = 3;
    int k = 0;
    boolean bool2;
    boolean bool3;
    do
    {
      int j;
      do
      {
        bool2 = bool1;
        if (i <= 0) {
          break;
        }
        if (!b())
        {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.n = true;
          i();
          return;
        }
        bool3 = c();
        j = i - 1;
        k = bool3;
        i = j;
      } while (!bool3);
      bool2 = d();
      bool1 = bool2;
      k = bool3;
      i = j;
    } while (!bool2);
    k = bool3;
    if ((k == 0) || (!bool2))
    {
      i();
      return;
    }
    if (!e())
    {
      i();
      return;
    }
    if (!f())
    {
      i();
      return;
    }
    if (!h())
    {
      g();
      i();
      return;
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 1;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread = new QPCheckCanRestartThread();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread.start();
    do
    {
      while (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread.a()) {
        b();
      }
      Thread.sleep(1000L);
    } while ((new Date().getTime() - this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Long) / 3600000L < 22L);
    i();
    QLog.i("QPSingleUpdEngine", 0, "Engine Ended");
  }
  
  public void a(QPSingleUpdateProto.Head paramHead, QPSingleUpdateProto.ReqBody paramReqBody)
  {
    int j = 0;
    QLog.i("QPSingleUpdEngine", 0, "getBaseInfo");
    paramHead.setHasFlag(true);
    paramHead.uint64_uin.set(Long.parseLong(this.jdField_e_of_type_JavaLangString));
    paramHead.uint32_command.set(0);
    paramHead.uint32_seq.set(0);
    Object localObject1 = new String();
    int i = 0;
    Object localObject2;
    while (i < "6.0.0".length())
    {
      localObject2 = localObject1;
      if ("6.0.0".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("6.0.0".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    paramHead.uint32_version.set(Integer.parseInt((String)localObject1));
    paramHead.uint32_retry_times.set(3);
    paramHead.uint32_client_type.set(1);
    paramHead.uint32_pubno.set(0);
    localObject1 = Locale.getDefault().getLanguage();
    if ((((String)localObject1).endsWith("cn")) || (((String)localObject1).endsWith("zh"))) {
      paramHead.uint32_localid.set(2052);
    }
    if (((String)localObject1).endsWith("en")) {
      paramHead.uint32_localid.set(1033);
    }
    paramHead.msg_login_sig.setHasFlag(true);
    paramHead.msg_login_sig.uint32_type.set(1);
    paramHead.uint32_client_ip.set(0);
    paramHead.uint32_client_port.set(0);
    paramHead.uint32_actual_ip.set(0);
    paramHead.uint32_qdun_ver.set(46);
    localObject1 = ByteStringMicro.copyFrom(Build.MODEL.getBytes());
    paramHead.bytes_phone_model.set((ByteStringMicro)localObject1);
    localObject1 = BaseApplication.getContext();
    BaseApplication.getContext();
    localObject1 = ByteStringMicro.copyFrom(((TelephonyManager)((Context)localObject1).getSystemService("phone")).getDeviceId().getBytes());
    paramHead.bytes_phone_imei.set((ByteStringMicro)localObject1);
    localObject1 = ByteStringMicro.copyFrom("".getBytes());
    paramHead.bytes_phone_num.set((ByteStringMicro)localObject1);
    localObject1 = a();
    if (localObject1 == QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE.WIFI)
    {
      paramHead.uint32_net_type.set(1);
      localObject1 = new Timestamp(new Date().getTime());
      paramHead.uint32_timestamp.set(((Timestamp)localObject1).getNanos());
      paramHead.uint32_subcmd.set(0);
      paramHead.uint32_result.set(0);
      paramHead.uint32_flag.set(1);
      int k = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileItemCount();
      paramReqBody.setHasFlag(true);
      i = j;
      label435:
      if (i >= k) {
        return;
      }
      localObject1 = new QPSingleUpdateProto.FileItem();
      paramHead = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      localObject2 = ByteStringMicro.copyFrom(paramHead.getBytes());
      ((QPSingleUpdateProto.FileItem)localObject1).bytes_name.set((ByteStringMicro)localObject2);
      if (!paramHead.equalsIgnoreCase("SupportUpd.cfg")) {
        break label587;
      }
    }
    label587:
    for (paramHead = MD5FileUtil.a(new File(this.jdField_d_of_type_JavaLangString + "SupportUpd.cfg"));; paramHead = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash))
    {
      paramHead = ByteStringMicro.copyFrom(paramHead.getBytes());
      ((QPSingleUpdateProto.FileItem)localObject1).bytes_hash.set(paramHead);
      ((QPSingleUpdateProto.FileItem)localObject1).setHasFlag(true);
      paramReqBody.rpt_file_item_list.add((MessageMicro)localObject1);
      i += 1;
      break label435;
      if (localObject1 != QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE.MOBILEPHONE) {
        break;
      }
      paramHead.uint32_net_type.set(2);
      break;
    }
  }
  
  public boolean a()
  {
    QLog.i("QPSingleUpdEngine", 0, "Begin Request");
    try
    {
      Object localObject2 = new QPSingleUpdateProto.Head();
      Object localObject3 = new QPSingleUpdateProto.ReqBody();
      a((QPSingleUpdateProto.Head)localObject2, (QPSingleUpdateProto.ReqBody)localObject3);
      this.jdField_a_of_type_JavaNetSocket = new Socket(InetAddress.getByName("qd-up.m.qq.com"), 14000);
      QLog.i("QPSingleUpdEngine", 0, "Create Socket Success");
      OutputStream localOutputStream = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
      QLog.i("QPSingleUpdEngine", 0, "GetOutputStream Successs");
      Object localObject4 = InetAddress.getLocalHost().getAddress();
      int i = localObject4[0];
      int j = localObject4[1];
      int k = localObject4[2];
      int m = localObject4[3];
      ((QPSingleUpdateProto.Head)localObject2).uint32_client_ip.set(m | i << 24 | j << 16 | k << 8);
      ((QPSingleUpdateProto.Head)localObject2).uint32_client_port.set(this.jdField_a_of_type_JavaNetSocket.getLocalPort());
      localObject2 = ((QPSingleUpdateProto.Head)localObject2).toByteArray();
      localObject3 = ((QPSingleUpdateProto.ReqBody)localObject3).toByteArray();
      localObject4 = new ByteArrayOutputStream(localObject2.length + 10 + localObject3.length);
      Object localObject5 = new DataOutputStream((OutputStream)localObject4);
      ((ByteArrayOutputStream)localObject4).write(2);
      ((DataOutputStream)localObject5).writeInt(localObject2.length);
      ((DataOutputStream)localObject5).writeInt(localObject3.length);
      ((ByteArrayOutputStream)localObject4).write((byte[])localObject2);
      ((ByteArrayOutputStream)localObject4).write((byte[])localObject3);
      ((ByteArrayOutputStream)localObject4).write(3);
      QLog.i("QPSingleUpdEngine", 0, "reqHeadLen = " + localObject2.length);
      QLog.i("QPSingleUpdEngine", 0, "reqBodyLen = " + localObject3.length);
      ((DataOutputStream)localObject5).close();
      ((ByteArrayOutputStream)localObject4).close();
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(15000);
      localOutputStream.write(((ByteArrayOutputStream)localObject4).toByteArray());
      QLog.i("QPSingleUpdEngine", 0, "Send Request Success");
      localObject2 = this.jdField_a_of_type_JavaNetSocket.getInputStream();
      QLog.i("QPSingleUpdEngine", 0, "GetInputStream Success");
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(15000);
      i = ((InputStream)localObject2).read();
      QLog.i("QPSingleUpdEngine", 0, "Got STX");
      if (i != 2)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.k = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException1)
        {
          for (;;)
          {
            localIOException1.printStackTrace();
          }
        }
      }
      localObject3 = new byte[4];
      if (((InputStream)localObject2).read((byte[])localObject3, 0, 4) < 4)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            localIOException2.printStackTrace();
          }
        }
      }
      a((byte[])localObject3);
      i = a((byte[])localObject3);
      QLog.i("QPSingleUpdEngine", 0, "iHeadLen = " + i);
      if (i == 0) {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
      }
      localObject3 = new byte[4];
      if (((InputStream)localObject2).read((byte[])localObject3, 0, 4) < 4)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            localIOException3.printStackTrace();
          }
        }
      }
      a((byte[])localObject3);
      j = a((byte[])localObject3);
      QLog.i("QPSingleUpdEngine", 0, "iBodyLen = " + j);
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.i = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return true;
        }
        catch (IOException localIOException4)
        {
          for (;;)
          {
            localIOException4.printStackTrace();
          }
        }
      }
      localObject4 = new byte[i];
      if (((InputStream)localObject2).read((byte[])localObject4, 0, i) < i)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException5)
        {
          for (;;)
          {
            localIOException5.printStackTrace();
          }
        }
      }
      localObject5 = new QPSingleUpdateProto.Head();
      localObject3 = new QPSingleUpdateProto.RspBody();
      boolean bool = a((QPSingleUpdateProto.Head)((QPSingleUpdateProto.Head)localObject5).mergeFrom((byte[])localObject4));
      if (!bool) {
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException6)
        {
          for (;;)
          {
            localIOException6.printStackTrace();
          }
        }
      }
      localObject4 = new byte[j];
      if (((InputStream)localObject2).read((byte[])localObject4, 0, j) < j)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException7)
        {
          for (;;)
          {
            localIOException7.printStackTrace();
          }
        }
      }
      localObject3 = (QPSingleUpdateProto.RspBody)((QPSingleUpdateProto.RspBody)localObject3).mergeFrom((byte[])localObject4);
      a((QPSingleUpdateProto.RspBody)localObject3);
      QLog.i("QPSingleUpdEngine", 0, "Got Entire Rsp Package");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject3).uint32_update_vailable.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject3).uint32_force_download.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_c_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject3).uint32_download_type.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_JavaLangString = new String(((QPSingleUpdateProto.RspBody)localObject3).bytes_packet_url.get().toByteArray());
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_JavaLangString = new String(((QPSingleUpdateProto.RspBody)localObject3).bytes_packet_hash.get().toByteArray());
      QLog.i("QPSingleUpdEngine", 0, "hit test");
      j = ((QPSingleUpdateProto.RspBody)localObject3).rpt_file_item_list.size();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.a(j);
      localObject4 = new QPSingleUpdateProto.FileItem[j];
      localObject3 = (QPSingleUpdateProto.FileItem[])((QPSingleUpdateProto.RspBody)localObject3).rpt_file_item_list.get().toArray((Object[])localObject4);
      QLog.i("QPSingleUpdEngine", 0, "hit test");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_ArrayOfHyr[i].jdField_a_of_type_JavaLangString = new String(localObject3[i].bytes_name.get().toByteArray());
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_ArrayOfHyr[i].jdField_b_of_type_JavaLangString = new String(localObject3[i].bytes_hash.get().toByteArray());
        i += 1;
      }
      i = ((InputStream)localObject2).read();
      QLog.i("QPSingleUpdEngine", 0, "Got ETX");
      if (i != 3)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.k = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException8)
        {
          for (;;)
          {
            localIOException8.printStackTrace();
          }
        }
      }
      localIOException8.close();
      ((InputStream)localObject2).close();
      QLog.i("QPSingleUpdEngine", 0, "Request Function Success");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d = true;
        return true;
      }
      catch (IOException localIOException9)
      {
        for (;;)
        {
          localIOException9.printStackTrace();
        }
      }
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        throw localObject1;
      }
      catch (IOException localIOException17)
      {
        for (;;)
        {
          localIOException17.printStackTrace();
        }
      }
    }
    catch (ConnectException localConnectException)
    {
      localConnectException = localConnectException;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp Connect Exception");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException10)
      {
        for (;;)
        {
          localIOException10.printStackTrace();
        }
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      localSocketTimeoutException = localSocketTimeoutException;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp SocketTimeoutException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException11)
      {
        for (;;)
        {
          localIOException11.printStackTrace();
        }
      }
    }
    catch (EOFException localEOFException)
    {
      localEOFException = localEOFException;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.f = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp EOFException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException12)
      {
        for (;;)
        {
          localIOException12.printStackTrace();
        }
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      localInvalidProtocolBufferMicroException = localInvalidProtocolBufferMicroException;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp InvalidProtocolBufferMicroException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException13)
      {
        for (;;)
        {
          localIOException13.printStackTrace();
        }
      }
    }
    catch (IOException localIOException14)
    {
      localIOException14 = localIOException14;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.h = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp IOException read or write Error");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException15)
      {
        for (;;)
        {
          localIOException15.printStackTrace();
        }
      }
    }
    catch (Exception localException)
    {
      localException = localException;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.j = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp Exception");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException16)
      {
        for (;;)
        {
          localIOException16.printStackTrace();
        }
      }
    }
    finally {}
  }
  
  public boolean a(QPSingleUpdateProto.Head paramHead)
  {
    int i = paramHead.uint32_result.get();
    if (i == 1) {
      return true;
    }
    if (i == 2) {
      return false;
    }
    return i != 3;
  }
  
  public boolean a(QPSingleUpdateProto.RspBody paramRspBody)
  {
    return true;
  }
  
  public void b()
  {
    QLog.i("QPSingleUpdEngine", 0, "restartQQ");
    System.exit(0);
  }
  
  public boolean b()
  {
    QLog.i("QPSingleUpdEngine", 0, "Try Can Download");
    int i = 7920;
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_Int == 1) {}
    do
    {
      return true;
      while ((i > 0) && (a() != QPSingleUpdEngine.QP_SINGLEUPD_NET_TYPE.WIFI))
      {
        Thread.sleep(10000L);
        i -= 1;
      }
    } while (i > 0);
    return false;
  }
  
  public void c()
  {
    int i = 0;
    QLog.i("QPSingleUpdEngine", 0, "updateFileDirInit");
    Object localObject2 = BaseApplication.getContext().getFilesDir().getAbsolutePath();
    Object localObject4 = this.jdField_d_of_type_JavaLangString;
    Object localObject5 = this.jdField_d_of_type_JavaLangString + "Download";
    Object localObject3 = this.jdField_d_of_type_JavaLangString + "RollBack";
    Object localObject1 = this.jdField_d_of_type_JavaLangString + "QPLib";
    localObject2 = new File((String)localObject2);
    localObject4 = new File((String)localObject4);
    localObject5 = new File((String)localObject5);
    localObject3 = new File((String)localObject3);
    localObject1 = new File((String)localObject1);
    if (!((File)localObject2).exists()) {
      ((File)localObject2).mkdir();
    }
    if (!((File)localObject4).exists()) {
      ((File)localObject4).mkdir();
    }
    if (!((File)localObject5).exists()) {
      ((File)localObject5).mkdir();
    }
    for (;;)
    {
      if (!((File)localObject3).exists()) {
        ((File)localObject3).mkdir();
      }
      if (!((File)localObject1).exists()) {
        ((File)localObject1).mkdir();
      }
      return;
      localObject2 = ((File)localObject5).listFiles();
      if (localObject2 != null) {
        while (i < localObject2.length)
        {
          localObject2[i].delete();
          i += 1;
        }
      }
    }
  }
  
  /* Error */
  public boolean c()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 59	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo	Lcom/tencent/qqprotect/singleupdate/QPSinlgeUpdInfo;
    //   4: getfield 663	com/tencent/qqprotect/singleupdate/QPSinlgeUpdInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore_3
    //   8: new 73	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 74	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: getfield 47	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 753
    //   25: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 43
    //   30: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: new 76	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 475	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 741	java/io/File:exists	()Z
    //   52: ifeq +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 751	java/io/File:delete	()Z
    //   60: pop
    //   61: ldc 24
    //   63: iconst_0
    //   64: ldc_w 755
    //   67: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: new 757	java/net/URL
    //   73: dup
    //   74: aload_3
    //   75: invokespecial 758	java/net/URL:<init>	(Ljava/lang/String;)V
    //   78: invokevirtual 762	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   81: astore_3
    //   82: ldc 24
    //   84: iconst_0
    //   85: ldc_w 764
    //   88: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: new 766	java/io/BufferedInputStream
    //   94: dup
    //   95: aload_3
    //   96: invokevirtual 769	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   99: invokespecial 772	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   102: astore_3
    //   103: ldc 24
    //   105: iconst_0
    //   106: ldc_w 774
    //   109: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   112: new 776	java/io/FileOutputStream
    //   115: dup
    //   116: aload_2
    //   117: invokespecial 777	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   120: astore_2
    //   121: ldc 24
    //   123: iconst_0
    //   124: ldc_w 779
    //   127: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: sipush 512
    //   133: newarray byte
    //   135: astore 4
    //   137: aload_3
    //   138: aload 4
    //   140: iconst_0
    //   141: sipush 512
    //   144: invokevirtual 780	java/io/BufferedInputStream:read	([BII)I
    //   147: istore_1
    //   148: iload_1
    //   149: iconst_m1
    //   150: if_icmpeq +34 -> 184
    //   153: aload_2
    //   154: aload 4
    //   156: iconst_0
    //   157: iload_1
    //   158: invokevirtual 783	java/io/FileOutputStream:write	([BII)V
    //   161: goto -24 -> 137
    //   164: astore_2
    //   165: aload_0
    //   166: getfield 55	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   169: iconst_1
    //   170: putfield 786	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:m	Z
    //   173: ldc 24
    //   175: iconst_0
    //   176: ldc_w 788
    //   179: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iconst_0
    //   183: ireturn
    //   184: aload_2
    //   185: invokevirtual 789	java/io/FileOutputStream:close	()V
    //   188: aload_3
    //   189: invokevirtual 790	java/io/BufferedInputStream:close	()V
    //   192: aload_0
    //   193: getfield 55	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   196: iconst_1
    //   197: putfield 793	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:l	Z
    //   200: ldc 24
    //   202: iconst_0
    //   203: ldc_w 795
    //   206: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   209: aload_0
    //   210: getfield 55	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   213: iconst_1
    //   214: putfield 793	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:l	Z
    //   217: iconst_1
    //   218: ireturn
    //   219: astore_2
    //   220: aload_0
    //   221: getfield 55	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   224: iconst_1
    //   225: putfield 798	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:q	Z
    //   228: ldc 24
    //   230: iconst_0
    //   231: ldc_w 800
    //   234: invokestatic 158	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: goto -55 -> 182
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	240	0	this	QPSingleUpdEngine
    //   147	11	1	i	int
    //   36	118	2	localObject1	Object
    //   164	21	2	localConnectException	ConnectException
    //   219	1	2	localException	Exception
    //   7	182	3	localObject2	Object
    //   45	110	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	61	164	java/net/ConnectException
    //   61	137	164	java/net/ConnectException
    //   137	148	164	java/net/ConnectException
    //   153	161	164	java/net/ConnectException
    //   184	217	164	java/net/ConnectException
    //   0	61	219	java/lang/Exception
    //   61	137	219	java/lang/Exception
    //   137	148	219	java/lang/Exception
    //   153	161	219	java/lang/Exception
    //   184	217	219	java/lang/Exception
  }
  
  public boolean d()
  {
    File localFile = new File(this.jdField_d_of_type_JavaLangString + "Download/" + "TxSingleUpd.zip");
    if (!localFile.exists())
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.s = true;
      return false;
    }
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_JavaLangString.equalsIgnoreCase(MD5FileUtil.a(localFile)))
    {
      QLog.i("QPSingleUpdEngine", 0, "checkDownloadFile Success");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.r = true;
      return true;
    }
    QLog.i("QPSingleUpdEngine", 0, "checkDownloadFile Failed");
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.t = true;
    return false;
  }
  
  public boolean e()
  {
    QLog.i("QPSingleUpdEngine", 0, "Begin UnzipFile and get files");
    String str1 = this.jdField_d_of_type_JavaLangString + "Download/" + "TxSingleUpd.zip";
    String str2 = this.jdField_d_of_type_JavaLangString + "Download";
    QPUpdFileOperation.a(str1, str2);
    File localFile1 = new File(str2 + "/SupportUpd.cfg");
    if (!localFile1.exists())
    {
      QLog.i("QPSingleUpdEngine", 0, "getUpdateFile Failed");
      return false;
    }
    File localFile2 = new File(QPSupportUpdCfg.CFG_FILEPATH);
    new QPSupportUpdCfg().ReadConfigFile(str2 + "SupportUpd.cfg");
    if (!MD5FileUtil.a(localFile2).equalsIgnoreCase(MD5FileUtil.a(localFile1)))
    {
      QPUpdFileOperation.b(localFile2, localFile1);
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.ReadConfigFile(QPSupportUpdCfg.CFG_FILEPATH);
    }
    new File(str1).delete();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.u = true;
    return true;
  }
  
  public boolean f()
  {
    int j = 0;
    QLog.i("QPSingleUpdEngine", 0, "Begin backupRollbackFile");
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem == null) {
      return true;
    }
    String str1 = this.jdField_d_of_type_JavaLangString + "RollBack/";
    Object localObject = new File(str1).listFiles();
    if (localObject != null)
    {
      i = 0;
      while (i < localObject.length)
      {
        localObject[i].delete();
        i += 1;
      }
    }
    int k = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileItemCount();
    int i = j;
    if (i < k)
    {
      localObject = new File(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      String str2 = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      if (!((File)localObject).exists()) {}
      for (;;)
      {
        i += 1;
        break;
        QPUpdFileOperation.a(new File(str1 + str2), (File)localObject);
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.v = true;
    return true;
  }
  
  public boolean g()
  {
    QLog.i("QPSingleUpdEngine", 0, "roll Back !!!!!!!!!!!!!!!!!!");
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem == null) {
      return true;
    }
    File[] arrayOfFile = new File(this.jdField_d_of_type_JavaLangString + "Rollback/").listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.IsFileInConfigFile(arrayOfFile[i].getName())) {
          QPUpdFileOperation.a(new File(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileDstPath(arrayOfFile[i].getName())), arrayOfFile[i]);
        }
        i += 1;
      }
      i = 0;
      while (i < arrayOfFile.length)
      {
        arrayOfFile[i].delete();
        i += 1;
      }
    }
    QLog.i("QPSingleUpdEngine", 0, "roll Back Success");
    return true;
  }
  
  public boolean h()
  {
    boolean bool2 = false;
    QLog.i("QPSingleUpdEngine", 0, "Begin updateFile");
    boolean bool1;
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem == null)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.B = true;
      bool1 = true;
      return bool1;
    }
    int j = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem.length;
    QLog.i("QPSingleUpdEngine", 0, "listNeedUpdateFile = " + j);
    int i = 0;
    label71:
    Object localObject1;
    if (i < j)
    {
      Object localObject2 = new String(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      if (QPUpdFileOperation.a((String)localObject2).equalsIgnoreCase("SupportUpd.cfg")) {}
      for (;;)
      {
        i += 1;
        break label71;
        localObject1 = this.jdField_d_of_type_JavaLangString + "Download/" + QPUpdFileOperation.a((String)localObject2);
        localObject2 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileDstPath((String)localObject2);
        bool1 = bool2;
        if (localObject2 == null) {
          break;
        }
        localObject1 = new File((String)localObject1);
        localObject2 = new File((String)localObject2);
        bool1 = bool2;
        if (!((File)localObject1).exists()) {
          break;
        }
        QPUpdFileOperation.b((File)localObject2, (File)localObject1);
      }
    }
    i = 0;
    if (i < this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem.length)
    {
      localObject1 = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath;
      if (QPUpdFileOperation.a((String)localObject1).equalsIgnoreCase("SupportUpd.cfg")) {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = "";
      }
      for (;;)
      {
        i += 1;
        break;
        localObject1 = new File((String)localObject1);
        if (!((File)localObject1).exists()) {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = "";
        } else {
          this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash = MD5FileUtil.a((File)localObject1);
        }
      }
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.WriteConfigFile();
    QLog.i("QPSingleUpdEngine", 0, "updateFile Success");
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.B = true;
    return true;
  }
  
  public boolean i()
  {
    QLog.i("QPSingleUpdEngine", 0, "uploadReport");
    try
    {
      QPSingleUpdateProto.Head localHead = new QPSingleUpdateProto.Head();
      a(localHead, new QPSingleUpdateProto.ReqBody());
      this.jdField_a_of_type_JavaNetSocket = new Socket(InetAddress.getByName("qd-up.m.qq.com"), 14000);
      QLog.i("QPSingleUpdEngine", 0, "uploadReport Create Socket Success");
      OutputStream localOutputStream = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
      QLog.i("QPSingleUpdEngine", 0, "uploadReport GetOutputStream Successs");
      Object localObject1 = InetAddress.getLocalHost().getAddress();
      int i = localObject1[0];
      int j = localObject1[1];
      int k = localObject1[2];
      int m = localObject1[3];
      localHead.uint32_client_ip.set(m | i << 24 | j << 16 | k << 8);
      localHead.uint32_client_port.set(this.jdField_a_of_type_JavaNetSocket.getLocalPort());
      localHead.uint32_subcmd.set(1);
      QPSingleUpdateProto.ReqBody localReqBody = new QPSingleUpdateProto.ReqBody();
      Object localObject2 = ByteStringMicro.copyFrom("".getBytes());
      Object localObject4 = ByteStringMicro.copyFrom("".getBytes());
      if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.a)
      {
        localReqBody.msg_report.uint32_suc.set(1);
        localObject1 = localObject4;
        if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.b)
        {
          localObject2 = ByteStringMicro.copyFrom("NotNeedtoUpdate".getBytes());
          localObject1 = localObject4;
        }
      }
      for (;;)
      {
        localReqBody.msg_report.bytes_failed_step.set((ByteStringMicro)localObject2);
        localReqBody.msg_report.bytes_failed_reason.set((ByteStringMicro)localObject1);
        localReqBody.setHasFlag(true);
        localReqBody.msg_report.setHasFlag(true);
        localObject1 = localHead.toByteArray();
        localObject2 = localReqBody.toByteArray();
        Object localObject3 = new ByteArrayOutputStream(localObject1.length + 10 + localObject2.length);
        localObject4 = new DataOutputStream((OutputStream)localObject3);
        ((ByteArrayOutputStream)localObject3).write(2);
        ((DataOutputStream)localObject4).writeInt(localObject1.length);
        ((DataOutputStream)localObject4).writeInt(localObject2.length);
        ((ByteArrayOutputStream)localObject3).write((byte[])localObject1);
        ((ByteArrayOutputStream)localObject3).write((byte[])localObject2);
        ((ByteArrayOutputStream)localObject3).write(3);
        QLog.i("QPSingleUpdEngine", 0, "uploadReport reqHeadLen = " + localObject1.length);
        QLog.i("QPSingleUpdEngine", 0, "uploadReport reqBodyLen = " + localObject2.length);
        ((DataOutputStream)localObject4).close();
        ((ByteArrayOutputStream)localObject3).close();
        this.jdField_a_of_type_JavaNetSocket.setSoTimeout(10000);
        localOutputStream.write(((ByteArrayOutputStream)localObject3).toByteArray());
        localOutputStream.close();
        this.jdField_a_of_type_JavaNetSocket.close();
        return true;
        if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d)
        {
          localObject3 = ByteStringMicro.copyFrom("RequestStep".getBytes());
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestTimeout".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.f)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestNotGetRsp".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g)
          {
            localObject1 = ByteStringMicro.copyFrom("CannotResolvePackage".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.h)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestIOException".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.i)
          {
            localObject1 = ByteStringMicro.copyFrom("RspNoBody".getBytes());
            localObject2 = localObject3;
          }
          else if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.j)
          {
            localObject1 = ByteStringMicro.copyFrom("RequestJustException".getBytes());
            localObject2 = localObject3;
          }
          else
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.k)
            {
              localObject1 = ByteStringMicro.copyFrom("RspStxOrEtxError".getBytes());
              localObject2 = localObject3;
            }
          }
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.l)
        {
          localObject3 = ByteStringMicro.copyFrom("DownloadStep".getBytes());
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.m)
          {
            localObject1 = ByteStringMicro.copyFrom("ConnectFailed".getBytes());
            localObject2 = localObject3;
          }
          else
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.q)
            {
              localObject1 = ByteStringMicro.copyFrom("DownloadUnknowError".getBytes());
              localObject2 = localObject3;
            }
          }
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.r)
        {
          localObject3 = ByteStringMicro.copyFrom("CheckHashStep".getBytes());
          if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.s)
          {
            localObject1 = ByteStringMicro.copyFrom("CheckHashNotFindFile".getBytes());
            localObject2 = localObject3;
          }
          else
          {
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.t)
            {
              localObject1 = ByteStringMicro.copyFrom("CheckHashNotEqual".getBytes());
              localObject2 = localObject3;
            }
          }
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.u)
        {
          localObject2 = ByteStringMicro.copyFrom("UnZipFileStep".getBytes());
          localObject1 = ByteStringMicro.copyFrom("UnZipFileFailed".getBytes());
        }
        else if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.v)
        {
          localObject2 = ByteStringMicro.copyFrom("RollbackSaveFileStep".getBytes());
          localObject1 = ByteStringMicro.copyFrom("SaveFileFailed".getBytes());
        }
        else
        {
          localObject1 = localObject4;
          if (!this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.B)
          {
            localObject3 = ByteStringMicro.copyFrom("UpdateStep".getBytes());
            localObject1 = localObject4;
            localObject2 = localObject3;
            if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.C)
            {
              localObject1 = ByteStringMicro.copyFrom("ReplaceFileFailed".getBytes());
              localObject2 = localObject3;
            }
          }
        }
      }
      return true;
    }
    catch (Exception localException)
    {
      QLog.i("QPSingleUpdEngine", 0, "uploadReport Exception");
    }
  }
  
  public boolean j()
  {
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_Int == 1) {
      return true;
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.a = true;
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.b = true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdEngine
 * JD-Core Version:    0.7.0.1
 */