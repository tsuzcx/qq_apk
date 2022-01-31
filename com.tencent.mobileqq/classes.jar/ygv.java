import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.fpsreport.FPSPinnedHeaderExpandableListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class ygv
  implements Runnable
{
  ygv(ygu paramygu, ArrayList paramArrayList, SparseArray paramSparseArray, SparseIntArray paramSparseIntArray) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged out ThreadManager");
    }
    BuddyListAdapter.a(this.jdField_a_of_type_Ygu.a, this.jdField_a_of_type_JavaUtilArrayList);
    BuddyListAdapter.a(this.jdField_a_of_type_Ygu.a, this.jdField_a_of_type_AndroidUtilSparseArray);
    BuddyListAdapter.a(this.jdField_a_of_type_Ygu.a, this.jdField_a_of_type_AndroidUtilSparseIntArray);
    ((FPSPinnedHeaderExpandableListView)this.jdField_a_of_type_Ygu.a.a).b();
    BuddyListAdapter.a(this.jdField_a_of_type_Ygu.a);
    if (BuddyListAdapter.a(this.jdField_a_of_type_Ygu.a))
    {
      BuddyListAdapter.a(this.jdField_a_of_type_Ygu.a, false);
      BuddyListAdapter.b(this.jdField_a_of_type_Ygu.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygv
 * JD-Core Version:    0.7.0.1
 */