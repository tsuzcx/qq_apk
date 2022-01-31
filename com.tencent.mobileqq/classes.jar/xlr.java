import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.OnGetPathListener;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class xlr
  implements EIPCResultCallback
{
  public xlr(PreloadManagerProxy paramPreloadManagerProxy, PreloadManager.OnGetPathListener paramOnGetPathListener, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      i = paramEIPCResult.data.getInt("result_code");
      paramEIPCResult = (PreloadManager.PathResult)paramEIPCResult.data.getSerializable("path_result");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener.onResult(i, paramEIPCResult);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener == null)
    {
      int i;
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener.onResult(1, PreloadManager.PathResult.getFailRes(this.jdField_a_of_type_JavaLangString));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xlr
 * JD-Core Version:    0.7.0.1
 */