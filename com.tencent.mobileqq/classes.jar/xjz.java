import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

class xjz
  extends PagerAdapter
{
  private List<View> jdField_a_of_type_JavaUtilList;
  
  public xjz(List<View> paramList)
  {
    Object localObject;
    this.jdField_a_of_type_JavaUtilList = localObject;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup.addView((View)this.jdField_a_of_type_JavaUtilList.get(paramInt));
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xjz
 * JD-Core Version:    0.7.0.1
 */