import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.album.adapter.AENewAlbumListAdapter.1;
import java.util.List;

public class awum
  extends awul
{
  public long Ly;
  boolean dsG;
  public boolean isShowQzoneAlbum;
  
  public awum(awuu paramawuu)
  {
    super(paramawuu);
  }
  
  boolean aNK()
  {
    if (this.mDataInfos.size() != 0)
    {
      int i = 0;
      while (i < this.mDataInfos.size())
      {
        if (((QQAlbumInfo)this.mDataInfos.get(i))._id.equals("qzone_album")) {
          return false;
        }
        i += 1;
      }
    }
    return true;
  }
  
  protected void b(QQAlbumInfo paramQQAlbumInfo)
  {
    Object localObject;
    if (!this.mDataInfos.isEmpty())
    {
      localObject = (QQAlbumInfo)this.mDataInfos.get(0);
      if (!((QQAlbumInfo)localObject)._id.equals("$RecentAlbumId"))
      {
        if (!((QQAlbumInfo)localObject)._id.equals("qzone_album")) {
          break label228;
        }
        this.mDataInfos.add(1, paramQQAlbumInfo);
      }
    }
    for (;;)
    {
      if ((this.isShowQzoneAlbum) && (this.Ly > 0L) && (aNK()))
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "qzone_album";
        paramQQAlbumInfo.name = "空间相册";
        paramQQAlbumInfo.mMediaFileCount = ((int)this.Ly);
        this.mDataInfos.add(0, paramQQAlbumInfo);
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListAdapter", 1, "addRecentAlbum");
        }
      }
      if (this.dsG)
      {
        paramQQAlbumInfo = new QQAlbumInfo();
        paramQQAlbumInfo._id = "$CustomAlbumId";
        localObject = rma.a().ci();
        if (((List)localObject).size() > 0)
        {
          paramQQAlbumInfo.name = ((LocalMediaInfo)((List)localObject).get(0)).mAlbumName;
          paramQQAlbumInfo.mCoverInfo = ((LocalMediaInfo)((List)localObject).get(0));
        }
        paramQQAlbumInfo.mMediaFileCount = ((List)localObject).size();
        this.mDataInfos.add(0, paramQQAlbumInfo);
      }
      return;
      label228:
      this.mDataInfos.add(0, paramQQAlbumInfo);
    }
  }
  
  void setData(List<QQAlbumInfo> paramList)
  {
    super.setData(paramList);
    ThreadManager.post(new AENewAlbumListAdapter.1(this), 2, null, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awum
 * JD-Core Version:    0.7.0.1
 */