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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class twb
{
  public static int a(VideoAdInfo paramVideoAdInfo)
  {
    if (paramVideoAdInfo == null) {}
    do
    {
      return 1;
      if (twq.a()) {
        return 3;
      }
    } while (!twq.c(paramVideoAdInfo));
    return 2;
  }
  
  public static void a(Context paramContext, rvi paramrvi)
  {
    VideoInfo localVideoInfo;
    if ((paramrvi != null) && (paramrvi.jdField_a_of_type_Ryo != null) && (paramrvi.jdField_a_of_type_Ryo.a != null))
    {
      localVideoInfo = paramrvi.jdField_a_of_type_Ryo.a;
      if (!twr.a(localVideoInfo)) {
        break label87;
      }
      paramrvi.q.setText(twr.a(paramContext, localVideoInfo, 1));
      paramrvi.k.setText(twr.a(paramContext, localVideoInfo, 2));
    }
    for (;;)
    {
      paramrvi.q.setTag(paramrvi);
      paramrvi.d.setTag(paramrvi);
      paramrvi.k.setTag(paramrvi);
      return;
      label87:
      paramrvi.d.setText(twr.a(paramContext, localVideoInfo, paramContext.getResources()));
      paramrvi.k.setText(twr.a(paramContext, localVideoInfo, paramContext.getResources()));
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
    paramLayoutParams.leftMargin = AIOUtils.dp2px(paramInt1, paramContext.getResources());
    paramLayoutParams.rightMargin = AIOUtils.dp2px(paramInt2, paramContext.getResources());
    paramLayoutParams.topMargin = AIOUtils.dp2px(paramInt3, paramContext.getResources());
    paramLayoutParams.bottomMargin = AIOUtils.dp2px(paramInt4, paramContext.getResources());
    paramLayoutParams.height = AIOUtils.dp2px(paramInt6, paramContext.getResources());
    if (paramInt5 > 0) {
      paramLayoutParams.width = AIOUtils.dp2px(paramInt5, paramContext.getResources());
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
  
  public static void a(rvi paramrvi)
  {
    if (paramrvi == null) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrvi.d.getLayoutParams();
    localLayoutParams.addRule(9, 0);
    localLayoutParams.addRule(13);
    paramrvi.d.setLayoutParams(localLayoutParams);
  }
  
  private static void a(rvi paramrvi, int paramInt)
  {
    a(false, paramrvi, paramInt);
    b(false, paramrvi, paramInt);
    if (paramrvi.jdField_b_of_type_AndroidWidgetImageView != null)
    {
      if (paramInt == 3) {
        paramrvi.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    else {
      return;
    }
    if (paramInt == 2)
    {
      paramrvi.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      return;
    }
    paramrvi.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public static void a(rvi paramrvi, String paramString)
  {
    if ((paramrvi == null) || (paramrvi.r == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    paramrvi.r.setText(paramString);
    a(paramrvi.r);
    ThreadManager.getUIHandler().postDelayed(new AdVideoButtonUIUtils.1(paramrvi), 1000L);
  }
  
  public static void a(boolean paramBoolean, rvi paramrvi)
  {
    if ((paramrvi == null) || (paramrvi.jdField_a_of_type_Ryo == null) || (paramrvi.jdField_a_of_type_Ryo.a == null) || (paramrvi.jdField_a_of_type_Ryo.a.a == null)) {
      return;
    }
    int i = a(paramrvi.jdField_a_of_type_Ryo.a.a);
    if (!paramBoolean)
    {
      a(paramrvi, i);
      return;
    }
    b(paramrvi, i);
  }
  
  private static void a(boolean paramBoolean, rvi paramrvi, int paramInt)
  {
    float f2 = 19.0F;
    if ((paramrvi == null) || (paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
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
      localGradientDrawable1.setCornerRadius(AIOUtils.dp2px(f2, localContext.getResources()));
      paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable1);
      localGradientDrawable2.setColor(Color.parseColor((String)localObject1));
      localGradientDrawable2.setCornerRadius(AIOUtils.dp2px(f1, localContext.getResources()));
      paramrvi.k.setBackgroundDrawable(localGradientDrawable2);
      if (paramInt == 3)
      {
        paramrvi.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842730));
        paramrvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842730));
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
          localObject1 = "#FF12B7F6";
          break;
        }
      }
      if (paramInt == 2)
      {
        paramrvi.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842729));
        paramrvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842729));
        return;
      }
      paramrvi.jdField_a_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842728));
      paramrvi.jdField_b_of_type_AndroidWidgetProgressBar.setProgressDrawable(localContext.getResources().getDrawable(2130842729));
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
  
  private static void b(rvi paramrvi)
  {
    if ((paramrvi == null) || (paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while ((localContext == null) || (paramrvi.jdField_a_of_type_Ryo == null) || (paramrvi.jdField_a_of_type_Ryo.a == null));
    Object localObject = paramrvi.jdField_a_of_type_Ryo.a;
    int i = localContext.getResources().getDisplayMetrics().widthPixels - AIOUtils.dp2px(77.0F, localContext.getResources());
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrvi.n.getLayoutParams();
    a(paramrvi.n, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramrvi.jdField_e_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
    a(paramrvi.jdField_e_of_type_AndroidWidgetRelativeLayout, localLayoutParams, i);
    localLayoutParams = (RelativeLayout.LayoutParams)paramrvi.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (twr.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = AIOUtils.dp2px(124.0F, localContext.getResources());
      a(paramrvi.jdField_c_of_type_AndroidWidgetTextView, localLayoutParams, i);
      paramrvi.jdField_c_of_type_AndroidWidgetTextView.setLineSpacing(AIOUtils.dp2px(4.0F, localContext.getResources()), 1.0F);
      localObject = (RelativeLayout.LayoutParams)paramrvi.m.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(65.0F, localContext.getResources());
      if (!a()) {
        break label520;
      }
    }
    label520:
    for (((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(62.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(120.0F, localContext.getResources()))
    {
      paramrvi.m.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrvi.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(65.0F, localContext.getResources());
      paramrvi.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrvi.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(60.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).topMargin = AIOUtils.dp2px(12.0F, localContext.getResources());
      paramrvi.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrvi.jdField_c_of_type_AndroidWidgetLinearLayout.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(10.0F, localContext.getResources());
      paramrvi.jdField_c_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramrvi.j.setTypeface(Typeface.DEFAULT);
      paramrvi.j.setTextSize(12.0F);
      localObject = (LinearLayout.LayoutParams)paramrvi.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(38.0F, localContext.getResources());
      paramrvi.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrvi.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(38.0F, localContext.getResources());
      paramrvi.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrvi.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(50.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = 0;
      ((RelativeLayout.LayoutParams)localObject).rightMargin = 0;
      paramrvi.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = AIOUtils.dp2px(114.0F, localContext.getResources());
      break;
    }
  }
  
  private static void b(rvi paramrvi, int paramInt)
  {
    a(true, paramrvi, paramInt);
    b(true, paramrvi, paramInt);
    if (paramInt == 3)
    {
      b(paramrvi.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    if (paramInt == 2)
    {
      b(paramrvi.jdField_b_of_type_AndroidWidgetImageView);
      return;
    }
    a(paramrvi.jdField_b_of_type_AndroidWidgetImageView);
  }
  
  private static void b(boolean paramBoolean, rvi paramrvi, int paramInt)
  {
    if ((paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout == null) || (paramrvi.d == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
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
      twp.a("AdVideoButtonUIUtils", "leftMargin = " + i + " rightMargin = " + j + " topMargin = " + k + " bottomMargin = " + m + " height = " + n);
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrvi.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      a(paramrvi.jdField_b_of_type_AndroidWidgetRelativeLayout, localLayoutParams, (Context)localObject, i, j, k, m, i3, n);
      localObject = (RelativeLayout.LayoutParams)paramrvi.d.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).addRule(i1, 0);
      ((RelativeLayout.LayoutParams)localObject).addRule(i2);
      paramrvi.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      if (paramInt == 3)
      {
        b(paramrvi);
        twc.a(paramrvi);
        a(paramrvi.s);
        a(paramrvi.o);
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
        c(paramrvi, paramInt);
        twc.b(paramrvi);
        b(paramrvi.s);
        b(paramrvi.o);
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
  
  private static void c(rvi paramrvi, int paramInt)
  {
    if ((paramrvi == null) || (paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout == null)) {}
    Context localContext;
    do
    {
      return;
      localContext = paramrvi.jdField_c_of_type_AndroidWidgetRelativeLayout.getContext();
    } while ((localContext == null) || (paramrvi.jdField_a_of_type_Ryo == null) || (paramrvi.jdField_a_of_type_Ryo.a == null));
    Object localObject = paramrvi.jdField_a_of_type_Ryo.a;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramrvi.jdField_c_of_type_AndroidWidgetTextView.getLayoutParams();
    if (twr.a((VideoInfo)localObject))
    {
      localLayoutParams.bottomMargin = AIOUtils.dp2px(51.0F, localContext.getResources());
      paramrvi.jdField_c_of_type_AndroidWidgetTextView.setLayoutParams(localLayoutParams);
      localObject = (RelativeLayout.LayoutParams)paramrvi.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
      if (paramInt != 2) {
        break label333;
      }
    }
    label333:
    for (((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(5.0F, localContext.getResources());; ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(0.0F, localContext.getResources()))
    {
      paramrvi.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrvi.jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).width = AIOUtils.dp2px(75.0F, localContext.getResources());
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(75.0F, localContext.getResources());
      paramrvi.jdField_e_of_type_AndroidWidgetImageView.setLayoutParams((ViewGroup.LayoutParams)localObject);
      paramrvi.j.setTypeface(Typeface.DEFAULT);
      localObject = (LinearLayout.LayoutParams)paramrvi.k.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
      paramrvi.k.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (LinearLayout.LayoutParams)paramrvi.p.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).height = AIOUtils.dp2px(31.0F, localContext.getResources());
      paramrvi.p.setLayoutParams((ViewGroup.LayoutParams)localObject);
      localObject = (RelativeLayout.LayoutParams)paramrvi.jdField_b_of_type_AndroidWidgetSeekBar.getLayoutParams();
      ((RelativeLayout.LayoutParams)localObject).bottomMargin = AIOUtils.dp2px(41.5F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).leftMargin = AIOUtils.dp2px(15.0F, localContext.getResources());
      ((RelativeLayout.LayoutParams)localObject).rightMargin = AIOUtils.dp2px(15.0F, localContext.getResources());
      paramrvi.jdField_b_of_type_AndroidWidgetSeekBar.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
      localLayoutParams.bottomMargin = AIOUtils.dp2px(55.0F, localContext.getResources());
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     twb
 * JD-Core Version:    0.7.0.1
 */