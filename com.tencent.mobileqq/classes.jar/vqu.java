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

public class vqu
{
  private static Handler jdField_a_of_type_AndroidOsHandler;
  public static final String a;
  private static AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean;
  public static final String b;
  private static String jdField_c_of_type_JavaLangString;
  private EditVideoMusic jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic;
  private EditVideoParams jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams;
  public final Object a;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private stx jdField_a_of_type_Stx = new stx();
  ArrayList<bcab> b;
  private ArrayList<vrk> jdField_c_of_type_JavaUtilArrayList = new ArrayList();
  
  static
  {
    jdField_a_of_type_JavaLangString = BaseApplicationImpl.sApplication.getFilesDir() + File.separator + "blessVoiceChange.json";
    jdField_b_of_type_JavaLangString = ajsd.aW + "voiceChange/bless/";
    jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    a();
  }
  
  public vqu(EditVideoMusic paramEditVideoMusic, EditVideoParams paramEditVideoParams, Handler paramHandler)
  {
    this.jdField_a_of_type_JavaLangObject = new Object[0];
    this.jdField_b_of_type_JavaUtilArrayList = null;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic = paramEditVideoMusic;
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams = paramEditVideoParams;
    jdField_a_of_type_AndroidOsHandler = paramHandler;
    long l = SystemClock.uptimeMillis();
    c();
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "BlessVoiceChangeManager initCost:" + (SystemClock.uptimeMillis() - l));
    }
  }
  
  public static void a()
  {
    if (!jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get()) {}
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
              System.load(jdField_c_of_type_JavaLangString);
              if (!bool) {
                continue;
              }
              jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
              if (!QLog.isColorLevel()) {
                break label198;
              }
              QLog.d("BlessVoiceChangeManager", 2, "so loadSuccess? " + bool + " ,traeSoPath:" + jdField_c_of_type_JavaLangString);
              return;
              localUnsatisfiedLinkError1 = localUnsatisfiedLinkError1;
              QLog.w("BlessVoiceChangeManager", 1, "stl so load error!", localUnsatisfiedLinkError1);
              bool = false;
            }
            catch (UnsatisfiedLinkError localUnsatisfiedLinkError2)
            {
              QLog.w("BlessVoiceChangeManager", 1, "trae so load error!", localUnsatisfiedLinkError2);
              jdField_c_of_type_JavaLangString = null;
              bool = false;
              continue;
            }
          }
          if (llw.f() <= 2) {
            break label199;
          }
          str1 = "/txlib/libtraeimp-armeabi-v7a.so";
          jdField_c_of_type_JavaLangString = BaseApplicationImpl.getContext().getFilesDir().getParent() + str1;
        }
        boolean bool = true;
      }
      catch (Exception localException)
      {
        QLog.w("BlessVoiceChangeManager", 1, localException.toString(), localException);
        return;
      }
      continue;
      label198:
      return;
      label199:
      String str2 = "/txlib/libtraeimp-armeabi.so";
    }
  }
  
  private boolean a()
  {
    int k;
    Object localObject4;
    Object localObject5;
    if (this.jdField_b_of_type_JavaUtilArrayList == null)
    {
      this.jdField_b_of_type_JavaUtilArrayList = new ArrayList();
      i = 0;
      if (i < ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt.length)
      {
        localObject1 = this.jdField_b_of_type_JavaUtilArrayList;
        k = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt[i];
        localObject4 = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfJavaLangString[i];
        localObject5 = ListenChangeVoicePanel.jdField_b_of_type_ArrayOfJavaLangString[i];
        if (i >= 6) {}
        for (j = 0;; j = 2)
        {
          ((ArrayList)localObject1).add(new bcab(k, (String)localObject4, (String)localObject5, 0, j, 1, new bcac(ListenChangeVoicePanel.jdField_b_of_type_ArrayOfInt[i], null, null, null)));
          i += 1;
          break;
        }
      }
    }
    Object localObject1 = new File(jdField_b_of_type_JavaLangString);
    if ((!((File)localObject1).exists()) || (!((File)localObject1).isDirectory())) {
      ((File)localObject1).mkdirs();
    }
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData start!");
    }
    localObject1 = VasQuickUpdateManager.getJSONFromLocal(BaseApplicationImpl.getApplication().getRuntime(), "blessVoiceList.json", false, null);
    int[] arrayOfInt = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt;
    int i = 6;
    if (localObject1 == null)
    {
      QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData null == xydata");
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject1 = (bcab)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject1 != null) {
          ((bcab)localObject1).jdField_b_of_type_Int = 0;
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
          break label1390;
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
            label433:
            if (j < ((JSONArray)localObject6).length())
            {
              localObject4 = ((JSONObject)localObject5).getJSONArray("operateInfo").getJSONObject(j);
              if ((localObject4 == null) || (!((JSONObject)localObject4).has("platformID"))) {
                break label1655;
              }
              k = ((JSONObject)localObject4).getInt("platformID");
              label481:
              localObject1 = localObject4;
              if (k == 0) {
                break label1644;
              }
              localObject1 = localObject4;
              if (k == 2) {
                break label1644;
              }
              localObject1 = localObject4;
              if (k == 3) {
                break label1644;
              }
              if (!QLog.isColorLevel()) {
                break label1641;
              }
              QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData continue platformId=" + k + ", i=" + m + ", timestamp:" + l1 + ", o=" + j);
              break label1641;
            }
            if (localObject4 == null)
            {
              new JSONObject();
              if (!QLog.isColorLevel()) {
                break label1632;
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
        label812:
        localObject4 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      }
      catch (Exception localException2)
      {
        QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData jsonEx:" + localException2.getMessage());
        if (localArrayList.size() <= 0) {
          break label1538;
        }
        localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        if (!localIterator.hasNext()) {
          break label1536;
        }
        localObject4 = (bcab)localIterator.next();
        if (localArrayList.contains(Integer.valueOf(((bcab)localObject4).jdField_a_of_type_Int))) {
          continue;
        }
        ((bcab)localObject4).jdField_b_of_type_Int = 0;
        continue;
        localObject6 = ((JSONObject)localObject5).getJSONArray("baseInfo").getJSONObject(0);
        k = ((JSONObject)localObject6).getInt("voiceID");
        localArrayList.add(Integer.valueOf(k));
        j = 0;
        if (j >= arrayOfInt.length) {
          break label1627;
        }
        if (arrayOfInt[j] != k) {
          break label929;
        }
        if (j >= 0) {
          break;
        }
        if (!QLog.isColorLevel()) {
          break label1632;
        }
        QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData not in VOICE_TYPES[] out:i=" + m + ", timestamp:" + l1);
      }
      finally
      {
        if (localArrayList.size() <= 0) {
          break label1582;
        }
      }
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (bcab)((Iterator)localObject4).next();
        if (!localArrayList.contains(Integer.valueOf(((bcab)localObject5).jdField_a_of_type_Int))) {
          ((bcab)localObject5).jdField_b_of_type_Int = 0;
        }
      }
      label929:
      j += 1;
    }
    Object localObject3;
    label1028:
    label1204:
    if (this.jdField_b_of_type_JavaUtilArrayList != null)
    {
      localObject3 = (bcab)this.jdField_b_of_type_JavaUtilArrayList.get(j);
      label956:
      if (localObject3 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData null == voiceChangeData out:i=" + m + ", timestamp:" + l1);
        }
      }
      else
      {
        if (!((JSONObject)localObject4).has("isShow")) {
          break label1666;
        }
        k = ((JSONObject)localObject4).getInt("isShow");
        j = k;
        if (k != 0)
        {
          j = k;
          if (((JSONObject)localObject4).has("QQVersion"))
          {
            j = k;
            if (bbqa.a(((JSONObject)localObject4).getString("QQVersion"), "8.3.0"))
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
          ((bcab)localObject3).jdField_b_of_type_Int = j;
        }
        else
        {
          if (!((JSONObject)localObject4).has("isEnable")) {
            break label1676;
          }
          if (((JSONObject)localObject4).getInt("isEnable") != 1) {
            break label1671;
          }
          j = 2;
          localObject5 = ((JSONObject)localObject6).getString("icon");
          if (TextUtils.isEmpty((CharSequence)localObject5)) {
            QLog.e("BlessVoiceChangeManager", 1, "preCheckVoiceData url Error null:");
          }
          for (;;)
          {
            ((bcab)localObject3).jdField_b_of_type_Int = j;
            if (1 != j) {
              break;
            }
            ((bcab)localObject3).d = 1;
            ((bcab)localObject3).c = 0;
            if (!TextUtils.isEmpty(((JSONObject)localObject6).getString("name"))) {
              break label1364;
            }
            localObject4 = ((bcab)localObject3).jdField_a_of_type_JavaLangString;
            label1225:
            ((bcab)localObject3).jdField_a_of_type_JavaLangString = ((String)localObject4);
            if (!TextUtils.isEmpty(((JSONObject)localObject6).getString("description"))) {
              break label1377;
            }
            localObject4 = ((bcab)localObject3).jdField_b_of_type_JavaLangString;
            label1253:
            ((bcab)localObject3).jdField_b_of_type_JavaLangString = ((String)localObject4);
            ((bcab)localObject3).jdField_a_of_type_Bcac.jdField_a_of_type_JavaLangString = ((String)localObject5);
            break label1632;
            localObject5 = bboe.jdField_a_of_type_JavaLangString + (String)localObject5;
            this.jdField_a_of_type_JavaUtilArrayList.add(localObject5);
          }
          if (!((JSONObject)localObject4).has("feeType")) {
            break label1679;
          }
          j = ((JSONObject)localObject4).getInt("feeType");
          ((bcab)localObject3).d = j;
          if (!((JSONObject)localObject4).has("tag")) {
            break label1684;
          }
        }
      }
    }
    label1154:
    label1329:
    for (int j = ((JSONObject)localObject4).getInt("tag");; j = 0)
    {
      ((bcab)localObject3).c = j;
      break label1204;
      label1364:
      localObject4 = ((JSONObject)localObject6).getString("name");
      break label1225;
      label1377:
      localObject4 = ((JSONObject)localObject6).getString("description");
      break label1253;
      label1390:
      if (QLog.isColorLevel()) {
        QLog.d("BlessVoiceChangeManager", 2, "preCheckVoiceData run ok! validNum:" + localArrayList.size());
      }
      if (localArrayList.size() > 0)
      {
        localObject3 = this.jdField_b_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (bcab)((Iterator)localObject3).next();
          if (!localArrayList.contains(Integer.valueOf(((bcab)localObject4).jdField_a_of_type_Int))) {
            ((bcab)localObject4).jdField_b_of_type_Int = 0;
          }
        }
        return true;
      }
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject3 = (bcab)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject3 != null) {
          ((bcab)localObject3).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      return true;
      return true;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject3 = (bcab)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject3 != null) {
          ((bcab)localObject3).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      return true;
      while (i < this.jdField_b_of_type_JavaUtilArrayList.size())
      {
        localObject4 = (bcab)this.jdField_b_of_type_JavaUtilArrayList.get(i);
        if (localObject4 != null) {
          ((bcab)localObject4).jdField_b_of_type_Int = 0;
        }
        i += 1;
      }
      throw ((Throwable)localObject3);
      label1627:
      j = -1;
      break label812;
      label1632:
      m += 1;
      break;
      label1641:
      localObject3 = null;
      label1644:
      j += 1;
      localObject4 = localObject3;
      break label433;
      label1655:
      k = -1;
      break label481;
      localObject3 = null;
      break label956;
      k = 2;
      break label1028;
      j = 1;
      break label1154;
      break label1154;
      j = 1;
      break label1329;
    }
  }
  
  @TargetApi(11)
  private void d()
  {
    long l = SystemClock.uptimeMillis();
    String str1;
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)
    {
      str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("BlessVoiceChangeManager", 1, "startDownloadVCImage url is null");
        d();
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
    String str2 = jdField_b_of_type_JavaLangString + str1.substring(str1.lastIndexOf("/") + 1);
    File localFile = new File(str2);
    if ((localFile.isFile()) && (localFile.exists()) && (localFile.length() > 0L))
    {
      if (QLog.isColorLevel()) {
        QLog.d("BlessVoiceChangeManager", 2, "startDownloadVCImage imageFile exits: " + str2 + ",len:" + localFile.length());
      }
      d();
      return;
    }
    new vqv(this, this.jdField_a_of_type_Stx, l).executeOnExecutor(Bosses.get().getExecutor(16), new tfb[] { new tfb(str1, str2, null) });
  }
  
  public void a(vrk paramvrk)
  {
    Object localObject2 = new Object[3];
    if (a((Object[])localObject2))
    {
      Object localObject1 = (String)localObject2[0];
      int i = ((Integer)localObject2[1]).intValue();
      ((Integer)localObject2[2]).intValue();
      localObject2 = ((String)localObject1).substring(0, ((String)localObject1).lastIndexOf(".")).concat(".pcm");
      File localFile = new File((String)localObject2);
      if (!localFile.exists()) {
        bbdx.a(new File((String)localObject1), localFile);
      }
      localObject2 = new bcaa((String)localObject2, i, 64000, 2, paramvrk.c);
      bcad.a(BaseApplicationImpl.getContext(), (bcaa)localObject2, jdField_c_of_type_JavaLangString, new vqw(paramvrk, (String)localObject1), new bcaf(false, false, false, true, true, null));
      localObject1 = new Properties();
      ((Properties)localObject1).setProperty("bless_param_voice_id", "" + paramvrk.c);
      afaz.a("bless_event_voice_click", (Properties)localObject1);
    }
  }
  
  public boolean a(Object[] paramArrayOfObject)
  {
    String str = "";
    Object localObject = new File(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a());
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
            str = this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams$EditSource.a() + File.separator + (String)localObject;
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
      if (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle != null)
      {
        paramArrayOfObject[1] = Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("audio_samplerate", 44100));
        paramArrayOfObject[2] = Integer.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.jdField_a_of_type_AndroidOsBundle.getInt("audio_channel", 1));
      }
    }
    return bool2;
  }
  
  protected void b()
  {
    Object localObject = new Object[3];
    if (a((Object[])localObject))
    {
      localObject = (String)localObject[0];
      File localFile = new File(((String)localObject).substring(0, ((String)localObject).lastIndexOf(".")).concat(".pcm"));
      if (localFile.exists()) {
        bbdx.a(localFile, new File((String)localObject));
      }
    }
  }
  
  public void c()
  {
    boolean bool = a();
    if (QLog.isColorLevel()) {
      QLog.d("BlessVoiceChangeManager", 2, "initVoiceDatas Json. isChecked=" + bool);
    }
    if (bool) {
      d();
    }
    synchronized (this.jdField_c_of_type_JavaUtilArrayList)
    {
      this.jdField_c_of_type_JavaUtilArrayList.clear();
      Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext())
      {
        bcab localbcab = (bcab)localIterator.next();
        if (localbcab.jdField_b_of_type_Int == 2)
        {
          vrk localvrk = new vrk(4, localbcab.jdField_a_of_type_JavaLangString, localbcab.jdField_a_of_type_Bcac.jdField_a_of_type_Int, localbcab.jdField_a_of_type_Int);
          if ((localbcab.jdField_a_of_type_Bcac.jdField_a_of_type_Int == 0) && (!TextUtils.isEmpty(localbcab.jdField_a_of_type_Bcac.jdField_a_of_type_JavaLangString))) {
            localvrk.g = (jdField_b_of_type_JavaLangString + localbcab.jdField_a_of_type_Bcac.jdField_a_of_type_JavaLangString.substring(localbcab.jdField_a_of_type_Bcac.jdField_a_of_type_JavaLangString.lastIndexOf("/") + 1));
          }
          this.jdField_c_of_type_JavaUtilArrayList.add(localvrk);
        }
      }
    }
    this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoMusic.jdField_a_of_type_JavaUtilArrayList = this.jdField_c_of_type_JavaUtilArrayList;
    jdField_a_of_type_AndroidOsHandler.sendMessage(Message.obtain(jdField_a_of_type_AndroidOsHandler, 1, null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vqu
 * JD-Core Version:    0.7.0.1
 */