package com.tencent.mobileqq.troop.widget;

import com.tencent.tencentmap.mapsdk.map.GeoPoint;
import com.tencent.tencentmap.mapsdk.map.OverlayItem;

public class NearbyTroopsMapViewOverlayItem
  extends OverlayItem
{
  public long a;
  public String a;
  public boolean a;
  public long b;
  public String b;
  
  public NearbyTroopsMapViewOverlayItem(GeoPoint paramGeoPoint, long paramLong1, String paramString1, String paramString2, long paramLong2)
  {
    super(paramGeoPoint, null, null);
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_b_of_type_Long = paramLong2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.NearbyTroopsMapViewOverlayItem
 * JD-Core Version:    0.7.0.1
 */