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

public class wih
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<wig> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<wij> b;
  
  public wih(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new wii(this));
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
    return ((wig)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (amsb)ampm.a().a(528);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((amsb)localObject).a == 1)) {}
    for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "qqsetting_qrlogin_set_mute", false);; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        localObject = (wig)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localStringBuilder.append(((wig)localObject).jdField_a_of_type_JavaLangString).append(" ").append(((wig)localObject).jdField_b_of_type_JavaLangString).append(" ").append(ajyc.a(2131694024));
        if (bool) {
          localStringBuilder.append("，").append(ajyc.a(2131695048));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(ajyc.a(2131699092));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(((wig)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString).append("、");
        }
        if (bool)
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "，");
          localStringBuilder.append(ajyc.a(2131695048));
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
        localStringBuilder.append(((wig)localIterator.next()).jdField_a_of_type_JavaLangString).append("、");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
    }
    return paramContext.getString(2131717194, new Object[] { localStringBuilder.toString() });
  }
  
  public void a(wij paramwij)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramwij)) {
        this.b.add(paramwij);
      }
      if (paramwij != null) {
        paramwij.a(this.jdField_a_of_type_JavaUtilArrayList);
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
        if (wik.a(j))
        {
          wig localwig = new wig(j);
          localwig.jdField_a_of_type_Long = localOnlineInfos.instanceId;
          this.jdField_a_of_type_JavaUtilArrayList.add(localwig);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localwig.toString());
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
        paramSvcRespParam = new wig(paramSvcRespParam.iPCClientType);
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
          ((wij)paramSvcRespParam.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
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
      if (wik.a(i))
      {
        wig localwig = new wig(i);
        localwig.jdField_a_of_type_Long = localInstanceInfo.iAppId;
        this.jdField_a_of_type_JavaUtilArrayList.add(localwig);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, localwig.toString());
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
        ((wij)paramArrayList.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(wij paramwij)
  {
    try
    {
      if (this.b != null) {
        this.b.remove(paramwij);
      }
      return;
    }
    finally
    {
      paramwij = finally;
      throw paramwij;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     wih
 * JD-Core Version:    0.7.0.1
 */