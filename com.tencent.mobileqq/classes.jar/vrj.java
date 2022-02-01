import com.tencent.qphone.base.util.QLog;

class vrj
  implements beuq
{
  vrj(vri paramvri, vrd paramvrd) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.a == 0)
    {
      QLog.i(vri.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " download success return");
      vri.a(this.jdField_a_of_type_Vri, this.jdField_a_of_type_Vrd, true, 0);
    }
    do
    {
      return;
      if ((parambevm.a == 1) || (parambevm.a == 2))
      {
        QLog.i(vri.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " download failed return:" + parambevm.b);
        vri.a(this.jdField_a_of_type_Vri, this.jdField_a_of_type_Vrd, false, parambevm.b);
        return;
      }
    } while (parambevm.a == 3);
    QLog.i(vri.a, 1, "seq = " + this.jdField_a_of_type_Vrd.a() + " download failed return" + parambevm.b);
    vri.a(this.jdField_a_of_type_Vri, this.jdField_a_of_type_Vrd, false, parambevm.b);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrj
 * JD-Core Version:    0.7.0.1
 */