import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.concurrent.CopyOnWriteArrayList;

public class tpd
{
  private CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  
  public void a(Context paramContext, ppu paramppu, int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (paramppu.a() == null) || (paramppu.a().mSmallMiniGameInfo == null) || (paramppu.a().mSmallMiniGameInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = paramppu.a().mSmallMiniGameInfo.b + "_" + ((tme)paramppu.a().mSmallMiniGameInfo.a.get(paramInt1)).a;
    } while (this.a.contains(str));
    this.a.add(str);
    nzq.a(paramContext, paramppu.a(), paramppu.h(), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpd
 * JD-Core Version:    0.7.0.1
 */