import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;

class aljb
  extends ClickableSpan
{
  aljb(aliz paramaliz, String paramString1, String paramString2, String paramString3) {}
  
  public void onClick(View paramView)
  {
    new alje(aliz.a(this.a).mContext).a(this.bWz).bfC();
    anot.a(aliz.a(this.a).getApp(), "dc00898", "", "", "0X800A4BB", "0X800A4BB", 0, 0, "", "", "", "");
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setUnderlineText(false);
    paramTextPaint.setTextSize(aqcx.dip2px(aliz.a(this.a).mContext, 14.0F));
    paramTextPaint.setColor(Color.parseColor("#4D94FF"));
    if (!TextUtils.isEmpty(this.bWA)) {
      paramTextPaint.setColor(Color.parseColor(this.bWA));
    }
    if (!TextUtils.isEmpty(this.bWB)) {
      paramTextPaint.setTextSize(Float.valueOf(this.bWB).floatValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aljb
 * JD-Core Version:    0.7.0.1
 */