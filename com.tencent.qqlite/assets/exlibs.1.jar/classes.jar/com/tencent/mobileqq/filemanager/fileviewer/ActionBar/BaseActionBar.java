package com.tencent.mobileqq.filemanager.fileviewer.ActionBar;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.filemanager.widget.HorizontalListViewAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import dsi;
import dsj;
import java.util.ArrayList;

public class BaseActionBar
{
  protected View a;
  public RelativeLayout a;
  public BaseActionBar.IActionBarClickEvent a;
  public HorizontalListViewAdapter a;
  public ActionSheet a;
  ArrayList a;
  ArrayList b = new ArrayList();
  
  public BaseActionBar(View paramView)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = null;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = null;
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131298001);
    this.jdField_a_of_type_AndroidViewView.findViewById(2131298011).setVisibility(8);
  }
  
  private Button a(int paramInt)
  {
    if (((paramInt >= 4) || (paramInt < 0)) && (QLog.isDevelopLevel())) {
      throw new IndexOutOfBoundsException();
    }
    Button localButton = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localButton == null) {
        QLog.e("BaseActinBar<FileAssistant>", 1, "addActionBar getButton index is[" + paramInt + "]");
      }
      return localButton;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298007);
      continue;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298008);
      continue;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298009);
      continue;
      localButton = (Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131298010);
    }
  }
  
  public ArrayList a()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public void a(int paramInt, String paramString, View.OnClickListener paramOnClickListener)
  {
    Button localButton = a(paramInt);
    if (localButton == null) {
      return;
    }
    localButton.setText(paramString);
    localButton.setOnClickListener(paramOnClickListener);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    Button localButton = a(paramInt);
    if (localButton == null) {
      return;
    }
    localButton.setEnabled(paramBoolean);
  }
  
  public void a(Activity paramActivity)
  {
    a(3, "更多", new dsj(this, paramActivity));
  }
  
  public void a(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(paramOnClickListener);
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.jdField_a_of_type_JavaUtilArrayList.add(localActionBar);
  }
  
  public void a(BaseActionBar.IActionBarClickEvent paramIActionBarClickEvent)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerFileviewerActionBarBaseActionBar$IActionBarClickEvent = paramIActionBarClickEvent;
  }
  
  public void a(Object paramObject) {}
  
  public ArrayList b()
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    return this.b;
  }
  
  public void b(Activity paramActivity)
  {
    a(1, "分享", new dsi(this, paramActivity));
  }
  
  public void b(Context paramContext, String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.b == null) {
      this.b = new ArrayList();
    }
    ActionBar localActionBar = new ActionBar();
    localActionBar.a(paramOnClickListener);
    localActionBar.a(paramContext, paramInt1, paramInt2);
    localActionBar.a(paramString);
    this.b.add(localActionBar);
  }
  
  protected void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.ActionBar.BaseActionBar
 * JD-Core Version:    0.7.0.1
 */