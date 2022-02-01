package com.tencent.qqmail.model.qmdomain;

import com.tencent.qqmail.utilities.QMMath;

public class ContactEmail
  implements Cloneable, Comparable<ContactEmail>
{
  private String email;
  private int freq;
  private int freqUpdateTime;
  
  public ContactEmail() {}
  
  public ContactEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public ContactEmail(String paramString, int paramInt1, int paramInt2)
  {
    this.email = paramString;
    this.freq = paramInt1;
    this.freqUpdateTime = paramInt2;
  }
  
  public ContactEmail clone()
  {
    ContactEmail localContactEmail = new ContactEmail();
    localContactEmail.setEmail(this.email);
    localContactEmail.setFreq(this.freq);
    localContactEmail.setFreqUpdateTime(this.freqUpdateTime);
    return localContactEmail;
  }
  
  public int compareTo(ContactEmail paramContactEmail)
  {
    if ((paramContactEmail == null) || (paramContactEmail.getEmail() == null)) {
      return 1;
    }
    if (this.email == null) {
      return -1;
    }
    return this.email.compareTo(paramContactEmail.getEmail());
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if (paramObject == null) {
        return false;
      }
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (ContactEmail)paramObject;
    } while ((paramObject.email != null) && (this.email != null) && (this.email.equals(paramObject.email)));
    return false;
  }
  
  public String getEmail()
  {
    return this.email;
  }
  
  public int getFreq()
  {
    return this.freq;
  }
  
  public int getFreqUpdateTime()
  {
    return this.freqUpdateTime;
  }
  
  public int hashCode()
  {
    return QMMath.hashInt(this.email);
  }
  
  public void setEmail(String paramString)
  {
    this.email = paramString;
  }
  
  public void setFreq(int paramInt)
  {
    this.freq = paramInt;
  }
  
  public void setFreqUpdateTime(int paramInt)
  {
    this.freqUpdateTime = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    localStringBuilder.append("\"class\":\"ContactEmail\",");
    localStringBuilder.append("\"email\":\"").append(this.email).append("\",");
    localStringBuilder.append("\"freq\":").append(this.freq).append(",");
    localStringBuilder.append("\"freqUpdateTime\":").append(this.freqUpdateTime);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.qmdomain.ContactEmail
 * JD-Core Version:    0.7.0.1
 */