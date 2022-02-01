import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.ForwardFileInfo;
import java.util.ArrayList;
import java.util.List;

public class atxg
{
  private List<atzy> KL;
  private int cYK;
  private int erj;
  private int erk;
  private int erl;
  private QQAppInterface mApp;
  
  public atxg(QQAppInterface paramQQAppInterface)
  {
    this.mApp = paramQQAppInterface;
    this.KL = new ArrayList();
  }
  
  public atxf.a a(BaseActivity paramBaseActivity)
  {
    return new atxg.a(paramBaseActivity, this.erk, this.erl);
  }
  
  public boolean a(Intent paramIntent, BaseActivity paramBaseActivity)
  {
    int j = 0;
    this.erk = paramIntent.getIntExtra("qfile_browser_forward_file_type", -1);
    this.erj = paramIntent.getIntExtra("qfile_browser_forward_file_index", 0);
    this.cYK = paramIntent.getIntExtra("qfile_browser_entrance_type", -1);
    this.erl = paramIntent.getIntExtra("qfile_browser_forward_data_type", 1);
    Object localObject = (ForwardFileInfo)paramIntent.getParcelableExtra("qfile_browser_forward_file_info");
    paramIntent = paramIntent.getParcelableArrayListExtra("qfile_browser_forward_file_list");
    if (localObject == null) {
      return false;
    }
    if (paramIntent != null)
    {
      int k = paramIntent.size();
      int i = j;
      if (this.erj >= k)
      {
        this.erj = 0;
        i = j;
      }
      while (i < k)
      {
        localObject = ((ForwardFileInfo)paramIntent.get(i)).a(paramBaseActivity);
        if (localObject != null) {
          this.KL.add(localObject);
        }
        i += 1;
      }
    }
    return true;
  }
  
  public List<atzy> hj()
  {
    return this.KL;
  }
  
  public class a
    implements atxf.a
  {
    private BaseActivity mActivity;
    
    public a(BaseActivity paramBaseActivity, int paramInt1, int paramInt2)
    {
      this.mActivity = paramBaseActivity;
    }
    
    public atzy a()
    {
      atzz localatzz = new atzz(this.mActivity);
      localatzz.ad(atxg.this.hj(), atxg.a(atxg.this));
      localatzz.Oy(atxg.b(atxg.this));
      return localatzz;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atxg
 * JD-Core Version:    0.7.0.1
 */