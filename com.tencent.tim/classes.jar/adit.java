import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

class adit
  implements aopn.a
{
  adit(adis paramadis, adis.b paramb) {}
  
  public void a(aopn paramaopn)
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, "onPreDownloadStart");
  }
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {
      QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download init. url = " + ((aoll)paramaomh.b).bZ);
    }
    for (;;)
    {
      return;
      int i;
      synchronized (adis.a(this.b))
      {
        if (adis.a(this.b) != null)
        {
          i = 0;
          label67:
          if (i < adis.a(this.b).size())
          {
            if (!((adis.b)adis.a(this.b).get(i)).url.equals(this.a.url)) {
              break label342;
            }
            adis.a(this.b).remove(i);
          }
        }
      }
      synchronized (adis.a(this.b))
      {
        ??? = (adis.a)adis.a(this.b).get(this.a.md5);
        if (paramaomh.mResult == 0)
        {
          if (adis.a(this.b) != null) {
            adis.a(this.b).be(this.a.url, this.a.fileSize);
          }
          ??? = new File(((aoll)paramaomh.b).atY);
          String str = alab.getFileMD5String(((File)???).getAbsolutePath());
          if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.md5))) && (this.a.type != 1))
          {
            QLog.i("AREngine_ARPreSoResourceDownload", 1, "Download end. MD5 check error. url = " + ((aoll)paramaomh.b).bZ + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
            if (??? == null) {
              continue;
            }
            ((adis.a)???).a(false, this.a);
            return;
            label342:
            i += 1;
            break label67;
            paramaomh = finally;
            throw paramaomh;
          }
        }
      }
      for (boolean bool = true; ??? != null; bool = false)
      {
        ((adis.a)???).a(bool, this.a);
        return;
        if (adis.a(this.b) != null) {
          adis.a(this.b).be(this.a.url, -1L);
        }
      }
    }
  }
  
  public void onUpdateProgeress(aomg arg1, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARPreSoResourceDownload", 2, "onUpdateProgeress. url = " + ((aoll)???).bZ + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    synchronized (adis.a(this.b))
    {
      adis.a locala = (adis.a)adis.a(this.b).get(this.a.md5);
      if (locala != null) {
        locala.aj(paramLong1, paramLong2);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adit
 * JD-Core Version:    0.7.0.1
 */