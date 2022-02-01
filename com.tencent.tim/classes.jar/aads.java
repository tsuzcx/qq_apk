import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.RedPacketInfo;
import com.tencent.mobileqq.activity.aio.CustomizeStrategyFactory.c;
import com.tencent.mobileqq.activity.qwallet.redpacket.IRedPacket.OnGetSkinListener;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketInfoBase;
import com.tencent.mobileqq.activity.qwallet.redpacket.RedPacketManager;
import java.lang.ref.WeakReference;

public class aads
  implements CustomizeStrategyFactory.c
{
  public aads(RedPacketManager paramRedPacketManager, RedPacketInfoBase paramRedPacketInfoBase, WeakReference paramWeakReference) {}
  
  public void onSucc(int paramInt, CustomizeStrategyFactory.RedPacketInfo paramRedPacketInfo)
  {
    paramRedPacketInfo.isCache = this.b.isCache;
    IRedPacket.OnGetSkinListener localOnGetSkinListener = (IRedPacket.OnGetSkinListener)this.eP.get();
    if (localOnGetSkinListener != null) {
      localOnGetSkinListener.onGetSkin(paramRedPacketInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aads
 * JD-Core Version:    0.7.0.1
 */