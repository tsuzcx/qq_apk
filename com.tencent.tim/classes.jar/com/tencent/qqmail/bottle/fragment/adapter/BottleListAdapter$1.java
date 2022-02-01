package com.tencent.qqmail.bottle.fragment.adapter;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.qqmail.bottle.controller.BottleManager.AvatarCallback;

class BottleListAdapter$1
  implements BottleManager.AvatarCallback
{
  BottleListAdapter$1(BottleListAdapter paramBottleListAdapter, BottleListAdapter.ViewHolder paramViewHolder) {}
  
  public void onErrorInMainThread2(String paramString, Bitmap paramBitmap) {}
  
  public void onSuccessInMainThread2(String paramString, Bitmap paramBitmap)
  {
    if ((this.val$holder.avatarUin != null) && (this.val$holder.avatarUin.equals(paramString))) {
      this.val$holder.avatar.setImageBitmap(paramBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.bottle.fragment.adapter.BottleListAdapter.1
 * JD-Core Version:    0.7.0.1
 */