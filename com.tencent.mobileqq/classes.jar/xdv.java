import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;

class xdv
  extends LinearLayout
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private int b;
  private int c;
  
  public xdv(Context paramContext, int paramInt1, int paramInt2, float paramFloat, View.OnClickListener paramOnClickListener)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.jdField_a_of_type_Float = paramFloat;
    this.c = (this.jdField_a_of_type_Int / this.b);
    a();
  }
  
  private void a()
  {
    setOrientation(0);
    setGravity(17);
    int j = xee.b(getContext(), 3.0F);
    int k = (int)((this.c - j * 2) * this.jdField_a_of_type_Float);
    int i = 0;
    while (i < this.b)
    {
      View localView = LayoutInflater.from(getContext()).inflate(2131561471, null);
      localView.setLayoutParams(new ViewGroup.LayoutParams(this.c - j * 2, this.c - j * 2));
      ((ImageView)localView.findViewById(2131369801)).setPadding(k, k, k, k);
      addView(localView);
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
  
  public void a(xdl paramxdl, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * this.b;
    label31:
    Object localObject3;
    URLImageView localURLImageView;
    TextView localTextView;
    Object localObject2;
    String str;
    Object localObject1;
    if (paramInt1 == paramInt2 - 1)
    {
      paramInt1 = paramxdl.b();
      a(paramInt1 - i);
      paramInt2 = i;
      if (paramInt2 >= paramInt1) {
        return;
      }
      localObject3 = getChildAt(paramInt2 - i);
      localURLImageView = (URLImageView)((View)localObject3).findViewById(2131369801);
      localTextView = (TextView)((View)localObject3).findViewById(2131369813);
      localObject2 = (ProgressBar)((View)localObject3).findViewById(2131369811);
      str = paramxdl.b(paramInt2);
      localObject1 = paramxdl.a(paramInt2);
      if (localObject1 != null) {
        break label137;
      }
      wsv.e("LocationFaceAdapter", "FacePackage's thumbUri is empty , pkg : %s", new Object[] { paramxdl.toString() });
    }
    for (;;)
    {
      paramInt2 += 1;
      break label31;
      paramInt1 = this.b + i;
      break;
      label137:
      ((View)localObject3).setContentDescription(str);
      localTextView.setText(str);
      localURLImageView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
      localURLImageView.setTag(2131377387, Integer.valueOf(paramInt2));
      localObject3 = (Boolean)localURLImageView.getTag(2131377365);
      if ((localObject3 != null) && (((Boolean)localObject3).booleanValue()) && (((String)localObject1).equals(localURLImageView.getTag(2131377396))))
      {
        ((ProgressBar)localObject2).setVisibility(4);
      }
      else
      {
        localURLImageView.setTag(2131377396, localObject1);
        localURLImageView.setTag(2131377365, Boolean.valueOf(false));
        ((ProgressBar)localObject2).setVisibility(0);
        localObject2 = new xdw((String)localObject1, localURLImageView, (ProgressBar)localObject2);
        localURLImageView.setURLDrawableDownListener((URLDrawableDownListener)localObject2);
        localObject3 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject3).mFailedDrawable = baul.a;
        ((URLDrawable.URLDrawableOptions)localObject3).mLoadingDrawable = baul.a;
        ((URLDrawable.URLDrawableOptions)localObject3).mUseAutoScaleParams = false;
        localObject1 = URLDrawable.getDrawable((String)localObject1, (URLDrawable.URLDrawableOptions)localObject3);
        if (((URLDrawable)localObject1).getStatus() == 1) {
          ((xdw)localObject2).onLoadSuccessed(localURLImageView, (URLDrawable)localObject1);
        }
        localURLImageView.setImageDrawable((Drawable)localObject1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdv
 * JD-Core Version:    0.7.0.1
 */