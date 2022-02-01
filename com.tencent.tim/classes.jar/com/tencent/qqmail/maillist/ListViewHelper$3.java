package com.tencent.qqmail.maillist;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qqmail.activity.contacts.fragment.AvatarViewHolder;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import java.util.Map;

final class ListViewHelper$3
  implements Runnable
{
  ListViewHelper$3(AvatarViewHolder paramAvatarViewHolder, String paramString1, String paramString2, QMAvatar paramQMAvatar, boolean paramBoolean, View paramView) {}
  
  public void run()
  {
    if ((this.val$viewHolder.avatarName == null) || (!this.val$viewHolder.avatarName.equals(this.val$name))) {}
    for (;;)
    {
      return;
      Bitmap localBitmap2 = QMPrivateProtocolManager.getPhotoBitmapByEmail(this.val$address, 3);
      Object localObject = null;
      if (localBitmap2 != null)
      {
        Bitmap localBitmap1 = (Bitmap)ListViewHelper.access$000().get(Integer.valueOf(localBitmap2.hashCode()));
        localObject = localBitmap1;
        if (localBitmap1 == null) {
          localObject = ListViewHelper.generateAvatar(this.val$avatarTool, localBitmap2, this.val$viewHolder.avatarName);
        }
      }
      while (localObject != null)
      {
        Threads.runOnMainThread(new ListViewHelper.3.1(this, (Bitmap)localObject));
        return;
        QMPrivateProtocolManager.sharedInstance().loadEmailIcon(this.val$address);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.ListViewHelper.3
 * JD-Core Version:    0.7.0.1
 */