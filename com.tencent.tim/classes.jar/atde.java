public class atde
{
  public int epe;
  public int epf;
  public int epg;
  public int eph;
  public int epi;
  public int epj;
  public int epk;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PstnSwitchConfig : ");
    localStringBuilder.append("pstn_c2c_aio_flag | ").append(this.epe).append(",pstn_c2c_profile_card_flag | ").append(this.epf).append(",pstn_c2c_ip_call_flag | ").append(this.epg).append(",pstn_multi_aio_flag | ").append(this.eph).append(",pstn_multi_auto_trans_time | ").append(this.epi).append(",pstn_miss_delay_time | ").append(this.epj).append(",pstn_miss_show_time | ").append(this.epk);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atde
 * JD-Core Version:    0.7.0.1
 */