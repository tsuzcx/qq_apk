package com.tencent.mobileqq.activity.contact.phonecontact;

import SecurityAccountServer.RespondQueryQQBindingStat;
import com.tencent.qphone.base.util.QLog;

class PhoneContactManagerImp$16
  implements Runnable
{
  PhoneContactManagerImp$16(PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean) {}
  
  public void run()
  {
    if (PhoneContactManagerImp.a(this.this$0)) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          i = this.this$0.xy();
          if (QLog.isColorLevel())
          {
            RespondQueryQQBindingStat localRespondQueryQQBindingStat = this.this$0.a();
            QLog.d("PhoneContact.Manager", 2, String.format("checkUpdateLocalContact [%s, %s, %s]", new Object[] { Boolean.valueOf(this.this$0.boQ), Boolean.valueOf(this.boU), localRespondQueryQQBindingStat }));
          }
          if ((i != 8) && (this.this$0.Ut()))
          {
            this.this$0.clO();
            return;
          }
          if (!this.this$0.Ur()) {
            break;
          }
        } while ((!this.boU) && (!this.this$0.boQ));
        PhoneContactManagerImp.d(this.this$0);
        return;
        if ((i != 4) && (this.this$0.Us()))
        {
          this.this$0.clU();
          return;
        }
        if (i != 1) {
          break;
        }
      } while ((!this.boU) || (!this.this$0.a().noBindUploadContacts));
      PhoneContactManagerImp.a(this.this$0, true, true, 15L);
      return;
    } while ((i != 2) || ((!this.boU) && (!this.this$0.boQ)));
    PhoneContactManagerImp.e(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp.16
 * JD-Core Version:    0.7.0.1
 */