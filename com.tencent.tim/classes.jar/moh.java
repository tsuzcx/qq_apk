import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class moh
  implements mqm<String>
{
  moh(mog parammog, UgcVideo paramUgcVideo) {}
  
  public void N(float paramFloat)
  {
    if ((paramFloat > this.b.videoProgress) && (this.b.status != UgcVideo.STATUS_PAUSE))
    {
      long l1 = System.currentTimeMillis();
      if ((this.b.lastUploadSizeUpdateTime != 0L) && (l1 - this.b.lastUploadSizeUpdateTime > 500L))
      {
        long l2 = ((paramFloat / 100.0F * (float)this.b.fileSize) - this.b.lastUploadSize) * 1000L / (l1 - this.b.lastUploadSizeUpdateTime);
        this.b.uploadSpeed = (mix.au(l2) + "/S");
        this.b.lastUploadSizeUpdateTime = l1;
        this.b.lastUploadSize = ((paramFloat / 100.0F * (float)this.b.fileSize));
      }
      this.b.videoProgress = ((int)paramFloat);
      this.b.status = UgcVideo.STATUS_UPLOADING;
      if (QLog.isColorLevel()) {
        QLog.i("RIJUGC.UploadVideoTaskStep", 2, "videoProgress = " + this.b.videoProgress + ", speed=" + this.b.uploadSpeed);
      }
    }
  }
  
  public void onFailed(int paramInt, @NotNull String paramString)
  {
    mix.a("fail", this.b);
    kbp.bp("0X800AC66", mix.a(kxm.a(), this.b).a("errMsg", paramString).build());
    QLog.e("RIJUGC.UploadVideoTaskStep", 1, "onFailed, errCode=" + paramInt + ", errMsg=" + paramString);
    this.b.status = UgcVideo.STATUS_FAILED;
    mog.a(this.a).f(this.b);
    this.a.aFM();
    mog.a(this.a, false);
  }
  
  public void onStart(@NotNull String paramString)
  {
    this.b.videoUploadKey = paramString;
    mog.a(this.a).f(this.b);
  }
  
  public void onSuccess(String paramString)
  {
    mix.a("success", this.b);
    kbp.bp("0X800AC67", mix.a(kxm.a(), this.b).a("from", Integer.valueOf(this.b.fromForReport)).a("compress_time", Long.valueOf(this.b.compressTime)).a("upload_time", Long.valueOf(this.b.uploadTotalCostTime)).a("wait_time", Long.valueOf(this.b.userWaitingTotalCostTime)).build());
    QLog.i("RIJUGC.UploadVideoTaskStep", 1, "upload success");
    if (QLog.isColorLevel()) {
      QLog.i("RIJUGC.UploadVideoTaskStep", 2, "url=" + paramString);
    }
    this.b.url = paramString;
    this.b.compressProgress = 100;
    this.b.videoProgress = 100;
    if (mog.a(this.a) != null) {
      mog.a(this.a).a(2, true, true, null);
    }
    mog.a(this.a).f(this.b);
    this.a.aFM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moh
 * JD-Core Version:    0.7.0.1
 */