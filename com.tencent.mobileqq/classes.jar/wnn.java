import java.util.ArrayList;

public class wnn
  implements woq
{
  protected uxt a;
  private wmu jdField_a_of_type_Wmu;
  private wnp jdField_a_of_type_Wnp;
  protected wnt a;
  protected wor a;
  protected wos a;
  
  public wnn(wnp paramwnp)
  {
    this.jdField_a_of_type_Wnp = paramwnp;
    this.jdField_a_of_type_Wmu = new wmu();
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
    wsv.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Wnt == null)
    {
      if (this.jdField_a_of_type_Wos != null)
      {
        this.jdField_a_of_type_Wos.a(a());
        return;
      }
      wsv.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Wnt.a);
    this.jdField_a_of_type_Uxt = uxt.a(localArrayList);
    this.jdField_a_of_type_Uxt.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Uxt.a(new wno(this, localArrayList));
    this.jdField_a_of_type_Uxt.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof wnt))
    {
      this.jdField_a_of_type_Wnt = ((wnt)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Wnt == null)
    {
      bool1 = true;
      wsv.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Wnt != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      xmh.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(wor paramwor)
  {
    this.jdField_a_of_type_Wor = paramwor;
  }
  
  public void a(wos paramwos)
  {
    this.jdField_a_of_type_Wos = paramwos;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wnn
 * JD-Core Version:    0.7.0.1
 */