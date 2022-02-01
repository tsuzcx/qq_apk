import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.interestTag.ChooseInterestTagActivity;

public class ajul
  implements TextWatcher
{
  public ajul(ChooseInterestTagActivity paramChooseInterestTagActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    ChooseInterestTagActivity.a(this.this$0).removeMessages(4097);
    ChooseInterestTagActivity.b(this.this$0, 0);
    String str;
    if (ChooseInterestTagActivity.a(this.this$0).getText() == null)
    {
      paramEditable = "";
      str = ajrk.mr(paramEditable);
      if (ChooseInterestTagActivity.a(this.this$0).getText() != null) {
        break label163;
      }
      paramEditable = "";
      label59:
      if (!TextUtils.isEmpty(paramEditable)) {
        break label185;
      }
      if (ChooseInterestTagActivity.b(this.this$0).getVisibility() != 8) {
        ChooseInterestTagActivity.b(this.this$0).setVisibility(8);
      }
      ChooseInterestTagActivity.a(this.this$0).aw(ChooseInterestTagActivity.a(this.this$0), true);
      paramEditable = this.this$0;
      if (ChooseInterestTagActivity.b(this.this$0) == -1) {
        break label180;
      }
    }
    label163:
    label180:
    for (boolean bool = true;; bool = false)
    {
      ChooseInterestTagActivity.a(paramEditable, false, bool);
      ChooseInterestTagActivity.a(this.this$0, "");
      return;
      paramEditable = ChooseInterestTagActivity.a(this.this$0).getText().toString();
      break;
      paramEditable = ChooseInterestTagActivity.a(this.this$0).getText().toString();
      break label59;
    }
    label185:
    if (TextUtils.isEmpty(str))
    {
      if (ChooseInterestTagActivity.b(this.this$0).getVisibility() != 0) {
        ChooseInterestTagActivity.b(this.this$0).setVisibility(0);
      }
      ChooseInterestTagActivity.b(this.this$0).setText(acfp.m(2131703832));
      ChooseInterestTagActivity.c(this.this$0).setVisibility(8);
      ChooseInterestTagActivity.a(this.this$0, "");
      return;
    }
    if (ChooseInterestTagActivity.b(this.this$0).getVisibility() != 0) {
      ChooseInterestTagActivity.b(this.this$0).setVisibility(0);
    }
    if (aqiw.isNetSupport(this.this$0))
    {
      ChooseInterestTagActivity.b(this.this$0).setText(acfp.m(2131703837));
      ChooseInterestTagActivity.c(this.this$0).setVisibility(8);
      ChooseInterestTagActivity.a(this.this$0, str);
      ChooseInterestTagActivity.a(this.this$0).sendEmptyMessageDelayed(4097, 400L);
      return;
    }
    if (!ChooseInterestTagActivity.c(this.this$0))
    {
      ChooseInterestTagActivity.a(this.this$0, acfp.m(2131703812));
      ChooseInterestTagActivity.a(this.this$0, true);
      ChooseInterestTagActivity.a(this.this$0).sendEmptyMessageDelayed(4100, 3000L);
    }
    ChooseInterestTagActivity.b(this.this$0).setText("");
    ChooseInterestTagActivity.b(this.this$0).setOnClickListener(null);
    ChooseInterestTagActivity.c(this.this$0).setVisibility(8);
    ChooseInterestTagActivity.a(this.this$0, "");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    ChooseInterestTagActivity.a(this.this$0, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajul
 * JD-Core Version:    0.7.0.1
 */