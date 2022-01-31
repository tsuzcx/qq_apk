import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnVideoOutputFrameListener;

class vxl
  implements TVK_IMediaPlayer.OnVideoOutputFrameListener
{
  vxl(vxe paramvxe) {}
  
  public void OnVideoOutputFrame(TVK_IMediaPlayer paramTVK_IMediaPlayer, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    wxe.a(this.a.a, "OnVideoOutputFrame width=%d height=%d rotation=%d %d", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxl
 * JD-Core Version:    0.7.0.1
 */