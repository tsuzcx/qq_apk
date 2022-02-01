import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.nearby.profilecard.LabelContainer;

public class akbx
  extends akbw
{
  protected View Fe;
  
  protected LabelContainer a(View paramView, int paramInt1, ajuu paramajuu, int paramInt2)
  {
    paramajuu = (ImageView)paramView.findViewById(2131381174);
    if (paramInt1 == 7) {
      paramajuu.setVisibility(8);
    }
    for (;;)
    {
      if (this.mContainer.getChildCount() != 0)
      {
        paramajuu = (LinearLayout.LayoutParams)paramView.getLayoutParams();
        paramajuu.topMargin = riw.dip2px(this.mContext, 16.0F);
        paramView.setLayoutParams(paramajuu);
      }
      paramInt1 = riw.dip2px(this.mContext, 7.0F);
      paramInt2 = riw.dip2px(this.mContext, 7.0F);
      paramView = (LabelContainer)paramView.findViewById(2131370115);
      paramView.setSpace(paramInt1, paramInt2);
      return paramView;
      paramajuu.setImageResource(lY[paramInt1]);
    }
  }
  
  public void a(Context paramContext, LinearLayout paramLinearLayout, View paramView)
  {
    super.b(paramContext, paramLinearLayout);
    this.Fe = paramView;
    this.Fe.setVisibility(8);
  }
  
  public boolean a(ajuu[] paramArrayOfajuu)
  {
    if (super.a(paramArrayOfajuu))
    {
      this.mContainer.setVisibility(0);
      this.Fe.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.mContainer.setVisibility(8);
      this.Fe.setVisibility(8);
    }
  }
  
  protected int tU()
  {
    return 2131561437;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbx
 * JD-Core Version:    0.7.0.1
 */