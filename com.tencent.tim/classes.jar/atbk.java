import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

class atbk
  extends accn
{
  atbk(atbj paramatbj) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((this.this$0.c.e == null) || (TextUtils.isEmpty(this.this$0.c.e.uin))) {}
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = this.this$0.mApp;
    } while (localQQAppInterface == null);
    Object localObject1 = null;
    boolean bool2 = ProfileActivity.AllInOne.g(this.this$0.c.e);
    boolean bool1 = bool2;
    if (this.this$0.c.e.pa == 41) {
      if (!TextUtils.isEmpty(this.this$0.c.e.uin))
      {
        bool1 = bool2;
        if (!this.this$0.c.e.uin.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModel", 2, "onCardDownload, success:" + paramBoolean + ", isPaHasUin=" + bool1);
    }
    Object localObject2;
    if (((paramObject instanceof Card)) && (bool1))
    {
      localObject2 = (Card)paramObject;
      bool2 = aqft.equalsWithNullCheck(this.this$0.c.e.uin, ((Card)localObject2).uin);
      localObject1 = localObject2;
      bool1 = bool2;
      if ((((Card)localObject2).lUserFlag & 1L) == 0L) {
        break label485;
      }
      afrx.a(localQQAppInterface).i(localQQAppInterface, ((Card)localObject2).uin, false);
      localObject1 = localObject2;
      bool1 = bool2;
    }
    for (;;)
    {
      if ((bool1) && (localObject1 != null) && (paramBoolean))
      {
        localObject2 = (FriendListHandler)localQQAppInterface.getBusinessHandler(1);
        if ((this.this$0.c.e.discussUin == null) && (localObject2 != null))
        {
          if (ProfileActivity.AllInOne.g(this.this$0.c.e)) {
            ((FriendListHandler)localObject2).DH(this.this$0.c.e.uin);
          }
          label332:
          if (this.this$0.f != null)
          {
            localObject2 = this.this$0.f.obtainMessage();
            ((Message)localObject2).what = 8;
            ((Message)localObject2).obj = localObject1;
            this.this$0.f.sendMessage((Message)localObject2);
          }
        }
      }
      for (;;)
      {
        if ((!paramBoolean) || (!(localObject1 instanceof Card)) || (!aqft.equalsWithNullCheck(localQQAppInterface.getCurrentAccountUin(), ((Card)localObject1).uin))) {
          break label669;
        }
        atbj.a(this.this$0, (Card)paramObject);
        atbj.a(this.this$0);
        return;
        if ((!(paramObject instanceof Card)) || (bool1)) {
          break label671;
        }
        localObject1 = (Card)paramObject;
        bool1 = aqft.equalsWithNullCheck(this.this$0.c.e.encId, ((Card)localObject1).encId);
        this.this$0.c.e.uin = ((Card)localObject1).uin;
        label485:
        break;
        if (localObject2 == null) {
          break label332;
        }
        ((FriendListHandler)localObject2).DH(this.this$0.c.e.uin);
        break label332;
        if ((!paramBoolean) && (this.this$0.c.d != null) && (this.this$0.c.d.lCurrentStyleId == -1L))
        {
          QLog.e("Q.profilecard.FrdProfileCard", 1, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
          this.this$0.c.d.lCurrentStyleId = alcs.agc;
          this.this$0.c.d.templateRet = 0;
          if (this.this$0.f != null)
          {
            localObject2 = this.this$0.f.obtainMessage();
            ((Message)localObject2).what = 8;
            ((Message)localObject2).obj = this.this$0.c.d;
            this.this$0.f.sendMessage((Message)localObject2);
          }
        }
      }
      label669:
      break;
      label671:
      bool1 = false;
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModel", 2, "onGetDetailInfo, success:" + paramBoolean + ", uin=" + paramString);
    }
    if ((paramBoolean) && (paramCard != null) && (aqft.equalsWithNullCheck(this.this$0.c.e.uin, paramCard.uin))) {
      atbj.a(this.this$0, paramCard);
    }
  }
  
  protected void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<aldd> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModel", 2, "onGetEducationList, success:" + paramBoolean + ", uin=" + paramLong);
    }
    if (paramBoolean) {
      atbj.a(this.this$0, paramArrayList);
    }
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.this$0.c.e.uin.equals(paramCard.uin)) && (this.this$0.f != null))
    {
      paramString = this.this$0.f.obtainMessage();
      paramString.what = 8;
      paramString.obj = paramCard;
      this.this$0.f.sendMessage(paramString);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("ProfileModel", 2, String.format("onSetDetailInfo success=%s resultCode=%s mDelayRemoveCardObserver=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.this$0.aWP) }));
    }
    int i;
    if (paramBoolean)
    {
      i = j;
      if (paramInt == 0) {}
    }
    else
    {
      if ((paramBoolean) || (paramInt != 34)) {
        break label146;
      }
      i = j;
    }
    atbj.a(this.this$0, paramCard);
    paramCard = this.this$0;
    if (i != 0) {}
    for (paramInt = 5;; paramInt = 4)
    {
      atbj.a(paramCard, paramInt);
      if (this.this$0.aWP)
      {
        this.this$0.mApp.removeObserver(this.this$0.jdField_a_of_type_Accn);
        this.this$0.aWP = false;
        this.this$0.jdField_a_of_type_Atbj$b = null;
      }
      return;
      label146:
      i = 0;
      break;
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if (!this.this$0.c.e.uin.equals(paramString)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
    }
    atbj.a(this.this$0, 3, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbk
 * JD-Core Version:    0.7.0.1
 */