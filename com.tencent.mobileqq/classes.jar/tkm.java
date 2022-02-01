import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.view.NativeAdDownloadView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;

public class tkm
{
  public static void a(Context paramContext, tse paramtse, tla paramtla, TextView paramTextView, NativeAdDownloadView paramNativeAdDownloadView)
  {
    int n = Color.parseColor("#40A0FF");
    if (!TextUtils.isEmpty(paramtla.jdField_a_of_type_JavaLangString)) {
      n = nzv.a(paramtla.jdField_a_of_type_JavaLangString, "#FFFFFF");
    }
    for (;;)
    {
      int i2 = (int)paramtla.g;
      float f2 = paramtla.jdField_a_of_type_Int;
      int i = 0;
      int j = 0;
      float f1 = f2;
      if (f2 < 10.0F) {
        f1 = 10.0F;
      }
      if (f1 > 16.0F) {}
      for (float f4 = 16.0F;; f4 = f1)
      {
        Object localObject = paramtla.b;
        f2 = paramtla.jdField_c_of_type_Float;
        String str = paramtla.jdField_c_of_type_JavaLangString;
        float f3 = paramtla.d;
        GradientDrawable localGradientDrawable = new GradientDrawable();
        if (!TextUtils.isEmpty(str)) {
          localGradientDrawable.setColor(nzv.a(str, "#40A0FF"));
        }
        f1 = f2;
        if (f2 > 0.0F)
        {
          f1 = f2;
          if (f2 > 2.0F) {
            f1 = 2.0F;
          }
          localGradientDrawable.setStroke(agej.a(f1, paramContext.getResources()), nzv.a((String)localObject, "#40A0FF"));
        }
        if (f3 < 0.0F) {
          f2 = 0.0F;
        }
        for (;;)
        {
          localGradientDrawable.setCornerRadius(agej.a(f2, paramContext.getResources()));
          oxr.a(paramTextView, localGradientDrawable);
          f3 = paramtla.e;
          float f5 = paramtla.f;
          label228:
          label238:
          int k;
          int m;
          if (f3 < 0.0F)
          {
            f2 = 0.0F;
            if (f5 >= 0.0F) {
              break label562;
            }
            f3 = 0.0F;
            if (f2 > 0.0F)
            {
              j = agej.a(f2, paramContext.getResources());
              i = j;
            }
            if (f3 <= 0.0F) {
              break label655;
            }
            k = agej.a(f3, paramContext.getResources());
            m = k;
          }
          for (;;)
          {
            f2 = paramtla.i;
            if (f2 == 3.0F)
            {
              localObject = (FrameLayout.LayoutParams)paramTextView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).gravity = 21;
              paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              localObject = (FrameLayout.LayoutParams)paramNativeAdDownloadView.getLayoutParams();
              ((FrameLayout.LayoutParams)localObject).gravity = 21;
              paramNativeAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
              label342:
              f2 = paramtla.k;
              f3 = paramtla.l;
              if ((f2 <= 0.0F) || (f3 <= 0.0F)) {
                break label640;
              }
              paramNativeAdDownloadView = (FrameLayout.LayoutParams)paramTextView.getLayoutParams();
              paramNativeAdDownloadView.height = agej.a(f3, paramContext.getResources());
              paramNativeAdDownloadView.width = agej.a(f2, paramContext.getResources());
              paramTextView.setLayoutParams(paramNativeAdDownloadView);
              paramTextView.setGravity(17);
              j = 0;
              i = 0;
              k = 0;
              m = 0;
            }
            for (;;)
            {
              f2 = paramtla.j;
              if (f2 > 0.0F)
              {
                if (f1 <= 2.0F) {
                  break label637;
                }
                f1 = 2.0F;
              }
              label562:
              label637:
              for (;;)
              {
                paramNativeAdDownloadView = paramtse.getComLayoutParams();
                paramtla = paramNativeAdDownloadView;
                if (paramNativeAdDownloadView == null) {
                  paramtla = new Layout.Params();
                }
                paramtla.mLayoutWidth = agej.a(f1 * 2.0F + f2, paramContext.getResources());
                paramtse.setComLayoutParams(paramtla);
                paramTextView.setCompoundDrawablePadding(i2);
                paramTextView.setTextColor(n);
                paramTextView.setTextSize(f4);
                paramTextView.setPadding(j, k, i, m);
                return;
                if (f3 <= 20.0F) {
                  break label664;
                }
                f2 = 20.0F;
                break;
                f2 = f3;
                if (f3 <= 12.0F) {
                  break label228;
                }
                f2 = 12.0F;
                break label228;
                f3 = f5;
                if (f5 <= 12.0F) {
                  break label238;
                }
                f3 = 12.0F;
                break label238;
                if (f2 != 1.0F) {
                  break label342;
                }
                localObject = (FrameLayout.LayoutParams)paramTextView.getLayoutParams();
                ((FrameLayout.LayoutParams)localObject).gravity = 19;
                paramTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
                localObject = (FrameLayout.LayoutParams)paramNativeAdDownloadView.getLayoutParams();
                ((FrameLayout.LayoutParams)localObject).gravity = 19;
                paramNativeAdDownloadView.setLayoutParams((ViewGroup.LayoutParams)localObject);
                break label342;
              }
              label640:
              int i1 = j;
              j = i;
              i = i1;
            }
            label655:
            m = 0;
            k = 0;
          }
          label664:
          f2 = f3;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tkm
 * JD-Core Version:    0.7.0.1
 */