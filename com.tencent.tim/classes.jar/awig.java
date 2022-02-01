import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build.VERSION;
import android.os.Handler;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.qzone.widget.QzoneGuideBubbleHelper.1;
import cooperation.qzone.widget.TriangleView;
import java.lang.ref.WeakReference;

public class awig
{
  private static volatile awig jdField_a_of_type_Awig;
  private int CP = 0;
  private awie jdField_a_of_type_Awie;
  private Runnable az = new QzoneGuideBubbleHelper.1(this);
  private WeakReference<Context> mContext;
  private Handler mHandler = new Handler();
  
  public static ShapeDrawable a(float paramFloat1, float paramFloat2, int paramInt)
  {
    Object localObject = new float[8];
    float[] arrayOfFloat = new float[8];
    int i = 0;
    while (i < 8)
    {
      localObject[i] = (paramFloat1 + paramFloat2);
      arrayOfFloat[i] = paramFloat1;
      i += 1;
    }
    localObject = new ShapeDrawable(new RoundRectShape((float[])localObject, new RectF(paramFloat2, paramFloat2, paramFloat2, paramFloat2), arrayOfFloat));
    ((ShapeDrawable)localObject).getPaint().setColor(paramInt);
    return localObject;
  }
  
  public static awig a()
  {
    if (jdField_a_of_type_Awig == null) {}
    try
    {
      if (jdField_a_of_type_Awig == null) {
        jdField_a_of_type_Awig = new awig();
      }
      return jdField_a_of_type_Awig;
    }
    finally {}
  }
  
  private int[] a(View paramView, ViewGroup paramViewGroup, String paramString, float paramFloat, int paramInt1, double paramDouble1, double paramDouble2, int paramInt2, boolean paramBoolean, awig.a parama, int paramInt3, int paramInt4)
  {
    if ((this.CP == 0) && (this.jdField_a_of_type_Awie == null) && (this.mContext != null) && (this.mContext.get() != null))
    {
      this.jdField_a_of_type_Awie = new awie((Context)this.mContext.get());
      this.jdField_a_of_type_Awie.setWidth(-2);
      this.jdField_a_of_type_Awie.setHeight(-2);
      this.jdField_a_of_type_Awie.setTouchable(paramBoolean);
      if (paramBoolean) {
        paramViewGroup.setOnTouchListener(new awih(this));
      }
      this.jdField_a_of_type_Awie.setOutsideTouchable(true);
      this.jdField_a_of_type_Awie.setBackgroundDrawable(new ColorDrawable(0));
    }
    paramView = a(paramViewGroup, paramView, paramString, paramFloat, paramInt1, paramInt2, parama, paramInt3, paramInt4);
    if (paramView == null) {}
    while (this.jdField_a_of_type_Awie == null) {
      return paramView;
    }
    this.jdField_a_of_type_Awie.setContentView(paramViewGroup);
    this.jdField_a_of_type_Awie.update();
    return paramView;
  }
  
