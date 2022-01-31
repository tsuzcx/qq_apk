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

public class clj
  extends BaseAdapter
{
  private clj(DiscussionListInnerFrame paramDiscussionListInnerFrame) {}
  
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
      localObject = (clk)paramView.getTag();
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
      paramViewGroup = this.a.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903630, paramViewGroup, false);
      paramView = new clk(this.a, null);
      paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296439));
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131298793));
      paramView.b = ((TextView)paramViewGroup.findViewById(2131298794));
      paramViewGroup.setTag(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     clj
 * JD-Core Version:    0.7.0.1
 */