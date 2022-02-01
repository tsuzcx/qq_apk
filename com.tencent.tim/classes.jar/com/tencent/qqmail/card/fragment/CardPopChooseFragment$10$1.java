package com.tencent.qqmail.card.fragment;

import android.graphics.Bitmap;
import android.widget.TextView;
import com.tencent.qqmail.card.view.CardAvatarChooseView;
import com.tencent.qqmail.maillist.ListViewHelper;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.view.QMAvatarView;

class CardPopChooseFragment$10$1
  implements Runnable
{
  CardPopChooseFragment$10$1(CardPopChooseFragment.10 param10, String paramString, CardAvatarChooseView paramCardAvatarChooseView) {}
  
  public void run()
  {
    Bitmap localBitmap = QMPrivateProtocolManager.getPhotoBitmapByEmail(this.val$email, 3);
    this.val$finalCardAvatarChooseView.getAvatarView().setAvatarBitmap(ListViewHelper.generateAvatar(new QMAvatar(1), localBitmap, this.val$finalCardAvatarChooseView.getNameTv().getText().toString()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardPopChooseFragment.10.1
 * JD-Core Version:    0.7.0.1
 */