package com.tencent.qqmail.card.fragment;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.fragment.base.QMBaseFragment.ViewHolder;
import com.tencent.qqmail.utilities.ui.MaskableImageView;
import com.tencent.qqmail.utilities.ui.QMButton;
import com.tencent.qqmail.view.QMTopBar;
import com.tencent.qqmail.view.QMWebView;
import java.util.ArrayList;
import java.util.List;

public class CardBirthdayPreviewFragment
  extends CardBaseFragment
{
  private LinearLayout mCardThumbContainer;
  private ImageView mEditFab;
  private List<ImageView> mImageViewList = new ArrayList();
  private QMTopBar mQMTopBar;
  private View mRootView;
  private int mSelectedIndex = 0;
  private WebView mWebView;
  
  private ImageView generateThumbImageView()
  {
    MaskableImageView localMaskableImageView = new MaskableImageView(getActivity());
    localMaskableImageView.setBorderColor(getResources().getColor(2131165524));
    localMaskableImageView.setBorderWidth(getResources().getDimensionPixelSize(2131296788));
    localMaskableImageView.setSelectorStrokeWidth(getResources().getDimensionPixelSize(2131296787));
    localMaskableImageView.setSelectorStrokeColor(getResources().getColor(2131165525));
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(getResources().getDimensionPixelSize(2131296791), getResources().getDimensionPixelSize(2131296789)));
    localLayoutParams.leftMargin = getResources().getDimensionPixelSize(2131296790);
    localLayoutParams.rightMargin = getResources().getDimensionPixelSize(2131296790);
    localLayoutParams.gravity = 16;
    localMaskableImageView.setLayoutParams(localLayoutParams);
    localMaskableImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    return localMaskableImageView;
  }
  
  private void initCardThumbs()
  {
    this.mCardThumbContainer = ((LinearLayout)this.mRootView.findViewById(2131363520));
    int i = 0;
    while (i < 10)
    {
      ImageView localImageView = generateThumbImageView();
      localImageView.setImageResource(2130840719);
      this.mImageViewList.add(localImageView);
      localImageView.setOnClickListener(new CardBirthdayPreviewFragment.3(this, localImageView));
      this.mCardThumbContainer.addView(localImageView);
      i += 1;
    }
    ((ImageView)this.mImageViewList.get(this.mSelectedIndex)).setSelected(true);
    this.mEditFab = ((ImageView)this.mRootView.findViewById(2131366187));
    this.mEditFab.setOnClickListener(new CardBirthdayPreviewFragment.4(this));
  }
  
  private void initTopBar()
  {
    this.mQMTopBar = ((QMTopBar)this.mRootView.findViewById(2131380043));
    this.mQMTopBar.setTitle(2131691279);
    this.mQMTopBar.setBackgroundColor(0);
    this.mQMTopBar.setButtonLeftNormal(2131691246);
    this.mQMTopBar.setButtonRightBlue(2131718919);
    if ((this.mQMTopBar.getButtonLeft() instanceof QMButton)) {
      ((QMButton)this.mQMTopBar.getButtonLeft()).setTextColor(getResources().getColor(2131165531));
    }
    if ((this.mQMTopBar.getButtonRight() instanceof QMButton)) {
      ((QMButton)this.mQMTopBar.getButtonRight()).setTextColor(getResources().getColor(2131165531));
    }
    this.mQMTopBar.getButtonLeft().setOnClickListener(new CardBirthdayPreviewFragment.1(this));
    this.mQMTopBar.getButtonRight().setOnClickListener(new CardBirthdayPreviewFragment.2(this));
    this.mQMTopBar.getTitleView().setTextColor(getResources().getColor(2131165531));
  }
  
  private void initWebview()
  {
    this.mWebView = ((QMWebView)this.mRootView.findViewById(2131382171));
  }
  
  public View initUI(QMBaseFragment.ViewHolder paramViewHolder)
  {
    this.mRootView = LayoutInflater.from(getActivity()).inflate(2131558821, null);
    this.mRootView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    initTopBar();
    initCardThumbs();
    initWebview();
    return this.mRootView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.card.fragment.CardBirthdayPreviewFragment
 * JD-Core Version:    0.7.0.1
 */