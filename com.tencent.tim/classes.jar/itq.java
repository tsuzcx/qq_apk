import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class itq
{
  private static int retCode = 0;
  private static String tips = "";
  
  public static SpannableStringBuilder a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString1);
    int i = paramString1.indexOf(paramString2);
    if (i != -1) {
      localSpannableStringBuilder.setSpan(new itq.a(paramContext, paramString3), i, paramString2.length() + i, 33);
    }
    return localSpannableStringBuilder;
  }
  
  public static aqju a(Context paramContext, String paramString1, CharSequence paramCharSequence, String paramString2, String paramString3, boolean paramBoolean, int paramInt, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    itr localitr = new itr(paramContext, 2131756467, paramString2, paramBoolean, paramInt);
    localitr.setContentView(2131559151);
    localitr.setCanceledOnTouchOutside(false);
    localitr.setTitle(paramString1);
    localitr.setMessageWithoutAutoLink(paramCharSequence);
    localitr.a(Typeface.DEFAULT_BOLD, paramContext.getResources().getColorStateList(2131165706));
    localitr.setNegativeButton(paramString2, paramOnClickListener1);
    localitr.setPositiveButton(paramString3, paramOnClickListener2);
    return localitr;
  }
  
  public static void ad(int paramInt, String paramString)
  {
    retCode = paramInt;
    tips = paramString;
  }
  
  public static int getFriendType()
  {
    return retCode;
  }
  
  public static String getTips()
  {
    return tips;
  }
  
  static class a
    extends ClickableSpan
  {
    private final Context mContext;
    private final String mLink;
    
    public a(Context paramContext, String paramString)
    {
      this.mContext = paramContext;
      this.mLink = paramString;
    }
    
    public void onClick(@NonNull View paramView)
    {
      paramView = new Intent(this.mContext, QQBrowserActivity.class);
      paramView.putExtra("url", this.mLink);
      this.mContext.startActivity(paramView);
    }
    
    public void updateDrawState(TextPaint paramTextPaint)
    {
      paramTextPaint.setColor(this.mContext.getResources().getColor(2131166558));
      paramTextPaint.setUnderlineText(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itq
 * JD-Core Version:    0.7.0.1
 */