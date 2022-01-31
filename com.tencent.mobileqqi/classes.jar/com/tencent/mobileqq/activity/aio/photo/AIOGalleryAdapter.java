package com.tencent.mobileqq.activity.aio.photo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.support.v4.util.MQLruCache;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.common.galleryactivity.AbstractImageListModel;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.PreloadGallery.OnPreloadListener;
import com.tencent.mobileqq.pic.PicReporter;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AIOGalleryAdapter
  extends AbstractImageAdapter
  implements PreloadGallery.OnPreloadListener
{
  static final String jdField_a_of_type_JavaLangString = "AIOGalleryAdapter";
  private int jdField_a_of_type_Int = -1;
  Context jdField_a_of_type_AndroidContentContext;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  IAIOImageProvider jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public AIOGalleryAdapter(Context paramContext, IAIOImageProvider paramIAIOImageProvider)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider = paramIAIOImageProvider;
  }
  
  private String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Actives: ");
    int i = 0;
    while (i < this.jdField_a_of_type_AndroidUtilSparseArray.size())
    {
      if (i > 0) {
        localStringBuilder.append(" , ");
      }
      localStringBuilder.append(this.jdField_a_of_type_AndroidUtilSparseArray.keyAt(i) + 1);
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
      this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
    }
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_Int = -1;
  }
  
  public View a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null) {
      if (paramView.getStatus() == 3) {
        paramView.restartDownload();
      }
    }
    for (;;)
    {
      return null;
      AIOImageData localAIOImageData = ((AIOImageInfo)a(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
      if (!"I:E".equals(localAIOImageData.e))
      {
        paramViewGroup = localAIOImageData.a(4);
        paramView = paramViewGroup;
        if (paramViewGroup == null)
        {
          paramView = localAIOImageData.a(2);
          if (paramView == null) {}
        }
        else
        {
          paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
          paramViewGroup.mLoadingDrawable = URLDrawableHelper.d;
          paramViewGroup.mFailedDrawable = URLDrawableHelper.d;
          paramViewGroup.mPlayGifImage = true;
          paramViewGroup.mUseExifOrientation = false;
          paramView = URLDrawable.getDrawable(paramView, paramViewGroup);
          paramView.setTag(Integer.valueOf(1));
          paramView.startDownload();
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
          continue;
        }
        if (localAIOImageData.a(1) != null)
        {
          URLDrawable.getDrawable(localAIOImageData.a(1), URLDrawableHelper.d, URLDrawableHelper.d).startDownload();
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.a, localAIOImageData.d, 2);
        }
        else
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.a, localAIOImageData.d, 2);
          if (QLog.isDevelopLevel()) {
            QLog.d("AIOGalleryAdapter", 4, "onCreateView():Thumb and large pic is not exist, download it. Gallery position is " + paramInt);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, View paramView)
  {
    paramView = (AbstractImageAdapter.URLImageView2)paramView;
    Object localObject = ((AIOImageInfo)a(paramInt)).jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    if ("I:E".equals(((AIOImageData)localObject).e))
    {
      paramView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837649));
      a(paramInt, false);
    }
    while (((AIOImageData)localObject).a(2) == null) {
      return;
    }
    localObject = URLDrawable.getDrawable(((AIOImageData)localObject).a(2), true);
    ((URLDrawable)localObject).setTag(Integer.valueOf(1));
    paramView.setDecodingDrawble((URLDrawable)localObject);
    ((URLDrawable)localObject).startDownload();
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.onSlot(): position is " + paramInt);
    }
    System.gc();
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup, boolean paramBoolean)
  {
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = -1;
      if (QLog.isColorLevel()) {
        QLog.d("AIOGalleryAdapter", 2, "destory rawDrawable, position: " + paramInt);
      }
    }
  }
  
  public void a(View paramView, int paramInt) {}
  
  public void a(AbstractImageListModel paramAbstractImageListModel)
  {
    super.a(paramAbstractImageListModel);
    a();
  }
  
  public void a(URLDrawable paramURLDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt) != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramURLDrawable);
    }
  }
  
  public void b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (paramView != null)
    {
      if (paramView.getStatus() == 0) {
        paramView.cancelDownload(true);
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
    }
    if (paramInt == this.jdField_a_of_type_Int)
    {
      if ((this.jdField_a_of_type_ComTencentImageURLDrawable != null) && (this.jdField_a_of_type_ComTencentImageURLDrawable.getStatus() == 0)) {
        this.jdField_a_of_type_ComTencentImageURLDrawable.cancelDownload(true);
      }
      this.jdField_a_of_type_ComTencentImageURLDrawable = null;
      this.jdField_a_of_type_Int = -1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, a());
    }
  }
  
  public void c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AbstractImageAdapter.URLImageView2 localURLImageView2 = (AbstractImageAdapter.URLImageView2)paramView;
    paramView = localURLImageView2.getDrawable();
    paramViewGroup = localURLImageView2.jdField_a_of_type_ComTencentImageURLDrawable;
    if (((paramView instanceof URLDrawable)) && (((URLDrawable)paramView).isFakeSize()) && (paramViewGroup == null))
    {
      paramView = ((URLDrawable)paramView).getURL();
      if (("file".equals(paramView.getProtocol())) && (paramView.getRef() == null))
      {
        if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
          break label142;
        }
        paramViewGroup = this.jdField_a_of_type_ComTencentImageURLDrawable;
        paramView = paramViewGroup;
        if (QLog.isColorLevel())
        {
          paramView = paramViewGroup;
          if (this.jdField_a_of_type_ComTencentImageURLDrawable != null)
          {
            QLog.d("AIOGalleryAdapter", 2, "use exist raw drawable");
            paramView = paramViewGroup;
          }
        }
      }
    }
    while (paramView.getStatus() == 1)
    {
      localURLImageView2.jdField_a_of_type_Boolean = true;
      localURLImageView2.setImageDrawable(paramView);
      localURLImageView2.jdField_a_of_type_Boolean = false;
      return;
      label142:
      if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
        QLog.d("AIOGalleryAdapter", 2, "rawDrawable is exist");
      }
      paramView = paramView.toString() + "#NOSAMPLE";
      paramViewGroup = URLDrawable.URLDrawableOptions.obtain();
      paramViewGroup.mUseExifOrientation = false;
      paramViewGroup.mUseMemoryCache = false;
      paramViewGroup = URLDrawable.getDrawable(paramView, paramViewGroup);
      paramViewGroup.setTag(Integer.valueOf(2));
      this.jdField_a_of_type_ComTencentImageURLDrawable = paramViewGroup;
      this.jdField_a_of_type_Int = paramInt;
      paramView = paramViewGroup;
      if (QLog.isColorLevel())
      {
        QLog.d("AIOGalleryAdapter", 2, "create rawDrawable, position:" + paramInt);
        paramView = paramViewGroup;
      }
    }
    localURLImageView2.setDecodingDrawble(paramView);
    paramView.startDownload();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool3 = true;
    if (paramView != null) {
      return paramView;
    }
    if (QLog.isColorLevel()) {
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): position=" + paramInt);
    }
    AIOGalleryAdapter.GalleryURLImageView localGalleryURLImageView = new AIOGalleryAdapter.GalleryURLImageView(this, this.jdField_a_of_type_AndroidContentContext);
    localGalleryURLImageView.setAdjustViewBounds(true);
    AIOImageInfo localAIOImageInfo = (AIOImageInfo)a(paramInt);
    AIOImageData localAIOImageData = localAIOImageInfo.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageData;
    localGalleryURLImageView.jdField_a_of_type_Int = paramInt;
    localGalleryURLImageView.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIOImageInfo = localAIOImageInfo;
    localGalleryURLImageView.jdField_a_of_type_Boolean = false;
    paramViewGroup = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    Object localObject;
    if ((paramViewGroup != null) && (paramViewGroup.getStatus() == 1))
    {
      localGalleryURLImageView.setImageDrawable(paramViewGroup);
      paramView = localAIOImageData.a(4);
      localObject = paramViewGroup.getURL().toString();
      if (((String)localObject).equals(paramView)) {
        localGalleryURLImageView.b = true;
      }
      if (localAIOImageInfo.b != -2) {}
    }
    for (;;)
    {
      try
      {
        localAIOImageInfo.b = new ExifInterface(paramViewGroup.getURL().getFile()).getAttributeInt("Orientation", 1);
        a(localGalleryURLImageView, paramViewGroup, localAIOImageInfo.b);
        if (localGalleryURLImageView.b)
        {
          paramView = "success_original";
          PicReporter.b(true, paramView);
          if (QLog.isColorLevel()) {
            QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): cache url is " + (String)localObject + ", cache type is " + localAIOImageData.a(paramViewGroup.getURL().getFile()));
          }
          paramViewGroup = localAIOImageData.a + "_" + localAIOImageData.d;
          paramView = localGalleryURLImageView;
          if (this.jdField_a_of_type_JavaUtilArrayList.contains(paramViewGroup)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.a, localAIOImageData.d);
          this.jdField_a_of_type_JavaUtilArrayList.add(paramViewGroup);
          return localGalleryURLImageView;
        }
      }
      catch (IOException paramView)
      {
        if (QLog.isColorLevel()) {
          QLog.e("AIOGalleryAdapter", 2, "read exif error", paramView);
        }
        localAIOImageInfo.b = 1;
        continue;
        paramView = "success_large";
        continue;
      }
      if (!"I:E".equals(localAIOImageData.e)) {
        break label440;
      }
      localGalleryURLImageView.setImageDrawable(BaseApplicationImpl.a().getResources().getDrawable(2130837649));
      a(paramInt, false);
      if (QLog.isColorLevel()) {
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): IMAGE_FILE_ERROR");
      }
    }
    label440:
    paramView = localAIOImageData.a(4);
    if (paramView == null)
    {
      paramViewGroup = localAIOImageData.a(2);
      if (paramViewGroup == null) {}
    }
    for (;;)
    {
      boolean bool1;
      label469:
      boolean bool2;
      if (paramView != null)
      {
        bool1 = true;
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mLoadingDrawable = URLDrawableHelper.d;
        paramView.mPlayGifImage = true;
        paramView.mUseExifOrientation = false;
        localObject = URLDrawable.getDrawable(paramViewGroup, paramView);
        ((URLDrawable)localObject).setTag(Integer.valueOf(1));
        this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localObject);
        if (((URLDrawable)localObject).isDownloadStarted())
        {
          if (BaseApplicationImpl.a.get(((URLDrawable)localObject).getURL().toString()) == null) {
            break label685;
          }
          bool2 = true;
          label544:
          if (bool2) {
            break label698;
          }
          if (!bool1) {
            break label691;
          }
          paramView = "fail_original";
          label558:
          PicReporter.b(bool2, paramView);
        }
        switch (((URLDrawable)localObject).getStatus())
        {
        }
      }
      for (;;)
      {
        localGalleryURLImageView.setImageDrawable((Drawable)localObject);
        localGalleryURLImageView.b = bool1;
        ((URLDrawable)localObject).downloadImediatly();
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + ((URLDrawable)localObject).getURL().toString() + ", file type is " + localAIOImageData.a(((URLDrawable)localObject).getURL().toString()));
        break;
        bool1 = false;
        break label469;
        label685:
        bool2 = false;
        break label544;
        label691:
        paramView = "fail_large";
        break label558;
        label698:
        if (bool1)
        {
          paramView = "success_original";
          break label558;
        }
        paramView = "success_large";
        break label558;
        if (localAIOImageInfo.b == -2) {}
        try
        {
          localAIOImageInfo.b = new ExifInterface(paramViewGroup.getAbsolutePath()).getAttributeInt("Orientation", 1);
          a(localGalleryURLImageView, (URLDrawable)localObject, localAIOImageInfo.b);
          if (((URLDrawable)localObject).getStatus() == 1)
          {
            bool2 = bool3;
            a(paramInt, bool2);
          }
        }
        catch (IOException paramView)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("AIOGalleryAdapter", 2, "read exif error", paramView);
            }
            localAIOImageInfo.b = 1;
            continue;
            bool2 = false;
          }
        }
      }
      if (localAIOImageData.a(1) != null)
      {
        paramView = URLDrawable.getDrawable(localAIOImageData.a(1), URLDrawableHelper.d, URLDrawableHelper.d);
        localGalleryURLImageView.setImageDrawable(paramView);
        paramView.downloadImediatly();
        a(paramInt, localAIOImageInfo.jdField_a_of_type_Int / 100);
        this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.a, localAIOImageData.d, 2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): url is " + localAIOImageData.a(1) + ", file type is " + 1);
        break;
      }
      a(paramInt, localAIOImageInfo.jdField_a_of_type_Int / 100);
      localGalleryURLImageView.setImageDrawable(URLDrawableHelper.d);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoIAIOImageProvider.a(localAIOImageData.a, localAIOImageData.d, 2);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("AIOGalleryAdapter", 2, "AIOGalleryAdapter.getView(): No pic");
      break;
      paramViewGroup = paramView;
    }
  }
  
  public void notifyDataSetChanged()
  {
    super.notifyDataSetChanged();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryAdapter", 2, "notifyDataSetChanged(): Data changed");
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter
 * JD-Core Version:    0.7.0.1
 */