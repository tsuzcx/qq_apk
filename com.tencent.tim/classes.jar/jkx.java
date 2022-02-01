import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

final class jkx
  implements aolm.b
{
  jkx(jkw.a parama) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3) {
      if (QLog.isColorLevel()) {
        QLog.i("ScoreManager", 1, "Download init. url = " + ((aoll)paramaomh.b).bZ);
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramaomh.mResult == 0)
        {
          File localFile = new File(((aoll)paramaomh.b).atY);
          String str = alab.getFileMD5String(localFile.getAbsolutePath());
          if ((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.a.md5)))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ScoreManager", 1, "Download end. MD5 check error. url = " + ((aoll)paramaomh.b).bZ + ", fileName = " + localFile.getAbsolutePath() + ", fileMD5 = " + str);
            return;
          }
          try
          {
            paramaomh = new File(this.a.fileName);
            adjg.fn(this.a.fileName, paramaomh.getParentFile().getAbsolutePath() + File.separator);
            if (QLog.isColorLevel()) {
              QLog.i("ScoreManager", 1, "onDownloadComplete  path : " + paramaomh.getParentFile().getAbsolutePath());
            }
            if (QLog.isColorLevel())
            {
              QLog.i("ScoreManager", 1, "qav_score_good : " + jjy.cK("qav_score_good.jpg") + ", qav_score_normal : " + jjy.cK("qav_score_normal.jpg") + ", qav_score_bad : " + jjy.cK("qav_score_bad.jpg"));
              return;
            }
          }
          catch (Exception paramaomh)
          {
            new File(this.a.fileName).delete();
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.i("ScoreManager", 1, "Download end. uncompressZip error.");
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ScoreManager", 2, "onUpdateProgeress. url = " + ((aoll)paramaomg).bZ + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jkx
 * JD-Core Version:    0.7.0.1
 */