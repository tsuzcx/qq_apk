package android.support.v4.app;

import android.app.Notification;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.RestrictTo;
import android.support.compat.R.dimen;
import android.support.compat.R.drawable;
import android.support.compat.R.id;
import android.support.compat.R.integer;
import android.support.compat.R.string;
import android.widget.RemoteViews;
import java.text.NumberFormat;

public abstract class NotificationCompat$Style
{
  CharSequence mBigContentTitle;
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected NotificationCompat.Builder mBuilder;
  CharSequence mSummaryText;
  boolean mSummaryTextSet = false;
  
  private int calculateTopPadding()
  {
    Resources localResources = this.mBuilder.mContext.getResources();
    int i = localResources.getDimensionPixelSize(R.dimen.notification_top_pad);
    int j = localResources.getDimensionPixelSize(R.dimen.notification_top_pad_large_text);
    float f1 = (constrain(localResources.getConfiguration().fontScale, 1.0F, 1.3F) - 1.0F) / 0.3F;
    float f2 = i;
    return Math.round(f1 * j + f2 * (1.0F - f1));
  }
  
  private static float constrain(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 < paramFloat2) {
      return paramFloat2;
    }
    if (paramFloat1 > paramFloat3) {
      return paramFloat3;
    }
    return paramFloat1;
  }
  
  private Bitmap createColoredBitmap(int paramInt1, int paramInt2, int paramInt3)
  {
    Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1);
    if (paramInt3 == 0) {}
    for (paramInt1 = localDrawable.getIntrinsicWidth();; paramInt1 = paramInt3)
    {
      int i = paramInt3;
      if (paramInt3 == 0) {
        i = localDrawable.getIntrinsicHeight();
      }
      Bitmap localBitmap = Bitmap.createBitmap(paramInt1, i, Bitmap.Config.ARGB_8888);
      localDrawable.setBounds(0, 0, paramInt1, i);
      if (paramInt2 != 0) {
        localDrawable.mutate().setColorFilter(new PorterDuffColorFilter(paramInt2, PorterDuff.Mode.SRC_IN));
      }
      localDrawable.draw(new Canvas(localBitmap));
      return localBitmap;
    }
  }
  
  private Bitmap createIconWithBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = R.drawable.notification_icon_background;
    int i = paramInt4;
    if (paramInt4 == 0) {
      i = 0;
    }
    Bitmap localBitmap = createColoredBitmap(j, i, paramInt2);
    Canvas localCanvas = new Canvas(localBitmap);
    Drawable localDrawable = this.mBuilder.mContext.getResources().getDrawable(paramInt1).mutate();
    localDrawable.setFilterBitmap(true);
    paramInt1 = (paramInt2 - paramInt3) / 2;
    localDrawable.setBounds(paramInt1, paramInt1, paramInt3 + paramInt1, paramInt3 + paramInt1);
    localDrawable.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_ATOP));
    localDrawable.draw(localCanvas);
    return localBitmap;
  }
  
  private void hideNormalContent(RemoteViews paramRemoteViews)
  {
    paramRemoteViews.setViewVisibility(R.id.title, 8);
    paramRemoteViews.setViewVisibility(R.id.text2, 8);
    paramRemoteViews.setViewVisibility(R.id.text, 8);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void addCompatExtras(Bundle paramBundle) {}
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor) {}
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews applyStandardTemplate(boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    Resources localResources = this.mBuilder.mContext.getResources();
    RemoteViews localRemoteViews = new RemoteViews(this.mBuilder.mContext.getPackageName(), paramInt);
    label91:
    int i;
    label133:
    Object localObject;
    if (this.mBuilder.getPriority() < -1)
    {
      paramInt = 1;
      if ((Build.VERSION.SDK_INT >= 16) && (Build.VERSION.SDK_INT < 21))
      {
        if (paramInt == 0) {
          break label585;
        }
        localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg_low);
        localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_low_bg);
      }
      if (this.mBuilder.mLargeIcon == null) {
        break label653;
      }
      if (Build.VERSION.SDK_INT < 16) {
        break label614;
      }
      localRemoteViews.setViewVisibility(R.id.icon, 0);
      localRemoteViews.setImageViewBitmap(R.id.icon, this.mBuilder.mLargeIcon);
      if ((paramBoolean1) && (this.mBuilder.mNotification.icon != 0))
      {
        paramInt = localResources.getDimensionPixelSize(R.dimen.notification_right_icon_size);
        i = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_background_padding);
        if (Build.VERSION.SDK_INT < 21) {
          break label627;
        }
        localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt, paramInt - i * 2, this.mBuilder.getColor());
        localRemoteViews.setImageViewBitmap(R.id.right_icon, (Bitmap)localObject);
        label217:
        localRemoteViews.setViewVisibility(R.id.right_icon, 0);
      }
      label226:
      if (this.mBuilder.mContentTitle != null) {
        localRemoteViews.setTextViewText(R.id.title, this.mBuilder.mContentTitle);
      }
      if (this.mBuilder.mContentText == null) {
        break label963;
      }
      localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mContentText);
    }
    label299:
    label951:
    label957:
    label963:
    for (paramInt = 1;; paramInt = 0)
    {
      label338:
      int j;
      if ((Build.VERSION.SDK_INT < 21) && (this.mBuilder.mLargeIcon != null))
      {
        i = 1;
        if (this.mBuilder.mContentInfo == null) {
          break label790;
        }
        localRemoteViews.setTextViewText(R.id.info, this.mBuilder.mContentInfo);
        localRemoteViews.setViewVisibility(R.id.info, 0);
        paramInt = 1;
        i = 1;
        if ((this.mBuilder.mSubText == null) || (Build.VERSION.SDK_INT < 16)) {
          break label915;
        }
        localRemoteViews.setTextViewText(R.id.text, this.mBuilder.mSubText);
        if (this.mBuilder.mContentText == null) {
          break label905;
        }
        localRemoteViews.setTextViewText(R.id.text2, this.mBuilder.mContentText);
        localRemoteViews.setViewVisibility(R.id.text2, 0);
        j = 1;
        if ((j != 0) && (Build.VERSION.SDK_INT >= 16))
        {
          if (paramBoolean2)
          {
            float f = localResources.getDimensionPixelSize(R.dimen.notification_subtext_size);
            localRemoteViews.setTextViewTextSize(R.id.text, 0, f);
          }
          localRemoteViews.setViewPadding(R.id.line1, 0, 0, 0, 0);
        }
        if (this.mBuilder.getWhenIfShowing() != 0L)
        {
          if ((!this.mBuilder.mUseChronometer) || (Build.VERSION.SDK_INT < 16)) {
            break label921;
          }
          localRemoteViews.setViewVisibility(R.id.chronometer, 0);
          localRemoteViews.setLong(R.id.chronometer, "setBase", this.mBuilder.getWhenIfShowing() + (SystemClock.elapsedRealtime() - System.currentTimeMillis()));
          localRemoteViews.setBoolean(R.id.chronometer, "setStarted", true);
          paramInt = 1;
        }
        j = R.id.right_side;
        if (paramInt == 0) {
          break label951;
        }
        paramInt = 0;
        localRemoteViews.setViewVisibility(j, paramInt);
        j = R.id.line3;
        if (i == 0) {
          break label957;
        }
      }
      for (paramInt = 0;; paramInt = 8)
      {
        localRemoteViews.setViewVisibility(j, paramInt);
        return localRemoteViews;
        paramInt = 0;
        break;
        label585:
        localRemoteViews.setInt(R.id.notification_background, "setBackgroundResource", R.drawable.notification_bg);
        localRemoteViews.setInt(R.id.icon, "setBackgroundResource", R.drawable.notification_template_icon_bg);
        break label91;
        label614:
        localRemoteViews.setViewVisibility(R.id.icon, 8);
        break label133;
        label627:
        localRemoteViews.setImageViewBitmap(R.id.right_icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        break label217;
        if ((!paramBoolean1) || (this.mBuilder.mNotification.icon == 0)) {
          break label226;
        }
        localRemoteViews.setViewVisibility(R.id.icon, 0);
        if (Build.VERSION.SDK_INT >= 21)
        {
          paramInt = localResources.getDimensionPixelSize(R.dimen.notification_large_icon_width);
          i = localResources.getDimensionPixelSize(R.dimen.notification_big_circle_margin);
          j = localResources.getDimensionPixelSize(R.dimen.notification_small_icon_size_as_large);
          localObject = createIconWithBackground(this.mBuilder.mNotification.icon, paramInt - i, j, this.mBuilder.getColor());
          localRemoteViews.setImageViewBitmap(R.id.icon, (Bitmap)localObject);
          break label226;
        }
        localRemoteViews.setImageViewBitmap(R.id.icon, createColoredBitmap(this.mBuilder.mNotification.icon, -1));
        break label226;
        i = 0;
        break label299;
        if (this.mBuilder.mNumber > 0)
        {
          paramInt = localResources.getInteger(R.integer.status_bar_notification_info_maxnum);
          if (this.mBuilder.mNumber > paramInt) {
            localRemoteViews.setTextViewText(R.id.info, localResources.getString(R.string.status_bar_notification_info_overflow));
          }
          for (;;)
          {
            localRemoteViews.setViewVisibility(R.id.info, 0);
            paramInt = 1;
            i = 1;
            break;
            localObject = NumberFormat.getIntegerInstance();
            localRemoteViews.setTextViewText(R.id.info, ((NumberFormat)localObject).format(this.mBuilder.mNumber));
          }
        }
        localRemoteViews.setViewVisibility(R.id.info, 8);
        j = paramInt;
        paramInt = i;
        i = j;
        break label338;
        localRemoteViews.setViewVisibility(R.id.text2, 8);
        j = 0;
        break label408;
        localRemoteViews.setViewVisibility(R.id.time, 0);
        localRemoteViews.setLong(R.id.time, "setTime", this.mBuilder.getWhenIfShowing());
        break label536;
        paramInt = 8;
        break label549;
      }
    }
  }
  
  public Notification build()
  {
    Notification localNotification = null;
    if (this.mBuilder != null) {
      localNotification = this.mBuilder.build();
    }
    return localNotification;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void buildIntoRemoteViews(RemoteViews paramRemoteViews1, RemoteViews paramRemoteViews2)
  {
    hideNormalContent(paramRemoteViews1);
    paramRemoteViews1.removeAllViews(R.id.notification_main_column);
    paramRemoteViews1.addView(R.id.notification_main_column, paramRemoteViews2.clone());
    paramRemoteViews1.setViewVisibility(R.id.notification_main_column, 0);
    if (Build.VERSION.SDK_INT >= 21) {
      paramRemoteViews1.setViewPadding(R.id.notification_main_column_container, 0, calculateTopPadding(), 0, 0);
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public Bitmap createColoredBitmap(int paramInt1, int paramInt2)
  {
    return createColoredBitmap(paramInt1, paramInt2, 0);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    return null;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    return null;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    return null;
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  protected void restoreFromCompatExtras(Bundle paramBundle) {}
  
  public void setBuilder(NotificationCompat.Builder paramBuilder)
  {
    if (this.mBuilder != paramBuilder)
    {
      this.mBuilder = paramBuilder;
      if (this.mBuilder != null) {
        this.mBuilder.setStyle(this);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.Style
 * JD-Core Version:    0.7.0.1
 */