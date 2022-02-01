import android.os.AsyncTask;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.oidb.cmd0x508.oidb_0x508.RspBody;

class atng
  extends AsyncTask<Void, Void, Boolean>
{
  atng(atnf paramatnf, oidb_0x508.RspBody paramRspBody) {}
  
  protected Boolean doInBackground(Void... paramVarArgs)
  {
    return Boolean.valueOf(atni.cy(this.this$0.app.getApplication()));
  }
  
  protected void onPostExecute(Boolean paramBoolean)
  {
    if (!paramBoolean.booleanValue())
    {
      if (this.a.rpt_uint64_appid_list.has())
      {
        List localList = this.a.rpt_uint64_appid_list.get();
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
            str = "officecenter_user_apps_list_txt_" + this.this$0.app.getLongAccountUin();
            atne.a().cl(str, paramBoolean);
          }
        }
      }
      return;
    }
    QLog.i("DingdongPluginBizHandler", 1, "officecenter: handleRspMsg_0x508_1 dingdong is running, no set list plz.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atng
 * JD-Core Version:    0.7.0.1
 */