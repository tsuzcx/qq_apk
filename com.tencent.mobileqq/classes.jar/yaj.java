import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.biz.qqstory.settings.QQStoryUserInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class yaj
  extends BaseAdapter
{
  List<QQStoryUserInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public yaj(List<QQStoryUserInfo> paramList)
  {
    Collection localCollection;
    if (localCollection != null)
    {
      this.jdField_a_of_type_JavaUtilList = new ArrayList(localCollection);
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
  }
  
  public void a(List<QQStoryUserInfo> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList(paramList);
    if (this.jdField_a_of_type_JavaUtilList != null) {
      Collections.sort(this.jdField_a_of_type_JavaUtilList);
    }
    super.notifyDataSetChanged();
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject;
    if (paramView == null)
    {
      localView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity).inflate(2131561847, null);
      paramView = new yak(this);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)localView.findViewById(2131366213));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131371647));
      paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a.widthPixels - agej.a(175.0F, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getResources()));
      paramView.jdField_a_of_type_AndroidWidgetButton = ((Button)localView.findViewById(2131365369));
      paramView.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
      localView.setTag(paramView);
      localObject = (QQStoryUserInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramView.jdField_a_of_type_JavaLangString = ((QQStoryUserInfo)localObject).uin;
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((QQStoryUserInfo)localObject).nick);
      paramView.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        break label289;
      }
      if (paramInt != 0) {
        break label254;
      }
      localView.setBackgroundResource(2130839456);
      label186:
      localObject = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.app.a(((QQStoryUserInfo)localObject).uin, true);
      if (localObject == null) {
        break label349;
      }
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      localObject = (yak)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject;
      break;
      label254:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        localView.setBackgroundResource(2130839447);
        break label186;
      }
      localView.setBackgroundResource(2130839450);
      break label186;
      label289:
      if (this.jdField_a_of_type_JavaUtilList.size() == 2)
      {
        if (paramInt == 0)
        {
          localView.setBackgroundResource(2130839456);
          break label186;
        }
        localView.setBackgroundResource(2130839447);
        break label186;
      }
      if (this.jdField_a_of_type_JavaUtilList.size() != 1) {
        break label186;
      }
      localView.setBackgroundResource(2130839447);
      break label186;
      label349:
      paramView.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bhmq.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yaj
 * JD-Core Version:    0.7.0.1
 */