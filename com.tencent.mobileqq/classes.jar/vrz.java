import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.text.TextUtils;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import java.util.ArrayList;
import java.util.List;

public class vrz
  extends vrx
{
  private static final int b = ScreenUtil.dip2px(63.0F);
  private stSimpleMetaFeed a;
  
  public vrz(voi paramvoi)
  {
    super(paramvoi);
  }
  
  public List<vpj> a(ArrayList paramArrayList)
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
      vox.a().a(this.a.collection.cid, 2, this);
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return b;
  }
  
  public void b()
  {
    super.b();
    vox.a().a();
  }
  
  public void c()
  {
    super.c();
    voi localvoi = a();
    if ((localvoi != null) && (this.a != null)) {
      localvoi.b(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vrz
 * JD-Core Version:    0.7.0.1
 */