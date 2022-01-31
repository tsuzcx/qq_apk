import java.util.ArrayList;

public class uyy
  implements vab
{
  protected tje a;
  private uyf jdField_a_of_type_Uyf;
  private uza jdField_a_of_type_Uza;
  protected uze a;
  protected vac a;
  protected vad a;
  
  public uyy(uza paramuza)
  {
    this.jdField_a_of_type_Uza = paramuza;
    this.jdField_a_of_type_Uyf = new uyf();
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
    veg.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Uze == null)
    {
      if (this.jdField_a_of_type_Vad != null)
      {
        this.jdField_a_of_type_Vad.a(a());
        return;
      }
      veg.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Uze.a);
    this.jdField_a_of_type_Tje = tje.a(localArrayList);
    this.jdField_a_of_type_Tje.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Tje.a(new uyz(this, localArrayList));
    this.jdField_a_of_type_Tje.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof uze))
    {
      this.jdField_a_of_type_Uze = ((uze)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Uze == null)
    {
      bool1 = true;
      veg.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Uze != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      vxs.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(vac paramvac)
  {
    this.jdField_a_of_type_Vac = paramvac;
  }
  
  public void a(vad paramvad)
  {
    this.jdField_a_of_type_Vad = paramvad;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     uyy
 * JD-Core Version:    0.7.0.1
 */