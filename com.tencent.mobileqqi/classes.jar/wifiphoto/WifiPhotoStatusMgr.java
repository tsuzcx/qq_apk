package wifiphoto;

public class WifiPhotoStatusMgr
{
  private long jdField_a_of_type_Long = 0L;
  private WifiPhotoStatusMgr.WifiPhotoStatus jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus = WifiPhotoStatusMgr.WifiPhotoStatus.CLOSED;
  
  private void a(WifiPhotoStatusMgr.WifiPhotoStatus paramWifiPhotoStatus)
  {
    this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus = paramWifiPhotoStatus;
  }
  
  public WifiPhotoStatusMgr.WifiPhotoStatus a()
  {
    return this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus;
  }
  
  public void a()
  {
    a(WifiPhotoStatusMgr.WifiPhotoStatus.CLOSED);
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus == WifiPhotoStatusMgr.WifiPhotoStatus.LSTENING) || (this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus == WifiPhotoStatusMgr.WifiPhotoStatus.CONNECTED);
  }
  
  public void b()
  {
    a(WifiPhotoStatusMgr.WifiPhotoStatus.LSTENING);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus == WifiPhotoStatusMgr.WifiPhotoStatus.CONNECTED;
  }
  
  public void c()
  {
    a(WifiPhotoStatusMgr.WifiPhotoStatus.CONNECTED);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus == WifiPhotoStatusMgr.WifiPhotoStatus.LSTENING;
  }
  
  public void d()
  {
    a(WifiPhotoStatusMgr.WifiPhotoStatus.PAUSED);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_WifiphotoWifiPhotoStatusMgr$WifiPhotoStatus == WifiPhotoStatusMgr.WifiPhotoStatus.PAUSED;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     wifiphoto.WifiPhotoStatusMgr
 * JD-Core Version:    0.7.0.1
 */