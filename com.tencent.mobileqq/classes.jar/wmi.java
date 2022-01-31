import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.chathistory.TroopMemberHistoryFragment;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.mobileqq.utils.ContactUtils;
import java.util.LinkedList;
import java.util.List;

public class wmi
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public wmi(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  boolean a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    return true;
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
    if (paramView == null)
    {
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130969076, null);
      paramViewGroup = new wmf();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363921));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363926));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362724));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131363205));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      wmh localwmh = (wmh)getItem(paramInt);
      paramViewGroup.b.setText(localwmh.jdField_a_of_type_JavaLangCharSequence);
      paramViewGroup.c.setText(localwmh.a());
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.b, localwmh.jdField_a_of_type_JavaLangString));
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a, 1, localwmh.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      paramView.setContentDescription(localwmh.jdField_a_of_type_JavaLangCharSequence + " " + localwmh.a());
      return paramView;
      paramViewGroup = (wmf)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wmi
 * JD-Core Version:    0.7.0.1
 */