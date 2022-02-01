import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class apbf
  extends acnd
{
  apbf(apbc paramapbc) {}
  
  protected void eE(int paramInt1, int paramInt2)
  {
    QLog.e("TroopCreateLogic", 1, "onTroopManagerFailed, result = " + paramInt2);
    this.c.app.removeObserver(this.c.jdField_b_of_type_Acnd);
    if (this.c.jdField_b_of_type_Apbc$c != null)
    {
      if (paramInt1 == 8) {
        this.c.jdField_b_of_type_Apbc$c.bF(paramInt2, "");
      }
      this.c.jdField_b_of_type_Apbc$c = null;
    }
  }
  
  protected void q(int paramInt1, int paramInt2, String paramString)
  {
    this.c.app.removeObserver(this.c.jdField_b_of_type_Acnd);
    if (paramInt1 == 8)
    {
      if (this.c.jdField_b_of_type_Apbc$c != null) {
        this.c.jdField_b_of_type_Apbc$c.bF(0, paramString);
      }
      this.c.j(paramString, true, "");
      ((acms)this.c.app.getBusinessHandler(20)).hS(Long.parseLong(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apbf
 * JD-Core Version:    0.7.0.1
 */