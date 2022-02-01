import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.MultiUserInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy.VoIPListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class asxp
  extends aseu
{
  asxp(asxn paramasxn) {}
  
  public void onEnterRoom()
  {
    if (asxn.a(this.a) != null) {
      asxn.a(this.a).onEnterRoom();
    }
  }
  
  public void onError(int paramInt)
  {
    if (asxn.a(this.a) != null) {
      asxn.a(this.a).onError(paramInt);
    }
  }
  
  public void onUserAudioAvailable(asei.b paramb, boolean paramBoolean)
  {
    if (asxn.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramb != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramb.mMicOn;
        localMultiUserInfo.mOpenId = paramb.mOpenId;
        localMultiUserInfo.mUin = paramb.mUin;
      }
      asxn.a(this.a).onUserAudioAvailable(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserEnter(asei.b paramb)
  {
    if (asxn.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramb != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramb.mMicOn;
        localMultiUserInfo.mOpenId = paramb.mOpenId;
        localMultiUserInfo.mUin = paramb.mUin;
      }
      asxn.a(this.a).onUserEnter(localMultiUserInfo);
    }
  }
  
  public void onUserExit(asei.b paramb)
  {
    if (asxn.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramb != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramb.mMicOn;
        localMultiUserInfo.mOpenId = paramb.mOpenId;
        localMultiUserInfo.mUin = paramb.mUin;
      }
      asxn.a(this.a).onUserExit(localMultiUserInfo);
    }
  }
  
  public void onUserSpeaking(asei.b paramb, boolean paramBoolean)
  {
    if (asxn.a(this.a) != null)
    {
      VoIPProxy.MultiUserInfo localMultiUserInfo = null;
      if (paramb != null)
      {
        localMultiUserInfo = new VoIPProxy.MultiUserInfo();
        localMultiUserInfo.mMicOn = paramb.mMicOn;
        localMultiUserInfo.mOpenId = paramb.mOpenId;
        localMultiUserInfo.mUin = paramb.mUin;
      }
      asxn.a(this.a).onUserSpeaking(localMultiUserInfo, paramBoolean);
    }
  }
  
  public void onUserUpdate(List<asei.b> paramList)
  {
    if (asxn.a(this.a) != null)
    {
      ArrayList localArrayList = null;
      if (paramList != null)
      {
        localArrayList = new ArrayList();
        paramList = paramList.iterator();
        while (paramList.hasNext())
        {
          asei.b localb = (asei.b)paramList.next();
          if (localb != null)
          {
            VoIPProxy.MultiUserInfo localMultiUserInfo = new VoIPProxy.MultiUserInfo();
            localMultiUserInfo.mMicOn = localb.mMicOn;
            localMultiUserInfo.mOpenId = localb.mOpenId;
            localMultiUserInfo.mUin = localb.mUin;
            localArrayList.add(localMultiUserInfo);
          }
        }
      }
      asxn.a(this.a).onUserUpdate(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asxp
 * JD-Core Version:    0.7.0.1
 */