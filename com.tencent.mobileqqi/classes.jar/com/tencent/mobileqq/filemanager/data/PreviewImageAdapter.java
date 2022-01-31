package com.tencent.mobileqq.filemanager.data;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ProgressBar;
import com.dataline.activities.DLBaseFileViewActivity;
import com.dataline.activities.DLFileViewerActivity;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ImagePreviewModel;
import com.tencent.mobileqq.activity.photo.BaseImageInfo;
import com.tencent.mobileqq.filemanager.activity.fileviewer.qfile.QfileFileViewerActivity;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.qphone.base.util.QLog;
import gce;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class PreviewImageAdapter
  extends BaseAdapter
{
  public static final int a = 100;
  static final String jdField_a_of_type_JavaLangString = "ImageAdapter";
  public static final int b = 36;
  protected float a;
  protected Context a;
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  Handler jdField_a_of_type_AndroidOsHandler;
  List jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean = false;
  Drawable jdField_b_of_type_AndroidGraphicsDrawableDrawable = null;
  private boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int = 0;
  Drawable jdField_c_of_type_AndroidGraphicsDrawableDrawable = null;
  int d = 0;
  private int e;
  
  public PreviewImageAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_AndroidOsHandler = new Handler();
    this.jdField_a_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    this.e = paramContext.getResources().getDisplayMetrics().densityDpi;
    this.e *= 2;
    this.jdField_c_of_type_Int = ((int)(paramContext.getResources().getDisplayMetrics().widthPixels * 1.5D));
    this.d = ((int)(paramContext.getResources().getDisplayMetrics().heightPixels * 1.5D));
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130840360);
    this.jdField_c_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130837860);
  }
  
  private View a(int paramInt, View paramView, gce paramgce)
  {
    BaseImageInfo localBaseImageInfo = (BaseImageInfo)getItem(paramInt);
    if (localBaseImageInfo == null)
    {
      paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      b(paramgce.jdField_a_of_type_AndroidWidgetProgressBar);
    }
    do
    {
      return paramView;
      this.jdField_b_of_type_Boolean = localBaseImageInfo.e;
      a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar);
      if (localBaseImageInfo.b != null) {
        break;
      }
      if (this.jdField_b_of_type_Boolean) {
        paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof DLFileViewerActivity));
    Object localObject = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130840361);
    paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar, localBaseImageInfo.e);
    return paramView;
    localObject = localBaseImageInfo.b;
    if (((String)localObject).startsWith("http")) {}
    for (;;)
    {
      try
      {
        localObject = URLDrawable.getDrawable(new URL((String)localObject), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        ((URLDrawable)localObject).setTargetDensity(this.e);
        paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
        a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar, localBaseImageInfo.e);
        return paramView;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        localMalformedURLException.printStackTrace();
        paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        continue;
      }
      File localFile = new File(localMalformedURLException);
      if (localFile.exists()) {
        try
        {
          URLDrawable localURLDrawable = URLDrawable.getDrawable(FileManagerUtil.a(localMalformedURLException, -1, -1, localFile), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
          localURLDrawable.setTargetDensity(this.e);
          paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(localURLDrawable);
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        }
      } else {
        paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      }
    }
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
  
  private View b(int paramInt, View paramView, gce paramgce)
  {
    FileViewerImageInfo localFileViewerImageInfo = (FileViewerImageInfo)getItem(paramInt);
    if (localFileViewerImageInfo == null)
    {
      paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      b(paramgce.jdField_a_of_type_AndroidWidgetProgressBar);
    }
    do
    {
      return paramView;
      a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar);
      if (localFileViewerImageInfo.a != null) {
        break;
      }
    } while (!localFileViewerImageInfo.f);
    paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar, localFileViewerImageInfo.f);
    return paramView;
    FileManagerEntity localFileManagerEntity = localFileViewerImageInfo.a;
    Object localObject1;
    switch (localFileManagerEntity.cloudType)
    {
    default: 
      localObject2 = localFileManagerEntity.strFilePath;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (FileUtil.b(localFileManagerEntity.strThumbPath)) {
          localObject1 = localFileManagerEntity.strThumbPath;
        }
      }
      break;
    }
    while (localObject1 == null)
    {
      paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar, localFileViewerImageInfo.f);
      return paramView;
      localObject1 = localFileManagerEntity.strFilePath;
      continue;
      localObject2 = localFileManagerEntity.strThumbPath;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = localObject2;
        if (FileUtil.b(localFileManagerEntity.strFilePath)) {
          localObject1 = localFileManagerEntity.strFilePath;
        }
      }
    }
    Object localObject2 = new File((String)localObject1);
    if (((File)localObject2).exists()) {}
    for (;;)
    {
      try
      {
        localObject1 = URLDrawable.getDrawable(FileManagerUtil.a((String)localObject1, -1, -1, (File)localObject2), this.jdField_c_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        ((URLDrawable)localObject1).setTargetDensity(this.e);
        paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
        a(paramgce.jdField_a_of_type_AndroidWidgetProgressBar, localFileViewerImageInfo.f);
        return paramView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        continue;
      }
      paramgce.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    }
  }
  
  private void b(ProgressBar paramProgressBar)
  {
    if (paramProgressBar == null) {
      return;
    }
    paramProgressBar.setVisibility(4);
  }
  
  public int a()
  {
    return 36;
  }
  
  public void a(ImagePreviewModel paramImagePreviewModel)
  {
    this.jdField_a_of_type_JavaUtilList = paramImagePreviewModel.a();
    if (QLog.isColorLevel()) {
      QLog.d("ImageAdapter", 2, "setList,model");
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    if (QLog.isColorLevel()) {
      QLog.d("ImageAdapter", 2, "setList,list");
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
    View localView;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903513, null);
      paramViewGroup = new gce(this);
      paramViewGroup.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131230758));
      paramViewGroup.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131230757));
      paramView.setTag(paramViewGroup);
      if (!(this.jdField_a_of_type_AndroidContentContext instanceof DLBaseFileViewActivity)) {
        break label91;
      }
      localView = a(paramInt, paramView, paramViewGroup);
    }
    label91:
    do
    {
      return localView;
      paramViewGroup = (gce)paramView.getTag();
      break;
      localView = paramView;
    } while (!(this.jdField_a_of_type_AndroidContentContext instanceof QfileFileViewerActivity));
    return b(paramInt, paramView, paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.PreviewImageAdapter
 * JD-Core Version:    0.7.0.1
 */