import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.lbs.LbsPortraitUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bsd
  extends CardObserver
{
  public bsd(VisitorsActivity paramVisitorsActivity) {}
  
  protected void onFavoritorsList(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onFavoritorsList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onFavoritorsList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_b_of_type_JavaUtilArrayList;
      if (this.a.jdField_b_of_type_Boolean) {
        paramString = new ArrayList();
      }
      this.a.jdField_b_of_type_Long = paramLong2;
      paramArrayOfByte = this.a.jdField_b_of_type_Bsg;
      if (this.a.jdField_b_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.a(paramBoolean);
        paramString = LbsPortraitUtil.a(paramString, paramArrayList);
        this.a.b(paramString, paramLong1);
        return;
      }
    }
    this.a.f();
  }
  
  protected void onVoterList(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (QLog.isColorLevel())
    {
      QLog.d("VisitorsActivity", 2, "onVoterList.isSuccess=" + paramBoolean + ";uin=" + paramString + ";startMid=" + paramLong1 + ";nextMid=" + paramLong2);
      if (paramArrayList != null) {
        QLog.d("VisitorsActivity", 2, "onVoterList.voters.size=" + paramArrayList.size());
      }
    }
    if (!this.a.app.a().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_a_of_type_JavaUtilArrayList;
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.app.a().c(AppConstants.W, 1001);
        paramString = new ArrayList();
      }
      this.a.jdField_a_of_type_Long = paramLong2;
      paramArrayOfByte = this.a.jdField_a_of_type_Bsg;
      if (this.a.jdField_a_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.a(paramBoolean);
        paramString = LbsPortraitUtil.a(paramString, paramArrayList);
        this.a.a(paramString, paramLong1);
        return;
      }
    }
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bsd
 * JD-Core Version:    0.7.0.1
 */