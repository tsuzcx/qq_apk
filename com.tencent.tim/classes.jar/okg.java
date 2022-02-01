import android.view.View;
import com.tencent.mobileqq.activity.miniaio.IMiniMsgUnreadCallback;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUser;
import com.tencent.mobileqq.activity.miniaio.MiniMsgUserParam;

public class okg
{
  private boolean axC = true;
  private int bfi;
  private View nx;
  
  private IMiniMsgUnreadCallback a()
  {
    return new okh(this);
  }
  
  public MiniMsgUserParam a()
  {
    MiniMsgUserParam localMiniMsgUserParam = new MiniMsgUserParam();
    localMiniMsgUserParam.businessName = 6;
    localMiniMsgUserParam.accessType = 2;
    localMiniMsgUserParam.filterMsgType = 0;
    localMiniMsgUserParam.unreadCallback = a();
    return localMiniMsgUserParam;
  }
  
  public void a(MiniMsgUser paramMiniMsgUser)
  {
    if ((this.bfi > 0) && (paramMiniMsgUser != null) && (this.nx != null))
    {
      this.bfi = 0;
      this.nx.setVisibility(4);
      paramMiniMsgUser.onClick(this.nx);
    }
  }
  
  public void dw(View paramView)
  {
    this.nx = paramView;
  }
  
  public void qP(boolean paramBoolean)
  {
    this.axC = paramBoolean;
  }
  
  public int ry()
  {
    return this.bfi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okg
 * JD-Core Version:    0.7.0.1
 */