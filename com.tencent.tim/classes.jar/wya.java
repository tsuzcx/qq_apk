import android.graphics.Color;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.qphone.base.util.QLog;

class wya
  extends ClickableSpan
{
  wya(wxz paramwxz, IntimateInfo.DNAInfo paramDNAInfo) {}
  
  public void onClick(View paramView)
  {
    anot.a(null, "dc00898", "", "", "0X800A20A ", "0X800A20A ", 0, 0, "", "", "", "");
    QLog.d("Intimate report test", 2, "REPORT_TAG_0X800A20A");
    if (TextUtils.isEmpty(this.a.linkUrl))
    {
      QLog.e("intimate_relationship", 2, "linkUrl is empty");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("intimate_relationship", 2, String.format("click scheme: %s, scheme: %s", new Object[] { this.a.linkWording, this.a.linkUrl }));
    }
    paramView = aqik.c(this.this$0.mApp, this.this$0.mContext, this.a.linkUrl);
    if (paramView != null)
    {
      paramView.ace();
      return;
    }
    if (this.a.linkUrl.toLowerCase().startsWith("mqzone://"))
    {
      avpw.dp(this.this$0.mContext, this.a.linkUrl);
      return;
    }
    wxw.bk(this.this$0.mContext, this.a.linkUrl);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setUnderlineText(false);
    try
    {
      int j = Color.parseColor("#4D94FF");
      paramTextPaint.setColor(j);
      int i = j;
      if (this.a != null)
      {
        i = j;
        if (!TextUtils.isEmpty(this.a.linkColor)) {
          i = Color.parseColor(this.a.linkColor);
        }
      }
      paramTextPaint.setColor(i);
      return;
    }
    catch (IllegalArgumentException paramTextPaint)
    {
      QLog.e("intimate_relationship", 2, " color parse err");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wya
 * JD-Core Version:    0.7.0.1
 */