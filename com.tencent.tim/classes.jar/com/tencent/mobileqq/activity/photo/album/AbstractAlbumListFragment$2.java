package com.tencent.mobileqq.activity.photo.album;

import android.os.MessageQueue.IdleHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XListView;

class AbstractAlbumListFragment$2
  implements MessageQueue.IdleHandler
{
  AbstractAlbumListFragment$2(AbstractAlbumListFragment paramAbstractAlbumListFragment, int paramInt1, int paramInt2) {}
  
  public boolean queueIdle()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListFragment", 2, "load Scroll Position,index:" + this.val$scrollIndex + " top:" + this.val$scrollY);
    }
    this.this$0.mListView.setSelectionFromTop(this.val$scrollIndex, this.val$scrollY);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.AbstractAlbumListFragment.2
 * JD-Core Version:    0.7.0.1
 */