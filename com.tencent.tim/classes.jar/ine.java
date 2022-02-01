import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ine
  implements aolm.b
{
  ine(ind.a parama, String paramString, imz paramimz, int paramInt) {}
  
  public void onResp(aomh paramaomh)
  {
    aoll localaoll = (aoll)paramaomh.b;
    if (this.b.d == localaoll) {
      this.b.d = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGPDownloadManager", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaoll.bZ, Integer.valueOf(paramaomh.mResult), Integer.valueOf(paramaomh.dPy), this.val$md5 }));
    }
    int i;
    if (paramaomh.mResult == 0)
    {
      paramaomh = new File(localaoll.atY);
      if (paramaomh.exists())
      {
        try
        {
          String str = paramaomh.getParent();
          aqhq.W(localaoll.atY, str, false);
          QLog.d("QavGPDownloadManager", 1, String.format("downloadRes, 下载成功了. path[%s]", new Object[] { str }));
          ind.a(this.c);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          ind.le(-1);
          return;
        }
        paramaomh.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        ind.le(100 / this.b.aqn + this.b.aqo);
        paramaomh = this.b;
        paramaomh.aqo += 100 / this.b.aqn;
        if (!this.b.a(this.c, this.aqp - 1)) {
          this.b.SR = false;
        }
        return;
      }
      i = 0;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      ind.le(i / this.b.aqn + this.b.aqo);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ine
 * JD-Core Version:    0.7.0.1
 */