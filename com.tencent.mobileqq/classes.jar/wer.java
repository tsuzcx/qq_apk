import java.lang.ref.WeakReference;

class wer
  extends ajpe
{
  WeakReference<wes> a;
  
  public wer(wes paramwes)
  {
    this.a = new WeakReference(paramwes);
  }
  
  public void b(boolean paramBoolean, String paramString)
  {
    super.a(paramBoolean, paramString);
    wes localwes = (wes)this.a.get();
    if (localwes != null) {
      localwes.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wer
 * JD-Core Version:    0.7.0.1
 */