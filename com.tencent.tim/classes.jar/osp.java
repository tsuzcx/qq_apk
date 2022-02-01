import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class osp
  extends oso
{
  private stSimpleMetaFeed j;
  
  public osp(oqi.b paramb)
  {
    super(paramb);
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.j != null) && (this.j.collection != null) && (!TextUtils.isEmpty(this.j.collection.cid)))
    {
      oqn.a().a(this.j.collection.cid, 2, this);
      return true;
    }
    return false;
  }
  
  public List<oqr> d(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.j = ((stSimpleMetaFeed)paramArrayList.get(0));
    }
    return null;
  }
  
  public void destroy()
  {
    super.destroy();
    oqn.a().reset();
  }
  
  public void initData()
  {
    super.initData();
    if ((this.a != null) && (this.j != null)) {
      this.a.ac(this.j);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     osp
 * JD-Core Version:    0.7.0.1
 */