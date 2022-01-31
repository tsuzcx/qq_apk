import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;

public class vcm
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<ImageView> jdField_a_of_type_AndroidUtilSparseArray;
  private vch jdField_a_of_type_Vch;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public vcm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = vct.a(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = vct.a(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = vct.a(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = vct.a(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = vct.a(this.jdField_a_of_type_AndroidContentContext, 7.5F);
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
      uxr.a(localImageView, f1);
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
  
  public void a(vch paramvch)
  {
    if (paramvch == null) {
      urk.b("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.jdField_a_of_type_Vch = paramvch;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Vch == null) {
      return 0;
    }
    return this.jdField_a_of_type_Vch.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Vch == null) {
      return null;
    }
    return this.jdField_a_of_type_Vch.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Vch == null) {
      return paramView;
    }
    if (paramView == null)
    {
      paramView = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
      if (paramInt == this.jdField_a_of_type_Int) {
        uxr.a(paramView, 1.0F);
      }
      paramView.setContentDescription("");
      if (paramInt != 0) {
        break label111;
      }
      paramView.setContentDescription(ajjy.a(2131640586));
      label60:
      paramViewGroup = (vbx)getItem(paramInt);
      if (paramViewGroup != null)
      {
        if (paramViewGroup.a == null) {
          break label128;
        }
        urk.b("LogoIconAdapter", "logo is already load. ");
        paramView.setImageDrawable(paramViewGroup.a);
      }
    }
    for (;;)
    {
      return paramView;
      paramView = (ImageView)paramView;
      uxr.a(paramView, 0.5F);
      break;
      label111:
      if (paramInt != 1) {
        break label60;
      }
      paramView.setContentDescription(ajjy.a(2131640585));
      break label60;
      label128:
      String str = (String)paramView.getTag(2131311070);
      if ((TextUtils.isEmpty(str)) || (!str.equals(paramViewGroup.c)))
      {
        paramView.setTag(2131311070, paramViewGroup.c);
        uyx.a().a(this.jdField_a_of_type_AndroidContentContext, paramView, paramViewGroup.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vcm
 * JD-Core Version:    0.7.0.1
 */