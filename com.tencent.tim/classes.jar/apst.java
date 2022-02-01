import com.tencent.mobileqq.app.QQAppInterface;

public class apst
{
  public static apst a;
  public QQAppInterface app;
  public accd b = new apsu(this);
  
  public static apst a(QQAppInterface paramQQAppInterface)
  {
    if (a == null) {
      en(paramQQAppInterface);
    }
    for (;;)
    {
      return a;
      if (a.app != paramQQAppInterface)
      {
        if (a.app != null)
        {
          a.app.removeObserver(a.b);
          a.app = null;
        }
        a = null;
        en(paramQQAppInterface);
      }
    }
  }
  
  public static void clearInstance(QQAppInterface paramQQAppInterface)
  {
    if ((a != null) && (a.app == paramQQAppInterface))
    {
      paramQQAppInterface.removeObserver(a.b);
      a.app = null;
      a = null;
    }
  }
  
  private static void en(QQAppInterface paramQQAppInterface)
  {
    a = new apst();
    a.app = paramQQAppInterface;
    paramQQAppInterface.addObserver(a.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apst
 * JD-Core Version:    0.7.0.1
 */