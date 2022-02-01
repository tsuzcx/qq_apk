import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class uuh
  extends uuf
{
  private stSimpleMetaFeed a;
  
  public uuh(uqu paramuqu)
  {
    super(paramuqu);
  }
  
  public List<uru> a(ArrayList paramArrayList)
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
      uri.a().a(this.a.collection.cid, 2, this);
      return true;
    }
    return false;
  }
  
  public void b()
  {
    super.b();
    uri.a().a();
  }
  
  public void c()
  {
    super.c();
    uqu localuqu = a();
    if ((localuqu != null) && (this.a != null)) {
      localuqu.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uuh
 * JD-Core Version:    0.7.0.1
 */