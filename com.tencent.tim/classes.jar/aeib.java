import ConfigPush.DomainIpChannel;
import ConfigPush.DomainIpInfo;
import ConfigPush.DomainIpList;
import ConfigPush.FileStoragePushFSSvcList;
import ConfigPush.FileStorageServerListInfo;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class aeib
{
  private static Hashtable<String, ArrayList<String>>[] a;
  private static String[] eE;
  private static String[] eF;
  public static final String[][] g;
  private static boolean[] r;
  
  static
  {
    int i = 0;
    String[] arrayOfString1 = { "q_qlogo_cn_2g", "q_qlogo_cn_3g", "q_qlogo_cn_4g", "q_qlogo_cn_wifi" };
    String[] arrayOfString2 = { "pgdt_gtimg_cn_2g", "pgdt_gtimg_cn_3g", "pgdt_gtimg_cn_4g", "pgdt_gtimg_cn_wifi" };
    String[] arrayOfString3 = { "download_wegame_qq_com_2g", "download_wegame_qq_com_3g", "download_wegame_qq_com_4g", "download_wegame_qq_com_wifi" };
    String[] arrayOfString4 = { "buluo_qq_com_2g", "buluo_qq_com_3g", "buluo_qq_com_4g", "buluo_qq_com_wifi" };
    g = new String[][] { arrayOfString1, { "p_qlogo_cn_2g", "p_qlogo_cn_3g", "p_plogo_cn_4g", "p_plogo_cn_wifi" }, { "p_qpic_cn_2g", "p_qpic_cn_3g", "p_qpic_cn_4g", "p_qpic_cn_wifi" }, arrayOfString2, { "sqimg_qq_com_2g", "sqimg_qq_com_3g", "sqimg_qq_com_4g", "sqimg_qq_com_wifi" }, arrayOfString3, { "wfqqreader_3g_qq_cn_2g", "wfqqreader_3g_qq_cn_3g", "wfqqreader_3g_qq_cn_4g", "wfqqreader_3g_qq_cn_wifi" }, arrayOfString4 };
    r = new boolean[13];
    eE = new String[14];
    eF = new String[14];
    a = new Hashtable[11];
    while (i <= 7)
    {
      a[i] = new Hashtable(4);
      i += 1;
    }
    i = 8;
    while (i < 11)
    {
      a[i] = new Hashtable(3);
      i += 1;
    }
  }
  
  public static void a(FileStoragePushFSSvcList paramFileStoragePushFSSvcList, QQAppInterface paramQQAppInterface)
  {
    int i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    int j;
    SharedPreferences localSharedPreferences;
    if (i == 1)
    {
      j = 3;
      if (QLog.isColorLevel()) {
        QLog.i("PicIPManager", 2, "saveQQHeadIpList netType=" + i);
      }
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("QQHeadIPList", 4);
      if (localSharedPreferences == null) {
        break label773;
      }
    }
    label773:
    for (Object localObject1 = localSharedPreferences.edit();; localObject1 = null)
    {
      i = 0;
      Object localObject2;
      for (;;)
      {
        if (i <= 7)
        {
          localObject2 = (ArrayList)a[i].get(Integer.valueOf(j));
          if ((localObject2 != null) && (!((ArrayList)localObject2).isEmpty())) {
            ((ArrayList)localObject2).clear();
          }
          if (localObject1 != null) {
            ((SharedPreferences.Editor)localObject1).putString(g[i][j], "");
          }
          eE[i] = null;
          eF[i] = null;
          i += 1;
          continue;
          if (i == 2)
          {
            j = 0;
            break;
          }
          if (i == 3)
          {
            j = 1;
            break;
          }
          if (i == 4)
          {
            j = 2;
            break;
          }
          QLog.i("PicIPManager", 1, "saveQQHeadIpList netType unknown netType=" + i);
          return;
        }
      }
      if (localObject1 != null) {
        ((SharedPreferences.Editor)localObject1).commit();
      }
      if ((paramFileStoragePushFSSvcList != null) && (paramFileStoragePushFSSvcList.domainIpChannel != null) && (paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists != null))
      {
        paramFileStoragePushFSSvcList = paramFileStoragePushFSSvcList.domainIpChannel.vDomain_iplists.iterator();
        while (paramFileStoragePushFSSvcList.hasNext())
        {
          localObject1 = (DomainIpList)paramFileStoragePushFSSvcList.next();
          if ((((DomainIpList)localObject1).vIplist != null) && (((DomainIpList)localObject1).vIplist.size() != 0))
          {
            localObject2 = new StringBuilder();
            i = 0;
            while (i < ((DomainIpList)localObject1).vIplist.size())
            {
              ((StringBuilder)localObject2).append(aqiw.IntAddr2Ip(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(i)).uIp));
              if (i < ((DomainIpList)localObject1).vIplist.size() - 1) {
                ((StringBuilder)localObject2).append("|");
              }
              i += 1;
            }
            if (QLog.isColorLevel()) {
              QLog.i("PicIPManager", 2, "saveQQHeadIpList.uDomain_type=" + ((DomainIpList)localObject1).uDomain_type + ".strBuilder=" + ((StringBuilder)localObject2).toString());
            }
            if (((DomainIpList)localObject1).uDomain_type == 8) {
              i = 0;
            }
            ArrayList localArrayList;
            for (;;)
            {
              if ((((DomainIpList)localObject1).vIplist == null) || (((DomainIpList)localObject1).vIplist.size() == 0)) {
                break label660;
              }
              localObject2 = new StringBuilder();
              localArrayList = new ArrayList();
              int k = 0;
              while (k < ((DomainIpList)localObject1).vIplist.size())
              {
                String str = aqiw.IntAddr2Ip(((DomainIpInfo)((DomainIpList)localObject1).vIplist.get(k)).uIp);
                localArrayList.add(str);
                ((StringBuilder)localObject2).append(str);
                if (k < ((DomainIpList)localObject1).vIplist.size() - 1) {
                  ((StringBuilder)localObject2).append("|");
                }
                k += 1;
              }
              if (((DomainIpList)localObject1).uDomain_type == 9)
              {
                i = 1;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 10)
              {
                i = 2;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 11)
              {
                i = 3;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 12)
              {
                i = 4;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 13)
              {
                i = 5;
              }
              else if (((DomainIpList)localObject1).uDomain_type == 14)
              {
                i = 6;
              }
              else
              {
                if (((DomainIpList)localObject1).uDomain_type != 15) {
                  break;
                }
                i = 7;
              }
            }
            label660:
            continue;
            a[i].put(g[i][j], localArrayList);
            if (QLog.isColorLevel()) {
              QLog.i("PicIPManager", 2, "saveQQHeadIpList.sIpList=" + localArrayList + ",sb=" + ((StringBuilder)localObject2).toString());
            }
            if (localSharedPreferences != null) {
              localSharedPreferences.edit().putString(g[i][j], ((StringBuilder)localObject2).toString()).commit();
            }
          }
        }
      }
      paramQQAppInterface.a().dyO();
      return;
    }
  }
  
  public static void cXe()
  {
    if (QLog.isColorLevel()) {
      QLog.i("PicIPManager", 2, "resetInitedFlag.");
    }
    int i = 0;
    while (i <= 7)
    {
      r[i] = false;
      i += 1;
    }
  }
  
  public static String dR(int paramInt)
  {
    int i = aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext());
    if (i == 1) {
      i = 3;
    }
    while ((g[paramInt][i].equals(eF[paramInt])) && (!TextUtils.isEmpty(eE[paramInt])))
    {
      return eE[paramInt];
      if (i == 2)
      {
        i = 0;
      }
      else if (i == 3)
      {
        i = 1;
      }
      else if (i == 4)
      {
        i = 2;
      }
      else
      {
        QLog.i("PicIPManager", 1, "getIpList netType unknown netType=" + i);
        return null;
      }
    }
    int j;
    if (r[paramInt] == 0)
    {
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("QQHeadIPList", 4);
      if (localObject == null) {
        return null;
      }
      j = 0;
      while (j <= 3)
      {
        String str = ((SharedPreferences)localObject).getString(g[paramInt][j], null);
        if (!TextUtils.isEmpty(str))
        {
          String[] arrayOfString = str.split("\\|");
          if ((arrayOfString != null) && (arrayOfString.length > 0))
          {
            ArrayList localArrayList = new ArrayList();
            int k = 0;
            while (k < arrayOfString.length)
            {
              localArrayList.add(arrayOfString[k]);
              k += 1;
            }
            a[paramInt].put(g[paramInt][j], localArrayList);
          }
          if (QLog.isColorLevel()) {
            QLog.i("PicIPManager", 2, "getIpList array=" + str);
          }
        }
        j += 1;
      }
      r[paramInt] = true;
    }
    Object localObject = (ArrayList)a[paramInt].get(g[paramInt][i]);
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      j = (int)(Math.random() * ((ArrayList)localObject).size());
      eE[paramInt] = ((String)((ArrayList)localObject).get(j));
      eF[paramInt] = g[paramInt][i];
    }
    return eE[paramInt];
  }
  
  public static String dS(int paramInt)
  {
    String str1 = String.valueOf(aqgz.LU());
    if ((str1.equals(eF[paramInt])) && (!TextUtils.isEmpty(eE[paramInt]))) {
      return eE[paramInt];
    }
    String str2;
    Object localObject1;
    if (r[paramInt] == 0)
    {
      str2 = QzoneConfig.getInstance().getConfig("PhotoSvrList", "DownloadDirectIP");
      if (QLog.isColorLevel()) {
        QLog.i("PicIPManager", 2, "getQzoneIp " + str2);
      }
      if (TextUtils.isEmpty(str2)) {
        return null;
      }
      localObject1 = "";
      if (paramInt == 10) {
        localObject1 = ".*qzonestyle.gtimg.cn";
      }
      while (TextUtils.isEmpty((CharSequence)localObject1))
      {
        return null;
        if (paramInt == 8) {
          localObject1 = "ugc.qpic.cn";
        } else if (paramInt == 9) {
          localObject1 = "a[0-9].qpic.cn";
        } else if (paramInt == 11) {
          localObject1 = ".*qzs.qq.com";
        }
      }
    }
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(str2).getJSONArray((String)localObject1);
        i = 0;
        if (i < ((JSONArray)localObject1).length())
        {
          Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
          str2 = ((JSONObject)localObject2).getString("apn");
          localObject2 = ((JSONObject)localObject2).getString("ip");
          ArrayList localArrayList2 = (ArrayList)a[paramInt].get(str2);
          if (localArrayList2 == null)
          {
            localArrayList2 = new ArrayList();
            localArrayList2.add(localObject2);
            a[paramInt].put(str2, localArrayList2);
          }
          else
          {
            localArrayList2.add(localObject2);
          }
        }
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isDevelopLevel()) {
          localJSONException.printStackTrace();
        }
      }
      for (;;)
      {
        ArrayList localArrayList1 = (ArrayList)a[paramInt].get(str1);
        if ((localArrayList1 == null) || (localArrayList1.isEmpty())) {
          break;
        }
        i = (int)(Math.random() * localArrayList1.size());
        eE[paramInt] = ((String)localArrayList1.get(i));
        eF[paramInt] = str1;
        return eE[paramInt];
        r[paramInt] = true;
      }
      return null;
      i += 1;
    }
  }
  
  public static String tg()
  {
    String str = String.valueOf(aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
    if ((str.equals(eF[12])) && (!TextUtils.isEmpty(eE[12]))) {
      return eE[12];
    }
    Object localObject = aokl.a().s(12);
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    localObject = (FileStorageServerListInfo)((ArrayList)localObject).get((int)(Math.random() * ((ArrayList)localObject).size() + 1.0D));
    if (localObject == null) {
      return null;
    }
    eF[12] = str;
    eE[12] = ((FileStorageServerListInfo)localObject).sIP;
    return eE[12];
  }
  
  public static String th()
  {
    String str = String.valueOf(aqiw.getSystemNetwork(BaseApplicationImpl.getApplication().getApplicationContext()));
    if ((str.equals(eF[13])) && (!TextUtils.isEmpty(eE[13]))) {
      return eE[13];
    }
    Object localObject = aokl.a().s(14);
    if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
      return null;
    }
    localObject = (FileStorageServerListInfo)((ArrayList)localObject).get((int)(Math.random() * ((ArrayList)localObject).size() + 1.0D));
    if (localObject == null) {
      return null;
    }
    eF[13] = str;
    eE[13] = ((FileStorageServerListInfo)localObject).sIP;
    return eE[13];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeib
 * JD-Core Version:    0.7.0.1
 */