import android.annotation.TargetApi;
import android.os.SystemClock;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.mobileqq.shortvideo.pkvideo.PKFilter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class azap
  implements ayyj.a, QQSpecialAVFilter.MusicWaveformSupporter
{
  private azbe a;
  private PKFilter b;
  private boolean dCl;
  private boolean dCm;
  public boolean dCn;
  private int eNy;
  private int height;
  private QQFilterRenderManager mManager = awte.c();
  private MusicItemInfo mMusicItemInfo;
  private boolean mRenderEditVideoFilterBitmap;
  private int width;
  
  public azap(List<FilterDesc> paramList, MusicItemInfo paramMusicItemInfo, int paramInt1, int paramInt2, PublishVideoEntry paramPublishVideoEntry)
  {
    if (paramList != null)
    {
      paramPublishVideoEntry = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        FilterDesc localFilterDesc = (FilterDesc)paramList.next();
        if (localFilterDesc != null)
        {
          int i = QQAVImageFilterConstants.getFilterType(localFilterDesc.id);
          if (i == 0)
          {
            this.dCn = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 2)
          {
            this.dCn = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 5)
          {
            this.dCn = false;
            paramPublishVideoEntry.add(localFilterDesc);
          }
          else if (i == 1)
          {
            this.dCn = true;
            paramPublishVideoEntry.clear();
            paramPublishVideoEntry.add(localFilterDesc);
          }
        }
      }
      if (paramPublishVideoEntry.size() > 0) {
        this.mManager.getBusinessOperation().setFilterEffectList(paramPublishVideoEntry);
      }
    }
    paramList = this.mManager.getQQFilters(80);
    if ((paramMusicItemInfo != null) && (paramList.size() > 0))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        ((QQSpecialAVFilter)paramList.next()).setMusicWaveformSupporter(this);
      }
    }
    this.mMusicItemInfo = paramMusicItemInfo;
    this.dCl = false;
    this.width = paramInt1;
    this.height = paramInt2;
    if (this.mMusicItemInfo != null) {
      eUD();
    }
  }
  
  @TargetApi(17)
  private void eUD()
  {
    if (this.mMusicItemInfo != null)
    {
      this.a = new azbe();
      if (!azbf.aRD()) {
        break label44;
      }
      this.dCm = true;
      if (QLog.isColorLevel()) {
        QLog.e("QQEncodeFilterRender", 2, "musicSoundFile create give up, is rubbish Meizu");
      }
    }
    for (;;)
    {
      return;
      label44:
      this.dCl = true;
      azaq localazaq = new azaq(this);
      try
      {
        long l = SystemClock.elapsedRealtimeNanos();
        boolean bool = this.a.a(this.mMusicItemInfo, localazaq, 0);
        if (QLog.isColorLevel()) {
          QLog.d("QQEncodeFilterRender", 2, "createSoundFile time: " + (SystemClock.elapsedRealtimeNanos() - l) / 1000000L + "ms");
        }
        if (!bool)
        {
          this.a = null;
          if (QLog.isColorLevel())
          {
            QLog.e("QQEncodeFilterRender", 2, "create MusicSoundFile fail");
            return;
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("QQEncodeFilterRender", 2, localException.toString());
        }
        this.a = null;
      }
    }
  }
  
  public int a(int paramInt1, int paramInt2, int paramInt3, long paramLong)
  {
    this.eNy = ((int)(paramLong / 1000000L));
    this.mManager.getBusinessOperation().SetTimeStamp(paramLong, paramLong);
    return this.mManager.drawFrame(paramInt3);
  }
  
  public PKFilter a()
  {
    return this.b;
  }
  
  public void eUE()
  {
    this.mManager.surfaceDestroyed();
    this.a = null;
  }
  
  public int g(int paramInt, long paramLong)
  {
    return a(this.width, this.height, paramInt, paramLong);
  }
  
  public float getCurrentMusicGain()
  {
    try
    {
      if (this.a != null)
      {
        if (this.dCm) {
          return 0.5F;
        }
        float f = this.a.B(this.eNy);
        return f;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QQEncodeFilterRender", 2, "getCurrentMusicGain() error: " + localException.toString());
      }
    }
    return -1.0F;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    return this.mMusicItemInfo;
  }
  
  public QQFilterRenderManager getQQFilterRenderManager()
  {
    return this.mManager;
  }
  
  public void lH(int paramInt1, int paramInt2)
  {
    this.mManager.surfaceCreate(paramInt1, paramInt2, paramInt1, paramInt2);
    this.mManager.surfaceChange(paramInt1, paramInt2, paramInt1, paramInt2);
  }
  
  public void setRenderEditVideoFilterBitmap(boolean paramBoolean)
  {
    this.mRenderEditVideoFilterBitmap = paramBoolean;
  }
  
  public void surfaceCreate(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mManager.surfaceCreate(paramInt1, paramInt2, paramInt3, paramInt4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azap
 * JD-Core Version:    0.7.0.1
 */