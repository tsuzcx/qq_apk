import android.view.View;
import android.view.View.OnClickListener;

class vds
  implements View.OnClickListener
{
  vds(vdr paramvdr) {}
  
  public void onClick(View paramView)
  {
    vdr.a(this.a, false);
    this.a.notifyDataSetChanged();
    if (vdr.a(this.a) != null) {
      vdr.a(this.a).f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vds
 * JD-Core Version:    0.7.0.1
 */