  private int[] a(ViewGroup paramViewGroup, View paramView, String paramString, float paramFloat, int paramInt1, int paramInt2, awig.a parama, int paramInt3, int paramInt4)
  {
    if ((this.mContext == null) || (this.mContext.get() == null)) {
      return null;
    }
    paramView = b(paramView);
    if ((paramView.left <= 0) && (paramView.right <= 0) && (paramView.top <= 0) && (paramView.bottom <= 0)) {
      return null;
    }
    TextView localTextView = new TextView((Context)this.mContext.get());
    localTextView.setId(2131376135);
    localTextView.setTextColor(-1);
    localTextView.setTextSize(paramFloat);
    localTextView.setText(paramString);
    int n = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131299079);
    if (parama != null)
    {
      paramString = ((Context)this.mContext.get()).getResources().getDrawable(parama.drawableId);
      if (paramString != null)
      {
        paramString.setBounds(0, 0, parama.ads, parama.adt);
        localTextView.setCompoundDrawables(paramString, null, null, null);
        localTextView.setCompoundDrawablePadding(parama.ais);
      }
    }
    int i = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131299081);
    int j = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131299080);
    localTextView.setPadding(j, i, j, i);
    localTextView.setGravity(17);
    if (paramInt4 > 0)
    {
      localTextView.setMaxLines(paramInt4);
      localTextView.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
    }
    i = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131299082);
    setViewBackground(localTextView, a(i, 0.0F, paramInt2));
    paramString = new TriangleView((Context)this.mContext.get(), paramInt1, paramInt2);
    paramString.setId(2131376133);
    parama = new RelativeLayout.LayoutParams(-2, -2);
    int k = ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131299078);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(k, ((Context)this.mContext.get()).getApplicationContext().getResources().getDimensionPixelSize(2131299077));
    int m;
    if (paramInt1 == 0)
    {
      parama.addRule(10);
      localLayoutParams.addRule(3, 2131376135);
      parama.addRule(14);
      localLayoutParams.leftMargin = paramInt3;
      paramViewGroup.addView(localTextView, parama);
      paramViewGroup.addView(paramString, localLayoutParams);
      paramInt2 = dpToPx(12.0F);
      paramViewGroup.measure(View.MeasureSpec.makeMeasureSpec(getScreenWidth() - dpToPx(12.0F) * 2, -2147483648), View.MeasureSpec.makeMeasureSpec(0, 0));
      m = paramViewGroup.getMeasuredWidth();
      paramInt3 = paramViewGroup.getMeasuredHeight();
      j = paramView.left + (paramView.right - paramView.left) / 2 - m / 2;
      if (paramInt1 != 0) {
        break label649;
      }
      paramInt4 = paramView.top - paramInt3 - n;
      label549:
      paramInt1 = getScreenWidth();
      if (j >= paramInt2) {
        break label664;
      }
      paramInt1 = paramInt2;
    }
    for (;;)
    {
      label566:
      j = paramView.left - paramInt1 + (paramView.right - paramView.left - k) / 2;
      if (j < i) {
        paramInt2 = i;
      }
      for (;;)
      {
        adzw.setX(paramString, paramInt2);
        return new int[] { paramInt1, paramInt4, paramInt2, paramInt3 };
        if (paramInt1 != 1) {
          break;
        }
        parama.addRule(3, 2131376133);
        break;
        label649:
        paramInt4 = paramView.bottom + n;
        paramInt3 = 0;
        break label549;
        label664:
        if (j <= paramInt1 - m - paramInt2) {
          break label720;
        }
        paramInt1 = paramInt1 - m - paramInt2;
        break label566;
        paramInt2 = j;
        if (j + k > m - i) {
          paramInt2 = m - i - k;
        }
      }
      label720:
      paramInt1 = j;
    }
  }
  
  private static Rect b(View paramView)
  {
    if (paramView == null) {
      return new Rect();
    }
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getMeasuredWidth(), arrayOfInt[1] + paramView.getMeasuredHeight());
  }
  
  private static FrameLayout c(Context paramContext)
  {
    if ((paramContext == null) || (!(paramContext instanceof Activity))) {
      return null;
    }
    paramContext = (ViewGroup)((Activity)paramContext).getWindow().getDecorView();
    FrameLayout localFrameLayout = (FrameLayout)paramContext.findViewById(2131376134);
    if (localFrameLayout == null) {
      return (FrameLayout)paramContext.findViewById(16908290);
    }
    return localFrameLayout;
  }
  
  public void Wp()
  {
    switch (this.CP)
    {
    }
    FrameLayout localFrameLayout;
    View localView;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
          } while (this.jdField_a_of_type_Awie == null);
          this.mHandler.removeCallbacks(this.az);
          try
          {
            this.jdField_a_of_type_Awie.dismiss();
            this.jdField_a_of_type_Awie = null;
            return;
          }
          catch (Exception localException)
          {
            return;
          }
        } while (this.mContext == null);
        localFrameLayout = c((Context)this.mContext.get());
      } while (localFrameLayout == null);
      localView = localFrameLayout.findViewById(2131376136);
    } while (localView == null);
    localFrameLayout.removeViewInLayout(localView);
  }
  
  public void a(Activity paramActivity, View paramView, String paramString, int paramInt1, float paramFloat, double paramDouble1, double paramDouble2, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, awig.a parama, int paramInt4)
  {
    a(paramActivity, paramView, paramString, paramInt1, paramFloat, paramDouble1, paramDouble2, paramLong, paramInt2, paramBoolean1, paramBoolean2, paramInt3, parama, paramInt4, 0, 0);
  }
  
  public void a(Activity paramActivity, View paramView, String paramString, int paramInt1, float paramFloat, double paramDouble1, double paramDouble2, long paramLong, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, int paramInt3, awig.a parama, int paramInt4, int paramInt5, int paramInt6)
  {
    this.CP = paramInt6;
    Wp();
    if ((paramActivity == null) || (paramView == null) || (paramInt1 < 0) || (paramInt1 > 1)) {}
    label29:
    do
    {
      do
      {
        return;
      } while (TextUtils.isEmpty(paramString));
      this.mContext = new WeakReference(paramActivity);
      paramActivity = new RelativeLayout(paramActivity);
      switch (this.CP)
      {
      }
      for (;;)
      {
        for (;;)
        {
          paramString = a(paramView, paramActivity, paramString, paramFloat, paramInt1, paramDouble1, paramDouble2, paramInt2, paramBoolean2, parama, paramInt4, paramInt5);
          if (paramString == null) {
            break;
          }
          paramInt4 = paramString[0] - paramInt4;
          paramInt5 = paramString[1];
          paramInt2 = paramInt3;
          if (paramInt1 == 0) {
            paramInt2 = -paramInt3;
          }
          paramInt1 = paramInt5 + paramInt2;
          switch (this.CP)
          {
          default: 
            return;
          case 0: 
            try
            {
              this.jdField_a_of_type_Awie.showAtLocation(paramView, 0, paramInt4, paramInt1);
              paramActivity.setVisibility(0);
              if (paramLong <= 0L) {
                break label29;
              }
              this.mHandler.postDelayed(this.az, paramLong);
              return;
            }
            catch (Exception paramActivity)
            {
              return;
            }
          }
        }
        paramActivity.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
        continue;
        paramActivity.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
      }
      paramView = c((Context)this.mContext.get());
    } while (paramView == null);
    paramActivity.setId(2131376136);
    paramString = (FrameLayout.LayoutParams)paramActivity.getLayoutParams();
    paramString.leftMargin = Math.max(paramInt4, aqnm.dip2px(12.0F));
    paramString.topMargin = paramInt1;
    paramString.rightMargin = aqnm.dip2px(12.0F);
    paramView.addView(paramActivity);
  }
  
  public int dpToPx(float paramFloat)
  {
    return Math.round(getDensity() * paramFloat);
  }
  
  public float getDensity()
  {
    float f = -1.0F;
    if (-1.0F < 0.0F) {
      f = BaseApplication.getContext().getResources().getDisplayMetrics().density;
    }
    return f;
  }
  
  public int getScreenWidth()
  {
    int i;
    int j;
    if (BaseApplication.getContext().getResources().getConfiguration().orientation == 2)
    {
      i = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      j = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      if (i <= j) {}
    }
    int k;
    do
    {
      return i;
      return j;
      j = BaseApplication.getContext().getResources().getDisplayMetrics().widthPixels;
      k = BaseApplication.getContext().getResources().getDisplayMetrics().heightPixels;
      i = j;
    } while (k > j);
    return k;
  }
  
  @TargetApi(16)
  public void setViewBackground(View paramView, Drawable paramDrawable)
  {
    if (paramView == null) {
      return;
    }
    if (Build.VERSION.SDK_INT < 16)
    {
      paramView.setBackgroundDrawable(paramDrawable);
      return;
    }
    paramView.setBackground(paramDrawable);
  }
  
  public static class a
  {
    public int ads;
    public int adt;
    public int ais;
    public int drawableId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awig
 * JD-Core Version:    0.7.0.1
 */