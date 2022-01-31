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

public class xko
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private xkq jdField_a_of_type_Xkq;
  private int b;
  private int c;
  
  public xko(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
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
    this.jdField_a_of_type_Xkq = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Xkq == null) {
      return;
    }
    this.jdField_a_of_type_Xkq.a(paramLocalMediaInfo);
  }
  
  public void a(xkq paramxkq)
  {
    this.jdField_a_of_type_Xkq = paramxkq;
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
      int i = (int)(wyg.a(this.jdField_a_of_type_AndroidContentContext.getResources()) * this.b);
      paramViewGroup = new ViewGroup.LayoutParams(this.b, i);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setLayoutParams(paramViewGroup);
      paramViewGroup = new xkp();
      paramViewGroup.a = paramView;
      paramViewGroup.a.setImageDrawable(new ColorDrawable(-12303292));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Xkq.a(paramViewGroup.a, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (xkp)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xko
 * JD-Core Version:    0.7.0.1
 */