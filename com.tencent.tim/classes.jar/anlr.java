import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class anlr
  extends anln
{
  private static final Map<String, List<anly>> ng = new HashMap();
  
  public anlr(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private void Vf(int paramInt)
  {
    SoLoadInfo localSoLoadInfo = a(paramInt);
    synchronized (ng)
    {
      Object localObject3 = (List)ng.get(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      ng.remove(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name);
      if (localObject3 != null)
      {
        ??? = ((List)localObject3).iterator();
        while (((Iterator)???).hasNext())
        {
          localObject3 = (anly)((Iterator)???).next();
          if (localObject3 != null) {
            ((anly)localObject3).a(localSoLoadInfo);
          }
        }
      }
    }
  }
  
  private void a(LoadParam.LoadItem paramLoadItem, SoConfig.SoInfo paramSoInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] info=" + paramSoInfo + ",is64Bit:" + anmb.is64Bit());
    }
    if (!a(paramSoInfo))
    {
      Vf(2);
      return;
    }
    paramSoInfo = anma.a(paramLoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo);
    String str = paramSoInfo.mSoPath;
    long l = paramSoInfo.amg;
    if ((!TextUtils.isEmpty(str)) && (new File(str).exists()))
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] configSoFile exist");
      }
      if (a(str, l, paramLoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 1))
      {
        this.ceE = str;
        this.ceF = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url;
        Vf(0);
        return;
      }
      Vf(10);
      return;
    }
    paramSoInfo = new DownloadParam();
    paramSoInfo.filePos = 1;
    paramSoInfo.url = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url;
    paramSoInfo.md5ForChecked = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.md5;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "[handleConfig] configSoFile not exist");
    }
    VACDReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.download.start", null, 0, null);
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType == LoadParam.CALL_TYPE_ASYNC_BY_SYNC) {
      paramSoInfo.isPreDownload = true;
    }
    PreloadManager.a().a(paramSoInfo, new anlt(this, paramLoadItem, paramSoInfo));
  }
  
  private boolean a(anly paramanly)
  {
    synchronized (ng)
    {
      Object localObject = ng.entrySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
        String str = (String)localEntry.getKey();
        if ((!TextUtils.isEmpty(str)) && (TextUtils.equals(str, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name)))
        {
          ((List)localEntry.getValue()).add(paramanly);
          return true;
        }
      }
      localObject = new LinkedList();
      ((List)localObject).add(paramanly);
      ng.put(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, localObject);
      return false;
    }
  }
  
  public void a(anly paramanly)
  {
    if (ayq())
    {
      if (QLog.isColorLevel()) {
        QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "not main process get loadInfo by IPC");
      }
      aafv.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, paramanly);
    }
    do
    {
      return;
      if (!a(paramanly)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("SoLoadWidget.GetSoTaskAsync", 2, "insert into same req list");
    return;
    VACDReportUtil.b(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq, null, "load.item.getconfig.start", this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, 0, null);
    anmf.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, new anls(this), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlr
 * JD-Core Version:    0.7.0.1
 */