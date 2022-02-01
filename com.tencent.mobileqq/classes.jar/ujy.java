import android.content.Context;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.concurrent.CopyOnWriteArrayList;

public class ujy
{
  private CopyOnWriteArrayList<String> a = new CopyOnWriteArrayList();
  
  public void a(Context paramContext, qfw paramqfw, int paramInt1, int paramInt2)
  {
    if ((this.a == null) || (paramqfw.a() == null) || (paramqfw.a().mSmallMiniGameInfo == null) || (paramqfw.a().mSmallMiniGameInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = paramqfw.a().mSmallMiniGameInfo.b + "_" + ((ugf)paramqfw.a().mSmallMiniGameInfo.a.get(paramInt1)).a;
    } while (this.a.contains(str));
    this.a.add(str);
    ois.a(paramContext, paramqfw.a(), paramqfw.g(), paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ujy
 * JD-Core Version:    0.7.0.1
 */