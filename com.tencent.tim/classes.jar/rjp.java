import android.annotation.TargetApi;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.takevideo.EditVideoMusic;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.EditVideoParams.EditSource;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONArray;
import org.json.JSONObject;

public class rjp
{
  public static final String aAL = BaseApplicationImpl.sApplication.getFilesDir() + File.separator + "blessVoiceChange.json";
  public static final String aAM = acbn.SDCARD_PATH + "voiceChange/bless/";
  private static String aAN;
  private static Handler bs;
  private static AtomicBoolean isSoLoaded = new AtomicBoolean(false);
  private EditVideoParams jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams;
  private pmz jdField_a_of_type_Pmz = new pmz();
  private EditVideoMusic b;
  public final Object bm = new Object[0];
  ArrayList<String> gk = new ArrayList();
  ArrayList<aqxo> nB = null;
  private ArrayList<rkc> nC = new ArrayList();
  
  static
  {
    loadSo();
  }
  
  public rjp(EditVideoMusic paramEditVideoMusic, EditVideoParams paramEditVideoParams, Handler paramHandler)
  {
    this.b = paramEditVideoMusic;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    bs = paramHandler;
    long l = SystemClock.uptimeMillis();
    buW();
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "BlessVoiceChangeManager initCost:" + (SystemClock.uptimeMillis() - l));
    }
  }
  
  private boolean LE()
  {
    int k;
    Object localObject4;
    Object localObject5;
    if (this.nB == null)
    {
      this.nB = new ArrayList();
      i = 0;
      if (i < ListenChangeVoicePanel.hm.length)
      {
        localObject1 = this.nB;
        k = ListenChangeVoicePanel.hm[i];
        localObject4 = ListenChangeVoicePanel.cD[i];
        localObject5 = ListenChangeVoicePanel.cE[i];
        if (i >= 6) {}
        for (j = 0;; j = 2)
        {
          ((ArrayList)localObject1).add(new aqxo(k, (String)localObject4, (String)localObject5, 0, j, 1, new aqxo.a(ListenChangeVoicePanel.hn[i], null, null, null)));
          i += 1;
          break;
        }
      }
    }
    Object localObject1 = new File(aAM);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData start!");
    }
    localObject1 = VasQuickUpdateManager.getJSONFromLocal(BaseApplicationImpl.getApplication().getRuntime(), "blessVoiceList.json", false, null);
    int[] arrayOfInt = ListenChangeVoicePanel.hm;
    int i = 6;
    if (localObject1 == null)
    {
      QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData null == xydata");
      while (i < this.nB.size())
      {
        localObject1 = (aqxo)this.nB.get(i);
        if (localObject1 != null) {
          ((aqxo)localObject1).status = 0;
        }
        i += 1;
      }
      return false;
    }
    ArrayList localArrayList = new ArrayList(16);
    long l1;
    int m;
    Object localObject6;
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData blessVoiceList:" + localObject1);
        }
        l1 = ((JSONObject)localObject1).getLong("timestamp");
        long l2 = System.currentTimeMillis() / 1000L;
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("VoiceChangeModels");
        m = 0;
        j = localJSONArray.length();
        if (m >= j) {
          break label1381;
        }
        try
        {
          localObject5 = localJSONArray.getJSONObject(m);
          if ((localObject5 == null) || (((JSONObject)localObject5).getJSONArray("baseInfo") == null) || (((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0) == null) || (((JSONObject)localObject5).getJSONArray("operateInfo") == null))
          {
            QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData JsonErr:i=" + m + ", timestamp:" + l1);
          }
          else
          {
            localObject6 = ((JSONObject)localObject5).getJSONArray("operateInfo");
            localObject4 = null;
            j = 0;
            label426:
            if (j < ((JSONArray)localObject6).length())
            {
              localObject4 = ((JSONObject)localObject5).getJSONArray("operateInfo").getJSONObject(j);
              if ((localObject4 == null) || (!((JSONObject)localObject4).has("platformID"))) {
                break label1646;
              }
              k = ((JSONObject)localObject4).getInt("platformID");
              label473:
              localObject1 = localObject4;
              if (k == 0) {
                break label1635;
              }
              localObject1 = localObject4;
              if (k == 2) {
                break label1635;
              }
              localObject1 = localObject4;
              if (k == 3) {
                break label1635;
              }
              if (!QLog.isColorLevel()) {
                break label1632;
              }
              QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData continue platformId=" + k + ", i=" + m + ", timestamp:" + l1 + ", o=" + j);
              break label1632;
            }
            if (localObject4 == null)
            {
              new JSONObject();
              if (!QLog.isColorLevel()) {
                break label1623;
              }
              QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData continue null == itemJsonOpera, i=" + m + ", timestamp:" + l1);
            }
          }
        }
        catch (Exception localException1)
        {
          QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData jsonEx:" + localException1);
        }
        Iterator localIterator;
        label803:
        localObject4 = this.nB.iterator();
      }
      catch (Exception localException2)
      {
        QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData jsonEx:" + localException2.getMessage());
        if (localArrayList.size() <= 0) {
          break label1529;
        }
        localIterator = this.nB.iterator();
        if (!localIterator.hasNext()) {
          break label1527;
        }
        localObject4 = (aqxo)localIterator.next();
        if (localArrayList.contains(Integer.valueOf(((aqxo)localObject4).type))) {
          continue;
        }
        ((aqxo)localObject4).status = 0;
        continue;
        localObject6 = ((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0);
        k = ((JSONObject)localObject6).getInt("voiceID");
        localArrayList.add(Integer.valueOf(k));
        j = 0;
        if (j >= arrayOfInt.length) {
          break label1618;
        }
        if (arrayOfInt[j] != k) {
          break label920;
        }
        if (j >= 0) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1623;
        }
        QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData not in VOICE_TYPES[] out:i=" + m + ", timestamp:" + l1);
      }
      finally
      {
        if (localArrayList.size() <= 0) {
          break label1573;
        }
      }
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (aqxo)((Iterator)localObject4).next();
        if (!localArrayList.contains(Integer.valueOf(((aqxo)localObject5).type))) {
          ((aqxo)localObject5).status = 0;
        }
      }
      label920:
      j += 1;
    }
    Object localObject3;
    label1195:
    if (this.nB != null)
    {
      localObject3 = (aqxo)this.nB.get(j);
      label947:
      if (localObject3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData null == voiceChangeData out:i=" + m + ", timestamp:" + l1);
        }
      }
      else
      {
        if (!((JSONObject)localObject4).has("isShow")) {
          break label1657;
        }
        k = ((JSONObject)localObject4).getInt("isShow");
        label1019:
        j = k;
        if (k != 0)
        {
          j = k;
          if (((JSONObject)localObject4).has("QQVersion"))
          {
            j = k;
            if (aqqi.bV(((JSONObject)localObject4).getString("QQVersion"), "3.4.4"))
            {
              k = 0;
              j = k;
              if (QLog.isColorLevel())
              {
                QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData Version out:i=" + m + ", timestamp:" + l1);
                j = k;
              }
            }
          }
        }
        if (j == 0)
        {
          ((aqxo)localObject3).status = j;
        }
        else
        {
          if (!((JSONObject)localObject4).has("isEnable")) {
            break label1667;
          }
          if (((JSONObject)localObject4).getInt("isEnable") != 1) {
            break label1662;
          }
          j = 2;
          label1145:
          localObject5 = ((JSONObject)localObject6).getString("icon");
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData url Error null:");
          }
          for (;;)
          {
            ((aqxo)localObject3).status = j;
            if (1 != j) {
              break;
            }
            ((aqxo)localObject3).feeType = 1;
            ((aqxo)localObject3).edy = 0;
            if (!TextUtils.isEmpty(((JSONObject)localObject6).getString("name"))) {
              break label1355;
            }
            localObject4 = ((aqxo)localObject3).name;
            label1216:
            ((aqxo)localObject3).name = ((String)localObject4);
            if (!TextUtils.isEmpty(((JSONObject)localObject6).getString("description"))) {
              break label1368;
            }
            localObject4 = ((aqxo)localObject3).contentDescription;
            label1244:
            ((aqxo)localObject3).contentDescription = ((String)localObject4);
            ((aqxo)localObject3).a.cyz = ((String)localObject5);
            break label1623;
            localObject5 = aqpi.cuH + (String)localObject5;
            this.gk.add(localObject5);
          }
          if (!((JSONObject)localObject4).has("feeType")) {
            break label1670;
          }
          j = ((JSONObject)localObject4).getInt("feeType");
          ((aqxo)localObject3).feeType = j;
          if (!((JSONObject)localObject4).has("tag")) {
            break label1675;
          }
        }
      }
    }
    label1320:
    for (int j = ((JSONObject)localObject4).getInt("tag");; j = 0)
    {
      ((aqxo)localObject3).edy = j;
      break label1195;
      label1355:
      localObject4 = ((JSONObject)localObject6).getString("name");
      break label1216;
      label1368:
      localObject4 = ((JSONObject)localObject6).getString("description");
      break label1244;
      label1381:
      if (QLog.isColorLevel()) {
        QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData run ok! validNum:" + localArrayList.size());
      }
      if (localArrayList.size() > 0)
      {
        localObject3 = this.nB.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (aqxo)((Iterator)localObject3).next();
          if (!localArrayList.contains(Integer.valueOf(((aqxo)localObject4).type))) {
            ((aqxo)localObject4).status = 0;
          }
        }
        return true;
      }
      while (i < this.nB.size())
      {
        localObject3 = (aqxo)this.nB.get(i);
        if (localObject3 != null) {
          ((aqxo)localObject3).status = 0;
        }
        i += 1;
      }
      return true;
      label1527:
      return true;
      label1529:
      while (i < this.nB.size())
      {
        localObject3 = (aqxo)this.nB.get(i);
        if (localObject3 != null) {
          ((aqxo)localObject3).status = 0;
        }
        i += 1;
      }
      return true;
      while (i < this.nB.size())
      {
        localObject4 = (aqxo)this.nB.get(i);
        if (localObject4 != null) {
          ((aqxo)localObject4).status = 0;
        }
        i += 1;
      }
      throw ((Throwable)localObject3);
      label1618:
      j = -1;
      break label803;
      label1623:
      m += 1;
      break;
      label1632:
      localObject3 = null;
      label1635:
      j += 1;
      localObject4 = localObject3;
      break label426;
      label1646:
      k = -1;
      break label473;
      localObject3 = null;
      break label947;
      label1657:
      k = 2;
      break label1019;
      label1662:
      j = 1;
      break label1145;
      break label1145;
      j = 1;
      break label1320;
    }
  }
  
  @TargetApi(11)
  private void buX()
  {
    long l = SystemClock.uptimeMillis();
    String str1;
    if (this.gk.size() > 0)
    {
      str1 = (String)this.gk.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("BlessVoiceChangeManager", 1, "startDownloadVCImage url is null");
        buX();
      }
    }
    else
    {
      while (!QLog.isColorLevel()) {
        return;
      }
      QLog.d("BlessVoiceChangeManager", 2, "startDownloadVCImage finish!");
      return;
    }
    String str2 = aAM + str1.substring(str1.lastIndexOf("/") + 1);
    File localFile = new File(str2);
    if ((localFile.isFile()) && (localFile.exists()) && (localFile.length() > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessVoiceChangeManager", 2, "startDownloadVCImage imageFile exits: " + str2 + ",len:" + localFile.length());
      }
      buX();
      return;
    }
    new rjq(this, this.jdField_a_of_type_Pmz, l).executeOnExecutor(Bosses.get().getExecutor(16), new pue.a[] { new pue.a(str1, str2, null) });
  }
  
  public static void loadSo()
  {
    if (!isSoLoaded.get()) {}
    for (;;)
    {
      try
      {
        String str1 = BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libstlport_shared.so";
        if (str1 != null)
        {
          try
          {
            System.load(str1);
            bool = true;
          }
          catch (UnsatisfiedLinkError localUnsatisfiedLinkError1)
          {
            try
            {
              System.load(aAN);
              if (!bool) {
                continue;
              }
              isSoLoaded.set(true);
              if (!QLog.isColorLevel()) {
                break label204;
              }
              QLog.d("BlessVoiceChangeManager", 2, "so loadSuccess? " + bool + " ,traeSoPath:" + aAN);
              return;
              localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
              QLog.w("BlessVoiceChangeManager", 1, "stl so load error!", localUnsatisfiedLinkError1);
              bool = false;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
            {
              QLog.w("BlessVoiceChangeManager", 1, "trae so load error!", localUnsatisfiedLinkError2);
              aAN = null;
              bool = false;
              continue;
            }
          }
          if (imm.getCpuArchitecture() <= 2) {
            break label205;
          }
          str1 = "/txlib/libtraeimp-armeabi-v7a.so";
          aAN = BaseApplicationImpl.getContext().getFilesDir().getParent() + str1;
        }
        boolean bool = true;
      }
      catch (Exception localException)
      {
        QLog.w("BlessVoiceChangeManager", 1, localException.toString(), localException);
        return;
      }
      continue;
      label204:
      return;
      label205:
      String str2 = "/txlib/libtraeimp-armeabi.so";
    }
  }
  
  public void b(rkc paramrkc)
  {
    Object localObject2 = new Object[3];
    if (b((Object[])localObject2))
    {
      Object localObject1 = (String)localObject2[0];
      int i = ((Integer)localObject2[1]).intValue();
      ((Integer)localObject2[2]).intValue();
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(".")).concat(".pcm");
      File localFile = new File((String)localObject2);
      if (!localFile.exists()) {
        aqhq.copyFile(new File((String)localObject1), localFile);
      }
      localObject2 = new aqxn((String)localObject2, i, 64000, 2, paramrkc.changeType);
      aqxp.a(BaseApplicationImpl.getContext(), (aqxn)localObject2, aAN, new rjp.a(paramrkc, (String)localObject1), new aqxr(false, false, false, true, true, null));
      localObject1 = new Properties();
      ((Properties)localObject1).setProperty("bless_param_voice_id", "" + paramrkc.changeType);
      ylo.c("bless_event_voice_click", (Properties)localObject1);
    }
  }
  
  public boolean b(Object[] paramArrayOfObject)
  {
    String str = "";
    Object localObject = new File(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath());
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      String[] arrayOfString = ((File)localObject).list();
      if (arrayOfString != null)
      {
        int j = arrayOfString.length;
        int i = 0;
        boolean bool1 = false;
        for (;;)
        {
          bool2 = bool1;
          localObject = str;
          if (i >= j) {
            break;
          }
          localObject = arrayOfString[i];
          if (((String)localObject).endsWith(".af"))
          {
            str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a.getSourcePath() + File.separator + (String)localObject;
            bool1 = true;
          }
          i += 1;
        }
      }
    }
    boolean bool2 = false;
    localObject = str;
    if (paramArrayOfObject != null)
    {
      paramArrayOfObject[0] = localObject;
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra != null)
      {
        paramArrayOfObject[1] = Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getInt("audio_samplerate", 44100));
        paramArrayOfObject[2] = Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.mExtra.getInt("audio_channel", 1));
      }
    }
    return bool2;
  }
  
  protected void buV()
  {
    Object localObject = new Object[3];
    if (b((Object[])localObject))
    {
      localObject = (String)localObject[0];
      File localFile = new File(((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")).concat(".pcm"));
      if (localFile.exists()) {
        aqhq.copyFile(localFile, new File((String)localObject));
      }
    }
  }
  
  public void buW()
  {
    boolean bool = LE();
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "initVoiceDatas Json. isChecked=" + bool);
    }
    if (bool) {
      buX();
    }
    synchronized (this.nC)
    {
      this.nC.clear();
      Iterator localIterator = this.nB.iterator();
      while (localIterator.hasNext())
      {
        aqxo localaqxo = (aqxo)localIterator.next();
        if (localaqxo.status == 2)
        {
          rkc localrkc = new rkc(4, localaqxo.name, localaqxo.a.imgId, localaqxo.type);
          if ((localaqxo.a.imgId == 0) && (!TextUtils.isEmpty(localaqxo.a.cyz))) {
            localrkc.aAR = (aAM + localaqxo.a.cyz.substring(localaqxo.a.cyz.lastIndexOf("/") + 1));
          }
          this.nC.add(localrkc);
        }
      }
    }
    this.b.nu = this.nC;
    bs.sendMessage(Message.obtain(bs, 1, null));
  }
  
  static class a
    implements aqxm
  {
    private String aAO;
    private rkc b;
    
    a(rkc paramrkc, String paramString)
    {
      this.b = paramrkc;
      this.aAO = paramString;
    }
    
    public void ad(int paramInt1, int paramInt2, int paramInt3) {}
    
    public void buY()
    {
      Object localObject = new File(this.aAO.substring(0, this.aAO.lastIndexOf(".af")).concat("_").concat(String.valueOf(this.b.changeType)).concat(".pcm"));
      if (((File)localObject).exists())
      {
        File localFile = new File(this.aAO);
        if (localFile.exists()) {
          localFile.delete();
        }
        aqhq.copyFile((File)localObject, new File(this.aAO));
        if (rjp.bs != null)
        {
          localObject = rjp.bs.obtainMessage(10);
          ((Message)localObject).obj = this.b;
          rjp.bs.sendMessage((Message)localObject);
        }
      }
    }
    
    public void onError() {}
    
    public void onPlayStop() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rjp
 * JD-Core Version:    0.7.0.1
 */