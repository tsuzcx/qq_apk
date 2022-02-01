import java.lang.ref.WeakReference;

class zkk
  extends amyh
{
  WeakReference<zkl> a;
  
  public zkk(zkl paramzkl)
  {
    this.a = new WeakReference(paramzkl);
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    zkl localzkl = (zkl)this.a.get();
    if (localzkl != null) {
      localzkl.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkk
 * JD-Core Version:    0.7.0.1
 */