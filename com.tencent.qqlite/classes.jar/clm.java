import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.CreateFaceToFaceDiscussionActivity;
import java.util.List;
import tencent.im.nearfield_discuss.nearfield_discuss.UserProfile;

public class clm
  extends BaseAdapter
{
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  cln jdField_a_of_type_Cln;
  
  public clm(CreateFaceToFaceDiscussionActivity paramCreateFaceToFaceDiscussionActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramCreateFaceToFaceDiscussionActivity.jdField_a_of_type_AndroidContentContext);
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() < 50) {
      return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size() + 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList == null) {
      return null;
    }
    return (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903485, null);
      this.jdField_a_of_type_Cln = new cln(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
      this.jdField_a_of_type_Cln.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296453));
      this.jdField_a_of_type_Cln.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296455));
      paramView.setTag(this.jdField_a_of_type_Cln);
      if ((paramInt != getCount() - 1) || (getCount() >= 50)) {
        break label237;
      }
      CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView);
    }
    for (;;)
    {
      if (paramInt == getCount() - 1)
      {
        if (paramInt <= 11) {
          break label264;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.b.getVisibility() == 0) {
          this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.c.setVisibility(0);
        }
      }
      return paramView;
      this.jdField_a_of_type_Cln = ((cln)paramView.getTag());
      if (!this.jdField_a_of_type_Cln.jdField_a_of_type_Boolean) {
        break;
      }
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903485, null);
      this.jdField_a_of_type_Cln = new cln(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity);
      this.jdField_a_of_type_Cln.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131296453));
      this.jdField_a_of_type_Cln.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131296455));
      paramView.setTag(this.jdField_a_of_type_Cln);
      this.jdField_a_of_type_Cln.jdField_a_of_type_Boolean = false;
      break;
      label237:
      CreateFaceToFaceDiscussionActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity, paramView, (nearfield_discuss.UserProfile)this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.jdField_a_of_type_JavaUtilList.get(paramInt));
    }
    label264:
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberCreateFaceToFaceDiscussionActivity.c.setVisibility(4);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clm
 * JD-Core Version:    0.7.0.1
 */