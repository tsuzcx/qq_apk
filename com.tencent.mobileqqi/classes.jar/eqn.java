import android.os.AsyncTask;
import com.tencent.mobileqq.activity.photo.AlbumListActivity;
import com.tencent.widget.XListView;
import java.util.List;

public class eqn
  extends AsyncTask
{
  public eqn(AlbumListActivity paramAlbumListActivity) {}
  
  protected List a(Object... paramVarArgs)
  {
    return this.a.a();
  }
  
  protected void a(List paramList)
  {
    AlbumListActivity.b(this.a);
    AlbumListActivity.a(this.a, paramList);
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.a.setEmptyView(null);
    AlbumListActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eqn
 * JD-Core Version:    0.7.0.1
 */