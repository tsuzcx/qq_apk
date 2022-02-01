package com.tencent.mobileqq.theme.diy;

import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import anot;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ThemeDIYActivity$12
  implements AdapterView.OnItemClickListener
{
  ThemeDIYActivity$12(ThemeDIYActivity paramThemeDIYActivity) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject1 = (ItemView)paramView;
    if ((localObject1 == null) || (((ItemView)localObject1).resSuitData == null)) {
      QLog.e("ThemeDIYActivity", 1, "resItemClickListener onItemClick, null == itemView , position:" + paramInt + ", itemView:" + localObject1);
    }
    for (;;)
    {
      EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, paramLong);
      return;
      int i;
      if ((((ItemView)localObject1).resSuitData instanceof ResSuitData.BgSuit))
      {
        ResSuitData.BgSuit localBgSuit = (ResSuitData.BgSuit)((ItemView)localObject1).resSuitData;
        Object localObject2;
        if ("99".equals(localBgSuit.id))
        {
          localObject1 = this.this$0.getIntent();
          localObject2 = DIYThemeUtils.getResData(this.this$0.app, this.this$0.mUploadBgRSD, 121, this.this$0.mUploadBgRSD.id + "." + this.this$0.mCurrentPageIndex + "." + System.currentTimeMillis()).path;
          Rect localRect = new Rect();
          this.this$0.getWindow().getDecorView().getWindowVisibleDisplayFrame(localRect);
          ((Intent)localObject1).putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
          int m = localRect.width();
          int k = localRect.height();
          int j = m;
          i = k;
          if (this.this$0.mCurrentPageIndex != 2)
          {
            j = m * 3 / 4;
            i = k * 3 / 4;
          }
          PhotoUtils.a((Intent)localObject1, this.this$0, ThemeDIYActivity.class.getName(), localRect.width() * 4 / 5, localRect.height() * 4 / 5, j, i, (String)localObject2);
          localObject1 = "diy_photo";
        }
        for (;;)
        {
          anot.a(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", (String)localObject1, 0, 0, String.valueOf(this.this$0.mCurrentPageIndex), localBgSuit.id, "" + localBgSuit.from, "");
          break;
          this.this$0.mPageView.mData.tryOnBgRSD = localBgSuit;
          this.this$0.setListItemStatus(this.this$0.bgResHListView, this.this$0.mPageView.mData.tryOnBgRSD, this.this$0.mPageView.mData.usedBgRSD, null);
          localObject2 = DIYThemeUtils.getResData(null, localBgSuit, 117, localBgSuit.thumbnail);
          if ("100".equals(localBgSuit.id))
          {
            localObject1 = "Diy_default";
            this.this$0.mPageView.showPic(this.this$0.mPageView.mData.defaultBgRSD, null, true, null);
            ((ResData)localObject2).resID = localBgSuit.resID;
            this.this$0.blurBg((ResData)localObject2, this.this$0.mPageView.bgDrawable, 1, false);
          }
          for (;;)
          {
            if ((TextUtils.isEmpty(localBgSuit.id)) || (localBgSuit.id.equals(this.this$0.mPageView.mData.usedBgRSD.id))) {
              break label710;
            }
            this.this$0.mPageView.mData.mSetStatus = 2;
            break;
            this.this$0.mPageView.showPic(localBgSuit, null, true, null);
            if (((ItemView)localObject1).mThumImg != null) {}
            for (localObject1 = ((ItemView)localObject1).mThumImg.getBackground();; localObject1 = null)
            {
              if ((localObject1 != null) && ((localObject1 instanceof URLDrawable)) && (((URLDrawable)localObject1).getStatus() == 1)) {
                break label689;
              }
              this.this$0.mPageView.bgDrawable = null;
              this.this$0.mHandler.sendMessage(Message.obtain(this.this$0.mHandler, 19, localObject2));
              localObject1 = "diy_yangtu";
              break;
            }
            label689:
            this.this$0.blurBg((ResData)localObject2, (Drawable)localObject1, 1, true);
            localObject1 = "diy_yangtu";
          }
          label710:
          this.this$0.mPageView.mData.mSetStatus = 0;
        }
      }
      if ((((ItemView)localObject1).resSuitData instanceof ResSuitData.StyleSuit))
      {
        localObject1 = (ResSuitData.StyleSuit)((ItemView)localObject1).resSuitData;
        this.this$0.tryOnStyleRSD = ((ResSuitData)localObject1);
        this.this$0.setListItemStatus(this.this$0.styleResHListView, this.this$0.tryOnStyleRSD, this.this$0.usedStyleRSD, null);
        i = 0;
        while (i < this.this$0.mScrollLayout.getChildCount())
        {
          ((PageView)this.this$0.mScrollLayout.getChildAt(i)).showPic((ResSuitData)localObject1, null, true, null);
          i += 1;
        }
        if ((this.this$0.mUserThemeId == null) || (!this.this$0.mUserThemeId.equals(((ResSuitData.StyleSuit)localObject1).id))) {}
        for (this.this$0.mStyleSetStatus = 2;; this.this$0.mStyleSetStatus = 0)
        {
          this.this$0.mAdapter.tryOnStyleRSD = this.this$0.tryOnStyleRSD;
          anot.a(this.this$0.app, "CliOper", "", this.this$0.app.getCurrentAccountUin(), "theme_mall", "diy_style", 0, 0, String.valueOf(this.this$0.mCurrentPageIndex), ((ResSuitData.StyleSuit)localObject1).id, "", "");
          if (this.this$0.mCurrentPageIndex != 0) {
            break;
          }
          this.this$0.mScrollLayout.snapToScreen(1);
          this.this$0.onScreenChange(1);
          break;
        }
      }
      QLog.e("ThemeDIYActivity", 1, "resItemClickListener itemView.resSuitData Type Error position:" + paramInt + ", itemView.resSuitData:" + ((ItemView)localObject1).resSuitData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.12
 * JD-Core Version:    0.7.0.1
 */