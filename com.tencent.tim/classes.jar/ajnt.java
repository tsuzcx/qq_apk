import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.manager.Manager;

public class ajnt
  implements Manager
{
  private static final String[] cB = { "data.json", "icon_close.png" };
  ajny a;
  QQAppInterface app;
  
  public ajnt(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
    this.a = new ajny();
  }
  
  public static ajnt a(QQAppInterface paramQQAppInterface)
  {
    return (ajnt)paramQQAppInterface.getManager(345);
  }
  
  public void a(String paramString1, String paramString2, ajny.b paramb)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "prepareCartoonResources url:" + paramString1 + " md5:" + paramString2);
    }
    this.a.a(this.app, 10089, "prd", paramString1, paramString2, cB, paramb);
  }
  
  public boolean bi(String paramString1, String paramString2)
  {
    boolean bool = ajny.a(paramString1, paramString2, cB);
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "isCartoonResourceReady url:" + paramString1 + " md5:" + paramString2 + " res:" + bool);
    }
    return bool;
  }
  
  public String bm(String paramString1, String paramString2)
  {
    return ajny.bn(paramString1, paramString2) + "/";
  }
  
  public void gK(String paramString1, String paramString2)
  {
    if (bi(paramString1, paramString2)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MutualMarkManger", 2, "checkDownloadCartoonResource download url:" + paramString1 + " md5:" + paramString2);
    }
    this.a.a(this.app, 10089, "prd", paramString1, paramString2, cB, null);
  }
  
  public void onDestroy()
  {
    this.a.onDestroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajnt
 * JD-Core Version:    0.7.0.1
 */