import java.lang.ref.WeakReference;

class zkj
  extends amyh
{
  WeakReference<zkl> a;
  
  public zkj(zkl paramzkl)
  {
    this.a = new WeakReference(paramzkl);
  }
  
  public void onFollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    zkl localzkl = (zkl)this.a.get();
    if (localzkl != null) {
      localzkl.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkj
 * JD-Core Version:    0.7.0.1
 */