import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqlc
  implements View.OnClickListener
{
  aqlc(aqla paramaqla) {}
  
  public void onClick(View paramView)
  {
    if (paramView == this.this$0.Ja) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.Ja != null) {
        this.this$0.Ja.findViewById(2131370528).setVisibility(8);
      }
      TextView localTextView = (TextView)paramView.findViewById(2131370529);
      this.this$0.UR(localTextView.getText().toString());
      paramView.findViewById(2131370528).setVisibility(0);
      this.this$0.Ja = paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqlc
 * JD-Core Version:    0.7.0.1
 */