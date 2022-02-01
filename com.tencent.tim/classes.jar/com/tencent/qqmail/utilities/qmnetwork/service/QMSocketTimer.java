package com.tencent.qqmail.utilities.qmnetwork.service;

import java.util.HashMap;
import java.util.Timer;

public class QMSocketTimer
{
  private static QMSocketTimer _instance = new QMSocketTimer();
  private HashMap<String, QMSocketPacket> _cacheMap = new HashMap();
  private Timer timer = new Timer(true);
  
  private QMSocketTimer()
  {
    this.timer.scheduleAtFixedRate(new QMSocketTimer.1(this), 0L, 2000L);
  }
  
  public static QMSocketTimer instance()
  {
    return _instance;
  }
  
  public void startTimer(SendPacket paramSendPacket, QMSocketTimeout paramQMSocketTimeout)
  {
    synchronized (this._cacheMap)
    {
      QMSocketPacket localQMSocketPacket = new QMSocketPacket(null);
      localQMSocketPacket.packet = paramSendPacket;
      localQMSocketPacket.callback = paramQMSocketTimeout;
      paramQMSocketTimeout = new StringBuilder();
      paramQMSocketTimeout.append(paramSendPacket.cmd_id);
      paramQMSocketTimeout.append("_");
      paramQMSocketTimeout.append(paramSendPacket.msg_id);
      localQMSocketPacket.id = paramQMSocketTimeout.toString();
      this._cacheMap.put(paramQMSocketTimeout.toString(), localQMSocketPacket);
      return;
    }
  }
  
  public void stopAllTimer()
  {
    synchronized (this._cacheMap)
    {
      this._cacheMap.clear();
      return;
    }
  }
  
  public void stopTimer(ReceivePacket paramReceivePacket)
  {
    synchronized (this._cacheMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramReceivePacket.cmd_id);
      localStringBuilder.append("_");
      localStringBuilder.append(paramReceivePacket.msg_id);
      this._cacheMap.remove(localStringBuilder.toString());
      return;
    }
  }
  
  class QMSocketPacket
  {
    public QMSocketTimer.QMSocketTimeout callback;
    public String id;
    public SendPacket packet;
    public int timeCount = 0;
    
    private QMSocketPacket() {}
    
    public void respondTimeout()
    {
      this.timeCount = 0;
      if (this.callback != null) {
        this.callback.run(this.packet);
      }
    }
  }
  
  public static abstract interface QMSocketTimeout
  {
    public abstract void run(SendPacket paramSendPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMSocketTimer
 * JD-Core Version:    0.7.0.1
 */