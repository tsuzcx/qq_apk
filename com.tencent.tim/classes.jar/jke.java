import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.av.opengl.effects.AEFilterSupport;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class jke
{
  private boolean ZL;
  private int aAt;
  private final HashMap<String, Long> cJ = new HashMap(10);
  private final HashMap<String, Long> cK = new HashMap(10);
  private int curIndex;
  private int frameCount;
  private final ArrayList<String> jc = new ArrayList(10);
  private long pS;
  private long pT;
  private long pU;
  private final long pV;
  private final long[] s = new long[20];
  
  public jke()
  {
    if (AudioHelper.jY(34) == 1) {}
    for (;;)
    {
      this.ZL = bool;
      while (i < this.s.length)
      {
        this.s[i] = 0L;
        i += 1;
      }
      bool = false;
    }
    i = AEFilterSupport.lo();
    if (i >= 7) {
      this.pV = 30L;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PerfRecorder", 2, "logPerfData[" + this.ZL + "], machineLevel[" + i + "], frameCostLine[" + this.pV + "]");
      }
      return;
      if (i >= 4) {
        this.pV = 48L;
      } else {
        this.pV = 66L;
      }
    }
  }
  
  public void apf()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject = localStringBuilder.append("endOfOneChat, frameAvgCost[").append(this.pU).append("], frameCount[").append(this.frameCount).append("], frameTotalCost[").append(this.pT).append("], frameAvgCost2[");
      long l;
      if (this.frameCount > 0)
      {
        l = this.pT / this.frameCount;
        localObject = ((StringBuilder)localObject).append(l).append("], frameCostLine[").append(this.pV).append("], frameCostOverLineCnt[").append(this.aAt).append("], frameCostOverLine[");
        if (this.frameCount <= 0) {
          break label193;
        }
      }
      label193:
      for (float f = this.aAt / this.frameCount;; f = 0.0F)
      {
        ((StringBuilder)localObject).append(f).append("], {");
        localObject = this.s;
        int j = localObject.length;
        i = 0;
        while (i < j)
        {
          localStringBuilder.append(localObject[i]).append(",");
          i += 1;
        }
        l = 0L;
        break;
      }
      localStringBuilder.append("}");
      QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    }
    this.frameCount = 0;
    this.pT = 0L;
    this.pU = 0L;
    int i = 0;
    while (i < this.s.length)
    {
      this.s[i] = 0L;
      i += 1;
    }
    this.curIndex = 0;
    this.aAt = 0;
  }
  
  public void axq()
  {
    this.cJ.clear();
    this.jc.clear();
    this.pS = SystemClock.elapsedRealtime();
  }
  
  public void ed(long paramLong)
  {
    long l3 = SystemClock.elapsedRealtime() - this.pS;
    this.frameCount += 1;
    this.pT += l3;
    if (this.pU == 0L) {}
    for (this.pU = l3;; this.pU = ((this.pU + l3) / 2L))
    {
      if (l3 > this.s[this.curIndex]) {
        this.s[this.curIndex] = l3;
      }
      long l1 = this.s[this.curIndex];
      int i = 0;
      while (i < this.s.length)
      {
        long l2 = l1;
        if (this.s[i] < l1)
        {
          l2 = this.s[i];
          this.curIndex = i;
        }
        i += 1;
        l1 = l2;
      }
    }
    if (l3 > this.pV) {
      this.aAt += 1;
    }
    this.cK.clear();
    if ((this.ZL) && (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("frameEnd, frameIndex: ").append(paramLong).append(", curFrameCost: ").append(l3).append(", frameCount: ").append(this.frameCount).append(", frameTotalCost: ").append(this.pT).append(", stepCost{");
      Iterator localIterator = this.jc.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Long localLong = (Long)this.cJ.get(str);
        localStringBuilder.append(str).append(" : ").append(localLong).append(", ");
      }
      localStringBuilder.append("}, ");
      QLog.i("PerfRecorder", 2, localStringBuilder.toString());
    }
  }
  
  public void kK(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      this.cK.put(paramString, Long.valueOf(SystemClock.elapsedRealtime()));
      this.jc.add(paramString);
    }
  }
  
  public void kL(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Long localLong = (Long)this.cK.get(paramString);
      if (localLong != null) {
        this.cJ.put(paramString, Long.valueOf(SystemClock.elapsedRealtime() - localLong.longValue()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jke
 * JD-Core Version:    0.7.0.1
 */