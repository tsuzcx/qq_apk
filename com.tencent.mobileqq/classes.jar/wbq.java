import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.widgets.QCirclePushRankTopView;
import java.util.List;
import qqcircle.QQCircleDitto.StItemContainer;

public class wbq
  extends PagerAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  private List<View> jdField_a_of_type_JavaUtilList;
  
  public wbq(Context paramContext, List<View> paramList)
  {
    this.jdField_a_of_type_AndroidContentContext = paramList;
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public int a()
  {
    int i = getCount() / 2;
    return i - i % this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public List<View> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)paramObject);
  }
  
  public int getCount()
  {
    return 360;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    View localView = QCirclePushRankTopView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankTopView, (QQCircleDitto.StItemContainer)QCirclePushRankTopView.a(this.jdField_a_of_type_ComTencentBizQqcircleWidgetsQCirclePushRankTopView).get(paramInt % i));
    paramViewGroup.addView(localView);
    return localView;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbq
 * JD-Core Version:    0.7.0.1
 */