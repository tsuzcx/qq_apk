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

public class zfm
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private SparseArray<ImageView> jdField_a_of_type_AndroidUtilSparseArray;
  private zfh jdField_a_of_type_Zfh;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  
  public zfm(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.b = zft.b(this.jdField_a_of_type_AndroidContentContext, 30.0F);
    this.c = zft.b(this.jdField_a_of_type_AndroidContentContext, 50.0F);
    this.d = zft.b(this.jdField_a_of_type_AndroidContentContext, 45.0F);
    this.e = zft.b(this.jdField_a_of_type_AndroidContentContext, 10.0F);
    this.f = zft.b(this.jdField_a_of_type_AndroidContentContext, 7.5F);
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
      zar.a(localImageView, f1);
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
  
  public void a(zfh paramzfh)
  {
    if (paramzfh == null) {
      yuk.b("LogoIconAdapter", "setFacePanelAdapter: null.");
    }
    this.jdField_a_of_type_Zfh = paramzfh;
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_Zfh == null) {
      return 0;
    }
    return this.jdField_a_of_type_Zfh.a();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Zfh == null) {
      return null;
    }
    return this.jdField_a_of_type_Zfh.a(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if (this.jdField_a_of_type_Zfh == null)
    {
      localObject = paramView;
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return localObject;
    }
    label38:
    label83:
    zex localzex;
    if (paramView == null)
    {
      localObject = a(false);
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
      if (paramInt == this.jdField_a_of_type_Int) {
        zar.a((View)localObject, 1.0F);
      }
      ((ImageView)localObject).setContentDescription("");
      if (paramInt != 0) {
        break label142;
      }
      ((ImageView)localObject).setContentDescription(anzj.a(2131705264));
      localzex = (zex)getItem(paramInt);
      if (localzex != null)
      {
        if (localzex.a == null) {
          break label160;
        }
        yuk.b("LogoIconAdapter", "logo is already load. ");
        ((ImageView)localObject).setImageDrawable(localzex.a);
      }
    }
    for (;;)
    {
      break;
      localObject = (ImageView)paramView;
      zar.a((View)localObject, 0.5F);
      break label38;
      label142:
      if (paramInt != 1) {
        break label83;
      }
      ((ImageView)localObject).setContentDescription(anzj.a(2131705263));
      break label83;
      label160:
      String str = (String)((ImageView)localObject).getTag(2131378440);
      if ((TextUtils.isEmpty(str)) || (!str.equals(localzex.c)))
      {
        ((ImageView)localObject).setTag(2131378440, localzex.c);
        zbx.a().a(this.jdField_a_of_type_AndroidContentContext, (ImageView)localObject, localzex.c, this.b, this.b, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zfm
 * JD-Core Version:    0.7.0.1
 */