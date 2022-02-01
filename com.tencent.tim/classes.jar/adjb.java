import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;

class adjb
  implements aolm.b
{
  adjb(adja paramadja, adja.b paramb, adja.a parama) {}
  
  public void onResp(aomh paramaomh)
  {
    if (paramaomh.mResult == 3)
    {
      QLog.i("AREngine_ARResourceDownload", 1, "Download init. url = " + ((aoll)paramaomh.b).bZ);
      return;
    }
    synchronized (adja.a(this.jdField_a_of_type_Adja))
    {
      int i;
      if (adja.a(this.jdField_a_of_type_Adja) != null)
      {
        i = 0;
        if (i < adja.a(this.jdField_a_of_type_Adja).size())
        {
          if (!((adja.b)adja.a(this.jdField_a_of_type_Adja).get(i)).url.equals(this.jdField_a_of_type_Adja$b.url)) {
            break label268;
          }
          adja.a(this.jdField_a_of_type_Adja).remove(i);
        }
      }
      if (paramaomh.mResult == 0)
      {
        ??? = new File(((aoll)paramaomh.b).atY);
        String str = alab.getFileMD5String(((File)???).getAbsolutePath());
        if (((TextUtils.isEmpty(str)) || (!str.equalsIgnoreCase(this.jdField_a_of_type_Adja$b.md5))) && (this.jdField_a_of_type_Adja$b.type != 1))
        {
          QLog.i("AREngine_ARResourceDownload", 1, "Download end. MD5 check error. url = " + ((aoll)paramaomh.b).bZ + ", fileName = " + ((File)???).getAbsolutePath() + ", fileMD5 = " + str);
          this.jdField_a_of_type_Adja$a.a(false, this.jdField_a_of_type_Adja$b);
          return;
          label268:
          i += 1;
        }
      }
    }
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Adja$a.a(bool, this.jdField_a_of_type_Adja$b);
      return;
    }
  }
  
  public void onUpdateProgeress(aomg paramaomg, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARResourceDownload", 2, "onUpdateProgeress. url = " + ((aoll)paramaomg).bZ + ", total size = " + paramLong2 + ", cur downloaded size = " + paramLong1);
    }
    this.jdField_a_of_type_Adja$a.aj(paramLong1, paramLong2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjb
 * JD-Core Version:    0.7.0.1
 */