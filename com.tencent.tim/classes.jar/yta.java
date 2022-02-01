import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.contact.newfriend.QIMNotifyAddFriendBuilder.1;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class yta
  extends ysa
  implements View.OnClickListener
{
  public acjf b = (acjf)this.mApp.getManager(257);
  
  public yta(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.jdField_a_of_type_Auvd = a(paramContext);
    this.mItemHeight = paramContext.getResources().getDimensionPixelSize(2131297806);
  }
  
  public View a(int paramInt, View paramView)
  {
    yta.a locala;
    StringBuilder localStringBuilder;
    QIMNotifyAddFriend localQIMNotifyAddFriend;
    Object localObject;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof yta.a)))
    {
      locala = new yta.a();
      paramView = a(this.mContext, 2131561720, locala);
      Y(paramView, this.mItemHeight);
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
      locala.jdField_Lz_of_type_AndroidViewView.setClickable(false);
      a(this.mContext, paramView, paramInt, this.jdField_a_of_type_Ytv, locala, this);
      localStringBuilder = new StringBuilder(256);
      localQIMNotifyAddFriend = ((yug)this.jdField_a_of_type_Ytv).a;
      locala.Lx.setText(localQIMNotifyAddFriend.nickName);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append(localQIMNotifyAddFriend.nickName);
      }
      localObject = locala.jdField_Lz_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Ytv.isReaded()) {
        break label564;
      }
      bool = true;
      label267:
      C((View)localObject, bool);
      a(locala.LB, localQIMNotifyAddFriend.gender, localQIMNotifyAddFriend.age, localStringBuilder);
      localObject = this.b.g(localQIMNotifyAddFriend.uin, localQIMNotifyAddFriend.qqUin);
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label569;
      }
      locala.Ly.setVisibility(8);
    }
    for (;;)
    {
      String str = ((FlashChatManager)this.mApp.getManager(217)).wf();
      localObject = str;
      if (TextUtils.isEmpty(str)) {
        localObject = "来自QIM的好友申请";
      }
      localObject = String.format(Locale.getDefault(), acfp.m(2131711225), new Object[] { localObject });
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append(",").append((String)localObject);
      }
      locala.LA.setVisibility(8);
      locala.ej.setText(acfp.m(2131711226));
      locala.ej.setVisibility(0);
      locala.ej.setOnClickListener(this);
      locala.aZH = String.valueOf(localQIMNotifyAddFriend.uin);
      locala.uw.setImageBitmap(this.jdField_a_of_type_Ytd.a(1, String.valueOf(localQIMNotifyAddFriend.uin)));
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      anot.a(null, "dc00898", "", "", "0X8008AA4", "0X8008AA4", 0, 0, "", "", "", "");
      return paramView;
      locala = (yta.a)paramView.getTag();
      break;
      label564:
      bool = false;
      break label267;
      label569:
      locala.Ly.setVisibility(0);
      locala.Ly.setText((CharSequence)localObject);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append(",").append((String)localObject);
      }
    }
  }
  
  protected void clg()
  {
    anot.a(null, "dc00898", "", "", "0X8008AA6", "0X8008AA6", 0, 0, "", "", "", "");
    ThreadManager.postImmediately(new QIMNotifyAddFriendBuilder.1(this), null, true);
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      fJ(paramView);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ((FlashChatManager)this.mApp.getManager(217)).a(this.mContext, null);
      ((ysf)this.mApp.getManager(34)).clt();
      FriendListHandler localFriendListHandler = (FriendListHandler)this.mApp.getBusinessHandler(1);
      QIMNotifyAddFriend localQIMNotifyAddFriend = ((yug)this.jdField_a_of_type_Ytv).a;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localQIMNotifyAddFriend);
      localFriendListHandler.iM(localArrayList);
      anot.a(null, "dc00898", "", "", "0X8008AA5", "0X8008AA5", 0, 0, "", "", "", "");
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
 * Qualified Name:     yta
 * JD-Core Version:    0.7.0.1
 */