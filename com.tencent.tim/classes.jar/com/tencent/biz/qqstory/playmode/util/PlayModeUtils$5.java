package com.tencent.biz.qqstory.playmode.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aqhu;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;
import plr;
import pmi;
import qem;
import qem.a;
import rop;
import rox;
import rpq;
import rqj;

public final class PlayModeUtils$5
  implements Runnable
{
  public PlayModeUtils$5(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt) {}
  
  public void run()
  {
    String str2 = qem.k(this.val$storyVideoItem.mVid, true);
    File localFile = new File(str2);
    Object localObject1 = rpq.k(this.val$storyVideoItem.mLocalVideoPath, qem.getApplicationContext().getResources().getDisplayMetrics().widthPixels, qem.getApplicationContext().getResources().getDisplayMetrics().heightPixels);
    if ((!rox.fileExistsAndNotEmpty(this.val$storyVideoItem.mLocalVideoPath)) || (localObject1 == null))
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "storyVideoItem.mLocalVideoPath: " + this.val$storyVideoItem.mLocalVideoPath + " or retriever.getFrameAtTime == null");
      }
      localObject1 = new qem.a(this.axd, 3, this.val$storyVideoItem);
      pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    Object localObject2 = rqj.a(qem.getApplicationContext(), this.val$storyVideoItem.mVid, this.val$storyVideoItem.mVideoWidth, this.val$storyVideoItem.mVideoHeight, this.bke);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "download water mark failed");
    }
    Object localObject3 = rqj.e(this.val$storyVideoItem);
    localObject1 = rqj.d(this.val$storyVideoItem);
    String str1 = rqj.a(this.val$storyVideoItem.getInteractLayout(), this.val$storyVideoItem.mVideoWidth, this.val$storyVideoItem.mVideoHeight);
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    while ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      str1 = plr.atr;
      str1 = str1 + this.val$storyVideoItem.mVid + System.currentTimeMillis() + "_max.png";
      if (!rqj.g((String)localObject3, (String)localObject1, str1))
      {
        localObject1 = new qem.a(this.axd, 3, this.val$storyVideoItem);
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
        QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg maxMask videoVote failed");
        return;
        localObject1 = str1;
      }
      else
      {
        localObject1 = str1;
      }
    }
    while ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject3 = localObject2;
      if (rqj.g((String)localObject1, (String)localObject2, (String)localObject2)) {
        break label433;
      }
      localObject1 = new qem.a(this.axd, 3, this.val$storyVideoItem);
      pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "combineTwoImg failed");
      return;
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        localObject1 = localObject3;
      }
    }
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
    for (;;)
    {
      localObject3 = localObject1;
      label433:
      localObject1 = rpq.k(this.val$storyVideoItem.mLocalVideoPath, qem.getApplicationContext().getResources().getDisplayMetrics().widthPixels, qem.getApplicationContext().getResources().getDisplayMetrics().heightPixels);
      if (localObject1 != null) {
        break;
      }
      localObject1 = new qem.a(this.axd, 3, this.val$storyVideoItem);
      pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
      QLog.e("Q.qqstory.player.PlayModeUtils", 2, "getLocalVideoThumbnail failed");
      return;
      localObject1 = localObject2;
    }
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = SafeBitmapFactory.decodeFile((String)localObject3);
      localObject2 = rop.d((Bitmap)localObject1, (Bitmap)localObject3);
      ((Bitmap)localObject1).recycle();
      ((Bitmap)localObject3).recycle();
      localObject1 = localObject2;
    }
    for (;;)
    {
      try
      {
        aqhu.saveBitmapToFile((Bitmap)localObject1, new File(str2));
        ((Bitmap)localObject1).recycle();
        rox.broadcastCarmera(qem.getApplicationContext(), localFile);
        localObject1 = new qem.a(this.axd, 2, this.val$storyVideoItem);
        ((qem.a)localObject1).outputPath = str2;
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
        return;
      }
      catch (IOException localIOException)
      {
        localObject2 = new qem.a(this.axd, 3, this.val$storyVideoItem);
        pmi.a().dispatch((Dispatcher.Dispatchable)localObject2);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("Q.qqstory.ffmpeg.FFmpegCmd", 2, "FFmpegUtils combineTwoImg IOException " + localIOException.getMessage());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.PlayModeUtils.5
 * JD-Core Version:    0.7.0.1
 */