import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class xiu
  implements xiy
{
  xiu(xiq paramxiq) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    xiq.a(this.a).setHasAutoSet(false);
    if (xiq.a(this.a) != null)
    {
      paramVsMusicItemInfo = xiq.a(this.a);
      if (!xiq.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      xiq.a(this.a).b();
    }
    xiq.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(int paramInt, xjc paramxjc)
  {
    if (xiq.a(this.a)) {
      xiq.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = xiq.a(this.a).a(paramInt);
    if ((xiq.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      xiq.b(this.a);
      xiq.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      xiq.a(this.a, localVsMusicItemInfo, paramInt, paramxjc);
    }
    xiq.c(this.a);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (xiq.a(this.a) != null) && (xiq.a(this.a).mSongMid != null) && (xiq.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      xiq.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xiu
 * JD-Core Version:    0.7.0.1
 */