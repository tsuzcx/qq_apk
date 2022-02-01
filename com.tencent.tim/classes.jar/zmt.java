import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.history.tendoc.TenDocMessageResultAdapter;
import com.tencent.qphone.base.util.QLog;

class zmt
  implements TextWatcher
{
  private String mLastKeyword = "";
  
  zmt(zmq paramzmq) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = paramEditable.toString().trim();
    if (TextUtils.isEmpty(paramEditable))
    {
      this.mLastKeyword = "";
      zmq.a(this.a).clearData();
      zmq.a(this.a).setVisibility(8);
      zmq.a(this.a).setVisibility(8);
      zmq.a(this.a).setVisibility(8);
    }
    while (TextUtils.equals(this.mLastKeyword, paramEditable)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TenDocMessageSearchDialog", 2, "afterTextChanged, mLastKeyword = " + this.mLastKeyword + ",lastKeyWord:" + paramEditable);
    }
    this.mLastKeyword = paramEditable;
    zmq.a(this.a).setVisibility(0);
    this.a.cpN();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zmt
 * JD-Core Version:    0.7.0.1
 */