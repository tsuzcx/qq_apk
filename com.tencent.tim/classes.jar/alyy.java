import android.text.TextUtils;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.Mp4FlowReEncoder;
import com.tencent.qphone.base.util.QLog;

public class alyy
{
  private volatile int dAO = 0;
  private volatile boolean mFinished;
  private Object mLock = new Object();
  
  private void a(alyy.a parama, amae paramamae)
  {
    int i = 1;
    boolean bool1 = parama.i.isLocalPublish;
    if (parama.i.businessId == 1)
    {
      boolean bool2 = parama.i.getBooleanExtra("is_hw_encode", false);
      if ((!bool1) && (bool2)) {
        break label50;
      }
    }
    label50:
    do
    {
      return;
      i = 0;
      break;
      if ((i != 0) || (parama.i.businessId == 9))
      {
        if (QLog.isColorLevel()) {
          QLog.d("MergeEditVideo", 2, "adjust encode config orientation:" + paramamae.toString());
        }
        paramamae.orientation = 0;
      }
    } while (!QLog.isColorLevel());
    QLog.d("MergeEditVideo", 2, "adjust encodeConfig result:" + paramamae.toString());
  }
  
  public int a(String arg1, String paramString2, alyy.a parama)
  {
    if ((parama == null) || (parama.i == null)) {
      i = -1;
    }
    String str;
    Object localObject;
    do
    {
      return i;
      str = parama.i.getStringExtra("subtitleData", "");
      localObject = new ankk.a();
      j = ankk.a(???, (ankk.a)localObject);
      i = j;
    } while (j != 0);
    int k = localObject.mMetaData[0];
    int m = localObject.mMetaData[1];
    int n = localObject.mMetaData[2];
    int i = localObject.mMetaData[4];
    int i1 = parama.bitrate;
    int j = 0;
    i = j;
    if (!parama.i.isLocalPublish)
    {
      i = j;
      if (parama.i.getBooleanExtra("is_hw_encode", false))
      {
        i = j;
        if (parama.i.businessId == 1)
        {
          i = j;
          if (n != 0) {
            i = 1;
          }
        }
      }
    }
    if ((parama.dAP == 0) && (parama.filterType == 0) && (parama.i.doodlePath == null) && (parama.i.mosaicPath == null) && (parama.i.businessId != 9) && (TextUtils.isEmpty(str)) && (!parama.i.hasFragments) && (TextUtils.isEmpty(parama.i.fragments)) && (i == 0)) {
      return -1;
    }
    boolean bool = parama.i.getBooleanExtra("enable_flow_decode", true);
    QLog.d("MergeEditVideo", 2, "mergeVideo. enableFlowDecode = " + bool + ", speedMode = " + parama.dAP);
    j = parama.i.videoRangeStart;
    i = parama.i.videoRangeEnd;
    if ((!bool) && (parama.dAP == 3))
    {
      ??? = parama.i.mIFrameVideoPath;
      i = 0;
      j = 0;
    }
    for (;;)
    {
      this.dAO = 0;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = 0;
      if ((bool) && (parama.dAP == 3))
      {
        localObject = new Mp4FlowReEncoder();
        arrayOfInt[0] = 1;
      }
      for (;;)
      {
        alza localalza = new alza(???, parama.dAP, false, true, j, i);
        if (((parama.i.businessId == 10) && ((n == 270) || (n == 90))) || ((parama.i.businessId == 12) && ((n == 270) || (n == 90))))
        {
          ??? = new amae(paramString2, m, k, i1, 1, 30, parama.filterType, false, 0, parama.i.doodlePath, parama.i.mosaicPath, str, false);
          ???.dBc = n;
          localalza.cBx = true;
          a(parama, ???);
          localalza.adjustRotation = n;
          ???.dzA = parama.dzA;
          ???.dzB = parama.dzB;
          ((alzt)localObject).a(localalza, ???, new alyz(this, arrayOfInt), null);
          if (this.mFinished) {}
        }
        synchronized (this.mLock)
        {
          bool = this.mFinished;
          if (!bool) {}
          try
          {
            this.mLock.wait();
            return this.dAO;
            localObject = new amah();
            arrayOfInt[0] = 2;
            continue;
            ??? = new amae(paramString2, k, m, i1, 1, 30, parama.filterType, false, n, parama.i.doodlePath, parama.i.mosaicPath, str, false);
          }
          catch (InterruptedException paramString2)
          {
            for (;;)
            {
              paramString2.printStackTrace();
            }
          }
        }
      }
    }
  }
  
  public static class a
  {
    protected int bitrate;
    protected int dAP;
    protected int dzA = -1;
    protected int dzB = -1;
    protected int filterType;
    protected PublishVideoEntry i;
    
    public a(int paramInt, PublishVideoEntry paramPublishVideoEntry)
    {
      this.bitrate = paramInt;
      this.i = new PublishVideoEntry();
      this.i.copy(paramPublishVideoEntry);
      Uf(this.i.saveMode);
    }
    
    private int getFilterType(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return 0;
      case 7: 
        return 5;
      case 8: 
        return 6;
      case 9: 
        return 7;
      }
      return 4;
    }
    
    public void TV(int paramInt)
    {
      this.dzA = paramInt;
    }
    
    public void Uf(int paramInt)
    {
      this.filterType = getFilterType(paramInt);
      this.dAP = iV(paramInt);
    }
    
    public int iV(int paramInt)
    {
      switch (paramInt)
      {
      case 3: 
      case 4: 
      default: 
        return 0;
      case 1: 
        return 1;
      case 2: 
        return 2;
      }
      return 3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alyy
 * JD-Core Version:    0.7.0.1
 */