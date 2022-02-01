import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.inputmethod.InputMethodManager;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.TroopEggLottieAnimHelper.1;
import com.tencent.widget.XEditTextEx;

public class wxh
  implements wvs
{
  private BaseChatPie a;
  private wpe b;
  
  public wxh(BaseChatPie paramBaseChatPie)
  {
    this.a = paramBaseChatPie;
    this.b = new wpe(this.a);
  }
  
  private void cdb()
  {
    if (this.a == null) {}
    String str;
    do
    {
      return;
      str = this.a.mActivity.getIntent().getStringExtra("chat_inputBarContent");
    } while ((str == null) || (str.isEmpty()));
    this.a.a.setText(str);
    this.a.a.requestFocus();
    InputMethodManager localInputMethodManager = (InputMethodManager)this.a.mActivity.getSystemService("input_method");
    if (localInputMethodManager != null) {
      localInputMethodManager.showSoftInput(this.a.a, 1);
    }
    this.a.a.post(new TroopEggLottieAnimHelper.1(this, str));
  }
  
  public int[] C()
  {
    return new int[] { 6, 9, 13 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 6: 
      cdb();
      return;
    }
    stop();
  }
  
  public boolean c(Object... paramVarArgs)
  {
    if (this.b == null) {
      this.b = new wpe(this.a);
    }
    return this.b.i(paramVarArgs);
  }
  
  public boolean stop()
  {
    if (this.b != null) {
      this.b.stopAnim();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wxh
 * JD-Core Version:    0.7.0.1
 */