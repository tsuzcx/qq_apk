import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mobileqq.activity.VerifyCodeActivity;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.mobileqq.widget.QQToast;
import mqq.observer.ServerNotifyObserver;

public class udo
  extends ServerNotifyObserver
{
  public udo(VerifyCodeActivity paramVerifyCodeActivity) {}
  
  public void onReceiveVerifyCode(String paramString1, int paramInt, String paramString2, byte[] paramArrayOfByte)
  {
    this.a.b = false;
    if (this.a.jdField_a_of_type_Boolean)
    {
      this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.setText("");
      QQToast.a(this.a.getApplicationContext(), 1, this.a.getString(2131433048), 0).a();
    }
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setKey(paramString1);
    this.a.jdField_a_of_type_MqqObserverServerNotifyObserver.setSeq(paramInt);
    this.a.jdField_a_of_type_AndroidWidgetTextView.setEnabled(true);
    if ((this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString() != null) && (this.a.jdField_a_of_type_ComTencentMobileqqWidgetClearableEditText.getText().toString().length() > 4)) {
      VerifyCodeActivity.a(this.a, true);
    }
    if (paramArrayOfByte != null)
    {
      this.a.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(BitmapManager.a(paramArrayOfByte, 0, paramArrayOfByte.length));
      this.a.a(false);
      return;
    }
    Toast.makeText(this.a.getApplicationContext(), this.a.getString(2131433049), 1).show();
  }
  
  public void onVerifyClose()
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     udo
 * JD-Core Version:    0.7.0.1
 */