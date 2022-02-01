import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ahpo
  implements aopn.a
{
  ahpo(ahpl paramahpl) {}
  
  public void a(aopn paramaopn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramaopn.f.bZ }));
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    Object localObject = ((aoll)paramaomh.b).bZ;
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onResp url=%s result=%s", new Object[] { localObject, Integer.valueOf(paramaomh.mResult) }));
    }
    switch (paramaomh.mResult)
    {
    }
    do
    {
      boolean bool1;
      boolean bool2;
      do
      {
        return;
        if (ahpl.a(this.a) != null) {
          ahpl.a(this.a).be((String)localObject, paramaomh.apU);
        }
        paramaomh = (aoll)paramaomh.b;
        if (!ahpl.a(this.a, paramaomh.atY, ahpl.a(this.a))) {
          break;
        }
        localObject = new File(ahpl.uI());
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        bool1 = ahpl.b(this.a, paramaomh.atY, ahpl.uI());
        bool2 = ahpl.a(this.a);
      } while (!QLog.isColorLevel());
      QLog.d("IntimateInfoManager", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      return;
      if (QLog.isColorLevel()) {
        QLog.e("IntimateInfoManager", 2, "onResp ResultOk file check invalid.");
      }
      ahpl.a(this.a, paramaomh.atY);
      return;
    } while (ahpl.a(this.a) == null);
    ahpl.a(this.a).be((String)localObject, -1L);
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("IntimateInfoManager", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((aoll)paramaomg).bZ, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahpo
 * JD-Core Version:    0.7.0.1
 */