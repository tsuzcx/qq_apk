import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;
import com.tencent.biz.common.util.ImageUtil;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class bvh
  extends Handler
{
  private boolean jdField_a_of_type_Boolean;
  
  public bvh(Share paramShare) {}
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while ((!(paramMessage.obj instanceof Bitmap)) || (this.jdField_a_of_type_Boolean));
      paramMessage = ImageUtil.a((Bitmap)paramMessage.obj, (int)(34.0F * this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_Float));
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.f.setVisibility(8);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
      this.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(paramMessage);
    } while (!QLog.isColorLevel());
    QLog.d(Share.b(), 2, "QQBrowserActivity VISIBLE -----------------------");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bvh
 * JD-Core Version:    0.7.0.1
 */