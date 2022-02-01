package com.tencent.qqmail.popularize.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.qqmail.maillist.view.ViewConfig;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.utilities.ui.QMAvatar;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMListItemViewer;
import java.lang.ref.WeakReference;

public class PopularizeMailListItemView
  extends View
  implements QMListItemViewer
{
  private static WeakReference<char[]> mBigCharCache = new WeakReference(null);
  private int abstractsBaseline;
  private int avatarMarginRight;
  private int avatarMarginTop;
  private int avatarSize;
  private Drawable backgroundDrawable;
  private int colorBlack;
  private int colorGray;
  private String commercialAdTag;
  private int commercialAdTagBgColor;
  private RectF commercialAdTagBgRectF;
  private int commercialAdTagMarginRight;
  private int commercialAdTagPaddingHorizontal;
  private Paint commercialAdTagPaint;
  private int commercialAdTagRadius;
  private int commercialAdTagTextSize;
  private int contentFirstLineBaseline;
  private int contentSecondLineBaseline;
  private String ellipsize;
  private int ellipsizeWidthForPaintAbstract;
  private int ellipsizeWidthForPaintContent;
  private int ellipsizeWidthForPaintSubject;
  private boolean isChecked;
  private boolean isInEditMode;
  private int itemHeight;
  private int limitLeft;
  private int limitRight;
  private final Runnable mCheckForChecked = new PopularizeMailListItemView.1(this);
  private Context mContext;
  private int[] padding;
  private Paint paintAbstracts;
  private Paint paintContent;
  private Paint paintDivider;
  private Paint paintMask;
  private Paint paintSubject;
  private Popularize popularize;
  private Drawable popularizeMarkIcon;
  private boolean showAvatar;
  private int subjectBaseline;
  private ViewConfig viewConfig;
  private int viewSpace;
  
  public PopularizeMailListItemView(Context paramContext)
  {
    super(paramContext);
    this.mContext = paramContext;
    this.viewConfig = new ViewConfig(getResources());
    this.colorBlack = getResources().getColor(2131167519);
    this.colorGray = getResources().getColor(2131167531);
    this.backgroundDrawable = getResources().getDrawable(2130845612);
    this.popularizeMarkIcon = getResources().getDrawable(2130842389);
    this.commercialAdTag = this.mContext.getResources().getString(2131718587);
    this.commercialAdTagBgColor = -29696;
    this.commercialAdTagTextSize = QMUIKit.dpToPx(12);
    this.commercialAdTagPaddingHorizontal = QMUIKit.dpToPx(7);
    this.commercialAdTagMarginRight = QMUIKit.dpToPx(6);
    this.commercialAdTagRadius = QMUIKit.dpToPx(2);
    this.commercialAdTagPaint = new Paint();
    this.commercialAdTagPaint.setTextSize(this.commercialAdTagTextSize);
    this.commercialAdTagBgRectF = new RectF();
    this.avatarSize = getResources().getDimensionPixelSize(2131296637);
    this.avatarMarginTop = getResources().getDimensionPixelSize(2131297682);
    this.avatarMarginRight = getResources().getDimensionPixelSize(2131297667);
    this.paintSubject = new Paint();
    this.paintSubject.setAntiAlias(true);
    this.paintSubject.setTextSize(getResources().getDimensionPixelSize(2131297623));
    this.paintSubject.setTypeface(getSysTypeFace(this.mContext));
    this.paintSubject.setColor(this.colorBlack);
    this.paintAbstracts = new Paint();
    this.paintAbstracts.setAntiAlias(true);
    this.paintAbstracts.setTextSize(getResources().getDimensionPixelSize(2131297620));
    this.paintAbstracts.setColor(this.colorBlack);
    this.paintAbstracts.setFakeBoldText(false);
    this.paintContent = new TextPaint();
    this.paintContent.setAntiAlias(true);
    this.paintContent.setTextSize(getResources().getDimensionPixelSize(2131297620));
    this.paintContent.setColor(this.colorGray);
    this.paintContent.setFakeBoldText(false);
    this.paintDivider = new Paint();
    this.paintDivider.setStrokeWidth(getContext().getResources().getDimension(2131297594));
    this.paintDivider.setColor(getContext().getResources().getColor(2131165952));
    this.paintMask = new Paint();
    this.paintMask.setColor(getContext().getResources().getColor(2131167654));
    this.paintMask.setAlpha(128);
    this.padding = new int[] { getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() };
    this.itemHeight = getResources().getDimensionPixelSize(2131297677);
    this.limitLeft = (getResources().getDimensionPixelSize(2131297678) + this.padding[0]);
    this.limitRight = (getResources().getDimensionPixelSize(2131297032) + this.padding[2]);
    this.viewSpace = getResources().getDimensionPixelSize(2131297691);
    this.subjectBaseline = getResources().getDimensionPixelSize(2131297676);
    this.abstractsBaseline = getResources().getDimensionPixelSize(2131297683);
    this.contentFirstLineBaseline = getResources().getDimensionPixelSize(2131297656);
    this.contentSecondLineBaseline = getResources().getDimensionPixelSize(2131297657);
    this.ellipsize = getResources().getString(2131721222);
    this.ellipsizeWidthForPaintSubject = ((int)this.paintSubject.measureText(this.ellipsize));
    this.ellipsizeWidthForPaintAbstract = ((int)this.paintAbstracts.measureText(this.ellipsize));
    this.ellipsizeWidthForPaintContent = ((int)this.paintContent.measureText(this.ellipsize));
    setLayoutParams(new LinearLayout.LayoutParams(-1, this.itemHeight));
    QMUIHelper.setBackground(this, this.backgroundDrawable);
  }
  
  private Typeface getSysTypeFace(Context paramContext)
  {
    return ((TextView)LayoutInflater.from(paramContext).inflate(2131559425, null).findViewById(2131371075)).getTypeface();
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    QMUIHelper.drawDivider(false, true, paramCanvas, this.paintDivider, this.limitLeft, 0);
  }
  
  public boolean isChecked()
  {
    return isSelected();
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    super.setPressed(false);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int k = getWidth();
    int i;
    label34:
    Object localObject1;
    Object localObject2;
    label208:
    int j;
    label319:
    float f1;
    float f2;
    float f3;
    if (this.popularize.isCommercialConfigMark())
    {
      i = 0;
      if (!this.popularize.isCommercialConfigMark()) {
        break label1111;
      }
      paramCanvas.save();
      paramCanvas.translate(this.limitLeft, this.subjectBaseline);
      if ((this.popularize.getType() == 9) && (!this.popularize.isRead()))
      {
        paramCanvas.save();
        localObject1 = this.viewConfig.getRectUnreadIcon();
        if (!this.showAvatar) {
          paramCanvas.translate(-(this.limitLeft + ((Rect)localObject1).width()) / 2, 0.0F);
        }
        localObject2 = this.viewConfig.getUnreadIcon();
        ((Drawable)localObject2).setBounds((Rect)localObject1);
        paramCanvas.translate(0.0F, -(((Rect)localObject1).height() + getResources().getDimensionPixelSize(2131297665)));
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.restore();
        if (this.showAvatar) {
          paramCanvas.translate(((Rect)localObject1).width() + this.viewSpace, 0.0F);
        }
      }
      if (this.popularize.getType() != 9) {
        break label1122;
      }
      localObject1 = this.popularize.getCommercialFromNick();
      if (localObject1 != null)
      {
        j = k - this.limitLeft - this.limitRight - this.ellipsizeWidthForPaintSubject - this.viewSpace - i;
        int m = this.paintSubject.breakText((String)localObject1, true, j, null);
        if (m >= ((String)localObject1).length()) {
          break label1134;
        }
        j += (int)(this.ellipsizeWidthForPaintSubject / 1.5D);
        paramCanvas.drawText(((String)localObject1).substring(0, m) + this.ellipsize, 0.0F, 0.0F, this.paintSubject);
        paramCanvas.translate(j + this.viewSpace, 0.0F);
      }
      paramCanvas.restore();
      if (!this.popularize.isCommercialConfigMark()) {
        break label1161;
      }
      this.commercialAdTagPaint.setColor(this.commercialAdTagBgColor);
      this.commercialAdTagBgRectF.left = (this.limitLeft + QMUIKit.dpToPx(2));
      this.commercialAdTagBgRectF.top = (this.abstractsBaseline + this.paintAbstracts.getFontMetrics().ascent);
      this.commercialAdTagBgRectF.bottom = (this.abstractsBaseline + this.paintAbstracts.getFontMetrics().descent);
      this.commercialAdTagBgRectF.right = (this.commercialAdTagBgRectF.left + this.commercialAdTagPaddingHorizontal * 2 + this.commercialAdTagPaint.measureText(this.commercialAdTag));
      paramCanvas.drawRoundRect(this.commercialAdTagBgRectF, this.commercialAdTagRadius, this.commercialAdTagRadius, this.commercialAdTagPaint);
      this.commercialAdTagPaint.setColor(-1);
      f1 = this.commercialAdTagBgRectF.top;
      f2 = (this.commercialAdTagBgRectF.bottom - this.commercialAdTagBgRectF.top) / 2.0F;
      f3 = (this.commercialAdTagPaint.getFontMetrics().descent + this.commercialAdTagPaint.getFontMetrics().ascent) / 2.0F;
      paramCanvas.drawText(this.commercialAdTag, this.commercialAdTagBgRectF.left + this.commercialAdTagPaddingHorizontal, f1 + f2 - f3, this.commercialAdTagPaint);
      label566:
      if (this.popularize.getType() != 9) {
        break label1387;
      }
      localObject1 = this.popularize.getSubject();
      label587:
      if (localObject1 != null)
      {
        j = k - this.limitRight - this.limitLeft - this.ellipsizeWidthForPaintAbstract - i;
        i = j;
        if (this.popularize.isCommercialConfigMark()) {
          i = (int)(j - (this.commercialAdTagBgRectF.right - this.commercialAdTagBgRectF.left));
        }
        i = this.paintAbstracts.breakText((String)localObject1, true, i, null);
        if (!this.popularize.isCommercialConfigMark()) {
          break label1399;
        }
        f1 = this.commercialAdTagBgRectF.right + this.commercialAdTagMarginRight;
        if (i >= ((String)localObject1).length()) {
          break label1408;
        }
        paramCanvas.drawText(((String)localObject1).substring(0, i) + this.ellipsize, f1, this.abstractsBaseline, this.paintAbstracts);
      }
      label690:
      label742:
      if (this.popularize.getType() != 9) {
        break label1427;
      }
      localObject1 = this.popularize.getAbstracts();
      label763:
      if (localObject1 != null)
      {
        i = k - this.limitRight - this.limitLeft - this.ellipsizeWidthForPaintContent;
        localObject2 = (char[])mBigCharCache.get();
        if (localObject2 != null) {
          break label1495;
        }
        localObject2 = new char[k * 2];
        mBigCharCache = new WeakReference(localObject2);
      }
    }
    label1111:
    label1495:
    for (;;)
    {
      j = Math.min(localObject2.length, Math.min(((String)localObject1).length(), i + 5));
      ((String)localObject1).getChars(0, j, (char[])localObject2, 0);
      k = this.paintContent.breakText((char[])localObject2, 0, Math.min(j, i), i, null);
      if (k < j)
      {
        paramCanvas.drawText((char[])localObject2, 0, k, this.limitLeft, this.contentFirstLineBaseline, this.paintContent);
        i = this.paintContent.breakText((char[])localObject2, k, j, i, null);
        if (i < j - k)
        {
          this.ellipsize.getChars(0, this.ellipsize.length(), (char[])localObject2, k + i);
          paramCanvas.drawText((char[])localObject2, k, i + this.ellipsize.length(), this.limitLeft, this.contentSecondLineBaseline, this.paintContent);
        }
      }
      for (;;)
      {
        localObject1 = this.popularize.getImageUrl();
        if ((this.showAvatar) && (localObject1 != null))
        {
          localObject1 = PopularizeThumbManager.sharedInstance().getPopularizeThumb((String)localObject1);
          localObject1 = new QMAvatar().setAvatar((Bitmap)localObject1, this.popularize.getCommercialFromNick());
          if (localObject1 != null) {
            paramCanvas.drawBitmap((Bitmap)localObject1, (this.limitLeft - this.avatarSize) / 2, this.avatarMarginTop, null);
          }
        }
        if (!isEnabled()) {
          paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.paintMask);
        }
        return;
        i = this.popularizeMarkIcon.getIntrinsicWidth();
        break;
        this.popularizeMarkIcon.getIntrinsicHeight();
        break label34;
        label1122:
        localObject1 = this.popularize.getSubject();
        break label208;
        label1134:
        j = (int)this.paintSubject.measureText((String)localObject1);
        paramCanvas.drawText((String)localObject1, 0.0F, 0.0F, this.paintSubject);
        break label319;
        this.commercialAdTagPaint.setColor(this.commercialAdTagBgColor);
        this.commercialAdTagBgRectF.left = (getWidth() - this.limitRight - this.commercialAdTagPaint.measureText(this.commercialAdTag) - this.commercialAdTagPaddingHorizontal * 2);
        this.commercialAdTagBgRectF.right = (getWidth() - this.limitRight);
        this.commercialAdTagBgRectF.top = (this.subjectBaseline + this.paintSubject.getFontMetrics().ascent);
        this.commercialAdTagBgRectF.bottom = (this.subjectBaseline + this.paintSubject.getFontMetrics().descent);
        paramCanvas.drawRoundRect(this.commercialAdTagBgRectF, this.commercialAdTagRadius, this.commercialAdTagRadius, this.commercialAdTagPaint);
        this.commercialAdTagPaint.setColor(-1);
        f1 = this.commercialAdTagBgRectF.top;
        f2 = (this.commercialAdTagBgRectF.bottom - this.commercialAdTagBgRectF.top) / 2.0F;
        f3 = (this.commercialAdTagPaint.getFontMetrics().descent + this.commercialAdTagPaint.getFontMetrics().ascent) / 2.0F;
        paramCanvas.drawText(this.commercialAdTag, this.commercialAdTagBgRectF.left + this.commercialAdTagPaddingHorizontal, f1 + f2 - f3, this.commercialAdTagPaint);
        break label566;
        label1387:
        localObject1 = this.popularize.getAbstracts();
        break label587;
        label1399:
        f1 = this.limitLeft;
        break label690;
        paramCanvas.drawText((String)localObject1, f1, this.abstractsBaseline, this.paintAbstracts);
        break label742;
        localObject1 = this.popularize.getContent();
        break label763;
        paramCanvas.drawText((char[])localObject2, k, j - k, this.limitLeft, this.contentSecondLineBaseline, this.paintContent);
        continue;
        paramCanvas.drawText((char[])localObject2, 0, j, this.limitLeft, this.contentFirstLineBaseline, this.paintContent);
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      super.setPressed(false);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.isChecked = paramBoolean;
    setSelected(paramBoolean);
  }
  
  public void setItemToEditMode()
  {
    this.isInEditMode = true;
  }
  
  public void setItemToNormalMode()
  {
    this.isInEditMode = false;
  }
  
  public void setPopularize(Popularize paramPopularize)
  {
    this.popularize = paramPopularize;
  }
  
  public void setPressed(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      super.setPressed(paramBoolean);
      return;
    }
    Runnable localRunnable = this.mCheckForChecked;
    long l;
    if (this.isChecked) {
      l = 0L;
    }
    for (;;)
    {
      postDelayed(localRunnable, l);
      return;
      if (this.isInEditMode) {
        l = ViewConfiguration.getDoubleTapTimeout();
      } else {
        l = ViewConfiguration.getLongPressTimeout();
      }
    }
  }
  
  public void setShowAvatar(boolean paramBoolean)
  {
    this.showAvatar = paramBoolean;
    if (this.showAvatar)
    {
      this.limitLeft = (getResources().getDimensionPixelSize(2131297032) + this.padding[0]);
      this.limitLeft += this.avatarSize + this.avatarMarginRight;
    }
  }
  
  public void toggle() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.popularize.view.PopularizeMailListItemView
 * JD-Core Version:    0.7.0.1
 */