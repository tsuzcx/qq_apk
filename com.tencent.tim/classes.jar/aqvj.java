import android.app.Activity;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.KCWraperV2InOtherProcess.1;
import com.tencent.mobileqq.vip.KingCardActivationFragment;
import com.tencent.util.Pair;
import mqq.os.MqqHandler;

public class aqvj
  extends aqvf
{
  void S(ViewGroup paramViewGroup)
  {
    VK("can not call bindActivationView");
  }
  
  void a(aqvn.a parama, boolean paramBoolean)
  {
    VK("queryKingCard : from cache");
    Pair localPair = f();
    if (parama != null)
    {
      if (paramBoolean) {
        ThreadManager.getUIHandler().post(new KCWraperV2InOtherProcess.1(this, parama, localPair));
      }
    }
    else {
      return;
    }
    parama.b(true, ((Boolean)localPair.first).booleanValue(), ((Integer)localPair.second).intValue());
  }
  
  boolean aFG()
  {
    boolean bool = aFH();
    VK("supportActivationView = " + bool);
    return bool;
  }
  
  void ar(Runnable paramRunnable)
  {
    VK("tryLoad : do nothing");
  }
  
  boolean isReady()
  {
    VK("isReady : do nothing");
    return true;
  }
  
  String tag()
  {
    return "KC.KCWraper.Other";
  }
  
  boolean x(Activity paramActivity)
  {
    if (aFH())
    {
      PublicFragmentActivity.start(paramActivity, KingCardActivationFragment.class);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvj
 * JD-Core Version:    0.7.0.1
 */