import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class wzx
  implements xab
{
  wzx(wzt paramwzt) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    wzt.a(this.a).setHasAutoSet(false);
    if (wzt.a(this.a) != null)
    {
      paramVsMusicItemInfo = wzt.a(this.a);
      if (!wzt.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      wzt.a(this.a).b();
    }
    wzt.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(int paramInt, xaf paramxaf)
  {
    if (wzt.a(this.a)) {
      wzt.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = wzt.a(this.a).a(paramInt);
    if ((wzt.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      wzt.b(this.a);
      wzt.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      wzt.a(this.a, localVsMusicItemInfo, paramInt, paramxaf);
    }
    wzt.c(this.a);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (wzt.a(this.a) != null) && (wzt.a(this.a).mSongMid != null) && (wzt.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      wzt.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wzx
 * JD-Core Version:    0.7.0.1
 */