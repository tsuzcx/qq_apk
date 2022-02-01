package com.tencent.qqmail.utilities.ui;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.Notification.Builder;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ZoomButtonsController;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.calendar.data.QMCalendarFolder;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;

public class QMUIHelper
{
  private static final String TAG = QMUIHelper.class.getSimpleName();
  private static final int[] calendarColorName = { 2131691062, 2131691060, 2131691063, 2131691059, 2131691057, 2131691061, 2131691058 };
  private static final int[] calendarColorResources;
  private static final int[] colorResources;
  private static final HashSet<Integer> sNotificationId = new HashSet();
  private static final Rect sTempRect = new Rect();
  
  static
  {
    colorResources = new int[] { 2131165994, 2131165995, 2131166006, 2131166017, 2131166024, 2131166025, 2131166026, 2131166027, 2131166028, 2131166029, 2131165996, 2131165997, 2131165998, 2131165999, 2131166000, 2131166001, 2131166002, 2131166003, 2131166004, 2131166005, 2131166007, 2131166008, 2131166009, 2131166010, 2131166011, 2131166012, 2131166013, 2131166014, 2131166015, 2131166016, 2131166018, 2131166019, 2131166020, 2131166021, 2131166022, 2131166023 };
    calendarColorResources = new int[] { 2131165512, 2131165510, 2131165513, 2131165496, 2131165494, 2131165511, 2131165495 };
  }
  
  public static void cancelNotification(int paramInt)
  {
    sNotificationId.remove(Integer.valueOf(paramInt));
    ((NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification")).cancel(paramInt);
  }
  
  public static void drawDivider(boolean paramBoolean1, boolean paramBoolean2, Canvas paramCanvas, Paint paramPaint)
  {
    drawDivider(paramBoolean1, paramBoolean2, paramCanvas, paramPaint, 0, 0);
  }
  
  public static void drawDivider(boolean paramBoolean1, boolean paramBoolean2, Canvas paramCanvas, Paint paramPaint, int paramInt1, int paramInt2)
  {
    int i = paramCanvas.getHeight();
    int j = paramCanvas.getWidth();
    if (paramBoolean1)
    {
      sTempRect.set(paramInt1, 0, j, (int)paramPaint.getStrokeWidth());
      paramCanvas.drawRect(sTempRect, paramPaint);
    }
    if (paramBoolean2)
    {
      sTempRect.set(paramInt2, (int)(i - paramPaint.getStrokeWidth()), j, i);
      paramCanvas.drawRect(sTempRect, paramPaint);
    }
  }
  
  public static int getCalendarColor(Context paramContext, QMCalendarFolder paramQMCalendarFolder)
  {
    if (paramQMCalendarFolder == null) {
      return getCalendarColorByIndex(paramContext, 0);
    }
    if (paramQMCalendarFolder.getCategory() == 1)
    {
      if ((paramQMCalendarFolder.getColor() >= 0) && (paramQMCalendarFolder.getColor() < getCalendarColorCount())) {
        return getCalendarColorByIndex(paramContext, paramQMCalendarFolder.getColor());
      }
      return paramQMCalendarFolder.getColor();
    }
    return getCalendarColorByIndex(paramContext, paramQMCalendarFolder.getColor());
  }
  
  public static int getCalendarColorByIndex(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QMLog.log(5, TAG, "colorIndex:" + paramInt + ", stack:" + QMLog.getStackTrace(10));
      i = 0;
    }
    return paramContext.getResources().getColor(calendarColorResources[getCalendarColorIndex(i)]);
  }
  
  public static int getCalendarColorCount()
  {
    return calendarColorResources.length;
  }
  
  public static int getCalendarColorIndex(int paramInt)
  {
    return paramInt % getCalendarColorCount();
  }
  
  public static String getCalendarColorName(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt < 0)
    {
      QMLog.log(5, TAG, "colorIndex:" + paramInt + ", stack:" + QMLog.getStackTrace(10));
      i = 0;
    }
    return paramContext.getResources().getString(calendarColorName[getCalendarColorIndex(i)]);
  }
  
