import android.text.TextUtils;
import com.tencent.av.opengl.filter.qqavimage.QQAVImageFilterConstants;
import com.tencent.mobileqq.richmedia.capture.data.FilterDesc;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.mobileqq.shortvideo.filter.FilterBusinessOperation;
import com.tencent.mobileqq.shortvideo.filter.QQFilterRenderManager;
import com.tencent.mobileqq.shortvideo.filter.QQSpecialAVFilter.MusicWaveformSupporter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import dov.com.qq.im.capture.music.QQMusicDownloader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class axro
  extends axon
  implements QQSpecialAVFilter.MusicWaveformSupporter
{
  private axri jdField_a_of_type_Axri;
  private axrj jdField_a_of_type_Axrj;
  private azbf jdField_a_of_type_Azbf = new azbf();
  private MusicItemInfo d;
  private boolean dwn;
  private boolean dwo;
  private MusicItemInfo e;
  private volatile int eCJ = 0;
  private int eGO = awte.eCQ;
  public ConcurrentHashMap<String, MusicItemInfo> ki = new ConcurrentHashMap();
  private ConcurrentHashMap<String, aquz> kj = new ConcurrentHashMap();
  private List<axrk> mListeners = new ArrayList();
  private HashMap<Integer, axrj> ru = new HashMap();
  
  /* Error */
  private axrj a(MusicItemInfo paramMusicItemInfo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aconst_null
    //   3: astore_2
    //   4: aload_1
    //   5: getfield 72	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   8: iconst_1
    //   9: if_icmpne +62 -> 71
    //   12: aload_0
    //   13: getfield 55	axro:ru	Ljava/util/HashMap;
    //   16: iconst_1
    //   17: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   20: invokevirtual 82	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   23: checkcast 84	axrj
    //   26: astore_3
    //   27: aload_3
    //   28: astore_2
    //   29: aload_3
    //   30: ifnonnull +32 -> 62
    //   33: new 84	axrj
    //   36: dup
    //   37: invokespecial 85	axrj:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: aload_0
    //   43: getfield 60	axro:mListeners	Ljava/util/List;
    //   46: invokevirtual 89	axrj:oJ	(Ljava/util/List;)V
    //   49: aload_0
    //   50: getfield 55	axro:ru	Ljava/util/HashMap;
    //   53: iconst_1
    //   54: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   57: aload_2
    //   58: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   61: pop
    //   62: aload_2
    //   63: aload_1
    //   64: invokevirtual 97	axrj:b	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: aload_2
    //   70: areturn
    //   71: aload_1
    //   72: getfield 72	com/tencent/mobileqq/richmedia/capture/data/MusicItemInfo:mType	I
    //   75: iconst_5
    //   76: if_icmpne -9 -> 67
    //   79: aload_0
    //   80: getfield 55	axro:ru	Ljava/util/HashMap;
    //   83: iconst_2
    //   84: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   87: invokevirtual 82	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 84	axrj
    //   93: astore_3
    //   94: aload_3
    //   95: astore_2
    //   96: aload_3
    //   97: ifnonnull +32 -> 129
    //   100: new 99	dov/com/qq/im/capture/music/QQMusicPlayerScene
    //   103: dup
    //   104: invokespecial 100	dov/com/qq/im/capture/music/QQMusicPlayerScene:<init>	()V
    //   107: astore_2
    //   108: aload_2
    //   109: aload_0
    //   110: getfield 60	axro:mListeners	Ljava/util/List;
    //   113: invokevirtual 89	axrj:oJ	(Ljava/util/List;)V
    //   116: aload_0
    //   117: getfield 55	axro:ru	Ljava/util/HashMap;
    //   120: iconst_2
    //   121: invokestatic 78	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aload_2
    //   125: invokevirtual 93	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   128: pop
    //   129: aload_2
    //   130: aload_1
    //   131: invokevirtual 97	axrj:b	(Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;)V
    //   134: goto -67 -> 67
    //   137: astore_1
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_1
    //   141: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	axro
    //   0	142	1	paramMusicItemInfo	MusicItemInfo
    //   3	127	2	localObject	Object
    //   26	71	3	localaxrj	axrj
    // Exception table:
    //   from	to	target	type
    //   4	27	137	finally
    //   33	62	137	finally
    //   62	67	137	finally
    //   71	94	137	finally
    //   100	129	137	finally
    //   129	134	137	finally
  }
  
  private void eOk()
  {
    if (this.jdField_a_of_type_Axrj != null)
    {
      eOr();
      this.jdField_a_of_type_Axrj.eOk();
    }
  }
  
  private void g(MusicItemInfo paramMusicItemInfo)
  {
    if ((this.jdField_a_of_type_Axri != null) && (!this.dwn) && ((this.d == null) || (this.d.isMute() != paramMusicItemInfo.isMute()))) {
      this.jdField_a_of_type_Axri.YS(paramMusicItemInfo.isMute());
    }
  }
  
  public void YV(boolean paramBoolean)
  {
    this.dwn = paramBoolean;
  }
  
  public void Zx()
  {
    if (this.jdField_a_of_type_Axrj != null) {
      this.jdField_a_of_type_Axrj.Zx();
    }
  }
  
  public void a(axri paramaxri)
  {
    this.jdField_a_of_type_Axri = paramaxri;
    if ((!this.dwn) && (this.d != null) && (this.jdField_a_of_type_Axri != null)) {
      this.jdField_a_of_type_Axri.YS(this.d.isMute());
    }
  }
  
  public void a(axrk paramaxrk)
  {
    if ((paramaxrk == null) || (this.mListeners == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener listener = null");
      }
    }
    do
    {
      return;
      if (!this.mListeners.contains(paramaxrk)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QimMusicPlayer", 2, "addMusicPlayerSceneListener mListeners has listener");
    return;
    this.mListeners.add(paramaxrk);
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "replaceCurMusicInfoForFuturePlay");
    }
    if (!b(paramMusicItemInfo)) {
      return false;
    }
    if ((this.d == paramMusicItemInfo) && (isPlaying()))
    {
      QLog.i("QimMusicPlayer", 1, "have playing" + paramMusicItemInfo);
      return false;
    }
    g(paramMusicItemInfo);
    if (this.mListeners != null)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((axrk)localIterator.next()).d(paramMusicItemInfo);
      }
    }
    eOq();
    this.d = paramMusicItemInfo;
    this.e = paramMusicItemInfo;
    this.jdField_a_of_type_Axrj = a(paramMusicItemInfo);
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, int paramInt)
  {
    return a(paramMusicItemInfo, false, paramInt);
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, axrh paramaxrh)
  {
    String str;
    if ((!b(paramMusicItemInfo)) && (paramMusicItemInfo != null))
    {
      str = paramMusicItemInfo.getLocalPath();
      if (!TextUtils.isEmpty(str)) {}
    }
    else
    {
      return false;
    }
    if (!this.ki.containsKey(str))
    {
      paramMusicItemInfo.mProgress = 0;
      paramaxrh = new axrn(this.ki, this.kj, paramaxrh);
      aquz localaquz = QQMusicDownloader.a(paramMusicItemInfo.mUrl, str, paramaxrh);
      if (localaquz != null)
      {
        this.kj.put(str, localaquz);
        QQMusicDownloader.a(localaquz, paramaxrh);
        this.ki.put(str, paramMusicItemInfo);
      }
    }
    return true;
  }
  
  public boolean a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "requestPlay " + paramInt + " " + this.eCJ);
    }
    this.eCJ = paramInt;
    if (!b(paramMusicItemInfo)) {}
    while ((anhq.a().axb()) || (c(paramMusicItemInfo))) {
      return false;
    }
    if ((this.d == paramMusicItemInfo) && (isPlaying()) && (!paramBoolean))
    {
      QLog.i("QimMusicPlayer", 1, "have playing" + paramMusicItemInfo);
      return false;
    }
    g(paramMusicItemInfo);
    if (this.mListeners != null)
    {
      Iterator localIterator = this.mListeners.iterator();
      while (localIterator.hasNext()) {
        ((axrk)localIterator.next()).d(paramMusicItemInfo);
      }
    }
    eOq();
    this.d = paramMusicItemInfo;
    this.e = paramMusicItemInfo;
    this.jdField_a_of_type_Axrj = a(paramMusicItemInfo);
    eOk();
    return true;
  }
  
  public boolean aPD()
  {
    int j = this.eGO;
    int i = j;
    if (j == awte.eCQ) {
      i = awte.QE();
    }
    QQFilterRenderManager localQQFilterRenderManager = awte.a(i);
    FilterDesc localFilterDesc = null;
    if (localQQFilterRenderManager != null) {
      localFilterDesc = localQQFilterRenderManager.getBusinessOperation().getCurrentAVFilterIdByType(2);
    }
    return (localFilterDesc != null) && (QQAVImageFilterConstants.isMusicSpecialFilter(localFilterDesc.id));
  }
  
  public void aeH(int paramInt)
  {
    if (this.jdField_a_of_type_Axri != null) {
      this.jdField_a_of_type_Axri.YS(true);
    }
    r(-1, -1, paramInt);
  }
  
  public void aeI(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "pauseMusicCheckScene " + paramInt + " " + this.eCJ);
    }
    if (paramInt != this.eCJ) {}
    while (this.jdField_a_of_type_Axrj == null) {
      return;
    }
    this.jdField_a_of_type_Axrj.Zx();
  }
  
  public void aeJ(int paramInt)
  {
    this.eGO = paramInt;
  }
  
  public MusicItemInfo b()
  {
    if (this.d == null) {}
    while ((this.d.mType != 5) && (this.d.mType != 1)) {
      return null;
    }
    return this.d;
  }
  
  public void b(axrk paramaxrk)
  {
    if ((this.mListeners != null) && (this.mListeners.contains(paramaxrk))) {
      this.mListeners.remove(paramaxrk);
    }
  }
  
  public boolean b(MusicItemInfo paramMusicItemInfo)
  {
    if (paramMusicItemInfo == null) {}
    while (((paramMusicItemInfo.mType == 5) || (paramMusicItemInfo.mType == 1)) && (!aqhq.fileExistsAndNotEmpty(paramMusicItemInfo.getLocalPath()))) {
      return false;
    }
    return true;
  }
  
  public MusicItemInfo c()
  {
    return this.e;
  }
  
  public boolean c(MusicItemInfo paramMusicItemInfo)
  {
    if (!this.dwo) {}
    while ((getCurrentPosition() == -1) || (!paramMusicItemInfo.mSongMid.equals(b().mSongMid)) || (getCurrentPosition() >= paramMusicItemInfo.musicDuration)) {
      return false;
    }
    return true;
  }
  
  public void eOq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QimMusicPlayer", 2, "clearMusic ");
    }
    this.e = null;
    this.d = null;
    if (this.jdField_a_of_type_Axrj != null) {
      this.jdField_a_of_type_Axrj.stopMusic();
    }
  }
  
  public void eOr()
  {
    MusicItemInfo localMusicItemInfo = b();
    if (localMusicItemInfo == null) {}
    label9:
    QQFilterRenderManager localQQFilterRenderManager;
    do
    {
      do
      {
        break label9;
        do
        {
          return;
        } while (this.jdField_a_of_type_Azbf == null);
        int j = this.eGO;
        int i = j;
        if (j == awte.eCQ) {
          i = awte.QE();
        }
        localQQFilterRenderManager = awte.a(i);
        if ((localMusicItemInfo.needPlay()) && (aPD()))
        {
          if (isPlaying()) {}
          for (i = getCurrentPosition() - localMusicItemInfo.musicStart;; i = 0)
          {
            this.jdField_a_of_type_Azbf.a(localMusicItemInfo, i);
            if (localQQFilterRenderManager == null) {
              break;
            }
            localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(this);
            return;
          }
        }
      } while ((!localMusicItemInfo.needPlay()) && (!aPD()));
      this.jdField_a_of_type_Azbf.onDestroy();
    } while (localQQFilterRenderManager == null);
    localQQFilterRenderManager.getBusinessOperation().setMusicWaveformSupporter(null);
  }
  
  public float getCurrentMusicGain()
  {
    MusicItemInfo localMusicItemInfo = b();
    if (localMusicItemInfo == null) {}
    do
    {
      for (;;)
      {
        return -1.0F;
        try
        {
          if ((this.jdField_a_of_type_Azbf != null) && (localMusicItemInfo.needPlay()) && (isPlaying()))
          {
            float f = this.jdField_a_of_type_Azbf.getCurrentGain(getCurrentPosition() - localMusicItemInfo.musicStart);
            return f;
          }
        }
        catch (Exception localException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("QimMusicPlayer", 2, "getCurrentMusicGain() error: " + localException.toString());
    return -1.0F;
  }
  
  public int getCurrentPosition()
  {
    int i = -1;
    if (isPlaying()) {
      i = this.jdField_a_of_type_Axrj.getCurrentPosition();
    }
    return i;
  }
  
  public MusicItemInfo getMusicItemInfo()
  {
    MusicItemInfo localMusicItemInfo = b();
    if ((localMusicItemInfo != null) && (localMusicItemInfo.needPlay())) {
      return localMusicItemInfo.copy();
    }
    return null;
  }
  
  public void h(MusicItemInfo paramMusicItemInfo)
  {
    if (this.kj != null)
    {
      localObject = (aquz)this.kj.get(paramMusicItemInfo.getLocalPath());
      if (localObject != null) {
        QQMusicDownloader.i((aquz)localObject);
      }
    }
    Object localObject = paramMusicItemInfo.getLocalPath();
    if ((this.ki != null) && (this.ki.contains(localObject))) {
      this.ki.remove(localObject);
    }
    paramMusicItemInfo.mProgress = -1;
    axxj.a(paramMusicItemInfo).ePi();
  }
  
  public boolean isMute()
  {
    return (this.d != null) && (this.d.isMute());
  }
  
  public boolean isPlaying()
  {
    return (this.jdField_a_of_type_Axrj != null) && (this.jdField_a_of_type_Axrj.isPlaying());
  }
  
  public void onDestroy()
  {
    this.d = null;
    this.e = null;
    this.jdField_a_of_type_Axri = null;
    this.mListeners.clear();
    this.mListeners = null;
    this.jdField_a_of_type_Axrj = null;
    this.kj.clear();
    this.ki.clear();
    Iterator localIterator = this.ru.values().iterator();
    while (localIterator.hasNext()) {
      ((axrj)localIterator.next()).destroy();
    }
    this.ru.clear();
    this.ru = null;
    this.jdField_a_of_type_Azbf.onDestroy();
    this.jdField_a_of_type_Azbf = null;
  }
  
  public void onInit() {}
  
  public boolean r(int paramInt1, int paramInt2, int paramInt3)
  {
    MusicItemInfo localMusicItemInfo = ((QIMMusicConfigManager)axov.a(2)).a(paramInt1, paramInt2);
    if (localMusicItemInfo != null) {
      return a(localMusicItemInfo, false, paramInt3);
    }
    return false;
  }
  
  public void resumeMusic()
  {
    if (this.jdField_a_of_type_Axrj != null)
    {
      if ((this.d != null) && (this.mListeners != null))
      {
        Iterator localIterator = this.mListeners.iterator();
        while (localIterator.hasNext()) {
          ((axrk)localIterator.next()).d(this.d);
        }
      }
      this.jdField_a_of_type_Axrj.resumeMusic();
      eOr();
    }
  }
  
  public void seekTo(long paramLong)
  {
    if (this.jdField_a_of_type_Axrj != null) {
      this.jdField_a_of_type_Axrj.seekTo(paramLong);
    }
  }
  
  public void setCurrentPosition(int paramInt)
  {
    if (this.jdField_a_of_type_Axrj != null) {
      this.jdField_a_of_type_Axrj.mCurrentPosition = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axro
 * JD-Core Version:    0.7.0.1
 */