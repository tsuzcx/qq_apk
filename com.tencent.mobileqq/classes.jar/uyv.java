import java.util.ArrayList;

public class uyv
  implements uzy
{
  protected tjb a;
  private uyc jdField_a_of_type_Uyc;
  private uyx jdField_a_of_type_Uyx;
  protected uzb a;
  protected uzz a;
  protected vaa a;
  
  public uyv(uyx paramuyx)
  {
    this.jdField_a_of_type_Uyx = paramuyx;
    this.jdField_a_of_type_Uyc = new uyc();
  }
  
  public Object a()
  {
    return null;
  }
  
  public String a()
  {
    return getClass().getSimpleName();
  }
  
  public void a()
  {
    ved.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Uzb == null)
    {
      if (this.jdField_a_of_type_Vaa != null)
      {
        this.jdField_a_of_type_Vaa.a(a());
        return;
      }
      ved.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Uzb.a);
    this.jdField_a_of_type_Tjb = tjb.a(localArrayList);
    this.jdField_a_of_type_Tjb.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Tjb.a(new uyw(this, localArrayList));
    this.jdField_a_of_type_Tjb.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof uzb))
    {
      this.jdField_a_of_type_Uzb = ((uzb)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Uzb == null)
    {
      bool1 = true;
      ved.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Uzb != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      vxp.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(uzz paramuzz)
  {
    this.jdField_a_of_type_Uzz = paramuzz;
  }
  
  public void a(vaa paramvaa)
  {
    this.jdField_a_of_type_Vaa = paramvaa;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyv
 * JD-Core Version:    0.7.0.1
 */