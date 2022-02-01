import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.biz.pubaccount.util.Achilles;
import com.tencent.biz.pubaccount.util.Achilles.1;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class oap
  extends adww
{
  public oap(Achilles.1 param1, RockDownloadInfo paramRockDownloadInfo, AchillesParams paramAchillesParams) {}
  
  public void a(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt)
  {
    QLog.d("Achilles", 1, "query predownload info fail: " + paramRockDownloadInfo);
    Achilles.b(this.jdField_a_of_type_ComTencentMobileqqDataRockDownloadInfo, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyConfigBeansAchillesParams);
  }
  
  public void onSuccess(ArrayList<RockDownloadInfo> paramArrayList)
  {
    QLog.d("Achilles", 1, "query predownload info success: " + paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oap
 * JD-Core Version:    0.7.0.1
 */