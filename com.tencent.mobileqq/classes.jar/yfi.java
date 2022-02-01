import java.util.ArrayList;

public class yfi
  implements ygl
{
  protected wpu a;
  private yep jdField_a_of_type_Yep;
  private yfk jdField_a_of_type_Yfk;
  protected yfo a;
  protected ygm a;
  protected ygn a;
  
  public yfi(yfk paramyfk)
  {
    this.jdField_a_of_type_Yfk = paramyfk;
    this.jdField_a_of_type_Yep = new yep();
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
    ykq.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Yfo == null)
    {
      if (this.jdField_a_of_type_Ygn != null)
      {
        this.jdField_a_of_type_Ygn.a(a());
        return;
      }
      ykq.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Yfo.a);
    this.jdField_a_of_type_Wpu = wpu.a(localArrayList);
    this.jdField_a_of_type_Wpu.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Wpu.a(new yfj(this, localArrayList));
    this.jdField_a_of_type_Wpu.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof yfo))
    {
      this.jdField_a_of_type_Yfo = ((yfo)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Yfo == null)
    {
      bool1 = true;
      ykq.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Yfo != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zdl.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(ygm paramygm)
  {
    this.jdField_a_of_type_Ygm = paramygm;
  }
  
  public void a(ygn paramygn)
  {
    this.jdField_a_of_type_Ygn = paramygn;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yfi
 * JD-Core Version:    0.7.0.1
 */