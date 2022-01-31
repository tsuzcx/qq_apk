package com.tencent.mobileqq.filemanager.fileviewer;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import dvw;
import java.io.File;
import java.util.List;

public class FileViewerGalleryAdapter
  extends BaseAdapter
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private List jdField_a_of_type_JavaUtilList;
  private Drawable b;
  
  public FileViewerGalleryAdapter(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
    this.jdField_a_of_type_Int *= 2;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130839510);
    this.b = paramContext.getResources().getDrawable(2130837928);
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
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
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903446, null);
      paramViewGroup = new dvw(this, null);
      paramViewGroup.a = ((URLImageView)paramView.findViewById(2131296283));
      paramView.setTag(paramViewGroup);
    }
    Object localObject;
    for (;;)
    {
      localObject = (IFileViewerAdapter)getItem(paramInt);
      if (localObject != null) {
        break;
      }
      paramViewGroup.a.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramView;
      paramViewGroup = (dvw)paramView.getTag();
    }
    String str = ((IFileViewerAdapter)localObject).f();
    if (str == null)
    {
      paramViewGroup.a.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
      return paramView;
    }
    File localFile = new File(str);
    if (localFile.exists()) {
      try
      {
        localObject = URLDrawable.getDrawable(FileManagerUtil.a(str, -1, -1, localFile), this.b, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, true);
        ((URLDrawable)localObject).setTargetDensity(this.jdField_a_of_type_Int);
        paramViewGroup.a.setImageDrawable((Drawable)localObject);
        return paramView;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        paramViewGroup.a.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
        return paramView;
      }
    }
    if ((localException.c() == 7) && (str != null) && (str.startsWith("http://")))
    {
      paramViewGroup.a.setImageURL(str);
      return paramView;
    }
    paramViewGroup.a.setImageDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileviewer.FileViewerGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */