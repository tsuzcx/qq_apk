import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdGameGiftUtil.showGiftDialog.1.1;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class ufk
  implements DialogInterface.OnClickListener
{
  ufk(ufj paramufj) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt == 0)
    {
      paramDialogInterface.dismiss();
      ueb.a(JumpMode.UNKNOWN, this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 10, (String)this.a.a.a.element);
      return;
    }
    ufi.a(ufi.a, this.a.a.this$0.jdField_a_of_type_AndroidContentContext, this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, this.a.a.this$0.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.a.a.this$0.jdField_a_of_type_Ule);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufk
 * JD-Core Version:    0.7.0.1
 */