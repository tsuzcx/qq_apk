package com.tencent.biz.qqstory.playmode.util;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import aqhu;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.io.File;
import java.io.IOException;
import pmi;
import qem;
import qeu;
import qeu.b;
import ram;
import rpq;
import rqj;

public class SendVideoToFriendHelper$1
  implements Runnable
{
  public SendVideoToFriendHelper$1(qeu paramqeu, long paramLong, StoryVideoItem paramStoryVideoItem, String paramString) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    ram.w("SendVideoToFriendHelper", "generateShareThumb run start: %d.", new Object[] { Long.valueOf(l - this.val$start) });
    qeu.a(this.this$0, this.val$storyVideoItem);
    if (!TextUtils.isEmpty(this.val$storyVideoItem.mVideoLocalThumbnailPath)) {
      ram.d("SendVideoToFriendHelper", "video thumbnail has existed.");
    }
    for (Object localObject1 = SafeBitmapFactory.decodeFile(this.val$storyVideoItem.mVideoLocalThumbnailPath);; localObject1 = rpq.k(this.val$storyVideoItem.mLocalVideoPath, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().widthPixels, BaseApplicationImpl.getContext().getResources().getDisplayMetrics().heightPixels))
    {
      ram.w("SendVideoToFriendHelper", "generate share thumbnail step first cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
      if (localObject1 != null) {
        break;
      }
      localObject1 = new qeu.b(new ErrorMessage(-1, "generate thumbnail failed."), this.axd);
      pmi.a().dispatch((Dispatcher.Dispatchable)localObject1);
      return;
    }
    l = System.currentTimeMillis();
    Object localObject2 = localObject1;
    if (!TextUtils.isEmpty(this.val$storyVideoItem.mLocalMaskPath)) {
      localObject2 = rqj.e((Bitmap)localObject1, SafeBitmapFactory.decodeFile(this.val$storyVideoItem.mLocalMaskPath));
    }
    ram.w("SendVideoToFriendHelper", "generate share thumbnail step second cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    Object localObject3 = rqj.a(this.val$storyVideoItem.getPollLayout(), this.val$storyVideoItem.mVideoWidth, this.val$storyVideoItem.mVideoHeight);
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = rqj.e((Bitmap)localObject2, (Bitmap)localObject3);
    }
    ram.w("SendVideoToFriendHelper", "generate share thumbnail step third cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject3 = rqj.a(this.val$storyVideoItem.getInteractLayout(), this.val$storyVideoItem.mVideoWidth, this.val$storyVideoItem.mVideoHeight);
    localObject2 = localObject1;
    if (localObject3 != null) {
      localObject2 = rqj.e((Bitmap)localObject1, (Bitmap)localObject3);
    }
    ram.w("SendVideoToFriendHelper", "generate share thumbnail step forth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    ram.w("SendVideoToFriendHelper", "generate share thumbnail step fifth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
    l = System.currentTimeMillis();
    localObject1 = qem.k(this.val$storyVideoItem.mVid, true);
    localObject3 = new File((String)localObject1);
    for (;;)
    {
      try
      {
        aqhu.saveBitmapToFile((Bitmap)localObject2, (File)localObject3);
        ((Bitmap)localObject2).recycle();
        ram.e("SendVideoToFriendHelper", "generate thumbnail failed. e = %s.", localIOException1);
      }
      catch (IOException localIOException1)
      {
        try
        {
          ram.b("SendVideoToFriendHelper", "generate thumbnail success. shareThumbPath = %s.", localObject1);
          ram.w("SendVideoToFriendHelper", "generate share thumbnail step sixth cost: %d.", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          localObject2 = new qeu.b(new ErrorMessage(), this.axd);
          ((qeu.b)localObject2).f = this.val$storyVideoItem;
          ((qeu.b)localObject2).axf = ((String)localObject1);
          pmi.a().dispatch((Dispatcher.Dispatchable)localObject2);
          return;
        }
        catch (IOException localIOException2)
        {
          qeu.b localb;
          break label503;
        }
        localIOException1 = localIOException1;
        localObject1 = null;
      }
      label503:
      localb = new qeu.b(new ErrorMessage(-1, "generate thumbnail failed." + localIOException1.getMessage()), this.axd);
      pmi.a().dispatch(localb);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.playmode.util.SendVideoToFriendHelper.1
 * JD-Core Version:    0.7.0.1
 */