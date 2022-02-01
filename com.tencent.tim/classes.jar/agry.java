import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class agry
  implements agqi.a
{
  agry(agrx paramagrx, BaseActivity paramBaseActivity) {}
  
  public aguk a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    switch (this.a.getType())
    {
    default: 
      localObject1 = null;
    }
    int j;
    int k;
    for (;;)
    {
      Object localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((List)localObject1).size() > 0)
        {
          localObject2 = (agsd)((List)localObject1).get(i);
          j = ((agsd)localObject2).getCloudType();
          k = ((agsd)localObject2).DW();
          if (j != 7) {
            break;
          }
          localObject2 = new agum(this.p, (List)localObject1, i);
        }
      }
      return localObject2;
      localObject1 = this.a.fc();
      i = this.a.EI();
      continue;
      localObject1 = this.a.fc();
      i = this.a.EI();
      continue;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.a.a());
    }
    if (j == 9) {
      return new aguh(this.p, (List)localObject1, i);
    }
    switch (k)
    {
    default: 
      return new agth(this.p, (List)localObject1, i);
    case 6000: 
      return new agtm(this.p, (List)localObject1, i);
    }
    return new aguc(this.p, (List)localObject1, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agry
 * JD-Core Version:    0.7.0.1
 */