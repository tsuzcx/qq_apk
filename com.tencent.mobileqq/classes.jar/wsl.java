import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import cooperation.weiyun.utils.PreferenceUtils;
import java.util.List;

public class wsl
  implements View.OnClickListener
{
  public wsl(AlbumListActivity paramAlbumListActivity) {}
  
  public void onClick(View paramView)
  {
    if (AlbumListActivity.a(this.a)) {
      PreferenceUtils.a(this.a.getApplicationContext(), this.a.a, "pref_select_album", PreferenceUtils.a(AlbumListActivity.a(this.a).iterator()));
    }
    this.a.onBackPressed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     wsl
 * JD-Core Version:    0.7.0.1
 */