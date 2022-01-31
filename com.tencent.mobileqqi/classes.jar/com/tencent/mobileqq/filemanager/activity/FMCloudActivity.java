package com.tencent.mobileqq.filemanager.activity;

import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.filemanager.app.FileManagerEngine;
import com.tencent.mobileqq.filemanager.core.FileManagerNotifyCenter;
import com.tencent.mobileqq.filemanager.data.FileCategoryAdapter;
import com.tencent.mobileqq.filemanager.data.FileCategoryEntity;
import com.tencent.mobileqq.filemanager.data.WeiYunClassificationType;
import com.tencent.widget.XListView;
import fvd;
import fve;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FMCloudActivity
  extends BaseFileAssistantActivity
  implements View.OnClickListener
{
  public static String b;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  public View.OnClickListener a;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  FileCategoryAdapter jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = null;
  XListView jdField_a_of_type_ComTencentWidgetXListView;
  List jdField_a_of_type_JavaUtilList = new ArrayList();
  private FMObserver b;
  
  static
  {
    jdField_b_of_type_JavaLangString = "FileAssistantActivity<FileAssistant>";
  }
  
  public FMCloudActivity()
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new fvd(this);
    this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver = new fve(this);
  }
  
  private void a(List paramList)
  {
    paramList = paramList.iterator();
    int n = 0;
    int m = 0;
    int k = 0;
    int j = 0;
    int i = 0;
    Object localObject;
    int i1;
    int i2;
    if (paramList.hasNext())
    {
      localObject = (WeiYunClassificationType)paramList.next();
      if (((WeiYunClassificationType)localObject).jdField_a_of_type_JavaLangString.equals("document"))
      {
        int i3 = ((WeiYunClassificationType)localObject).jdField_a_of_type_Int;
        i1 = n;
        i2 = m;
        n = i + i3;
        m = j;
        j = i2;
        i = i1;
      }
    }
    for (;;)
    {
      i1 = n;
      i2 = m;
      n = i;
      m = j;
      j = i2;
      i = i1;
      break;
      if (((WeiYunClassificationType)localObject).jdField_a_of_type_JavaLangString.equals("music"))
      {
        i1 = ((WeiYunClassificationType)localObject).jdField_a_of_type_Int;
        i2 = j + i1;
        i1 = i;
        i = n;
        j = m;
        m = i2;
        n = i1;
      }
      else if (((WeiYunClassificationType)localObject).jdField_a_of_type_JavaLangString.equals("other"))
      {
        i1 = ((WeiYunClassificationType)localObject).jdField_a_of_type_Int;
        k += i1;
        i1 = j;
        i2 = i;
        i = n;
        j = m;
        m = i1;
        n = i2;
      }
      else if (((WeiYunClassificationType)localObject).jdField_a_of_type_JavaLangString.equals("picture"))
      {
        i1 = ((WeiYunClassificationType)localObject).jdField_a_of_type_Int;
        i2 = m + i1;
        m = j;
        i1 = i;
        i = n;
        j = i2;
        n = i1;
      }
      else if (((WeiYunClassificationType)localObject).jdField_a_of_type_JavaLangString.equals("video"))
      {
        i2 = n + ((WeiYunClassificationType)localObject).jdField_a_of_type_Int;
        n = j;
        i1 = i;
        i = i2;
        j = m;
        m = n;
        n = i1;
        continue;
        paramList = this.jdField_a_of_type_JavaUtilList.iterator();
        while (paramList.hasNext())
        {
          localObject = (FileCategoryEntity)paramList.next();
          switch (((FileCategoryEntity)localObject).G)
          {
          case 0: 
          case 9: 
          case 4: 
          case 6: 
          case 7: 
          case 8: 
          default: 
            break;
          case 1: 
            ((FileCategoryEntity)localObject).F = j;
            break;
          case 10: 
            ((FileCategoryEntity)localObject).F = m;
            break;
          case 3: 
            ((FileCategoryEntity)localObject).F = i;
            break;
          case 2: 
            ((FileCategoryEntity)localObject).F = n;
            break;
          case 5: 
            ((FileCategoryEntity)localObject).F = k;
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
      }
      else
      {
        i1 = j;
        i2 = i;
        i = n;
        j = m;
        m = i1;
        n = i2;
      }
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null))
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130837852);
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, null, null, null);
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).start();
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidWidgetTextView != null) && (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable != null))
    {
      ((Animatable)this.jdField_a_of_type_AndroidGraphicsDrawableDrawable).stop();
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
      this.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawables(null, null, null, null);
    }
  }
  
  private void i()
  {
    String str1 = getString(2131558700);
    String str2 = getString(2131558691);
    String str3 = getString(2131558692);
    String str4 = getString(2131558694);
    getString(2131558693);
    String str5 = getString(2131558695);
    String str6 = getString(2131558681);
    String str7 = getString(2131558685);
    a(2130903505, 2130838960, 1, getString(2131558686), 0, true, 0, "video", 1);
    a(2130903489, 2130838604, 0, str6, 0, false, 9, "offline", 1);
    a(2130903505, 2130838960, 1, str7, 0, true, 0, "other", 1);
    a(2130903489, 2130838608, 0, str1, 0, true, 10, "picture", 2);
    a(2130903489, 2130838605, 0, str2, 0, true, 1, "music", 3);
    a(2130903489, 2130838611, 0, str3, 0, true, 2, "video", 3);
    a(2130903489, 2130838603, 0, str4, 0, true, 3, "document", 3);
    a(2130903489, 2130838606, 0, str5, 0, true, 5, "other", 4);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter.notifyDataSetChanged();
  }
  
  private void j()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = this.l;
    setTitle(2131558679);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString1, int paramInt4, boolean paramBoolean, int paramInt5, String paramString2, int paramInt6)
  {
    FileCategoryEntity localFileCategoryEntity = new FileCategoryEntity();
    localFileCategoryEntity.D = paramInt1;
    localFileCategoryEntity.E = paramInt2;
    localFileCategoryEntity.C = paramInt3;
    localFileCategoryEntity.jdField_a_of_type_JavaLangString = paramString1;
    localFileCategoryEntity.F = paramInt4;
    localFileCategoryEntity.jdField_a_of_type_Boolean = paramBoolean;
    localFileCategoryEntity.G = paramInt5;
    localFileCategoryEntity.c = paramString2;
    localFileCategoryEntity.H = paramInt6;
    this.jdField_a_of_type_JavaUtilList.add(localFileCategoryEntity);
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2130903493);
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(a());
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)findViewById(2131232727));
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter = new FileCategoryAdapter(this, this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentWidgetXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqFilemanagerDataFileCategoryAdapter);
    j();
    i();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().addObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    g();
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c();
    return true;
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver != null) {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().deleteObserver(this.jdField_b_of_type_ComTencentMobileqqFilemanagerAppFMObserver);
    }
  }
  
  protected void onPause()
  {
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.FMCloudActivity
 * JD-Core Version:    0.7.0.1
 */