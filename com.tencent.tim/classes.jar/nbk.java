import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPreDownloadMgr;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.1;
import com.tencent.biz.pubaccount.readinjoy.video.player.ReadinjoyPlayerReporter.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import org.json.JSONObject;

public class nbk
  extends nbf
{
  private nbk.a a;
  private boolean acL;
  private boolean aqr;
  public mhu d;
  private Handler mHandler;
  private boolean mIsCompleted;
  private int mSceneType;
  private VideoPreDownloadMgr mVideoPreDownloadMgr;
  
  public nbk(int paramInt, nbk.a parama)
  {
    this.mSceneType = paramInt;
    this.mHandler = new Handler(Looper.getMainLooper());
    this.d = new mhu();
    this.aqr = false;
    this.a = parama;
  }
  
  private void b(mhu parammhu)
  {
    this.acL = true;
    ThreadManager.excute(new ReadinjoyPlayerReporter.1(this, parammhu), 16, null, true);
  }
  
  private void bL(String paramString1, String paramString2)
  {
    if (this.mVideoPreDownloadMgr != null)
    {
      this.aqr = this.mVideoPreDownloadMgr.I(paramString2, paramString1);
      if (QLog.isColorLevel()) {
        QLog.d("ReadinjoyPlayerReporter", 2, "视频预下载: url:" + paramString1 + " ;isPreDownloadHit: " + this.aqr);
      }
      this.mVideoPreDownloadMgr.ak(paramString1, this.aqr);
    }
  }
  
  private void reset(String paramString)
  {
    this.d = new mhu();
    this.d.vid = paramString;
    this.d.IH = this.mSceneType;
    this.d.success = true;
    this.d.aSt = 0;
    this.d.skipFramesTotalCount = 0;
    this.d.aSu = 0;
    this.d.amE = false;
    this.d.ahy = "";
    this.d.amF = false;
    this.d.amG = false;
    if (this.a != null) {
      this.a.c(this.d);
    }
  }
  
  public void a(VideoPreDownloadMgr paramVideoPreDownloadMgr)
  {
    this.mVideoPreDownloadMgr = paramVideoPreDownloadMgr;
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.mIsCompleted = false;
    this.acL = false;
    reset(paramString1);
    this.d.aSs = 0;
    if (!paramBoolean1) {
      this.d.vs = SystemClock.uptimeMillis();
    }
    if (this.d != null)
    {
      this.d.aSt = 0;
      this.d.skipFramesTotalCount = 0;
      this.d.aSu = 0;
      this.d.amF = false;
      this.d.amG = false;
      this.d.amH = paramBoolean2;
    }
    bL(paramString1, paramString2);
  }
  
  public void a(myi parammyi, int paramInt)
  {
    this.d.playDuration = parammyi.c(this.mIsCompleted);
    this.d.secondBufferCount = parammyi.qf();
    this.d.vD = parammyi.dd();
    this.d.videoFormat = parammyi.qg();
    this.d.amD = parammyi.aqr;
    this.d.mFileSize = parammyi.mFileSize;
    this.d.vF = parammyi.vF;
    this.d.vG = parammyi.df();
    this.d.vH = parammyi.qh();
    this.d.ahx = parammyi.ky();
    this.d.vJ = parammyi.dh();
    this.d.vK = parammyi.dg();
    if ((this.d.playDuration == 0L) && (this.d.vt == 0L))
    {
      this.d.vt = (SystemClock.uptimeMillis() - this.d.vs);
      this.d.vv = this.d.vt;
    }
    this.d.bandwidth = mzs.a().getCurrentPrediction();
    this.d.ahD = mzz.a().kC();
    this.d.loopCount = paramInt;
    b(this.d);
  }
  
  public void c(kxz paramkxz)
  {
    int i = 0;
    this.d.vz = kxv.a().r.longValue();
    this.d.aSo = paramkxz.errorCode;
    this.d.aiJ = paramkxz.aiJ;
    this.d.adD = paramkxz.adD;
    this.d.Tx = paramkxz.Tx;
    this.d.amE = false;
    this.d.ahy = "";
    this.d.videoReportInfo = paramkxz.videoReportInfo;
    this.d.adE = paramkxz.adE;
    Object localObject = this.d;
    boolean bool;
    if (!TextUtils.isEmpty(paramkxz.adF)) {
      bool = true;
    }
    for (;;)
    {
      ((mhu)localObject).amG = bool;
      try
      {
        localObject = new URL(paramkxz.url).getHost();
        paramkxz = aopd.a().a((String)localObject, 1006);
        mhu localmhu = this.d;
        if (paramkxz == null)
        {
          localmhu.aSv = i;
          localmhu = this.d;
          if (paramkxz != null) {
            break label206;
          }
        }
        label206:
        for (paramkxz = "";; paramkxz = paramkxz.toString())
        {
          localmhu.ahB = paramkxz;
          this.d.ahA = ((String)localObject);
          return;
          i = paramkxz.size();
          break;
        }
        bool = false;
      }
      catch (Exception paramkxz)
      {
        return;
      }
    }
  }
  
  public void e(myi parammyi)
  {
    this.d.aSr = parammyi.getVideoHeight();
    this.d.aSq = parammyi.getVideoWidth();
  }
  
  public void f(myi parammyi)
  {
    if (this.d.vt != 0L) {
      return;
    }
    this.d.vt = (SystemClock.uptimeMillis() - this.d.vs);
    Object localObject = this.d;
    ((mhu)localObject).vv += this.d.vt;
    localObject = this.d;
    ((mhu)localObject).bufferCount += 1;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doReportOnVideoPrepared: vid=").append(this.d.vid).append(", 预加载状态：").append(this.d.aSs).append(", 预下载命中：").append(this.aqr).append(", 首帧耗时：").append(this.d.vt);
      QLog.d("ReadinjoyPlayerReporter", 2, ((StringBuilder)localObject).toString());
    }
    ThreadManager.excute(new ReadinjoyPlayerReporter.3(this, parammyi), 16, null, true);
  }
  
  public void i(int paramInt, Object paramObject)
  {
    int i = 0;
    switch (paramInt)
    {
    default: 
    case 112: 
    case 113: 
    case 28: 
    case 40: 
    case 39: 
    case 41: 
    case 42: 
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                this.d.vu = SystemClock.uptimeMillis();
                return;
                paramObject = this.d;
                paramObject.vv += SystemClock.uptimeMillis() - this.d.vu;
                paramObject = this.d;
                paramObject.bufferCount += 1;
                return;
                if (QLog.isColorLevel()) {
                  QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_DECODER_BLOCK");
                }
                paramObject = this.d;
                paramObject.aSt += 1;
                return;
                try
                {
                  paramObject = new JSONObject((String)paramObject);
                  paramInt = paramObject.optInt("decoderMode", 0);
                }
                catch (Exception paramObject)
                {
                  for (;;)
                  {
                    int j;
                    paramInt = 0;
                  }
                }
                try
                {
                  j = paramObject.optInt("skipFrameCount", 1);
                  i = j;
                }
                catch (Exception paramObject)
                {
                  break label194;
                }
                if (i > 0)
                {
                  paramObject = this.d;
                  paramObject.skipFramesTotalCount += i;
                }
                paramObject = this.d;
                paramObject.aSu += i;
              } while (!QLog.isColorLevel());
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_SKIP_ONE_FRAME decoderMode = " + paramInt + ", skipFrameCount = " + i + ", totalSkipCount = " + this.d.skipFramesTotalCount + ", finalSkipCount = " + this.d.aSu);
              return;
              if (QLog.isColorLevel()) {
                QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_HW_DECODE_FAILED");
              }
              this.d.amE = true;
            } while (!(paramObject instanceof String));
            this.d.ahy = ((String)paramObject);
            return;
            if (QLog.isColorLevel()) {
              QLog.d("ReadinjoyPlayerReporter", 2, "播放状态回调 onInfo() PLAYER_INFO_CHANGE_HW_BACKUP_URL");
            }
            this.d.amF = true;
            return;
          } while (paramObject == null);
          paramObject = ((String)paramObject).split(":", 2);
        } while ((paramObject == null) || (paramObject.length != 2));
        if (QLog.isColorLevel()) {
          QLog.d("ReadinjoyPlayerReporter", 2, "PERFORMANCE_REPORT method:" + paramObject[0] + "\ntimeJson:" + paramObject[1]);
        }
      } while (!"prepare".equals(paramObject[0]));
      this.d.ahC = paramObject[1];
      return;
    case 208: 
      label194:
      mrs.a.a(paramObject, this.d);
      return;
    }
  }
  
  public void oc(String paramString)
  {
    this.d.ahz = paramString;
  }
  
  public void onCompletion()
  {
    this.mIsCompleted = true;
    this.d.success = true;
    this.d.isCompleted = true;
  }
  
  public void onError(int paramInt1, int paramInt2, String paramString)
  {
    this.d.success = false;
    this.d.errCode = (paramInt1 + ":" + paramInt2);
    this.d.errDetailInfo = paramString;
  }
  
  public void pg(boolean paramBoolean)
  {
    this.d.vs = SystemClock.uptimeMillis();
    mhu localmhu = this.d;
    if (paramBoolean) {}
    for (int i = 2;; i = 1)
    {
      localmhu.aSs = i;
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void c(mhu parammhu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbk
 * JD-Core Version:    0.7.0.1
 */