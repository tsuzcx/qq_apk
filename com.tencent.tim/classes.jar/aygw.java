import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.IEventReceiver;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMultiSegment.1;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoMultiSegment.2;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class aygw
  extends aygy
  implements aydt, IEventReceiver
{
  private List<Long> Nx;
  private long aCM;
  private long aCN;
  private long aCO;
  private boolean aEi;
  private boolean dxn;
  private Handler mHandler;
  
  public aygw(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private long ac(long paramLong)
  {
    int k = 0;
    if ((this.Nx == null) || (this.Nx.size() == 0)) {
      return paramLong;
    }
    int i = 0;
    for (;;)
    {
      int j = k;
      if (i < this.Nx.size())
      {
        if (((Long)this.Nx.get(i)).longValue() > paramLong) {
          j = 1;
        }
      }
      else
      {
        if (j == 0) {
          break label104;
        }
        if (i != 0) {
          break;
        }
        return 0L;
      }
      i += 1;
    }
    return ((Long)this.Nx.get(i - 1)).longValue();
    label104:
    return ((Long)this.Nx.get(this.Nx.size() - 1)).longValue();
  }
  
  private void eRD()
  {
    if (!QLog.isColorLevel()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder("keyFrames{");
    if ((this.Nx == null) || (this.Nx.size() == 0)) {
      localStringBuilder.append('}');
    }
    for (;;)
    {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, localStringBuilder.toString());
      return;
      Iterator localIterator = this.Nx.iterator();
      while (localIterator.hasNext())
      {
        localStringBuilder.append((Long)localIterator.next());
        localStringBuilder.append(",");
      }
      localStringBuilder.append('}');
    }
  }
  
  private void f(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seekPlayer, pos:" + paramLong);
    }
    Object localObject;
    if (this.mHandler != null)
    {
      this.mHandler.removeCallbacksAndMessages(null);
      this.mHandler.postDelayed(new EditVideoMultiSegment.2(this), 3000L);
      boolean bool2 = false;
      long l2 = 0L;
      long l1 = l2;
      boolean bool1 = bool2;
      if (this.Nx != null)
      {
        l1 = l2;
        bool1 = bool2;
        if (this.Nx.size() != 0)
        {
          l1 = l2;
          bool1 = bool2;
          if (!this.dxn)
          {
            l1 = l2;
            bool1 = bool2;
            if (paramBoolean2)
            {
              l1 = l2;
              bool1 = bool2;
              if (paramLong >= this.aCN)
              {
                l2 = ac(paramLong);
                l1 = l2;
                bool1 = bool2;
                if (l2 < this.aCN)
                {
                  l1 = l2;
                  bool1 = bool2;
                  if (this.aCN <= paramLong)
                  {
                    bool1 = true;
                    l1 = l2;
                  }
                }
              }
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seekplayer, pos: " + paramLong + " keyPos:" + l1 + " curseek:" + this.aCN + " useIFrame:" + this.dxn + "  bNext:" + bool1);
      }
      localObject = (ayhm)a(ayhm.class);
      if (localObject != null)
      {
        if (!bool1) {
          break label340;
        }
        ((ayhm)localObject).aH(paramLong, paramBoolean1);
      }
    }
    for (;;)
    {
      this.aCN = paramLong;
      this.aEi = true;
      localObject = (aydu)a(aydu.class);
      if (localObject != null) {
        ((aydu)localObject).seekTo(paramLong);
      }
      return;
      label340:
      ((ayhm)localObject).aG(paramLong, paramBoolean1);
    }
  }
  
  public void aI(long paramLong, boolean paramBoolean)
  {
    e(paramLong, paramBoolean, true);
  }
  
  public boolean aQt()
  {
    if (this.dxn) {
      return true;
    }
    ayhm localayhm = (ayhm)a(ayhm.class);
    if (localayhm != null) {
      this.dxn = localayhm.dt(this.aCO);
    }
    return this.dxn;
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject) {}
  
  public void e(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((this.aEi) && (paramBoolean2))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "seek, current state is seeking, pos:" + paramLong);
      }
      this.aCM = paramLong;
      return;
    }
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      f(paramLong, paramBoolean1, paramBoolean2);
      return;
    }
    ThreadManager.getUIHandler().post(new EditVideoMultiSegment.1(this, paramLong, paramBoolean1, paramBoolean2));
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return super.e(paramMessage);
    case 13: 
      this.aCO = ((Long[])(Long[])paramMessage.obj)[0].longValue();
      this.aEi = false;
      return true;
    }
    this.aEi = false;
    return true;
  }
  
  public int getPlayMode()
  {
    ayhm localayhm = (ayhm)a(ayhm.class);
    if (localayhm != null) {
      return localayhm.getPlayMode();
    }
    return 0;
  }
  
  public void oO(List<Long> paramList)
  {
    if (this.Nx == null) {
      this.Nx = new ArrayList();
    }
    this.Nx.clear();
    this.Nx.addAll(paramList);
    eRD();
  }
  
  public void onCreate()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "onCreate");
    }
    this.mHandler = new Handler();
    a(aydt.class, this);
    if ((this.b.a.a instanceof EditLocalVideoSource))
    {
      long l = ((EditLocalVideoSource)this.b.a.a).startTime * -1;
      SegmentKeeper.adjustTime(l);
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "local video, adjusttime::" + l);
      }
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqstory.publish.edit.EditVideoMultiSegment", 2, "onDestroy");
    }
    this.mHandler = null;
  }
  
  public void pausePlay()
  {
    Object localObject = (ayhm)a(ayhm.class);
    if (localObject != null) {
      ((ayhm)localObject).pause();
    }
    localObject = (aydu)a(aydu.class);
    if (localObject != null) {
      ((aydu)localObject).bsh();
    }
  }
  
  public void resumePlay()
  {
    Object localObject = (ayhm)a(ayhm.class);
    if (localObject != null) {
      ((ayhm)localObject).play();
    }
    localObject = (aydu)a(aydu.class);
    if (localObject != null) {
      ((aydu)localObject).bsi();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygw
 * JD-Core Version:    0.7.0.1
 */