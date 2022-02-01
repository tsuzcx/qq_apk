import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.nearby.picbrowser.PicInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import java.util.ArrayList;
import java.util.List;

public class akbt
  implements sxm
{
  private int cVo;
  private Context mContext;
  private ArrayList<akbr> yh = new ArrayList();
  
  public akbt(Context paramContext, List<PicInfo> paramList)
  {
    this.mContext = paramContext;
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      if (i < paramList.size())
      {
        paramContext = (PicInfo)paramList.get(i);
        if ((ShortVideoUtils.awI()) && ((!TextUtils.isEmpty(paramContext.videoUrl)) || (!TextUtils.isEmpty(paramContext.videoLocalPath)))) {}
        for (paramContext = new akbj(this.mContext, paramContext);; paramContext = new akbi(this.mContext, paramContext))
        {
          this.yh.add(paramContext);
          i += 1;
          break;
        }
      }
    }
  }
  
  public akbr a()
  {
    if ((this.cVo < 0) || (this.cVo >= this.yh.size())) {
      return null;
    }
    return (akbr)this.yh.get(this.cVo);
  }
  
  public akbr a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.yh.size())) {
      return null;
    }
    return (akbr)this.yh.get(paramInt);
  }
  
  public akbr b(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.yh != null)
    {
      localObject1 = localObject2;
      if (paramInt >= 0)
      {
        localObject1 = localObject2;
        if (paramInt < this.yh.size()) {
          localObject1 = (akbr)this.yh.remove(paramInt);
        }
      }
    }
    return localObject1;
  }
  
  public ArrayList<PicInfo> dl()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < this.yh.size())
    {
      localArrayList.add(((akbr)this.yh.get(i)).a);
      i += 1;
    }
    return localArrayList;
  }
  
  public int getCount()
  {
    return this.yh.size();
  }
  
  public int getSelectedIndex()
  {
    return this.cVo;
  }
  
  public void onPause()
  {
    if ((this.cVo >= 0) && (this.cVo < this.yh.size())) {
      ((akbr)this.yh.get(this.cVo)).onPause();
    }
  }
  
  public void setSelectedIndex(int paramInt)
  {
    this.cVo = paramInt;
    int i = 0;
    if (i < this.yh.size())
    {
      akbr localakbr = (akbr)this.yh.get(i);
      if (paramInt == i) {}
      for (boolean bool = true;; bool = false)
      {
        localakbr.MF(bool);
        i += 1;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     akbt
 * JD-Core Version:    0.7.0.1
 */