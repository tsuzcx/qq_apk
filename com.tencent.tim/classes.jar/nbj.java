import com.tencent.biz.pubaccount.readinjoy.video.player.ReadInjoyPlayer.1.1;
import com.tencent.qphone.base.util.QLog;

public class nbj
  implements kxv.a
{
  nbj(nbi paramnbi, String paramString, long paramLong, int paramInt) {}
  
  public void b(kxz paramkxz)
  {
    if (paramkxz == null)
    {
      QLog.d(nbi.a(this.b), 2, "UUIDToUrlCallback videoUrlInfo == null RETURN");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(nbi.a(this.b), 2, "UUIDToUrlCallback Callback vid=" + paramkxz.vid + ", url=" + paramkxz.url + ", isH265=" + paramkxz.aiJ + ", isHWCodec=" + paramkxz.Tx + ", fileBitRate=" + paramkxz.adD + ", hwBackupUrl=" + paramkxz.adF);
    }
    nbg.runOnUiThread(new ReadInjoyPlayer.1.1(this, paramkxz));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nbj
 * JD-Core Version:    0.7.0.1
 */