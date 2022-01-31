import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class ayt
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private int b;
  
  public ayt(NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int getCount()
  {
    if (this.b == 0)
    {
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size() > 6) {
        return 6;
      }
      return NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size();
    }
    if (this.b == 1)
    {
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size() > 6) {
        return Math.min(6, NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size() - 6);
      }
      return 0;
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.b == 0) {
      return NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).get(paramInt);
    }
    if (this.b == 1) {
      return NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).get(paramInt + 6);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.getLayoutInflater().inflate(2130903516, paramViewGroup, false);
    paramViewGroup = (URLImageView)paramView.findViewById(2131297359);
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramViewGroup.setLayoutParams(new RelativeLayout.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n));
    Object localObject = (ayu)getItem(paramInt);
    if (localObject == NearbyPeopleProfileActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity))
    {
      paramViewGroup.setBackgroundResource(2130838774);
      paramViewGroup.setContentDescription("添加照片");
    }
    label354:
    do
    {
      do
      {
        return paramView;
        if ((this.jdField_a_of_type_Int == 0) && (this.b == 0) && (paramInt == 0)) {
          paramView.findViewById(2131298290).setVisibility(0);
        }
        if (this.b == 0) {
          paramView.setContentDescription("照片" + (paramInt + 1));
        }
        for (;;)
        {
          try
          {
            if ((((ayu)localObject).a == null) || (((ayu)localObject).a.length() <= 0)) {
              break label354;
            }
            LocalMediaInfo localLocalMediaInfo = new LocalMediaInfo();
            localLocalMediaInfo.a = ((ayu)localObject).a;
            localLocalMediaInfo.f = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n;
            localLocalMediaInfo.g = this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n;
            localObject = new URL("albumthumb", "", LocalMediaInfo.a(localLocalMediaInfo));
            if (localObject == null) {
              break;
            }
            paramViewGroup.setImageDrawable(URLDrawable.getDrawable((URL)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n, NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity), NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity)));
            return paramView;
          }
          catch (MalformedURLException paramViewGroup) {}
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("NearbyPeopleProfileActivity", 2, "GridAdapter.getView() new URL(). " + paramViewGroup.getMessage(), paramViewGroup);
          return paramView;
          if (this.b == 1) {
            paramView.setContentDescription("照片" + (paramInt + 1 + 6));
          }
        }
      } while (StringUtil.b(((ayu)localObject).b));
      localObject = new URL(((ayu)localObject).b);
    } while (localObject == null);
    paramViewGroup.setImageDrawable(URLDrawable.getDrawable((URL)localObject, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n, this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity.n, NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity), NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity)));
    return paramView;
  }
  
  public void notifyDataSetChanged()
  {
    if (this.jdField_a_of_type_Int == 0)
    {
      if (NearbyPeopleProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity).size() > 1) {
        break label33;
      }
      NearbyPeopleProfileActivity.u(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity);
    }
    for (;;)
    {
      super.notifyDataSetChanged();
      return;
      label33:
      NearbyPeopleProfileActivity.v(this.jdField_a_of_type_ComTencentMobileqqActivityNearbyPeopleProfileActivity);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     ayt
 * JD-Core Version:    0.7.0.1
 */