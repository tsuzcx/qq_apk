package com.tencent.mobileqq.data;

import aqoj;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageForText$AtTroopMemberInfo
{
  public byte flag;
  public short startPos;
  public short textLen;
  public long uin;
  public short wExtBufLen;
  
  public static AtTroopMemberInfo setFromJson(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return null;
    }
    AtTroopMemberInfo localAtTroopMemberInfo = new AtTroopMemberInfo();
    try
    {
      localAtTroopMemberInfo.flag = ((byte)((Integer)paramJSONObject.get("flag")).intValue());
      localAtTroopMemberInfo.uin = paramJSONObject.getLong("uin");
      localAtTroopMemberInfo.startPos = ((short)((Integer)paramJSONObject.get("startPos")).intValue());
      localAtTroopMemberInfo.textLen = ((short)((Integer)paramJSONObject.get("textLen")).intValue());
      return localAtTroopMemberInfo;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e("MessageForText", 1, paramJSONObject, new Object[0]);
      return null;
    }
    catch (ClassCastException paramJSONObject)
    {
      QLog.e("MessageForText", 1, paramJSONObject, new Object[0]);
    }
    return null;
  }
  
  public boolean isIncludingAll()
  {
    return (this.flag == 1) && (this.uin == 0L);
  }
  
  public boolean isIncludingMe(long paramLong)
  {
    return (this.flag == 0) && (this.uin == paramLong);
  }
  
  public boolean isValid()
  {
    return (this.startPos >= 0) && (this.textLen > 0);
  }
  
  public int length()
  {
    return this.wExtBufLen + 11;
  }
  
  public boolean readFrom(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt < 0) || (paramArrayOfByte.length < paramInt + 11)) {
      return false;
    }
    this.startPos = aqoj.b(paramArrayOfByte, paramInt + 0);
    this.textLen = aqoj.b(paramArrayOfByte, paramInt + 2);
    this.flag = paramArrayOfByte[(paramInt + 4)];
    this.uin = aqoj.getLongData(paramArrayOfByte, paramInt + 5);
    this.wExtBufLen = aqoj.b(paramArrayOfByte, paramInt + 9);
    return true;
  }
  
  public JSONObject toJsonObject()
    throws JSONException
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("flag", this.flag);
    localJSONObject.put("uin", this.uin);
    localJSONObject.put("startPos", this.startPos);
    localJSONObject.put("textLen", this.textLen);
    return localJSONObject;
  }
  
  public String toString()
  {
    return "flag:" + this.flag + " uin:" + this.uin + " startPos:" + this.startPos + " textLen:" + this.textLen + "\n";
  }
  
  public boolean writeTo(byte[] paramArrayOfByte, int paramInt)
  {
    if ((paramArrayOfByte == null) || (paramInt < 0) || (paramArrayOfByte.length < paramInt + 11)) {
      return false;
    }
    aqoj.Word2Byte(paramArrayOfByte, paramInt + 0, this.startPos);
    aqoj.Word2Byte(paramArrayOfByte, paramInt + 2, this.textLen);
    paramArrayOfByte[(paramInt + 4)] = this.flag;
    aqoj.DWord2Byte(paramArrayOfByte, paramInt + 5, this.uin);
    aqoj.Word2Byte(paramArrayOfByte, paramInt + 9, (short)0);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.MessageForText.AtTroopMemberInfo
 * JD-Core Version:    0.7.0.1
 */