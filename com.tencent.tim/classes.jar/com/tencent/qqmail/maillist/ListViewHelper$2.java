package com.tencent.qqmail.maillist;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import java.util.Map;

final class ListViewHelper$2
  implements Runnable
{
  ListViewHelper$2(MailListItemView.MailListItemData paramMailListItemData, String paramString, QMAvatar paramQMAvatar, View paramView) {}
  
  public void run()
  {
    Object localObject1 = null;
    String str = this.val$itemData.avatarOptionalName;
    if (str == null) {}
    for (;;)
    {
      return;
      Bitmap localBitmap = QMPrivateProtocolManager.getPhotoBitmapByEmail(this.val$address, 3);
      Object localObject2;
      if (localBitmap != null)
      {
        localObject2 = (Bitmap)ListViewHelper.access$000().get(Integer.valueOf(localBitmap.hashCode()));
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = ListViewHelper.generateAvatar(this.val$avatarTool, localBitmap, str);
        }
      }
      while (localObject1 != null)
      {
        Threads.runOnMainThread(new ListViewHelper.2.1(this, (Bitmap)localObject1));
        return;
        if (this.val$itemData.avatarBitmap == null)
        {
          localObject1 = ListViewHelper.generateAvatar(this.val$avatarTool, null, str);
          localObject2 = "asyncLoadAvatar-" + this.val$address;
          ListViewHelper.access$000().put(Integer.valueOf(((String)localObject2).hashCode()), localObject1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.ListViewHelper.2
 * JD-Core Version:    0.7.0.1
 */