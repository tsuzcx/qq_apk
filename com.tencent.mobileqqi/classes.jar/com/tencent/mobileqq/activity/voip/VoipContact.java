package com.tencent.mobileqq.activity.voip;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class VoipContact
  extends Entity
  implements Cloneable
{
  public static final int QQIVOIP_RELATION_BINDED_CONTACT_AND_QQFRIEND = 0;
  public static final int QQIVOIP_RELATION_BINDED_CONTACT_AND_QQSTRANGER = 2;
  public static final int QQIVOIP_RELATION_BINDED_QQFRIEND = 1;
  public static final int QQIVOIP_RELATION_BINDED_QQSTRANGER = 3;
  public static final int QQIVOIP_RELATION_UNBINDED_CONTACT = 6;
  public static final int QQIVOIP_RELATION_UNBINDED_QQFRIEND = 4;
  public static final int QQIVOIP_RELATION_UNBINDED_QQSTRANGER = 5;
  public static final int QQIVOIP_RELATION_UNBINDED_STRANGER = 7;
  public PhoneContact contact = null;
  public int contactId = -1;
  private FriendManager friendMgr;
  public boolean isbinded = false;
  public String lookupID = null;
  private PhoneContactManager mgr;
  public VoipPhoneNumber phoneNumber = null;
  public int relationship = -1;
  public String uin = null;
  
  public VoipContact(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    if ((paramString1 != null) && (paramString1.equals(""))) {
      paramString1 = null;
    }
    for (;;)
    {
      String str = paramString3;
      if (paramString3 != null)
      {
        str = paramString3;
        if (paramString3.equals("")) {
          str = null;
        }
      }
      this.mgr = ((PhoneContactManager)paramQQAppInterface.getManager(10));
      this.friendMgr = ((FriendManager)paramQQAppInterface.getManager(8));
      if ((paramString1 == null) && (paramString2 == null) && (str == null)) {
        break;
      }
      if ((paramString1 == null) && (paramString2 == null) && (str != null))
      {
        this.contact = this.mgr.c(str);
        if (str != null) {
          this.phoneNumber = new VoipPhoneNumber(str, paramQQAppInterface.a().getApplicationContext());
        }
        if (this.contact == null) {
          break label602;
        }
        this.lookupID = this.contact.lookupID;
        this.contactId = this.contact.contactID;
        if (this.contact.uin != null)
        {
          if (!this.contact.uin.equals("0")) {
            break label588;
          }
          if (paramString1 != null) {
            break label585;
          }
          paramString1 = this.contact.nationCode + this.contact.mobileNo;
          label266:
          this.uin = paramString1;
          label271:
          this.isbinded = true;
          this.phoneNumber = new VoipPhoneNumber(this.contact.nationCode + this.contact.mobileNo, paramQQAppInterface.a().getApplicationContext());
        }
        if (this.phoneNumber == null) {
          this.phoneNumber = new VoipPhoneNumber(this.contact.mobileNo, paramQQAppInterface.a().getApplicationContext());
        }
      }
      for (;;)
      {
        getContactRelation();
        return;
        if ((paramString1 == null) && (paramString2 != null) && (str == null))
        {
          this.contact = this.mgr.a(paramString2);
          break;
        }
        if ((paramString1 == null) && (paramString2 != null) && (str != null))
        {
          this.contact = this.mgr.a(paramString2);
          if (this.contact != null) {
            break;
          }
          this.contact = this.mgr.c(str);
          break;
        }
        if ((paramString1 != null) && (paramString2 == null) && (str == null))
        {
          this.contact = this.mgr.b(paramString1);
          break;
        }
        if ((paramString1 != null) && (paramString2 == null) && (str != null))
        {
          this.contact = this.mgr.b(paramString1);
          if (this.contact != null) {
            break;
          }
          this.contact = this.mgr.c(str);
          break;
        }
        if ((paramString1 != null) && (paramString2 != null) && (str == null))
        {
          this.contact = this.mgr.a(paramString2);
          break;
        }
        if ((paramString1 == null) || (paramString2 == null) || (str == null)) {
          break;
        }
        this.contact = this.mgr.a(paramString2);
        break;
        label585:
        break label266;
        label588:
        this.uin = this.contact.uin;
        break label271;
        label602:
        this.uin = paramString1;
      }
    }
  }
  
  private void getContactRelation()
  {
    if ((this.isbinded) && (this.uin != null) && (this.contactId >= 0))
    {
      this.relationship = 2;
      if (this.friendMgr.b(this.uin)) {
        this.relationship = 0;
      }
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if ((!this.isbinded) || (this.uin == null) || (this.contactId >= 0)) {
              break;
            }
            this.relationship = 3;
          } while (!this.friendMgr.b(this.uin));
          this.relationship = 1;
          return;
          if ((this.isbinded) && (this.uin == null) && (this.contactId >= 0))
          {
            this.relationship = 2;
            return;
          }
          if ((this.isbinded) && (this.uin == null) && (this.contactId < 0))
          {
            this.relationship = 3;
            return;
          }
          if ((this.isbinded) || (this.uin == null) || (this.contactId < 0)) {
            break;
          }
          this.relationship = 6;
        } while (!this.friendMgr.b(this.uin));
        this.relationship = 4;
        return;
        if ((this.isbinded) || (this.uin == null) || (this.contactId >= 0)) {
          break;
        }
        this.relationship = 5;
      } while (!this.friendMgr.b(this.uin));
      this.relationship = 4;
      return;
      if ((!this.isbinded) && (this.uin == null) && (this.contactId >= 0))
      {
        this.relationship = 6;
        return;
      }
    } while ((this.isbinded) || (this.uin != null) || (this.contactId >= 0));
    this.relationship = 7;
  }
  
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
      QLog.d("PhoneContactManager", 2, "PhoneContact clone failed." + localCloneNotSupportedException.toString());
    }
    return this;
  }
  
  public boolean isSameContact(VoipContact paramVoipContact)
  {
    if (paramVoipContact == null) {}
    do
    {
      do
      {
        return false;
        if ((this.lookupID != null) && (paramVoipContact.lookupID != null)) {
          return this.lookupID.equals(paramVoipContact.lookupID);
        }
        if (this.contactId < 0) {
          break;
        }
      } while (this.contactId != paramVoipContact.contactId);
      return true;
      if ((this.uin != null) && (this.uin.length() > 0) && (!this.uin.equals("0")) && (paramVoipContact.uin != null)) {
        return this.uin.equals(paramVoipContact.uin);
      }
    } while (this.phoneNumber == null);
    return this.phoneNumber.a(paramVoipContact.phoneNumber);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.VoipContact
 * JD-Core Version:    0.7.0.1
 */