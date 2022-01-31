package com.tencent.turingfd.sdk.base;

import android.util.SparseArray;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class g
  extends am
{
  public g(j paramj, String paramString, int paramInt, SparseArray paramSparseArray, List paramList, et paramet)
  {
    super(paramString);
  }
  
  public void a()
  {
    int k = this.a;
    et localet = this.d;
    SparseArray localSparseArray = this.b;
    List localList = this.c;
    Damson localDamson = new Damson();
    Guava localGuava = localet.e;
    Object localObject1 = new ArrayList();
    int i = 0;
    Object localObject2;
    if (i < localSparseArray.size())
    {
      localObject2 = ((cv)localSparseArray.valueAt(i)).a(localList);
      if (((ArrayList)localObject1).size() == 0) {}
      for (;;)
      {
        i += 1;
        localObject1 = localObject2;
        break;
        int j = 0;
        while (j < ((ArrayList)localObject2).size())
        {
          ((Grapefruit)((ArrayList)localObject2).get(j)).Wc.putAll(((Grapefruit)((ArrayList)localObject1).get(j)).Wc);
          j += 1;
        }
      }
    }
    if ((((ArrayList)localObject1).size() > 0) && (((ArrayList)localObject1).get(0) != null))
    {
      localObject2 = new Gooseberry();
      ((Gooseberry)localObject2).Oc = ((Grapefruit)((ArrayList)localObject1).get(0)).Vc;
      ((Gooseberry)localObject2).Pc = ((ArrayList)localObject1);
      ((Gooseberry)localObject2).rc = k;
      ((Gooseberry)localObject2).action = 1;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localGuava);
      ((Gooseberry)localObject2).Sc = ((ArrayList)localObject1);
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localObject2);
      localDamson.Ob = ((ArrayList)localObject1);
      long l = localet.e.cd;
      i = localet.d;
      localObject2 = new Dew();
      ((Dew)localObject2).qc = l;
      ((Dew)localObject2).rc = k;
      ((Dew)localObject2).pc = i;
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add(localObject2);
      localObject2 = new Cumquat();
      ((Cumquat)localObject2).Cb = ((ArrayList)localObject1);
      localDamson.dc = ((Cumquat)localObject2);
      localDamson.fc = new ArrayList();
      ((x)x.a.b()).a(this.d.c, this.a, 0, localDamson);
      localObject1 = this.d.f;
      if (localObject1 != null) {
        ef.a(this.a, ((dr)localObject1).a);
      }
      return;
    }
    throw new IllegalArgumentException("invalid stateUnits");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.g
 * JD-Core Version:    0.7.0.1
 */