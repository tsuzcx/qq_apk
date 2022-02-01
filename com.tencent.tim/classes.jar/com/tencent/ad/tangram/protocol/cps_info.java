package com.tencent.ad.tangram.protocol;

public final class cps_info
{
  public static final class CpsCacheInfo
  {
    public long kol_id = 0L;
    public MediaInfo media_info = new MediaInfo();
    public cps_info.PcgMediaTraceInfo[] pcg_media_trace_infos;
    public cps_info.ProductShareInfo[] product_share_info;
    public String trace_id;
    
    public static final class MediaInfo
    {
      public String trace_id;
      public String user_id;
    }
  }
  
  public static final class CpsChanTagInfo
  {
    public boolean is_distribution = false;
    public long product_id = 0L;
    public String trace_id;
  }
  
  public static final class PcgMediaTraceInfo
  {
    public String buyer_id;
    public String content_id;
    public String ext_info;
    public int media_type = 0;
    public long product_id = 0L;
    public int scene = 0;
    public String seller_grade;
    public String seller_id;
    public long timestamp = 0L;
    public String trace_id;
  }
  
  public static final class ProductShareInfo
  {
    public long product_id = 0L;
    public int share_rate = 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.protocol.cps_info
 * JD-Core Version:    0.7.0.1
 */