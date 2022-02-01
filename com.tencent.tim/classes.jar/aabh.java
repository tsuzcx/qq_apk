import Wallet.GetRandomHbIdiomRsp;
import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment;
import com.tencent.mobileqq.activity.qwallet.fragment.WordChainHbFragment.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import mqq.observer.BusinessObserver;

public class aabh
  implements BusinessObserver
{
  public aabh(WordChainHbFragment paramWordChainHbFragment, WordChainHbFragment.a parama) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (paramInt == 27)
    {
      this.this$0.buV = false;
      paramBundle = (GetRandomHbIdiomRsp)paramBundle.getSerializable("rsp");
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "ReportHBGameRsp reportObserver:" + paramBoolean + "|" + paramBundle);
      }
      if ((!paramBoolean) || (paramBundle == null) || (paramBundle.suggestIdioms == null) || (paramBundle.suggestIdioms.size() <= 0)) {
        break label170;
      }
      WordChainHbFragment.e().clear();
      WordChainHbFragment.e().addAll(paramBundle.suggestIdioms);
      if (QLog.isColorLevel()) {
        QLog.d("WordChainHbFragment", 2, "getIdiomListFromSSO idiomListSize:" + WordChainHbFragment.e().size());
      }
      if (this.a != null) {
        this.a.G(true, WordChainHbFragment.e());
      }
      WordChainHbFragment.r(System.currentTimeMillis());
    }
    label170:
    while (this.a == null) {
      return;
    }
    this.a.G(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aabh
 * JD-Core Version:    0.7.0.1
 */