package com.tencent.mobileqq.minigame.publicaccount;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.d;
import com.tencent.qphone.base.util.QLog;

class MiniGamePublicAccountWebFragment$2
  implements PreloadManager.d
{
  MiniGamePublicAccountWebFragment$2(MiniGamePublicAccountWebFragment paramMiniGamePublicAccountWebFragment) {}
  
  public void onResult(int paramInt, PreloadManager.PathResult paramPathResult)
  {
    if ((paramInt == 0) && (!TextUtils.isEmpty(paramPathResult.folderPath))) {
      QLog.d("MiniGamePublicAccountWebFragment", 1, "loading apng download succ!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.MiniGamePublicAccountWebFragment.2
 * JD-Core Version:    0.7.0.1
 */