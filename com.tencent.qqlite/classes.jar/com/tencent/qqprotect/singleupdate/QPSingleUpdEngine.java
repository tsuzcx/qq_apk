package com.tencent.qqprotect.singleupdate;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.tencent.common.config.AppSetting;
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
  private static final String f = "EmulatorDetect";
  final int jdField_a_of_type_Int = 10000;
  QPCheckCanRestartThread jdField_a_of_type_ComTencentQqprotectSingleupdateQPCheckCanRestartThread = null;
  QPSingleUpdReportSig jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig = null;
  QPSingleUpdStateCfg jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg = null;
  QPSinlgeUpdInfo jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo = null;
  QPSupportUpdCfg jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg = null;
  final String jdField_a_of_type_JavaLangString = "QPSingleUpdEngine";
  Socket jdField_a_of_type_JavaNetSocket;
  final int jdField_b_of_type_Int = 60000;
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
  
  public int a()
  {
    Object localObject1 = BaseApplication.getContext();
    BaseApplication.getContext();
    Object localObject2 = (ConnectivityManager)((Context)localObject1).getSystemService("connectivity");
    localObject1 = ((ConnectivityManager)localObject2).getNetworkInfo(1);
    localObject2 = ((ConnectivityManager)localObject2).getNetworkInfo(0);
    if ((localObject1 != null) && (((NetworkInfo)localObject1).getState() == NetworkInfo.State.CONNECTED)) {
      return 1;
    }
    if ((localObject2 != null) && (((NetworkInfo)localObject2).getState() == NetworkInfo.State.CONNECTED)) {
      return 2;
    }
    return 0;
  }
  
  public void a()
  {
    QLog.d("QPSingleUpdEngine", 0, "Engine started");
    c();
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.a())
    {
      QLog.d("QPSingleUpdEngine", 0, "Today is updated");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c();
      return;
    }
    if (this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdStateCfg.c())
    {
      QLog.d("QPSingleUpdEngine", 0, "Today is updated");
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
      QLog.d("QPSingleUpdEngine", 0, "there is another Update thread is running");
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
      Thread.sleep(60000L);
      QLog.d("QPSingleUpdEngine", 0, "requestUpdate error !!!");
    }
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d = true;
    if (!j())
    {
      QLog.d("QPSingleUpdEngine", 0, "the ClientFile is Already the highest version");
      i();
      return;
    }
    QLog.d("QPSingleUpdEngine", 0, "Need to Update");
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
    QLog.d("QPSingleUpdEngine", 0, "Engine Ended");
  }
  
  public void a(QPSingleUpdateProto.Head paramHead, QPSingleUpdateProto.ReqBody paramReqBody)
  {
    QLog.d("QPSingleUpdEngine", 0, "getBaseInfo");
    paramHead.setHasFlag(true);
    paramHead.uint64_uin.set(Long.parseLong(this.jdField_e_of_type_JavaLangString));
    paramHead.uint32_command.set(0);
    paramHead.uint32_seq.set(0);
    Object localObject1 = new String();
    int i = 0;
    Object localObject2;
    while (i < "3.4.0".length())
    {
      localObject2 = localObject1;
      if ("3.4.0".charAt(i) != '.') {
        localObject2 = ((String)localObject1).concat(Character.toString("3.4.0".charAt(i)));
      }
      i += 1;
      localObject1 = localObject2;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmulatorDetect", 2, "SubVer = " + (String)localObject1);
    }
    paramHead.uint32_version.set(Integer.parseInt((String)localObject1));
    paramHead.uint32_retry_times.set(3);
    paramHead.uint32_client_type.set(1);
    localObject1 = String.format("%d", new Object[] { Integer.valueOf(AppSetting.jdField_a_of_type_Int) });
    if (QLog.isColorLevel()) {
      QLog.d("EmulatorDetect", 2, "appID = " + (String)localObject1);
    }
    paramHead.uint32_pubno.set(Integer.parseInt((String)localObject1));
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
    i = a();
    if (i == 1) {
      paramHead.uint32_net_type.set(1);
    }
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmulatorDetect", 2, "EmulatorDetectFactory Start!!");
        }
        i = new EmulatorDetectFactory().a("ENCRYPTFILE");
        paramHead.uint32_emulator_flag.set(i);
        if (QLog.isColorLevel()) {
          QLog.d("EmulatorDetect", 2, "detectresult = " + i);
        }
      }
      catch (Exception localException)
      {
        int j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("EmulatorDetect", 2, "EmulatorDetectFactory emulator Error!!");
        paramHead.uint32_emulator_flag.set(5);
        continue;
        paramHead = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFileHash);
        continue;
        QLog.d("QPSingleUpdEngine", 0, "getBaseInfo___end");
      }
      localObject1 = new Timestamp(new Date().getTime());
      paramHead.uint32_timestamp.set(((Timestamp)localObject1).getNanos());
      paramHead.uint32_subcmd.set(0);
      paramHead.uint32_result.set(0);
      paramHead.uint32_flag.set(1);
      j = this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.getFileItemCount();
      paramReqBody.setHasFlag(true);
      i = 0;
      if (i >= j) {
        continue;
      }
      localObject1 = new QPSingleUpdateProto.FileItem();
      paramHead = QPUpdFileOperation.a(this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSupportUpdCfg.fileItem[i].strFilePath);
      localObject2 = ByteStringMicro.copyFrom(paramHead.getBytes());
      ((QPSingleUpdateProto.FileItem)localObject1).bytes_name.set((ByteStringMicro)localObject2);
      if (!paramHead.equalsIgnoreCase("SupportUpd.cfg")) {
        continue;
      }
      paramHead = MD5FileUtil.a(new File(this.jdField_d_of_type_JavaLangString + "SupportUpd.cfg"));
      paramHead = ByteStringMicro.copyFrom(paramHead.getBytes());
      ((QPSingleUpdateProto.FileItem)localObject1).bytes_hash.set(paramHead);
      ((QPSingleUpdateProto.FileItem)localObject1).setHasFlag(true);
      paramReqBody.rpt_file_item_list.add((MessageMicro)localObject1);
      i += 1;
      continue;
      if (i == 2) {
        paramHead.uint32_net_type.set(2);
      }
    }
  }
  
  public boolean a()
  {
    QLog.d("QPSingleUpdEngine", 0, "Begin Request");
    Object localObject4 = new QPSingleUpdateProto.Head();
    Object localObject3 = new QPSingleUpdateProto.ReqBody();
    try
    {
      a((QPSingleUpdateProto.Head)localObject4, (QPSingleUpdateProto.ReqBody)localObject3);
      Object localObject1 = InetAddress.getByName("qd-up.m.qq.com");
      QLog.d("QPSingleUpdEngine", 0, "Start Create Socket!!!");
      this.jdField_a_of_type_JavaNetSocket = new Socket((InetAddress)localObject1, 14000);
      QLog.d("QPSingleUpdEngine", 0, "Create Socket Success");
      localObject1 = this.jdField_a_of_type_JavaNetSocket.getOutputStream();
      QLog.d("QPSingleUpdEngine", 0, "GetOutputStream Successs");
      Object localObject5 = InetAddress.getLocalHost().getAddress();
      int i = localObject5[0];
      int j = localObject5[1];
      int k = localObject5[2];
      int m = localObject5[3];
      ((QPSingleUpdateProto.Head)localObject4).uint32_client_ip.set(m | i << 24 | j << 16 | k << 8);
      ((QPSingleUpdateProto.Head)localObject4).uint32_client_port.set(this.jdField_a_of_type_JavaNetSocket.getLocalPort());
      localObject4 = ((QPSingleUpdateProto.Head)localObject4).toByteArray();
      localObject3 = ((QPSingleUpdateProto.ReqBody)localObject3).toByteArray();
      localObject5 = new ByteArrayOutputStream(localObject4.length + 10 + localObject3.length);
      Object localObject6 = new DataOutputStream((OutputStream)localObject5);
      ((ByteArrayOutputStream)localObject5).write(2);
      ((DataOutputStream)localObject6).writeInt(localObject4.length);
      ((DataOutputStream)localObject6).writeInt(localObject3.length);
      ((ByteArrayOutputStream)localObject5).write((byte[])localObject4);
      ((ByteArrayOutputStream)localObject5).write((byte[])localObject3);
      ((ByteArrayOutputStream)localObject5).write(3);
      QLog.d("QPSingleUpdEngine", 0, "reqHeadLen = " + localObject4.length);
      QLog.d("QPSingleUpdEngine", 0, "reqBodyLen = " + localObject3.length);
      ((DataOutputStream)localObject6).close();
      ((ByteArrayOutputStream)localObject5).close();
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(15000);
      ((OutputStream)localObject1).write(((ByteArrayOutputStream)localObject5).toByteArray());
      QLog.d("QPSingleUpdEngine", 0, "Send Request Success");
      localObject3 = this.jdField_a_of_type_JavaNetSocket.getInputStream();
      QLog.d("QPSingleUpdEngine", 0, "GetInputStream Success");
      this.jdField_a_of_type_JavaNetSocket.setSoTimeout(15000);
      i = ((InputStream)localObject3).read();
      QLog.d("QPSingleUpdEngine", 0, "Got STX");
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
          return false;
        }
      }
      localObject4 = new byte[4];
      if (((InputStream)localObject3).read((byte[])localObject4, 0, 4) < 4)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException2)
        {
          return false;
        }
      }
      a((byte[])localObject4);
      i = a((byte[])localObject4);
      QLog.d("QPSingleUpdEngine", 0, "iHeadLen = " + i);
      if (i == 0) {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
      }
      localObject4 = new byte[4];
      if (((InputStream)localObject3).read((byte[])localObject4, 0, 4) < 4)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException3)
        {
          return false;
        }
      }
      a((byte[])localObject4);
      j = a((byte[])localObject4);
      QLog.d("QPSingleUpdEngine", 0, "iBodyLen = " + j);
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
          return false;
        }
      }
      localObject5 = new byte[i];
      if (((InputStream)localObject3).read((byte[])localObject5, 0, i) < i)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException5)
        {
          return false;
        }
      }
      localObject6 = new QPSingleUpdateProto.Head();
      localObject4 = new QPSingleUpdateProto.RspBody();
      boolean bool = a((QPSingleUpdateProto.Head)((QPSingleUpdateProto.Head)localObject6).mergeFrom((byte[])localObject5));
      if (!bool) {
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException6)
        {
          return false;
        }
      }
      localObject5 = new byte[j];
      if (((InputStream)localObject3).read((byte[])localObject5, 0, j) < j)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
        try
        {
          this.jdField_a_of_type_JavaNetSocket.close();
          return false;
        }
        catch (IOException localIOException7)
        {
          return false;
        }
      }
      localObject4 = (QPSingleUpdateProto.RspBody)((QPSingleUpdateProto.RspBody)localObject4).mergeFrom((byte[])localObject5);
      a((QPSingleUpdateProto.RspBody)localObject4);
      QLog.d("QPSingleUpdEngine", 0, "Got Entire Rsp Package");
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject4).uint32_update_vailable.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject4).uint32_force_download.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_c_of_type_Int = ((QPSingleUpdateProto.RspBody)localObject4).uint32_download_type.get();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_JavaLangString = new String(((QPSingleUpdateProto.RspBody)localObject4).bytes_packet_url.get().toByteArray());
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_b_of_type_JavaLangString = new String(((QPSingleUpdateProto.RspBody)localObject4).bytes_packet_hash.get().toByteArray());
      QLog.d("QPSingleUpdEngine", 0, "hit test");
      j = ((QPSingleUpdateProto.RspBody)localObject4).rpt_file_item_list.size();
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.a(j);
      localObject5 = new QPSingleUpdateProto.FileItem[j];
      localObject4 = (QPSingleUpdateProto.FileItem[])((QPSingleUpdateProto.RspBody)localObject4).rpt_file_item_list.get().toArray((Object[])localObject5);
      QLog.d("QPSingleUpdEngine", 0, "hit test");
      i = 0;
      while (i < j)
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_ArrayOfFgq[i].jdField_a_of_type_JavaLangString = new String(localObject4[i].bytes_name.get().toByteArray());
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo.jdField_a_of_type_ArrayOfFgq[i].jdField_b_of_type_JavaLangString = new String(localObject4[i].bytes_hash.get().toByteArray());
        i += 1;
      }
      i = ((InputStream)localObject3).read();
      QLog.d("QPSingleUpdEngine", 0, "Got ETX");
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
          return false;
        }
      }
      localIOException8.close();
      ((InputStream)localObject3).close();
      QLog.d("QPSingleUpdEngine", 0, "Request Function Success");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.d = true;
        return true;
      }
      catch (IOException localIOException9)
      {
        return false;
      }
      return false;
    }
    catch (ConnectException localConnectException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp Connect Exception");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException10)
      {
        return false;
      }
    }
    catch (SocketTimeoutException localSocketTimeoutException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.e = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp SocketTimeoutException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException11)
      {
        return false;
      }
    }
    catch (EOFException localEOFException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.f = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp EOFException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException12)
      {
        return false;
      }
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.g = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp InvalidProtocolBufferMicroException");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException13)
      {
        return false;
      }
    }
    catch (IOException localIOException14)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.h = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp IOException read or write Error");
      QLog.i("QPSingleUpdEngine", 0, "fuck error!!!");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException15)
      {
        return false;
      }
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig.j = true;
      QLog.i("QPSingleUpdEngine", 0, "Req/Rsp Exception");
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        return false;
      }
      catch (IOException localIOException16)
      {
        return false;
      }
    }
    finally
    {
      try
      {
        this.jdField_a_of_type_JavaNetSocket.close();
        throw localObject2;
      }
      catch (IOException localIOException17) {}
    }
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
      while ((i > 0) && (a() != 1))
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
    //   1: getfield 62	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSinlgeUpdInfo	Lcom/tencent/qqprotect/singleupdate/QPSinlgeUpdInfo;
    //   4: getfield 691	com/tencent/qqprotect/singleupdate/QPSinlgeUpdInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   7: astore_3
    //   8: new 76	java/lang/StringBuilder
    //   11: dup
    //   12: invokespecial 77	java/lang/StringBuilder:<init>	()V
    //   15: aload_0
    //   16: getfield 50	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_d_of_type_JavaLangString	Ljava/lang/String;
    //   19: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: ldc_w 785
    //   25: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: ldc 46
    //   30: invokevirtual 87	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   36: astore_2
    //   37: new 79	java/io/File
    //   40: dup
    //   41: aload_2
    //   42: invokespecial 505	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore 4
    //   47: aload 4
    //   49: invokevirtual 773	java/io/File:exists	()Z
    //   52: ifeq +9 -> 61
    //   55: aload 4
    //   57: invokevirtual 783	java/io/File:delete	()Z
    //   60: pop
    //   61: ldc 27
    //   63: iconst_0
    //   64: ldc_w 787
    //   67: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: new 789	java/net/URL
    //   73: dup
    //   74: ldc_w 791
    //   77: aload_3
    //   78: invokestatic 797	com/tencent/mobileqq/msf/sdk/MsfSdkUtils:insertMtype	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   81: invokespecial 798	java/net/URL:<init>	(Ljava/lang/String;)V
    //   84: invokevirtual 802	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   87: astore_3
    //   88: ldc 27
    //   90: iconst_0
    //   91: ldc_w 804
    //   94: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   97: new 806	java/io/BufferedInputStream
    //   100: dup
    //   101: aload_3
    //   102: invokevirtual 809	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   105: invokespecial 812	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   108: astore_3
    //   109: ldc 27
    //   111: iconst_0
    //   112: ldc_w 814
    //   115: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: new 816	java/io/FileOutputStream
    //   121: dup
    //   122: aload_2
    //   123: invokespecial 817	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   126: astore_2
    //   127: ldc 27
    //   129: iconst_0
    //   130: ldc_w 819
    //   133: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   136: sipush 512
    //   139: newarray byte
    //   141: astore 4
    //   143: aload_3
    //   144: aload 4
    //   146: iconst_0
    //   147: sipush 512
    //   150: invokevirtual 820	java/io/BufferedInputStream:read	([BII)I
    //   153: istore_1
    //   154: iload_1
    //   155: iconst_m1
    //   156: if_icmpeq +34 -> 190
    //   159: aload_2
    //   160: aload 4
    //   162: iconst_0
    //   163: iload_1
    //   164: invokevirtual 823	java/io/FileOutputStream:write	([BII)V
    //   167: goto -24 -> 143
    //   170: astore_2
    //   171: aload_0
    //   172: getfield 58	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   175: iconst_1
    //   176: putfield 826	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:m	Z
    //   179: ldc 27
    //   181: iconst_0
    //   182: ldc_w 828
    //   185: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iconst_0
    //   189: ireturn
    //   190: aload_2
    //   191: invokevirtual 829	java/io/FileOutputStream:close	()V
    //   194: aload_3
    //   195: invokevirtual 830	java/io/BufferedInputStream:close	()V
    //   198: aload_0
    //   199: getfield 58	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   202: iconst_1
    //   203: putfield 833	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:l	Z
    //   206: ldc 27
    //   208: iconst_0
    //   209: ldc_w 835
    //   212: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: aload_0
    //   216: getfield 58	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   219: iconst_1
    //   220: putfield 833	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:l	Z
    //   223: iconst_1
    //   224: ireturn
    //   225: astore_2
    //   226: aload_0
    //   227: getfield 58	com/tencent/qqprotect/singleupdate/QPSingleUpdEngine:jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdReportSig	Lcom/tencent/qqprotect/singleupdate/QPSingleUpdReportSig;
    //   230: iconst_1
    //   231: putfield 838	com/tencent/qqprotect/singleupdate/QPSingleUpdReportSig:q	Z
    //   234: ldc 27
    //   236: iconst_0
    //   237: ldc_w 840
    //   240: invokestatic 733	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   243: goto -55 -> 188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	246	0	this	QPSingleUpdEngine
    //   153	11	1	i	int
    //   36	124	2	localObject1	Object
    //   170	21	2	localConnectException	ConnectException
    //   225	1	2	localException	Exception
    //   7	188	3	localObject2	Object
    //   45	116	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   0	61	170	java/net/ConnectException
    //   61	143	170	java/net/ConnectException
    //   143	154	170	java/net/ConnectException
    //   159	167	170	java/net/ConnectException
    //   190	223	170	java/net/ConnectException
    //   0	61	225	java/lang/Exception
    //   61	143	225	java/lang/Exception
    //   143	154	225	java/lang/Exception
    //   159	167	225	java/lang/Exception
    //   190	223	225	java/lang/Exception
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdEngine
 * JD-Core Version:    0.7.0.1
 */