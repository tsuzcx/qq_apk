import java.lang.ref.WeakReference;

class zzp
  extends aoav
{
  WeakReference<zzq> a;
  
  public zzp(zzq paramzzq)
  {
    this.a = new WeakReference(paramzzq);
  }
  
  public void onUnfollowPublicAccount(boolean paramBoolean, String paramString)
  {
    super.onFollowPublicAccount(paramBoolean, paramString);
    zzq localzzq = (zzq)this.a.get();
    if (localzzq != null) {
      localzzq.a(paramBoolean, paramString, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzp
 * JD-Core Version:    0.7.0.1
 */