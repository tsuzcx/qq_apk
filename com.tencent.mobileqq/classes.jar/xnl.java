import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.qwallet.utils.QWalletTools.TextUrlClickListener;

public final class xnl
  extends ClickableSpan
{
  public xnl(QWalletTools.TextUrlClickListener paramTextUrlClickListener, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletUtilsQWalletTools$TextUrlClickListener.a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xnl
 * JD-Core Version:    0.7.0.1
 */