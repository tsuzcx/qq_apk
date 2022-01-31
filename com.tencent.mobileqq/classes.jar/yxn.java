import android.widget.TextView;
import com.tencent.biz.videostory.widget.view.smartmusicview.SmartMusicRecyclerView;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.qphone.base.util.QLog;

class yxn
  implements yxr
{
  yxn(yxj paramyxj) {}
  
  public void a(int paramInt, VsMusicItemInfo paramVsMusicItemInfo)
  {
    boolean bool = false;
    if (paramInt == this.a.a) {
      return;
    }
    yxj.a(this.a).setHasAutoSet(false);
    if (yxj.a(this.a) != null)
    {
      paramVsMusicItemInfo = yxj.a(this.a);
      if (!yxj.a(this.a)) {
        bool = true;
      }
      paramVsMusicItemInfo.a(bool);
      yxj.a(this.a).b();
    }
    yxj.a(this.a).smoothScrollToPosition(paramInt);
  }
  
  public void a(int paramInt, yxv paramyxv)
  {
    if (yxj.a(this.a)) {
      yxj.a(this.a);
    }
    VsMusicItemInfo localVsMusicItemInfo = yxj.a(this.a).a(paramInt);
    if ((yxj.c(this.a) != null) && (localVsMusicItemInfo != null))
    {
      QLog.i("EditVideoSmartMusicPart", 1, "onPositionChange:" + paramInt + ", music name:" + localVsMusicItemInfo.mMusicName + ", musicSongMid:" + localVsMusicItemInfo.mSongMid + ", musicCoverUrl:" + localVsMusicItemInfo.mAlbumUrl + ", musicUrl:" + localVsMusicItemInfo.mUrl);
      yxj.b(this.a);
      yxj.c(this.a).setText(localVsMusicItemInfo.mMusicName);
      yxj.a(this.a, localVsMusicItemInfo, paramInt, paramyxv);
    }
    yxj.c(this.a);
  }
  
  public void a(VsMusicItemInfo paramVsMusicItemInfo, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (yxj.a(this.a) != null) && (yxj.a(this.a).mSongMid != null) && (yxj.a(this.a).mSongMid.equals(paramVsMusicItemInfo.mSongMid))) {
      yxj.a(this.a, paramVsMusicItemInfo, paramInt, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yxn
 * JD-Core Version:    0.7.0.1
 */