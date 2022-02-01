package com.tencent.qqmail.card.view.card;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.qqmail.card.model.QMCardData;
import com.tencent.qqmail.card.view.CardHandler;

public class GeneralCard
  extends BaseCard
{
  private static final String TAG = "GeneralCard";
  private TextView mHotTagTv;
  private RelativeLayout mHotTagView;
  
  public GeneralCard(Context paramContext)
  {
    super(paramContext);
  }
  
  protected void initView()
  {
    LayoutInflater.from(getContext()).inflate(2131558823, this, true);
    this.mCardCoverView = ((ImageView)findViewById(2131364286));
    this.mCardNameTv = ((TextView)findViewById(2131364305));
    this.mHotTagView = ((RelativeLayout)findViewById(2131364322));
    this.mHotTagTv = ((TextView)findViewById(2131364323));
  }
  
  protected void onAddBottomContentHeight(int paramInt)
  {
    Object localObject = (FrameLayout.LayoutParams)this.mCardCoverView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).bottomMargin += paramInt;
    localObject = this.mCardNameTv.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).height += paramInt;
  }
  
  public void render(QMCardData paramQMCardData, CardHandler paramCardHandler)
  {
    super.render(paramQMCardData, paramCardHandler);
    paramQMCardData = paramQMCardData.getTag();
    Log.v("GeneralCard", "render tag: " + paramQMCardData);
    if ((paramQMCardData != null) && (paramQMCardData.length() > 0))
    {
      paramCardHandler = new AnimationSet(true);
      RotateAnimation localRotateAnimation = new RotateAnimation(45, 45, 1, 0.5F, 1, 0.5F);
      TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.17F, 1, 0.17F, 1, 0.0F, 1, 0.0F);
      paramCardHandler.setFillAfter(true);
      paramCardHandler.setFillEnabled(true);
      paramCardHandler.setDuration(0L);
      paramCardHandler.addAnimation(localRotateAnimation);
      paramCardHandler.addAnimation(localTranslateAnimation);
      this.mHotTagTv.setAnimation(paramCardHandler);
      paramCardHandler.startNow();
      this.mHotTagTv.setText(paramQMCardData);
      this.mHotTagView.setVisibility(0);
      return;
    }
    this.mHotTagView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.view.card.GeneralCard
 * JD-Core Version:    0.7.0.1
 */