import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.service.lbs.LbsPortraitUtil;
import java.util.ArrayList;

public class dvf
  extends CardObserver
{
  public dvf(VisitorsActivity paramVisitorsActivity) {}
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte)
  {
    if (!this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_a_of_type_JavaUtilArrayList;
      if (this.a.jdField_a_of_type_Boolean)
      {
        paramString = new ArrayList();
        new dvg(this).start();
      }
      paramString = LbsPortraitUtil.a(paramString, paramArrayList);
      this.a.c = paramLong2;
      paramArrayList = this.a.jdField_a_of_type_Dvj;
      if (this.a.c != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayList.a(paramBoolean);
        this.a.a(paramString, paramLong1);
        return;
      }
    }
    this.a.d();
  }
  
  protected void a(boolean paramBoolean, String paramString, ArrayList paramArrayList, long paramLong1, long paramLong2, byte[] paramArrayOfByte, Card paramCard)
  {
    if (!this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().equals(paramString)) {
      return;
    }
    if (paramBoolean)
    {
      paramString = this.a.jdField_a_of_type_JavaUtilArrayList;
      if (this.a.jdField_a_of_type_Boolean)
      {
        this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().c(AppConstants.S, 1001);
        paramString = new ArrayList();
      }
      this.a.jdField_b_of_type_Long = paramLong2;
      paramArrayOfByte = this.a.jdField_a_of_type_Dvj;
      if (this.a.jdField_b_of_type_Long != -1L) {}
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramArrayOfByte.a(paramBoolean);
        paramString = LbsPortraitUtil.a(paramString, paramArrayList);
        this.a.a(paramString, paramLong1);
        return;
      }
    }
    this.a.d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvf
 * JD-Core Version:    0.7.0.1
 */