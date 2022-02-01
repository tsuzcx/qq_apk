import android.content.Context;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.aifilter.BatchImageAIFilterProxy.1;
import java.util.ArrayList;
import java.util.List;

public class axko
  extends axkj
{
  private static final String TAG = axko.class.getSimpleName();
  private List<axjm> MQ;
  private axkn a;
  private int eFP;
  private List<String> imagePaths;
  
  public axko(List<String> paramList, List<axjm> paramList1, int paramInt, axkn paramaxkn)
  {
    this.imagePaths = paramList;
    this.MQ = paramList1;
    this.eFP = paramInt;
    this.a = paramaxkn;
    this.eFO = (paramList.size() - 1);
  }
  
  protected axkn a(List<axkm> paramList)
  {
    int j = 0;
    axkp localaxkp = new axkp();
    int i;
    if ((paramList == null) || (paramList.size() == 0)) {
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        i = j;
        for (;;)
        {
          if (i < this.eFO)
          {
            paramList = a(null);
            paramList.bGa = true;
            localaxkp.Bu.add(paramList);
            i += 1;
            continue;
            if (paramList.size() == this.MN.size()) {
              break label210;
            }
            axiy.e(TAG, "batch image responseList size not match image size");
            i = 1;
            break;
          }
        }
        localaxkp.bGa = true;
      }
      for (;;)
      {
        localaxkp.Bu.add(this.eFP, (axks)this.a);
        return localaxkp;
        i = 0;
        while (i < this.eFO)
        {
          Object localObject = (axkm)paramList.get(i);
          this.mPickUpBitmapList.clear();
          this.mPickUpBitmapList.add(this.MN.get(i));
          localObject = a((axkm)localObject);
          localaxkp.Bu.add(localObject);
          i += 1;
        }
      }
      label210:
      i = 0;
    }
  }
  
  protected void a(Context paramContext, axkj.a parama)
  {
    ArrayList localArrayList = new ArrayList(this.imagePaths);
    localArrayList.remove(this.eFP);
    ThreadManager.excute(new BatchImageAIFilterProxy.1(this, localArrayList, paramContext, parama), 128, null, false);
  }
  
  public boolean aOO()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axko
 * JD-Core Version:    0.7.0.1
 */