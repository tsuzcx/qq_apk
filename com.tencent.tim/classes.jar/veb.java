import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;

public class veb
  extends accn
{
  public veb(InterestSwitchEditActivity paramInterestSwitchEditActivity) {}
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("InterestSwitchEditActivity", 2, String.format(Locale.getDefault(), "onGetDetailInfo switch_interest=%s switch_music=%s switch_personality_label=%s switch_present=%s switch_miniapp=%s switch_musicbox=%s switch_sticky_note=%s switch_qqcircle=%s switch_life_achievement=%s", new Object[] { Short.valueOf(paramCard.switch_interest), Short.valueOf(paramCard.switch_music), Short.valueOf(paramCard.switch_disable_personality_label), Short.valueOf(paramCard.switch_present), Short.valueOf(paramCard.switch_miniapp), Short.valueOf(paramCard.switch_musicbox), Short.valueOf(paramCard.switch_sticky_note), Short.valueOf(paramCard.switch_qqcircle), Short.valueOf(paramCard.switch_life_achievement) }));
    }
    if (paramBoolean)
    {
      if ((this.a.app.getCurrentAccountUin().equals(paramString)) && (paramCard != null) && (-1 != paramCard.switch_interest) && (-1 != paramCard.switch_music) && (-1 != paramCard.switch_disable_personality_label) && (-1 != paramCard.switch_present) && (-1 != paramCard.switch_miniapp) && (-1 != paramCard.switch_musicbox) && (-1 != paramCard.switch_sticky_note) && (-1 != paramCard.switch_qqcircle) && (-1 != paramCard.switch_life_achievement))
      {
        InterestSwitchEditActivity.a(this.a, paramCard);
        InterestSwitchEditActivity.a(this.a);
        InterestSwitchEditActivity.b(this.a);
        InterestSwitchEditActivity.c(this.a);
        return;
      }
      QLog.i("InterestSwitchEditActivity", 1, "onGetDetailInfo has invalidate value.");
      return;
    }
    QQToast.a(this.a, acfp.m(2131707447), 0).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     veb
 * JD-Core Version:    0.7.0.1
 */