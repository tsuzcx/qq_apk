import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyYAFolderTextView.b;

public class lsz
  extends ClickableSpan
  implements ReadInJoyYAFolderTextView.b, nqi
{
  private int aPF = -1;
  private int aPG = -1;
  boolean mIsPressed;
  private TextPaint mPaint;
  private View.OnClickListener onClickListener;
  private int textColor = -1;
  
  public lsz(int paramInt1, int paramInt2, int paramInt3)
  {
    this.textColor = paramInt1;
    this.aPF = paramInt2;
    this.aPG = paramInt3;
  }
  
  public void onClick(View paramView)
  {
    if (this.onClickListener != null)
    {
      this.onClickListener.onClick(paramView);
      return;
    }
    paramView.callOnClick();
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    this.onClickListener = paramOnClickListener;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    this.mIsPressed = paramBoolean;
    if (this.mPaint != null) {
      updateDrawState(this.mPaint);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    this.mPaint = paramTextPaint;
    this.mPaint.setColor(this.textColor);
    paramTextPaint = this.mPaint;
    if (this.mIsPressed) {}
    for (int i = this.aPG;; i = this.aPF)
    {
      paramTextPaint.bgColor = i;
      this.mPaint.setUnderlineText(false);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lsz
 * JD-Core Version:    0.7.0.1
 */