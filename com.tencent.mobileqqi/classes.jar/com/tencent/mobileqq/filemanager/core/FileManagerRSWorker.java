package com.tencent.mobileqq.filemanager.core;

import android.os.Handler;
import com.qq.taf.jce.HexUtil;
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
import fyu;
import fyw;
import fyx;
import fyy;
import fyz;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
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
  private FileTransferObserver jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver = new fyu(this);
  public FileManagerEntity a;
  HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  SSCM jdField_a_of_type_ComTencentWsttSSCMSSCM;
  public IWyTaskManager.Task a;
  File jdField_a_of_type_JavaIoFile = null;
  InputStream jdField_a_of_type_JavaIoInputStream = null;
  public OutputStream a;
  public String a;
  Thread jdField_a_of_type_JavaLangThread;
  public List a;
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
    this.jdField_a_of_type_JavaUtilList = null;
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
    c();
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
  
  private String a(String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, int paramInt)
  {
    if ((paramString1 != null) && (paramString1.length() > 0)) {
      return paramString1;
    }
    if ((paramString2 != null) && (paramString2.length() > 0) && (paramByteStringMicro != null) && (paramByteStringMicro.size() > 0))
    {
      paramString1 = HexUtil.bytes2HexStr(paramByteStringMicro.toByteArray());
      return "http://" + paramString2 + "/?ver=" + "2" + "&rkey=" + paramString1;
    }
    return null;
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
      String str1 = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localHttpMsg.a("Net-type", str1);
      localHttpMsg.a("Range", str2);
      if (paramString != null) {
        localHttpMsg.a("Cookie", paramString);
      }
      localHttpMsg.b(1);
      localHttpMsg.a(true);
      localHttpMsg.jdField_d_of_type_Int = 0;
      localHttpMsg.e = this.jdField_a_of_type_Int;
      localHttpMsg.ad = String.valueOf(this.jdField_c_of_type_Long);
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "get Stream null", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9003L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
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
      ((HttpMsg)localObject).ad = String.valueOf(this.jdField_c_of_type_Long);
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
  
  private static String f()
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
    if (FileUtils.a(this.jdField_b_of_type_JavaLangString)) {
      this.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.jdField_b_of_type_JavaLangString);
    }
    if (!FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString)))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.jdField_d_of_type_JavaLangString + "],strFilePath[" + this.jdField_b_of_type_JavaLangString + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "rename error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9003L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
      b(null, null);
      return;
    }
    Object localObject = HexUtil.bytes2HexStr(FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName));
    if ((this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 error, mathMd5[" + (String)localObject + "],FileMd5[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9082L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "rename error", null);
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath = this.jdField_b_of_type_JavaLangString;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
    a(2003);
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]recive success, set TrafficData,size[" + String.valueOf(this.jdField_a_of_type_Long) + "]");
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
    this.jdField_h_of_type_Long = System.currentTimeMillis();
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
    FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_h_of_type_Long - this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_i_of_type_Int, null);
    localObject = new FileManagerReporter.fileAssistantReportData();
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_JavaLangString = "rece_file_suc";
    ((FileManagerReporter.fileAssistantReportData)localObject).jdField_a_of_type_Int = 1;
    FileManagerReporter.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), (FileManagerReporter.fileAssistantReportData)localObject);
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
    String str = AppConstants.as;
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = f();
    }
    paramString1 = new File(str + paramString1);
    QLog.d("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public String a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    return paramString1 + "/?ver=" + "2" + "&ukey=" + paramString2 + "&filekey=" + paramString3 + "&filesize=" + paramLong;
  }
  
  public void a()
  {
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
    int n;
    int i1;
    int i2;
    if (paramHttpMsg != null)
    {
      n = paramHttpMsg.jdField_d_of_type_Int;
      i1 = paramHttpMsg.e;
      i2 = paramHttpMsg.f;
      if (((n == -1) || (i1 == -1)) && (QLog.isColorLevel())) {
        QLog.e("flowstat", 2, "fileType:" + n + ",busiType:" + i1);
      }
      if (!"POST".equals(paramHttpMsg.d())) {
        break label115;
      }
    }
    label115:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool, i2, n, i1, paramHttpMsg.jdField_i_of_type_Int);
      return;
    }
  }
  
  /* Error */
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 54	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ArrayOfInt	[I
    //   4: astore 10
    //   6: aload 10
    //   8: monitorenter
    //   9: aload_0
    //   10: getfield 70	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Boolean	Z
    //   13: ifeq +55 -> 68
    //   16: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +45 -> 64
    //   22: ldc_w 456
    //   25: iconst_2
    //   26: new 210	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 638
    //   36: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   43: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   46: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 640
    //   55: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 10
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 402	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   73: if_acmpeq +305 -> 378
    //   76: aload_1
    //   77: ifnull +92 -> 169
    //   80: aload_0
    //   81: getfield 402	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   84: ifnull +85 -> 169
    //   87: ldc 17
    //   89: iconst_1
    //   90: new 210	java/lang/StringBuilder
    //   93: dup
    //   94: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   97: ldc_w 642
    //   100: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: aload_0
    //   104: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   107: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   110: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: ldc_w 644
    //   116: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: aload_1
    //   120: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   123: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc_w 648
    //   132: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: aload_0
    //   136: getfield 402	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   139: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   142: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   145: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: ldc 222
    //   150: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload 10
    //   161: monitorexit
    //   162: return
    //   163: astore_1
    //   164: aload 10
    //   166: monitorexit
    //   167: aload_1
    //   168: athrow
    //   169: aload_1
    //   170: ifnull +142 -> 312
    //   173: ldc 17
    //   175: iconst_1
    //   176: new 210	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   183: ldc_w 642
    //   186: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: aload_0
    //   190: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   193: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   196: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: ldc_w 644
    //   202: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: aload_1
    //   206: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   209: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   212: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: ldc 222
    //   217: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   223: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   226: goto -67 -> 159
    //   229: astore 11
    //   231: aload 11
    //   233: invokevirtual 649	java/lang/Exception:printStackTrace	()V
    //   236: ldc 17
    //   238: iconst_1
    //   239: aload 11
    //   241: invokevirtual 650	java/lang/Exception:toString	()Ljava/lang/String;
    //   244: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: ldc 103
    //   249: astore 9
    //   251: aload 11
    //   253: invokevirtual 654	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   256: astore 11
    //   258: aload 11
    //   260: arraylength
    //   261: istore 4
    //   263: iconst_0
    //   264: istore_3
    //   265: iload_3
    //   266: iload 4
    //   268: if_icmpge +1785 -> 2053
    //   271: aload 11
    //   273: iload_3
    //   274: aaload
    //   275: astore 12
    //   277: new 210	java/lang/StringBuilder
    //   280: dup
    //   281: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   284: aload 9
    //   286: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: aload 12
    //   291: invokevirtual 657	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   294: ldc_w 659
    //   297: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   303: astore 9
    //   305: iload_3
    //   306: iconst_1
    //   307: iadd
    //   308: istore_3
    //   309: goto -44 -> 265
    //   312: aload_0
    //   313: getfield 402	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   316: ifnull -157 -> 159
    //   319: ldc 17
    //   321: iconst_1
    //   322: new 210	java/lang/StringBuilder
    //   325: dup
    //   326: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   329: ldc_w 642
    //   332: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: aload_0
    //   336: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   339: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   342: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: ldc_w 661
    //   348: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   351: aload_0
    //   352: getfield 402	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   355: invokevirtual 646	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()I
    //   358: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   361: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: ldc 222
    //   366: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   369: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   372: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   375: goto -216 -> 159
    //   378: aload_0
    //   379: getfield 143	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Int	I
    //   382: ifne +1210 -> 1592
    //   385: aload_2
    //   386: invokevirtual 663	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   389: sipush 200
    //   392: if_icmpne +1005 -> 1397
    //   395: aload_0
    //   396: getfield 199	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentWsttSSCMSSCM	Lcom/tencent/wstt/SSCM/SSCM;
    //   399: invokevirtual 664	com/tencent/wstt/SSCM/SSCM:b	()V
    //   402: aload_2
    //   403: ldc_w 666
    //   406: invokevirtual 667	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   409: ifnull +1789 -> 2198
    //   412: aload_2
    //   413: ldc_w 666
    //   416: invokevirtual 667	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   419: invokestatic 601	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   422: lstore 5
    //   424: lload 5
    //   426: lconst_0
    //   427: lcmp
    //   428: ifeq +103 -> 531
    //   431: aload_0
    //   432: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: aload_0
    //   436: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   439: aload_0
    //   440: getfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   443: aload_0
    //   444: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   447: aload_0
    //   448: getfield 148	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   455: aload_0
    //   456: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   459: ldc2_w 668
    //   462: ldc 103
    //   464: aload_0
    //   465: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   468: aload_0
    //   469: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   472: aload_0
    //   473: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   476: aload_2
    //   477: invokevirtual 671	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   480: aload_2
    //   481: getfield 674	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   484: aload_0
    //   485: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   488: new 210	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 676
    //   498: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 5
    //   503: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   506: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: ldc 222
    //   511: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   517: aconst_null
    //   518: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   521: aload_0
    //   522: aload_1
    //   523: aload_2
    //   524: invokevirtual 433	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   527: aload 10
    //   529: monitorexit
    //   530: return
    //   531: aload_2
    //   532: ldc_w 365
    //   535: invokevirtual 667	com/tencent/mobileqq/utils/httputils/HttpMsg:a	(Ljava/lang/String;)Ljava/lang/String;
    //   538: astore 9
    //   540: aload 9
    //   542: ifnull +1650 -> 2192
    //   545: aload 9
    //   547: invokestatic 601	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   550: lstore 5
    //   552: lload 5
    //   554: aload_0
    //   555: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   558: lcmp
    //   559: ifgt +509 -> 1068
    //   562: aload_0
    //   563: getfield 95	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   566: iconst_3
    //   567: if_icmpgt +222 -> 789
    //   570: new 678	android/os/Handler
    //   573: dup
    //   574: invokespecial 679	android/os/Handler:<init>	()V
    //   577: new 681	fyv
    //   580: dup
    //   581: aload_0
    //   582: lload 5
    //   584: invokespecial 684	fyv:<init>	(Lcom/tencent/mobileqq/filemanager/core/FileManagerRSWorker;J)V
    //   587: ldc2_w 685
    //   590: invokevirtual 690	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   593: pop
    //   594: new 210	java/lang/StringBuilder
    //   597: dup
    //   598: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   601: ldc_w 692
    //   604: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: aload_0
    //   608: getfield 95	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   611: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   614: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: ldc_w 694
    //   620: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: lload 5
    //   625: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   628: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   631: ldc_w 696
    //   634: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: aload_0
    //   638: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   641: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   644: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: ldc_w 698
    //   650: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: sipush 6000
    //   656: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   659: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   662: ldc 222
    //   664: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: astore 9
    //   672: ldc 17
    //   674: iconst_1
    //   675: new 210	java/lang/StringBuilder
    //   678: dup
    //   679: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   682: ldc_w 700
    //   685: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   688: aload_0
    //   689: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   692: invokevirtual 220	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   695: ldc 222
    //   697: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: aload 9
    //   702: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   705: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   708: invokestatic 703	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   711: aload_0
    //   712: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   715: aload_0
    //   716: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   719: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   722: aload_0
    //   723: getfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   726: aload_0
    //   727: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   730: aload_0
    //   731: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   734: aload_0
    //   735: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   738: aload_0
    //   739: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   742: ldc2_w 704
    //   745: ldc 103
    //   747: aload_0
    //   748: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   751: aload_0
    //   752: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   755: aload_0
    //   756: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   759: aload_0
    //   760: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   763: ldc 103
    //   765: aload_0
    //   766: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   769: aload 9
    //   771: aconst_null
    //   772: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   775: aload_0
    //   776: aload_0
    //   777: getfield 95	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   780: iconst_1
    //   781: iadd
    //   782: putfield 95	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   785: aload 10
    //   787: monitorexit
    //   788: return
    //   789: aload_0
    //   790: sipush 1005
    //   793: invokevirtual 241	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   796: aload_0
    //   797: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   800: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   803: aload_0
    //   804: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   807: aload_0
    //   808: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   811: aload_0
    //   812: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   815: aload_0
    //   816: getfield 133	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   819: bipush 15
    //   821: aconst_null
    //   822: iconst_5
    //   823: aconst_null
    //   824: invokevirtual 410	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   827: aload_0
    //   828: invokevirtual 707	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:c	()V
    //   831: ldc 17
    //   833: iconst_1
    //   834: new 210	java/lang/StringBuilder
    //   837: dup
    //   838: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   841: ldc 213
    //   843: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: aload_0
    //   847: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   850: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   853: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   856: ldc 222
    //   858: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: ldc_w 709
    //   864: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   867: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   870: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   873: new 210	java/lang/StringBuilder
    //   876: dup
    //   877: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   880: ldc_w 692
    //   883: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   886: aload_0
    //   887: getfield 95	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   890: invokestatic 388	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   893: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   896: ldc_w 694
    //   899: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   902: lload 5
    //   904: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   907: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   910: ldc_w 696
    //   913: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload_0
    //   917: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   920: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   923: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   926: ldc 222
    //   928: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   934: astore 9
    //   936: aload_0
    //   937: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   940: aload_0
    //   941: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   944: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   947: aload_0
    //   948: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   951: aload_0
    //   952: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   955: aload_0
    //   956: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   959: aload_0
    //   960: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   963: aload_0
    //   964: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   967: ldc2_w 704
    //   970: ldc 103
    //   972: aload_0
    //   973: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   976: aload_0
    //   977: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   980: aload_0
    //   981: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   984: aload_0
    //   985: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   988: ldc 103
    //   990: aload_0
    //   991: getfield 97	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   994: aload 9
    //   996: aconst_null
    //   997: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1000: aload_0
    //   1001: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1004: aload_0
    //   1005: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1008: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1011: aload_0
    //   1012: getfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1015: aload_0
    //   1016: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1019: aload_0
    //   1020: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1023: aload_0
    //   1024: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1027: aload_0
    //   1028: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1031: ldc2_w 704
    //   1034: ldc 103
    //   1036: aload_0
    //   1037: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1040: aload_0
    //   1041: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1044: aload_0
    //   1045: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1048: aload_0
    //   1049: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1052: ldc 103
    //   1054: aload_0
    //   1055: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   1058: aload 9
    //   1060: aconst_null
    //   1061: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1064: aload 10
    //   1066: monitorexit
    //   1067: return
    //   1068: aload_0
    //   1069: iconst_0
    //   1070: putfield 95	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Int	I
    //   1073: iconst_0
    //   1074: istore 4
    //   1076: iload 4
    //   1078: istore_3
    //   1079: aload_0
    //   1080: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1083: lconst_0
    //   1084: lcmp
    //   1085: ifne +67 -> 1152
    //   1088: iload 4
    //   1090: istore_3
    //   1091: lload 5
    //   1093: aload_0
    //   1094: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1097: lcmp
    //   1098: ifne +54 -> 1152
    //   1101: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1104: ifeq +1100 -> 2204
    //   1107: ldc_w 456
    //   1110: iconst_2
    //   1111: new 210	java/lang/StringBuilder
    //   1114: dup
    //   1115: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1118: ldc_w 638
    //   1121: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1124: aload_0
    //   1125: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1128: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1131: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1134: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: ldc_w 711
    //   1140: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1143: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1146: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1149: goto +1055 -> 2204
    //   1152: aload_0
    //   1153: lload 5
    //   1155: putfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1158: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1161: ifeq +77 -> 1238
    //   1164: ldc 17
    //   1166: iconst_2
    //   1167: new 210	java/lang/StringBuilder
    //   1170: dup
    //   1171: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1174: ldc 213
    //   1176: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1179: aload_0
    //   1180: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1183: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1186: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1189: ldc 222
    //   1191: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: ldc_w 451
    //   1197: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1200: aload_0
    //   1201: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1204: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1207: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1210: ldc_w 713
    //   1213: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1216: aload_0
    //   1217: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1220: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1223: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1226: ldc_w 715
    //   1229: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1232: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1235: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1238: lload 5
    //   1240: aload_0
    //   1241: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1244: lcmp
    //   1245: ifge +156 -> 1401
    //   1248: aload_0
    //   1249: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1252: aload_0
    //   1253: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1256: l2f
    //   1257: aload_0
    //   1258: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1261: l2f
    //   1262: fdiv
    //   1263: putfield 197	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1266: aload_0
    //   1267: sipush 1002
    //   1270: invokevirtual 241	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1273: invokestatic 334	java/lang/System:currentTimeMillis	()J
    //   1276: lstore 5
    //   1278: lload 5
    //   1280: aload_0
    //   1281: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1284: lsub
    //   1285: ldc2_w 20
    //   1288: lcmp
    //   1289: iflt +96 -> 1385
    //   1292: aload_0
    //   1293: lload 5
    //   1295: putfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1298: aload_0
    //   1299: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1302: iconst_3
    //   1303: putfield 541	com/tencent/mobileqq/filemanager/data/FileManagerEntity:cloudType	I
    //   1306: aload_0
    //   1307: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1310: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1313: aload_0
    //   1314: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   1317: aload_0
    //   1318: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1321: aload_0
    //   1322: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1325: aload_0
    //   1326: getfield 133	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1329: bipush 16
    //   1331: aconst_null
    //   1332: iconst_0
    //   1333: aconst_null
    //   1334: invokevirtual 410	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1337: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1340: ifeq +45 -> 1385
    //   1343: ldc 17
    //   1345: iconst_2
    //   1346: new 210	java/lang/StringBuilder
    //   1349: dup
    //   1350: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1353: ldc 213
    //   1355: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1358: aload_0
    //   1359: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1362: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1365: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1368: ldc 222
    //   1370: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1373: ldc_w 717
    //   1376: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1382: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1385: aload_0
    //   1386: aload_0
    //   1387: getfield 148	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1390: aload_0
    //   1391: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1394: invokevirtual 720	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(Ljava/lang/String;J)V
    //   1397: aload 10
    //   1399: monitorexit
    //   1400: return
    //   1401: aload_0
    //   1402: invokestatic 334	java/lang/System:currentTimeMillis	()J
    //   1405: putfield 93	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_Long	J
    //   1408: aload_0
    //   1409: invokestatic 334	java/lang/System:currentTimeMillis	()J
    //   1412: putfield 74	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_h_of_type_Long	J
    //   1415: iload_3
    //   1416: ifne +67 -> 1483
    //   1419: aload_0
    //   1420: invokevirtual 722	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:i	()V
    //   1423: new 558	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData
    //   1426: dup
    //   1427: invokespecial 559	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:<init>	()V
    //   1430: astore 9
    //   1432: aload 9
    //   1434: ldc_w 724
    //   1437: putfield 562	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1440: aload 9
    //   1442: iconst_1
    //   1443: putfield 563	com/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData:jdField_a_of_type_Int	I
    //   1446: aload_0
    //   1447: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1450: invokevirtual 565	com/tencent/mobileqq/app/QQAppInterface:a	()Ljava/lang/String;
    //   1453: aload 9
    //   1455: invokestatic 570	com/tencent/mobileqq/filemanager/util/FileManagerReporter:a	(Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/util/FileManagerReporter$fileAssistantReportData;)V
    //   1458: aload_0
    //   1459: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1462: iconst_1
    //   1463: putfield 185	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   1466: aload_0
    //   1467: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1470: invokevirtual 188	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerDataCenter;
    //   1473: aload_0
    //   1474: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1477: invokevirtual 193	com/tencent/mobileqq/filemanager/core/FileManagerDataCenter:c	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1480: goto -83 -> 1397
    //   1483: invokestatic 208	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1486: ifeq +45 -> 1531
    //   1489: ldc_w 456
    //   1492: iconst_2
    //   1493: new 210	java/lang/StringBuilder
    //   1496: dup
    //   1497: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1500: ldc_w 638
    //   1503: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1506: aload_0
    //   1507: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1510: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1513: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1516: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1519: ldc_w 726
    //   1522: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1525: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1528: invokestatic 460	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1531: aload_0
    //   1532: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1535: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1538: invokestatic 728	com/tencent/mobileqq/filemanager/util/FileManagerUtil:b	(J)V
    //   1541: aload_0
    //   1542: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1545: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   1548: aload_0
    //   1549: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1552: iconst_5
    //   1553: aload_0
    //   1554: getfield 148	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_JavaLangString	Ljava/lang/String;
    //   1557: invokevirtual 731	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;ILjava/lang/String;)V
    //   1560: aload_0
    //   1561: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1564: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1567: aload_0
    //   1568: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1571: aload_0
    //   1572: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1575: aload_0
    //   1576: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1579: getfield 136	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   1582: aload_0
    //   1583: getfield 89	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1586: invokevirtual 734	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1589: goto -166 -> 1423
    //   1592: aload_2
    //   1593: invokevirtual 663	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1596: sipush 206
    //   1599: if_icmpeq +15 -> 1614
    //   1602: aload_2
    //   1603: invokevirtual 663	com/tencent/mobileqq/utils/httputils/HttpMsg:c	()I
    //   1606: istore_3
    //   1607: iload_3
    //   1608: sipush 200
    //   1611: if_icmpne -214 -> 1397
    //   1614: aload_0
    //   1615: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1618: aload_2
    //   1619: invokevirtual 736	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1622: invokevirtual 742	java/io/OutputStream:write	([B)V
    //   1625: aload_2
    //   1626: invokevirtual 736	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()[B
    //   1629: arraylength
    //   1630: i2l
    //   1631: lstore 5
    //   1633: aload_0
    //   1634: aload_0
    //   1635: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1638: lload 5
    //   1640: ladd
    //   1641: putfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1644: aload_0
    //   1645: lload 5
    //   1647: aload_0
    //   1648: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1651: ladd
    //   1652: putfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1655: aload_0
    //   1656: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1659: lstore 5
    //   1661: aload_2
    //   1662: invokevirtual 744	com/tencent/mobileqq/utils/httputils/HttpMsg:a	()J
    //   1665: lstore 5
    //   1667: aload_0
    //   1668: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1671: lload 5
    //   1673: lcmp
    //   1674: iflt +269 -> 1943
    //   1677: aload_0
    //   1678: getfield 133	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   1681: sipush 3000
    //   1684: if_icmpeq +25 -> 1709
    //   1687: aload_0
    //   1688: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1691: invokevirtual 597	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/app/FileTransferHandler;
    //   1694: aload_0
    //   1695: getfield 165	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   1698: aload_0
    //   1699: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1702: aload_0
    //   1703: getfield 89	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver	Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;
    //   1706: invokevirtual 747	com/tencent/mobileqq/filemanager/app/FileTransferHandler:a	(Ljava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/filemanager/app/FileTransferObserver;)V
    //   1709: aload_0
    //   1710: aconst_null
    //   1711: putfield 402	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg	Lcom/tencent/mobileqq/utils/httputils/HttpMsg;
    //   1714: aload_0
    //   1715: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1718: ifnull +10 -> 1728
    //   1721: aload_0
    //   1722: getfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1725: invokevirtual 750	java/io/OutputStream:close	()V
    //   1728: aload_0
    //   1729: aconst_null
    //   1730: putfield 64	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1733: aload_0
    //   1734: invokespecial 752	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:j	()V
    //   1737: goto -340 -> 1397
    //   1740: astore 9
    //   1742: aload_0
    //   1743: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1746: aload_0
    //   1747: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1750: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1753: aload_0
    //   1754: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   1757: aload_0
    //   1758: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1761: aload_0
    //   1762: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1765: aload_0
    //   1766: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1769: aload_0
    //   1770: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1773: ldc2_w 422
    //   1776: ldc 103
    //   1778: aload_0
    //   1779: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1782: aload_0
    //   1783: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1786: aload_0
    //   1787: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1790: aload_0
    //   1791: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1794: ldc 103
    //   1796: aload_0
    //   1797: getfield 97	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Int	I
    //   1800: ldc_w 754
    //   1803: aconst_null
    //   1804: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1807: aload_0
    //   1808: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1811: aload_0
    //   1812: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1815: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1818: aload_0
    //   1819: getfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   1822: aload_0
    //   1823: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   1826: aload_0
    //   1827: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1830: aload_0
    //   1831: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   1834: aload_0
    //   1835: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   1838: ldc2_w 422
    //   1841: ldc 103
    //   1843: aload_0
    //   1844: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   1847: aload_0
    //   1848: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1851: aload_0
    //   1852: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1855: aload_0
    //   1856: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   1859: ldc 103
    //   1861: aload_0
    //   1862: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   1865: ldc_w 754
    //   1868: aconst_null
    //   1869: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1872: aload_0
    //   1873: aconst_null
    //   1874: aconst_null
    //   1875: invokevirtual 433	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   1878: aload 10
    //   1880: monitorexit
    //   1881: return
    //   1882: astore 9
    //   1884: ldc_w 756
    //   1887: iconst_1
    //   1888: new 210	java/lang/StringBuilder
    //   1891: dup
    //   1892: invokespecial 211	java/lang/StringBuilder:<init>	()V
    //   1895: ldc 213
    //   1897: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1900: aload_0
    //   1901: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   1904: invokestatic 232	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1907: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1910: ldc 222
    //   1912: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1915: ldc_w 758
    //   1918: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1921: aload 9
    //   1923: invokevirtual 759	java/io/IOException:toString	()Ljava/lang/String;
    //   1926: invokevirtual 217	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1929: invokevirtual 235	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1932: invokestatic 238	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1935: aload 9
    //   1937: invokevirtual 760	java/io/IOException:printStackTrace	()V
    //   1940: goto -212 -> 1728
    //   1943: aload_0
    //   1944: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1947: aload_0
    //   1948: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   1951: l2f
    //   1952: aload_0
    //   1953: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   1956: l2f
    //   1957: fdiv
    //   1958: putfield 197	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1961: aload_0
    //   1962: sipush 2002
    //   1965: invokevirtual 241	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:a	(I)V
    //   1968: invokestatic 334	java/lang/System:currentTimeMillis	()J
    //   1971: lstore 5
    //   1973: aload_0
    //   1974: getfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   1977: lstore 7
    //   1979: lload 5
    //   1981: lload 7
    //   1983: lsub
    //   1984: ldc2_w 20
    //   1987: lcmp
    //   1988: ifge +7 -> 1995
    //   1991: aload 10
    //   1993: monitorexit
    //   1994: return
    //   1995: aload_0
    //   1996: lload 5
    //   1998: putfield 68	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_f_of_type_Long	J
    //   2001: aload_0
    //   2002: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2005: aload_0
    //   2006: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2009: l2f
    //   2010: aload_0
    //   2011: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2014: l2f
    //   2015: fdiv
    //   2016: putfield 197	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   2019: aload_0
    //   2020: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2023: invokevirtual 405	com/tencent/mobileqq/app/QQAppInterface:a	()Lcom/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter;
    //   2026: aload_0
    //   2027: getfield 56	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_Long	J
    //   2030: aload_0
    //   2031: getfield 58	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_c_of_type_Long	J
    //   2034: aload_0
    //   2035: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2038: aload_0
    //   2039: getfield 133	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Int	I
    //   2042: bipush 16
    //   2044: aconst_null
    //   2045: iconst_0
    //   2046: aconst_null
    //   2047: invokevirtual 410	com/tencent/mobileqq/filemanager/core/FileManagerNotifyCenter:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   2050: goto -653 -> 1397
    //   2053: aload_0
    //   2054: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2057: aload_0
    //   2058: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2061: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2064: aload_0
    //   2065: getfield 78	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_JavaLangString	Ljava/lang/String;
    //   2068: aload_0
    //   2069: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2072: aload_0
    //   2073: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2076: aload_0
    //   2077: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2080: aload_0
    //   2081: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2084: ldc2_w 761
    //   2087: aconst_null
    //   2088: aload_0
    //   2089: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2092: aload_0
    //   2093: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2096: aload_0
    //   2097: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2100: aload_1
    //   2101: invokevirtual 671	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   2104: aload_2
    //   2105: getfield 674	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   2108: aload_0
    //   2109: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2112: aload 9
    //   2114: aconst_null
    //   2115: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2118: aload_0
    //   2119: getfield 157	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2122: aload_0
    //   2123: getfield 155	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2126: getfield 182	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2129: aload_0
    //   2130: getfield 80	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_j_of_type_JavaLangString	Ljava/lang/String;
    //   2133: aload_0
    //   2134: getfield 72	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_Long	J
    //   2137: aload_0
    //   2138: getfield 105	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_l_of_type_JavaLangString	Ljava/lang/String;
    //   2141: aload_0
    //   2142: getfield 153	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_e_of_type_JavaLangString	Ljava/lang/String;
    //   2145: aload_0
    //   2146: getfield 138	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_g_of_type_JavaLangString	Ljava/lang/String;
    //   2149: ldc2_w 761
    //   2152: aconst_null
    //   2153: aload_0
    //   2154: getfield 91	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Long	J
    //   2157: aload_0
    //   2158: getfield 52	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_Long	J
    //   2161: aload_0
    //   2162: getfield 60	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_d_of_type_Long	J
    //   2165: aload_1
    //   2166: invokevirtual 671	com/tencent/mobileqq/utils/httputils/HttpMsg:b	()Ljava/lang/String;
    //   2169: aload_2
    //   2170: getfield 674	com/tencent/mobileqq/utils/httputils/HttpMsg:ag	Ljava/lang/String;
    //   2173: aload_0
    //   2174: getfield 101	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_i_of_type_Int	I
    //   2177: aload 9
    //   2179: aconst_null
    //   2180: invokestatic 430	com/tencent/mobileqq/filemanager/util/FileManagerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2183: aload_0
    //   2184: aconst_null
    //   2185: aconst_null
    //   2186: invokevirtual 433	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:b	(Lcom/tencent/mobileqq/utils/httputils/HttpMsg;Lcom/tencent/mobileqq/utils/httputils/HttpMsg;)V
    //   2189: goto -792 -> 1397
    //   2192: lconst_0
    //   2193: lstore 5
    //   2195: goto -1643 -> 552
    //   2198: lconst_0
    //   2199: lstore 5
    //   2201: goto -1777 -> 424
    //   2204: iconst_1
    //   2205: istore_3
    //   2206: goto -1054 -> 1152
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2209	0	this	FileManagerRSWorker
    //   0	2209	1	paramHttpMsg1	HttpMsg
    //   0	2209	2	paramHttpMsg2	HttpMsg
    //   264	1942	3	n	int
    //   261	828	4	i1	int
    //   422	1778	5	l1	long
    //   1977	5	7	l2	long
    //   249	1205	9	localObject	Object
    //   1740	1	9	localException1	java.lang.Exception
    //   1882	296	9	localIOException	java.io.IOException
    //   4	1988	10	arrayOfInt	int[]
    //   229	23	11	localException2	java.lang.Exception
    //   256	16	11	arrayOfStackTraceElement	java.lang.StackTraceElement[]
    //   275	15	12	localStackTraceElement	java.lang.StackTraceElement
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
    //   431	527	163	finally
    //   527	530	163	finally
    //   531	540	163	finally
    //   545	552	163	finally
    //   552	785	163	finally
    //   785	788	163	finally
    //   789	1064	163	finally
    //   1064	1067	163	finally
    //   1068	1073	163	finally
    //   1079	1088	163	finally
    //   1091	1149	163	finally
    //   1152	1238	163	finally
    //   1238	1385	163	finally
    //   1385	1397	163	finally
    //   1397	1400	163	finally
    //   1401	1415	163	finally
    //   1419	1423	163	finally
    //   1423	1480	163	finally
    //   1483	1531	163	finally
    //   1531	1589	163	finally
    //   1592	1607	163	finally
    //   1614	1625	163	finally
    //   1625	1709	163	finally
    //   1709	1714	163	finally
    //   1714	1728	163	finally
    //   1728	1737	163	finally
    //   1742	1878	163	finally
    //   1878	1881	163	finally
    //   1884	1940	163	finally
    //   1943	1979	163	finally
    //   1991	1994	163	finally
    //   1995	2050	163	finally
    //   2053	2189	163	finally
    //   9	64	229	java/lang/Exception
    //   68	76	229	java/lang/Exception
    //   80	159	229	java/lang/Exception
    //   173	226	229	java/lang/Exception
    //   312	375	229	java/lang/Exception
    //   378	424	229	java/lang/Exception
    //   431	527	229	java/lang/Exception
    //   531	540	229	java/lang/Exception
    //   545	552	229	java/lang/Exception
    //   552	785	229	java/lang/Exception
    //   789	1064	229	java/lang/Exception
    //   1068	1073	229	java/lang/Exception
    //   1079	1088	229	java/lang/Exception
    //   1091	1149	229	java/lang/Exception
    //   1152	1238	229	java/lang/Exception
    //   1238	1385	229	java/lang/Exception
    //   1385	1397	229	java/lang/Exception
    //   1401	1415	229	java/lang/Exception
    //   1419	1423	229	java/lang/Exception
    //   1423	1480	229	java/lang/Exception
    //   1483	1531	229	java/lang/Exception
    //   1531	1589	229	java/lang/Exception
    //   1592	1607	229	java/lang/Exception
    //   1625	1709	229	java/lang/Exception
    //   1709	1714	229	java/lang/Exception
    //   1714	1728	229	java/lang/Exception
    //   1728	1737	229	java/lang/Exception
    //   1742	1878	229	java/lang/Exception
    //   1884	1940	229	java/lang/Exception
    //   1943	1979	229	java/lang/Exception
    //   1995	2050	229	java/lang/Exception
    //   1614	1625	1740	java/lang/Exception
    //   1714	1728	1882	java/io/IOException
  }
  
  public void a(Object paramObject)
  {
    HttpMsg localHttpMsg = (HttpMsg)paramObject;
    int n;
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
        n = 0;
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.jdField_a_of_type_Long / (float)this.jdField_d_of_type_Long);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.jdField_b_of_type_Long;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
      } while (localHttpMsg == null);
      int i1 = localHttpMsg.jdField_h_of_type_Int;
      localObject = localHttpMsg.c();
      n = i1;
      paramObject = localObject;
      if (i1 == 0)
      {
        n = i1;
        paramObject = localObject;
        if (localObject == null)
        {
          n = 9001;
          paramObject = "[Http_RespValue_Null]" + FileManagerUtil.a();
        }
      }
      localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + n + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        n = 9042;
      }
      break;
    }
    for (;;)
    {
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, n, String.valueOf(localHttpMsg.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, localHttpMsg.b(), localHttpMsg.ag, this.jdField_i_of_type_Int, (String)localObject, null);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      n = 16;
      break;
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
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
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.jdField_g_of_type_JavaLangString;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (n = 0;; n = 16)
      {
        paramObject.status = n;
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 38, null, 11, null);
        break;
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, long paramLong)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int n;
    if (paramLong == 0L)
    {
      FMConstants.V = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong);
      if (this.jdField_d_of_type_Long < FMConstants.V) {}
      for (l1 = this.jdField_d_of_type_Long;; l1 = FMConstants.V)
      {
        n = (int)l1;
        this.jdField_a_of_type_Long = 0L;
        n = Math.min(n, 1048576);
        if (QLog.isColorLevel()) {
          QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong + "], size[" + n + "]");
        }
        a(paramString, paramLong, n);
        return;
      }
    }
    FMConstants.T = this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.jdField_d_of_type_Long, paramLong);
    this.jdField_e_of_type_Long = FMConstants.T;
    if (this.jdField_d_of_type_Long < this.jdField_e_of_type_Long + paramLong) {}
    for (long l1 = this.jdField_d_of_type_Long - paramLong;; l1 = this.jdField_e_of_type_Long)
    {
      int i1 = (int)l1;
      int i2 = Utils.a(BaseApplication.getContext());
      if (i2 != 1)
      {
        n = i1;
        if (i2 != 2) {
          break;
        }
      }
      n = i1;
      if (i1 <= 16384) {
        break;
      }
      n = 16384;
      break;
    }
  }
  
  public void a(List paramList, String paramString1, String paramString2, ByteStringMicro paramByteStringMicro, short paramShort)
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilList.clear();
    paramString2 = paramString1.substring(paramString1.indexOf("/?ver"));
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      paramString1 = paramList.iterator();
      while (paramString1.hasNext())
      {
        paramByteStringMicro = (String)paramString1.next();
        paramByteStringMicro = "http://" + paramByteStringMicro + paramString2;
        this.jdField_a_of_type_JavaUtilList.add(paramByteStringMicro);
      }
    }
    paramShort = 0;
    while ((paramList != null) && (paramShort < paramList.size()))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "setServerPathList[" + String.valueOf(paramShort) + "],ip:" + (String)paramList.get(paramShort));
      paramShort += 1;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  boolean a(HttpMsg paramHttpMsg)
  {
    if ((this.jdField_a_of_type_Int == 3000) || (this.jdField_a_of_type_JavaUtilList == null)) {}
    int n;
    do
    {
      return false;
      if (paramHttpMsg == null) {
        break;
      }
      n = paramHttpMsg.jdField_h_of_type_Int;
    } while ((n != 9052) && (n != 9050) && (n != 9055) && (n != 9053) && (n != 9054));
    return true;
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if ((5 == paramInt) && (this.jdField_b_of_type_Int != 0) && (this.jdField_a_of_type_Long < this.jdField_d_of_type_Long))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.jdField_c_of_type_Long) + "] HttpCommunicator.status = STATUS_END . but data no recv completed." + " recvData=" + this.jdField_a_of_type_Long + " filesize=" + this.jdField_d_of_type_Long);
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_c_of_type_Long, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, -9527L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ag, this.jdField_i_of_type_Int, "statusChanged mtransferedSize[" + String.valueOf(this.jdField_a_of_type_Long) + "]nFileSize[" + String.valueOf(this.jdField_d_of_type_Long) + "]", null);
      j();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 867	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 128	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   16: invokespecial 868	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 867	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 128	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   51: invokespecial 868	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 874	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 875	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 875	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   144: lsub
    //   145: invokevirtual 879	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 760	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 867	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 128	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   179: invokespecial 868	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 111	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:k	J
    //   190: aload_0
    //   191: getfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 879	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 66	com/tencent/mobileqq/filemanager/core/FileManagerRSWorker:jdField_a_of_type_JavaIoInputStream	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 760	java/io/IOException:printStackTrace	()V
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
  
  String b()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return "";
    }
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return "";
    }
    String str = (String)this.jdField_a_of_type_JavaUtilList.get(0);
    this.jdField_a_of_type_JavaUtilList.remove(0);
    return str;
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
      int n;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        n = 9080;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, n, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "errserverPathForOldMsg", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, n, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "errServerPathForOldMsg", null);
        return;
        if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          n = 9081;
        } else {
          n = 9020;
        }
      }
    }
    if (-1L != this.jdField_b_of_type_Long) {}
    label1153:
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
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_c_of_type_Long, this.jdField_b_of_type_JavaLangString);
      this.jdField_a_of_type_Long = FileManagerUtil.a(this.jdField_d_of_type_JavaLangString);
      if (this.jdField_a_of_type_Long == this.jdField_d_of_type_Long)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
        a(2003);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 11, new Object[] { this.jdField_b_of_type_JavaLangString, Long.valueOf(this.jdField_d_of_type_Long), Boolean.valueOf(true), this.jdField_f_of_type_JavaLangString }, 0, null);
        FileUtils.a(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_b_of_type_JavaLangString));
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, this.jdField_f_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 0L, 0L, this.jdField_d_of_type_Long, this.jdField_g_of_type_Int, null);
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
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "sdcard full", null);
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9040L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "sdcard full", null);
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
        break label1153;
      }
    }
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    String str1 = null;
    if (paramHttpMsg2 != null) {
      str1 = paramHttpMsg2.c();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "null";
    }
    int n = 0;
    if (this.jdField_a_of_type_JavaUtilList != null) {
      n = this.jdField_a_of_type_JavaUtilList.size();
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "lstUrl[" + String.valueOf(n) + "]" + "transferedSize[" + this.jdField_a_of_type_Long + "]" + "isStop[" + String.valueOf(a()) + "],  " + "status[" + String.valueOf(this.jdField_j_of_type_Int) + "], " + "strErrString[" + str2 + "], " + "autoRetry[" + String.valueOf(this.jdField_g_of_type_Int) + "]");
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
    int i1 = paramHttpMsg2.jdField_h_of_type_Int;
    if (a(paramHttpMsg2))
    {
      this.jdField_i_of_type_Int += 1;
      paramHttpMsg1 = b();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]get nextIp[" + paramHttpMsg1 + "]errCode[" + i1 + "]");
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, i1, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ag, this.jdField_i_of_type_Int, paramHttpMsg2.c() + "&goChangeUrl", null);
      if (paramHttpMsg1.length() == 0)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_c_of_type_Long) + "] all offlinefile url may be retry,faild!!!");
        if (this.jdField_b_of_type_Int == 0)
        {
          a(1005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 15, null, 5, null);
        }
        for (;;)
        {
          FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, i1, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ag, this.jdField_i_of_type_Int, paramHttpMsg2.c() + "&UrlOver", null);
          return;
          a(2005);
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 12, null, 6, null);
        }
      }
      b(paramHttpMsg1);
      return;
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_Long + "]don't need chang Ip errCode[" + i1 + "]");
    long l1 = this.jdField_g_of_type_Long;
    if (a(paramHttpMsg1, paramHttpMsg2))
    {
      if (str2.indexOf("-29120") > 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = "";
        this.jdField_f_of_type_JavaLangString = "";
      }
      if (str2.indexOf("-6101") <= 0) {
        break label883;
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9042, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ag, this.jdField_i_of_type_Int, paramHttpMsg2.c(), null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
    }
    label883:
    do
    {
      this.jdField_g_of_type_Int = 0;
      c();
      a(paramHttpMsg2);
      return;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "handleError-----------retryTime:" + this.jdField_g_of_type_Int);
      }
    } while (this.jdField_g_of_type_Int >= 8);
    this.jdField_g_of_type_Int += 1;
    this.jdField_i_of_type_Int += 1;
    if ((this.jdField_h_of_type_Int < 3) && (i1 == 9056))
    {
      this.jdField_h_of_type_Int += 1;
      this.jdField_g_of_type_Int -= 1;
      if (i1 != 9056) {
        break label1217;
      }
    }
    label1217:
    for (n = 0;; n = 6000)
    {
      new Handler().postDelayed(new fyw(this), n);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.jdField_c_of_type_Long + "] after [" + n + "] time retry!");
      if (9048 == i1) {
        i1 = 11202;
      }
      for (;;)
      {
        FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, l1, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, i1, String.valueOf(paramHttpMsg2.a()), this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, paramHttpMsg2.b(), paramHttpMsg2.ag, this.jdField_i_of_type_Int, "delayTimes[" + n + "]" + paramHttpMsg2.c(), null);
        return;
        this.jdField_h_of_type_Int = 0;
        break;
      }
    }
  }
  
  void b(String paramString)
  {
    if (this.jdField_b_of_type_Int == 0) {}
    for (int n = 1; n != 0; n = 0)
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
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 1, null, 2, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_g_of_type_Int, "NoNetWork", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9004L, "", 0L, 0L, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, "NoNetWork", null);
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      b(null, null);
      return false;
    }
    if ((this.jdField_f_of_type_JavaLangString != null) && (this.jdField_f_of_type_JavaLangString.length() != 0))
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], entify" + FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      this.jdField_e_of_type_Long = FMConstants.T;
      this.jdField_i_of_type_Long = 0L;
      a(this.jdField_f_of_type_JavaLangString, 0L);
      return true;
    }
    byte[] arrayOfByte = FileManagerUtil.a(this.jdField_b_of_type_JavaLangString, null);
    if (arrayOfByte == null)
    {
      a(0);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_b_of_type_Long, this.jdField_c_of_type_Long, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_Int, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.jdField_c_of_type_Long + "], getMd5 failed");
      }
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, "getfile md5 error", null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9041L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, "getfile md5 error", null);
      return true;
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int n = 0;
    Object localObject2;
    Object localObject1;
    while (n < arrayOfByte.length)
    {
      localObject2 = Integer.toHexString(arrayOfByte[n] & 0xFF);
      localObject1 = localObject2;
      if (((String)localObject2).length() == 1) {
        localObject1 = '0' + (String)localObject2;
      }
      System.out.print(((String)localObject1).toUpperCase() + " ");
      localStringBuffer.append(((String)localObject1).toUpperCase() + " ");
      n += 1;
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9005L, null, this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, "", "", this.jdField_i_of_type_Int, FileManagerUtil.a(), null);
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
    boolean bool2 = true;
    Object localObject = AppConstants.as;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.jdField_c_of_type_Long) + "]" + "getTransferFilePath dir: " + (String)localObject);
    String str = AppConstants.al;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Root[" + str + "]");
    str = AppConstants.an;
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "SDCard[" + str + "]");
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.jdField_c_of_type_Long + "]getRecvDir[" + bool1 + "]");
      }
      this.jdField_c_of_type_JavaLangString = AppConstants.au;
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
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public void d()
  {
    c();
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_g_of_type_Int, str, null);
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_j_of_type_JavaLangString, this.jdField_g_of_type_Long, this.jdField_l_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_g_of_type_JavaLangString, 9037L, "", this.jdField_i_of_type_Long, this.jdField_a_of_type_Long, this.jdField_d_of_type_Long, this.jdField_l_of_type_JavaLangString, "", this.jdField_i_of_type_Int, str, null);
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
    this.jdField_a_of_type_JavaLangThread = new Thread(new fyx(this));
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, this.jdField_g_of_type_Long, "", "", "", 9040L, "", this.jdField_a_of_type_Long, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
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
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new fyy(this));
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
      FileManagerUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_i_of_type_JavaLangString, 0L, "", "", "", 9004L, "", 0L, 0L, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
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
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new fyz(this));
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_JavaLangString, this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.jdField_a_of_type_ComTencentMobileqqFilemanagerAppFileTransferObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.FileManagerRSWorker
 * JD-Core Version:    0.7.0.1
 */