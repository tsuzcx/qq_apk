package com.tencent.qqmail.bottle.fragment.adapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.bottle.controller.BottleManager.AvatarCallback;

class BottleConversationAdapter$1
  implements BottleManager.AvatarCallback
{
  BottleConversationAdapter$1(BottleConversationAdapter paramBottleConversationAdapter, BottleConversationAdapter.ViewHolder paramViewHolder) {}
  
  public void onErrorInMainThread2(String paramString, Bitmap paramBitmap) {}
  
  public void onSuccessInMainThread2(String paramString, Bitmap paramBitmap)
  {
    if ((this.val$holder.avatarUin != null) && (this.val$holder.avatarUin.toString().equals(paramString)))
    {
      this.val$holder.avatar.setImageBitmap(paramBitmap);
      BottleConversationAdapter.access$100(this.this$0, paramString, paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.BottleConversationAdapter.1
 * JD-Core Version:    0.7.0.1
 */