package com.tencent.qqmail.bottle.fragment;

import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.QMApplicationContext.LowMemoryListener;

class BottleConversationFragment$1
  implements QMApplicationContext.LowMemoryListener
{
  BottleConversationFragment$1(BottleConversationFragment paramBottleConversationFragment) {}
  
  public void onRelease()
  {
    if (BottleConversationFragment.access$100().activeFragment == null)
    {
      QMApplicationContext.sharedInstance().removeLowMemoryListener(this);
      BottleConversationFragment.access$102(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.BottleConversationFragment.1
 * JD-Core Version:    0.7.0.1
 */