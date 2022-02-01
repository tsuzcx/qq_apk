import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class vbi
{
  protected vbi.a a;
  public QQAppInterface app;
  protected vbi.b c;
  protected int index = -1;
  public String toUin;
  
  public vbi(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public vbi.b a()
  {
    return this.c;
  }
  
  public abstract vbi.b a(int paramInt);
  
  public abstract void a(BaseActivity paramBaseActivity, vbi.b paramb);
  
  public void a(vbi.a parama)
  {
    this.a = parama;
  }
  
  public Drawable am()
  {
    return null;
  }
  
  public abstract void d(BaseActivity paramBaseActivity);
  
  public abstract void e(BaseActivity paramBaseActivity);
  
  public abstract void e(vbi.b paramb);
  
  public void g(vbi.b paramb)
  {
    if ((paramb == this.c) && (this.a != null)) {
      this.a.b(paramb);
    }
  }
  
  public abstract int getCount();
  
  public int getCurrentIndex()
  {
    return this.index;
  }
  
  public abstract void setCurrentIndex(int paramInt);
  
  public static abstract interface a
  {
    public abstract void b(vbi.b paramb);
  }
  
  public static class b
  {
    public String fileKey;
    public String filePath;
    public int progress;
    public boolean showProgress;
    public int state;
    public String thumbnail;
    public String toUin;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vbi
 * JD-Core Version:    0.7.0.1
 */