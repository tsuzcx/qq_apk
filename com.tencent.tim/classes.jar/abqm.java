import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abqm
  implements View.OnClickListener
{
  abqm(abql paramabql) {}
  
  public void onClick(View paramView)
  {
    if (abql.a(this.this$0) == null)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    boolean bool = abql.a(this.this$0).YX();
    label63:
    abql localabql;
    if (bool)
    {
      abql.a(this.this$0).setImageDrawable(abql.a(this.this$0).getContext().getResources().getDrawable(2130838576));
      localabql = this.this$0;
      if (bool) {
        break label133;
      }
    }
    label133:
    for (bool = true;; bool = false)
    {
      abql.a(localabql, bool);
      abql.a(this.this$0).setMute(abql.a(this.this$0));
      break;
      abql.a(this.this$0).setImageDrawable(abql.a(this.this$0).getContext().getResources().getDrawable(2130838575));
      break label63;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abqm
 * JD-Core Version:    0.7.0.1
 */