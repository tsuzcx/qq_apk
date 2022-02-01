import com.tencent.mobileqq.app.BaseActivity;
import java.util.ArrayList;
import java.util.List;

class atyp
  implements atxf.a
{
  atyp(atyo paramatyo, BaseActivity paramBaseActivity) {}
  
  public atzy a()
  {
    Object localObject3 = null;
    int i = 0;
    Object localObject1;
    Object localObject2;
    int j;
    int k;
    switch (this.a.getType())
    {
    default: 
      localObject1 = null;
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = localObject3;
        if (((List)localObject1).size() > 0)
        {
          localObject2 = (agsd)((List)localObject1).get(i);
          j = ((agsd)localObject2).getCloudType();
          k = ((agsd)localObject2).DW();
          if (j != 7) {
            break label204;
          }
          localObject1 = new auaa(this.p, (List)localObject1, i);
        }
      }
      break;
    }
    for (;;)
    {
      ((atzy)localObject1).Oy(atyo.a(this.a));
      localObject2 = localObject1;
      return localObject2;
      localObject1 = this.a.fc();
      i = this.a.EI();
      break;
      localObject1 = this.a.fc();
      i = this.a.EI();
      break;
      localObject1 = new ArrayList(1);
      ((List)localObject1).add(this.a.a());
      break;
      label204:
      if (j == 9) {
        localObject1 = new auaj(this.p, (List)localObject1, i);
      } else {
        switch (k)
        {
        default: 
          localObject1 = new atzf(this.p, (List)localObject1, i);
          break;
        case 6000: 
          localObject1 = new atzm(this.p, (List)localObject1, i);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atyp
 * JD-Core Version:    0.7.0.1
 */