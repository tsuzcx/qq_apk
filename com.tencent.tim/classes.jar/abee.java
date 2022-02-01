import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class abee
  implements View.OnClickListener
{
  abee(abec paramabec) {}
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if (!(localObject instanceof abec.b)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localObject = (abec.b)localObject;
      if ((((abec.b)localObject).e != null) && (this.b.a != null)) {
        this.b.a.a(((abec.b)localObject).e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abee
 * JD-Core Version:    0.7.0.1
 */