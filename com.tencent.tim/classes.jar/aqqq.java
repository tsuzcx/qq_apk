import com.tencent.mobileqq.app.QQAppInterface;

public abstract interface aqqq
{
  public abstract void onCompleted(QQAppInterface paramQQAppInterface, long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2);
  
  public abstract void onProgress(QQAppInterface paramQQAppInterface, long paramLong1, String paramString1, String paramString2, long paramLong2, long paramLong3);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqqq
 * JD-Core Version:    0.7.0.1
 */