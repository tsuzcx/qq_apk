package com.tencent.qqmail.card.view.card;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.CardHandler;
import com.tencent.qqmail.card.view.Gallery.EcoGallery.ScrollStateObserveView;
import com.tencent.qqmail.card.view.Gallery.EcoGalleryAbsSpinner.LayoutParams;
import com.tencent.qqmail.card.view.Recyclable;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public abstract class BaseCard
  extends RelativeLayout
  implements EcoGallery.ScrollStateObserveView, Recyclable
{
  private static final String TAG = "BaseCard";
  private static final int bottomContentAddHeight = QMUIKit.dpToPx(20);
  private static final float suitableRadio = 1.65F;
  protected View mBottomView;
  protected QMCardData mCard;
  protected ImageView mCardCoverView;
  protected CardHandler mCardHandler;
  protected TextView mCardNameTv;
  protected int mCardWidth;
  private String mCoverUrl;
  protected Drawable mDefaultCover = getResources().getDrawable(2130839117);
  protected View mRootView;
  
  public BaseCard(Context paramContext)
  {
    super(paramContext);
    initView();
    this.mRootView = findViewById(2131364330);
    cardHeightProtection();
  }
  
  private void cardHeightProtection()
  {
    if (QMUIKit.getScreenHeight() / QMUIKit.getScreenWidth() > 1.65F)
    {
      int j = (int)(QMUIKit.getScreenHeight() - QMUIKit.getScreenWidth() * 1.65F);
      int i = j;
      if (j > bottomContentAddHeight)
      {
        i = j - bottomContentAddHeight;
        onAddBottomContentHeight(bottomContentAddHeight);
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mRootView.getLayoutParams();
      localLayoutParams.topMargin += i * 2 / 3;
      j = localLayoutParams.bottomMargin;
      localLayoutParams.bottomMargin = (i / 3 + j);
      this.mRootView.setLayoutParams(localLayoutParams);
    }
  }
  
  protected abstract void initView();
  
  protected void onAddBottomContentHeight(int paramInt) {}
  
  protected void onBitmapChanged(Bitmap paramBitmap) {}
  
  protected void onCardWidthChanged(int paramInt) {}
  
  public void onScrollStateChanged(int paramInt) {}
  
  public void recycle() {}
  
  public void render(QMCardData paramQMCardData, CardHandler paramCardHandler)
  {
    Log.v("BaseCard", "render: " + paramQMCardData.getCardId() + ", " + paramQMCardData.getName() + ", " + paramQMCardData.getCardCoverUrl());
    this.mCard = paramQMCardData;
    this.mCardHandler = paramCardHandler;
    this.mCardNameTv.setText(this.mCard.getName());
    paramQMCardData = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal(this.mCard.getCardCoverUrl());
    this.mCoverUrl = this.mCard.getCardCoverUrl();
    if (paramQMCardData == null)
    {
      this.mCardCoverView.setImageDrawable(this.mDefaultCover);
      paramQMCardData = new DownloadInfo();
      paramQMCardData.setUrl(this.mCoverUrl);
      paramQMCardData.setImageDownloadListener(new BaseCard.1(this));
      ImageDownloadManager.shareInstance().fetchImage(paramQMCardData);
      return;
    }
    this.mCardCoverView.setImageBitmap(paramQMCardData);
    onBitmapChanged(paramQMCardData);
  }
  
  public final void setCardWidth(int paramInt)
  {
    this.mCardWidth = paramInt;
    onCardWidthChanged(paramInt);
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    Object localObject = localLayoutParams;
    if (localLayoutParams == null) {
      localObject = new EcoGalleryAbsSpinner.LayoutParams(paramInt, -2);
    }
    ((ViewGroup.LayoutParams)localObject).width = paramInt;
    setLayoutParams((ViewGroup.LayoutParams)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.card.BaseCard
 * JD-Core Version:    0.7.0.1
 */