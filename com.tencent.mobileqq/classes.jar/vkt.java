public abstract class vkt<T>
  implements vku<T>
{
  private vkv<T> a;
  
  public void a()
  {
    Object localObject = this.a.a();
    if (localObject != null)
    {
      a(localObject);
      xvv.a("Q.qqstory.home.data.Producer", "start one consumer:%s", localObject);
      return;
    }
    xvv.d("Q.qqstory.home.data.Producer", "no data return");
  }
  
  public abstract void a(T paramT);
  
  public void a(vkv<T> paramvkv)
  {
    this.a = paramvkv;
  }
  
  public void b()
  {
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vkt
 * JD-Core Version:    0.7.0.1
 */