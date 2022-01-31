import android.view.View;
import android.view.View.OnClickListener;

class wsk
  implements View.OnClickListener
{
  wsk(wsj paramwsj) {}
  
  public void onClick(View paramView)
  {
    wsj.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (wsj.a(this.a) != null) {
      wsj.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wsk
 * JD-Core Version:    0.7.0.1
 */