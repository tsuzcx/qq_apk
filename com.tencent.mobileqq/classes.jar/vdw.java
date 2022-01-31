import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class vdw
{
  public TextView a;
  
  public vdw(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131376835));
  }
  
  public void a(vve paramvve, vdv paramvdv)
  {
    if (TextUtils.isEmpty(paramvve.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(vdr.a(paramvve));
    vdr.a(this.a);
    this.a.setOnClickListener(new vdx(this, paramvdv, paramvve));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdw
 * JD-Core Version:    0.7.0.1
 */