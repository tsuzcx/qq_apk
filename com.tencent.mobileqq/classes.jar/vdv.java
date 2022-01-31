import android.view.View;
import android.view.View.OnClickListener;

class vdv
  implements View.OnClickListener
{
  vdv(vdu paramvdu) {}
  
  public void onClick(View paramView)
  {
    vdu.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (vdu.a(this.a) != null) {
      vdu.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdv
 * JD-Core Version:    0.7.0.1
 */