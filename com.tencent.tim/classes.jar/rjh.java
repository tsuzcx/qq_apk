import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;

public class rjh
  extends rja
{
  public int blH;
  
  public rjh(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramString, paramInt2);
    this.blH = paramInt3;
  }
  
  public boolean LD()
  {
    return true;
  }
  
  @NonNull
  public rja.a a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return new rjh.a(paramContext, paramViewGroup);
  }
  
  @NonNull
  public Class<? extends rja.a> c()
  {
    return rjh.a.class;
  }
  
  public void xD(int paramInt)
  {
    ram.b("WeatherFilterData", "updateWeather:%s", Integer.valueOf(paramInt));
    this.blH = paramInt;
  }
  
  class a
    extends rja.a<rjh>
  {
    private LinearLayout fb;
    private Context mContext;
    
    protected a(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      super(paramViewGroup);
      this.mContext = paramContext;
      this.fb = ((LinearLayout)this.mItemView.findViewById(2131379310));
    }
    
    private void b(ImageView paramImageView, char paramChar)
    {
      if (paramImageView == null) {
        return;
      }
      switch (paramChar)
      {
      case '.': 
      case '/': 
      default: 
        return;
      case '-': 
        paramImageView.setImageResource(2130847723);
        return;
      case '0': 
        paramImageView.setImageResource(2130847724);
        return;
      case '1': 
        paramImageView.setImageResource(2130847725);
        return;
      case '2': 
        paramImageView.setImageResource(2130847726);
        return;
      case '3': 
        paramImageView.setImageResource(2130847727);
        return;
      case '4': 
        paramImageView.setImageResource(2130847728);
        return;
      case '5': 
        paramImageView.setImageResource(2130847729);
        return;
      case '6': 
        paramImageView.setImageResource(2130847730);
        return;
      case '7': 
        paramImageView.setImageResource(2130847731);
        return;
      case '8': 
        paramImageView.setImageResource(2130847732);
        return;
      }
      paramImageView.setImageResource(2130847733);
    }
    
    private void xE(int paramInt)
    {
      char[] arrayOfChar = String.valueOf(paramInt).toCharArray();
      paramInt = 0;
      Object localObject1;
      while (paramInt < arrayOfChar.length)
      {
        Object localObject2 = (ImageView)this.fb.getChildAt(paramInt);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = new ImageView(this.mContext);
          localObject2 = new RelativeLayout.LayoutParams(rpq.dip2px(this.mContext, 40.0F), rpq.dip2px(this.mContext, 62.0F));
          if (paramInt != 0) {
            ((RelativeLayout.LayoutParams)localObject2).leftMargin = rpq.dip2px(this.mContext, 1.0F);
          }
          ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
          ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.fb.addView((View)localObject1);
        }
        b((ImageView)localObject1, arrayOfChar[paramInt]);
        paramInt += 1;
      }
      paramInt = arrayOfChar.length;
      while (paramInt < this.fb.getChildCount())
      {
        localObject1 = this.fb.getChildAt(paramInt);
        this.fb.removeView((View)localObject1);
        paramInt += 1;
      }
    }
    
    public void a(rjh paramrjh, int paramInt)
    {
      super.a(paramrjh, paramInt);
      if (paramrjh != null) {
        xE(paramrjh.blH);
      }
    }
    
    protected View b(@NonNull Context paramContext, ViewGroup paramViewGroup)
    {
      return LayoutInflater.from(paramContext).inflate(2131562044, paramViewGroup, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjh
 * JD-Core Version:    0.7.0.1
 */