import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.Iterator;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class tzu
  implements sal
{
  tzu(String paramString1, QQAppInterface paramQQAppInterface, int paramInt1, BridgeModule paramBridgeModule, int paramInt2, String paramString2) {}
  
  public void a(@NotNull List<UgcVideo> paramList)
  {
    Object localObject = paramList.iterator();
    UgcVideo localUgcVideo;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localUgcVideo = (UgcVideo)((Iterator)localObject).next();
    } while (!TextUtils.equals(localUgcVideo.seqId, this.jdField_a_of_type_JavaLangString));
    for (;;)
    {
      if (localUgcVideo != null)
      {
        localObject = rth.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Int, localUgcVideo.publicType).a();
        if (localUgcVideo.status == UgcVideo.STATUS_PAUSE) {
          olh.a("0X800AC62", (String)localObject);
        }
        while ((NetworkUtil.isMobileNetWork(BaseApplicationImpl.getContext())) && (BaseActivity.sTopActivity != null))
        {
          long l = rth.a(localUgcVideo);
          if (l > 0L)
          {
            rth.a(BaseActivity.sTopActivity, l, new tzv(this, localUgcVideo, paramList), null);
            return;
            if (localUgcVideo.status == UgcVideo.STATUS_FAILED) {
              olh.a("0X800AC63", (String)localObject);
            }
          }
          else
          {
            sad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
            tzr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
            return;
          }
        }
        sad.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a(localUgcVideo, true);
        tzr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, 0, "");
        return;
      }
      tzr.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule, this.jdField_b_of_type_Int, paramList, this.jdField_b_of_type_JavaLangString, -1, "ugcVideo not exist");
      return;
      localUgcVideo = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tzu
 * JD-Core Version:    0.7.0.1
 */