import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.support.annotation.Nullable;
import android.util.AndroidRuntimeException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class alzy
  implements alze, alzk
{
  private final List<alzg> Fz = new ArrayList();
  private Comparator<alzg> T = new amaa(this);
  private alzd jdField_b_of_type_Alzd = new alzz(this);
  private alzy.a jdField_b_of_type_Alzy$a;
  private amab jdField_b_of_type_Amab = new amab();
  
  private void dLT()
  {
    synchronized (this.Fz)
    {
      Iterator localIterator = this.Fz.iterator();
      if (localIterator.hasNext()) {
        ((alzg)localIterator.next()).recycle();
      }
    }
    this.Fz.clear();
  }
  
  public void a(alza paramalza, int paramInt, SurfaceTexture.OnFrameAvailableListener paramOnFrameAvailableListener, alzd paramalzd)
  {
    throw new AndroidRuntimeException("please use startDecode(FlowDecodeConfig, FlowListener) instead");
  }
  
  public void a(alzj paramalzj, alzy.a parama)
  {
    this.jdField_b_of_type_Alzy$a = parama;
    ram.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "startDecode : decodeConfig = %s", new Object[] { paramalzj });
    this.jdField_b_of_type_Amab.a(paramalzj, this.jdField_b_of_type_Alzd, this);
  }
  
  @Nullable
  public alzg b()
  {
    synchronized (this.Fz)
    {
      if (this.Fz.size() > 0)
      {
        alzg localalzg = (alzg)this.Fz.remove(0);
        return localalzg;
      }
      return null;
    }
  }
  
  @Nullable
  public alzg c()
  {
    synchronized (this.Fz)
    {
      if (this.Fz.size() > 0)
      {
        alzg localalzg = (alzg)this.Fz.get(0);
        return localalzg;
      }
      return null;
    }
  }
  
  @Nullable
  public alzg d()
  {
    synchronized (this.Fz)
    {
      if (this.Fz.size() >= 2)
      {
        alzg localalzg = (alzg)this.Fz.get(1);
        return localalzg;
      }
      return null;
    }
  }
  
  public void dLJ()
  {
    ram.i("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of play range change");
    dLT();
  }
  
  public void dLK()
  {
    ram.i("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of direction change");
    dLT();
  }
  
  public int getFrameCount()
  {
    synchronized (this.Fz)
    {
      int i = this.Fz.size();
      return i;
    }
  }
  
  public void pauseDecode()
  {
    this.jdField_b_of_type_Amab.pauseDecode();
  }
  
  public void resumeDecode()
  {
    this.jdField_b_of_type_Amab.resumeDecode();
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    this.jdField_b_of_type_Amab.setPlayRange(paramLong1, paramLong2);
  }
  
  public void setSpeedType(int paramInt)
  {
    this.jdField_b_of_type_Amab.setSpeedType(paramInt);
  }
  
  public void stopDecode()
  {
    ram.a("FlowEdit_VideoFlowDecodeWrapper", new Throwable(), "stopDecode", new Object[0]);
    this.jdField_b_of_type_Amab.stopDecode();
    ram.i("FlowEdit_VideoFlowDecodeWrapper", "clear frame list because of stopDecode");
    dLT();
  }
  
  public int y(List<alzg> paramList)
  {
    if (paramList.size() > 0) {
      ram.i("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size " + paramList.size() + ", range [" + ((alzg)paramList.get(0)).gH() + " - " + ((alzg)paramList.get(paramList.size() - 1)).gH() + "], cycle " + ((alzg)paramList.get(0)).Iv() + ", current size " + this.Fz.size());
    }
    synchronized (this.Fz)
    {
      for (;;)
      {
        this.Fz.addAll(paramList);
        Collections.sort(this.Fz, this.T);
        int j = this.Fz.size();
        if (j <= 5) {
          break;
        }
        i = 1;
        if ((i != 0) && (this.jdField_b_of_type_Alzy$a != null)) {
          this.jdField_b_of_type_Alzy$a.dLO();
        }
        return j;
        ram.w("FlowEdit_VideoFlowDecodeWrapper", "onFrameReached : size 0");
      }
      int i = 0;
    }
  }
  
  public static abstract interface a
  {
    public abstract void dLO();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alzy
 * JD-Core Version:    0.7.0.1
 */