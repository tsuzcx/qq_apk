import android.view.View;
import android.widget.TextView;

public class zet
  extends zev
{
  TextView a;
  
  public zet(zex paramzex, View paramView)
  {
    super(paramzex, paramView);
    this.a = ((TextView)paramView.findViewById(2131378697));
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
    paramCharSequence = zem.a(this.a, 1);
    this.a.setText(paramCharSequence);
  }
  
  public void e_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundResource(2130844549);
      return;
    }
    this.a.setBackgroundResource(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zet
 * JD-Core Version:    0.7.0.1
 */