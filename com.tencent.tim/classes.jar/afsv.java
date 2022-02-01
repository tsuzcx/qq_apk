import com.tencent.qphone.base.util.QLog;
import java.io.File;

class afsv
  implements aopn.a
{
  afsv(afss paramafss) {}
  
  public void a(aopn paramaopn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramaopn.f.bZ }));
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    int i = 1;
    Object localObject = ((aoll)paramaomh.b).bZ;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaomh.mResult) }));
    }
    switch (paramaomh.mResult)
    {
    }
    label277:
    label282:
    label303:
    label308:
    do
    {
      return;
      if (afss.a(this.this$0) != null) {
        afss.a(this.this$0).be((String)localObject, paramaomh.apU);
      }
      paramaomh = (aoll)paramaomh.b;
      boolean bool2 = afss.a(this.this$0, paramaomh.atY, afss.a(this.this$0));
      boolean bool1;
      if (bool2)
      {
        localObject = new File(afss.uI());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool4 = afss.b(this.this$0, paramaomh.atY, afss.uI());
        boolean bool3 = afss.a(this.this$0);
        if (QLog.isColorLevel()) {
          QLog.d("ExtendFriendResourceDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool3) }));
        }
        if (afss.a(this.this$0) != null)
        {
          paramaomh = afss.a(this.this$0);
          if ((bool4) && (bool3))
          {
            bool1 = true;
            paramaomh.Im(bool1);
          }
        }
        else
        {
          paramaomh = afxv.a();
          if ((!bool4) || (!bool3)) {
            break label303;
          }
          bool1 = true;
          if (bool3) {
            break label308;
          }
          paramaomh.bj(bool1, i);
        }
      }
      for (;;)
      {
        afxv.a().bi(bool2, 0);
        return;
        bool1 = false;
        break;
        bool1 = false;
        break label277;
        i = 0;
        break label282;
        if (QLog.isColorLevel()) {
          QLog.e("ExtendFriendResourceDownloader", 2, "onResp ResultOk file check invalid.");
        }
        afss.a(this.this$0, paramaomh.atY);
        if (afss.a(this.this$0) != null) {
          afss.a(this.this$0).Im(false);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.e("ExtendFriendResourceDownloader", 2, "download fail " + paramaomh.clO);
      }
    } while (afss.a(this.this$0) == null);
    afss.a(this.this$0).be((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendResourceDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((aoll)paramaomg).bZ, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afsv
 * JD-Core Version:    0.7.0.1
 */