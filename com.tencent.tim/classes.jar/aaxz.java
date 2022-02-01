import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.activity.selectmember.SelectMemberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class aaxz
  implements View.OnClickListener
{
  public aaxz(SelectMemberActivity paramSelectMemberActivity) {}
  
  public void onClick(View paramView)
  {
    if (this.this$0.mIntent.getBooleanExtra("show_invite_entry", false)) {
      ivc.a(this.this$0.app, this.this$0, paramView, this.this$0.mIntent);
    }
    label101:
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.this$0.eK == 11)
      {
        if (this.this$0.a.uy() == 0) {
          anot.a(this.this$0.app, "CliOper", "", "", "0X8005527", "0X8005527", 0, 0, "", "", "", "");
        }
      }
      else if (this.this$0.bGG == 3)
      {
        localObject2 = this.this$0.getIntent().getStringExtra("group_uin");
        localObject3 = jlk.a(this.this$0.app, this.this$0.app.getCurrentAccountUin(), (String)localObject2) + "";
        if (!"发起视频".equals(this.this$0.mRightBtn.getText().toString())) {
          break label295;
        }
      }
      label295:
      for (localObject1 = "0";; localObject1 = "1")
      {
        anot.a(null, "dc00899", "Grp_video", "", "invite", "Clk_call", 0, 0, (String)localObject2, (String)localObject3, (String)localObject1, "");
        if (this.this$0.eK != 33) {
          break label302;
        }
        zzn.a(this.this$0, this.this$0.aQ);
        break;
        if (this.this$0.a.uy() != 1) {
          break label101;
        }
        anot.a(this.this$0.app, "CliOper", "", "", "0X8005526", "0X8005526", 0, 0, "", "", "", "");
        break label101;
      }
      label302:
      if ((this.this$0.eK == 32) && (this.this$0.aQ.size() > this.this$0.cms))
      {
        localObject1 = MessageFormat.format(this.this$0.getString(2131719449), new Object[] { Integer.valueOf(this.this$0.cms) });
        QQToast.a(this.this$0, (CharSequence)localObject1, 0).show(this.this$0.mTitleBar.getHeight());
      }
      else if ((!aqiw.isNetSupport(this.this$0)) && (this.this$0.eK != 41))
      {
        QQToast.a(this.this$0, this.this$0.getString(2131693404), 0).show(this.this$0.mTitleBar.getHeight());
      }
      else
      {
        if ((!this.this$0.bBb) || (this.this$0.aQ.size() != 1) || (this.this$0.aQ.get(0) == null)) {
          break;
        }
        localObject1 = (ResultRecord)this.this$0.aQ.get(0);
        localObject2 = this.this$0.app.getCurrentUin();
        if ((localObject2 == null) || (((ResultRecord)localObject1).uin == null) || (!((String)localObject2).equals(((ResultRecord)localObject1).uin))) {
          break;
        }
        QQToast.a(this.this$0, this.this$0.getString(2131719447), 0).show(this.this$0.mTitleBar.getHeight());
      }
    }
    Object localObject1 = this.this$0.aQ.iterator();
    do
    {
      if (!((Iterator)localObject1).hasNext()) {
        break;
      }
    } while (((ResultRecord)((Iterator)localObject1).next()).type == 5);
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.i("SelectMemberActivity", 2, "right btn click entrance[" + this.this$0.eK + "], uinType[" + this.this$0.mType + "], nopstn[" + bool + "]");
      }
      if (((this.this$0.eK == 36) || (this.this$0.eK == 11)) && (bool))
      {
        aqha.a(this.this$0, 230, this.this$0.getString(2131697879), this.this$0.getString(2131721279), 2131697614, 2131691970, new aaya(this), new aayb(this)).show();
        anot.a(null, "CliOper", "", "", "0X8004CED", "0X8004CED", 0, 0, "", "", "", "");
        break;
      }
      int i;
      if ((this.this$0.eK == 12) && (this.this$0.cms == 1)) {
        if (this.this$0.aQ.size() == 1)
        {
          localObject2 = (ResultRecord)this.this$0.aQ.get(0);
          localObject3 = new Intent();
          ((Intent)localObject3).putExtra("select_memeber_single_friend", true);
          ((Intent)localObject3).putExtra("select_memeber_single_friend_type", ((ResultRecord)localObject2).type);
          if ((((ResultRecord)localObject2).type == 0) && (((ResultRecord)localObject2).type != 1)) {
            break label1917;
          }
          i = 1000;
        }
      }
      for (localObject1 = this.this$0.in(((ResultRecord)localObject2).QD);; localObject1 = null)
      {
        if (((ResultRecord)localObject2).type == 2)
        {
          localObject1 = ((ResultRecord)localObject2).QD;
          i = 1004;
        }
        label1176:
        for (;;)
        {
          if (((ResultRecord)localObject2).type == 3) {
            i = 1021;
          }
          label1075:
          label1107:
          label1903:
          label1911:
          for (;;)
          {
            Object localObject4 = ((acff)this.this$0.app.getManager(51)).e(((ResultRecord)localObject2).uin);
            int j = i;
            if (localObject4 != null)
            {
              j = i;
              if (((Friends)localObject4).isFriend()) {
                j = 0;
              }
            }
            localObject4 = new Bundle();
            ((Bundle)localObject4).putString("uin", ((ResultRecord)localObject2).uin);
            ((Bundle)localObject4).putInt("uintype", j);
            ((Bundle)localObject4).putString("uinname", ((ResultRecord)localObject2).name);
            ((Bundle)localObject4).putString("troop_uin", (String)localObject1);
            ((Intent)localObject3).putExtras((Bundle)localObject4);
            this.this$0.setResult(-1, (Intent)localObject3);
            this.this$0.finish();
            anot.a(this.this$0.app, "CliOper", "", "", "0X8006664", "0X8006664", 0, 0, "", "", "", "");
            for (;;)
            {
              if (this.this$0.bGG == 1)
              {
                localObject1 = this.this$0.aQ.iterator();
                i = 0;
                while (((Iterator)localObject1).hasNext())
                {
                  localObject2 = (ResultRecord)((Iterator)localObject1).next();
                  if ((((ResultRecord)localObject2).type != 1) && (((ResultRecord)localObject2).type != 2)) {
                    break label1903;
                  }
                  i += 1;
                }
                if (((ResultRecord)localObject2).type != 4) {
                  break label1911;
                }
                i = 1006;
                break;
                this.this$0.cjw();
                break label1075;
                if (this.this$0.eK == 23)
                {
                  localObject1 = new Intent();
                  localObject2 = new Bundle();
                  localObject3 = new ArrayList();
                  localObject4 = this.this$0.aQ.iterator();
                  while (((Iterator)localObject4).hasNext())
                  {
                    ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject4).next();
                    if (localResultRecord.type == 1) {
                      ((ArrayList)localObject3).add(localResultRecord.uin);
                    }
                  }
                  ((Bundle)localObject2).putStringArrayList("troopMemList", (ArrayList)localObject3);
                  ((Intent)localObject1).putExtras((Bundle)localObject2);
                  this.this$0.setResult(-1, (Intent)localObject1);
                  this.this$0.finish();
                }
                else if ((this.this$0.eK == 41) && (!TextUtils.isEmpty(this.this$0.mIntent.getStringExtra("checkDiscussion"))))
                {
                  localObject1 = this.this$0.mIntent.getStringExtra("checkDiscussion");
                  localObject2 = (acdu)this.this$0.app.getManager(53);
                  localObject3 = this.this$0.aQ.iterator();
                  do
                  {
                    if (!((Iterator)localObject3).hasNext()) {
                      break;
                    }
                  } while (((acdu)localObject2).a((String)localObject1, ((ResultRecord)((Iterator)localObject3).next()).uin) != null);
                }
              }
            }
            for (i = 1;; i = 0)
            {
              if (i != 0)
              {
                aqha.a(this.this$0, 230, this.this$0.getString(2131719063), this.this$0.getString(2131719061), 2131719060, 2131719062, new aayc(this), new aayd(this)).show();
                break label1107;
              }
              this.this$0.cjw();
              break label1107;
              if (this.this$0.eK == 24)
              {
                localObject1 = new Intent();
                localObject2 = new Bundle();
                ((Bundle)localObject2).putParcelableArrayList("friendsSelected", this.this$0.aQ);
                ((Intent)localObject1).putExtras((Bundle)localObject2);
                this.this$0.setResult(-1, (Intent)localObject1);
                if (this.this$0.bAY) {
                  rar.a("set_notsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
                for (;;)
                {
                  this.this$0.finish();
                  break;
                  rar.a("set_notletsee", "clk_done", 0, 0, new String[] { "", "", "", "" });
                }
              }
              if (this.this$0.eK == 37)
              {
                this.this$0.mIntent.putParcelableArrayListExtra("result_set", this.this$0.aQ);
                this.this$0.setResult(-1, this.this$0.mIntent);
                this.this$0.finish();
                break label1107;
              }
              if ((this.this$0.mType == 3000) && (this.this$0.bGG == 0))
              {
                this.this$0.cAe();
                break label1107;
              }
              this.this$0.cjw();
              break label1107;
              break;
              if (i <= 0) {
                break;
              }
              localObject1 = ((TroopManager)this.this$0.app.getManager(52)).c(this.this$0.aRJ);
              if (localObject1 == null) {
                break;
              }
              localObject2 = this.this$0.app.getCurrentUin();
              if (((TroopInfo)localObject1).isTroopOwner((String)localObject2)) {
                j = 0;
              }
              for (;;)
              {
                anot.a(this.this$0.app, "dc00899", "invite_friend", "", "friend_list", "invite_friend", 0, 0, this.this$0.aRJ, String.valueOf(j), String.valueOf(i), "");
                break;
                if (((TroopInfo)localObject1).isTroopAdmin((String)localObject2)) {
                  j = 1;
                } else {
                  j = 2;
                }
              }
              break label1176;
            }
          }
        }
        label1917:
        i = 0;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaxz
 * JD-Core Version:    0.7.0.1
 */