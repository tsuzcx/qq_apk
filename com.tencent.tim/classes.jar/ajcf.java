import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

class ajcf
  extends ClickableSpan
{
  ajcf(ajcd paramajcd, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    ajcd.a(this.b, this.val$activity);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setColor(this.b.mApp.getApp().getResources().getColor(2131167312));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajcf
 * JD-Core Version:    0.7.0.1
 */