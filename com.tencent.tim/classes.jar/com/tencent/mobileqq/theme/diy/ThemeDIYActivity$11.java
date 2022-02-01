package com.tencent.mobileqq.theme.diy;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import aszy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.TabBarView.a;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

class ThemeDIYActivity$11
  extends Handler
{
  ThemeDIYActivity$11(ThemeDIYActivity paramThemeDIYActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    switch (paramMessage.what)
    {
    case 23: 
    default: 
      QLog.e("ThemeDIYActivity", 1, "Handler = default");
    case 29: 
    case 19: 
      do
      {
        for (;;)
        {
          return;
          i = paramMessage.arg1;
          if ((this.this$0.mScrollLayout != null) && (this.this$0.mScrollLayout.getChildCount() > i)) {}
          for (localObject = this.this$0.mScrollLayout.getChildAt(i);; localObject = null)
          {
            if ((!(localObject instanceof PageView)) || (!(paramMessage.obj instanceof ThemeBackground))) {
              break label246;
            }
            localObject = (PageView)localObject;
            paramMessage = (ThemeBackground)paramMessage.obj;
            if (paramMessage.img == null) {
              break;
            }
            ((PageView)localObject).showPic(this.this$0.showData[i].usedBgRSD, null, false, paramMessage.img);
            if ((i != 0) || (this.this$0.showData[i].usedBgRSD == null)) {
              break;
            }
            localObject = new ResData();
            ((ResData)localObject).id = this.this$0.showData[i].usedBgRSD.id;
            ((ResData)localObject).path = paramMessage.path;
            this.this$0.blurBg((ResData)localObject, paramMessage.img, 1, true);
            return;
          }
        }
        paramMessage = (ResData)paramMessage.obj;
      } while (paramMessage == null);
      Object localObject = this.this$0.mContext.getResources().getDrawable(2130848337);
      try
      {
        URL localURL = new URL("themediydownloader", paramMessage.path, paramMessage.url);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject);
        localURLDrawableOptions.mUseSharpPImage = aszy.cv(BaseApplicationImpl.getApplication());
        localObject = URLDrawable.getDrawable(localURL, localURLDrawableOptions);
        if (((URLDrawable)localObject).getStatus() != 1)
        {
          ((URLDrawable)localObject).addHeader("my_id", paramMessage.id);
          ((URLDrawable)localObject).addHeader("my_uin", this.this$0.app.getCurrentUin());
          ((URLDrawable)localObject).addHeader("my_type", "" + paramMessage.type);
          ((URLDrawable)localObject).addHeader("page_index", "" + this.this$0.mCurrentPageIndex);
          return;
        }
      }
      catch (MalformedURLException paramMessage)
      {
        QLog.e("ThemeDIYActivity", 1, "HANDLER_MSG_SET_BLUR_BG err:" + paramMessage.getMessage());
        return;
      }
      this.this$0.blurBg(paramMessage, (Drawable)localObject, 0, true);
      return;
    case 20: 
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof Drawable))) {}
      for (paramMessage = (Drawable)paramMessage.obj;; paramMessage = null)
      {
        this.this$0.mblurbgView.setBackgroundDrawable(paramMessage);
        this.this$0.mPageView.bgDrawable = paramMessage;
        return;
      }
    case 21: 
      label246:
      if (paramMessage.arg1 == 1) {
        if (this.this$0.usedStyleRSD != null)
        {
          paramMessage = this.this$0.usedStyleRSD;
          if ((paramMessage != null) || (this.this$0.mStyleSuits.size() <= 0)) {
            break label1236;
          }
          paramMessage = (ResSuitData)this.this$0.mStyleSuits.get(0);
        }
      }
      break;
    }
    label1236:
    for (;;)
    {
      if (paramMessage != null)
      {
        i = 0;
        for (;;)
        {
          if (i < this.this$0.mScrollLayout.getChildCount())
          {
            ((PageView)this.this$0.mScrollLayout.getChildAt(i)).showPic(paramMessage, null, false, null);
            i += 1;
            continue;
            paramMessage = this.this$0.tryOnStyleRSD;
            break;
          }
        }
      }
      if (this.this$0.bgResHListView != null)
      {
        this.this$0.bgResHListView = null;
        this.this$0.mIsUserClickTab.set(false);
        this.this$0.mTypeTabChangeListener.onTabSelected(1, 1);
        return;
      }
      if (this.this$0.styleResHListView == null) {
        break;
      }
      this.this$0.styleResHListView = null;
      this.this$0.mIsUserClickTab.set(false);
      this.this$0.mTypeTabChangeListener.onTabSelected(3, 3);
      return;
      i = 0;
      if (i < this.this$0.showData.length)
      {
        if (6 != this.this$0.showData[i].mSaveStatus)
        {
          if (this.this$0.showData[i].tryOnBgBigOrgRD == null) {
            break label869;
          }
          QLog.e("ThemeDIYActivity", 1, "save timeout 0 Page:" + i + ", state:" + this.this$0.showData[i].tryOnBgBigOrgRD.state + ", id:" + this.this$0.showData[i].tryOnBgBigOrgRD.id);
          this.this$0.showData[i].tryOnBgBigOrgRD.state = 0;
        }
        for (;;)
        {
          i += 1;
          break;
          label869:
          QLog.e("ThemeDIYActivity", 1, "save timeout 1 Page:" + i);
        }
      }
      if (6 != this.this$0.mStyleSaveStatus) {
        QLog.e("ThemeDIYActivity", 1, "save timeout 3 mStyleSaveStatus:" + this.this$0.mStyleSaveStatus);
      }
      if (6 != this.this$0.mSaveToServerStatus) {
        QLog.e("ThemeDIYActivity", 1, "save timeout 4 mSaveToServerStatus:" + this.this$0.mSaveToServerStatus);
      }
      this.this$0.mHandler.removeMessages(24);
      this.this$0.mIsSaving.set(false);
      this.this$0.setProgessDialog(false, 0);
      QQToast.a(this.this$0.mContext, 2131721023, 3000).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      if (paramMessage.obj == null)
      {
        this.this$0.saveOperate(false);
        return;
      }
      this.this$0.saveOperate(true);
      return;
      if (paramMessage.obj == null) {
        break;
      }
      this.this$0.setProgressText(paramMessage.obj.toString());
      return;
      this.this$0.setProgessDialog(false, 0);
      if (paramMessage.obj == null) {
        break;
      }
      QQToast.a(this.this$0.mContext, paramMessage.obj.toString(), 3600).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      if (paramMessage.obj == null) {
        break;
      }
      QQToast.a(this.this$0.mContext, paramMessage.obj.toString(), 3600).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
      if (1 != paramMessage.arg1) {
        break;
      }
      this.this$0.setProgessDialog(false, 0);
      this.this$0.onUpdate(paramMessage.obj);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.theme.diy.ThemeDIYActivity.11
 * JD-Core Version:    0.7.0.1
 */