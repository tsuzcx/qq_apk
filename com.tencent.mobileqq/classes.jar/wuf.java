import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.MediaScanner;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import cooperation.qzone.QZoneHelper;
import java.util.ArrayList;
import java.util.HashMap;

public class wuf
  implements AdapterView.OnItemClickListener
{
  public wuf(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.a.y) {
      this.a.y = true;
    }
    switch (this.a.jdField_a_of_type_Wur.getItemViewType(paramInt))
    {
    default: 
    case 0: 
    case 1: 
      label554:
      label1092:
      String str;
      int i;
      label1399:
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!this.a.i) {
                break label554;
              }
              paramAdapterView = this.a.jdField_a_of_type_Wur.a(paramInt);
              if ((!this.a.P) || ((paramAdapterView.mediaWidth >= 320) && (paramAdapterView.mediaHeight >= 320))) {
                break;
              }
              paramAdapterView = DialogUtil.a(this.a, 230, null, "图片过小，请重新上传（最小需要320x320）", "好的", null, null, new wug(this));
              try
              {
                paramAdapterView.show();
                return;
              }
              catch (Exception paramAdapterView) {}
            } while (!QLog.isColorLevel());
            QLog.d("PhotoListActivity", 2, "showLocationFailDialog fail!", paramAdapterView);
            return;
            if ((this.a.G) && (paramAdapterView.mediaWidth > 0) && (paramAdapterView.mediaHeight > 0))
            {
              if ((this.a.jdField_a_of_type_Double > 0.0D) && ((paramAdapterView.mediaHeight * 1.0F / paramAdapterView.mediaWidth < this.a.jdField_b_of_type_Double) || (paramAdapterView.mediaHeight * 1.0F / paramAdapterView.mediaWidth > this.a.jdField_a_of_type_Double)))
              {
                QQToast.a(this.a, this.a.getResources().getString(2131434786), 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
                return;
              }
              if ((this.a.o > 0) && (paramAdapterView.fileSize > this.a.o))
              {
                QQToast.a(this.a, this.a.getResources().getString(2131434787, new Object[] { Integer.valueOf(this.a.o / 1048576) }), 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
                return;
              }
            }
            if ((PhotoListActivity.h(this.a)) && (paramAdapterView.mediaWidth > 0) && (paramAdapterView.mediaHeight > 0) && (this.a.o > 0) && (paramAdapterView.fileSize > this.a.o))
            {
              QQToast.a(this.a, this.a.getResources().getString(2131434787, new Object[] { Integer.valueOf(this.a.o / 1048576) }), 0).b(this.a.getResources().getDimensionPixelSize(2131558448));
              return;
            }
            if (this.a.M)
            {
              this.a.c();
              MediaScanner.a(BaseApplicationImpl.getContext()).a(new wuh(this, paramInt), paramAdapterView);
              return;
            }
            if (this.a.O)
            {
              this.a.c();
              MediaScanner.a(BaseApplicationImpl.getContext()).a(new wui(this, paramInt), paramAdapterView);
              return;
            }
            this.a.a(paramAdapterView, paramInt);
            return;
            AlbumUtil.a();
            paramAdapterView = this.a.getIntent();
            paramAdapterView.putExtra("ALBUM_NAME", this.a.jdField_a_of_type_JavaLangString);
            paramAdapterView.putExtra("ALBUM_ID", this.a.jdField_b_of_type_JavaLangString);
            if (this.a.N)
            {
              paramAdapterView.putExtra("PhotoConst.IS_OVERLOAD", false);
              paramAdapterView.putExtra("PhotoConst.IS_FROM_QQSTORY_SLIDESHOW", true);
              paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
              paramAdapterView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
              paramAdapterView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.a.jdField_d_of_type_JavaUtilArrayList);
              paramAdapterView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
              paramAdapterView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.l);
              paramAdapterView.putExtra("PhotoConst.SHOW_ALBUM", true);
              paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.p);
              paramAdapterView.putExtra("PasterConstants.paster_id", this.a.jdField_c_of_type_JavaLangString);
              paramAdapterView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_d_of_type_JavaLangString);
              PhotoListActivity.m = this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
              paramView = this.a.jdField_a_of_type_Wur.a(paramInt);
              if (AlbumUtil.a(paramView) == 0) {
                paramAdapterView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", paramView.position);
              }
              if ((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.g(this.a)))
              {
                if (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(paramView.path)) {
                  this.a.jdField_c_of_type_JavaUtilHashMap.put(paramView.path, paramView);
                }
                paramAdapterView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.a.jdField_c_of_type_JavaUtilHashMap);
              }
              paramAdapterView.putExtra("PasterConstants.pasters_data", this.a.jdField_e_of_type_JavaUtilHashMap);
              paramAdapterView.setClass(this.a, PhotoPreviewActivity.class);
              paramAdapterView.putExtra("from_qzone", PhotoListActivity.b(this.a));
              if (PhotoListActivity.i(this.a)) {
                paramAdapterView.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
              }
              paramAdapterView.addFlags(603979776);
              if (PhotoListActivity.e(this.a)) {
                paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", PhotoListActivity.e(this.a));
              }
              if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
                ReportController.b(null, "CliOper", "", this.a.jdField_e_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.a.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
              }
              if (!PhotoListActivity.c(this.a)) {
                break label1092;
              }
              this.a.startActivityForResult(paramAdapterView, 100010);
            }
            for (;;)
            {
              AlbumUtil.a(this.a, true, true);
              return;
              paramAdapterView.putExtra("PhotoConst.IS_OVERLOAD", this.a.x);
              if (this.a.x) {
                break;
              }
              paramAdapterView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
              break;
              if (this.a.J)
              {
                paramAdapterView.putExtra("from_health", true);
                this.a.startActivityForResult(paramAdapterView, 100010);
              }
              else
              {
                this.a.startActivity(paramAdapterView);
                PhotoListActivity.b(this.a);
              }
            }
            if ((!this.a.I) && (!this.a.jdField_c_of_type_JavaUtilArrayList.isEmpty()))
            {
              paramAdapterView = DialogUtil.a(this.a, 230);
              paramAdapterView.setMessage("不能同时选择照片和视频");
              paramAdapterView.setPositiveButton(2131432999, new DialogUtil.DialogOnClickAdapter());
              paramAdapterView.show();
              return;
            }
            if (!Utils.a())
            {
              QQToast.a(this.a, this.a.getResources().getString(2131434753), 0).a();
              return;
            }
            paramView = this.a.jdField_a_of_type_Wur.a(paramInt);
          } while (paramView == null);
          paramAdapterView = this.a.getIntent();
          localObject = paramAdapterView.getStringExtra("PhotoConst.PLUGIN_APK");
          str = paramAdapterView.getStringExtra("video_refer");
          i = 0;
          if (!TextUtils.isEmpty(str))
          {
            if ((!str.contains("QZonePublishMoodTabActivity")) && (!str.contains("QZoneUploadPhotoActivity"))) {
              break label1399;
            }
            i = 1;
          }
          while (i != 0)
          {
            paramLong = paramAdapterView.getLongExtra("PhotoConst.PHOTOLIST_KEY_VIDEO_CAN_UPLOAD_DURATION", 9223372036854775807L);
            if (paramView.mDuration > paramLong)
            {
              paramAdapterView = "请上传不超过" + paramLong / 60L / 1000L + "分钟的视频";
              QQToast.a(this.a, paramAdapterView, 0).b(this.a.e());
              return;
              i = 0;
            }
            else
            {
              paramLong = QZoneHelper.b();
              if (paramView.fileSize > paramLong)
              {
                QQToast.a(this.a, "请上传不超过" + (float)paramLong / 1024.0F / 1024.0F / 1024.0F + "G的视频", 0).b(this.a.e());
                return;
              }
            }
          }
          if ((this.a.K) || (i != 0) || (paramView.fileSize <= this.a.jdField_b_of_type_Long) || (this.a.L) || (PhotoListActivity.f(this.a))) {
            break;
          }
          paramAdapterView = DialogUtil.a(this.a, "你选择的视频文件过大，无法发送。");
          paramAdapterView.setPositiveButton(2131432999, new DialogUtil.DialogOnClickAdapter());
          paramAdapterView.show();
        } while (!this.a.F);
        paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
        paramView = new Intent("key_video_size_overflow");
        paramView.putExtra("className", paramAdapterView);
        this.a.sendBroadcast(paramView);
        return;
        if (((!this.a.G) && (!this.a.F)) || (paramView.mDuration - this.a.jdField_c_of_type_Long <= 999L)) {
          break;
        }
        paramAdapterView = DialogUtil.a(this.a, "你选择的视频时间过长，无法发送");
        paramAdapterView.setPositiveButton(2131432999, new DialogUtil.DialogOnClickAdapter());
        paramAdapterView.show();
        paramAdapterView = this.a.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      } while (!this.a.F);
      paramView = new Intent("key_video_time_overflow");
      paramView.putExtra("className", paramAdapterView);
      this.a.sendBroadcast(paramView);
      return;
      HashMap localHashMap = AlbumUtil.jdField_c_of_type_JavaUtilHashMap;
      if (!localHashMap.containsKey(paramView.path))
      {
        Pair localPair = new Pair(this.a.jdField_b_of_type_JavaLangString, this.a.jdField_a_of_type_JavaLangString);
        localHashMap.put(paramView.path, localPair);
      }
      this.a.a(paramView.path);
      if (("cover_mall_record_video".equals(str)) && (paramView.mDuration / 1000L > this.a.jdField_d_of_type_Long / 1000L))
      {
        paramAdapterView = "视频时间不能超过" + this.a.jdField_d_of_type_Long / 1000L + "s，请重新选择";
        QQToast.a(this.a, paramAdapterView, 0).b(this.a.e());
        QLog.i("PhotoListActivity", 1, "QQToast:" + paramAdapterView);
        return;
      }
      if ("qzone_plugin.apk".equals(localObject))
      {
        if (paramAdapterView.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME").contains("TrimVideoActivity")) {
          break label2222;
        }
        if ((!this.a.g) && (paramView.mDuration <= this.a.jdField_c_of_type_Long) && (!PhotoListActivity.d(this.a)) && ((!PhotoListActivity.e(this.a)) || (!PhotoListActivity.jdField_a_of_type_Boolean))) {
          break label2148;
        }
        this.a.f = true;
      }
      for (;;)
      {
        if (this.a.f) {
          break label2366;
        }
        paramAdapterView.putExtra("file_send_path", paramView.path);
        paramAdapterView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
        paramAdapterView.putExtra("PhotoConst.VIDEO_SIZE", paramView.fileSize);
        paramAdapterView.putExtra("file_send_duration", paramView.mDuration);
        paramAdapterView.putExtra("file_width", paramView.mediaWidth);
        paramAdapterView.putExtra("file_height", paramView.mediaHeight);
        paramAdapterView.putExtra("media_info", paramView);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramView.path);
        if (!this.a.M) {
          break;
        }
        this.a.c();
        MediaScanner.a(BaseApplicationImpl.getContext()).a(new wuj(this, paramAdapterView, (ArrayList)localObject), paramView);
        return;
        label2148:
        this.a.f = false;
        paramAdapterView.putExtra("support_record", false);
        paramAdapterView.putExtra("support_trim", true);
        paramAdapterView.putExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        paramAdapterView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", "cooperation.qzone.QZoneVideoDownloadActivity");
        paramAdapterView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.p);
      }
      label2222:
      Object localObject = this.a;
      if (paramView.mDuration > this.a.jdField_c_of_type_Long) {}
      for (boolean bool = true;; bool = false)
      {
        ((PhotoListActivity)localObject).f = bool;
        paramAdapterView.putExtra("PhotoConst.IS_PREVIEW_VIDEO", this.a.f);
        break;
      }
      if (this.a.O)
      {
        this.a.c();
        MediaScanner.a(BaseApplicationImpl.getContext()).a(new wuk(this, paramInt), paramView);
        return;
      }
      if (PhotoListActivity.j(this.a))
      {
        this.a.c();
        MediaScanner.a(BaseApplicationImpl.getContext()).a(new wul(this, paramAdapterView, (ArrayList)localObject), paramView);
        return;
      }
      PhotoUtils.a(this.a, paramAdapterView, (ArrayList)localObject, 2, false);
      return;
      label2366:
      if (((PhotoListActivity.d(this.a)) || (PhotoListActivity.e(this.a)) || (PhotoListActivity.k(this.a)) || (PhotoListActivity.f(this.a))) && (this.a.I))
      {
        paramView = this.a.getIntent();
        paramView.putExtra("ALBUM_NAME", this.a.jdField_a_of_type_JavaLangString);
        paramView.putExtra("ALBUM_ID", this.a.jdField_b_of_type_JavaLangString);
        paramView.putExtra("PhotoConst.IS_OVERLOAD", this.a.x);
        if (!this.a.x) {
          paramView.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_b_of_type_JavaUtilArrayList);
        }
        paramView.putStringArrayListExtra("PhotoConst.SELECTED_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
        paramView.putIntegerArrayListExtra("PhotoConst.SELECTED_INDEXS", this.a.jdField_d_of_type_JavaUtilArrayList);
        paramView.putExtra("FROM_WHERE", "FROM_PHOTO_LIST");
        paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", this.a.l);
        paramView.putExtra("PhotoConst.SHOW_ALBUM", true);
        paramView.putExtra("PhotoConst.SHOW_MAGIC_USE_PASTER", this.a.p);
        paramView.putExtra("PasterConstants.paster_id", this.a.jdField_c_of_type_JavaLangString);
        paramView.putExtra("PasterConstants.paster_cate_id", this.a.jdField_d_of_type_JavaLangString);
        PhotoListActivity.m = this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.getFirstVisiblePosition();
        localObject = this.a.jdField_a_of_type_Wur.a(paramInt);
        paramView.putExtra("PhotoConst.CURRENT_SELECTED_INDEX", ((LocalMediaInfo)localObject).position);
        if (!this.a.jdField_c_of_type_JavaUtilHashMap.containsKey(((LocalMediaInfo)localObject).path)) {
          this.a.jdField_c_of_type_JavaUtilHashMap.put(((LocalMediaInfo)localObject).path, localObject);
        }
        paramView.putExtra("PeakConstants.selectedMediaInfoHashMap", this.a.jdField_c_of_type_JavaUtilHashMap);
        paramView.putExtra("PasterConstants.pasters_data", this.a.jdField_e_of_type_JavaUtilHashMap);
        paramView.setClass(this.a, PhotoPreviewActivity.class);
        if (PhotoListActivity.e(this.a)) {
          paramAdapterView.putExtra("PhotoConst.IS_FROM_SHUOSHUO", PhotoListActivity.e(this.a));
        }
        paramView.putExtra("from_qzone", PhotoListActivity.b(this.a));
        paramView.putExtra("PhotoConst.PHOTOLIST_IS_FROM_HWUPLOAD", PhotoListActivity.f(this.a));
        paramView.addFlags(603979776);
        if ((this.a.jdField_c_of_type_JavaUtilArrayList != null) && (this.a.jdField_c_of_type_JavaUtilArrayList.size() > 0)) {
          ReportController.b(null, "CliOper", "", this.a.jdField_e_of_type_JavaLangString, "0X8005674", "0X8005674", 0, this.a.jdField_c_of_type_JavaUtilArrayList.size(), 0, "", "", "", "");
        }
        this.a.startActivity(paramView);
        PhotoListActivity.c(this.a);
        AlbumUtil.a(this.a, true, true);
        return;
      }
      localObject = new Intent(this.a, ShortVideoPreviewActivity.class);
      ((Intent)localObject).putExtras(paramAdapterView);
      ((Intent)localObject).putExtra("file_send_path", paramView.path);
      ((Intent)localObject).putExtra("file_send_size", paramView.fileSize);
      ((Intent)localObject).putExtra("file_send_duration", paramView.mDuration);
      ((Intent)localObject).putExtra("file_width", paramView.mediaWidth);
      ((Intent)localObject).putExtra("file_height", paramView.mediaHeight);
      ((Intent)localObject).putExtra("uin", this.a.j);
      ((Intent)localObject).putExtra("uintype", this.a.k);
      ((Intent)localObject).putExtra("file_source", "album");
      ((Intent)localObject).putExtra("is_from_system_media", paramView.isSystemMeidaStore);
      ((Intent)localObject).putExtra("PhotoConst.IS_FROM_TROOP_BAR", this.a.F);
      if (this.a.K)
      {
        ((Intent)localObject).putExtra("from_health", true);
        paramInt = ((Intent)localObject).getIntExtra("size_before_compress", 104857600);
        i = ((Intent)localObject).getIntExtra("duration_max", 180000);
        if ((paramView.fileSize > paramInt) || (paramView.mDuration > i))
        {
          QQToast.a(this.a, "视频文件过大，无法发送", 0).b(this.a.e());
          return;
        }
      }
      if (this.a.L)
      {
        ((Intent)localObject).putExtra("readinjoy_video", true);
        if (((float)paramView.mDuration / 1000.0F <= 3.0F) || ((float)paramView.mDuration / 1000.0F >= 600.0F))
        {
          QQToast.a(this.a, "请上传3秒至10分钟的视频", 0).b(this.a.e());
          return;
        }
      }
      if (this.a.I)
      {
        ((Intent)localObject).putExtra("PhotoConst.IS_SUPPORT_VIDEO_CHECKBOX", true);
        ((Intent)localObject).putExtra("PhotoConst.PHOTO_PATHS", this.a.jdField_c_of_type_JavaUtilArrayList);
      }
      if (((PhotoListActivity.d(this.a)) || ((PhotoListActivity.e(this.a)) && (PhotoListActivity.jdField_a_of_type_Boolean) && (!PhotoListActivity.jdField_b_of_type_Boolean))) && (this.a.I)) {
        ((Intent)localObject).putExtra("preview_only", true);
      }
      this.a.startActivityForResult((Intent)localObject, 17);
      return;
    }
    if (!Utils.a())
    {
      QQToast.a(this.a, this.a.getResources().getString(2131434753), 0).a();
      return;
    }
    if (this.a.J)
    {
      paramAdapterView = new Intent();
      paramAdapterView.putStringArrayListExtra("img_list", this.a.jdField_c_of_type_JavaUtilArrayList);
      this.a.setResult(16, paramAdapterView);
      this.a.finish();
      return;
    }
    if ((PhotoListActivity.e(this.a)) || (PhotoListActivity.d(this.a)))
    {
      PhotoListActivity.d(this.a);
      return;
    }
    this.a.h();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wuf
 * JD-Core Version:    0.7.0.1
 */