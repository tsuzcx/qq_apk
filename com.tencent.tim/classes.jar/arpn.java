import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.open.agent.AuthorityControlFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class arpn
  implements View.OnClickListener
{
  public arpn(AuthorityControlFragment paramAuthorityControlFragment) {}
  
  public void onClick(View paramView)
  {
    AuthorityControlFragment.a(this.this$0).elI();
    AuthorityControlFragment.a(this.this$0, this.this$0.rightViewText, 2131690649);
    this.this$0.rightViewText.setTextColor(AuthorityControlFragment.a(this.this$0));
    this.this$0.rightViewText.setEnabled(true);
    this.this$0.setLeftButton("", null);
    this.this$0.leftView.setVisibility(0);
    AuthorityControlFragment.a(this.this$0).setText(2131690661);
    AuthorityControlFragment.a(this.this$0).setOverScrollHeader(AuthorityControlFragment.a(this.this$0));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpn
 * JD-Core Version:    0.7.0.1
 */