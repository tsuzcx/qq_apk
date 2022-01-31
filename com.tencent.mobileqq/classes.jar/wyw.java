import android.content.Intent;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity.sendPhotoTask;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pic.compress.Utils;
import com.tencent.mobileqq.utils.AlbumConstants;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class wyw
  implements Runnable
{
  public wyw(SendPhotoActivity.sendPhotoTask paramsendPhotoTask) {}
  
  public void run()
  {
    try
    {
      this.a.a();
      this.a.jdField_a_of_type_AndroidContentIntent.removeExtra("PhotoConst.SEND_BUSINESS_TYPE");
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra(AlbumConstants.h, 2);
      if (!this.a.jdField_a_of_type_AndroidContentIntent.hasExtra("extra_image_sender_tag")) {
        this.a.jdField_a_of_type_AndroidContentIntent.putExtra("extra_image_sender_tag", "SendPhotoActivity.handlePhoto");
      }
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("open_chatfragment_fromphoto", true);
      this.a.jdField_a_of_type_AndroidContentIntent.putExtra("param_selNum", this.a.jdField_b_of_type_JavaUtilArrayList.size());
      if (!this.a.jdField_c_of_type_Boolean)
      {
        ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).setResult(-1, this.a.jdField_a_of_type_AndroidContentIntent);
        ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).finish();
        ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).overridePendingTransition(0, 2131034124);
        if (!this.a.jdField_b_of_type_Boolean)
        {
          String str1 = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
          String str2 = this.a.jdField_a_of_type_AndroidContentIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
          this.a.jdField_a_of_type_AndroidContentIntent.setClassName(str2, str1);
          this.a.jdField_a_of_type_AndroidContentIntent.addFlags(603979776);
          ((BaseActivity)this.a.jdField_a_of_type_JavaLangRefWeakReference.get()).startActivity(this.a.jdField_a_of_type_AndroidContentIntent);
        }
      }
      Utils.a(BaseApplication.getContext(), this.a.jdField_c_of_type_JavaUtilArrayList);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wyw
 * JD-Core Version:    0.7.0.1
 */