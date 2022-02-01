package com.tencent.qqmail.utilities.animation;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.animation.AccelerateDecelerateInterpolator;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.ui.PtrListView;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import com.tencent.qqmail.view.QMAdvertiseView;
import com.tencent.qqmail.view.QMBaseView;

public class AdvertiseAnimUtil
{
  public static final int ADVERTISE_ANIM_DURATION = 600;
  private static final String TAG = "AdvertiseAnimUtil";
  public static boolean advertiseViewForeground = false;
  public static boolean duringAnimation = false;
  
  public static void hideAdvertiseView(Activity paramActivity, QMBaseView paramQMBaseView, QMAdvertiseView paramQMAdvertiseView, PtrListView paramPtrListView)
  {
    boolean bool2 = true;
    if ((duringAnimation) || (paramQMAdvertiseView == null) || (paramPtrListView == null))
    {
      paramActivity = new StringBuilder().append("hideAdvertiseView: ").append(duringAnimation).append(", ");
      if (paramQMAdvertiseView == null)
      {
        bool1 = true;
        paramActivity = paramActivity.append(bool1).append(", ");
        if (paramPtrListView != null) {
          break label90;
        }
      }
      label90:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        QMLog.log(4, "AdvertiseAnimUtil", bool1);
        return;
        bool1 = false;
        break;
      }
    }
    DataCollector.logEvent("Event_Effect_Pull_Refresh_Webview_Hide");
    AnimUtil.animateViewAlphaToHide(paramQMAdvertiseView, 600, new AdvertiseAnimUtil.2(paramPtrListView, paramQMAdvertiseView, paramQMBaseView, paramActivity));
  }
  
  public static void showAdvertiseView(Activity paramActivity, QMAdvertiseView paramQMAdvertiseView, PtrListView paramPtrListView)
  {
    if ((duringAnimation) || (paramQMAdvertiseView == null) || (paramPtrListView == null)) {
      return;
    }
    DataCollector.logEvent("Event_Effect_Pull_Refresh_Webview_Show");
    paramQMAdvertiseView.setVisibility(0);
    int i = (int)(600.0F - (paramQMAdvertiseView.getContext().getResources().getDimension(2131299664) + paramPtrListView.getRefreshBarHeight()) / QMUIKit.getScreenHeight() * 600.0F);
    AnimUtil.animateViewTranslationY(paramQMAdvertiseView, -QMUIKit.getScreenHeight(), 0.0F, i, 0, new AccelerateDecelerateInterpolator(), new AdvertiseAnimUtil.1(paramPtrListView, paramQMAdvertiseView, paramActivity));
    paramPtrListView.dropDownListViewContent();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.animation.AdvertiseAnimUtil
 * JD-Core Version:    0.7.0.1
 */