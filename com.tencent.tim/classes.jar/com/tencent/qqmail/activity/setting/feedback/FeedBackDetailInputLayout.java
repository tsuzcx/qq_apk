package com.tencent.qqmail.activity.setting.feedback;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.widget.EditText;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.qmui.helper.QMUIDisplayHelper;
import com.tencent.qqmail.qmui.layout.QMUIFloatLayout;
import com.tencent.qqmail.trd.guava.Lists;
import com.tencent.qqmail.utilities.ui.PressableImageView;
import java.util.List;

class FeedBackDetailInputLayout
  extends LinearLayout
{
  private static final int IMAGE_COUNT_ONE_LINE = 4;
  private static final int IMAGE_MAX_COUNT_DEFAULT = 8;
  private static final String TAG = "DetailInputLayout";
  private boolean hasDescInputRequestFocus = false;
  private LinearLayout mAddImageLayout;
  private TextView mAddImageTipView;
  private Context mContext;
  private EditText mDescInput;
  private QMUIFloatLayout mFloatLayout;
  private int mImageItemSize;
  private int mImageItemSpaceHorizontal;
  private int mImageItemSpaceVertical;
  private FeedBackDetailInputListener mListener;
  private int mMaxImageCount = 8;
  private List<String> mPaths = Lists.newArrayList();
  
  public FeedBackDetailInputLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext, getResources().getString(2131719834));
  }
  
  public FeedBackDetailInputLayout(Context paramContext, String paramString)
  {
    super(paramContext);
    init(paramContext, paramString);
  }
  
  private void init(Context paramContext, String paramString)
  {
    this.mContext = paramContext;
    setOrientation(1);
    setBackgroundResource(2130845599);
    setPadding(getResources().getDimensionPixelSize(2131297032), getResources().getDimensionPixelSize(2131299381), getResources().getDimensionPixelSize(2131297032), getResources().getDimensionPixelSize(2131299381));
    this.mImageItemSize = getResources().getDimensionPixelSize(2131299379);
    this.mImageItemSpaceHorizontal = ((QMUIDisplayHelper.getScreenWidth(this.mContext) - getPaddingLeft() - getPaddingRight() - this.mImageItemSize * 4) / 3);
    this.mImageItemSpaceVertical = getResources().getDimensionPixelSize(2131299380);
    initInputView(paramString);
    initFlowLayout();
  }
  
  private void initAddImageAddTip()
  {
    this.mAddImageLayout = new LinearLayout(this.mContext);
    this.mAddImageLayout.setOrientation(0);
    this.mAddImageLayout.setGravity(16);
    PressableImageView localPressableImageView = new PressableImageView(this.mContext);
    localPressableImageView.setImageResource(2130840920);
    localPressableImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localPressableImageView.setOnClickListener(new FeedBackDetailInputLayout.2(this));
    this.mAddImageLayout.addView(localPressableImageView, new LinearLayout.LayoutParams(this.mImageItemSize, this.mImageItemSize));
    this.mAddImageTipView = new TextView(this.mContext);
    this.mAddImageTipView.setPadding(QMUIDisplayHelper.dp2px(this.mContext, 14), 0, 0, 0);
    this.mAddImageTipView.setTextColor(ContextCompat.getColor(this.mContext, 2131166574));
    this.mAddImageTipView.setTextSize(0, QMUIDisplayHelper.dp2px(this.mContext, 16));
    this.mAddImageTipView.setText(2131719832);
    this.mAddImageLayout.addView(this.mAddImageTipView, new LinearLayout.LayoutParams(-2, -2));
  }
  
  private void initFlowLayout()
  {
    this.mFloatLayout = new QMUIFloatLayout(this.mContext);
    this.mFloatLayout.setChildVerticalSpacing(this.mImageItemSpaceVertical);
    this.mFloatLayout.setChildHorizontalSpacing(this.mImageItemSpaceHorizontal);
    initAddImageAddTip();
    this.mFloatLayout.addView(this.mAddImageLayout);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
    localLayoutParams.topMargin = getResources().getDimensionPixelSize(2131299378);
    addView(this.mFloatLayout, localLayoutParams);
  }
  
  private void initInputView(String paramString)
  {
    this.mDescInput = new EditText(this.mContext);
    this.mDescInput.setHintTextColor(ContextCompat.getColor(this.mContext, 2131166574));
    this.mDescInput.setTextColor(ContextCompat.getColor(this.mContext, 2131166572));
    this.mDescInput.setTextSize(0, QMUIDisplayHelper.dp2px(this.mContext, 16));
    this.mDescInput.setFocusable(true);
    this.mDescInput.setFocusableInTouchMode(true);
    this.mDescInput.setLineSpacing(QMUIDisplayHelper.dp2px(this.mContext, 3), 1.0F);
    this.mDescInput.setMinLines(2);
    this.mDescInput.setGravity(48);
    this.mDescInput.setBackgroundResource(0);
    this.mDescInput.setPadding(0, 0, 0, 0);
    this.mDescInput.setHint(paramString);
    this.mDescInput.setOnFocusChangeListener(new FeedBackDetailInputLayout.1(this));
    addView(this.mDescInput, new LinearLayout.LayoutParams(-1, -2));
  }
  
  @NonNull
  private PressableImageView newPressableImageView(AttachInfo paramAttachInfo)
  {
    this.mPaths.add(paramAttachInfo.getAbsAttachPath());
    PressableImageView localPressableImageView = new PressableImageView(this.mContext);
    localPressableImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
    localPressableImageView.setPadding(1, 1, 1, 1);
    localPressableImageView.setBackgroundResource(2131166583);
    localPressableImageView.setOnClickListener(new FeedBackDetailInputLayout.3(this, paramAttachInfo, localPressableImageView));
    this.mFloatLayout.addView(localPressableImageView, this.mFloatLayout.getChildCount() - 1, new ViewGroup.LayoutParams(this.mImageItemSize, this.mImageItemSize));
    if (!canAddImage()) {
      this.mAddImageLayout.setVisibility(8);
    }
    this.mAddImageTipView.setVisibility(8);
    return localPressableImageView;
  }
  
  public void addImage(int paramInt, AttachInfo paramAttachInfo)
  {
    if (!canAddImage()) {
      return;
    }
    newPressableImageView(paramAttachInfo).setImageResource(paramInt);
  }
  
  public void addImage(Bitmap paramBitmap, AttachInfo paramAttachInfo)
  {
    if ((paramBitmap == null) || (!canAddImage())) {
      return;
    }
    newPressableImageView(paramAttachInfo).setImageBitmap(paramBitmap);
  }
  
  public boolean canAddImage()
  {
    return this.mFloatLayout.getChildCount() <= this.mMaxImageCount;
  }
  
  public int getImageCountAdded()
  {
    return this.mFloatLayout.getChildCount() - 1;
  }
  
  public int getImagesCountCanAdd()
  {
    return this.mMaxImageCount - this.mFloatLayout.getChildCount() + 1;
  }
  
  public int getIndexOfInfo(AttachInfo paramAttachInfo)
  {
    return this.mPaths.indexOf(paramAttachInfo.getAbsAttachPath());
  }
  
  public String getInputContent()
  {
    if (this.mDescInput == null) {
      return "";
    }
    return this.mDescInput.getText().toString();
  }
  
  public int getMaxImageCount()
  {
    return this.mMaxImageCount;
  }
  
  protected boolean isCover()
  {
    Rect localRect = new Rect();
    return (!getGlobalVisibleRect(localRect)) || (localRect.width() < getWidth()) || (localRect.height() < getHeight());
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    showInputCursor();
  }
  
  public void setListener(FeedBackDetailInputListener paramFeedBackDetailInputListener)
  {
    this.mListener = paramFeedBackDetailInputListener;
  }
  
  public void setMaxImageCount(int paramInt)
  {
    this.mMaxImageCount = paramInt;
  }
  
  public void showInputCursor()
  {
    if ((!this.hasDescInputRequestFocus) && (getVisibility() == 0) && (!isCover()))
    {
      this.mDescInput.requestFocus();
      this.hasDescInputRequestFocus = true;
    }
  }
  
  public static abstract interface FeedBackDetailInputListener
  {
    public abstract void onClickAddImageBtn();
    
    public abstract void onDelete(AttachInfo paramAttachInfo);
    
    public abstract void onInputFoucChange(boolean paramBoolean);
    
    public abstract void onPreviewImage(AttachInfo paramAttachInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.FeedBackDetailInputLayout
 * JD-Core Version:    0.7.0.1
 */