import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class zlu
  implements TextWatcher
{
  zlu(zlt paramzlt) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.b.v.getText().toString().trim();
    if (paramEditable.length() == 0)
    {
      this.b.bao = "";
      this.b.findViewById(2131368696).setVisibility(8);
      this.b.hO.setVisibility(8);
      this.b.a.clearData();
      this.b.footerView.setVisibility(8);
    }
    while (this.b.bao.equals(paramEditable)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("LinkMessageSearchDialog", 2, "afterTextChanged, lastChangedKeyword = " + this.b.bao + ",lastKeyWord:" + paramEditable);
    }
    this.b.bao = paramEditable;
    this.b.findViewById(2131368696).setVisibility(0);
    this.b.F.setVisibility(0);
    this.b.cpN();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlu
 * JD-Core Version:    0.7.0.1
 */