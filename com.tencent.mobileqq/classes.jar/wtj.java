import java.lang.ref.WeakReference;

class wtj
  extends akdo
{
  WeakReference<wtk> a;
  
  public wtj(wtk paramwtk)
  {
    this.a = new WeakReference(paramwtk);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    wtk localwtk = (wtk)this.a.get();
    if (localwtk != null) {
      localwtk.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtj
 * JD-Core Version:    0.7.0.1
 */