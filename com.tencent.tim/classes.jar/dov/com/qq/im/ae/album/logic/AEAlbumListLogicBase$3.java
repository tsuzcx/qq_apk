package dov.com.qq.im.ae.album.logic;

import aqip;
import awul;
import awuo;
import awuy;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.AlbumListBaseData;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class AEAlbumListLogicBase$3
  implements Runnable
{
  public AEAlbumListLogicBase$3(awuy paramawuy, awul paramawul, MediaFileFilter paramMediaFileFilter) {}
  
  public void run()
  {
    aqip.beginPile();
    QQAlbumInfo localQQAlbumInfo = this.c.queryRecentMediaBucket(((awuo)this.this$0.bu.get()).getActivity(), this.this$0.mAlbumListData.recentImagesLimitSize, this.this$0.mAlbumListData.recentImagesMaxCount, this.b, this.this$0.mAlbumListData.recentImagesLimitWidth, this.this$0.mAlbumListData.isBothwidthheight, this.this$0.mAlbumListData.recentImagesBlockPaths);
    this.c.c(localQQAlbumInfo);
    aqip.endPile("PEAK", "queryRecentBucket");
    aqip.beginPile();
    if ((this.b != null) && (this.b.showVideo()))
    {
      localQQAlbumInfo = this.c.queryAllVideoBucket(((awuo)this.this$0.bu.get()).getActivity());
      this.c.e(localQQAlbumInfo);
      if (QLog.isColorLevel()) {
        QLog.d("AlbumModule", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
      }
    }
    aqip.endPile("PEAK", "queryVideoBucket");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.album.logic.AEAlbumListLogicBase.3
 * JD-Core Version:    0.7.0.1
 */