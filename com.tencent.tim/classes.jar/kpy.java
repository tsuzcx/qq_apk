import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.biu.ReadInjoyFriendsBiuComponentFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.MultiBiuSameContent;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class kpy
  implements View.OnClickListener
{
  public kpy(ReadInjoyFriendsBiuComponentFragment paramReadInjoyFriendsBiuComponentFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.mActivity.doOnBackPressed();
    Object localObject1 = paramView.getTag();
    try
    {
      i = Integer.valueOf(localObject1.toString()).intValue();
      if ((i >= 0) && (i < this.a.mContents.size()))
      {
        localObject1 = (MultiBiuSameContent)this.a.mContents.get(i);
        switch (paramView.getId())
        {
        default: 
          EventCollector.getInstance().onViewClicked(paramView);
          return;
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = -1;
        continue;
        if (localException != null)
        {
          String str = ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.mUin);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, str);
          ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.mUin, localException.vd, "0X800953D", localException.aLh);
          continue;
          if (localException != null)
          {
            str = ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.mUin, localException.aLh, localException.vd);
            ReadInjoyFriendsBiuComponentFragment.a(this.a, str);
            ReadInjoyFriendsBiuComponentFragment.a(this.a, localException.mUin, localException.vd, "0X800953C", localException.aLh);
            continue;
            Object localObject2 = null;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kpy
 * JD-Core Version:    0.7.0.1
 */