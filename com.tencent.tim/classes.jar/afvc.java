import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

public class afvc
  implements TextWatcher
{
  String bFJ;
  int cUK = 0;
  
  public afvc(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    int i = this.this$0.g.getLineCount();
    if (i > 30)
    {
      if (this.bFJ == null) {
        break label136;
      }
      this.this$0.g.setText(this.bFJ);
      this.this$0.g.setSelection(this.cUK);
    }
    for (;;)
    {
      if (ExtendFriendProfileEditFragment.a(this.this$0) == null) {
        ExtendFriendProfileEditFragment.a(this.this$0, QQToast.a(this.this$0.getActivity(), "输入文字不要超过30行", 0));
      }
      if (!ExtendFriendProfileEditFragment.a(this.this$0).isShowing()) {
        ExtendFriendProfileEditFragment.a(this.this$0).show();
      }
      if (i != ExtendFriendProfileEditFragment.a(this.this$0))
      {
        ExtendFriendProfileEditFragment.a(this.this$0, i);
        this.this$0.cbd = true;
      }
      return;
      label136:
      this.this$0.g.setText("");
      this.this$0.g.setSelection(0);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.g.getLineCount() <= 30)
    {
      this.bFJ = this.this$0.g.getText().toString();
      this.cUK = this.this$0.g.getSelectionStart();
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.bFI == null) {
      this.this$0.bFI = "";
    }
    if ((this.this$0.bFI.equals(paramCharSequence.toString())) && (!ExtendFriendProfileEditFragment.a(this.this$0)))
    {
      ExtendFriendProfileEditFragment.a(this.this$0);
      return;
    }
    ExtendFriendProfileEditFragment.b(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afvc
 * JD-Core Version:    0.7.0.1
 */