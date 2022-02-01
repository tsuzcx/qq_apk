package com.tencent.TMG.audio;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class TraeAudioSessionHost
{
  private ArrayList<SessionInfo> _sessionInfoList = new ArrayList();
  private ReentrantLock mLock = new ReentrantLock();
  
  public void add(TraeAudioSession paramTraeAudioSession, long paramLong, Context paramContext)
  {
    if (find(paramLong) != null) {
      return;
    }
    paramContext = new SessionInfo();
    paramContext.sessionId = paramLong;
    paramContext._traeAs = paramTraeAudioSession;
    this.mLock.lock();
    this._sessionInfoList.add(paramContext);
    this.mLock.unlock();
  }
  
  public SessionInfo find(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    SessionInfo localSessionInfo;
    if (i < this._sessionInfoList.size())
    {
      localSessionInfo = (SessionInfo)this._sessionInfoList.get(i);
      if (localSessionInfo.sessionId != paramLong) {}
    }
    for (;;)
    {
      this.mLock.unlock();
      return localSessionInfo;
      i += 1;
      break;
      localSessionInfo = null;
    }
  }
  
  public void remove(long paramLong)
  {
    this.mLock.lock();
    int i = 0;
    for (;;)
    {
      if (i < this._sessionInfoList.size())
      {
        if (((SessionInfo)this._sessionInfoList.get(i)).sessionId == paramLong) {
          this._sessionInfoList.remove(i);
        }
      }
      else
      {
        this.mLock.unlock();
        return;
      }
      i += 1;
    }
  }
  
  public void sendToAudioSessionMessage(Intent paramIntent)
  {
    this.mLock.lock();
    int i = 0;
    while (i < this._sessionInfoList.size())
    {
      ((SessionInfo)this._sessionInfoList.get(i))._traeAs.onReceiveCallback(paramIntent);
      i += 1;
    }
    this.mLock.unlock();
  }
  
  public class SessionInfo
  {
    public TraeAudioSession _traeAs;
    public long sessionId;
    
    public SessionInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.audio.TraeAudioSessionHost
 * JD-Core Version:    0.7.0.1
 */