import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.List;
import mqq.app.AppRuntime;

public class wvr
  implements AdapterView.OnItemClickListener
{
  private wvr(AlbumListActivity paramAlbumListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      QQToast.a(this.a, 2131436147, 0).a();
      return;
    }
    if (this.a.h)
    {
      paramView = this.a.getIntent();
      paramView.putExtra("ALBUM_ID", paramAdapterView._id);
      paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramView.putExtra("album_enter_directly", false);
      this.a.setResult(-1, paramView);
      this.a.finish();
      AlbumUtil.a(this.a, true, true);
      return;
    }
    if (AlbumListActivity.a(this.a))
    {
      if (AlbumListActivity.a(this.a).contains(paramAdapterView._id)) {
        AlbumListActivity.a(this.a).remove(paramAdapterView._id);
      }
      for (;;)
      {
        this.a.a.notifyDataSetChanged();
        return;
        if (!TextUtils.isEmpty(paramAdapterView._id)) {
          AlbumListActivity.a(this.a).add(paramAdapterView._id);
        }
      }
    }
    if (paramAdapterView._id == "qzone_album")
    {
      paramView = this.a.getIntent();
      paramAdapterView = paramView.getExtras();
      paramAdapterView.putInt("key_personal_album_enter_model", 1);
      paramAdapterView.putInt("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramAdapterView.putSerializable("PhotoConst.PHOTO_INFOS", paramView.getSerializableExtra("PhotoConst.PHOTO_INFOS"));
      paramAdapterView.putBoolean("PhotoConst.IS_SHOW_QZONE_ALBUM", true);
      paramAdapterView.putLong("PhotoConst.QZONE_ALBUM_NUM", paramView.getLongExtra("PhotoConst.QZONE_ALBUM_NUM", 0L));
      paramAdapterView.putStringArrayList("PhotoConst.PHOTO_PATHS", paramView.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"));
      paramView = QZoneHelper.UserInfo.a();
      paramView.a = BaseApplicationImpl.getApplication().getRuntime().getAccount();
      paramAdapterView.putString("keyAction", "actionSelectPicture");
      paramAdapterView.putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.a(this.a, paramView, paramAdapterView, 0);
      this.a.finish();
      AlbumUtil.a(this.a, true, true);
    }
    while (this.a.i)
    {
      StoryReportor.a("pic_choose_slides", "change_album", 0, 0, new String[0]);
      return;
      paramView = this.a.getIntent();
      paramView.putExtra("ALBUM_ID", paramAdapterView._id);
      paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
      paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
      paramView.putExtra("album_enter_directly", false);
      paramView.putExtra("PhotoConst.ALWAYS_SHOW_NUMBER_WHEN_ONLY_ONE_IMAGE", this.a.b);
      paramView.putExtra("PhotoConst.DISABLE_UPLOAD_TO_TROOP_ALBUM", this.a.d);
      AlbumListActivity.a(this.a, true);
      paramView.setClass(this.a, PhotoListActivity.class);
      paramView.addFlags(603979776);
      this.a.startActivity(paramView);
      if ("$VideoAlbumId".equals(paramAdapterView._id)) {
        ReportController.b(null, "CliOper", "", "", "0X8006131", "0X8006131", 0, 0, "", "", "", "");
      }
      try
      {
        this.a.finish();
        AlbumUtil.a(this.a, true, true);
      }
      catch (Exception paramAdapterView)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("AlbumListActivity", 2, "onItemClick finish() exception=" + paramAdapterView.getMessage());
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wvr
 * JD-Core Version:    0.7.0.1
 */