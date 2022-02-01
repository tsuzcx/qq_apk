package com.tencent.weiyun.data;

public class PoiItem
  extends CNativeObject
{
  public static final int NATION_TYPE_DOMESTIC = 1;
  public static final int NATION_TYPE_FOREIGN = 2;
  public String address;
  public int cityId;
  public String cityName;
  public double latitude;
  public double longitude;
  public String nationName;
  public int nationType;
  public String poiId;
  public String poiName;
  
  private PoiItem()
  {
    super(0L);
  }
  
  private PoiItem(long paramLong)
  {
    super(paramLong);
  }
  
  public static PoiItem createGpsInfo(double paramDouble1, double paramDouble2)
  {
    PoiItem localPoiItem = new PoiItem();
    localPoiItem.longitude = paramDouble1;
    localPoiItem.latitude = paramDouble2;
    return localPoiItem;
  }
  
  public static PoiItem newInstance(long paramLong)
  {
    if (paramLong == 0L) {
      return null;
    }
    PoiItem localPoiItem = new PoiItem(paramLong);
    localPoiItem.longitude = CBundleReader.getDouble(paramLong, "longitude", 0.0D);
    localPoiItem.latitude = CBundleReader.getDouble(paramLong, "latitude", 0.0D);
    localPoiItem.nationName = CBundleReader.getString(paramLong, "nation_name");
    localPoiItem.cityName = CBundleReader.getString(paramLong, "city_name");
    localPoiItem.poiId = CBundleReader.getString(paramLong, "poi_id");
    localPoiItem.poiName = CBundleReader.getString(paramLong, "name");
    localPoiItem.address = CBundleReader.getString(paramLong, "addr");
    localPoiItem.releaseNative();
    return localPoiItem;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (!(paramObject instanceof PoiItem)) {
        return false;
      }
      paramObject = (PoiItem)paramObject;
      if (Double.compare(paramObject.longitude, this.longitude) != 0) {
        return false;
      }
    } while (Double.compare(paramObject.latitude, this.latitude) == 0);
    return false;
  }
  
  public int hashCode()
  {
    long l = Double.doubleToLongBits(this.longitude);
    int i = (int)(l ^ l >>> 32);
    l = Double.doubleToLongBits(this.latitude);
    return i * 31 + (int)(l ^ l >>> 32);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.weiyun.data.PoiItem
 * JD-Core Version:    0.7.0.1
 */