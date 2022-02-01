import java.util.ArrayList;

public class qxa
  implements qxo
{
  protected pxd a;
  private qxa.a a;
  protected qxd.a a;
  protected qxo.a a;
  protected qxo.b a;
  private qwm b;
  
  public qxa(qxa.a parama)
  {
    this.jdField_a_of_type_Qxa$a = parama;
    this.b = new qwm();
  }
  
  public Object D()
  {
    return null;
  }
  
  public boolean KH()
  {
    return false;
  }
  
  public void a(qxo.a parama)
  {
    this.jdField_a_of_type_Qxo$a = parama;
  }
  
  public void a(qxo.b paramb)
  {
    this.jdField_a_of_type_Qxo$b = paramb;
  }
  
  public void an(Object paramObject)
  {
    boolean bool2 = true;
    if ((paramObject instanceof qxd.a))
    {
      this.jdField_a_of_type_Qxd$a = ((qxd.a)paramObject);
      return;
    }
    paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
    if (this.jdField_a_of_type_Qxd$a == null)
    {
      bool1 = true;
      ram.e("GetMyStoryDesFromVidListStep", bool1);
      paramObject = new StringBuilder().append("GetMyStoryDesFromVidListStep 没拿到正确的VidList,reason:");
      if (this.jdField_a_of_type_Qxd$a != null) {
        break label96;
      }
    }
    label96:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      rom.fail(bool1, new Object[0]);
      return;
      bool1 = false;
      break;
    }
  }
  
  public void dump() {}
  
  public String getKey()
  {
    return getClass().getSimpleName();
  }
  
  public void reset() {}
  
  public void run()
  {
    ram.i("GetMyStoryDesFromVidListStep", "GetMyStoryDesFromVidListStep");
    if (this.jdField_a_of_type_Qxd$a == null)
    {
      if (this.jdField_a_of_type_Qxo$b != null)
      {
        this.jdField_a_of_type_Qxo$b.si(getKey());
        return;
      }
      ram.w("GetMyStoryDesFromVidListStep", "finish callBack is null");
      return;
    }
    ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_Qxd$a.nq);
    this.jdField_a_of_type_Pxd = pxd.a(localArrayList);
    this.jdField_a_of_type_Pxd.setTag("GetMyStoryDesFromVidListStep");
    this.jdField_a_of_type_Pxd.a(new qxb(this, localArrayList));
    this.jdField_a_of_type_Pxd.run();
  }
  
  public static abstract interface a
  {
    public abstract void a(qwm paramqwm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxa
 * JD-Core Version:    0.7.0.1
 */