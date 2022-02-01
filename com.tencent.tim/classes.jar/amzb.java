import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.theme.ThemeUtil;

public class amzb
  extends amzk
{
  public View He;
  public TextView Zk;
  public TextView hL;
  public TextView hM;
  
  public amzb(ViewGroup paramViewGroup, int paramInt)
  {
    super(paramViewGroup, paramInt);
  }
  
  public static int a(Context paramContext, View... paramVarArgs)
  {
    int j = paramContext.getResources().getDisplayMetrics().widthPixels;
    int k = paramVarArgs.length;
    int i = 0;
    while (i < k)
    {
      paramContext = paramVarArgs[i];
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
      paramContext.measure(0, 0);
      j = j - paramContext.getMeasuredWidth() - localLayoutParams.leftMargin - localLayoutParams.rightMargin;
      i += 1;
    }
    return j;
  }
  
  private void b(amrd paramamrd)
  {
    if (getTitleView() != null) {
      getTitleView().setText(paramamrd.getTitle());
    }
    if (z() != null) {
      z().setText(paramamrd.f());
    }
    if ((this.Zk != null) && (!TextUtils.isEmpty(paramamrd.ccb)))
    {
      this.Zk.setText(paramamrd.ccb);
      z().setMaxWidth(a(this.view.getContext(), new View[] { getTitleView(), this.Zk, this.DF }) - wja.dp2px(75.0F, z().getResources()));
    }
    ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#e7e7e7"));
    Object localObject;
    if (w() != null)
    {
      if (paramamrd.dDC != 0)
      {
        w().setImageResource(paramamrd.dDC);
        w().setVisibility(0);
      }
    }
    else if (this.He != null)
    {
      localObject = getView().getTag(2131381961);
      if (!(localObject instanceof Integer)) {
        break label545;
      }
    }
    label523:
    label535:
    label545:
    for (int i = ((Integer)localObject).intValue();; i = -1)
    {
      if (i > 0)
      {
        this.He.setVisibility(0);
        label212:
        if ((N() != null) && (!TextUtils.isEmpty(paramamrd.getDescription())))
        {
          N().setText(paramamrd.getDescription());
          N().setVisibility(0);
        }
        if (v() != null)
        {
          if (!paramamrd.DR()) {
            break label523;
          }
          v().setVisibility(0);
        }
      }
      for (;;)
      {
        if (TextUtils.isEmpty(paramamrd.ccd)) {
          break label535;
        }
        i = getView().getResources().getDimensionPixelSize(2131298754);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
        ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "rightIcon";
        ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
        ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
        paramamrd = URLDrawable.getDrawable(paramamrd.ccd, (URLDrawable.URLDrawableOptions)localObject);
        if ((paramamrd.getStatus() != 1) && (paramamrd.getStatus() != 0)) {
          paramamrd.restartDownload();
        }
        v().setImageDrawable(paramamrd);
        v().setVisibility(0);
        return;
        if (!TextUtils.isEmpty(paramamrd.iconUrl))
        {
          i = getView().getResources().getDimensionPixelSize(2131297863);
          localObject = URLDrawable.URLDrawableOptions.obtain();
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = i;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = i;
          ((URLDrawable.URLDrawableOptions)localObject).mMemoryCacheKeySuffix = "isAvatar";
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localColorDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localColorDrawable;
          localObject = URLDrawable.getDrawable(paramamrd.iconUrl, (URLDrawable.URLDrawableOptions)localObject);
          ((URLDrawable)localObject).setDecodeHandler(aqbn.b);
          if ((((URLDrawable)localObject).getStatus() != 1) && (((URLDrawable)localObject).getStatus() != 0)) {
            ((URLDrawable)localObject).restartDownload();
          }
          w().setImageDrawable((Drawable)localObject);
          w().setVisibility(0);
          break;
        }
        w().setVisibility(8);
        break;
        if (i != 0) {
          break label212;
        }
        this.He.setVisibility(8);
        break label212;
        v().setVisibility(8);
      }
      v().setVisibility(8);
      return;
    }
  }
  
  public void a(amrd paramamrd)
  {
    refreshView();
    switch (paramamrd.blx)
    {
    case -2: 
    default: 
      return;
    }
    b(paramamrd);
  }
  
  protected void aDR()
  {
    super.aDR();
    this.He = this.view.findViewById(2131366004);
    switch (this.acL)
    {
    default: 
    case 2131560005: 
      do
      {
        return;
        this.hL = ((TextView)this.view.findViewById(2131379402));
        this.hM = ((TextView)this.view.findViewById(2131379404));
        getTitleView().setMaxWidth(a(this.view.getContext(), new View[] { this.hL, this.hM, this.DF }));
        getTitleView().setTextColor(amxk.xk());
      } while (!ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null));
      return;
    }
    this.Zk = ((TextView)this.view.findViewById(2131371972));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amzb
 * JD-Core Version:    0.7.0.1
 */