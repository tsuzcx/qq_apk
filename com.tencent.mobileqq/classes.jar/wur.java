import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.transfile.AlbumThumbDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.NumberCheckBox;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class wur
  extends BaseAdapter
  implements URLDrawableDownListener
{
  Resources jdField_a_of_type_AndroidContentResResources;
  ColorDrawable jdField_a_of_type_AndroidGraphicsDrawableColorDrawable = new ColorDrawable(570425344);
  Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public ArrayList a;
  
  public wur(PhotoListActivity paramPhotoListActivity)
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramPhotoListActivity.getLayoutInflater();
    this.jdField_a_of_type_AndroidContentResResources = paramPhotoListActivity.getResources();
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130844380);
  }
  
  private TextView a()
  {
    TextView localTextView = new TextView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
    localTextView.setGravity(17);
    localTextView.setTextSize(10.0F);
    localTextView.setTextColor(-1);
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setShape(0);
    localGradientDrawable.setSize(ViewUtils.b(30.0F), ViewUtils.b(18.0F));
    localGradientDrawable.setCornerRadii(new float[] { ViewUtils.b(2.0F), ViewUtils.b(2.0F), 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F });
    localGradientDrawable.setColor(1291845632);
    localTextView.setBackgroundDrawable(localGradientDrawable);
    return localTextView;
  }
  
  private boolean a()
  {
    return PhotoListActivity.l(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
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
    return AlbumUtil.a((LocalMediaInfo)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt));
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    switch (i)
    {
    default: 
      return paramView;
    case 0: 
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970484, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int));
        paramViewGroup = new wus(this);
        paramViewGroup.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370840));
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131370847));
        paramViewGroup.c = ((ImageView)paramView.findViewById(2131370842));
        paramViewGroup.d = ((ImageView)paramView.findViewById(2131369348));
        paramViewGroup.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131370845);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)paramView.findViewById(2131370846));
        paramViewGroup.jdField_a_of_type_Wup = new wup(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        if (paramViewGroup.jdField_a_of_type_AndroidViewView != null) {
          paramViewGroup.jdField_a_of_type_AndroidViewView.setOnClickListener(paramViewGroup.jdField_a_of_type_Wup);
        }
        paramView.setTag(paramViewGroup);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.i) {
          break label1578;
        }
        paramViewGroup.jdField_a_of_type_AndroidViewView.setVisibility(0);
      }
      break;
    }
    label401:
    label670:
    label1315:
    label1578:
    for (;;)
    {
      paramViewGroup.jdField_a_of_type_Wup.a(paramInt);
      paramViewGroup.jdField_a_of_type_Wup.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
      Object localObject2 = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
      ((ImageView)localObject2).setAdjustViewBounds(false);
      Object localObject1 = a(paramInt);
      paramView.setContentDescription(PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt));
      label309:
      Object localObject3;
      int j;
      Object localObject4;
      if (localObject1 != null)
      {
        if ((((LocalMediaInfo)localObject1).isPanoramaPhoto()) && ((PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)))) {
          paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        }
      }
      else
      {
        if ((!a()) || (!PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject1))) {
          break label670;
        }
        if (paramViewGroup.jdField_b_of_type_AndroidWidgetTextView == null)
        {
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView = a();
          paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setText("GIF");
          localObject3 = new RelativeLayout.LayoutParams(-2, -2);
          ((RelativeLayout.LayoutParams)localObject3).addRule(11);
          ((RelativeLayout.LayoutParams)localObject3).addRule(12);
          ((RelativeLayout)paramView).addView(paramViewGroup.jdField_b_of_type_AndroidWidgetTextView, (ViewGroup.LayoutParams)localObject3);
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
        j = AlbumThumbDownloader.a;
        ((LocalMediaInfo)localObject1).thumbHeight = j;
        ((LocalMediaInfo)localObject1).thumbWidth = j;
        localObject3 = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
        localObject4 = new StringBuilder("albumthumb");
        ((StringBuilder)localObject4).append("://");
        ((StringBuilder)localObject4).append(((LocalMediaInfo)localObject1).path);
        if ((localObject3 == null) || (!((URLDrawable)localObject3).getURL().toString().equals(((StringBuilder)localObject4).toString())))
        {
          localObject4 = URLDrawableHelper.a(AlbumUtil.a((LocalMediaInfo)localObject1), this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject4).setTag(localObject1);
          ((ImageView)localObject2).setImageDrawable((Drawable)localObject4);
          ((URLImageView)localObject2).setURLDrawableDownListener(this);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject4);
          if (localObject3 != null) {
            ((URLDrawable)localObject3).cancelDownload();
          }
        }
        localObject2 = paramViewGroup.c;
        j = ((LocalMediaInfo)localObject1).selectStatus;
        if (j != 1) {
          break label689;
        }
        ((ImageView)localObject2).setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.indexOf(((LocalMediaInfo)localObject1).path) + 1);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
      }
      for (;;)
      {
        if (AppSetting.b)
        {
          localObject2 = PhotoUtils.a(i, (LocalMediaInfo)localObject1, paramInt, paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.isChecked());
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setContentDescription((CharSequence)localObject2);
        }
        ((LocalMediaInfo)localObject1).visableTime = SystemClock.uptimeMillis();
        ((LocalMediaInfo)localObject1).listViewPosition = paramInt;
        return paramView;
        paramViewGroup = (wus)paramView.getTag();
        break;
        paramViewGroup.jdField_a_of_type_AndroidWidgetImageView.setVisibility(4);
        break label309;
        if (paramViewGroup.jdField_b_of_type_AndroidWidgetTextView == null) {
          break label401;
        }
        paramViewGroup.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        break label401;
        label689:
        if (j == 3)
        {
          ((ImageView)localObject2).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.y)
          {
            if (paramView.getBackground() == null) {
              paramView.setBackgroundResource(2130837753);
            }
          }
          else {
            paramView.setBackgroundDrawable(null);
          }
        }
        else
        {
          ((ImageView)localObject2).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
      }
      if (paramView == null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130970633, null);
        ((View)localObject1).setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int));
        localObject2 = new wus(this);
        ((wus)localObject2).jdField_b_of_type_AndroidWidgetImageView = ((ImageView)((View)localObject1).findViewById(2131370840));
        ((wus)localObject2).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject1).findViewById(2131371446));
        ((wus)localObject2).c = ((ImageView)((View)localObject1).findViewById(2131370842));
        ((wus)localObject2).d = ((ImageView)((View)localObject1).findViewById(2131369348));
        ((wus)localObject2).jdField_a_of_type_AndroidViewView = ((View)localObject1).findViewById(2131370845);
        ((wus)localObject2).jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox = ((NumberCheckBox)((View)localObject1).findViewById(2131370846));
        ((wus)localObject2).jdField_a_of_type_Wup = new wup(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        if (((wus)localObject2).jdField_a_of_type_AndroidViewView != null) {
          ((wus)localObject2).jdField_a_of_type_AndroidViewView.setOnClickListener(((wus)localObject2).jdField_a_of_type_Wup);
        }
        ((View)localObject1).setTag(localObject2);
        paramViewGroup = (ViewGroup)localObject2;
        paramView = (View)localObject1;
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.i)
        {
          paramViewGroup = (ViewGroup)localObject2;
          paramView = (View)localObject1;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.I)
          {
            ((wus)localObject2).jdField_a_of_type_AndroidViewView.setVisibility(0);
            paramView = (View)localObject1;
            paramViewGroup = (ViewGroup)localObject2;
          }
        }
        paramViewGroup.jdField_a_of_type_Wup.a(paramInt);
        paramViewGroup.jdField_a_of_type_Wup.a(paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox);
        localObject3 = paramViewGroup.jdField_b_of_type_AndroidWidgetImageView;
        ((ImageView)localObject3).setAdjustViewBounds(false);
        localObject2 = a(paramInt);
        paramView.setContentDescription(PhotoUtils.a(i, (LocalMediaInfo)localObject2, paramInt));
        if (((LocalMediaInfo)localObject2).isSystemMeidaStore != true) {
          break label1315;
        }
        localObject1 = AlbumUtil.a((LocalMediaInfo)localObject2, "VIDEO");
        label1074:
        i = AlbumThumbDownloader.a;
        ((LocalMediaInfo)localObject2).thumbHeight = i;
        ((LocalMediaInfo)localObject2).thumbWidth = i;
        localObject4 = paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable;
        if ((localObject4 == null) || (!((URLDrawable)localObject4).getURL().equals(localObject1)))
        {
          localObject1 = URLDrawableHelper.a((URL)localObject1, this.jdField_a_of_type_AndroidGraphicsDrawableColorDrawable, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
          ((URLDrawable)localObject1).setTag(localObject2);
          ((ImageView)localObject3).setImageDrawable((Drawable)localObject1);
          ((URLImageView)localObject3).setURLDrawableDownListener(this);
          paramViewGroup.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
          if (localObject4 != null) {
            ((URLDrawable)localObject4).cancelDownload();
          }
        }
        localObject1 = paramViewGroup.jdField_a_of_type_AndroidWidgetTextView;
        if ((((LocalMediaInfo)localObject2).isSystemMeidaStore) || (((LocalMediaInfo)localObject2).mDuration > 0L)) {
          break label1328;
        }
        ((TextView)localObject1).setVisibility(8);
        localObject1 = MediaScanner.a(BaseApplicationImpl.getContext());
        if (localObject1 != null) {
          ((MediaScanner)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2, paramInt);
        }
        label1227:
        localObject1 = paramViewGroup.c;
        i = ((LocalMediaInfo)localObject2).selectStatus;
        if (i != 1) {
          break label1351;
        }
        ((ImageView)localObject1).setVisibility(0);
        paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setCheckedNumber(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.indexOf(((LocalMediaInfo)localObject2).path) + 1);
        if (paramView.getBackground() != null) {
          paramView.setBackgroundDrawable(null);
        }
      }
      for (;;)
      {
        ((LocalMediaInfo)localObject2).visableTime = SystemClock.uptimeMillis();
        ((LocalMediaInfo)localObject2).listViewPosition = paramInt;
        return paramView;
        paramViewGroup = (wus)paramView.getTag();
        break;
        localObject1 = AlbumUtil.a((LocalMediaInfo)localObject2, "APP_VIDEO");
        break label1074;
        label1328:
        ((TextView)localObject1).setVisibility(0);
        ((TextView)localObject1).setText(a(((LocalMediaInfo)localObject2).mDuration));
        break label1227;
        label1351:
        if (i == 3)
        {
          ((ImageView)localObject1).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.y)
          {
            if (paramView.getBackground() == null) {
              paramView.setBackgroundResource(2130837753);
            }
          }
          else {
            paramView.setBackgroundDrawable(null);
          }
        }
        else
        {
          ((ImageView)localObject1).setVisibility(4);
          paramViewGroup.jdField_a_of_type_ComTencentMobileqqWidgetNumberCheckBox.setChecked(false);
          if (paramView.getBackground() != null) {
            paramView.setBackgroundDrawable(null);
          }
        }
      }
      if ((PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)))
      {
        if (paramView != null) {
          break;
        }
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130971239, null);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int));
        PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, 1);
        return paramView;
      }
      if (paramView == null)
      {
        paramView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
        paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int));
      }
      for (;;)
      {
        paramViewGroup = (ImageView)paramView;
        paramView.setBackgroundColor(-16777216);
        paramViewGroup.setImageResource(2130839551);
        paramViewGroup.setScaleType(ImageView.ScaleType.CENTER);
        return paramView;
      }
    }
  }
  
  public int getViewTypeCount()
  {
    return AlbumUtil.d.size();
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    new Rect();
    paramView = (LocalMediaInfo)paramURLDrawable.getTag();
    int i = paramView.listViewPosition;
    if ((i == -1) || (paramView.visableTime == 0L)) {}
    long l1;
    long l2;
    do
    {
      return;
      l1 = SystemClock.uptimeMillis();
      l2 = paramView.visableTime;
    } while (!QLog.isColorLevel());
    QLog.d("PhotoListActivity", 2, "onLoadSuccessed,no next ,listViewPositon:" + i + " costTime:" + (l1 - l2) + " imageInfo;" + paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wur
 * JD-Core Version:    0.7.0.1
 */