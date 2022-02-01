class wsa
  implements wvd
{
  wsa(wrz paramwrz) {}
  
  public void a(boolean paramBoolean, wuz paramwuz)
  {
    yuk.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwuz != null))
    {
      yuk.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramwuz.b), Integer.valueOf(paramwuz.a));
      this.a.a(paramwuz.b, paramwuz.a);
      return;
    }
    yuk.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wsa
 * JD-Core Version:    0.7.0.1
 */