import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.FlowControlDownloadStruct;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadResource;
import java.util.LinkedList;

public class xfv
  extends Handler
{
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  
  public xfv(PreloadManager paramPreloadManager, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private void a()
  {
    PreloadManager.FlowControlDownloadStruct localFlowControlDownloadStruct = (PreloadManager.FlowControlDownloadStruct)this.jdField_a_of_type_JavaUtilLinkedList.getFirst();
    this.jdField_a_of_type_JavaUtilLinkedList.removeFirst();
    localFlowControlDownloadStruct.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadResource.handleFlowConfig(this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager, localFlowControlDownloadStruct.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadModule, localFlowControlDownloadStruct.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
    case 1: 
      do
      {
        return;
        this.jdField_a_of_type_JavaUtilLinkedList.addLast((PreloadManager.FlowControlDownloadStruct)paramMessage.obj);
      } while (this.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_Boolean = true;
      sendEmptyMessage(2);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      a();
      return;
    }
    this.jdField_a_of_type_Boolean = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xfv
 * JD-Core Version:    0.7.0.1
 */