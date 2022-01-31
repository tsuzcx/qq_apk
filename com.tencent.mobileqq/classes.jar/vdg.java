import android.os.Bundle;
import com.tencent.biz.qqstory.network.pb.qqstory_service.RspIconPostfix;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;

public class vdg
  extends uuc
{
  qqstory_service.RspIconPostfix a;
  
  public vdg() {}
  
  public vdg(qqstory_service.RspIconPostfix paramRspIconPostfix)
  {
    super(paramRspIconPostfix.result);
    this.a = paramRspIconPostfix;
  }
  
  public void a()
  {
    if ((this.a.icon_info.has()) && (this.a.icon_info.size() > 0)) {
      Bosses.get().postJob(new vdh(this, "GetUserIconHandler"));
    }
  }
  
  public void a(int paramInt, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GetUserIconHandler", 2, "GetUserIconListResponse onNetError errorCode " + paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.e("GetUserIconHandler", 2, "GetUserIconListResponse errorCode:" + paramInt + " errorMsg:" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */