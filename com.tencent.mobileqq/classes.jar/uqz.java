import android.view.View;
import android.view.View.OnClickListener;

class uqz
  implements View.OnClickListener
{
  uqz(uqy paramuqy) {}
  
  public void onClick(View paramView)
  {
    uqy.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (uqy.a(this.a) != null) {
      uqy.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uqz
 * JD-Core Version:    0.7.0.1
 */