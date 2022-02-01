import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnCompletionListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import com.tencent.superplayer.seamless.SPSeamlessHelper;
import com.tencent.superplayer.view.ISPlayerVideoView;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPCDNURLInfo;
import com.tencent.thumbplayer.api.TPPlayerMsg.TPDownLoadProgressInfo;
import java.util.Properties;

public class vhi
  implements ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnCompletionListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, vgv<Object, SuperPlayerVideoInfo>
{
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private vgx jdField_a_of_type_Vgx;
  private vhc jdField_a_of_type_Vhc;
  
  public vhi(ISuperPlayer paramISuperPlayer)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = paramISuperPlayer;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return 1;
    case 2: 
      return 2;
    }
    return 3;
  }
  
  private int b(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return paramInt;
    case 112: 
      return 112;
    }
    return 113;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoWidth();
    }
    return 0;
  }
  
  public long a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
    }
    return 0L;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getStreamDumpInfo();
    }
    return "";
  }
  
  public Properties a()
  {
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.start();
    }
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setXYaxis(a(paramInt));
    }
  }
  
  public void a(Context paramContext, long paramLong, int paramInt, vgu<Object, SuperPlayerVideoInfo> paramvgu)
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (paramvgu != null)) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(paramContext, (SuperPlayerVideoInfo)paramvgu.c(), paramLong);
    }
  }
  
  public void a(vgx paramvgx)
  {
    this.jdField_a_of_type_Vgx = paramvgx;
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCompletionListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
    }
  }
  
  public void a(vhc paramvhc)
  {
    this.jdField_a_of_type_Vhc = paramvhc;
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (paramvhc != null))
    {
      paramvhc = paramvhc.a();
      if ((paramvhc instanceof ISPlayerVideoView)) {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)paramvhc);
      }
    }
  }
  
  public void a(vhc paramvhc, ViewGroup paramViewGroup)
  {
    if (paramvhc != null)
    {
      paramvhc = paramvhc.a();
      if ((paramvhc instanceof ISPlayerVideoView)) {
        SPSeamlessHelper.get().attachVideoView(paramViewGroup, (ISPlayerVideoView)paramvhc, new ViewGroup.LayoutParams(-1, -1));
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(paramBoolean);
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPlaying());
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getVideoHeight();
    }
    return 0;
  }
  
  public long b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs();
    }
    return 0L;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pause();
    }
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(paramInt);
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(paramBoolean);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.isPausing());
  }
  
  public void c()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.jdField_a_of_type_Vhc != null))
    {
      View localView = this.jdField_a_of_type_Vhc.a();
      if ((localView instanceof ISPlayerVideoView))
      {
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.reset();
        this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.updatePlayerVideoView((ISPlayerVideoView)localView);
      }
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.pauseDownload();
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.resumeDownload();
    }
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Vgx != null) {
      this.jdField_a_of_type_Vgx.a(this, paramInt1, paramInt2);
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (this.jdField_a_of_type_Vgx != null) {
      this.jdField_a_of_type_Vgx.a(this, paramInt1, paramInt2, paramInt3, paramBitmap);
    }
  }
  
  public void onCompletion(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_Vgx != null) {
      this.jdField_a_of_type_Vgx.b(this);
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if (this.jdField_a_of_type_Vgx != null) {
      return this.jdField_a_of_type_Vgx.a(this, paramInt1, paramInt2, paramInt3, paramString);
    }
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    vmp.e("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] what:" + paramInt + ", arg1:" + paramLong1 + ", arg2:" + paramLong2 + ", extra:" + paramObject);
    switch (paramInt)
    {
    }
    while (this.jdField_a_of_type_Vgx != null)
    {
      return this.jdField_a_of_type_Vgx.a(this, b(paramInt), paramObject);
      if ((paramObject instanceof TPPlayerMsg.TPDownLoadProgressInfo))
      {
        paramISuperPlayer = (TPPlayerMsg.TPDownLoadProgressInfo)paramObject;
        if (this.jdField_a_of_type_Vgx != null) {
          this.jdField_a_of_type_Vgx.a(paramISuperPlayer.downloadSpeedKBps, paramISuperPlayer.totalFileSize, paramISuperPlayer.extraInfo);
        }
        return true;
        if ((paramObject instanceof TPPlayerMsg.TPCDNURLInfo))
        {
          paramISuperPlayer = (TPPlayerMsg.TPCDNURLInfo)paramObject;
          vmp.d("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] TPCDNURLInfo url:" + paramISuperPlayer.url + ", uIp:" + paramISuperPlayer.uIp + ", cdnIp:" + paramISuperPlayer.cdnIp + ", errorStr:" + paramISuperPlayer.errorStr);
          continue;
          vmp.e("WS_VIDEO_SuperPlayerImpl", "[SuperPlayerImpl.java][onInfo] PLAYER_INFO_ALL_DOWNLOAD_FINISH!");
        }
      }
    }
    return false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_Vgx != null) {
      this.jdField_a_of_type_Vgx.c(this);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_Vgx != null) {
      this.jdField_a_of_type_Vgx.a(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhi
 * JD-Core Version:    0.7.0.1
 */