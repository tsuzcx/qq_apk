import com.tencent.av.so.DownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class iwf
  implements aolm.b
{
  iwf(iwe.a parama, String paramString, int paramInt1, DownloadInfo paramDownloadInfo, int paramInt2) {}
  
  public void onResp(aomh paramaomh)
  {
    aoll localaoll = (aoll)paramaomh.b;
    if (this.b.d == localaoll) {
      this.b.d = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("QavSo", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaoll.bZ, Integer.valueOf(paramaomh.mResult), Integer.valueOf(paramaomh.dPy), this.val$md5 }));
    }
    int i;
    if (paramaomh.mResult == 0)
    {
      paramaomh = new File(localaoll.atY);
      if (paramaomh.exists())
      {
        try
        {
          if (!iwe.o(localaoll.atY, this.val$md5)) {
            break label343;
          }
          String str = paramaomh.getParent();
          aqhq.W(localaoll.atY, str, false);
          if (((this.auP != 1) || (!iwe.o(str + File.separator + this.c.filename_so_wxvoiceembedqqegg, this.c.MD5_so_wxvoiceembedqqegg))) && ((this.auP != 2) || (!iwe.o(str + File.separator + this.c.filename_model_wxvoiceembed, this.c.MD5_model_wxvoiceembed)))) {
            break label343;
          }
          iwe.a(this.c, this.auP);
          i = 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            localException.printStackTrace();
            i = 0;
          }
          iwe.le(-1);
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
        iwe.le(100 / this.b.aqn + this.b.aqo);
        paramaomh = this.b;
        paramaomh.aqo += 100 / this.b.aqn;
        if (!this.b.a(this.c, this.aqp - 1)) {
          this.b.SR = false;
        }
        return;
      }
      label343:
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
      iwe.le(i / this.b.aqn + this.b.aqo);
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
 * Qualified Name:     iwf
 * JD-Core Version:    0.7.0.1
 */