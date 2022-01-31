import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

class urd
{
  public TextView a;
  
  public urd(View paramView)
  {
    this.a = ((TextView)paramView.findViewById(2131311024));
  }
  
  public void a(vil paramvil, urc paramurc)
  {
    if (TextUtils.isEmpty(paramvil.a))
    {
      this.a.setVisibility(8);
      return;
    }
    this.a.setVisibility(0);
    this.a.setText(uqy.a(paramvil));
    uqy.a(this.a);
    this.a.setOnClickListener(new ure(this, paramurc, paramvil));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     urd
 * JD-Core Version:    0.7.0.1
 */