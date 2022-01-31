import android.graphics.BitmapFactory;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.widget.ClearableEditText;
import mqq.observer.ServerNotifyObserver;

public class brn
  extends ServerNotifyObserver
{
  public brn(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    this.a.b = false;
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      Toast.makeText(this.a, this.a.getString(2131362820), 0).show();
    }
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey(paramString1);
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString().length() > 4)) {
      VerifyCodeActivity.a(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.a(false);
      return;
    }
    Toast.makeText(this.a, this.a.getString(2131362821), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     brn
 * JD-Core Version:    0.7.0.1
 */