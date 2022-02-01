import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class tmi
  implements rnw
{
  tmi(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Iterator localIterator = paramList.iterator();
    UgcVideo localUgcVideo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localUgcVideo = (UgcVideo)localIterator.next();
    } while (!TextUtils.equals(localUgcVideo.seqId, this.jdField_a_of_type_JavaLangString));
    for (;;)
    {
      if (localUgcVideo != null)
      {
        odq.a("0X800AC61", rha.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.publicType).a());
        rno.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(localUgcVideo);
        tmd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
      tmd.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
      return;
      localUgcVideo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tmi
 * JD-Core Version:    0.7.0.1
 */