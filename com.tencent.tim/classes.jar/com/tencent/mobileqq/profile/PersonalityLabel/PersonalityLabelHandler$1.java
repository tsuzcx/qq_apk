package com.tencent.mobileqq.profile.PersonalityLabel;

import alcn;
import com.tencent.mobileqq.app.QQAppInterface;

public final class PersonalityLabelHandler$1
  implements Runnable
{
  public PersonalityLabelHandler$1(String paramString, QQAppInterface paramQQAppInterface, alcn paramalcn, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    if (this.val$uin.equals(this.val$app.getCurrentAccountUin())) {
      this.b.d.vPersonalityLabelV2 = this.bt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler.1
 * JD-Core Version:    0.7.0.1
 */