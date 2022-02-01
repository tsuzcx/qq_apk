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
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.photo.LocalPhotoInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.CameraView;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class emz
  extends BaseAdapter
{
  private Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  public emz(PhotoListActivity paramPhotoListActivity)
  {
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramPhotoListActivity.getLayoutInflater();
    this.jdField_a_of_type_AndroidContentResResources = paramPhotoListActivity.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130839362);
  }
  
  public LocalPhotoInfo a(int paramInt)
  {
    return (LocalPhotoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
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
    if ("file://camera".equals(((LocalPhotoInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).a)) {
      return 1;
    }
    return 0;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      paramViewGroup = paramView;
    }
    label30:
    Object localObject1;
    Object localObject2;
    do
    {
      do
      {
        ImageView localImageView;
        do
        {
          do
          {
            return paramViewGroup;
            if (paramView == null)
            {
              paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903598, null);
              paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b));
              paramViewGroup = new ena(this, null);
              paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131233028));
              paramViewGroup.b = ((ImageView)paramView.findViewById(2131233029));
              paramViewGroup.c = ((ImageView)paramView.findViewById(2131233030));
              paramView.setTag(paramViewGroup);
            }
            for (;;)
            {
              localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetImageView;
              localObject2 = paramViewGroup.b;
              localImageView = paramViewGroup.c;
              ((ImageView)localObject1).setAdjustViewBounds(false);
              LocalPhotoInfo localLocalPhotoInfo = a(paramInt);
              Object localObject3 = AlbumUtil.a(localLocalPhotoInfo, AlbumThumbDownloader.a);
              URLDrawable localURLDrawable = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
              if ((localURLDrawable == null) || (!localURLDrawable.getURL().equals(localObject3)))
              {
                localObject3 = URLDrawable.getDrawable((URL)localObject3, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
                ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
                paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject3);
                if (localURLDrawable != null) {
                  localURLDrawable.cancelDownload();
                }
              }
              switch (localLocalPhotoInfo.e)
              {
              default: 
                ((ImageView)localObject2).setVisibility(4);
                localImageView.setVisibility(4);
                paramViewGroup = paramView;
                if (paramView.getBackground() == null) {
                  break label30;
                }
                paramView.setBackgroundDrawable(null);
                return paramView;
                paramViewGroup = (ena)paramView.getTag();
              }
            }
            ((ImageView)localObject2).setVisibility(0);
            localImageView.setVisibility(0);
            paramViewGroup = paramView;
          } while (paramView.getBackground() == null);
          paramView.setBackgroundDrawable(null);
          return paramView;
          ((ImageView)localObject2).setVisibility(4);
          localImageView.setVisibility(4);
          paramViewGroup = paramView;
        } while (paramView.getBackground() == null);
        paramView.setBackgroundDrawable(null);
        return paramView;
        ((ImageView)localObject2).setVisibility(4);
        localImageView.setVisibility(4);
        if (PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
          break;
        }
        paramViewGroup = paramView;
      } while (paramView.getBackground() != null);
      paramView.setBackgroundResource(2130837681);
      return paramView;
      paramView.setBackgroundDrawable(null);
      return paramView;
      if (!PhotoListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) {
        break;
      }
      paramViewGroup = paramView;
    } while (paramView != null);
    paramView = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    paramView.setPadding(PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity));
    paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b));
    paramViewGroup = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    paramViewGroup.setImageResource(2130838165);
    paramViewGroup.setScaleType(ImageView.ScaleType.CENTER_CROP);
    paramView.addView(paramViewGroup, new RelativeLayout.LayoutParams(-1, -1));
    return paramView;
    if (paramView == null)
    {
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) == null) {
        break label820;
      }
      if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity).getParent() == null)
      {
        paramView = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        paramView.setPadding(PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), PhotoListActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity));
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.a, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b));
        paramView.addView(PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity), new RelativeLayout.LayoutParams(-1, -1));
        paramViewGroup = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        paramViewGroup.setImageResource(2130838165);
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
      label820:
      paramView = null;
    }
  }
  
  public int getViewTypeCount()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emz
 * JD-Core Version:    0.7.0.1
 */