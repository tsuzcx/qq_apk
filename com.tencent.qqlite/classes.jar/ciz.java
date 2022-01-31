import android.os.Handler;
import android.os.Message;
import android.view.ViewGroup;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;

public class ciz
  extends Handler
{
  public ciz(PhotoCropForPortraitActivity paramPhotoCropForPortraitActivity, int paramInt1, int paramInt2) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (-1 != paramMessage.what) {
      return;
    }
    paramMessage = new RelativeLayout.LayoutParams((int)(this.jdField_a_of_type_Int * 1.257D), (int)(this.b * 1.481D));
    paramMessage.addRule(14);
    paramMessage.topMargin = (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoCropForPortraitActivity.a.getHeight() / 2 - (int)(this.b / 2 * 1.705D));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     ciz
 * JD-Core Version:    0.7.0.1
 */