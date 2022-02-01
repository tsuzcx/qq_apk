import com.tencent.qphone.base.util.QLog;

class viu
  implements bdvw
{
  viu(vit paramvit, viw paramviw) {}
  
  public void onResp(bdwt parambdwt)
  {
    if (parambdwt.a == 0) {
      QLog.d(vit.b(), 1, this.jdField_a_of_type_Viw.a() + ",download success ");
    }
    do
    {
      vit.a(this.jdField_a_of_type_Vit, this.jdField_a_of_type_Viw);
      do
      {
        return;
      } while ((parambdwt.a != 1) && (parambdwt.a != 2));
      QLog.d(vit.b(), 1, this.jdField_a_of_type_Viw.a() + ",download failed ");
      bgmg.a(this.jdField_a_of_type_Viw.c(), true);
    } while (viw.a(this.jdField_a_of_type_Viw) == null);
    viw.a(this.jdField_a_of_type_Viw).a(false);
  }
  
  public void onUpdateProgeress(bdws parambdws, long paramLong1, long paramLong2)
  {
    if (viw.a(this.jdField_a_of_type_Viw) != null)
    {
      int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      viw.a(this.jdField_a_of_type_Viw).a(i);
      QLog.d(vit.b(), 1, this.jdField_a_of_type_Viw.a() + ",download progress:  " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     viu
 * JD-Core Version:    0.7.0.1
 */