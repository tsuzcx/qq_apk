import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class xix
  implements xjb
{
  xix(xit paramxit) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    xit.a(this.a).setHasAutoSet(false);
    if (xit.a(this.a) != null)
    {
      paramVsMusicItemInfo = xit.a(this.a);
      if (!xit.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      xit.a(this.a).b();
    }
    xit.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(int paramInt, xjf paramxjf)
  {
    if (xit.a(this.a)) {
      xit.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = xit.a(this.a).a(paramInt);
    if ((xit.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      xit.b(this.a);
      xit.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      xit.a(this.a, localVsMusicItemInfo, paramInt, paramxjf);
    }
    xit.c(this.a);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (xit.a(this.a) != null) && (xit.a(this.a).mSongMid != null) && (xit.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      xit.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     xix
 * JD-Core Version:    0.7.0.1
 */