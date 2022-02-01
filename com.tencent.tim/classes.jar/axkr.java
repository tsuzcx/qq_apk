import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.SingleImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class axkr
  extends axkj
{
  private static final String TAG = axkr.class.getSimpleName();
  private List<axjm> MS;
  private int eFQ;
  private String imagePath;
  
  public axkr(String paramString, List<axjm> paramList, int paramInt)
  {
    this.imagePath = paramString;
    this.eFQ = paramInt;
    this.MS = paramList;
  }
  
  public axkn a(List<axkm> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {}
    for (paramList = null;; paramList = (axkm)paramList.get(0))
    {
      return a(paramList);
      if (paramList.size() > 1) {
        axiy.e(TAG, "single image but responseList != 1");
      }
    }
  }
  
  protected void a(Context paramContext, axkj.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.imagePath);
    this.eFO = 1;
    ThreadManager.excute(new SingleImageAIFilterProxy.1(this, localArrayList, paramContext, parama), 128, null, false);
  }
  
  public boolean aOO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axkr
 * JD-Core Version:    0.7.0.1
 */