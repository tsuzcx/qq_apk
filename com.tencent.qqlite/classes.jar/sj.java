import android.graphics.Bitmap;
import com.tencent.biz.webviewplugin.Share;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

class sj
  implements Runnable
{
  sj(si paramsi, String paramString1, String paramString2, String paramString3, String paramString4, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Si.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isResume()) && (!this.jdField_a_of_type_Si.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqActivityQQBrowserActivity.isFinishing()))
    {
      if ((this.jdField_a_of_type_Si.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog != null) && (this.jdField_a_of_type_Si.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.isShowing())) {
        this.jdField_a_of_type_Si.jdField_a_of_type_ComTencentBizWebviewpluginShare.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.dismiss();
      }
      this.jdField_a_of_type_Si.jdField_a_of_type_ComTencentBizWebviewpluginShare.a(this.jdField_a_of_type_Si.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     sj
 * JD-Core Version:    0.7.0.1
 */