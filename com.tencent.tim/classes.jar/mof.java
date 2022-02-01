import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import org.jetbrains.annotations.NotNull;

class mof
  implements mqk
{
  mof(moe parammoe, UgcVideo paramUgcVideo) {}
  
  public void N(float paramFloat)
  {
    if (this.b.status != UgcVideo.STATUS_PAUSE)
    {
      this.b.coverProgress = ((int)paramFloat);
      this.b.status = UgcVideo.STATUS_UPLOADING;
      if (moe.a(this.a) != null) {
        moe.a(this.a).a(3, true, false, null);
      }
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.UploadCoverTaskStep", 0, "coverProgress =" + paramFloat);
      }
    }
  }
  
  public void onFailed(int paramInt, @NotNull String paramString)
  {
    QLog.e("RIJUGC.UploadCoverTaskStep", 1, "upload cover fail, errCode=" + paramInt + ", errMsg=" + paramString);
    if (this.b.status != UgcVideo.STATUS_PAUSE)
    {
      this.b.status = UgcVideo.STATUS_FAILED;
      if (moe.a(this.a) != null) {
        moe.a(this.a).a(3, false, false, paramString);
      }
      moe.a(this.a).f(this.b);
      this.a.aFM();
    }
  }
  
  public void onSuccess(String paramString)
  {
    QLog.i("RIJUGC.UploadCoverTaskStep", 1, "upload cover success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadCoverTaskStep", 0, "upload cover url=" + paramString);
    }
    this.b.coverUrl = paramString;
    if (this.b.status != UgcVideo.STATUS_PAUSE)
    {
      this.b.coverProgress = 100;
      if (moe.a(this.a) != null) {
        moe.a(this.a).a(3, true, true, null);
      }
    }
    moe.a(this.a).f(this.b);
    this.a.aFM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mof
 * JD-Core Version:    0.7.0.1
 */