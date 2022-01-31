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

public class vvw
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private vvy jdField_a_of_type_Vvy;
  private int b;
  private int c;
  
  public vvw(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
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
    this.jdField_a_of_type_Vvy = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Vvy == null) {
      return;
    }
    this.jdField_a_of_type_Vvy.a(paramLocalMediaInfo);
  }
  
  public void a(vvy paramvvy)
  {
    this.jdField_a_of_type_Vvy = paramvvy;
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
      int i = (int)(vjo.a(this.jdField_a_of_type_AndroidContentContext.getResources()) * this.b);
      paramViewGroup = new ViewGroup.LayoutParams(this.b, i);
      paramView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      paramView.setLayoutParams(paramViewGroup);
      paramViewGroup = new vvx();
      paramViewGroup.a = paramView;
      paramViewGroup.a.setImageDrawable(new ColorDrawable(-12303292));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      this.jdField_a_of_type_Vvy.a(paramViewGroup.a, Integer.valueOf(paramInt));
      return paramView;
      paramViewGroup = (vvx)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vvw
 * JD-Core Version:    0.7.0.1
 */