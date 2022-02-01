class wof
  implements wri
{
  wof(woe paramwoe) {}
  
  public void a(boolean paramBoolean, wre paramwre)
  {
    yqp.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (paramwre != null))
    {
      yqp.a("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(paramwre.b), Integer.valueOf(paramwre.a));
      this.a.a(paramwre.b, paramwre.a);
      return;
    }
    yqp.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.a(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wof
 * JD-Core Version:    0.7.0.1
 */