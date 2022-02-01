import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.apollo.FriendCardApolloViewController;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.qcall.QCallCardInfo;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;
import com.tencent.mobileqq.widget.VoteView;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class vae
  implements Handler.Callback
{
  public vae(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    boolean bool2 = false;
    boolean bool1 = false;
    Object localObject1;
    if (paramMessage.what == 3) {
      if ((paramMessage.obj instanceof Card))
      {
        localObject1 = (Card)paramMessage.obj;
        String str = ((Card)localObject1).uin;
        localObject2 = localObject1;
        localObject1 = str;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.FrdProfileCard", 2, "MSG_SWITCH_TO_FRIEND, uin = " + (String)localObject1 + ", obj: " + paramMessage.obj + "");
      }
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        this.this$0.a(localObject2, (String)localObject1);
      }
      label325:
      label376:
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          do
                          {
                            do
                            {
                              do
                              {
                                do
                                {
                                  do
                                  {
                                    int i;
                                    do
                                    {
                                      return true;
                                      if (!(paramMessage.obj instanceof String)) {
                                        break label1407;
                                      }
                                      localObject1 = (String)paramMessage.obj;
                                      break;
                                      if (paramMessage.what != 5) {
                                        break label427;
                                      }
                                      if (this.this$0.d.isAnimating())
                                      {
                                        this.this$0.c.addLast(Message.obtain(paramMessage));
                                        return true;
                                      }
                                      if (paramMessage.arg1 != 1) {
                                        break label325;
                                      }
                                      bool1 = true;
                                      i = paramMessage.arg2;
                                    } while (!(paramMessage.obj instanceof Card));
                                    localObject1 = (Card)paramMessage.obj;
                                    this.this$0.jdField_a_of_type_Alcn.d = ((Card)localObject1);
                                    if (QLog.isColorLevel()) {
                                      QLog.d("Q.profilecard.FrdProfileCard", 2, "UI_MSG_UPDATE_CARD: isNegRet = " + bool1 + " msgSource = " + i);
                                    }
                                    this.this$0.a((Card)localObject1, bool1);
                                    if (i == 1) {
                                      this.this$0.jdField_a_of_type_Aqmv.dn("updateCardByDbEnd", false);
                                    }
                                    for (;;)
                                    {
                                      if ((paramMessage.arg2 != 12) && (paramMessage.arg2 != 11)) {
                                        break label376;
                                      }
                                      this.this$0.bOK();
                                      return true;
                                      bool1 = false;
                                      break;
                                      if ((i == 7) || (i == 8) || (paramMessage.arg2 == 12) || (paramMessage.arg2 == 11)) {
                                        this.this$0.jdField_a_of_type_Aqmv.dn("updateCardBySSOEnd", false);
                                      }
                                    }
                                    if (paramMessage.arg2 == 17)
                                    {
                                      this.this$0.bOL();
                                      return true;
                                    }
                                  } while (paramMessage.arg2 != 18);
                                  this.this$0.qC = false;
                                  this.this$0.a(this.this$0.jdField_a_of_type_Alcn);
                                  return true;
                                  if (paramMessage.what != 4) {
                                    break label485;
                                  }
                                  if (paramMessage.arg1 == 1) {
                                    bool1 = true;
                                  }
                                } while (!(paramMessage.obj instanceof ContactCard));
                                paramMessage = (ContactCard)paramMessage.obj;
                                this.this$0.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqDataContactCard = paramMessage;
                                this.this$0.a(paramMessage, bool1);
                                return true;
                                if (paramMessage.what != 6) {
                                  break label547;
                                }
                                bool1 = bool2;
                                if (paramMessage.arg1 == 1) {
                                  bool1 = true;
                                }
                              } while (!(paramMessage.obj instanceof QCallCardInfo));
                              paramMessage = (QCallCardInfo)paramMessage.obj;
                              this.this$0.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo = paramMessage;
                              this.this$0.a(paramMessage, bool1);
                              return true;
                              if (paramMessage.what != 10) {
                                break label724;
                              }
                              if (this.this$0.jdField_a_of_type_Alcn.d != null)
                              {
                                if (QLog.isColorLevel()) {
                                  QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
                                }
                                this.this$0.jdField_a_of_type_Alcn.cwb = true;
                                this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId = alcs.agc;
                                this.this$0.jdField_a_of_type_Alcn.d.templateRet = 0;
                                this.this$0.jdField_a_of_type_Alcn.b = null;
                                this.this$0.a(this.this$0.jdField_a_of_type_Alcn.d, false);
                                return true;
                              }
                            } while (this.this$0.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo == null);
                            if (QLog.isColorLevel()) {
                              QLog.i("Q.profilecard.FrdProfileCard", 2, "initHeaderView timeout");
                            }
                            this.this$0.jdField_a_of_type_Alcn.cwb = true;
                            this.this$0.jdField_a_of_type_Alcn.b = null;
                            this.this$0.a(this.this$0.jdField_a_of_type_Alcn.jdField_a_of_type_ComTencentMobileqqQcallQCallCardInfo, false);
                            return true;
                            if (paramMessage.what != 13) {
                              break label856;
                            }
                            if (!((Boolean)paramMessage.obj).booleanValue()) {
                              break label838;
                            }
                            paramMessage = new ProfileActivity.AllInOne(this.this$0.app.getCurrentAccountUin(), 0);
                            paramMessage.nickname = this.this$0.app.getCurrentNickname();
                            paramMessage.bIZ = 1;
                            paramMessage.bJa = 5;
                          } while ((this.this$0.jdField_a_of_type_Alcn == null) || (this.this$0.jdField_a_of_type_Alcn.e.uin.equals(this.this$0.app.getCurrentAccountUin())));
                          ProfileActivity.a(this.this$0, paramMessage);
                          return true;
                          Toast.makeText(this.this$0.getApplicationContext(), 2131697314, 0).show();
                          return true;
                          if (paramMessage.what != 12) {
                            break label1089;
                          }
                        } while ((this.this$0.jdField_a_of_type_Alcn.d == null) || ((alcs.agi != this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId) && (alcs.agk != this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId)) || (!(paramMessage.obj instanceof Bitmap)));
                        paramMessage = (Bitmap)paramMessage.obj;
                        localObject1 = (FrameLayout)this.this$0.findViewById(16908290);
                      } while ((localObject1 == null) || (((FrameLayout)localObject1).getChildCount() <= 0));
                      localObject1 = ((FrameLayout)localObject1).getChildAt(0);
                    } while (localObject1 == null);
                    paramMessage = new BitmapDrawable(this.this$0.getResources(), paramMessage);
                    paramMessage.setAlpha(0);
                    ((View)localObject1).setBackgroundDrawable(paramMessage);
                  } while (this.this$0.jdField_a_of_type_Alcn.d.lCurrentStyleId != alcs.agk);
                  if (QLog.isColorLevel()) {
                    QLog.i("setShoppingBgBlur", 2, "setShoppingBgBlur");
                  }
                } while (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo == null);
                new ArrayList();
              } while (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileProfileShoppingPhotoInfo.getPhotoFromRawData().size() <= 0);
              this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.setShoppingBgBlur(true);
              return true;
              if (paramMessage.what != 100) {
                break label1127;
              }
            } while (FriendProfileCardActivity.a(this.this$0) == null);
            FriendProfileCardActivity.a(this.this$0).c(this.this$0.jdField_a_of_type_Alcn);
            return true;
            if (paramMessage.what != 14) {
              break label1257;
            }
            if (this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null) {
              break label1200;
            }
            paramMessage = (View)this.this$0.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.mt.get("map_key_like");
            if ((paramMessage instanceof VoteView))
            {
              ((VoteView)paramMessage).TT(true);
              return true;
            }
          } while (!(paramMessage instanceof VoteViewV2));
          ((VoteViewV2)paramMessage).TT(true);
          return true;
        } while (paramMessage.arg1 <= 0);
        localObject1 = this.this$0.b.obtainMessage();
        ((Message)localObject1).what = paramMessage.what;
        ((Message)localObject1).arg1 = (paramMessage.arg1 - 1);
        this.this$0.b.sendMessageDelayed((Message)localObject1, 1000L);
        return true;
        if (paramMessage.what == 102)
        {
          FriendProfileCardActivity.a(this.this$0, paramMessage);
          return true;
        }
        if (paramMessage.what == 103)
        {
          this.this$0.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.c(this.this$0.jdField_a_of_type_Alcn, true, new String[] { "map_key_medal" });
          return true;
        }
      } while (paramMessage.what != 104);
      label427:
      label485:
      label1127:
      label1257:
      paramMessage = (BusinessInfoCheckUpdate.RedTypeInfo)paramMessage.obj;
      label547:
      label724:
      label856:
      if (this.this$0.n == null)
      {
        localObject1 = FriendProfileCardActivity.a(this.this$0, this.this$0.er, 5, 0, 5, 0);
        this.this$0.n = new RedTouch(this.this$0, (View)localObject1).a(53).d(5).a();
      }
      label838:
      this.this$0.n.c(paramMessage);
      label1089:
      return true;
      label1200:
      label1407:
      localObject1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vae
 * JD-Core Version:    0.7.0.1
 */