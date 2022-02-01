import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class zlj
  implements TextWatcher
{
  zlj(zli paramzli) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.c.v.getText().toString().trim();
    if (paramEditable.length() == 0)
    {
      this.c.bao = "";
      this.c.findViewById(2131368696).setVisibility(8);
      this.c.hO.setVisibility(8);
      this.c.a.clearData();
      this.c.footerView.setVisibility(8);
    }
    while (this.c.bao.equals(paramEditable)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("C2CMessageSearchDialog", 2, "afterTextChanged, lastChangedKeyword = " + this.c.bao + ",lastKeyWord:" + paramEditable);
    }
    this.c.bao = paramEditable;
    this.c.findViewById(2131368696).setVisibility(0);
    this.c.F.setVisibility(0);
    this.c.cpN();
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zlj
 * JD-Core Version:    0.7.0.1
 */