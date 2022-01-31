package com.tencent.mobileqq.filemanager.activity.fileviewer.base;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import ftg;
import java.io.File;
import java.util.List;

public class FileViewerImageAdapter
  extends BaseAdapter
{
  static final String jdField_a_of_type_JavaLangString = "FileViewerImageAdapter";
  protected float a;
  int jdField_a_of_type_Int = 0;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  protected BaseFileViewerActivity a;
  List jdField_a_of_type_JavaUtilList;
  int jdField_b_of_type_Int = 0;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  private int jdField_c_of_type_Int;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
  
  public FileViewerImageAdapter(BaseFileViewerActivity paramBaseFileViewerActivity)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity = paramBaseFileViewerActivity;
    this.jdField_a_of_type_Float = paramBaseFileViewerActivity.getResources().getDisplayMetrics().density;
    this.jdField_c_of_type_Int = paramBaseFileViewerActivity.getResources().getDisplayMetrics().densityDpi;
    this.jdField_c_of_type_Int *= 2;
    this.jdField_a_of_type_Int = ((int)(paramBaseFileViewerActivity.getResources().getDisplayMetrics().widthPixels * 1.5D));
    this.jdField_b_of_type_Int = ((int)(paramBaseFileViewerActivity.getResources().getDisplayMetrics().heightPixels * 1.5D));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramBaseFileViewerActivity.getResources().getDrawable(2130840362);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramBaseFileViewerActivity.getResources().getDrawable(2130837862);
  }
  
  private void a(ProgressBar paramProgressBar)
  {
    if (paramProgressBar == null) {
      return;
    }
    paramProgressBar.setVisibility(0);
  }
  
  private void a(ProgressBar paramProgressBar, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      a(paramProgressBar);
      return;
    }
    b(paramProgressBar);
  }
  
  private void b(ProgressBar paramProgressBar)
  {
    if (paramProgressBar == null) {
      return;
    }
    paramProgressBar.setVisibility(4);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("FileViewerImageAdapter", 2, "setList,model");
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity).inflate(2130903515, null);
      paramViewGroup = new ftg(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131230758));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131230757));
      paramView.setTag(paramViewGroup);
    }
    FileViewerImageInfo localFileViewerImageInfo;
    for (;;)
    {
      localFileViewerImageInfo = (FileViewerImageInfo)getItem(paramInt);
      if (localFileViewerImageInfo != null) {
        break;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      b(paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar);
      return paramView;
      paramViewGroup = (ftg)paramView.getTag();
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerActivityFileviewerBaseBaseFileViewerActivity.a(localFileViewerImageInfo.jdField_a_of_type_JavaLangObject);
    if (localObject == null)
    {
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar, localFileViewerImageInfo.jdField_a_of_type_Boolean);
      return paramView;
    }
    File localFile = new File((String)localObject);
    if (localFile.exists()) {}
    for (;;)
    {
      try
      {
        localObject = URLDrawable.getDrawable(FileManagerUtil.a((String)localObject, -1, -1, localFile), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_c_of_type_Int);
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        a(paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar, localFileViewerImageInfo.jdField_a_of_type_Boolean);
        return paramView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        continue;
      }
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.fileviewer.base.FileViewerImageAdapter
 * JD-Core Version:    0.7.0.1
 */