import java.lang.ref.WeakReference;

class yhx
  extends alvc
{
  WeakReference<yhz> a;
  
  public yhx(yhz paramyhz)
  {
    this.a = new WeakReference(paramyhz);
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    yhz localyhz = (yhz)this.a.get();
    if (localyhz != null) {
      localyhz.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yhx
 * JD-Core Version:    0.7.0.1
 */