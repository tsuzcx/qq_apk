import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class srw
  implements srs.a
{
  srw(srs paramsrs) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.this$0.mCurrentPos) {
      return;
    }
    srs.a(this.this$0).setHasAutoSet(false);
    if (srs.a(this.this$0) != null)
    {
      paramVsMusicItemInfo = srs.a(this.this$0);
      if (!srs.a(this.this$0)) {
        bool = true;
      }
      paramVsMusicItemInfo.vb(bool);
      srs.a(this.this$0).bAy();
    }
    srs.a(this.this$0).smoothScrollToPosition(paramInt);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (srs.a(this.this$0) != null) && (srs.a(this.this$0).mSongMid != null) && (srs.a(this.this$0).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      srs.a(this.this$0, paramVsMusicItemInfo, paramInt, null);
    }
  }
  
  public void b(int paramInt, ssa.a parama)
  {
    if (srs.a(this.this$0)) {
      srs.a(this.this$0);
    }
    VsMusicItemInfo localVsMusicItemInfo = srs.a(this.this$0).a(paramInt);
    if ((srs.c(this.this$0) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      srs.b(this.this$0);
      srs.c(this.this$0).setText(localVsMusicItemInfo.mMusicName);
      srs.a(this.this$0, localVsMusicItemInfo, paramInt, parama);
    }
    srs.c(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     srw
 * JD-Core Version:    0.7.0.1
 */