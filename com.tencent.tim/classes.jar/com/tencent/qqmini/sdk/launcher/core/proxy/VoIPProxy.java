package com.tencent.qqmini.sdk.launcher.core.proxy;

import java.util.List;

public abstract class VoIPProxy
{
  public abstract int enableLocalAudio(boolean paramBoolean);
  
  public abstract int enableRemoteAudio(boolean paramBoolean);
  
  public abstract void exitRoom();
  
  public abstract void init(long paramLong, VoIPListener paramVoIPListener);
  
  public abstract int joinRoom(long paramLong, int paramInt, String paramString, byte[] paramArrayOfByte);
  
  public abstract void setAudioRoute(int paramInt);
  
  public abstract void unInit();
  
  public abstract void updateRoomInfo();
  
  public static final class MultiUserInfo
  {
    public boolean mMicOn;
    public String mOpenId;
    public long mUin;
    
    public String toString()
    {
      return "MultiUserInfo{mUin=" + this.mUin + ", mOpenId='" + this.mOpenId + '\'' + ", mMicOn=" + this.mMicOn + '}';
    }
  }
  
  public static abstract interface VoIPListener
  {
    public abstract void onEnterRoom();
    
    public abstract void onError(int paramInt);
    
    public abstract void onUserAudioAvailable(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean);
    
    public abstract void onUserEnter(VoIPProxy.MultiUserInfo paramMultiUserInfo);
    
    public abstract void onUserExit(VoIPProxy.MultiUserInfo paramMultiUserInfo);
    
    public abstract void onUserSpeaking(VoIPProxy.MultiUserInfo paramMultiUserInfo, boolean paramBoolean);
    
    public abstract void onUserUpdate(List<VoIPProxy.MultiUserInfo> paramList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.core.proxy.VoIPProxy
 * JD-Core Version:    0.7.0.1
 */