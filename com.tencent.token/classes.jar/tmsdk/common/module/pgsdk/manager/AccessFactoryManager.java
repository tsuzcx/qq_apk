package tmsdk.common.module.pgsdk.manager;

public class AccessFactoryManager
{
  private IAccessFactory a;
  
  private void a()
  {
    if (this.a == null) {
      this.a = new AccessFactoryManager.DefaultAccessFactory(this);
    }
  }
  
  public static AccessFactoryManager get()
  {
    return AccessFactoryManager.Holder.a();
  }
  
  public IAccessFactory accessFactory()
  {
    a();
    return this.a;
  }
  
  public void init(IAccessFactory paramIAccessFactory)
  {
    this.a = paramIAccessFactory;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.module.pgsdk.manager.AccessFactoryManager
 * JD-Core Version:    0.7.0.1
 */