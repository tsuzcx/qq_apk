import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.SoLoadInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoDetailInfo;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class anlu
  extends anln
{
  public anlu(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    super(paramLoadParam, paramLoadItem);
  }
  
  private SoLoadInfo b(int paramInt)
  {
    return a(paramInt);
  }
  
  @NonNull
  public SoLoadInfo a()
  {
    if (ayq())
    {
      if (QLog.isColorLevel()) {
        QLog.i("GetSoTaskSync", 2, "not main process get loadInfo sync by IPC");
      }
      return aafv.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem);
    }
    Object localObject1 = anmf.a().a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem.name, null, true);
    long l = this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq;
    Object localObject2 = new StringBuilder().append("is64bit=");
    if (anmb.is64Bit()) {}
    for (int i = 1;; i = 0)
    {
      VACDReportUtil.b(l, null, "load.item.getconfig.end", i + "&v=" + ku() + "&f=" + this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType, SoConfig.SoInfo.getReportCode((SoConfig.SoInfo)localObject1), null);
      if (QLog.isColorLevel()) {
        QLog.i("GetSoTaskSync", 2, "[handleConfigSync] info=" + localObject1 + ",is64Bit:" + anmb.is64Bit());
      }
      if (a((SoConfig.SoInfo)localObject1)) {
        break;
      }
      return b(2);
    }
    localObject1 = anma.a(this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url);
    localObject2 = ((anmj)localObject1).mSoPath;
    if ((TextUtils.isEmpty((CharSequence)localObject2)) || (!new File((String)localObject2).exists())) {
      return b(3);
    }
    if (QLog.isColorLevel()) {
      QLog.i("GetSoTaskSync", 2, "[handleConfigSync] configSoFile exist");
    }
    if (a((String)localObject2, ((anmj)localObject1).amg, this.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo, 1))
    {
      this.ceE = ((String)localObject2);
      this.ceF = this.jdField_a_of_type_ComTencentMobileqqSoloadConfigSoConfig$SoDetailInfo.url;
      return b(0);
    }
    return b(10);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anlu
 * JD-Core Version:    0.7.0.1
 */