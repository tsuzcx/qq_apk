import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

class aksm
  implements View.OnClickListener
{
  aksm(aksl paramaksl) {}
  
  public void onClick(View paramView)
  {
    if (aksl.a(this.b).size() > 10) {
      QQToast.a(aksl.a(this.b), 1, 2131690687, 1).show();
    }
    while (aksl.a(this.b) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (aksl.a(this.b).size() > 1) {}
    for (int i = aksl.a(this.b).size() - 1;; i = 0)
    {
      AutoReplyText localAutoReplyText = new AutoReplyText("", i);
      localAutoReplyText.getExtra().putBoolean("addFlag", true);
      aksl.a(this.b).b(localAutoReplyText, false);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aksm
 * JD-Core Version:    0.7.0.1
 */