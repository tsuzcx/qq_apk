import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.2.1;
import com.tencent.mobileqq.intervideo.groupvideo.GroupVideoLoadingFragment.a;

public class aics
  implements aidc
{
  public aics(GroupVideoLoadingFragment paramGroupVideoLoadingFragment) {}
  
  public void I(int paramInt, Bundle paramBundle)
  {
    if ((this.a.getActivity() == null) || (this.a.getActivity().isFinishing())) {}
    do
    {
      return;
      GroupVideoLoadingFragment.a(this.a, paramInt);
      switch (paramInt)
      {
      case 4: 
      case 8: 
      default: 
        return;
      }
    } while (!GroupVideoLoadingFragment.a(this.a));
    long l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).gn(acfp.m(2131707082), acfp.m(2131707097));
    GroupVideoLoadingFragment.a(this.a).h(acfp.m(2131707093) + aicm.formatSize(l) + ")", new GroupVideoLoadingFragment.a(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).gn(acfp.m(2131707095), acfp.m(2131707096));
    paramInt = paramBundle.getInt("key_progress", 0);
    l = paramBundle.getLong("key_totalSize", 0L);
    GroupVideoLoadingFragment.a(this.a).aj(paramInt, l);
    GroupVideoLoadingFragment.a(this.a).showLeftText();
    return;
    GroupVideoLoadingFragment.a(this.a).drY();
    GroupVideoLoadingFragment.a(this.a).gn(acfp.m(2131707094), acfp.m(2131707088));
    paramBundle = Message.obtain();
    paramBundle.arg1 = 10;
    GroupVideoLoadingFragment.a(this.a).sendMessage(paramBundle);
    return;
    GroupVideoLoadingFragment.a(this.a).gn(acfp.m(2131707091), acfp.m(2131707087));
    GroupVideoLoadingFragment.a(this.a).h(acfp.m(2131707092), new GroupVideoLoadingFragment.a(this.a, null));
    return;
    GroupVideoLoadingFragment.a(this.a).showLeftText();
    GroupVideoLoadingFragment.a(this.a).gn(acfp.m(2131707083), "");
    GroupVideoLoadingFragment.a(this.a).h(acfp.m(2131707084), new GroupVideoLoadingFragment.a(this.a, null));
    return;
    GroupVideoLoadingFragment.b(this.a, 90);
    GroupVideoLoadingFragment.a(this.a).aj(90, 0L);
    return;
    GroupVideoLoadingFragment.b(this.a, 100);
    GroupVideoLoadingFragment.a(this.a).aj(100, 0L);
    GroupVideoLoadingFragment.a(this.a).postDelayed(new GroupVideoLoadingFragment.2.1(this), 1500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aics
 * JD-Core Version:    0.7.0.1
 */