import java.lang.ref.WeakReference;

class yhy
  extends alvc
{
  WeakReference<yhz> a;
  
  public yhy(yhz paramyhz)
  {
    this.a = new WeakReference(paramyhz);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    yhz localyhz = (yhz)this.a.get();
    if (localyhz != null) {
      localyhz.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhy
 * JD-Core Version:    0.7.0.1
 */