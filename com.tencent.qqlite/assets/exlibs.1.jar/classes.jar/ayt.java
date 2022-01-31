import android.os.Build.VERSION;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import java.util.ArrayList;

public class ayt
  extends PagerAdapter
{
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  public GridView a;
  public ayr a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  public GridView b;
  public ayr b;
  
  public ayt(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, int paramInt, ViewPager paramViewPager)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = paramViewPager;
    if (paramInt == 0)
    {
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramNearbyPeopleProfileActivity.findViewById(2131298297));
      this.jdField_a_of_type_Ayr = new ayr(paramNearbyPeopleProfileActivity, 0, 0);
      this.jdField_a_of_type_AndroidWidgetGridView.setOnItemClickListener(paramNearbyPeopleProfileActivity);
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_a_of_type_AndroidWidgetGridView.setAdapter(this.jdField_a_of_type_Ayr);
      if (paramInt != 0) {
        break label193;
      }
      this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)paramNearbyPeopleProfileActivity.findViewById(2131298298));
      this.jdField_b_of_type_Ayr = new ayr(paramNearbyPeopleProfileActivity, 0, 1);
    }
    for (;;)
    {
      this.jdField_b_of_type_AndroidWidgetGridView.setOnItemClickListener(paramNearbyPeopleProfileActivity);
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_b_of_type_AndroidWidgetGridView.setOverScrollMode(2);
      }
      this.jdField_b_of_type_AndroidWidgetGridView.setAdapter(this.jdField_b_of_type_Ayr);
      return;
      if (paramInt != 1) {
        break;
      }
      this.jdField_a_of_type_AndroidWidgetGridView = ((GridView)paramNearbyPeopleProfileActivity.findViewById(2131298255));
      this.jdField_a_of_type_Ayr = new ayr(paramNearbyPeopleProfileActivity, 1, 0);
      break;
      label193:
      if (paramInt == 1)
      {
        this.jdField_b_of_type_AndroidWidgetGridView = ((GridView)paramNearbyPeopleProfileActivity.findViewById(2131298256));
        this.jdField_b_of_type_Ayr = new ayr(paramNearbyPeopleProfileActivity, 1, 1);
      }
    }
  }
  
  public void a()
  {
    notifyDataSetChanged();
    this.jdField_a_of_type_Ayr.notifyDataSetChanged();
    this.jdField_b_of_type_Ayr.notifyDataSetChanged();
    NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity, this.jdField_a_of_type_AndroidSupportV4ViewViewPager);
    NearbyPeopleProfileActivity.s(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity);
    if (this.jdField_a_of_type_AndroidSupportV4ViewViewPager == NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity)) {
      NearbyPeopleProfileActivity.t(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity);
    }
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject) {}
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public int getCount()
  {
    if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size() > 6) {
      return 2;
    }
    return 1;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_AndroidWidgetGridView;
    }
    return this.jdField_b_of_type_AndroidWidgetGridView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayt
 * JD-Core Version:    0.7.0.1
 */