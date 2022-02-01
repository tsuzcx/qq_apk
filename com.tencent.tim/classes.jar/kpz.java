import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment.b;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.c;

public class kpz
  implements AdapterView.c
{
  public kpz(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.mActivity.doOnBackPressed();
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView instanceof ReadInjoyFriendsBiuComponentFragment.b))
    {
      paramAdapterView = (ReadInjoyFriendsBiuComponentFragment.b)paramAdapterView;
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.abG);
      ReadInjoyFriendsBiuComponentFragment.a(this.a, paramAdapterView.mUin, paramAdapterView.sG, "0X800953C", paramAdapterView.aLh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpz
 * JD-Core Version:    0.7.0.1
 */