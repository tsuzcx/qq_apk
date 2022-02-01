import com.tencent.qphone.base.util.QLog;

class vpa
  implements bdvw
{
  vpa(voz paramvoz, vou paramvou) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.a == 0) {
      voz.a(this.jdField_a_of_type_Voz, this.jdField_a_of_type_Vou, true, 0);
    }
    while ((parambdwt.a != 1) && (parambdwt.a != 2)) {
      return;
    }
    voz.a(this.jdField_a_of_type_Voz, this.jdField_a_of_type_Vou, false, parambdwt.b);
    QLog.d(voz.a, 4, "download failed return");
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vpa
 * JD-Core Version:    0.7.0.1
 */