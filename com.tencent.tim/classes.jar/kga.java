import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import org.json.JSONException;

class kga
  extends lce
{
  kga(kfv paramkfv) {}
  
  public void a(boolean paramBoolean1, int paramInt, List<Long> paramList, boolean paramBoolean2)
  {
    super.a(paramBoolean1, paramInt, paramList, paramBoolean2);
    paramInt = this.this$0.getCurrentItem();
    kfv.a(this.this$0, paramInt);
    kfv.a(this.this$0).notifyDataSetChanged();
  }
  
  public void aCi()
  {
    super.aCi();
  }
  
  public void c(float paramFloat, int paramInt)
  {
    super.c(paramFloat, paramInt);
    paramFloat /= paramInt;
    kfv.a(this.this$0).setY((1.0F - paramFloat) * kfv.a(this.this$0).getHeight() * 0.03F);
  }
  
  public void d(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    super.d(paramTabChannelCoverInfo);
    if (paramTabChannelCoverInfo != null)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onChannelTabSelected, channelID = ", Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), ", channelName = ", paramTabChannelCoverInfo.mChannelCoverName });
      kfv.cn(paramTabChannelCoverInfo.mChannelCoverId, 1);
      this.this$0.oF(paramTabChannelCoverInfo.mChannelCoverId);
      kfv.a(this.this$0);
      if (awit.aMY())
      {
        kfv.b(this.this$0, paramTabChannelCoverInfo);
        kfv.b(this.this$0, kfv.a(this.this$0, kfv.a(this.this$0)));
      }
    }
    try
    {
      kfv.G("0X8009B94", "", new kxm.b().a("source", "303").a(paramTabChannelCoverInfo.mChannelCoverId).b("style", 0).build());
      return;
    }
    catch (JSONException paramTabChannelCoverInfo)
    {
      QLog.d("ReadInJoyChannelViewPagerController", 2, "report click channel bar exception, e = ", paramTabChannelCoverInfo);
    }
  }
  
  public void d(boolean paramBoolean, List<TabChannelCoverInfo> paramList)
  {
    int i = 0;
    if (paramList != null) {
      i = paramList.size();
    }
    QLog.d("ReadInJoyChannelViewPagerController", 2, new Object[] { "onIndependentMainChannelListupdate, success = ", Boolean.valueOf(paramBoolean), ", size = ", Integer.valueOf(i) });
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      kfv.a(this.this$0, paramList);
    }
  }
  
  public void lT(boolean paramBoolean)
  {
    int i = 8;
    kfv.a(this.this$0, paramBoolean);
    if (!kyo.Bg())
    {
      ImageView localImageView = kfv.a(this.this$0);
      if (paramBoolean) {
        i = 0;
      }
      localImageView.setVisibility(i);
      return;
    }
    kfv.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kga
 * JD-Core Version:    0.7.0.1
 */