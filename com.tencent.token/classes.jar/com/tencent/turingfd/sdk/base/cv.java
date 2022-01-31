package com.tencent.turingfd.sdk.base;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class cv
{
  public final int a;
  public Object[] b;
  public int c;
  public final int d;
  public final int e;
  
  public cv(int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramInt1;
    this.b = new Object[(int)Math.ceil(paramInt3 * 1.0F / paramInt2)];
    this.c = 0;
    this.d = paramInt3;
    this.e = paramInt2;
  }
  
  public ArrayList a(List paramList)
  {
    ArrayList localArrayList1 = new ArrayList();
    int j = 0;
    Object localObject2;
    for (;;)
    {
      localObject1 = this.b;
      if (j >= localObject1.length) {
        break label347;
      }
      localObject2 = (List)localObject1[j];
      if ((localObject2 != null) && (((List)localObject2).size() != 0)) {
        break;
      }
      j += 1;
    }
    Object localObject1 = new Grapefruit();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject3 = (List)this.b[j];
    label89:
    int i;
    if (localObject3 == null)
    {
      localObject3 = new HashMap();
      i = this.a;
      if (i != 1) {
        break label311;
      }
      i = 0;
    }
    for (;;)
    {
      ((Map)localObject3).put(Integer.valueOf(i), localArrayList2);
      ((Grapefruit)localObject1).Wc = ((Map)localObject3);
      localObject2 = (cw)((List)localObject2).get(0);
      if (localObject2 == null) {
        break;
      }
      ((Grapefruit)localObject1).Vc = ((cw)localObject2).b;
      if (paramList.size() > j)
      {
        localObject2 = (cx)paramList.get(j);
        if (localObject2 != null)
        {
          ((Grapefruit)localObject1).Zc = ((cx)localObject2).a;
          ((Grapefruit)localObject1)._c = ((cx)localObject2).b;
        }
      }
      localArrayList1.add(localObject1);
      break;
      i = 0;
      while (i < ((List)localObject3).size())
      {
        cw localcw = (cw)((List)localObject3).get(i);
        Grape localGrape = new Grape();
        float[] arrayOfFloat = localcw.c;
        localGrape.x = arrayOfFloat[0];
        localGrape.y = arrayOfFloat[1];
        localGrape.z = arrayOfFloat[2];
        localGrape.Tc = localcw.b;
        localArrayList2.add(localGrape);
        i += 1;
      }
      break label89;
      label311:
      if (i == 4) {
        i = 2;
      } else if (i == 9) {
        i = 4;
      } else if (i == 2) {
        i = 5;
      } else {
        i = -1;
      }
    }
    label347:
    return localArrayList1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cv
 * JD-Core Version:    0.7.0.1
 */