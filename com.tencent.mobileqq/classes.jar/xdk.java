import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideShowPhotoListManager;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MimeHelper;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity.onSelectionChangeListener;
import com.tencent.mobileqq.activity.photo.StatisticConstants;
import com.tencent.mobileqq.activity.richmedia.QQStoryFlowCallback;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.GestureSelectGridView;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;

public class xdk
  implements View.OnClickListener
{
  int jdField_a_of_type_Int;
  CheckBox jdField_a_of_type_AndroidWidgetCheckBox;
  
  public xdk(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void a(CheckBox paramCheckBox)
  {
    this.jdField_a_of_type_AndroidWidgetCheckBox = paramCheckBox;
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_i_of_type_Boolean) {}
    Object localObject2;
    int i;
    do
    {
      long l;
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListActivity", 2, "current select count:" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.size());
        }
        localObject2 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Xdm.a(this.jdField_a_of_type_Int);
        i = ((LocalMediaInfo)localObject2).selectStatus;
        if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.J) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.k == 9501) && (i == 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.size() >= 1))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "最多只能选择1张图片", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
          return;
        }
        if ((i == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.size() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_i_of_type_Int)) {
          break;
        }
        l = System.currentTimeMillis();
      } while (l - this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Long < 1000L);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
      this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_Long = l;
      PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity);
      return;
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.k == 9501) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getBooleanExtra("PhotoConst.IS_SEND_FILESIZE_LIMIT", false)) && (i != 1))
      {
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.iterator();
        for (l = 0L; paramView.hasNext(); l = FileUtils.a((String)paramView.next()) + l) {}
        if (FileUtils.a(((LocalMediaInfo)localObject2).path) + l > 52428800L)
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "选择图片总大小不能超过50M", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
          this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
          return;
        }
      }
      if ((PhotoListActivity.f(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) && (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) != -1L) && (i != 1))
      {
        if ((AlbumUtil.a((LocalMediaInfo)localObject2) == 1) && (((LocalMediaInfo)localObject2).mDuration > this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Long))
        {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "请选择时长在" + this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Long / 1000L / 60L + "分钟以内的视频", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
          return;
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.iterator();
        for (l = 0L; paramView.hasNext(); l = FileUtils.a((String)paramView.next()) + l) {}
        if (FileUtils.a(((LocalMediaInfo)localObject2).path) + l > PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) * 1024L * 1024L)
        {
          localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
          localObject2 = new StringBuilder().append("最多上传");
          if (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) < 1024L) {}
          for (paramView = PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) + "MB";; paramView = (float)PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity) / 1024.0F + "G")
          {
            QQToast.a((Context)localObject1, paramView + "大小的图片和视频", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
            this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
            return;
          }
        }
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getBooleanExtra("PhotoConst.IS_SEND_GIF_SIZE_LIMIT", false)) && (PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2)) && (FileUtils.a(((LocalMediaInfo)localObject2).path) > 3145728L))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, "图片文件过大", 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
        this.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(false);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.P) && (!QQStoryFlowCallback.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, (LocalMediaInfo)localObject2)));
    if (i == 1)
    {
      i = 2;
      ((LocalMediaInfo)localObject2).selectStatus = i;
      if (((LocalMediaInfo)localObject2).selectStatus != 1) {
        break label891;
      }
    }
    String str;
    label891:
    for (boolean bool = true;; bool = false)
    {
      str = ((LocalMediaInfo)localObject2).path;
      paramView = PresendPicMgr.a();
      if (!bool) {
        break label1514;
      }
      localObject1 = MimeHelper.a(((LocalMediaInfo)localObject2).mMimeType);
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.K) || (localObject1 == null) || (!"video".equals(localObject1[0]))) {
        break label939;
      }
      if (AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, PhotoListActivity.a(), (LocalMediaInfo)localObject2, PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
        break label897;
      }
      ((LocalMediaInfo)localObject2).selectStatus = 2;
      return;
      i = 1;
      break;
    }
    label897:
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
    ((PhotoListActivity)localObject1).p += 1;
    PhotoListActivity.b();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.p == 1) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
    }
    label939:
    if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
      ((PhotoListActivity)localObject1).q += 1;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.add(str);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilArrayList.add(((LocalMediaInfo)localObject2).position);
    this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilHashMap.put(str, Integer.valueOf(((LocalMediaInfo)localObject2).panoramaPhotoType));
    if ((PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilHashMap.put(str, localObject2);
    }
    if (paramView != null) {
      paramView.a(str, 1007, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent().getIntExtra("entrance", 0));
    }
    StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent(), "param_totalSelNum");
    paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent();
    if (!paramView.hasExtra("param_initTime")) {
      paramView.putExtra("param_initTime", System.currentTimeMillis());
    }
    localObject1 = (LinkedHashMap)AlbumUtil.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b);
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      paramView = new LinkedHashMap();
      AlbumUtil.b.put(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b, paramView);
    }
    paramView.put(str, Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition()));
    paramView = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
    if (!paramView.containsKey(str)) {
      paramView.put(str, new Pair(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_JavaLangString));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity$onSelectionChangeListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity$onSelectionChangeListener.a(bool, (LocalMediaInfo)localObject2);
      }
      PhotoListActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_Int, bool);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.l == 2) && (new File(((LocalMediaInfo)localObject2).path).length() > 19922944L))
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity, this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getResources().getString(2131435938), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.n);
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.l = 0;
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.g();
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.e();
      if ((!this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.P) || (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager == null)) {
        break;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager.a().isEmpty())
      {
        i = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
        paramView = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getChildAt(this.jdField_a_of_type_Int - i);
        if ((paramView != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getHeight() - paramView.getY() < this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_Int)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.smoothScrollBy(SlideShowPhotoListManager.jdField_a_of_type_Int, 500);
        }
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentBizQqstoryTakevideoSlideshowSlideShowPhotoListManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList);
      return;
      label1514:
      localObject1 = MimeHelper.a(((LocalMediaInfo)localObject2).mMimeType);
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.K) && (localObject1 != null) && ("video".equals(localObject1[0])))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
        ((PhotoListActivity)localObject1).p -= 1;
        PhotoListActivity.c();
        if (this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.p == 1) {
          this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo = ((LocalMediaInfo)localObject2);
        }
      }
      if ((!TextUtils.isEmpty(((LocalMediaInfo)localObject2).mMimeType)) && ("image/gif".equals(((LocalMediaInfo)localObject2).mMimeType)))
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity;
        ((PhotoListActivity)localObject1).q -= 1;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilArrayList.remove(str);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilArrayList.remove(((LocalMediaInfo)localObject2).position);
      this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_d_of_type_JavaUtilHashMap.remove(str);
      if ((PhotoListActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity)) || (PhotoListActivity.g(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity))) {
        this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.jdField_c_of_type_JavaUtilHashMap.remove(str);
      }
      if (paramView != null) {
        paramView.b(str, 1013);
      }
      StatisticConstants.a(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.getIntent(), "param_cancelSelNum");
      paramView = (HashMap)AlbumUtil.b.get(this.jdField_a_of_type_ComTencentMobileqqActivityPhotoPhotoListActivity.b);
      if (paramView != null) {
        paramView.remove(str);
      }
      paramView = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (paramView.containsKey(str)) {
        paramView.remove(str);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xdk
 * JD-Core Version:    0.7.0.1
 */