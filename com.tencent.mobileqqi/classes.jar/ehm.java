import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.language.SelectTransLangActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class ehm
  implements View.OnClickListener
{
  public ehm(SelectTransLangActivity paramSelectTransLangActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, QQBrowserActivity.class);
    paramView.putExtra("uin", this.a.b.a());
    paramView.putExtra("url", "http://m.fanyi.qq.com/intro/?ADTAG=iqq");
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ehm
 * JD-Core Version:    0.7.0.1
 */