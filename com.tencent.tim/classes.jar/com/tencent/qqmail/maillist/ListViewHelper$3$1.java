package com.tencent.qqmail.maillist;

import android.graphics.Bitmap;
import android.view.View;
import com.tencent.qqmail.activity.contacts.fragment.AvatarViewHolder;
import com.tencent.qqmail.view.QMAvatarView;

class ListViewHelper$3$1
  implements Runnable
{
  ListViewHelper$3$1(ListViewHelper.3 param3, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.this$0.val$viewHolder.avatarName != null) && (this.this$0.val$viewHolder.avatarName.equals(this.this$0.val$name)))
    {
      if (!this.this$0.val$smallIcon) {
        break label84;
      }
      this.this$0.val$viewHolder.avatarView.setAvatar(this.val$fAvatarBitmap, this.this$0.val$viewHolder.avatarName);
    }
    for (;;)
    {
      this.this$0.val$itemView.postInvalidate();
      return;
      label84:
      this.this$0.val$viewHolder.avatarView.setAvatarBitmap(this.val$fAvatarBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.ListViewHelper.3.1
 * JD-Core Version:    0.7.0.1
 */