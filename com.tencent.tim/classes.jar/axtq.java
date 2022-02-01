import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.predownload.QIMPredownHistory;
import dov.com.qq.im.capture.predownload.QIMResClickHistory;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class axtq
  extends axon
  implements Handler.Callback, axtp.a
{
  public static final String[] jo = { "combo", "filter", "music", "ptv", "paster", "text" };
  static File rootDir;
  ArrayList<axtq.a.a> FY = new ArrayList();
  ArrayList<axtq.a.a> FZ = new ArrayList();
  public axtp a;
  axtq.a a;
  LinkedList<axtp> aw = new LinkedList();
  public boolean dwx;
  public Handler ek = new Handler(ThreadManager.getSubThreadLooper(), this);
  public boolean mIsInited;
  
  private axtp a(int paramInt1, String paramString, int paramInt2)
  {
    axtp localaxtp = new axtp();
    localaxtp.index = paramInt1;
    localaxtp.resId = paramString;
    localaxtp.resType = paramInt2;
    localaxtp.a(this);
    return localaxtp;
  }
  
  private void adp(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "content " + paramString);
    }
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        axtq.a locala = axtq.a.a(paramString);
        File localFile = new File(getRootDir(), "predownload11111.cfg");
        SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qim_pre_down11111", 0).edit();
        if (localEditor != null) {
          localEditor.remove("leftRaw").apply();
        }
        aqhq.writeFile(localFile.getAbsolutePath(), paramString);
        a(locala);
        eOQ();
        return;
      }
      catch (Exception paramString)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("QIMPredownManager", 2, "config  ", paramString);
        return;
      }
    }
    new File(getRootDir(), "predownload11111.cfg").delete();
  }
  
  private void eOP()
  {
    eOO();
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(this.FZ);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, String.format("startPredown level:%d  queue:%d  left:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Axtq$a.eHa), Integer.valueOf(this.aw.size()), Integer.valueOf(this.FZ.size()) }));
    }
    int k = localArrayList.size();
    int j = 0;
    int i = 0;
    if ((j >= k) || (this.aw.size() >= 30))
    {
      if (i != 0) {
        eOQ();
      }
      if (!this.aw.isEmpty())
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPredownManager", 2, String.format("startPredown: %d", new Object[] { Integer.valueOf(this.aw.size()) }));
        }
        this.ek.sendEmptyMessage(2);
      }
      return;
    }
    axtq.a.a locala = (axtq.a.a)localArrayList.get(j);
    axtp localaxtp;
    if (this.jdField_a_of_type_Axtq$a.eHa >= locala.level)
    {
      localaxtp = a(locala.index, locala.resId, locala.resType);
      switch (localaxtp.getState())
      {
      }
    }
    for (;;)
    {
      j += 1;
      break;
      this.FZ.remove(locala);
      this.aw.offer(localaxtp);
      continue;
      this.FY.remove(locala);
      this.FZ.remove(locala);
      i = 1;
    }
  }
  
  public static File getRootDir()
  {
    if (rootDir == null)
    {
      rootDir = new File(BaseApplicationImpl.getContext().getFilesDir(), "predownload");
      rootDir.mkdir();
    }
    return rootDir;
  }
  
  public void a(axtq.a parama)
  {
    this.FY.clear();
    this.FZ.clear();
    this.aw.clear();
    this.jdField_a_of_type_Axtq$a = parama;
    Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("qim_pre_down11111", 0).getString("leftRaw", null);
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "updateData leftRaw: " + (String)localObject1);
    }
    if (localObject1 == null)
    {
      parama = parama.Ga.iterator();
      while (parama.hasNext())
      {
        localObject1 = (axtq.a.a)parama.next();
        this.FY.add(localObject1);
        this.FZ.add(localObject1);
      }
    }
    localObject1 = ((String)localObject1).split(":");
    int j = localObject1.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        Object localObject2 = localObject1[i];
        try
        {
          int k = Integer.valueOf((String)localObject2).intValue();
          localObject2 = parama.Ga.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            axtq.a.a locala = (axtq.a.a)((Iterator)localObject2).next();
            if (locala.index == k)
            {
              this.FY.add(locala);
              this.FZ.add(locala);
            }
          }
        }
        catch (Exception localException)
        {
          i += 1;
        }
      }
    }
  }
  
  public void a(boolean paramBoolean, axtp paramaxtp)
  {
    Handler localHandler = this.ek;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      paramaxtp = Message.obtain(localHandler, 2, i, 0, paramaxtp);
      this.ek.sendMessageDelayed(paramaxtp, 3000L);
      return;
    }
  }
  
  public boolean aPJ()
  {
    boolean bool2 = this.dwx;
    boolean bool3 = AppNetConnInfo.isWifiConn();
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
    if ((localAppRuntime != null) && (localAppRuntime.isLogin())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QIMPredownManager", 2, "canPredownload bg " + bool2 + " wifi " + bool3 + " log " + bool1);
      }
      if ((!bool2) || (!bool1) || (!bool3)) {
        break;
      }
      return true;
    }
    return false;
  }
  
  public void eOO()
  {
    if (this.jdField_a_of_type_Axtq$a != null) {
      return;
    }
    localObject4 = new File(getRootDir(), "predownload11111.cfg");
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      localObject4 = aqhq.readFileContent((File)localObject4);
      localObject1 = localObject2;
      localObject2 = axtq.a.a((String)localObject4);
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = localObject2;
        QLog.i("QIMPredownManager", 2, "ensureInit cache " + (String)localObject4);
      }
      localObject1 = localObject2;
    }
    catch (Exception localException2)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QIMPredownManager", 2, "ensureInit: ", localException2);
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject4 = localObject1;
    }
    try
    {
      String str = axwf.py("predownload11111.cfg");
      localObject4 = localObject1;
      localObject1 = axtq.a.a(str);
      localObject2 = localObject1;
      localObject4 = localObject1;
      if (QLog.isColorLevel())
      {
        localObject4 = localObject1;
        QLog.i("QIMPredownManager", 2, "ensureInit asset " + str);
        localObject2 = localObject1;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        Object localObject3 = localObject4;
        if (QLog.isColorLevel())
        {
          QLog.i("QIMPredownManager", 2, "ensureInit: ", localException1);
          localObject3 = localObject4;
        }
      }
    }
    this.mIsInited = true;
    a((axtq.a)localObject2);
  }
  
  public void eOQ()
  {
    Object localObject = new StringBuilder(this.FY.size());
    int i = 0;
    if (i < this.FY.size())
    {
      axtq.a.a locala = (axtq.a.a)this.FY.get(i);
      if (i == 0) {
        ((StringBuilder)localObject).append(locala.index);
      }
      for (;;)
      {
        i += 1;
        break;
        ((StringBuilder)localObject).append(":");
        ((StringBuilder)localObject).append(locala.index);
      }
    }
    localObject = ((StringBuilder)localObject).toString();
    BaseApplicationImpl.getApplication().getSharedPreferences("qim_pre_down11111", 0).edit().putString("leftRaw", (String)localObject).apply();
    if (QLog.isColorLevel()) {
      QLog.i("QIMPredownManager", 2, "saveWaitingQueue leftRaw: " + (String)localObject);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    Object localObject3;
    int i;
    label300:
    label366:
    do
    {
      for (;;)
      {
        return false;
        eOP();
        continue;
        if (QLog.isColorLevel()) {
          QLog.i("QIMPredownManager", 2, "checkAndCreateJob: MSG_CHECK_ANDROID_CREATE_EXECUTE");
        }
        if (paramMessage.obj != null)
        {
          localObject1 = (axtp)paramMessage.obj;
          if (QLog.isColorLevel()) {
            QLog.i("QIMPredownManager", 2, "onJobFinish: " + ((axtp)localObject1).index + ", " + ((axtp)localObject1).resId);
          }
          localObject2 = new QIMPredownHistory();
          ((QIMPredownHistory)localObject2).resId = ((axtp)localObject1).resId;
          ((QIMPredownHistory)localObject2).resType = jo[localObject1.resType];
          localObject3 = a().getEntityManagerFactory().createEntityManager();
          ((EntityManager)localObject3).persist((Entity)localObject2);
          ((EntityManager)localObject3).close();
          if (paramMessage.arg1 == 1)
          {
            i = 0;
            if (i < this.FY.size())
            {
              paramMessage = (axtq.a.a)this.FY.get(i);
              if (paramMessage.index != ((axtp)localObject1).index) {
                break label366;
              }
              if (QLog.isColorLevel()) {
                QLog.i("QIMPredownManager", 2, "onJobFinish: remove " + ((axtp)localObject1).index + ", " + ((axtp)localObject1).resId);
              }
              this.FY.remove(paramMessage);
              eOQ();
            }
          }
        }
        if (aPJ())
        {
          i = 1;
          if (i != 0)
          {
            paramMessage = (axtp)this.aw.poll();
            if (paramMessage != null)
            {
              switch (paramMessage.getState())
              {
              case 1: 
              default: 
                if (QLog.isColorLevel()) {
                  QLog.i("QIMPredownManager", 2, "runJob ignore");
                }
                break;
              }
              for (;;)
              {
                break label300;
                i += 1;
                break;
                this.jdField_a_of_type_Axtp = paramMessage;
                paramMessage.eON();
                i = 0;
                continue;
                this.jdField_a_of_type_Axtp = paramMessage;
                a(true, paramMessage);
                i = 0;
              }
            }
          }
        }
        else if (QLog.isColorLevel())
        {
          QLog.i("QIMPredownManager", 2, "runJob aborted");
          continue;
          adp((String)paramMessage.obj);
        }
      }
      localObject3 = this.jdField_a_of_type_Axtq$a;
    } while (localObject3 == null);
    paramMessage = (HashMap)paramMessage.obj;
    Object localObject1 = (String)paramMessage.get("id");
    int m = ((Integer)paramMessage.get("type")).intValue();
    paramMessage = a().getEntityManagerFactory().createEntityManager();
    Object localObject2 = paramMessage.query(QIMResClickHistory.class, true, "resId=? and resType=?", new String[] { localObject1, jo[m] }, null, null, null, null);
    paramMessage.close();
    int j;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      j = 1;
      label548:
      if (j == 0)
      {
        localObject2 = new QIMResClickHistory();
        ((QIMResClickHistory)localObject2).resId = ((String)localObject1);
        ((QIMResClickHistory)localObject2).resType = jo[m];
        paramMessage = a().getEntityManagerFactory().createEntityManager();
        paramMessage.persist((Entity)localObject2);
        paramMessage.close();
      }
      paramMessage = paramMessage.query(QIMPredownHistory.class, true, "resId=? and resType=?", new String[] { localObject1, jo[m] }, null, null, null, null);
      if ((paramMessage == null) || (paramMessage.isEmpty())) {
        break label872;
      }
      i = 1;
      label649:
      localObject2 = new anqj();
      ((anqj)localObject2).Uq = "0X80090DF";
      ((anqj)localObject2).cgG = String.valueOf(m);
      ((anqj)localObject2).cgI = ((String)localObject1);
      ((anqj)localObject2).cgJ = String.valueOf(aqmj.bl(BaseApplicationImpl.context));
      if (j == 0) {
        break label877;
      }
      paramMessage = "2";
      label705:
      ((anqj)localObject2).cgK = paramMessage;
      int k = -1;
      paramMessage = ((axtq.a)localObject3).Gb.iterator();
      do
      {
        j = k;
        if (!paramMessage.hasNext()) {
          break;
        }
        localObject3 = (axtq.a.a)paramMessage.next();
      } while ((!TextUtils.equals((CharSequence)localObject1, ((axtq.a.a)localObject3).resId)) || (m != ((axtq.a.a)localObject3).resType));
      j = ((axtq.a.a)localObject3).level;
      if ((j == -1) && (i == 0)) {
        break label884;
      }
      paramMessage = "1";
      label788:
      ((anqj)localObject2).cgL = paramMessage;
      paramMessage = new axtp();
      paramMessage.resId = ((String)localObject1);
      paramMessage.resType = m;
      i = 0;
      paramMessage = paramMessage.a();
      if (paramMessage != null)
      {
        if (paramMessage.getState() != 3) {
          break label891;
        }
        i = 1;
      }
      label835:
      if (i == 0) {
        break label896;
      }
    }
    label896:
    for (paramMessage = "1";; paramMessage = "2")
    {
      ((anqj)localObject2).cgM = paramMessage;
      ((anqj)localObject2).cgw = String.valueOf(j);
      anoq.a(null, (anqj)localObject2);
      break;
      j = 0;
      break label548;
      label872:
      i = 0;
      break label649;
      label877:
      paramMessage = "1";
      break label705;
      label884:
      paramMessage = "2";
      break label788;
      label891:
      i = 0;
      break label835;
    }
  }
  
  public void hk(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap(2);
    localHashMap.put("type", Integer.valueOf(paramInt));
    localHashMap.put("id", paramString);
    Message.obtain(this.ek, 3, localHashMap).sendToTarget();
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public static class a
  {
    public ArrayList<axtq.a.a> Ga = new ArrayList();
    public ArrayList<axtq.a.a> Gb = new ArrayList();
    public int eHa;
    
    public static a a(String paramString)
    {
      if (TextUtils.isEmpty(paramString)) {
        return new a();
      }
      locala = new a();
      try
      {
        paramString = new JSONObject(paramString);
        locala.eHa = paramString.getInt("levelLimit");
        paramString = paramString.getJSONArray("levelCfg");
        int j = 0;
        int i = 0;
        while (j < paramString.length())
        {
          JSONObject localJSONObject = paramString.getJSONObject(j);
          int i1 = localJSONObject.getInt("level");
          int k = 0;
          while (k < axtq.jo.length)
          {
            JSONArray localJSONArray = localJSONObject.optJSONArray(axtq.jo[k]);
            int n = i;
            if (localJSONArray != null)
            {
              int m = 0;
              for (;;)
              {
                n = i;
                if (m >= localJSONArray.length()) {
                  break;
                }
                String str = localJSONArray.getString(m);
                axtq.a.a locala1 = new axtq.a.a();
                locala1.resId = str;
                locala1.resType = k;
                locala1.level = i1;
                n = i;
                if (locala.eHa >= i1)
                {
                  locala1.index = i;
                  locala.Ga.add(locala1);
                  n = i + 1;
                }
                locala.Gb.add(locala1);
                m += 1;
                i = n;
              }
            }
            k += 1;
            i = n;
          }
          j += 1;
        }
        return locala;
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
    }
    
    public static class a
    {
      int index;
      int level;
      String resId;
      int resType;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axtq
 * JD-Core Version:    0.7.0.1
 */