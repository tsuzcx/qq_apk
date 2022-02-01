import java.util.ArrayList;

public class xqn
  implements xrq
{
  protected waz a;
  private xpu jdField_a_of_type_Xpu;
  private xqp jdField_a_of_type_Xqp;
  protected xqt a;
  protected xrr a;
  protected xrs a;
  
  public xqn(xqp paramxqp)
  {
    this.jdField_a_of_type_Xqp = paramxqp;
    this.jdField_a_of_type_Xpu = new xpu();
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
    xvv.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Xqt == null)
    {
      if (this.jdField_a_of_type_Xrs != null)
      {
        this.jdField_a_of_type_Xrs.a(a());
        return;
      }
      xvv.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Xqt.a);
    this.jdField_a_of_type_Waz = waz.a(localArrayList);
    this.jdField_a_of_type_Waz.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Waz.a(new xqo(this, localArrayList));
    this.jdField_a_of_type_Waz.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof xqt))
    {
      this.jdField_a_of_type_Xqt = ((xqt)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Xqt == null)
    {
      bool1 = true;
      xvv.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Xqt != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      yos.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(xrr paramxrr)
  {
    this.jdField_a_of_type_Xrr = paramxrr;
  }
  
  public void a(xrs paramxrs)
  {
    this.jdField_a_of_type_Xrs = paramxrs;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqn
 * JD-Core Version:    0.7.0.1
 */