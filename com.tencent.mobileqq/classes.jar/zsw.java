import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qrcode.activity.QRDisplayActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class zsw
  extends ankx
{
  public zsw(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.a.a(paramInt);
      return;
    }
    Object localObject = this.a.jdField_a_of_type_Anks.a(this.a.jdField_c_of_type_JavaLangString, true);
    if ((localObject != null) && ((localObject instanceof BitmapDrawable))) {
      this.a.jdField_a_of_type_AndroidGraphicsBitmap = ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = this.a.getSharedPreferences("qrcode", 0).edit();
    ((SharedPreferences.Editor)localObject).putLong("discussionvalidtime" + this.a.jdField_c_of_type_JavaLangString, paramLong1);
    ((SharedPreferences.Editor)localObject).putString("discussion" + this.a.jdField_c_of_type_JavaLangString, paramString2);
    ((SharedPreferences.Editor)localObject).putString("discussionfullSig" + this.a.jdField_c_of_type_JavaLangString, paramString1);
    ((SharedPreferences.Editor)localObject).commit();
    this.a.jdField_b_of_type_Long = paramLong1;
    localObject = zvc.a(paramString2, -1);
    if (localObject != null)
    {
      ((TextView)this.a.findViewById(2131373621)).setText(paramString2);
      this.a.jdField_b_of_type_AndroidViewView.post(this.a.jdField_b_of_type_JavaLangRunnable);
      this.a.d = paramString2;
      this.a.e = paramString1;
      this.a.jdField_a_of_type_Gt = ((gt)localObject);
      this.a.h();
      return;
    }
    this.a.i();
  }
  
  protected void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      paramString = ((anks)this.a.app.a(6)).a(paramString, true);
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
      if (this.a.jdField_a_of_type_Gt == null) {
        this.a.jdField_a_of_type_Gt = this.a.a(this.a.jdField_c_of_type_JavaLangString, this.a.jdField_c_of_type_Int, -1);
      }
      if (this.a.jdField_a_of_type_Gt != null) {
        this.a.h();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsw
 * JD-Core Version:    0.7.0.1
 */