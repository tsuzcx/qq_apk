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

public class ruw
  extends acdv
{
  public ruw(QRDisplayActivity paramQRDisplayActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QRDisplayActivity", 2, "onGetFlyTicket: " + paramBoolean);
    }
    if (!paramBoolean)
    {
      this.this$0.xZ(paramInt);
      return;
    }
    Object localObject = this.this$0.jdField_a_of_type_Acdt.a(this.this$0.uin, true);
    if ((localObject != null) && ((localObject instanceof BitmapDrawable))) {
      this.this$0.cT = ((BitmapDrawable)localObject).getBitmap();
    }
    localObject = this.this$0.getSharedPreferences("qrcode", 0).edit();
    ((SharedPreferences.Editor)localObject).putLong("discussionvalidtime" + this.this$0.uin, paramLong1);
    ((SharedPreferences.Editor)localObject).putString("discussion" + this.this$0.uin, paramString2);
    ((SharedPreferences.Editor)localObject).putString("discussionfullSig" + this.this$0.uin, paramString1);
    ((SharedPreferences.Editor)localObject).commit();
    this.this$0.mValidTime = paramLong1;
    localObject = rwt.a(paramString2, -1);
    if (localObject != null)
    {
      ((TextView)this.this$0.findViewById(2131374349)).setText(paramString2);
      this.this$0.pm.post(this.this$0.dz);
      this.this$0.aCs = paramString2;
      this.this$0.aCt = paramString1;
      this.this$0.jdField_a_of_type_Lk = ((lk)localObject);
      this.this$0.bwD();
      return;
    }
    this.this$0.bwE();
  }
  
  protected void d(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if (paramBoolean1)
    {
      paramString = ((acdt)this.this$0.app.getBusinessHandler(6)).a(paramString, true);
      if ((paramString instanceof BitmapDrawable)) {
        this.this$0.cT = ((BitmapDrawable)paramString).getBitmap();
      }
      if (this.this$0.O == null)
      {
        this.this$0.O = new Bundle();
        this.this$0.O.putInt("bkgRes", 0);
        this.this$0.O.putInt("nameClr", -16777216);
        this.this$0.O.putInt("tipsClr", -8947849);
        this.this$0.O.putInt("B", -16777216);
        this.this$0.O.putInt("W", 16777215);
        this.this$0.O.putParcelable("qrloc", new Rect(45, 76, 495, 526));
        this.this$0.O.putInt("head", 1);
      }
      if (this.this$0.jdField_a_of_type_Lk == null) {
        this.this$0.jdField_a_of_type_Lk = this.this$0.b(this.this$0.uin, this.this$0.type, -1);
      }
      if (this.this$0.jdField_a_of_type_Lk != null) {
        this.this$0.bwD();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ruw
 * JD-Core Version:    0.7.0.1
 */