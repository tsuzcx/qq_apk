import android.util.SparseArray;
import com.tencent.mobileqq.data.TroopBarPageEntity;
import com.tencent.mobileqq.data.TroopBarPageEntity.TypeListEntity;
import com.tencent.mobileqq.troop.activity.TroopBarPageActivity;
import com.tencent.mobileqq.troop.widget.TroopBarPostAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class grz
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public grz(TroopBarPageActivity paramTroopBarPageActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IphoneTitleBarActivity", 2, "onScrollStateChanged lastVisibleIndex = " + this.jdField_a_of_type_Int + ", scrollState = " + paramInt);
    }
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.jdField_a_of_type_ComTencentMobileqqTroopWidgetTroopBarPostAdapter.getCount() - 1) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType != null))
    {
      paramInt = this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.jdField_a_of_type_ComTencentMobileqqDataTroopBarPageEntity.curType.type;
      if (this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
        break label138;
      }
    }
    label138:
    for (long l = 0L;; l = ((Long)this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt)).longValue())
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.a(this.jdField_a_of_type_ComTencentMobileqqTroopActivityTroopBarPageActivity.r, paramInt, l, false, false);
      return;
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     grz
 * JD-Core Version:    0.7.0.1
 */