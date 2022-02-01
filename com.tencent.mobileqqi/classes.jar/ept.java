import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.selectmember.DiscussionListInnerFrame;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.ArrayList;

public class ept
  extends BaseAdapter
{
  private ept(DiscussionListInnerFrame paramDiscussionListInnerFrame) {}
  
  public int getCount()
  {
    if (this.a.jdField_a_of_type_JavaUtilArrayList == null) {
      return 0;
    }
    return this.a.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.jdField_a_of_type_JavaUtilArrayList.size())) {
      return this.a.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null))
    {
      localObject = (epu)paramView.getTag();
      paramViewGroup = paramView;
      paramView = (View)localObject;
    }
    for (;;)
    {
      localObject = (DiscussionInfo)getItem(paramInt);
      String str1 = ((DiscussionInfo)localObject).uin;
      String str2 = ContactUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity, (DiscussionInfo)localObject);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(str2);
      paramInt = ((FriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8)).c(str1);
      paramView.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(paramInt) }));
      paramView.b.setContentDescription(" " + paramInt + "人");
      paramView.jdField_a_of_type_AndroidWidgetImageView.setBackgroundDrawable(FaceDrawable.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 101, str1));
      paramView.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject);
      paramViewGroup.setOnClickListener(this.a);
      return paramViewGroup;
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903959, paramViewGroup, false);
      paramView = new epu(this.a, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131230985));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131234455));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131234456));
      paramViewGroup.setTag(paramView);
      if (paramInt == 0) {
        paramViewGroup.setBackgroundResource(2130837877);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     ept
 * JD-Core Version:    0.7.0.1
 */