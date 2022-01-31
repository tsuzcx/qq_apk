import java.lang.ref.WeakReference;

class ymk
  extends alzr
{
  WeakReference<ymm> a;
  
  public ymk(ymm paramymm)
  {
    this.a = new WeakReference(paramymm);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    ymm localymm = (ymm)this.a.get();
    if (localymm != null) {
      localymm.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymk
 * JD-Core Version:    0.7.0.1
 */