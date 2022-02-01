import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.12.1;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.12.2;
import com.tencent.mobileqq.activity.FriendProfileCardActivity.12.3;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileBaseView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class uyp
  extends accn
{
  public uyp(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    Object localObject2 = null;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "onCardDownload() isSuccess = " + paramBoolean);
    }
    if ((this.this$0.jdField_a_of_type_Alcn.e == null) || (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.uin))) {
      return;
    }
    Object localObject1 = aurh.b;
    if ((localObject1 != null) && (((aurh)localObject1).aJB())) {
      ((aurh)localObject1).aaZ(6);
    }
    if ((jqs.c(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin)) || (asgx.ag(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin)))
    {
      jqs.a(this.this$0, null, this.this$0.jdField_a_of_type_Alcn.e.uin, false, -1, true, -1);
      this.this$0.finish();
    }
    boolean bool2 = ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e);
    boolean bool1 = bool2;
    if (this.this$0.jdField_a_of_type_Alcn.e.pa == 41) {
      if (!TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.uin))
      {
        bool1 = bool2;
        if (!this.this$0.jdField_a_of_type_Alcn.e.uin.equals("0")) {}
      }
      else
      {
        bool1 = false;
      }
    }
    if (((paramObject instanceof Card)) && (bool1))
    {
      Card localCard = (Card)paramObject;
      bool2 = aqft.equalsWithNullCheck(this.this$0.jdField_a_of_type_Alcn.e.uin, localCard.uin);
      bool1 = bool2;
      localObject1 = localObject2;
      paramObject = localCard;
      if ((localCard.lUserFlag & 1L) != 0L)
      {
        afrx.a(this.this$0.app).i(this.this$0.app, localCard.uin, false);
        paramObject = localCard;
        localObject1 = localObject2;
        bool1 = bool2;
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_Aqmv.X("initCardBySSOEnd", "initCardBySSOStart", false);
      if ((bool1) && (paramObject != null) && (paramBoolean))
      {
        localObject1 = (FriendListHandler)this.this$0.app.getBusinessHandler(1);
        if ((this.this$0.jdField_a_of_type_Alcn.e.discussUin == null) && (localObject1 != null))
        {
          if (ProfileActivity.AllInOne.g(this.this$0.jdField_a_of_type_Alcn.e)) {
            ((FriendListHandler)localObject1).DH(this.this$0.jdField_a_of_type_Alcn.e.uin);
          }
          label454:
          if (this.this$0.f != null)
          {
            localObject1 = this.this$0.f.obtainMessage();
            ((Message)localObject1).what = 8;
            ((Message)localObject1).obj = paramObject;
            this.this$0.f.sendMessage((Message)localObject1);
          }
        }
      }
      for (;;)
      {
        this.this$0.b.removeMessages(100);
        this.this$0.b.sendEmptyMessageDelayed(100, 100L);
        return;
        if (((paramObject instanceof ContactCard)) && (!bool1))
        {
          localObject1 = (ContactCard)paramObject;
          bool1 = aqft.equalsWithNullCheck(((ContactCard)localObject1).mobileNo, this.this$0.he(FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e)));
          this.this$0.jdField_a_of_type_Alcn.e.uin = ((ContactCard)localObject1).mobileNo;
          paramObject = this.this$0.jdField_a_of_type_Alcn.e;
          if ((paramObject != null) && (paramObject.pr != null) && (paramObject.pr.size() > 0)) {
            ((ProfileActivity.CardContactInfo)paramObject.pr.get(0)).phoneNumber = ((ContactCard)localObject1).mobileNo;
          }
          paramObject = null;
          break;
        }
        if ((paramObject instanceof String))
        {
          paramObject = (String)paramObject;
          if (bool1) {}
          for (bool1 = aqft.equalsWithNullCheck(paramObject, this.this$0.jdField_a_of_type_Alcn.e.uin);; bool1 = aqft.equalsWithNullCheck(paramObject, FriendProfileCardActivity.a(this.this$0.jdField_a_of_type_Alcn.e)))
          {
            paramObject = null;
            localObject1 = localObject2;
            break;
          }
        }
        if ((!(paramObject instanceof Card)) || (bool1)) {
          break label1265;
        }
        paramObject = (Card)paramObject;
        bool1 = aqft.equalsWithNullCheck(this.this$0.jdField_a_of_type_Alcn.e.encId, paramObject.encId);
        this.this$0.jdField_a_of_type_Alcn.e.uin = paramObject.uin;
        this.this$0.aWo = true;
        localObject1 = localObject2;
        break;
        if (localObject1 == null) {
          break label454;
        }
        ((FriendListHandler)localObject1).DH(this.this$0.jdField_a_of_type_Alcn.e.uin);
        break label454;
        if ((bool1) && (localObject1 != null) && (paramBoolean))
        {
          paramObject = (FriendListHandler)this.this$0.app.getBusinessHandler(1);
          if ((paramObject != null) && (!TextUtils.isEmpty(((ContactCard)localObject1).mobileNo))) {
            paramObject.DJ(((ContactCard)localObject1).mobileNo);
          }
          this.this$0.jdField_a_of_type_Alcn.e.bindQQ = ((ContactCard)localObject1).bindQQ;
          if (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.contactName)) {
            this.this$0.jdField_a_of_type_Alcn.e.contactName = this.this$0.jdField_a_of_type_Alcn.e.nickname;
          }
          if (!TextUtils.isEmpty(((ContactCard)localObject1).nickName)) {
            this.this$0.jdField_a_of_type_Alcn.e.nickname = ((ContactCard)localObject1).nickName;
          }
          paramObject = (acff)this.this$0.app.getManager(51);
          if (!TextUtils.isEmpty(((ContactCard)localObject1).uin))
          {
            paramObject = paramObject.a(((ContactCard)localObject1).uin);
            if (paramObject != null) {
              this.this$0.jdField_a_of_type_Alcn.e.remark = paramObject.remark;
            }
          }
          this.this$0.jdField_a_of_type_Alcn.a = ((ContactCard)localObject1);
          if (QLog.isColorLevel()) {
            QLog.d("ContactCard", 2, "contactCard .bindQQ = " + ((ContactCard)localObject1).bindQQ + " contactCard.uin  = " + ((ContactCard)localObject1).uin);
          }
          paramObject = Message.obtain();
          paramObject.what = 4;
          paramObject.obj = localObject1;
          paramObject.arg1 = 1;
          this.this$0.b.sendMessage(paramObject);
        }
        else if ((!paramBoolean) && (this.this$0.jdField_a_of_type_Alcn.d != null) && (this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId == -1L))
        {
          QLog.e("Q.profilecard.FrdProfileCard", 1, "onCardDownload isSuccess = " + paramBoolean + ",lCurrentStyleId=-1");
          this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId = alcs.agc;
          this.this$0.jdField_a_of_type_Alcn.d.templateRet = 0;
          if (this.this$0.f != null)
          {
            paramObject = this.this$0.f.obtainMessage();
            paramObject.what = 8;
            paramObject.obj = this.this$0.jdField_a_of_type_Alcn.d;
            this.this$0.f.sendMessage(paramObject);
          }
        }
      }
      label1265:
      bool1 = false;
      paramObject = null;
      localObject1 = localObject2;
    }
  }
  
  protected void onDelQZonePhotoWall(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      this.this$0.ci(acfp.m(2131706615), 2);
    }
    for (;;)
    {
      ((CardHandler)this.this$0.app.getBusinessHandler(2)).eD(this.this$0.jdField_a_of_type_Alcn.e.uin, "");
      return;
      this.this$0.ci(acfp.m(2131706604), 1);
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    simpleUpdate(paramBoolean, paramString, paramCard);
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(paramCard.uin)) && (this.this$0.f != null))
    {
      paramString = this.this$0.f.obtainMessage();
      paramString.what = 8;
      paramString.obj = paramCard;
      this.this$0.f.sendMessage(paramString);
    }
  }
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    this.this$0.xn(false);
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "onGetQZonePhotoWall isSuc:" + paramBoolean + " uin:" + paramString2);
    }
    if (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(paramString2))
    {
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(paramBoolean, paramString2, parammobile_sub_get_photo_wall_rsp);
      }
      if (this.this$0.jdField_a_of_type_Argj != null) {
        this.this$0.jdField_a_of_type_Argj.b(paramBoolean, paramString1, parammobile_sub_get_photo_wall_rsp);
      }
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView != null) {
        this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.eiz();
      }
    }
  }
  
  protected void onGetShoppingInfo(boolean paramBoolean, String paramString, List<alde> paramList, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "shopName=" + paramString + ",accountFlag=" + paramInt1 + "follow_type=" + paramInt2 + ",certifiedGrade:" + paramInt3);
    }
    if (paramBoolean)
    {
      this.this$0.bdV = paramInt1;
      this.this$0.mFollowType = paramInt2;
      this.this$0.aNg = paramString;
      if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.i(paramString, paramInt3, paramList);
        if (paramList.size() != 0) {
          this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
        }
      }
    }
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
  
  protected void onMedalChange(boolean paramBoolean, Card paramCard)
  {
    Locale localLocale;
    Object localObject1;
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      localLocale = Locale.getDefault();
      if (paramCard != null) {
        break label146;
      }
      localObject1 = "null";
      if (paramCard != null) {
        break label157;
      }
      localObject2 = "null";
      label28:
      if (paramCard != null) {
        break label169;
      }
    }
    label146:
    label157:
    label169:
    for (Object localObject3 = "null";; localObject3 = Integer.valueOf(paramCard.iUpgradeCount))
    {
      QLog.i("MedalWallMng", 4, String.format(localLocale, "onMedalChange isSuc: %s, iMedalCount: %s, iNewCount: %s, iUpgradeCount:%s", new Object[] { Boolean.valueOf(paramBoolean), localObject1, localObject2, localObject3 }));
      if ((paramCard != null) && (this.this$0.jdField_a_of_type_Alcn != null) && (this.this$0.jdField_a_of_type_Alcn.d != null) && (aqft.equalsWithNullCheck(paramCard.uin, this.this$0.jdField_a_of_type_Alcn.d.uin)))
      {
        this.this$0.jdField_a_of_type_Alcn.d = paramCard;
        this.this$0.bOq();
      }
      return;
      localObject1 = Integer.valueOf(paramCard.iMedalCount);
      break;
      localObject2 = Integer.valueOf(paramCard.iNewCount);
      break label28;
    }
  }
  
  protected void onPraiseLifeAchievement(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, String.format("onPraiseLifeAchievement isSuccess:%s,actionType:%s,achivementId:%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    aled localaled;
    if (!paramBoolean)
    {
      Iterator localIterator = this.this$0.jdField_a_of_type_Alcn.d.lifeAchivementList.iterator();
      while (localIterator.hasNext())
      {
        localaled = (aled)localIterator.next();
        if (localaled.id == paramInt2)
        {
          if (paramInt1 != 1) {
            break label168;
          }
          localaled.dsC -= 1;
          localaled.hasPraised = false;
        }
      }
    }
    for (;;)
    {
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.post(new FriendProfileCardActivity.12.3(this));
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.this$0.jdField_a_of_type_Alcn, true, new String[] { "map_key_life_achievement" });
      return;
      label168:
      if (paramInt1 == 2)
      {
        localaled.dsC += 1;
        localaled.hasPraised = true;
      }
    }
  }
  
  protected void onReqFavoriteResult(boolean paramBoolean, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    if ((this.this$0.jdField_a_of_type_Alcn.e == null) || (TextUtils.isEmpty(this.this$0.jdField_a_of_type_Alcn.e.uin)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString1)) || (aqft.equalsWithNullCheck(paramString2, paramString1))) {}
    do
    {
      do
      {
        return;
      } while ((!aqft.equalsWithNullCheck(paramString2, this.this$0.jdField_a_of_type_Alcn.e.uin)) || (!aqft.equalsWithNullCheck(paramString1, this.this$0.app.getCurrentAccountUin())));
      if (!paramBoolean) {
        break;
      }
      if ((paramInt2 == 1) && (this.this$0.jdField_a_of_type_Alcn.d != null))
      {
        paramString1 = this.this$0.jdField_a_of_type_Alcn.d;
        paramString1.lVoteCount += paramInt1;
        this.this$0.jdField_a_of_type_Alcn.d.bVoted = 1;
        paramString1 = this.this$0.jdField_a_of_type_Alcn.d;
        paramString1.bAvailVoteCnt = ((short)(paramString1.bAvailVoteCnt - paramInt1));
        if (this.this$0.jdField_a_of_type_Alcn.d.bAvailVoteCnt < 0) {
          this.this$0.jdField_a_of_type_Alcn.d.bAvailVoteCnt = 0;
        }
      }
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.this$0.jdField_a_of_type_Alcn, -1L, false);
    return;
    aqna.ap(new FriendProfileCardActivity.12.1(this));
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if (!this.this$0.jdField_a_of_type_Alcn.e.uin.equals(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "onUpdateAvatar " + paramBoolean);
      }
      if (!paramBoolean) {
        this.this$0.cf(2131718799, 1);
      }
    } while (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null);
    this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(this.this$0.jdField_a_of_type_Alcn.e);
  }
  
  protected void onUploadQZonePhotoWall(boolean paramBoolean, Object paramObject)
  {
    if (this.this$0.jdField_a_of_type_Vbv != null) {
      this.this$0.jdField_a_of_type_Vbv.bPr();
    }
    if (paramBoolean) {
      this.this$0.ci(acfp.m(2131706598), 0);
    }
    CardHandler localCardHandler;
    for (;;)
    {
      localCardHandler = (CardHandler)this.this$0.app.getBusinessHandler(2);
      if (paramBoolean) {
        break;
      }
      paramObject = (String)((Object[])(Object[])paramObject)[0];
      this.this$0.runOnUiThread(new FriendProfileCardActivity.12.2(this, localCardHandler, paramObject));
      return;
      this.this$0.ci(acfp.m(2131706624), 1);
    }
    localCardHandler.eD(this.this$0.jdField_a_of_type_Alcn.e.uin, "");
  }
  
  protected void reqShoppingInfo(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (this.this$0.jdField_a_of_type_Alcn == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (QLog.isColorLevel()) {
            QLog.d("FriendProfileCardActivity", 2, "shoppingNo=" + paramString1 + "seq=" + paramInt);
          }
        } while ((!paramBoolean) || (!this.this$0.jdField_a_of_type_Alcn.e.uin.equals(paramString2)));
        if (!"0".equals(paramString1)) {
          break;
        }
        paramString1 = this.this$0.getSharedPreferences("is_binding_shop", 0).edit();
        paramString1.putBoolean(this.this$0.aNh, false);
        paramString1.commit();
      } while ((this.this$0.jdField_a_of_type_Alcn.d == null) || (this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agk));
      this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.e = null;
      this.this$0.jdField_a_of_type_Alcn.b = null;
      this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView = new ProfileBaseView(this.this$0, this.this$0.jdField_a_of_type_Alcn, this.this$0.jdField_a_of_type_ComTencentWidgetPullToZoomHeaderListView, this.this$0.Dq, FriendProfileCardActivity.a(this.this$0));
      this.this$0.a(this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView, 0L, 0L);
    } while (this.this$0.isFinishing());
    this.this$0.bOK();
    this.this$0.xl(true);
    return;
    paramString2 = ProfileShoppingPhotoInfo.getPhotoInfo(this.this$0.app, this.this$0.jdField_a_of_type_Alcn.e.uin);
    if (paramString2 != null)
    {
      this.this$0.mFollowType = paramString2.followType;
      this.this$0.aNf = paramString2.bindShoppingNo;
    }
    paramString2 = (CardHandler)this.this$0.app.getBusinessHandler(2);
    if (paramString2 != null)
    {
      this.this$0.aNf = paramString1;
      paramString2.D(paramInt, paramString1, this.this$0.jdField_a_of_type_Alcn.e.uin);
    }
    paramString1 = this.this$0.getSharedPreferences("is_binding_shop", 0).edit();
    paramString1.putBoolean(this.this$0.aNh, true);
    paramString1.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uyp
 * JD-Core Version:    0.7.0.1
 */