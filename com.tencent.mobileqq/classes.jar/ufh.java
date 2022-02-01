import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.pubaccount.NativeAd.report.JumpMode;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.event.DownloadClickState;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"}, k=3, mv={1, 1, 16})
final class ufh
  implements DialogInterface.OnClickListener
{
  ufh(AdvertisementInfo paramAdvertisementInfo, ule paramule, RIJDownloadView paramRIJDownloadView) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (paramInt != 1)
    {
      ueb.a(JumpMode.UNKNOWN, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, 10, "2");
      return;
    }
    paramDialogInterface = this.jdField_a_of_type_Ule;
    if (paramDialogInterface != null)
    {
      paramDialogInterface = ufc.a(paramDialogInterface);
      if (paramDialogInterface != null) {
        paramDialogInterface.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView, this.jdField_a_of_type_Ule);
      }
    }
    paramDialogInterface = ufd.a;
    Context localContext = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdCommon_ad_downloadViewRIJDownloadView.getContext();
    Intrinsics.checkExpressionValueIsNotNull(localContext, "view.context");
    ufd.a(paramDialogInterface, localContext, DownloadClickState.START_DOWNLOAD, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructAdvertisementInfo, null, 8, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ufh
 * JD-Core Version:    0.7.0.1
 */