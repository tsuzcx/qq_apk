import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.DownloadParam;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class aaco
  implements EIPCResultCallback
{
  aaco(aacm paramaacm, PreloadManager.d paramd, DownloadParam paramDownloadParam) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (PreloadManager.PathResult)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_b_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$d != null) {
        this.jdField_b_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$d.onResult(i, paramEIPCResult);
      }
    }
    while (this.jdField_b_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$d == null)
    {
      int i;
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$d.onResult(1, PreloadManager.PathResult.getFailRes(this.a.url));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaco
 * JD-Core Version:    0.7.0.1
 */