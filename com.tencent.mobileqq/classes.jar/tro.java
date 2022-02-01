import android.content.Context;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.AnimationTextView;

public class tro
  extends QQCustomDialog
{
  AnimationTextView a;
  
  public tro(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    a();
  }
  
  private void a()
  {
    this.a = ((AnimationTextView)findViewById(2131377249));
  }
  
  public void a(String paramString)
  {
    if (this.a != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tro
 * JD-Core Version:    0.7.0.1
 */