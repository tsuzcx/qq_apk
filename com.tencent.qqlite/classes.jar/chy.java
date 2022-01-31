import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;

public class chy
  implements AdapterView.OnItemClickListener
{
  private chy(AlbumListActivity paramAlbumListActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = this.a.a.a(paramInt);
    if ((paramAdapterView == null) || (paramAdapterView.mMediaFileCount <= 0) || (TextUtils.isEmpty(paramAdapterView.name)))
    {
      QQToast.a(this.a, 2131364072, 0).a();
      return;
    }
    paramView = this.a.getIntent();
    paramView.putExtra("ALBUM_ID", paramAdapterView._id);
    paramView.putExtra("ALBUM_NAME", paramAdapterView.name);
    paramView.putExtra("PhotoConst.CURRENT_QUALITY_TYPE", paramView.getIntExtra("PhotoConst.CURRENT_QUALITY_TYPE", 0));
    paramView.putExtra("album_enter_directly", false);
    AlbumListActivity.a(this.a, true);
    paramView.setClass(this.a, PhotoListActivity.class);
    paramView.addFlags(603979776);
    this.a.startActivity(paramView);
    this.a.finish();
    AlbumUtil.a(this.a, true, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     chy
 * JD-Core Version:    0.7.0.1
 */