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

public class yyd
  implements Manager
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ArrayList<yyc> jdField_a_of_type_JavaUtilArrayList;
  private ArrayList<yyf> b;
  
  public yyd(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 1)) {
      Collections.sort(this.jdField_a_of_type_JavaUtilArrayList, new yye(this));
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
    return ((yyc)this.jdField_a_of_type_JavaUtilArrayList.get(0)).jdField_b_of_type_Int;
  }
  
  public String a()
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList == null) || (this.jdField_a_of_type_JavaUtilArrayList.size() < 1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = (apxf)apub.a().a(528);
    if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (((apxf)localObject).a == 1)) {}
    for (boolean bool = SettingCloneUtil.readValue(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), null, "qqsetting_qrlogin_set_mute", false);; bool = false)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 1)
      {
        localObject = (yyc)this.jdField_a_of_type_JavaUtilArrayList.get(0);
        localStringBuilder.append(((yyc)localObject).jdField_a_of_type_JavaLangString).append(" ").append(((yyc)localObject).jdField_b_of_type_JavaLangString).append(" ").append(amtj.a(2131693537));
        if (bool) {
          localStringBuilder.append("，").append(amtj.a(2131694394));
        }
      }
      for (;;)
      {
        return localStringBuilder.toString();
        localStringBuilder.append(amtj.a(2131698311));
        localObject = this.jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject).hasNext()) {
          localStringBuilder.append(((yyc)((Iterator)localObject).next()).jdField_a_of_type_JavaLangString).append("、");
        }
        if (bool)
        {
          localStringBuilder.replace(localStringBuilder.length() - 1, localStringBuilder.length(), "，");
          localStringBuilder.append(amtj.a(2131694394));
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
        localStringBuilder.append(((yyc)localIterator.next()).jdField_a_of_type_JavaLangString).append("、");
      }
      localStringBuilder.deleteCharAt(localStringBuilder.lastIndexOf("、"));
    }
    return paramContext.getString(2131716157, new Object[] { localStringBuilder.toString() });
  }
  
  public void a(yyf paramyyf)
  {
    try
    {
      if (this.b == null) {
        this.b = new ArrayList();
      }
      if (!this.b.contains(paramyyf)) {
        this.b.add(paramyyf);
      }
      if (paramyyf != null) {
        paramyyf.a(this.jdField_a_of_type_JavaUtilArrayList);
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
        if (yyg.a(j))
        {
          yyc localyyc = new yyc(j);
          localyyc.jdField_a_of_type_Long = localOnlineInfos.instanceId;
          this.jdField_a_of_type_JavaUtilArrayList.add(localyyc);
          if (QLog.isDevelopLevel()) {
            QLog.d("LoginDevicesManager", 4, localyyc.toString());
          }
        }
        if ((j != 66818) && (j != 66831) && (j != 81154)) {
          break label332;
        }
        i = 1;
      }
    }
    label332:
    for (;;)
    {
      break label56;
      if ((i == 0) && (paramSvcRespParam.PCstat != 0) && ((paramSvcRespParam.iPCClientType == 65793) || (paramSvcRespParam.iPCClientType == 77313)))
      {
        paramSvcRespParam = new yyc(paramSvcRespParam.iPCClientType);
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
          ((yyf)paramSvcRespParam.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
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
      if (yyg.a(i))
      {
        yyc localyyc = new yyc(i);
        localyyc.jdField_a_of_type_Long = localInstanceInfo.iAppId;
        this.jdField_a_of_type_JavaUtilArrayList.add(localyyc);
        if (QLog.isDevelopLevel()) {
          QLog.d("LoginDevicesManager", 4, localyyc.toString());
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
        ((yyf)paramArrayList.next()).a(this.jdField_a_of_type_JavaUtilArrayList);
      }
    }
    if (this.jdField_a_of_type_JavaUtilArrayList.size() > 0) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public void b(yyf paramyyf)
  {
    try
    {
      if (this.b != null) {
        this.b.remove(paramyyf);
      }
      return;
    }
    finally
    {
      paramyyf = finally;
      throw paramyyf;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yyd
 * JD-Core Version:    0.7.0.1
 */