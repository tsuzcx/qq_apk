import android.view.View;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

public class cpm
  implements ActionSheet.OnButtonClickListener
{
  public cpm(GroupManagerActivity paramGroupManagerActivity, byte paramByte) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.c();
    if (paramInt == 0)
    {
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).setDragEnabled(true);
      GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.b.a(this.jdField_a_of_type_Byte));
      if (QLog.isColorLevel()) {
        QLog.d(GroupManagerActivity.a, 2, "DeleteFriendGroup :" + this.jdField_a_of_type_Byte + ", " + GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity));
      }
      if (!GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)) {
        break label114;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a(2131561931);
    }
    label114:
    while (GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity) == null) {
      return;
    }
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cpm
 * JD-Core Version:    0.7.0.1
 */