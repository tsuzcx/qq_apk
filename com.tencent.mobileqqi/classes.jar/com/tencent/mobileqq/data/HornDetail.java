package com.tencent.mobileqq.data;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;

public class HornDetail
  implements Serializable, Cloneable
{
  public int commentCnt;
  public CharSequence content;
  public String distance;
  public String hornKey;
  public String nickName;
  public String place;
  public long publishTime;
  public byte[] seg;
  public int status;
  public String time;
  public String uin;
  
  public Object clone()
  {
    try
    {
      localObject = super.clone();
      return localObject;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      do
      {
        Object localObject = this;
      } while (!QLog.isColorLevel());
      QLog.d("NearHornRelated", 2, "HornDetail clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.HornDetail
 * JD-Core Version:    0.7.0.1
 */