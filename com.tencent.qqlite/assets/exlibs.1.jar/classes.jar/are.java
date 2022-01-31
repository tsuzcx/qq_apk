import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.GroupManagerActivity;
import com.tencent.mobileqq.adapter.GroupEditeDragSortAdapter;
import com.tencent.mobileqq.emosm.view.DragSortListView;
import com.tencent.qphone.base.util.QLog;

public class are
  implements DialogInterface.OnClickListener
{
  public are(GroupManagerActivity paramGroupManagerActivity, byte paramByte) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.c();
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).setDragEnabled(true);
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity, this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a(this.jdField_a_of_type_Byte));
    if (QLog.isColorLevel()) {
      QLog.d(GroupManagerActivity.a, 2, "DeleteFriendGroup :" + this.jdField_a_of_type_Byte + ", " + GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity));
    }
    if (GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity.a(2131363801);
    }
    while (GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity) == null) {
      return;
    }
    GroupManagerActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityGroupManagerActivity).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     are
 * JD-Core Version:    0.7.0.1
 */