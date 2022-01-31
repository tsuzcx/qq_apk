import QQService.DiscussMemberInfo;
import QQService.InteRemarkInfo;
import QQService.RespGetDiscussInfo;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.JoinDiscussionActivity;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.DiscussionObserver;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class arm
  extends DiscussionObserver
{
  private arm(JoinDiscussionActivity paramJoinDiscussionActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, RespGetDiscussInfo paramRespGetDiscussInfo)
  {
    if (paramBoolean)
    {
      JoinDiscussionActivity.a(this.a);
      this.a.d = String.valueOf(paramRespGetDiscussInfo.DiscussUin);
      this.a.jdField_c_of_type_JavaLangString = paramRespGetDiscussInfo.Name;
      this.a.jdField_a_of_type_JavaUtilList = paramRespGetDiscussInfo.Members;
      this.a.jdField_a_of_type_Long = paramRespGetDiscussInfo.OwnerUin;
      this.a.b = (paramRespGetDiscussInfo.CreateTime * 1000L);
      HashMap localHashMap = new HashMap();
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        Iterator localIterator = this.a.jdField_a_of_type_JavaUtilList.iterator();
        Object localObject2;
        Object localObject1;
        if (localIterator.hasNext())
        {
          localObject2 = (DiscussMemberInfo)localIterator.next();
          if (((DiscussMemberInfo)localObject2).Uin == this.a.jdField_a_of_type_Long) {
            this.a.e = ((DiscussMemberInfo)localObject2).StInteRemark.StrValue;
          }
          l = ((DiscussMemberInfo)localObject2).Uin;
          localObject1 = null;
          if (0 == 0)
          {
            localObject1 = new DiscussionMemberInfo();
            ((DiscussionMemberInfo)localObject1).discussionUin = this.a.d;
            ((DiscussionMemberInfo)localObject1).memberUin = String.valueOf(l);
          }
          ((DiscussionMemberInfo)localObject1).flag = ((DiscussMemberInfo)localObject2).Flag;
          if ((((DiscussMemberInfo)localObject2).StInteRemark != null) && (!TextUtils.isEmpty(((DiscussMemberInfo)localObject2).StInteRemark.StrValue)))
          {
            ((DiscussionMemberInfo)localObject1).inteRemark = ((DiscussMemberInfo)localObject2).StInteRemark.StrValue;
            ((DiscussionMemberInfo)localObject1).inteRemarkSource = ((DiscussMemberInfo)localObject2).StInteRemark.Source;
          }
          for (;;)
          {
            localHashMap.put(((DiscussionMemberInfo)localObject1).memberUin, localObject1);
            break;
            if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject1).inteRemark))
            {
              localObject2 = ((FriendsManager)this.a.app.getManager(43)).a(((DiscussionMemberInfo)localObject1).memberUin);
              if ((localObject2 != null) && (((Friends)localObject2).isFriend()))
              {
                ((DiscussionMemberInfo)localObject1).memberName = ((Friends)localObject2).name;
                if (TextUtils.isEmpty(((Friends)localObject2).remark)) {}
                for (localObject2 = ((Friends)localObject2).name;; localObject2 = ((Friends)localObject2).remark)
                {
                  ((DiscussionMemberInfo)localObject1).inteRemark = ((String)localObject2);
                  ((DiscussionMemberInfo)localObject1).inteRemarkSource = 129L;
                  break;
                }
              }
              ((DiscussionMemberInfo)localObject1).inteRemarkSource = 0L;
            }
          }
        }
        this.a.jdField_c_of_type_Int = Math.min(this.a.jdField_a_of_type_JavaUtilList.size(), 5);
        this.a.jdField_a_of_type_JavaUtilArrayList.clear();
        this.a.f = "";
        paramInt = 0;
        while (paramInt < this.a.jdField_c_of_type_Int)
        {
          localObject1 = String.valueOf(((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin);
          if (this.a.app.a((String)localObject1, true) != null)
          {
            this.a.jdField_a_of_type_JavaUtilArrayList.add(localObject1);
            localObject1 = new StringBuilder();
            localObject2 = this.a;
            ((JoinDiscussionActivity)localObject2).f = (((JoinDiscussionActivity)localObject2).f + String.valueOf(((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin) + ";");
          }
          paramInt += 1;
        }
      }
      long l = paramRespGetDiscussInfo.DiscussFlag;
      this.a.jdField_c_of_type_JavaLangString = ContactUtils.a(this.a.app, this.a.d, String.valueOf(this.a.jdField_a_of_type_Long), l | 0x20000000, paramRespGetDiscussInfo.Name, localHashMap);
      if (this.a.jdField_a_of_type_JavaUtilArrayList.size() == this.a.jdField_c_of_type_Int)
      {
        paramRespGetDiscussInfo = this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.a(this.a.f);
        this.a.runOnUiThread(new arn(this, paramRespGetDiscussInfo));
      }
      this.a.runOnUiThread(new aro(this));
      return;
    }
    this.a.a(0, paramInt);
  }
  
  protected void a(boolean paramBoolean, long paramLong, int paramInt)
  {
    String str;
    if (paramBoolean)
    {
      ReportController.b(this.a.app, "CliOper", "", this.a.app.a(), "discuss", "discuss_QR_join", 0, 0, "", "", "", "");
      JoinDiscussionActivity.b(this.a);
      str = String.valueOf(paramLong);
      if ((str != null) && (str.length() > 0))
      {
        if (this.a.jdField_a_of_type_JavaUtilList == null) {
          break label292;
        }
        paramLong = Long.parseLong(this.a.app.a());
        paramInt = 0;
        if (paramInt >= this.a.jdField_a_of_type_JavaUtilList.size()) {
          break label292;
        }
        if (((DiscussMemberInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).Uin != paramLong) {
          break label272;
        }
      }
    }
    label272:
    label292:
    for (paramInt = 1;; paramInt = 0)
    {
      if (paramInt != 0) {
        QQToast.a(this.a, "你已是讨论组成员", 0).b(this.a.getTitleBarHeight());
      }
      Intent localIntent = new Intent(this.a, ChatActivity.class);
      localIntent.putExtra("uin", str);
      localIntent.putExtra("uintype", 3000);
      localIntent.putExtra("uinname", this.a.jdField_c_of_type_JavaLangString);
      localIntent.putExtra("isBack2Root", true);
      localIntent.putExtra("isFromDiscussionFlyTicket", true);
      localIntent.addFlags(67108864);
      this.a.startActivity(localIntent);
      this.a.finish();
      return;
      paramInt += 1;
      break;
      this.a.a(1, paramInt);
      return;
    }
  }
  
  protected void c(boolean paramBoolean, String paramString)
  {
    if (paramBoolean)
    {
      this.a.jdField_a_of_type_JavaLangString = paramString;
      this.a.jdField_a_of_type_ComTencentMobileqqAppDiscussionHandler.c(this.a.jdField_a_of_type_JavaLangString);
      return;
    }
    this.a.a(0, -161);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     arm
 * JD-Core Version:    0.7.0.1
 */