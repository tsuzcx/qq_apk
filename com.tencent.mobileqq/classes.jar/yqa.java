import android.view.View;
import android.widget.TextView;

public class yqa
  extends yqc
{
  TextView a;
  
  public yqa(yqe paramyqe, View paramView)
  {
    super(paramyqe, paramView);
    this.a = ((TextView)paramView.findViewById(2131378406));
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
    paramCharSequence = ypt.a(this.a, 1);
    this.a.setText(paramCharSequence);
  }
  
  public void e_(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.a.setBackgroundResource(2130844482);
      return;
    }
    this.a.setBackgroundResource(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqa
 * JD-Core Version:    0.7.0.1
 */