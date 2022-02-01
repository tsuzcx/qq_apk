import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
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
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.UIThreadPool;
import com.tencent.qphone.base.util.QLog;

public class cmr
  extends CardObserver
{
  public cmr(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void a(boolean paramBoolean, Object paramObject)
  {
    if (this.a.jdField_a_of_type_AndroidOsHandler != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "get card success remove timeout msg");
      }
      this.a.jdField_a_of_type_AndroidOsHandler.removeMessages(10);
    }
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
        break label838;
      }
      EnterpriseQQManager.a(this.a.b).a(this.a.b, paramObject.uin, false);
      localObject = null;
      i = 0;
    }
    for (;;)
    {
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject = (FriendListHandler)this.a.b.a(1);
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.d == null) && (localObject != null)) {
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
            break label825;
          }
          paramObject = (Card)paramObject;
          bool1 = Utils.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.n, paramObject.encId);
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
        paramObject = (FriendListHandler)this.a.b.a(1);
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
      if ((paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentTemplateId != -1L)) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean + ",lCurrentTemplateId=-1");
      }
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.lCurrentTemplateId = 0L;
      this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard.templateRet = 0;
      paramObject = Message.obtain();
      paramObject.what = 4;
      paramObject.obj = this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqDataCard;
      paramObject.arg1 = 0;
      this.a.jdField_a_of_type_AndroidOsHandler.sendMessage(paramObject);
      return;
      label825:
      bool1 = false;
      localObject = null;
      paramObject = null;
      i = 0;
      continue;
      label838:
      localObject = null;
      i = 0;
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (!Utils.a(paramString, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString))) {}
    while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramBoolean, paramString, parammobile_sub_get_cover_rsp);
  }
  
  protected void a(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
  
  protected void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne == null) || (TextUtils.isEmpty(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (Utils.a(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!Utils.a(paramString2, this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString)) || (!Utils.a(paramString1, this.a.b.a())));
      if (!paramBoolean) {
        break;
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo, -1L);
    return;
    UIThreadPool.a(new cms(this));
  }
  
  protected void b(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString.equals(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
      }
      if (!paramBoolean) {
        this.a.a(2131562098, 1);
      }
    } while (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne, 0, paramString);
  }
  
  protected void c(boolean paramBoolean, String paramString, Card paramCard)
  {
    d(paramBoolean, paramString, paramCard);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cmr
 * JD-Core Version:    0.7.0.1
 */