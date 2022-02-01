package wf7;

import java.util.ArrayList;

public class ck
{
  static final ArrayList<Integer> hz = new ArrayList();
  
  static
  {
    hz.add(Integer.valueOf(0));
    hz.add(Integer.valueOf(1));
    hz.add(Integer.valueOf(3));
    hz.add(Integer.valueOf(4));
    hz.add(Integer.valueOf(5));
    hz.add(Integer.valueOf(6));
    hz.add(Integer.valueOf(7));
    hz.add(Integer.valueOf(8));
    hz.add(Integer.valueOf(9));
    hz.add(Integer.valueOf(10));
    hz.add(Integer.valueOf(11));
    hz.add(Integer.valueOf(12));
    hz.add(Integer.valueOf(13));
    hz.add(Integer.valueOf(14));
    hz.add(Integer.valueOf(15));
    hz.add(Integer.valueOf(16));
    hz.add(Integer.valueOf(18));
    hz.add(Integer.valueOf(20));
    hz.add(Integer.valueOf(24));
  }
  
  public static boolean L(int paramInt)
  {
    return hz.contains(Integer.valueOf(paramInt));
  }
  
  public static boolean M(int paramInt)
  {
    return (paramInt == 4) || (paramInt == 9) || (paramInt == 10) || (paramInt == 5);
  }
  
  public static boolean N(int paramInt)
  {
    return paramInt == 3;
  }
  
  public static boolean O(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 1)
    {
      if (paramInt == 24) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public static boolean P(int paramInt)
  {
    return paramInt == 19;
  }
  
  public static boolean Q(int paramInt)
  {
    return paramInt == 27;
  }
  
  public static boolean f(int paramInt1, int paramInt2)
  {
    return (O(paramInt1)) || (N(paramInt1)) || (M(paramInt1)) || (g(paramInt1, paramInt2)) || (i(paramInt1, paramInt2)) || (h(paramInt1, paramInt2)) || (P(paramInt1)) || (j(paramInt1, paramInt2)) || (k(paramInt1, paramInt2)) || (l(paramInt1, paramInt2)) || (m(paramInt1, paramInt2)) || (Q(paramInt1)) || (n(paramInt1, paramInt2)) || (o(paramInt1, paramInt2));
  }
  
  public static boolean g(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 14) && ((paramInt2 == 0) || (paramInt2 == -1));
  }
  
  public static boolean h(int paramInt1, int paramInt2)
  {
    return ((paramInt1 == 17) || (paramInt1 == 30) || (paramInt1 == 22) || (paramInt1 == 26)) && ((paramInt2 == 2) || (paramInt2 == -1));
  }
  
  public static boolean i(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 18) && ((paramInt2 == 0) || (paramInt2 == -1));
  }
  
  public static boolean j(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 20) && ((paramInt2 == 2) || (paramInt2 == -1));
  }
  
  public static boolean k(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 21) && ((paramInt2 == 0) || (paramInt2 == -1));
  }
  
  public static boolean l(int paramInt1, int paramInt2)
  {
    return paramInt1 == 23;
  }
  
  public static boolean m(int paramInt1, int paramInt2)
  {
    return (paramInt1 == 25) && ((paramInt2 == 0) || (paramInt2 == -1));
  }
  
  public static boolean n(int paramInt1, int paramInt2)
  {
    return paramInt1 == 28;
  }
  
  public static boolean o(int paramInt1, int paramInt2)
  {
    return paramInt1 == 31;
  }
  
  public static boolean p(int paramInt1, int paramInt2)
  {
    return (O(paramInt1)) || (h(paramInt1, paramInt2)) || ((P(paramInt1)) && (cg.aL().aN() != null)) || (l(paramInt1, paramInt2)) || ((Q(paramInt1)) && (cg.aL().aO())) || ((m(paramInt1, paramInt2)) && (cg.aL().aO())) || ((n(paramInt1, paramInt2)) && (cg.aL().aO()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wf7.ck
 * JD-Core Version:    0.7.0.1
 */