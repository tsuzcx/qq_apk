import com.tencent.mobileqq.app.QQAppInterface;

public abstract class augv
  implements augw
{
  protected QQAppInterface app;
  protected augx c;
  
  public augv(QQAppInterface paramQQAppInterface, augx paramaugx)
  {
    this.app = paramQQAppInterface;
    this.c = paramaugx;
  }
  
  public void create()
  {
    onCreate();
  }
  
  public final void destroy()
  {
    onDestroy();
    euT();
    this.c = null;
  }
  
  protected void euT() {}
  
  public boolean isActive()
  {
    return this.c != null;
  }
  
  public final void onAccountChanged(QQAppInterface paramQQAppInterface)
  {
    onDestroy();
    this.app = paramQQAppInterface;
    onCreate();
  }
  
  protected void onCreate() {}
  
  protected void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     augv
 * JD-Core Version:    0.7.0.1
 */