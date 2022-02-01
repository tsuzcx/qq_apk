import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import com.tencent.superplayer.api.ISuperPlayer.OnCaptureImageListener;
import com.tencent.superplayer.api.ISuperPlayer.OnErrorListener;
import com.tencent.superplayer.api.ISuperPlayer.OnInfoListener;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import com.tencent.superplayer.api.ISuperPlayer.OnVideoPreparedListener;
import com.tencent.superplayer.api.SuperPlayerFactory;
import com.tencent.superplayer.view.ISPlayerVideoView;
import java.util.HashSet;
import java.util.Set;

public class mlx
  implements ISuperPlayer.OnCaptureImageListener, ISuperPlayer.OnErrorListener, ISuperPlayer.OnInfoListener, ISuperPlayer.OnSeekCompleteListener, ISuperPlayer.OnVideoPreparedListener, mlw
{
  private ISuperPlayer.OnSeekCompleteListener jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener;
  private ISuperPlayer jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer;
  private Set<mlt> ab = new HashSet();
  private SparseArray<mlu.a> am = new SparseArray();
  private SparseArray<mlu> an = new SparseArray();
  private boolean ann;
  private boolean hasPrepared;
  
  public mlx()
  {
    aQb();
  }
  
  public static void aQb()
  {
    if (!allf.isSDKReady()) {
      allf.a(BaseApplication.getContext(), new mly());
    }
  }
  
  public void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener)
  {
    this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener = paramOnSeekCompleteListener;
    if (this.hasPrepared) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.seekTo(paramInt, 3);
    }
  }
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    ISPlayerVideoView localISPlayerVideoView2;
    if (paramViewGroup != null)
    {
      localISPlayerVideoView2 = SuperPlayerFactory.createPlayerVideoView(BaseApplication.getContext());
      localISPlayerVideoView1 = localISPlayerVideoView2;
      if ((localISPlayerVideoView2 instanceof View)) {
        paramViewGroup.addView((View)localISPlayerVideoView2);
      }
    }
    for (ISPlayerVideoView localISPlayerVideoView1 = localISPlayerVideoView2;; localISPlayerVideoView1 = null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = SuperPlayerFactory.createMediaPlayer(BaseApplication.getContext(), 104, localISPlayerVideoView1);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOutputMute(true);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setLoopback(true);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnInfoListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnCaptureImageListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnVideoPreparedListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnSeekCompleteListener(this);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.setOnErrorListener(this);
      paramString = SuperPlayerFactory.createVideoInfoForUrl(paramString, 101, null);
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.openMediaPlayer(BaseApplication.getContext(), paramString, 0L);
      return;
    }
  }
  
  public void a(mlt parammlt)
  {
    this.ab.add(parammlt);
  }
  
  public void a(mlu parammlu, mlu.a parama)
  {
    try
    {
      int i = this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.captureImageInTime(parammlu.position, parammlu.width, parammlu.height, 0, 0, 300);
      parammlu.id = i;
      this.an.put(i, parammlu);
      this.am.put(i, parama);
      if (QLog.isColorLevel()) {
        QLog.d("PlayerCaptureProxy", 2, "PlayerCaptureProxy try capture captureTask:" + parammlu);
      }
      return;
    }
    catch (IllegalAccessException parama)
    {
      for (;;)
      {
        parama.printStackTrace();
      }
    }
    finally {}
  }
  
  public long getVideoDuration()
  {
    return this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getDurationMs();
  }
  
  public void onCaptureImageFailed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2)
  {
    QLog.e("PlayerCaptureProxy", 1, "onCaptureImageFailed id:" + paramInt1 + " errCode:" + paramInt2);
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 < this.am.size())
      {
        if (this.am.keyAt(paramInt2) == paramInt1)
        {
          paramISuperPlayer = (mlu.a)this.am.get(paramInt1);
          if (paramISuperPlayer != null) {
            paramISuperPlayer.aPX();
          }
          this.am.remove(paramInt1);
        }
      }
      else {
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public void onCaptureImageSucceed(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayerCaptureProxy", 2, "onCaptureImageSucceed id:" + paramInt1 + " bitmap:" + paramBitmap + " callbackSparseArray:" + this.am);
    }
    paramInt2 = 0;
    for (;;)
    {
      if (paramInt2 < this.am.size())
      {
        if (this.am.keyAt(paramInt2) == paramInt1)
        {
          paramISuperPlayer = (mlu.a)this.am.get(paramInt1);
          mlu localmlu = (mlu)this.an.get(paramInt1);
          this.an.remove(paramInt1);
          if (paramISuperPlayer != null) {
            paramISuperPlayer.a(paramBitmap, localmlu);
          }
          this.am.remove(paramInt1);
        }
      }
      else {
        return;
      }
      paramInt2 += 1;
    }
  }
  
  public boolean onError(ISuperPlayer paramISuperPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    QLog.e("PlayerCaptureProxy", 1, "PlayerCaptureProxy onError: module = " + paramInt1 + ", errorType = " + paramInt2 + ", errorCode = " + paramInt3 + ", extraInfo = " + paramString);
    return false;
  }
  
  public boolean onInfo(ISuperPlayer paramISuperPlayer, int paramInt, long paramLong1, long paramLong2, Object paramObject)
  {
    return false;
  }
  
  public void onPause()
  {
    this.ann = true;
  }
  
  public void onResume()
  {
    if ((this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null) && (this.ann)) {
      a((int)this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.getCurrentPositionMs(), null);
    }
    this.ann = false;
  }
  
  public void onSeekComplete(ISuperPlayer paramISuperPlayer)
  {
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener != null) {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer$OnSeekCompleteListener.onSeekComplete(paramISuperPlayer);
    }
  }
  
  public void onVideoPrepared(ISuperPlayer paramISuperPlayer)
  {
    asfe.au(new PlayerCaptureProxy.2(this));
  }
  
  public void release()
  {
    this.am.clear();
    if (this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer != null)
    {
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.stop();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer.release();
      this.jdField_a_of_type_ComTencentSuperplayerApiISuperPlayer = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mlx
 * JD-Core Version:    0.7.0.1
 */