package com.tencent.qqmail.card.fragment;

import android.graphics.Bitmap;
import com.tencent.qqmail.download.listener.ImageDownloadListener;
import com.tencent.qqmail.view.QMAvatarView;

class CardBirthdayChooseAdapter$1
  implements ImageDownloadListener
{
  CardBirthdayChooseAdapter$1(CardBirthdayChooseAdapter paramCardBirthdayChooseAdapter, CardBirthdayChooseAdapter.ViewHolder paramViewHolder) {}
  
  public void onErrorInMainThread(String paramString, Object paramObject) {}
  
  public void onProgressInMainThread(String paramString, long paramLong1, long paramLong2) {}
  
  public void onSuccessInMainThread(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    if (this.val$holder.avatarUrl.equals(paramString1)) {
      this.val$holder.avatarView.setAvatar(paramBitmap, this.val$holder.avatarName);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayChooseAdapter.1
 * JD-Core Version:    0.7.0.1
 */