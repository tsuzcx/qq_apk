import android.content.Context;
import com.tencent.mobileqq.widget.AnimationTextView;

public class nsf
  extends aqju
{
  AnimationTextView a;
  
  public nsf(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    initView();
  }
  
  private void initView()
  {
    this.a = ((AnimationTextView)findViewById(2131377895));
  }
  
  public void oB(String paramString)
  {
    if (this.a != null) {
      this.a.setText(paramString);
    }
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    initView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsf
 * JD-Core Version:    0.7.0.1
 */