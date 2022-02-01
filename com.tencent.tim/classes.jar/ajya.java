import android.graphics.Paint;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import java.util.List;

public class ajya
{
  public ImageView Bp;
  public ImageView Bq;
  public ImageView Br;
  public TextView EK;
  public TextView Vg;
  public TextView fe;
  public ImageView ho;
  
  public void a(MedalInfo paramMedalInfo, int paramInt, Paint paramPaint, boolean paramBoolean)
  {
    paramInt = (int)(paramInt - (int)paramPaint.measureText(this.EK.getText().toString()) - jll.dp2px(this.EK.getContext(), 30.0F));
    this.Bq.setVisibility(8);
    this.Br.setVisibility(8);
    if ((paramMedalInfo == null) || (paramMedalInfo.DH == null) || (paramMedalInfo.DH.size() < 0))
    {
      this.fe.setMaxWidth(paramInt);
      return;
    }
    this.fe.setMaxWidth(paramInt);
  }
  
  public void gM(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (!paramString1.equals("")))
    {
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
      localSpannableStringBuilder.append("回复");
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-8947849), 0, localSpannableStringBuilder.length(), 17);
      int i = localSpannableStringBuilder.length();
      String str = paramString1;
      if (paramString1.length() > 6)
      {
        paramString1 = paramString1.substring(0, 6);
        str = paramString1 + "...";
      }
      localSpannableStringBuilder.append(str);
      localSpannableStringBuilder.append(": ");
      localSpannableStringBuilder.append(paramString2);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-16777216), i, str.length() + i, 17);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(-8947849), i + str.length(), localSpannableStringBuilder.length(), 17);
      this.Vg.setText(localSpannableStringBuilder);
      return;
    }
    setContent(paramString2);
  }
  
  public void setContent(String paramString)
  {
    this.Vg.setText(paramString);
  }
  
  public void setTime(long paramLong)
  {
    this.EK.setText(ajxp.by(1000L * paramLong));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajya
 * JD-Core Version:    0.7.0.1
 */