import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

class xii
  extends LinearLayout
{
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private int b;
  private int c;
  private int d;
  
  public xii(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    paramInt1 /= this.b;
    this.c = ((int)(paramInt1 * paramFloat));
    this.d = (paramInt1 - this.c * 2);
    a();
  }
  
  private void a()
  {
    int i = 0;
    setOrientation(0);
    setGravity(17);
    int j = this.jdField_a_of_type_Int / this.b;
    while (i < this.b)
    {
      ImageView localImageView = new ImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(j, j);
      if (i == 0) {
        localLayoutParams.leftMargin = xin.b(getContext(), 7.0F);
      }
      if (i == this.b - 1) {
        localLayoutParams.rightMargin = xin.b(getContext(), 7.0F);
      }
      localImageView.setLayoutParams(localLayoutParams);
      localImageView.setPadding(this.c, this.c, this.c, this.c);
      addView(localImageView);
      i += 1;
    }
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    int j;
    for (;;)
    {
      j = paramInt;
      if (i >= paramInt) {
        break;
      }
      j = paramInt;
      if (i >= getChildCount()) {
        break;
      }
      getChildAt(i).setVisibility(0);
      i += 1;
    }
    while ((j < this.b) && (j < getChildCount()))
    {
      getChildAt(j).setVisibility(4);
      j += 1;
    }
  }
  
  public void a(xhx paramxhx, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.b;
    if (paramInt1 == paramInt2 - 1) {}
    for (paramInt1 = paramxhx.b();; paramInt1 = this.b + i)
    {
      a(paramInt1 - i);
      paramInt2 = i;
      while (paramInt2 < paramInt1)
      {
        ImageView localImageView = (ImageView)getChildAt(paramInt2 - i);
        localImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        String str = paramxhx.a(paramInt2);
        localImageView.setTag(2131377450, str);
        localImageView.setTag(2131377441, Integer.valueOf(paramInt2));
        localImageView.setContentDescription(alud.a(2131707992) + paramInt2);
        xer.a().a(getContext(), localImageView, str, this.d, this.d, null);
        paramInt2 += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xii
 * JD-Core Version:    0.7.0.1
 */