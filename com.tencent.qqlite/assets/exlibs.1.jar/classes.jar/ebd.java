import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import com.tencent.mobileqq.richstatus.ActionListActivity;
import com.tencent.mobileqq.richstatus.StateTag;
import java.util.ArrayList;
import java.util.Iterator;

public class ebd
  extends PagerAdapter
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private ebd(ActionListActivity paramActionListActivity) {}
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      StateTag localStateTag = (StateTag)localIterator.next();
      GridView localGridView = new GridView(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity.getApplicationContext());
      localGridView.setNumColumns(3);
      localGridView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
      localGridView.setSelector(new ColorDrawable(0));
      localGridView.setScrollingCacheEnabled(false);
      localGridView.setAdapter(new ebc(this.jdField_a_of_type_ComTencentMobileqqRichstatusActionListActivity, localStateTag.jdField_a_of_type_JavaUtilArrayList));
      this.jdField_a_of_type_JavaUtilArrayList.add(localGridView);
    }
    super.notifyDataSetChanged();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    GridView localGridView = (GridView)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    paramViewGroup.addView(localGridView);
    return localGridView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ebd
 * JD-Core Version:    0.7.0.1
 */