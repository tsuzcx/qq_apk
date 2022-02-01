import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zbr
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<ImageView> jdField_a_of_type_AndroidUtilSparseArray;
  private zbm jdField_a_of_type_Zbm;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public zbr(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = zby.b(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = zby.b(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = zby.b(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = zby.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = zby.b(this.jdField_a_of_type_AndroidContentContext, 7.5F);
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
      yww.a(localImageView, f1);
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
  
  public void a(zbm paramzbm)
  {
    if (paramzbm == null) {
      yqp.b("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.jdField_a_of_type_Zbm = paramzbm;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Zbm == null) {
      return 0;
    }
    return this.jdField_a_of_type_Zbm.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Zbm == null) {
      return null;
    }
    return this.jdField_a_of_type_Zbm.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.jdField_a_of_type_Zbm == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    label38:
    label83:
    zbc localzbc;
    if (paramView == null)
    {
      localObject = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      if (paramInt == this.jdField_a_of_type_Int) {
        yww.a((View)localObject, 1.0F);
      }
      ((ImageView)localObject).setContentDescription("");
      if (paramInt != 0) {
        break label142;
      }
      ((ImageView)localObject).setContentDescription(anni.a(2131705157));
      localzbc = (zbc)getItem(paramInt);
      if (localzbc != null)
      {
        if (localzbc.a == null) {
          break label160;
        }
        yqp.b("LogoIconAdapter", "logo is already load. ");
        ((ImageView)localObject).setImageDrawable(localzbc.a);
      }
    }
    for (;;)
    {
      break;
      localObject = (ImageView)paramView;
      yww.a((View)localObject, 0.5F);
      break label38;
      label142:
      if (paramInt != 1) {
        break label83;
      }
      ((ImageView)localObject).setContentDescription(anni.a(2131705156));
      break label83;
      label160:
      String str = (String)((ImageView)localObject).getTag(2131378283);
      if ((TextUtils.isEmpty(str)) || (!str.equals(localzbc.c)))
      {
        ((ImageView)localObject).setTag(2131378283, localzbc.c);
        yyc.a().a(this.jdField_a_of_type_AndroidContentContext, (ImageView)localObject, localzbc.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zbr
 * JD-Core Version:    0.7.0.1
 */