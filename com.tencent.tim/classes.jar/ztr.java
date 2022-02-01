import com.tencent.mobileqq.activity.photo.album.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.album.AlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.NewAlbumListAdapter.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class ztr
  extends AlbumListAdapter
{
  long Ly;
  private QQAlbumInfo a;
  
  public ztr(AlbumListFragment paramAlbumListFragment)
  {
    super(paramAlbumListFragment);
  }
  
  private static void a(ztr.a parama, String paramString, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramQQAlbumInfo.name;
    if (paramString.contains("/qq_collection/"))
    {
      parama.cfa += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((str.equals("qq_images")) || (paramString.contains("/mobileqq/photo")) || (paramString.contains("/mobileqq/diskcache")))
    {
      parama.cfb += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (str.equals("qqfile_recv"))
    {
      parama.cfc += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (str.equals("qq_favorite"))
    {
      parama.cfe += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (paramString.contains("/zebra/cache"))
    {
      parama.cfd += 1;
      return;
    }
    if ((str.equals("weixin")) || (str.equals("wechat")) || (str.equals("micromsg")))
    {
      parama.cff += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (zsz.it(paramString))
    {
      parama.ceY += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    parama.ceZ += paramQQAlbumInfo.mMediaFileCount;
  }
  
  private static void b(ztr.a parama, String paramString, QQAlbumInfo paramQQAlbumInfo)
  {
    String str = paramQQAlbumInfo.name;
    if (str.equals("qq_screenshot"))
    {
      parama.ceW += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((paramString.contains("screenshot")) || (paramString.contains("截屏")) || (paramString.contains("截图")) || (paramString.equals("screen_cap")) || (paramString.equals("ScreenCapture")))
    {
      parama.ceX += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if ((str.contains("camera")) || (str.equals("dcim")) || (str.equals("100MEDIA")) || (str.equals("100ANDRO")) || (str.contains("相机")) || (str.contains("照片")) || (str.contains("相片")))
    {
      parama.ceV += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    if (zsz.it(paramString))
    {
      parama.ceY += paramQQAlbumInfo.mMediaFileCount;
      return;
    }
    parama.ceZ += paramQQAlbumInfo.mMediaFileCount;
  }
  
  public void gC(long paramLong)
  {
    if (paramLong == 0L) {
      return;
    }
    this.Ly = paramLong;
    QQAlbumInfo localQQAlbumInfo = new QQAlbumInfo();
    localQQAlbumInfo._id = "qzone_album";
    localQQAlbumInfo.name = "空间相册";
    localQQAlbumInfo.mMediaFileCount = ((int)this.Ly);
    if (QLog.isColorLevel()) {
      QLog.d("AlbumListAdapter", 1, "setQzoneAlbumNum " + paramLong);
    }
    this.a = localQQAlbumInfo;
  }
  
  public List<QQAlbumInfo> getDefaultAlbums()
  {
    List localList = super.getDefaultAlbums();
    if ((localList != null) && (this.a != null)) {
      localList.add(0, this.a);
    }
    return localList;
  }
  
  public void setData()
  {
    super.setData();
    ThreadManager.post(new NewAlbumListAdapter.1(this), 2, null, false);
  }
  
  public static class a
  {
    public int ceV = 0;
    public int ceW = 0;
    public int ceX = 0;
    public int ceY = 0;
    public int ceZ = 0;
    public int cfa = 0;
    public int cfb = 0;
    public int cfc = 0;
    public int cfd = 0;
    public int cfe = 0;
    public int cff = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ztr
 * JD-Core Version:    0.7.0.1
 */