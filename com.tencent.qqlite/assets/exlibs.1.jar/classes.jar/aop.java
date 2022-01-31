import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.enterpriseqq.EnterpriseQQManager;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.UIThreadPool;
import com.tencent.qphone.base.util.QLog;

public class aop
  extends CardObserver
{
  public aop(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {
      return;
    }
    boolean bool2 = ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
    boolean bool1 = bool2;
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 41) {
      if (!TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))
      {
        bool1 = bool2;
        if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    Object localObject;
    int i;
    if (((paramObject instanceof Card)) && (bool1))
    {
      paramObject = (Card)paramObject;
      bool1 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramObject.uin);
      if ((paramObject.lUserFlag & 1L) == 0L) {
        break label804;
      }
      EnterpriseQQManager.a(this.a.app).a(this.a.app, paramObject.uin, false);
      localObject = null;
      i = 0;
    }
    for (;;)
    {
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject = (FriendListHandler)this.a.app.a(1);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.e == null) && (localObject != null)) {
          if (ProfileActivity.AllInOne.f(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)) {
            ((FriendListHandler)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
        for (;;)
        {
          localObject = Message.obtain();
          ((Message)localObject).what = 4;
          ((Message)localObject).obj = paramObject;
          ((Message)localObject).arg1 = 1;
          ((Message)localObject).arg2 = i;
          this.a.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
          return;
          if (((paramObject instanceof ContactCard)) && (!bool1))
          {
            localObject = (ContactCard)paramObject;
            bool1 = Utils.a(((ContactCard)localObject).mobileNo, this.a.c());
            paramObject = null;
            i = 0;
            break;
          }
          if ((paramObject instanceof String))
          {
            paramObject = (String)paramObject;
            if (bool1) {}
            for (bool1 = Utils.a(paramObject, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);; bool1 = Utils.a(paramObject, this.a.c()))
            {
              localObject = null;
              paramObject = null;
              i = 0;
              break;
            }
          }
          if ((!(paramObject instanceof Card)) || (bool1)) {
            break label791;
          }
          paramObject = (Card)paramObject;
          bool1 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.o, paramObject.encId);
          this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString = paramObject.uin;
          FriendProfileCardActivity.a(this.a, true);
          localObject = null;
          i = 1;
          break;
          if (localObject != null) {
            ((FriendListHandler)localObject).b(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString);
          }
        }
      }
      if ((bool1) && (localObject != null) && (paramBoolean))
      {
        paramObject = (FriendListHandler)this.a.app.a(1);
        String str = this.a.c();
        if ((paramObject != null) && (!TextUtils.isEmpty(str))) {
          paramObject.d(str);
        }
        paramObject = Message.obtain();
        paramObject.what = 4;
        paramObject.obj = localObject;
        paramObject.arg1 = 1;
        this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
        return;
      }
      if ((paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId != -1L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentStyleId = ProfileCardTemplate.a;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
      paramObject = Message.obtain();
      paramObject.what = 4;
      paramObject.obj = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      paramObject.arg1 = 0;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
      label791:
      bool1 = false;
      localObject = null;
      paramObject = null;
      i = 0;
      continue;
      label804:
      localObject = null;
      i = 0;
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  protected void onGotFriendInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  protected void onGotGroupInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  protected void onLabelLikeSet(boolean paramBoolean, Card paramCard, long paramLong)
  {
    super.onLabelLikeSet(paramBoolean, paramCard, paramLong);
    if (QLog.isColorLevel()) {
      QLog.d("zivzhou", 2, "set the status of label = " + paramBoolean);
    }
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!Utils.a(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!Utils.a(paramString1, this.a.app.a())));
      if (!paramBoolean) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, -1L);
    return;
    UIThreadPool.a(new aoq(this));
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
      }
      if (!paramBoolean) {
        this.a.a(2131363448, 1);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, 0, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aop
 * JD-Core Version:    0.7.0.1
 */