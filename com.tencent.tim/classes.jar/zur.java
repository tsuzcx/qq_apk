import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;

public class zur
  extends ztp
{
  boolean btG = false;
  
  protected zur(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  public void initData(Intent paramIntent)
  {
    super.initData(paramIntent);
    this.btG = paramIntent.getBooleanExtra("PhotoConst.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES", false);
    if (this.btG)
    {
      this.a.recentImagesMaxCount = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_MAX_COUNT", 100);
      this.a.recentImagesLimitSize = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_SIZE", 0);
      this.a.recentImagesLimitWidth = paramIntent.getIntExtra("PhotoConst.RECENT_IMAGES_LIMIT_WIDTH", -1);
      this.a.recentImagesBlockPaths = paramIntent.getStringArrayListExtra("PhotoConst.RECENT_IMAGES_BLOCK_PATHS");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     zur
 * JD-Core Version:    0.7.0.1
 */