import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class vde
  extends vdc
{
  private stSimpleMetaFeed a;
  
  public vde(uzq paramuzq)
  {
    super(paramuzq);
  }
  
  public List<vaq> a(ArrayList paramArrayList)
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
      vae.a().a(this.a.collection.cid, 2, this);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    vae.a().a();
  }
  
  public void c()
  {
    super.c();
    uzq localuzq = a();
    if ((localuzq != null) && (this.a != null)) {
      localuzq.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vde
 * JD-Core Version:    0.7.0.1
 */