import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class mqv
{
  QQAppInterface app;
  mqv.a b;
  Context context;
  
  public mqv(Context paramContext, QQAppInterface paramQQAppInterface, mqv.a parama)
  {
    this.context = paramContext;
    this.app = paramQQAppInterface;
    this.b = parama;
  }
  
  public abstract void ah(String paramString, boolean paramBoolean);
  
  public void cancel() {}
  
  public abstract void onDestroy();
  
  public static abstract interface a
  {
    public abstract void L(float paramFloat);
    
    public abstract void aDx();
    
    public abstract void e(int paramInt, String paramString1, String paramString2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mqv
 * JD-Core Version:    0.7.0.1
 */