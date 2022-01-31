package com.tencent.mobileqq.activity.recent.msg;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopNotificationMsg
  implements IRecentUserMsg, Cloneable
{
  public int a;
  public String a;
  
  public TroopNotificationMsg(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = paramContext.getString(2131561546);
    this.jdField_a_of_type_Int = -35072;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopNotificationMsg.class.getSimpleName(), 2, "deSerialize");
    }
    paramArrayOfByte = new String(paramArrayOfByte);
    try
    {
      paramArrayOfByte = new JSONObject(paramArrayOfByte);
      this.jdField_a_of_type_JavaLangString = paramArrayOfByte.getString("remindText");
      this.jdField_a_of_type_Int = paramArrayOfByte.getInt("color");
      return;
    }
    catch (JSONException paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
    }
  }
  
  public byte[] a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(TroopNotificationMsg.class.getSimpleName(), 2, "serialize");
    }
    return b();
  }
  
  public byte[] b()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("remindText", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("color", this.jdField_a_of_type_Int);
      return localJSONObject.toString().getBytes();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.msg.TroopNotificationMsg
 * JD-Core Version:    0.7.0.1
 */