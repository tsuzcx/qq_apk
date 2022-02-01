import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.mp.mobileqq_mp.SetFunctionFlagRequset;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.NewIntent;

public class jtz
{
  public static void a(QQAppInterface paramQQAppInterface, AccountDetail paramAccountDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AccountDetailBaseInfoModel", 2, "saveAccountDetailToDBAndCache");
    }
    EntityManager localEntityManager = paramQQAppInterface.a().createEntityManager();
    if ((paramAccountDetail != null) && (paramAccountDetail.getId() != -1L)) {
      if (!localEntityManager.update(paramAccountDetail)) {
        localEntityManager.drop(AccountDetail.class);
      }
    }
    for (;;)
    {
      localEntityManager.close();
      paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
      if ((paramQQAppInterface != null) && (paramAccountDetail != null))
      {
        paramQQAppInterface.f(paramAccountDetail);
        if (paramAccountDetail.followType == 1) {
          paramQQAppInterface.c(PublicAccountInfo.createPublicAccount(paramAccountDetail, 0L));
        }
      }
      return;
      localEntityManager.persist(paramAccountDetail);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, jzs.a parama, int paramInt)
  {
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApp(), kbs.class);
    localNewIntent.putExtra("cmd", "set_function_flag");
    mobileqq_mp.SetFunctionFlagRequset localSetFunctionFlagRequset = new mobileqq_mp.SetFunctionFlagRequset();
    localSetFunctionFlagRequset.version.set(1);
    localSetFunctionFlagRequset.uin.set((int)Long.parseLong(paramString));
    localSetFunctionFlagRequset.type.set(parama.aGI);
    localSetFunctionFlagRequset.value.set(paramInt);
    localSetFunctionFlagRequset.account_type.set(1);
    localNewIntent.putExtra("data", localSetFunctionFlagRequset.toByteArray());
    localNewIntent.setObserver(new jua(paramQQAppInterface, parama, paramInt, paramString));
    paramQQAppInterface.startServlet(localNewIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jtz
 * JD-Core Version:    0.7.0.1
 */