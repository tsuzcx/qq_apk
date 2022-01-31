import android.os.Handler;
import android.util.Pair;
import android.widget.Toast;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class aos
  extends CardObserver
{
  public aos(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onSetCardTemplateReturn(boolean paramBoolean, Object paramObject)
  {
    this.a.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.a.jdField_b_of_type_JavaLangRunnable);
    this.a.n();
    if ((paramBoolean) && (paramObject != null))
    {
      if (!(paramObject instanceof Card)) {
        break label183;
      }
      paramObject = (Card)paramObject;
      if (!this.a.a((int)paramObject.lCurrentStyleId, (int)paramObject.lCurrentBgId, paramObject.backgroundUrl, (int)paramObject.backgroundColor, paramObject.templateRet)) {
        break label169;
      }
      paramObject = new ProfileActivity.AllInOne(this.a.app.a(), 0);
      paramObject.h = this.a.app.c();
      paramObject.f = 1;
      paramObject.g = 5;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null) && (!this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a.equals(this.a.app.a()))) {
        ProfileActivity.a(this.a, paramObject);
      }
    }
    label169:
    label183:
    while (!(paramObject instanceof Pair))
    {
      return;
      Toast.makeText(this.a, 2131364277, 0).show();
      return;
    }
    paramObject = (Pair)paramObject;
    if (((Integer)paramObject.first).intValue() == 101107) {}
    for (this.a.jdField_b_of_type_Int = 1;; this.a.jdField_b_of_type_Int = 2)
    {
      this.a.o();
      return;
      if (((Integer)paramObject.first).intValue() != 101108) {
        break;
      }
    }
    if ((((Integer)paramObject.first).intValue() >= 400000) && (((Integer)paramObject.first).intValue() <= 499999))
    {
      Toast.makeText(this.a, (CharSequence)paramObject.second, 0).show();
      return;
    }
    Toast.makeText(this.a, 2131364277, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     aos
 * JD-Core Version:    0.7.0.1
 */