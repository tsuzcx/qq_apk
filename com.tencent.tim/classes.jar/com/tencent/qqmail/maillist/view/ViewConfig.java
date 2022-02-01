package com.tencent.qqmail.maillist.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.tencent.qqmail.download.ImageDownloadManager;

public final class ViewConfig
{
  private static int avatarMarginRight;
  private static int avatarMarginTop;
  private static int avatarSize;
  private static int colorBlack = -2147483648;
  private static int colorGray;
  private static int colorGray1;
  private static int colorProgress;
  private static int colorProgressBackground;
  private static int colorRed;
  private static int colorTagBackground;
  private static int colorWhite = -2147483648;
  private static Typeface sTypeface = null;
  private static boolean sTypefaceGet;
  private static int statusIconMarginTop;
  private static int tagBaseline;
  private static int tagCornerRadius;
  private static int tagHeight;
  private static int tagMarginBottom;
  private static int tagMaxTextWidth;
  private static int[] tagPadding;
  private Drawable adBackground;
  private int adMarginTop = -2147483648;
  private int[] adPadding;
  private int adSize = -2147483648;
  private Drawable attachIcon;
  private Drawable backgroundDrawable;
  private Drawable backgroundDrawableEditMode;
  private Drawable backgroundDrawableTopMode;
  private Drawable[] cancelingIcon;
  private Drawable clockSendIcon;
  private Drawable conversationBackground;
  private int conversationMarginTop = -2147483648;
  private int conversationNumberSize = -2147483648;
  private int[] conversationPadding;
  private Drawable forwardIcon;
  private final Resources mResources;
  private Drawable progressCancelIcon;
  private Rect rectAttachIcon;
  private Rect rectClockSendIcon;
  private Rect rectProgressCancelIcon;
  private Rect rectStarIcon;
  private Rect rectStatusTopIcon;
  private Rect rectUnreadIcon;
  private Drawable replyIcon;
  private Drawable sendErrorIcon;
  private Drawable sendingIcon;
  private Drawable starIcon;
  private Drawable topAdBackground;
  private Drawable topIcon;
  private Drawable unreadIcon;
  
  static
  {
    colorGray = -2147483648;
    colorRed = -2147483648;
    colorTagBackground = -2147483648;
    colorProgressBackground = -2147483648;
    colorProgress = -2147483648;
    colorGray1 = -2147483648;
    avatarSize = -2147483648;
    avatarMarginTop = -2147483648;
    avatarMarginRight = -2147483648;
    statusIconMarginTop = -2147483648;
    tagBaseline = -2147483648;
    tagHeight = -2147483648;
    tagMaxTextWidth = -2147483648;
    tagMarginBottom = -2147483648;
    tagCornerRadius = -2147483648;
    sTypefaceGet = true;
  }
  
  public ViewConfig(Resources paramResources)
  {
    this.mResources = paramResources;
  }
  
