import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class afzl
{
  private final int cVF = 7;
  private int cVG = -1;
  private int cVH;
  private int mLineHeight;
  private int mParentWidth = -1;
  private ArrayList<afzm> tagList = new ArrayList();
  
  public afzl(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.cVG = paramInt1;
    this.mParentWidth = paramInt2;
    this.mLineHeight = paramInt3;
    this.cVH = paramInt4;
  }
  
  private int DS()
  {
    switch (this.cVG)
    {
    default: 
      return 0;
    case 0: 
      return -30;
    case 1: 
      return -80;
    case 2: 
      return -10;
    }
    return -60;
  }
  
  private void eg(ArrayList<afub> paramArrayList)
  {
    if (paramArrayList == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < paramArrayList.size())
      {
        a(new afzm((afub)paramArrayList.get(i)));
        i += 1;
      }
    }
  }
  
  public void NH(int paramInt)
  {
    int m = 0;
    int j = 0;
    if (this.tagList.size() < 2)
    {
      QLog.e("RaceLine horserace", 2, "tag 数量连2个都没有，不滑了哦～嘤嘤嘤嘤嘤～");
      return;
    }
    if ((this.mParentWidth == -1) || (this.mParentWidth < 10))
    {
      QLog.e("RaceLine horserace", 2, "mParentWidth err num");
      return;
    }
    afzm localafzm1;
    int k;
    afzm localafzm2;
    if (paramInt > 0)
    {
      for (i = -1; j < this.tagList.size(); i = k)
      {
        localafzm1 = (afzm)this.tagList.get(j);
        localafzm1.NI(localafzm1.DT() + paramInt);
        m = localafzm1.DT();
        k = i;
        if (m > 0)
        {
          k = i;
          if (m < this.mParentWidth)
          {
            k = i;
            if (i == -1) {
              k = j;
            }
          }
        }
        j += 1;
      }
      if (i == -1)
      {
        QLog.e("RaceLine horserace", 2, "SubIndex out of range");
        return;
      }
      paramInt = i;
      if (paramInt >= 0)
      {
        localafzm1 = (afzm)this.tagList.get(paramInt);
        if (localafzm1.DT() > this.mParentWidth)
        {
          localafzm2 = localafzm1.b();
          if (localafzm2 != null) {
            break label242;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.cVG);
        }
        for (;;)
        {
          paramInt -= 1;
          break;
          label242:
          localafzm1.NI(localafzm2.DT() - localafzm1.getWidth());
        }
      }
      paramInt = this.tagList.size() - 1;
      label271:
      if (paramInt > i)
      {
        localafzm1 = (afzm)this.tagList.get(paramInt);
        if (localafzm1.DT() > this.mParentWidth)
        {
          localafzm2 = localafzm1.b();
          if (localafzm2 != null) {
            break label357;
          }
          QLog.e("RaceLine horserace", 2, "rightBro is null " + paramInt + "  index:" + this.cVG);
        }
      }
      for (;;)
      {
        paramInt -= 1;
        break label271;
        break;
        label357:
        localafzm1.NI(localafzm2.DT() - localafzm1.getWidth());
      }
    }
    j = 0;
    for (int i = -1; j < this.tagList.size(); i = k)
    {
      localafzm1 = (afzm)this.tagList.get(j);
      localafzm1.NI(localafzm1.DT() + paramInt);
      k = localafzm1.DT();
      int n = localafzm1.getWidth() + k;
      k = i;
      if (n > 0)
      {
        k = i;
        if (n < this.mParentWidth)
        {
          k = i;
          if (i == -1) {
            k = j;
          }
        }
      }
      j += 1;
    }
    if (i == -1)
    {
      QLog.e("RaceLine horserace", 2, "SubIndex out of range");
      return;
    }
    paramInt = i;
    j = m;
    if (paramInt < this.tagList.size())
    {
      localafzm1 = (afzm)this.tagList.get(paramInt);
      if (localafzm1.DT() + localafzm1.getWidth() < 0)
      {
        localafzm2 = localafzm1.a();
        if (localafzm2 != null) {
          break label587;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + paramInt + "  index:" + this.cVG);
      }
      for (;;)
      {
        paramInt += 1;
        break;
        label587:
        j = localafzm2.DT();
        localafzm1.NI(localafzm2.getWidth() + j);
      }
    }
    label608:
    if (j < i)
    {
      localafzm1 = (afzm)this.tagList.get(j);
      if (localafzm1.DT() + localafzm1.getWidth() < 0)
      {
        localafzm2 = localafzm1.a();
        if (localafzm2 != null) {
          break label696;
        }
        QLog.e("RaceLine horserace", 2, "leftBro is null " + j + "  index:" + this.cVG);
      }
    }
    for (;;)
    {
      j += 1;
      break label608;
      break;
      label696:
      paramInt = localafzm2.DT();
      localafzm1.NI(localafzm2.getWidth() + paramInt);
    }
  }
  
  public void a(afzm paramafzm)
  {
    if (this.tagList.size() > 0)
    {
      ((afzm)this.tagList.get(0)).b(paramafzm);
      ((afzm)this.tagList.get(this.tagList.size() - 1)).c(paramafzm);
      paramafzm.c((afzm)this.tagList.get(0));
      paramafzm.b((afzm)this.tagList.get(this.tagList.size() - 1));
    }
    for (;;)
    {
      this.tagList.add(paramafzm);
      return;
      paramafzm.b(paramafzm);
      paramafzm.c(paramafzm);
    }
  }
  
  public void dei()
  {
    int m = 0;
    if ((this.tagList == null) || (this.tagList.size() == 0))
    {
      QLog.e("RaceLine horserace", 2, "一个都没有，没法复制啊大哥");
      return;
    }
    int j = 0;
    int i = 0;
    for (int k = 0; j < this.tagList.size(); k = n)
    {
      int i1 = ((afzm)this.tagList.get(j)).getMeasuredWidth();
      n = k + i1;
      k = i;
      if (i < i1) {
        k = i1;
      }
      j += 1;
      i = k;
    }
    int n = this.mParentWidth + i;
    float f2 = 0.0F;
    float f1;
    if (k < n)
    {
      f1 = n / k;
      if (f1 <= 7.0F) {
        break label306;
      }
      f1 = 7.0F;
    }
    label306:
    for (;;)
    {
      ArrayList localArrayList = new ArrayList();
      j = 0;
      for (;;)
      {
        k = m;
        if (j >= this.tagList.size()) {
          break;
        }
        afub localafub = ((afzm)this.tagList.get(j)).b;
        if (localafub != null) {
          localArrayList.add(new afub(localafub.tagId, localafub.tagName, localafub.cUs));
        }
        j += 1;
      }
      for (;;)
      {
        f2 = f1;
        if (k >= f1) {
          break;
        }
        eg(localArrayList);
        k += 1;
      }
      QLog.d("RaceLine horserace", 2, "finalWid: " + n + " parent: " + this.mParentWidth + " maxTagwid:" + i + " copyTime : " + f2);
      return;
    }
  }
  
  public ArrayList<afzm> getTagList()
  {
    return this.tagList;
  }
  
  public void kP()
  {
    int i = 0;
    if (i < this.tagList.size())
    {
      afzm localafzm1 = (afzm)this.tagList.get(i);
      int j = this.cVG;
      if (i == 0)
      {
        localafzm1.NI(DS() + 0);
        localafzm1.NJ(this.mLineHeight * j + (j + 1) * this.cVH);
      }
      for (;;)
      {
        i += 1;
        break;
        afzm localafzm2 = (afzm)this.tagList.get(i - 1);
        int k = localafzm2.DT();
        localafzm1.NI(localafzm2.getWidth() + k);
        localafzm1.NJ(this.mLineHeight * j + (j + 1) * this.cVH);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afzl
 * JD-Core Version:    0.7.0.1
 */