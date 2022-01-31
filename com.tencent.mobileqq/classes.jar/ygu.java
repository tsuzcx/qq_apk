import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.mobileqq.adapter.BuddyListAdapter;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ygu
  implements Runnable
{
  public ygu(BuddyListAdapter paramBuddyListAdapter) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = new SparseArray();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    BuddyListAdapter.a(this.a, localArrayList, localSparseArray, localSparseIntArray);
    if (QLog.isColorLevel()) {
      QLog.d("BuddyListAdapter", 2, "notifyDataSetChanged in ThreadManager");
    }
    ThreadManager.getUIHandler().post(new ygv(this, localArrayList, localSparseArray, localSparseIntArray));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ygu
 * JD-Core Version:    0.7.0.1
 */