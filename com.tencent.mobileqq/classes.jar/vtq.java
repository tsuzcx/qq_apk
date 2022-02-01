class vtq
  implements vwt
{
  vtq(vtp paramvtp) {}
  
  public void a(boolean paramBoolean, vwp paramvwp)
  {
    xvv.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramvwp != null))
    {
      xvv.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramvwp.b), Integer.valueOf(paramvwp.a));
      this.a.a(paramvwp.b, paramvwp.a);
      return;
    }
    xvv.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vtq
 * JD-Core Version:    0.7.0.1
 */