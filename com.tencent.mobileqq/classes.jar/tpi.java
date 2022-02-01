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

public class tpi
{
  public static TextView a(Context paramContext, VideoInfo paramVideoInfo, String paramString)
  {
    if ((paramVideoInfo == null) || (paramVideoInfo.a == null)) {
      return null;
    }
    int i = tph.a(paramVideoInfo.a);
    paramVideoInfo = new LinearLayout.LayoutParams(-2, -2);
    paramVideoInfo.rightMargin = agej.a(6.0F, paramContext.getResources());
    paramContext = new TextView(paramContext);
    paramContext.setIncludeFontPadding(false);
    if (i == 3)
    {
      paramContext.setBackgroundResource(2130849330);
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
      paramContext.setBackgroundResource(2130849328);
      paramContext.setTextSize(10.0F);
      paramContext.setTextColor(Color.parseColor("#737373"));
    }
  }
  
  public static void a(rog paramrog)
  {
    if ((paramrog == null) || (paramrog.c == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramrog.a != null)
        {
          bool1 = bool2;
          if (paramrog.a.a != null) {
            bool1 = tqa.a(paramrog.a.a);
          }
        }
      } while (!bool1);
      localContext = paramrog.c.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramrog.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = agej.a(245.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = agej.a(48.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(65.0F, localContext.getResources());
    paramrog.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#7F4D4D4D"));
    ((GradientDrawable)localObject).setCornerRadius(agej.a(6.0F, localContext.getResources()));
    paramrog.e.setBackgroundDrawable((Drawable)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#12B7F5"));
    ((GradientDrawable)localObject).setCornerRadius(agej.a(19.0F, localContext.getResources()));
    paramrog.k.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrog.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = agej.a(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = agej.a(40.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = agej.a(4.0F, localContext.getResources());
    paramrog.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrog.p.setTextSize(14.0F);
    localObject = (RelativeLayout.LayoutParams)paramrog.p.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).leftMargin = agej.a(10.0F, localContext.getResources());
    paramrog.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrog.q.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).rightMargin = agej.a(25.0F, localContext.getResources());
    paramrog.q.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (LinearLayout.LayoutParams)paramrog.d.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).leftMargin = agej.a(10.0F, localContext.getResources());
    paramrog.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrog.q.setTextSize(14.0F);
    paramrog.q.setTypeface(Typeface.DEFAULT);
    paramrog.m.setTypeface(Typeface.DEFAULT);
    paramrog.o.setTypeface(Typeface.DEFAULT);
    paramrog.n.setTextColor(Color.parseColor("#FFFFFF"));
    paramrog.n.setTextSize(11.0F);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#FF6522"));
    ((GradientDrawable)localObject).setCornerRadius(agej.a(3.0F, localContext.getResources()));
    paramrog.n.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrog.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(50.0F, localContext.getResources());
    paramrog.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrog.k.setTypeface(Typeface.DEFAULT_BOLD);
  }
  
  public static void b(rog paramrog)
  {
    if ((paramrog == null) || (paramrog.e == null)) {}
    Context localContext;
    do
    {
      boolean bool1;
      do
      {
        return;
        boolean bool2 = false;
        bool1 = bool2;
        if (paramrog.a != null)
        {
          bool1 = bool2;
          if (paramrog.a.a != null) {
            bool1 = tqa.a(paramrog.a.a);
          }
        }
      } while (!bool1);
      localContext = paramrog.e.getContext();
    } while (localContext == null);
    Object localObject = (RelativeLayout.LayoutParams)paramrog.e.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).height = agej.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(10.0F, localContext.getResources());
    paramrog.e.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#33FFFFFF"));
    ((GradientDrawable)localObject).setCornerRadius(agej.a(6.0F, localContext.getResources()));
    paramrog.e.setBackgroundDrawable((Drawable)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor("#12B7F5"));
    ((GradientDrawable)localObject).setCornerRadius(agej.a(6.0F, localContext.getResources()));
    paramrog.k.setBackgroundDrawable((Drawable)localObject);
    localObject = (RelativeLayout.LayoutParams)paramrog.f.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = agej.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).height = agej.a(31.0F, localContext.getResources());
    ((RelativeLayout.LayoutParams)localObject).leftMargin = agej.a(0.0F, localContext.getResources());
    paramrog.f.setLayoutParams((ViewGroup.LayoutParams)localObject);
    paramrog.p.setTextSize(16.0F);
    paramrog.q.setTextSize(14.0F);
    paramrog.q.setTypeface(Typeface.DEFAULT);
    paramrog.m.setTypeface(Typeface.DEFAULT_BOLD);
    localObject = (RelativeLayout.LayoutParams)paramrog.b.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(0.0F, localContext.getResources());
    paramrog.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpi
 * JD-Core Version:    0.7.0.1
 */