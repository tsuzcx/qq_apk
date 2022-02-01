import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.PhoneContactAddBuilder.1;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.PhoneContactAdd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysy
  extends ysa
  implements View.OnClickListener
{
  public ysy(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.jdField_a_of_type_Auvd = a(paramContext);
  }
  
  public View a(int paramInt, View paramView)
  {
    ysy.a locala;
    PhoneContactAdd localPhoneContactAdd;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysy.a)))
    {
      locala = new ysy.a();
      paramView = a(this.mContext, 2131561720, locala);
      locala.uw = ((ImageView)paramView.findViewById(2131361802));
      locala.Lx = ((TextView)paramView.findViewById(2131372384));
      locala.Ly = ((TextView)paramView.findViewById(2131377214));
      locala.LB = ((TextView)paramView.findViewById(2131362339));
      locala.jdField_Lz_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131378586));
      locala.LA = ((TextView)paramView.findViewById(2131377211));
      locala.ej = ((Button)paramView.findViewById(2131377201));
      fI(locala.uw);
      paramView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setTag(locala);
      locala.jdField_Lz_of_type_AndroidViewView.setOnClickListener(this);
      a(this.mContext, paramView, paramInt, this.jdField_a_of_type_Ytv, locala, this);
      C(locala.jdField_Lz_of_type_AndroidViewView, false);
      localPhoneContactAdd = ((yue)this.jdField_a_of_type_Ytv).a;
      if (TextUtils.isEmpty(localPhoneContactAdd.name)) {
        break label346;
      }
      locala.Lx.setVisibility(0);
      locala.Lx.setText(localPhoneContactAdd.name);
      label221:
      locala.LB.setVisibility(8);
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(8);
      if (TextUtils.isEmpty(localPhoneContactAdd.remindInfo)) {
        break label358;
      }
      locala.Ly.setVisibility(0);
      locala.Ly.setText(localPhoneContactAdd.remindInfo);
    }
    for (;;)
    {
      locala.LA.setVisibility(0);
      locala.ej.setVisibility(8);
      locala.LA.setText(this.mContext.getString(2131718834));
      locala.aZH = localPhoneContactAdd.unifiedCode;
      locala.uw.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, localPhoneContactAdd.unifiedCode));
      return paramView;
      locala = (ysy.a)paramView.getTag();
      break;
      label346:
      locala.Lx.setVisibility(8);
      break label221;
      label358:
      locala.Ly.setVisibility(8);
    }
  }
  
  protected void clg()
  {
    ThreadManager.postImmediately(new PhoneContactAddBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      fJ(paramView);
    }
    PhoneContactAdd localPhoneContactAdd;
    do
    {
      do
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = paramView.getTag();
      } while ((localObject == null) || (!(localObject instanceof ysy.a)));
      localPhoneContactAdd = ((yue)this.jdField_a_of_type_Ytv).a;
    } while (localPhoneContactAdd == null);
    Object localObject = (PhoneContactManagerImp)this.mApp.getManager(11);
    if (((PhoneContactManagerImp)localObject).c(localPhoneContactAdd.unifiedCode) == null) {
      localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
    }
    for (;;)
    {
      ((ProfileActivity.AllInOne)localObject).nickname = localPhoneContactAdd.name;
      ProfileActivity.a((NewFriendActivity)this.mContext, (ProfileActivity.AllInOne)localObject, 227);
      ((ysf)this.mApp.getManager(34)).clt();
      break;
      if (((PhoneContactManagerImp)localObject).Uv()) {
        localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 34);
      } else {
        localObject = new ProfileActivity.AllInOne(localPhoneContactAdd.unifiedCode, 29);
      }
    }
  }
  
  protected int xl()
  {
    return 1;
  }
  
  public static class a
    extends ysa.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysy
 * JD-Core Version:    0.7.0.1
 */