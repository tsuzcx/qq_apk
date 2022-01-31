package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.data.FMConstants;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.discoperation.FileHttpUtils;
import com.tencent.mobileqq.filemanager.discoperation.IFileHttpBase;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import com.tencent.wstt.SSCM.Utils;
import com.weiyun.sdk.IWyTaskManager.Task;
import dns;
import dnu;
import dnv;
import dnw;
import dnx;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class FileManagerRSWorker
  implements IFileHttpBase, IHttpCommunicatorListener
{
  private static final int e = 8;
  private static final int f = 6000;
  private static final String jdField_k_of_type_JavaLangString = "FileManagerRSWorker<FileAssistant>";
  private static final long m = 1000L;
  public int a;
  public long a;
  public QQAppInterface a;
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new dns(this);
  private HttpUrlProcessor jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor;
  public FileManagerEntity a;
  HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  public IWyTaskManager.Task a;
  File jdField_a_of_type_JavaIoFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  public OutputStream a;
  public String a;
  Thread jdField_a_of_type_JavaLangThread;
  boolean jdField_a_of_type_Boolean = false;
  int[] jdField_a_of_type_ArrayOfInt = new int[0];
  public int b;
  public long b;
  HttpMsg b;
  public String b;
  int c;
  public long c;
  public String c;
  public int d;
  public long d;
  public String d;
  public long e;
  public String e;
  public long f;
  public String f;
  private int g;
  public long g;
  public String g;
  private int h;
  public long h;
  public String h;
  private int i;
  public long i;
  public String i;
  private int j;
  public long j;
  public String j;
  long jdField_k_of_type_Long;
  long jdField_l_of_type_Long = 0L;
  private String jdField_l_of_type_JavaLangString = "";
  private long n = 0L;
  
  public FileManagerRSWorker(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_h_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaIoOutputStream = null;
    this.jdField_f_of_type_Long = 0L;
    this.jdField_g_of_type_Long = 0L;
    this.jdField_h_of_type_Long = 0L;
    this.jdField_i_of_type_JavaLangString = null;
    this.jdField_j_of_type_JavaLangString = null;
    this.jdField_i_of_type_Long = 0L;
    this.jdField_j_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = null;
    this.k = 0L;
    if (paramFileManagerEntity == null)
    {
      try
      {
        throw new NullPointerException("entry = null,why?");
      }
      catch (NullPointerException paramQQAppInterface)
      {
        paramQQAppInterface.printStackTrace();
      }
      return;
    }
    this.jdField_b_of_type_JavaLangString = paramFileManagerEntity.strFilePath;
    this.jdField_a_of_type_Int = paramFileManagerEntity.peerType;
    this.jdField_g_of_type_JavaLangString = paramFileManagerEntity.Uuid;
    this.jdField_b_of_type_Int = paramFileManagerEntity.nOpType;
    this.jdField_f_of_type_JavaLangString = paramFileManagerEntity.strServerPath;
    this.jdField_e_of_type_JavaLangString = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getAccount();
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName == null)) {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
    }
    b();
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      this.jdField_d_of_type_Long = paramFileManagerEntity.fileSize;
      this.jdField_b_of_type_Long = paramFileManagerEntity.uniseq;
      this.jdField_c_of_type_Long = paramFileManagerEntity.nSessionId;
      paramFileManagerEntity.status = 0;
      paramQQAppInterface.a().c(paramFileManagerEntity);
      paramFileManagerEntity.fProgress = 0.0F;
      paramFileManagerEntity.status = 2;
      if (this.jdField_a_of_type_ComTencentWsttSSCMSSCM != null) {
        break;
      }
      this.jdField_a_of_type_ComTencentWsttSSCMSSCM = new SSCM();
      return;
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + paramFileManagerEntity.nSessionId + "]" + "filepath[" + this.jdField_b_of_type_JavaLangString + "]:size[" + String.valueOf(paramFileManagerEntity.fileSize) + "]");
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileUp";
        this.jdField_j_of_type_JavaLangString = "actFileUpDetail";
      }
      while ((paramFileManagerEntity.strFilePath != null) && (paramFileManagerEntity.strFilePath.length() > 0))
      {
        this.jdField_a_of_type_JavaIoFile = new File(paramFileManagerEntity.strFilePath);
        break;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.jdField_i_of_type_JavaLangString = "actDiscussFileUp";
          this.jdField_j_of_type_JavaLangString = "actDiscussFileUpDetail";
        }
      }
      if ((this.jdField_b_of_type_JavaLangString == null) || (this.jdField_b_of_type_JavaLangString.equals(paramFileManagerEntity.fileName)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath");
        }
        this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, paramFileManagerEntity.fileName);
      }
      a(2);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDown";
        this.jdField_j_of_type_JavaLangString = "actFileDownDetail";
      }
      else if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
      {
        this.jdField_i_of_type_JavaLangString = "actFileDiscDownLoad";
        this.jdField_j_of_type_JavaLangString = "actFileDiscDownLoadDetail";
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
        }
        this.jdField_i_of_type_JavaLangString = "actFileWyDown";
        continue;
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
        }
        this.jdField_i_of_type_JavaLangString = "actFileWyUp";
      }
    }
  }
  
  private String a(ByteStringMicro paramByteStringMicro)
  {
    paramByteStringMicro = HexUtil.bytes2HexStr(paramByteStringMicro.toByteArray());
    return "/?ver=2&rkey=" + paramByteStringMicro;
  }
  
  private String a(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private String a(String paramString1, String paramString2, long paramLong)
  {
    return "/?ver=2&ukey=" + paramString1 + "&filekey=" + paramString2 + "&filesize=" + paramLong;
  }
  
  private void a(long paramLong, String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      String str2 = "bytes=" + paramLong + "-";
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_f_of_type_JavaLangString, null, this, true);
      localHttpMsg.b(false);
      String str1 = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localHttpMsg.a("Net-type", str1);
      localHttpMsg.a("cache-control", "no-cache");
      localHttpMsg.a("Range", str2);
      if (paramString != null) {
        localHttpMsg.a("Cookie", paramString);
      }
      localHttpMsg.b(1);
      localHttpMsg.a(true);
      localHttpMsg.jdField_d_of_type_Int = 0;
      localHttpMsg.e = this.jdField_a_of_type_Int;
      localHttpMsg.ae = String.valueOf(this.jdField_c_of_type_Long);
      QLog.d("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.jdField_a_of_type_Int) + "]");
      localHttpMsg.a("Accept-Encoding", "identity");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    } while (paramLong != 0L);
    a(2001);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 10, null, 6, null);
  }
  
  private void a(String paramString, long paramLong, int paramInt)
  {
    this.jdField_i_of_type_Long += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]" + "sendFilePakage transferData null");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((HttpMsg)localObject).b(false);
      ((HttpMsg)localObject).a("cache-control", "no-cache");
      paramString = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((HttpMsg)localObject).a("Net-type", paramString);
      ((HttpMsg)localObject).a("Range", "bytes=" + paramLong + "-");
      ((HttpMsg)localObject).c("POST");
      ((HttpMsg)localObject).b(1);
      ((HttpMsg)localObject).jdField_d_of_type_Int = 0;
      ((HttpMsg)localObject).e = this.jdField_a_of_type_Int;
      ((HttpMsg)localObject).ae = String.valueOf(this.jdField_c_of_type_Long);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.jdField_c_of_type_Long + "]" + "send http data size[" + paramInt + "], peerType[" + this.jdField_a_of_type_Int + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a((HttpMsg)localObject);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = ((HttpMsg)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (paramHttpMsg1 == null) {}
    do
    {
      return false;
      if (paramHttpMsg2 == null) {
        return true;
      }
    } while (!NetworkUtil.e(BaseApplication.getContext()));
    return true;
  }
  
  private static String e()
  {
    try
    {
      Thread.sleep(1L);
      long l1 = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l1));
      return str;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
    finally {}
  }
  
  private void j()
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    if (!FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString)))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "rename error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
      b(null, null);
      return;
    }
    Object localObject = HexUtil.bytes2HexStr(FileManagerUtil.b(this.jdField_b_of_type_JavaLangString));
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = this.jdField_b_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      if ((2 == this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType) && (!FileUtils.b(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath))) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strThumbPath = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_b_of_type_JavaLangString, 150, 150);
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
      a(2003);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
      this.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
      localObject = new FileManagerReporter.fileAssistantReportData();
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_b_of_type_JavaLangString = "rece_file_suc";
      ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
      }
      else
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      }
    }
  }
  
  public int a()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(String paramString1, String paramString2)
  {
    String str = AppConstants.ay;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = e();
    }
    paramString1 = new File(str + paramString1);
    QLog.d("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void a()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return;
    }
    if ((this.jdField_g_of_type_JavaLangString == null) || (this.jdField_g_of_type_JavaLangString.length() == 0))
    {
      b();
      return;
    }
    if (this.jdField_a_of_type_Int == 3000)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
  
  public void a(int paramInt)
  {
    paramInt = FileManagerUtil.c(paramInt);
    if ((this.jdField_j_of_type_Int == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.jdField_j_of_type_Int = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
    } while (paramInt == 2);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = this.jdField_e_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
    FileManagerEntity localFileManagerEntity = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.jdField_g_of_type_JavaLangString != null) {}
    for (String str = this.jdField_g_of_type_JavaLangString;; str = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)
    {
      localFileManagerEntity.Uuid = str;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  public void a(HttpMsg paramHttpMsg)
  {
    int i1;
    int i2;
    int i3;
    if (paramHttpMsg != null)
    {
      i1 = paramHttpMsg.jdField_d_of_type_Int;
      i2 = paramHttpMsg.e;
      i3 = paramHttpMsg.f;
      if (((i1 == -1) || (i2 == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + i1 + ",busiType:" + i2);
      }
      if (!"POST".equals(paramHttpMsg.e())) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, i3, i1, i2, paramHttpMsg.jdField_i_of_type_Int);
      return;
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 57	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ArrayOfInt	[I
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 73	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Boolean	Z
    //   13: ifeq +55 -> 68
    //   16: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +45 -> 64
    //   22: ldc_w 474
    //   25: iconst_2
    //   26: new 211	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 670
    //   36: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   43: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   46: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 672
    //   55: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 12
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 417	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   73: if_acmpeq +305 -> 378
    //   76: aload_1
    //   77: ifnull +92 -> 169
    //   80: aload_0
    //   81: getfield 417	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   84: ifnull +85 -> 169
    //   87: ldc 17
    //   89: iconst_1
    //   90: new 211	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 674
    //   100: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   107: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 676
    //   116: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 678	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   123: invokestatic 403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 680
    //   132: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: getfield 417	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   139: invokevirtual 678	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   142: invokestatic 403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 223
    //   150: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 12
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload 12
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +142 -> 312
    //   173: ldc 17
    //   175: iconst_1
    //   176: new 211	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 674
    //   186: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   193: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 676
    //   202: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 678	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   209: invokestatic 403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 223
    //   217: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -67 -> 159
    //   229: astore 10
    //   231: aload 10
    //   233: invokevirtual 681	java/lang/Exception:printStackTrace	()V
    //   236: ldc 17
    //   238: iconst_1
    //   239: aload 10
    //   241: invokevirtual 682	java/lang/Exception:toString	()Ljava/lang/String;
    //   244: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: ldc 104
    //   249: astore 9
    //   251: aload 10
    //   253: invokevirtual 686	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   256: astore 10
    //   258: aload 10
    //   260: arraylength
    //   261: istore 4
    //   263: iconst_0
    //   264: istore_3
    //   265: iload_3
    //   266: iload 4
    //   268: if_icmpge +1740 -> 2008
    //   271: aload 10
    //   273: iload_3
    //   274: aaload
    //   275: astore 11
    //   277: new 211	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   284: aload 9
    //   286: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 11
    //   291: invokevirtual 689	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: ldc_w 691
    //   297: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 9
    //   305: iload_3
    //   306: iconst_1
    //   307: iadd
    //   308: istore_3
    //   309: goto -44 -> 265
    //   312: aload_0
    //   313: getfield 417	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   316: ifnull -157 -> 159
    //   319: ldc 17
    //   321: iconst_1
    //   322: new 211	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 674
    //   332: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   339: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   342: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 693
    //   348: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 417	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   355: invokevirtual 678	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   358: invokestatic 403	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   361: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 223
    //   366: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -216 -> 159
    //   378: aload_0
    //   379: getfield 144	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Int	I
    //   382: ifne +1146 -> 1528
    //   385: aload_2
    //   386: invokevirtual 695	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   389: sipush 200
    //   392: if_icmpne +937 -> 1329
    //   395: aload_0
    //   396: getfield 200	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   399: invokevirtual 696	com/tencent/wstt/SSCM/SSCM:b	()V
    //   402: aload_2
    //   403: ldc_w 698
    //   406: invokevirtual 699	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   409: ifnull +1778 -> 2187
    //   412: aload_2
    //   413: ldc_w 698
    //   416: invokevirtual 699	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokestatic 634	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   422: lstore 5
    //   424: lload 5
    //   426: lconst_0
    //   427: lcmp
    //   428: ifeq +110 -> 538
    //   431: aload_0
    //   432: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: aload_0
    //   436: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   439: aload_0
    //   440: getfield 81	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   447: aload_0
    //   448: getfield 149	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload_0
    //   456: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   459: aload_0
    //   460: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   463: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   466: ldc2_w 700
    //   469: ldc 104
    //   471: aload_0
    //   472: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   475: aload_0
    //   476: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   479: aload_0
    //   480: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   483: aload_2
    //   484: invokevirtual 702	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   487: aload_2
    //   488: getfield 705	com/tencent/mobileqq/utils/httputils/HttpMsg:ah	Ljava/lang/String;
    //   491: aload_0
    //   492: getfield 102	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   495: new 211	java/lang/StringBuilder
    //   498: dup
    //   499: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   502: ldc_w 707
    //   505: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   508: lload 5
    //   510: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   513: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: ldc 223
    //   518: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: aconst_null
    //   525: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   528: aload_0
    //   529: aload_1
    //   530: aload_2
    //   531: invokevirtual 451	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   534: aload 12
    //   536: monitorexit
    //   537: return
    //   538: aload_2
    //   539: ldc_w 381
    //   542: invokevirtual 699	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   545: astore 9
    //   547: aload 9
    //   549: ifnull +1632 -> 2181
    //   552: aload 9
    //   554: invokestatic 634	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   557: lstore 5
    //   559: lload 5
    //   561: aload_0
    //   562: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   565: lcmp
    //   566: ifgt +434 -> 1000
    //   569: new 211	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   576: ldc_w 709
    //   579: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: lload 5
    //   584: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   587: ldc_w 711
    //   590: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: aload_0
    //   594: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   597: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   600: ldc_w 713
    //   603: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: aload_0
    //   607: getfield 55	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   610: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   613: ldc_w 715
    //   616: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: aload_0
    //   620: getfield 96	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   623: invokevirtual 472	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   626: ldc 223
    //   628: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   634: astore 9
    //   636: lload 5
    //   638: aload_0
    //   639: getfield 55	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   642: lcmp
    //   643: ifgt +247 -> 890
    //   646: aload_0
    //   647: getfield 96	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   650: iconst_1
    //   651: iadd
    //   652: istore_3
    //   653: aload_0
    //   654: iload_3
    //   655: putfield 96	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   658: iload_3
    //   659: iconst_3
    //   660: if_icmple +230 -> 890
    //   663: aload_0
    //   664: sipush 1005
    //   667: invokevirtual 242	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   670: aload_0
    //   671: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   674: invokevirtual 420	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   677: aload_0
    //   678: getfield 59	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   681: aload_0
    //   682: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   685: aload_0
    //   686: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   689: aload_0
    //   690: getfield 134	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   693: bipush 15
    //   695: aconst_null
    //   696: iconst_5
    //   697: aconst_null
    //   698: invokevirtual 425	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   701: aload_0
    //   702: invokevirtual 717	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:c	()V
    //   705: aload_0
    //   706: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   709: aload_0
    //   710: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   713: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   716: aload_0
    //   717: getfield 79	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   720: aload_0
    //   721: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   724: aload_0
    //   725: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   728: aload_0
    //   729: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   732: aload_0
    //   733: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   736: aload_0
    //   737: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   740: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   743: ldc2_w 718
    //   746: ldc 104
    //   748: aload_0
    //   749: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   752: aload_0
    //   753: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   756: aload_0
    //   757: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   760: aload_0
    //   761: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   764: ldc 104
    //   766: aload_0
    //   767: getfield 98	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   770: aload 9
    //   772: aconst_null
    //   773: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   776: ldc 17
    //   778: iconst_1
    //   779: new 211	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   786: ldc_w 721
    //   789: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   792: aload_0
    //   793: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   796: invokevirtual 221	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   799: ldc 223
    //   801: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   804: aload 9
    //   806: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   812: invokestatic 724	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   815: aload_0
    //   816: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   819: aload_0
    //   820: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   823: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   826: aload_0
    //   827: getfield 81	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   830: aload_0
    //   831: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   834: aload_0
    //   835: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   838: aload_0
    //   839: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   842: aload_0
    //   843: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   846: aload_0
    //   847: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   850: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   853: ldc2_w 718
    //   856: ldc 104
    //   858: aload_0
    //   859: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   862: aload_0
    //   863: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   866: aload_0
    //   867: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   870: aload_0
    //   871: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   874: ldc 104
    //   876: aload_0
    //   877: getfield 102	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   880: aload 9
    //   882: aconst_null
    //   883: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   886: aload 12
    //   888: monitorexit
    //   889: return
    //   890: aload_0
    //   891: lload 5
    //   893: putfield 55	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:n	J
    //   896: aload_0
    //   897: lload 5
    //   899: putfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   902: new 726	android/os/Handler
    //   905: dup
    //   906: invokespecial 727	android/os/Handler:<init>	()V
    //   909: new 729	dnt
    //   912: dup
    //   913: aload_0
    //   914: lload 5
    //   916: invokespecial 732	dnt:<init>	(Lcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker;J)V
    //   919: ldc2_w 733
    //   922: invokevirtual 738	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   925: pop
    //   926: aload_0
    //   927: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   930: aload_0
    //   931: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   934: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   937: aload_0
    //   938: getfield 81	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   941: aload_0
    //   942: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   945: aload_0
    //   946: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   949: aload_0
    //   950: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   953: aload_0
    //   954: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   957: aload_0
    //   958: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   961: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   964: ldc2_w 718
    //   967: ldc 104
    //   969: aload_0
    //   970: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   973: aload_0
    //   974: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   977: aload_0
    //   978: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   981: aload_0
    //   982: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   985: ldc 104
    //   987: aload_0
    //   988: getfield 102	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   991: aload 9
    //   993: aconst_null
    //   994: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   997: goto -221 -> 776
    //   1000: iconst_0
    //   1001: istore 4
    //   1003: iload 4
    //   1005: istore_3
    //   1006: aload_0
    //   1007: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1010: lconst_0
    //   1011: lcmp
    //   1012: ifne +67 -> 1079
    //   1015: iload 4
    //   1017: istore_3
    //   1018: lload 5
    //   1020: aload_0
    //   1021: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1024: lcmp
    //   1025: ifne +54 -> 1079
    //   1028: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1031: ifeq +1162 -> 2193
    //   1034: ldc_w 474
    //   1037: iconst_2
    //   1038: new 211	java/lang/StringBuilder
    //   1041: dup
    //   1042: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   1045: ldc_w 670
    //   1048: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1051: aload_0
    //   1052: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1055: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1058: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1061: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: ldc_w 740
    //   1067: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1076: goto +1117 -> 2193
    //   1079: aload_0
    //   1080: lload 5
    //   1082: putfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1085: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1088: ifeq +77 -> 1165
    //   1091: ldc 17
    //   1093: iconst_2
    //   1094: new 211	java/lang/StringBuilder
    //   1097: dup
    //   1098: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   1101: ldc 214
    //   1103: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload_0
    //   1107: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1110: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1113: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1116: ldc 223
    //   1118: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1121: ldc_w 469
    //   1124: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1127: aload_0
    //   1128: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1131: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1134: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: ldc_w 742
    //   1140: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: aload_0
    //   1144: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1147: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1150: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1153: ldc_w 744
    //   1156: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1159: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1162: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1165: lload 5
    //   1167: aload_0
    //   1168: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1171: lcmp
    //   1172: ifge +161 -> 1333
    //   1175: aload_0
    //   1176: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1179: aload_0
    //   1180: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1183: l2f
    //   1184: aload_0
    //   1185: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1188: l2f
    //   1189: fdiv
    //   1190: putfield 198	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1193: aload_0
    //   1194: sipush 1002
    //   1197: invokevirtual 242	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1200: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   1203: lstore 5
    //   1205: lload 5
    //   1207: aload_0
    //   1208: getfield 71	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1211: lsub
    //   1212: ldc2_w 20
    //   1215: lcmp
    //   1216: iflt +96 -> 1312
    //   1219: aload_0
    //   1220: lload 5
    //   1222: putfield 71	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1225: aload_0
    //   1226: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1229: iconst_3
    //   1230: putfield 567	com/tencent/mobileqq/filemanager/data/FileManagerEntity:cloudType	I
    //   1233: aload_0
    //   1234: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1237: invokevirtual 420	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1240: aload_0
    //   1241: getfield 59	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   1244: aload_0
    //   1245: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1248: aload_0
    //   1249: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1252: aload_0
    //   1253: getfield 134	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1256: bipush 16
    //   1258: aconst_null
    //   1259: iconst_0
    //   1260: aconst_null
    //   1261: invokevirtual 425	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1264: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1267: ifeq +45 -> 1312
    //   1270: ldc 17
    //   1272: iconst_2
    //   1273: new 211	java/lang/StringBuilder
    //   1276: dup
    //   1277: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   1280: ldc 214
    //   1282: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1285: aload_0
    //   1286: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1289: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1292: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1295: ldc 223
    //   1297: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1300: ldc_w 746
    //   1303: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1306: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1309: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1312: aload_0
    //   1313: iconst_0
    //   1314: putfield 98	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1317: aload_0
    //   1318: aload_0
    //   1319: getfield 149	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1322: aload_0
    //   1323: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1326: invokevirtual 749	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(Ljava/lang/String;J)V
    //   1329: aload 12
    //   1331: monitorexit
    //   1332: return
    //   1333: aload_0
    //   1334: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   1337: putfield 94	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_Long	J
    //   1340: aload_0
    //   1341: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   1344: putfield 77	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_h_of_type_Long	J
    //   1347: iload_3
    //   1348: ifne +67 -> 1415
    //   1351: aload_0
    //   1352: invokevirtual 751	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:i	()V
    //   1355: new 584	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData
    //   1358: dup
    //   1359: invokespecial 585	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:<init>	()V
    //   1362: astore 9
    //   1364: aload 9
    //   1366: ldc_w 753
    //   1369: putfield 588	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   1372: aload 9
    //   1374: iconst_1
    //   1375: putfield 589	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_a_of_type_Int	I
    //   1378: aload_0
    //   1379: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1382: invokevirtual 591	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1385: aload 9
    //   1387: invokestatic 596	com/tencent/mobileqq/filemanager/util/FileManagerReporter:a	(Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData;)V
    //   1390: aload_0
    //   1391: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1394: iconst_1
    //   1395: putfield 186	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   1398: aload_0
    //   1399: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1402: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   1405: aload_0
    //   1406: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1409: invokevirtual 194	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1412: goto -83 -> 1329
    //   1415: invokestatic 209	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1418: ifeq +45 -> 1463
    //   1421: ldc_w 474
    //   1424: iconst_2
    //   1425: new 211	java/lang/StringBuilder
    //   1428: dup
    //   1429: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   1432: ldc_w 670
    //   1435: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1438: aload_0
    //   1439: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1442: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1445: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1448: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1451: ldc_w 755
    //   1454: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1457: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1460: invokestatic 478	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1463: aload_0
    //   1464: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1467: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1470: invokestatic 757	com/tencent/mobileqq/filemanager/util/FileManagerUtil:b	(J)V
    //   1473: aload_0
    //   1474: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1477: invokevirtual 420	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1480: aload_0
    //   1481: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1484: iconst_5
    //   1485: aload_0
    //   1486: getfield 149	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1489: invokevirtual 760	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;ILjava/lang/String;)V
    //   1492: aload_0
    //   1493: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1496: invokevirtual 630	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1499: aload_0
    //   1500: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1503: aload_0
    //   1504: getfield 166	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1507: aload_0
    //   1508: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1511: aload_0
    //   1512: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1515: getfield 137	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   1518: aload_0
    //   1519: getfield 90	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1522: invokevirtual 763	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1525: goto -170 -> 1355
    //   1528: aload_2
    //   1529: invokevirtual 695	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1532: sipush 206
    //   1535: if_icmpeq +15 -> 1550
    //   1538: aload_2
    //   1539: invokevirtual 695	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1542: istore_3
    //   1543: iload_3
    //   1544: sipush 200
    //   1547: if_icmpne -218 -> 1329
    //   1550: aload_0
    //   1551: getfield 67	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1554: aload_2
    //   1555: invokevirtual 765	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1558: invokevirtual 771	java/io/OutputStream:write	([B)V
    //   1561: aload_0
    //   1562: iconst_0
    //   1563: putfield 98	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1566: aload_2
    //   1567: invokevirtual 765	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1570: arraylength
    //   1571: i2l
    //   1572: lstore 5
    //   1574: aload_0
    //   1575: aload_0
    //   1576: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1579: lload 5
    //   1581: ladd
    //   1582: putfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1585: aload_0
    //   1586: lload 5
    //   1588: aload_0
    //   1589: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1592: ladd
    //   1593: putfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1596: aload_0
    //   1597: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1600: lstore 5
    //   1602: aload_2
    //   1603: invokevirtual 773	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()J
    //   1606: lstore 5
    //   1608: aload_0
    //   1609: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1612: lload 5
    //   1614: lcmp
    //   1615: iflt +283 -> 1898
    //   1618: aload_0
    //   1619: getfield 134	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1622: sipush 3000
    //   1625: if_icmpeq +25 -> 1650
    //   1628: aload_0
    //   1629: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1632: invokevirtual 630	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1635: aload_0
    //   1636: getfield 166	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1639: aload_0
    //   1640: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1643: aload_0
    //   1644: getfield 90	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1647: invokevirtual 776	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1650: aload_0
    //   1651: aconst_null
    //   1652: putfield 417	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1655: aload_0
    //   1656: getfield 67	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1659: ifnull +10 -> 1669
    //   1662: aload_0
    //   1663: getfield 67	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1666: invokevirtual 779	java/io/OutputStream:close	()V
    //   1669: aload_0
    //   1670: aconst_null
    //   1671: putfield 67	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1674: aload_0
    //   1675: invokespecial 781	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:j	()V
    //   1678: goto -349 -> 1329
    //   1681: astore 9
    //   1683: aload_0
    //   1684: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1687: aload_0
    //   1688: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1691: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1694: aload_0
    //   1695: getfield 79	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1698: aload_0
    //   1699: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1702: aload_0
    //   1703: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1706: aload_0
    //   1707: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1710: aload_0
    //   1711: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1714: aload_0
    //   1715: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1718: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1721: ldc2_w 440
    //   1724: ldc 104
    //   1726: aload_0
    //   1727: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1730: aload_0
    //   1731: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1734: aload_0
    //   1735: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1738: aload_0
    //   1739: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1742: ldc 104
    //   1744: aload_0
    //   1745: getfield 98	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1748: ldc_w 783
    //   1751: aconst_null
    //   1752: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1755: aload_0
    //   1756: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1759: aload_0
    //   1760: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1763: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1766: aload_0
    //   1767: getfield 81	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1770: aload_0
    //   1771: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1774: aload_0
    //   1775: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1778: aload_0
    //   1779: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1782: aload_0
    //   1783: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1786: aload_0
    //   1787: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1790: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1793: ldc2_w 440
    //   1796: ldc 104
    //   1798: aload_0
    //   1799: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1802: aload_0
    //   1803: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1806: aload_0
    //   1807: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1810: aload_0
    //   1811: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1814: ldc 104
    //   1816: aload_0
    //   1817: getfield 102	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   1820: ldc_w 783
    //   1823: aconst_null
    //   1824: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1827: aload_0
    //   1828: aconst_null
    //   1829: aconst_null
    //   1830: invokevirtual 451	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   1833: aload 12
    //   1835: monitorexit
    //   1836: return
    //   1837: astore 9
    //   1839: ldc_w 785
    //   1842: iconst_1
    //   1843: new 211	java/lang/StringBuilder
    //   1846: dup
    //   1847: invokespecial 212	java/lang/StringBuilder:<init>	()V
    //   1850: ldc 214
    //   1852: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1855: aload_0
    //   1856: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1859: invokestatic 233	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1862: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1865: ldc 223
    //   1867: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1870: ldc_w 787
    //   1873: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1876: aload 9
    //   1878: invokevirtual 788	java/io/IOException:toString	()Ljava/lang/String;
    //   1881: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1884: invokevirtual 236	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1887: invokestatic 239	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1890: aload 9
    //   1892: invokevirtual 789	java/io/IOException:printStackTrace	()V
    //   1895: goto -226 -> 1669
    //   1898: aload_0
    //   1899: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1902: aload_0
    //   1903: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1906: l2f
    //   1907: aload_0
    //   1908: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1911: l2f
    //   1912: fdiv
    //   1913: putfield 198	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1916: aload_0
    //   1917: sipush 2002
    //   1920: invokevirtual 242	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1923: invokestatic 343	java/lang/System:currentTimeMillis	()J
    //   1926: lstore 5
    //   1928: aload_0
    //   1929: getfield 71	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1932: lstore 7
    //   1934: lload 5
    //   1936: lload 7
    //   1938: lsub
    //   1939: ldc2_w 20
    //   1942: lcmp
    //   1943: ifge +7 -> 1950
    //   1946: aload 12
    //   1948: monitorexit
    //   1949: return
    //   1950: aload_0
    //   1951: lload 5
    //   1953: putfield 71	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1956: aload_0
    //   1957: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1960: aload_0
    //   1961: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1964: l2f
    //   1965: aload_0
    //   1966: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1969: l2f
    //   1970: fdiv
    //   1971: putfield 198	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1974: aload_0
    //   1975: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1978: invokevirtual 420	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1981: aload_0
    //   1982: getfield 59	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   1985: aload_0
    //   1986: getfield 61	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1989: aload_0
    //   1990: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1993: aload_0
    //   1994: getfield 134	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1997: bipush 16
    //   1999: aconst_null
    //   2000: iconst_0
    //   2001: aconst_null
    //   2002: invokevirtual 425	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   2005: goto -676 -> 1329
    //   2008: ldc 104
    //   2010: astore 10
    //   2012: ldc 104
    //   2014: astore 11
    //   2016: aload_1
    //   2017: ifnull +9 -> 2026
    //   2020: aload_1
    //   2021: invokevirtual 702	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   2024: astore 10
    //   2026: aload 11
    //   2028: astore_1
    //   2029: aload_2
    //   2030: ifnull +8 -> 2038
    //   2033: aload_2
    //   2034: getfield 792	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   2037: astore_1
    //   2038: aload_0
    //   2039: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2042: aload_0
    //   2043: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2046: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2049: aload_0
    //   2050: getfield 79	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   2053: aload_0
    //   2054: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2057: aload_0
    //   2058: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2061: aload_0
    //   2062: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2065: aload_0
    //   2066: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2069: aload_0
    //   2070: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2073: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2076: ldc2_w 793
    //   2079: aconst_null
    //   2080: aload_0
    //   2081: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2084: aload_0
    //   2085: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2088: aload_0
    //   2089: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2092: aload 10
    //   2094: aload_1
    //   2095: aload_0
    //   2096: getfield 102	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2099: aload 9
    //   2101: aconst_null
    //   2102: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2105: aload_0
    //   2106: getfield 158	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2109: aload_0
    //   2110: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2113: getfield 183	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2116: aload_0
    //   2117: getfield 81	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2120: aload_0
    //   2121: getfield 75	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2124: aload_0
    //   2125: getfield 106	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2128: aload_0
    //   2129: getfield 154	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2132: aload_0
    //   2133: getfield 139	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2136: aload_0
    //   2137: getfield 156	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2140: getfield 439	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2143: ldc2_w 793
    //   2146: aconst_null
    //   2147: aload_0
    //   2148: getfield 92	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2151: aload_0
    //   2152: getfield 53	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2155: aload_0
    //   2156: getfield 63	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2159: aload 10
    //   2161: aload_1
    //   2162: aload_0
    //   2163: getfield 102	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2166: aload 9
    //   2168: aconst_null
    //   2169: invokestatic 448	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2172: aload_0
    //   2173: aconst_null
    //   2174: aconst_null
    //   2175: invokevirtual 451	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2178: goto -849 -> 1329
    //   2181: lconst_0
    //   2182: lstore 5
    //   2184: goto -1625 -> 559
    //   2187: lconst_0
    //   2188: lstore 5
    //   2190: goto -1766 -> 424
    //   2193: iconst_1
    //   2194: istore_3
    //   2195: goto -1116 -> 1079
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2198	0	this	FileManagerRSWorker
    //   0	2198	1	paramHttpMsg1	HttpMsg
    //   0	2198	2	paramHttpMsg2	HttpMsg
    //   264	1931	3	i1	int
    //   261	755	4	i2	int
    //   422	1767	5	l1	long
    //   1932	5	7	l2	long
    //   249	1137	9	localObject1	Object
    //   1681	1	9	localException1	java.lang.Exception
    //   1837	330	9	localIOException	java.io.IOException
    //   229	23	10	localException2	java.lang.Exception
    //   256	1904	10	localObject2	Object
    //   275	1752	11	localObject3	Object
    //   4	1943	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   9	64	163	finally
    //   64	67	163	finally
    //   68	76	163	finally
    //   80	159	163	finally
    //   159	162	163	finally
    //   164	167	163	finally
    //   173	226	163	finally
    //   231	247	163	finally
    //   251	263	163	finally
    //   277	305	163	finally
    //   312	375	163	finally
    //   378	424	163	finally
    //   431	534	163	finally
    //   534	537	163	finally
    //   538	547	163	finally
    //   552	559	163	finally
    //   559	658	163	finally
    //   663	776	163	finally
    //   776	886	163	finally
    //   886	889	163	finally
    //   890	997	163	finally
    //   1006	1015	163	finally
    //   1018	1076	163	finally
    //   1079	1165	163	finally
    //   1165	1312	163	finally
    //   1312	1329	163	finally
    //   1329	1332	163	finally
    //   1333	1347	163	finally
    //   1351	1355	163	finally
    //   1355	1412	163	finally
    //   1415	1463	163	finally
    //   1463	1525	163	finally
    //   1528	1543	163	finally
    //   1550	1561	163	finally
    //   1561	1650	163	finally
    //   1650	1655	163	finally
    //   1655	1669	163	finally
    //   1669	1678	163	finally
    //   1683	1833	163	finally
    //   1833	1836	163	finally
    //   1839	1895	163	finally
    //   1898	1934	163	finally
    //   1946	1949	163	finally
    //   1950	2005	163	finally
    //   2020	2026	163	finally
    //   2033	2038	163	finally
    //   2038	2178	163	finally
    //   9	64	229	java/lang/Exception
    //   68	76	229	java/lang/Exception
    //   80	159	229	java/lang/Exception
    //   173	226	229	java/lang/Exception
    //   312	375	229	java/lang/Exception
    //   378	424	229	java/lang/Exception
    //   431	534	229	java/lang/Exception
    //   538	547	229	java/lang/Exception
    //   552	559	229	java/lang/Exception
    //   559	658	229	java/lang/Exception
    //   663	776	229	java/lang/Exception
    //   776	886	229	java/lang/Exception
    //   890	997	229	java/lang/Exception
    //   1006	1015	229	java/lang/Exception
    //   1018	1076	229	java/lang/Exception
    //   1079	1165	229	java/lang/Exception
    //   1165	1312	229	java/lang/Exception
    //   1312	1329	229	java/lang/Exception
    //   1333	1347	229	java/lang/Exception
    //   1351	1355	229	java/lang/Exception
    //   1355	1412	229	java/lang/Exception
    //   1415	1463	229	java/lang/Exception
    //   1463	1525	229	java/lang/Exception
    //   1528	1543	229	java/lang/Exception
    //   1561	1650	229	java/lang/Exception
    //   1650	1655	229	java/lang/Exception
    //   1655	1669	229	java/lang/Exception
    //   1669	1678	229	java/lang/Exception
    //   1683	1833	229	java/lang/Exception
    //   1839	1895	229	java/lang/Exception
    //   1898	1934	229	java/lang/Exception
    //   1950	2005	229	java/lang/Exception
    //   1550	1561	1681	java/lang/Exception
    //   1655	1669	1837	java/io/IOException
  }
  
  public void a(Object paramObject)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int i1;
    Object localObject;
    switch (this.jdField_b_of_type_Int)
    {
    case 2: 
    case 3: 
    case 4: 
    case 7: 
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          break;
        }
        i1 = 0;
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localHttpMsg == null);
      int i2 = localHttpMsg.jdField_h_of_type_Int;
      localObject = localHttpMsg.d();
      i1 = i2;
      paramObject = localObject;
      if (i2 == 0)
      {
        i1 = i2;
        paramObject = localObject;
        if (localObject == null)
        {
          i1 = 9001;
          paramObject = "[Http_RespValue_Null]" + FileManagerUtil.a();
        }
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + i1 + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        i1 = 9042;
      }
      break;
    }
    for (;;)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, String.valueOf(localHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.b(), localHttpMsg.ah, this.jdField_i_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      i1 = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (i1 = 0;; i1 = 16)
      {
        paramObject.status = i1;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  public void a(String paramString)
  {
    QLog.d("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9062L, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.b(), this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.ah, this.jdField_i_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.d() + "&UrlOver", null);
    a(null);
  }
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i1;
    if (paramLong == 0L)
    {
      FMConstants.Y = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong);
      if (this.jdField_d_of_type_Long < FMConstants.Y) {}
      for (l1 = this.jdField_d_of_type_Long;; l1 = FMConstants.Y)
      {
        i1 = (int)l1;
        this.jdField_a_of_type_Long = 0L;
        i1 = Math.min(i1, 1048576);
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong + "], size[" + i1 + "]");
        }
        a(paramString, paramLong, i1);
        return;
      }
    }
    FMConstants.W = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong);
    this.jdField_e_of_type_Long = FMConstants.W;
    if (this.jdField_d_of_type_Long < this.jdField_e_of_type_Long + paramLong) {}
    for (long l1 = this.jdField_d_of_type_Long - paramLong;; l1 = this.jdField_e_of_type_Long)
    {
      int i2 = (int)l1;
      int i3 = Utils.a(BaseApplication.getContext());
      if (i3 != 1)
      {
        i1 = i2;
        if (i3 != 2) {
          break;
        }
      }
      i1 = i2;
      if (i2 <= 16384) {
        break;
      }
      i1 = 16384;
      break;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed." + " recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      j();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 870	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 129	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 871	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 870	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 129	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 871	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 877	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 878	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 878	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   144: lsub
    //   145: invokevirtual 882	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 789	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 870	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 129	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 871	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 112	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   190: aload_0
    //   191: getfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 882	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 69	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 789	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	FileManagerRSWorker
    //   0	224	1	paramLong	long
    //   0	224	3	paramInt	int
    //   70	26	4	arrayOfByte	byte[]
    //   98	8	4	localFileNotFoundException1	FileNotFoundException
    //   112	8	4	localFileNotFoundException2	FileNotFoundException
    //   152	3	4	localIOException1	java.io.IOException
    //   202	8	4	localIOException2	java.io.IOException
    //   216	1	4	localException	java.lang.Exception
    //   219	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	98	java/io/FileNotFoundException
    //   42	62	112	java/io/FileNotFoundException
    //   135	149	152	java/io/IOException
    //   170	199	202	java/io/IOException
    //   72	95	216	java/lang/Exception
  }
  
  public int b()
  {
    return this.jdField_j_of_type_Int;
  }
  
  public long b()
  {
    return this.jdField_d_of_type_Long;
  }
  
  public String b()
  {
    boolean bool2 = true;
    Object localObject = AppConstants.ay;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath dir: " + (String)localObject);
    String str = AppConstants.aq;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Root[" + str + "]");
    str = AppConstants.as;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "SDCard[" + str + "]");
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = AppConstants.aA;
      localObject = new File(this.jdField_c_of_type_JavaLangString);
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        bool1 = ((File)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getTmpDir[" + bool1 + "]");
      }
      return this.jdField_c_of_type_JavaLangString;
    }
  }
  
  public void b()
  {
    if (a()) {
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "],ReceiveOfflineForOldMsg");
    if ((this.jdField_f_of_type_JavaLangString == null) || (this.jdField_f_of_type_JavaLangString.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] get old offlinefile info is error! serverPath is empty");
      a(2005);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
      int i1;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        i1 = 9080;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "errserverPathForOldMsg", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i1, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "errServerPathForOldMsg", null);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          i1 = 9081;
        } else {
          i1 = 9020;
        }
      }
    }
    if (-1L != this.jdField_b_of_type_Long) {}
    label1304:
    Object localObject;
    for (MessageRecord localMessageRecord = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.jdField_e_of_type_JavaLangString, 0, this.jdField_b_of_type_Long);; localObject = null)
    {
      if (localMessageRecord != null)
      {
        EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
        TransFileInfo localTransFileInfo = (TransFileInfo)localEntityManager.a(TransFileInfo.class, new String[] { String.valueOf(localMessageRecord.time), String.valueOf(localMessageRecord.msgseq), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), this.jdField_e_of_type_JavaLangString });
        localEntityManager.a();
        if ((localTransFileInfo != null) && (2008 == localTransFileInfo.status)) {
          this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
        }
      }
      if ((localMessageRecord != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 1)) {
        this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_d_of_type_JavaLangString = (this.jdField_b_of_type_JavaLangString + ".tmp");
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        if (a()) {
          break;
        }
        a(2005);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
        a(2003);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.jdField_b_of_type_JavaLangString = a(this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
          this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
        }
        FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
        return;
      }
      if (this.jdField_d_of_type_Long > this.jdField_a_of_type_Long)
      {
        long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
        if (SystemUtil.a()) {}
        for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
          a(2005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 12, null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "sdcard full", null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "sdcard full", null);
          return;
        }
      }
      if (this.jdField_a_of_type_JavaIoOutputStream == null) {}
      try
      {
        this.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
        if (this.jdField_b_of_type_Int == 1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 2002);
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        a(this.jdField_a_of_type_Long, null);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label1304;
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    String str1 = null;
    if (paramHttpMsg2 != null) {
      str1 = paramHttpMsg2.d();
    }
    if (str1 == null) {
      str1 = "null";
    }
    for (;;)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "transferedSize[" + this.jdField_a_of_type_Long + "]" + "isStop[" + String.valueOf(a()) + "],  " + "status[" + String.valueOf(this.jdField_j_of_type_Int) + "], " + "strErrString[" + str1 + "], " + "autoRetry[" + String.valueOf(this.jdField_g_of_type_Int) + "]");
      if ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)) {}
      do
      {
        return;
        if ((paramHttpMsg1 == null) && (paramHttpMsg2 == null))
        {
          c();
          a(null);
          return;
        }
      } while ((!NetworkUtil.e(BaseApplication.getContext())) && ((a()) || (this.jdField_j_of_type_Int == 1003) || (this.jdField_j_of_type_Int == 2003)));
      int i2 = paramHttpMsg2.jdField_h_of_type_Int;
      if (FileHttpUtils.a(paramHttpMsg2.jdField_h_of_type_Int))
      {
        this.jdField_i_of_type_Int += 1;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor == null) {
          break label1054;
        }
      }
      label1047:
      label1054:
      for (String str2 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();; str2 = null)
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + str2 + "]errCode[" + i2 + "]");
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i2, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, paramHttpMsg2.d() + "&goChangeUrl", null);
        long l1;
        if ((str2 == null) || (str2.length() == 0))
        {
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "] need chang Ip ,but can not get next ip errCode[" + i2 + "]");
          l1 = this.jdField_g_of_type_Long;
          if (a(paramHttpMsg1, paramHttpMsg2))
          {
            if (str1.indexOf("-29120") > 0)
            {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
              this.jdField_f_of_type_JavaLangString = "";
            }
            if (str1.indexOf("-6101") <= 0) {
              break label706;
            }
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, paramHttpMsg2.d(), null);
            this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          }
        }
        label706:
        do
        {
          this.jdField_g_of_type_Int = 0;
          c();
          a(paramHttpMsg2);
          return;
          b(str2);
          return;
          QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i2 + "]");
          break;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          if (QLog.isColorLevel()) {
            QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "handleError-----------retryTime:" + this.jdField_g_of_type_Int);
          }
        } while (this.jdField_g_of_type_Int >= 8);
        this.jdField_g_of_type_Int += 1;
        this.jdField_i_of_type_Int += 1;
        if ((this.jdField_h_of_type_Int < 3) && (i2 == 9056))
        {
          this.jdField_h_of_type_Int += 1;
          this.jdField_g_of_type_Int -= 1;
          if (i2 != 9056) {
            break label1047;
          }
        }
        for (int i1 = 0;; i1 = 6000)
        {
          new Handler().postDelayed(new dnu(this), i1);
          QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + i1 + "] time retry!");
          if (9048 == i2) {
            i2 = 11202;
          }
          for (;;)
          {
            FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, l1, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i2, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ah, this.jdField_i_of_type_Int, "delayTimes[" + i1 + "]" + paramHttpMsg2.d(), null);
            return;
            this.jdField_h_of_type_Int = 0;
            break;
          }
        }
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int i1 = 1; i1 != 0; i1 = 0)
    {
      this.jdField_f_of_type_JavaLangString = paramString;
      this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
      this.jdField_d_of_type_Int += 1;
      this.jdField_g_of_type_Long = System.currentTimeMillis();
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return;
    }
    this.jdField_f_of_type_JavaLangString = paramString;
    this.jdField_l_of_type_JavaLangString = this.jdField_f_of_type_JavaLangString;
    this.jdField_d_of_type_Int += 1;
    this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
    a(this.jdField_a_of_type_Long, null);
  }
  
  public boolean b()
  {
    if (!NetworkUtil.e(BaseApplicationImpl.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 13, null, 0, null);
    if (this.jdField_b_of_type_Int == 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, 1002);
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.jdField_b_of_type_JavaLangString == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], strFilePath is null");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      b(null, null);
      return false;
    }
    Object localObject1;
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor = new HttpUrlProcessor(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_f_of_type_JavaLangString);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpUrlProcessor.a();
      if (localObject1 != null)
      {
        this.jdField_f_of_type_JavaLangString = ((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], entify" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        }
        this.jdField_e_of_type_Long = FMConstants.W;
        this.jdField_i_of_type_Long = 0L;
        a(this.jdField_f_of_type_JavaLangString, 0L);
        return true;
      }
    }
    byte[] arrayOfByte = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    if (arrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "getfile md5 error", null);
      return true;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int i1 = 0;
    Object localObject2;
    while (i1 < arrayOfByte.length)
    {
      localObject2 = Integer.toHexString(arrayOfByte[i1] & 0xFF);
      localObject1 = localObject2;
      if (((String)localObject2).length() == 1) {
        localObject1 = '0' + (String)localObject2;
      }
      System.out.print(((String)localObject1).toUpperCase() + " ");
      localStringBuffer.append(((String)localObject1).toUpperCase() + " ");
      i1 += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile md5[" + localStringBuffer.toString() + "]");
    }
    try
    {
      localObject1 = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString).getBytes("utf-8");
      localObject2 = this.jdField_b_of_type_JavaLangString.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], serverPath is null, so get upload info");
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_e_of_type_JavaLangString, (byte[])localObject2, (byte[])localObject1, this.jdField_d_of_type_Long, arrayOfByte, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      a(0);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
    }
    return false;
  }
  
  public int c()
  {
    if (this.jdField_d_of_type_Long <= 0L) {
      return 0;
    }
    return (int)(this.jdField_a_of_type_Long * 100L / this.jdField_d_of_type_Long);
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "stop serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()) + "]");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]WeiyunFile stop!!!");
      }
      this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
    }
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
  }
  
  public void d()
  {
    c();
  }
  
  public void e()
  {
    c();
    if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "] is Successed, return!");
      }
      return;
    }
    if (this.jdField_b_of_type_Int == 0) {
      a(1004);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(true, 3, null);
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "stop for pause!");
      }
      long l1 = System.currentTimeMillis();
      String str = "Now[" + String.valueOf(l1) + "]startTime[" + String.valueOf(this.jdField_g_of_type_Long) + "]notifyTime[" + String.valueOf(this.jdField_f_of_type_Long) + "]C2CTime[" + String.valueOf(this.jdField_j_of_type_Long) + "]";
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, str, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, str, null);
      return;
      if (1 == this.jdField_b_of_type_Int) {
        a(2004);
      } else if ((5 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)) {
        this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
      } else if ((6 == this.jdField_b_of_type_Int) && (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task != null)) {
        this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
      }
    }
  }
  
  public void f()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaLangThread = new Thread(new dnv(this));
    this.jdField_a_of_type_JavaLangThread.start();
  }
  
  protected void finalize()
  {
    switch (this.jdField_b_of_type_Int)
    {
    }
    for (;;)
    {
      c();
      super.finalize();
      return;
      this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
    }
  }
  
  public void g()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.jdField_d_of_type_Long - this.jdField_a_of_type_Long;
    if (SystemUtil.a()) {}
    for (long l1 = SystemUtil.a() * 1024L; l1 < l2; l1 = SystemUtil.b() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "weiyun local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 12, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime, null);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "]fileid[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + "] modifytime[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new dnw(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  public void h()
  {
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath, null);
    this.jdField_d_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + String.valueOf(this.jdField_c_of_type_Long) + "] filePath[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath + "]");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new dnx(this));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  void i()
  {
    this.jdField_l_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
    a(1003);
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.jdField_c_of_type_Long + "], FileSize[" + this.jdField_d_of_type_Long + "], Uuid[" + this.jdField_g_of_type_JavaLangString + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 14, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "uuid is null Entity[" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.jdField_j_of_type_Long = System.currentTimeMillis();
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker
 * JD-Core Version:    0.7.0.1
 */