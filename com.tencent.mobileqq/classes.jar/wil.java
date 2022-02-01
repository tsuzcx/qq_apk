class wil
  implements wlo
{
  wil(wik paramwik) {}
  
  public void a(boolean paramBoolean, wlk paramwlk)
  {
    ykq.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwlk != null))
    {
      ykq.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramwlk.b), Integer.valueOf(paramwlk.a));
      this.a.a(paramwlk.b, paramwlk.a);
      return;
    }
    ykq.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wil
 * JD-Core Version:    0.7.0.1
 */