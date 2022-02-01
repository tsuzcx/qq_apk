package com.tencent.qqmail.view;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.utilities.ui.QMImageButton;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class QMQuickReplyView
  extends FrameLayout
{
  public static final int ID_CONTAINER = 11;
  public static final int ID_FULL_MODE_BTN = 15;
  public static final int ID_RECEIVER = 13;
  public static final int ID_RECEIVER_CAPTION = 12;
  public static final int ID_REPLY_TEXT = 14;
  private RelativeLayout containerLayout;
  private EditTextInWebView editText;
  private final int minHeight;
  
  public QMQuickReplyView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.minHeight = (paramInt - QMUIKit.dpToPx(66));
    setBackgroundResource(2130850397);
    setPadding(QMUIKit.dpToPx(10), QMUIKit.dpToPx(15), QMUIKit.dpToPx(10), QMUIKit.dpToPx(15));
    initViews(paramContext);
  }
  
  private void initContainer(Context paramContext)
  {
    this.containerLayout = new RelativeLayout(paramContext);
    this.containerLayout.setId(11);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    this.containerLayout.setBackgroundResource(2130847899);
    this.containerLayout.setPadding(0, 0, 0, 0);
    addView(this.containerLayout, paramContext);
  }
  
  private void initEditText(Context paramContext)
  {
    this.editText = new EditTextInWebView(paramContext);
    this.editText.setId(14);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = QMUIKit.dpToPx(32);
    this.editText.setPadding(QMUIKit.dpToPx(9), QMUIKit.dpToPx(4), QMUIKit.dpToPx(9), QMUIKit.dpToPx(4));
    this.editText.setBackgroundResource(0);
    this.editText.setGravity(48);
    this.editText.setHintTextColor(paramContext.getResources().getColor(2131167534));
    this.editText.setTextColor(paramContext.getResources().getColor(2131165381));
    refreshMinHeight();
    this.containerLayout.addView(this.editText, localLayoutParams);
  }
  
  private void initFullModeButton(Context paramContext)
  {
    paramContext = new QMImageButton(paramContext);
    paramContext.setContentDescription(getResources().getString(2131720847));
    paramContext.setId(15);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    localLayoutParams.bottomMargin = (-QMUIKit.dpToPx(4));
    localLayoutParams.addRule(8, 14);
    localLayoutParams.addRule(7, 14);
    int i = QMUIKit.dpToPx(10);
    paramContext.setPadding(i, i, i, i);
    paramContext.setImageResource(2130840925);
    this.containerLayout.addView(paramContext, localLayoutParams);
  }
  
  private void initHeader(Context paramContext)
  {
    int i = QMUIKit.dpToPx(32);
    TextView localTextView = new TextView(paramContext);
    localTextView.setId(12);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, i);
    localLayoutParams.leftMargin = QMUIKit.dpToPx(9);
    localTextView.setGravity(16);
    localTextView.setTextColor(-10066330);
    localTextView.setTextSize(2, 14.0F);
    localTextView.setText(2131691904);
    this.containerLayout.addView(localTextView, localLayoutParams);
    paramContext = new TextView(paramContext);
    paramContext.setId(13);
    localLayoutParams = new RelativeLayout.LayoutParams(-2, i);
    localLayoutParams.setMargins(QMUIKit.dpToPx(2), 0, QMUIKit.dpToPx(9), 0);
    localLayoutParams.addRule(1, 12);
    paramContext.setGravity(localTextView.getGravity());
    paramContext.setGravity(localTextView.getGravity());
    paramContext.setTextColor(localTextView.getTextColors());
    paramContext.setTextSize(2, 14.0F);
    paramContext.setSingleLine(true);
    paramContext.setEllipsize(TextUtils.TruncateAt.END);
    this.containerLayout.addView(paramContext, localLayoutParams);
  }
  
  public void destroy()
  {
    this.containerLayout.removeAllViews();
    this.containerLayout = null;
    this.editText = null;
  }
  
  public int getMinHeight()
  {
    return this.minHeight + QMUIKit.dpToPx(66);
  }
  
  public void initViews(Context paramContext)
  {
    initContainer(paramContext);
    initHeader(paramContext);
    initEditText(paramContext);
    initFullModeButton(paramContext);
  }
  
  public void refreshMinHeight()
  {
    int i = this.editText.getLineHeight();
    int j = this.editText.getLineCount();
    int k = this.editText.getPaddingTop();
    int m = this.editText.getPaddingBottom();
    this.editText.setMinHeight(Math.max(i * (j + 1) + k + m, this.minHeight));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.QMQuickReplyView
 * JD-Core Version:    0.7.0.1
 */