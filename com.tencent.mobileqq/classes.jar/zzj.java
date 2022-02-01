import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class zzj
  implements zzn
{
  zzj(zzf paramzzf) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    zzf.a(this.a).setHasAutoSet(false);
    if (zzf.a(this.a) != null)
    {
      paramVsMusicItemInfo = zzf.a(this.a);
      if (!zzf.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      zzf.a(this.a).b();
    }
    zzf.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(int paramInt, zzr paramzzr)
  {
    if (zzf.a(this.a)) {
      zzf.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = zzf.a(this.a).a(paramInt);
    if ((zzf.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      zzf.b(this.a);
      zzf.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      zzf.a(this.a, localVsMusicItemInfo, paramInt, paramzzr);
    }
    zzf.c(this.a);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (zzf.a(this.a) != null) && (zzf.a(this.a).mSongMid != null) && (zzf.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      zzf.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzj
 * JD-Core Version:    0.7.0.1
 */