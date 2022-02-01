import com.tencent.qphone.base.util.QLog;

class vky
  implements beuq
{
  vky(vkx paramvkx, vla paramvla) {}
  
  public void onResp(bevm parambevm)
  {
    if (parambevm.a == 0) {
      QLog.d(vkx.b(), 1, this.jdField_a_of_type_Vla.a() + ",download success ");
    }
    do
    {
      vkx.a(this.jdField_a_of_type_Vkx, this.jdField_a_of_type_Vla);
      do
      {
        return;
      } while ((parambevm.a != 1) && (parambevm.a != 2));
      QLog.d(vkx.b(), 1, this.jdField_a_of_type_Vla.a() + ",download failed ");
      bhmi.a(this.jdField_a_of_type_Vla.c(), true);
    } while (vla.a(this.jdField_a_of_type_Vla) == null);
    vla.a(this.jdField_a_of_type_Vla).a(false);
  }
  
  public void onUpdateProgeress(bevl parambevl, long paramLong1, long paramLong2)
  {
    if (vla.a(this.jdField_a_of_type_Vla) != null)
    {
      int i = (int)((float)paramLong1 / (float)paramLong2 * 100.0F);
      vla.a(this.jdField_a_of_type_Vla).a(i);
      QLog.d(vkx.b(), 1, this.jdField_a_of_type_Vla.a() + ",download progress:  " + i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vky
 * JD-Core Version:    0.7.0.1
 */