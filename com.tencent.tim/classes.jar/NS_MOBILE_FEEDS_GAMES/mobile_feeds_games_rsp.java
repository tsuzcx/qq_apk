package NS_MOBILE_FEEDS_GAMES;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.HashMap;
import java.util.Map;

public final class mobile_feeds_games_rsp
  extends JceStruct
{
  static Map<Integer, String> cache_mapRsp;
  static st_Games_MarketData cache_mkData;
  static st_Games_OpData cache_opData;
  static st_Games_OrderData cache_orderData = new st_Games_OrderData();
  public Map<Integer, String> mapRsp;
  public st_Games_MarketData mkData;
  public st_Games_OpData opData;
  public st_Games_OrderData orderData;
  
  static
  {
    cache_opData = new st_Games_OpData();
    cache_mkData = new st_Games_MarketData();
    cache_mapRsp = new HashMap();
    cache_mapRsp.put(Integer.valueOf(0), "");
  }
  
  public mobile_feeds_games_rsp() {}
  
  public mobile_feeds_games_rsp(st_Games_OrderData paramst_Games_OrderData, st_Games_OpData paramst_Games_OpData, st_Games_MarketData paramst_Games_MarketData, Map<Integer, String> paramMap)
  {
    this.orderData = paramst_Games_OrderData;
    this.opData = paramst_Games_OpData;
    this.mkData = paramst_Games_MarketData;
    this.mapRsp = paramMap;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.orderData = ((st_Games_OrderData)paramJceInputStream.read(cache_orderData, 0, false));
    this.opData = ((st_Games_OpData)paramJceInputStream.read(cache_opData, 1, false));
    this.mkData = ((st_Games_MarketData)paramJceInputStream.read(cache_mkData, 2, false));
    this.mapRsp = ((Map)paramJceInputStream.read(cache_mapRsp, 3, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    if (this.orderData != null) {
      paramJceOutputStream.write(this.orderData, 0);
    }
    if (this.opData != null) {
      paramJceOutputStream.write(this.opData, 1);
    }
    if (this.mkData != null) {
      paramJceOutputStream.write(this.mkData, 2);
    }
    if (this.mapRsp != null) {
      paramJceOutputStream.write(this.mapRsp, 3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     NS_MOBILE_FEEDS_GAMES.mobile_feeds_games_rsp
 * JD-Core Version:    0.7.0.1
 */