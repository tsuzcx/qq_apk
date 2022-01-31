import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.TroopTransferActivity;
import com.tencent.mobileqq.activity.TroopTransferActivity.TroopMemberItem;
import com.tencent.mobileqq.adapter.FacePreloadBaseAdapter;
import java.util.List;

public class ujv
  extends FacePreloadBaseAdapter
{
  private List jdField_a_of_type_JavaUtilList;
  
  public ujv(TroopTransferActivity paramTroopTransferActivity, List paramList)
  {
    super(paramTroopTransferActivity, paramTroopTransferActivity.app, paramTroopTransferActivity.b, 1, true);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopTransferActivity.TroopMemberItem localTroopMemberItem;
    if (paramView == null)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity.getLayoutInflater().inflate(2130971590, paramViewGroup, false);
      paramViewGroup = new uka(null);
      paramViewGroup.c = ((ImageView)paramView.findViewById(2131364365));
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131363568));
      ((TextView)paramView.findViewById(2131363569)).setText("");
      paramView.setTag(paramViewGroup);
      localTroopMemberItem = (TroopTransferActivity.TroopMemberItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if ((TextUtils.isEmpty(localTroopMemberItem.e)) || (localTroopMemberItem.e.equals(localTroopMemberItem.b))) {
        break label203;
      }
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopMemberItem.b + "(" + localTroopMemberItem.e + ")");
    }
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_JavaLangString = localTroopMemberItem.jdField_a_of_type_JavaLangString;
      paramViewGroup.jdField_a_of_type_ComTencentMobileqqActivityTroopTransferActivity$TroopMemberItem = localTroopMemberItem;
      paramViewGroup.c.setImageBitmap(a(1, localTroopMemberItem.jdField_a_of_type_JavaLangString));
      return paramView;
      paramViewGroup = (uka)paramView.getTag();
      break;
      label203:
      paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(localTroopMemberItem.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ujv
 * JD-Core Version:    0.7.0.1
 */