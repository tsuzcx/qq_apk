package com.tencent.qqmail.maillist;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.maillist.view.MailListItemView.MailListItemData;

class ListViewHelper$2$1
  implements Runnable
{
  ListViewHelper$2$1(ListViewHelper.2 param2, Bitmap paramBitmap) {}
  
  public void run()
  {
    Object localObject = new String();
    if (this.this$0.val$itemView.getTag() != null)
    {
      localObject = ((String)this.this$0.val$itemView.getTag()).split("#");
      if (localObject.length == 2) {
        localObject = localObject[1];
      }
    }
    else
    {
      if (!this.this$0.val$address.equals(localObject)) {
        break label96;
      }
      this.this$0.val$itemData.avatarBitmap = this.val$fAvatarBitmap;
    }
    for (;;)
    {
      this.this$0.val$itemView.postInvalidate();
      return;
      localObject = localObject[0];
      break;
      label96:
      if ((this.this$0.val$itemData.nickName != null) && (!this.this$0.val$itemData.nickName.equals(""))) {
        this.this$0.val$itemData.avatarBitmap = ListViewHelper.generateAvatar(this.this$0.val$avatarTool, null, this.this$0.val$itemData.nickName);
      } else {
        this.this$0.val$itemData.avatarBitmap = BitmapFactory.decodeResource(QMApplicationContext.sharedInstance().getResources(), 2130838764);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.ListViewHelper.2.1
 * JD-Core Version:    0.7.0.1
 */