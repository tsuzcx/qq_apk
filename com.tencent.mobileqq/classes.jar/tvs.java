import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class tvs
  extends BaseAdapter
  implements aoog
{
  Activity jdField_a_of_type_AndroidAppActivity;
  public aoof a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  protected List<tvr> a;
  private tvn jdField_a_of_type_Tvn;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public tvs(Activity paramActivity, QQAppInterface paramQQAppInterface, tvn paramtvn)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_JavaUtilList = new ArrayList(11);
    this.jdField_a_of_type_Aoof = new aoof(paramActivity, paramQQAppInterface);
    this.jdField_a_of_type_Aoof.a(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Tvn = paramtvn;
    this.jdField_a_of_type_Boolean = ThemeUtil.isInNightMode(paramQQAppInterface);
    if (Build.MANUFACTURER.toUpperCase().equals("XIAOMI")) {
      this.b = true;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilList.clear();
  }
  
  public void a(List<tvr> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() >= 10) {}
      for (int i = 10;; i = paramList.size())
      {
        int j = 0;
        while (j < i)
        {
          a((tvr)paramList.get(j));
          j += 1;
        }
      }
      paramList = new tvr();
      paramList.a = -1L;
      a(paramList);
    }
  }
  
  public void a(tvr paramtvr)
  {
    if (paramtvr != null) {
      this.jdField_a_of_type_JavaUtilList.add(paramtvr);
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_Aoof.a(null);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramInt > getCount()) || (paramInt < 0)) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    if (paramView == null)
    {
      localView = this.jdField_a_of_type_AndroidAppActivity.getLayoutInflater().inflate(2131560380, null);
      paramView = new tvt(this, localView, this.jdField_a_of_type_Boolean);
      localView.setVisibility(0);
      localView.setFocusable(false);
      localView.setTag(paramView);
    }
    for (;;)
    {
      paramView.a((tvr)this.jdField_a_of_type_JavaUtilList.get(paramInt), paramInt);
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      tvt localtvt = (tvt)paramView.getTag();
      localView = paramView;
      paramView = localtvt;
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvs
 * JD-Core Version:    0.7.0.1
 */