package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import acfp;
import asei.b;
import asej;
import aser;
import aseu;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;

class VoIPManager$3
  extends aseu
{
  VoIPManager$3(VoIPManager paramVoIPManager) {}
  
  public void onEnterRoom()
  {
    QLog.d("VoIPManager", 1, "onEnterRoom");
    VoIPManager.access$200(this.this$0).set(true);
    aser localaser = asej.a().a();
    if (VoIPManager.access$300(this.this$0) != null) {
      this.this$0.updateMuteConfig(VoIPManager.access$300(this.this$0), null);
    }
    if (localaser != null) {
      localaser.updateRoomInfo();
    }
    VoIPManager.access$000(this.this$0);
  }
  
  public void onError(int paramInt)
  {
    QLog.d("VoIPManager", 1, String.format("onEnterRoom errorType=%s", new Object[] { Integer.valueOf(paramInt) }));
    if ((paramInt == 2) || (paramInt == 1)) {
      if (VoIPManager.access$400(this.this$0) != null)
      {
        VoIPManager.access$400(this.this$0).onError(paramInt);
        VoIPManager.access$402(this.this$0, null);
      }
    }
    do
    {
      do
      {
        return;
        if (paramInt != 4) {
          break;
        }
      } while (VoIPManager.access$500(this.this$0) == null);
      VoIPManager.access$500(this.this$0).onInterrupt(4, acfp.m(2131716882));
      return;
    } while ((paramInt != 3) || (VoIPManager.access$500(this.this$0) == null));
    VoIPManager.access$500(this.this$0).onInterrupt(3, acfp.m(2131716881));
  }
  
  public void onUserAudioAvailable(asei.b paramb, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserAudioAvailable userInfo=%s available=%s", new Object[] { paramb, Boolean.valueOf(paramBoolean) }));
  }
  
  public void onUserEnter(asei.b paramb)
  {
    QLog.d("VoIPManager", 1, String.format("onUserEnter userInfo=%s", new Object[] { paramb }));
    if ((VoIPManager.access$400(this.this$0) == null) && (VoIPManager.access$600(this.this$0, paramb.mUin) == null))
    {
      VoIPManager.UserModel localUserModel = new VoIPManager.UserModel(this.this$0, null);
      localUserModel.mUin = paramb.mUin;
      localUserModel.mOpenId = paramb.mOpenId;
      localUserModel.mMicStat = 1;
      VoIPManager.access$800(this.this$0, localUserModel);
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberChange(VoIPManager.access$900(this.this$0));
      }
    }
  }
  
  public void onUserExit(asei.b paramb)
  {
    QLog.d("VoIPManager", 1, String.format("onUserExit userInfo=%s", new Object[] { paramb }));
    if (VoIPManager.access$400(this.this$0) == null)
    {
      VoIPManager.access$1000(this.this$0, paramb.mUin);
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberChange(VoIPManager.access$900(this.this$0));
      }
    }
  }
  
  public void onUserSpeaking(asei.b paramb, boolean paramBoolean)
  {
    QLog.d("VoIPManager", 1, String.format("onUserSpeaking userInfo=%s speaking=%s", new Object[] { paramb, Boolean.valueOf(paramBoolean) }));
    paramb = VoIPManager.access$600(this.this$0, paramb.mUin);
    if (paramb != null)
    {
      paramb.mSpeaking = paramBoolean;
      if (VoIPManager.access$500(this.this$0) != null) {
        VoIPManager.access$500(this.this$0).onRoomMemberSpeaking(VoIPManager.access$1100(this.this$0));
      }
      return;
    }
    QLog.e("VoIPManager", 1, "onUserSpeaking userModel==null");
  }
  
  public void onUserUpdate(List<asei.b> paramList)
  {
    if ((VoIPManager.access$400(this.this$0) != null) && (paramList != null))
    {
      JSONArray localJSONArray = new JSONArray();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        asei.b localb = (asei.b)localIterator.next();
        if (localb.mUin != 0L) {
          localJSONArray.put(localb.mOpenId);
        }
      }
      VoIPManager.access$400(this.this$0).onJoinRoom(localJSONArray);
      VoIPManager.access$1200(this.this$0, paramList);
      VoIPManager.access$402(this.this$0, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.VoIPManager.3
 * JD-Core Version:    0.7.0.1
 */