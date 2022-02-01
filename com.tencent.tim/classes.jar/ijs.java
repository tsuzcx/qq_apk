import android.os.Handler;
import android.os.Message;
import com.tencent.av.business.manager.EffectConfigBase;
import com.tencent.av.business.manager.EffectConfigBase.b;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

public class ijs
  implements aolm.b
{
  public ijs(EffectConfigBase paramEffectConfigBase, long paramLong, EffectConfigBase.b paramb) {}
  
  public void onResp(aomh paramaomh)
  {
    int i = 0;
    EffectConfigBase.b localb = (EffectConfigBase.b)paramaomh.b.U();
    String str1 = "";
    if (paramaomh.mResult == 3)
    {
      QLog.w(this.this$0.TAG, 1, "startDownload, onResp, 重复下载, item[" + localb + "], seq[" + this.kQ + "]");
      return;
    }
    boolean bool;
    if (paramaomh.mResult != 0)
    {
      str1 = "fail, mErrCode[" + paramaomh.mErrCode + "], mErrDesc[" + paramaomh.clO + "]";
      bool = false;
    }
    for (;;)
    {
      QLog.w(this.this$0.TAG, 1, "startDownload, onResp, result[" + bool + "], resp.mResult[" + paramaomh.mResult + "], item[" + localb + "], seq[" + this.kQ + "], " + str1 + "]");
      localb.isDownloading = false;
      paramaomh = this.this$0.ar;
      if (bool) {
        i = 1;
      }
      paramaomh.obtainMessage(1, i, (int)this.kQ, this.c).sendToTarget();
      if (!bool) {
        break;
      }
      this.this$0.a(this.c);
      return;
      String str3 = SecUtil.getFileMd5(paramaomh.b.atY);
      if (!localb.getMd5().equalsIgnoreCase(str3))
      {
        str1 = "fail, md5不匹配, fileMD5[" + str3 + "], configMD5[" + localb.getMd5() + "], mOutPath[" + paramaomh.b.atY + "]";
        bool = false;
      }
      else
      {
        try
        {
          aqhq.W(paramaomh.b.atY, this.this$0.b(this.c), false);
          bool = true;
        }
        catch (IOException localIOException)
        {
          if (QLog.isColorLevel()) {
            QLog.i(this.this$0.TAG, 4, "startDownload, uncompressZip fail.", localIOException);
          }
          String str2 = acfp.m(2131705750);
          bool = false;
        }
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    this.this$0.ar.obtainMessage(2, (int)(100L * paramLong1 / paramLong2), 0, this.c).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijs
 * JD-Core Version:    0.7.0.1
 */