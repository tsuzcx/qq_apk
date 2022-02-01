import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.voicechange.QQVoiceChangerThread;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.manager.Manager;
import org.json.JSONArray;
import org.json.JSONObject;

public class aqxp
  implements Manager
{
  public static String cyB;
  public static String[] ig = { null, null, null };
  public static HashMap<String, aqxt> pt = new HashMap();
  ArrayList<String> gk = new ArrayList();
  QQAppInterface mApp;
  aquy x = new aqxq(this);
  
  public aqxp(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  public static String CD()
  {
    if (cyB == null)
    {
      localObject = BaseApplication.getContext().getExternalFilesDir(null);
      if (localObject == null) {
        break label83;
      }
    }
    label83:
    for (Object localObject = ((File)localObject).getParent();; localObject = BaseApplication.getContext().getFilesDir().getAbsolutePath())
    {
      cyB = (String)localObject + File.separator + "Tencent" + File.separator + "MobileQQ" + File.separator + "voiceChange" + File.separator;
      return cyB;
    }
  }
  
  /* Error */
  public static void a(int paramInt1, String paramString1, String paramString2, int paramInt2, int paramInt3)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: iload_0
    //   4: i2d
    //   5: dstore 5
    //   7: dload 5
    //   9: invokestatic 103	com/tencent/mobileqq/utils/QQRecorder:d	(D)I
    //   12: istore_0
    //   13: getstatic 29	aqxp:pt	Ljava/util/HashMap;
    //   16: aload_1
    //   17: invokevirtual 107	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   20: checkcast 109	aqxt
    //   23: astore 7
    //   25: aload 7
    //   27: ifnull +88 -> 115
    //   30: aload 7
    //   32: getfield 112	aqxt:jdField_a_of_type_Aqxt$a	Laqxt$a;
    //   35: ifnull +84 -> 119
    //   38: aload_1
    //   39: aload_2
    //   40: iload_3
    //   41: invokestatic 118	aqxu:ac	(Ljava/lang/String;Ljava/lang/String;I)V
    //   44: aload 7
    //   46: getfield 112	aqxt:jdField_a_of_type_Aqxt$a	Laqxt$a;
    //   49: aload_1
    //   50: iload 4
    //   52: iload_0
    //   53: invokeinterface 124 4 0
    //   58: invokestatic 130	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   61: ifeq +46 -> 107
    //   64: ldc 132
    //   66: iconst_2
    //   67: new 71	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   74: ldc 134
    //   76: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: aload_1
    //   80: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: ldc 136
    //   85: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: iload_0
    //   89: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   92: ldc 141
    //   94: invokevirtual 76	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   97: iload_3
    //   98: invokevirtual 139	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   101: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   104: invokestatic 144	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   107: getstatic 29	aqxp:pt	Ljava/util/HashMap;
    //   110: aload_1
    //   111: invokevirtual 147	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   114: pop
    //   115: ldc 2
    //   117: monitorexit
    //   118: return
    //   119: aload 7
    //   121: iconst_1
    //   122: putfield 151	aqxt:finished	Z
    //   125: aload 7
    //   127: iload_0
    //   128: putfield 155	aqxt:totalTime	I
    //   131: goto -16 -> 115
    //   134: astore_1
    //   135: ldc 2
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	140	0	paramInt1	int
    //   0	140	1	paramString1	String
    //   0	140	2	paramString2	String
    //   0	140	3	paramInt2	int
    //   0	140	4	paramInt3	int
    //   5	3	5	d	double
    //   23	103	7	localaqxt	aqxt
    // Exception table:
    //   from	to	target	type
    //   7	25	134	finally
    //   30	107	134	finally
    //   107	115	134	finally
    //   119	131	134	finally
  }
  
  public static void a(Context paramContext, aqxn paramaqxn, String paramString, aqxm paramaqxm)
  {
    if ((aqxt)pt.get(paramaqxn.aHD) == null) {
      b(paramContext, paramaqxn, paramString, paramaqxm);
    }
    ((aqxt)pt.get(paramaqxn.aHD)).jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.egh();
  }
  
  public static void a(Context paramContext, aqxn paramaqxn, String paramString, aqxm paramaqxm, aqxr paramaqxr)
  {
    aqxt localaqxt = (aqxt)pt.get(paramaqxn.aHD);
    if (localaqxt != null) {
      localaqxt.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.isRunning = false;
    }
    localaqxt = new aqxt();
    localaqxt.b = paramaqxn;
    localaqxt.jdField_a_of_type_Aqxr = paramaqxr;
    localaqxt.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread = new QQVoiceChangerThread(paramContext, paramaqxn, paramaqxr, paramString, paramaqxm);
    pt.put(paramaqxn.aHD, localaqxt);
    localaqxt.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.start();
  }
  
  public static void a(aqxn paramaqxn)
  {
    aqxt localaqxt = (aqxt)pt.get(paramaqxn.aHD);
    if (localaqxt != null)
    {
      localaqxt.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.egi();
      pt.remove(paramaqxn.aHD);
    }
  }
  
  public static boolean a(String paramString, aqxt.a parama)
  {
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("VoiceChangeManager", 2, "queryStateByPath called path=" + paramString);
        }
        aqxt localaqxt = (aqxt)pt.get(paramString);
        if (localaqxt == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "no task path=" + paramString);
          }
          bool = false;
          return bool;
        }
        if (localaqxt.finished)
        {
          aqxu.ac(paramString, localaqxt.b.aHD, localaqxt.b.changeType);
          pt.remove(paramString);
          parama.aI(paramString, localaqxt.b.voiceType, localaqxt.totalTime);
          if (QLog.isColorLevel()) {
            QLog.d("VoiceChangeManager", 2, "queryStateByPath onCompressFinished filePath=" + paramString + " time=" + localaqxt.totalTime + " voiceType=" + localaqxt.b.voiceType);
          }
        }
        else
        {
          localaqxt.jdField_a_of_type_Aqxt$a = parama;
        }
      }
      finally {}
      boolean bool = true;
    }
  }
  
  public static void b(Context paramContext, aqxn paramaqxn, String paramString, aqxm paramaqxm)
  {
    a(paramContext, paramaqxn, paramString, paramaqxm, aqxr.a());
  }
  
  public static void b(aqxn paramaqxn)
  {
    aqxt localaqxt = (aqxt)pt.get(paramaqxn.aHD);
    if (localaqxt != null)
    {
      localaqxt.jdField_a_of_type_ComTencentMobileqqVoicechangeQQVoiceChangerThread.isRunning = false;
      pt.remove(paramaqxn.aHD);
    }
  }
  
  public boolean a(ArrayList<aqxo> paramArrayList, JSONObject paramJSONObject)
  {
    Object localObject1 = new File(CD());
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceChangeManager", 2, "preCheckData start");
    }
    localObject1 = paramJSONObject;
    if (paramJSONObject == null) {
      localObject1 = VasQuickUpdateManager.getJSONFromLocal(this.mApp, "changeVoice_json", false, null);
    }
    int[] arrayOfInt = ListenChangeVoicePanel.hm;
    if (localObject1 == null)
    {
      QLog.e("VoiceChangeManager", 1, "preCheckData null == xydata");
      return false;
    }
    long l1;
    int k;
    Object localObject3;
    label237:
    Object localObject2;
    try
    {
      l1 = ((JSONObject)localObject1).optLong("timestamp", 0L);
      long l2 = System.currentTimeMillis() / 1000L;
      JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("VoiceChangeModels");
      k = 0;
      if (k >= localJSONArray.length()) {
        break label1027;
      }
      localObject3 = localJSONArray.getJSONObject(k);
      if ((localObject3 == null) || (((JSONObject)localObject3).getJSONArray("baseInfo") == null) || (((JSONObject)localObject3).getJSONArray("baseInfo").getJSONObject(0) == null) || (((JSONObject)localObject3).getJSONArray("operationInfo") == null))
      {
        QLog.e("VoiceChangeManager", 1, "preCheckData JsonErr:i=" + k + ", timestamp:" + l1);
        break label1261;
      }
      localObject4 = ((JSONObject)localObject3).getJSONArray("operationInfo");
      paramJSONObject = null;
      i = 0;
      if (i < ((JSONArray)localObject4).length())
      {
        localObject2 = ((JSONObject)localObject3).getJSONArray("operationInfo").getJSONObject(i);
        if ((localObject2 == null) || (!((JSONObject)localObject2).has("platformId"))) {
          break label1279;
        }
        j = ((JSONObject)localObject2).getInt("platformId");
        label286:
        paramJSONObject = (JSONObject)localObject2;
        if (j == 0) {
          break label1272;
        }
        paramJSONObject = (JSONObject)localObject2;
        if (j == 2) {
          break label1272;
        }
        if (!QLog.isColorLevel()) {
          break label1270;
        }
        QLog.d("VoiceChangeManager", 2, "preCheckData continue platformId=" + j + ", i=" + k + ", timestamp:" + l1 + ", o=" + i);
        break label1270;
      }
      if (paramJSONObject != null) {
        break label1255;
      }
      localObject2 = new JSONObject();
      if (!QLog.isColorLevel()) {
        break label1285;
      }
      QLog.d("VoiceChangeManager", 2, "preCheckData continue null == itemJsonOpera, i=" + k + ", timestamp:" + l1);
    }
    catch (Exception paramArrayList)
    {
      label431:
      QLog.e("VoiceChangeManager", 1, "preCheckData jsonEx:" + paramArrayList.getMessage());
    }
    Object localObject4 = ((JSONObject)localObject3).getJSONArray("baseInfo").getJSONObject(0);
    int j = ((JSONObject)localObject4).getInt("voiceID");
    int i = 6;
    for (;;)
    {
      if (i < arrayOfInt.length)
      {
        if (arrayOfInt[i] == j)
        {
          label474:
          if (i < 0)
          {
            if (!QLog.isColorLevel()) {
              break label1261;
            }
            QLog.d("VoiceChangeManager", 2, "preCheckData not in VOICE_TYPES[] out:i=" + k + ", timestamp:" + l1);
            break label1261;
            this.x.onDone(null);
            return true;
          }
        }
        else
        {
          label555:
          i += 1;
          continue;
        }
        if (paramArrayList == null) {
          break label1288;
        }
        paramJSONObject = (aqxo)paramArrayList.get(i);
        label585:
        if (paramJSONObject == null)
        {
          if (!QLog.isColorLevel()) {
            break label1261;
          }
          QLog.d("VoiceChangeManager", 2, "preCheckData null == voiceChangeData out:i=" + k + ", timestamp:" + l1);
          break label1261;
        }
        if (!((JSONObject)localObject2).has("isShow")) {
          break label1293;
        }
        j = ((JSONObject)localObject2).getInt("isShow");
        label657:
        i = j;
        if (j != 0)
        {
          i = j;
          if (((JSONObject)localObject2).has("QQVersion"))
          {
            i = j;
            if (aqqi.bV(((JSONObject)localObject2).getString("QQVersion"), "3.4.4"))
            {
              j = 0;
              i = j;
              if (QLog.isColorLevel())
              {
                QLog.d("VoiceChangeManager", 2, "preCheckData Version out:i=" + k + ", timestamp:" + l1);
                i = j;
              }
            }
          }
        }
        if (i == 0)
        {
          paramJSONObject.status = i;
          break label1261;
        }
        if (!((JSONObject)localObject2).has("isEnable")) {
          break label1304;
        }
        if (((JSONObject)localObject2).getInt("isEnable") != 1) {
          break label1299;
        }
        i = 2;
        label789:
        localObject3 = ((JSONObject)localObject4).getString("icon");
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          QLog.e("VoiceChangeManager", 1, "preCheckData url Error null:");
          label816:
          paramJSONObject.status = i;
          if (1 != i) {
            break label948;
          }
          paramJSONObject.feeType = 1;
          paramJSONObject.edy = 0;
          if (!TextUtils.isEmpty(((JSONObject)localObject4).getString("name"))) {
            break label1001;
          }
          localObject2 = paramJSONObject.name;
          label856:
          paramJSONObject.name = ((String)localObject2);
          if (!TextUtils.isEmpty(((JSONObject)localObject4).getString("description"))) {
            break label1014;
          }
        }
        label948:
        label968:
        label993:
        label1001:
        label1014:
        for (localObject2 = paramJSONObject.contentDescription;; localObject2 = ((JSONObject)localObject4).getString("description"))
        {
          paramJSONObject.contentDescription = ((String)localObject2);
          paramJSONObject.a.cyz = ((String)localObject3);
          break label1261;
          localObject3 = aqpi.cuH + (String)localObject3;
          if (this.gk.contains(localObject3)) {
            break label1307;
          }
          this.gk.add(localObject3);
          break label1307;
          if (!((JSONObject)localObject2).has("feeType")) {
            break label1310;
          }
          i = ((JSONObject)localObject2).getInt("feeType");
          paramJSONObject.feeType = i;
          if (!((JSONObject)localObject2).has("tag")) {
            break label1315;
          }
          i = ((JSONObject)localObject2).getInt("tag");
          paramJSONObject.edy = i;
          break;
          localObject2 = ((JSONObject)localObject4).getString("name");
          break label856;
        }
        label1027:
        if ((TextUtils.isEmpty(ig[0])) || (TextUtils.isEmpty(ig[1])) || (TextUtils.isEmpty(ig[2])))
        {
          paramArrayList = ((JSONObject)localObject1).getJSONArray("commmonData");
          if (paramArrayList == null) {
            break label1327;
          }
        }
      }
    }
    label1285:
    label1288:
    label1293:
    label1299:
    label1304:
    label1307:
    label1310:
    label1315:
    label1327:
    for (paramArrayList = paramArrayList.getJSONObject(0);; paramArrayList = null)
    {
      if (paramArrayList != null)
      {
        paramJSONObject = new String[3];
        paramJSONObject[0] = "vipIcon";
        paramJSONObject[1] = "svipIcon";
        paramJSONObject[2] = "activityIcon";
        i = 0;
      }
      for (;;)
      {
        if (i < paramJSONObject.length)
        {
          localObject1 = paramArrayList.getJSONObject(paramJSONObject[i]);
          if (localObject1 != null)
          {
            localObject1 = ((JSONObject)localObject1).getString("src");
            if (TextUtils.isEmpty((CharSequence)localObject1))
            {
              QLog.e("VoiceChangeManager", 1, "preCheckData common url Error null:" + paramJSONObject[i]);
            }
            else
            {
              localObject1 = aqpi.cuH + (String)localObject1;
              if (!this.gk.contains(localObject1)) {
                this.gk.add(localObject1);
              }
              ig[i] = localObject1;
            }
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label555;
          }
          QLog.d("VoiceChangeManager", 2, "preCheckData run ok");
          break label555;
          i = -1;
          break label474;
          label1255:
          localObject2 = paramJSONObject;
          break label431;
          label1261:
          k += 1;
          break;
          label1270:
          paramJSONObject = null;
          label1272:
          i += 1;
          break label237;
          label1279:
          j = -1;
          break label286;
          break label431;
          paramJSONObject = null;
          break label585;
          j = 2;
          break label657;
          i = 1;
          break label789;
          break label789;
          break label816;
          i = 1;
          break label968;
          i = 0;
          break label993;
        }
        i += 1;
      }
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqxp
 * JD-Core Version:    0.7.0.1
 */