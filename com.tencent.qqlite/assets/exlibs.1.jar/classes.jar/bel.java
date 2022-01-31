import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.mobileqq.richstatus.StatusManager;

public class bel
  implements View.OnClickListener
{
  public bel(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    if (QQSetting.a(this.a) == null) {}
    while (QQSetting.a(this.a).a()) {
      return;
    }
    paramView = new Intent(this.a.a(), EditActivity.class);
    paramView.putExtra("k_source", 0);
    this.a.a(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bel
 * JD-Core Version:    0.7.0.1
 */