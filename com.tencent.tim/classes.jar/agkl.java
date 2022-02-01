import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.VFSFile;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.3;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.4;
import com.tencent.mobileqq.filemanager.core.FileManagerRSWorker.8;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.Executor;
import mqq.os.MqqHandler;

public class agkl
  implements agpb, aqoi
{
  long HO = 0L;
  public long YD = 0L;
  long YE;
  public long YF = 0L;
  long YG = 0L;
  long YH = 0L;
  long YI = 0L;
  private aglb jdField_a_of_type_Aglb;
  agmv jdField_a_of_type_Agmv = null;
  agzu jdField_a_of_type_Agzu = null;
  agzx jdField_a_of_type_Agzx = null;
  ahaf jdField_a_of_type_Ahaf = null;
  aqog jdField_a_of_type_Aqog;
  public String aBA = null;
  String aEL = null;
  public int actionType;
  public QQAppInterface app;
  auyc jdField_b_of_type_Auyc;
  VFSFile jdField_b_of_type_ComTencentMmVfsVFSFile = null;
  String bHI;
  public String bHJ;
  public String bHK;
  String bHL;
  public String bHM = null;
  public String bHN = null;
  private String bHO = "";
  boolean bUseMediaPlatform;
  public FileManagerEntity c;
  public OutputStream c;
  int cXp = 0;
  int cXq = 0;
  private int cXr;
  private int cXs;
  private int cXt;
  private int cXu;
  int cXv = 0;
  boolean cdQ = false;
  public byte[] dO;
  public byte[] dP;
  public byte[] dQ;
  private agie e = new agkm(this);
  long endTime = 0L;
  InputStream i = null;
  boolean isStop = false;
  int[] lo = new int[0];
  public long nFileSize = 0L;
  public long nSessionId = 0L;
  public int peerType;
  Runnable runnable;
  String selfUin;
  public String serverPath;
  public long startTime = 0L;
  private int status;
  public String strFilePath;
  public String strUin;
  public long uniseq = 0L;
  
  public agkl(QQAppInterface paramQQAppInterface, FileManagerEntity paramFileManagerEntity)
  {
    this.jdField_c_of_type_JavaIoOutputStream = null;
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
      label183:
      return;
    }
    this.strFilePath = paramFileManagerEntity.getFilePath();
    this.peerType = paramFileManagerEntity.peerType;
    this.bHK = paramFileManagerEntity.Uuid;
    this.bHL = paramFileManagerEntity.fileIdCrc;
    this.bUseMediaPlatform = paramFileManagerEntity.bUseMediaPlatform;
    this.actionType = paramFileManagerEntity.nOpType;
    this.serverPath = paramFileManagerEntity.strServerPath;
    this.strUin = paramFileManagerEntity.peerUin;
    this.jdField_a_of_type_Ahaf = ahaf.a();
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity = paramFileManagerEntity;
    for (;;)
    {
      try
      {
        this.isStop = true;
        this.app = paramQQAppInterface;
        this.selfUin = paramQQAppInterface.getAccount();
        if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName == null)) {
          this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strSrcName = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName;
        }
        vc();
        switch (this.actionType)
        {
        default: 
          this.nFileSize = paramFileManagerEntity.fileSize;
          this.uniseq = paramFileManagerEntity.uniseq;
          this.nSessionId = paramFileManagerEntity.nSessionId;
          paramFileManagerEntity.status = 0;
          paramQQAppInterface.a().u(paramFileManagerEntity);
          paramFileManagerEntity.fProgress = 0.0F;
          paramFileManagerEntity.status = 2;
          if (this.jdField_b_of_type_Auyc != null) {
            break label183;
          }
          this.jdField_b_of_type_Auyc = new auyc();
          return;
        }
      }
      finally {}
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + paramFileManagerEntity.nSessionId + "]filepath[" + this.strFilePath + "]:size[" + String.valueOf(paramFileManagerEntity.fileSize) + "]");
      }
      setStatus(2);
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.aBA = "actFileUp";
        this.bHN = "actFileUpDetail";
      }
      for (;;)
      {
        if ((paramFileManagerEntity.getFilePath() == null) || (paramFileManagerEntity.getFilePath().length() <= 0)) {
          break label614;
        }
        this.jdField_b_of_type_ComTencentMmVfsVFSFile = new VFSFile(paramFileManagerEntity.getFilePath());
        break;
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.aBA = "actDiscussFileUp";
          this.bHN = "actDiscussFileUpDetail";
        }
      }
      label614:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.nSessionId) + "]getTransferFilePath");
      }
      this.strFilePath = aX(this.strUin, paramFileManagerEntity.fileName);
      setStatus(2);
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 0)
      {
        this.aBA = "actFileDown";
        this.bHN = "actFileDownDetail";
      }
      for (;;)
      {
        if (!this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) {
          break label761;
        }
        this.aBA = "actFileUfGenDownload";
        this.bHN = "actFileUfGenDownloadDetail";
        break;
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType == 3000)
        {
          this.aBA = "actFileDiscDownLoad";
          this.bHN = "actFileDiscDownLoadDetail";
        }
      }
      label761:
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "download insert, nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.aBA = "actFileWyDown";
      continue;
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "upload insert nSessionId[" + String.valueOf(paramFileManagerEntity.nSessionId) + "] ,fileId[" + paramFileManagerEntity.WeiYunFileId + "], fileName[" + paramFileManagerEntity.fileName + "], fileSize[" + String.valueOf(paramFileManagerEntity.fileSize) + "], modifyTime[" + String.valueOf(paramFileManagerEntity.lastTime) + "]");
      }
      this.aBA = "actFileWyUp";
    }
  }
  
  private int Eo()
  {
    return ahbr.dg(this.serverPath);
  }
  
  private void a(long paramLong, agkl.a parama)
  {
    this.app.a().Jh(false);
    parama = new ArrayList();
    parama.add(this.bHJ);
    this.jdField_a_of_type_Ahaf.a(paramLong, parama, SplashActivity.sTopActivity, new agkt(this));
  }
  
  private void a(aqog paramaqog, Bundle paramBundle, int paramInt, long paramLong)
  {
    this.cXr += 1;
    this.cXu += 1;
    if (paramInt == 9056)
    {
      if (this.cXs < 3)
      {
        this.cXs += 1;
        this.cXr -= 1;
      }
    }
    else if (paramInt == 9042)
    {
      if (this.cXt >= 3) {
        break label303;
      }
      this.cXt += 1;
      this.cXr -= 1;
    }
    for (;;)
    {
      int j = 6000;
      if (paramInt == 9056) {
        j = 0;
      }
      ThreadManager.getFileThreadHandler().postDelayed(new FileManagerRSWorker.3(this), j);
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.nSessionId + "] after [" + j + "] time retry!");
      int k = paramInt;
      if (9048 == paramInt) {
        k = 11202;
      }
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, paramLong, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, k, String.valueOf(paramaqog.Mk()), this.YF, this.YD, this.nFileSize, paramaqog.getRealUrl(), paramaqog.cuw, this.cXu, "delayTimes[" + j + "]" + paramaqog.getErrorString(), null, paramBundle);
      return;
      this.cXs = 0;
      break;
      label303:
      this.cXt = 0;
    }
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new agzw();
    paramString.bJz = this.strUin;
    paramString.ej = paramArrayOfByte2;
    paramString.ei = paramArrayOfByte1;
    paramString.fileSize = this.nFileSize;
    paramString.md5 = this.dO;
    if (paramLong <= 104857600L)
    {
      paramString.cYU = 1700;
      this.dP = ahav.x(new String(paramArrayOfByte1));
      if (this.dP == null)
      {
        j(null, 0);
        return;
      }
      paramString.sha1 = this.dP;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.nSessionId + "], filesize < 100 get sha1");
    }
    for (;;)
    {
      this.app.a().a(paramString, this.e, paramFileManagerEntity);
      return;
      paramString.cYU = 1600;
      this.dQ = ahav.B(new String(paramArrayOfByte1));
      paramFileManagerEntity.strFileSha3 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.dQ);
      paramFileManagerEntity.str10Md5 = com.tencent.commonsdk.util.HexUtil.bytes2HexStr(this.dO);
      if (this.dQ == null)
      {
        j(null, 0);
        return;
      }
      paramString.el = this.dQ;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [CS Step], SessionId[" + this.nSessionId + "], filesize > 100 get sha3");
    }
  }
  
  private boolean a(aqog paramaqog1, aqog paramaqog2)
  {
    if (paramaqog1 == null) {}
    do
    {
      return false;
      if (paramaqog2 == null) {
        return true;
      }
    } while (!aqiw.isNetSupport(BaseApplication.getContext()));
    return true;
  }
  
  private void ar(long paramLong, String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]id[" + String.valueOf(this.nSessionId) + "] receviveFile, pos[" + paramLong + "] url:" + this.serverPath);
    if (this.isStop) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Recv]id[" + String.valueOf(this.nSessionId) + "] is stoped!");
    }
    do
    {
      return;
      String str2 = "bytes=" + paramLong + "-";
      aqog localaqog = new aqog(this.serverPath, null, this, true);
      localaqog.setInstanceFollowRedirects(false);
      String str1 = "gprs";
      if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
        str1 = "wifi";
      }
      localaqog.setRequestProperty("Net-type", str1);
      localaqog.setRequestProperty("cache-control", "no-cache");
      localaqog.setRequestProperty("Range", str2);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "set cookie:" + paramString);
      }
      if (paramString != null) {
        localaqog.setRequestProperty("Cookie", paramString);
      }
      localaqog.setPriority(1);
      localaqog.SP(true);
      localaqog.fileType = 0;
      localaqog.busiType = this.peerType;
      localaqog.msgId = String.valueOf(this.nSessionId);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Recv]Id[" + String.valueOf(this.nSessionId) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.peerType) + "]");
      localaqog.setRequestProperty("Accept-Encoding", "identity");
      paramString = "";
      if (this.serverPath != null) {
        paramString = this.serverPath.toLowerCase();
      }
      if ((this.cdQ) && (paramString.startsWith("https")))
      {
        localaqog.mIsHttps = true;
        localaqog.cML = aglb.mp(this.serverPath);
        localaqog.cux = this.aEL;
      }
      localaqog.d = ahav.a();
      this.app.getHttpCommunicatort().a(localaqog);
      this.jdField_a_of_type_Aqog = localaqog;
    } while (paramLong != 0L);
    setStatus(2001);
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 10, null, 6, null);
  }
  
  private void dhr()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Download]Id[" + this.nSessionId + "] downLoad Success!");
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = ahav.getFileName(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = anaz.gQ();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v [Http Download]Id[" + this.nSessionId + "] update successTime[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    int j = this.strFilePath.length() - this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - j)
    {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = ahav.al(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - j);
      this.strFilePath = aX(this.strUin, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("param_V6SelectType", this.cXp);
    ((Bundle)localObject1).putInt("param_ipAddrType", Eo());
    if (this.cdQ) {}
    for (j = 1;; j = 0)
    {
      ((Bundle)localObject1).putInt("param_ishttps", j);
      if (aqhq.fileExists(this.strFilePath)) {
        this.strFilePath = ahav.kW(this.strFilePath);
      }
      try
      {
        if (ahav.b(new VFSFile(this.bHJ), new VFSFile(this.strFilePath))) {
          break;
        }
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.bHJ + "],strFilePath[" + this.strFilePath + "]");
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, "rename error", null, (Bundle)localObject1);
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "rename error", null, (Bundle)localObject1);
        b(null, null);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
        localObject2 = com.qq.taf.jce.HexUtil.bytes2HexStr(ahav.t(this.strFilePath));
        if (localObject2 != null) {
          break label1272;
        }
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "rename error", null, (Bundle)localObject1);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = ahav.getFileName(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = ahav.getFileType(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSha3 = agoy.t(ahav.A(this.strFilePath));
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize < 104857600L) {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileSHA = agoy.t(ahav.x(this.strFilePath));
      }
    }
    Object localObject2 = new VFSFile(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.localModifyTime = ((VFSFile)localObject2).lastModified();
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    setStatus(2003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.nSessionId) + "]recive success, set TrafficData,size[" + String.valueOf(this.YD) + "]");
    }
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 11, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
    this.endTime = System.currentTimeMillis();
    ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.endTime - this.startTime, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.YF, this.YD, this.nFileSize, this.cXu, null, (Bundle)localObject1);
    ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.endTime - this.startTime, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.YF, this.YD, this.nFileSize, this.cXu, null, (Bundle)localObject1);
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      ahbh.O(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      ahbh.M(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      ahav.K(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = new Bundle();
        ((Bundle)localObject1).putString("FILE_TMP_SERVER_PATH", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
        ((Bundle)localObject1).putLong("FILE_TMP_RELATED_ID", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);
        ((Bundle)localObject1).putString("FILE_TMP_DIR_PATH", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
        ((Bundle)localObject1).putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
        ((Bundle)localObject1).putString("FILE_TMP_ZIP_FILEID", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFileId);
        this.app.a().a(null, -1, this.strFilePath, this.nFileSize, 190, null, (Bundle)localObject1);
      }
      localObject1 = new ahau.a();
      ((ahau.a)localObject1).bJE = "rece_file_suc";
      ((ahau.a)localObject1).cYX = 1;
      ahau.a(this.app.getCurrentAccountUin(), (ahau.a)localObject1);
      return;
      label1272:
      if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject2).equalsIgnoreCase(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "rename error", null, (Bundle)localObject1);
        break;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      break;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        ahav.J(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      }
    }
  }
  
  private void dht()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.app.a().dhl();
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    FileManagerEntity localFileManagerEntity;
    do
    {
      return;
      long l2 = this.nFileSize - this.YD;
      if (aqfo.isExistSDCard()) {}
      for (long l1 = aqfo.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = aqfo.getSystemAvailableSize() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.app.a().dhl();
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 12, null);
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9040L, "", this.YD, this.YD, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
        return;
      }
      localFileManagerEntity = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      this.nFileSize = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Agmv = this.app.a().a().a(localFileManagerEntity, null, new agkr(this, localFileManagerEntity));
    } while (this.jdField_a_of_type_Agmv == null);
    this.jdField_a_of_type_Agmv.setFileId(localFileManagerEntity.WeiYunFileId);
  }
  
  private void dhw()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "start Rsworker OfflineFileHitReq:" + anaz.gQ());
    }
    ahav.a.getExecutor().execute(new FileManagerRSWorker.8(this));
  }
  
  private String kQ(String paramString)
  {
    return "/ftn_handler/" + paramString;
  }
  
  private boolean mn(String paramString)
  {
    return (paramString.contains("-6101")) || (paramString.contains("-7003")) || (paramString.contains("-403")) || (paramString.contains("-9006")) || (paramString.contains("-9004")) || (paramString.contains("-9017")) || (paramString.contains("-28137"));
  }
  
  private boolean mo(String paramString)
  {
    return (paramString.contains("-29120")) || (paramString.contains("-502")) || (paramString.contains("HTTP_PROXY_AUTH")) || (paramString.contains("-29150")) || (paramString.contains("-21122")) || (paramString.contains("-28123")) || (paramString.contains("-25081")) || (paramString.contains("-28126"));
  }
  
  private void p(String paramString, long paramLong, int paramInt)
  {
    this.YF += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step] Id[" + this.nSessionId + "]sendFilePakage transferData null");
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "get Stream null", null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "get Stream null", null);
      b(null, null);
    }
    do
    {
      return;
      localObject = new aqog(paramString + "&bmd5=" + MD5.toMD5((byte[])localObject) + "&range=" + String.valueOf(paramLong), (byte[])localObject, this);
      ((aqog)localObject).setInstanceFollowRedirects(false);
      ((aqog)localObject).setRequestProperty("cache-control", "no-cache");
      paramString = "gprs";
      if (aqiw.getNetworkType(BaseApplication.getContext()) == 1) {
        paramString = "wifi";
      }
      ((aqog)localObject).setRequestProperty("Net-type", paramString);
      ((aqog)localObject).setRequestProperty("Range", "bytes=" + paramLong + "-");
      ((aqog)localObject).setRequestMethod("POST");
      ((aqog)localObject).setPriority(1);
      ((aqog)localObject).fileType = 0;
      ((aqog)localObject).busiType = this.peerType;
      ((aqog)localObject).msgId = String.valueOf(this.nSessionId);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + this.nSessionId + "]send http data size[" + paramInt + "], peerType[" + this.peerType + "]");
      }
      this.app.getHttpCommunicatort().a((aqog)localObject);
      this.jdField_a_of_type_Aqog = ((aqog)localObject);
    } while (!QLog.isColorLevel());
    QLog.e("##########", 2, "发送一个数据包,nSessionID[" + String.valueOf(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
  }
  
  private static String vd()
  {
    try
    {
      Thread.sleep(1L);
      long l = System.currentTimeMillis();
      String str = new SimpleDateFormat("yyyyMMddHHmmssSS", Locale.US).format(new Date(l));
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
  
  public void Hp(String paramString)
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, new location:" + paramString);
    if (this.jdField_a_of_type_Aqog == null)
    {
      QLog.w("FileManagerRSWorker<FileAssistant>", 1, "handleRedirect, but curRequest is null");
      return;
    }
    ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, String.valueOf(this.jdField_a_of_type_Aqog.Mk()), this.YF, this.YD, this.nFileSize, this.jdField_a_of_type_Aqog.getRealUrl(), this.jdField_a_of_type_Aqog.cuw, this.cXu, this.jdField_a_of_type_Aqog.getErrorString() + "&UrlOver&handleRedirect", null);
    j(null, 0);
  }
  
  void II(String paramString)
  {
    if (this.actionType == 0) {}
    for (int j = 1; j != 0; j = 0)
    {
      this.serverPath = paramString;
      this.bHO = this.serverPath;
      this.cXv += 1;
      aj(this.serverPath, 0L);
      return;
    }
    this.serverPath = paramString;
    this.bHO = this.serverPath;
    this.cXv += 1;
    this.YD = ahav.getFileSizes(this.bHJ);
    ar(this.YD, this.bHM);
  }
  
  public FileManagerEntity a()
  {
    return this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
  }
  
  /* Error */
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 90	agkl:lo	[I
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: new 722	android/os/Bundle
    //   12: dup
    //   13: invokespecial 723	android/os/Bundle:<init>	()V
    //   16: astore 13
    //   18: aload_0
    //   19: invokevirtual 1089	agkl:isStop	()Z
    //   22: ifeq +55 -> 77
    //   25: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   28: ifeq +45 -> 73
    //   31: ldc_w 1036
    //   34: iconst_2
    //   35: new 260	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 1091
    //   45: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: aload_0
    //   49: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   52: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   55: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   58: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: ldc_w 1093
    //   64: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload 12
    //   75: monitorexit
    //   76: return
    //   77: aload_1
    //   78: aload_0
    //   79: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   82: if_acmpeq +312 -> 394
    //   85: aload_1
    //   86: ifnull +94 -> 180
    //   89: aload_0
    //   90: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   93: ifnull +87 -> 180
    //   96: ldc_w 258
    //   99: iconst_1
    //   100: new 260	java/lang/StringBuilder
    //   103: dup
    //   104: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   107: ldc_w 1095
    //   110: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   113: aload_0
    //   114: getfield 94	agkl:nSessionId	J
    //   117: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   120: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc_w 1097
    //   126: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: aload_1
    //   130: invokevirtual 454	aqog:Mk	()I
    //   133: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   136: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: ldc_w 1099
    //   142: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   145: aload_0
    //   146: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   149: invokevirtual 454	aqog:Mk	()I
    //   152: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   155: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc_w 282
    //   161: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload 12
    //   172: monitorexit
    //   173: return
    //   174: astore_1
    //   175: aload 12
    //   177: monitorexit
    //   178: aload_1
    //   179: athrow
    //   180: aload_1
    //   181: ifnull +145 -> 326
    //   184: ldc_w 258
    //   187: iconst_1
    //   188: new 260	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 1095
    //   198: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 94	agkl:nSessionId	J
    //   205: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   208: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: ldc_w 1097
    //   214: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: aload_1
    //   218: invokevirtual 454	aqog:Mk	()I
    //   221: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   224: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: ldc_w 282
    //   230: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   233: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   236: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   239: goto -69 -> 170
    //   242: astore 10
    //   244: aload 10
    //   246: invokevirtual 1100	java/lang/Exception:printStackTrace	()V
    //   249: ldc_w 258
    //   252: iconst_1
    //   253: aload 10
    //   255: invokevirtual 1101	java/lang/Exception:toString	()Ljava/lang/String;
    //   258: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   261: ldc 143
    //   263: astore 9
    //   265: aload 10
    //   267: invokevirtual 1105	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   270: astore 10
    //   272: aload 10
    //   274: arraylength
    //   275: istore 4
    //   277: iconst_0
    //   278: istore_3
    //   279: iload_3
    //   280: iload 4
    //   282: if_icmpge +998 -> 1280
    //   285: aload 10
    //   287: iload_3
    //   288: aaload
    //   289: astore 11
    //   291: new 260	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   298: aload 9
    //   300: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 11
    //   305: invokevirtual 1108	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: ldc_w 1110
    //   311: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: astore 9
    //   319: iload_3
    //   320: iconst_1
    //   321: iadd
    //   322: istore_3
    //   323: goto -44 -> 279
    //   326: aload_0
    //   327: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   330: ifnull -160 -> 170
    //   333: ldc_w 258
    //   336: iconst_1
    //   337: new 260	java/lang/StringBuilder
    //   340: dup
    //   341: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   344: ldc_w 1095
    //   347: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_0
    //   351: getfield 94	agkl:nSessionId	J
    //   354: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   357: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   360: ldc_w 1112
    //   363: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: aload_0
    //   367: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   370: invokevirtual 454	aqog:Mk	()I
    //   373: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   376: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: ldc_w 282
    //   382: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   388: invokestatic 572	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   391: goto -221 -> 170
    //   394: aload_0
    //   395: getfield 190	agkl:actionType	I
    //   398: istore_3
    //   399: iload_3
    //   400: ifne +7 -> 407
    //   403: aload 12
    //   405: monitorexit
    //   406: return
    //   407: aload 13
    //   409: ldc_w 725
    //   412: aload_0
    //   413: getfield 118	agkl:cXp	I
    //   416: invokevirtual 729	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   419: aload 13
    //   421: ldc_w 731
    //   424: aload_0
    //   425: invokespecial 689	agkl:Eo	()I
    //   428: invokevirtual 729	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   431: aload_0
    //   432: getfield 126	agkl:cdQ	Z
    //   435: ifeq +1022 -> 1457
    //   438: iconst_1
    //   439: istore_3
    //   440: aload 13
    //   442: ldc_w 733
    //   445: iload_3
    //   446: invokevirtual 729	android/os/Bundle:putInt	(Ljava/lang/String;I)V
    //   449: aload_2
    //   450: invokevirtual 1115	aqog:getResponseCode	()I
    //   453: sipush 206
    //   456: if_icmpeq +15 -> 471
    //   459: aload_2
    //   460: invokevirtual 1115	aqog:getResponseCode	()I
    //   463: istore_3
    //   464: iload_3
    //   465: sipush 200
    //   468: if_icmpne -65 -> 403
    //   471: aload_0
    //   472: getfield 100	agkl:jdField_c_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   475: aload_2
    //   476: invokevirtual 1118	aqog:aB	()[B
    //   479: invokevirtual 1123	java/io/OutputStream:write	([B)V
    //   482: aload_0
    //   483: iconst_0
    //   484: putfield 361	agkl:cXr	I
    //   487: aload_2
    //   488: invokevirtual 1118	aqog:aB	()[B
    //   491: arraylength
    //   492: i2l
    //   493: lstore 5
    //   495: aload_0
    //   496: aload_0
    //   497: getfield 137	agkl:YF	J
    //   500: lload 5
    //   502: ladd
    //   503: putfield 137	agkl:YF	J
    //   506: aload_0
    //   507: lload 5
    //   509: aload_0
    //   510: getfield 88	agkl:YD	J
    //   513: ladd
    //   514: putfield 88	agkl:YD	J
    //   517: aload_0
    //   518: getfield 96	agkl:nFileSize	J
    //   521: lstore 5
    //   523: aload_2
    //   524: invokevirtual 1126	aqog:hR	()J
    //   527: lstore 5
    //   529: aload_0
    //   530: getfield 88	agkl:YD	J
    //   533: lload 5
    //   535: lcmp
    //   536: iflt +634 -> 1170
    //   539: aload_0
    //   540: getfield 172	agkl:peerType	I
    //   543: sipush 3000
    //   546: if_icmpeq +79 -> 625
    //   549: aload_0
    //   550: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   553: getfield 1129	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   556: ifne +69 -> 625
    //   559: ldc_w 258
    //   562: iconst_1
    //   563: new 260	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   570: ldc_w 1131
    //   573: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: aload_0
    //   577: getfield 94	agkl:nSessionId	J
    //   580: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   583: ldc_w 1133
    //   586: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   592: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   595: aload_0
    //   596: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   599: invokevirtual 520	com/tencent/mobileqq/app/QQAppInterface:a	()Lagib;
    //   602: aload_0
    //   603: getfield 216	agkl:selfUin	Ljava/lang/String;
    //   606: aload_0
    //   607: getfield 177	agkl:bHK	Ljava/lang/String;
    //   610: aload_0
    //   611: getfield 185	agkl:bUseMediaPlatform	Z
    //   614: aload_0
    //   615: getfield 182	agkl:bHL	Ljava/lang/String;
    //   618: aload_0
    //   619: getfield 135	agkl:e	Lagie;
    //   622: invokevirtual 1136	agib:a	(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Lagie;)V
    //   625: aload_0
    //   626: aconst_null
    //   627: putfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   630: aload_0
    //   631: getfield 100	agkl:jdField_c_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   634: invokevirtual 1139	java/io/OutputStream:close	()V
    //   637: aload_0
    //   638: aconst_null
    //   639: putfield 100	agkl:jdField_c_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   642: aload_0
    //   643: invokespecial 1141	agkl:dhr	()V
    //   646: goto -243 -> 403
    //   649: astore 9
    //   651: aload 9
    //   653: invokevirtual 1144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   656: ldc_w 1146
    //   659: invokevirtual 975	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   662: ifeq +126 -> 788
    //   665: aload_0
    //   666: monitorenter
    //   667: aload_0
    //   668: iconst_1
    //   669: putfield 106	agkl:isStop	Z
    //   672: aload_0
    //   673: monitorexit
    //   674: aload_0
    //   675: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   678: ifnull +83 -> 761
    //   681: ldc_w 258
    //   684: iconst_2
    //   685: new 260	java/lang/StringBuilder
    //   688: dup
    //   689: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   692: ldc_w 746
    //   695: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: aload_0
    //   699: getfield 94	agkl:nSessionId	J
    //   702: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   705: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   708: ldc_w 1148
    //   711: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   714: aload_0
    //   715: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   718: invokevirtual 454	aqog:Mk	()I
    //   721: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   724: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: ldc_w 1150
    //   730: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: aload 9
    //   735: invokevirtual 1144	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   738: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   744: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   747: aload_0
    //   748: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   751: invokevirtual 668	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   754: aload_0
    //   755: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   758: invokevirtual 1154	com/tencent/mobileqq/utils/httputils/HttpCommunicator:f	(Laqog;)V
    //   761: aload_0
    //   762: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   765: invokevirtual 372	com/tencent/mobileqq/app/QQAppInterface:a	()Lagkj;
    //   768: iconst_0
    //   769: invokevirtual 378	agkj:Jh	(Z)V
    //   772: aload_0
    //   773: aload_0
    //   774: getfield 96	agkl:nFileSize	J
    //   777: new 1156	agkp
    //   780: dup
    //   781: aload_0
    //   782: invokespecial 1157	agkp:<init>	(Lagkl;)V
    //   785: invokespecial 407	agkl:a	(JLagkl$a;)V
    //   788: aload_0
    //   789: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   792: aload_0
    //   793: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   796: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   799: aload_0
    //   800: getfield 120	agkl:aBA	Ljava/lang/String;
    //   803: aload_0
    //   804: getfield 108	agkl:startTime	J
    //   807: aload_0
    //   808: getfield 145	agkl:bHO	Ljava/lang/String;
    //   811: aload_0
    //   812: getfield 200	agkl:strUin	Ljava/lang/String;
    //   815: aload_0
    //   816: getfield 177	agkl:bHK	Ljava/lang/String;
    //   819: aload_0
    //   820: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   823: getfield 449	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   826: ldc2_w 751
    //   829: ldc 143
    //   831: aload_0
    //   832: getfield 137	agkl:YF	J
    //   835: aload_0
    //   836: getfield 88	agkl:YD	J
    //   839: aload_0
    //   840: getfield 96	agkl:nFileSize	J
    //   843: aload_0
    //   844: getfield 145	agkl:bHO	Ljava/lang/String;
    //   847: ldc 143
    //   849: aload_0
    //   850: getfield 361	agkl:cXr	I
    //   853: ldc_w 1159
    //   856: aconst_null
    //   857: aload 13
    //   859: invokestatic 473	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   862: aload_0
    //   863: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   866: aload_0
    //   867: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   870: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   873: aload_0
    //   874: getfield 122	agkl:bHN	Ljava/lang/String;
    //   877: aload_0
    //   878: getfield 108	agkl:startTime	J
    //   881: aload_0
    //   882: getfield 145	agkl:bHO	Ljava/lang/String;
    //   885: aload_0
    //   886: getfield 200	agkl:strUin	Ljava/lang/String;
    //   889: aload_0
    //   890: getfield 177	agkl:bHK	Ljava/lang/String;
    //   893: aload_0
    //   894: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   897: getfield 449	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   900: ldc2_w 751
    //   903: ldc 143
    //   905: aload_0
    //   906: getfield 137	agkl:YF	J
    //   909: aload_0
    //   910: getfield 88	agkl:YD	J
    //   913: aload_0
    //   914: getfield 96	agkl:nFileSize	J
    //   917: aload_0
    //   918: getfield 145	agkl:bHO	Ljava/lang/String;
    //   921: ldc 143
    //   923: aload_0
    //   924: getfield 415	agkl:cXu	I
    //   927: ldc_w 1159
    //   930: aconst_null
    //   931: aload 13
    //   933: invokestatic 473	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   936: aload_0
    //   937: aconst_null
    //   938: aconst_null
    //   939: invokevirtual 757	agkl:b	(Laqog;Laqog;)V
    //   942: aload 12
    //   944: monitorexit
    //   945: return
    //   946: astore 9
    //   948: aload_0
    //   949: monitorexit
    //   950: aload 9
    //   952: athrow
    //   953: astore 9
    //   955: aload_0
    //   956: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   959: aload_0
    //   960: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   963: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   966: aload_0
    //   967: getfield 120	agkl:aBA	Ljava/lang/String;
    //   970: aload_0
    //   971: getfield 108	agkl:startTime	J
    //   974: aload_0
    //   975: getfield 145	agkl:bHO	Ljava/lang/String;
    //   978: aload_0
    //   979: getfield 200	agkl:strUin	Ljava/lang/String;
    //   982: aload_0
    //   983: getfield 177	agkl:bHK	Ljava/lang/String;
    //   986: aload_0
    //   987: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   990: getfield 449	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   993: ldc2_w 751
    //   996: ldc 143
    //   998: aload_0
    //   999: getfield 137	agkl:YF	J
    //   1002: aload_0
    //   1003: getfield 88	agkl:YD	J
    //   1006: aload_0
    //   1007: getfield 96	agkl:nFileSize	J
    //   1010: aload_0
    //   1011: getfield 145	agkl:bHO	Ljava/lang/String;
    //   1014: ldc 143
    //   1016: aload_0
    //   1017: getfield 361	agkl:cXr	I
    //   1020: ldc_w 1159
    //   1023: aconst_null
    //   1024: aload 13
    //   1026: invokestatic 473	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1029: aload_0
    //   1030: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1033: aload_0
    //   1034: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1037: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1040: aload_0
    //   1041: getfield 122	agkl:bHN	Ljava/lang/String;
    //   1044: aload_0
    //   1045: getfield 108	agkl:startTime	J
    //   1048: aload_0
    //   1049: getfield 145	agkl:bHO	Ljava/lang/String;
    //   1052: aload_0
    //   1053: getfield 200	agkl:strUin	Ljava/lang/String;
    //   1056: aload_0
    //   1057: getfield 177	agkl:bHK	Ljava/lang/String;
    //   1060: aload_0
    //   1061: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1064: getfield 449	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1067: ldc2_w 751
    //   1070: ldc 143
    //   1072: aload_0
    //   1073: getfield 137	agkl:YF	J
    //   1076: aload_0
    //   1077: getfield 88	agkl:YD	J
    //   1080: aload_0
    //   1081: getfield 96	agkl:nFileSize	J
    //   1084: aload_0
    //   1085: getfield 145	agkl:bHO	Ljava/lang/String;
    //   1088: ldc 143
    //   1090: aload_0
    //   1091: getfield 415	agkl:cXu	I
    //   1094: ldc_w 1159
    //   1097: aconst_null
    //   1098: aload 13
    //   1100: invokestatic 473	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1103: aload_0
    //   1104: aconst_null
    //   1105: aconst_null
    //   1106: invokevirtual 757	agkl:b	(Laqog;Laqog;)V
    //   1109: aload 12
    //   1111: monitorexit
    //   1112: return
    //   1113: astore 9
    //   1115: ldc_w 1161
    //   1118: iconst_1
    //   1119: new 260	java/lang/StringBuilder
    //   1122: dup
    //   1123: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   1126: ldc_w 263
    //   1129: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1132: aload_0
    //   1133: getfield 94	agkl:nSessionId	J
    //   1136: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1139: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1142: ldc_w 1163
    //   1145: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1148: aload 9
    //   1150: invokevirtual 1164	java/io/IOException:toString	()Ljava/lang/String;
    //   1153: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1156: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1159: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1162: aload 9
    //   1164: invokevirtual 1165	java/io/IOException:printStackTrace	()V
    //   1167: goto -530 -> 637
    //   1170: aload_0
    //   1171: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1174: aload_0
    //   1175: getfield 88	agkl:YD	J
    //   1178: l2f
    //   1179: aload_0
    //   1180: getfield 96	agkl:nFileSize	J
    //   1183: l2f
    //   1184: fdiv
    //   1185: putfield 245	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1188: aload_0
    //   1189: sipush 2002
    //   1192: invokevirtual 292	agkl:setStatus	(I)V
    //   1195: invokestatic 816	java/lang/System:currentTimeMillis	()J
    //   1198: lstore 5
    //   1200: aload_0
    //   1201: getfield 104	agkl:HO	J
    //   1204: lstore 7
    //   1206: lload 5
    //   1208: lload 7
    //   1210: lsub
    //   1211: ldc2_w 1166
    //   1214: lcmp
    //   1215: ifge +7 -> 1222
    //   1218: aload 12
    //   1220: monitorexit
    //   1221: return
    //   1222: aload_0
    //   1223: lload 5
    //   1225: putfield 104	agkl:HO	J
    //   1228: aload_0
    //   1229: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1232: aload_0
    //   1233: getfield 88	agkl:YD	J
    //   1236: l2f
    //   1237: aload_0
    //   1238: getfield 96	agkl:nFileSize	J
    //   1241: l2f
    //   1242: fdiv
    //   1243: putfield 245	com/tencent/mobileqq/filemanager/data/FileManagerEntity:fProgress	F
    //   1246: aload_0
    //   1247: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1250: invokevirtual 678	com/tencent/mobileqq/app/QQAppInterface:a	()Lagkh;
    //   1253: aload_0
    //   1254: getfield 92	agkl:uniseq	J
    //   1257: aload_0
    //   1258: getfield 94	agkl:nSessionId	J
    //   1261: aload_0
    //   1262: getfield 200	agkl:strUin	Ljava/lang/String;
    //   1265: aload_0
    //   1266: getfield 172	agkl:peerType	I
    //   1269: bipush 16
    //   1271: aconst_null
    //   1272: iconst_0
    //   1273: aconst_null
    //   1274: invokevirtual 683	agkh:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1277: goto -874 -> 403
    //   1280: ldc 143
    //   1282: astore 10
    //   1284: ldc 143
    //   1286: astore 11
    //   1288: aload_1
    //   1289: ifnull +9 -> 1298
    //   1292: aload_1
    //   1293: invokevirtual 460	aqog:getRealUrl	()Ljava/lang/String;
    //   1296: astore 10
    //   1298: aload 11
    //   1300: astore_1
    //   1301: aload_2
    //   1302: ifnull +8 -> 1310
    //   1305: aload_2
    //   1306: getfield 463	aqog:cuw	Ljava/lang/String;
    //   1309: astore_1
    //   1310: aload_0
    //   1311: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1314: aload_0
    //   1315: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1318: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1321: aload_0
    //   1322: getfield 120	agkl:aBA	Ljava/lang/String;
    //   1325: aload_0
    //   1326: getfield 108	agkl:startTime	J
    //   1329: aload_0
    //   1330: getfield 145	agkl:bHO	Ljava/lang/String;
    //   1333: aload_0
    //   1334: getfield 200	agkl:strUin	Ljava/lang/String;
    //   1337: aload_0
    //   1338: getfield 177	agkl:bHK	Ljava/lang/String;
    //   1341: aload_0
    //   1342: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1345: getfield 449	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1348: ldc2_w 1168
    //   1351: aconst_null
    //   1352: aload_0
    //   1353: getfield 137	agkl:YF	J
    //   1356: aload_0
    //   1357: getfield 88	agkl:YD	J
    //   1360: aload_0
    //   1361: getfield 96	agkl:nFileSize	J
    //   1364: aload 10
    //   1366: aload_1
    //   1367: aload_0
    //   1368: getfield 415	agkl:cXu	I
    //   1371: aload 9
    //   1373: aconst_null
    //   1374: aload 13
    //   1376: invokestatic 473	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1379: aload_0
    //   1380: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1383: aload_0
    //   1384: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1387: getfield 230	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1390: aload_0
    //   1391: getfield 122	agkl:bHN	Ljava/lang/String;
    //   1394: aload_0
    //   1395: getfield 108	agkl:startTime	J
    //   1398: aload_0
    //   1399: getfield 145	agkl:bHO	Ljava/lang/String;
    //   1402: aload_0
    //   1403: getfield 200	agkl:strUin	Ljava/lang/String;
    //   1406: aload_0
    //   1407: getfield 177	agkl:bHK	Ljava/lang/String;
    //   1410: aload_0
    //   1411: getfield 207	agkl:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1414: getfield 449	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1417: ldc2_w 1168
    //   1420: aconst_null
    //   1421: aload_0
    //   1422: getfield 137	agkl:YF	J
    //   1425: aload_0
    //   1426: getfield 88	agkl:YD	J
    //   1429: aload_0
    //   1430: getfield 96	agkl:nFileSize	J
    //   1433: aload 10
    //   1435: aload_1
    //   1436: aload_0
    //   1437: getfield 415	agkl:cXu	I
    //   1440: aload 9
    //   1442: aconst_null
    //   1443: aload 13
    //   1445: invokestatic 473	ahav:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Landroid/os/Bundle;)V
    //   1448: aload_0
    //   1449: aconst_null
    //   1450: aconst_null
    //   1451: invokevirtual 757	agkl:b	(Laqog;Laqog;)V
    //   1454: goto -1051 -> 403
    //   1457: iconst_0
    //   1458: istore_3
    //   1459: goto -1019 -> 440
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1462	0	this	agkl
    //   0	1462	1	paramaqog1	aqog
    //   0	1462	2	paramaqog2	aqog
    //   278	1181	3	j	int
    //   275	8	4	k	int
    //   493	731	5	l1	long
    //   1204	5	7	l2	long
    //   263	55	9	str	String
    //   649	85	9	localException1	Exception
    //   946	5	9	localObject1	Object
    //   953	1	9	localException2	Exception
    //   1113	328	9	localIOException	java.io.IOException
    //   242	24	10	localException3	Exception
    //   270	1164	10	localObject2	Object
    //   289	1010	11	localObject3	Object
    //   4	1215	12	arrayOfInt	int[]
    //   16	1428	13	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   9	18	174	finally
    //   18	73	174	finally
    //   73	76	174	finally
    //   77	85	174	finally
    //   89	170	174	finally
    //   170	173	174	finally
    //   175	178	174	finally
    //   184	239	174	finally
    //   244	261	174	finally
    //   265	277	174	finally
    //   291	319	174	finally
    //   326	391	174	finally
    //   394	399	174	finally
    //   403	406	174	finally
    //   407	438	174	finally
    //   440	464	174	finally
    //   471	482	174	finally
    //   482	625	174	finally
    //   625	630	174	finally
    //   630	637	174	finally
    //   637	646	174	finally
    //   651	667	174	finally
    //   674	761	174	finally
    //   761	772	174	finally
    //   772	788	174	finally
    //   788	942	174	finally
    //   942	945	174	finally
    //   950	953	174	finally
    //   955	1109	174	finally
    //   1109	1112	174	finally
    //   1115	1167	174	finally
    //   1170	1206	174	finally
    //   1218	1221	174	finally
    //   1222	1277	174	finally
    //   1292	1298	174	finally
    //   1305	1310	174	finally
    //   1310	1454	174	finally
    //   18	73	242	java/lang/Exception
    //   77	85	242	java/lang/Exception
    //   89	170	242	java/lang/Exception
    //   184	239	242	java/lang/Exception
    //   326	391	242	java/lang/Exception
    //   394	399	242	java/lang/Exception
    //   407	438	242	java/lang/Exception
    //   440	464	242	java/lang/Exception
    //   482	625	242	java/lang/Exception
    //   625	630	242	java/lang/Exception
    //   630	637	242	java/lang/Exception
    //   637	646	242	java/lang/Exception
    //   651	667	242	java/lang/Exception
    //   674	761	242	java/lang/Exception
    //   761	772	242	java/lang/Exception
    //   788	942	242	java/lang/Exception
    //   950	953	242	java/lang/Exception
    //   955	1109	242	java/lang/Exception
    //   1115	1167	242	java/lang/Exception
    //   1170	1206	242	java/lang/Exception
    //   1222	1277	242	java/lang/Exception
    //   471	482	649	java/lang/Exception
    //   667	674	946	finally
    //   948	950	946	finally
    //   772	788	953	java/lang/Exception
    //   630	637	1113	java/io/IOException
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    if ((5 == paramInt) && (this.actionType != 0) && (this.YD < this.nFileSize))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.nSessionId) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.YD + " filesize=" + this.nFileSize);
      }
      ahav.a(this.app, this.nSessionId, this.bHN, this.startTime, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, "statusChanged mtransferedSize[" + String.valueOf(this.YD) + "]nFileSize[" + String.valueOf(this.nFileSize) + "]", null);
      dhr();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 102	agkl:i	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1184	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 169	agkl:strFilePath	Ljava/lang/String;
    //   16: invokespecial 1185	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 102	agkl:i	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 151	agkl:YH	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 151	agkl:YH	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1184	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 169	agkl:strFilePath	Ljava/lang/String;
    //   51: invokespecial 1185	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 102	agkl:i	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 151	agkl:YH	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 151	agkl:YH	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 102	agkl:i	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1191	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 151	agkl:YH	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 151	agkl:YH	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 102	agkl:i	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1192	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 102	agkl:i	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1192	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 151	agkl:YH	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 102	agkl:i	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 151	agkl:YH	J
    //   144: lsub
    //   145: invokevirtual 1196	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 1165	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 151	agkl:YH	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1184	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 169	agkl:strFilePath	Ljava/lang/String;
    //   179: invokespecial 1185	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 102	agkl:i	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 151	agkl:YH	J
    //   190: aload_0
    //   191: getfield 102	agkl:i	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1196	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 102	agkl:i	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 1165	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	agkl
    //   0	224	1	paramLong	long
    //   0	224	3	paramInt	int
    //   70	26	4	arrayOfByte	byte[]
    //   98	8	4	localFileNotFoundException1	FileNotFoundException
    //   112	8	4	localFileNotFoundException2	FileNotFoundException
    //   152	3	4	localIOException1	java.io.IOException
    //   202	8	4	localIOException2	java.io.IOException
    //   216	1	4	localException	Exception
    //   219	1	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   7	27	98	java/io/FileNotFoundException
    //   42	62	112	java/io/FileNotFoundException
    //   135	149	152	java/io/IOException
    //   170	199	202	java/io/IOException
    //   72	95	216	java/lang/Exception
  }
  
  public String aX(String paramString1, String paramString2)
  {
    String str = this.jdField_a_of_type_Ahaf.vZ();
    paramString1 = paramString2;
    if (paramString2 == null) {
      paramString1 = vd();
    }
    paramString1 = new File(str + paramString1);
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.nSessionId) + "]getTransferFilePath : " + paramString1.getAbsoluteFile().toString());
    return paramString1.getAbsoluteFile().toString();
  }
  
  public void aj(String paramString, long paramLong)
  {
    if (isStop())
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Upload Step], working stoped!");
      return;
    }
    if (paramLong == 0L) {
      this.YD = 0L;
    }
    int k = this.jdField_b_of_type_Auyc.a(BaseApplication.getContext(), this.nFileSize, paramLong, 1048576);
    int m = auye.getNetWorkType(BaseApplication.getContext());
    int j;
    if (m != 1)
    {
      j = k;
      if (m != 2) {}
    }
    else
    {
      j = k;
      if (k > 16384) {
        j = 16384;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "sendFilePakage transferedSize[" + paramLong + "], packetSize[" + j + "]");
    p(paramString, paramLong, j);
  }
  
  public boolean alA()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step],send LocalFile");
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      setStatus(0);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 1, null, 2, null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "NoNetWork", null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], no network!");
      return false;
    }
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 13, null, 0, null);
    if (this.actionType == 0) {
      this.app.a().o(this.nSessionId, 1002);
    }
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = 0.0F;
    if (this.strFilePath == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.nSessionId + "], strFilePath is null");
      }
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, ahav.ti(), null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, ahav.ti(), null);
      b(null, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], Filepath is null!");
      return false;
    }
    Object localObject;
    if ((this.serverPath != null) && (this.serverPath.length() != 0))
    {
      this.bHO = this.serverPath;
      this.jdField_a_of_type_Aglb = new aglb(this.app, this.serverPath);
      localObject = this.jdField_a_of_type_Aglb.vg();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.serverPath = ((String)localObject);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.serverPath;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^ [CS Step], server Path is not empty, Goto [Upload Step]!");
        this.YE = 131072L;
        this.YF = 0L;
        aj(this.serverPath, 0L);
        return true;
      }
    }
    this.dO = ahav.a(this.strFilePath, this.nFileSize);
    if (this.dO == null)
    {
      setStatus(0);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.nSessionId + "], getMd5 failed");
      }
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, "getfile md5 error", null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = ahav.getFileName(this.strFilePath).getBytes("utf-8");
      byte[] arrayOfByte = this.strFilePath.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> sendLocalFile, SessionId[" + this.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.strUin, arrayOfByte, (byte[])localObject, this.nFileSize, this.dO, this.e, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [CS Step], SessionId[" + this.nSessionId + "], getFilePath failed");
      setStatus(0);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, ahav.ti(), null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, ahav.ti(), null);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 15, null, 5, null);
    }
    return false;
  }
  
  public void b(aqog paramaqog1, aqog paramaqog2)
  {
    String str1 = null;
    if (paramaqog2 != null) {
      str1 = paramaqog2.getErrorString();
    }
    String str2 = str1;
    if (str1 == null) {
      str2 = "null";
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "handleError....., Id[" + String.valueOf(this.nSessionId) + "]transferedSize[" + this.YD + "]isStop[" + String.valueOf(isStop()) + "],  status[" + String.valueOf(this.status) + "], strErrString[" + str2 + "], autoRetry[" + String.valueOf(this.cXr) + "]");
    if ((isStop()) || (this.status == 1003) || (this.status == 2003)) {}
    do
    {
      return;
      if ((paramaqog1 == null) && (paramaqog2 == null))
      {
        clearTask();
        j(null, 0);
        return;
      }
    } while ((!aqiw.isNetSupport(BaseApplication.getContext())) && ((isStop()) || (this.status == 1003) || (this.status == 2003)));
    Bundle localBundle = new Bundle();
    int j;
    int k;
    if (this.actionType != 0)
    {
      localBundle.putInt("param_V6SelectType", this.cXp);
      localBundle.putInt("param_ipAddrType", Eo());
      if (this.cdQ)
      {
        j = 1;
        localBundle.putInt("param_ishttps", j);
      }
    }
    else
    {
      k = paramaqog2.errCode;
      if (!agoy.jL(paramaqog2.errCode)) {
        break label679;
      }
      this.cXu += 1;
      if (this.jdField_a_of_type_Aglb == null) {
        break label1161;
      }
    }
    label1161:
    for (str1 = this.jdField_a_of_type_Aglb.vg();; str1 = null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]get nextIp[" + str1 + "]errCode[" + k + "]");
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, k, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString() + "&goChangeUrl", null, localBundle);
      label540:
      long l;
      if ((str1 == null) || (str1.length() == 0))
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "] need chang Ip ,but can not get next ip errCode[" + k + "]");
        l = this.startTime;
        if (!str2.contains("-29602")) {
          break label729;
        }
        j = -29602;
        paramaqog2.errCode = -29602;
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString(), null, localBundle);
      }
      for (;;)
      {
        this.cXr = 0;
        clearTask();
        j(paramaqog2, j);
        return;
        j = 0;
        break;
        II(str1);
        return;
        label679:
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]don't need chang Ip errCode[" + k + "]");
        break label540;
        label729:
        j = k;
        if (a(paramaqog1, paramaqog2))
        {
          if (!str2.contains("SSLPeerUnverifiedException")) {
            break label862;
          }
          ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, k, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString(), null, localBundle);
          this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
          this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
          j = k;
        }
      }
      label862:
      if (mo(str2))
      {
        k = 9042;
        if (!TextUtils.isEmpty(this.bHK))
        {
          this.serverPath = "";
          j = k;
        }
      }
      for (;;)
      {
        if (mn(str2))
        {
          j = 9042;
          ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString(), null, localBundle);
          this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
          break;
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!!!uuid is null!!!!!!!");
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, ahav.d(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
          j = k;
          if (TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)) {
            continue;
          }
          this.bHK = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid;
          this.serverPath = "";
          j = k;
          continue;
        }
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.nSessionId) + "]handleError-----------retryTime:" + this.cXr);
        }
        if (this.cXr < 8)
        {
          a(paramaqog2, localBundle, j, l);
          return;
        }
        break;
        j = k;
      }
    }
  }
  
  /* Error */
  public void clearTask()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iconst_1
    //   4: putfield 106	agkl:isStop	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1366	agkl:runnable	Ljava/lang/Runnable;
    //   13: ifnull +13 -> 26
    //   16: aload_0
    //   17: getfield 1366	agkl:runnable	Ljava/lang/Runnable;
    //   20: bipush 64
    //   22: invokestatic 1370	com/tencent/mobileqq/app/ThreadManager:removeJobFromThreadPool	(Ljava/lang/Runnable;I)Z
    //   25: pop
    //   26: aload_0
    //   27: getfield 102	agkl:i	Ljava/io/InputStream;
    //   30: invokevirtual 1371	java/io/InputStream:close	()V
    //   33: aload_0
    //   34: aconst_null
    //   35: putfield 102	agkl:i	Ljava/io/InputStream;
    //   38: aload_0
    //   39: getfield 114	agkl:jdField_a_of_type_Agzu	Lagzu;
    //   42: ifnull +10 -> 52
    //   45: aload_0
    //   46: getfield 114	agkl:jdField_a_of_type_Agzu	Lagzu;
    //   49: invokevirtual 1376	agzu:stop	()V
    //   52: aload_0
    //   53: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   56: ifnull +81 -> 137
    //   59: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +61 -> 123
    //   65: ldc_w 258
    //   68: iconst_2
    //   69: new 260	java/lang/StringBuilder
    //   72: dup
    //   73: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   76: ldc_w 263
    //   79: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: aload_0
    //   83: getfield 94	agkl:nSessionId	J
    //   86: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   89: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: ldc_w 1148
    //   95: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: aload_0
    //   99: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   102: invokevirtual 454	aqog:Mk	()I
    //   105: invokestatic 457	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   108: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc_w 282
    //   114: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   117: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   123: aload_0
    //   124: getfield 209	agkl:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   127: invokevirtual 668	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   130: aload_0
    //   131: getfield 675	agkl:jdField_a_of_type_Aqog	Laqog;
    //   134: invokevirtual 1154	com/tencent/mobileqq/utils/httputils/HttpCommunicator:f	(Laqog;)V
    //   137: aload_0
    //   138: getfield 149	agkl:jdField_a_of_type_Agmv	Lagmv;
    //   141: ifnull +55 -> 196
    //   144: invokestatic 256	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +42 -> 189
    //   150: ldc_w 258
    //   153: iconst_2
    //   154: new 260	java/lang/StringBuilder
    //   157: dup
    //   158: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   161: ldc_w 263
    //   164: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: aload_0
    //   168: getfield 94	agkl:nSessionId	J
    //   171: invokestatic 280	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   174: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: ldc_w 1378
    //   180: invokevirtual 267	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: invokevirtual 285	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 288	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: aload_0
    //   190: getfield 149	agkl:jdField_a_of_type_Agmv	Lagmv;
    //   193: invokevirtual 1381	agmv:cancel	()V
    //   196: return
    //   197: astore_1
    //   198: aload_0
    //   199: monitorexit
    //   200: aload_1
    //   201: athrow
    //   202: astore_1
    //   203: goto -165 -> 38
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	206	0	this	agkl
    //   197	4	1	localObject	Object
    //   202	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	197	finally
    //   198	200	197	finally
    //   26	38	202	java/lang/Exception
  }
  
  public void dgu()
  {
    try
    {
      this.isStop = false;
      this.runnable = new FileManagerRSWorker.4(this);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Run RSWorker" + anaz.gQ());
      }
      ahav.a.getExecutor().execute(this.runnable);
      if ((this.actionType == 0) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize > 104857600L)) {
        dhw();
      }
      return;
    }
    finally {}
  }
  
  public void dgv()
  {
    clearTask();
  }
  
  public void dgw()
  {
    clearTask();
    if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 1)) {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.nSessionId) + "] is Successed, return!");
      }
    }
    for (;;)
    {
      return;
      if ((this.actionType == 0) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
        setStatus(1004);
      }
      while (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)
      {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 3;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.YD / (float)this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().b(true, 3, null);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.nSessionId) + "]stop for pause!");
        }
        long l = System.currentTimeMillis();
        String str = "Now[" + String.valueOf(l) + "]startTime[" + String.valueOf(this.startTime) + "]notifyTime[" + String.valueOf(this.HO) + "]C2CTime[" + String.valueOf(this.YG) + "]";
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, str, null);
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9037L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, str, null);
        return;
        if ((1 == this.actionType) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity != null)) {
          setStatus(2004);
        } else if ((5 == this.actionType) && (this.jdField_a_of_type_Agmv != null)) {
          this.jdField_a_of_type_Agmv.cancel();
        } else if ((6 == this.actionType) && (this.jdField_a_of_type_Agmv != null)) {
          this.jdField_a_of_type_Agmv.cancel();
        } else if ((50 == this.actionType) && (this.jdField_a_of_type_Agmv != null)) {
          this.jdField_a_of_type_Agmv.cancel();
        }
      }
    }
  }
  
  public void dgx()
  {
    try
    {
      this.i.close();
      this.i = null;
      label12:
      setStatus(0);
      return;
    }
    catch (Exception localException)
    {
      break label12;
    }
  }
  
  public void dhp()
  {
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.nSessionId + "],call receive");
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      setStatus(0);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 1, null, 2, null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "NoNetWork", null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "NoNetWork", null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.nSessionId + "],no network!");
      return;
    }
    if (ahbj.fileExistsAndNotEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [CS Send] Id[" + this.nSessionId + "],file exists!!");
      dhr();
      return;
    }
    this.cdQ = false;
    this.aEL = null;
    if ((this.bHK == null) || (this.bHK.length() == 0))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.nSessionId + "],uuid is null! : " + ahav.d(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
      dhq();
      return;
    }
    if (this.peerType == 3000)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.nSessionId + "],Send getDiscFileInfo CS！");
      try
      {
        this.app.a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, Long.parseLong(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin), this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.e);
        return;
      }
      catch (Exception localException)
      {
        j(null, 0);
        return;
      }
    }
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [CS Send] Id[" + this.nSessionId + "],Send getDownloadInfo CS！");
    boolean bool = false;
    if (agmx.aF(this.app)) {
      bool = true;
    }
    this.app.a().a(this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileIdCrc, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, bool, this.e);
  }
  
  public void dhq()
  {
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>!!!! [Http Downlaod] Id[" + this.nSessionId + "],is oldMsg?");
    if (isStop())
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v>! [Http Downlaod] Id[" + this.nSessionId + "],no network");
      return;
    }
    if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath)) {
      this.serverPath = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath;
    }
    if (TextUtils.isEmpty(this.serverPath))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.nSessionId) + "] get old offlinefile info is error! serverPath is empty");
      if (ahbj.fileExistsAndNotEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath()))
      {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 11, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v> [Http Downlaod] Id[" + this.nSessionId + "], filee Exists");
        return;
      }
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      setStatus(2005);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 6, null);
      int j = 9020;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) {
        j = 9080;
      }
      for (;;)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.nSessionId + "], errCode[" + j + "]");
        return;
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -2) {
          j = 9081;
        }
      }
    }
    this.bHJ = (this.strFilePath + ".tmp");
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.nSessionId + "], no network");
      setStatus(2005);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 1, null, 2, null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "NoNetWork", null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "NoNetWork", null);
      return;
    }
    this.YD = ahav.getFileSizes(this.bHJ);
    if (this.YD == this.nFileSize)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod] Id[" + this.nSessionId + "], id downloaded");
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
      setStatus(2003);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 11, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = ahav.getFileName(this.strFilePath);
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
      {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = ahav.kY(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        this.strFilePath = aX(this.strUin, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
      }
      if (aqhq.fileExists(this.strFilePath)) {
        this.strFilePath = ahav.kW(this.strFilePath);
      }
      ahav.b(new VFSFile(this.bHJ), new VFSFile(this.strFilePath));
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = ahav.getFileName(this.strFilePath);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, 0L, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.nFileSize, this.cXr, null);
      return;
    }
    if (this.nFileSize > this.YD)
    {
      long l2 = this.nFileSize - this.YD;
      if (aqfo.isExistSDCard()) {}
      for (long l1 = aqfo.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = aqfo.getSystemAvailableSize() * 1024L)
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= v! [Http Downlaod]Id[" + String.valueOf(this.nSessionId) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
        setStatus(2005);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 12, null);
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, "sdcard full", null);
        ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "sdcard full", null);
        return;
      }
    }
    if (this.jdField_c_of_type_JavaIoOutputStream == null) {}
    try
    {
      this.jdField_c_of_type_JavaIoOutputStream = new FileOutputStream(this.bHJ, true);
      label1294:
      if (this.actionType == 1) {
        this.app.a().o(this.nSessionId, 2002);
      }
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject1 = localObject2;
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId != null) {
          localObject1 = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
        }
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile) && (this.serverPath.toLowerCase().startsWith("https")))
      {
        this.cdQ = true;
        this.aEL = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.httpsDomain;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= v>ReceiveOfflineForOldMsg Id[" + this.nSessionId + "], mUseHttps:" + this.cdQ + " mHttpsDomain:" + this.aEL);
      ar(this.YD, (String)localObject1);
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      break label1294;
    }
  }
  
  public void dhs()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 11, null);
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      this.app.a().dhl();
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.nFileSize - this.YD;
    if (aqfo.isExistSDCard()) {}
    for (long l1 = aqfo.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = aqfo.getSystemAvailableSize() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.app.a().dhl();
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 12, null);
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9040L, "", this.YD, this.YD, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.nFileSize = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    this.jdField_a_of_type_Agmv = this.app.a().a().a(localFileManagerEntity, null, new agkq(this));
    if (this.jdField_a_of_type_Agmv == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + this.nSessionId + "]fileid[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize + "] modifytime[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime + "]");
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_Agmv.setFileId(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId);
  }
  
  public void dhu()
  {
    if (!aqiw.isNetSupport(BaseApplication.getContext()))
    {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 38, null, 11, null);
      this.app.a().dhl();
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "net work error");
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
    }
    do
    {
      return;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
      this.nFileSize = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
      this.jdField_a_of_type_Agmv = this.app.a().a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null, new agks(this));
    } while (this.jdField_a_of_type_Agmv != null);
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + this.nSessionId + "] filePath[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 38, null, 11, null);
  }
  
  void dhv()
  {
    this.YI = System.currentTimeMillis();
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = anaz.gQ();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "=_= ^> [Http upload]Id[" + this.nSessionId + "] update successTime[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime + "]");
    setStatus(1003);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    QLog.i("FileManagerRSWorker<FileAssistant>", 2, "=_= ^> [Http upload] SendFileSuccess, SessionId[" + this.nSessionId + "], FileSize[" + this.nFileSize + "], Uuid[" + this.bHK + "]");
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 14, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
    if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "=_= ^! [Http upload] uuid is null Entity[" + ahav.d(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.YG = System.currentTimeMillis();
    this.endTime = System.currentTimeMillis();
    this.app.a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.selfUin, this.strUin, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.e);
  }
  
  public int getActionType()
  {
    return this.actionType;
  }
  
  public String getFileId()
  {
    return this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
  }
  
  public long getFileSize()
  {
    return this.nFileSize;
  }
  
  public int getProgress()
  {
    if (this.nFileSize <= 0L) {
      return 0;
    }
    return (int)(this.YD * 100L / this.nFileSize);
  }
  
  public int getStatus()
  {
    return this.status;
  }
  
  public boolean isStop()
  {
    try
    {
      boolean bool = this.isStop;
      return bool;
    }
    finally {}
  }
  
  public void j(Object paramObject, int paramInt)
  {
    aqog localaqog = (aqog)paramObject;
    int j;
    switch (this.actionType)
    {
    default: 
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "why actionType is out?!");
    case 0: 
      do
      {
        return;
        this.app.a().dhl();
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        paramObject = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status == 16) {
          break;
        }
        j = 0;
        paramObject.status = j;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.YD / (float)this.nFileSize);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.uniseq;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.bHK;
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 15, null, 5, null);
      } while (localaqog == null);
      paramObject = localaqog.getErrorString();
      if ((paramInt == 0) && (paramObject == null))
      {
        paramObject = "[Http_RespValue_Null]" + ahav.ti();
        paramInt = 9001;
      }
      break;
    }
    for (;;)
    {
      Object localObject = paramObject;
      if (paramObject == null) {
        localObject = "errMsgString_NUll_retCode[" + paramInt + "]";
      }
      if (((String)localObject).indexOf("-6101") > 0) {
        paramInt = 9042;
      }
      if (((String)localObject).contains("HTTP_PROXY_AUTH")) {
        paramInt = 9004;
      }
      ahav.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localaqog.Mk()), this.YF, this.YD, this.nFileSize, localaqog.getRealUrl(), localaqog.cuw, this.cXu, (String)localObject, null);
      this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
      j = 16;
      break;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.app.a().dhl();
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      paramObject = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (j = 0;; j = 16)
      {
        paramObject.status = j;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.YD / (float)this.nFileSize);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.uniseq;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.bHK;
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 6, null);
        break;
      }
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.YD / (float)this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
      paramObject = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (j = 0;; j = 16)
      {
        paramObject.status = j;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.bHK;
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().dhl();
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 6, null);
        break;
      }
      paramObject = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (j = 0;; j = 16)
      {
        paramObject.status = j;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.app.a().dhl();
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 11, null);
        break;
      }
      paramObject = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status != 16) {}
      for (j = 0;; j = 16)
      {
        paramObject.status = j;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
        this.app.a().dhl();
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 38, null, 11, null);
        break;
      }
    }
  }
  
  public void setStatus(int paramInt)
  {
    paramInt = ahav.hM(paramInt);
    if ((this.status == paramInt) && (paramInt == 2)) {}
    do
    {
      return;
      this.status = paramInt;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fProgress = ((float)this.YD / (float)this.nFileSize);
    } while (paramInt == 2);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin = this.strUin;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerType = this.peerType;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.uniseq;
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    if (this.bHK != null) {}
    for (String str = this.bHK;; str = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid)
    {
      localFileManagerEntity.Uuid = str;
      this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      return;
    }
  }
  
  public String vc()
  {
    boolean bool2 = true;
    Object localObject = this.jdField_a_of_type_Ahaf.vZ();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.nSessionId) + "]getTransferFilePath dir: " + (String)localObject);
    localObject = new VFSFile((String)localObject);
    if (!((VFSFile)localObject).exists()) {}
    for (boolean bool1 = ((VFSFile)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.nSessionId + "]getRecvDir[" + bool1 + "]");
      }
      this.bHI = this.jdField_a_of_type_Ahaf.wa();
      localObject = new VFSFile(this.bHI);
      bool1 = bool2;
      if (!((VFSFile)localObject).exists()) {
        bool1 = ((VFSFile)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.nSessionId + "]getTmpDir[" + bool1 + "]");
      }
      return this.bHI;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agkl
 * JD-Core Version:    0.7.0.1
 */