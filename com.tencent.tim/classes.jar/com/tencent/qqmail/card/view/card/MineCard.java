package com.tencent.qqmail.card.view.card;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.card.QMCardManager;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.CardHandler;
import com.tencent.qqmail.card.view.CollapsingAvatarsView;
import com.tencent.qqmail.utilities.ui.DividerTextView;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class MineCard
  extends BaseCard
{
  private static final String TAG = "MineCard";
  private static int mCardEyeBoxMarginBottom = -1;
  private static int mCardEyeBoxMarginLeft = -1;
  private LinearLayout mBottomContentContainer;
  private FrameLayout mCardBox;
  private TextView mCardEyeBox;
  private DividerTextView mNameTvSingle;
  private CollapsingAvatarsView mThanksAvatarsView;
  private View mThanksBox;
  int mThanksInfoTextWidth = 0;
  private TextView mThanksInfoTv;
  
  public MineCard(Context paramContext)
  {
    super(paramContext);
  }
  
  private void calCoverInfo(float paramFloat1, float paramFloat2)
  {
    int j = 0;
    paramFloat1 /= paramFloat2;
    paramFloat2 = this.mCardCoverView.getWidth() / this.mCardCoverView.getHeight();
    int i;
    if (paramFloat1 < paramFloat2) {
      i = (int)((this.mCardCoverView.getWidth() - paramFloat1 * this.mCardCoverView.getHeight()) / 2.0F);
    }
    for (;;)
    {
      mCardEyeBoxMarginLeft = i + getResources().getDimensionPixelSize(2131296801);
      mCardEyeBoxMarginBottom = j + getResources().getDimensionPixelSize(2131296800);
      FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)this.mCardEyeBox.getLayoutParams();
      localLayoutParams.leftMargin = mCardEyeBoxMarginLeft;
      localLayoutParams.bottomMargin = mCardEyeBoxMarginBottom;
      this.mCardEyeBox.setLayoutParams(localLayoutParams);
      return;
      if (paramFloat1 > paramFloat2)
      {
        j = (int)((this.mCardCoverView.getHeight() - this.mCardCoverView.getWidth() / paramFloat1) / 2.0F);
        i = 0;
      }
      else
      {
        i = 0;
      }
    }
  }
  
  private int getAvatarListMaxWidth()
  {
    return this.mCardWidth - getResources().getDimensionPixelSize(2131296813) * 2 - this.mThanksInfoTextWidth - ((LinearLayout.LayoutParams)this.mThanksInfoTv.getLayoutParams()).rightMargin - getResources().getDimensionPixelSize(2131296809) * 2 - QMUIKit.dpToPx(12);
  }
  
  protected void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131558824, this, true);
    this.mCardBox = ((FrameLayout)findViewById(2131365483));
    this.mCardCoverView = ((ImageView)findViewById(2131364286));
    this.mCardNameTv = ((TextView)findViewById(2131364305));
    this.mCardEyeBox = ((TextView)findViewById(2131364319));
    this.mThanksBox = findViewById(2131379605);
    this.mThanksInfoTv = ((TextView)findViewById(2131373541));
    this.mThanksAvatarsView = ((CollapsingAvatarsView)findViewById(2131373539));
    this.mBottomContentContainer = ((LinearLayout)findViewById(2131363650));
    this.mNameTvSingle = ((DividerTextView)findViewById(2131364307));
  }
  
  protected void onAddBottomContentHeight(int paramInt)
  {
    super.onAddBottomContentHeight(paramInt);
    Object localObject = (FrameLayout.LayoutParams)this.mCardBox.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin += paramInt;
    localObject = this.mBottomContentContainer.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height += paramInt;
    localObject = this.mNameTvSingle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height += paramInt;
  }
  
  protected void onBitmapChanged(Bitmap paramBitmap)
  {
    if ((mCardEyeBoxMarginLeft != -1) && (mCardEyeBoxMarginBottom != -1)) {
      return;
    }
    if (this.mCardCoverView.getWidth() == 0)
    {
      this.mCardCoverView.getViewTreeObserver().addOnGlobalLayoutListener(new MineCard.2(this, paramBitmap));
      return;
    }
    calCoverInfo(paramBitmap.getWidth(), paramBitmap.getHeight());
  }
  
  protected void onCardWidthChanged(int paramInt)
  {
    super.onCardWidthChanged(paramInt);
    if (this.mCard != null) {
      render(this.mCard, this.mCardHandler);
    }
  }
  
  public void render(QMCardData paramQMCardData, CardHandler paramCardHandler)
  {
    super.render(paramQMCardData, paramCardHandler);
    int i = paramQMCardData.getViewCount();
    if (i == 0)
    {
      this.mCardEyeBox.setVisibility(8);
      i = paramQMCardData.getThanksCount();
      if (i > 0) {
        break label84;
      }
      this.mBottomContentContainer.setVisibility(8);
      this.mNameTvSingle.setVisibility(0);
      this.mNameTvSingle.setText(paramQMCardData.getName());
    }
    label84:
    do
    {
      return;
      this.mCardEyeBox.setText(String.valueOf(i));
      this.mCardEyeBox.setVisibility(0);
      break;
      this.mBottomContentContainer.setVisibility(0);
      this.mNameTvSingle.setVisibility(8);
      paramCardHandler = String.format(getResources().getString(2131691329), new Object[] { Integer.valueOf(i) });
      this.mThanksInfoTextWidth = ((int)this.mThanksInfoTv.getPaint().measureText(paramCardHandler));
      this.mThanksInfoTv.setText(paramCardHandler);
      paramCardHandler = QMCardManager.shareInstance().getThanksFriendList(paramQMCardData.getCardId());
      this.mThanksAvatarsView.setAvatars(paramCardHandler, getAvatarListMaxWidth());
      this.mThanksBox.setOnClickListener(new MineCard.1(this, paramQMCardData));
    } while ((mCardEyeBoxMarginLeft == -1) || (mCardEyeBoxMarginBottom == -1));
    paramQMCardData = (FrameLayout.LayoutParams)this.mCardEyeBox.getLayoutParams();
    paramQMCardData.leftMargin = mCardEyeBoxMarginLeft;
    paramQMCardData.bottomMargin = mCardEyeBoxMarginBottom;
    this.mCardEyeBox.setLayoutParams(paramQMCardData);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.card.MineCard
 * JD-Core Version:    0.7.0.1
 */