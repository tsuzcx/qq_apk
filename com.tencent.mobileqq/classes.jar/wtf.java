import java.lang.ref.WeakReference;

class wtf
  extends akdn
{
  WeakReference<wth> a;
  
  public wtf(wth paramwth)
  {
    this.a = new WeakReference(paramwth);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    wth localwth = (wth)this.a.get();
    if (localwth != null) {
      localwth.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtf
 * JD-Core Version:    0.7.0.1
 */