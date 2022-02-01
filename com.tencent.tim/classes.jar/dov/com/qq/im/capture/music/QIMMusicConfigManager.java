package dov.com.qq.im.capture.music;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import aoll;
import aolm;
import aolm.b;
import aomg;
import aomh;
import aqgz;
import aqiw;
import atad;
import axpk;
import axpm;
import axqd;
import axrf;
import axrl;
import axrm;
import axsf;
import axwf;
import com.tencent.biz.richframework.network.VSNetworkHelper;
import com.tencent.biz.richframework.network.request.BatchGetMusicInfoRequest;
import com.tencent.biz.videostory.widget.view.smartmusicview.VsMusicItemInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.PeakAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.richmedia.capture.data.MusicItemInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask;
import dov.com.qq.im.capture.control.GetSingleFullMusicInfoTask.a;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.TicketManagerImpl;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rox;

public class QIMMusicConfigManager
  extends axpm
{
  public static final File bl = new File(axwf.g(), "dov_doodle_music");
  private ArrayList<axqd> FW;
  private ArrayList<axqd> FX;
  private List<FlowMusic> Ni = new ArrayList();
  private List<a> Nj = new ArrayList();
  private axqd a;
  public String aPq = null;
  protected BroadcastReceiver ao = new axrm(this);
  public axqd b;
  public MusicItemInfo c;
  public String cVP;
  private String cVQ;
  private String cVR = "我的";
  private boolean dwj = false;
  private boolean dwk = false;
  public aolm e = a().getNetEngine(0);
  private int eGJ = 3;
  private int eGK = 0;
  private int eGL = 0;
  private int eGM = 0;
  private int eGN = 2;
  public AtomicBoolean eN = new AtomicBoolean(false);
  public EntityManager h = a().getEntityManagerFactory().createEntityManager();
  private Object mLock = new Object();
  
  private void YU(boolean paramBoolean)
  {
    if (paramBoolean) {
      adm(a().getCurrentAccountUin());
    }
  }
  
  private int a(MusicItemInfo paramMusicItemInfo)
  {
    int j;
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      j = -1;
      return j;
    }
    if (this.a.Fv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.a.Fv.size()) {
        break label156;
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.a.Fv.get(i);
      j = i;
      if (localMusicItemInfo.mItemId == paramMusicItemInfo.mItemId) {
        break;
      }
      if ((paramMusicItemInfo.mRecognitionOffset != -1.0F) && (!TextUtils.isEmpty(paramMusicItemInfo.mMusicName)) && (!TextUtils.isEmpty(localMusicItemInfo.mMusicName)))
      {
        j = i;
        if (paramMusicItemInfo.mMusicName.equals(localMusicItemInfo.mMusicName)) {
          break;
        }
      }
      i += 1;
    }
    label156:
    return -1;
  }
  
  private axqd a(MusicItemInfo paramMusicItemInfo1, MusicItemInfo paramMusicItemInfo2, MusicItemInfo paramMusicItemInfo3)
  {
    this.a = new axqd();
    this.a.cVe = 999;
    this.a.categoryName = this.cVR;
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mType = 4;
    localMusicItemInfo.mItemId = -3;
    this.a.Fv = new ArrayList();
    this.a.Fv.add(paramMusicItemInfo1);
    this.a.Fv.add(paramMusicItemInfo2);
    if (axsf.ON)
    {
      this.eGJ = 4;
      paramMusicItemInfo1 = new MusicItemInfo();
      paramMusicItemInfo1.mType = 6;
      paramMusicItemInfo1.mItemId = -4;
      this.a.Fv.add(paramMusicItemInfo1);
      if (this.dwk)
      {
        paramMusicItemInfo1 = new MusicItemInfo();
        paramMusicItemInfo1.mType = 8;
        paramMusicItemInfo1.mItemId = -6;
        this.a.Fv.add(paramMusicItemInfo1);
      }
    }
    this.a.Fv.add(localMusicItemInfo);
    if (this.eGM == 1)
    {
      this.a.Fv.add(paramMusicItemInfo3);
      paramMusicItemInfo3.jumpWs = this.cVQ;
    }
    int i = 0;
    while (i < this.Ni.size())
    {
      paramMusicItemInfo1 = (FlowMusic)this.Ni.get(i);
      paramMusicItemInfo2 = new MusicItemInfo();
      paramMusicItemInfo2.mType = 5;
      paramMusicItemInfo2.mMusicName = paramMusicItemInfo1.songName;
      paramMusicItemInfo2.setPath(paramMusicItemInfo1.path);
      paramMusicItemInfo2.mUrl = paramMusicItemInfo1.url;
      paramMusicItemInfo2.mSingername = paramMusicItemInfo1.singerName;
      paramMusicItemInfo2.mItemId = paramMusicItemInfo1.songId;
      paramMusicItemInfo2.mSongMid = paramMusicItemInfo1.songMid;
      paramMusicItemInfo2.musicStart = paramMusicItemInfo1.tryBegin;
      paramMusicItemInfo2.musicEnd = paramMusicItemInfo1.tryEnd;
      paramMusicItemInfo2.musicDuration = paramMusicItemInfo1.duration;
      paramMusicItemInfo2.mAlbumUrl = paramMusicItemInfo1.albumUrl;
      this.a.Fv.add(paramMusicItemInfo2);
      i += 1;
    }
    return this.a;
  }
  
  private FlowMusic a(int paramInt)
  {
    Object localObject;
    if (this.Ni == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findFlowMusicFromUserList mUserMusicList is null");
      }
      localObject = null;
      return localObject;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.Ni.size()) {
        break label75;
      }
      FlowMusic localFlowMusic = (FlowMusic)this.Ni.get(i);
      localObject = localFlowMusic;
      if (localFlowMusic.songId == paramInt) {
        break;
      }
      i += 1;
    }
    label75:
    return null;
  }
  
  private MusicItemInfo a(JSONObject paramJSONObject, boolean paramBoolean)
  {
    if (paramBoolean) {
      return new VsMusicItemInfo(paramJSONObject);
    }
    MusicItemInfo localMusicItemInfo = new MusicItemInfo();
    localMusicItemInfo.mType = 5;
    localMusicItemInfo.mMusicName = paramJSONObject.optString("title");
    localMusicItemInfo.mSingername = paramJSONObject.optString("desc");
    localMusicItemInfo.mItemId = paramJSONObject.optInt("id");
    localMusicItemInfo.mSongMid = paramJSONObject.optString("mid");
    return localMusicItemInfo;
  }
  
  private void a(axqd paramaxqd, MusicItemInfo paramMusicItemInfo)
  {
    if ((paramaxqd.cVe == 999) || (paramMusicItemInfo.mType != 5)) {}
    MusicItemInfo localMusicItemInfo;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = paramaxqd.Fv.iterator();
      }
      localMusicItemInfo = (MusicItemInfo)localIterator.next();
      if (localMusicItemInfo.mType == 5)
      {
        i = paramaxqd.Fv.indexOf(localMusicItemInfo);
        paramaxqd.Fv.remove(i);
        paramaxqd.Fv.add(i, paramMusicItemInfo);
        return;
      }
    } while (localMusicItemInfo.mType != 1);
    int i = paramaxqd.Fv.indexOf(localMusicItemInfo);
    paramaxqd.Fv.add(i, paramMusicItemInfo);
  }
  
  private void a(FlowMusic paramFlowMusic, long paramLong)
  {
    EntityTransaction localEntityTransaction = this.h.getTransaction();
    for (;;)
    {
      try
      {
        localEntityTransaction.begin();
        paramFlowMusic.storeTimeStamp = paramLong;
        localObject = this.Ni.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label298;
        }
        FlowMusic localFlowMusic = (FlowMusic)((Iterator)localObject).next();
        if (localFlowMusic.songId != paramFlowMusic.songId) {
          continue;
        }
        localObject = localFlowMusic;
        if (localFlowMusic != paramFlowMusic)
        {
          localFlowMusic.copyFrom(paramFlowMusic);
          localObject = localFlowMusic;
        }
        if (localObject != null)
        {
          this.h.update((Entity)localObject);
          return;
        }
        if (this.Ni.size() < 40)
        {
          this.Ni.add(0, paramFlowMusic);
          this.h.persistOrReplace(paramFlowMusic);
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("QIMMusicConfigManager", 2, "insert music=" + paramFlowMusic);
          continue;
        }
        i = this.Ni.size();
      }
      finally
      {
        Collections.sort(this.Ni);
        localEntityTransaction.commit();
        localEntityTransaction.end();
      }
      int i;
      Object localObject = (FlowMusic)this.Ni.remove(i - 1);
      this.h.delete(FlowMusic.class.getSimpleName(), "songName=? and tryBegin=? and tryEnd=?", new String[] { ((FlowMusic)localObject).songName, String.valueOf(((FlowMusic)localObject).tryBegin), String.valueOf(((FlowMusic)localObject).tryEnd) });
      this.Ni.add(0, paramFlowMusic);
      continue;
      label298:
      localObject = null;
    }
  }
  
  public static boolean aPB()
  {
    boolean bool = new File(bl + File.separator + "doodle_music_config.cfg").exists();
    if (QLog.isColorLevel()) {
      QLog.i("QIMMusicConfigManager", 2, "QIMMusicConfigManager isStickerConfigFileExist=" + bool);
    }
    return bool;
  }
  
  public static void adm(String paramString)
  {
    SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4).edit();
    localEditor.putLong("fecth_from_qq_music_time_" + paramString, System.currentTimeMillis());
    localEditor.commit();
  }
  
  public int Rt()
  {
    return this.eGN;
  }
  
  public void YT(boolean paramBoolean)
  {
    try
    {
      this.dwk = paramBoolean;
      eOn();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  public MusicItemInfo a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: invokevirtual 487	dov/com/qq/im/capture/music/QIMMusicConfigManager:eJ	()Ljava/util/ArrayList;
    //   6: astore_3
    //   7: aload_3
    //   8: ifnull +63 -> 71
    //   11: aload_3
    //   12: invokevirtual 488	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   15: astore_3
    //   16: aload_3
    //   17: invokeinterface 335 1 0
    //   22: ifeq +49 -> 71
    //   25: aload_3
    //   26: invokeinterface 339 1 0
    //   31: checkcast 173	axqd
    //   34: astore 4
    //   36: iload_1
    //   37: iconst_m1
    //   38: if_icmpne +14 -> 52
    //   41: aload 4
    //   43: iload_2
    //   44: invokevirtual 491	axqd:a	(I)Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   47: astore_3
    //   48: aload_0
    //   49: monitorexit
    //   50: aload_3
    //   51: areturn
    //   52: aload 4
    //   54: getfield 218	axqd:cVe	I
    //   57: iload_1
    //   58: if_icmpne -42 -> 16
    //   61: aload 4
    //   63: iload_2
    //   64: invokevirtual 491	axqd:a	(I)Lcom/tencent/mobileqq/richmedia/capture/data/MusicItemInfo;
    //   67: astore_3
    //   68: goto -20 -> 48
    //   71: aconst_null
    //   72: astore_3
    //   73: goto -25 -> 48
    //   76: astore_3
    //   77: aload_0
    //   78: monitorexit
    //   79: aload_3
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	QIMMusicConfigManager
    //   0	81	1	paramInt1	int
    //   0	81	2	paramInt2	int
    //   6	67	3	localObject1	Object
    //   76	4	3	localObject2	Object
    //   34	28	4	localaxqd	axqd
    // Exception table:
    //   from	to	target	type
    //   2	7	76	finally
    //   11	16	76	finally
    //   16	36	76	finally
    //   41	48	76	finally
    //   52	68	76	finally
  }
  
  public void a(MusicItemInfo paramMusicItemInfo, boolean paramBoolean)
  {
    label475:
    for (;;)
    {
      Object localObject1;
      int i;
      long l;
      synchronized (this.mLock)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, lock updateTimeStamp=" + paramBoolean);
        }
        if ((this.a == null) || (this.a.Fv == null)) {
          return;
        }
        localObject1 = this.a.Fv;
        i = a(paramMusicItemInfo);
        l = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, index=" + i);
        }
        if (i != -1) {
          break label369;
        }
        if (((List)localObject1).size() < this.eGJ + 40)
        {
          ((List)localObject1).add(this.eGJ, paramMusicItemInfo);
          localObject1 = new FlowMusic(paramMusicItemInfo);
          if (localObject1 != null)
          {
            ((FlowMusic)localObject1).tryBegin = paramMusicItemInfo.musicStart;
            ((FlowMusic)localObject1).tryEnd = paramMusicItemInfo.musicEnd;
            ((FlowMusic)localObject1).url = paramMusicItemInfo.mUrl;
            ((FlowMusic)localObject1).path = paramMusicItemInfo.getLocalPath();
            ((FlowMusic)localObject1).duration = paramMusicItemInfo.musicDuration;
            a((FlowMusic)localObject1, l);
          }
          if (this.Nj == null) {
            break label475;
          }
          localObject1 = this.Nj.iterator();
          if (!((Iterator)localObject1).hasNext()) {
            break label475;
          }
          ((a)((Iterator)localObject1).next()).bI(5, true, paramMusicItemInfo);
        }
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)((List)localObject1).remove(((List)localObject1).size() - 1);
      if (!TextUtils.isEmpty(localMusicItemInfo.getLocalPath()))
      {
        rox.delete(new File(localMusicItemInfo.getLocalPath()));
        if (QLog.isColorLevel()) {
          QLog.d("QIMMusicConfigManager", 2, "delete file=" + localMusicItemInfo.mMusicName);
        }
      }
      ((List)localObject1).add(this.eGJ, paramMusicItemInfo);
      continue;
      label369:
      if ((i != this.eGJ) && (paramBoolean))
      {
        ((List)localObject1).remove(i);
        ((List)localObject1).add(this.eGJ, paramMusicItemInfo);
        localObject1 = a(paramMusicItemInfo.mItemId);
        if (localObject1 != null) {
          ((FlowMusic)localObject1).sourceType = 0;
        }
      }
      else
      {
        ((List)localObject1).remove(i);
        ((List)localObject1).add(i, paramMusicItemInfo);
        localObject1 = a(paramMusicItemInfo.mItemId);
        if (localObject1 != null)
        {
          ((FlowMusic)localObject1).sourceType = 0;
          l = ((FlowMusic)localObject1).storeTimeStamp;
          continue;
          if (QLog.isColorLevel()) {
            QLog.d("QIMMusicConfigManager", 2, "addOrUpdateMytabMusic, unlock");
          }
        }
        else {}
      }
    }
  }
  
  public void a(a parama)
  {
    if ((parama == null) || (this.Nj == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener listener = null");
      }
    }
    do
    {
      return;
      if (!this.Nj.contains(parama)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("QIMMusicConfigManager", 2, "addLoadMusicListener mListeners has listener");
    return;
    this.Nj.add(parama);
  }
  
  public void a(String paramString, GetSingleFullMusicInfoTask.a parama)
  {
    a(paramString, false, parama);
  }
  
  public void a(String paramString, boolean paramBoolean, GetSingleFullMusicInfoTask.a parama)
  {
    if (paramBoolean)
    {
      QLog.i("QIMMusicConfigManager", 1, "getSingleFullMusicInfo instance is VsMusicItemInfo though videoStory cmd");
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramString);
      VSNetworkHelper.a().a(new BatchGetMusicInfoRequest(localArrayList), new axrl(this, parama));
      return;
    }
    ThreadManager.executeOnSubThread(new GetSingleFullMusicInfoTask(paramString, parama));
  }
  
  public boolean aPC()
  {
    if (!this.dwj)
    {
      this.dwj = true;
      SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication);
      if (!localSharedPreferences.contains("show_wstab")) {
        break label55;
      }
      this.eGL = localSharedPreferences.getInt("show_wstab", 0);
    }
    while (this.eGL == 1)
    {
      return true;
      label55:
      eJ();
    }
    return false;
  }
  
  public void adl(String paramString)
  {
    this.FW = aq(paramString);
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleDoodleMusicConfig").append(paramString).append(" result:");
      if (this.FW == null) {
        break label102;
      }
    }
    label102:
    for (boolean bool = true;; bool = false)
    {
      QLog.i("QIMMusicConfigManager", 2, bool);
      axwf.b(bl, "doodle_music_config.cfg", paramString);
      PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.sApplication).edit().putInt("show_wstab", this.eGL).commit();
      return;
    }
  }
  
  public ArrayList<axqd> aq(String paramString)
  {
    ArrayList localArrayList = new ArrayList(4);
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("showMine")) {
        this.eGK = paramString.getInt("showMine");
      }
      if (paramString.has("showWsTab")) {
        this.eGL = paramString.getInt("showWsTab");
      }
      if (paramString.has("showMusicWs")) {
        this.eGM = paramString.getInt("showMusicWs");
      }
      if (paramString.has("jumpWsTab")) {
        this.cVP = paramString.getString("jumpWsTab");
      }
      if (paramString.has("jumpWsMusic")) {
        this.cVQ = paramString.getString("jumpWsMusic");
      }
      if (paramString.has("mineIndex")) {
        this.eGN = paramString.getInt("mineIndex");
      }
      if (paramString.has("mineCategoryName")) {
        this.cVR = paramString.getString("mineCategoryName");
      }
      JSONArray localJSONArray = paramString.getJSONArray("category");
      localArrayList.ensureCapacity(localJSONArray.length());
      int i = 0;
      for (;;)
      {
        paramString = localArrayList;
        if (i >= localJSONArray.length()) {
          break;
        }
        localArrayList.add(new axqd(localJSONArray.getJSONObject(i)));
        i += 1;
      }
      return paramString;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QIMMusicConfigManager", 2, QLog.getStackTraceString(paramString));
      }
      paramString = null;
    }
  }
  
  public MusicItemInfo b(int paramInt)
  {
    Object localObject;
    if (this.a == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory is null");
      }
      localObject = null;
      return localObject;
    }
    if (this.a.Fv == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "findMusicInfoFromMyTab myTabCategory.templateGroups is null");
      }
      return null;
    }
    int i = 0;
    for (;;)
    {
      if (i >= this.a.Fv.size()) {
        break label106;
      }
      MusicItemInfo localMusicItemInfo = (MusicItemInfo)this.a.Fv.get(i);
      localObject = localMusicItemInfo;
      if (localMusicItemInfo.mItemId == paramInt) {
        break;
      }
      i += 1;
    }
    label106:
    return null;
  }
  
  public void b(a parama)
  {
    if (this.Nj.contains(parama)) {
      this.Nj.remove(parama);
    }
  }
  
  public void bH(int paramInt, boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean)
    {
      if (paramInt == 4)
      {
        this.Ni.addAll((Collection)paramObject);
        Collections.sort(this.Ni);
      }
      if (((paramObject instanceof String)) && (QLog.isColorLevel())) {
        QLog.d("QIMMusicConfigManager", 2, "onStepCall successed, step=" + paramInt + ", msg=" + paramObject);
      }
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new QIMMusicConfigManager.1(this, paramInt, paramBoolean, paramObject));
      return;
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "onStepCall failed, step=" + paramInt + ", msg=" + paramObject);
      }
    }
  }
  
  public MusicItemInfo c(int paramInt)
  {
    Object localObject1 = null;
    MusicItemInfo localMusicItemInfo = null;
    try
    {
      Object localObject3 = eJ();
      if (localObject3 != null)
      {
        localObject3 = ((ArrayList)localObject3).iterator();
        localObject1 = localMusicItemInfo;
        while (((Iterator)localObject3).hasNext())
        {
          localMusicItemInfo = ((axqd)((Iterator)localObject3).next()).a(paramInt);
          localObject1 = localMusicItemInfo;
          if (localMusicItemInfo != null) {
            localObject1 = localMusicItemInfo;
          }
        }
      }
      return localObject1;
    }
    finally {}
  }
  
  public ArrayList<axqd> c(boolean paramBoolean)
  {
    int j = 0;
    for (;;)
    {
      MusicItemInfo localMusicItemInfo2;
      MusicItemInfo localMusicItemInfo3;
      try
      {
        synchronized (this.mLock)
        {
          this.eN.set(true);
          if (this.FW == null)
          {
            localObject3 = axwf.d(bl, "doodle_music_config.cfg");
            if (localObject3 != null)
            {
              this.FW = aq((String)localObject3);
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("initStickerConfigFromCache, result:");
                if (this.FW == null) {
                  break label625;
                }
                bool = true;
                QLog.i("QIMMusicConfigManager", 2, bool);
              }
            }
            if ((this.FW == null) || (this.FW.isEmpty()))
            {
              this.FW = aq(axwf.py("doodle_music.cfg"));
              if (QLog.isColorLevel())
              {
                localObject3 = new StringBuilder().append("initStickerConfigFromAssets, result:");
                if (this.FW == null) {
                  break label631;
                }
                bool = true;
                QLog.i("QIMMusicConfigManager", 2, bool);
              }
            }
          }
          if ((this.a == null) || (this.a.Fv.size() == this.Ni.size() + this.eGJ)) {
            break label727;
          }
          i = 1;
          if ((this.FX != null) && (!paramBoolean) && (i == 0)) {
            break label705;
          }
          if (this.FW != null) {
            break label637;
          }
          i = j;
          this.FX = new ArrayList(i);
          Object localObject3 = new MusicItemInfo();
          ((MusicItemInfo)localObject3).mType = 2;
          ((MusicItemInfo)localObject3).mItemId = -1;
          localMusicItemInfo2 = new MusicItemInfo();
          localMusicItemInfo2.mType = 3;
          localMusicItemInfo2.mItemId = -2;
          localMusicItemInfo3 = new MusicItemInfo();
          localMusicItemInfo3.mType = 10;
          localMusicItemInfo3.mItemId = -7;
          MusicItemInfo localMusicItemInfo4 = new MusicItemInfo();
          localMusicItemInfo4.mType = 6;
          localMusicItemInfo4.mItemId = -4;
          MusicItemInfo localMusicItemInfo5 = new MusicItemInfo();
          localMusicItemInfo5.mType = 8;
          localMusicItemInfo5.mItemId = -6;
          if (this.FW == null) {
            break label648;
          }
          Iterator localIterator = this.FW.iterator();
          if (!localIterator.hasNext()) {
            break label648;
          }
          axqd localaxqd1 = (axqd)localIterator.next();
          if ((localaxqd1.Fv == null) || (localaxqd1.Fv.size() <= 0)) {
            continue;
          }
          axqd localaxqd2 = localaxqd1.a();
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(localObject3);
          localArrayList.add(localMusicItemInfo2);
          this.eGJ = 3;
          if (axsf.ON)
          {
            localArrayList.add(localMusicItemInfo4);
            this.eGJ = 4;
            if (this.dwk)
            {
              localArrayList.add(localMusicItemInfo5);
              this.eGJ = 5;
            }
          }
          if ((this.b != null) && (this.b.Fv != null) && (this.b.cVe == localaxqd1.cVe) && (this.c != null)) {
            a(localaxqd1, this.c);
          }
          if ((paramBoolean) && (localaxqd1.dvY)) {
            Collections.shuffle(localaxqd1.Fv);
          }
          localArrayList.addAll(localaxqd1.Fv);
          localaxqd2.Fv = localArrayList;
          this.FX.add(localaxqd2);
        }
        bool = false;
      }
      finally {}
      label625:
      continue;
      label631:
      boolean bool = false;
      continue;
      label637:
      int i = this.FW.size();
      continue;
      label648:
      if ((this.eGK == 1) && (this.eGN >= 1) && (this.eGN <= this.FX.size()))
      {
        localObject4 = a(localMusicItemInfo1, localMusicItemInfo2, localMusicItemInfo3);
        this.FX.add(this.eGN - 1, localObject4);
      }
      label705:
      this.eN.set(false);
      Object localObject4 = this.FX;
      return localObject4;
      label727:
      i = 0;
    }
  }
  
  public void eIC()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null)
    {
      IntentFilter localIntentFilter = new IntentFilter("com.tencent.mobileqq.action.ACTION_WEBVIEW_DISPATCH_EVENT");
      localAppInterface.getApp().registerReceiver(this.ao, localIntentFilter);
      eJ();
      a().notifyObservers(axrf.class, 1, true, null);
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("QIMMusicConfigManager", 4, "initMusicConfig");
    }
  }
  
  /* Error */
  public ArrayList<axqd> eJ()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 111	dov/com/qq/im/capture/music/QIMMusicConfigManager:eN	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   6: iconst_1
    //   7: iconst_1
    //   8: invokevirtual 763	java/util/concurrent/atomic/AtomicBoolean:compareAndSet	(ZZ)Z
    //   11: istore_1
    //   12: iload_1
    //   13: ifeq +9 -> 22
    //   16: aconst_null
    //   17: astore_2
    //   18: aload_0
    //   19: monitorexit
    //   20: aload_2
    //   21: areturn
    //   22: aload_0
    //   23: iconst_0
    //   24: invokevirtual 765	dov/com/qq/im/capture/music/QIMMusicConfigManager:c	(Z)Ljava/util/ArrayList;
    //   27: astore_2
    //   28: goto -10 -> 18
    //   31: astore_2
    //   32: aload_0
    //   33: monitorexit
    //   34: aload_2
    //   35: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	36	0	this	QIMMusicConfigManager
    //   11	2	1	bool	boolean
    //   17	11	2	localObject1	Object
    //   31	4	2	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	31	finally
    //   22	28	31	finally
  }
  
  public void eOn()
  {
    try
    {
      this.FX = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void eOo()
  {
    this.Ni.clear();
    PeakAppInterface.a.aeC(1009);
    String str = a().getCurrentAccountUin();
    long l = BaseApplicationImpl.getContext().getSharedPreferences("fecth_qq_music", 4).getLong("fecth_from_qq_music_time_" + str, 0L);
    if ((System.currentTimeMillis() - l > 86400000L) && (aqiw.isWifiEnabled(BaseApplicationImpl.sApplication))) {}
    for (int i = 1;; i = 0)
    {
      if ((l == 0L) || (i != 0))
      {
        str = a().getCurrentAccountUin();
        if (str != null)
        {
          this.aPq = str;
          new GetQQMusicSongListTask(this).dCy();
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "checkMyFavoriteUpgradeInQQMusic, lastFetchTime = " + l);
      }
      return;
    }
  }
  
  public void onDestroy()
  {
    AppInterface localAppInterface = a();
    if (localAppInterface != null) {
      localAppInterface.getApp().unregisterReceiver(this.ao);
    }
  }
  
  final class GetQQMusicSongListTask
    extends QIMMusicConfigManager.LoadMusicStepTask
  {
    GetQQMusicSongListTask(QIMMusicConfigManager paramQIMMusicConfigManager)
    {
      super();
    }
    
    QIMMusicConfigManager.GetSongListStepTask a()
    {
      return new QIMMusicConfigManager.GetSongListStepTask(QIMMusicConfigManager.this, this.a);
    }
    
    public void onResp(aomh paramaomh)
    {
      if (paramaomh.dPy == 200)
      {
        if (paramaomh.mRespData != null)
        {
          QIMMusicConfigManager.GetSongListStepTask localGetSongListStepTask = a();
          localGetSongListStepTask.json = new String(paramaomh.mRespData);
          localGetSongListStepTask.dCy();
          this.a.bH(0, true, localGetSongListStepTask.json);
          return;
        }
        QIMMusicConfigManager.a(QIMMusicConfigManager.this, false);
        this.a.bH(0, false, "Have no data.");
        return;
      }
      QIMMusicConfigManager.a(QIMMusicConfigManager.this, false);
      this.a.bH(0, false, "Http Request fail, code=" + paramaomh.dPy);
    }
    
    public void run()
    {
      aoll localaoll = new aoll();
      localaoll.mHttpMethod = 0;
      localaoll.dPo = 1;
      localaoll.f = this;
      long l = System.currentTimeMillis() / 1000L;
      String str = ((TicketManagerImpl)this.mApp.getManager(2)).getSkey(this.aPq);
      HashMap localHashMap = new HashMap();
      localHashMap.put("app_id", "2000000025");
      localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
      localHashMap.put("device_id", aqgz.getIMEI());
      localHashMap.put("timestamp", String.valueOf(l));
      localHashMap.put("sign", cw(l));
      localHashMap.putAll(b(this.aPq, str));
      localaoll.bZ = f("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_self.fcg", localHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "QQMusicReq SongList api request, req url=" + localaoll.bZ);
      }
      this.e.a(localaoll);
    }
  }
  
  final class GetSongListStepTask
    extends QIMMusicConfigManager.LoadMusicStepTask
  {
    String json;
    
    GetSongListStepTask(QIMMusicConfigManager paramQIMMusicConfigManager)
    {
      super();
    }
    
    public void onResp(aomh paramaomh)
    {
      if (paramaomh.dPy == 200)
      {
        if (paramaomh.mRespData != null)
        {
          paramaomh = new String(paramaomh.mRespData);
          PeakAppInterface.a.y(String.valueOf(1008), new Object[] { paramaomh });
          return;
        }
        QIMMusicConfigManager.a(QIMMusicConfigManager.this, false);
        this.a.bH(1, false, "have no data.");
        return;
      }
      QIMMusicConfigManager.a(QIMMusicConfigManager.this, false);
      this.a.bH(1, false, "Http Request fail, code=" + paramaomh.dPy);
    }
    
    public void run()
    {
      for (;;)
      {
        int i;
        try
        {
          Object localObject1 = new JSONObject(this.json);
          if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
            break label389;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("data");
          if (localObject1 == null) {
            break label389;
          }
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            Object localObject2 = ((JSONArray)localObject1).optJSONObject(i);
            if ((localObject2 == null) || (!"我喜欢".equals(((JSONObject)localObject2).optString("diss_name")))) {
              break label390;
            }
            l1 = ((JSONObject)localObject2).optLong("diss_id", -1L);
            if (l1 != -1L)
            {
              localObject1 = new aoll();
              ((aoll)localObject1).mHttpMethod = 0;
              ((aoll)localObject1).dPo = 1;
              ((aoll)localObject1).f = this;
              long l2 = System.currentTimeMillis() / 1000L;
              localObject2 = ((TicketManagerImpl)this.mApp.getManager(2)).getSkey(this.aPq);
              HashMap localHashMap = new HashMap();
              localHashMap.put("app_id", "2000000025");
              localHashMap.put("app_key", "SApgehUTVGxZKBQZTt");
              localHashMap.put("device_id", aqgz.getIMEI());
              localHashMap.put("timestamp", String.valueOf(l2));
              localHashMap.put("sign", cw(l2));
              localHashMap.put("dissid", String.valueOf(l1));
              localHashMap.putAll(b(this.aPq, (String)localObject2));
              ((aoll)localObject1).bZ = f("https://open.music.qq.com/fcgi-bin/fcg_music_custom_get_songlist_detail.fcg", localHashMap);
              this.e.a((aomg)localObject1);
              if (!QLog.isColorLevel()) {
                break label389;
              }
              QLog.d("QIMMusicConfigManager", 2, "QQMusicReq GetSongListStepTask req url=" + ((aoll)localObject1).bZ);
              return;
            }
            QIMMusicConfigManager.a(QIMMusicConfigManager.this, true);
            this.a.bH(1, false, "can not find myFav diss.");
            return;
          }
        }
        catch (JSONException localJSONException)
        {
          QIMMusicConfigManager.a(QIMMusicConfigManager.this, false);
          this.a.bH(1, false, "parsed json error, json=" + this.json);
          return;
        }
        long l1 = -1L;
        continue;
        label389:
        return;
        label390:
        i += 1;
      }
    }
  }
  
  static abstract class LoadMusicStepTask
    implements aolm.b, Runnable
  {
    final QIMMusicConfigManager a;
    final String aPq;
    final aolm e;
    final AppInterface mApp;
    final String mUin;
    
    LoadMusicStepTask(QIMMusicConfigManager paramQIMMusicConfigManager)
    {
      this.a = paramQIMMusicConfigManager;
      this.mApp = paramQIMMusicConfigManager.a();
      this.mUin = this.mApp.getCurrentAccountUin();
      this.aPq = paramQIMMusicConfigManager.aPq;
      this.e = paramQIMMusicConfigManager.e;
    }
    
    Map<String, String> b(String paramString1, String paramString2)
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("login_type", String.valueOf(1));
      localHashMap.put("uin", paramString1);
      localHashMap.put("ticket_type", "skey");
      localHashMap.put("auth", paramString2);
      return localHashMap;
    }
    
    String cw(long paramLong)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OpitrtqeGzopIlwxs").append("_").append("2000000025").append("_").append("SApgehUTVGxZKBQZTt").append("_").append("QmnkKmaTHNDozKdIUA").append("_").append(paramLong);
      localObject = ((StringBuilder)localObject).toString();
      String str = atad.toMD5((String)localObject).toLowerCase();
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "generate the sign string, pre=" + (String)localObject + ", md5=" + str);
      }
      return str;
    }
    
    void dCy()
    {
      ThreadManager.executeOnSubThread(this);
    }
    
    String f(String paramString, Map<String, String> paramMap)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      if (!paramMap.isEmpty())
      {
        paramString = paramMap.entrySet().iterator();
        int i = 1;
        if (paramString.hasNext())
        {
          paramMap = (Map.Entry)paramString.next();
          if (i != 0)
          {
            localStringBuilder.append("?");
            i = 0;
          }
          for (;;)
          {
            localStringBuilder.append((String)paramMap.getKey()).append("=").append((String)paramMap.getValue());
            break;
            localStringBuilder.append("&");
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMMusicConfigManager", 2, "genQQMusicReqUrl url" + localStringBuilder.toString());
      }
      return localStringBuilder.toString();
    }
    
    public void onResp(aomh paramaomh) {}
    
    public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
  }
  
  public static abstract interface a
  {
    public abstract void bI(int paramInt, boolean paramBoolean, Object paramObject);
    
    public abstract void f(MusicItemInfo paramMusicItemInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.music.QIMMusicConfigManager
 * JD-Core Version:    0.7.0.1
 */