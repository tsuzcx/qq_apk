package com.tencent.qqmail.notificationshortcut;

import android.app.Notification;
import android.app.Notification.Builder;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RemoteViews;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NotificationColorUtils
{
  private static final int INVALID_COLOR = -1;
  private static final String NOTIFICATION_TITLE = "notification_title";
  private static int notificationTitleColor = -1;
  
  private static int findMaxTextSizeIndex(List<TextView> paramList)
  {
    paramList = paramList.iterator();
    float f1 = -2.147484E+009F;
    int j = -2147483648;
    int i = 0;
    while (paramList.hasNext())
    {
      TextView localTextView = (TextView)paramList.next();
      float f2 = f1;
      if (f1 < localTextView.getTextSize())
      {
        f2 = localTextView.getTextSize();
        j = i;
      }
      i += 1;
      f1 = f2;
    }
    return j;
  }
  
  private static List<TextView> getAllTextViews(View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    iteratorView(paramView, new NotificationColorUtils.2(localArrayList));
    return localArrayList;
  }
  
  public static int getNotificationColor(Context paramContext)
  {
    try
    {
      if (notificationTitleColor == -1) {
        notificationTitleColor = getNotificationColorInternal(paramContext);
      }
      label14:
      return notificationTitleColor;
    }
    catch (Exception paramContext)
    {
      break label14;
    }
  }
  
  private static int getNotificationColorCompat(Context paramContext)
  {
    try
    {
      int i = new Notification.Builder(paramContext).build().contentView.getLayoutId();
      paramContext = (ViewGroup)LayoutInflater.from(paramContext).inflate(i, null);
      TextView localTextView = (TextView)paramContext.findViewById(16908310);
      if (localTextView == null) {
        return getTitleColorIteratorCompat(paramContext);
      }
      i = localTextView.getCurrentTextColor();
      return i;
    }
    catch (Exception paramContext) {}
    return -1;
  }
  
  private static int getNotificationColorInternal(Context paramContext)
  {
    Object localObject = new Notification.Builder(paramContext);
    ((Notification.Builder)localObject).setContentTitle("notification_title");
    localObject = ((Notification.Builder)localObject).build();
    try
    {
      localObject = (ViewGroup)((Notification)localObject).contentView.apply(paramContext, new FrameLayout(paramContext));
      TextView localTextView = (TextView)((ViewGroup)localObject).findViewById(16908310);
      if (localTextView == null)
      {
        iteratorView((View)localObject, new NotificationColorUtils.1());
        return notificationTitleColor;
      }
      int i = localTextView.getCurrentTextColor();
      return i;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return getNotificationColorCompat(paramContext);
  }
  
  private static int getTitleColorIteratorCompat(View paramView)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return -1;
      paramView = getAllTextViews(paramView);
      i = findMaxTextSizeIndex(paramView);
    } while (i == -2147483648);
    return ((TextView)paramView.get(i)).getCurrentTextColor();
  }
  
  private static void iteratorView(View paramView, Filter paramFilter)
  {
    if ((paramView == null) || (paramFilter == null)) {}
    for (;;)
    {
      return;
      paramFilter.filter(paramView);
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i = 0;
        while (i < paramView.getChildCount())
        {
          iteratorView(paramView.getChildAt(i), paramFilter);
          i += 1;
        }
      }
    }
  }
  
  static abstract interface Filter
  {
    public abstract void filter(View paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.notificationshortcut.NotificationColorUtils
 * JD-Core Version:    0.7.0.1
 */