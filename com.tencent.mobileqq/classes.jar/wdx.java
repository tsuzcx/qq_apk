import android.support.annotation.NonNull;

public abstract class wdx
  implements wdo
{
  protected void a(Error paramError) {}
  
  protected void a(wdl paramwdl) {}
  
  public final void a(@NonNull wdm paramwdm)
  {
    a(new wdl(paramwdm.a()));
  }
  
  public final void b(@NonNull wdm paramwdm)
  {
    a(paramwdm.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wdx
 * JD-Core Version:    0.7.0.1
 */