import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class wwx
{
  public TextView a;
  
  public wwx(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131377403));
  }
  
  public void a(xof paramxof, www paramwww)
  {
    if (TextUtils.isEmpty(paramxof.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(wws.a(paramxof));
    wws.a(this.a);
    this.a.setOnClickListener(new wwy(this, paramwww, paramxof));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwx
 * JD-Core Version:    0.7.0.1
 */