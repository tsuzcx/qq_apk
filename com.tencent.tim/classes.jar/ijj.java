import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.handler.NetAddr;
import com.tencent.av.business.manager.zimu.ZimuItem;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ijj
  extends iji
{
  public ijj(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  protected void a(long paramLong1, boolean paramBoolean, List<NetAddr> paramList, long paramLong2)
  {
    VideoController localVideoController = ((VideoAppInterface)this.mApp).b();
    iiv localiiv = localVideoController.b();
    StringBuilder localStringBuilder = new StringBuilder().append("requestRecordingAudio, isStart[").append(paramBoolean).append("], sessionid[").append(paramLong2).append("], seq[").append(paramLong1).append("], iplist[");
    if (paramList == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append(localObject).append("], peerUin[");
      if (localiiv != null) {
        break label159;
      }
    }
    label159:
    for (Object localObject = "null";; localObject = localiiv.peerUin)
    {
      QLog.w("AudioTransClientInterfaceHandlerExtend.runhw", 1, (String)localObject + "]");
      if ((localVideoController != null) && (localiiv != null)) {
        localVideoController.a(ihk.u(localiiv.peerUin), paramBoolean, paramList, paramLong2);
      }
      return;
      localObject = Integer.valueOf(paramList.size());
      break;
    }
  }
  
  protected void h(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    notifyEvent(Integer.valueOf(6008), new ijn(paramString1, paramString2, paramString3, paramInt));
  }
  
  protected int kP()
  {
    Object localObject = (VideoAppInterface)this.mApp;
    if (((VideoAppInterface)localObject).ch(0))
    {
      localObject = (ilg)((VideoAppInterface)localObject).a(0);
      if (localObject != null) {
        return ((ilg)localObject).kY();
      }
    }
    return 4;
  }
  
  protected void notifyEvent(Integer paramInteger, Object paramObject)
  {
    igd.aJ("AudioTransClientInterfaceHandlerExtend.runhw", "notifyEvent :" + paramInteger + "|" + paramObject);
    ((VideoAppInterface)this.mApp).l(new Object[] { paramInteger, paramObject });
  }
  
  protected boolean tt()
  {
    boolean bool2 = false;
    Object localObject = (VideoAppInterface)this.mApp;
    boolean bool1 = bool2;
    if (((VideoAppInterface)localObject).ch(0))
    {
      localObject = (ilg)((VideoAppInterface)localObject).a(0);
      bool1 = bool2;
      if (localObject != null)
      {
        localObject = (ZimuItem)((ilg)localObject).a();
        bool1 = bool2;
        if (localObject != null)
        {
          localObject = ((ZimuItem)localObject).getId();
          if ((TextUtils.isEmpty((CharSequence)localObject)) || (!((String)localObject).equalsIgnoreCase("film"))) {
            break label74;
          }
        }
      }
    }
    label74:
    for (bool1 = true;; bool1 = false) {
      return bool1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijj
 * JD-Core Version:    0.7.0.1
 */