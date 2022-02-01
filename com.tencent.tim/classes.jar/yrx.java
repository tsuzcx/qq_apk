import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
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
import com.tencent.mobileqq.activity.contact.newfriend.ContactMatchBuilder.1;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ContactMatch;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

public class yrx
  extends ysa
  implements View.OnClickListener
{
  private ysf a;
  private acff f;
  
  public yrx(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
    this.f = ((acff)paramQQAppInterface.getManager(51));
    this.jdField_a_of_type_Ysf = ((ysf)paramQQAppInterface.getManager(34));
    this.jdField_a_of_type_Auvd = a(paramContext);
    this.mItemHeight = this.mContext.getResources().getDimensionPixelSize(2131297808);
  }
  
  public View a(int paramInt, View paramView)
  {
    yrx.a locala;
    Object localObject;
    boolean bool;
    label213:
    StringBuilder localStringBuilder;
    if ((paramView == null) || (!(paramView.getTag() instanceof yrx.a)))
    {
      locala = new yrx.a();
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
      locala.jdField_Lz_of_type_AndroidViewView.setOnClickListener(this);
      a(this.mContext, paramView, paramInt, this.jdField_a_of_type_Ytv, locala, this);
      localObject = locala.jdField_Lz_of_type_AndroidViewView;
      if (this.jdField_a_of_type_Ytv.isReaded()) {
        break label495;
      }
      bool = true;
      C((View)localObject, bool);
      localObject = ((ytp)this.jdField_a_of_type_Ytv).a;
      localStringBuilder = new StringBuilder(256);
      if (TextUtils.isEmpty(((ContactMatch)localObject).name)) {
        break label500;
      }
      locala.Lx.setVisibility(0);
      locala.Lx.setText(((ContactMatch)localObject).name);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append(((ContactMatch)localObject).name);
      }
      label293:
      a(locala.LB, ((ContactMatch)localObject).gender, ((ContactMatch)localObject).age, localStringBuilder);
      locala.Ly.setVisibility(8);
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setText(acfp.m(2131704418));
      locala.jdField_Lz_of_type_AndroidWidgetTextView.setVisibility(0);
      if (AppSetting.enableTalkBack) {
        localStringBuilder.append(",来自手机通讯录");
      }
      if (!this.f.w(((ContactMatch)localObject).unifiedCode, true)) {
        break label513;
      }
      locala.ej.setVisibility(8);
      locala.LA.setVisibility(0);
      locala.LA.setText(acfp.m(2131704415));
      if (AppSetting.enableTalkBack)
      {
        localStringBuilder.append(",等待验证");
        locala.LA.setContentDescription(acfp.m(2131704419));
      }
    }
    for (;;)
    {
      if (AppSetting.enableTalkBack) {
        paramView.setContentDescription(localStringBuilder.toString());
      }
      locala.aZH = ((ContactMatch)localObject).unifiedCode;
      locala.uw.setImageBitmap(this.jdField_a_of_type_Ytd.a(11, ((ContactMatch)localObject).unifiedCode));
      return paramView;
      locala = (yrx.a)paramView.getTag();
      break;
      label495:
      bool = false;
      break label213;
      label500:
      locala.Lx.setVisibility(8);
      break label293;
      label513:
      locala.ej.setVisibility(0);
      locala.ej.setText(acfp.m(2131721053));
      locala.ej.setTag(localObject);
      locala.ej.setOnClickListener(this);
      locala.LA.setVisibility(8);
      if (AppSetting.enableTalkBack)
      {
        localStringBuilder.append(",添加");
        locala.ej.setContentDescription(acfp.m(2131704416));
      }
    }
  }
  
  protected void clg()
  {
    ThreadManager.getSubThreadHandler().post(new ContactMatchBuilder.1(this));
    anot.a(this.mApp, "CliOper", "", "", "0X8006A72", "0X8006A72", 0, 0, "", "", "", "");
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
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof yrx.a)))
      {
        Object localObject2 = ((ytp)this.jdField_a_of_type_Ytv).a;
        if (localObject2 != null)
        {
          if (((PhoneContactManagerImp)this.mApp.getManager(11)).Uv()) {}
          for (localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 34);; localObject1 = new ProfileActivity.AllInOne(((ContactMatch)localObject2).unifiedCode, 29))
          {
            ((ProfileActivity.AllInOne)localObject1).nickname = ((ContactMatch)localObject2).name;
            ProfileActivity.a((NewFriendActivity)this.mContext, (ProfileActivity.AllInOne)localObject1, 229);
            this.jdField_a_of_type_Ysf.clu();
            break;
          }
          localObject1 = paramView.getTag();
          if ((localObject1 != null) && ((localObject1 instanceof ContactMatch))) {
            if (!aqiw.isNetworkAvailable(this.mContext))
            {
              QQToast.a(this.mContext, this.mContext.getResources().getString(2131693404), 0).show(getTitleBarHeight());
            }
            else
            {
              localObject1 = (ContactMatch)localObject1;
              if (localObject1 != null)
              {
                localObject2 = (PhoneContactManagerImp)this.mApp.getManager(11);
                int i = 3006;
                int j = 3;
                if (!((PhoneContactManagerImp)localObject2).Uv())
                {
                  i = 3075;
                  j = 1;
                }
                localObject1 = AddFriendLogicActivity.a(this.mContext, 2, ((ContactMatch)localObject1).unifiedCode, "ContactMatchBuilder", i, j, ((ContactMatch)localObject1).name, null, null, acfp.m(2131704417), null);
                ((NewFriendActivity)this.mContext).startActivityForResult((Intent)localObject1, 229);
              }
              this.jdField_a_of_type_Ysf.clu();
              anot.a(this.mApp, "CliOper", "", "", "0X8006A71", "0X8006A71", 0, 0, "", "", "", "");
            }
          }
        }
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
 * Qualified Name:     yrx
 * JD-Core Version:    0.7.0.1
 */