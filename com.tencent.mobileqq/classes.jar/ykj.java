import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class ykj
{
  public TextView a;
  
  public ykj(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131378439));
  }
  
  public void a(zbe paramzbe, yki paramyki)
  {
    if (TextUtils.isEmpty(paramzbe.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(yke.a(paramzbe));
    yke.a(this.a);
    this.a.setOnClickListener(new ykk(this, paramyki, paramzbe));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ykj
 * JD-Core Version:    0.7.0.1
 */