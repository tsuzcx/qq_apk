import android.view.View;
import android.widget.TextView;

public class vza
  extends vzc
{
  TextView a;
  
  public vza(vze paramvze, View paramView)
  {
    super(paramvze, paramView);
    this.a = ((TextView)paramView.findViewById(2131377067));
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
    paramCharSequence = vyt.a(this.a, 1);
    this.a.setText(paramCharSequence);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundResource(2130843781);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vza
 * JD-Core Version:    0.7.0.1
 */