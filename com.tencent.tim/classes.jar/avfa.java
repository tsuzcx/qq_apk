import com.tencent.qphone.base.util.QLog;
import java.io.File;

class avfa
  implements aolm.b
{
  avfa(avez.a parama, String paramString, avey paramavey) {}
  
  public void onResp(aomh paramaomh)
  {
    aoll localaoll = (aoll)paramaomh.b;
    if (this.b.d == localaoll) {
      this.b.d = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TMG_Downloader", 2, String.format("onResp, Url[%s], mResult[%s], mHttpCode[%s], md5[%s]", new Object[] { localaoll.bZ, Integer.valueOf(paramaomh.mResult), Integer.valueOf(paramaomh.dPy), this.val$md5 }));
    }
    if (paramaomh.mResult == 0)
    {
      paramaomh = new File(localaoll.atY);
      if (!paramaomh.exists()) {}
    }
    do
    {
      for (;;)
      {
        try
        {
          paramaomh = paramaomh.getParent();
          aqhq.W(localaoll.atY, paramaomh, false);
          avez.CV(this.d.MD5_zip_so);
          i = 1;
          if (i == 0) {
            break;
          }
          if (this.b.a != null)
          {
            this.b.a.Ik(100);
            this.b.a.bT(0, "Download Complete!!!");
          }
          this.b.SR = false;
          return;
        }
        catch (Exception paramaomh)
        {
          paramaomh.printStackTrace();
        }
        int i = 0;
      }
    } while (this.b.a == null);
    this.b.a.bT(2, "");
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    int i;
    if (paramLong2 == 0L) {
      i = 0;
    }
    for (;;)
    {
      if (this.b.a != null) {
        this.b.a.Ik(i);
      }
      return;
      if (paramLong1 >= paramLong2) {
        i = 99;
      } else {
        i = (int)((float)paramLong1 * 100.0F / (float)paramLong2);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avfa
 * JD-Core Version:    0.7.0.1
 */