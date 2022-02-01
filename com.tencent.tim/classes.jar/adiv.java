import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class adiv
  extends aopn
{
  adiv(adis paramadis, QQAppInterface paramQQAppInterface, String paramString, aopn.a parama, aoll paramaoll, adis.b paramb, adis.a parama1)
  {
    super(paramQQAppInterface, paramString, parama, paramaoll);
  }
  
  protected void realCancel()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask realCancel");
    synchronized (adis.a(this.b))
    {
      adis.a locala = (adis.a)adis.a(this.b).get(this.a.md5);
      if (locala != null) {
        locala.cQV();
      }
      super.realCancel();
      return;
    }
  }
  
  protected void realStart()
  {
    QLog.i("AREngine_ARPreSoResourceDownload", 1, " HttpEngineTask  realStart");
    synchronized (adis.a(this.b))
    {
      adis.a locala = (adis.a)adis.a(this.b).get(this.a.md5);
      if (locala != null) {
        this.e.cQU();
      }
      super.realStart();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adiv
 * JD-Core Version:    0.7.0.1
 */