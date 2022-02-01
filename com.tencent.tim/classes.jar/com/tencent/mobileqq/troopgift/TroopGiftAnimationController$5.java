package com.tencent.mobileqq.troopgift;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.text.TextUtils;
import aptj;
import apuh;
import apwy;
import apwy.a;
import apxd;
import apxe;
import apxf;
import apxg;
import aqbn;
import aqcx;
import aqdj;
import aqhu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageForDeliverGiftTips;
import com.tencent.qphone.base.util.QLog;

public class TroopGiftAnimationController$5
  implements Runnable
{
  public TroopGiftAnimationController$5(apwy paramapwy, MessageForDeliverGiftTips paramMessageForDeliverGiftTips) {}
  
  public void run()
  {
    apwy.a(this.this$0, System.currentTimeMillis());
    Object localObject2;
    Object localObject1;
    if (apwy.a(this.this$0) != null)
    {
      this.this$0.fN = this.this$0.a(String.valueOf(this.a.senderUin), new apxd(this));
      localObject2 = apuh.f(this.this$0.fN);
      if (!TextUtils.isEmpty(this.a.receiverHead))
      {
        localObject1 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = aqcx.dip2px(BaseApplicationImpl.getContext(), 70.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = aqcx.dip2px(BaseApplicationImpl.getContext(), 70.0F);
        ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = aqdj.g(1, 3);
        ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = aqdj.g(1, 3);
        localObject1 = URLDrawable.getDrawable(this.a.receiverHead, (URLDrawable.URLDrawableOptions)localObject1);
        if (((URLDrawable)localObject1).getStatus() != 1)
        {
          ((URLDrawable)localObject1).setDownloadListener(new apxe(this, (URLDrawable)localObject1));
          ((URLDrawable)localObject1).startDownload();
        }
        ((URLDrawable)localObject1).setURLDrawableListener(new apxf(this, (URLDrawable)localObject1));
        this.this$0.fO = ((Drawable)localObject1);
        localObject1 = apuh.f((Drawable)localObject1);
      }
    }
    for (;;)
    {
      label279:
      label338:
      Object localObject3;
      label344:
      String str;
      if ((!this.a.isToAll()) && (this.a.senderUin <= 0L) && (this.a.receiverUin <= 0L)) {
        if (!TextUtils.isEmpty(this.a.senderAvatarUrl))
        {
          localObject1 = URLDrawable.URLDrawableOptions.obtain();
          localObject1 = URLDrawable.getDrawable(this.a.senderAvatarUrl, (URLDrawable.URLDrawableOptions)localObject1);
          ((URLDrawable)localObject1).setDecodeHandler(aqbn.b);
          if ((((URLDrawable)localObject1).getStatus() == 1) && (((URLDrawable)localObject1).getCurrDrawable() != null))
          {
            localObject1 = aqhu.g(((URLDrawable)localObject1).getCurrDrawable());
            if (TextUtils.isEmpty(this.a.receiveAvatarUrl)) {
              break label563;
            }
            localObject2 = URLDrawable.URLDrawableOptions.obtain();
            localObject2 = URLDrawable.getDrawable(this.a.receiveAvatarUrl, (URLDrawable.URLDrawableOptions)localObject2);
            ((URLDrawable)localObject2).setDecodeHandler(aqbn.b);
            if ((((URLDrawable)localObject2).getStatus() != 1) || (((URLDrawable)localObject2).getCurrDrawable() == null)) {
              break label552;
            }
            localObject2 = aqhu.g(((URLDrawable)localObject2).getCurrDrawable());
            localObject3 = localObject1;
            localObject1 = localObject2;
            localObject2 = localObject3;
            str = aptj.a(this.a);
          }
        }
      }
      label552:
      label563:
      label614:
      for (;;)
      {
        try
        {
          localObject3 = BitmapFactory.decodeFile(str + "/avatar/avatar_anim_res.png");
          this.this$0.uiHandler.postDelayed(new TroopGiftAnimationController.5.5(this, str, (Bitmap)localObject2, (Bitmap)localObject1, (Bitmap)localObject3), 300L);
          return;
          this.this$0.fO = this.this$0.a(String.valueOf(this.a.receiverUin), new apxg(this));
          localObject1 = apuh.f(this.this$0.fO);
          break;
          if ((apwy.a(this.this$0) == null) || (!(apwy.a(this.this$0) instanceof apwy.a))) {
            break label617;
          }
          localObject1 = (apwy.a)apwy.a(this.this$0);
          localObject2 = ((apwy.a)localObject1).e(String.valueOf(this.a.senderUin), this.a.frienduin);
          localObject1 = ((apwy.a)localObject1).e(String.valueOf(this.a.receiverUin), this.a.frienduin);
          break;
          ((URLDrawable)localObject1).startDownload();
          localObject1 = aqhu.G();
          break label279;
          localObject1 = null;
          break label279;
          ((URLDrawable)localObject2).startDownload();
          localObject2 = aqhu.G();
          break label338;
          localObject3 = null;
          localObject2 = localObject1;
          localObject1 = localObject3;
          break label344;
          if (localObject2 != null) {
            break label614;
          }
          localObject2 = aqhu.G();
          if (localObject1 == null) {
            localObject1 = aqhu.G();
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          if (QLog.isColorLevel()) {
            QLog.d("TroopGiftAnimationController", 2, "decode avatarAnimRes failed");
          }
          Object localObject4 = null;
          continue;
        }
        break label344;
      }
      label617:
      localObject1 = null;
      localObject2 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopgift.TroopGiftAnimationController.5
 * JD-Core Version:    0.7.0.1
 */