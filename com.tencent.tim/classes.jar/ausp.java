import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashSet;

class ausp
  implements View.OnClickListener
{
  ausp(ausj paramausj) {}
  
  public void onClick(View paramView)
  {
    int i = paramView.getId();
    Object localObject;
    if ((ausj.a(this.this$0)) && ((ausj.a(this.this$0) == null) || (!ausj.a(this.this$0).contains(Integer.valueOf(i)))) && (ausj.b(this.this$0) != -1) && (i != ausj.b(this.this$0)))
    {
      localObject = (View)ausj.a(this.this$0).get(ausj.b(this.this$0));
      ((View)localObject).findViewById(2131362006).setVisibility(8);
      localObject = (TextView)((View)localObject).findViewById(2131362005);
      ausj.a(this.this$0, (TextView)localObject, false);
      localObject = (View)ausj.a(this.this$0).get(i);
      ((View)localObject).findViewById(2131362006).setVisibility(0);
      localObject = (TextView)((View)localObject).findViewById(2131362005);
      ausj.a(this.this$0, (TextView)localObject, true);
      ausj.a(this.this$0, i);
    }
    if (ausj.a(this.this$0) != null) {
      ausj.a(this.this$0).OnClick(paramView, i);
    }
    if (ausj.a(this.this$0) != null)
    {
      localObject = (TextView)paramView.findViewById(2131362005);
      if ((localObject != null) && ((localObject instanceof TextView))) {
        ausj.a(this.this$0).OnClick(paramView, i, ((TextView)localObject).getText().toString());
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausp
 * JD-Core Version:    0.7.0.1
 */