package dov.com.qq.im.capture.control;

import android.text.TextUtils;
import axol;
import axov;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.ParallGroup;
import com.tencent.mobileqq.data.FlowMusic;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.QIMMusicConfigManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class GetAllFullMusicInfoTask
  extends ParallGroup
{
  private List<FlowMusic> Nc;
  private List<FlowMusic> Nd = new ArrayList();
  private List<FlowMusic> Ne = new ArrayList();
  private QIMMusicConfigManager a;
  private String mData;
  
  public GetAllFullMusicInfoTask()
  {
    this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager = ((QIMMusicConfigManager)axov.a(2));
  }
  
  private void dcD()
  {
    int k = 0;
    this.mData = ((String)this.mParams[0]);
    Object localObject1 = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.h.query(FlowMusic.class);
    if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
      this.Nc = new ArrayList((Collection)localObject1);
    }
    Object localObject2;
    for (int i = this.Nc.size(); QLog.isColorLevel(); i = 0)
    {
      QLog.d("GetAllFullMusicInfoTask", 2, "load db, has load local, size=" + i);
      if (this.Nc == null) {
        break;
      }
      localObject1 = this.Nc.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (FlowMusic)((Iterator)localObject1).next();
        QLog.d("GetAllFullMusicInfoTask", 2, "load db, local music=" + localObject2);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = new JSONObject(this.mData);
        if (((JSONObject)localObject1).optInt("ret", -1) != 0) {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).optJSONArray("song_list");
        if ((localObject1 == null) || (((JSONArray)localObject1).length() <= 0)) {
          continue;
        }
        localObject2 = new HashSet();
        if (this.Nc == null) {
          break label568;
        }
        i = this.Nc.size();
      }
      catch (JSONException localJSONException)
      {
        int j;
        long l;
        label271:
        JSONObject localJSONObject;
        FlowMusic localFlowMusic;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("GetAllFullMusicInfoTask", 2, "can not parse json, json = " + this.mData, localJSONException);
        return;
      }
      j = i;
      if (((JSONArray)localObject1).length() < i) {
        j = ((JSONArray)localObject1).length();
      }
      l = System.currentTimeMillis();
      i = k;
      if (i < j)
      {
        localJSONObject = ((JSONArray)localObject1).optJSONObject(i);
        if (localJSONObject != null)
        {
          localFlowMusic = new FlowMusic();
          localFlowMusic.albumId = localJSONObject.optInt("album_id");
          localFlowMusic.albumMid = localJSONObject.optString("album_mid");
          localFlowMusic.albumName = localJSONObject.optString("album_name");
          localFlowMusic.singerId = localJSONObject.optInt("singer_id");
          localFlowMusic.singerMid = localJSONObject.optString("singer_mid");
          localFlowMusic.singerName = localJSONObject.optString("singer_name");
          localFlowMusic.songId = localJSONObject.optInt("song_id");
          localFlowMusic.songMid = localJSONObject.optString("song_mid");
          localFlowMusic.songName = localJSONObject.optString("song_name");
          localFlowMusic.songPlayTime = localJSONObject.optInt("song_play_time");
          localFlowMusic.userOwnRule = localJSONObject.optInt("user_own_rule");
          localFlowMusic.sourceType = 1;
          localFlowMusic.storeTimeStamp = (j + l - i);
          if ((!TextUtils.isEmpty(localFlowMusic.songMid)) && ((this.Nc == null) || (!this.Nc.contains(localFlowMusic)))) {
            ((Set)localObject2).add(localFlowMusic);
          }
        }
      }
      else
      {
        this.Ne.addAll((Collection)localObject2);
        return;
      }
      for (;;)
      {
        if (40 - i <= 20) {
          break label573;
        }
        i = 20;
        break;
        i += 1;
        break label271;
        label568:
        i = 0;
      }
      label573:
      i = 40 - i;
    }
  }
  
  private void eNG()
  {
    if (!this.Nd.isEmpty())
    {
      localObject1 = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.h.getTransaction();
      try
      {
        ((EntityTransaction)localObject1).begin();
        Iterator localIterator = this.Nd.iterator();
        while (localIterator.hasNext())
        {
          FlowMusic localFlowMusic = (FlowMusic)localIterator.next();
          this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.h.persistOrReplace(localFlowMusic);
        }
      }
      finally
      {
        ((EntityTransaction)localObject1).end();
      }
      ((EntityTransaction)localObject1).end();
      this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager.bH(4, true, this.Nd);
    }
    Object localObject1 = this.jdField_a_of_type_DovComQqImCaptureMusicQIMMusicConfigManager;
    QIMMusicConfigManager.adm(axol.getAppInterface().getCurrentAccountUin());
  }
  
  /* Error */
  public void a(AsyncStep paramAsyncStep, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: instanceof 288
    //   6: ifeq +34 -> 40
    //   9: aload_1
    //   10: checkcast 288	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   13: getfield 292	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:b	Lcom/tencent/mobileqq/data/FlowMusic;
    //   16: astore_3
    //   17: aload_3
    //   18: ifnonnull +67 -> 85
    //   21: aload_1
    //   22: checkcast 288	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   25: getfield 294	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:a	Lcom/tencent/mobileqq/data/FlowMusic;
    //   28: astore_1
    //   29: aload_0
    //   30: getfield 22	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:Nd	Ljava/util/List;
    //   33: aload_1
    //   34: invokeinterface 295 2 0
    //   39: pop
    //   40: aload_0
    //   41: getfield 298	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:cyC	I
    //   44: iconst_1
    //   45: isub
    //   46: istore_2
    //   47: aload_0
    //   48: iload_2
    //   49: putfield 298	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:cyC	I
    //   52: iload_2
    //   53: ifne +18 -> 71
    //   56: aload_0
    //   57: invokespecial 300	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:eNG	()V
    //   60: aload_0
    //   61: bipush 7
    //   63: invokevirtual 304	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:setResult	(I)V
    //   66: aload_0
    //   67: aconst_null
    //   68: putfield 307	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep	[Lcom/tencent/mobileqq/app/automator/AsyncStep;
    //   71: aload_0
    //   72: getfield 310	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator	Lcom/tencent/mobileqq/app/automator/Automator;
    //   75: aload_0
    //   76: getfield 307	dov/com/qq/im/capture/control/GetAllFullMusicInfoTask:jdField_a_of_type_ArrayOfComTencentMobileqqAppAutomatorAsyncStep	[Lcom/tencent/mobileqq/app/automator/AsyncStep;
    //   79: invokevirtual 315	com/tencent/mobileqq/app/automator/Automator:a	([Lcom/tencent/mobileqq/app/automator/AsyncStep;)V
    //   82: aload_0
    //   83: monitorexit
    //   84: return
    //   85: aload_3
    //   86: getfield 201	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   89: invokestatic 228	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   92: ifeq +17 -> 109
    //   95: aload_3
    //   96: aload_1
    //   97: checkcast 288	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   100: getfield 294	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:a	Lcom/tencent/mobileqq/data/FlowMusic;
    //   103: getfield 201	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   106: putfield 201	com/tencent/mobileqq/data/FlowMusic:songMid	Ljava/lang/String;
    //   109: aload_3
    //   110: aload_1
    //   111: checkcast 288	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask
    //   114: getfield 294	dov/com/qq/im/capture/control/GetSingleFullMusicInfoTask:a	Lcom/tencent/mobileqq/data/FlowMusic;
    //   117: getfield 223	com/tencent/mobileqq/data/FlowMusic:storeTimeStamp	J
    //   120: putfield 223	com/tencent/mobileqq/data/FlowMusic:storeTimeStamp	J
    //   123: aload_3
    //   124: iconst_1
    //   125: putfield 219	com/tencent/mobileqq/data/FlowMusic:sourceType	I
    //   128: aload_3
    //   129: astore_1
    //   130: goto -101 -> 29
    //   133: astore_1
    //   134: aload_0
    //   135: monitorexit
    //   136: aload_1
    //   137: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	GetAllFullMusicInfoTask
    //   0	138	1	paramAsyncStep	AsyncStep
    //   0	138	2	paramInt	int
    //   16	113	3	localFlowMusic	FlowMusic
    // Exception table:
    //   from	to	target	type
    //   2	17	133	finally
    //   21	29	133	finally
    //   29	40	133	finally
    //   40	52	133	finally
    //   56	71	133	finally
    //   71	82	133	finally
    //   85	109	133	finally
    //   109	128	133	finally
  }
  
  public int od()
  {
    this.cyC = this.Ne.size();
    if (!this.Ne.isEmpty())
    {
      Iterator localIterator = this.Ne.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          localObject = (FlowMusic)localIterator.next();
          if (this.mResult != 8) {}
        }
        else
        {
          return 2;
        }
        Object localObject = new GetSingleFullMusicInfoTask((FlowMusic)localObject, null);
        ((AsyncStep)localObject).a = this;
        this.jdField_a_of_type_ComTencentMobileqqAppAutomatorAutomator.b((AsyncStep)localObject);
      }
    }
    eNG();
    return 7;
  }
  
  public void onCreate()
  {
    dcD();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.control.GetAllFullMusicInfoTask
 * JD-Core Version:    0.7.0.1
 */