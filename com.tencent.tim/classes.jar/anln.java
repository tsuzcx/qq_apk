import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.IOUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import mqq.app.AppRuntime;

class anln
{
  private static final Map<String, Object> ne = new HashMap();
  LoadParam.LoadItem jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem;
  LoadParam jdField_a_of_type_ComTencentMobileqqSoloadLoadParam;
  SoConfig.SoDetailInfo jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo;
  boolean cIp = false;
  String ceE;
  String ceF;
  String ceG;
  int dJY;
  
  anln(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam = paramLoadParam;
    this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem = paramLoadItem;
  }
  
  static boolean a(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoConfig.SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    Object localObject;
    for (;;)
    {
      boolean bool;
      synchronized (ne)
      {
        localObject = ne.get(paramLoadItem.name);
        if (localObject == null)
        {
          localObject = new byte[0];
          ne.put(paramLoadItem.name, localObject);
        }
      }
    }
  }
  
  static boolean ayq()
  {
    return !(BaseApplicationImpl.getApplication().peekAppRuntime() instanceof QQAppInterface);
  }
  
  private static boolean b(String paramString, long paramLong, LoadParam.LoadItem paramLoadItem, SoConfig.SoDetailInfo paramSoDetailInfo, int paramInt)
  {
    if ((paramLong == -1L) && (paramSoDetailInfo.crc == -1L)) {
      return true;
    }
    long l1;
    boolean bool2;
    long l2;
    label142:
    boolean bool3;
    label158:
    int i;
    boolean bool1;
    if (paramSoDetailInfo.crc != -1L)
    {
      l1 = paramSoDetailInfo.crc;
      bool2 = true;
      l2 = IOUtil.getCRC32Value(new File(paramString));
      if (l1 == l2) {
        break label421;
      }
      anma.a(paramLoadItem);
      paramString = new DownloadParam();
      paramString.filePos = 1;
      paramString.url = paramSoDetailInfo.url;
      paramString.md5ForChecked = paramSoDetailInfo.md5;
      PreloadManager.PathResult localPathResult = PreloadManager.a(paramString);
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.folderPath))) {
        break label376;
      }
      paramString = new File(localPathResult.folderPath, paramLoadItem.soFileName).getAbsolutePath();
      if ((localPathResult == null) || (!localPathResult.retryUnzip())) {
        break label382;
      }
      bool3 = true;
      i = 0;
      if (!bool3) {
        break label403;
      }
      paramLong = IOUtil.getCRC32Value(new File(paramString));
      if (!bool2) {
        break label397;
      }
      if (paramLong != l1) {
        break label388;
      }
      bool1 = true;
      label193:
      if (i == 0) {
        break label423;
      }
      if ((localPathResult == null) || (TextUtils.isEmpty(localPathResult.filePath))) {
        break label416;
      }
      paramString = MD5Coding.encodeFile2HexStr(localPathResult.filePath);
      label223:
      if ((TextUtils.isEmpty(paramSoDetailInfo.md5)) || (paramSoDetailInfo.md5.equalsIgnoreCase(paramString))) {
        break label423;
      }
      PreloadManager.e(paramSoDetailInfo.url, false, 1);
    }
    label388:
    label397:
    label403:
    label416:
    label421:
    label423:
    for (boolean bool4 = false;; bool4 = true)
    {
      VACDReportUtil.a(paramLoadItem.name + "_" + paramSoDetailInfo.ver, "qqwallet", "SoLoadCRC", l2 + "_" + l1 + "_" + bool3 + "_" + paramLong + "_" + bool2 + "_" + bool4, null, paramInt, null);
      return bool1;
      bool2 = false;
      l1 = paramLong;
      break;
      label376:
      paramString = "";
      break label142;
      label382:
      bool3 = false;
      break label158;
      i = 1;
      bool1 = false;
      break label193;
      bool1 = true;
      break label193;
      i = 1;
      bool1 = false;
      paramLong = -1L;
      break label193;
      paramString = null;
      break label223;
      return true;
    }
  }
  
  static int ku()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if (!(localAppRuntime instanceof QQAppInterface)) {
      return 0;
    }
    return aeif.a().q(526, ((QQAppInterface)localAppRuntime).getCurrentAccountUin());
  }
  
  @NonNull
  SoLoadInfo a(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = new SoLoadInfo();
    localSoLoadInfo.curCode = paramInt;
    localSoLoadInfo.curLoadVer = this.ceG;
    localSoLoadInfo.configSoUrl = this.ceF;
    localSoLoadInfo.pathToLoad = this.ceE;
    localSoLoadInfo.subErrCode = this.dJY;
    localSoLoadInfo.isFinishDownload = this.cIp;
    return localSoLoadInfo;
  }
  
  boolean a(SoConfig.SoInfo paramSoInfo)
  {
    if (paramSoInfo != null)
    {
      if (anmb.is64Bit())
      {
        paramSoInfo = paramSoInfo.arm64Info;
        this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo = paramSoInfo;
      }
    }
    else {
      if ((this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url))) {
        break label100;
      }
    }
    label100:
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.AbsGetSoTask", 2, "[initConfig] isConfigValid=" + bool);
      }
      if (bool) {
        this.ceG = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.ver;
      }
      return bool;
      paramSoInfo = paramSoInfo.arm32Info;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anln
 * JD-Core Version:    0.7.0.1
 */