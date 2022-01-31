import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.av.utils.TroopMemberUtil;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.qwallet.TopayManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQToast;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class ybe
  implements View.OnClickListener
{
  public ybe(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    Object localObject2;
    if (this.a.f == 11) {
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        break label197;
        break label197;
        if (this.a.d == 3)
        {
          localObject1 = this.a.getIntent().getStringExtra("group_uin");
          localObject2 = TroopMemberUtil.a(this.a.app, this.a.app.getCurrentAccountUin(), (String)localObject1) + "";
          if (!"发起视频".equals(this.a.e.getText().toString())) {
            break label350;
          }
        }
      }
    }
    label197:
    label350:
    for (paramView = "0";; paramView = "1")
    {
      ReportController.b(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject1, (String)localObject2, paramView, "");
      if (this.a.f != 33) {
        break label356;
      }
      TopayManager.a(this.a, this.a.jdField_i_of_type_JavaUtilArrayList);
      return;
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 1) {
        break;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
      break;
      if (this.a.f != 10) {
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() == 0)
      {
        ReportController.b(this.a.app, "CliOper", "", "", "0X8005522", "0X8005522", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a() != 1) {
        break;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8005521", "0X8005521", 0, 0, "", "", "", "");
      break;
    }
    label356:
    if ((this.a.f == 32) && (this.a.jdField_i_of_type_JavaUtilArrayList.size() > this.a.jdField_i_of_type_Int))
    {
      paramView = MessageFormat.format(this.a.getString(2131435968), new Object[] { Integer.valueOf(this.a.jdField_i_of_type_Int) });
      QQToast.a(this.a, paramView, 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      return;
    }
    if (!NetworkUtil.d(this.a))
    {
      QQToast.a(this.a, this.a.getString(2131433009), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
      return;
    }
    if ((this.a.y) && (this.a.jdField_i_of_type_JavaUtilArrayList.size() == 1) && (this.a.jdField_i_of_type_JavaUtilArrayList.get(0) != null))
    {
      paramView = (ResultRecord)this.a.jdField_i_of_type_JavaUtilArrayList.get(0);
      localObject1 = this.a.app.c();
      if ((localObject1 != null) && (paramView.jdField_a_of_type_JavaLangString != null) && (((String)localObject1).equals(paramView.jdField_a_of_type_JavaLangString)))
      {
        QQToast.a(this.a, this.a.getString(2131436016), 0).b(this.a.jdField_c_of_type_AndroidViewView.getHeight());
        return;
      }
    }
    paramView = this.a.jdField_i_of_type_JavaUtilArrayList.iterator();
    do
    {
      if (!paramView.hasNext()) {
        break;
      }
    } while (((ResultRecord)paramView.next()).jdField_a_of_type_Int == 5);
    for (int i = 1;; i = 0)
    {
      if ((this.a.jdField_a_of_type_AndroidContentIntent != null) && (this.a.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("ShowJoinDiscTips", false)) && (i != 0))
      {
        DialogUtil.b(this.a, 230, this.a.getString(2131429041), this.a.getString(2131433989), 2131429048, 2131429053, new ybf(this), new ybg(this)).show();
        ReportController.b(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        return;
      }
      if ((this.a.f == 12) && (this.a.jdField_i_of_type_Int == 1)) {
        if (this.a.jdField_i_of_type_JavaUtilArrayList.size() == 1)
        {
          localObject1 = (ResultRecord)this.a.jdField_i_of_type_JavaUtilArrayList.get(0);
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject2).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject1).jdField_a_of_type_Int);
          if ((((ResultRecord)localObject1).jdField_a_of_type_Int == 0) && (((ResultRecord)localObject1).jdField_a_of_type_Int != 1)) {
            break label1628;
          }
          i = 1000;
        }
      }
      for (paramView = this.a.a(((ResultRecord)localObject1).jdField_c_of_type_JavaLangString);; paramView = null)
      {
        if (((ResultRecord)localObject1).jdField_a_of_type_Int == 2)
        {
          paramView = ((ResultRecord)localObject1).jdField_c_of_type_JavaLangString;
          i = 1004;
        }
        for (;;)
        {
          if (((ResultRecord)localObject1).jdField_a_of_type_Int == 3) {
            i = 1021;
          }
          label900:
          label1054:
          label1078:
          label1619:
          label1622:
          for (;;)
          {
            Object localObject3 = ((FriendsManager)this.a.app.getManager(50)).c(((ResultRecord)localObject1).jdField_a_of_type_JavaLangString);
            int j = i;
            if (localObject3 != null)
            {
              j = i;
              if (((Friends)localObject3).isFriend()) {
                j = 0;
              }
            }
            localObject3 = new Bundle();
            ((Bundle)localObject3).putString("uin", ((ResultRecord)localObject1).jdField_a_of_type_JavaLangString);
            ((Bundle)localObject3).putInt("uintype", j);
            ((Bundle)localObject3).putString("uinname", ((ResultRecord)localObject1).b);
            ((Bundle)localObject3).putString("troop_uin", paramView);
            ((Intent)localObject2).putExtras((Bundle)localObject3);
            this.a.setResult(-1, (Intent)localObject2);
            this.a.finish();
            label1022:
            ReportController.b(this.a.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
            if (this.a.d == 1)
            {
              paramView = this.a.jdField_i_of_type_JavaUtilArrayList.iterator();
              i = 0;
              if (!paramView.hasNext()) {
                break label1500;
              }
              localObject1 = (ResultRecord)paramView.next();
              if ((((ResultRecord)localObject1).jdField_a_of_type_Int != 1) && (((ResultRecord)localObject1).jdField_a_of_type_Int != 2)) {
                break label1619;
              }
              i += 1;
            }
            for (;;)
            {
              break label1078;
              if (((ResultRecord)localObject1).jdField_a_of_type_Int != 4) {
                break label1622;
              }
              i = 1006;
              break label900;
              this.a.a();
              break label1022;
              if (this.a.f == 23)
              {
                paramView = new Intent();
                localObject1 = new Bundle();
                localObject2 = new ArrayList();
                localObject3 = this.a.jdField_i_of_type_JavaUtilArrayList.iterator();
                while (((Iterator)localObject3).hasNext())
                {
                  ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
                  if (localResultRecord.jdField_a_of_type_Int == 1) {
                    ((ArrayList)localObject2).add(localResultRecord.jdField_a_of_type_JavaLangString);
                  }
                }
                ((Bundle)localObject1).putStringArrayList("troopMemList", (ArrayList)localObject2);
                paramView.putExtras((Bundle)localObject1);
                this.a.setResult(-1, paramView);
                this.a.finish();
                break label1054;
              }
              if (this.a.f == 24)
              {
                paramView = new Intent();
                localObject1 = new Bundle();
                ((Bundle)localObject1).putParcelableArrayList("friendsSelected", this.a.jdField_i_of_type_JavaUtilArrayList);
                paramView.putExtras((Bundle)localObject1);
                this.a.setResult(-1, paramView);
                if (this.a.v) {
                  StoryReportor.a("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
                for (;;)
                {
                  this.a.finish();
                  break;
                  StoryReportor.a("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
              }
              if ((this.a.jdField_c_of_type_Int == 3000) && (this.a.d == 0) && (this.a.f != 10) && (this.a.f != 13))
              {
                this.a.k();
                break label1054;
              }
              this.a.a();
              break label1054;
              break label197;
              label1500:
              if (i <= 0) {
                break;
              }
              paramView = ((TroopManager)this.a.app.getManager(51)).b(this.a.jdField_c_of_type_JavaLangString);
              if (paramView == null) {
                break;
              }
              localObject1 = this.a.app.c();
              if (paramView.isTroopOwner((String)localObject1)) {
                j = 0;
              }
              for (;;)
              {
                ReportController.b(this.a.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.a.jdField_c_of_type_JavaLangString, String.valueOf(j), String.valueOf(i), "");
                return;
                if (paramView.isTroopAdmin((String)localObject1)) {
                  j = 1;
                } else {
                  j = 2;
                }
              }
            }
          }
        }
        label1628:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ybe
 * JD-Core Version:    0.7.0.1
 */