import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ygn
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<ImageView> jdField_a_of_type_AndroidUtilSparseArray;
  private ygi jdField_a_of_type_Ygi;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public ygn(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = DisplayUtil.dip2px(this.jdField_a_of_type_AndroidContentContext, 7.5F);
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
      yca.a(localImageView, f1);
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
  
  public void a(ygi paramygi)
  {
    if (paramygi == null) {
      xvv.b("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.jdField_a_of_type_Ygi = paramygi;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Ygi == null) {
      return 0;
    }
    return this.jdField_a_of_type_Ygi.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Ygi == null) {
      return null;
    }
    return this.jdField_a_of_type_Ygi.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.jdField_a_of_type_Ygi == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    label38:
    label83:
    yfy localyfy;
    if (paramView == null)
    {
      localObject = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      if (paramInt == this.jdField_a_of_type_Int) {
        yca.a((View)localObject, 1.0F);
      }
      ((ImageView)localObject).setContentDescription("");
      if (paramInt != 0) {
        break label142;
      }
      ((ImageView)localObject).setContentDescription(amtj.a(2131705494));
      localyfy = (yfy)getItem(paramInt);
      if (localyfy != null)
      {
        if (localyfy.a == null) {
          break label160;
        }
        xvv.b("LogoIconAdapter", "logo is already load. ");
        ((ImageView)localObject).setImageDrawable(localyfy.a);
      }
    }
    for (;;)
    {
      break;
      localObject = (ImageView)paramView;
      yca.a((View)localObject, 0.5F);
      break label38;
      label142:
      if (paramInt != 1) {
        break label83;
      }
      ((ImageView)localObject).setContentDescription(amtj.a(2131705493));
      break label83;
      label160:
      String str = (String)((ImageView)localObject).getTag(2131378207);
      if ((TextUtils.isEmpty(str)) || (!str.equals(localyfy.c)))
      {
        ((ImageView)localObject).setTag(2131378207, localyfy.c);
        ydf.a().a(this.jdField_a_of_type_AndroidContentContext, (ImageView)localObject, localyfy.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ygn
 * JD-Core Version:    0.7.0.1
 */