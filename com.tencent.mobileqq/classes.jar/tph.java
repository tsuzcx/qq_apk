import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.AdVideoButtonUIUtils.1;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class tph
{
  public static int a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return 1;
      if (tpz.c(paramVideoAdInfo)) {
        return 2;
      }
    } while (!tpz.a());
    return 3;
  }
  
  public static void a(Context paramContext, rog paramrog)
  {
    VideoInfo localVideoInfo;
    if ((paramrog != null) && (paramrog.jdField_a_of_type_Rrm != null) && (paramrog.jdField_a_of_type_Rrm.a != null))
    {
      localVideoInfo = paramrog.jdField_a_of_type_Rrm.a;
      if (!tqa.a(localVideoInfo)) {
        break label87;
      }
      paramrog.q.setText(tqa.a(paramContext, localVideoInfo, 1));
      paramrog.k.setText(tqa.a(paramContext, localVideoInfo, 2));
    }
    for (;;)
    {
      paramrog.q.setTag(paramrog);
      paramrog.d.setTag(paramrog);
      paramrog.k.setTag(paramrog);
      return;
      label87:
      paramrog.d.setText(tqa.a(paramContext, localVideoInfo, paramContext.getResources()));
      paramrog.k.setText(tqa.a(paramContext, localVideoInfo, paramContext.getResources()));
    }
  }
  
  public static void a(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 0)) {
      paramView.setVisibility(0);
    }
  }
  
  private static void a(View paramView, ViewGroup.LayoutParams paramLayoutParams, int paramInt)
  {
    paramLayoutParams.width = paramInt;
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  private static void a(View paramView, RelativeLayout.LayoutParams paramLayoutParams, Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if ((paramView == null) || (paramContext == null) || (paramLayoutParams == null)) {
      return;
    }
    paramLayoutParams.leftMargin = agej.a(paramInt1, paramContext.getResources());
    paramLayoutParams.rightMargin = agej.a(paramInt2, paramContext.getResources());
    paramLayoutParams.topMargin = agej.a(paramInt3, paramContext.getResources());
    paramLayoutParams.bottomMargin = agej.a(paramInt4, paramContext.getResources());
    paramLayoutParams.height = agej.a(paramInt6, paramContext.getResources());
    if (paramInt5 > 0) {
      paramLayoutParams.width = agej.a(paramInt5, paramContext.getResources());
    }
    paramView.setLayoutParams(paramLayoutParams);
  }
  
  public static void a(ImageView paramImageView)
  {
    if (paramImageView == null) {
      return;
    }
    paramImageView.setAlpha(0.5F);
  }
  
  public static void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void a(rog paramrog)
  {
    if (paramrog == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrog.d.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(13);
    paramrog.d.setLayoutParams(localLayoutParams);
  }
  
  private static void a(rog paramrog, int paramInt)
  {
    a(false, paramrog, paramInt);
    b(false, paramrog, paramInt);
    if (paramrog.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (paramInt == 3) {
        paramrog.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramInt == 2)
    {
      paramrog.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramrog.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public static void a(rog paramrog, String paramString)
  {
    if ((paramrog == null) || (paramrog.r == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramrog.r.setText(paramString);
    a(paramrog.r);
    ThreadManager.getUIHandler().postDelayed(new AdVideoButtonUIUtils.1(paramrog), 1000L);
  }
  
  public static void a(boolean paramBoolean, rog paramrog)
  {
    if ((paramrog == null) || (paramrog.jdField_a_of_type_Rrm == null) || (paramrog.jdField_a_of_type_Rrm.a == null) || (paramrog.jdField_a_of_type_Rrm.a.a == null)) {
      return;
    }
    int i = a(paramrog.jdField_a_of_type_Rrm.a.a);
    if (!paramBoolean)
    {
      a(paramrog, i);
      return;
    }
    b(paramrog, i);
  }
  
  private static void a(boolean paramBoolean, rog paramrog, int paramInt)
  {
    float f2 = 19.0F;
    if ((paramrog == null) || (paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while (localContext == null);
    GradientDrawable localGradientDrawable1 = new GradientDrawable();
    GradientDrawable localGradientDrawable2 = new GradientDrawable();
    Object localObject1;
    Object localObject2;
    label64:
    label77:
    Object localObject3;
    float f1;
    if (paramBoolean)
    {
      localObject1 = "#FF12B7F6";
      if (!paramBoolean) {
        break label208;
      }
      localObject2 = "#FF12B7F6";
      if (paramInt != 3) {
        break label222;
      }
      if (!paramBoolean) {
        break label215;
      }
      localObject1 = "#FF12B7F5";
      localObject3 = "#FF12B7F5";
      f1 = 19.0F;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
    for (;;)
    {
      localGradientDrawable1.setColor(Color.parseColor((String)localObject2));
      localGradientDrawable1.setCornerRadius(agej.a(f2, localContext.getResources()));
      paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
      localGradientDrawable2.setColor(Color.parseColor((String)localObject1));
      localGradientDrawable2.setCornerRadius(agej.a(f1, localContext.getResources()));
      paramrog.k.setBackgroundDrawable(localGradientDrawable2);
      if (paramInt == 3)
      {
        paramrog.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842684));
        paramrog.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842684));
        return;
        localObject1 = "#1AFFFFFF";
        break;
        label208:
        localObject2 = "#1AFFFFFF";
        break label64;
        label215:
        localObject1 = "#7F7A8690";
        break label77;
        label222:
        if (paramInt != 2) {
          break label335;
        }
        if (paramBoolean) {}
        for (localObject1 = "#FF12B7F6";; localObject1 = "#1AFFFFFF")
        {
          localObject2 = localObject1;
          f1 = 6.0F;
          f2 = 6.0F;
          localObject1 = "#FF12B7F5";
          break;
        }
      }
      if (paramInt == 2)
      {
        paramrog.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842683));
        paramrog.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842683));
        return;
      }
      paramrog.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842682));
      paramrog.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842683));
      return;
      label335:
      f2 = 0.0F;
      f1 = 6.0F;
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
    }
  }
  
  public static boolean a()
  {
    return Aladdin.getConfig(343).getIntegerFromString("tiktok_big_style", 0) == 1;
  }
  
  public static void b(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 8)) {
      paramView.setVisibility(8);
    }
  }
  
  private static void b(rog paramrog)
  {
    if ((paramrog == null) || (paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while ((localContext == null) || (paramrog.jdField_a_of_type_Rrm == null) || (paramrog.jdField_a_of_type_Rrm.a == null));
    Object localObject = paramrog.jdField_a_of_type_Rrm.a;
    int i = localContext.getResources().getDisplayMetrics().widthPixels - agej.a(77.0F, localContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrog.jdField_m_of_type_AndroidViewViewGroup.getLayoutParams();
    a(paramrog.jdField_m_of_type_AndroidViewViewGroup, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramrog.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    a(paramrog.jdField_e_of_type_AndroidWidgetRelativeLayout, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramrog.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (tqa.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = agej.a(124.0F, localContext.getResources());
      a(paramrog.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams, i);
      paramrog.jdField_c_of_type_AndroidWidgetTextView.setLineSpacing(agej.a(4.0F, localContext.getResources()), 1.0F);
      localObject = (RelativeLayout.LayoutParams)paramrog.jdField_m_of_type_AndroidViewView.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(65.0F, localContext.getResources());
      if (!a()) {
        break label520;
      }
    }
    label520:
    for (((RelativeLayout.LayoutParams)localObject).rightMargin = agej.a(62.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).rightMargin = agej.a(120.0F, localContext.getResources()))
    {
      paramrog.jdField_m_of_type_AndroidViewView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrog.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(65.0F, localContext.getResources());
      paramrog.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrog.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = agej.a(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = agej.a(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = agej.a(10.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = agej.a(12.0F, localContext.getResources());
      paramrog.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrog.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = agej.a(10.0F, localContext.getResources());
      paramrog.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramrog.j.setTypeface(Typeface.DEFAULT);
      paramrog.j.setTextSize(12.0F);
      localObject = (LinearLayout.LayoutParams)paramrog.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = agej.a(38.0F, localContext.getResources());
      paramrog.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrog.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = agej.a(38.0F, localContext.getResources());
      paramrog.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrog.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(50.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramrog.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = agej.a(114.0F, localContext.getResources());
      break;
    }
  }
  
  private static void b(rog paramrog, int paramInt)
  {
    a(true, paramrog, paramInt);
    b(true, paramrog, paramInt);
    if (paramInt == 3)
    {
      b(paramrog.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    if (paramInt == 2)
    {
      b(paramrog.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    a(paramrog.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  private static void b(boolean paramBoolean, rog paramrog, int paramInt)
  {
    if ((paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout == null) || (paramrog.d == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while (localObject == null);
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    int i3 = -1;
    int n = 42;
    int i1;
    int i2;
    if (paramInt == 3)
    {
      i = 16;
      j = 15;
      k = 13;
      m = 65;
      i3 = 205;
      n = 40;
      i1 = 9;
      i2 = 13;
    }
    for (;;)
    {
      tpx.a("AdVideoButtonUIUtils", "leftMargin = " + i + " rightMargin = " + j + " topMargin = " + k + " bottomMargin = " + m + " height = " + n);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrog.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      a(paramrog.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams, (Context)localObject, i, j, k, m, i3, n);
      localObject = (RelativeLayout.LayoutParams)paramrog.d.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(i1, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(i2);
      paramrog.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramInt == 3)
      {
        b(paramrog);
        tpi.a(paramrog);
        a(paramrog.s);
        a(paramrog.n);
        return;
        if (paramInt == 2)
        {
          int i5 = 15;
          int i4 = 15;
          k = 8;
          m = 5;
          n = 31;
          if (paramBoolean)
          {
            i = 13;
            label283:
            if (!paramBoolean) {
              break label314;
            }
          }
          label314:
          for (j = 9;; j = 13)
          {
            i1 = j;
            i2 = i;
            i = i5;
            j = i4;
            break;
            i = 9;
            break label283;
          }
        }
      }
      else
      {
        c(paramrog, paramInt);
        tpi.b(paramrog);
        b(paramrog.s);
        b(paramrog.n);
        return;
      }
      i1 = 13;
      i2 = 9;
    }
  }
  
  public static boolean b()
  {
    return Aladdin.getConfig(343).getIntegerFromString("gray_btn", 0) == 1;
  }
  
  public static void c(View paramView)
  {
    if ((paramView != null) && (paramView.getVisibility() != 4)) {
      paramView.setVisibility(4);
    }
  }
  
  private static void c(rog paramrog, int paramInt)
  {
    if ((paramrog == null) || (paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrog.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while ((localContext == null) || (paramrog.jdField_a_of_type_Rrm == null) || (paramrog.jdField_a_of_type_Rrm.a == null));
    Object localObject = paramrog.jdField_a_of_type_Rrm.a;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrog.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (tqa.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = agej.a(51.0F, localContext.getResources());
      paramrog.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)paramrog.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt != 2) {
        break label333;
      }
    }
    label333:
    for (((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(5.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(0.0F, localContext.getResources()))
    {
      paramrog.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrog.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = agej.a(75.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = agej.a(75.0F, localContext.getResources());
      paramrog.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramrog.j.setTypeface(Typeface.DEFAULT);
      localObject = (LinearLayout.LayoutParams)paramrog.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = agej.a(31.0F, localContext.getResources());
      paramrog.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrog.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = agej.a(31.0F, localContext.getResources());
      paramrog.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrog.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = agej.a(41.5F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = agej.a(15.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = agej.a(15.0F, localContext.getResources());
      paramrog.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = agej.a(55.0F, localContext.getResources());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tph
 * JD-Core Version:    0.7.0.1
 */