package com.tencent.mobileqq.debug;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import ddc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

public class DebugMemoryMgr
{
  private static final byte jdField_a_of_type_Byte = 3;
  private static final long jdField_a_of_type_Long = 1048576L;
  private static DebugMemoryMgr jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr = null;
  private static final String jdField_a_of_type_JavaLangString = "Q.Memory.DebugMemoryMgr";
  private static ArrayList jdField_a_of_type_JavaUtilArrayList;
  public static List a;
  private static Map jdField_a_of_type_JavaUtilMap;
  private static final ConcurrentLinkedQueue jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue;
  public static boolean a = false;
  private static final byte jdField_b_of_type_Byte = 4;
  private static final long jdField_b_of_type_Long = 5242880L;
  private static boolean jdField_b_of_type_Boolean = false;
  private static final byte jdField_c_of_type_Byte = 5;
  private static long jdField_c_of_type_Long;
  
  static
  {
    b = false;
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue = new ConcurrentLinkedQueue();
    c = 0L;
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static DebugMemoryMgr a()
  {
    if (jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr == null) {}
    try
    {
      if (jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr == null) {
        jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr = new DebugMemoryMgr();
      }
      return jdField_a_of_type_ComTencentMobileqqDebugDebugMemoryMgr;
    }
    finally {}
  }
  
  public static String a()
  {
    try
    {
      String str = jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.toString();
      return str;
    }
    catch (Exception localException) {}
    return "";
  }
  
  public static ArrayList a()
  {
    ArrayList localArrayList = new ArrayList();
    if (jdField_a_of_type_JavaUtilMap != null)
    {
      Iterator localIterator = jdField_a_of_type_JavaUtilMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        ddc localddc = (ddc)((Map.Entry)localIterator.next()).getValue();
        if ((localddc != null) && (ddc.a(localddc) >= 5242880L)) {
          localArrayList.add(Pair.create(ddc.a(localddc), Long.valueOf(ddc.a(localddc))));
        }
      }
    }
    return localArrayList;
  }
  
  public static void a()
  {
    if ((jdField_a_of_type_Boolean) && (jdField_a_of_type_JavaUtilMap != null)) {
      jdField_a_of_type_JavaUtilMap.clear();
    }
  }
  
  public static void a(Activity paramActivity)
  {
    a((ViewGroup)paramActivity.getWindow().getDecorView().getRootView());
  }
  
  public static void a(View paramView)
  {
    if (paramView.getBackground() != null)
    {
      paramView.getBackground().setCallback(null);
      paramView.setBackgroundDrawable(null);
    }
    if ((paramView instanceof ViewGroup))
    {
      if (((paramView instanceof FrameLayout)) && (((FrameLayout)paramView).getForeground() != null)) {
        ((FrameLayout)paramView).setForeground(null);
      }
      int i = 0;
      while (i < ((ViewGroup)paramView).getChildCount())
      {
        a(((ViewGroup)paramView).getChildAt(i));
        i += 1;
      }
    }
    try
    {
      ((ViewGroup)paramView).removeAllViews();
      label90:
      if ((paramView instanceof ImageView))
      {
        ImageView localImageView = (ImageView)paramView;
        Drawable localDrawable = localImageView.getDrawable();
        if (localDrawable != null) {
          localDrawable.setCallback(null);
        }
        localImageView.setImageDrawable(null);
        localImageView.setImageBitmap(null);
      }
      if ((paramView instanceof TextView)) {
        ((TextView)paramView).setCompoundDrawables(null, null, null, null);
      }
      if ((paramView instanceof ProgressBar))
      {
        if (((ProgressBar)paramView).getProgressDrawable() != null) {
          ((ProgressBar)paramView).setProgressDrawable(null);
        }
        if (((ProgressBar)paramView).getIndeterminateDrawable() != null) {
          ((ProgressBar)paramView).setIndeterminateDrawable(null);
        }
      }
      paramView.destroyDrawingCache();
      return;
    }
    catch (IncompatibleClassChangeError paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.e("Q.Memory.DebugMemoryMgr", 2, "May cause dvmFindCatchBlock crash!");
      }
      throw ((IncompatibleClassChangeError)new IncompatibleClassChangeError("May cause dvmFindCatchBlock crash!").initCause(paramView));
    }
    catch (Throwable localThrowable)
    {
      break label90;
    }
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.add(b(paramBaseActivity));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity instanceof SplashActivity)) {}
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean) {}
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaUtilConcurrentConcurrentLinkedQueue.remove(paramString);
  }
  
  private static String b(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity != null) && (paramBaseActivity.getClass() != null)) {
      return String.format("%s@%x", new Object[] { paramBaseActivity.getClass().getSimpleName(), Integer.valueOf(paramBaseActivity.hashCode()) });
    }
    return "[noclass]";
  }
  
  public static void b(BaseActivity paramBaseActivity) {}
  
  public static void b(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity) {}
  
  public static void c(BaseActivity paramBaseActivity) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.debug.DebugMemoryMgr
 * JD-Core Version:    0.7.0.1
 */