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

class xjf
  extends xit<xje>
{
  private Context jdField_a_of_type_AndroidContentContext;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  
  protected xjf(xje paramxje, @NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    super(paramContext, paramViewGroup);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131377518));
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
        localObject2 = new RelativeLayout.LayoutParams(xsm.a(this.jdField_a_of_type_AndroidContentContext, 40.0F), xsm.a(this.jdField_a_of_type_AndroidContentContext, 62.0F));
        if (paramInt != 0) {
          ((RelativeLayout.LayoutParams)localObject2).leftMargin = xsm.a(this.jdField_a_of_type_AndroidContentContext, 1.0F);
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
      paramImageView.setImageResource(2130846402);
      return;
    case '0': 
      paramImageView.setImageResource(2130846403);
      return;
    case '1': 
      paramImageView.setImageResource(2130846404);
      return;
    case '2': 
      paramImageView.setImageResource(2130846405);
      return;
    case '3': 
      paramImageView.setImageResource(2130846406);
      return;
    case '4': 
      paramImageView.setImageResource(2130846407);
      return;
    case '5': 
      paramImageView.setImageResource(2130846408);
      return;
    case '6': 
      paramImageView.setImageResource(2130846409);
      return;
    case '7': 
      paramImageView.setImageResource(2130846410);
      return;
    case '8': 
      paramImageView.setImageResource(2130846411);
      return;
    }
    paramImageView.setImageResource(2130846412);
  }
  
  protected View a(@NonNull Context paramContext, ViewGroup paramViewGroup)
  {
    return LayoutInflater.from(paramContext).inflate(2131561651, paramViewGroup, false);
  }
  
  public void a(xje paramxje, int paramInt)
  {
    super.a(paramxje, paramInt);
    if (paramxje != null) {
      a(paramxje.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xjf
 * JD-Core Version:    0.7.0.1
 */