package com.tencent.mobileqq.activity.photo.album;

import aeee;
import android.content.Intent;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import anot;
import arlc;
import ayxa;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.helper.AIOLongShotHelper;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.b;
import com.tencent.widget.HorizontalListView;
import ivv;
import java.util.ArrayList;
import ztt;
import zvz;

public class NewPhotoPreviewActivity
  extends AbstractPhotoPreviewActivity
  implements DragView.b
{
  public ztt a;
  public DragView b;
  public HorizontalListView p;
  public BubblePopupWindow popup;
  public View yW;
  
  protected void crR()
  {
    int i = 0;
    this.b = ((DragView)findViewById(2131366139));
    this.b.setGestureChangeListener(this);
    this.b.setRatioModify(true);
    Rect localRect = (Rect)getIntent().getParcelableExtra("KEY_THUMBNAL_BOUND");
    if (localRect != null)
    {
      if (this.mEnableLiuHai) {
        i = ayxa.sNotchHeight;
      }
      localRect.top -= i;
      localRect.bottom -= i;
      if ((this.mPhotoPreviewData.paths != null) && (-1 != this.mPhotoPreviewData.firstSelectedPostion) && (this.mPhotoPreviewData.paths.get(this.mPhotoPreviewData.firstSelectedPostion) != null))
      {
        LocalMediaInfo localLocalMediaInfo = getMediaInfo((String)this.mPhotoPreviewData.paths.get(this.mPhotoPreviewData.firstSelectedPostion));
        if (localLocalMediaInfo != null) {
          localLocalMediaInfo.thumbRect = localRect;
        }
      }
      this.b.setOriginRect(localRect);
      return;
    }
    this.b.setEnableDrag(false);
  }
  
  public PhotoPreviewLogic generateLogic()
  {
    int i = getIntent().getIntExtra("enter_from", 0);
    PhotoPreviewLogic localPhotoPreviewLogic = zvz.a(i, this);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoPreviewActivity", 2, "generateLogic:" + localPhotoPreviewLogic.getClass().getName() + " enterFrom:" + i);
    }
    return localPhotoPreviewLogic;
  }
  
  public Class getBackActivity()
  {
    return NewPhotoListActivity.class;
  }
  
  void hideMenuBar()
  {
    super.hideMenuBar();
    if (this.popup != null) {
      this.popup.dismiss();
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("PhotoPreviewActivity", 4, "[PhotoPreviewActivity] [onActivityResult] requestCode = " + paramInt1 + "  resultCode:" + paramInt2 + "  ok:" + -1);
    }
    this.mPhotoPreviewLogic.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    if (this.rootLayout != null)
    {
      Drawable localDrawable = this.rootLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha((int)(255.0F * paramFloat));
      }
    }
    if (paramFloat < 0.8F)
    {
      this.topBar.setVisibility(4);
      this.bottomBar.setVisibility(4);
      this.yW.setVisibility(4);
      this.p.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ayxa.initLiuHaiProperty(this);
    if (ayxa.needCloseFullScreen()) {
      ayxa.closeFullScreen(this);
    }
    super.onCreate(paramBundle);
    crR();
    if (this.mPhotoPreviewLogic.mPhotoCommonData.myUin == null) {
      this.mPhotoPreviewLogic.mPhotoCommonData.myUin = this.lastLoginUin;
    }
  }
  
  public void onDestroy()
  {
    if (this.popup != null) {
      this.popup.dismiss();
    }
    super.onDestroy();
  }
  
  public void onGestureFinish()
  {
    Object localObject = this.adapter.getItem(getCurrentSelectedPostion());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = getMediaInfoTemp((String)localObject);
      if (localObject != null)
      {
        if (((LocalMediaInfo)localObject).mMediaType != 0) {
          break label85;
        }
        localObject = "0X8009AB2";
      }
    }
    for (;;)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        anot.a(null, "dc00898", "", "", (String)localObject, (String)localObject, 4, 0, "", "", "", "");
      }
      this.mPhotoPreviewLogic.onBackPressed(true);
      return;
      label85:
      if (((LocalMediaInfo)localObject).mMediaType == 1) {
        localObject = "0X8009AB3";
      } else {
        localObject = null;
      }
    }
  }
  
  public void onPause()
  {
    super.onPause();
    ivv.o(BaseApplicationImpl.getContext(), false);
    arlc.sendWindowVisibleBroadcast(BaseApplicationImpl.getContext(), true);
    aeee.e(BaseApplicationImpl.getContext(), 2, true);
  }
  
  public void onResetPosition()
  {
    if (this.rootLayout != null)
    {
      Drawable localDrawable = this.rootLayout.getBackground();
      if (localDrawable != null) {
        localDrawable.mutate().setAlpha(255);
      }
    }
    this.topBar.setVisibility(0);
    if (this.mPhotoPreviewLogic.needShowMultiPhoto())
    {
      this.yW.setVisibility(0);
      this.p.setVisibility(0);
    }
  }
  
  public void r(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void s(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1)
    {
      setResult(-1, paramIntent);
      finish();
    }
  }
  
  public void t(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (paramInt2 == -1) {
      AIOLongShotHelper.y(this, paramIntent);
    }
    while ((paramIntent == null) || (!paramIntent.getBooleanExtra("NOCANCEL4DATALIN", false))) {
      return;
    }
    setResult(-1, paramIntent);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity
 * JD-Core Version:    0.7.0.1
 */