import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class zcc
  implements zcg
{
  zcc(zby paramzby) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    zby.a(this.a).setHasAutoSet(false);
    if (zby.a(this.a) != null)
    {
      paramVsMusicItemInfo = zby.a(this.a);
      if (!zby.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      zby.a(this.a).b();
    }
    zby.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(int paramInt, zck paramzck)
  {
    if (zby.a(this.a)) {
      zby.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = zby.a(this.a).a(paramInt);
    if ((zby.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      zby.b(this.a);
      zby.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      zby.a(this.a, localVsMusicItemInfo, paramInt, paramzck);
    }
    zby.c(this.a);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (zby.a(this.a) != null) && (zby.a(this.a).mSongMid != null) && (zby.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      zby.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zcc
 * JD-Core Version:    0.7.0.1
 */