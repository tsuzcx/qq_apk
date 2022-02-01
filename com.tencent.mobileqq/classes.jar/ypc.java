import java.util.ArrayList;

public class ypc
  implements yqf
{
  protected wzj a;
  private yoj jdField_a_of_type_Yoj;
  private ype jdField_a_of_type_Ype;
  protected ypi a;
  protected yqg a;
  protected yqh a;
  
  public ypc(ype paramype)
  {
    this.jdField_a_of_type_Ype = paramype;
    this.jdField_a_of_type_Yoj = new yoj();
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
    yuk.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Ypi == null)
    {
      if (this.jdField_a_of_type_Yqh != null)
      {
        this.jdField_a_of_type_Yqh.a(a());
        return;
      }
      yuk.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Ypi.a);
    this.jdField_a_of_type_Wzj = wzj.a(localArrayList);
    this.jdField_a_of_type_Wzj.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Wzj.a(new ypd(this, localArrayList));
    this.jdField_a_of_type_Wzj.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof ypi))
    {
      this.jdField_a_of_type_Ypi = ((ypi)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Ypi == null)
    {
      bool1 = true;
      yuk.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Ypi != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      znw.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(yqg paramyqg)
  {
    this.jdField_a_of_type_Yqg = paramyqg;
  }
  
  public void a(yqh paramyqh)
  {
    this.jdField_a_of_type_Yqh = paramyqh;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ypc
 * JD-Core Version:    0.7.0.1
 */