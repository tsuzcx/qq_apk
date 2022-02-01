import android.text.Editable;
import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.widget.ClearableEditText;

public class vrk
  implements View.OnFocusChangeListener
{
  public vrk(RegisterByNicknameAndPwdActivity paramRegisterByNicknameAndPwdActivity) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramView == RegisterByNicknameAndPwdActivity.a(this.this$0))
    {
      if (paramBoolean)
      {
        RegisterByNicknameAndPwdActivity.a(this.this$0).setSelection(RegisterByNicknameAndPwdActivity.a(this.this$0).getText().length());
        RegisterByNicknameAndPwdActivity.a(this.this$0).setVisibility(0);
        RegisterByNicknameAndPwdActivity.a(this.this$0).setVisibility(0);
        RegisterByNicknameAndPwdActivity.b(this.this$0).setVisibility(0);
      }
    }
    else {
      return;
    }
    RegisterByNicknameAndPwdActivity.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vrk
 * JD-Core Version:    0.7.0.1
 */