class prx
  implements pub.a
{
  prx(prw paramprw) {}
  
  public void a(boolean paramBoolean, pua parampua)
  {
    ram.d("AddressDataProvider", "AddressLbsListener: onLbsUpdate, isSuccess=" + paramBoolean);
    if ((paramBoolean) && (parampua != null))
    {
      ram.b("AddressDataProvider", "AddressLbsListener: onLbsUpdate, [longitude=%s, latitude=%s]", Integer.valueOf(parampua.mLongitude), Integer.valueOf(parampua.mLatitude));
      this.a.dO(parampua.mLongitude, parampua.mLatitude);
      return;
    }
    ram.e("AddressDataProvider", "AddressLbsListener: onLbsUpdate, failed.");
    this.a.k(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     prx
 * JD-Core Version:    0.7.0.1
 */