package com.tencent.qqlive.module.videoreport.collect;

import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;

class EventNotifyManager$10
  implements ListenerMgr.INotifyCallback<IEventListener>
{
  EventNotifyManager$10(EventNotifyManager paramEventNotifyManager, FragmentCompat paramFragmentCompat) {}
  
  public void onNotify(IEventListener paramIEventListener)
  {
    paramIEventListener.onFragmentPause(this.val$fragment);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.collect.EventNotifyManager.10
 * JD-Core Version:    0.7.0.1
 */