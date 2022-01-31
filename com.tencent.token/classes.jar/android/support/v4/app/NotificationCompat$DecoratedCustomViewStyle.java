package android.support.v4.app;

import android.app.Notification.Builder;
import android.app.Notification.DecoratedCustomViewStyle;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.RestrictTo;
import android.support.compat.R.color;
import android.support.compat.R.id;
import android.support.compat.R.layout;
import android.widget.RemoteViews;
import java.util.ArrayList;

public class NotificationCompat$DecoratedCustomViewStyle
  extends NotificationCompat.Style
{
  private static final int MAX_ACTION_BUTTONS = 3;
  
  private RemoteViews createRemoteViews(RemoteViews paramRemoteViews, boolean paramBoolean)
  {
    RemoteViews localRemoteViews1 = applyStandardTemplate(true, R.layout.notification_template_custom_big, false);
    localRemoteViews1.removeAllViews(R.id.actions);
    if ((paramBoolean) && (this.mBuilder.mActions != null))
    {
      int j = Math.min(this.mBuilder.mActions.size(), 3);
      if (j > 0)
      {
        i = 0;
        while (i < j)
        {
          RemoteViews localRemoteViews2 = generateActionButton((NotificationCompat.Action)this.mBuilder.mActions.get(i));
          localRemoteViews1.addView(R.id.actions, localRemoteViews2);
          i += 1;
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0) {}
      for (i = 0;; i = 8)
      {
        localRemoteViews1.setViewVisibility(R.id.actions, i);
        localRemoteViews1.setViewVisibility(R.id.action_divider, i);
        buildIntoRemoteViews(localRemoteViews1, paramRemoteViews);
        return localRemoteViews1;
      }
    }
  }
  
  private RemoteViews generateActionButton(NotificationCompat.Action paramAction)
  {
    int i;
    Object localObject;
    if (paramAction.actionIntent == null)
    {
      i = 1;
      localObject = this.mBuilder.mContext.getPackageName();
      if (i == 0) {
        break label129;
      }
    }
    label129:
    for (int j = R.layout.notification_action_tombstone;; j = R.layout.notification_action)
    {
      localObject = new RemoteViews((String)localObject, j);
      ((RemoteViews)localObject).setImageViewBitmap(R.id.action_image, createColoredBitmap(paramAction.getIcon(), this.mBuilder.mContext.getResources().getColor(R.color.notification_action_color_filter)));
      ((RemoteViews)localObject).setTextViewText(R.id.action_text, paramAction.title);
      if (i == 0) {
        ((RemoteViews)localObject).setOnClickPendingIntent(R.id.action_container, paramAction.actionIntent);
      }
      if (Build.VERSION.SDK_INT >= 15) {
        ((RemoteViews)localObject).setContentDescription(R.id.action_container, paramAction.title);
      }
      return localObject;
      i = 0;
      break;
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public void apply(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {
      paramNotificationBuilderWithBuilderAccessor.getBuilder().setStyle(new Notification.DecoratedCustomViewStyle());
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews makeBigContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (;;)
    {
      return null;
      paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getBigContentView();
      if (paramNotificationBuilderWithBuilderAccessor != null) {}
      while (paramNotificationBuilderWithBuilderAccessor != null)
      {
        return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
        paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView();
      }
    }
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews makeContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    while (this.mBuilder.getContentView() == null) {
      return null;
    }
    return createRemoteViews(this.mBuilder.getContentView(), false);
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public RemoteViews makeHeadsUpContentView(NotificationBuilderWithBuilderAccessor paramNotificationBuilderWithBuilderAccessor)
  {
    if (Build.VERSION.SDK_INT >= 24) {}
    for (;;)
    {
      return null;
      RemoteViews localRemoteViews = this.mBuilder.getHeadsUpContentView();
      if (localRemoteViews != null) {}
      for (paramNotificationBuilderWithBuilderAccessor = localRemoteViews; localRemoteViews != null; paramNotificationBuilderWithBuilderAccessor = this.mBuilder.getContentView()) {
        return createRemoteViews(paramNotificationBuilderWithBuilderAccessor, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.NotificationCompat.DecoratedCustomViewStyle
 * JD-Core Version:    0.7.0.1
 */