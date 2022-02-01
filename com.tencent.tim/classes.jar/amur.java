import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public abstract class amur
  implements amuk
{
  private amum jdField_a_of_type_Amum;
  private amuq jdField_a_of_type_Amuq = new amuq();
  private String awx;
  private int dDz;
  private WeakReference<amul> hP;
  protected QQAppInterface mApp;
  protected Context mContext;
  
  public amum a()
  {
    return this.jdField_a_of_type_Amum;
  }
  
  protected abstract amum a(Context paramContext);
  
  public void a(amul paramamul)
  {
    this.hP = new WeakReference(paramamul);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "create, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3 + " templateid:" + paramInt);
    }
    this.jdField_a_of_type_Amuq.Px(true);
    this.jdField_a_of_type_Amuq.PX(paramString1);
    this.jdField_a_of_type_Amuq.PT(paramString2);
    this.awx = paramString3;
    this.dDz = paramInt;
    this.jdField_a_of_type_Amum = a(paramContext);
  }
  
  public void aT(String paramString1, String paramString2, String paramString3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "updateData, serverdata:" + paramString1 + "  extredata:" + paramString2 + " config:" + paramString3);
    }
    this.jdField_a_of_type_Amuq.PX(paramString1);
    this.jdField_a_of_type_Amuq.PT(paramString2);
    this.awx = paramString3;
  }
  
  protected void dOt()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireOnRichViewChangedEvent");
    }
    if (this.hP != null)
    {
      amul localamul = (amul)this.hP.get();
      if (localamul != null) {
        localamul.a(this);
      }
    }
  }
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "destroy");
    }
    onDestroy();
    this.mApp = null;
    this.mContext = null;
    this.hP = null;
    if (this.jdField_a_of_type_Amum != null)
    {
      this.jdField_a_of_type_Amum.destroy();
      this.jdField_a_of_type_Amum = null;
    }
    this.awx = null;
    this.jdField_a_of_type_Amuq = null;
  }
  
  public String getData()
  {
    return this.jdField_a_of_type_Amuq.toJson();
  }
  
  protected void ho(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "fireEvent, key:" + paramString1 + " value:" + paramString2);
    }
    if (this.hP != null)
    {
      amul localamul = (amul)this.hP.get();
      if (localamul != null) {
        localamul.a(this, paramString1, paramString2);
      }
    }
  }
  
  protected void onDestroy() {}
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "pause");
    }
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RichNodeBase", 2, "resume");
    }
  }
  
  public int vY()
  {
    return this.dDz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amur
 * JD-Core Version:    0.7.0.1
 */