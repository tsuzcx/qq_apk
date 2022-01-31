import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;

public class xox
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private xoz jdField_a_of_type_Xoz;
  private int b;
  private int c;
  
  public xox(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
  }
  
  public Bitmap a(int paramInt)
  {
    return null;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xoz = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Xoz == null) {
      return;
    }
    this.jdField_a_of_type_Xoz.a(paramLocalMediaInfo);
  }
  
  public void a(xoz paramxoz)
  {
    this.jdField_a_of_type_Xoz = paramxoz;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      int i = (int)(xcp.a(this.jdField_a_of_type_AndroidContentContext.getResources()) * this.b);
      paramViewGroup = new ViewGroup.LayoutParams(this.b, i);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setLayoutParams(paramViewGroup);
      paramViewGroup = new xoy();
      paramViewGroup.a = paramView;
      paramViewGroup.a.setImageDrawable(new ColorDrawable(-12303292));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xoz.a(paramViewGroup.a, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (xoy)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xox
 * JD-Core Version:    0.7.0.1
 */