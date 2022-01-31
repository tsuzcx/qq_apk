package com.tencent.mobileqq.data;

import com.tencent.mobileqq.troop.utils.TroopBarUtils;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import org.json.JSONObject;

class TroopBarPostEntity$TroopBarPostAddress
  extends TroopBarAbsDataEntity
{
  protected static final String JSON_KEY_CITY = "city";
  protected static final String JSON_KEY_COUNTRY = "country";
  protected static final String JSON_KEY_LATITUDE = "latitude";
  protected static final String JSON_KEY_LONGITUDE = "longitude";
  protected static final String JSON_KEY_PROVINCE = "province";
  protected static final String JSON_KEY_STREET = "street";
  protected static final long serialVersionUID = 10006L;
  public String city;
  public String country;
  public long latitude;
  public long longitude;
  public String province;
  public String street;
  
  public TroopBarPostEntity$TroopBarPostAddress(TroopBarPostEntity paramTroopBarPostEntity) {}
  
  public TroopBarPostEntity$TroopBarPostAddress(TroopBarPostEntity paramTroopBarPostEntity, JSONObject paramJSONObject)
  {
    super(paramJSONObject);
    this.street = TroopBarUtils.a(paramJSONObject, "street");
    this.province = TroopBarUtils.a(paramJSONObject, "province");
    this.longitude = TroopBarUtils.a(paramJSONObject, "longitude");
    this.latitude = TroopBarUtils.a(paramJSONObject, "latitude");
    this.city = TroopBarUtils.a(paramJSONObject, "city");
    this.country = TroopBarUtils.a(paramJSONObject, "country");
  }
  
  public void readExternal(ObjectInput paramObjectInput)
  {
    this.street = paramObjectInput.readUTF();
    this.province = paramObjectInput.readUTF();
    this.longitude = paramObjectInput.readLong();
    this.latitude = paramObjectInput.readLong();
    this.city = paramObjectInput.readUTF();
    this.country = paramObjectInput.readUTF();
  }
  
  public void writeExternal(ObjectOutput paramObjectOutput)
  {
    paramObjectOutput.writeUTF(this.street);
    paramObjectOutput.writeUTF(this.province);
    paramObjectOutput.writeLong(this.longitude);
    paramObjectOutput.writeLong(this.latitude);
    paramObjectOutput.writeUTF(this.city);
    paramObjectOutput.writeUTF(this.country);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.TroopBarPostEntity.TroopBarPostAddress
 * JD-Core Version:    0.7.0.1
 */