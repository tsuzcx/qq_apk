import android.support.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class lji<BEAN, COOKIE>
  implements ljh.b<BEAN>
{
  @Nullable
  private COOKIE aM = null;
  private boolean ahL;
  private boolean akA;
  private boolean akB;
  private boolean akC;
  private int mErrorCode = 0;
  private String mErrorMsg = "";
  protected int mTotalSize;
  protected CopyOnWriteArrayList<BEAN> q = new CopyOnWriteArrayList();
  
  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt1, List<BEAN> paramList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString, ljh.a<BEAN> parama)
  {
    this.akA = true;
    if ((paramBoolean2) && (paramInt1 >= 0)) {
      this.mTotalSize = paramInt1;
    }
    if (this.akB) {
      if (paramBoolean2)
      {
        this.q.clear();
        this.q.addAll(paramList);
        cC(paramList);
        this.aM = paramCOOKIE;
        if (!paramBoolean3)
        {
          paramBoolean1 = true;
          this.ahL = paramBoolean1;
        }
      }
      else
      {
        parama.a(paramBoolean2, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
      }
    }
    do
    {
      return;
      paramBoolean1 = false;
      break;
      if (paramBoolean2)
      {
        this.q.clear();
        this.q.addAll(paramList);
        this.aM = paramCOOKIE;
        if (!paramBoolean3) {}
        for (paramBoolean1 = true;; paramBoolean1 = false)
        {
          this.ahL = paramBoolean1;
          parama.a(true, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
          return;
        }
      }
      this.akC = true;
      this.mErrorCode = paramInt2;
      this.mErrorMsg = paramString;
    } while (paramBoolean1);
    parama.a(false, paramList, paramInt1, Boolean.valueOf(false), paramInt2, paramString);
  }
  
  private void aME()
  {
    this.akA = false;
    this.akB = false;
    this.akC = false;
    this.mErrorCode = 0;
    this.mErrorMsg = "";
  }
  
  public boolean Cz()
  {
    return this.ahL;
  }
  
  public abstract void a(@Nullable COOKIE paramCOOKIE, lji.a<BEAN, COOKIE> parama);
  
  public void a(ljh.e<BEAN> parame)
  {
    a(this.aM, new ljl(this, parame));
  }
  
  public abstract void a(lji.b<BEAN> paramb);
  
  public void a(boolean paramBoolean, ljh.a<BEAN> parama)
  {
    aME();
    if (paramBoolean) {
      a(new ljj(this, parama));
    }
    a(null, new ljk(this, paramBoolean, parama));
  }
  
  public abstract void cC(List<BEAN> paramList);
  
  public static abstract interface a<BEAN, COOKIE>
  {
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, ArrayList<BEAN> paramArrayList, @Nullable COOKIE paramCOOKIE, int paramInt2, String paramString);
  }
  
  public static abstract interface b<BEAN> {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lji
 * JD-Core Version:    0.7.0.1
 */