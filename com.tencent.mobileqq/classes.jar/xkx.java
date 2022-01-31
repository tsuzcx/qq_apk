import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;

class xkx
  extends ClickableSpan
{
  xkx(xkv paramxkv, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (BaseActivity.sTopActivity == null) {
      return;
    }
    paramView = new Intent(BaseActivity.sTopActivity, QQBrowserActivity.class);
    paramView.putExtra("url", this.jdField_a_of_type_JavaLangString);
    paramView.putExtra("startOpenPageTime", System.currentTimeMillis());
    BaseActivity.sTopActivity.startActivityForResult(paramView, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xkx
 * JD-Core Version:    0.7.0.1
 */