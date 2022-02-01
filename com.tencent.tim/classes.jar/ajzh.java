import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class ajzh
{
  protected ImageView Bt;
  private ImageView Bu;
  ajyc a;
  public ajzh.a a;
  protected ajzp a;
  long adI;
  private String aeD;
  ajww jdField_b_of_type_Ajww;
  private VideoData jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  public String bSS = "";
  private boolean cqU = true;
  private boolean cqV;
  private final int dlJ = 1024;
  private final int dlK = -2147483648;
  private final int dlL = 2025;
  private final int dlM = 2026;
  public boolean isPlaying;
  protected QQAppInterface mApp;
  protected Context mContext;
  long mFileSize = 0L;
  protected Handler mHandler;
  private long mInterval = -1L;
  long mOffset = 0L;
  private boolean mPaused;
  public int mPlayerType = 0;
  private RelativeLayout mRootView;
  
  public ajzh(Context paramContext, QQAppInterface paramQQAppInterface)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Ajzp = a();
    this.mApp = paramQQAppInterface;
    this.jdField_b_of_type_Ajww = new ajww(this.mApp);
  }
  
  public static String getFileName(String paramString)
  {
    return MD5.toMD5(paramString);
  }
  
  public void A(RelativeLayout paramRelativeLayout)
  {
    this.mRootView = paramRelativeLayout;
    this.Bt = ((ImageView)this.mRootView.findViewById(2131369717));
    this.Bu = ((ImageView)this.mRootView.findViewById(2131366039));
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(2025);
      this.mHandler.removeMessages(2026);
    }
    this.mHandler = new ajzi(this, this.mContext.getMainLooper());
  }
  
  public ajzp a()
  {
    return new ajyd(this.mContext);
  }
  
  public void a(ajzh.a parama)
  {
    this.jdField_a_of_type_Ajzh$a = parama;
  }
  
  public void a(RelativeLayout paramRelativeLayout, VideoData paramVideoData, ajyc paramajyc)
  {
    this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    A(paramRelativeLayout);
    c(paramVideoData);
  }
  
  public void c(VideoData paramVideoData)
  {
    String str1 = paramVideoData.videoUrl;
    this.mFileSize = 0L;
    this.mOffset = 0L;
    boolean bool = yE();
    this.bSS = str1;
    this.aeD = str1;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "play(String videoPath)! path is: " + str1 + "play stack is: " + Log.getStackTraceString(new Throwable()));
    }
    if (this.jdField_a_of_type_Ajzp != null) {
      this.jdField_a_of_type_Ajzp.stopPlayback();
    }
    if ((this.jdField_a_of_type_Ajzp != null) && (this.jdField_a_of_type_Ajzp.getView() != null) && (this.jdField_a_of_type_Ajzp.getView().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Ajzp.getView().getParent()).removeView(this.jdField_a_of_type_Ajzp.getView());
    }
    this.jdField_a_of_type_Ajzp = a();
    if (this.jdField_a_of_type_Ajzp == null)
    {
      QLog.e("VideoPlayerView", 1, "mPlayer == null!");
      return;
    }
    if ((this.jdField_a_of_type_Ajzp != null) && (this.jdField_a_of_type_Ajzp.getView() != null) && (this.jdField_a_of_type_Ajzp.getView().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Ajzp.getView().getParent()).removeView(this.jdField_a_of_type_Ajzp.getView());
    }
    if (this.jdField_a_of_type_Ajzp != null) {
      this.mRootView.addView(this.jdField_a_of_type_Ajzp.getView(), 0, new RelativeLayout.LayoutParams(-1, -1));
    }
    this.mRootView.requestLayout();
    this.mPlayerType = 1;
    ajxs.dlD = 0;
    ajxs.ady = System.currentTimeMillis();
    ajxs.feedId = paramVideoData.id;
    ajxs.bSM = String.valueOf(paramVideoData.ads);
    if (this.jdField_a_of_type_Ajzh$a != null) {
      this.jdField_a_of_type_Ajzh$a.dAl();
    }
    for (;;)
    {
      String str2;
      try
      {
        this.Bt.setVisibility(0);
        this.Bu.setVisibility(0);
        this.jdField_a_of_type_Ajzp.a(new ajzj(this));
        this.jdField_a_of_type_Ajzp.a(new ajzk(this));
        this.jdField_a_of_type_Ajzp.a(new ajzl(this));
        this.jdField_a_of_type_Ajzp.a(new ajzm(this, paramVideoData));
        str2 = acbn.SDCARD_PATH + ".now_video/" + "vid_" + getFileName(str1) + ".mp4";
        localFile = new File(str2);
        if (localFile.exists())
        {
          if (QLog.isColorLevel()) {
            QLog.i("VideoPlayerView", 2, "file.exists ! use local file");
          }
          this.mFileSize = localFile.length();
          this.mOffset = this.mFileSize;
          this.jdField_a_of_type_Ajzp.a("vid_" + getFileName(str1), str2, str1, paramVideoData.AC);
          this.jdField_a_of_type_Ajzp.a(new ajzn(this, paramVideoData, bool));
          if (QLog.isColorLevel()) {
            QLog.i("VideoPlayerView", 2, "player start!");
          }
          this.mPaused = false;
          return;
        }
      }
      catch (Exception paramVideoData)
      {
        Log.e("VideoPlayerView", paramVideoData.toString());
        return;
      }
      File localFile = new File(str2 + ".tmp");
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "use remote file,tmp's exsit=" + localFile.exists());
      }
      this.jdField_a_of_type_Ajzp.a("vid_" + getFileName(str1), str2 + ".tmp", str1, paramVideoData.AC);
    }
  }
  
  public void dAi() {}
  
  public long getCurrentPosition()
  {
    return this.jdField_a_of_type_Ajzp.getCurrentPosition();
  }
  
  public long getFileSize()
  {
    return this.mFileSize;
  }
  
  public long gu()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    Object localObject;
    do
    {
      return 0L;
      localObject = acbn.SDCARD_PATH + ".now_video/" + "vid_" + getFileName(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.videoUrl) + ".mp4";
      if (new File((String)localObject).exists()) {
        return ((String)localObject).length();
      }
      localObject = new File(acbn.SDCARD_PATH + ".now_video/" + "vid_" + getFileName(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.videoUrl) + ".mp4.tmp");
    } while (!((File)localObject).exists());
    return ((File)localObject).length();
  }
  
  public boolean isPlaying()
  {
    return this.jdField_a_of_type_Ajzp.isPlaying();
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "pause");
    }
    this.jdField_a_of_type_Ajzp.pause();
    this.mPaused = true;
    this.adI = getCurrentPosition();
  }
  
  public boolean restart()
  {
    ajxs.dlD += 1;
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "restart");
    }
    String str = this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.id;
    if (yE()) {}
    for (int i = 1;; i = 2)
    {
      ajxt.j(str, i, "0", "0");
      ajxt.RB(2);
      ajxt.dzS();
      this.jdField_a_of_type_Ajzp.restart();
      return true;
    }
  }
  
  public void resume()
  {
    if (this.mPaused)
    {
      if (QLog.isColorLevel()) {
        QLog.i("VideoPlayerView", 2, "resume");
      }
      this.jdField_a_of_type_Ajzp.start();
      this.jdField_a_of_type_Ajzp.seekTo(this.adI);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.w("VideoPlayerView", 2, "!not paused no resume!");
  }
  
  public void suspend()
  {
    if (QLog.isColorLevel()) {
      QLog.i("VideoPlayerView", 2, "stop");
    }
    if (this.mHandler != null)
    {
      this.mHandler.removeMessages(2025);
      this.mHandler.removeMessages(2026);
    }
    if (this.cqV) {
      this.cqV = false;
    }
    if ((this.jdField_a_of_type_Ajzp != null) && (this.jdField_a_of_type_Ajzp.getView() != null) && (this.jdField_a_of_type_Ajzp.getView().getParent() != null)) {
      ((ViewGroup)this.jdField_a_of_type_Ajzp.getView().getParent()).removeView(this.jdField_a_of_type_Ajzp.getView());
    }
    this.jdField_a_of_type_Ajzp.stopPlayback();
    this.jdField_a_of_type_Ajyc = null;
  }
  
  public boolean yE()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) {}
    do
    {
      return false;
      if (new File(acbn.SDCARD_PATH + ".now_video/" + "vid_" + getFileName(this.jdField_b_of_type_ComTencentMobileqqNearbyNowModelVideoData.videoUrl) + ".mp4").exists()) {
        return true;
      }
    } while ((this.mOffset < this.mFileSize) || (this.mOffset == 0L));
    return true;
  }
  
  public static abstract interface a
  {
    public abstract void RF(int paramInt);
    
    public abstract void dAj();
    
    public abstract void dAk();
    
    public abstract void dAl();
    
    public abstract void onComplete();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajzh
 * JD-Core Version:    0.7.0.1
 */