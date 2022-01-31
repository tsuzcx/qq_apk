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

public class wie
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<wid> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<wig> b;
  
  public wie(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new wif(this));
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
    return ((wid)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (amsa)ampl.a().a(528);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((amsa)localObject).a == 1)) {}
    for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(), null, "qqsetting_qrlogin_set_mute", false);; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        localObject = (wid)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localStringBuilder.append(((wid)localObject).jdField_a_of_type_JavaLangString).append(" ").append(((wid)localObject).jdField_b_of_type_JavaLangString).append(" ").append(ajya.a(2131694025));
        if (bool) {
          localStringBuilder.append("，").append(ajya.a(2131695049));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(ajya.a(2131699102));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(((wid)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString).append("、");
        }
        if (bool)
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "，");
          localStringBuilder.append(ajya.a(2131695049));
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
        localStringBuilder.append(((wid)localIterator.next()).jdField_a_of_type_JavaLangString).append("、");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
    }
    return paramContext.getString(2131717205, new Object[] { localStringBuilder.toString() });
  }
  
  public void a(wig paramwig)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramwig)) {
        this.b.add(paramwig);
      }
      if (paramwig != null) {
        paramwig.a(this.jdField_a_of_type_JavaUtilArrayList);
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
        if (wih.a(j))
        {
          wid localwid = new wid(j);
          localwid.jdField_a_of_type_Long = localOnlineInfos.instanceId;
          this.jdField_a_of_type_JavaUtilArrayList.add(localwid);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localwid.toString());
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
        paramSvcRespParam = new wid(paramSvcRespParam.iPCClientType);
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
          ((wig)paramSvcRespParam.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
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
      if (wih.a(i))
      {
        wid localwid = new wid(i);
        localwid.jdField_a_of_type_Long = localInstanceInfo.iAppId;
        this.jdField_a_of_type_JavaUtilArrayList.add(localwid);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, localwid.toString());
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
        ((wig)paramArrayList.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(wig paramwig)
  {
    try
    {
      if (this.b != null) {
        this.b.remove(paramwig);
      }
      return;
    }
    finally
    {
      paramwig = finally;
      throw paramwig;
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
 * Qualified Name:     wie
 * JD-Core Version:    0.7.0.1
 */