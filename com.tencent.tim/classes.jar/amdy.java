import android.graphics.Bitmap;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class amdy
  implements VideoPlayerCallback
{
  amdy(amdw paramamdw, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOFileVideoView<FileAssistant>XOXO", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    amdw.a(this.this$0, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    QLog.i("AIOFileVideoView<FileAssistant>XOXO", 1, "@@@@@@@@@@@ videoView Download Success:" + paramLong);
    AIOFileVideoData localAIOFileVideoData = this.this$0.b();
    if (!localAIOFileVideoData.bit) {
      this.this$0.b.d(localAIOFileVideoData);
    }
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onFirstFrameRendered, id:" + paramLong);
    }
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOFileVideoView<FileAssistant>XOXO", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    amdw.a(this.this$0, paramInt1, paramInt3, this.c);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    amdw.a(this.this$0, paramLong2);
    int i = (int)(paramLong2 / this.this$0.mVideoView.getVideoDurationMs() * 10000.0D);
    this.this$0.Bv.setText(ShortVideoUtils.stringForTime(paramLong2));
    this.this$0.m.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFileVideoView<FileAssistant>XOXO", 0, "onStateChange , state = " + amdw.a(this.this$0, paramInt) + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 7: 
    default: 
      return;
    case 4: 
      Object localObject = this.this$0.b();
      if (((AIOFileVideoData)localObject).bit) {
        amdw.a(this.this$0, 5);
      }
      for (;;)
      {
        this.this$0.updateUI();
        if (localObject != null)
        {
          this.this$0.b.le(((AIOFileVideoData)localObject).msgId);
          this.this$0.b.ld(((AIOFileVideoData)localObject).msgId);
        }
        if (!this.this$0.b.le(this.this$0.b.getCurrentPosition())) {
          break;
        }
        this.this$0.b.cWC();
        localObject = this.this$0.b.getSelectedItem();
        if ((localObject == null) || (!(((RichMediaBrowserInfo)localObject).baseData instanceof AIOBrowserBaseData)) || (this.this$0.b.a() == null) || (this.this$0.mVideoView == null)) {
          break;
        }
        this.this$0.b.a().jJ(amch.a(((AIOBrowserBaseData)((RichMediaBrowserInfo)localObject).baseData).shmsgseq, this.this$0.mVideoView.getCurPlayingPos(), this.this$0.b.a(), this.this$0.b.gM));
        return;
        amdw.a(this.this$0, 1);
      }
    case 8: 
      this.this$0.Bv.setText(ShortVideoUtils.stringForTime(this.this$0.mVideoView.getVideoDurationMs()));
      this.this$0.m.setProgress(100);
      amdw.a(this.this$0, 0);
      this.this$0.updateUI();
      this.this$0.mVideoView.seekTo(0);
      return;
    case 9: 
      amdw.a(this.this$0);
      return;
    case 6: 
      amdw.a(this.this$0, 6);
      this.this$0.updateUI();
      return;
    }
    amdw.a(this.this$0, 3);
    this.this$0.updateUI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amdy
 * JD-Core Version:    0.7.0.1
 */