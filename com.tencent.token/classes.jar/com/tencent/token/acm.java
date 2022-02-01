package com.tencent.token;

import com.tencent.turingfd.sdk.base.Haw;
import com.tencent.turingfd.sdk.base.Herbaceous;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class acm
{
  public final int a;
  public Object[] b;
  public int c;
  public final int d;
  public final int e;
  
  public acm(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = new Object[(int)Math.ceil(paramInt3 * 1.0F / paramInt2)];
    this.c = 0;
    this.d = paramInt3;
    this.e = paramInt2;
  }
  
  public final ArrayList<Herbaceous> a(List<acp> paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    for (;;)
    {
      Object localObject1 = this.b;
      if (j >= localObject1.length) {
        break;
      }
      Object localObject2 = (List)localObject1[j];
      if ((localObject2 != null) && (((List)localObject2).size() != 0))
      {
        localObject1 = new Herbaceous();
        ArrayList localArrayList2 = new ArrayList();
        Object localObject3 = (List)this.b[j];
        int k = 2;
        if (localObject3 != null)
        {
          i = 0;
          while (i < ((List)localObject3).size())
          {
            aco localaco = (aco)((List)localObject3).get(i);
            Haw localHaw = new Haw();
            float[] arrayOfFloat = localaco.c;
            localHaw.x = arrayOfFloat[0];
            localHaw.y = arrayOfFloat[1];
            localHaw.z = arrayOfFloat[2];
            localHaw.Rc = localaco.b;
            localArrayList2.add(localHaw);
            i += 1;
          }
        }
        localObject3 = new HashMap();
        int i = this.a;
        if (i == 1) {
          i = 0;
        } else if (i == 4) {
          i = k;
        } else if (i == 9) {
          i = 4;
        } else if (i == 2) {
          i = 5;
        } else {
          i = -1;
        }
        ((Map)localObject3).put(Integer.valueOf(i), localArrayList2);
        ((Herbaceous)localObject1).Uc = ((Map)localObject3);
        localObject2 = (aco)((List)localObject2).get(0);
        if (localObject2 != null)
        {
          ((Herbaceous)localObject1).Tc = ((aco)localObject2).b;
          if (paramList.size() > j)
          {
            localObject2 = (acp)paramList.get(j);
            if (localObject2 != null)
            {
              ((Herbaceous)localObject1).Xc = ((acp)localObject2).a;
              ((Herbaceous)localObject1).Yc = ((acp)localObject2).b;
            }
          }
          localArrayList1.add(localObject1);
        }
      }
      j += 1;
    }
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acm
 * JD-Core Version:    0.7.0.1
 */