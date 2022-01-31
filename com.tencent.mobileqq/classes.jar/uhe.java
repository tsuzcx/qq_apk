public abstract class uhe<T>
  implements uhf<T>
{
  private uhg<T> a;
  
  public void a()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      a(localObject);
      wsv.a("Q.qqstory.home.data.Producer", "start one consumer:%s", localObject);
      return;
    }
    wsv.d("Q.qqstory.home.data.Producer", "no data return");
  }
  
  public abstract void a(T paramT);
  
  public void a(uhg<T> paramuhg)
  {
    this.a = paramuhg;
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uhe
 * JD-Core Version:    0.7.0.1
 */