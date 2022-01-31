import com.tencent.mobileqq.activity.photo.AlbumListAdapter;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.QLog;

public class xbm
  implements Runnable
{
  public xbm(AlbumListAdapter paramAlbumListAdapter) {}
  
  public void run()
  {
    
    if (AlbumListAdapter.a(this.a)) {}
    for (QQAlbumInfo localQQAlbumInfo = this.a.b(this.a.jdField_a_of_type_AndroidAppActivity, AlbumListAdapter.a(this.a), AlbumListAdapter.b(this.a), this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter, AlbumListAdapter.c(this.a), true, AlbumListAdapter.a(this.a));; localQQAlbumInfo = this.a.b(this.a.jdField_a_of_type_AndroidAppActivity, 210, 100, this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter))
    {
      this.a.b(localQQAlbumInfo);
      if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityPhotoMediaFileFilter.b()))
      {
        localQQAlbumInfo = this.a.a(this.a.jdField_a_of_type_AndroidAppActivity);
        this.a.d(localQQAlbumInfo);
        if (QLog.isColorLevel()) {
          QLog.d("AlbumListAdapter", 2, "queryAlbumList() run postVideoAlbum()， videoAlbumInfo.count=" + localQQAlbumInfo.mMediaFileCount);
        }
      }
      LogTag.a("PEAK", "queryRecentBucket");
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xbm
 * JD-Core Version:    0.7.0.1
 */