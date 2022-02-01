package com.tencent.qqmail.maillist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.AbsListView.LayoutParams;
import androidx.core.app.ActivityCompat;
import androidx.core.view.ViewCompat;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMListItemViewer;
import java.lang.ref.WeakReference;
import java.util.HashSet;

public class MailListItemView
  extends View
  implements QMListItemViewer
{
  private static final int[] CHECKED_STATE_SET = { 16842912 };
  public static final int STATE_CLOCK_SEND = 2;
  public static final int STATE_NONE = 0;
  public static final int STATE_UNREAD = 1;
  public static final int STATUS_FORWARD = 2;
  public static final int STATUS_NONE = 0;
  public static final int STATUS_REPLY = 1;
  public static final int STATUS_SENDING = 3;
  public static final int STATUS_SEND_CANCEL = 5;
  public static final int STATUS_SEND_CANCELING = 6;
  public static final int STATUS_SEND_ERROR = 4;
  public static final int VIEW_HEIGHT = QMApplicationContext.sharedInstance().getResources().getDimensionPixelSize(2131297677);
  private static final String[] highLightKeywords = new String[10];
  private static int highLightSearchType;
  private static WeakReference<char[]> mBigCharCache = new WeakReference(null);
  private int abstractTextFirstLineBaseline;
  private int abstractTextSecondLineBaseline;
  private int adSize;
  private int cancelIconMarginRight = 0;
  private int colorBlack;
  private int colorBlue;
  private int colorGray;
  private int colorGray1;
  private int colorRed;
  private int colorTagBackground;
  private int colorWhite;
  private String commercialAdTag;
  private int commercialAdTagBgColor;
  private RectF commercialAdTagBgRectF;
  private int commercialAdTagMarginLeft;
  private int commercialAdTagPaddingHorizontal;
  private Paint commercialAdTagPaint;
  private int commercialAdTagRadius;
  private int commercialAdTagTextSize;
  private float commercialAdTagWidth;
  private int conversationNumberSize;
  private int dateTimeBaseline;
  private Drawable drawableStatusIcon;
  private String ellipsize;
  private int ellipsizeWidthForPaintAbstractText;
  private int ellipsizeWidthForPaintFromAddress;
  private int ellipsizeWidthForPaintSubjectTitle;
  private int ellipsizeWidthForPaintTagName;
  private int fromAddressBaseline;
  private int iconAttachMarginTop;
  private boolean isChecked;
  private boolean isInEditMode;
  private boolean isTopped;
  private MailListItemData itemData;
  private int itemHeight;
  private int limitLeft;
  private int limitRight;
  private final Runnable mCheckForChecked = new MailListItemView.1(this);
  private int mProgressBgColor;
  private Paint mProgressBgPaint = new Paint();
  private Rect mProgressBgRect;
  private Drawable mProgressCancelDrawable;
  private int mProgressCancelLoadingIndex = 0;
  private Rect mProgressCancelRect;
  private int mProgressColor;
  private Paint mProgressPaint = new Paint();
  private Rect mProgressRect;
  private RectF nativeAdProBg;
  private int nativeAdsProPaddingHorizontal;
  private int[] padding;
  private Paint paintAbstractText;
  private Paint paintAdText;
  private Paint paintConversationText;
  private Paint paintDateTime;
  private Paint paintDivider;
  private Paint paintFromAddress;
  private Paint paintNativeAds;
  private Paint paintSubjectTitle;
  private Paint paintTagColor;
  private Paint paintTagName1;
  private Paint paintTagName2;
  private Paint paintUnreadNumber;
  private int progressCancelLeftSpace;
  private int progressCancelMarginTop;
  private int progressRectHeight;
  private Rect rectAdBackground;
  private Rect rectConversationBackground;
  private RectF rectTagBackground;
  private boolean showAvatar;
  private int subjectTitleBaseline;
  private ViewConfig viewConfig;
  private int viewSpace;
  
  public MailListItemView(Context paramContext)
  {
    super(paramContext);
    ViewCompat.setImportantForAccessibility(this, 1);
    this.viewConfig = new ViewConfig(getResources());
    this.itemData = new MailListItemData();
    this.itemData.reset();
    setLayoutParams(new AbsListView.LayoutParams(-1, VIEW_HEIGHT));
    this.padding = new int[] { getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() };
    this.itemHeight = VIEW_HEIGHT;
    this.limitLeft = (getResources().getDimensionPixelSize(2131297678) + this.padding[0]);
    this.limitRight = (getResources().getDimensionPixelSize(2131297032) + this.padding[2]);
    this.viewSpace = getResources().getDimensionPixelSize(2131297691);
    this.dateTimeBaseline = getResources().getDimensionPixelSize(2131297675);
    this.fromAddressBaseline = getResources().getDimensionPixelSize(2131297676);
    this.subjectTitleBaseline = getResources().getDimensionPixelSize(2131297683);
    this.abstractTextFirstLineBaseline = getResources().getDimensionPixelSize(2131297656);
    this.progressCancelMarginTop = getResources().getDimensionPixelSize(2131297680);
    this.progressCancelLeftSpace = getResources().getDimensionPixelSize(2131297679);
    this.progressRectHeight = getResources().getDimensionPixelSize(2131297681);
    this.abstractTextSecondLineBaseline = getResources().getDimensionPixelSize(2131297657);
    this.iconAttachMarginTop = getResources().getDimensionPixelSize(2131297665);
    this.conversationNumberSize = this.viewConfig.getConversationNumberSize();
    this.adSize = this.viewConfig.getAdSize();
    this.colorBlack = this.viewConfig.getColorBlack();
    this.colorWhite = this.viewConfig.getColorWhite();
    this.colorGray = this.viewConfig.getColorGray();
    this.colorGray1 = this.viewConfig.getColorGray1();
    this.colorRed = this.viewConfig.getColorRed();
    this.colorTagBackground = this.viewConfig.getColorTagBackground();
    this.colorBlue = ActivityCompat.getColor(getContext(), 2131165952);
    this.paintFromAddress = new Paint();
    this.paintFromAddress.setAntiAlias(true);
    this.paintFromAddress.setTypeface(this.viewConfig.getSystemTypeface(paramContext));
    this.paintFromAddress.setTextSize(getResources().getDimensionPixelSize(2131297623));
    this.paintFromAddress.setColor(this.colorBlack);
    this.paintSubjectTitle = new Paint();
    this.paintSubjectTitle.setAntiAlias(true);
    this.paintSubjectTitle.setTextSize(getResources().getDimensionPixelSize(2131297620));
    this.paintSubjectTitle.setColor(this.colorBlack);
    this.paintSubjectTitle.setFakeBoldText(false);
    this.paintUnreadNumber = new Paint();
    this.paintUnreadNumber.setAntiAlias(true);
    this.paintUnreadNumber.setTextSize(QMUIKit.dpToPx(12));
    this.paintUnreadNumber.setStyle(Paint.Style.FILL);
    this.paintUnreadNumber.setColor(-12739090);
    this.paintAbstractText = new TextPaint();
    this.paintAbstractText.setAntiAlias(true);
    this.paintAbstractText.setTextSize(getResources().getDimensionPixelSize(2131297620));
    this.paintAbstractText.setColor(this.colorGray);
    this.paintAbstractText.setFakeBoldText(false);
    this.commercialAdTag = paramContext.getResources().getString(2131718587);
    this.commercialAdTagBgColor = -29696;
    this.commercialAdTagTextSize = QMUIKit.dpToPx(10);
    this.commercialAdTagPaddingHorizontal = QMUIKit.dpToPx(4);
    this.commercialAdTagMarginLeft = QMUIKit.dpToPx(6);
    this.commercialAdTagRadius = QMUIKit.dpToPx(2);
    this.commercialAdTagPaint = new Paint();
    this.commercialAdTagPaint.setTextSize(this.commercialAdTagTextSize);
    this.commercialAdTagBgRectF = new RectF();
    this.commercialAdTagWidth = (this.commercialAdTagPaddingHorizontal * 2 + this.commercialAdTagPaint.measureText(this.commercialAdTag));
    this.paintNativeAds = new Paint();
    this.paintNativeAds.setTextSize(QMUIKit.dpToPx(12));
    this.paintNativeAds.setColor(this.commercialAdTagBgColor);
    this.nativeAdsProPaddingHorizontal = QMUIKit.dpToPx(7);
    this.nativeAdProBg = new RectF();
    this.paintDateTime = new Paint(this.paintAbstractText);
    this.paintAbstractText.setColor(this.colorGray1);
    this.paintDateTime.setTextSize(getResources().getDimensionPixelSize(2131297622));
    this.paintTagName1 = new Paint();
    this.paintTagName1.setAntiAlias(true);
    this.paintTagName1.setTextSize(getResources().getDimensionPixelSize(2131297622));
    this.paintTagName1.setColor(this.colorWhite);
    this.paintTagName2 = new Paint(this.paintTagName1);
    this.mProgressColor = this.viewConfig.getColorProgress();
    this.mProgressBgColor = this.viewConfig.getColorProgressBackground();
    this.mProgressCancelDrawable = this.viewConfig.getProgressCancelIcon();
    this.mProgressCancelRect = this.viewConfig.getRectProgressCancelIcon();
    this.mProgressPaint.setAntiAlias(true);
    this.mProgressPaint.setColor(this.mProgressColor);
    this.mProgressPaint.setStyle(Paint.Style.FILL);
    this.mProgressBgPaint.setStyle(Paint.Style.FILL);
    this.mProgressBgPaint.setAntiAlias(true);
    this.mProgressBgPaint.setColor(this.mProgressBgColor);
    this.mProgressBgRect = new Rect();
    this.mProgressBgRect.top = (this.progressCancelMarginTop + this.mProgressCancelRect.height() / 2 - this.progressRectHeight / 2);
    this.mProgressBgRect.bottom = (this.mProgressBgRect.top + this.progressRectHeight);
    this.mProgressRect = new Rect();
    this.mProgressRect.top = this.mProgressBgRect.top;
    this.mProgressRect.bottom = this.mProgressBgRect.bottom;
    this.paintTagColor = new Paint();
    this.paintTagColor.setAntiAlias(true);
    this.paintTagColor.setStyle(Paint.Style.FILL);
    this.paintConversationText = new Paint();
    this.paintConversationText.setAntiAlias(true);
    this.paintConversationText.setTextSize(getResources().getDimensionPixelSize(2131297033));
    this.paintConversationText.setColor(this.colorWhite);
    this.paintAdText = new Paint();
    this.paintAdText.setAntiAlias(true);
    this.paintAdText.setTextSize(getResources().getDimensionPixelSize(2131297664));
    this.paintAdText.setColor(this.colorWhite);
    this.paintDivider = new Paint();
    this.paintDivider.setStrokeWidth(getContext().getResources().getDimension(2131297594));
    this.paintDivider.setColor(getContext().getResources().getColor(2131165952));
    this.ellipsize = getResources().getString(2131721222);
    this.ellipsizeWidthForPaintFromAddress = ((int)this.paintFromAddress.measureText(this.ellipsize));
    this.ellipsizeWidthForPaintSubjectTitle = ((int)this.paintSubjectTitle.measureText(this.ellipsize));
    this.ellipsizeWidthForPaintAbstractText = ((int)this.paintAbstractText.measureText(this.ellipsize));
    this.ellipsizeWidthForPaintTagName = ((int)this.paintTagName1.measureText(this.ellipsize));
    this.rectConversationBackground = new Rect(0, 0, this.conversationNumberSize, this.conversationNumberSize);
    this.rectAdBackground = new Rect(0, 0, this.adSize, this.adSize);
    this.rectTagBackground = new RectF();
    setItemToNormalMode();
  }
  
  private void changePaintForState()
  {
    this.paintFromAddress.setColor(this.colorBlack);
    this.paintSubjectTitle.setColor(this.colorBlack);
    this.paintAbstractText.setColor(this.colorGray);
    this.paintDateTime.setColor(this.colorGray);
    this.paintConversationText.setColor(this.colorWhite);
    this.paintTagName1.setColor(this.itemData.tagColor1);
    this.paintTagName2.setColor(this.itemData.tagColor2);
    this.paintTagColor.setColor(this.colorTagBackground);
    this.drawableStatusIcon = getStatusIconDrawable(this.itemData.statusId);
  }
  
  private void drawSubejctWithEllipsize(String paramString, int paramInt1, int paramInt2, Canvas paramCanvas)
  {
    String str = "";
    int i = 0;
    for (;;)
    {
      if (i < paramString.length())
      {
        str = paramString.subSequence(0, i).toString();
        if ((int)this.paintSubjectTitle.measureText(str) + paramInt2 + this.ellipsizeWidthForPaintSubjectTitle <= paramInt1 - this.limitRight) {}
      }
      else
      {
        paramCanvas.drawText(str + this.ellipsize, paramInt2, this.subjectTitleBaseline, this.paintSubjectTitle);
        return;
      }
      i += 1;
    }
  }
  
  private void drawTextWithHighLightKeywords(Canvas paramCanvas, String paramString, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2, paramPaint);
    int k;
    for (;;)
    {
      int i;
      synchronized (highLightKeywords)
      {
        k = paramPaint.getColor();
        paramPaint.setColor(-11102752);
        String str1 = paramString.toLowerCase();
        i = 0;
        if (i >= highLightKeywords.length) {
          break;
        }
        if ((highLightKeywords[i] != null) && (!highLightKeywords[i].equals("")))
        {
          String str2 = highLightKeywords[i].toLowerCase();
          int j = 0;
          int m = str1.indexOf(str2, j);
          if (m >= 0)
          {
            j = str2.length() + m;
            float f = paramPaint.measureText(paramString.substring(0, m));
            paramCanvas.drawText(paramString.substring(m, j), f + paramFloat1, paramFloat2, paramPaint);
          }
        }
      }
      i += 1;
    }
    paramPaint.setColor(k);
  }
  
  private void drawTextWithHighLightKeywords(Canvas paramCanvas, char[] paramArrayOfChar, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, Paint paramPaint)
  {
    if ((paramInt1 | paramInt2 | paramInt1 + paramInt2 | paramArrayOfChar.length - paramInt1 - paramInt2) < 0) {
      throw new IndexOutOfBoundsException();
    }
    paramCanvas.drawText(paramArrayOfChar, paramInt1, paramInt2, paramFloat1, paramFloat2, paramPaint);
    for (;;)
    {
      int m;
      int i;
      int j;
      int n;
      int k;
      synchronized (highLightKeywords)
      {
        m = paramPaint.getColor();
        paramPaint.setColor(-11102752);
        paramArrayOfChar = new String(paramArrayOfChar);
        String str1 = paramArrayOfChar.toLowerCase();
        i = 0;
        if (i >= highLightKeywords.length) {
          break label310;
        }
        if ((highLightKeywords[i] == null) || (highLightKeywords[i].equals(""))) {
          break label321;
        }
        String str2 = highLightKeywords[i].toLowerCase();
        j = 0;
        n = str1.indexOf(str2, j);
        if (n < 0) {
          break label321;
        }
        k = str2.length() + n;
        j = k;
        if (k <= paramInt1) {
          continue;
        }
        j = k;
        if (n >= paramInt1 + paramInt2) {
          continue;
        }
        if (n < paramInt1)
        {
          paramCanvas.drawText(paramArrayOfChar.substring(paramInt1, k), paramFloat1, paramFloat2, paramPaint);
          j = k;
        }
      }
      float f;
      if (k > paramInt1 + paramInt2)
      {
        f = paramPaint.measureText(paramArrayOfChar.substring(paramInt1, n));
        paramCanvas.drawText(paramArrayOfChar.substring(n, paramInt1 + paramInt2), f + paramFloat1, paramFloat2, paramPaint);
        j = k;
      }
      else
      {
        f = paramPaint.measureText(paramArrayOfChar.substring(paramInt1, n));
        paramCanvas.drawText(paramArrayOfChar.substring(n, k), f + paramFloat1, paramFloat2, paramPaint);
        j = k;
        continue;
        label310:
        paramPaint.setColor(m);
        return;
        label321:
        i += 1;
      }
    }
  }
  
  public static String[] getHightLightKeywords()
  {
    synchronized (highLightKeywords)
    {
      String[] arrayOfString2 = new String[highLightKeywords.length];
      int i = 0;
      while (i < highLightKeywords.length)
      {
        arrayOfString2[i] = highLightKeywords[i];
        i += 1;
      }
      return arrayOfString2;
    }
  }
  
  private Drawable getStatusIconDrawable(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 1: 
      return this.viewConfig.getReplyIcon();
    case 2: 
      return this.viewConfig.getForwardIcon();
    case 3: 
      return this.viewConfig.getSendingIcon();
    case 5: 
      return this.viewConfig.getSendErrorIcon();
    case 6: 
      return this.viewConfig.getCancelingIcon()[this.mProgressCancelLoadingIndex];
    }
    return this.viewConfig.getSendErrorIcon();
  }
  
  public static void setHighLightKeywords(String[] paramArrayOfString)
  {
    int j = 0;
    String[] arrayOfString = highLightKeywords;
    if (paramArrayOfString != null) {}
    for (;;)
    {
      int i;
      try
      {
        HashSet localHashSet = new HashSet();
        i = 0;
        if (i < paramArrayOfString.length)
        {
          if (paramArrayOfString[i] == null) {
            break label113;
          }
          localHashSet.add(paramArrayOfString[i].trim());
          break label113;
        }
        localHashSet.remove("");
        paramArrayOfString = (String[])localHashSet.toArray(paramArrayOfString);
        i = j;
        if (i < highLightKeywords.length) {
          if (i < paramArrayOfString.length) {
            highLightKeywords[i] = paramArrayOfString[i];
          } else {
            highLightKeywords[i] = null;
          }
        }
      }
      finally {}
      return;
      label113:
      i += 1;
      continue;
      i += 1;
    }
  }
  
  public static void setHighLightType(int paramInt)
  {
    highLightSearchType = paramInt;
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    QMUIHelper.drawDivider(false, true, paramCanvas, this.paintDivider, 0, this.limitLeft);
  }
  
  public int getCancelIconMarginRight()
  {
    return this.cancelIconMarginRight;
  }
  
  public int getCancelIconWidth()
  {
    return this.mProgressCancelRect.width();
  }
  
  public CharSequence getContentDescription()
  {
    Context localContext = getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    CharSequence localCharSequence = super.getContentDescription();
    if (localCharSequence != null) {
      localStringBuilder.append(localCharSequence);
    }
    if (isChecked())
    {
      localStringBuilder.append(localContext.getString(2131720855));
      localStringBuilder.append(localContext.getString(2131720812));
      localStringBuilder.append(localContext.getString(2131720821, new Object[] { this.itemData.nickName, this.itemData.dateTime, this.itemData.subjectTitle }));
      localStringBuilder.append(localContext.getString(2131720846));
      return localStringBuilder.toString();
    }
    if (this.itemData.stateId == 2)
    {
      localStringBuilder.append(localContext.getString(2131720810));
      localStringBuilder.append(localContext.getString(2131720812));
    }
    for (;;)
    {
      if (this.itemData.hasAttach)
      {
        localStringBuilder.append(localContext.getString(2131720800));
        localStringBuilder.append(localContext.getString(2131720812));
      }
      if (this.itemData.isTopped)
      {
        localStringBuilder.append(localContext.getString(2131695663));
        localStringBuilder.append(localContext.getString(2131720812));
      }
      if (this.itemData.isStarred)
      {
        localStringBuilder.append(localContext.getString(2131695667));
        localStringBuilder.append(localContext.getString(2131720812));
      }
      if ((this.itemData.tagName1 != null) || (this.itemData.tagName2 != null))
      {
        localStringBuilder.append(localContext.getString(2131720822));
        if (this.itemData.tagName1 != null)
        {
          localStringBuilder.append(this.itemData.tagName1);
          localStringBuilder.append(localContext.getString(2131720812));
        }
        if (this.itemData.tagName2 != null)
        {
          localStringBuilder.append(this.itemData.tagName2);
          localStringBuilder.append(localContext.getString(2131720812));
        }
      }
      localStringBuilder.append(localContext.getString(2131720821, new Object[] { this.itemData.nickName, this.itemData.dateTime, this.itemData.subjectTitle }));
      localStringBuilder.append(localContext.getString(2131720846));
      break;
      if (this.itemData.stateId == 1)
      {
        localStringBuilder.append(localContext.getString(2131720799));
        localStringBuilder.append(localContext.getString(2131720812));
      }
    }
  }
  
  public MailListItemData getItemData()
  {
    return this.itemData;
  }
  
  public int getProgressCancelMarginTop()
  {
    return this.progressCancelMarginTop;
  }
  
  public boolean getShowAvatar()
  {
    return this.showAvatar;
  }
  
  public boolean isChecked()
  {
    return this.isChecked;
  }
  
  public boolean isInEditMode()
  {
    return this.isInEditMode;
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    super.setPressed(false);
  }
  
  protected int[] onCreateDrawableState(int paramInt)
  {
    int[] arrayOfInt = super.onCreateDrawableState(CHECKED_STATE_SET.length + paramInt);
    if (isChecked()) {
      mergeDrawableStates(arrayOfInt, CHECKED_STATE_SET);
    }
    return arrayOfInt;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    changePaintForState();
    int m = getWidth();
    int i = 0;
    int j = i;
    if (this.itemData.isShowNativeAdsPro)
    {
      j = i;
      if (this.itemData.unreadNumber > 0)
      {
        paramCanvas.save();
        i = (int)this.paintUnreadNumber.measureText(String.valueOf(this.itemData.unreadNumber));
        paramCanvas.translate(m - this.limitRight - i, this.dateTimeBaseline);
        paramCanvas.drawText(String.valueOf(this.itemData.unreadNumber), 0.0F, 0.0F, this.paintUnreadNumber);
        j = i + QMUIKit.dpToPx(4);
        paramCanvas.restore();
      }
    }
    i = 0;
    Object localObject1;
    Object localObject2;
    int k;
    if (this.itemData.isToppedAd)
    {
      localObject1 = getContext().getResources().getString(2131695612);
      i = (int)this.paintAdText.measureText((String)localObject1);
      localObject2 = this.viewConfig.getAdPadding();
      this.rectAdBackground.right = Math.max(localObject2[0] + i + localObject2[2], this.adSize);
      paramCanvas.save();
      paramCanvas.translate(m - this.limitRight - this.rectAdBackground.width() - j, this.dateTimeBaseline);
      k = this.viewConfig.getAdMarginTop();
      Drawable localDrawable = this.viewConfig.getTopAdBackground();
      localDrawable.setBounds(0, k - this.adSize, this.rectAdBackground.width(), k);
      localDrawable.draw(paramCanvas);
      paramCanvas.drawText((String)localObject1, (this.rectAdBackground.width() - i) / 2, -localObject2[3], this.paintAdText);
      paramCanvas.restore();
      paramCanvas.save();
      paramCanvas.translate(this.limitLeft, this.fromAddressBaseline);
      if (this.itemData.stateId != 0)
      {
        paramCanvas.save();
        localObject2 = this.viewConfig.getRectUnreadIcon();
        if (!this.showAvatar) {
          paramCanvas.translate(-(this.limitLeft + ((Rect)localObject2).width()) / 2, 0.0F);
        }
        localObject1 = null;
        if (this.itemData.stateId != 2) {
          break label3520;
        }
        localObject1 = this.viewConfig.getClockSendIcon();
        label403:
        ((Drawable)localObject1).setBounds((Rect)localObject2);
        paramCanvas.translate(0.0F, -(((Rect)localObject2).height() + this.iconAttachMarginTop));
        ((Drawable)localObject1).draw(paramCanvas);
        paramCanvas.restore();
        if (this.showAvatar) {
          paramCanvas.translate(((Rect)localObject2).width() + this.viewSpace, 0.0F);
        }
      }
      if (this.itemData.nickName != null)
      {
        j = m - this.limitLeft - this.limitRight - (i + j) - this.ellipsizeWidthForPaintFromAddress - this.viewSpace;
        i = j;
        if (this.itemData.stateId == 1) {
          i = j - (this.viewConfig.getRectUnreadIcon().width() + this.viewSpace);
        }
        j = i;
        if (this.itemData.stateId == 2) {
          j = i - (this.viewConfig.getRectClockSendIcon().width() + this.viewSpace);
        }
        i = j;
        if (this.itemData.hasAttach) {
          i = j - (this.viewConfig.getRectAttachIcon().width() + this.viewSpace);
        }
        j = i;
        if (this.itemData.isTopped) {
          j = i - (this.viewConfig.getRectStatusTopIcon().width() + this.viewSpace);
        }
        i = j;
        if (this.itemData.isStarred) {
          i = j - (this.viewConfig.getRectStarIcon().width() + this.viewSpace);
        }
        j = this.paintFromAddress.breakText(this.itemData.nickName, true, i, null);
        if (j >= this.itemData.nickName.length()) {
          break label3589;
        }
        i += (int)(this.ellipsizeWidthForPaintFromAddress / 1.5D);
        if ((highLightSearchType != 1) && (highLightSearchType != 2) && (highLightSearchType != 7)) {
          break label3543;
        }
        drawTextWithHighLightKeywords(paramCanvas, this.itemData.nickName.substring(0, j) + this.ellipsize, 0.0F, 0.0F, this.paintFromAddress);
        label789:
        paramCanvas.translate(i + this.viewSpace, 0.0F);
      }
      if (!this.itemData.hasAttach) {
        break label3669;
      }
      localObject1 = this.viewConfig.getRectAttachIcon();
      paramCanvas.translate(0.0F, this.iconAttachMarginTop - ((Rect)localObject1).height());
      localObject2 = this.viewConfig.getAttachIcon();
      ((Drawable)localObject2).setBounds(0, 0, ((Rect)localObject1).width(), ((Rect)localObject1).height());
      ((Drawable)localObject2).draw(paramCanvas);
      paramCanvas.translate(((Rect)localObject1).width() + this.viewSpace, -(this.iconAttachMarginTop - ((Rect)localObject1).height()));
      label896:
      if (this.itemData.isStarred)
      {
        localObject1 = this.viewConfig.getRectStarIcon();
        paramCanvas.translate(0.0F, this.iconAttachMarginTop - ((Rect)localObject1).height());
        localObject2 = this.viewConfig.getStarIcon();
        ((Drawable)localObject2).setBounds((Rect)localObject1);
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.translate(((Rect)localObject1).width() + this.viewSpace, ((Rect)localObject1).height() - this.iconAttachMarginTop);
      }
      if (this.itemData.isTopped)
      {
        localObject1 = this.viewConfig.getRectStatusTopIcon();
        paramCanvas.translate(0.0F, -((Rect)localObject1).height());
        localObject2 = this.viewConfig.getTopIcon();
        ((Drawable)localObject2).setBounds(0, 0, ((Rect)localObject1).width(), ((Rect)localObject1).height());
        ((Drawable)localObject2).draw(paramCanvas);
        paramCanvas.translate(((Rect)localObject1).width() + this.viewSpace, ((Rect)localObject1).height());
      }
      if ((this.itemData.unreadNumber > 0) && (!this.itemData.isShowNativeAdsPro)) {
        paramCanvas.drawText("" + this.itemData.unreadNumber, 0.0F, -QMUIKit.dpToPx(1), this.paintUnreadNumber);
      }
      paramCanvas.restore();
      if (this.itemData.subjectTitle == null) {
        break label5086;
      }
      j = m - this.limitRight - this.limitLeft - this.ellipsizeWidthForPaintSubjectTitle;
      if (this.itemData.conversationNumber == null) {
        break label5080;
      }
      i = (int)this.paintConversationText.measureText(this.itemData.conversationNumber);
      localObject1 = this.viewConfig.getConversationPadding();
      k = localObject1[0];
      k = Math.max(localObject1[2] + (k + i), this.conversationNumberSize);
      this.rectConversationBackground.right = k;
      j -= this.rectConversationBackground.width() + this.viewSpace;
      label1244:
      j = this.paintSubjectTitle.breakText(this.itemData.subjectTitle, true, j, null);
      if (j >= this.itemData.subjectTitle.length()) {
        break label3768;
      }
      localObject1 = this.itemData.subjectTitle.substring(0, j) + this.ellipsize;
      label1315:
      if ((highLightSearchType != 4) && (highLightSearchType != 7)) {
        break label3780;
      }
      drawTextWithHighLightKeywords(paramCanvas, (String)localObject1, this.limitLeft, this.subjectTitleBaseline, this.paintSubjectTitle);
    }
    label1823:
    label4387:
    for (;;)
    {
      label1351:
      float f1;
      float f2;
      if (this.itemData.conversationNumber != null)
      {
        paramCanvas.save();
        paramCanvas.translate(m - this.limitRight - this.rectConversationBackground.width(), this.subjectTitleBaseline);
        j = this.viewConfig.getConversationMarginTop();
        localObject1 = this.viewConfig.getConversationBackground();
        ((Drawable)localObject1).setBounds(0, j - this.conversationNumberSize, this.rectConversationBackground.width(), j);
        ((Drawable)localObject1).draw(paramCanvas);
        f1 = j - this.conversationNumberSize / 2;
        f2 = (this.paintConversationText.getFontMetrics().descent + this.paintConversationText.getFontMetrics().ascent) / 2.0F;
        paramCanvas.drawText(this.itemData.conversationNumber, (this.rectConversationBackground.width() - i) / 2, f1 - f2, this.paintConversationText);
        paramCanvas.restore();
      }
      i = m - this.limitRight;
      j = i;
      int i1;
      int n;
      int i2;
      if (this.itemData.tagName1 != null)
      {
        j = i;
        if (this.itemData.tagColor1 != 0)
        {
          j = this.viewConfig.getTagHeight();
          i1 = this.viewConfig.getTagMaxTextWidth();
          localObject1 = this.viewConfig.getTagPadding();
          k = this.viewConfig.getTagMarginBottom();
          n = this.viewConfig.getTagCornerRadius();
          i = this.viewConfig.getTagBaseline();
          this.rectTagBackground.setEmpty();
          this.rectTagBackground.bottom = j;
          if ((this.itemData.tagName2 != null) && (this.itemData.tagColor2 != 0))
          {
            i2 = (int)this.paintTagName2.measureText(this.itemData.tagName2);
            int i3 = Math.min(i2, i1);
            this.rectTagBackground.right = (localObject1[0] + i3 + localObject1[2]);
            this.rectTagBackground.offsetTo(m - this.limitRight - this.rectTagBackground.width(), this.itemHeight - k - j);
            paramCanvas.drawRoundRect(this.rectTagBackground, n, n, this.paintTagColor);
            if (i2 <= i3) {
              break label3803;
            }
            i2 = this.paintTagName2.breakText(this.itemData.tagName2, true, i3 - this.ellipsizeWidthForPaintTagName, null);
            paramCanvas.drawText(this.itemData.tagName2.substring(0, i2) + this.ellipsize, this.rectTagBackground.left + localObject1[0], i, this.paintTagName2);
          }
          i2 = (int)this.paintTagName1.measureText(this.itemData.tagName1);
          i1 = Math.min(i2, i1);
          this.rectTagBackground.right = (this.rectTagBackground.left + localObject1[0] + i1 + localObject1[2]);
          if (this.rectTagBackground.left == 0.0F) {
            break label3841;
          }
          this.rectTagBackground.offsetTo(this.rectTagBackground.left - this.viewSpace - this.rectTagBackground.width(), this.rectTagBackground.top);
          paramCanvas.drawRoundRect(this.rectTagBackground, n, n, this.paintTagColor);
          if (i2 <= i1) {
            break label3878;
          }
          j = this.paintTagName1.breakText(this.itemData.tagName1, true, i1 - this.ellipsizeWidthForPaintTagName, null);
          paramCanvas.drawText(this.itemData.tagName1.substring(0, j) + this.ellipsize, this.rectTagBackground.left + localObject1[0], i, this.paintTagName1);
          label2034:
          j = (int)this.rectTagBackground.left;
        }
      }
      label2126:
      boolean bool;
      if ((this.itemData.statusId != 0) && (this.itemData.statusId != 3))
      {
        k = this.drawableStatusIcon.getIntrinsicWidth();
        n = this.drawableStatusIcon.getIntrinsicHeight();
        i1 = (this.limitLeft - k) / 2;
        if (this.showAvatar)
        {
          i = this.viewConfig.getAvatarMarginTop() + this.viewConfig.getAvatarSize() + this.viewConfig.getStatusIconMarginTop();
          this.drawableStatusIcon.setBounds(i1, i, k + i1, n + i);
          this.drawableStatusIcon.draw(paramCanvas);
        }
      }
      else if ((this.itemData.abstractText != null) && (this.itemData.statusId != 3))
      {
        if (this.itemData.statusId == 4) {
          this.paintAbstractText.setColor(this.colorRed);
        }
        bool = this.itemData.isShowCommercialAdTag;
        k = 0;
        localObject2 = this.itemData.abstractText.split("\n");
        if ((!this.itemData.canSplitAbstractText) || (localObject2.length <= 1)) {
          break label4185;
        }
        i = j - this.limitLeft - this.ellipsizeWidthForPaintAbstractText;
        if ((this.itemData.tagName1 == null) && (this.itemData.tagName2 == null)) {
          break label5077;
        }
        i -= this.viewSpace;
      }
      label2500:
      label3669:
      label5077:
      for (;;)
      {
        localObject1 = (char[])mBigCharCache.get();
        if (localObject1 == null)
        {
          localObject1 = new char[m * 2];
          mBigCharCache = new WeakReference(localObject1);
        }
        for (;;)
        {
          j = Math.min(localObject1.length, Math.min(localObject2[0].length(), i + 5));
          localObject2[0].getChars(0, j, (char[])localObject1, 0);
          k = this.paintAbstractText.breakText((char[])localObject1, 0, Math.min(j, i), i, null);
          if (k < j)
          {
            this.ellipsize.getChars(0, this.ellipsize.length(), (char[])localObject1, k);
            if (highLightSearchType == 7)
            {
              drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, k + this.ellipsize.length(), this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
              j = Math.min(localObject1.length, Math.min(localObject2[1].length(), i + 5));
              localObject2[1].getChars(0, j, (char[])localObject1, 0);
              if (!bool) {
                break label4083;
              }
              f1 = i - this.commercialAdTagWidth - this.commercialAdTagMarginLeft;
              i = this.paintAbstractText.breakText((char[])localObject1, 0, Math.min(j, (int)f1), f1, null);
              if (i >= j) {
                break label4124;
              }
              this.ellipsize.getChars(0, this.ellipsize.length(), (char[])localObject1, i);
              if (highLightSearchType != 7) {
                break label4090;
              }
              drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, i + this.ellipsize.length(), this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
              if (!bool) {
                break label5068;
              }
              i = this.abstractTextSecondLineBaseline;
              localObject2 = this.commercialAdTagBgRectF;
              f1 = this.limitLeft;
              ((RectF)localObject2).left = (this.paintAbstractText.measureText((char[])localObject1, 0, j) + f1 + this.commercialAdTagMarginLeft);
            }
          }
          for (;;)
          {
            float f3;
            if (bool)
            {
              this.commercialAdTagPaint.setColor(this.commercialAdTagBgColor);
              this.commercialAdTagBgRectF.top = (i + this.paintAbstractText.getFontMetrics().ascent + QMUIKit.dpToPx(2));
              this.commercialAdTagBgRectF.bottom = (i + this.paintAbstractText.getFontMetrics().descent - QMUIKit.dpToPx(2));
              this.commercialAdTagBgRectF.right = (this.commercialAdTagBgRectF.left + this.commercialAdTagWidth);
              paramCanvas.drawRoundRect(this.commercialAdTagBgRectF, this.commercialAdTagRadius, this.commercialAdTagRadius, this.commercialAdTagPaint);
              this.commercialAdTagPaint.setColor(-1);
              f1 = this.commercialAdTagBgRectF.top;
              f2 = (this.commercialAdTagBgRectF.bottom - this.commercialAdTagBgRectF.top) / 2.0F;
              f3 = (this.commercialAdTagPaint.getFontMetrics().descent + this.commercialAdTagPaint.getFontMetrics().ascent) / 2.0F;
              paramCanvas.drawText(this.commercialAdTag, this.commercialAdTagBgRectF.left + this.commercialAdTagPaddingHorizontal, f1 + f2 - f3, this.commercialAdTagPaint);
            }
            if (this.showAvatar)
            {
              localObject2 = this.itemData.avatarOptionalName;
              localObject1 = localObject2;
              if (localObject2 == null) {
                localObject1 = this.itemData.nickName;
              }
              if (localObject1 == null) {
                QMLog.log(6, "MailListItemView", "no showText:" + this.itemData);
              }
              if (this.itemData.avatarBitmap != null) {
                paramCanvas.drawBitmap(this.itemData.avatarBitmap, this.limitLeft - this.viewConfig.getAvatarSize() - this.viewConfig.getAvatarMarginRight(), this.viewConfig.getAvatarMarginTop(), null);
              }
            }
            if (this.itemData.statusId == 3)
            {
              this.cancelIconMarginRight = (this.limitRight + this.mProgressCancelRect.width());
              this.mProgressCancelRect.offsetTo(m - this.limitRight - this.mProgressCancelRect.width(), this.progressCancelMarginTop);
              this.mProgressCancelDrawable.setBounds(this.mProgressCancelRect);
              this.mProgressCancelDrawable.draw(paramCanvas);
              this.mProgressBgRect.left = this.limitLeft;
              this.mProgressRect.left = this.mProgressBgRect.left;
              this.mProgressBgRect.right = (m - this.limitRight - this.mProgressCancelRect.width() - this.progressCancelLeftSpace);
              this.mProgressRect.right = (this.mProgressRect.left + (int)(this.mProgressBgRect.width() * this.itemData.progress));
              paramCanvas.drawRect(this.mProgressBgRect, this.mProgressBgPaint);
              paramCanvas.drawRect(this.mProgressRect, this.mProgressPaint);
            }
            if (this.itemData.statusId == 6)
            {
              this.mProgressCancelLoadingIndex += 1;
              if (this.mProgressCancelLoadingIndex >= 12) {
                this.mProgressCancelLoadingIndex = 0;
              }
              postInvalidateDelayed(50L);
            }
            return;
            if (this.itemData.isShowNativeAdsPro)
            {
              localObject1 = getContext().getResources().getString(2131695612);
              i = (int)this.paintNativeAds.measureText((String)localObject1);
              this.nativeAdProBg.left = 0.0F;
              this.nativeAdProBg.right = (this.nativeAdsProPaddingHorizontal * 2 + i);
              this.nativeAdProBg.top = (this.dateTimeBaseline + this.paintNativeAds.getFontMetrics().ascent - QMUIKit.dpToPx(2));
              this.nativeAdProBg.bottom = (this.dateTimeBaseline + this.paintNativeAds.getFontMetrics().descent + QMUIKit.dpToPx(2));
              paramCanvas.save();
              paramCanvas.translate(m - this.limitRight - this.nativeAdProBg.width() - j, 0.0F);
              this.paintNativeAds.setColor(this.commercialAdTagBgColor);
              paramCanvas.drawRoundRect(this.nativeAdProBg, this.commercialAdTagRadius, this.commercialAdTagRadius, this.paintNativeAds);
              this.paintNativeAds.setColor(-1);
              f1 = this.nativeAdProBg.top;
              f2 = (this.nativeAdProBg.bottom - this.nativeAdProBg.top) / 2.0F;
              f3 = (this.paintNativeAds.getFontMetrics().descent + this.paintNativeAds.getFontMetrics().ascent) / 2.0F;
              paramCanvas.drawText((String)localObject1, this.nativeAdProBg.left + this.nativeAdsProPaddingHorizontal, f1 + f2 - f3, this.paintNativeAds);
              paramCanvas.restore();
              break;
            }
            if (this.itemData.dateTime == null) {
              break;
            }
            i = (int)this.paintDateTime.measureText(this.itemData.dateTime);
            paramCanvas.drawText(this.itemData.dateTime, m - this.limitRight - i, this.dateTimeBaseline, this.paintDateTime);
            break;
            if (this.itemData.stateId != 1) {
              break label403;
            }
            localObject1 = this.viewConfig.getUnreadIcon();
            break label403;
            label3543:
            paramCanvas.drawText(this.itemData.nickName.substring(0, j) + this.ellipsize, 0.0F, 0.0F, this.paintFromAddress);
            break label789;
            i = (int)this.paintFromAddress.measureText(this.itemData.nickName);
            if ((highLightSearchType == 1) || (highLightSearchType == 2) || (highLightSearchType == 7))
            {
              drawTextWithHighLightKeywords(paramCanvas, this.itemData.nickName, 0.0F, 0.0F, this.paintFromAddress);
              break label789;
            }
            paramCanvas.drawText(this.itemData.nickName, 0.0F, 0.0F, this.paintFromAddress);
            break label789;
            if ((this.showAvatar) || (this.itemData.avatarBitmap == null)) {
              break label896;
            }
            localObject1 = this.paintFromAddress.getFontMetrics();
            f1 = ((Paint.FontMetrics)localObject1).ascent;
            f1 = (((Paint.FontMetrics)localObject1).descent + f1 - this.itemData.avatarBitmap.getHeight()) / 2.0F;
            paramCanvas.translate(0.0F, f1);
            paramCanvas.drawBitmap(this.itemData.avatarBitmap, 0.0F, 0.0F, null);
            paramCanvas.translate(this.itemData.avatarBitmap.getWidth() + this.viewSpace, -f1);
            break label896;
            localObject1 = this.itemData.subjectTitle;
            break label1315;
            paramCanvas.drawText((String)localObject1, this.limitLeft, this.subjectTitleBaseline, this.paintSubjectTitle);
            break label1351;
            label3803:
            paramCanvas.drawText(this.itemData.tagName2, this.rectTagBackground.right - localObject1[2] - i2, i, this.paintTagName2);
            break label1823;
            this.rectTagBackground.offsetTo(m - this.limitRight - this.rectTagBackground.width(), this.itemHeight - k - j);
            break label1926;
            paramCanvas.drawText(this.itemData.tagName1, this.rectTagBackground.left + localObject1[0], i, this.paintTagName1);
            break label2034;
            if ((this.itemData.statusId == 5) || (this.itemData.statusId == 6) || (this.itemData.statusId == 4))
            {
              i = this.viewConfig.getAvatarMarginTop() + this.viewConfig.getAvatarSize() + this.viewConfig.getStatusIconMarginTop();
              break label2126;
            }
            i = (this.itemHeight - n) / 2;
            break label2126;
            paramCanvas.drawText((char[])localObject1, 0, this.ellipsize.length() + k, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
            break label2445;
            if (highLightSearchType == 7)
            {
              drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, j, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
              break label2445;
            }
            paramCanvas.drawText((char[])localObject1, 0, j, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
            break label2445;
            label4083:
            f1 = i;
            break label2500;
            label4090:
            paramCanvas.drawText((char[])localObject1, 0, this.ellipsize.length() + i, this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
            break label2587;
            if (highLightSearchType == 7)
            {
              drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, j, this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
              break label2587;
            }
            paramCanvas.drawText((char[])localObject1, 0, j, this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
            break label2587;
            label4185:
            i = j - this.limitLeft - this.ellipsizeWidthForPaintAbstractText;
            if ((this.itemData.tagName1 != null) || (this.itemData.tagName2 != null)) {
              i -= this.viewSpace;
            }
            for (;;)
            {
              localObject1 = (char[])mBigCharCache.get();
              if (localObject1 == null)
              {
                localObject1 = new char[m * 2];
                mBigCharCache = new WeakReference(localObject1);
              }
              for (;;)
              {
                j = Math.min(localObject1.length, Math.min(this.itemData.abstractText.length(), i + 5));
                this.itemData.abstractText.getChars(0, j, (char[])localObject1, 0);
                if (bool)
                {
                  f1 = i - this.commercialAdTagWidth - this.commercialAdTagMarginLeft;
                  label4325:
                  n = this.paintAbstractText.breakText((char[])localObject1, 0, Math.min(j, i), i, null);
                  if (n >= j) {
                    break label4734;
                  }
                  if (highLightSearchType != 7) {
                    break label4548;
                  }
                  drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, n, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
                  i1 = this.paintAbstractText.breakText((char[])localObject1, n, j, f1, null);
                  if (i1 >= j - n) {
                    break label4609;
                  }
                  this.ellipsize.getChars(0, this.ellipsize.length(), (char[])localObject1, n + i1);
                  if (highLightSearchType != 7) {
                    break label4574;
                  }
                  drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, n, i1 + this.ellipsize.length(), this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
                }
                for (;;)
                {
                  i = k;
                  if (!bool) {
                    break;
                  }
                  i = this.abstractTextSecondLineBaseline;
                  localObject2 = this.commercialAdTagBgRectF;
                  f1 = this.limitLeft;
                  ((RectF)localObject2).left = (this.paintAbstractText.measureText((char[])localObject1, n, i1 + this.ellipsize.length()) + f1 + this.commercialAdTagMarginLeft);
                  break;
                  f1 = i;
                  break label4325;
                  paramCanvas.drawText((char[])localObject1, 0, n, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
                  break label4387;
                  label4574:
                  paramCanvas.drawText((char[])localObject1, n, i1 + this.ellipsize.length(), this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
                }
                if (highLightSearchType == 7) {
                  drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, n, j - n, this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
                }
                for (;;)
                {
                  i = k;
                  if (!bool) {
                    break;
                  }
                  i = this.abstractTextSecondLineBaseline;
                  localObject2 = this.commercialAdTagBgRectF;
                  f1 = this.limitLeft;
                  ((RectF)localObject2).left = (this.paintAbstractText.measureText((char[])localObject1, n, j - n) + f1 + this.commercialAdTagMarginLeft);
                  break;
                  paramCanvas.drawText((char[])localObject1, n, j - n, this.limitLeft, this.abstractTextSecondLineBaseline, this.paintAbstractText);
                }
                label4734:
                if (bool)
                {
                  i = this.paintAbstractText.breakText((char[])localObject1, 0, Math.min(j, (int)f1), f1, null);
                  if (i < j)
                  {
                    this.ellipsize.getChars(0, this.ellipsize.length(), (char[])localObject1, i);
                    i += this.ellipsize.length();
                    this.commercialAdTagBgRectF.left = (this.limitLeft + this.paintAbstractText.measureText((char[])localObject1, 0, i) + this.commercialAdTagMarginLeft);
                  }
                }
                for (;;)
                {
                  if ((this.itemData.statusId == 4) || (this.itemData.statusId == 6))
                  {
                    localObject2 = this.paintAbstractText.getFontMetrics();
                    f1 = this.viewConfig.getAvatarMarginTop() + this.viewConfig.getAvatarSize() + this.viewConfig.getStatusIconMarginTop() + this.drawableStatusIcon.getIntrinsicHeight() - ((Paint.FontMetrics)localObject2).descent + QMUIKit.dpToPx(1);
                    if (highLightSearchType == 7) {
                      drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, i, this.limitLeft, f1, this.paintAbstractText);
                    }
                    for (;;)
                    {
                      i = k;
                      if (!bool) {
                        break;
                      }
                      i = (int)f1;
                      break;
                      paramCanvas.drawText((char[])localObject1, 0, i, this.limitLeft, f1, this.paintAbstractText);
                    }
                  }
                  if (highLightSearchType == 7) {
                    drawTextWithHighLightKeywords(paramCanvas, (char[])localObject1, 0, i, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
                  }
                  for (;;)
                  {
                    i = k;
                    if (!bool) {
                      break;
                    }
                    i = this.abstractTextFirstLineBaseline;
                    break;
                    paramCanvas.drawText((char[])localObject1, 0, i, this.limitLeft, this.abstractTextFirstLineBaseline, this.paintAbstractText);
                  }
                  i = j;
                  break label4798;
                  i = j;
                }
              }
            }
            i = 0;
          }
        }
      }
      label3520:
      label3780:
      label4548:
      label5068:
      label5080:
      i = 0;
      label3768:
      label4798:
      break label1244;
      label3878:
      label5086:
      i = 0;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (!paramBoolean) {
      super.setPressed(false);
    }
  }
  
  public void refreshTopMode(boolean paramBoolean)
  {
    if ((!this.isInEditMode) && (this.isTopped != paramBoolean))
    {
      this.isTopped = paramBoolean;
      setItemToNormalMode();
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (this.isChecked != paramBoolean)
    {
      this.isChecked = paramBoolean;
      refreshDrawableState();
    }
  }
  
  public void setItemToEditMode()
  {
    QMUIHelper.setBackground(this, this.viewConfig.getBackgroundDrawableEditMode());
    this.isInEditMode = true;
  }
  
  public void setItemToNormalMode()
  {
    boolean bool = this.itemData.isTopped;
    this.isTopped = bool;
    if (bool) {}
    for (Drawable localDrawable = this.viewConfig.getBackgroundDrawableTopMode();; localDrawable = this.viewConfig.getBackgroundDrawable())
    {
      QMUIHelper.setBackground(this, localDrawable);
      setChecked(false);
      this.isInEditMode = false;
      return;
    }
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
  
  public void setPressedCustom(boolean paramBoolean)
  {
    super.setSelected(paramBoolean);
  }
  
  public void setShowAvatar(boolean paramBoolean)
  {
    this.showAvatar = paramBoolean;
    if (this.showAvatar)
    {
      this.limitLeft = (getResources().getDimensionPixelSize(2131297032) + this.padding[0]);
      this.limitLeft += this.viewConfig.getAvatarSize() + this.viewConfig.getAvatarMarginRight();
    }
  }
  
  public void toggle()
  {
    if (!this.isChecked) {}
    for (boolean bool = true;; bool = false)
    {
      setChecked(bool);
      return;
    }
  }
  
  public static class MailListItemData
  {
    public String abstractText;
    public Bitmap avatarBitmap;
    public String avatarOptionalName;
    public boolean canSplitAbstractText;
    public String conversationNumber;
    public String dateTime;
    public boolean hasAttach;
    public boolean isShowCommercialAdTag;
    public boolean isShowNativeAdsPro;
    public boolean isStarred;
    public boolean isTopped;
    public boolean isToppedAd;
    public boolean needReNew;
    public String nickName;
    public double progress;
    public int stateId;
    public int statusId;
    public String subjectTitle;
    public int tagColor1;
    public int tagColor2;
    public String tagName1;
    public String tagName2;
    public int unreadNumber;
    
    public void reset()
    {
      this.needReNew = false;
      this.nickName = null;
      this.subjectTitle = null;
      this.abstractText = null;
      this.dateTime = null;
      this.conversationNumber = null;
      this.tagName1 = null;
      this.tagName2 = null;
      this.tagColor1 = 0;
      this.tagColor2 = 0;
      this.statusId = 0;
      this.stateId = 0;
      this.hasAttach = false;
      this.isStarred = false;
      this.isTopped = false;
      this.avatarBitmap = null;
      this.unreadNumber = 0;
      this.avatarOptionalName = null;
      this.progress = 0.0D;
      this.isToppedAd = false;
      this.isShowNativeAdsPro = false;
      this.isShowCommercialAdTag = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.view.MailListItemView
 * JD-Core Version:    0.7.0.1
 */