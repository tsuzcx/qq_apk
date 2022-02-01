import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

public class agjg
{
  private accd c = new agji(this);
  private boolean cdB;
  private ConcurrentHashMap<String, agzi> fn;
  private aghq g = new agjh(this);
  private QQAppInterface mApp;
  
  public agjg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
  }
  
  private void dgT()
  {
    if (this.g != null) {
      this.mApp.a().addObserver(this.g);
    }
    if (this.c != null) {
      this.mApp.addObserver(this.c);
    }
  }
  
  private void dgU()
  {
    if (this.g != null) {
      this.mApp.a().deleteObserver(this.g);
    }
    if (this.c != null) {
      this.mApp.removeObserver(this.c);
    }
  }
  
  public agzi a(String paramString1, String paramString2, String paramString3)
  {
    if (this.fn == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return null;
    }
    paramString1 = agzi.C(paramString1, paramString2, paramString3);
    return (agzi)this.fn.get(paramString1);
  }
  
  public void a(agzi paramagzi)
  {
    if (this.fn == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    if (paramagzi == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req is null.");
      return;
    }
    String str = paramagzi.vU();
    if (TextUtils.isEmpty(str))
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "controlKey is null.");
      return;
    }
    this.fn.put(paramagzi.vU(), paramagzi);
    QLog.e("QFileMultiControlManager<QFile>", 1, "addFileControlReq: controlKey[" + str + "]");
  }
  
  public void b(agzi paramagzi)
  {
    if (this.fn == null)
    {
      QLog.e("QFileMultiControlManager<QFile>", 1, "req map is null.if you forget init manager?");
      return;
    }
    paramagzi = paramagzi.vU();
    this.fn.remove(paramagzi);
    QLog.e("QFileMultiControlManager<QFile>", 1, "removeFileContolReq: controlKey[" + paramagzi + "]");
  }
  
  public void dgV()
  {
    if (this.cdB) {
      return;
    }
    QLog.i("QFileMultiControlManager<QFile>", 1, "initFileControlManager");
    this.cdB = true;
    dgT();
    if (this.fn != null) {
      this.fn.clear();
    }
    this.fn = new ConcurrentHashMap();
  }
  
  public void dgW()
  {
    QLog.i("QFileMultiControlManager<QFile>", 1, "clearFileControlManager");
    this.cdB = false;
    dgU();
    if (this.fn != null) {
      this.fn.clear();
    }
    this.fn = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agjg
 * JD-Core Version:    0.7.0.1
 */