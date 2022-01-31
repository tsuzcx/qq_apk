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

class xew
  extends xek<xev>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  protected xew(xev paramxev, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377464));
  }
  
  private void a(int paramInt)
  {
    char[] arrayOfChar = String.valueOf(paramInt).toCharArray();
    paramInt = 0;
    Object localObject1;
    while (paramInt < arrayOfChar.length)
    {
      Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(xod.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), xod.a(this.jdField_a_of_type_AndroidContentContext, 62.0F));
        if (paramInt != 0) {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = xod.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
        }
        ((ImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_CENTER);
        ((ImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      a((ImageView)localObject1, arrayOfChar[paramInt]);
      paramInt += 1;
    }
    paramInt = arrayOfChar.length;
    while (paramInt < this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildCount())
    {
      localObject1 = this.jdField_a_of_type_AndroidWidgetLinearLayout.getChildAt(paramInt);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeView((View)localObject1);
      paramInt += 1;
    }
  }
  
  private void a(ImageView paramImageView, char paramChar)
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
      paramImageView.setImageResource(2130846329);
      return;
    case '0': 
      paramImageView.setImageResource(2130846330);
      return;
    case '1': 
      paramImageView.setImageResource(2130846331);
      return;
    case '2': 
      paramImageView.setImageResource(2130846332);
      return;
    case '3': 
      paramImageView.setImageResource(2130846333);
      return;
    case '4': 
      paramImageView.setImageResource(2130846334);
      return;
    case '5': 
      paramImageView.setImageResource(2130846335);
      return;
    case '6': 
      paramImageView.setImageResource(2130846336);
      return;
    case '7': 
      paramImageView.setImageResource(2130846337);
      return;
    case '8': 
      paramImageView.setImageResource(2130846338);
      return;
    }
    paramImageView.setImageResource(2130846339);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561633, paramViewGroup, false);
  }
  
  public void a(xev paramxev, int paramInt)
  {
    super.a(paramxev, paramInt);
    if (paramxev != null) {
      a(paramxev.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xew
 * JD-Core Version:    0.7.0.1
 */