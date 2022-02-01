import UserGrowth.stSimpleMetaFeed;
import java.util.List;

class vsb
  implements vbf<stSimpleMetaFeed>
{
  vsb(vsa paramvsa, vos paramvos, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = vsa.a(this.jdField_a_of_type_Vsa, paramList);
    if (this.jdField_a_of_type_Vos != null) {
      this.jdField_a_of_type_Vos.a(paramList, this.jdField_a_of_type_Boolean, this.b, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    if (!paramBoolean3)
    {
      if (this.jdField_a_of_type_Vos != null) {
        this.jdField_a_of_type_Vos.a(-1, "task failed.");
      }
      this.jdField_a_of_type_Vsa.a(-1, "task failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vsb
 * JD-Core Version:    0.7.0.1
 */