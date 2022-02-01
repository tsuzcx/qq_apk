import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController.a;
import mqq.os.MqqHandler;

public class ahrl
  implements GameCenterVideoViewController.a
{
  ahrl(ahrb.b paramb) {}
  
  public void al(boolean paramBoolean, int paramInt) {}
  
  public void am(boolean paramBoolean, int paramInt) {}
  
  public void eM(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QQGamePubFeedsAdapter.FeedsItemVH.2.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahrl
 * JD-Core Version:    0.7.0.1
 */