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

public class wdt
  extends BaseAdapter
{
  private Context jdField_a_of_type_AndroidContentContext;
  private List jdField_a_of_type_JavaUtilList = new LinkedList();
  
  public wdt(TroopMemberHistoryFragment paramTroopMemberHistoryFragment, Context paramContext)
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
      paramView = View.inflate(this.jdField_a_of_type_AndroidContentContext, 2130969074, null);
      paramViewGroup = new wdq();
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363873));
      paramViewGroup.b = ((TextView)paramView.findViewById(2131363878));
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362701));
      paramViewGroup.c = ((TextView)paramView.findViewById(2131363183));
      paramView.setTag(paramViewGroup);
    }
    for (;;)
    {
      wds localwds = (wds)getItem(paramInt);
      paramViewGroup.b.setText(localwds.jdField_a_of_type_JavaLangCharSequence);
      paramViewGroup.c.setText(localwds.a());
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(ContactUtils.g(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a, this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.b, localwds.jdField_a_of_type_JavaLangString));
      FaceDrawable localFaceDrawable = FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqActivityChathistoryTroopMemberHistoryFragment.a, 1, localwds.jdField_a_of_type_JavaLangString);
      paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(localFaceDrawable);
      paramView.setContentDescription(localwds.jdField_a_of_type_JavaLangCharSequence + " " + localwds.a());
      return paramView;
      paramViewGroup = (wdq)paramView.getTag();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wdt
 * JD-Core Version:    0.7.0.1
 */