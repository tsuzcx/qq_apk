import com.tencent.mobileqq.shortvideo.gesture.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class anhu
  implements aolm.b
{
  anhu(anht.a parama, String paramString, DownloadInfo paramDownloadInfo, int paramInt1, int paramInt2) {}
  
  public void onResp(aomh paramaomh)
  {
    aoll localaoll = (aoll)paramaomh.b;
    if (this.b.d == localaoll) {
      this.b.d = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavGesture", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaoll.bZ, Integer.valueOf(paramaomh.mResult), Integer.valueOf(paramaomh.dPy), this.val$md5 }));
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
          anht.a(this.c, this.auP);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          anht.le(-1);
          this.b.SR = false;
          return;
        }
        paramaomh.delete();
      }
    }
    for (;;)
    {
      if (i != 0)
      {
        anht.le(100 / this.b.aqn + this.b.aqo);
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
      anht.le(i / this.b.aqn + this.b.aqo);
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhu
 * JD-Core Version:    0.7.0.1
 */