package com.tencent.mobileqq.activity.contact.addcontact;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class ViewFactory
{
  public static final int a = 4;
  private static ViewFactory jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static final int[] jdField_a_of_type_ArrayOfInt = { 80000000, 80000001 };
  public static final int b = 80000000;
  private static final int[] b = { 80000001, 80000000 };
  public static final int c = 80000001;
  public static final int d = 80000002;
  public static final int e = 80000003;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap(4);
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 2131363759;
    case 80000000: 
      return 2131363364;
    }
    return 2131363760;
  }
  
  private View a(Context paramContext)
  {
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
    localLinearLayout.setOrientation(1);
    TextView localTextView = new TextView(paramContext);
    localTextView.setText("没有找到相关结果");
    localTextView.setTextSize(0, paramContext.getResources().getDimension(2131492890));
    localTextView.setPadding(0, paramContext.getResources().getDimensionPixelSize(2131493093), 0, 0);
    paramContext = new LinearLayout.LayoutParams(-2, -2);
    paramContext.gravity = 1;
    localLinearLayout.addView(localTextView, paramContext);
    localLinearLayout.setContentDescription("没有找到相关结果");
    return localLinearLayout;
  }
  
  public static ViewFactory a()
  {
    if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {}
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory == null) {
        jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = new ViewFactory();
      }
      return jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory;
    }
  }
  
  public static int[] a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return jdField_a_of_type_ArrayOfInt;
    case 80000000: 
      return jdField_a_of_type_ArrayOfInt;
    }
    return b;
  }
  
  private View b(Context paramContext)
  {
    return new ViewFactory.GuideView(paramContext);
  }
  
  public View a(int paramInt, Context paramContext, boolean paramBoolean)
  {
    int j = 0;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    int i = j;
    if (paramBoolean)
    {
      localObject1 = localObject2;
      i = j;
      if (this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt)) != null)
      {
        localObject1 = (View)((WeakReference)this.jdField_a_of_type_JavaUtilHashMap.get(Integer.valueOf(paramInt))).get();
        i = 1;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      switch (paramInt)
      {
      default: 
        localObject2 = localObject1;
      }
    }
    for (;;)
    {
      if ((paramBoolean) && (i == 0)) {
        this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), new WeakReference(localObject2));
      }
      return localObject2;
      localObject2 = b(paramContext);
      continue;
      localObject2 = a(paramContext);
    }
  }
  
  public void a()
  {
    jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactViewFactory = null;
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_JavaUtilHashMap = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ViewFactory
 * JD-Core Version:    0.7.0.1
 */