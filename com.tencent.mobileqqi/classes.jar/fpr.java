import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.filemanager.activity.CloudFileBrowserActivity;
import com.tencent.mobileqq.widget.GridListView;
import com.tencent.mobileqq.widget.SlideDetectListView;

public class fpr
  extends Handler
{
  public fpr(CloudFileBrowserActivity paramCloudFileBrowserActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      super.handleMessage(paramMessage);
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetSlideDetectListView.B();
    this.a.jdField_a_of_type_ComTencentMobileqqWidgetGridListView.B();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     fpr
 * JD-Core Version:    0.7.0.1
 */