  private Drawable getLoadingBitmap(int paramInt1, int paramInt2)
  {
    Object localObject3 = "QMLoading:" + paramInt2 + ":" + paramInt1 + ":" + -8224126;
    Object localObject2 = ImageDownloadManager.shareInstance().getThumbBitmapFromLocal((String)localObject3);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = Bitmap.createBitmap(paramInt2, paramInt2, Bitmap.Config.ARGB_8888);
      ImageDownloadManager.shareInstance().addMemoryCache((String)localObject3, (Bitmap)localObject1);
      int i = paramInt2 / 12;
      int j = paramInt2 / 6;
      localObject2 = new Paint();
      ((Paint)localObject2).setAntiAlias(true);
      ((Paint)localObject2).setColor(-8224126);
      ((Paint)localObject2).setStrokeWidth(i);
      ((Paint)localObject2).setStrokeCap(Paint.Cap.ROUND);
      localObject3 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject3).rotate(paramInt1, paramInt2 / 2, paramInt2 / 2);
      ((Canvas)localObject3).translate(paramInt2 / 2, paramInt2 / 2);
      paramInt1 = 0;
      while (paramInt1 < 12)
      {
        ((Canvas)localObject3).rotate(30.0F);
        ((Paint)localObject2).setAlpha((int)((paramInt1 + 1) * 255 / 12.0F));
        ((Canvas)localObject3).translate(0.0F, -paramInt2 / 2 + i / 2);
        ((Canvas)localObject3).drawLine(0.0F, 0.0F, 0.0F, j, (Paint)localObject2);
        ((Canvas)localObject3).translate(0.0F, paramInt2 / 2 - i / 2);
        paramInt1 += 1;
      }
    }
    return new BitmapDrawable(this.mResources, (Bitmap)localObject1);
  }
  
  final Drawable getAdBackground()
  {
    if (this.adBackground == null) {
      this.adBackground = this.mResources.getDrawable(2130850452);
    }
    return this.adBackground;
  }
  
  final int getAdMarginTop()
  {
    if (this.adMarginTop == -2147483648) {
      this.adMarginTop = this.mResources.getDimensionPixelSize(2131297658);
    }
    return this.adMarginTop;
  }
  
  final int[] getAdPadding()
  {
    if (this.adPadding == null) {
      this.adPadding = new int[] { this.mResources.getDimensionPixelSize(2131297660), this.mResources.getDimensionPixelSize(2131297662), this.mResources.getDimensionPixelSize(2131297661), this.mResources.getDimensionPixelSize(2131297659) };
    }
    return this.adPadding;
  }
  
  final int getAdSize()
  {
    if (this.adSize == -2147483648) {
      this.adSize = this.mResources.getDimensionPixelSize(2131297663);
    }
    return this.adSize;
  }
  
  public final Drawable getAttachIcon()
  {
    if (this.attachIcon == null) {
      this.attachIcon = this.mResources.getDrawable(2130841063);
    }
    return this.attachIcon;
  }
  
  final int getAvatarMarginRight()
  {
    if (avatarMarginRight == -2147483648) {
      avatarMarginRight = this.mResources.getDimensionPixelSize(2131297667);
    }
    return avatarMarginRight;
  }
  
  final int getAvatarMarginTop()
  {
    if (avatarMarginTop == -2147483648) {
      avatarMarginTop = this.mResources.getDimensionPixelSize(2131297666);
    }
    return avatarMarginTop;
  }
  
  final int getAvatarSize()
  {
    if (avatarSize == -2147483648) {
      avatarSize = this.mResources.getDimensionPixelSize(2131296637);
    }
    return avatarSize;
  }
  
  final Drawable getBackgroundDrawable()
  {
    if (this.backgroundDrawable == null) {
      this.backgroundDrawable = this.mResources.getDrawable(2130845612);
    }
    return this.backgroundDrawable;
  }
  
  final Drawable getBackgroundDrawableEditMode()
  {
    if (this.backgroundDrawableEditMode == null) {
      this.backgroundDrawableEditMode = this.mResources.getDrawable(2130845612);
    }
    return this.backgroundDrawableEditMode;
  }
  
  final Drawable getBackgroundDrawableTopMode()
  {
    if (this.backgroundDrawableTopMode == null) {
      this.backgroundDrawableTopMode = this.mResources.getDrawable(2130850546);
    }
    return this.backgroundDrawableTopMode;
  }
  
  public final Drawable[] getCancelingIcon()
  {
    if (this.cancelingIcon == null)
    {
      this.cancelingIcon = new Drawable[12];
      int i = 0;
      while (i < 12)
      {
        this.cancelingIcon[i] = getLoadingBitmap(i * 30, this.mResources.getDimensionPixelSize(2131297668));
        i += 1;
      }
    }
    return this.cancelingIcon;
  }
  
  public final Drawable getClockSendIcon()
  {
    if (this.clockSendIcon == null) {
      this.clockSendIcon = this.mResources.getDrawable(2130841064);
    }
    return this.clockSendIcon;
  }
  
  final int getColorBlack()
  {
    if (colorBlack == -2147483648) {
      colorBlack = this.mResources.getColor(2131167519);
    }
    return colorBlack;
  }
  
  final int getColorGray()
  {
    if (colorGray == -2147483648) {
      colorGray = this.mResources.getColor(2131166576);
    }
    return colorGray;
  }
  
  final int getColorGray1()
  {
    if (colorGray1 == 2147483647) {
      colorGray1 = this.mResources.getColor(2131166574);
    }
    return colorGray1;
  }
  
  final int getColorProgress()
  {
    if (colorProgress == -2147483648) {
      colorProgress = this.mResources.getColor(2131165991);
    }
    return colorProgress;
  }
  
  final int getColorProgressBackground()
  {
    if (colorProgressBackground == -2147483648) {
      colorProgressBackground = this.mResources.getColor(2131165992);
    }
    return colorProgressBackground;
  }
  
  final int getColorRed()
  {
    if (colorRed == -2147483648) {
      colorRed = this.mResources.getColor(2131165993);
    }
    return colorRed;
  }
  
  final int getColorTagBackground()
  {
    if (colorTagBackground == -2147483648) {
      colorTagBackground = this.mResources.getColor(2131166030);
    }
    return colorTagBackground;
  }
  
  final int getColorWhite()
  {
    if (colorWhite == -2147483648) {
      colorWhite = this.mResources.getColor(2131167654);
    }
    return colorWhite;
  }
  
  public final Drawable getConversationBackground()
  {
    if (this.conversationBackground == null) {
      this.conversationBackground = this.mResources.getDrawable(2130850491);
    }
    return this.conversationBackground;
  }
  
  final int getConversationMarginTop()
  {
    if (this.conversationMarginTop == -2147483648) {
      this.conversationMarginTop = this.mResources.getDimensionPixelSize(2131297669);
    }
    return this.conversationMarginTop;
  }
  
  final int getConversationNumberSize()
  {
    if (this.conversationNumberSize == -2147483648) {
      this.conversationNumberSize = this.mResources.getDimensionPixelSize(2131297674);
    }
    return this.conversationNumberSize;
  }
  
  final int[] getConversationPadding()
  {
    if (this.conversationPadding == null) {
      this.conversationPadding = new int[] { this.mResources.getDimensionPixelSize(2131297671), this.mResources.getDimensionPixelSize(2131297673), this.mResources.getDimensionPixelSize(2131297672), this.mResources.getDimensionPixelSize(2131297670) };
    }
    return this.conversationPadding;
  }
  
  public final Drawable getForwardIcon()
  {
    if (this.forwardIcon == null) {
      this.forwardIcon = this.mResources.getDrawable(2130841066);
    }
    return this.forwardIcon;
  }
  
  public final Drawable getProgressCancelIcon()
  {
    if (this.progressCancelIcon == null) {
      this.progressCancelIcon = this.mResources.getDrawable(2130840856);
    }
    return this.progressCancelIcon;
  }
  
  public final Rect getRectAttachIcon()
  {
    if (this.rectAttachIcon == null)
    {
      Drawable localDrawable = getAttachIcon();
      this.rectAttachIcon = new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    }
    return this.rectAttachIcon;
  }
  
  public final Rect getRectClockSendIcon()
  {
    if (this.rectClockSendIcon == null)
    {
      Drawable localDrawable = getClockSendIcon();
      this.rectClockSendIcon = new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    }
    return this.rectClockSendIcon;
  }
  
  public final Rect getRectProgressCancelIcon()
  {
    if (this.rectProgressCancelIcon == null)
    {
      Drawable localDrawable = getProgressCancelIcon();
      this.rectProgressCancelIcon = new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    }
    return this.rectProgressCancelIcon;
  }
  
  public final Rect getRectStarIcon()
  {
    if (this.rectStarIcon == null)
    {
      Drawable localDrawable = getStarIcon();
      this.rectStarIcon = new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    }
    return this.rectStarIcon;
  }
  
  public final Rect getRectStatusTopIcon()
  {
    if (this.rectStatusTopIcon == null)
    {
      Drawable localDrawable = getTopIcon();
      this.rectStatusTopIcon = new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    }
    return this.rectStatusTopIcon;
  }
  
  public final Rect getRectUnreadIcon()
  {
    if (this.rectUnreadIcon == null)
    {
      Drawable localDrawable = getUnreadIcon();
      this.rectUnreadIcon = new Rect(0, 0, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight());
    }
    return this.rectUnreadIcon;
  }
  
  public final Drawable getReplyIcon()
  {
    if (this.replyIcon == null) {
      this.replyIcon = this.mResources.getDrawable(2130841067);
    }
    return this.replyIcon;
  }
  
  public final Drawable getSendErrorIcon()
  {
    if (this.sendErrorIcon == null) {
      this.sendErrorIcon = this.mResources.getDrawable(2130841065);
    }
    return this.sendErrorIcon;
  }
  
  public final Drawable getSendingIcon()
  {
    if (this.sendingIcon == null) {
      this.sendingIcon = this.mResources.getDrawable(2130841068);
    }
    return this.sendingIcon;
  }
  
  public final Drawable getStarIcon()
  {
    if (this.starIcon == null) {
      this.starIcon = this.mResources.getDrawable(2130841069);
    }
    return this.starIcon;
  }
  
  final int getStatusIconMarginTop()
  {
    if (statusIconMarginTop == -2147483648) {
      statusIconMarginTop = this.mResources.getDimensionPixelSize(2131297682);
    }
    return statusIconMarginTop;
  }
  
  public Typeface getSystemTypeface(Context paramContext)
  {
    if (sTypefaceGet)
    {
      sTypeface = ((TextView)LayoutInflater.from(paramContext).inflate(2131559425, null).findViewById(2131371075)).getTypeface();
      sTypefaceGet = false;
    }
    return sTypeface;
  }
  
  final int getTagBaseline()
  {
    if (tagBaseline == -2147483648) {
      tagBaseline = this.mResources.getDimensionPixelSize(2131297684);
    }
    return tagBaseline;
  }
  
  final int getTagCornerRadius()
  {
    if (tagCornerRadius == -2147483648) {
      tagCornerRadius = this.mResources.getDimensionPixelSize(2131297649);
    }
    return tagCornerRadius;
  }
  
  final int getTagHeight()
  {
    if (tagHeight == -2147483648) {
      tagHeight = this.mResources.getDimensionPixelSize(2131297685);
    }
    return tagHeight;
  }
  
  final int getTagMarginBottom()
  {
    if (tagMarginBottom == -2147483648) {
      tagMarginBottom = this.mResources.getDimensionPixelSize(2131297686);
    }
    return tagMarginBottom;
  }
  
  final int getTagMaxTextWidth()
  {
    if (tagMaxTextWidth == -2147483648)
    {
      int[] arrayOfInt = getTagPadding();
      tagMaxTextWidth = this.mResources.getDimensionPixelSize(2131297651) - arrayOfInt[0] - arrayOfInt[2];
    }
    return tagMaxTextWidth;
  }
  
  final int[] getTagPadding()
  {
    if (tagPadding == null) {
      tagPadding = new int[] { this.mResources.getDimensionPixelSize(2131297688), this.mResources.getDimensionPixelSize(2131297690), this.mResources.getDimensionPixelSize(2131297689), this.mResources.getDimensionPixelSize(2131297687) };
    }
    return tagPadding;
  }
  
  final Drawable getTopAdBackground()
  {
    if (this.topAdBackground == null) {
      this.topAdBackground = this.mResources.getDrawable(2130850451);
    }
    return this.topAdBackground;
  }
  
  public final Drawable getTopIcon()
  {
    if (this.topIcon == null) {
      this.topIcon = this.mResources.getDrawable(2130841071);
    }
    return this.topIcon;
  }
  
  public final Drawable getUnreadIcon()
  {
    if (this.unreadIcon == null) {
      this.unreadIcon = this.mResources.getDrawable(2130841072);
    }
    return this.unreadIcon;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.maillist.view.ViewConfig
 * JD-Core Version:    0.7.0.1
 */