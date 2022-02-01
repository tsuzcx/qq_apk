package com.tencent.qqmail.utilities.keyboardhelper;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.reflect.Method;

public class KeyBoardHelper
{
  private static final String KEY_KEYBOARD_HEIGHT = "keyboardHeight";
  private static final String KEY_KEYBOARD_HEIGHT_LANDSCAPE = "keyboardHeight_landscape";
  private static final int NONE_FLAGS = -1;
  
  public static int getKeyboardHeight()
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    SharedPreferences localSharedPreferences = localQMApplicationContext.getSharedPreferences("user_info", 0);
    if (localQMApplicationContext.getResources().getConfiguration().orientation == 2) {
      return localSharedPreferences.getInt("keyboardHeight_landscape", 0);
    }
    return localSharedPreferences.getInt("keyboardHeight", 0);
  }
  
  public static boolean hasSoftMenu()
  {
    ViewConfiguration localViewConfiguration = ViewConfiguration.get(QMApplicationContext.sharedInstance());
    try
    {
      boolean bool = ((Boolean)ViewConfiguration.class.getMethod("hasPermanentMenuKey", new Class[0]).invoke(localViewConfiguration, new Object[0])).booleanValue();
      return !bool;
    }
    catch (Exception localException) {}
    return false;
  }
  
  public static void hideKeyBoard(View paramView)
  {
    ((InputMethodManager)QMApplicationContext.sharedInstance().getSystemService("input_method")).hideSoftInputFromWindow(paramView.getWindowToken(), 0);
  }
  
  public static void saveKeyBoardHeight(int paramInt)
  {
    QMApplicationContext localQMApplicationContext = QMApplicationContext.sharedInstance();
    SharedPreferences.Editor localEditor = localQMApplicationContext.getSharedPreferences("user_info", 0).edit();
    if (localQMApplicationContext.getResources().getConfiguration().orientation == 2) {
      localEditor.putInt("keyboardHeight_landscape", paramInt);
    }
    for (;;)
    {
      localEditor.commit();
      return;
      localEditor.putInt("keyboardHeight", paramInt);
    }
  }
  
  public static void showKeyBoard(int paramInt1, int paramInt2)
  {
    showKeyBoard(null, -1, paramInt1, paramInt2);
  }
  
  public static void showKeyBoard(View paramView, int paramInt)
  {
    showKeyBoard(paramView, paramInt, 0, 0);
  }
  
  public static void showKeyBoard(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    InputMethodManager localInputMethodManager = (InputMethodManager)QMApplicationContext.sharedInstance().getApplicationContext().getSystemService("input_method");
    if (paramView != null)
    {
      if (!paramView.hasFocus())
      {
        paramView.setFocusableInTouchMode(true);
        paramView.requestFocus();
      }
      localInputMethodManager.showSoftInput(paramView, paramInt1);
      return;
    }
    localInputMethodManager.toggleSoftInput(paramInt2, paramInt3);
  }
  
  public static void showSoftInputDelay(EditText paramEditText, long paramLong)
  {
    Threads.runOnMainThread(new KeyBoardHelper.1(paramEditText), paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.keyboardhelper.KeyBoardHelper
 * JD-Core Version:    0.7.0.1
 */