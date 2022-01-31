import android.view.View;
import android.widget.TextView;

public class xnp
  extends xnr
{
  TextView a;
  
  public xnp(xnt paramxnt, View paramView)
  {
    super(paramxnt, paramView);
    this.a = ((TextView)paramView.findViewById(2131377590));
    this.a.setMaxLines(1);
    this.a.setSingleLine();
  }
  
  public CharSequence a()
  {
    return this.a.getText();
  }
  
  public void a(CharSequence paramCharSequence)
  {
    paramCharSequence = paramCharSequence.toString();
    this.a.setText(paramCharSequence);
    paramCharSequence = xni.a(this.a, 1);
    this.a.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundResource(2130844125);
      return;
    }
    this.a.setBackgroundResource(0);
  }
  
  public CharSequence b()
  {
    return this.a.getHint();
  }
  
  public void b(CharSequence paramCharSequence)
  {
    this.a.setHint(paramCharSequence);
    this.a.setGravity(17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnp
 * JD-Core Version:    0.7.0.1
 */