class uqk
  implements utn
{
  uqk(uqj paramuqj) {}
  
  public void a(boolean paramBoolean, utj paramutj)
  {
    wsv.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramutj != null))
    {
      wsv.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramutj.b), Integer.valueOf(paramutj.a));
      this.a.a(paramutj.b, paramutj.a);
      return;
    }
    wsv.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     uqk
 * JD-Core Version:    0.7.0.1
 */