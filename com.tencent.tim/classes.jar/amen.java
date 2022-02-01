import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.videoplatform.api.VideoPlayParam;
import com.tencent.mobileqq.videoplatform.api.VideoPlayerCallback;
import com.tencent.mobileqq.videoplatform.view.BaseVideoView;
import com.tencent.richmediabrowser.log.BrowserLogHelper;
import com.tencent.richmediabrowser.log.IBrowserLog;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;

class amen
  implements VideoPlayerCallback
{
  amen(amem paramamem, VideoPlayParam paramVideoPlayParam) {}
  
  public void onCapFrame(long paramLong, boolean paramBoolean, int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AIOVideoView", 0, "onCapFrame, id:" + paramLong + ", isSuccess:" + paramBoolean + ", w:" + paramInt1 + ", h:" + paramInt2);
    }
    amem.a(this.this$0, paramBitmap);
  }
  
  public void onDownloadComplete(long paramLong)
  {
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onDownloadComplete");
    ztn localztn = this.this$0.b.a(this.this$0.a());
    if (localztn != null) {
      localztn.btf = false;
    }
    this.this$0.b.ao(2003, 0L);
  }
  
  public void onDownloadProgress(long paramLong1, long paramLong2) {}
  
  public void onFirstFrameRendered(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onFirstFrameRendered, id:" + paramLong);
    }
    amem.a(this.this$0, paramLong, this.a);
  }
  
  public void onLoopBack(long paramLong1, long paramLong2) {}
  
  public void onPlayError(long paramLong, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    BrowserLogHelper.getInstance().getGalleryLog().e("AIOVideoView", 1, "onPlayError, id = " + paramLong + " ,module = " + paramInt1 + " , errorType = " + paramInt2 + ", errCode = " + paramInt3 + " , exInfo = " + paramString);
    amem.a(this.this$0, paramInt1, paramInt3, this.a);
  }
  
  public void onPlayProgress(long paramLong1, long paramLong2)
  {
    amem.a(this.this$0, paramLong2);
    int i = (int)(paramLong2 / this.this$0.mVideoView.getVideoDurationMs() * 10000.0D);
    BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "onPlayProgress, id = " + paramLong1 + " , position = " + paramLong2 + " , progress = " + i);
    this.this$0.Bv.setText(ShortVideoUtils.stringForTime(paramLong2));
    this.this$0.m.setProgress(i);
  }
  
  public void onStateChange(long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOVideoView", 0, "onStateChange , state = " + paramInt + ", msgUniseq=" + paramLong);
    }
    switch (paramInt)
    {
    case 6: 
    case 7: 
    default: 
    case 4: 
      RichMediaBrowserInfo localRichMediaBrowserInfo;
      do
      {
        do
        {
          return;
          if (this.this$0.mVideoView != null)
          {
            long l = this.this$0.mVideoView.getVideoDurationMs();
            BrowserLogHelper.getInstance().getGalleryLog().d("AIOVideoView", 4, "videoDuration = " + l);
            this.this$0.Bu.setText(ShortVideoUtils.stringForTime(l));
            this.this$0.Bv.setText(ShortVideoUtils.stringForTime(0L));
          }
          this.this$0.b.onLoadFinish(this.this$0.b.getSelectedIndex(), true);
          this.this$0.OV(true);
          this.this$0.zA(false);
          this.this$0.hQ.setVisibility(8);
          amem.a(this.this$0).setVisibility(8);
          amem.a(this.this$0).setVisibility(8);
          amem.a(this.this$0, true);
          this.this$0.b.le(paramLong);
        } while (!this.this$0.b.le(this.this$0.b.getCurrentPosition()));
        this.this$0.b.cWC();
        localRichMediaBrowserInfo = this.this$0.b.getSelectedItem();
      } while ((localRichMediaBrowserInfo == null) || (!(localRichMediaBrowserInfo.baseData instanceof AIOBrowserBaseData)) || (this.this$0.b.a() == null) || (this.this$0.mVideoView == null));
      this.this$0.b.a().jJ(amch.a(((AIOBrowserBaseData)localRichMediaBrowserInfo.baseData).shmsgseq, this.this$0.mVideoView.getCurPlayingPos(), this.this$0.b.a(), this.this$0.b.gM));
      return;
    case 8: 
      this.this$0.m.setProgress(this.this$0.m.getMax());
      return;
    case 9: 
      this.this$0.b.onLoadFinish(this.this$0.b.getSelectedIndex(), true);
      this.this$0.OV(true);
      this.this$0.zA(false);
      this.this$0.Bv.setText(ShortVideoUtils.stringForTime(this.this$0.mVideoView.getVideoDurationMs()));
      this.this$0.hQ.setVisibility(8);
      amem.a(this.this$0).setVisibility(8);
      amem.a(this.this$0).setVisibility(0);
      this.this$0.jO.setImageResource(2130847020);
      amem.a(this.this$0, true);
      amem.a(this.this$0);
      return;
    }
    if (this.this$0.mVideoView != null)
    {
      if (!this.this$0.mVideoView.isPlaying()) {
        break label640;
      }
      this.this$0.hQ.setVisibility(0);
    }
    for (;;)
    {
      this.this$0.b.onLoadFinish(this.this$0.b.getSelectedIndex(), true);
      this.this$0.OV(true);
      this.this$0.zA(false);
      amem.a(this.this$0).setVisibility(8);
      amem.a(this.this$0, true);
      return;
      label640:
      this.this$0.hQ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amen
 * JD-Core Version:    0.7.0.1
 */