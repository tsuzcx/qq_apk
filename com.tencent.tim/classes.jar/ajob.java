import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.util.WeakReference;

class ajob
  implements aopn.a
{
  ajob(ajny paramajny, String paramString, String[] paramArrayOfString, ajny.b paramb) {}
  
  public void a(aopn paramaopn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onPreDownloadStart url=%s", new Object[] { paramaopn.f.bZ }));
    }
  }
  
  public void onResp(aomh paramaomh)
  {
    String str = ((aoll)paramaomh.b).bZ;
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onResp url=%s result=%s", new Object[] { str, Integer.valueOf(paramaomh.mResult) }));
    }
    switch (paramaomh.mResult)
    {
    default: 
      return;
    case 0: 
      if (this.b.aP == null) {
        break;
      }
    }
    for (Object localObject = (aopo)this.b.aP.get();; localObject = null)
    {
      if (localObject != null) {
        ((aopo)localObject).be(str, paramaomh.apU);
      }
      paramaomh = (aoll)paramaomh.b;
      if (ajny.o(paramaomh.atY, this.val$md5))
      {
        localObject = new File(ajny.access$100(this.val$md5));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdirs();
        }
        boolean bool1 = ajny.access$200(paramaomh.atY, ajny.access$100(this.val$md5));
        boolean bool2 = ajny.c(str, this.val$md5, this.fv);
        if (QLog.isColorLevel()) {
          QLog.d("ZipResourcesDownloader", 2, String.format("onResp ResultOk unzip result=%s unzipped=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        ajny.a(this.b, str, this.val$md5, bool2, this.a);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.e("ZipResourcesDownloader", 2, "onResp ResultOk file check invalid.");
      }
      ajny.ur(paramaomh.atY);
      ajny.a(this.b, str, this.val$md5, false, this.a);
      return;
      if (this.b.aP != null) {}
      for (paramaomh = (aopo)this.b.aP.get();; paramaomh = null)
      {
        if (paramaomh != null) {
          paramaomh.be(str, -1L);
        }
        ajny.a(this.b, str, this.val$md5, false, this.a);
        return;
      }
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZipResourcesDownloader", 2, String.format("onUpdateProgeress url=%s totalLen=%s curOffset=%s", new Object[] { ((aoll)paramaomg).bZ, Long.valueOf(paramLong2), Long.valueOf(paramLong1) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajob
 * JD-Core Version:    0.7.0.1
 */