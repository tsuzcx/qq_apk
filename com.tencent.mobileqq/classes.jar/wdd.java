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

public class wdd
  extends BaseAdapter
{
  List<QQStoryUserInfo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public wdd(List<QQStoryUserInfo> paramList)
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity).inflate(2131561571, null);
      paramViewGroup = new wde(this);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131365912));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131370977));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setMaxWidth(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.a.widthPixels - aepi.a(175.0F, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryShieldListActivity.getResources()));
      paramViewGroup.jdField_a_of_type_AndroidWidgetButton = ((Button)paramView.findViewById(2131365088));
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
      paramView.setBackgroundResource(2130839270);
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
      paramViewGroup = (wde)paramView.getTag();
      break;
      label225:
      if (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1)
      {
        paramView.setBackgroundResource(2130839261);
      }
      else
      {
        paramView.setBackgroundResource(2130839264);
        continue;
        if (this.jdField_a_of_type_JavaUtilList.size() == 2)
        {
          if (paramInt == 0) {
            paramView.setBackgroundResource(2130839270);
          } else {
            paramView.setBackgroundResource(2130839261);
          }
        }
        else if (this.jdField_a_of_type_JavaUtilList.size() == 1) {
          paramView.setBackgroundResource(2130839261);
        }
      }
    }
    label315:
    paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(bdhj.a());
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdd
 * JD-Core Version:    0.7.0.1
 */