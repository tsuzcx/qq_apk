import android.view.View;
import android.view.View.OnClickListener;

class wwt
  implements View.OnClickListener
{
  wwt(wws paramwws) {}
  
  public void onClick(View paramView)
  {
    wws.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (wws.a(this.a) != null) {
      wws.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwt
 * JD-Core Version:    0.7.0.1
 */