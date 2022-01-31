import android.graphics.BitmapFactory;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity2;
import mqq.observer.ServerNotifyObserver;

public class dur
  extends ServerNotifyObserver
{
  public dur(VerifyCodeActivity2 paramVerifyCodeActivity2) {}
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_AndroidWidgetEditText.setText("");
      Toast.makeText(this.a, this.a.getString(2131563159), 0).show();
    }
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey(paramString1);
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if ((this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString() != null) && (this.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().length() > 4)) {
      VerifyCodeActivity2.a(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapFactory.decodeByteArray(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.a(false);
      return;
    }
    Toast.makeText(this.a, this.a.getString(2131561431), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     dur
 * JD-Core Version:    0.7.0.1
 */