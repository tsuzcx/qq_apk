import java.util.ArrayList;

public class umc
  implements unf
{
  protected swi a;
  private ulj jdField_a_of_type_Ulj;
  private ume jdField_a_of_type_Ume;
  protected umi a;
  protected ung a;
  protected unh a;
  
  public umc(ume paramume)
  {
    this.jdField_a_of_type_Ume = paramume;
    this.jdField_a_of_type_Ulj = new ulj();
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
    urk.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Umi == null)
    {
      if (this.jdField_a_of_type_Unh != null)
      {
        this.jdField_a_of_type_Unh.a(a());
        return;
      }
      urk.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Umi.a);
    this.jdField_a_of_type_Swi = swi.a(localArrayList);
    this.jdField_a_of_type_Swi.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Swi.a(new umd(this, localArrayList));
    this.jdField_a_of_type_Swi.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof umi))
    {
      this.jdField_a_of_type_Umi = ((umi)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Umi == null)
    {
      bool1 = true;
      urk.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Umi != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      vkw.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(ung paramung)
  {
    this.jdField_a_of_type_Ung = paramung;
  }
  
  public void a(unh paramunh)
  {
    this.jdField_a_of_type_Unh = paramunh;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     umc
 * JD-Core Version:    0.7.0.1
 */