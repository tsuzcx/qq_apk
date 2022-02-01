import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity;
import com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.a;
import com.tencent.mobileqq.activity.contact.addcontact.SearchBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class vbj
  extends accn
{
  public vbj(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && ((paramObject instanceof Card)) && (aqft.equalsWithNullCheck(this.this$0.app.getCurrentAccountUin(), ((Card)paramObject).uin)))
    {
      FriendProfileMoreInfoActivity.a(this.this$0, (Card)paramObject, true);
      if (!this.this$0.aXb)
      {
        paramObject = (adyp)this.this$0.app.getManager(112);
        FriendProfileMoreInfoActivity.a(this.this$0, paramObject.cN());
      }
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (aqft.equalsWithNullCheck(this.this$0.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.this$0, paramCard, true);
    }
  }
  
  protected void onGetEducationList(boolean paramBoolean, long paramLong, ArrayList<aldd> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onGetEducationList, success:" + paramBoolean + ", uin=" + paramLong);
    }
    if (paramBoolean) {
      FriendProfileMoreInfoActivity.a(this.this$0, paramArrayList);
    }
  }
  
  protected void onGetLocationDescription(boolean paramBoolean, String paramString, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (aqft.equalsWithNullCheck(this.this$0.app.getCurrentAccountUin(), paramCard.uin))) {
      FriendProfileMoreInfoActivity.a(this.this$0, paramCard, true);
    }
  }
  
  protected void onGetQZonePhotoWall(boolean paramBoolean, String paramString1, mobile_sub_get_photo_wall_rsp parammobile_sub_get_photo_wall_rsp, String paramString2)
  {
    if ((paramBoolean) && (parammobile_sub_get_photo_wall_rsp != null))
    {
      paramString1 = new ArrayList();
      this.this$0.a(parammobile_sub_get_photo_wall_rsp.total_pic, parammobile_sub_get_photo_wall_rsp.iHasMore, parammobile_sub_get_photo_wall_rsp.attachInfo, parammobile_sub_get_photo_wall_rsp.vecUrls, paramString1);
      parammobile_sub_get_photo_wall_rsp = this.this$0.jdField_a_of_type_Auru.obtainMessage(1002);
      parammobile_sub_get_photo_wall_rsp.obj = paramString1;
      this.this$0.jdField_a_of_type_Auru.sendMessage(parammobile_sub_get_photo_wall_rsp);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, String.format("onSetDetailInfo success=%s resultCode=%s mDelayRemoveCardObserver=%s", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(paramInt), Boolean.valueOf(this.this$0.aWP) }));
    }
    if (FriendProfileMoreInfoActivity.a(this.this$0))
    {
      FriendProfileMoreInfoActivity.a(this.this$0, paramBoolean, paramCard);
      return;
    }
    if (((paramBoolean) && (paramInt == 0)) || ((!paramBoolean) && (paramInt == 34)))
    {
      label86:
      if (this.this$0.aWP)
      {
        this.this$0.removeObserver(this.this$0.jdField_a_of_type_Accn);
        this.this$0.aWP = false;
      }
      if ((!this.this$0.aWO) || (this.this$0.I == null)) {
        break label766;
      }
      if (paramBoolean)
      {
        anot.a(this.this$0.app, "dc00898", "", "", "0X8007EC3", "0X8007EC3", 0, 0, "", "", "", "");
        String str;
        if (this.this$0.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe)
        {
          str = this.this$0.aC.getText().toString();
          if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty(str.trim()))) {
            break label696;
          }
        }
        label219:
        if (this.this$0.aWQ) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007EC8", "0X8007EC8", 0, 0, "", "", "", "");
        }
        if (this.this$0.aWR) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007EC9", "0X8007EC9", 0, 0, "", "", "", "");
        }
        if (this.this$0.aWS) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007ECA", "0X8007ECA", 0, 0, "", "", "", "");
        }
        if (this.this$0.b.aXe) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007ECB", "0X8007ECB", 0, 0, "", "", "", "");
        }
        if (this.this$0.c.aXe) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007ECC", "0X8007ECC", 0, 0, "", "", "", "");
        }
        if (this.this$0.aWT) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007ECD", "0X8007ECD", 0, 0, "", "", "", "");
        }
        if (this.this$0.aWU) {
          anot.a(this.this$0.app, "dc00898", "", "", "0X8007ECE", "0X8007ECE", 0, 0, "", "", "", "");
        }
        if (this.this$0.d.aXe)
        {
          str = this.this$0.aF.getText().toString();
          Matcher localMatcher = SearchBaseActivity.Q.matcher(str);
          if ((TextUtils.isEmpty(str)) || (localMatcher.matches())) {
            break label731;
          }
        }
      }
    }
    for (;;)
    {
      if (this.this$0.aWV) {
        anot.a(this.this$0.app, "dc00898", "", "", "0X8007ED0", "0X8007ED0", 0, 0, "", "", "", "");
      }
      if (this.this$0.aa == null) {
        this.this$0.aa = new Bundle();
      }
      this.this$0.aa.putShort("key_personality_label_switch", paramCard.switch_disable_personality_label);
      this.this$0.aWO = false;
      this.this$0.I.dismiss();
      if (this.this$0.isFinishing()) {
        break;
      }
      this.this$0.finish();
      return;
      this.this$0.cf(2131697281, 1);
      break label86;
      label696:
      anot.a(this.this$0.app, "dc00898", "", "", "0X8007EC7", "0X8007EC7", 0, 0, "", "", "", "");
      break label219;
      label731:
      anot.a(this.this$0.app, "dc00898", "", "", "0X8007ECF", "0X8007ECF", 0, 0, "", "", "", "");
    }
    label766:
    FriendProfileMoreInfoActivity.a(this.this$0, paramCard, true);
  }
  
  protected void onSetNick(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileMoreInfoActivity", 2, "onSetNick, success:" + paramBoolean + ", nick=" + paramString);
    }
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)) && (this.this$0.aC != null) && (!paramString.equals(this.this$0.aC.getText().toString())))
    {
      this.this$0.vD(paramString);
      this.this$0.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileMoreInfoActivity$a.aXe = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbj
 * JD-Core Version:    0.7.0.1
 */