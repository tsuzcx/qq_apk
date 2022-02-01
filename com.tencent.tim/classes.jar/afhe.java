import android.content.Context;
import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.widget.ListView;

public class afhe
  extends afnd
{
  private ahyb a;
  private String bDq;
  private QQAppInterface mApp;
  private Context mContext;
  
  public afhe(QQAppInterface paramQQAppInterface, Context paramContext, ahyb paramahyb)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.a = paramahyb;
  }
  
  public void HT(String paramString)
  {
    this.bDq = paramString;
  }
  
  public void a(ListView paramListView, afll paramafll)
  {
    b(paramListView, paramafll);
    paramafll = bU();
    if (paramafll.getParent() == null) {
      paramListView.addFooterView(paramafll);
    }
  }
  
  public void cZu() {}
  
  public void cZv()
  {
    this.a.cZv();
  }
  
  public void cZw()
  {
    this.bDq = null;
  }
  
  public QQAppInterface getApp()
  {
    return this.mApp;
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public int getPageType()
  {
    return 2;
  }
  
  public String getTag()
  {
    return "RichTextPanelEmoticonSearchLayoutHelper";
  }
  
  public String ut()
  {
    return this.bDq;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhe
 * JD-Core Version:    0.7.0.1
 */