import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendLogicActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contacts.mayknow.ContactReportUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.troop.widget.TroopLabelLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.List;

public class yry
  extends ysa
  implements View.OnClickListener
{
  private ysf a;
  private achg b;
  private int caS;
  protected int caT;
  
  public yry(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv, int paramInt)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.caS = paramInt;
    this.jdField_a_of_type_Auvd = a(paramContext);
    this.b = ((achg)paramQQAppInterface.getManager(159));
    this.jdField_a_of_type_Ysf = ((ysf)paramQQAppInterface.getManager(34));
    this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(2131297808);
  }
  
  public void Ex(int paramInt)
  {
    this.caT = paramInt;
  }
  
  public byte[] M()
  {
    return ((yts)this.jdField_a_of_type_Ytv).b.algBuffer;
  }
  
  public View a(int paramInt, View paramView)
  {
    yry.a locala;
    MayKnowRecommend localMayKnowRecommend;
    label266:
    StringBuilder localStringBuilder;
    boolean bool;
    if ((paramView == null) || (!(paramView.getTag() instanceof yry.a)))
    {
      locala = new yry.a();
      paramView = a(this.mContext, 2131561722, locala);
      locala.uw = ((ImageView)paramView.findViewById(2131361802));
      locala.Lx = ((TextView)paramView.findViewById(2131372384));
      locala.LA = ((TextView)paramView.findViewById(2131377211));
      locala.ej = ((Button)paramView.findViewById(2131377201));
      locala.a = ((TroopLabelLayout)paramView.findViewById(2131380324));
      locala.a.setLabelType(1);
      locala.LG = ((TextView)paramView.findViewById(2131371194));
      locala.LP = ((TextView)paramView.findViewById(2131378956));
      fI(locala.uw);
      paramView.setTag(locala);
      locala.Lz.setTag(locala);
      locala.Lz.setOnClickListener(this);
      a(this.mContext, paramView, paramInt, this.jdField_a_of_type_Ytv, locala, this);
      localMayKnowRecommend = ((yts)this.jdField_a_of_type_Ytv).b;
      if (this.jdField_a_of_type_Ytv.isReaded()) {
        break label633;
      }
      C(locala.Lz, true);
      if (aqft.rj(String.valueOf(localMayKnowRecommend.uin))) {
        anot.a(this.mApp, "dc00898", "", "", "0X800826F", "0X800826F", 0, 0, "", "", "", "");
      }
      if (this.jdField_a_of_type_Ytd.xt() == 23) {
        clh();
      }
      localStringBuilder = new StringBuilder(256);
      bool = false;
      if (this.b != null) {
        bool = this.b.aaC();
      }
      Object localObject = localMayKnowRecommend.getDisplayName(bool);
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label645;
      }
      locala.Lx.setVisibility(0);
      locala.Lx.setText((CharSequence)localObject);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append((String)localObject);
      }
      label360:
      if ((TextUtils.isEmpty(localMayKnowRecommend.uin)) || (!aqft.rj(localMayKnowRecommend.uin))) {
        break label658;
      }
      localObject = this.mContext.getResources().getDrawable(2130842599);
      ((Drawable)localObject).setBounds(0, 0, wja.dp2px(15.0F, this.mContext.getResources()), wja.dp2px(15.0F, this.mContext.getResources()));
      locala.Lx.setCompoundDrawables(null, null, (Drawable)localObject, null);
      label440:
      if (!TextUtils.isEmpty(localMayKnowRecommend.recommendReason)) {
        break label673;
      }
      locala.LG.setVisibility(8);
      label461:
      locala.a.b(localMayKnowRecommend);
      if (localMayKnowRecommend.friendStatus != 0) {
        break label712;
      }
      locala.ej.setOnClickListener(this);
      locala.ej.setVisibility(0);
      locala.ej.setText(acfp.m(2131721053));
      locala.ej.setTag(localMayKnowRecommend);
      locala.LA.setVisibility(8);
      if (AppSetting.enableTalkBack)
      {
        localStringBuilder.append(",点击添加");
        locala.ej.setContentDescription(acfp.m(2131721053));
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      locala.aZH = localMayKnowRecommend.uin;
      locala.uw.setImageBitmap(this.jdField_a_of_type_Ytd.a(1, localMayKnowRecommend.uin));
      a(locala.LP, localMayKnowRecommend, bool);
      return paramView;
      locala = (yry.a)paramView.getTag();
      break;
      label633:
      C(locala.Lz, false);
      break label266;
      label645:
      locala.Lx.setVisibility(8);
      break label360;
      label658:
      locala.Lx.setCompoundDrawables(null, null, null, null);
      break label440;
      label673:
      locala.LG.setText(localMayKnowRecommend.recommendReason);
      if (!AppSetting.enableTalkBack) {
        break label461;
      }
      localStringBuilder.append(",").append(localMayKnowRecommend.recommendReason);
      break label461;
      label712:
      if (localMayKnowRecommend.friendStatus == 1)
      {
        locala.ej.setVisibility(8);
        locala.LA.setVisibility(0);
        locala.LA.setText(2131718834);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",等待验证");
          locala.LA.setContentDescription(acfp.m(2131708056));
        }
      }
      else
      {
        locala.ej.setVisibility(8);
        locala.LA.setVisibility(0);
        locala.LA.setText(2131690291);
        if (AppSetting.enableTalkBack)
        {
          localStringBuilder.append(",已添加");
          locala.LA.setContentDescription(acfp.m(2131708058));
        }
      }
    }
  }
  
  public void a(TextView paramTextView, MayKnowRecommend paramMayKnowRecommend, boolean paramBoolean)
  {
    if (paramMayKnowRecommend == null) {
      return;
    }
    String str = paramMayKnowRecommend.getDisplayName(paramBoolean);
    if ((!TextUtils.isEmpty(paramMayKnowRecommend.mobile_name)) && (!str.equals(paramMayKnowRecommend.mobile_name)))
    {
      paramTextView.setText("(" + paramMayKnowRecommend.mobile_name + ")");
      paramTextView.setVisibility(0);
      return;
    }
    paramTextView.setVisibility(8);
  }
  
  protected void clg()
  {
    if (!aqiw.isNetworkAvailable(this.mContext))
    {
      QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(this.mContext.getResources().getDimensionPixelSize(2131299627));
      return;
    }
    String str = ((yts)this.jdField_a_of_type_Ytv).b.uin;
    ((FriendListHandler)this.mApp.getBusinessHandler(1)).DK(str);
    this.jdField_a_of_type_Ytd.a(this);
    this.jdField_a_of_type_Ytd.gs(200L);
    anot.a(this.mApp, "CliOper", "", "", "0X8006A6F", "0X8006A6F", 0, 0, "", "", "", "");
    Object localObject = ((yts)this.jdField_a_of_type_Ytv).b;
    if (localObject != null) {}
    for (localObject = ((MayKnowRecommend)localObject).msgLabel;; localObject = null)
    {
      int i = this.jdField_a_of_type_Ytd.xt();
      ContactReportUtils.a(this.mApp, str, "frd_list_dlt", i, 0, ((yts)this.jdField_a_of_type_Ytv).b.recommendReason, this.caT, ((yts)this.jdField_a_of_type_Ytv).b.algBuffer, ContactReportUtils.w((List)localObject), 0, "3");
      return;
    }
  }
  
  public void clh()
  {
    if (this.b != null) {
      this.b.a(((yts)this.jdField_a_of_type_Ytv).b, 23, this.caS, 1);
    }
  }
  
  public void cli()
  {
    if (this.b != null) {
      this.b.b(((yts)this.jdField_a_of_type_Ytv).b, 23, this.caS, 1);
    }
  }
  
  public String getRecommendReason()
  {
    return ((yts)this.jdField_a_of_type_Ytv).b.recommendReason;
  }
  
  public void onClick(View paramView)
  {
    int j = this.jdField_a_of_type_Ytd.xt();
    Object localObject1;
    Object localObject2;
    switch (paramView.getId())
    {
    default: 
      fJ(paramView);
    case 2131377370: 
      do
      {
        do
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          localObject1 = paramView.getTag();
        } while ((localObject1 == null) || (!(localObject1 instanceof yry.a)));
        localObject1 = ((yts)this.jdField_a_of_type_Ytv).b;
      } while (localObject1 == null);
      localObject2 = (acff)this.mApp.getManager(51);
      if ((localObject2 == null) || (!((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))) {
        break;
      }
    }
    for (int i = 1;; i = 110)
    {
      if (QLog.isColorLevel()) {
        QLog.d("MayKnowRecommendBuilder", 2, "onClick rlSystemMsg， friendtype=" + i + ", gameSourceId=" + ((MayKnowRecommend)localObject1).recommendReason);
      }
      localObject2 = new ProfileActivity.AllInOne(((MayKnowRecommend)localObject1).uin, i);
      boolean bool = false;
      if (this.b != null) {
        bool = this.b.aaC();
      }
      String str = ((MayKnowRecommend)localObject1).getRecommendName(bool);
      if (!TextUtils.isEmpty(str)) {
        ((ProfileActivity.AllInOne)localObject2).aOH = str;
      }
      if (!TextUtils.isEmpty(((MayKnowRecommend)localObject1).nick)) {
        ((ProfileActivity.AllInOne)localObject2).nickname = ((MayKnowRecommend)localObject1).nick;
      }
      str = ContactReportUtils.w(((MayKnowRecommend)localObject1).msgLabel);
      ((ProfileActivity.AllInOne)localObject2).bJa = 88;
      Bundle localBundle = new Bundle();
      localBundle.putString("recommend_entry_type", "3");
      localBundle.putString("recommend_reason", ((MayKnowRecommend)localObject1).recommendReason);
      localBundle.putInt("recommend_pos", this.caT);
      localBundle.putByteArray("recommend_algh_id", ((MayKnowRecommend)localObject1).algBuffer);
      localBundle.putString("recommend_label", str);
      localBundle.putInt("tabID", j);
      ProfileActivity.a((NewFriendActivity)this.mContext, (ProfileActivity.AllInOne)localObject2, 228, localBundle);
      this.jdField_a_of_type_Ysf.clu();
      if ((j == 23) && (this.b != null)) {
        this.b.a((MayKnowRecommend)localObject1, 23, this.caS, 2);
      }
      ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_clk", j, 0, ((MayKnowRecommend)localObject1).recommendReason, this.caT, ((MayKnowRecommend)localObject1).algBuffer, str, 0, "3");
      break;
      localObject1 = paramView.getTag();
      if ((localObject1 == null) || (!(localObject1 instanceof MayKnowRecommend))) {
        break;
      }
      if (!aqiw.isNetworkAvailable(this.mContext))
      {
        QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
        break;
      }
      localObject1 = (MayKnowRecommend)localObject1;
      localObject2 = (acff)this.mApp.getManager(51);
      if ((!((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin)) && (!((acff)localObject2).kd(((MayKnowRecommend)localObject1).uin)))
      {
        bool = false;
        if (this.b != null) {
          bool = this.b.aaC();
        }
        localObject2 = ((MayKnowRecommend)localObject1).getDisplayName(bool);
        i = this.jdField_a_of_type_Ytd.xt();
        localObject2 = AddFriendLogicActivity.a(this.mContext, 1, ((MayKnowRecommend)localObject1).uin, null, 3045, i, (String)localObject2, null, null, this.mContext.getString(2131721053), null);
        anot.a(this.mApp, "CliOper", "", "", "0X80085C4", "0X80085C4", 0, 0, String.valueOf(i), "", "", "");
        ((NewFriendActivity)this.mContext).startActivityForResult((Intent)localObject2, 228);
      }
      for (;;)
      {
        this.jdField_a_of_type_Ysf.clu();
        anot.a(this.mApp, "CliOper", "", "", "0X8006A6E", "0X8006A6E", 0, 0, "", "", "", "");
        if (aqft.rj(String.valueOf(((MayKnowRecommend)localObject1).uin))) {
          anot.a(this.mApp, "dc00898", "", "", "0X8008270", "0X8008270", 0, 0, "", "", "", "");
        }
        if ((j == 23) && (this.b != null)) {
          this.b.a((MayKnowRecommend)localObject1, 23, this.caS, 3);
        }
        ContactReportUtils.a(this.mApp, ((MayKnowRecommend)localObject1).uin, "frd_list_add", j, 1, ((MayKnowRecommend)localObject1).recommendReason, this.caT, ((MayKnowRecommend)localObject1).algBuffer, ContactReportUtils.w(((MayKnowRecommend)localObject1).msgLabel), 0, "3");
        break;
        if (((acff)localObject2).isFriend(((MayKnowRecommend)localObject1).uin))
        {
          ((MayKnowRecommend)localObject1).friendStatus = 2;
          this.jdField_a_of_type_Ytd.notifyDataSetChanged();
        }
        else
        {
          ((MayKnowRecommend)localObject1).friendStatus = 1;
          this.jdField_a_of_type_Ytd.notifyDataSetChanged();
        }
      }
    }
  }
  
  public String pQ()
  {
    return ((yts)this.jdField_a_of_type_Ytv).b.uin;
  }
  
  protected int xl()
  {
    return 1;
  }
  
  public int xm()
  {
    return this.caT;
  }
  
  public static class a
    extends ysa.a
  {
    public TextView LP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yry
 * JD-Core Version:    0.7.0.1
 */