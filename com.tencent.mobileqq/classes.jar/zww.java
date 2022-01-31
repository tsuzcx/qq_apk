import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.utils.DingdongPluginBizHandler;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.data.OfficeCenterSharedPref;
import java.util.List;
import tencent.im.oidb.cmd0x508.oidb_0x508.RspBody;

public class zww
  extends AsyncTask
{
  public zww(DingdongPluginBizHandler paramDingdongPluginBizHandler, oidb_0x508.RspBody paramRspBody) {}
  
  protected Boolean a(Void... paramVarArgs)
  {
    return Boolean.valueOf(DingdongPluginHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizHandler.b.getApplication()));
  }
  
  protected void a(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue())
    {
      if (this.jdField_a_of_type_TencentImOidbCmd0x508Oidb_0x508$RspBody.rpt_uint64_appid_list.has())
      {
        List localList = this.jdField_a_of_type_TencentImOidbCmd0x508Oidb_0x508$RspBody.rpt_uint64_appid_list.get();
        int j = localList.size();
        if (j > 0)
        {
          paramBoolean = "";
          int i = 0;
          String str;
          while (i < j)
          {
            str = paramBoolean + localList.get(i);
            paramBoolean = str;
            if (i != j - 1) {
              paramBoolean = str + ",";
            }
            i += 1;
          }
          QLog.i("DingdongPluginBizHandler", 4, "officecenter: handleRspMsg_0x508_1 set app id list: " + paramBoolean);
          if (paramBoolean.length() > 0)
          {
            str = "officecenter_user_apps_list_txt_" + this.jdField_a_of_type_ComTencentMobileqqAppUtilsDingdongPluginBizHandler.b.getLongAccountUin();
            OfficeCenterSharedPref.a().a(str, paramBoolean);
          }
        }
      }
      return;
    }
    QLog.i("DingdongPluginBizHandler", 1, "officecenter: handleRspMsg_0x508_1 dingdong is running, no set list plz.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zww
 * JD-Core Version:    0.7.0.1
 */