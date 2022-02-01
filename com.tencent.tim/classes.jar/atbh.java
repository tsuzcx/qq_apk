import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

public class atbh
{
  public static boolean a(alcn paramalcn, Intent paramIntent)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.FrdProfileCard", 2, "checkParamValidate() cardInfo.allinone = " + paramalcn.e);
    }
    if (paramalcn.e == null) {}
    while (TextUtils.isEmpty(paramalcn.e.uin)) {
      return false;
    }
    if (ProfileActivity.AllInOne.g(paramalcn.e)) {}
    try
    {
      alkt.getLong(paramalcn.e.uin);
      if ((paramalcn.e.pa == 56) || (paramalcn.e.pa == 55)) {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.FrdProfileCard", 2, "rich statuc profile, ricthStatus id = " + paramalcn.e.bJd + ", entry = " + paramalcn.e.bJa);
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder(300);
          localStringBuilder.append("checkParamValidate, [pa: ").append(paramalcn.e.pa).append(", uin: ").append(aqft.pl(paramalcn.e.uin));
          if (ProfileActivity.gj(paramalcn.e.pa)) {
            localStringBuilder.append(", allinone_discussUin: ").append(paramalcn.e.discussUin);
          }
          if (ProfileActivity.gk(paramalcn.e.pa)) {
            localStringBuilder.append(", allinone_troopUin: ").append(paramalcn.e.troopUin).append(",  allinone_troopcode: ").append(paramalcn.e.troopcode).append(", sub_source_id: ").append(paramalcn.e.subSourceId).append(", troopUin: ").append(paramalcn.troopUin);
          }
          paramIntent = paramIntent.getBundleExtra("flc_extra_param");
          if (paramIntent != null)
          {
            localStringBuilder.append(", extra_param_troop_code: ").append(paramIntent.getString("troop_code"));
            localStringBuilder.append(", extra_param_troop_uin: ").append(paramIntent.getString("troop_uin"));
            localStringBuilder.append(", extra_param_notify_type: ").append(paramIntent.getInt("flc_notify_type"));
            localStringBuilder.append(", extra_param_recommend_uin: ").append(paramIntent.getString("flc_recommend_uin"));
          }
          localStringBuilder.append(", reportExtraParam: ").append(paramalcn.e.ae);
          localStringBuilder.append("]");
          QLog.i("addFriendTag", 2, localStringBuilder.toString());
        }
        return true;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("Q.profilecard.FrdProfileCard", 2, "通讯录陌生人： cardInfo.allinone.uin = " + paramalcn.e.uin);
        break;
        paramalcn.e.bJd = 0;
      }
      return false;
    }
    catch (NumberFormatException paramalcn) {}
  }
  
  public static boolean a(alcn paramalcn, Card paramCard, boolean paramBoolean)
  {
    if (paramCard == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.FrdProfileCard", 2, "updateNameList by Card");
      }
      return false;
    }
    boolean bool2;
    if ((paramBoolean) || (!TextUtils.isEmpty(paramCard.strNick))) {
      if (!aqft.equalsWithNullCheck(paramalcn.gh[0], paramCard.strNick))
      {
        bool2 = true;
        paramalcn.gh[0] = paramCard.strNick;
      }
    }
    for (;;)
    {
      if (!paramBoolean)
      {
        bool1 = bool2;
        if (TextUtils.isEmpty(paramCard.strReMark)) {}
      }
      else
      {
        if ((!bool2) && (aqft.equalsWithNullCheck(paramalcn.gh[4], paramCard.strReMark))) {
          break label433;
        }
        bool1 = true;
        label103:
        paramalcn.gh[4] = paramCard.strReMark;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool1;
        if (TextUtils.isEmpty(paramCard.strAutoRemark)) {}
      }
      else
      {
        if ((!bool1) && (aqft.equalsWithNullCheck(paramalcn.gh[6], paramCard.strAutoRemark))) {
          break label438;
        }
        paramBoolean = true;
        label152:
        paramalcn.gh[6] = paramCard.strAutoRemark;
      }
      boolean bool1 = paramBoolean;
      if (!TextUtils.isEmpty(paramCard.strContactName))
      {
        if ((paramBoolean) || (!aqft.equalsWithNullCheck(paramalcn.gh[3], paramCard.strContactName)))
        {
          bool1 = true;
          label197:
          paramalcn.gh[3] = paramCard.strContactName;
        }
      }
      else
      {
        paramBoolean = bool1;
        if (!TextUtils.isEmpty(paramCard.strAutoRemark)) {
          if ((!bool1) && (aqft.equalsWithNullCheck(paramalcn.gh[2], paramCard.strAutoRemark))) {
            break label448;
          }
        }
      }
      label433:
      label438:
      label448:
      for (paramBoolean = true;; paramBoolean = false)
      {
        paramalcn.gh[2] = paramCard.strAutoRemark;
        if (QLog.isColorLevel())
        {
          paramCard = new StringBuilder();
          paramCard.append("updateNameList()").append(", bRet = ").append(paramBoolean).append(", strNick = ");
          paramCard.append(aqft.pl(paramalcn.gh[0])).append(", strRemark = ");
          paramCard.append(aqft.pl(paramalcn.gh[4])).append(", strContactName = ");
          paramCard.append(aqft.pl(paramalcn.gh[3])).append(", strCircleName = ");
          paramCard.append(aqft.pl(paramalcn.gh[2])).append(", strRecommenName = ");
          paramCard.append(aqft.pl(paramalcn.gh[5])).append(", strTroopNickName = ");
          paramCard.append(aqft.pl(paramalcn.gh[1])).append(", strAutoRemark = ");
          paramCard.append(aqft.pl(paramalcn.gh[6]));
          QLog.d("Q.profilecard.FrdProfileCard", 2, paramCard.toString());
        }
        return paramBoolean;
        bool2 = false;
        break;
        bool1 = false;
        break label103;
        paramBoolean = false;
        break label152;
        bool1 = false;
        break label197;
      }
      bool2 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atbh
 * JD-Core Version:    0.7.0.1
 */