import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class vdz
{
  public TextView a;
  
  public vdz(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131376833));
  }
  
  public void a(vvh paramvvh, vdy paramvdy)
  {
    if (TextUtils.isEmpty(paramvvh.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(vdu.a(paramvvh));
    vdu.a(this.a);
    this.a.setOnClickListener(new vea(this, paramvdy, paramvvh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdz
 * JD-Core Version:    0.7.0.1
 */