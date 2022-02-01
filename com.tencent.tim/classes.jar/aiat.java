import com.tencent.qphone.base.util.QLog;
import java.io.IOException;

class aiat
  implements aolm.b
{
  aiat(aiaq paramaiaq, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3)
    {
      QLog.d("qqidentification_server", 2, "identification res download repeating ");
      return;
    }
    if (paramaomh.mResult == 0)
    {
      paramaomh = paramaomh.b.atY;
      String str = aqhq.px(paramaomh);
      if ((str == null) || (!str.equalsIgnoreCase(this.aVy))) {}
    }
    for (;;)
    {
      try
      {
        aqhq.W(paramaomh, this.aVx, false);
        QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but unzip is failed");
      }
      catch (IOException localIOException1)
      {
        try
        {
          aiaq.a(this.this$0).destroy();
          aiaq.a(this.this$0, null);
          bool = true;
          aqhq.deleteFile(paramaomh);
          if (QLog.isColorLevel()) {
            QLog.d("qqidentification_server", 2, "downloadRes.onResp download path : " + this.aVx);
          }
          QLog.d("qqidentification_server", 1, new Object[] { "download face res success : ", Boolean.valueOf(bool) });
          if (bool)
          {
            aqmj.UX(this.aVx);
            aqmj.XE(this.cPs);
            aqmj.XF(aiao.Fy());
          }
          aiaq.a(this.this$0, 1, bool);
          return;
        }
        catch (IOException localIOException2)
        {
          for (;;)
          {
            boolean bool = true;
          }
        }
        localIOException1 = localIOException1;
        bool = false;
      }
      continue;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp download succ but md5 is mismatched ");
      if (QLog.isColorLevel()) {
        QLog.d("qqidentification_server", 2, "downloadRes.onResp download succ but md5 is mismatched,fileSize = " + aqhq.getFileSizes(paramaomh) + ",md5 = " + localIOException1 + ",url = " + this.val$url);
      }
      bool = false;
      continue;
      QLog.d("qqidentification_server", 1, "downloadRes.onResp failed  isSuccess is false");
      bool = false;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aiat
 * JD-Core Version:    0.7.0.1
 */