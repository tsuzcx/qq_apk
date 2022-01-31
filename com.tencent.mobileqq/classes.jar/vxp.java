import android.graphics.Color;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class vxp
  extends vox
{
  vxp(vxo paramvxo) {}
  
  public void d()
  {
    super.d();
    if (bngs.b(this.a.b()))
    {
      LinearLayout localLinearLayout = (LinearLayout)this.a.a().a.findViewById(2131363407);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localLinearLayout.getLayoutParams();
      localLayoutParams.height = vxo.a(this.a);
      if (!azgq.a(this.a.a.getContext())) {
        localLinearLayout.setBackgroundColor(Color.parseColor("#181818"));
      }
      localLinearLayout.setLayoutParams(localLayoutParams);
    }
  }
  
  public void g()
  {
    super.g();
    vxo.a(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxp
 * JD-Core Version:    0.7.0.1
 */