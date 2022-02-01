package com.tencent.qidian;

import alcn;
import android.text.TextUtils;
import avpw;
import avpw.d;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.QQAppInterface;

class QidianProfileCardActivity$25
  implements Runnable
{
  QidianProfileCardActivity$25(QidianProfileCardActivity paramQidianProfileCardActivity, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    Object localObject2 = this.this$0.app.getCurrentNickname();
    Object localObject1 = localObject2;
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = this.this$0.app.getCurrentNickname();
    }
    localObject2 = avpw.d.a();
    ((avpw.d)localObject2).cMP = this.this$0.app.getCurrentAccountUin();
    ((avpw.d)localObject2).nickname = ((String)localObject1);
    avpw.a(this.this$0, (avpw.d)localObject2, this.this$0.jdField_a_of_type_Alcn.e.uin, this.this$0.jdField_a_of_type_Alcn.e.bIZ, -1, 5, this.this$0.jdField_a_of_type_Ahyh, this.hu, false);
    QidianProfileCardActivity.b(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qidian.QidianProfileCardActivity.25
 * JD-Core Version:    0.7.0.1
 */