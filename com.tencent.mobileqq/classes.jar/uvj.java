import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class uvj
  extends uvh
{
  private stSimpleMetaFeed a;
  
  public uvj(urv paramurv)
  {
    super(paramurv);
  }
  
  public List<usv> a(ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0) && ((paramArrayList.get(0) instanceof stSimpleMetaFeed))) {
      this.a = ((stSimpleMetaFeed)paramArrayList.get(0));
    }
    return null;
  }
  
  public boolean a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    if ((this.a != null) && (this.a.collection != null) && (!TextUtils.isEmpty(this.a.collection.cid)))
    {
      usj.a().a(this.a.collection.cid, 2, this);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    usj.a().a();
  }
  
  public void c()
  {
    super.c();
    urv localurv = a();
    if ((localurv != null) && (this.a != null)) {
      localurv.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uvj
 * JD-Core Version:    0.7.0.1
 */