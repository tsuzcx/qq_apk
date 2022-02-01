package com.tencent.qqlive.module.videoreport.collect;

import com.tencent.qqlive.module.videoreport.collect.notifier.IEventNotifier;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$2
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$2(EventNotifyManager paramEventNotifyManager, IEventNotifier paramIEventNotifier) {}
  
  public void onNotify(IEventListener paramIEventListener)
  {
    this.val$notifier.notifyEvent(paramIEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.2
 * JD-Core Version:    0.7.0.1
 */