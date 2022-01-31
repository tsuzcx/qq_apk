import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.CameraView;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class cja
  extends BaseAdapter
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public cja(PhotoListActivity paramPhotoListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramPhotoListActivity.getLayoutInflater();
    this.jdField_a_of_type_AndroidContentResResources = paramPhotoListActivity.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839066);
  }
  
  private String a(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder1;
    StringBuilder localStringBuilder2;
    if (paramInt1 == 0)
    {
      localStringBuilder1 = new StringBuilder("照片");
      localStringBuilder2 = localStringBuilder1.append(paramInt2 + 1);
      if (!paramBoolean) {
        break label120;
      }
    }
    label120:
    for (String str = "已选中";; str = "")
    {
      localStringBuilder2.append(str).append(" 创建时间: ");
      return new SimpleDateFormat("yyyy年MM月dd HH点mm分ss秒").format(new Date(paramLocalMediaInfo.d * 1000L));
      if (paramInt1 == 1)
      {
        localStringBuilder1 = new StringBuilder("视频");
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.e(PhotoListActivity.jdField_a_of_type_JavaLangString, 2, "PhotoListActivity createContentDescription mediaType is error");
      }
      return "";
    }
  }
  
  public LocalMediaInfo a(int paramInt)
  {
    return (LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  String a(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label105;
      }
    }
    label105:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    if ((paramList == null) || (paramList.size() == 0)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.addAll(paramList);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public int getItemViewType(int paramInt)
  {
    String[] arrayOfString = MimeHelper.a(((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).jdField_b_of_type_JavaLangString);
    if (arrayOfString == null) {
      return 0;
    }
    return ((Integer)PhotoListActivity.a().get(arrayOfString[0])).intValue();
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    switch (i)
    {
    default: 
      paramViewGroup = paramView;
    }
    label134:
    Object localObject2;
    Object localObject1;
    label312:
    label318:
    label369:
    label505:
    label763:
    do
    {
      do
      {
        do
        {
          Object localObject3;
          URLDrawable localURLDrawable;
          do
          {
            do
            {
              return paramViewGroup;
              if (paramView == null)
              {
                paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903525, null);
                paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Int));
                paramViewGroup = new cjb(this, null);
                paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298372));
                paramViewGroup.b = ((ImageView)paramView.findViewById(2131298373));
                paramViewGroup.c = ((ImageView)paramView.findViewById(2131298374));
                paramView.setTag(paramViewGroup);
                localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
                ((ImageView)localObject2).setAdjustViewBounds(false);
                localObject1 = a(paramInt);
                if (((LocalMediaInfo)localObject1).jdField_b_of_type_Int != 1) {
                  break label312;
                }
              }
              for (bool = true;; bool = false)
              {
                paramView.setContentDescription(a(i, (LocalMediaInfo)localObject1, paramInt, bool));
                localObject3 = AlbumUtil.a((LocalMediaInfo)localObject1, AlbumThumbDownloader.jdField_a_of_type_Int);
                localURLDrawable = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
                if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject3)))
                {
                  localObject3 = URLDrawable.getDrawable((URL)localObject3, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                  ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
                  paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
                  if (localURLDrawable != null) {
                    localURLDrawable.cancelDownload();
                  }
                }
                localObject2 = paramViewGroup.b;
                paramViewGroup = paramViewGroup.c;
                paramInt = ((LocalMediaInfo)localObject1).jdField_b_of_type_Int;
                if (paramInt != 1) {
                  break label318;
                }
                ((ImageView)localObject2).setVisibility(0);
                paramViewGroup.setVisibility(0);
                paramViewGroup = paramView;
                if (paramView.getBackground() == null) {
                  break;
                }
                paramView.setBackgroundDrawable(null);
                return paramView;
                paramViewGroup = (cjb)paramView.getTag();
                break label134;
              }
              if (paramInt != 3) {
                break label369;
              }
              ((ImageView)localObject2).setVisibility(4);
              paramViewGroup.setVisibility(4);
              if (PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
                break;
              }
              paramViewGroup = paramView;
            } while (paramView.getBackground() != null);
            paramView.setBackgroundResource(2130837585);
            return paramView;
            paramView.setBackgroundDrawable(null);
            return paramView;
            ((ImageView)localObject2).setVisibility(4);
            paramViewGroup.setVisibility(4);
            paramViewGroup = paramView;
          } while (paramView.getBackground() == null);
          paramView.setBackgroundDrawable(null);
          return paramView;
          if (paramView == null)
          {
            paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903578, null);
            paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Int));
            paramViewGroup = new cjb(this, null);
            paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131298372));
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131298580));
            paramViewGroup.b = ((ImageView)paramView.findViewById(2131298373));
            paramViewGroup.c = ((ImageView)paramView.findViewById(2131298374));
            paramView.setTag(paramViewGroup);
            localObject2 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
            ((ImageView)localObject2).setAdjustViewBounds(false);
            localObject1 = a(paramInt);
            if (((LocalMediaInfo)localObject1).jdField_b_of_type_Int != 1) {
              break label706;
            }
          }
          for (boolean bool = true;; bool = false)
          {
            paramView.setContentDescription(a(i, (LocalMediaInfo)localObject1, paramInt, bool));
            localObject3 = AlbumUtil.a((LocalMediaInfo)localObject1, AlbumThumbDownloader.jdField_a_of_type_Int);
            localURLDrawable = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
            if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject3)))
            {
              localObject3 = URLDrawable.getDrawable((URL)localObject3, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
              ((URLDrawable)localObject3).setTag(localObject1);
              ((ImageView)localObject2).setImageDrawable((Drawable)localObject3);
              paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
              if (localURLDrawable != null) {
                localURLDrawable.cancelDownload();
              }
            }
            paramViewGroup.jdField_a_of_type_AndroidWidgetTextView.setText(a(((LocalMediaInfo)localObject1).e));
            localObject2 = paramViewGroup.b;
            paramViewGroup = paramViewGroup.c;
            paramInt = ((LocalMediaInfo)localObject1).jdField_b_of_type_Int;
            if (paramInt != 1) {
              break label712;
            }
            ((ImageView)localObject2).setVisibility(0);
            paramViewGroup.setVisibility(0);
            paramViewGroup = paramView;
            if (paramView.getBackground() == null) {
              break;
            }
            paramView.setBackgroundDrawable(null);
            return paramView;
            paramViewGroup = (cjb)paramView.getTag();
            break label505;
          }
          if (paramInt != 3) {
            break label763;
          }
          ((ImageView)localObject2).setVisibility(4);
          paramViewGroup.setVisibility(4);
          if (PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
            break;
          }
          paramViewGroup = paramView;
        } while (paramView.getBackground() != null);
        paramView.setBackgroundResource(2130837585);
        return paramView;
        paramView.setBackgroundDrawable(null);
        return paramView;
        ((ImageView)localObject2).setVisibility(4);
        paramViewGroup.setVisibility(4);
        paramViewGroup = paramView;
      } while (paramView.getBackground() == null);
      paramView.setBackgroundDrawable(null);
      return paramView;
      if (!PhotoListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
        break;
      }
      paramViewGroup = paramView;
    } while (paramView != null);
    label706:
    label712:
    paramView = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    paramView.setPadding(PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity));
    paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Int));
    paramViewGroup = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    paramViewGroup.setImageResource(2130838166);
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.addView(paramViewGroup, new RelativeLayout.LayoutParams(-1, -1));
    return paramView;
    if (paramView == null)
    {
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) == null) {
        break label1211;
      }
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity).getParent() == null)
      {
        paramView = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        paramView.setPadding(PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity));
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_b_of_type_Int));
        paramView.addView(PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), new RelativeLayout.LayoutParams(-1, -1));
        paramViewGroup = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        paramViewGroup.setImageResource(2130838166);
        paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
        paramView.addView(paramViewGroup, new RelativeLayout.LayoutParams(-1, -1));
      }
    }
    for (;;)
    {
      return paramView;
      paramView = (RelativeLayout)PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity).getParent();
      continue;
      localObject1 = (RelativeLayout)paramView;
      paramViewGroup = paramView;
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) == null) {
        break;
      }
      paramViewGroup = paramView;
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity).getParent() != null) {
        break;
      }
      localObject2 = ((RelativeLayout)localObject1).getChildAt(0);
      paramViewGroup = paramView;
      if (localObject2 == null) {
        break;
      }
      paramViewGroup = paramView;
      if (!localObject2.getClass().equals(PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity).getClass())) {
        break;
      }
      paramViewGroup = paramView;
      if (localObject2.equals(PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
        break;
      }
      ((RelativeLayout)localObject1).removeView((View)localObject2);
      ((RelativeLayout)localObject1).addView(PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), 0, new RelativeLayout.LayoutParams(-1, -1));
      return paramView;
      label1211:
      paramView = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return PhotoListActivity.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cja
 * JD-Core Version:    0.7.0.1
 */