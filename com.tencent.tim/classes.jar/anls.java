import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.soload.LoadParam;
import com.tencent.mobileqq.soload.config.SoConfig.SoInfo;

class anls
  implements anmf.a
{
  anls(anlr paramanlr) {}
  
  public void a(int paramInt, SoConfig.SoInfo paramSoInfo)
  {
    this.a.dJY = paramInt;
    long l = this.a.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mReportSeq;
    StringBuilder localStringBuilder = new StringBuilder().append("is64bit=");
    if (anmb.is64Bit()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      VACDReportUtil.b(l, null, "load.item.getconfig.end", paramInt + "&v=" + anln.ku() + "&f=" + this.a.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam.mCallType, SoConfig.SoInfo.getReportCode(paramSoInfo), null);
      anlr.a(this.a, this.a.jdField_a_of_type_ComTencentMobileqqSoloadLoadParam$LoadItem, paramSoInfo);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anls
 * JD-Core Version:    0.7.0.1
 */