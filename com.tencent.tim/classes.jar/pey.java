import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.widget.TextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.a;
import com.tencent.biz.qqcircle.widgets.QCircleExpandableTextView.b;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class pey
  implements View.OnClickListener
{
  public pey(QCircleExpandableTextView paramQCircleExpandableTextView) {}
  
  public void onClick(View paramView)
  {
    Object localObject = this.this$0;
    boolean bool;
    if (!this.this$0.azO)
    {
      bool = true;
      ((QCircleExpandableTextView)localObject).azO = bool;
      if (!this.this$0.azO) {
        break label144;
      }
      this.this$0.wn.setText(this.this$0.asH);
      if (this.this$0.a != null) {
        this.this$0.a.ro(false);
      }
    }
    for (localObject = new QCircleExpandableTextView.a(this.this$0, this.this$0.getHeight(), this.this$0.bij, null);; localObject = new QCircleExpandableTextView.a(this.this$0, this.this$0.getHeight(), this.this$0.bii + this.this$0.lastHeight, null))
    {
      ((QCircleExpandableTextView.a)localObject).setFillAfter(true);
      ((QCircleExpandableTextView.a)localObject).setAnimationListener(new pez(this));
      this.this$0.clearAnimation();
      this.this$0.startAnimation((Animation)localObject);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = false;
      break;
      label144:
      this.this$0.wn.setText(this.this$0.asG);
      if (this.this$0.a != null) {
        this.this$0.a.ro(true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pey
 * JD-Core Version:    0.7.0.1
 */