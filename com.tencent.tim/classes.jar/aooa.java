import ConfigPush.FileStorageServerListInfo;
import android.app.Application;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.highway.config.HwConfig;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class aooa
{
  private static aooa jdField_a_of_type_Aooa;
  public static int dQx;
  public static int dQy = dQx + 1;
  private List<aoqs> Hd;
  aooa.a jdField_a_of_type_Aooa$a = new aooa.a();
  Application app;
  
  private aooa(Application paramApplication)
  {
    this.app = paramApplication;
  }
  
  public static aooa a()
  {
    if (jdField_a_of_type_Aooa == null) {}
    try
    {
      if (jdField_a_of_type_Aooa == null) {
        jdField_a_of_type_Aooa = new aooa(BaseApplicationImpl.getApplication());
      }
      return jdField_a_of_type_Aooa;
    }
    finally {}
  }
  
  private List<aoqs> al(int paramInt)
  {
    if (paramInt == 0) {
      return this.Hd;
    }
    return null;
  }
  
  public void dWi()
  {
    Object localObject = this.app.getSharedPreferences("SosoSrvAddrList", 0).edit();
    if (localObject != null) {
      ((SharedPreferences.Editor)localObject).putString("SosoSrvAddrList_key", null).commit();
    }
    localObject = new Intent("com.tencent.receiver.soso");
    ((Intent)localObject).putExtra("com.tencent.receiver.soso.type", dQy);
    this.app.sendBroadcast((Intent)localObject);
  }
  
  public void eW(ArrayList<FileStorageServerListInfo> paramArrayList)
  {
    Object localObject = this.app;
    if (Build.VERSION.SDK_INT > 10) {}
    StringBuilder localStringBuilder;
    for (int i = 4;; i = 0)
    {
      localObject = ((Application)localObject).getSharedPreferences("SosoSrvAddrList", i);
      if (paramArrayList == null) {
        return;
      }
      localStringBuilder = new StringBuilder();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        FileStorageServerListInfo localFileStorageServerListInfo = (FileStorageServerListInfo)paramArrayList.next();
        localStringBuilder.append(localFileStorageServerListInfo.sIP).append(":").append(localFileStorageServerListInfo.iPort).append("|");
      }
    }
    ((SharedPreferences)localObject).edit().putString("SosoSrvAddrList_key", localStringBuilder.toString()).commit();
    paramArrayList = new Intent("com.tencent.receiver.soso");
    paramArrayList.putExtra("com.tencent.receiver.soso.type", dQx);
    this.app.sendBroadcast(paramArrayList);
  }
  
  public void init()
  {
    ArrayList localArrayList = new ArrayList();
    HwConfig localHwConfig = aokl.a().a();
    if (localHwConfig != null)
    {
      int i;
      aoqt localaoqt;
      if ((localHwConfig.ipv6List != null) && (localHwConfig.ipv6List.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipv6List.size())
        {
          localaoqt = new aoqt();
          localaoqt.ip = ((EndPoint)localHwConfig.ipv6List.get(i)).host;
          localaoqt.port = ((EndPoint)localHwConfig.ipv6List.get(i)).port;
          localaoqt.cOe = true;
          localArrayList.add(localaoqt);
          i += 1;
        }
      }
      if ((localHwConfig.ipList != null) && (localHwConfig.ipList.size() > 0))
      {
        i = 0;
        while (i < localHwConfig.ipList.size())
        {
          localaoqt = new aoqt();
          localaoqt.ip = ((EndPoint)localHwConfig.ipList.get(i)).host;
          localaoqt.port = ((EndPoint)localHwConfig.ipList.get(i)).port;
          localaoqt.cOe = false;
          localArrayList.add(localaoqt);
          i += 1;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("SosoSrvAddrProvider", 2, String.format("init iplist=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    mE(localArrayList);
  }
  
  public void mE(List<aoqs> paramList)
  {
    try
    {
      this.Hd = paramList;
      this.jdField_a_of_type_Aooa$a.init(paramList);
      return;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  public String o(int paramInt, boolean paramBoolean)
  {
    Object localObject1 = null;
    try
    {
      aoqs localaoqs = this.jdField_a_of_type_Aooa$a.a(paramInt, paramBoolean);
      if (localaoqs != null)
      {
        Object localObject3 = localaoqs.getIp();
        paramInt = localaoqs.getPort();
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localObject3 = localObject1;
        if (((String)localObject1).indexOf(':') >= 0)
        {
          localObject3 = localObject1;
          if (!((String)localObject1).startsWith("[")) {
            localObject3 = "[" + (String)localObject1 + "]";
          }
        }
        localObject1 = "http://" + (String)localObject3 + ":" + paramInt + "/";
      }
      return localObject1;
    }
    finally {}
  }
  
  class a
  {
    private int[] oA;
    
    a() {}
    
    private aoqs a(List<aoqs> paramList, int[] paramArrayOfInt, boolean paramBoolean)
    {
      if (paramArrayOfInt != null)
      {
        ArrayList localArrayList = new ArrayList();
        int i = 0;
        int j = 5;
        if (i < paramArrayOfInt.length)
        {
          int k = j;
          if (((aoqs)paramList.get(i)).isIpv6() == paramBoolean)
          {
            if (paramArrayOfInt[i] >= j) {
              break label94;
            }
            k = paramArrayOfInt[i];
            localArrayList.clear();
            localArrayList.add(Integer.valueOf(i));
          }
          for (;;)
          {
            i += 1;
            j = k;
            break;
            label94:
            k = j;
            if (paramArrayOfInt[i] == j)
            {
              localArrayList.add(Integer.valueOf(i));
              k = j;
            }
          }
        }
        if (localArrayList.size() > 0)
        {
          i = ((Integer)localArrayList.get(0)).intValue();
          if ((i >= 0) && (i < paramList.size())) {
            return (aoqs)paramList.get(i);
          }
        }
      }
      return null;
    }
    
    aoqs a(int paramInt, boolean paramBoolean)
    {
      Object localObject2 = null;
      List localList = aooa.a(aooa.this, paramInt);
      Object localObject1 = localObject2;
      if (localList != null)
      {
        localObject1 = localObject2;
        if (localList.size() > 0) {
          localObject1 = a(localList, r(paramInt), paramBoolean);
        }
      }
      return localObject1;
    }
    
    void init(List<aoqs> paramList)
    {
      if ((paramList != null) && (paramList != null) && (paramList.size() > 0)) {
        this.oA = new int[paramList.size()];
      }
    }
    
    int[] r(int paramInt)
    {
      if (paramInt == 0) {
        return this.oA;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aooa
 * JD-Core Version:    0.7.0.1
 */