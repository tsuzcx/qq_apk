import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.concurrent.CopyOnWriteArrayList;

public class tvx
{
  private CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  
  public void a(Context paramContext, pvc parampvc, int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (parampvc.a() == null) || (parampvc.a().mSmallMiniGameInfo == null) || (parampvc.a().mSmallMiniGameInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = parampvc.a().mSmallMiniGameInfo.b + "_" + ((tru)parampvc.a().mSmallMiniGameInfo.a.get(paramInt1)).a;
    } while (this.a.contains(str));
    this.a.add(str);
    obb.a(paramContext, parampvc.a(), parampvc.g(), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tvx
 * JD-Core Version:    0.7.0.1
 */