package moai.fragment.base;

import android.util.Log;
import java.util.ArrayList;
import moai.fragment.app.BackStackRecord;
import moai.fragment.app.FragmentManager.OpGenerator;

class BaseFragment$2
  implements FragmentManager.OpGenerator
{
  BaseFragment$2(BaseFragment paramBaseFragment) {}
  
  public boolean generateOps(ArrayList<BackStackRecord> paramArrayList, ArrayList<Boolean> paramArrayList1)
  {
    Log.v("BaseFragment", "overridePendingTransition after:");
    paramArrayList = this.this$0.getBaseFragmentActivity();
    if (paramArrayList != null)
    {
      paramArrayList.mEnterAnim = -1;
      paramArrayList.mExitAnim = -1;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.fragment.base.BaseFragment.2
 * JD-Core Version:    0.7.0.1
 */