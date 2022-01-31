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
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class txj
  extends BaseAdapter
{
  List<QQStoryUserInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public txj(List<QQStoryUserInfo> paramList)
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
    Object localObject;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity).inflate(2131495773, null);
      paramViewGroup = new txk(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131300226));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131304981));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a.widthPixels - aciy.a(175.0F, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getResources()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131299434));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity);
      paramView.setTag(paramViewGroup);
      localObject = (QQStoryUserInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      paramViewGroup.jdField_a_of_type_JavaLangString = ((QQStoryUserInfo)localObject).uin;
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(((QQStoryUserInfo)localObject).nick);
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton.setTag(localObject);
      if (this.jdField_a_of_type_JavaUtilList.size() <= 2) {
        break label258;
      }
      if (paramInt != 0) {
        break label225;
      }
      paramView.setBackgroundResource(2130839160);
    }
    label258:
    for (;;)
    {
      localObject = this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.app.a(((QQStoryUserInfo)localObject).uin, true);
      if (localObject == null) {
        break label315;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap((Bitmap)localObject);
      return paramView;
      paramViewGroup = (txk)paramView.getTag();
      break;
      label225:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramView.setBackgroundResource(2130839151);
      }
      else
      {
        paramView.setBackgroundResource(2130839154);
        continue;
        if (this.jdField_a_of_type_JavaUtilList.size() == 2)
        {
          if (paramInt == 0) {
            paramView.setBackgroundResource(2130839160);
          } else {
            paramView.setBackgroundResource(2130839151);
          }
        }
        else if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
          paramView.setBackgroundResource(2130839151);
        }
      }
    }
    label315:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bacm.a());
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txj
 * JD-Core Version:    0.7.0.1
 */