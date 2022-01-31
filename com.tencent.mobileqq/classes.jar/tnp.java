import UserGrowth.stSimpleMetaFeed;
import java.util.List;

class tnp
  implements teo<stSimpleMetaFeed>
{
  tnp(tno paramtno, tmr paramtmr) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = tno.a(this.jdField_a_of_type_Tno, paramList);
    if (this.jdField_a_of_type_Tmr != null) {
      this.jdField_a_of_type_Tmr.a(paramList);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, Object paramObject)
  {
    if (!paramBoolean2)
    {
      if (this.jdField_a_of_type_Tmr != null) {
        this.jdField_a_of_type_Tmr.a(-1, "task failed.");
      }
      this.jdField_a_of_type_Tno.a(-1, "task failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     tnp
 * JD-Core Version:    0.7.0.1
 */