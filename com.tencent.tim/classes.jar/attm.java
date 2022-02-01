import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TransFileInfo;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tim.filemanager.core.FileManagerRSWorker.4;
import com.weiyun.sdk.IWyTaskManager.Task;
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

public class attm
  implements aqoi
{
  long HO;
  public long YD;
  long YE;
  public long YF;
  long YG;
  long YH;
  long YI;
  private long YM;
  aqog jdField_a_of_type_Aqog;
  private attx jdField_a_of_type_Attx;
  audg jdField_a_of_type_Audg;
  audj jdField_a_of_type_Audj;
  audn jdField_a_of_type_Audn;
  IWyTaskManager.Task jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task;
  public String aBA;
  public int actionType;
  public QQAppInterface app;
  auyc b;
  String bHI;
  public String bHJ;
  public String bHK;
  public String bHM;
  public String bHN;
  private String bHO;
  public FileManagerEntity c;
  public OutputStream c;
  int cXq;
  private int cXr;
  private int cXs;
  private int cXt;
  private int cXu;
  int cXv;
  public byte[] dO;
  public byte[] dP;
  public byte[] dQ;
  private agie e;
  long endTime;
  InputStream i;
  boolean isStop;
  int[] lo;
  public long nFileSize;
  public long nSessionId;
  public int peerType;
  Runnable runnable;
  String selfUin;
  public String serverPath;
  public long startTime;
  private int status;
  public String strFilePath;
  public String strUin;
  public long uniseq;
  
  private void a(long paramLong, attm.a parama)
  {
    this.app.a().Jh(false);
    parama = new ArrayList();
    parama.add(this.bHJ);
    this.jdField_a_of_type_Audn.a(paramLong, parama, SplashActivity.sTopActivity, new atto(this));
  }
  
  private void a(agib.b paramb)
  {
    if (paramb.cXe == 2)
    {
      if (paramb.ag == 0) {
        paramb.ag = 80;
      }
      this.serverPath = (paramb.strIP + ":" + paramb.ag);
      return;
    }
    this.serverPath = this.jdField_a_of_type_Attx.vg();
  }
  
  private void a(String paramString, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, long paramLong, byte[] paramArrayOfByte3, agie paramagie, FileManagerEntity paramFileManagerEntity)
  {
    paramString = new audi();
    paramString.bJz = this.strUin;
    paramString.ej = paramArrayOfByte2;
    paramString.ei = paramArrayOfByte1;
    paramString.fileSize = this.nFileSize;
    paramString.md5 = this.dO;
    if (paramLong <= 104857600L)
    {
      paramString.cYU = 1700;
      this.dP = audx.x(new String(paramArrayOfByte1));
      if (this.dP == null)
      {
        j(null, 0);
        return;
      }
      paramString.sha1 = this.dP;
    }
    for (;;)
    {
      this.app.a().a(paramString, this.e, paramFileManagerEntity);
      return;
      paramString.cYU = 1600;
      this.dQ = audx.B(new String(paramArrayOfByte1));
      if (this.dQ == null)
      {
        j(null, 0);
        return;
      }
      paramString.el = this.dQ;
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
    if (this.isStop) {}
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
      if (paramString != null) {
        localaqog.setRequestProperty("Cookie", paramString);
      }
      localaqog.setPriority(1);
      localaqog.SP(true);
      localaqog.fileType = 0;
      localaqog.busiType = this.peerType;
      localaqog.msgId = String.valueOf(this.nSessionId);
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.nSessionId) + "]recv http data RANGE[" + String.valueOf(str2) + "], peerType[" + String.valueOf(this.peerType) + "]");
      localaqog.setRequestProperty("Accept-Encoding", "identity");
      this.app.getHttpCommunicatort().a(localaqog);
      this.jdField_a_of_type_Aqog = localaqog;
    } while (paramLong != 0L);
    setStatus(2001);
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 10, null, 6, null);
  }
  
  private void b(String paramString, long paramLong, int paramInt, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_Audj = new audj();
    this.jdField_a_of_type_Audj.a(HexUtil.bytes2HexStr(paramArrayOfByte), HexUtil.bytes2HexStr(this.dP), HexUtil.bytes2HexStr(this.dQ), this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.e);
    this.jdField_a_of_type_Audg = new audg(this.app, paramString, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.jdField_a_of_type_Audj);
    this.jdField_a_of_type_Audg.dgu();
  }
  
  private void dhr()
  {
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = audx.getFileName(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = anaz.gQ();
    int j = this.strFilePath.length() - this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.length();
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250 - j)
    {
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = audx.al(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, 250 - j);
      this.strFilePath = aX(this.strUin, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    }
    if (aqhq.fileExists(this.strFilePath)) {
      this.strFilePath = audx.kW(this.strFilePath);
    }
    Object localObject;
    try
    {
      if (!aqhq.renameFile(new File(this.bHJ), new File(this.strFilePath)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]rename file error, strTmpPath[" + this.bHJ + "],strFilePath[" + this.strFilePath + "]");
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, "rename error", null);
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "rename error", null);
        b(null, null);
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      localObject = HexUtil.bytes2HexStr(audx.t(this.strFilePath));
      if (localObject != null) {
        break label1003;
      }
    }
    QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
    audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "mathMd5 is null", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "rename error", null);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setFilePath(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = audx.getFileName(this.strFilePath);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType = audx.fM(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    setStatus(2003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "Id[" + String.valueOf(this.nSessionId) + "]recive success, set TrafficData,size[" + String.valueOf(this.YD) + "]");
    }
    atgi.a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.strFilePath, true);
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 11, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
    this.endTime = System.currentTimeMillis();
    audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.endTime - this.startTime, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, this.YF, this.YD, this.nFileSize, this.cXu, null);
    if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 0)
    {
      auef.O(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      auef.M(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    }
    for (;;)
    {
      audx.K(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("FILE_TMP_SERVER_PATH", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath);
        ((Bundle)localObject).putLong("FILE_TMP_RELATED_ID", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nRelatedSessionId);
        ((Bundle)localObject).putString("FILE_TMP_DIR_PATH", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipInnerPath);
        ((Bundle)localObject).putBoolean("FILE_TMP_IS_ZIPINNER_FILE", true);
        ((Bundle)localObject).putString("FILE_TMP_ZIP_FILEID", this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.zipFileId);
        this.app.a().a(null, -1, this.strFilePath, this.nFileSize, 190, null, (Bundle)localObject);
      }
      localObject = new audw.b();
      ((audw.b)localObject).bJE = "rece_file_suc";
      ((audw.b)localObject).cYX = 1;
      audw.a(this.app.getCurrentAccountUin(), (audw.b)localObject);
      return;
      label1003:
      if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 != null) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5.length() > 0) && (!((String)localObject).equalsIgnoreCase(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5)))
      {
        QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "] mathMd5 is null,FileMd5[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5 + "]");
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9082L, "md5 is not equal", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "rename error", null);
        break;
      }
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId + "]equalsIgnoreCase md5 success,");
      break;
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nFileType == 2) {
        audx.J(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
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
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
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
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9040L, "", this.YD, this.YD, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    FileManagerEntity localFileManagerEntity = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.app.a().a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime, null);
    this.nFileSize = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + String.valueOf(this.nSessionId) + "]fileid[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + String.valueOf(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + "] modifytime[" + String.valueOf(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) + "]");
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new attr(this, localFileManagerEntity));
    this.app.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  private String g(String paramString1, String paramString2, long paramLong)
  {
    return "/?ver=2&ukey=" + paramString1 + "&filekey=" + paramString2 + "&filesize=" + paramLong;
  }
  
  private void p(String paramString, long paramLong, int paramInt)
  {
    this.YF += paramInt;
    Object localObject = a(paramLong, paramInt);
    if (localObject == null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]sendFilePakage transferData null");
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "get Stream null", null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9003L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "get Stream null", null);
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
    audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, String.valueOf(this.jdField_a_of_type_Aqog.Mk()), this.YF, this.YD, this.nFileSize, this.jdField_a_of_type_Aqog.getRealUrl(), this.jdField_a_of_type_Aqog.cuw, this.cXu, this.jdField_a_of_type_Aqog.getErrorString() + "&UrlOver&handleRedirect", null);
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
    this.YD = audx.getFileSizes(this.bHJ);
    ar(this.YD, this.bHM);
  }
  
  /* Error */
  public void a(aqog paramaqog1, aqog paramaqog2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 833	attm:lo	[I
    //   4: astore 12
    //   6: aload 12
    //   8: monitorenter
    //   9: aload_0
    //   10: invokevirtual 835	attm:isStop	()Z
    //   13: ifeq +55 -> 68
    //   16: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   19: ifeq +45 -> 64
    //   22: ldc_w 758
    //   25: iconst_2
    //   26: new 149	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 837
    //   36: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   43: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   46: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   49: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: ldc_w 839
    //   55: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   64: aload 12
    //   66: monitorexit
    //   67: return
    //   68: aload_1
    //   69: aload_0
    //   70: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   73: if_acmpeq +313 -> 386
    //   76: aload_1
    //   77: ifnull +94 -> 171
    //   80: aload_0
    //   81: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   84: ifnull +87 -> 171
    //   87: ldc_w 328
    //   90: iconst_1
    //   91: new 149	java/lang/StringBuilder
    //   94: dup
    //   95: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   98: ldc_w 841
    //   101: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: aload_0
    //   105: getfield 319	attm:nSessionId	J
    //   108: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   111: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: ldc_w 843
    //   117: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: aload_1
    //   121: invokevirtual 804	aqog:Mk	()I
    //   124: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   127: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: ldc_w 845
    //   133: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   136: aload_0
    //   137: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   140: invokevirtual 804	aqog:Mk	()I
    //   143: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   146: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   149: ldc_w 342
    //   152: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload 12
    //   163: monitorexit
    //   164: return
    //   165: astore_1
    //   166: aload 12
    //   168: monitorexit
    //   169: aload_1
    //   170: athrow
    //   171: aload_1
    //   172: ifnull +146 -> 318
    //   175: ldc_w 328
    //   178: iconst_1
    //   179: new 149	java/lang/StringBuilder
    //   182: dup
    //   183: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   186: ldc_w 841
    //   189: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: aload_0
    //   193: getfield 319	attm:nSessionId	J
    //   196: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   199: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: ldc_w 843
    //   205: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: aload_1
    //   209: invokevirtual 804	aqog:Mk	()I
    //   212: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   215: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: ldc_w 342
    //   221: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   224: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   230: goto -69 -> 161
    //   233: astore 10
    //   235: aload 10
    //   237: invokevirtual 846	java/lang/Exception:printStackTrace	()V
    //   240: ldc_w 328
    //   243: iconst_1
    //   244: aload 10
    //   246: invokevirtual 847	java/lang/Exception:toString	()Ljava/lang/String;
    //   249: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: ldc_w 485
    //   255: astore 9
    //   257: aload 10
    //   259: invokevirtual 851	java/lang/Exception:getStackTrace	()[Ljava/lang/StackTraceElement;
    //   262: astore 10
    //   264: aload 10
    //   266: arraylength
    //   267: istore 4
    //   269: iconst_0
    //   270: istore_3
    //   271: iload_3
    //   272: iload 4
    //   274: if_icmpge +1980 -> 2254
    //   277: aload 10
    //   279: iload_3
    //   280: aaload
    //   281: astore 11
    //   283: new 149	java/lang/StringBuilder
    //   286: dup
    //   287: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   290: aload 9
    //   292: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   295: aload 11
    //   297: invokevirtual 854	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   300: ldc_w 856
    //   303: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   309: astore 9
    //   311: iload_3
    //   312: iconst_1
    //   313: iadd
    //   314: istore_3
    //   315: goto -44 -> 271
    //   318: aload_0
    //   319: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   322: ifnull -161 -> 161
    //   325: ldc_w 328
    //   328: iconst_1
    //   329: new 149	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   336: ldc_w 841
    //   339: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: aload_0
    //   343: getfield 319	attm:nSessionId	J
    //   346: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   349: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: ldc_w 858
    //   355: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload_0
    //   359: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   362: invokevirtual 804	aqog:Mk	()I
    //   365: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   368: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: ldc_w 342
    //   374: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   380: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   383: goto -222 -> 161
    //   386: aload_0
    //   387: getfield 818	attm:actionType	I
    //   390: ifne +1079 -> 1469
    //   393: aload_2
    //   394: invokevirtual 861	aqog:getResponseCode	()I
    //   397: sipush 200
    //   400: if_icmpne +870 -> 1270
    //   403: aload_0
    //   404: getfield 863	attm:b	Lauyc;
    //   407: invokevirtual 868	auyc:exX	()V
    //   410: aload_2
    //   411: ldc_w 870
    //   414: invokevirtual 873	aqog:pK	(Ljava/lang/String;)Ljava/lang/String;
    //   417: ifnull +2018 -> 2435
    //   420: aload_2
    //   421: ldc_w 870
    //   424: invokevirtual 873	aqog:pK	(Ljava/lang/String;)Ljava/lang/String;
    //   427: invokestatic 876	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   430: lstore 5
    //   432: lload 5
    //   434: lconst_0
    //   435: lcmp
    //   436: ifeq +112 -> 548
    //   439: aload_0
    //   440: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   443: aload_0
    //   444: getfield 319	attm:nSessionId	J
    //   447: aload_0
    //   448: getfield 496	attm:bHN	Ljava/lang/String;
    //   451: aload_0
    //   452: getfield 476	attm:startTime	J
    //   455: aload_0
    //   456: getfield 168	attm:serverPath	Ljava/lang/String;
    //   459: aload_0
    //   460: getfield 190	attm:strUin	Ljava/lang/String;
    //   463: aload_0
    //   464: getfield 478	attm:bHK	Ljava/lang/String;
    //   467: aload_0
    //   468: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   471: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   474: ldc2_w 877
    //   477: ldc_w 485
    //   480: aload_0
    //   481: getfield 487	attm:YF	J
    //   484: aload_0
    //   485: getfield 489	attm:YD	J
    //   488: aload_0
    //   489: getfield 201	attm:nFileSize	J
    //   492: aload_2
    //   493: invokevirtual 807	aqog:getRealUrl	()Ljava/lang/String;
    //   496: aload_2
    //   497: getfield 810	aqog:cuw	Ljava/lang/String;
    //   500: aload_0
    //   501: getfield 377	attm:cXu	I
    //   504: new 149	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   511: ldc_w 880
    //   514: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: lload 5
    //   519: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   522: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   525: ldc_w 342
    //   528: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: aconst_null
    //   535: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   538: aload_0
    //   539: aload_1
    //   540: aload_2
    //   541: invokevirtual 499	attm:b	(Laqog;Laqog;)V
    //   544: aload 12
    //   546: monitorexit
    //   547: return
    //   548: aload_2
    //   549: ldc_w 300
    //   552: invokevirtual 873	aqog:pK	(Ljava/lang/String;)Ljava/lang/String;
    //   555: astore 9
    //   557: aload 9
    //   559: ifnull +1870 -> 2429
    //   562: aload 9
    //   564: invokestatic 876	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   567: lstore 5
    //   569: lload 5
    //   571: aload_0
    //   572: getfield 489	attm:YD	J
    //   575: lcmp
    //   576: ifgt +371 -> 947
    //   579: new 149	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   586: ldc_w 882
    //   589: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: lload 5
    //   594: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   597: ldc_w 884
    //   600: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   603: aload_0
    //   604: getfield 489	attm:YD	J
    //   607: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   610: ldc_w 886
    //   613: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   616: aload_0
    //   617: getfield 888	attm:YM	J
    //   620: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   623: ldc_w 890
    //   626: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: aload_0
    //   630: getfield 892	attm:cXq	I
    //   633: invokevirtual 162	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   636: ldc_w 342
    //   639: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   645: astore 9
    //   647: lload 5
    //   649: aload_0
    //   650: getfield 888	attm:YM	J
    //   653: lcmp
    //   654: ifgt +180 -> 834
    //   657: aload_0
    //   658: getfield 892	attm:cXq	I
    //   661: iconst_1
    //   662: iadd
    //   663: istore_3
    //   664: aload_0
    //   665: iload_3
    //   666: putfield 892	attm:cXq	I
    //   669: iload_3
    //   670: iconst_3
    //   671: if_icmple +163 -> 834
    //   674: aload_0
    //   675: sipush 1005
    //   678: invokevirtual 365	attm:setStatus	(I)V
    //   681: aload_0
    //   682: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   685: invokevirtual 368	com/tencent/mobileqq/app/QQAppInterface:a	()Latti;
    //   688: aload_0
    //   689: getfield 370	attm:uniseq	J
    //   692: aload_0
    //   693: getfield 319	attm:nSessionId	J
    //   696: aload_0
    //   697: getfield 190	attm:strUin	Ljava/lang/String;
    //   700: aload_0
    //   701: getfield 314	attm:peerType	I
    //   704: bipush 15
    //   706: aconst_null
    //   707: iconst_5
    //   708: aconst_null
    //   709: invokevirtual 375	atti:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   712: aload_0
    //   713: invokevirtual 895	attm:clearTask	()V
    //   716: aload_0
    //   717: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   720: aload_0
    //   721: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   724: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   727: aload_0
    //   728: getfield 474	attm:aBA	Ljava/lang/String;
    //   731: aload_0
    //   732: getfield 476	attm:startTime	J
    //   735: aload_0
    //   736: getfield 85	attm:bHO	Ljava/lang/String;
    //   739: aload_0
    //   740: getfield 190	attm:strUin	Ljava/lang/String;
    //   743: aload_0
    //   744: getfield 478	attm:bHK	Ljava/lang/String;
    //   747: aload_0
    //   748: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   751: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   754: ldc2_w 896
    //   757: ldc_w 485
    //   760: aload_0
    //   761: getfield 487	attm:YF	J
    //   764: aload_0
    //   765: getfield 489	attm:YD	J
    //   768: aload_0
    //   769: getfield 201	attm:nFileSize	J
    //   772: aload_0
    //   773: getfield 85	attm:bHO	Ljava/lang/String;
    //   776: ldc_w 485
    //   779: aload_0
    //   780: getfield 75	attm:cXr	I
    //   783: aload 9
    //   785: aconst_null
    //   786: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   789: ldc_w 328
    //   792: iconst_1
    //   793: new 149	java/lang/StringBuilder
    //   796: dup
    //   797: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   800: ldc_w 899
    //   803: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   806: aload_0
    //   807: getfield 319	attm:nSessionId	J
    //   810: invokevirtual 270	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   813: ldc_w 342
    //   816: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload 9
    //   821: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   824: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   827: invokestatic 801	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   830: aload 12
    //   832: monitorexit
    //   833: return
    //   834: aload_0
    //   835: lload 5
    //   837: putfield 888	attm:YM	J
    //   840: aload_0
    //   841: lload 5
    //   843: putfield 489	attm:YD	J
    //   846: new 901	android/os/Handler
    //   849: dup
    //   850: invokespecial 902	android/os/Handler:<init>	()V
    //   853: new 904	com/tencent/tim/filemanager/core/FileManagerRSWorker$2
    //   856: dup
    //   857: aload_0
    //   858: lload 5
    //   860: invokespecial 907	com/tencent/tim/filemanager/core/FileManagerRSWorker$2:<init>	(Lattm;J)V
    //   863: ldc2_w 908
    //   866: invokevirtual 913	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   869: pop
    //   870: aload_0
    //   871: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   874: aload_0
    //   875: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   878: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   881: aload_0
    //   882: getfield 496	attm:bHN	Ljava/lang/String;
    //   885: aload_0
    //   886: getfield 476	attm:startTime	J
    //   889: aload_0
    //   890: getfield 85	attm:bHO	Ljava/lang/String;
    //   893: aload_0
    //   894: getfield 190	attm:strUin	Ljava/lang/String;
    //   897: aload_0
    //   898: getfield 478	attm:bHK	Ljava/lang/String;
    //   901: aload_0
    //   902: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   905: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   908: ldc2_w 896
    //   911: ldc_w 485
    //   914: aload_0
    //   915: getfield 487	attm:YF	J
    //   918: aload_0
    //   919: getfield 489	attm:YD	J
    //   922: aload_0
    //   923: getfield 201	attm:nFileSize	J
    //   926: aload_0
    //   927: getfield 85	attm:bHO	Ljava/lang/String;
    //   930: aload_2
    //   931: getfield 810	aqog:cuw	Ljava/lang/String;
    //   934: aload_0
    //   935: getfield 377	attm:cXu	I
    //   938: aload 9
    //   940: aconst_null
    //   941: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   944: goto -155 -> 789
    //   947: iconst_0
    //   948: istore 4
    //   950: iload 4
    //   952: istore_3
    //   953: aload_0
    //   954: getfield 489	attm:YD	J
    //   957: lconst_0
    //   958: lcmp
    //   959: ifne +67 -> 1026
    //   962: iload 4
    //   964: istore_3
    //   965: lload 5
    //   967: aload_0
    //   968: getfield 201	attm:nFileSize	J
    //   971: lcmp
    //   972: ifne +54 -> 1026
    //   975: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   978: ifeq +1463 -> 2441
    //   981: ldc_w 758
    //   984: iconst_2
    //   985: new 149	java/lang/StringBuilder
    //   988: dup
    //   989: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   992: ldc_w 837
    //   995: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   998: aload_0
    //   999: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1002: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1005: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1008: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1011: ldc_w 915
    //   1014: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1017: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1020: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1023: goto +1418 -> 2441
    //   1026: aload_0
    //   1027: lload 5
    //   1029: putfield 489	attm:YD	J
    //   1032: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1035: ifeq +74 -> 1109
    //   1038: ldc_w 328
    //   1041: iconst_2
    //   1042: new 149	java/lang/StringBuilder
    //   1045: dup
    //   1046: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1049: ldc_w 330
    //   1052: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1055: aload_0
    //   1056: getfield 319	attm:nSessionId	J
    //   1059: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1062: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1065: ldc_w 756
    //   1068: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1071: aload_0
    //   1072: getfield 489	attm:YD	J
    //   1075: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1078: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: ldc_w 917
    //   1084: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1087: aload_0
    //   1088: getfield 201	attm:nFileSize	J
    //   1091: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1094: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1097: ldc_w 919
    //   1100: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1103: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1106: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1109: lload 5
    //   1111: aload_0
    //   1112: getfield 201	attm:nFileSize	J
    //   1115: lcmp
    //   1116: ifge +158 -> 1274
    //   1119: aload_0
    //   1120: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1123: aload_0
    //   1124: getfield 489	attm:YD	J
    //   1127: l2f
    //   1128: aload_0
    //   1129: getfield 201	attm:nFileSize	J
    //   1132: l2f
    //   1133: fdiv
    //   1134: invokevirtual 923	com/tencent/mobileqq/filemanager/data/FileManagerEntity:setfProgress	(F)V
    //   1137: aload_0
    //   1138: sipush 1002
    //   1141: invokevirtual 365	attm:setStatus	(I)V
    //   1144: invokestatic 554	java/lang/System:currentTimeMillis	()J
    //   1147: lstore 5
    //   1149: lload 5
    //   1151: aload_0
    //   1152: getfield 925	attm:HO	J
    //   1155: lsub
    //   1156: ldc2_w 926
    //   1159: lcmp
    //   1160: iflt +93 -> 1253
    //   1163: aload_0
    //   1164: lload 5
    //   1166: putfield 925	attm:HO	J
    //   1169: aload_0
    //   1170: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1173: iconst_3
    //   1174: invokevirtual 525	com/tencent/mobileqq/filemanager/data/FileManagerEntity:setCloudType	(I)V
    //   1177: aload_0
    //   1178: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1181: invokevirtual 368	com/tencent/mobileqq/app/QQAppInterface:a	()Latti;
    //   1184: aload_0
    //   1185: getfield 370	attm:uniseq	J
    //   1188: aload_0
    //   1189: getfield 319	attm:nSessionId	J
    //   1192: aload_0
    //   1193: getfield 190	attm:strUin	Ljava/lang/String;
    //   1196: aload_0
    //   1197: getfield 314	attm:peerType	I
    //   1200: bipush 16
    //   1202: aconst_null
    //   1203: iconst_0
    //   1204: aconst_null
    //   1205: invokevirtual 375	atti:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   1208: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1211: ifeq +42 -> 1253
    //   1214: ldc_w 328
    //   1217: iconst_2
    //   1218: new 149	java/lang/StringBuilder
    //   1221: dup
    //   1222: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1225: ldc_w 330
    //   1228: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1231: aload_0
    //   1232: getfield 319	attm:nSessionId	J
    //   1235: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1238: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1241: ldc_w 929
    //   1244: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1247: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1250: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1253: aload_0
    //   1254: iconst_0
    //   1255: putfield 75	attm:cXr	I
    //   1258: aload_0
    //   1259: aload_0
    //   1260: getfield 168	attm:serverPath	Ljava/lang/String;
    //   1263: aload_0
    //   1264: getfield 489	attm:YD	J
    //   1267: invokevirtual 823	attm:aj	(Ljava/lang/String;J)V
    //   1270: aload 12
    //   1272: monitorexit
    //   1273: return
    //   1274: aload_0
    //   1275: invokestatic 554	java/lang/System:currentTimeMillis	()J
    //   1278: putfield 931	attm:YG	J
    //   1281: aload_0
    //   1282: invokestatic 554	java/lang/System:currentTimeMillis	()J
    //   1285: putfield 556	attm:endTime	J
    //   1288: iload_3
    //   1289: ifne +67 -> 1356
    //   1292: aload_0
    //   1293: invokevirtual 934	attm:dhv	()V
    //   1296: new 620	audw$b
    //   1299: dup
    //   1300: invokespecial 621	audw$b:<init>	()V
    //   1303: astore 9
    //   1305: aload 9
    //   1307: ldc_w 936
    //   1310: putfield 626	audw$b:bJE	Ljava/lang/String;
    //   1313: aload 9
    //   1315: iconst_1
    //   1316: putfield 629	audw$b:cYX	I
    //   1319: aload_0
    //   1320: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1323: invokevirtual 632	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1326: aload 9
    //   1328: invokestatic 637	audw:a	(Ljava/lang/String;Laudw$b;)V
    //   1331: aload_0
    //   1332: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1335: iconst_1
    //   1336: putfield 522	com/tencent/mobileqq/filemanager/data/FileManagerEntity:status	I
    //   1339: aload_0
    //   1340: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1343: invokevirtual 613	com/tencent/mobileqq/app/QQAppInterface:a	()Lattf;
    //   1346: aload_0
    //   1347: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1350: invokevirtual 939	attf:u	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;)V
    //   1353: goto -83 -> 1270
    //   1356: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1359: ifeq +45 -> 1404
    //   1362: ldc_w 758
    //   1365: iconst_2
    //   1366: new 149	java/lang/StringBuilder
    //   1369: dup
    //   1370: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1373: ldc_w 837
    //   1376: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1379: aload_0
    //   1380: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1383: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1386: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1389: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1392: ldc_w 941
    //   1395: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1401: invokestatic 472	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1404: aload_0
    //   1405: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1408: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1411: invokestatic 944	audx:jR	(J)V
    //   1414: aload_0
    //   1415: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1418: invokevirtual 368	com/tencent/mobileqq/app/QQAppInterface:a	()Latti;
    //   1421: aload_0
    //   1422: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1425: iconst_5
    //   1426: aload_0
    //   1427: getfield 168	attm:serverPath	Ljava/lang/String;
    //   1430: invokevirtual 947	atti:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;ILjava/lang/String;)V
    //   1433: aload_0
    //   1434: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1437: invokevirtual 237	com/tencent/mobileqq/app/QQAppInterface:a	()Latsq;
    //   1440: aload_0
    //   1441: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1444: aload_0
    //   1445: getfield 949	attm:selfUin	Ljava/lang/String;
    //   1448: aload_0
    //   1449: getfield 190	attm:strUin	Ljava/lang/String;
    //   1452: aload_0
    //   1453: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1456: getfield 952	com/tencent/mobileqq/filemanager/data/FileManagerEntity:Uuid	Ljava/lang/String;
    //   1459: aload_0
    //   1460: getfield 79	attm:e	Lagie;
    //   1463: invokevirtual 955	atsq:a	(Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lagie;)V
    //   1466: goto -170 -> 1296
    //   1469: aload_2
    //   1470: invokevirtual 861	aqog:getResponseCode	()I
    //   1473: sipush 206
    //   1476: if_icmpeq +15 -> 1491
    //   1479: aload_2
    //   1480: invokevirtual 861	aqog:getResponseCode	()I
    //   1483: istore_3
    //   1484: iload_3
    //   1485: sipush 200
    //   1488: if_icmpne -218 -> 1270
    //   1491: aload_0
    //   1492: getfield 957	attm:jdField_c_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1495: aload_2
    //   1496: invokevirtual 960	aqog:aB	()[B
    //   1499: invokevirtual 965	java/io/OutputStream:write	([B)V
    //   1502: aload_0
    //   1503: iconst_0
    //   1504: putfield 75	attm:cXr	I
    //   1507: aload_2
    //   1508: invokevirtual 960	aqog:aB	()[B
    //   1511: arraylength
    //   1512: i2l
    //   1513: lstore 5
    //   1515: aload_0
    //   1516: aload_0
    //   1517: getfield 487	attm:YF	J
    //   1520: lload 5
    //   1522: ladd
    //   1523: putfield 487	attm:YF	J
    //   1526: aload_0
    //   1527: lload 5
    //   1529: aload_0
    //   1530: getfield 489	attm:YD	J
    //   1533: ladd
    //   1534: putfield 489	attm:YD	J
    //   1537: aload_0
    //   1538: getfield 201	attm:nFileSize	J
    //   1541: lstore 5
    //   1543: aload_2
    //   1544: invokevirtual 968	aqog:hR	()J
    //   1547: lstore 5
    //   1549: aload_0
    //   1550: getfield 489	attm:YD	J
    //   1553: lload 5
    //   1555: lcmp
    //   1556: iflt +588 -> 2144
    //   1559: aload_0
    //   1560: getfield 314	attm:peerType	I
    //   1563: sipush 3000
    //   1566: if_icmpeq +35 -> 1601
    //   1569: aload_0
    //   1570: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1573: getfield 971	com/tencent/mobileqq/filemanager/data/FileManagerEntity:bSend	Z
    //   1576: ifne +25 -> 1601
    //   1579: aload_0
    //   1580: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1583: invokevirtual 237	com/tencent/mobileqq/app/QQAppInterface:a	()Latsq;
    //   1586: aload_0
    //   1587: getfield 949	attm:selfUin	Ljava/lang/String;
    //   1590: aload_0
    //   1591: getfield 478	attm:bHK	Ljava/lang/String;
    //   1594: aload_0
    //   1595: getfield 79	attm:e	Lagie;
    //   1598: invokevirtual 974	atsq:a	(Ljava/lang/String;Ljava/lang/String;Lagie;)V
    //   1601: aload_0
    //   1602: aconst_null
    //   1603: putfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   1606: aload_0
    //   1607: getfield 957	attm:jdField_c_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1610: invokevirtual 977	java/io/OutputStream:close	()V
    //   1613: aload_0
    //   1614: aconst_null
    //   1615: putfield 957	attm:jdField_c_of_type_JavaIoOutputStream	Ljava/io/OutputStream;
    //   1618: aload_0
    //   1619: invokespecial 979	attm:dhr	()V
    //   1622: goto -352 -> 1270
    //   1625: astore 9
    //   1627: aload 9
    //   1629: invokevirtual 982	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   1632: ldc_w 984
    //   1635: invokevirtual 988	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   1638: ifeq +124 -> 1762
    //   1641: aload_0
    //   1642: monitorenter
    //   1643: aload_0
    //   1644: iconst_1
    //   1645: putfield 265	attm:isStop	Z
    //   1648: aload_0
    //   1649: monitorexit
    //   1650: aload_0
    //   1651: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   1654: ifnull +81 -> 1735
    //   1657: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1660: ifeq +61 -> 1721
    //   1663: ldc_w 328
    //   1666: iconst_2
    //   1667: new 149	java/lang/StringBuilder
    //   1670: dup
    //   1671: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   1674: ldc_w 330
    //   1677: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1680: aload_0
    //   1681: getfield 319	attm:nSessionId	J
    //   1684: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1687: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1690: ldc_w 990
    //   1693: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1696: aload_0
    //   1697: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   1700: invokevirtual 804	aqog:Mk	()I
    //   1703: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   1706: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1709: ldc_w 342
    //   1712: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1715: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1718: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1721: aload_0
    //   1722: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1725: invokevirtual 355	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   1728: aload_0
    //   1729: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   1732: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpCommunicator:f	(Laqog;)V
    //   1735: aload_0
    //   1736: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1739: invokevirtual 99	com/tencent/mobileqq/app/QQAppInterface:a	()Lattk;
    //   1742: iconst_0
    //   1743: invokevirtual 105	attk:Jh	(Z)V
    //   1746: aload_0
    //   1747: aload_0
    //   1748: getfield 201	attm:nFileSize	J
    //   1751: new 996	attp
    //   1754: dup
    //   1755: aload_0
    //   1756: invokespecial 997	attp:<init>	(Lattm;)V
    //   1759: invokespecial 999	attm:a	(JLattm$a;)V
    //   1762: aload_0
    //   1763: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1766: aload_0
    //   1767: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1770: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1773: aload_0
    //   1774: getfield 474	attm:aBA	Ljava/lang/String;
    //   1777: aload_0
    //   1778: getfield 476	attm:startTime	J
    //   1781: aload_0
    //   1782: getfield 85	attm:bHO	Ljava/lang/String;
    //   1785: aload_0
    //   1786: getfield 190	attm:strUin	Ljava/lang/String;
    //   1789: aload_0
    //   1790: getfield 478	attm:bHK	Ljava/lang/String;
    //   1793: aload_0
    //   1794: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1797: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1800: ldc2_w 482
    //   1803: ldc_w 485
    //   1806: aload_0
    //   1807: getfield 487	attm:YF	J
    //   1810: aload_0
    //   1811: getfield 489	attm:YD	J
    //   1814: aload_0
    //   1815: getfield 201	attm:nFileSize	J
    //   1818: aload_0
    //   1819: getfield 85	attm:bHO	Ljava/lang/String;
    //   1822: ldc_w 485
    //   1825: aload_0
    //   1826: getfield 75	attm:cXr	I
    //   1829: ldc_w 1001
    //   1832: aconst_null
    //   1833: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1836: aload_0
    //   1837: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1840: aload_0
    //   1841: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1844: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1847: aload_0
    //   1848: getfield 496	attm:bHN	Ljava/lang/String;
    //   1851: aload_0
    //   1852: getfield 476	attm:startTime	J
    //   1855: aload_0
    //   1856: getfield 85	attm:bHO	Ljava/lang/String;
    //   1859: aload_0
    //   1860: getfield 190	attm:strUin	Ljava/lang/String;
    //   1863: aload_0
    //   1864: getfield 478	attm:bHK	Ljava/lang/String;
    //   1867: aload_0
    //   1868: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1871: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1874: ldc2_w 482
    //   1877: ldc_w 485
    //   1880: aload_0
    //   1881: getfield 487	attm:YF	J
    //   1884: aload_0
    //   1885: getfield 489	attm:YD	J
    //   1888: aload_0
    //   1889: getfield 201	attm:nFileSize	J
    //   1892: aload_0
    //   1893: getfield 85	attm:bHO	Ljava/lang/String;
    //   1896: ldc_w 485
    //   1899: aload_0
    //   1900: getfield 377	attm:cXu	I
    //   1903: ldc_w 1001
    //   1906: aconst_null
    //   1907: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   1910: aload_0
    //   1911: aconst_null
    //   1912: aconst_null
    //   1913: invokevirtual 499	attm:b	(Laqog;Laqog;)V
    //   1916: aload 12
    //   1918: monitorexit
    //   1919: return
    //   1920: astore 9
    //   1922: aload_0
    //   1923: monitorexit
    //   1924: aload 9
    //   1926: athrow
    //   1927: astore 9
    //   1929: aload_0
    //   1930: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1933: aload_0
    //   1934: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1937: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   1940: aload_0
    //   1941: getfield 474	attm:aBA	Ljava/lang/String;
    //   1944: aload_0
    //   1945: getfield 476	attm:startTime	J
    //   1948: aload_0
    //   1949: getfield 85	attm:bHO	Ljava/lang/String;
    //   1952: aload_0
    //   1953: getfield 190	attm:strUin	Ljava/lang/String;
    //   1956: aload_0
    //   1957: getfield 478	attm:bHK	Ljava/lang/String;
    //   1960: aload_0
    //   1961: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   1964: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   1967: ldc2_w 482
    //   1970: ldc_w 485
    //   1973: aload_0
    //   1974: getfield 487	attm:YF	J
    //   1977: aload_0
    //   1978: getfield 489	attm:YD	J
    //   1981: aload_0
    //   1982: getfield 201	attm:nFileSize	J
    //   1985: aload_0
    //   1986: getfield 85	attm:bHO	Ljava/lang/String;
    //   1989: ldc_w 485
    //   1992: aload_0
    //   1993: getfield 75	attm:cXr	I
    //   1996: ldc_w 1001
    //   1999: aconst_null
    //   2000: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2003: aload_0
    //   2004: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2007: aload_0
    //   2008: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2011: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2014: aload_0
    //   2015: getfield 496	attm:bHN	Ljava/lang/String;
    //   2018: aload_0
    //   2019: getfield 476	attm:startTime	J
    //   2022: aload_0
    //   2023: getfield 85	attm:bHO	Ljava/lang/String;
    //   2026: aload_0
    //   2027: getfield 190	attm:strUin	Ljava/lang/String;
    //   2030: aload_0
    //   2031: getfield 478	attm:bHK	Ljava/lang/String;
    //   2034: aload_0
    //   2035: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2038: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2041: ldc2_w 482
    //   2044: ldc_w 485
    //   2047: aload_0
    //   2048: getfield 487	attm:YF	J
    //   2051: aload_0
    //   2052: getfield 489	attm:YD	J
    //   2055: aload_0
    //   2056: getfield 201	attm:nFileSize	J
    //   2059: aload_0
    //   2060: getfield 85	attm:bHO	Ljava/lang/String;
    //   2063: ldc_w 485
    //   2066: aload_0
    //   2067: getfield 377	attm:cXu	I
    //   2070: ldc_w 1001
    //   2073: aconst_null
    //   2074: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2077: aload_0
    //   2078: aconst_null
    //   2079: aconst_null
    //   2080: invokevirtual 499	attm:b	(Laqog;Laqog;)V
    //   2083: aload 12
    //   2085: monitorexit
    //   2086: return
    //   2087: astore 9
    //   2089: ldc_w 1003
    //   2092: iconst_1
    //   2093: new 149	java/lang/StringBuilder
    //   2096: dup
    //   2097: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   2100: ldc_w 330
    //   2103: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2106: aload_0
    //   2107: getfield 319	attm:nSessionId	J
    //   2110: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   2113: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2116: ldc_w 1005
    //   2119: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2122: aload 9
    //   2124: invokevirtual 1006	java/io/IOException:toString	()Ljava/lang/String;
    //   2127: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2130: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2133: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2136: aload 9
    //   2138: invokevirtual 1007	java/io/IOException:printStackTrace	()V
    //   2141: goto -528 -> 1613
    //   2144: aload_0
    //   2145: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2148: aload_0
    //   2149: getfield 489	attm:YD	J
    //   2152: l2f
    //   2153: aload_0
    //   2154: getfield 201	attm:nFileSize	J
    //   2157: l2f
    //   2158: fdiv
    //   2159: invokevirtual 923	com/tencent/mobileqq/filemanager/data/FileManagerEntity:setfProgress	(F)V
    //   2162: aload_0
    //   2163: sipush 2002
    //   2166: invokevirtual 365	attm:setStatus	(I)V
    //   2169: invokestatic 554	java/lang/System:currentTimeMillis	()J
    //   2172: lstore 5
    //   2174: aload_0
    //   2175: getfield 925	attm:HO	J
    //   2178: lstore 7
    //   2180: lload 5
    //   2182: lload 7
    //   2184: lsub
    //   2185: ldc2_w 926
    //   2188: lcmp
    //   2189: ifge +7 -> 2196
    //   2192: aload 12
    //   2194: monitorexit
    //   2195: return
    //   2196: aload_0
    //   2197: lload 5
    //   2199: putfield 925	attm:HO	J
    //   2202: aload_0
    //   2203: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2206: aload_0
    //   2207: getfield 489	attm:YD	J
    //   2210: l2f
    //   2211: aload_0
    //   2212: getfield 201	attm:nFileSize	J
    //   2215: l2f
    //   2216: fdiv
    //   2217: invokevirtual 923	com/tencent/mobileqq/filemanager/data/FileManagerEntity:setfProgress	(F)V
    //   2220: aload_0
    //   2221: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2224: invokevirtual 368	com/tencent/mobileqq/app/QQAppInterface:a	()Latti;
    //   2227: aload_0
    //   2228: getfield 370	attm:uniseq	J
    //   2231: aload_0
    //   2232: getfield 319	attm:nSessionId	J
    //   2235: aload_0
    //   2236: getfield 190	attm:strUin	Ljava/lang/String;
    //   2239: aload_0
    //   2240: getfield 314	attm:peerType	I
    //   2243: bipush 16
    //   2245: aconst_null
    //   2246: iconst_0
    //   2247: aconst_null
    //   2248: invokevirtual 375	atti:a	(JJLjava/lang/String;IILjava/lang/Object;ILjava/lang/String;)V
    //   2251: goto -981 -> 1270
    //   2254: ldc_w 485
    //   2257: astore 10
    //   2259: ldc_w 485
    //   2262: astore 11
    //   2264: aload_1
    //   2265: ifnull +9 -> 2274
    //   2268: aload_1
    //   2269: invokevirtual 807	aqog:getRealUrl	()Ljava/lang/String;
    //   2272: astore 10
    //   2274: aload 11
    //   2276: astore_1
    //   2277: aload_2
    //   2278: ifnull +8 -> 2286
    //   2281: aload_2
    //   2282: getfield 810	aqog:cuw	Ljava/lang/String;
    //   2285: astore_1
    //   2286: aload_0
    //   2287: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2290: aload_0
    //   2291: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2294: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2297: aload_0
    //   2298: getfield 474	attm:aBA	Ljava/lang/String;
    //   2301: aload_0
    //   2302: getfield 476	attm:startTime	J
    //   2305: aload_0
    //   2306: getfield 85	attm:bHO	Ljava/lang/String;
    //   2309: aload_0
    //   2310: getfield 190	attm:strUin	Ljava/lang/String;
    //   2313: aload_0
    //   2314: getfield 478	attm:bHK	Ljava/lang/String;
    //   2317: aload_0
    //   2318: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2321: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2324: ldc2_w 1008
    //   2327: aconst_null
    //   2328: aload_0
    //   2329: getfield 487	attm:YF	J
    //   2332: aload_0
    //   2333: getfield 489	attm:YD	J
    //   2336: aload_0
    //   2337: getfield 201	attm:nFileSize	J
    //   2340: aload 10
    //   2342: aload_1
    //   2343: aload_0
    //   2344: getfield 377	attm:cXu	I
    //   2347: aload 9
    //   2349: aconst_null
    //   2350: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2353: aload_0
    //   2354: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2357: aload_0
    //   2358: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2361: getfield 403	com/tencent/mobileqq/filemanager/data/FileManagerEntity:nSessionId	J
    //   2364: aload_0
    //   2365: getfield 496	attm:bHN	Ljava/lang/String;
    //   2368: aload_0
    //   2369: getfield 476	attm:startTime	J
    //   2372: aload_0
    //   2373: getfield 85	attm:bHO	Ljava/lang/String;
    //   2376: aload_0
    //   2377: getfield 190	attm:strUin	Ljava/lang/String;
    //   2380: aload_0
    //   2381: getfield 478	attm:bHK	Ljava/lang/String;
    //   2384: aload_0
    //   2385: getfield 391	attm:jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity	Lcom/tencent/mobileqq/filemanager/data/FileManagerEntity;
    //   2388: getfield 481	com/tencent/mobileqq/filemanager/data/FileManagerEntity:strFileMd5	Ljava/lang/String;
    //   2391: ldc2_w 1008
    //   2394: aconst_null
    //   2395: aload_0
    //   2396: getfield 487	attm:YF	J
    //   2399: aload_0
    //   2400: getfield 489	attm:YD	J
    //   2403: aload_0
    //   2404: getfield 201	attm:nFileSize	J
    //   2407: aload 10
    //   2409: aload_1
    //   2410: aload_0
    //   2411: getfield 377	attm:cXu	I
    //   2414: aload 9
    //   2416: aconst_null
    //   2417: invokestatic 494	audx:a	(Lcom/tencent/mobileqq/app/QQAppInterface;JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;JJJLjava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    //   2420: aload_0
    //   2421: aconst_null
    //   2422: aconst_null
    //   2423: invokevirtual 499	attm:b	(Laqog;Laqog;)V
    //   2426: goto -1156 -> 1270
    //   2429: lconst_0
    //   2430: lstore 5
    //   2432: goto -1863 -> 569
    //   2435: lconst_0
    //   2436: lstore 5
    //   2438: goto -2006 -> 432
    //   2441: iconst_1
    //   2442: istore_3
    //   2443: goto -1417 -> 1026
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2446	0	this	attm
    //   0	2446	1	paramaqog1	aqog
    //   0	2446	2	paramaqog2	aqog
    //   270	2173	3	j	int
    //   267	696	4	k	int
    //   430	2007	5	l1	long
    //   2178	5	7	l2	long
    //   255	1072	9	localObject1	Object
    //   1625	3	9	localException1	Exception
    //   1920	5	9	localObject2	Object
    //   1927	1	9	localException2	Exception
    //   2087	328	9	localIOException	java.io.IOException
    //   233	25	10	localException3	Exception
    //   262	2146	10	localObject3	Object
    //   281	1994	11	localObject4	Object
    //   4	2189	12	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   9	64	165	finally
    //   64	67	165	finally
    //   68	76	165	finally
    //   80	161	165	finally
    //   161	164	165	finally
    //   166	169	165	finally
    //   175	230	165	finally
    //   235	252	165	finally
    //   257	269	165	finally
    //   283	311	165	finally
    //   318	383	165	finally
    //   386	432	165	finally
    //   439	544	165	finally
    //   544	547	165	finally
    //   548	557	165	finally
    //   562	569	165	finally
    //   569	669	165	finally
    //   674	789	165	finally
    //   789	830	165	finally
    //   830	833	165	finally
    //   834	944	165	finally
    //   953	962	165	finally
    //   965	1023	165	finally
    //   1026	1109	165	finally
    //   1109	1253	165	finally
    //   1253	1270	165	finally
    //   1270	1273	165	finally
    //   1274	1288	165	finally
    //   1292	1296	165	finally
    //   1296	1353	165	finally
    //   1356	1404	165	finally
    //   1404	1466	165	finally
    //   1469	1484	165	finally
    //   1491	1502	165	finally
    //   1502	1601	165	finally
    //   1601	1606	165	finally
    //   1606	1613	165	finally
    //   1613	1622	165	finally
    //   1627	1643	165	finally
    //   1650	1721	165	finally
    //   1721	1735	165	finally
    //   1735	1746	165	finally
    //   1746	1762	165	finally
    //   1762	1916	165	finally
    //   1916	1919	165	finally
    //   1924	1927	165	finally
    //   1929	2083	165	finally
    //   2083	2086	165	finally
    //   2089	2141	165	finally
    //   2144	2180	165	finally
    //   2192	2195	165	finally
    //   2196	2251	165	finally
    //   2268	2274	165	finally
    //   2281	2286	165	finally
    //   2286	2426	165	finally
    //   9	64	233	java/lang/Exception
    //   68	76	233	java/lang/Exception
    //   80	161	233	java/lang/Exception
    //   175	230	233	java/lang/Exception
    //   318	383	233	java/lang/Exception
    //   386	432	233	java/lang/Exception
    //   439	544	233	java/lang/Exception
    //   548	557	233	java/lang/Exception
    //   562	569	233	java/lang/Exception
    //   569	669	233	java/lang/Exception
    //   674	789	233	java/lang/Exception
    //   789	830	233	java/lang/Exception
    //   834	944	233	java/lang/Exception
    //   953	962	233	java/lang/Exception
    //   965	1023	233	java/lang/Exception
    //   1026	1109	233	java/lang/Exception
    //   1109	1253	233	java/lang/Exception
    //   1253	1270	233	java/lang/Exception
    //   1274	1288	233	java/lang/Exception
    //   1292	1296	233	java/lang/Exception
    //   1296	1353	233	java/lang/Exception
    //   1356	1404	233	java/lang/Exception
    //   1404	1466	233	java/lang/Exception
    //   1469	1484	233	java/lang/Exception
    //   1502	1601	233	java/lang/Exception
    //   1601	1606	233	java/lang/Exception
    //   1606	1613	233	java/lang/Exception
    //   1613	1622	233	java/lang/Exception
    //   1627	1643	233	java/lang/Exception
    //   1650	1721	233	java/lang/Exception
    //   1721	1735	233	java/lang/Exception
    //   1735	1746	233	java/lang/Exception
    //   1762	1916	233	java/lang/Exception
    //   1924	1927	233	java/lang/Exception
    //   1929	2083	233	java/lang/Exception
    //   2089	2141	233	java/lang/Exception
    //   2144	2180	233	java/lang/Exception
    //   2196	2251	233	java/lang/Exception
    //   1491	1502	1625	java/lang/Exception
    //   1643	1650	1920	finally
    //   1922	1924	1920	finally
    //   1746	1762	1927	java/lang/Exception
    //   1606	1613	2087	java/io/IOException
  }
  
  public boolean a(aqog paramaqog1, aqog paramaqog2, int paramInt)
  {
    if ((5 == paramInt) && (this.actionType != 0) && (this.YD < this.nFileSize))
    {
      if (QLog.isColorLevel()) {
        QLog.e("FileManagerRSWorker<FileAssistant>", 2, "nSessionID[" + String.valueOf(this.nSessionId) + "] HttpCommunicator.status = STATUS_END . but data no recv completed. recvData=" + this.YD + " filesize=" + this.nFileSize);
      }
      audx.a(this.app, this.nSessionId, this.bHN, this.startTime, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -9527L, "", this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, "statusChanged mtransferedSize[" + String.valueOf(this.YD) + "]nFileSize[" + String.valueOf(this.nFileSize) + "]", null);
      dhr();
    }
    return true;
  }
  
  /* Error */
  byte[] a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 1022	attm:i	Ljava/io/InputStream;
    //   4: ifnonnull +23 -> 27
    //   7: aload_0
    //   8: new 1024	java/io/FileInputStream
    //   11: dup
    //   12: aload_0
    //   13: getfield 416	attm:strFilePath	Ljava/lang/String;
    //   16: invokespecial 1025	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   19: putfield 1022	attm:i	Ljava/io/InputStream;
    //   22: aload_0
    //   23: lconst_0
    //   24: putfield 1027	attm:YH	J
    //   27: lload_1
    //   28: lconst_0
    //   29: lcmp
    //   30: ifne +96 -> 126
    //   33: aload_0
    //   34: getfield 1027	attm:YH	J
    //   37: lconst_0
    //   38: lcmp
    //   39: ifeq +23 -> 62
    //   42: aload_0
    //   43: new 1024	java/io/FileInputStream
    //   46: dup
    //   47: aload_0
    //   48: getfield 416	attm:strFilePath	Ljava/lang/String;
    //   51: invokespecial 1025	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   54: putfield 1022	attm:i	Ljava/io/InputStream;
    //   57: aload_0
    //   58: lconst_0
    //   59: putfield 1027	attm:YH	J
    //   62: aload_0
    //   63: lload_1
    //   64: putfield 1027	attm:YH	J
    //   67: iload_3
    //   68: newarray byte
    //   70: astore 4
    //   72: aload_0
    //   73: getfield 1022	attm:i	Ljava/io/InputStream;
    //   76: aload 4
    //   78: iconst_0
    //   79: iload_3
    //   80: invokevirtual 1033	java/io/InputStream:read	([BII)I
    //   83: pop
    //   84: aload_0
    //   85: aload_0
    //   86: getfield 1027	attm:YH	J
    //   89: iload_3
    //   90: i2l
    //   91: ladd
    //   92: putfield 1027	attm:YH	J
    //   95: aload 4
    //   97: areturn
    //   98: astore 4
    //   100: aload_0
    //   101: aconst_null
    //   102: putfield 1022	attm:i	Ljava/io/InputStream;
    //   105: aload 4
    //   107: invokevirtual 1034	java/io/FileNotFoundException:printStackTrace	()V
    //   110: aconst_null
    //   111: areturn
    //   112: astore 4
    //   114: aload_0
    //   115: aconst_null
    //   116: putfield 1022	attm:i	Ljava/io/InputStream;
    //   119: aload 4
    //   121: invokevirtual 1034	java/io/FileNotFoundException:printStackTrace	()V
    //   124: aconst_null
    //   125: areturn
    //   126: lload_1
    //   127: aload_0
    //   128: getfield 1027	attm:YH	J
    //   131: lcmp
    //   132: ifle +29 -> 161
    //   135: aload_0
    //   136: getfield 1022	attm:i	Ljava/io/InputStream;
    //   139: lload_1
    //   140: aload_0
    //   141: getfield 1027	attm:YH	J
    //   144: lsub
    //   145: invokevirtual 1038	java/io/InputStream:skip	(J)J
    //   148: pop2
    //   149: goto -87 -> 62
    //   152: astore 4
    //   154: aload 4
    //   156: invokevirtual 1007	java/io/IOException:printStackTrace	()V
    //   159: aconst_null
    //   160: areturn
    //   161: lload_1
    //   162: aload_0
    //   163: getfield 1027	attm:YH	J
    //   166: lcmp
    //   167: ifge -105 -> 62
    //   170: aload_0
    //   171: new 1024	java/io/FileInputStream
    //   174: dup
    //   175: aload_0
    //   176: getfield 416	attm:strFilePath	Ljava/lang/String;
    //   179: invokespecial 1025	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   182: putfield 1022	attm:i	Ljava/io/InputStream;
    //   185: aload_0
    //   186: lconst_0
    //   187: putfield 1027	attm:YH	J
    //   190: aload_0
    //   191: getfield 1022	attm:i	Ljava/io/InputStream;
    //   194: lload_1
    //   195: invokevirtual 1038	java/io/InputStream:skip	(J)J
    //   198: pop2
    //   199: goto -137 -> 62
    //   202: astore 4
    //   204: aload_0
    //   205: aconst_null
    //   206: putfield 1022	attm:i	Ljava/io/InputStream;
    //   209: aload 4
    //   211: invokevirtual 1007	java/io/IOException:printStackTrace	()V
    //   214: aconst_null
    //   215: areturn
    //   216: astore 4
    //   218: aconst_null
    //   219: astore 4
    //   221: goto -126 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	attm
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
    String str = this.jdField_a_of_type_Audn.vZ();
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
    if (isStop()) {
      return;
    }
    if (paramLong == 0L) {
      this.YD = 0L;
    }
    int k = this.b.a(BaseApplication.getContext(), this.nFileSize, paramLong, 1048576);
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
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      setStatus(0);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 1, null, 2, null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "NoNetWork", null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "NoNetWork", null);
      return false;
    }
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 13, null, 0, null);
    if (this.actionType == 0) {
      this.app.a().o(this.nSessionId, 1002);
    }
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setfProgress(0.0F);
    if (this.strFilePath == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.nSessionId + "], strFilePath is null");
      }
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, audx.ti(), null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, audx.ti(), null);
      b(null, null);
      return false;
    }
    Object localObject;
    if ((this.serverPath != null) && (this.serverPath.length() != 0))
    {
      this.bHO = this.serverPath;
      this.jdField_a_of_type_Attx = new attx(this.app, this.serverPath);
      localObject = this.jdField_a_of_type_Attx.vg();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        this.serverPath = ((String)localObject);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath = this.serverPath;
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.nSessionId + "], entify" + audx.d(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
        }
        this.YE = 131072L;
        this.YF = 0L;
        aj(this.serverPath, 0L);
        return true;
      }
    }
    this.dO = audx.a(this.strFilePath, this.nFileSize);
    if (this.dO == null)
    {
      setStatus(0);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 2, null, 5, null);
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.nSessionId + "], getMd5 failed");
      }
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, "getfile md5 error", null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9041L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "getfile md5 error", null);
      return true;
    }
    try
    {
      localObject = audx.getFileName(this.strFilePath).getBytes("utf-8");
      byte[] arrayOfByte = this.strFilePath.getBytes("utf-8");
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.nSessionId + "], serverPath is null, so get upload info");
      }
      if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType > 0L) {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionSig = audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.peerUin, (int)this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.tmpSessionType);
      }
      a(this.strUin, arrayOfByte, (byte[])localObject, this.nFileSize, this.dO, this.e, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "发送CS包,请求上传,nSessionID[" + String.valueOf(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId) + "]");
      }
      return true;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      localUnsupportedEncodingException.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendLocalFile, SessionId[" + this.nSessionId + "], getMd5 failed");
      }
      setStatus(0);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, audx.ti(), null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9005L, null, this.YF, this.YD, this.nFileSize, "", "", this.cXu, audx.ti(), null);
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
    int j = paramaqog2.errCode;
    if (atwx.jL(paramaqog2.errCode))
    {
      this.cXu += 1;
      if (this.jdField_a_of_type_Attx == null) {
        break label1419;
      }
    }
    label1419:
    for (str1 = this.jdField_a_of_type_Attx.vg();; str1 = null)
    {
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]get nextIp[" + str1 + "]errCode[" + j + "]");
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, j, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString() + "&goChangeUrl", null);
      long l;
      int k;
      if ((str1 == null) || (str1.length() == 0))
      {
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "] need chang Ip ,but can not get next ip errCode[" + j + "]");
        l = this.startTime;
        if (str2.indexOf("-29602") <= 0) {
          break label659;
        }
        paramaqog2.errCode = -29602;
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, -29602, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString(), null);
        k = -29602;
      }
      for (;;)
      {
        this.cXr = 0;
        clearTask();
        j(paramaqog2, k);
        return;
        II(str1);
        return;
        QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + this.nSessionId + "]don't need chang Ip errCode[" + j + "]");
        break;
        label659:
        if (a(paramaqog1, paramaqog2))
        {
          if ((str2.contains("-29120")) || (str2.contains("-502")) || (str2.contains("HTTP_PROXY_AUTH")) || (str2.contains("-29150")) || (str2.contains("-21122")) || (str2.contains("-28123")) || (str2.contains("-25081")) || (str2.contains("-28126")))
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
            if ((str2.contains("-6101")) || (str2.contains("-7003")) || (str2.contains("-403")) || (str2.contains("-9006")) || (str2.contains("-9004")) || (str2.contains("-9017")) || (str2.contains("-28137")))
            {
              audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9042, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, paramaqog2.getErrorString(), null);
              this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
              k = 9042;
              break;
              QLog.e("FileManagerRSWorker<FileAssistant>", 1, "!!!!!!!uuid is null!!!!!!!");
              QLog.e("FileManagerRSWorker<FileAssistant>", 1, audx.d(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity));
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
            k = j;
            if (this.cXr >= 8) {
              break;
            }
            this.cXr += 1;
            this.cXu += 1;
            if (j == 9056)
            {
              if (this.cXs < 3)
              {
                this.cXs += 1;
                this.cXr -= 1;
              }
            }
            else
            {
              if (j == 9042)
              {
                if (this.cXt >= 3) {
                  break label1399;
                }
                this.cXt += 1;
                this.cXr -= 1;
              }
              label1188:
              k = 6000;
              if (j == 9056) {
                k = 0;
              }
              new Handler().postDelayed(new FileManagerRSWorker.4(this), k);
              QLog.w("FileManagerRSWorker<FileAssistant>", 1, "nSessionId[" + this.nSessionId + "] after [" + k + "] time retry!");
              if (9048 != j) {
                break label1407;
              }
              j = 11202;
            }
            label1399:
            label1407:
            for (;;)
            {
              audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, l, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, j, String.valueOf(paramaqog2.Mk()), this.YF, this.YD, this.nFileSize, paramaqog2.getRealUrl(), paramaqog2.cuw, this.cXu, "delayTimes[" + k + "]" + paramaqog2.getErrorString(), null);
              return;
              this.cXs = 0;
              break;
              this.cXt = 0;
              break label1188;
            }
          }
        }
        k = j;
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
    //   4: putfield 265	attm:isStop	Z
    //   7: aload_0
    //   8: monitorexit
    //   9: aload_0
    //   10: getfield 1231	attm:runnable	Ljava/lang/Runnable;
    //   13: invokestatic 1237	com/tencent/mobileqq/app/ThreadManager:remove	(Ljava/lang/Runnable;)Z
    //   16: pop
    //   17: aload_0
    //   18: getfield 1022	attm:i	Ljava/io/InputStream;
    //   21: invokevirtual 1238	java/io/InputStream:close	()V
    //   24: aload_0
    //   25: aconst_null
    //   26: putfield 1022	attm:i	Ljava/io/InputStream;
    //   29: aload_0
    //   30: getfield 408	attm:jdField_a_of_type_Audg	Laudg;
    //   33: ifnull +10 -> 43
    //   36: aload_0
    //   37: getfield 408	attm:jdField_a_of_type_Audg	Laudg;
    //   40: invokevirtual 1241	audg:stop	()V
    //   43: aload_0
    //   44: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   47: ifnull +81 -> 128
    //   50: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   53: ifeq +61 -> 114
    //   56: ldc_w 328
    //   59: iconst_2
    //   60: new 149	java/lang/StringBuilder
    //   63: dup
    //   64: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   67: ldc_w 330
    //   70: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: aload_0
    //   74: getfield 319	attm:nSessionId	J
    //   77: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc_w 990
    //   86: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: aload_0
    //   90: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   93: invokevirtual 804	aqog:Mk	()I
    //   96: invokestatic 340	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   99: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: ldc_w 342
    //   105: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   114: aload_0
    //   115: getfield 94	attm:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   118: invokevirtual 355	com/tencent/mobileqq/app/QQAppInterface:getHttpCommunicatort	()Lcom/tencent/mobileqq/utils/httputils/HttpCommunicator;
    //   121: aload_0
    //   122: getfield 362	attm:jdField_a_of_type_Aqog	Laqog;
    //   125: invokevirtual 994	com/tencent/mobileqq/utils/httputils/HttpCommunicator:f	(Laqog;)V
    //   128: aload_0
    //   129: getfield 698	attm:jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task	Lcom/weiyun/sdk/IWyTaskManager$Task;
    //   132: ifnull +58 -> 190
    //   135: invokestatic 529	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +42 -> 180
    //   141: ldc_w 328
    //   144: iconst_2
    //   145: new 149	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 150	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 330
    //   155: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: aload_0
    //   159: getfield 319	attm:nSessionId	J
    //   162: invokestatic 323	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   165: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: ldc_w 1243
    //   171: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 166	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 347	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: aload_0
    //   181: getfield 698	attm:jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task	Lcom/weiyun/sdk/IWyTaskManager$Task;
    //   184: invokeinterface 1246 1 0
    //   189: pop
    //   190: return
    //   191: astore_1
    //   192: aload_0
    //   193: monitorexit
    //   194: aload_1
    //   195: athrow
    //   196: astore_1
    //   197: goto -168 -> 29
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	200	0	this	attm
    //   191	4	1	localObject	Object
    //   196	1	1	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   2	9	191	finally
    //   192	194	191	finally
    //   17	29	196	java/lang/Exception
  }
  
  void d(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (isStop()) {
      return;
    }
    int j;
    if (paramLong == 0L)
    {
      j = this.b.a(BaseApplication.getContext(), this.nFileSize, paramLong, 1024);
      if (this.nFileSize < j) {}
      for (l = this.nFileSize;; l = 1024L)
      {
        j = (int)l;
        this.YD = 0L;
        j = Math.min(j, 1048576);
        if (QLog.isColorLevel()) {
          QLog.i("FileManagerRSWorker<FileAssistant>", 2, "sendFilePakage transferedSize[" + paramLong + "], size[" + j + "]");
        }
        b(paramString, paramLong, j, paramArrayOfByte);
        return;
      }
    }
    this.YE = this.b.a(BaseApplication.getContext(), this.nFileSize, paramLong, 131072);
    if (this.nFileSize < this.YE + paramLong) {}
    for (long l = this.nFileSize - paramLong;; l = this.YE)
    {
      int k = (int)l;
      int m = auye.getNetWorkType(BaseApplication.getContext());
      if (m != 1)
      {
        j = k;
        if (m != 2) {
          break;
        }
      }
      j = k;
      if (k <= 16384) {
        break;
      }
      j = 16384;
      break;
    }
  }
  
  public void dhp()
  {
    if (!aqiw.isNetSupport(BaseApplicationImpl.getContext()))
    {
      setStatus(0);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 1, null, 2, null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "NoNetWork", null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "NoNetWork", null);
      return;
    }
    if (aueh.fileExistsAndNotEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath))
    {
      dhr();
      return;
    }
    if ((this.bHK == null) || (this.bHK.length() == 0))
    {
      dhq();
      return;
    }
    if (this.peerType == 3000) {
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
    this.app.a().a(this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bSend, this.e);
  }
  
  public void dhq()
  {
    if (isStop()) {}
    do
    {
      return;
      QLog.i("FileManagerRSWorker<FileAssistant>", 1, "nSessionID[" + String.valueOf(this.nSessionId) + "],ReceiveOfflineForOldMsg");
      if (!TextUtils.isEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath)) {
        this.serverPath = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strServerPath;
      }
      if ((this.serverPath != null) && (this.serverPath.length() != 0)) {
        break;
      }
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "id[" + String.valueOf(this.nSessionId) + "] get old offlinefile info is error! serverPath is empty");
      if (aueh.fileExistsAndNotEmpty(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFilePath))
      {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 1;
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 11, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
        return;
      }
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 16;
      setStatus(2005);
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 6, null);
    } while ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType == -1) || (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nWeiYunSrcType != -2));
    return;
    if (-1L != this.uniseq) {}
    label1277:
    Object localObject2;
    for (Object localObject1 = this.app.b().b(this.strUin, 0, this.uniseq);; localObject2 = null)
    {
      EntityManager localEntityManager;
      if (localObject1 != null)
      {
        localEntityManager = this.app.a().createEntityManager();
        TransFileInfo localTransFileInfo = (TransFileInfo)localEntityManager.find(TransFileInfo.class, new String[] { String.valueOf(((MessageRecord)localObject1).time), String.valueOf(((MessageRecord)localObject1).msgseq), this.app.getCurrentAccountUin(), this.strUin });
        localEntityManager.close();
        if ((localTransFileInfo != null) && (2008 == localTransFileInfo.status)) {
          this.strFilePath = audx.kW(this.strFilePath);
        }
      }
      if ((localObject1 != null) && (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getCloudType() == 1)) {
        this.strFilePath = audx.kW(this.strFilePath);
      }
      this.bHJ = (this.strFilePath + ".tmp");
      if (!aqiw.isNetSupport(BaseApplication.getContext()))
      {
        if (isStop()) {
          break;
        }
        setStatus(2005);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 1, null, 2, null);
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXr, "NoNetWork", null);
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9004L, "", 0L, 0L, this.nFileSize, "", "", this.cXu, "NoNetWork", null);
        return;
      }
      this.YD = audx.getFileSizes(this.bHJ);
      if (this.YD == this.nFileSize)
      {
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
        setStatus(2003);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 11, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = audx.getFileName(this.strFilePath);
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName.getBytes().length > 250)
        {
          this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = audx.kY(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
          this.strFilePath = aX(this.strUin, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName);
        }
        if (aqhq.fileExists(this.strFilePath)) {
          this.strFilePath = audx.kW(this.strFilePath);
        }
        aqhq.renameFile(new File(this.bHJ), new File(this.strFilePath));
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName = audx.getFileName(this.strFilePath);
        audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, 0L, this.serverPath, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 0L, 0L, this.nFileSize, this.cXr, null);
        return;
      }
      if (this.nFileSize > this.YD)
      {
        long l2 = this.nFileSize - this.YD;
        if (aqfo.isExistSDCard()) {}
        for (long l1 = aqfo.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = aqfo.getSystemAvailableSize() * 1024L)
        {
          QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.nSessionId) + "]local sdcard space no enough!! [downsize:" + l2 + "mobile space:" + l1 + "]");
          setStatus(2005);
          this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 12, null);
          audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXr, "sdcard full", null);
          audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.bHN, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, 9040L, "", this.YF, this.YD, this.nFileSize, this.bHO, "", this.cXu, "sdcard full", null);
          return;
        }
      }
      if (this.jdField_c_of_type_JavaIoOutputStream == null) {}
      try
      {
        this.jdField_c_of_type_JavaIoOutputStream = new FileOutputStream(this.bHJ, true);
        if (this.actionType == 1) {
          this.app.a().o(this.nSessionId, 2002);
        }
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
        localEntityManager = null;
        localObject1 = localEntityManager;
        if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isZipInnerFile)
        {
          localObject1 = localEntityManager;
          if (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId != null) {
            localObject1 = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId;
          }
        }
        ar(this.YD, (String)localObject1);
        return;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        break label1277;
      }
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
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    long l2 = this.nFileSize - this.YD;
    if (aqfo.isExistSDCard()) {}
    for (long l1 = aqfo.getSDCardAvailableSize() * 1024L; l1 < l2; l1 = aqfo.getSystemAvailableSize() * 1024L)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.nSessionId) + "]downLoadWeiYunFile local space no enough!! [downsize:" + l2 + "sdcardsize:" + l1 + "]");
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.app.a().dhl();
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 12, null);
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, "", "", "", "", 9040L, "", this.YD, this.YD, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "sdcard full", null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.app.a().a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime, null);
    this.nFileSize = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create download task is fail! nSessionId[" + String.valueOf(this.nSessionId) + "]fileid[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.WeiYunFileId + "] filename[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileName + "] filesize[" + String.valueOf(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize) + "] modifytime[" + String.valueOf(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastTime) + "]");
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 36, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new attq(this));
    this.app.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
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
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, 0L, "", "", "", "", 9004L, "", 0L, 0L, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize, "", "", 0, "no network", null);
      return;
    }
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 0;
    this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = 2;
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task = this.app.a().a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath(), null);
    this.nFileSize = this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize;
    if (this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task == null)
    {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "create upload task is fail! nSessionId[" + String.valueOf(this.nSessionId) + "] filePath[" + this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.getFilePath() + "]");
      this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 38, null, 11, null);
      return;
    }
    this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.addListener(new atts(this));
    this.app.a().a().a(this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task);
  }
  
  void dhv()
  {
    this.YI = System.currentTimeMillis();
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setCloudType(3);
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.bOnceSuccess = true;
    this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.lastSuccessTime = anaz.gQ();
    setStatus(1003);
    if (QLog.isColorLevel()) {
      QLog.i("FileManagerRSWorker<FileAssistant>", 2, "SendFileSuccess, SessionId[" + this.nSessionId + "], FileSize[" + this.nFileSize + "], Uuid[" + this.bHK + "]");
    }
    this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 14, new Object[] { this.strFilePath, Long.valueOf(this.nFileSize), Boolean.valueOf(true), this.serverPath }, 0, null);
    if ((this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid == null) || (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid.length() == 0)) {
      QLog.e("FileManagerRSWorker<FileAssistant>", 1, "uuid is null Entity[" + audx.d(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity) + "]");
    }
    this.YG = System.currentTimeMillis();
    this.endTime = System.currentTimeMillis();
    this.app.a().a(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity, this.selfUin, this.strUin, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid, this.e);
  }
  
  protected void finalize()
    throws Throwable
  {
    switch (this.actionType)
    {
    }
    for (;;)
    {
      clearTask();
      super.finalize();
      return;
      this.jdField_a_of_type_ComWeiyunSdkIWyTaskManager$Task.cancel();
    }
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
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setfProgress((float)this.YD / (float)this.nFileSize);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.uniseq;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.bHK;
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 15, null, 5, null);
      } while (localaqog == null);
      paramObject = localaqog.getErrorString();
      if ((paramInt == 0) && (paramObject == null))
      {
        paramObject = "[Http_RespValue_Null]" + audx.ti();
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
      audx.a(this.app, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.nSessionId, this.aBA, this.startTime, this.bHO, this.strUin, this.bHK, this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.strFileMd5, paramInt, String.valueOf(localaqog.Mk()), this.YF, this.YD, this.nFileSize, localaqog.getRealUrl(), localaqog.cuw, this.cXu, (String)localObject, null);
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
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setfProgress((float)this.YD / (float)this.nFileSize);
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.uniseq = this.uniseq;
        this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.Uuid = this.bHK;
        this.app.a().u(this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity);
        this.app.a().a(this.uniseq, this.nSessionId, this.strUin, this.peerType, 12, null, 6, null);
        break;
      }
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.isReaded = false;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setfProgress((float)this.YD / (float)this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.fileSize);
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
    paramInt = audx.hM(paramInt);
    if ((this.status == paramInt) && (paramInt == 2)) {}
    do
    {
      do
      {
        return;
        this.status = paramInt;
      } while (this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity == null);
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.status = paramInt;
      this.jdField_c_of_type_ComTencentMobileqqFilemanagerDataFileManagerEntity.setfProgress((float)this.YD / (float)this.nFileSize);
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
    Object localObject = this.jdField_a_of_type_Audn.vZ();
    QLog.i("FileManagerRSWorker<FileAssistant>", 1, "Id[" + String.valueOf(this.nSessionId) + "]getTransferFilePath dir: " + (String)localObject);
    localObject = new File((String)localObject);
    if (!((File)localObject).exists()) {}
    for (boolean bool1 = ((File)localObject).mkdirs();; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.nSessionId + "]getRecvDir[" + bool1 + "]");
      }
      this.bHI = this.jdField_a_of_type_Audn.wa();
      localObject = new File(this.bHI);
      bool1 = bool2;
      if (!((File)localObject).exists()) {
        bool1 = ((File)localObject).mkdirs();
      }
      if (QLog.isColorLevel()) {
        QLog.i("FileManagerRSWorker<FileAssistant>", 2, "id[" + this.nSessionId + "]getTmpDir[" + bool1 + "]");
      }
      return this.bHI;
    }
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     attm
 * JD-Core Version:    0.7.0.1
 */