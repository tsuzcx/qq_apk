package com.tencent.mobileqq.together;

import aoii;
import com.tencent.mobileqq.app.QQAppInterface;
import java.io.Serializable;

public class TogetherUIData
  implements Serializable
{
  private aoii mTogetherSession;
  
  public String getCurUin()
  {
    return this.mTogetherSession.uin;
  }
  
  public int getSessionType()
  {
    return this.mTogetherSession.type;
  }
  
  public String getSubTitleText(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    return this.mTogetherSession.a(paramBoolean, paramQQAppInterface);
  }
  
  public aoii getTogetherSession()
  {
    return this.mTogetherSession;
  }
  
  public void reset()
  {
    this.mTogetherSession = null;
  }
  
  public void setTogetherSession(aoii paramaoii)
  {
    this.mTogetherSession = paramaoii;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.together.TogetherUIData
 * JD-Core Version:    0.7.0.1
 */