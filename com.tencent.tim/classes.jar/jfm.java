import com.tencent.av.VideoController;
import com.tencent.av.VideoController.b;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public final class jfm
  implements jfk
{
  public static final String TAG = jfm.class.getSimpleName();
  private boolean YQ;
  private boolean YR = true;
  private VideoController a;
  private int ayx;
  private int ayy = -1;
  private VideoLayerUI b;
  private final Object[] h = new Object[0];
  private final Object[] i = new Object[0];
  private ArrayList<VideoController.b> iU = new ArrayList();
  private ArrayList<jfj> iV = new ArrayList();
  private final Object[] j = new Object[0];
  private boolean mIsDestroyed;
  
  public jfm(VideoController paramVideoController, VideoLayerUI paramVideoLayerUI)
  {
    this.a = paramVideoController;
    this.b = paramVideoLayerUI;
  }
  
  private String e(long paramLong, int paramInt)
  {
    return String.valueOf(paramLong) + String.valueOf(paramInt);
  }
  
  public ArrayList<jfj> a(boolean paramBoolean)
  {
    int k = 0;
    long l = System.currentTimeMillis();
    synchronized (this.h)
    {
      if (this.YQ)
      {
        this.YQ = false;
        k = 1;
      }
    }
    Object localObject11;
    Object localObject13;
    Object localObject14;
    synchronized (this.i)
    {
      if (this.YR)
      {
        this.YR = false;
        k = 1;
      }
      if ((k == 0) && (!paramBoolean)) {
        break label702;
      }
      synchronized (this.j)
      {
        this.iV.clear();
        localObject11 = new HashMap();
        synchronized (this.a.b().ig)
        {
          Iterator localIterator = this.a.b().ig.iterator();
          do
          {
            if (!localIterator.hasNext()) {
              break;
            }
            localObject13 = (ioa)localIterator.next();
            ??? = new jfj();
            ((jfj)???).uin = ((ioa)localObject13).uin;
            ((jfj)???).awy = ((ioa)localObject13).videoSrcType;
            ((jfj)???).Ts = ((ioa)localObject13).Ts;
            ((jfj)???).Tp = ((ioa)localObject13).Tp;
            ((jfj)???).Xc = true;
            ((jfj)???).Ww = true;
            this.iV.add(???);
            localObject13 = e(((jfj)???).uin, ((jfj)???).awy);
            localObject14 = (jfj)((HashMap)localObject11).put(localObject13, ???);
          } while (localObject14 == null);
          if (((jfj)???).xa()) {
            ((HashMap)localObject11).put(localObject13, localObject14);
          }
          QLog.w(TAG, 1, "getVideoViewList oldInfo:=" + ((jfj)localObject14).toString());
        }
      }
      localObject7 = finally;
      throw localObject7;
    }
    this.ayx = this.iV.size();
    Object localObject9;
    for (;;)
    {
      synchronized (this.h)
      {
        localObject13 = this.iU.iterator();
        if (!((Iterator)localObject13).hasNext()) {
          break;
        }
        localObject14 = (VideoController.b)((Iterator)localObject13).next();
        localObject9 = (jfj)((HashMap)localObject11).get(e(((VideoController.b)localObject14).uin, 1));
        Object localObject3 = localObject9;
        if (localObject9 == null) {
          localObject3 = (jfj)((HashMap)localObject11).get(e(((VideoController.b)localObject14).uin, 2));
        }
        if (localObject3 == null) {
          break label519;
        }
        if (((jfj)localObject3).getVideoSrcType() != 2)
        {
          ((jfj)localObject3).Wu = ((VideoController.b)localObject14).Pg;
          ((jfj)localObject3).accountType = ((VideoController.b)localObject14).accountType;
          ((jfj)localObject3).b = ((VideoController.b)localObject14).a;
          ((jfj)localObject3).Pk = ((VideoController.b)localObject14).Pk;
          ((jfj)localObject3).Pl = ((VideoController.b)localObject14).Pl;
        }
      }
      localObject4.Wu = false;
      continue;
      label519:
      ??? = new jfj();
      ((jfj)???).uin = ((VideoController.b)localObject14).uin;
      ((jfj)???).awy = 0;
      ((jfj)???).Xc = false;
      ((jfj)???).Ww = ((VideoController.b)localObject14).Pn;
      ((jfj)???).b = ((VideoController.b)localObject14).a;
      ((jfj)???).Wu = ((VideoController.b)localObject14).Pg;
      ((jfj)???).accountType = ((VideoController.b)localObject14).accountType;
      ((jfj)???).Pk = ((VideoController.b)localObject14).Pk;
      ((jfj)???).Pl = ((VideoController.b)localObject14).Pl;
      this.iV.add(???);
    }
    ??? = this.iV.iterator();
    while (((Iterator)???).hasNext())
    {
      localObject9 = (jfj)((Iterator)???).next();
      localObject11 = this.b.b(((jfj)localObject9).uin);
      if (localObject11 != null)
      {
        ((jfj)localObject9).Wu = ((jfj)localObject11).Wu;
        ((jfj)localObject9).Pk = ((jfj)localObject11).Pk;
      }
    }
    label702:
    synchronized (this.j)
    {
      localObject9 = (ArrayList)this.iV.clone();
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 1, "getVideoViewList listSort exceedMaxNumber cost" + (System.currentTimeMillis() - l));
      }
      return localObject9;
    }
  }
  
  public ArrayList<jfj> aT()
  {
    synchronized (this.j)
    {
      ArrayList localArrayList = (ArrayList)this.iV.clone();
      return localArrayList;
    }
  }
  
  public void avE()
  {
    if (this.mIsDestroyed) {
      return;
    }
    QLog.w(TAG, 1, "onMemmbersInOrOutChange");
    synchronized (this.i)
    {
      this.YR = true;
      return;
    }
  }
  
  public void bH(ArrayList<VideoController.b> paramArrayList)
  {
    QLog.w(TAG, 1, "updateAudioMemberListInfo");
    if (this.mIsDestroyed) {
      return;
    }
    synchronized (this.h)
    {
      this.YQ = true;
      this.iU.clear();
      this.iU.addAll(paramArrayList);
      return;
    }
  }
  
  public void doDestroy()
  {
    synchronized (this.h)
    {
      this.YQ = false;
      this.iU.clear();
    }
    synchronized (this.j)
    {
      this.iV.clear();
      this.mIsDestroyed = true;
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public boolean g(long paramLong, boolean paramBoolean)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    synchronized (this.h)
    {
      this.YQ = true;
      return true;
    }
  }
  
  public boolean h(long paramLong, boolean paramBoolean)
  {
    if (this.mIsDestroyed) {
      return false;
    }
    synchronized (this.h)
    {
      this.YQ = true;
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jfm
 * JD-Core Version:    0.7.0.1
 */