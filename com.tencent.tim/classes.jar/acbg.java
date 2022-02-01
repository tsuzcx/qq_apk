import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class acbg
{
  public int awS = 0;
  public int cud;
  protected int cuv = -1;
  public int mBinderType;
  public Context mContext;
  public SessionInfo mSessionInfo;
  public List<abzy> xf;
  
  public int Ad()
  {
    return 0;
  }
  
  public View G(int paramInt)
  {
    View localView = bQ();
    ac(localView, paramInt);
    return localView;
  }
  
  public void IC(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] highlightItemIndex=", Integer.valueOf(paramInt) });
    }
    if ((this.xf == null) || (this.xf.size() == 0)) {
      QLog.e("ApolloViewBinder", 1, "[setHighlightItemIndex] no panel data, set failed");
    }
    do
    {
      do
      {
        return;
      } while ((paramInt < 0) || (paramInt >= this.xf.size()));
      this.cuv = paramInt;
    } while (!QLog.isColorLevel());
    QLog.d("ApolloViewBinder", 2, new Object[] { "[setHighlightItemIndex] set success, highlightItemIndex=", Integer.valueOf(paramInt) });
  }
  
  public abzy a(String paramString)
  {
    return null;
  }
  
  public void ac(View paramView, int paramInt) {}
  
  public View bQ()
  {
    return null;
  }
  
  public int gq(int paramInt)
  {
    return 0;
  }
  
  public void ix(List<abzy> paramList)
  {
    this.xf = paramList;
  }
  
  public ArrayList<abzy> o(int paramInt)
  {
    return null;
  }
  
  public void onDestroy() {}
  
  public void setPanelType(int paramInt)
  {
    this.awS = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acbg
 * JD-Core Version:    0.7.0.1
 */