import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class akig
{
  private akhv b;
  private akhv c;
  private akhv d;
  private akhv e;
  private akhv f;
  private QQAppInterface mApp;
  private Context mContext;
  
  public akig(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
  }
  
  public int a(akjj paramakjj)
  {
    if ((paramakjj instanceof akji)) {
      return 0;
    }
    if ((paramakjj instanceof akjm)) {
      return 1;
    }
    if ((paramakjj instanceof akjk)) {
      return 2;
    }
    if ((paramakjj instanceof akjg)) {
      return 3;
    }
    if ((paramakjj instanceof akjn)) {
      return 4;
    }
    return -1;
  }
  
  public akhv a(int paramInt)
  {
    Object localObject = null;
    if (paramInt == 0) {
      if (this.b != null) {
        localObject = this.b;
      }
    }
    do
    {
      return localObject;
      localObject = new akif(this.mContext, this.mApp);
      this.b = ((akhv)localObject);
      return localObject;
      if (paramInt == 1)
      {
        if (this.c != null) {
          return this.c;
        }
        localObject = new akje(this.mContext, this.mApp);
        this.c = ((akhv)localObject);
        return localObject;
      }
      if (paramInt == 2)
      {
        if (this.d != null) {
          return this.d;
        }
        localObject = new akjc(this.mContext, this.mApp);
        this.d = ((akhv)localObject);
        return localObject;
      }
      if (paramInt == 3)
      {
        if (this.e != null) {
          return this.e;
        }
        localObject = new akic(this.mContext, this.mApp);
        this.e = ((akhv)localObject);
        return localObject;
      }
    } while (paramInt != 4);
    if (this.f != null) {
      return this.f;
    }
    localObject = new akjf(this.mContext, this.mApp);
    this.f = ((akhv)localObject);
    return localObject;
  }
  
  public int getItemCount()
  {
    return 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akig
 * JD-Core Version:    0.7.0.1
 */