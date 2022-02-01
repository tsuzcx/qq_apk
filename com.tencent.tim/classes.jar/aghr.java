import com.tencent.mobileqq.app.QQAppInterface;

public class aghr
{
  private QQAppInterface app;
  
  public aghr(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3, String paramString4, long paramLong, String paramString5, aghr.a parama)
  {
    agik localagik = this.app.a().a();
    agik.a locala = new agik.a();
    locala.fileName = paramString4;
    locala.fileSize = paramLong;
    locala.md5 = paramString5;
    locala.uuid = paramString3;
    if (paramInt1 != 3000)
    {
      localagik.a(paramString1, paramInt1, paramString2, paramInt2, locala, 5000, 5, new aghu(this, parama));
      return;
    }
    localagik.a(paramString1, paramString2, locala, new aghv(this, parama));
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, String paramString4, long paramLong, int paramInt2, aghr.a parama)
  {
    agik localagik = this.app.a().a();
    agik.a locala = new agik.a();
    locala.fileName = paramString4;
    locala.fileSize = paramLong;
    if ((paramInt1 == 3000) || (paramInt1 == 1))
    {
      localagik.a(paramString2, paramString1, locala, paramInt2, 5000, 3, new aghs(this, parama));
      return;
    }
    localagik.a(paramString1, paramInt1, paramString2, paramString3, 5000, 3, new aght(this, parama));
  }
  
  static abstract interface a
  {
    public abstract void cr(int paramInt, String paramString);
    
    public abstract void onSuccess(String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aghr
 * JD-Core Version:    0.7.0.1
 */