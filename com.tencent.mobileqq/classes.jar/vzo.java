public abstract class vzo<T>
  implements vzp<T>
{
  private vzq<T> a;
  
  public void a()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      a(localObject);
      ykq.a("Q.qqstory.home.data.Producer", "start one consumer:%s", localObject);
      return;
    }
    ykq.d("Q.qqstory.home.data.Producer", "no data return");
  }
  
  public abstract void a(T paramT);
  
  public void a(vzq<T> paramvzq)
  {
    this.a = paramvzq;
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vzo
 * JD-Core Version:    0.7.0.1
 */