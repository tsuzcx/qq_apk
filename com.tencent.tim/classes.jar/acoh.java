import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.asyncdb.BaseCache;
import com.tencent.mobileqq.app.asyncdb.BaseCacheManager;

public class acoh
  extends BaseCacheManager
{
  private QQAppInterface app;
  
  public acoh(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
  }
  
  public BaseCache createCacheByName(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 2: 
      return new acoj(this.app, this.dbDelayManager);
    }
    return new acol(this.app, this.dbDelayManager);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acoh
 * JD-Core Version:    0.7.0.1
 */