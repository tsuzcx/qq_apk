import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class xdx
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<ImageView> jdField_a_of_type_AndroidUtilSparseArray;
  private xds jdField_a_of_type_Xds;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public xdx(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = xee.b(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = xee.b(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = xee.b(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = xee.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = xee.b(this.jdField_a_of_type_AndroidContentContext, 7.5F);
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private ImageView a(boolean paramBoolean)
  {
    ImageView localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(this.c, this.d);
    localImageView.setPadding(this.e, this.f, this.e, this.f);
    localImageView.setLayoutParams(localLayoutParams);
    localImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    if (paramBoolean) {}
    for (float f1 = 1.0F;; f1 = 0.5F)
    {
      wzc.a(localImageView, f1);
      return localImageView;
    }
  }
  
  public int a()
  {
    return this.c;
  }
  
  public void a()
  {
    super.notifyDataSetChanged();
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(xds paramxds)
  {
    if (paramxds == null) {
      wsv.b("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.jdField_a_of_type_Xds = paramxds;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Xds == null) {
      return 0;
    }
    return this.jdField_a_of_type_Xds.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Xds == null) {
      return null;
    }
    return this.jdField_a_of_type_Xds.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Xds == null) {
      return paramView;
    }
    if (paramView == null)
    {
      paramView = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      if (paramInt == this.jdField_a_of_type_Int) {
        wzc.a(paramView, 1.0F);
      }
      paramView.setContentDescription("");
      if (paramInt != 0) {
        break label111;
      }
      paramView.setContentDescription(alpo.a(2131706754));
      label60:
      paramViewGroup = (xdi)getItem(paramInt);
      if (paramViewGroup != null)
      {
        if (paramViewGroup.a == null) {
          break label128;
        }
        wsv.b("LogoIconAdapter", "logo is already load. ");
        paramView.setImageDrawable(paramViewGroup.a);
      }
    }
    for (;;)
    {
      return paramView;
      paramView = (ImageView)paramView;
      wzc.a(paramView, 0.5F);
      break;
      label111:
      if (paramInt != 1) {
        break label60;
      }
      paramView.setContentDescription(alpo.a(2131706753));
      break label60;
      label128:
      String str = (String)paramView.getTag(2131377396);
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramViewGroup.c)))
      {
        paramView.setTag(2131377396, paramViewGroup.c);
        xai.a().a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xdx
 * JD-Core Version:    0.7.0.1
 */