import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr;
import com.tencent.mobileqq.shortvideo.util.RecentDanceConfigMgr.DItemInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public final class ankr
  implements aolm.b
{
  public ankr(RecentDanceConfigMgr.DItemInfo paramDItemInfo, String paramString) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 0)
    {
      paramaomh = paramaomh.b;
      if (new File(paramaomh.atY).exists())
      {
        str = RecentDanceConfigMgr.access$200(paramaomh.atY);
        if ((str == null) || ("".equals(str)) || (!str.equalsIgnoreCase(this.a.icon_md5)))
        {
          aqhq.deleteFile(paramaomh.atY);
          aqhq.deleteFile(this.ceB);
          if (QLog.isColorLevel()) {
            QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: item.icon_md5" + this.a.icon_md5 + " md5=" + str);
          }
        }
      }
      while (!QLog.isColorLevel())
      {
        String str;
        return;
        if (QLog.isColorLevel()) {
          QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: check success");
        }
        aqhq.rename(paramaomh.atY, this.ceB);
        RecentDanceConfigMgr.d(this.a, this.ceB);
        return;
      }
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp[not exists]: mOutPath" + paramaomh.atY);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onResp: resp.mResult=" + paramaomh.mResult);
    }
    aqhq.deleteFile(paramaomh.b.atY);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RecentDanceConfigMgr", 2, "processNetWork onUpdateProgeress: totalLen=" + paramLong2 + " curOffset=" + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ankr
 * JD-Core Version:    0.7.0.1
 */