import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.manager.Manager;

public class aopo
  implements Manager
{
  private aops a;
  private boolean enable = true;
  private QQAppInterface mApp;
  
  public aopo(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    BaseApplication.getContext().getSharedPreferences("mobileQQ", 4);
    this.a = ((aops)this.mApp.getManager(233));
    this.a.setEnable(this.enable);
  }
  
  public static String a(int paramInt, String paramString, boolean paramBoolean)
  {
    return aops.a(paramInt, paramString, paramBoolean);
  }
  
  public static ArrayList<String> i(int paramInt1, int paramInt2)
  {
    return new ArrayList(5);
  }
  
  public aopm a(String paramString)
  {
    return this.a.a(paramString);
  }
  
  void a(aopm paramaopm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PreDownload.Controller", 2, "onTaskEnd: " + paramaopm);
    }
    this.a.a(paramaopm);
  }
  
  public boolean a(int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3, String paramString4, int paramInt3, int paramInt4, boolean paramBoolean, aopm paramaopm)
  {
    return this.a.a(paramInt1, paramString1, paramString2, paramInt2, paramString3, paramString4, paramInt3, paramInt4, paramBoolean, paramaopm);
  }
  
  public void be(String paramString, long paramLong)
  {
    this.a.be(paramString, paramLong);
  }
  
  public boolean isEnable()
  {
    return this.enable;
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopo
 * JD-Core Version:    0.7.0.1
 */