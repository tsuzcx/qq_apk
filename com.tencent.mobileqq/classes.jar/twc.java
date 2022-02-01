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

public class twc
{
  public static TextView a(Context paramContext, VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      return null;
    }
    int i = twb.a(paramVideoInfo.a);
    paramVideoInfo = new LinearLayout.LayoutParams(-2, -2);
    paramVideoInfo.rightMargin = AIOUtils.dp2px(6.0F, paramContext.getResources());
    paramContext = new TextView(paramContext);
    paramContext.setIncludeFontPadding(false);
    if (i == 3)
    {
      paramContext.setBackgroundResource(2130849241);
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
      paramContext.setBackgroundResource(2130849239);
      paramContext.setTextSize(10.0F);
      paramContext.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  public static void a(rvi paramrvi)
  {
    if ((paramrvi == null) || (paramrvi.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramrvi.a != null)
        {
          bool1 = bool2;
          if (paramrvi.a.a != null) {
            bool1 = twr.a(paramrvi.a.a);
          }
        }
      } while (!bool1);
      localContext = paramrvi.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramrvi.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.dp2px(245.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(48.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(65.0F, localContext.getResources());
    paramrvi.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#7F4D4D4D"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(6.0F, localContext.getResources()));
    paramrvi.e.setBackgroundDrawable((Drawable)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#12B7F5"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(19.0F, localContext.getResources()));
    paramrvi.k.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrvi.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.dp2px(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(4.0F, localContext.getResources());
    paramrvi.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrvi.p.setTextSize(14.0F);
    localObject = (RelativeLayout.LayoutParams)paramrvi.p.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
    paramrvi.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrvi.q.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(25.0F, localContext.getResources());
    paramrvi.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)paramrvi.d.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
    paramrvi.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrvi.q.setTextSize(14.0F);
    paramrvi.q.setTypeface(Typeface.DEFAULT);
    paramrvi.m.setTypeface(Typeface.DEFAULT);
    paramrvi.o.setTypeface(Typeface.DEFAULT);
    paramrvi.n.setTextColor(Color.parseColor("#FFFFFF"));
    paramrvi.n.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FF6522"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(3.0F, localContext.getResources()));
    paramrvi.n.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrvi.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(50.0F, localContext.getResources());
    paramrvi.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrvi.k.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  public static void b(rvi paramrvi)
  {
    if ((paramrvi == null) || (paramrvi.e == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramrvi.a != null)
        {
          bool1 = bool2;
          if (paramrvi.a.a != null) {
            bool1 = twr.a(paramrvi.a.a);
          }
        }
      } while (!bool1);
      localContext = paramrvi.e.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramrvi.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
    paramrvi.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#33FFFFFF"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(6.0F, localContext.getResources()));
    paramrvi.e.setBackgroundDrawable((Drawable)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#12B7F5"));
    ((GradientDrawable)localObject).setCornerRadius(AIOUtils.dp2px(6.0F, localContext.getResources()));
    paramrvi.k.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrvi.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = AIOUtils.dp2px(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(0.0F, localContext.getResources());
    paramrvi.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrvi.p.setTextSize(16.0F);
    paramrvi.q.setTextSize(14.0F);
    paramrvi.q.setTypeface(Typeface.DEFAULT);
    paramrvi.m.setTypeface(Typeface.DEFAULT_BOLD);
    localObject = (RelativeLayout.LayoutParams)paramrvi.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(0.0F, localContext.getResources());
    paramrvi.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twc
 * JD-Core Version:    0.7.0.1
 */