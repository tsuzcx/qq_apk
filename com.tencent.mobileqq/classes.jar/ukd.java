import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils.TruncateAt;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.mobileqq.activity.aio.AIOUtils;

public class ukd
{
  public static TextView a(Context paramContext, VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      return null;
    }
    int i = ukc.a(paramVideoInfo.a);
    paramVideoInfo = new LinearLayout.LayoutParams(-2, -2);
    paramVideoInfo.rightMargin = AIOUtils.dp2px(6.0F, paramContext.getResources());
    paramContext = new TextView(paramContext);
    paramContext.setIncludeFontPadding(false);
    if (i == 3)
    {
      paramContext.setBackgroundResource(2130849333);
      paramContext.setTextColor(Color.parseColor("#757575"));
      paramContext.setTextSize(11.0F);
    }
    for (;;)
    {
      paramContext.setMaxLines(1);
      paramContext.setEllipsize(TextUtils.TruncateAt.END);
      paramContext.setGravity(17);
      paramContext.setText(paramString);
      paramContext.setLayoutParams(paramVideoInfo);
      return paramContext;
      paramContext.setBackgroundResource(2130849331);
      paramContext.setTextSize(10.0F);
      paramContext.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  public static void a(swi paramswi)
  {
    if ((paramswi == null) || (paramswi.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramswi.a != null)
        {
          bool1 = bool2;
          if (paramswi.a.a != null) {
            bool1 = uks.a(paramswi.a.a);
          }
        }
      } while (!bool1);
      localContext = paramswi.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramswi.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.dp2px(245.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(48.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(65.0F, localContext.getResources());
    paramswi.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#7F4D4D4D"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(6.0F, localContext.getResources()));
    paramswi.c.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramswi.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.dp2px(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(4.0F, localContext.getResources());
    paramswi.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramswi.l.setTextSize(14.0F);
    localObject = (RelativeLayout.LayoutParams)paramswi.l.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
    paramswi.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)paramswi.m.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(25.0F, localContext.getResources());
    paramswi.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)paramswi.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
    paramswi.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramswi.m.setTextSize(14.0F);
    paramswi.m.setTypeface(Typeface.DEFAULT);
    paramswi.i.setTypeface(Typeface.DEFAULT);
    paramswi.k.setTypeface(Typeface.DEFAULT);
    paramswi.j.setTextColor(Color.parseColor("#FFFFFF"));
    paramswi.j.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FF6522"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(3.0F, localContext.getResources()));
    paramswi.j.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramswi.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(50.0F, localContext.getResources());
    paramswi.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
  
  public static void b(swi paramswi)
  {
    if ((paramswi == null) || (paramswi.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramswi.a != null)
        {
          bool1 = bool2;
          if (paramswi.a.a != null) {
            bool1 = uks.a(paramswi.a.a);
          }
        }
      } while (!bool1);
      localContext = paramswi.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramswi.c.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
    paramswi.c.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#33FFFFFF"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(6.0F, localContext.getResources()));
    paramswi.c.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramswi.d.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.dp2px(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(0.0F, localContext.getResources());
    paramswi.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramswi.l.setTextSize(16.0F);
    paramswi.m.setTextSize(14.0F);
    paramswi.m.setTypeface(Typeface.DEFAULT);
    paramswi.i.setTypeface(Typeface.DEFAULT_BOLD);
    localObject = (RelativeLayout.LayoutParams)paramswi.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(0.0F, localContext.getResources());
    paramswi.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ukd
 * JD-Core Version:    0.7.0.1
 */