import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.galleryactivity.AbstractImageAdapter.URLImageView2;
import com.tencent.image.RegionDrawableData;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.ProGallery.OnProGalleryListener;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.Gallery.LayoutParams;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;

public class wvn
  extends BaseAdapter
  implements ProGallery.OnProGalleryListener
{
  int jdField_a_of_type_Int = -1;
  SparseArray jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  URLDrawable jdField_a_of_type_ComTencentImageURLDrawable;
  
  public wvn(PhotoPreviewActivity paramPhotoPreviewActivity) {}
  
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
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, a());
      }
      do
      {
        return null;
        paramView = a(paramInt);
        if (!TextUtils.isEmpty(paramView)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("PhotoPreviewActivity", 2, "Path is empty. position " + paramInt + ", size " + getCount());
      return null;
      File localFile = new File(paramView);
      if (localFile.exists())
      {
        paramView = URLDrawable.URLDrawableOptions.obtain();
        paramView.mRequestWidth = paramViewGroup.getWidth();
        paramView.mRequestHeight = paramViewGroup.getHeight();
        paramView.mLoadingDrawable = URLDrawableHelper.a;
        paramView.mPlayGifImage = true;
        paramViewGroup = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, localFile);
        if (paramViewGroup != null)
        {
          paramView = URLDrawable.getDrawable(paramViewGroup, paramView);
          paramView.setTag(Integer.valueOf(1));
          paramView.startDownload();
          this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramView);
        }
      }
    }
  }
  
  String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(preview) Actives: ");
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
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a != null) && (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a.size()) && (paramInt >= 0)) {
      return (String)this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, View paramView, ViewGroup paramViewGroup) {}
  
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
        QLog.d("PEAK", 2, "(preview)destory rawDrawable, position: " + paramInt);
      }
    }
  }
  
  public void a(int paramInt, View paramView, RegionDrawableData paramRegionDrawableData)
  {
    if (!ImageView.class.isInstance(paramView)) {}
    do
    {
      return;
      paramView = ((ImageView)paramView).getDrawable();
    } while (!URLDrawable.class.isInstance(paramView));
    ((URLDrawable)paramView).updateRegionBitmap(paramRegionDrawableData);
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
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, a());
    }
  }
  
  public void c(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (!(paramView instanceof AbstractImageAdapter.URLImageView2)) {
      if (QLog.isColorLevel()) {
        QLog.d("PEAK", 2, "onscaleBegin,classcast error,class of current view is " + paramView.getClass().toString());
      }
    }
    do
    {
      do
      {
        do
        {
          return;
          paramView = (AbstractImageAdapter.URLImageView2)paramView;
          paramViewGroup = paramView.getDrawable();
          localObject = paramView.jdField_a_of_type_ComTencentImageURLDrawable;
        } while ((!(paramViewGroup instanceof URLDrawable)) || (!((URLDrawable)paramViewGroup).isFakeSize()) || (localObject != null));
        paramViewGroup = ((URLDrawable)paramViewGroup).getURL();
      } while ((!"file".equals(paramViewGroup.getProtocol())) || (paramViewGroup.getRef() != null));
      if ((paramInt != this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null)) {
        break;
      }
      paramView = this.jdField_a_of_type_ComTencentImageURLDrawable;
    } while ((!QLog.isColorLevel()) || (this.jdField_a_of_type_ComTencentImageURLDrawable == null));
    QLog.d("PEAK", 2, "use exist raw drawable");
    return;
    if ((QLog.isColorLevel()) && (this.jdField_a_of_type_ComTencentImageURLDrawable != null)) {
      QLog.d("PEAK", 2, "rawDrawable is exist");
    }
    paramViewGroup = paramViewGroup.toString() + "#NOSAMPLE";
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mUseExifOrientation = false;
    ((URLDrawable.URLDrawableOptions)localObject).mUseMemoryCache = false;
    paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject);
    paramViewGroup.setTag(Integer.valueOf(2));
    this.jdField_a_of_type_ComTencentImageURLDrawable = null;
    this.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "create rawDrawable, position:" + paramInt);
    }
    if (paramViewGroup.getStatus() == 1)
    {
      paramView.jdField_a_of_type_Boolean = true;
      paramView.setImageDrawable(paramViewGroup);
      paramView.jdField_a_of_type_Boolean = false;
      return;
    }
    paramView.setDecodingDrawble(paramViewGroup);
    paramViewGroup.startDownload();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject2 = null;
    if (paramView != null) {
      return paramView;
    }
    Object localObject4 = a(paramInt);
    int i;
    label32:
    Object localObject3;
    View localView;
    Object localObject1;
    if (PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, (String)localObject4) == 1)
    {
      i = 1;
      localObject3 = (URLDrawable)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
      if (i == 0) {
        break label165;
      }
      localView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.getLayoutInflater().inflate(2130970483, null);
      localView.setTag(2131296400, Boolean.valueOf(true));
      localView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      localObject1 = (ImageView)localView.findViewById(2131370839);
      label105:
      if ((localObject3 == null) || (((URLDrawable)localObject3).getStatus() != 1)) {
        break label184;
      }
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    for (;;)
    {
      if (i != 0)
      {
        localView.setContentDescription("视频" + paramInt);
        return localView;
        i = 0;
        break label32;
        label165:
        localObject1 = new AbstractImageAdapter.URLImageView2(paramViewGroup.getContext());
        localView = null;
        break label105;
        label184:
        if (localObject4 == null) {
          break;
        }
        localObject3 = new File((String)localObject4);
        if (((File)localObject3).exists()) {
          if ((!"FromCamera".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.e)) && (!"FromFastImage".equals(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.e))) {}
        }
      }
    }
    for (;;)
    {
      try
      {
        paramView = URLDrawableHelper.a;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.i != 103) {
          break label562;
        }
        paramViewGroup = BaseApplicationImpl.sImageCache.get((String)localObject4 + "#short_video_camera_preview_cache");
        if (!Bitmap.class.isInstance(paramViewGroup)) {
          break label562;
        }
        paramView = (Bitmap)paramViewGroup;
        paramViewGroup = new BitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.getResources(), paramView);
        if (!QLog.isColorLevel()) {
          break label567;
        }
        QLog.d("PhotoPreviewActivity", 2, "shortVideo preview cache");
      }
      catch (Exception paramViewGroup)
      {
        paramView = localObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("PhotoPreviewActivity", 2, paramViewGroup.getMessage());
        paramView = localObject2;
        continue;
      }
      localObject3 = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, (File)localObject3);
      if (localObject3 != null)
      {
        paramView = URLDrawable.getDrawable((URL)localObject3, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.g, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity.h, paramView, paramViewGroup, true);
        if (paramView == null) {
          break label560;
        }
        ((ImageView)localObject1).setImageDrawable(paramView);
        break;
        localObject4 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestWidth = paramViewGroup.getWidth();
        ((URLDrawable.URLDrawableOptions)localObject4).mRequestHeight = paramViewGroup.getHeight();
        ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = URLDrawableHelper.a;
        ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
        paramViewGroup = PhotoPreviewActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoPreviewActivity, (File)localObject3);
        paramView = localObject2;
        if (paramViewGroup == null) {
          continue;
        }
        paramViewGroup = URLDrawable.getDrawable(paramViewGroup, (URLDrawable.URLDrawableOptions)localObject4);
        paramView = paramViewGroup;
        if (paramViewGroup == null) {
          continue;
        }
        paramView = paramViewGroup;
        switch (paramViewGroup.getStatus())
        {
        }
        paramViewGroup.setTag(Integer.valueOf(1));
        paramViewGroup.startDownload();
        paramView = paramViewGroup;
        continue;
        ((ImageView)localObject1).setContentDescription("照片" + paramInt);
        return localObject1;
      }
      paramView = null;
      continue;
      label560:
      break;
      label562:
      paramViewGroup = null;
      continue;
      label567:
      paramView = paramViewGroup;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvn
 * JD-Core Version:    0.7.0.1
 */