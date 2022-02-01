import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.crmqq.structmsg.StructMsg.ButtonInfo;
import com.tencent.crmqq.structmsg.StructMsg.GetCRMMenuResponse;
import com.tencent.crmqq.structmsg.StructMsg.RetInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.soso.SosoInterface.a;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager.1;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQMenuEntity;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class afrx
{
  private static afrx jdField_a_of_type_Afrx;
  private static byte[] dE = new byte[0];
  private static byte[] lock = new byte[0];
  private long XG;
  private long XH = 1800000L;
  private afrw jdField_a_of_type_Afrw = new afrw();
  public SosoInterface.a c = new afry(this, 4, true, true, 0L, false, false, "EnterpriseQQManager");
  private double cC;
  private double cD;
  protected Runnable ct = new EnterpriseQQManager.1(this);
  private QQAppInterface mApp;
  private Context mContext;
  private ArrayList<afrx.a> wn = new ArrayList();
  
  private afrx(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      z(paramQQAppInterface);
    }
  }
  
  public static afrx a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Afrx == null) {}
    synchronized (lock)
    {
      if (jdField_a_of_type_Afrx == null) {
        jdField_a_of_type_Afrx = new afrx(paramQQAppInterface);
      }
      return jdField_a_of_type_Afrx;
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, StructMsg.ButtonInfo paramButtonInfo)
  {
    paramButtonInfo = new StringBuilder(paramButtonInfo.url.get());
    if (paramButtonInfo.indexOf("?") < 0) {
      paramButtonInfo.append("?");
    }
    for (;;)
    {
      paramButtonInfo.append("uin=" + paramQQAppInterface.getCurrentAccountUin());
      paramButtonInfo.append("&puin=" + paramString);
      Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
      localIntent.putExtra("url", paramButtonInfo.toString());
      localIntent.putExtra("uin", paramQQAppInterface.getCurrentAccountUin());
      localIntent.putExtra("puin", paramString);
      localIntent.putExtra("assignBackText", paramContext.getResources().getString(2131691039));
      if (paramString.equalsIgnoreCase("2632129500")) {
        localIntent.putExtra("hide_operation_bar", true);
      }
      paramContext.startActivity(localIntent);
      return;
      if (paramButtonInfo.indexOf("?") < paramButtonInfo.length() - 1) {
        if (paramButtonInfo.indexOf("&") < 0) {
          paramButtonInfo.append("&");
        } else if (paramButtonInfo.lastIndexOf("&") < paramButtonInfo.length() - 1) {
          paramButtonInfo.append("&");
        }
      }
    }
  }
  
  public void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString1)))
    {
      paramContext = (aceb)paramQQAppInterface.getBusinessHandler(21);
      if (paramContext != null) {
        paramContext.a(paramString1, paramString2, 1, paramBoolean, paramDouble1, paramDouble2);
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, StructMsg.GetCRMMenuResponse paramGetCRMMenuResponse)
  {
    if ((paramQQAppInterface == null) || (TextUtils.isEmpty(paramString))) {}
    long l;
    do
    {
      return;
      if (this.jdField_a_of_type_Afrw == null) {
        this.jdField_a_of_type_Afrw = new afrw();
      }
      l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Afrw.cQ(paramString) != paramInt) && (paramGetCRMMenuResponse != null))
      {
        List localList = paramGetCRMMenuResponse.button_info.get();
        paramGetCRMMenuResponse = new EnterpriseQQMenuEntity(paramString, paramGetCRMMenuResponse, paramInt, l);
        paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
        EnterpriseQQMenuEntity localEnterpriseQQMenuEntity = (EnterpriseQQMenuEntity)paramQQAppInterface.find(EnterpriseQQMenuEntity.class, paramString);
        if (localEnterpriseQQMenuEntity != null)
        {
          localEnterpriseQQMenuEntity.data = ((byte[])paramGetCRMMenuResponse.data.clone());
          localEnterpriseQQMenuEntity.savedDateTime = paramGetCRMMenuResponse.savedDateTime;
          localEnterpriseQQMenuEntity.seqno = paramGetCRMMenuResponse.seqno;
          paramQQAppInterface.update(localEnterpriseQQMenuEntity);
        }
        for (;;)
        {
          this.jdField_a_of_type_Afrw.a(paramString, localList, paramInt, l);
          return;
          paramQQAppInterface.persist(paramGetCRMMenuResponse);
        }
      }
    } while (paramGetCRMMenuResponse == null);
    paramQQAppInterface = paramQQAppInterface.a().createEntityManager();
    paramGetCRMMenuResponse = (EnterpriseQQMenuEntity)paramQQAppInterface.find(EnterpriseQQMenuEntity.class, paramString);
    if (paramGetCRMMenuResponse != null)
    {
      paramGetCRMMenuResponse.savedDateTime = l;
      paramQQAppInterface.update(paramGetCRMMenuResponse);
    }
    this.jdField_a_of_type_Afrw.ah(paramString, l);
  }
  
  public void a(String arg1, Context paramContext, QQAppInterface paramQQAppInterface, String paramString2, StructMsg.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null) {
      if (QLog.isColorLevel()) {
        QLog.e("EnterpriseQQManager", 2, "buttoninfo is null.");
      }
    }
    int i;
    do
    {
      return;
      switch (paramButtonInfo.type.get())
      {
      default: 
        return;
      case 1: 
        if (paramButtonInfo.is_need_lbs.get())
        {
          if ((System.currentTimeMillis() - this.XG < this.XH) && (this.cC != 0.0D) && (this.cD != 0.0D))
          {
            a(paramContext, paramQQAppInterface, paramString2, ???, true, this.cC, this.cD);
            return;
          }
          this.mApp = paramQQAppInterface;
          this.mContext = paramContext;
          paramContext = new afrx.a();
          paramContext.VJ = paramString2;
          paramContext.VK = ???;
          synchronized (dE)
          {
            this.wn.add(paramContext);
            ThreadManager.post(this.ct, 8, null, true);
            return;
          }
        }
        a(paramContext, paramQQAppInterface, paramString2, ???, false, 0.0D, 0.0D);
        return;
      case 2: 
        a(paramContext, paramQQAppInterface, paramString2, paramButtonInfo);
        return;
      }
      i = paramButtonInfo.event_id.get();
    } while ((i == 1) || (i == 2) || (i == 3) || (i != 4));
  }
  
  public List<StructMsg.ButtonInfo> d(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (this.jdField_a_of_type_Afrw != null) {
      return this.jdField_a_of_type_Afrw.au(paramString);
    }
    return null;
  }
  
  public void i(QQAppInterface paramQQAppInterface, String paramString, boolean paramBoolean)
  {
    if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = 0L;
      if (this.jdField_a_of_type_Afrw != null) {
        l = this.jdField_a_of_type_Afrw.ak(paramString);
      }
      if ((paramBoolean) || ((!paramBoolean) && (System.currentTimeMillis() - l > 43200000L)))
      {
        paramQQAppInterface = (aceb)paramQQAppInterface.getBusinessHandler(21);
        if (paramQQAppInterface != null) {
          paramQQAppInterface.DC(paramString);
        }
      }
    }
  }
  
  public void z(QQAppInterface paramQQAppInterface)
  {
    if (this.jdField_a_of_type_Afrw == null) {
      this.jdField_a_of_type_Afrw = new afrw();
    }
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.a().createEntityManager().query(EnterpriseQQMenuEntity.class);
      if ((paramQQAppInterface != null) && (paramQQAppInterface.size() > 0)) {
        paramQQAppInterface = paramQQAppInterface.iterator();
      }
    }
    for (;;)
    {
      EnterpriseQQMenuEntity localEnterpriseQQMenuEntity;
      StructMsg.GetCRMMenuResponse localGetCRMMenuResponse;
      if (paramQQAppInterface.hasNext())
      {
        localEnterpriseQQMenuEntity = (EnterpriseQQMenuEntity)paramQQAppInterface.next();
        if (localEnterpriseQQMenuEntity == null) {
          continue;
        }
        localGetCRMMenuResponse = new StructMsg.GetCRMMenuResponse();
      }
      try
      {
        localGetCRMMenuResponse.mergeFrom(localEnterpriseQQMenuEntity.data);
        label95:
        if (!localGetCRMMenuResponse.ret_info.has()) {
          continue;
        }
        this.jdField_a_of_type_Afrw.a(localEnterpriseQQMenuEntity.uin, localGetCRMMenuResponse.button_info.get(), localEnterpriseQQMenuEntity.seqno, localEnterpriseQQMenuEntity.savedDateTime);
        continue;
        return;
      }
      catch (Exception localException)
      {
        break label95;
      }
    }
  }
  
  public class a
  {
    public String VJ;
    public String VK;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afrx
 * JD-Core Version:    0.7.0.1
 */