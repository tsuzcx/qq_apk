import com.tencent.biz.qqstory.base.ErrorMessage;

public abstract class qxm
  implements qxo
{
  private qxo.a jdField_a_of_type_Qxo$a;
  private qxo.b jdField_a_of_type_Qxo$b;
  private Object param;
  
  public Object D()
  {
    return this.param;
  }
  
  public boolean KH()
  {
    return true;
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
    this.param = paramObject;
  }
  
  public void completed()
  {
    if (this.jdField_a_of_type_Qxo$b != null)
    {
      this.jdField_a_of_type_Qxo$b.si(getKey());
      return;
    }
    ram.w("SimpleStep", getKey() + " finishCallBack is null.");
  }
  
  protected void f(ErrorMessage paramErrorMessage)
  {
    paramErrorMessage.extraMsg = getKey();
    if (this.jdField_a_of_type_Qxo$a != null)
    {
      this.jdField_a_of_type_Qxo$a.e(paramErrorMessage);
      return;
    }
    ram.w("SimpleStep", getKey() + " errorCallBack is null.");
  }
  
  public static class a<T>
    extends qxm
  {
    public qxm.c<T> a;
    public String azd = "GetResultSimpleStep";
    public T param;
    
    public a(qxm.c<T> paramc)
    {
      this.a = paramc;
    }
    
    public Object D()
    {
      return this.param;
    }
    
    public void an(Object paramObject)
    {
      this.param = paramObject;
    }
    
    public void dump() {}
    
    public String getKey()
    {
      return this.azd;
    }
    
    public void reset() {}
    
    public void run()
    {
      if (this.a != null) {
        this.a.ao(this.param);
      }
    }
  }
  
  public static class b
    extends qxm
  {
    public String azd = "InitParamSimpleStep";
    public Object bu;
    
    public b(Object paramObject)
    {
      this.bu = paramObject;
    }
    
    public Object D()
    {
      return this.bu;
    }
    
    public void dump() {}
    
    public String getKey()
    {
      return this.azd;
    }
    
    public void reset() {}
    
    public void run()
    {
      completed();
    }
  }
  
  public static abstract interface c<T>
  {
    public abstract void ao(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qxm
 * JD-Core Version:    0.7.0.1
 */