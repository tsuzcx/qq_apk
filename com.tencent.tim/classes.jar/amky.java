import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import com.tencent.mobileqq.search.activity.ActiveEntitySearchActivity;
import com.tencent.mobileqq.search.view.QuickPinyinEditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amky
  implements View.OnClickListener
{
  public amky(ActiveEntitySearchActivity paramActiveEntitySearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.gR();
    this.this$0.C.setVisibility(8);
    this.this$0.as.setVisibility(8);
    this.this$0.b.setCursorVisible(false);
    this.this$0.b.removeTextChangedListener(this.this$0);
    if ((ActiveEntitySearchActivity.a(this.this$0) == 1) && (!TextUtils.isEmpty(this.this$0.caI)))
    {
      this.this$0.b.setText(this.this$0.caI);
      ActiveEntitySearchActivity.a(this.this$0, ActiveEntitySearchActivity.a(this.this$0));
    }
    for (;;)
    {
      this.this$0.b.addTextChangedListener(this.this$0);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.this$0.b.setText("");
      ActiveEntitySearchActivity.a(this.this$0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amky
 * JD-Core Version:    0.7.0.1
 */