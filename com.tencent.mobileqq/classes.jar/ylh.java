import java.util.ArrayList;

public class ylh
  implements ymk
{
  protected wvo a;
  private yko jdField_a_of_type_Yko;
  private ylj jdField_a_of_type_Ylj;
  protected yln a;
  protected yml a;
  protected ymm a;
  
  public ylh(ylj paramylj)
  {
    this.jdField_a_of_type_Ylj = paramylj;
    this.jdField_a_of_type_Yko = new yko();
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
    yqp.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Yln == null)
    {
      if (this.jdField_a_of_type_Ymm != null)
      {
        this.jdField_a_of_type_Ymm.a(a());
        return;
      }
      yqp.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Yln.a);
    this.jdField_a_of_type_Wvo = wvo.a(localArrayList);
    this.jdField_a_of_type_Wvo.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Wvo.a(new yli(this, localArrayList));
    this.jdField_a_of_type_Wvo.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof yln))
    {
      this.jdField_a_of_type_Yln = ((yln)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Yln == null)
    {
      bool1 = true;
      yqp.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Yln != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      zkb.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(yml paramyml)
  {
    this.jdField_a_of_type_Yml = paramyml;
  }
  
  public void a(ymm paramymm)
  {
    this.jdField_a_of_type_Ymm = paramymm;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ylh
 * JD-Core Version:    0.7.0.1
 */