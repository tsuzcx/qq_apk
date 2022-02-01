import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendFragment;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.pb.profilecard.EditExtendFriendInfo.SchoolInfo;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0xdb1.oidb_0xdb1.SchoolInfo;

public class afuy
  extends afsr
{
  public afuy(ExtendFriendFragment paramExtendFriendFragment) {}
  
  protected void Be(int paramInt)
  {
    aizy.a(ExtendFriendFragment.a(this.this$0), ExtendFriendFragment.a(this.this$0).app);
    Intent localIntent = new Intent("match_chat_notify_update");
    BaseApplicationImpl.getApplication().sendBroadcast(localIntent);
  }
  
  protected void aB(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateSignalBombPush " + paramBoolean + " " + paramString);
    }
    if ((ExtendFriendFragment.a(this.this$0) != null) && (ExtendFriendFragment.a(this.this$0).isResume()) && (((afwh)ExtendFriendFragment.a(this.this$0).app.getManager(292)).getState() != 2) && (!ExtendFriendFragment.a(this.this$0))) {
      ExtendFriendFragment.a(this.this$0, afwz.a(ExtendFriendFragment.a(this.this$0), ExtendFriendFragment.a(this.this$0).app, ExtendFriendFragment.a(this.this$0)));
    }
  }
  
  protected void as(boolean paramBoolean, int paramInt)
  {
    int i = ExtendFriendFragment.a(this.this$0).DA();
    String str1 = ExtendFriendFragment.a(this.this$0).uG();
    String str2 = ExtendFriendFragment.a(this.this$0).uH();
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateCampusCertificateStatus,isSuccess + " + paramBoolean + ",scene + " + paramInt + ",verifyStatus + " + i + ",serverSuggestSchoolName + " + str1);
    }
    if ((paramBoolean) && (paramInt == 1))
    {
      if (((i == 0) || (i == 3)) && (!afxn.ax(ExtendFriendFragment.a(this.this$0))) && (TextUtils.isEmpty(str2)))
      {
        afxn.D(ExtendFriendFragment.a(this.this$0), str1);
        afxn.cS(ExtendFriendFragment.a(this.this$0));
      }
      Object localObject = ExtendFriendFragment.a(this.this$0).a();
      str2 = ExtendFriendFragment.a(this.this$0).uH();
      if ((!TextUtils.isEmpty(str2)) && (localObject != null) && (!ExtendFriendFragment.a(this.this$0).isFinishing()))
      {
        if (!((oidb_0xdb1.SchoolInfo)localObject).str_school_name.has()) {
          break label307;
        }
        str1 = ((oidb_0xdb1.SchoolInfo)localObject).str_school_name.get();
        afsg localafsg = (afsg)ExtendFriendFragment.a(this.this$0).getBusinessHandler(127);
        localObject = afxn.a((oidb_0xdb1.SchoolInfo)localObject);
        afxn.a(ExtendFriendFragment.a(this.this$0), localafsg, str1, (EditExtendFriendInfo.SchoolInfo)localObject);
      }
      if (TextUtils.isEmpty(str2)) {
        break label314;
      }
      paramInt = 1;
      label276:
      if (paramInt == 0) {
        break label319;
      }
    }
    label307:
    label314:
    label319:
    for (paramInt = 1;; paramInt = 2)
    {
      anot.a(null, "dc00898", "", "", "0X800ADD7", "0X800ADD7", paramInt, 0, "", "", "", "");
      return;
      str1 = "";
      break;
      paramInt = 0;
      break label276;
    }
  }
  
  protected void bl(boolean paramBoolean, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendFragment", 2, "onUpdateExtendFriendCampusSchoolInfo isSuccess = " + paramBoolean);
    }
    if (paramBoolean) {
      QQToast.a(ExtendFriendFragment.a(this.this$0), 2, 2131701092, 0).show(ExtendFriendFragment.a(this.this$0).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afuy
 * JD-Core Version:    0.7.0.1
 */