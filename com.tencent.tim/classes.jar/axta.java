import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.paster.QIMInformationPasterManager.2;

public class axta
  implements axsz.a
{
  public axta(QIMInformationPasterManager.2 param2) {}
  
  public void a(float paramFloat, String paramString, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, ayna.c paramc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMInformationPasterManager", 2, "isSucess:" + paramBoolean + " url:" + paramString + " item:" + paramc);
    }
    if (paramc.a() != null) {
      paramc.a().YX(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     axta
 * JD-Core Version:    0.7.0.1
 */