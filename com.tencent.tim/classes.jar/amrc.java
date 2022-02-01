import android.view.View;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class amrc
  implements ampw
{
  public int dDt;
  public int dDu;
  public int positionInList;
  
  public int Ex()
  {
    return 0;
  }
  
  public void aZ(int paramInt1, int paramInt2, int paramInt3)
  {
    iv(2, paramInt1);
    iv(1, paramInt2);
    iv(3, paramInt3);
  }
  
  public int bW(int paramInt)
  {
    int i = -1;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.uniteSearch.SearchResultGroupModelImpl", 2, "getPosition(). type=" + paramInt + "  position=" + i);
      }
      return i;
      i = this.positionInList;
      continue;
      i = this.dDt;
      continue;
      i = this.dDu;
    }
  }
  
  public List<ampx> eX()
  {
    return null;
  }
  
  public void gJ(View paramView) {}
  
  public String getGroupName()
  {
    return null;
  }
  
  public String getKeyword()
  {
    return null;
  }
  
  public void iv(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return;
    case 1: 
      this.positionInList = paramInt2;
      return;
    case 2: 
      this.dDt = paramInt2;
      return;
    }
    this.dDu = paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amrc
 * JD-Core Version:    0.7.0.1
 */