  public static int getDrawableByDomain(String paramString)
  {
    if (paramString.contains("gmail")) {
      return 2130840962;
    }
    if (paramString.contains("163")) {
      return 2130840956;
    }
    if (paramString.contains("263")) {
      return 2130840958;
    }
    if (paramString.contains("126")) {
      return 2130840955;
    }
    if (paramString.contains("sina")) {
      return 2130840966;
    }
    if ((paramString.contains("yahoo")) || (paramString.contains("ymail"))) {
      return 2130840968;
    }
    if (paramString.contains("21cn")) {
      return 2130840957;
    }
    if (paramString.contains("foxmail")) {
      return 2130840961;
    }
    if ((paramString.contains("qq")) || (paramString.contains("rdgz")) || (paramString.contains("tencent"))) {
      return 2130840965;
    }
    if (paramString.contains("sohu")) {
      return 2130840967;
    }
    if ((paramString.contains("outlook")) || (paramString.contains("msn")) || (paramString.contains("live")) || (paramString.contains("hotmail"))) {
      return 2130840964;
    }
    if (paramString.contains("netease")) {
      return 2130840963;
    }
    return 2130840959;
  }
  
  public static int getDrawableByFolder(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    case -21: 
    case -17: 
    case -15: 
    case -8: 
    case -7: 
    case -6: 
    default: 
      if (paramInt2 != 140) {
        break;
      }
    case -20: 
      return 2130841295;
    case -4: 
      return 2130841296;
    case -3: 
      return 2130841294;
    case -5: 
      return 2130841291;
    case -1: 
      return 2130841292;
    case -14: 
      return 2130841302;
    case -19: 
      return 2130841280;
    case -11: 
      return 2130841282;
    case -13: 
      return 2130841283;
    case -12: 
      return 2130841281;
    case -2: 
      return 2130841284;
    case -9: 
      return 2130841285;
    case -10: 
      return 2130841298;
    case -16: 
      return 2130841286;
    case -18: 
      return 2130841287;
    case -22: 
      return 2130841279;
    case -23: 
      return 2130841288;
    }
    if (paramInt2 == 130) {
      return 2130841297;
    }
    return 2130841290;
  }
  
  public static int getMailTagColorByColorId(Context paramContext, String paramString)
  {
    try
    {
      i = Integer.valueOf(paramString).intValue();
      int j;
      if (i >= 0)
      {
        j = i;
        if (i < colorResources.length) {}
      }
      else
      {
        j = 0;
      }
      return paramContext.getResources().getColor(colorResources[j]);
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(5, TAG, "MailTag colorId is not an int: " + paramString + ", use 0 for default.");
        int i = 0;
      }
    }
  }
  
  public static int[] getWindowSize(Activity paramActivity)
  {
    paramActivity = paramActivity.getWindowManager().getDefaultDisplay();
    int[] arrayOfInt = new int[2];
    int[] tmp15_14 = arrayOfInt;
    tmp15_14[0] = 480;
    int[] tmp21_15 = tmp15_14;
    tmp21_15[1] = 800;
    tmp21_15;
    arrayOfInt[0] = paramActivity.getWidth();
    arrayOfInt[1] = paramActivity.getHeight();
    return arrayOfInt;
  }
  
  public static void notifyNotification(int paramInt, Notification paramNotification)
  {
    sNotificationId.add(Integer.valueOf(paramInt));
    ((NotificationManager)QMApplicationContext.sharedInstance().getSystemService("notification")).notify(paramInt, paramNotification);
  }
  
  public static void qqmailNotice(Activity paramActivity, String paramString, int paramInt1, int paramInt2)
  {
    if (QMNetworkUtils.isNetworkConnected(paramActivity))
    {
      Object localObject = new Intent(paramActivity, paramActivity.getClass());
      ((Intent)localObject).setFlags(536870912);
      localObject = PendingIntent.getActivity(paramActivity, 0, (Intent)localObject, 0);
      paramActivity = new Notification.Builder(paramActivity).setTicker(paramString).setSmallIcon(QMAppInterface.sharedInstance().getNtId()).setContentTitle(paramActivity.getString(2131696461)).setContentText(paramString).setContentIntent((PendingIntent)localObject).build();
      paramActivity.flags = 8;
      if (paramInt1 == 0) {
        paramActivity.icon = 2130850519;
      }
      for (;;)
      {
        notifyNotification(paramInt2, paramActivity);
        return;
        if (paramInt1 == 1) {
          paramActivity.icon = 2130840992;
        } else {
          paramActivity.icon = 2130841014;
        }
      }
    }
    Threads.runOnMainThread(new QMUIHelper.1());
  }
  
  public static void recycleBitmap(Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (!paramBitmap.isRecycled())) {
      paramBitmap.recycle();
    }
  }
  
  @SuppressLint({"NewApi"})
  public static View setBackground(View paramView, Drawable paramDrawable)
  {
    int[] arrayOfInt;
    if (paramView != null)
    {
      arrayOfInt = new int[4];
      arrayOfInt[0] = paramView.getPaddingLeft();
      arrayOfInt[1] = paramView.getPaddingTop();
      arrayOfInt[2] = paramView.getPaddingRight();
      arrayOfInt[3] = paramView.getPaddingBottom();
      if (Build.VERSION.SDK_INT >= 16) {
        break label67;
      }
      paramView.setBackgroundDrawable(paramDrawable);
    }
    for (;;)
    {
      paramView.setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
      return paramView;
      label67:
      paramView.setBackground(paramDrawable);
    }
  }
  
  public static View setBackgroundResource(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      int[] arrayOfInt = new int[4];
      arrayOfInt[0] = paramView.getPaddingLeft();
      arrayOfInt[1] = paramView.getPaddingTop();
      arrayOfInt[2] = paramView.getPaddingRight();
      arrayOfInt[3] = paramView.getPaddingBottom();
      paramView.setBackgroundResource(paramInt);
      paramView.setPadding(arrayOfInt[0], arrayOfInt[1], arrayOfInt[2], arrayOfInt[3]);
    }
    return paramView;
  }
  
  @SuppressLint({"NewApi"})
  public static View setBackgroundWithNoPadding(View paramView, Drawable paramDrawable)
  {
    if (paramView != null)
    {
      if (Build.VERSION.SDK_INT < 16) {
        paramView.setBackgroundDrawable(paramDrawable);
      }
    }
    else {
      return paramView;
    }
    paramView.setBackground(paramDrawable);
    return paramView;
  }
  
  public static void setFocusable(View paramView, boolean paramBoolean1, boolean paramBoolean2, View... paramVarArgs)
  {
    if ((paramView != null) && (paramBoolean1))
    {
      paramView.setFocusable(true);
      paramView.setFocusableInTouchMode(true);
      if (paramBoolean2)
      {
        paramView.requestFocus();
        if ((paramView instanceof EditText))
        {
          EditText localEditText = (EditText)paramView;
          localEditText.setSelection(localEditText.getText().toString().length());
        }
        if ((paramView instanceof EditText)) {
          KeyBoardHelper.showSoftInputDelay((EditText)paramView, 100L);
        }
      }
    }
    int i = 0;
    if (i < paramVarArgs.length)
    {
      if (paramVarArgs[i] != null)
      {
        if (!paramBoolean1) {
          break label127;
        }
        if (paramVarArgs[i] != paramView)
        {
          paramVarArgs[i].setFocusableInTouchMode(true);
          paramVarArgs[i].setFocusable(true);
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label127:
        paramVarArgs[i].setFocusableInTouchMode(false);
        paramVarArgs[i].setFocusable(false);
      }
    }
  }
  
  public static void setMailTagColor(Context paramContext, View paramView, String paramString)
  {
    float f = paramContext.getResources().getDimensionPixelSize(2131297650);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new RoundRectShape(new float[] { f, f, f, f, f, f, f, f }, null, null));
    localShapeDrawable.getPaint().setColor(getMailTagColorByColorId(paramContext, paramString));
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    paramView.setBackgroundDrawable(localShapeDrawable);
  }
  
  public static void setViewEnable(boolean paramBoolean, View... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramVarArgs.length)
      {
        if (paramVarArgs[i] != null) {
          paramVarArgs[i].setEnabled(paramBoolean);
        }
        i += 1;
      }
    }
  }
  
  @TargetApi(11)
  public static void setZoomControlGone(WebView paramWebView)
  {
    if ((Build.BRAND.contains("vivo")) && (Build.VERSION.SDK_INT < 11)) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 11) {
      paramWebView.getSettings().setDisplayZoomControls(false);
    }
    try
    {
      Field localField = WebView.class.getDeclaredField("mZoomButtonsController");
      localField.setAccessible(true);
      ZoomButtonsController localZoomButtonsController = new ZoomButtonsController(paramWebView);
      localZoomButtonsController.getZoomControls().setVisibility(8);
      return;
    }
    catch (SecurityException paramWebView)
    {
      try
      {
        localField.set(paramWebView, localZoomButtonsController);
        return;
      }
      catch (IllegalArgumentException paramWebView)
      {
        paramWebView.printStackTrace();
        return;
        paramWebView = paramWebView;
        paramWebView.printStackTrace();
        return;
      }
      catch (IllegalAccessException paramWebView)
      {
        paramWebView.printStackTrace();
        return;
      }
    }
    catch (NoSuchFieldException paramWebView)
    {
      paramWebView.printStackTrace();
    }
  }
  
  public static QMUIDialog showQMDialog(Context paramContext, String paramString1, String paramString2, Runnable paramRunnable)
  {
    return showQMDialog(paramContext, paramContext.getString(2131696547), paramString1, paramString2, paramRunnable);
  }
  
  public static QMUIDialog showQMDialog(Context paramContext, String paramString1, String paramString2, String paramString3, Runnable paramRunnable)
  {
    paramContext = new QMUIDialog.MessageDialogBuilder(paramContext);
    if (paramString2 != null) {
      paramContext.setTitle(paramString2);
    }
    if (paramString3 != null) {
      paramContext.setMessage(paramString3);
    }
    paramContext = ((QMUIDialog.MessageDialogBuilder)paramContext.addAction(paramString1, new QMUIHelper.2(paramRunnable))).create();
    paramContext.setCanceledOnTouchOutside(false);
    paramContext.show();
    return paramContext;
  }
  
  public static void showToast(Context paramContext, int paramInt, String paramString)
  {
    try
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), paramContext.getResources().getString(paramInt) + paramString, 0).show();
      return;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public static boolean triggerFilteringForAutoCompleteTextView(AutoCompleteTextView paramAutoCompleteTextView)
  {
    try
    {
      Method localMethod = AutoCompleteTextView.class.getDeclaredMethod("doBeforeTextChanged", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
      localMethod = AutoCompleteTextView.class.getDeclaredMethod("doAfterTextChanged", new Class[0]);
      localMethod.setAccessible(true);
      localMethod.invoke(paramAutoCompleteTextView, new Object[0]);
      return true;
    }
    catch (NoSuchMethodException paramAutoCompleteTextView)
    {
      QMLog.log(6, "searchcontact", "error" + paramAutoCompleteTextView.getMessage());
      return false;
    }
    catch (IllegalArgumentException paramAutoCompleteTextView)
    {
      QMLog.log(6, "searchcontact", "error" + paramAutoCompleteTextView.getMessage());
      return false;
    }
    catch (IllegalAccessException paramAutoCompleteTextView)
    {
      QMLog.log(6, "searchcontact", "error" + paramAutoCompleteTextView.getMessage());
      return false;
    }
    catch (InvocationTargetException paramAutoCompleteTextView)
    {
      QMLog.log(6, "searchcontact", "error" + paramAutoCompleteTextView.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMUIHelper
 * JD-Core Version:    0.7.0.1
 */