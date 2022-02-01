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
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zbw
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private zby jdField_a_of_type_Zby;
  private int b;
  private int c;
  
  public zbw(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
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
    this.jdField_a_of_type_Zby = null;
    this.jdField_a_of_type_AndroidContentContext = null;
  }
  
  public void a(LocalMediaInfo paramLocalMediaInfo)
  {
    if (this.jdField_a_of_type_Zby == null) {
      return;
    }
    this.jdField_a_of_type_Zby.a(paramLocalMediaInfo);
  }
  
  public void a(zby paramzby)
  {
    this.jdField_a_of_type_Zby = paramzby;
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
    Object localObject;
    if (paramView == null)
    {
      localObject = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      int i = (int)(ypx.a(this.jdField_a_of_type_AndroidContentContext.getResources()) * this.b);
      paramView = new ViewGroup.LayoutParams(this.b, i);
      ((ImageView)localObject).setScaleType(ImageView.ScaleType.CENTER_CROP);
      ((ImageView)localObject).setLayoutParams(paramView);
      paramView = new zbx();
      paramView.a = ((ImageView)localObject);
      paramView.a.setImageDrawable(new ColorDrawable(-12303292));
      ((View)localObject).setTag(paramView);
    }
    for (;;)
    {
      this.jdField_a_of_type_Zby.a(paramView.a, Integer.valueOf(paramInt));
      EventCollector.getInstance().onListGetView(paramInt, (View)localObject, paramViewGroup, getItemId(paramInt));
      return localObject;
      zbx localzbx = (zbx)paramView.getTag();
      localObject = paramView;
      paramView = localzbx;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbw
 * JD-Core Version:    0.7.0.1
 */