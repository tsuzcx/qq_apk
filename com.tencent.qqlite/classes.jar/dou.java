import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.MessageObserver.StatictisInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler;
import com.tencent.mobileqq.filemanager.app.FileTransferHandler.FileUploadInfo;
import com.tencent.mobileqq.filemanager.app.FileTransferObserver;
import com.tencent.mobileqq.filemanager.core.FileManagerDataCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter;
import com.tencent.mobileqq.filemanager.util.FileManagerReporter.fileAssistantReportData;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class dou
  extends FileTransferObserver
{
  public dou(FileManagerRSWorker paramFileManagerRSWorker) {}
  
  protected void a(boolean paramBoolean, long paramLong1, long paramLong2, int paramInt)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(paramLong2) + "] SendCC [" + String.valueOf(paramBoolean) + "],retCode[" + String.valueOf(paramLong1) + "]");
    if (!paramBoolean)
    {
      if (paramLong1 == -100001L) {}
      for (long l = 9043L;; l = 90460L)
      {
        this.a.a(1005);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, paramLong2, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 15, null, 5, null);
        this.a.c();
        QLog.d("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]" + "OnSendCCReplay Faild! !");
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "sendCCFaild", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "sendCCFaild", null);
        return;
      }
    }
    if (paramLong1 == 58L)
    {
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "ServerMasking", null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "ServerMasking", null);
      this.a.a(1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, paramLong2, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 15, null, 5, null);
      this.a.c();
      QLog.d("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(paramLong2) + "]" + "OnSendCCReplay Faild! !retCode[" + paramLong1 + "]");
      return;
    }
    String str = null;
    if (this.a.jdField_d_of_type_Int > 0) {
      str = "ChanedUrlCount[" + this.a.jdField_d_of_type_Int + "]";
    }
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_h_of_type_Long - this.a.jdField_g_of_type_Long, this.a.f, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.b(this.a), str);
    FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_h_of_type_Long - this.a.jdField_g_of_type_Long, this.a.f, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.b(this.a), str);
  }
  
  protected void a(boolean paramBoolean, long paramLong, String paramString1, ByteStringMicro paramByteStringMicro, String paramString2, short paramShort, String paramString3, List paramList, int paramInt, String paramString4)
  {
    if (this.a.a()) {
      return;
    }
    long l;
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramInt);
      this.a.a(2005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
      if (paramLong == -100001L) {}
      for (l = 9043L;; l = 9045L)
      {
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "server ret error", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "server ret error", null);
        return;
      }
    }
    if (paramString4 != null) {
      this.a.jdField_b_of_type_JavaLangString = this.a.a(this.a.jdField_e_of_type_JavaLangString, paramString4);
    }
    paramString4 = paramList;
    if (paramList == null) {
      paramString4 = new ArrayList();
    }
    if ((paramString3 != null) && (paramString3.length() > 0))
    {
      paramShort = paramString3.indexOf("/?ver");
      paramString2 = paramString3.substring(paramShort);
      if (-1 != paramString3.indexOf("http://"))
      {
        paramByteStringMicro = paramString3.substring(7, paramShort);
        paramString4.add(0, paramByteStringMicro);
        paramByteStringMicro = paramString2;
      }
    }
    for (;;)
    {
      label538:
      paramString2 = null;
      if (paramByteStringMicro != null)
      {
        FileManagerRSWorker.a(this.a, new HttpUrlProcessor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString4, paramByteStringMicro));
        paramString2 = FileManagerRSWorker.a(this.a).a();
      }
      if (paramString2 == null)
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] get offlinefile info Url is null, IP is null too");
        this.a.a(2005);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 12, null, (int)paramLong, paramString1);
        if (paramLong == 0L) {}
        for (l = 9048L;; l = paramLong)
        {
          if (paramLong == -6101L) {
            this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          }
          FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "ip url error", null);
          FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, l, String.valueOf(paramInt), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "ip url error", null);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          return;
          paramByteStringMicro = paramString3.substring(0, paramShort);
          break;
          if ((paramByteStringMicro == null) || (paramByteStringMicro.size() <= 0)) {
            break label2703;
          }
          paramString2 = paramString2 + ":" + paramShort;
          paramByteStringMicro = FileManagerRSWorker.a(this.a, paramByteStringMicro);
          paramString4.add(0, paramString2);
          break label538;
        }
      }
      this.a.f = paramString2;
      FileManagerRSWorker.a(this.a, this.a.f);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.a.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong) + "]");
      if ((paramString1 != null) && (paramString1.length() > 0))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong) + "], retMsg:" + paramString1);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 4, null, (int)paramLong, paramString1);
      }
      if (-1L != this.a.jdField_b_of_type_Long) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(this.a.jdField_e_of_type_JavaLangString, 0, this.a.jdField_b_of_type_Long);
      }
      paramString1 = MD5.toMD5(this.a.jdField_g_of_type_JavaLangString);
      this.a.jdField_d_of_type_JavaLangString = (this.a.jdField_c_of_type_JavaLangString + paramString1);
      if (!NetworkUtil.e(BaseApplication.getContext()))
      {
        this.a.a(2005);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 1, null, 2, null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "net", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt) + "&" + String.valueOf(paramLong), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "net", null);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_c_of_type_Long, this.a.jdField_b_of_type_JavaLangString);
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.a.jdField_c_of_type_Long) + "], strTmp[" + this.a.jdField_d_of_type_JavaLangString + "]");
      }
      this.a.jdField_a_of_type_Long = FileManagerUtil.a(this.a.jdField_d_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_Long == this.a.jdField_d_of_type_Long)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
        this.a.a(2003);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 11, new Object[] { this.a.jdField_b_of_type_JavaLangString, Long.valueOf(this.a.jdField_d_of_type_Long), Boolean.valueOf(true), this.a.f }, 0, null);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
        if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.a.jdField_b_of_type_JavaLangString = this.a.a(this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (FileUtils.a(this.a.jdField_b_of_type_JavaLangString)) {
          this.a.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.a.jdField_b_of_type_JavaLangString);
        }
        FileUtils.a(new File(this.a.jdField_d_of_type_JavaLangString), new File(this.a.jdField_b_of_type_JavaLangString));
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, 0L, this.a.f, this.a.jdField_e_of_type_JavaLangString, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.a.jdField_d_of_type_Long, FileManagerRSWorker.b(this.a), null);
        return;
      }
      if (this.a.jdField_d_of_type_Long > this.a.jdField_a_of_type_Long)
      {
        l = this.a.jdField_d_of_type_Long - this.a.jdField_a_of_type_Long;
        if (SystemUtil.a()) {}
        for (paramLong = SystemUtil.a() * 1024L; paramLong < l; paramLong = SystemUtil.b() * 1024L)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "]" + "local space no enough!! [downsize:" + l + "mobile space:" + paramLong + "]");
          this.a.a(2005);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 12, null, 12, null);
          FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "sdcard full", null);
          FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "sdcard full", null);
          return;
        }
      }
      if (this.a.jdField_a_of_type_JavaIoOutputStream == null) {}
      try
      {
        this.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.a.jdField_d_of_type_JavaLangString, true);
        if (this.a.jdField_b_of_type_Int == 1) {
          this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_c_of_type_Long, 2002);
        }
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        FileManagerRSWorker.a(this.a, this.a.jdField_a_of_type_Long, null);
        return;
      }
      catch (FileNotFoundException paramString1)
      {
        for (;;)
        {
          paramString1.printStackTrace();
        }
      }
      label2703:
      paramByteStringMicro = null;
    }
  }
  
  protected void a(boolean paramBoolean, long paramLong1, String paramString1, String paramString2, String paramString3, int paramInt1, String paramString4, String paramString5, int paramInt2, long paramLong2)
  {
    if (this.a.a()) {
      return;
    }
    if (!paramBoolean)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] get offlinefile info is error!retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramInt2);
      this.a.a(2005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == -100001L) {}
      for (paramLong2 = 9043L;; paramLong2 = 9045L)
      {
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "ret error", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong2, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "ret error", null);
        return;
      }
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramString3 != null)
    {
      localObject1 = localObject2;
      if (paramString4 != null)
      {
        paramString3 = paramString3 + ":" + paramInt1;
        paramString4 = FileManagerRSWorker.b(this.a, paramString4);
        localObject1 = new ArrayList(1);
        ((List)localObject1).add(paramString3);
        FileManagerRSWorker.a(this.a, new HttpUrlProcessor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (List)localObject1, paramString4));
        localObject1 = FileManagerRSWorker.a(this.a).a();
      }
    }
    if (localObject1 == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] get DiscdownLoad info Url is null");
      this.a.a(2005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 12, null, (int)paramLong1, paramString1);
      if (paramLong1 == 0L) {
        paramLong1 = 9048L;
      }
      for (;;)
      {
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt2), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "ip url error", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramLong1, String.valueOf(paramInt2), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "ip url error", null);
        return;
      }
    }
    this.a.f = ((String)localObject1);
    FileManagerRSWorker.a(this.a, this.a.f);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.a.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramLong1) + "]downLoadUrl[" + String.valueOf(this.a.f) + "]");
    if ((paramString1 != null) && (paramString1.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramLong1) + "], retMsg:" + paramString1);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 4, null, (int)paramLong1, paramString1);
    }
    if ((paramString2 != null) && (paramString2.length() > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSeseeId[" + String.valueOf(this.a.jdField_c_of_type_Long) + "]renamed[" + String.valueOf(paramString2) + "]");
      }
      this.a.jdField_b_of_type_JavaLangString = this.a.a(this.a.jdField_e_of_type_JavaLangString, paramString2);
    }
    if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType == 1) {
      this.a.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.a.jdField_b_of_type_JavaLangString);
    }
    this.a.jdField_d_of_type_JavaLangString = (this.a.jdField_c_of_type_JavaLangString + "dsc-" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.replace("/", "")));
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      this.a.a(2005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 1, null, 2, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.a.jdField_c_of_type_Long) + "], NetWork Error, notify UI!");
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "net", null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 2L, String.valueOf(paramInt2) + "&" + String.valueOf(paramLong1), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "net", null);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_c_of_type_Long, this.a.jdField_b_of_type_JavaLangString);
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "sessionId[" + String.valueOf(this.a.jdField_c_of_type_Long) + "], strTmp[" + this.a.jdField_d_of_type_JavaLangString + "]");
    }
    this.a.jdField_a_of_type_Long = FileManagerUtil.a(this.a.jdField_d_of_type_JavaLangString);
    if (this.a.jdField_a_of_type_Long == this.a.jdField_d_of_type_Long)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.cloudType = 3;
      this.a.a(2003);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 11, new Object[] { this.a.jdField_b_of_type_JavaLangString, Long.valueOf(this.a.jdField_d_of_type_Long), Boolean.valueOf(true), this.a.f }, 0, null);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.d(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.a.jdField_b_of_type_JavaLangString = this.a.a(this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (FileUtils.a(this.a.jdField_b_of_type_JavaLangString)) {
        this.a.jdField_b_of_type_JavaLangString = FileManagerUtil.b(this.a.jdField_b_of_type_JavaLangString);
      }
      FileUtils.a(new File(this.a.jdField_d_of_type_JavaLangString), new File(this.a.jdField_b_of_type_JavaLangString));
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = FileManagerUtil.a(this.a.jdField_b_of_type_JavaLangString);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + String.valueOf(this.a.jdField_c_of_type_Long) + "], fileExisted, notify UI!");
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, 0L, this.a.f, this.a.jdField_e_of_type_JavaLangString, this.a.f, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.a.jdField_d_of_type_Long, FileManagerRSWorker.b(this.a), null);
      return;
    }
    if (this.a.jdField_d_of_type_Long > this.a.jdField_a_of_type_Long)
    {
      paramLong2 = this.a.jdField_d_of_type_Long - this.a.jdField_a_of_type_Long;
      if (SystemUtil.a()) {}
      for (paramLong1 = SystemUtil.a() * 1024L; paramLong1 < paramLong2; paramLong1 = SystemUtil.b() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "]" + "local space no enough!! [downsize:" + paramLong2 + "mobile space:" + paramLong1 + "]");
        this.a.a(2005);
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 12, null, 12, null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "sdcard full", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "sdcard full", null);
        return;
      }
    }
    if (this.a.jdField_a_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.a.jdField_a_of_type_JavaIoOutputStream = new FileOutputStream(this.a.jdField_d_of_type_JavaLangString, true);
      label2634:
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_c_of_type_Long, 2002);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      for (paramString1 = this.a.jdField_e_of_type_JavaLangString; paramString1.length() < 10; paramString1 = "0" + paramString1) {}
      this.a.jdField_h_of_type_JavaLangString = ("FTN5K=" + paramString5);
      FileManagerRSWorker.a(this.a, this.a.jdField_a_of_type_Long, this.a.jdField_h_of_type_JavaLangString);
      return;
    }
    catch (FileNotFoundException paramString1)
    {
      break label2634;
    }
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.a.jdField_c_of_type_Long + "]" + "wk,onUpdateSetOfflineFileState-->failed");
      this.a.a(1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      if (paramFileUploadInfo.jdField_a_of_type_Int == -100001) {}
      for (int i = 9043;; i = 9045)
      {
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "setSuccFaild", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "setSuccFaild", null);
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.a.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
        return;
      }
    }
    QLog.d("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.a.jdField_c_of_type_Long + "]" + "onUpdateSetOfflineFileState success, send CC!");
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, FileManagerRSWorker.a(this.a));
  }
  
  protected void a(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo, List paramList)
  {
    if (this.a.a())
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.a.jdField_c_of_type_Long + "]" + "onUpdateSendOfflineFile: but this work has stop");
      }
      return;
    }
    this.a.jdField_i_of_type_Long = 0L;
    int i;
    if (!paramBoolean)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.a.jdField_c_of_type_Long + "]" + "wk,onUpdateSendOfflineFile-->failed");
      this.a.a(1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      if (paramFileUploadInfo.jdField_a_of_type_Int == -100001) {}
      for (i = 9043;; i = 9045)
      {
        paramList = "server retError";
        if (paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) {
          paramList = paramFileUploadInfo.jdField_a_of_type_JavaLangString;
        }
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), paramList, null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), paramList, null);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.a.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.a.jdField_c_of_type_Long + "]" + "wk,handleSendOfflineFileResp");
    }
    if ((paramFileUploadInfo.jdField_b_of_type_JavaLangString == null) || (paramFileUploadInfo.jdField_b_of_type_JavaLangString.length() == 0))
    {
      this.a.a(1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 15, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "]" + "ResultCodeNoServerAddr ip = 0");
      if (paramFileUploadInfo.jdField_a_of_type_Int == 0) {}
      for (i = 9048;; i = paramFileUploadInfo.jdField_a_of_type_Int)
      {
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "onUpSend ip url error", null);
        FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, i, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "onUpSend ip url error", null);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.a.jdField_c_of_type_Long) + "],retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "]");
    if ((paramFileUploadInfo.jdField_a_of_type_JavaLangString != null) && (paramFileUploadInfo.jdField_a_of_type_JavaLangString.length() > 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "] will show taost, retCode[" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int) + "], retMsg:" + paramFileUploadInfo.jdField_a_of_type_JavaLangString);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 4, null, paramFileUploadInfo.jdField_a_of_type_Int, paramFileUploadInfo.jdField_a_of_type_JavaLangString);
    }
    if ((paramFileUploadInfo.jdField_a_of_type_ArrayOfByte != null) && (paramFileUploadInfo.jdField_a_of_type_ArrayOfByte.length > 0))
    {
      this.a.jdField_g_of_type_JavaLangString = new String(paramFileUploadInfo.jdField_a_of_type_ArrayOfByte);
      this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.a.jdField_g_of_type_JavaLangString;
      localObject = this.a.jdField_b_of_type_JavaLangString;
      if (this.a.jdField_d_of_type_Long >= 10002432L) {
        break label1472;
      }
    }
    byte[] arrayOfByte;
    StringBuffer localStringBuffer;
    label1472:
    for (long l = this.a.jdField_d_of_type_Long;; l = 10002432L)
    {
      arrayOfByte = MD5.getPartfileMd5((String)localObject, l);
      localStringBuffer = new StringBuffer();
      i = 0;
      while (i < arrayOfByte.length)
      {
        String str = Integer.toHexString(arrayOfByte[i] & 0xFF);
        localObject = str;
        if (str.length() == 1) {
          localObject = '0' + str;
        }
        System.out.print(((String)localObject).toUpperCase() + " ");
        localStringBuffer.append(((String)localObject).toUpperCase() + " ");
        i += 1;
      }
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!Server Return the UUID is null!!!!!");
      break;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FileManagerRSWorker<FileAssistant>", 2, "onUpdateSendOfflineFile rawMd5[" + localStringBuffer.toString() + "]");
    }
    if (arrayOfByte == null)
    {
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "getfile md5 error", null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "getfile md5 error", null);
      this.a.b(null, null);
      return;
    }
    if (!Arrays.equals(paramFileUploadInfo.jdField_c_of_type_ArrayOfByte, arrayOfByte))
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.a.jdField_c_of_type_Long) + "]" + "Md5 not equal, file may changed");
      this.a.a(1005);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_b_of_type_Long, this.a.jdField_c_of_type_Long, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_Int, 15, null, 5, null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_i_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.a(this.a), "file md5 server md5 not equal", null);
      FileManagerUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.a.jdField_j_of_type_JavaLangString, this.a.jdField_g_of_type_Long, FileManagerRSWorker.a(this.a), this.a.jdField_e_of_type_JavaLangString, this.a.jdField_g_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, String.valueOf(paramStatictisInfo.jdField_a_of_type_Int) + "&" + String.valueOf(paramFileUploadInfo.jdField_a_of_type_Int), this.a.jdField_i_of_type_Long, this.a.jdField_a_of_type_Long, this.a.jdField_d_of_type_Long, FileManagerRSWorker.a(this.a), "", FileManagerRSWorker.b(this.a), "file md5 server md5 not equal", null);
      return;
    }
    paramStatictisInfo = new byte[arrayOfByte.length + 4];
    PkgTools.a(paramStatictisInfo, 0, arrayOfByte, arrayOfByte.length);
    PkgTools.a(paramStatictisInfo, arrayOfByte.length, this.a.jdField_d_of_type_Long);
    Object localObject = HexUtil.bytes2HexStr(paramFileUploadInfo.jdField_b_of_type_ArrayOfByte);
    paramStatictisInfo = HexUtil.bytes2HexStr(paramStatictisInfo).toLowerCase(Locale.US);
    paramList.add(0, paramFileUploadInfo.jdField_b_of_type_JavaLangString + ":" + paramFileUploadInfo.jdField_a_of_type_Short);
    paramStatictisInfo = FileManagerRSWorker.a(this.a, (String)localObject, paramStatictisInfo, this.a.jdField_d_of_type_Long);
    FileManagerRSWorker.a(this.a, new HttpUrlProcessor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramList, paramStatictisInfo));
    this.a.f = FileManagerRSWorker.a(this.a).a();
    FileManagerRSWorker.a(this.a, this.a.f);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.a.f;
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    if (QLog.isColorLevel()) {
      QLog.e("##########", 2, "已收到CS包,准备开始上传任务,nSessionID[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
    }
    if (paramFileUploadInfo.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.a.jdField_c_of_type_Long + "], onUpdateSendOfflineFile: file Exist");
      }
      if (QLog.isColorLevel()) {
        QLog.d("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.a.jdField_c_of_type_Long + "], FileSize[" + this.a.jdField_d_of_type_Long + "], Uuid[" + this.a.jdField_g_of_type_JavaLangString + "]");
      }
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "CS秒传,nSessionID[" + String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      this.a.jdField_j_of_type_Long = System.currentTimeMillis();
      this.a.jdField_h_of_type_Long = System.currentTimeMillis();
      FileManagerUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, 5, this.a.f);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.a.jdField_a_of_type_JavaLangString, this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, FileManagerRSWorker.a(this.a));
      paramFileUploadInfo = new FileManagerReporter.fileAssistantReportData();
      paramFileUploadInfo.jdField_b_of_type_JavaLangString = "send_file_suc";
      paramFileUploadInfo.jdField_a_of_type_Int = 1;
      FileManagerReporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), paramFileUploadInfo);
      return;
    }
    this.a.jdField_e_of_type_Long = paramFileUploadInfo.jdField_b_of_type_Int;
    this.a.a(this.a.f, 0L);
  }
  
  protected void b(boolean paramBoolean, FileTransferHandler.FileUploadInfo paramFileUploadInfo, MessageObserver.StatictisInfo paramStatictisInfo)
  {
    super.b(paramBoolean, paramFileUploadInfo, paramStatictisInfo);
    if ((paramBoolean) && ((paramFileUploadInfo.jdField_c_of_type_Int == 2) || (paramFileUploadInfo.jdField_c_of_type_Int == 0)) && (!this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend))
    {
      QLog.d("FileManagerRSWorker<FileAssistant>", 1, "onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.jdField_c_of_type_Int + "]. need to send file receipt");
      if (this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.a.jdField_d_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
        return;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.a.jdField_e_of_type_JavaLangString, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.a.jdField_d_of_type_Long, this.a.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq);
      return;
    }
    QLog.d("FileManagerRSWorker<FileAssistant>", 1, "onDownloadFileSuc isSuccess[" + paramBoolean + "],retCode[" + paramFileUploadInfo.jdField_a_of_type_Int + "],retMsg[" + paramFileUploadInfo.jdField_a_of_type_JavaLangString + "],retStat[" + paramFileUploadInfo.jdField_c_of_type_Int + "]. don't need to send file receipt");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     dou
 * JD-Core Version:    0.7.0.1
 */