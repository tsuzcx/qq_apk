import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.google.zxing.common.BitMatrix;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.biz.qrcode.util.QRUtils;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class pt
  extends DiscussionObserver
{
  public pt(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(QRDisplayActivity.jdField_a_of_type_JavaLangString, 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(paramInt);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.a.h, true);
    if ((localObject != null) && ((localObject instanceof BitmapDrawable))) {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = this.a.getSharedPreferences("qrcode", 0).edit();
    ((SharedPreferences.Editor)localObject).putLong("discussionvalidtime" + this.a.h, paramLong);
    ((SharedPreferences.Editor)localObject).putString("discussion" + this.a.h, paramString2);
    ((SharedPreferences.Editor)localObject).putString("discussionfullSig" + this.a.h, paramString1);
    ((SharedPreferences.Editor)localObject).commit();
    this.a.jdField_b_of_type_Long = paramLong;
    localObject = QRUtils.a(paramString2, -1);
    if (localObject != null)
    {
      ((TextView)this.a.findViewById(2131297812)).setText(paramString2);
      this.a.jdField_e_of_type_AndroidViewView.setVisibility(0);
      if (this.a.f != 540)
      {
        ViewGroup.LayoutParams localLayoutParams = this.a.jdField_e_of_type_AndroidViewView.getLayoutParams();
        if (localLayoutParams != null)
        {
          localLayoutParams.width = (this.a.f + (int)(2.0F * QRDisplayActivity.a(this.a)));
          this.a.jdField_e_of_type_AndroidViewView.setLayoutParams(localLayoutParams);
        }
      }
      this.a.jdField_b_of_type_AndroidViewView.post(this.a.jdField_b_of_type_JavaLangRunnable);
      this.a.i = paramString2;
      this.a.j = paramString1;
      this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = ((BitMatrix)localObject);
      this.a.c();
      return;
    }
    this.a.d();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      paramString = ((DiscussionHandler)this.a.app.a(6)).a(paramString, true);
      if ((paramString instanceof BitmapDrawable)) {
        this.a.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)paramString).getBitmap();
      }
      if (this.a.jdField_a_of_type_AndroidOsBundle == null)
      {
        this.a.jdField_a_of_type_AndroidOsBundle = new Bundle();
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("bkgRes", 0);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("nameClr", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("tipsClr", -8947849);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("B", -16777216);
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("W", 16777215);
        this.a.jdField_a_of_type_AndroidOsBundle.putParcelable("qrloc", new Rect(45, 76, 495, 526));
        this.a.jdField_a_of_type_AndroidOsBundle.putInt("head", 1);
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix == null) {
        this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix = this.a.a(this.a.h, this.a.jdField_e_of_type_Int, -1);
      }
      if (this.a.jdField_a_of_type_ComGoogleZxingCommonBitMatrix != null) {
        this.a.c();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     pt
 * JD-Core Version:    0.7.0.1
 */