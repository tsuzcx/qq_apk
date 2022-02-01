import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aniy
{
  public static aniy.a a;
  public static aniy.b a;
  public static aniy.a b;
  public static aniy.b b;
  public static aniy.a c = new aniy.a(7.82D);
  public static aniy.a d = new aniy.a(0.0D);
  public anjc a;
  
  static
  {
    jdField_a_of_type_Aniy$b = new aniz();
    jdField_b_of_type_Aniy$b = new anja();
    jdField_a_of_type_Aniy$a = new aniy.a(16.27D);
    jdField_b_of_type_Aniy$a = new aniy.a(11.34D);
  }
  
  public static anjc a(List<anjb> paramList, aniy.b paramb)
  {
    paramList = new anjc(null, paramList);
    a(paramList, paramb, d, 0);
    return paramList;
  }
  
  static void a(anjc paramanjc, aniy.b paramb, aniy.a parama, int paramInt)
  {
    paramanjc.Gx.size();
    int i = ((anjb)paramanjc.Gx.get(0)).nE.length;
    i = anjb.dHC;
    Object localObject1 = (int[][])Array.newInstance(Integer.TYPE, new int[] { i, 2 });
    int k = 0;
    int m = 0;
    i = 0;
    if (i < paramanjc.Gx.size())
    {
      if (((anjb)paramanjc.Gx.get(i)).label == 1) {
        k += 1;
      }
      for (;;)
      {
        i += 1;
        break;
        m += 1;
      }
    }
    double d1 = -100000.0D;
    int j = -1;
    i = 0;
    Object localObject2;
    Object localObject3;
    if (i < paramanjc.dHE)
    {
      int n = anjb.dHC;
      localObject2 = (int[][])Array.newInstance(Integer.TYPE, new int[] { n, 2 });
      localObject3 = paramanjc.Gx.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        anjb localanjb = (anjb)((Iterator)localObject3).next();
        if (localanjb.label == 1)
        {
          localanjb = localObject2[localanjb.nE[i]];
          localanjb[1] += 1;
        }
        else
        {
          localanjb = localObject2[localanjb.nE[i]];
          localanjb[0] += 1;
        }
      }
      double d2 = paramb.e(k, m);
      n = 0;
      while (n < anjb.dHC)
      {
        d2 -= 1.0D * (localObject2[n][0] + localObject2[n][1]) / (k + m) * paramb.e(localObject2[n][0], localObject2[n][1]);
        n += 1;
      }
      if (d2 <= d1) {
        break label633;
      }
      j = 0;
      while (j < anjb.dHC)
      {
        localObject1[j][0] = localObject2[j][0];
        localObject1[j][1] = localObject2[j][1];
        j += 1;
      }
      j = i;
      d1 = d2;
    }
    label633:
    for (;;)
    {
      i += 1;
      break;
      if ((d1 > 1.0E-010D) && (parama.a((int[][])localObject1)))
      {
        paramanjc.dHD = j;
        localObject1 = new ArrayList();
        i = 0;
        while (i < anjb.dHC)
        {
          ((ArrayList)localObject1).add(new ArrayList());
          i += 1;
        }
        localObject2 = paramanjc.Gx.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (anjb)((Iterator)localObject2).next();
          ((ArrayList)((ArrayList)localObject1).get(localObject3.nE[j])).add(localObject3);
        }
        i = 0;
        while (i < anjb.dHC)
        {
          if (((j != 16) || (i != 2)) || (((ArrayList)((ArrayList)localObject1).get(i)).size() > 0))
          {
            paramanjc.a[i] = new anjc(paramanjc, (List)((ArrayList)localObject1).get(i));
            a(paramanjc.a[i], paramb, parama, paramInt + 1);
          }
          i += 1;
        }
      }
      return;
    }
  }
  
  public void mu(List<anjb> paramList)
  {
    this.jdField_a_of_type_Anjc = a(paramList, jdField_a_of_type_Aniy$b);
  }
  
  public static class a
  {
    double cY;
    
    a(double paramDouble)
    {
      this.cY = paramDouble;
    }
    
    public boolean a(int[][] paramArrayOfInt)
    {
      double d2 = 0.0D;
      int k = paramArrayOfInt.length;
      int m = paramArrayOfInt[0].length;
      double[] arrayOfDouble1 = new double[k];
      double[] arrayOfDouble2 = new double[m];
      double d1 = 0.0D;
      int i = 0;
      int j;
      while (i < k)
      {
        j = 0;
        while (j < m)
        {
          arrayOfDouble1[i] += paramArrayOfInt[i][j];
          d1 += paramArrayOfInt[i][j];
          j += 1;
        }
        i += 1;
      }
      i = 0;
      while (i < m)
      {
        j = 0;
        while (j < k)
        {
          arrayOfDouble2[i] += paramArrayOfInt[j][i];
          j += 1;
        }
        i += 1;
      }
      i = 0;
      while (i < k)
      {
        j = 0;
        while (j < m)
        {
          double d4 = 1.0D * arrayOfDouble1[i] * arrayOfDouble2[j] / d1;
          double d5 = paramArrayOfInt[i][j];
          double d3 = d2;
          if (d4 > 0.0D) {
            d3 = d2 + (d4 - d5) * (d4 - d5) / d4;
          }
          j += 1;
          d2 = d3;
        }
        i += 1;
      }
      return d2 > this.cY + 1.0E-008D;
    }
  }
  
  public static abstract class b
  {
    public abstract double e(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aniy
 * JD-Core Version:    0.7.0.1
 */