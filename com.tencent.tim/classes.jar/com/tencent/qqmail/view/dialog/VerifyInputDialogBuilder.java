package com.tencent.qqmail.view.dialog;

import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.EditTextDialogBuilder;
import com.tencent.qqmail.utilities.ui.QMLoading;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class VerifyInputDialogBuilder
  extends QMUIDialog.EditTextDialogBuilder
{
  private static final int VERIFY_HEIGHT = QMUIKit.dpToPx(27);
  private static final int VERIFY_WIDTH = QMUIKit.dpToPx(66);
  private QMLoading mLoading;
  private FrameLayout mLoadingBox;
  
  public VerifyInputDialogBuilder(Context paramContext)
  {
    super(paramContext);
    this.mRightImageView.setVisibility(0);
    this.mRightImageView.setBackgroundResource(2130851864);
    this.mRightImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    this.mLoading = new QMLoading(paramContext, QMLoading.SIZE_MINI);
    this.mLoadingBox = new FrameLayout(this.mContext);
    this.mLoadingBox.setBackgroundColor(paramContext.getResources().getColor(2131166569));
    this.mLoadingBox.setVisibility(8);
  }
  
  public RelativeLayout.LayoutParams createEditTextLayoutParams()
  {
    RelativeLayout.LayoutParams localLayoutParams = super.createEditTextLayoutParams();
    localLayoutParams.addRule(15, 0);
    localLayoutParams.addRule(8, this.mRightImageView.getId());
    localLayoutParams.bottomMargin = (-CONTENT_DISTANCE_SEPERATOR * 2);
    return localLayoutParams;
  }
  
  public RelativeLayout.LayoutParams createRightIconLayoutParams()
  {
    RelativeLayout.LayoutParams localLayoutParams = super.createRightIconLayoutParams();
    localLayoutParams.width = VERIFY_WIDTH;
    localLayoutParams.height = VERIFY_HEIGHT;
    localLayoutParams.bottomMargin = (CONTENT_DISTANCE_SEPERATOR * 2);
    return localLayoutParams;
  }
  
  public FrameLayout getLoadingBox()
  {
    return this.mLoadingBox;
  }
  
  public void onCreateContent(QMUIDialog paramQMUIDialog, ViewGroup paramViewGroup)
  {
    super.onCreateContent(paramQMUIDialog, paramViewGroup);
    paramQMUIDialog = new FrameLayout.LayoutParams(-2, -2);
    paramQMUIDialog.gravity = 17;
    this.mLoadingBox.addView(this.mLoading, paramQMUIDialog);
    paramQMUIDialog = createRightIconLayoutParams();
    this.mMainLayout.addView(this.mLoadingBox, paramQMUIDialog);
  }
  
  public void showLoading(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.mLoadingBox.setVisibility(0);
      return;
    }
    this.mLoadingBox.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.dialog.VerifyInputDialogBuilder
 * JD-Core Version:    0.7.0.1
 */