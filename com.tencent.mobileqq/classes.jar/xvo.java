import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class xvo
{
  public TextView a;
  
  public xvo(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131378151));
  }
  
  public void a(yml paramyml, xvn paramxvn)
  {
    if (TextUtils.isEmpty(paramyml.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(xvj.a(paramyml));
    xvj.a(this.a);
    this.a.setOnClickListener(new xvp(this, paramxvn, paramyml));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvo
 * JD-Core Version:    0.7.0.1
 */