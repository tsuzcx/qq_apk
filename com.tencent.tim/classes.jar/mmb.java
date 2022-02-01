import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.1;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.2;
import com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.SystemCaptureProxy.3;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer.OnSeekCompleteListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import mqq.os.MqqHandler;

public class mmb
  implements mlw
{
  private MediaMetadataRetriever a = new MediaMetadataRetriever();
  private Set<mlt> ab = new HashSet();
  private SparseArray<mlu.a> am = new SparseArray();
  private volatile boolean anp = true;
  private int duration;
  private int height;
  private String path;
  private volatile boolean released;
  private int width;
  
  private Bitmap a(MediaMetadataRetriever paramMediaMetadataRetriever, mlu parammlu)
  {
    try
    {
      paramMediaMetadataRetriever = paramMediaMetadataRetriever.getFrameAtTime(parammlu.position * 1000, 0);
      return paramMediaMetadataRetriever;
    }
    catch (Throwable paramMediaMetadataRetriever)
    {
      QLog.e("SystemCaptureProxy", 1, "getFrameAtTime failed for captureTask" + parammlu.position, paramMediaMetadataRetriever);
    }
    return null;
  }
  
  private int ds(int paramInt)
  {
    return Integer.parseInt(this.a.extractMetadata(paramInt));
  }
  
  private void notifyListeners()
  {
    Iterator localIterator = this.ab.iterator();
    while (localIterator.hasNext())
    {
      mlt localmlt = (mlt)localIterator.next();
      if (localmlt != null) {
        localmlt.a(this.width, this.height, this.duration);
      }
    }
  }
  
  private void prepare()
  {
    try
    {
      QLog.d("SystemCaptureProxy", 1, "prepare...");
      this.a.setDataSource(this.path);
      QLog.d("SystemCaptureProxy", 1, "prepare after...");
      this.duration = ds(9);
      this.width = ds(18);
      this.height = ds(19);
      ThreadManager.getUIHandler().post(new SystemCaptureProxy.3(this));
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public void a(int paramInt, ISuperPlayer.OnSeekCompleteListener paramOnSeekCompleteListener) {}
  
  public void a(String paramString, ViewGroup paramViewGroup)
  {
    this.path = paramString;
    QLog.d("SystemCaptureProxy", 1, "prepare before...");
    ThreadManager.excute(new SystemCaptureProxy.1(this), 16, null, true);
  }
  
  public void a(mlt parammlt)
  {
    this.ab.add(parammlt);
  }
  
  public void a(mlu parammlu, mlu.a parama)
  {
    try
    {
      ThreadManager.excute(new SystemCaptureProxy.2(this, parammlu, parama), 16, null, true);
      return;
    }
    finally
    {
      parammlu = finally;
      throw parammlu;
    }
  }
  
  public long getVideoDuration()
  {
    return this.duration;
  }
  
  public void onPause() {}
  
  public void onResume() {}
  
  public void release()
  {
    this.released = true;
    if (this.a != null) {
      this.a.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mmb
 * JD-Core Version:    0.7.0.1
 */