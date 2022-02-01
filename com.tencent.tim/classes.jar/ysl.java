import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.contact.addcontact.AddContactsActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendMoreSysMsgActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NewFriendMoreInfo;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ysl
  extends ysa
  implements View.OnClickListener
{
  public ysl(Context paramContext, QQAppInterface paramQQAppInterface, ytd paramytd, ytv paramytv)
  {
    super(paramContext, paramQQAppInterface, paramytd, paramytv);
  }
  
  public View a(int paramInt, View paramView)
  {
    ysl.a locala;
    if ((paramView == null) || (!(paramView.getTag() instanceof ysl.a)))
    {
      locala = new ysl.a();
      paramView = LayoutInflater.from(this.mContext).inflate(2131561511, null);
      locala.jS = ((TextView)paramView.findViewById(2131371945));
      if (ThemeUtil.isDefaultTheme())
      {
        paramView.setBackgroundResource(2130839700);
        paramView.setTag(locala);
      }
    }
    for (;;)
    {
      NewFriendMoreInfo localNewFriendMoreInfo = ((ytw)this.jdField_a_of_type_Ytv).a;
      locala.jS.setText(localNewFriendMoreInfo.moreInfo);
      paramView.setOnClickListener(this);
      return paramView;
      paramView.setBackgroundResource(2130839639);
      break;
      locala = (ysl.a)paramView.getTag();
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject = paramView.getTag();
    if ((localObject != null) && ((localObject instanceof ysl.a))) {
      switch (((ytw)this.jdField_a_of_type_Ytv).a.type)
      {
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      int i = this.jdField_a_of_type_Ytd.xs();
      NewFriendMoreSysMsgActivity.b((NewFriendActivity)this.mContext, 225, i);
      anot.a(this.mApp, "dc00898", "", "", "0X8007704", "0X8007704", 0, 0, "", "", "", "");
      continue;
      localObject = (ysf)this.mApp.getManager(34);
      Intent localIntent = new Intent(this.mContext, AddContactsActivity.class);
      localIntent.putExtra("entrence_data_report", 4);
      localIntent.putExtra("EntranceId", 6);
      ((NewFriendActivity)this.mContext).startActivityForResult(localIntent, 226);
      ((ysf)localObject).cls();
    }
  }
  
  public static class a
  {
    public TextView jS;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ysl
 * JD-Core Version:    0.7.0.1
 */