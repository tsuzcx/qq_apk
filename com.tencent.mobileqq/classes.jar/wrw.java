import java.util.ArrayList;

public class wrw
  implements wsz
{
  protected vcc a;
  private wrd jdField_a_of_type_Wrd;
  private wry jdField_a_of_type_Wry;
  protected wsc a;
  protected wta a;
  protected wtb a;
  
  public wrw(wry paramwry)
  {
    this.jdField_a_of_type_Wry = paramwry;
    this.jdField_a_of_type_Wrd = new wrd();
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
    wxe.c("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Wsc == null)
    {
      if (this.jdField_a_of_type_Wtb != null)
      {
        this.jdField_a_of_type_Wtb.a(a());
        return;
      }
      wxe.d("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Wsc.a);
    this.jdField_a_of_type_Vcc = vcc.a(localArrayList);
    this.jdField_a_of_type_Vcc.a("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Vcc.a(new wrx(this, localArrayList));
    this.jdField_a_of_type_Vcc.b();
  }
  
  public void a(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof wsc))
    {
      this.jdField_a_of_type_Wsc = ((wsc)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Wsc == null)
    {
      bool1 = true;
      wxe.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Wsc != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      xqq.a(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void a(wta paramwta)
  {
    this.jdField_a_of_type_Wta = paramwta;
  }
  
  public void a(wtb paramwtb)
  {
    this.jdField_a_of_type_Wtb = paramwtb;
  }
  
  public boolean a()
  {
    return false;
  }
  
  public void b() {}
  
  public void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wrw
 * JD-Core Version:    0.7.0.1
 */