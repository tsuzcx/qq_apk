import android.content.Intent;
import android.content.res.Resources;
import android.util.Pair;
import android.view.View;
import android.widget.Toast;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPreviewActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.DialogUtil.DialogOnClickAdapter;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.GestureSelectGridView;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class cjb
  implements AdapterView.OnItemClickListener
{
  public cjb(PhotoListActivity paramPhotoListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    int i = 1;
    if (!PhotoListActivity.e(this.a)) {
      PhotoListActivity.c(this.a, true);
    }
    switch (this.a.jdField_a_of_type_Cjg.getItemViewType(paramInt))
    {
    default: 
    case 0: 
    case 1: 
      label218:
      do
      {
        return;
        if (this.a.jdField_a_of_type_Boolean)
        {
          paramAdapterView = this.a.jdField_a_of_type_Cjg.a(paramInt);
          PhotoListActivity.a(this.a, paramAdapterView.a);
          return;
        }
        localObject = this.a.jdField_a_of_type_Cjg;
        LocalMediaInfo localLocalMediaInfo = ((cjg)localObject).a(paramInt);
        paramInt = localLocalMediaInfo.jdField_b_of_type_Int;
        if ((paramInt == 2) && (this.a.jdField_a_of_type_JavaUtilArrayList.size() >= this.a.c))
        {
          QQToast.a(this.a, "最多只能选择" + this.a.c + "张图片", 0).b(this.a.d);
          return;
        }
        String str;
        if (paramInt == 1)
        {
          paramInt = 2;
          localLocalMediaInfo.jdField_b_of_type_Int = paramInt;
          if (localLocalMediaInfo.jdField_b_of_type_Int != 1) {
            break label390;
          }
          paramInt = i;
          str = localLocalMediaInfo.a;
          if (paramInt == 0) {
            break label395;
          }
          this.a.jdField_a_of_type_JavaUtilArrayList.add(str);
          paramView = (LinkedHashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
          paramAdapterView = paramView;
          if (paramView == null)
          {
            paramAdapterView = new LinkedHashMap();
            AlbumUtil.b.put(PhotoListActivity.a(this.a), paramAdapterView);
          }
          paramAdapterView.put(str, Integer.valueOf(this.a.jdField_a_of_type_ComTencentWidgetGestureSelectGridView.q()));
          paramAdapterView = AlbumUtil.c;
          if (!paramAdapterView.containsKey(str)) {
            paramAdapterView.put(str, new Pair(PhotoListActivity.a(this.a), PhotoListActivity.b(this.a)));
          }
        }
        for (;;)
        {
          ((cjg)localObject).notifyDataSetChanged();
          if (PhotoListActivity.b(this.a) == 2) {
            PhotoListActivity.b(this.a, localLocalMediaInfo.a);
          }
          PhotoListActivity.a(this.a);
          return;
          paramInt = 1;
          break;
          paramInt = 0;
          break label218;
          this.a.jdField_a_of_type_JavaUtilArrayList.remove(str);
          paramAdapterView = (HashMap)AlbumUtil.b.get(PhotoListActivity.a(this.a));
          if (paramAdapterView != null) {
            paramAdapterView.remove(str);
          }
          paramAdapterView = AlbumUtil.c;
          if (paramAdapterView.containsKey(str)) {
            paramAdapterView.remove(str);
          }
        }
        if (!this.a.jdField_a_of_type_JavaUtilArrayList.isEmpty())
        {
          paramAdapterView = DialogUtil.a(this.a, 230);
          paramAdapterView.setMessage("不能同时选择照片和视频");
          paramAdapterView.setPositiveButton(2131362795, new DialogUtil.DialogOnClickAdapter());
          paramAdapterView.show();
          return;
        }
        if (!Utils.e())
        {
          Toast.makeText(this.a, this.a.getResources().getString(2131363511), 0).show();
          return;
        }
        paramAdapterView = this.a.jdField_a_of_type_Cjg.a(paramInt);
        if (paramAdapterView.jdField_b_of_type_Long > PhotoListActivity.a(this.a))
        {
          paramAdapterView = DialogUtil.a(this.a, "你选择的视频文件过大，无法发送");
          paramAdapterView.setPositiveButton(2131362795, new DialogUtil.DialogOnClickAdapter());
          paramAdapterView.show();
          return;
        }
        paramView = AlbumUtil.c;
        if (!paramView.containsKey(paramAdapterView.a))
        {
          localObject = new Pair(PhotoListActivity.a(this.a), PhotoListActivity.b(this.a));
          paramView.put(paramAdapterView.a, localObject);
        }
        PhotoListActivity.c(this.a, paramAdapterView.a);
      } while (paramAdapterView == null);
      label390:
      label395:
      if (!PhotoListActivity.f(this.a))
      {
        paramView = this.a.getIntent();
        paramView.putExtra("file_send_path", paramAdapterView.a);
        paramView.putExtra("PhotoConst.IS_VIDEO_SELECTED", true);
        paramView.putExtra("PhotoConst.VIDEO_SIZE", paramAdapterView.jdField_b_of_type_Long);
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramAdapterView.a);
        PhotoUtils.a(this.a, paramView, (ArrayList)localObject, 2, false);
        return;
      }
      paramView = new Intent(this.a, ShortVideoPreviewActivity.class);
      paramView.putExtra("file_send_path", paramAdapterView.a);
      paramView.putExtra("file_send_size", paramAdapterView.jdField_b_of_type_Long);
      paramView.putExtra("file_send_duration", paramAdapterView.e);
      paramView.putExtra("uin", PhotoListActivity.d(this.a));
      paramView.putExtra("uintype", PhotoListActivity.c(this.a));
      paramView.putExtra("file_source", "album");
      Object localObject = this.a.getIntent();
      if (((Intent)localObject).getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
        paramView.putExtras((Intent)localObject);
      }
      paramView.putExtra("PhotoConst.IS_FROM_TROOP_BAR", false);
      paramAdapterView = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localObject = ((Intent)localObject).getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramAdapterView);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", (String)localObject);
      this.a.startActivityForResult(paramView, 17);
      return;
    }
    if (!Utils.e())
    {
      Toast.makeText(this.a, this.a.getResources().getString(2131363511), 0).show();
      return;
    }
    PhotoListActivity.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     cjb
 * JD-Core Version:    0.7.0.1
 */