import android.os.Handler.Callback;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.CoverCacheData;

public class vaf
  implements Handler.Callback
{
  public vaf(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject3 = (acff)this.this$0.app.getManager(51);
    Object localObject4;
    Object localObject1;
    switch (paramMessage.what)
    {
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    default: 
    case 1: 
    case 2: 
      for (;;)
      {
        return true;
        localObject4 = aurh.b;
        if ((localObject4 != null) && (((aurh)localObject4).aJB()))
        {
          ((aurh)localObject4).aaZ(4);
          ((aurh)localObject4).aaY(5);
          ((aurh)localObject4).aaY(8);
        }
        paramMessage = (String)paramMessage.obj;
        this.this$0.jdField_a_of_type_Aqmv.dn("initCardByDbStart", true);
        localObject1 = aqep.a(this.this$0.app, paramMessage);
        this.this$0.jdField_a_of_type_Aqmv.X("initCardByDbEnd", "initCardByDbStart", false);
        if ((localObject1 != null) && (localObject3 != null))
        {
          if ((((acff)localObject3).isFriend(((Card)localObject1).uin)) && (!this.this$0.jdField_a_of_type_Alcn.e.uin.equals(this.this$0.app.getCurrentAccountUin())) && (!ProfileActivity.AllInOne.b(this.this$0.jdField_a_of_type_Alcn.e))) {
            this.this$0.jdField_a_of_type_Alcn.e.pa = 1;
          }
          this.this$0.jdField_a_of_type_Alcn.d = ((Card)localObject1);
          if ((localObject4 != null) && (((aurh)localObject4).aJB()))
          {
            ((aurh)localObject4).aaZ(5);
            ((aurh)localObject4).aaY(6);
            ((aurh)localObject4).aaY(9);
          }
          this.this$0.a((Card)localObject1, false, 1);
          this.this$0.jdField_a_of_type_Aqmv.dn("initCardBySSOStart", true);
          localObject3 = ((Card)localObject1).vSeed;
          paramMessage = null;
          if ((this.this$0.jdField_a_of_type_Alcn.e.pa == 56) || (this.this$0.jdField_a_of_type_Alcn.e.pa == 57))
          {
            paramMessage = this.this$0.jdField_a_of_type_Alcn.e.cf;
            this.this$0.a(((Card)localObject1).feedPreviewTime, (byte[])localObject3, paramMessage, false);
            FriendProfileCardActivity.e(this.this$0);
            if (!this.this$0.jdField_a_of_type_Alcn.cwc) {
              continue;
            }
            paramMessage = this.this$0.app.getCurrentAccountUin();
            localObject3 = new StringBuilder().append("");
            if (this.this$0.jdField_a_of_type_Alcn.e.pa != 0) {
              break label618;
            }
            i = 1;
            localObject3 = i;
            localObject4 = new StringBuilder().append("");
            if (((Card)localObject1).lCurrentStyleId <= 0L) {
              break label623;
            }
          }
          for (int i = 2;; i = 1)
          {
            VasWebviewUtil.reportCommercialDrainage(paramMessage, "group_card", "show", "", 0, 0, 0, "", "", (String)localObject3, i, "", "", "", 0, 0, 0, 0);
            break;
            if ((this.this$0.jdField_a_of_type_Alcn.e.pa != 35) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 37) && (this.this$0.jdField_a_of_type_Alcn.e.pa != 36)) {
              break label392;
            }
            paramMessage = this.this$0.jdField_a_of_type_Alcn.e.cf;
            break label392;
            i = 2;
            break label470;
          }
          localObject1 = this.this$0.he(FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e));
          if ((localObject3 != null) && (localObject1 != null) && (((String)localObject1).length() > 0))
          {
            paramMessage = aurh.b;
            if ((paramMessage != null) && (paramMessage.aJB()))
            {
              paramMessage.aaZ(4);
              paramMessage.aaY(8);
              paramMessage.aaY(5);
            }
            localObject1 = ((acff)localObject3).b((String)localObject1);
            localObject4 = FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e);
            if (localObject4 != null)
            {
              ((ContactCard)localObject1).nationCode = ((ProfileActivity.CardContactInfo)localObject4).aOM;
              ((ContactCard)localObject1).mobileCode = ((ProfileActivity.CardContactInfo)localObject4).phoneNumber;
              ((ContactCard)localObject1).strContactName = ((ProfileActivity.CardContactInfo)localObject4).aOL;
            }
            if ((((ContactCard)localObject1).nickName == null) || (((ContactCard)localObject1).nickName.length() == 0)) {
              ((ContactCard)localObject1).nickName = this.this$0.jdField_a_of_type_Alcn.e.nickname;
            }
            ((acff)localObject3).a((ContactCard)localObject1);
            this.this$0.jdField_a_of_type_Alcn.e.bindQQ = ((ContactCard)localObject1).bindQQ;
            if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
            {
              localObject3 = ((acff)localObject3).e(((ContactCard)localObject1).uin);
              if (localObject3 != null) {
                this.this$0.jdField_a_of_type_Alcn.e.remark = ((Friends)localObject3).remark;
              }
            }
            this.this$0.a((ContactCard)localObject1, false);
            FriendProfileCardActivity.b(this.this$0.jdField_a_of_type_Alcn);
            localObject3 = Message.obtain();
            ((Message)localObject3).what = 4;
            ((Message)localObject3).obj = localObject1;
            ((Message)localObject3).arg1 = 0;
            this.this$0.b.sendMessage((Message)localObject3);
            if ((paramMessage != null) && (paramMessage.aJB()))
            {
              paramMessage.aaZ(5);
              paramMessage.aaY(6);
              paramMessage.aaY(9);
              paramMessage.aaY(7);
              paramMessage.aaZ(7);
            }
            this.this$0.a(0L, null, null, false);
          }
        }
      }
    case 9: 
      label392:
      label470:
      label618:
      label623:
      localObject1 = (alkf)this.this$0.app.getManager(140);
      if (localObject1 != null)
      {
        paramMessage = ((alkf)localObject1).a(this.this$0.jdField_a_of_type_Alcn.e.uin);
        if (paramMessage != null) {
          this.this$0.jdField_a_of_type_Alcn.a = paramMessage;
        }
        ((alkf)localObject1).a(paramMessage);
      }
      break;
    }
    for (;;)
    {
      for (;;)
      {
        localObject1 = Message.obtain();
        ((Message)localObject1).what = 6;
        ((Message)localObject1).obj = paramMessage;
        ((Message)localObject1).arg1 = 0;
        this.this$0.b.sendMessage((Message)localObject1);
        break;
        try
        {
          if ((paramMessage.arg1 == 0) && (this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d != null) && (!alcs.cy(this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId))) {
            this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId = alcs.agc;
          }
          if (paramMessage.arg2 == 1) {
            this.this$0.a(this.this$0.jdField_a_of_type_Alcn.d, true, 13);
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("FriendProfileCardActivity", 1, "handle SUBTHREAD_MSG_DOWNLOAD_RES fail.", localException);
          }
          this.this$0.a(this.this$0.jdField_a_of_type_Alcn.d, false, 7);
        }
      }
      break;
      if ((paramMessage.obj instanceof Card))
      {
        this.this$0.a((Card)paramMessage.obj, true, 8);
        break;
      }
      this.this$0.a(this.this$0.jdField_a_of_type_Alcn.d, true, 8);
      break;
      localObject3 = (CoverCacheData)paramMessage.obj;
      localObject4 = this.this$0.app.a().createEntityManager();
      if (localObject4 == null)
      {
        paramMessage = null;
        label1274:
        localObject2 = paramMessage;
        if (paramMessage == null)
        {
          localObject2 = new QZoneCover();
          ((QZoneCover)localObject2).uin = Long.toString(((CoverCacheData)localObject3).uin);
        }
        ((QZoneCover)localObject2).updateQzoneCover((CoverCacheData)localObject3);
        if (((QZoneCover)localObject2).getStatus() != 1000) {
          break label1353;
        }
        ((EntityManager)localObject4).persist((Entity)localObject2);
      }
      for (;;)
      {
        ((EntityManager)localObject4).close();
        break;
        paramMessage = (QZoneCover)((EntityManager)localObject4).find(QZoneCover.class, Long.toString(((CoverCacheData)localObject3).uin));
        break label1274;
        label1353:
        ((EntityManager)localObject4).update((Entity)localObject2);
      }
      if ((this.this$0.app == null) || (localObject3 == null)) {
        break;
      }
      paramMessage = ((acff)localObject3).b(this.this$0.app.getCurrentAccountUin());
      if (paramMessage == null) {
        break;
      }
      this.this$0.a(paramMessage.feedPreviewTime, paramMessage.vSeed, null, false);
      break;
      Object localObject2 = this.this$0.app.a().createEntityManager();
      ((EntityManager)localObject2).update((Card)paramMessage.obj);
      ((EntityManager)localObject2).close();
      break;
      localObject2 = this.this$0.app.a().createEntityManager();
      ((EntityManager)localObject2).persist((Card)paramMessage.obj);
      ((EntityManager)localObject2).close();
      break;
      this.this$0.bOS();
      break;
      ((albz)this.this$0.app.getBusinessHandler(112)).fy(this.this$0.jdField_a_of_type_Alcn.e.uin, 0);
      break;
      paramMessage = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vaf
 * JD-Core Version:    0.7.0.1
 */