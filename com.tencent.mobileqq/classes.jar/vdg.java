import UserGrowth.stSimpleMetaFeed;
import java.util.List;

class vdg
  implements unf<stSimpleMetaFeed>
{
  vdg(vdf paramvdf, vaa paramvaa, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(boolean paramBoolean1, List<stSimpleMetaFeed> paramList, boolean paramBoolean2)
  {
    paramList = vdf.a(this.jdField_a_of_type_Vdf, paramList);
    if (this.jdField_a_of_type_Vaa != null) {
      this.jdField_a_of_type_Vaa.a(paramList, this.jdField_a_of_type_Boolean, this.b, null);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, Object paramObject)
  {
    if (!paramBoolean3)
    {
      if (this.jdField_a_of_type_Vaa != null) {
        this.jdField_a_of_type_Vaa.a(-1, "task failed.");
      }
      this.jdField_a_of_type_Vdf.a(-1, "task failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */