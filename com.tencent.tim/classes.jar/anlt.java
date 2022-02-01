import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anlt
  implements PreloadManager.d
{
  anlt(anlr paramanlr, LoadParam.LoadItem paramLoadItem, DownloadParam paramDownloadParam) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] download resCode=" + paramInt + ",pathRes=" + paramPathResult);
    }
    VACDReportUtil.b(this.a.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.download.end", "sc=" + paramPathResult.subErrCode, paramInt, null);
    this.a.dJY = paramPathResult.subErrCode;
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath)))
    {
      this.a.cIp = true;
      paramPathResult = new File(paramPathResult.folderPath, this.b.soFileName).getAbsolutePath();
      if (anln.a(paramPathResult, this.a.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.crc, this.b, this.a.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 2))
      {
        this.a.ceE = paramPathResult;
        this.a.ceF = this.c.url;
        anlr.a(this.a, 0);
        return;
      }
      anlr.a(this.a, 10);
      return;
    }
    if (paramInt == 2)
    {
      anlr.a(this.a, 4);
      return;
    }
    if (paramPathResult.subErrCode == 404)
    {
      anlr.a(this.a, 9);
      return;
    }
    anlr.a(this.a, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlt
 * JD-Core Version:    0.7.0.1
 */