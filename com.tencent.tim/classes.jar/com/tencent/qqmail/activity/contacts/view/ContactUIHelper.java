package com.tencent.qqmail.activity.contacts.view;

import android.os.Build.VERSION;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.widget.ListView;
import com.tencent.qqmail.maillist.view.MailListItemView;
import com.tencent.qqmail.model.contact.cursor.ContactBaseListCursor;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.utilities.log.QMLog;

public class ContactUIHelper
{
  private static String TAG = "ContactUIHelper";
  private static int duration = 200;
  private static int height = 0;
  private static int lastIndex;
  private static int[] lastPosition;
  private static int lastTop = -1;
  
  static
  {
    lastIndex = -1;
    lastPosition = null;
  }
  
  public static void restoreAndClearPosition(int paramInt1, int paramInt2, ListView paramListView)
  {
    if ((lastPosition != null) && (paramListView != null))
    {
      if ((lastPosition[2] == paramInt1) && (lastPosition[3] == paramInt2))
      {
        lastIndex = lastPosition[0];
        lastTop = lastPosition[1];
        restorePostion(paramListView);
      }
      lastPosition = null;
    }
  }
  
  private static void restorePostion(ListView paramListView)
  {
    if ((lastIndex > -1) && (paramListView != null))
    {
      paramListView.setSelectionFromTop(lastIndex, lastTop);
      lastTop = -1;
      lastIndex = -1;
    }
  }
  
  private static void savePosition(ListView paramListView)
  {
    int i = 0;
    if (paramListView != null)
    {
      lastIndex = paramListView.getFirstVisiblePosition();
      paramListView = paramListView.getChildAt(0);
      if (paramListView != null) {
        break label28;
      }
    }
    for (;;)
    {
      lastTop = i;
      return;
      label28:
      i = paramListView.getTop();
    }
  }
  
  public static void scrollTopNewContact(ListView paramListView, ContactBaseListCursor paramContactBaseListCursor, long paramLong)
  {
    if ((paramListView != null) && (paramContactBaseListCursor != null)) {}
    for (;;)
    {
      try
      {
        int j = paramContactBaseListCursor.getCount();
        if (j > 0)
        {
          i = 0;
          if (i < j)
          {
            MailContact localMailContact = paramContactBaseListCursor.getItem(i);
            if ((localMailContact != null) && (localMailContact.getId() == paramLong))
            {
              j = i;
              if (i >= 0)
              {
                j = i;
                if (i < paramContactBaseListCursor.getCount()) {
                  j = i + paramListView.getHeaderViewsCount();
                }
              }
              QMLog.log(4, TAG, "newPos:" + j + " newContactId:" + paramLong);
              if ((j >= 0) && (j < paramContactBaseListCursor.getCount())) {
                paramListView.post(new ContactUIHelper.1(paramListView, j));
              }
              return;
            }
            i += 1;
            continue;
          }
        }
        int i = -1;
      }
      catch (Exception paramListView)
      {
        QMLog.log(6, TAG, Log.getStackTraceString(paramListView));
        return;
      }
    }
  }
  
  public static void smoothScrollToTop(ListView paramListView)
  {
    if (Build.VERSION.SDK_INT >= 8)
    {
      int i = paramListView.getFirstVisiblePosition();
      int j = MailListItemView.VIEW_HEIGHT;
      float f = paramListView.getHeight() * 1.5F;
      int k = Math.round(f / MailListItemView.VIEW_HEIGHT);
      if (i * j > f) {
        paramListView.setSelectionFromTop(k, 0);
      }
      paramListView.smoothScrollToPosition(0);
      return;
    }
    paramListView.setSelectionFromTop(0, 0);
  }
  
  public static void startAddItemAnimation(View paramView, Runnable paramRunnable)
  {
    if (paramView == null) {
      return;
    }
    height = 0;
    paramView.getViewTreeObserver().addOnPreDrawListener(new ContactUIHelper.2(paramView));
    ContactUIHelper.3 local3 = new ContactUIHelper.3(paramView);
    local3.setDuration(duration);
    local3.setAnimationListener(new ContactUIHelper.4(paramRunnable));
    paramView.startAnimation(local3);
  }
  
  public static void startRemoveItemAnimation(View paramView, Runnable paramRunnable)
  {
    if (paramView == null) {
      return;
    }
    ContactUIHelper.5 local5 = new ContactUIHelper.5(paramView.getMeasuredHeight(), paramView);
    local5.setDuration(duration);
    local5.setAnimationListener(new ContactUIHelper.6(paramRunnable));
    paramView.startAnimation(local5);
  }
  
  public static void storePostion(int paramInt1, int paramInt2, ListView paramListView)
  {
    savePosition(paramListView);
    lastPosition = new int[] { lastIndex, lastTop, paramInt1, paramInt2 };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.contacts.view.ContactUIHelper
 * JD-Core Version:    0.7.0.1
 */