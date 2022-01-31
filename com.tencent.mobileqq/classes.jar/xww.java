import QQService.InstanceInfo;
import RegisterProxySvcPack.OnlineInfos;
import RegisterProxySvcPack.SvcRespParam;
import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import mqq.manager.Manager;

public class xww
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<xwv> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<xwy> b;
  
  public xww(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new xwx(this));
    }
  }
  
  public int a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
      return 0;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 1) {
      return 4;
    }
    return ((xwv)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (aoiy)aogj.a().a(528);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((aoiy)localObject).a == 1)) {}
    for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "qqsetting_qrlogin_set_mute", false);; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        localObject = (xwv)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localStringBuilder.append(((xwv)localObject).jdField_a_of_type_JavaLangString).append(" ").append(((xwv)localObject).jdField_b_of_type_JavaLangString).append(" ").append(alpo.a(2131694141));
        if (bool) {
          localStringBuilder.append("，").append(alpo.a(2131695206));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(alpo.a(2131699445));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(((xwv)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString).append("、");
        }
        if (bool)
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "，");
          localStringBuilder.append(alpo.a(2131695206));
        }
        else
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "。");
        }
      }
    }
  }
  
  public String a(Context paramContext)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((xwv)localIterator.next()).jdField_a_of_type_JavaLangString).append("、");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
    }
    return paramContext.getString(2131717577, new Object[] { localStringBuilder.toString() });
  }
  
  public void a(xwy paramxwy)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramxwy)) {
        this.b.add(paramxwy);
      }
      if (paramxwy != null) {
        paramxwy.a(this.jdField_a_of_type_JavaUtilArrayList);
      }
      return;
    }
    finally {}
  }
  
  public boolean a(SvcRespParam paramSvcRespParam)
  {
    boolean bool = true;
    if ((paramSvcRespParam == null) || (paramSvcRespParam.onlineinfos == null))
    {
      bool = false;
      return bool;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    Iterator localIterator = paramSvcRespParam.onlineinfos.iterator();
    int i = 0;
    label56:
    while (localIterator.hasNext())
    {
      OnlineInfos localOnlineInfos = (OnlineInfos)localIterator.next();
      if (localOnlineInfos.onlineStatus != 0)
      {
        int j = (int)localOnlineInfos.uClientType;
        if (xwz.a(j))
        {
          xwv localxwv = new xwv(j);
          localxwv.jdField_a_of_type_Long = localOnlineInfos.instanceId;
          this.jdField_a_of_type_JavaUtilArrayList.add(localxwv);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localxwv.toString());
          }
        }
        if ((j != 66818) && (j != 66831)) {
          break label326;
        }
        i = 1;
      }
    }
    label326:
    for (;;)
    {
      break label56;
      if ((i == 0) && (paramSvcRespParam.PCstat != 0) && ((paramSvcRespParam.iPCClientType == 65793) || (paramSvcRespParam.iPCClientType == 77313)))
      {
        paramSvcRespParam = new xwv(paramSvcRespParam.iPCClientType);
        this.jdField_a_of_type_JavaUtilArrayList.add(0, paramSvcRespParam);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, paramSvcRespParam.toString());
        }
      }
      a();
      if (QLog.isColorLevel()) {
        QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByRegPrxy size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
      }
      if (this.b != null)
      {
        paramSvcRespParam = this.b.iterator();
        while (paramSvcRespParam.hasNext()) {
          ((xwy)paramSvcRespParam.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
        }
      }
      if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {
        break;
      }
      return false;
    }
  }
  
  public boolean a(ArrayList<InstanceInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      return false;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      InstanceInfo localInstanceInfo = (InstanceInfo)paramArrayList.next();
      int i = (int)localInstanceInfo.iClientType;
      if (xwz.a(i))
      {
        xwv localxwv = new xwv(i);
        localxwv.jdField_a_of_type_Long = localInstanceInfo.iAppId;
        this.jdField_a_of_type_JavaUtilArrayList.add(localxwv);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, localxwv.toString());
        }
      }
    }
    a();
    if (QLog.isColorLevel()) {
      QLog.d("LoginDevicesManager", 2, new Object[] { "updateDevListByOnlinePush size:", Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size()) });
    }
    if (this.b != null)
    {
      paramArrayList = this.b.iterator();
      while (paramArrayList.hasNext()) {
        ((xwy)paramArrayList.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(xwy paramxwy)
  {
    try
    {
      if (this.b != null) {
        this.b.remove(paramxwy);
      }
      return;
    }
    finally
    {
      paramxwy = finally;
      throw paramxwy;
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaUtilArrayList != null)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
    if (this.b != null)
    {
      this.b.clear();
      this.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xww
 * JD-Core Version:    0.7.0.1
 */