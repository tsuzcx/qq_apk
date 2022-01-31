class uut
  implements uxw
{
  uut(uus paramuus) {}
  
  public void a(boolean paramBoolean, uxs paramuxs)
  {
    wxe.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramuxs != null))
    {
      wxe.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramuxs.b), Integer.valueOf(paramuxs.a));
      this.a.a(paramuxs.b, paramuxs.a);
      return;
    }
    wxe.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uut
 * JD-Core Version:    0.7.0.1
 */