import android.content.Context;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;

public abstract class agog
  extends ampy
{
  protected Bundle aZ;
  protected int mFromType;
  protected String wB;
  
  public agog(String paramString, int paramInt)
  {
    this.wB = paramString;
    this.mFromType = paramInt;
  }
  
  public boolean DR()
  {
    return false;
  }
  
  public int Ey()
  {
    return 0;
  }
  
  public List<ampx> a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    return new ArrayList(0);
  }
  
  public abstract boolean alP();
  
  public void cA(Bundle paramBundle)
  {
    this.aZ = paramBundle;
  }
  
  public void cR(View paramView)
  {
    int i = Ey();
    if (i == 1) {
      if (paramView.getId() == 2131367020) {
        gK(paramView);
      }
    }
    while (i <= 1)
    {
      return;
      gL(paramView);
      return;
    }
    gM(paramView);
  }
  
  protected abstract void gK(View paramView);
  
  protected abstract void gL(View paramView);
  
  protected abstract void gM(View paramView);
  
  public abstract String getFileName();
  
  public abstract int getFileType();
  
  public String getKeyword()
  {
    return this.wB;
  }
  
  public abstract String vp();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agog
 * JD-Core Version:    0.7.0.1
 */