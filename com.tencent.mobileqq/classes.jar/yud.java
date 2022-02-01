import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class yud
{
  public TextView a;
  
  public yud(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131378384));
  }
  
  public void a(zll paramzll, yuc paramyuc)
  {
    if (TextUtils.isEmpty(paramzll.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(yty.a(paramzll));
    yty.a(this.a);
    this.a.setOnClickListener(new yue(this, paramyuc, paramzll));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yud
 * JD-Core Version:    0.7.0.1
 */