import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.download.WSDownloadParams;

final class ugw
  implements DialogInterface.OnClickListener
{
  ugw(Activity paramActivity, WSDownloadParams paramWSDownloadParams) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if ((paramDialogInterface instanceof ugs)) {
      ugs.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams);
    }
    for (;;)
    {
      paramDialogInterface.dismiss();
      ugs.a(125, this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams);
      unx.a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newDownloadWSDownloadParams.mScene, false, true);
      return;
      Log.e("weishi-808", "dialog type is error");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ugw
 * JD-Core Version:    0.7.0.1
 */