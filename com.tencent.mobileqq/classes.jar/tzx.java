import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class tzx
  implements sal
{
  tzx(BridgeModule paramBridgeModule, long paramLong, String paramString) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    if (!paramList.isEmpty()) {
      tzr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_a_of_type_Long, paramList, this.jdField_a_of_type_JavaLangString, 0, "");
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.i(tzr.jdField_a_of_type_JavaLangString, 2, "getUploadingVideoList,ugcVideoList.isEmpty");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzx
 * JD-Core Version:    0.7.0.1
 */