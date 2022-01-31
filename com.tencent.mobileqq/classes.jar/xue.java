public class xue
{
  private void a(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i = paramInt1 >> 2;
    a(paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - i * 2);
    if (paramInt1 > 512)
    {
      a(i, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
      b(i, paramArrayOfDouble1, paramInt2 + i, paramInt3, paramArrayOfDouble2);
      a(i, paramArrayOfDouble1, paramInt2 + i * 2, paramInt3, paramArrayOfDouble2);
      a(i, paramArrayOfDouble1, paramInt2 + i * 3, paramInt3, paramArrayOfDouble2);
      return;
    }
    c(paramInt1, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
  }
  
  private final void a(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int j = paramInt1 >> 3;
    int k = j * 2;
    paramInt1 = k + k;
    int i = paramInt1 + k;
    double d1 = paramArrayOfDouble1[(paramInt2 + 0)] + paramArrayOfDouble1[(paramInt2 + paramInt1)];
    double d2 = paramArrayOfDouble1[(paramInt2 + 1)] + paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)];
    double d3 = paramArrayOfDouble1[(paramInt2 + 0)] - paramArrayOfDouble1[(paramInt2 + paramInt1)];
    double d4 = paramArrayOfDouble1[(paramInt2 + 1)] - paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)];
    double d5 = paramArrayOfDouble1[(paramInt2 + k)] + paramArrayOfDouble1[(paramInt2 + i)];
    double d6 = paramArrayOfDouble1[(paramInt2 + k + 1)] + paramArrayOfDouble1[(paramInt2 + i + 1)];
    double d7 = paramArrayOfDouble1[(paramInt2 + k)] - paramArrayOfDouble1[(paramInt2 + i)];
    double d8 = paramArrayOfDouble1[(paramInt2 + k + 1)] - paramArrayOfDouble1[(paramInt2 + i + 1)];
    paramArrayOfDouble1[(paramInt2 + 0)] = (d1 + d5);
    paramArrayOfDouble1[(paramInt2 + 1)] = (d2 + d6);
    paramArrayOfDouble1[(paramInt2 + k)] = (d1 - d5);
    paramArrayOfDouble1[(paramInt2 + k + 1)] = (d2 - d6);
    paramArrayOfDouble1[(paramInt2 + paramInt1)] = (d3 - d8);
    paramArrayOfDouble1[(paramInt1 + paramInt2 + 1)] = (d4 + d7);
    paramArrayOfDouble1[(paramInt2 + i)] = (d3 + d8);
    paramArrayOfDouble1[(paramInt2 + i + 1)] = (d4 - d7);
    d1 = paramArrayOfDouble2[(paramInt3 + 1)];
    i = 0;
    paramInt1 = 2;
    while (paramInt1 < j)
    {
      i += 4;
      d4 = paramArrayOfDouble2[(paramInt3 + i)];
      d5 = paramArrayOfDouble2[(paramInt3 + i + 1)];
      d2 = paramArrayOfDouble2[(paramInt3 + i + 2)];
      d3 = -paramArrayOfDouble2[(paramInt3 + i + 3)];
      int m = paramInt1 + k;
      int n = m + k;
      int i1 = n + k;
      double d10 = paramArrayOfDouble1[(paramInt2 + paramInt1)] + paramArrayOfDouble1[(paramInt2 + n)];
      double d11 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] + paramArrayOfDouble1[(paramInt2 + n + 1)];
      d8 = paramArrayOfDouble1[(paramInt2 + paramInt1)] - paramArrayOfDouble1[(paramInt2 + n)];
      d6 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] - paramArrayOfDouble1[(paramInt2 + n + 1)];
      double d12 = paramArrayOfDouble1[(paramInt2 + m)] + paramArrayOfDouble1[(paramInt2 + i1)];
      double d13 = paramArrayOfDouble1[(paramInt2 + m + 1)] + paramArrayOfDouble1[(paramInt2 + i1 + 1)];
      d7 = paramArrayOfDouble1[(paramInt2 + m)] - paramArrayOfDouble1[(paramInt2 + i1)];
      d9 = paramArrayOfDouble1[(paramInt2 + m + 1)] - paramArrayOfDouble1[(paramInt2 + i1 + 1)];
      paramArrayOfDouble1[(paramInt2 + paramInt1)] = (d10 + d12);
      paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] = (d11 + d13);
      paramArrayOfDouble1[(paramInt2 + m)] = (d10 - d12);
      paramArrayOfDouble1[(m + paramInt2 + 1)] = (d11 - d13);
      d10 = d8 - d9;
      d11 = d6 + d7;
      paramArrayOfDouble1[(paramInt2 + n)] = (d4 * d10 - d5 * d11);
      paramArrayOfDouble1[(paramInt2 + n + 1)] = (d10 * d5 + d11 * d4);
      d8 += d9;
      d6 -= d7;
      paramArrayOfDouble1[(paramInt2 + i1)] = (d2 * d8 + d3 * d6);
      paramArrayOfDouble1[(i1 + paramInt2 + 1)] = (d6 * d2 - d8 * d3);
      m = k - paramInt1;
      n = m + k;
      i1 = n + k;
      int i2 = i1 + k;
      d10 = paramArrayOfDouble1[(paramInt2 + m)] + paramArrayOfDouble1[(paramInt2 + i1)];
      d11 = paramArrayOfDouble1[(paramInt2 + m + 1)] + paramArrayOfDouble1[(paramInt2 + i1 + 1)];
      d8 = paramArrayOfDouble1[(paramInt2 + m)] - paramArrayOfDouble1[(paramInt2 + i1)];
      d6 = paramArrayOfDouble1[(paramInt2 + m + 1)] - paramArrayOfDouble1[(paramInt2 + i1 + 1)];
      d12 = paramArrayOfDouble1[(paramInt2 + n)] + paramArrayOfDouble1[(paramInt2 + i2)];
      d13 = paramArrayOfDouble1[(paramInt2 + n + 1)] + paramArrayOfDouble1[(paramInt2 + i2 + 1)];
      d7 = paramArrayOfDouble1[(paramInt2 + n)] - paramArrayOfDouble1[(paramInt2 + i2)];
      d9 = paramArrayOfDouble1[(paramInt2 + n + 1)] - paramArrayOfDouble1[(paramInt2 + i2 + 1)];
      paramArrayOfDouble1[(paramInt2 + m)] = (d10 + d12);
      paramArrayOfDouble1[(m + paramInt2 + 1)] = (d11 + d13);
      paramArrayOfDouble1[(paramInt2 + n)] = (d10 - d12);
      paramArrayOfDouble1[(paramInt2 + n + 1)] = (d11 - d13);
      d10 = d8 - d9;
      d11 = d6 + d7;
      paramArrayOfDouble1[(paramInt2 + i1)] = (d5 * d10 - d4 * d11);
      paramArrayOfDouble1[(i1 + paramInt2 + 1)] = (d4 * d10 + d5 * d11);
      d4 = d8 + d9;
      d5 = d6 - d7;
      paramArrayOfDouble1[(paramInt2 + i2)] = (d3 * d4 + d2 * d5);
      paramArrayOfDouble1[(paramInt2 + i2 + 1)] = (d5 * d3 - d4 * d2);
      paramInt1 += 2;
    }
    paramInt1 = j + k;
    paramInt3 = paramInt1 + k;
    i = k + paramInt3;
    d6 = paramArrayOfDouble1[(paramInt2 + j)] + paramArrayOfDouble1[(paramInt2 + paramInt3)];
    d7 = paramArrayOfDouble1[(paramInt2 + j + 1)] + paramArrayOfDouble1[(paramInt2 + paramInt3 + 1)];
    d4 = paramArrayOfDouble1[(paramInt2 + j)] - paramArrayOfDouble1[(paramInt2 + paramInt3)];
    d2 = paramArrayOfDouble1[(paramInt2 + j + 1)] - paramArrayOfDouble1[(paramInt2 + paramInt3 + 1)];
    d8 = paramArrayOfDouble1[(paramInt2 + paramInt1)] + paramArrayOfDouble1[(paramInt2 + i)];
    double d9 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] + paramArrayOfDouble1[(paramInt2 + i + 1)];
    d3 = paramArrayOfDouble1[(paramInt2 + paramInt1)] - paramArrayOfDouble1[(paramInt2 + i)];
    d5 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] - paramArrayOfDouble1[(paramInt2 + i + 1)];
    paramArrayOfDouble1[(paramInt2 + j)] = (d6 + d8);
    paramArrayOfDouble1[(j + paramInt2 + 1)] = (d7 + d9);
    paramArrayOfDouble1[(paramInt2 + paramInt1)] = (d6 - d8);
    paramArrayOfDouble1[(paramInt1 + paramInt2 + 1)] = (d7 - d9);
    d6 = d4 - d5;
    d7 = d2 + d3;
    paramArrayOfDouble1[(paramInt2 + paramInt3)] = ((d6 - d7) * d1);
    paramArrayOfDouble1[(paramInt2 + paramInt3 + 1)] = ((d6 + d7) * d1);
    d4 += d5;
    d2 -= d3;
    paramArrayOfDouble1[(paramInt2 + i)] = (-d1 * (d4 + d2));
    paramArrayOfDouble1[(paramInt2 + i + 1)] = ((d2 - d4) * -d1);
  }
  
  private void a(int paramInt1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt2)
  {
    int j = paramInt1 >> 3;
    int k = j * 2;
    paramInt1 = k + k;
    int i = paramInt1 + k;
    double d1 = paramArrayOfDouble1[0] + paramArrayOfDouble1[paramInt1];
    double d2 = paramArrayOfDouble1[1] + paramArrayOfDouble1[(paramInt1 + 1)];
    double d3 = paramArrayOfDouble1[0] - paramArrayOfDouble1[paramInt1];
    double d4 = paramArrayOfDouble1[1] - paramArrayOfDouble1[(paramInt1 + 1)];
    double d5 = paramArrayOfDouble1[k] + paramArrayOfDouble1[i];
    double d6 = paramArrayOfDouble1[(k + 1)] + paramArrayOfDouble1[(i + 1)];
    double d7 = paramArrayOfDouble1[k] - paramArrayOfDouble1[i];
    double d8 = paramArrayOfDouble1[(k + 1)] - paramArrayOfDouble1[(i + 1)];
    paramArrayOfDouble1[0] = (d1 + d5);
    paramArrayOfDouble1[1] = (d2 + d6);
    paramArrayOfDouble1[k] = (d1 - d5);
    paramArrayOfDouble1[(k + 1)] = (d2 - d6);
    paramArrayOfDouble1[paramInt1] = (d3 - d8);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d4 + d7);
    paramArrayOfDouble1[i] = (d3 + d8);
    paramArrayOfDouble1[(i + 1)] = (d4 - d7);
    d5 = paramArrayOfDouble2[(paramInt2 + 1)];
    d7 = paramArrayOfDouble2[(paramInt2 + 2)];
    d6 = paramArrayOfDouble2[(paramInt2 + 3)];
    d4 = 1.0D;
    d3 = 0.0D;
    d2 = 1.0D;
    d1 = 0.0D;
    i = 0;
    paramInt1 = 2;
    while (paramInt1 < j - 2)
    {
      i += 4;
      d10 = d7 * (d4 + paramArrayOfDouble2[(paramInt2 + i)]);
      d11 = d7 * (d3 + paramArrayOfDouble2[(paramInt2 + i + 1)]);
      d8 = d6 * (d2 + paramArrayOfDouble2[(paramInt2 + i + 2)]);
      d9 = d6 * (d1 - paramArrayOfDouble2[(paramInt2 + i + 3)]);
      d4 = paramArrayOfDouble2[(paramInt2 + i)];
      d3 = paramArrayOfDouble2[(paramInt2 + i + 1)];
      d2 = paramArrayOfDouble2[(paramInt2 + i + 2)];
      d1 = -paramArrayOfDouble2[(paramInt2 + i + 3)];
      int m = paramInt1 + k;
      int n = m + k;
      int i1 = n + k;
      double d20 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[n];
      double d21 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(n + 1)];
      double d18 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[n];
      double d16 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(n + 1)];
      double d22 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(n + 2)];
      double d23 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(n + 3)];
      double d14 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(n + 2)];
      d12 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(n + 3)];
      double d24 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      double d25 = paramArrayOfDouble1[(m + 1)] + paramArrayOfDouble1[(i1 + 1)];
      double d17 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      double d19 = paramArrayOfDouble1[(m + 1)] - paramArrayOfDouble1[(i1 + 1)];
      double d26 = paramArrayOfDouble1[(m + 2)] + paramArrayOfDouble1[(i1 + 2)];
      double d27 = paramArrayOfDouble1[(m + 3)] + paramArrayOfDouble1[(i1 + 3)];
      d13 = paramArrayOfDouble1[(m + 2)] - paramArrayOfDouble1[(i1 + 2)];
      double d15 = paramArrayOfDouble1[(m + 3)] - paramArrayOfDouble1[(i1 + 3)];
      paramArrayOfDouble1[paramInt1] = (d20 + d24);
      paramArrayOfDouble1[(paramInt1 + 1)] = (d21 + d25);
      paramArrayOfDouble1[(paramInt1 + 2)] = (d22 + d26);
      paramArrayOfDouble1[(paramInt1 + 3)] = (d23 + d27);
      paramArrayOfDouble1[m] = (d20 - d24);
      paramArrayOfDouble1[(m + 1)] = (d21 - d25);
      paramArrayOfDouble1[(m + 2)] = (d22 - d26);
      paramArrayOfDouble1[(m + 3)] = (d23 - d27);
      d20 = d18 - d19;
      d21 = d16 + d17;
      paramArrayOfDouble1[n] = (d10 * d20 - d11 * d21);
      paramArrayOfDouble1[(n + 1)] = (d20 * d11 + d21 * d10);
      d20 = d14 - d15;
      d21 = d12 + d13;
      paramArrayOfDouble1[(n + 2)] = (d4 * d20 - d3 * d21);
      paramArrayOfDouble1[(n + 3)] = (d20 * d3 + d21 * d4);
      d18 += d19;
      d16 -= d17;
      paramArrayOfDouble1[i1] = (d8 * d18 + d9 * d16);
      paramArrayOfDouble1[(i1 + 1)] = (d16 * d8 - d18 * d9);
      d14 += d15;
      d12 -= d13;
      paramArrayOfDouble1[(i1 + 2)] = (d2 * d14 + d1 * d12);
      paramArrayOfDouble1[(i1 + 3)] = (d12 * d2 - d14 * d1);
      m = k - paramInt1;
      n = m + k;
      i1 = n + k;
      int i2 = i1 + k;
      d20 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      d21 = paramArrayOfDouble1[(m + 1)] + paramArrayOfDouble1[(i1 + 1)];
      d18 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      d16 = paramArrayOfDouble1[(m + 1)] - paramArrayOfDouble1[(i1 + 1)];
      d22 = paramArrayOfDouble1[(m - 2)] + paramArrayOfDouble1[(i1 - 2)];
      d23 = paramArrayOfDouble1[(m - 1)] + paramArrayOfDouble1[(i1 - 1)];
      d14 = paramArrayOfDouble1[(m - 2)] - paramArrayOfDouble1[(i1 - 2)];
      d12 = paramArrayOfDouble1[(m - 1)] - paramArrayOfDouble1[(i1 - 1)];
      d24 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i2];
      d25 = paramArrayOfDouble1[(n + 1)] + paramArrayOfDouble1[(i2 + 1)];
      d17 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i2];
      d19 = paramArrayOfDouble1[(n + 1)] - paramArrayOfDouble1[(i2 + 1)];
      d26 = paramArrayOfDouble1[(n - 2)] + paramArrayOfDouble1[(i2 - 2)];
      d27 = paramArrayOfDouble1[(n - 1)] + paramArrayOfDouble1[(i2 - 1)];
      d13 = paramArrayOfDouble1[(n - 2)] - paramArrayOfDouble1[(i2 - 2)];
      d15 = paramArrayOfDouble1[(n - 1)] - paramArrayOfDouble1[(i2 - 1)];
      paramArrayOfDouble1[m] = (d20 + d24);
      paramArrayOfDouble1[(m + 1)] = (d21 + d25);
      paramArrayOfDouble1[(m - 2)] = (d22 + d26);
      paramArrayOfDouble1[(m - 1)] = (d23 + d27);
      paramArrayOfDouble1[n] = (d20 - d24);
      paramArrayOfDouble1[(n + 1)] = (d21 - d25);
      paramArrayOfDouble1[(n - 2)] = (d22 - d26);
      paramArrayOfDouble1[(n - 1)] = (d23 - d27);
      d20 = d18 - d19;
      d21 = d16 + d17;
      paramArrayOfDouble1[i1] = (d11 * d20 - d10 * d21);
      paramArrayOfDouble1[(i1 + 1)] = (d10 * d20 + d11 * d21);
      d10 = d14 - d15;
      d11 = d12 + d13;
      paramArrayOfDouble1[(i1 - 2)] = (d3 * d10 - d4 * d11);
      paramArrayOfDouble1[(i1 - 1)] = (d10 * d4 + d11 * d3);
      d10 = d18 + d19;
      d11 = d16 - d17;
      paramArrayOfDouble1[i2] = (d9 * d10 + d8 * d11);
      paramArrayOfDouble1[(i2 + 1)] = (d11 * d9 - d10 * d8);
      d8 = d14 + d15;
      d9 = d12 - d13;
      paramArrayOfDouble1[(i2 - 2)] = (d1 * d8 + d2 * d9);
      paramArrayOfDouble1[(i2 - 1)] = (d9 * d1 - d8 * d2);
      paramInt1 += 4;
    }
    d4 = (d4 + d5) * d7;
    d3 = (d3 + d5) * d7;
    d2 = (d2 - d5) * d6;
    d1 = (d1 - d5) * d6;
    paramInt1 = j + k;
    paramInt2 = paramInt1 + k;
    i = k + paramInt2;
    double d10 = paramArrayOfDouble1[(j - 2)] + paramArrayOfDouble1[(paramInt2 - 2)];
    double d11 = paramArrayOfDouble1[(j - 1)] + paramArrayOfDouble1[(paramInt2 - 1)];
    d8 = paramArrayOfDouble1[(j - 2)] - paramArrayOfDouble1[(paramInt2 - 2)];
    d6 = paramArrayOfDouble1[(j - 1)] - paramArrayOfDouble1[(paramInt2 - 1)];
    double d12 = paramArrayOfDouble1[(paramInt1 - 2)] + paramArrayOfDouble1[(i - 2)];
    double d13 = paramArrayOfDouble1[(paramInt1 - 1)] + paramArrayOfDouble1[(i - 1)];
    d7 = paramArrayOfDouble1[(paramInt1 - 2)] - paramArrayOfDouble1[(i - 2)];
    double d9 = paramArrayOfDouble1[(paramInt1 - 1)] - paramArrayOfDouble1[(i - 1)];
    paramArrayOfDouble1[(j - 2)] = (d10 + d12);
    paramArrayOfDouble1[(j - 1)] = (d11 + d13);
    paramArrayOfDouble1[(paramInt1 - 2)] = (d10 - d12);
    paramArrayOfDouble1[(paramInt1 - 1)] = (d11 - d13);
    d10 = d8 - d9;
    d11 = d6 + d7;
    paramArrayOfDouble1[(paramInt2 - 2)] = (d4 * d10 - d3 * d11);
    paramArrayOfDouble1[(paramInt2 - 1)] = (d10 * d3 + d11 * d4);
    d8 += d9;
    d6 -= d7;
    paramArrayOfDouble1[(i - 2)] = (d2 * d8 + d1 * d6);
    paramArrayOfDouble1[(i - 1)] = (d6 * d2 - d8 * d1);
    d10 = paramArrayOfDouble1[j] + paramArrayOfDouble1[paramInt2];
    d11 = paramArrayOfDouble1[(j + 1)] + paramArrayOfDouble1[(paramInt2 + 1)];
    d8 = paramArrayOfDouble1[j] - paramArrayOfDouble1[paramInt2];
    d6 = paramArrayOfDouble1[(j + 1)] - paramArrayOfDouble1[(paramInt2 + 1)];
    d12 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[i];
    d13 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(i + 1)];
    d7 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[i];
    d9 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(i + 1)];
    paramArrayOfDouble1[j] = (d10 + d12);
    paramArrayOfDouble1[(j + 1)] = (d11 + d13);
    paramArrayOfDouble1[paramInt1] = (d10 - d12);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d11 - d13);
    d10 = d8 - d9;
    d11 = d6 + d7;
    paramArrayOfDouble1[paramInt2] = ((d10 - d11) * d5);
    paramArrayOfDouble1[(paramInt2 + 1)] = ((d10 + d11) * d5);
    d8 += d9;
    d6 -= d7;
    paramArrayOfDouble1[i] = (-d5 * (d8 + d6));
    paramArrayOfDouble1[(i + 1)] = (-d5 * (d6 - d8));
    d9 = paramArrayOfDouble1[(j + 2)] + paramArrayOfDouble1[(paramInt2 + 2)];
    d10 = paramArrayOfDouble1[(j + 3)] + paramArrayOfDouble1[(paramInt2 + 3)];
    d7 = paramArrayOfDouble1[(j + 2)] - paramArrayOfDouble1[(paramInt2 + 2)];
    d5 = paramArrayOfDouble1[(j + 3)] - paramArrayOfDouble1[(paramInt2 + 3)];
    d11 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(i + 2)];
    d12 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(i + 3)];
    d6 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(i + 2)];
    d8 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(i + 3)];
    paramArrayOfDouble1[(j + 2)] = (d9 + d11);
    paramArrayOfDouble1[(j + 3)] = (d10 + d12);
    paramArrayOfDouble1[(paramInt1 + 2)] = (d9 - d11);
    paramArrayOfDouble1[(paramInt1 + 3)] = (d10 - d12);
    d9 = d7 - d8;
    d10 = d5 + d6;
    paramArrayOfDouble1[(paramInt2 + 2)] = (d3 * d9 - d4 * d10);
    paramArrayOfDouble1[(paramInt2 + 3)] = (d3 * d10 + d4 * d9);
    d3 = d7 + d8;
    d4 = d5 - d6;
    paramArrayOfDouble1[(i + 2)] = (d1 * d3 + d2 * d4);
    paramArrayOfDouble1[(i + 3)] = (d1 * d4 - d2 * d3);
  }
  
  private void a(int paramInt1, double[] paramArrayOfDouble1, int[] paramArrayOfInt, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i;
    if (paramInt1 > 32)
    {
      i = paramInt1 >> 2;
      a(paramInt1, paramArrayOfDouble1, paramArrayOfDouble2, paramInt3 - i);
      if (paramInt1 > 512)
      {
        a(i, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        b(i, paramArrayOfDouble1, i, paramInt3, paramArrayOfDouble2);
        a(i, paramArrayOfDouble1, i * 2, paramInt3, paramArrayOfDouble2);
        a(i, paramArrayOfDouble1, i * 3, paramInt3, paramArrayOfDouble2);
        a(paramInt1, paramArrayOfInt, paramInt2, paramArrayOfDouble1);
      }
    }
    do
    {
      return;
      if (i > 32)
      {
        c(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        break;
      }
      e(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
      break;
      if (paramInt1 > 8)
      {
        if (paramInt1 == 32)
        {
          a(paramArrayOfDouble1, 0, paramArrayOfDouble2, paramInt3 - 8);
          a(paramArrayOfDouble1);
          return;
        }
        c(paramArrayOfDouble1, 0, paramArrayOfDouble2, 0);
        c(paramArrayOfDouble1);
        return;
      }
      if (paramInt1 == 8)
      {
        e(paramArrayOfDouble1);
        return;
      }
    } while (paramInt1 != 4);
    g(paramArrayOfDouble1);
  }
  
  private final void a(int paramInt1, int[] paramArrayOfInt, int paramInt2, double[] paramArrayOfDouble)
  {
    paramArrayOfInt[(paramInt2 + 0)] = 0;
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 << 3 < i)
    {
      j = i >> 1;
      i = 0;
      while (i < paramInt1)
      {
        paramArrayOfInt[(paramInt2 + paramInt1 + i)] = (paramArrayOfInt[(paramInt2 + i)] + j);
        i += 1;
      }
      paramInt1 <<= 1;
      i = j;
    }
    int k = paramInt1 * 2;
    int n;
    int m;
    double d1;
    double d2;
    double d3;
    double d4;
    if (paramInt1 << 3 == i)
    {
      i = 0;
      while (i < paramInt1)
      {
        j = 0;
        while (j < i)
        {
          n = j * 2 + paramArrayOfInt[(paramInt2 + i)];
          m = i * 2 + paramArrayOfInt[(paramInt2 + j)];
          d1 = paramArrayOfDouble[n];
          d2 = paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          n += k;
          m += k * 2;
          d1 = paramArrayOfDouble[n];
          d2 = paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          n += k;
          m -= k;
          d1 = paramArrayOfDouble[n];
          d2 = paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          n += k;
          m += k * 2;
          d1 = paramArrayOfDouble[n];
          d2 = paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          j += 1;
        }
        j = i * 2 + k + paramArrayOfInt[(paramInt2 + i)];
        m = j + k;
        d1 = paramArrayOfDouble[j];
        d2 = paramArrayOfDouble[(j + 1)];
        d3 = paramArrayOfDouble[m];
        d4 = paramArrayOfDouble[(m + 1)];
        paramArrayOfDouble[j] = d3;
        paramArrayOfDouble[(j + 1)] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[(m + 1)] = d2;
        i += 1;
      }
    }
    i = 1;
    while (i < paramInt1)
    {
      j = 0;
      while (j < i)
      {
        n = j * 2 + paramArrayOfInt[(paramInt2 + i)];
        m = i * 2 + paramArrayOfInt[(paramInt2 + j)];
        d1 = paramArrayOfDouble[n];
        d2 = paramArrayOfDouble[(n + 1)];
        d3 = paramArrayOfDouble[m];
        d4 = paramArrayOfDouble[(m + 1)];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[(n + 1)] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[(m + 1)] = d2;
        n += k;
        m += k;
        d1 = paramArrayOfDouble[n];
        d2 = paramArrayOfDouble[(n + 1)];
        d3 = paramArrayOfDouble[m];
        d4 = paramArrayOfDouble[(m + 1)];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[(n + 1)] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[(m + 1)] = d2;
        j += 1;
      }
      i += 1;
    }
  }
  
  private void a(int paramInt, int[] paramArrayOfInt, double[] paramArrayOfDouble)
  {
    paramArrayOfInt[0] = paramInt;
    paramArrayOfInt[1] = 1;
    if (paramInt > 2)
    {
      int i = paramInt >> 1;
      double d2 = 0.7853981633974483D / i;
      double d1 = Math.cos(i * d2);
      paramArrayOfDouble[0] = 1.0D;
      paramArrayOfDouble[1] = d1;
      if (i >= 4)
      {
        paramArrayOfDouble[2] = (0.5D / Math.cos(2.0D * d2));
        paramArrayOfDouble[3] = (0.5D / Math.cos(6.0D * d2));
      }
      paramInt = 4;
      while (paramInt < i)
      {
        paramArrayOfDouble[paramInt] = Math.cos(paramInt * d2);
        paramArrayOfDouble[(paramInt + 1)] = Math.sin(paramInt * d2);
        paramArrayOfDouble[(paramInt + 2)] = Math.cos(3.0D * d2 * paramInt);
        paramArrayOfDouble[(paramInt + 3)] = Math.sin(3.0D * d2 * paramInt);
        paramInt += 4;
      }
      paramInt = 0;
      while (i > 2)
      {
        int j = paramInt + i;
        int k = i >> 1;
        paramArrayOfDouble[j] = 1.0D;
        paramArrayOfDouble[(j + 1)] = d1;
        double d3;
        if (k >= 4)
        {
          d2 = paramArrayOfDouble[(paramInt + 4)];
          d3 = paramArrayOfDouble[(paramInt + 6)];
          paramArrayOfDouble[(j + 2)] = (0.5D / d2);
          paramArrayOfDouble[(j + 3)] = (0.5D / d3);
        }
        i = 4;
        while (i < k)
        {
          d2 = paramArrayOfDouble[(i * 2 + paramInt)];
          d3 = paramArrayOfDouble[(i * 2 + paramInt + 1)];
          double d4 = paramArrayOfDouble[(i * 2 + paramInt + 2)];
          double d5 = paramArrayOfDouble[(i * 2 + paramInt + 3)];
          paramArrayOfDouble[(j + i)] = d2;
          paramArrayOfDouble[(j + i + 1)] = d3;
          paramArrayOfDouble[(j + i + 2)] = d4;
          paramArrayOfDouble[(j + i + 3)] = d5;
          i += 4;
        }
        paramInt = j;
        i = k;
      }
    }
  }
  
  private void a(int paramInt1, int[] paramArrayOfInt, double[] paramArrayOfDouble, int paramInt2)
  {
    int i = 1;
    paramArrayOfInt[1] = paramInt1;
    if (paramInt1 > 1)
    {
      int j = paramInt1 >> 1;
      double d = 0.7853981633974483D / j;
      paramArrayOfDouble[(paramInt2 + 0)] = Math.cos(j * d);
      paramArrayOfDouble[(paramInt2 + j)] = (paramArrayOfDouble[(paramInt2 + 0)] * 0.5D);
      while (i < j)
      {
        paramArrayOfDouble[(paramInt2 + i)] = (Math.cos(i * d) * 0.5D);
        paramArrayOfDouble[(paramInt2 + paramInt1 - i)] = (Math.sin(i * d) * 0.5D);
        i += 1;
      }
    }
  }
  
  private void a(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[8];
    double d8 = paramArrayOfDouble[9];
    double d9 = paramArrayOfDouble[10];
    double d10 = paramArrayOfDouble[11];
    double d11 = paramArrayOfDouble[14];
    double d12 = paramArrayOfDouble[15];
    double d13 = paramArrayOfDouble[16];
    double d14 = paramArrayOfDouble[17];
    double d15 = paramArrayOfDouble[20];
    double d16 = paramArrayOfDouble[21];
    double d17 = paramArrayOfDouble[22];
    double d18 = paramArrayOfDouble[23];
    double d19 = paramArrayOfDouble[24];
    double d20 = paramArrayOfDouble[25];
    double d21 = paramArrayOfDouble[26];
    double d22 = paramArrayOfDouble[27];
    double d23 = paramArrayOfDouble[28];
    double d24 = paramArrayOfDouble[29];
    paramArrayOfDouble[2] = d13;
    paramArrayOfDouble[3] = d14;
    paramArrayOfDouble[4] = d7;
    paramArrayOfDouble[5] = d8;
    paramArrayOfDouble[6] = d19;
    paramArrayOfDouble[7] = d20;
    paramArrayOfDouble[8] = d3;
    paramArrayOfDouble[9] = d4;
    paramArrayOfDouble[10] = d15;
    paramArrayOfDouble[11] = d16;
    paramArrayOfDouble[14] = d23;
    paramArrayOfDouble[15] = d24;
    paramArrayOfDouble[16] = d1;
    paramArrayOfDouble[17] = d2;
    paramArrayOfDouble[20] = d9;
    paramArrayOfDouble[21] = d10;
    paramArrayOfDouble[22] = d21;
    paramArrayOfDouble[23] = d22;
    paramArrayOfDouble[24] = d5;
    paramArrayOfDouble[25] = d6;
    paramArrayOfDouble[26] = d17;
    paramArrayOfDouble[27] = d18;
    paramArrayOfDouble[28] = d11;
    paramArrayOfDouble[29] = d12;
  }
  
  private void a(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d6 = paramArrayOfDouble2[(paramInt2 + 1)];
    double d20 = paramArrayOfDouble2[(paramInt2 + 2)] * d6;
    double d21 = paramArrayOfDouble2[(paramInt2 + 2)] + d20;
    double d5 = paramArrayOfDouble1[(paramInt1 + 0)] + paramArrayOfDouble1[(paramInt1 + 16)];
    double d7 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(paramInt1 + 17)];
    double d8 = paramArrayOfDouble1[(paramInt1 + 0)] - paramArrayOfDouble1[(paramInt1 + 16)];
    double d3 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(paramInt1 + 17)];
    double d11 = paramArrayOfDouble1[(paramInt1 + 8)] + paramArrayOfDouble1[(paramInt1 + 24)];
    double d10 = paramArrayOfDouble1[(paramInt1 + 9)] + paramArrayOfDouble1[(paramInt1 + 25)];
    double d4 = paramArrayOfDouble1[(paramInt1 + 8)] - paramArrayOfDouble1[(paramInt1 + 24)];
    double d9 = paramArrayOfDouble1[(paramInt1 + 9)] - paramArrayOfDouble1[(paramInt1 + 25)];
    double d2 = d5 + d11;
    double d1 = d7 + d10;
    d5 -= d11;
    d7 -= d10;
    double d13 = d8 - d9;
    double d12 = d3 + d4;
    double d22 = d8 + d9;
    double d23 = d3 - d4;
    d9 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(paramInt1 + 18)];
    d11 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(paramInt1 + 19)];
    double d14 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(paramInt1 + 18)];
    d8 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(paramInt1 + 19)];
    double d17 = paramArrayOfDouble1[(paramInt1 + 10)] + paramArrayOfDouble1[(paramInt1 + 26)];
    double d16 = paramArrayOfDouble1[(paramInt1 + 11)] + paramArrayOfDouble1[(paramInt1 + 27)];
    d10 = paramArrayOfDouble1[(paramInt1 + 10)] - paramArrayOfDouble1[(paramInt1 + 26)];
    double d15 = paramArrayOfDouble1[(paramInt1 + 11)] - paramArrayOfDouble1[(paramInt1 + 27)];
    d4 = d9 + d17;
    d3 = d11 + d16;
    d9 -= d17;
    d11 -= d16;
    d17 = d14 - d15;
    double d18 = d8 + d10;
    d16 = d21 * d17 - d20 * d18;
    double d19 = d17 * d20 + d18 * d21;
    d14 += d15;
    d8 -= d10;
    double d24 = d20 * d14 - d21 * d8;
    double d25 = d14 * d21 + d8 * d20;
    d14 = paramArrayOfDouble1[(paramInt1 + 4)] + paramArrayOfDouble1[(paramInt1 + 20)];
    d17 = paramArrayOfDouble1[(paramInt1 + 5)] + paramArrayOfDouble1[(paramInt1 + 21)];
    double d26 = paramArrayOfDouble1[(paramInt1 + 4)] - paramArrayOfDouble1[(paramInt1 + 20)];
    d15 = paramArrayOfDouble1[(paramInt1 + 5)] - paramArrayOfDouble1[(paramInt1 + 21)];
    double d28 = paramArrayOfDouble1[(paramInt1 + 12)] + paramArrayOfDouble1[(paramInt1 + 28)];
    double d27 = paramArrayOfDouble1[(paramInt1 + 13)] + paramArrayOfDouble1[(paramInt1 + 29)];
    d18 = paramArrayOfDouble1[(paramInt1 + 12)] - paramArrayOfDouble1[(paramInt1 + 28)];
    double d29 = paramArrayOfDouble1[(paramInt1 + 13)] - paramArrayOfDouble1[(paramInt1 + 29)];
    d10 = d14 + d28;
    d8 = d17 + d27;
    d14 -= d28;
    d17 -= d27;
    d28 = d26 - d29;
    double d30 = d15 + d18;
    d27 = (d28 - d30) * d6;
    d28 = (d28 + d30) * d6;
    d26 += d29;
    d15 -= d18;
    double d32 = (d26 + d15) * d6;
    double d33 = (d15 - d26) * d6;
    d26 = paramArrayOfDouble1[(paramInt1 + 6)] + paramArrayOfDouble1[(paramInt1 + 22)];
    d29 = paramArrayOfDouble1[(paramInt1 + 7)] + paramArrayOfDouble1[(paramInt1 + 23)];
    double d36 = paramArrayOfDouble1[(paramInt1 + 6)] - paramArrayOfDouble1[(paramInt1 + 22)];
    double d34 = paramArrayOfDouble1[(paramInt1 + 7)] - paramArrayOfDouble1[(paramInt1 + 23)];
    double d31 = paramArrayOfDouble1[(paramInt1 + 14)] + paramArrayOfDouble1[(paramInt1 + 30)];
    d30 = paramArrayOfDouble1[(paramInt1 + 15)] + paramArrayOfDouble1[(paramInt1 + 31)];
    double d35 = paramArrayOfDouble1[(paramInt1 + 14)] - paramArrayOfDouble1[(paramInt1 + 30)];
    double d37 = paramArrayOfDouble1[(paramInt1 + 15)] - paramArrayOfDouble1[(paramInt1 + 31)];
    d18 = d26 + d31;
    d15 = d29 + d30;
    d26 -= d31;
    d29 -= d30;
    d31 = d36 - d37;
    double d38 = d34 + d35;
    d30 = d20 * d31 - d21 * d38;
    d31 = d31 * d21 + d38 * d20;
    d36 += d37;
    d35 = d34 - d35;
    d34 = d21 * d36 - d20 * d35;
    d35 = d20 * d36 + d21 * d35;
    d20 = d22 - d32;
    d21 = d23 - d33;
    d22 += d32;
    d23 += d33;
    d32 = d24 - d34;
    d33 = d25 - d35;
    d24 += d34;
    d25 = d35 + d25;
    paramArrayOfDouble1[(paramInt1 + 24)] = (d20 + d32);
    paramArrayOfDouble1[(paramInt1 + 25)] = (d21 + d33);
    paramArrayOfDouble1[(paramInt1 + 26)] = (d20 - d32);
    paramArrayOfDouble1[(paramInt1 + 27)] = (d21 - d33);
    paramArrayOfDouble1[(paramInt1 + 28)] = (d22 - d25);
    paramArrayOfDouble1[(paramInt1 + 29)] = (d23 + d24);
    paramArrayOfDouble1[(paramInt1 + 30)] = (d25 + d22);
    paramArrayOfDouble1[(paramInt1 + 31)] = (d23 - d24);
    d20 = d13 + d27;
    d21 = d12 + d28;
    d13 -= d27;
    d12 -= d28;
    d22 = d16 + d30;
    d23 = d19 + d31;
    d16 -= d30;
    d19 -= d31;
    paramArrayOfDouble1[(paramInt1 + 16)] = (d20 + d22);
    paramArrayOfDouble1[(paramInt1 + 17)] = (d21 + d23);
    paramArrayOfDouble1[(paramInt1 + 18)] = (d20 - d22);
    paramArrayOfDouble1[(paramInt1 + 19)] = (d21 - d23);
    paramArrayOfDouble1[(paramInt1 + 20)] = (d13 - d19);
    paramArrayOfDouble1[(paramInt1 + 21)] = (d12 + d16);
    paramArrayOfDouble1[(paramInt1 + 22)] = (d13 + d19);
    paramArrayOfDouble1[(paramInt1 + 23)] = (d12 - d16);
    d13 = d9 - d29;
    d16 = d11 + d26;
    d12 = (d13 - d16) * d6;
    d13 = (d13 + d16) * d6;
    d16 = d9 + d29;
    d11 -= d26;
    d9 = (d16 - d11) * d6;
    d6 *= (d16 + d11);
    d11 = d5 - d17;
    d16 = d7 + d14;
    d5 += d17;
    d7 -= d14;
    paramArrayOfDouble1[(paramInt1 + 8)] = (d11 + d12);
    paramArrayOfDouble1[(paramInt1 + 9)] = (d16 + d13);
    paramArrayOfDouble1[(paramInt1 + 10)] = (d11 - d12);
    paramArrayOfDouble1[(paramInt1 + 11)] = (d16 - d13);
    paramArrayOfDouble1[(paramInt1 + 12)] = (d5 - d6);
    paramArrayOfDouble1[(paramInt1 + 13)] = (d7 + d9);
    paramArrayOfDouble1[(paramInt1 + 14)] = (d6 + d5);
    paramArrayOfDouble1[(paramInt1 + 15)] = (d7 - d9);
    d5 = d2 + d10;
    d6 = d1 + d8;
    d2 -= d10;
    d1 -= d8;
    d7 = d4 + d18;
    d8 = d3 + d15;
    d4 -= d18;
    d3 -= d15;
    paramArrayOfDouble1[(paramInt1 + 0)] = (d5 + d7);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d6 + d8);
    paramArrayOfDouble1[(paramInt1 + 2)] = (d5 - d7);
    paramArrayOfDouble1[(paramInt1 + 3)] = (d6 - d8);
    paramArrayOfDouble1[(paramInt1 + 4)] = (d2 - d3);
    paramArrayOfDouble1[(paramInt1 + 5)] = (d1 + d4);
    paramArrayOfDouble1[(paramInt1 + 6)] = (d2 + d3);
    paramArrayOfDouble1[(paramInt1 + 7)] = (d1 - d4);
  }
  
  private void b(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i = paramInt1 >> 2;
    b(paramInt1, paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - paramInt1);
    if (paramInt1 > 512)
    {
      a(i, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
      b(i, paramArrayOfDouble1, paramInt2 + i, paramInt3, paramArrayOfDouble2);
      a(i, paramArrayOfDouble1, paramInt2 + i * 2, paramInt3, paramArrayOfDouble2);
      b(i, paramArrayOfDouble1, paramInt2 + i * 3, paramInt3, paramArrayOfDouble2);
      return;
    }
    d(paramInt1, paramArrayOfDouble1, paramInt2, paramInt3, paramArrayOfDouble2);
  }
  
  private final void b(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 3;
    int m = k * 2;
    double d3 = paramArrayOfDouble2[(paramInt3 + 1)];
    paramInt1 = m + m;
    int i = paramInt1 + m;
    double d6 = paramArrayOfDouble1[(paramInt2 + 0)] - paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)];
    double d7 = paramArrayOfDouble1[(paramInt2 + 1)] + paramArrayOfDouble1[(paramInt2 + paramInt1)];
    double d1 = paramArrayOfDouble1[(paramInt2 + 0)] + paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)];
    double d2 = paramArrayOfDouble1[(paramInt2 + 1)] - paramArrayOfDouble1[(paramInt2 + paramInt1)];
    double d9 = paramArrayOfDouble1[(paramInt2 + m)] - paramArrayOfDouble1[(paramInt2 + i + 1)];
    double d10 = paramArrayOfDouble1[(paramInt2 + m + 1)] + paramArrayOfDouble1[(paramInt2 + i)];
    double d4 = paramArrayOfDouble1[(paramInt2 + m)] + paramArrayOfDouble1[(paramInt2 + i + 1)];
    double d5 = paramArrayOfDouble1[(paramInt2 + m + 1)] - paramArrayOfDouble1[(paramInt2 + i)];
    double d8 = (d9 - d10) * d3;
    d9 = (d9 + d10) * d3;
    paramArrayOfDouble1[(paramInt2 + 0)] = (d6 + d8);
    paramArrayOfDouble1[(paramInt2 + 1)] = (d7 + d9);
    paramArrayOfDouble1[(paramInt2 + m)] = (d6 - d8);
    paramArrayOfDouble1[(paramInt2 + m + 1)] = (d7 - d9);
    d6 = (d4 - d5) * d3;
    d3 *= (d5 + d4);
    paramArrayOfDouble1[(paramInt2 + paramInt1)] = (d1 - d3);
    paramArrayOfDouble1[(paramInt1 + paramInt2 + 1)] = (d2 + d6);
    paramArrayOfDouble1[(paramInt2 + i)] = (d3 + d1);
    paramArrayOfDouble1[(paramInt2 + i + 1)] = (d2 - d6);
    int j = 0;
    i = m * 2;
    paramInt1 = 2;
    while (paramInt1 < k)
    {
      j += 4;
      d5 = paramArrayOfDouble2[(paramInt3 + j)];
      d6 = paramArrayOfDouble2[(paramInt3 + j + 1)];
      d1 = paramArrayOfDouble2[(paramInt3 + j + 2)];
      d2 = -paramArrayOfDouble2[(paramInt3 + j + 3)];
      i -= 4;
      d7 = paramArrayOfDouble2[(paramInt3 + i)];
      d8 = paramArrayOfDouble2[(paramInt3 + i + 1)];
      d3 = paramArrayOfDouble2[(paramInt3 + i + 2)];
      d4 = -paramArrayOfDouble2[(paramInt3 + i + 3)];
      int n = paramInt1 + m;
      int i1 = n + m;
      int i2 = i1 + m;
      double d16 = paramArrayOfDouble1[(paramInt2 + paramInt1)] - paramArrayOfDouble1[(paramInt2 + i1 + 1)];
      double d17 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] + paramArrayOfDouble1[(paramInt2 + i1)];
      d11 = paramArrayOfDouble1[(paramInt2 + paramInt1)] + paramArrayOfDouble1[(paramInt2 + i1 + 1)];
      double d12 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] - paramArrayOfDouble1[(paramInt2 + i1)];
      double d14 = paramArrayOfDouble1[(paramInt2 + n)] - paramArrayOfDouble1[(paramInt2 + i2 + 1)];
      double d15 = paramArrayOfDouble1[(paramInt2 + n + 1)] + paramArrayOfDouble1[(paramInt2 + i2)];
      d9 = paramArrayOfDouble1[(paramInt2 + n)] + paramArrayOfDouble1[(paramInt2 + i2 + 1)];
      d10 = paramArrayOfDouble1[(paramInt2 + n + 1)] - paramArrayOfDouble1[(paramInt2 + i2)];
      double d13 = d5 * d16 - d6 * d17;
      d16 = d16 * d6 + d17 * d5;
      d17 = d8 * d14 - d7 * d15;
      d14 = d14 * d7 + d15 * d8;
      paramArrayOfDouble1[(paramInt2 + paramInt1)] = (d13 + d17);
      paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] = (d16 + d14);
      paramArrayOfDouble1[(paramInt2 + n)] = (d13 - d17);
      paramArrayOfDouble1[(n + paramInt2 + 1)] = (d16 - d14);
      d13 = d1 * d11 + d2 * d12;
      d11 = d1 * d12 - d11 * d2;
      d12 = d4 * d9 + d3 * d10;
      d9 = d4 * d10 - d3 * d9;
      paramArrayOfDouble1[(paramInt2 + i1)] = (d13 + d12);
      paramArrayOfDouble1[(paramInt2 + i1 + 1)] = (d11 + d9);
      paramArrayOfDouble1[(paramInt2 + i2)] = (d13 - d12);
      paramArrayOfDouble1[(paramInt2 + i2 + 1)] = (d11 - d9);
      n = m - paramInt1;
      i1 = n + m;
      i2 = i1 + m;
      int i3 = i2 + m;
      d16 = paramArrayOfDouble1[(paramInt2 + n)] - paramArrayOfDouble1[(paramInt2 + i2 + 1)];
      d17 = paramArrayOfDouble1[(paramInt2 + n + 1)] + paramArrayOfDouble1[(paramInt2 + i2)];
      d11 = paramArrayOfDouble1[(paramInt2 + n)] + paramArrayOfDouble1[(paramInt2 + i2 + 1)];
      d12 = paramArrayOfDouble1[(paramInt2 + n + 1)] - paramArrayOfDouble1[(paramInt2 + i2)];
      d14 = paramArrayOfDouble1[(paramInt2 + i1)] - paramArrayOfDouble1[(paramInt2 + i3 + 1)];
      d15 = paramArrayOfDouble1[(paramInt2 + i1 + 1)] + paramArrayOfDouble1[(paramInt2 + i3)];
      d9 = paramArrayOfDouble1[(paramInt2 + i1)] + paramArrayOfDouble1[(paramInt2 + i3 + 1)];
      d10 = paramArrayOfDouble1[(paramInt2 + i1 + 1)] - paramArrayOfDouble1[(paramInt2 + i3)];
      d13 = d7 * d16 - d8 * d17;
      d7 = d7 * d17 + d8 * d16;
      d8 = d6 * d14 - d5 * d15;
      d5 = d5 * d14 + d6 * d15;
      paramArrayOfDouble1[(paramInt2 + n)] = (d13 + d8);
      paramArrayOfDouble1[(n + paramInt2 + 1)] = (d7 + d5);
      paramArrayOfDouble1[(paramInt2 + i1)] = (d13 - d8);
      paramArrayOfDouble1[(paramInt2 + i1 + 1)] = (d7 - d5);
      d5 = d3 * d11 + d4 * d12;
      d3 = d3 * d12 - d4 * d11;
      d4 = d2 * d9 + d1 * d10;
      d1 = d2 * d10 - d1 * d9;
      paramArrayOfDouble1[(paramInt2 + i2)] = (d5 + d4);
      paramArrayOfDouble1[(paramInt2 + i2 + 1)] = (d3 + d1);
      paramArrayOfDouble1[(paramInt2 + i3)] = (d5 - d4);
      paramArrayOfDouble1[(paramInt2 + i3 + 1)] = (d3 - d1);
      paramInt1 += 2;
    }
    d1 = paramArrayOfDouble2[(paramInt3 + m)];
    d2 = paramArrayOfDouble2[(paramInt3 + m + 1)];
    paramInt1 = k + m;
    paramInt3 = paramInt1 + m;
    i = m + paramInt3;
    d10 = paramArrayOfDouble1[(paramInt2 + k)] - paramArrayOfDouble1[(paramInt2 + paramInt3 + 1)];
    double d11 = paramArrayOfDouble1[(paramInt2 + k + 1)] + paramArrayOfDouble1[(paramInt2 + paramInt3)];
    d5 = paramArrayOfDouble1[(paramInt2 + k)] + paramArrayOfDouble1[(paramInt2 + paramInt3 + 1)];
    d6 = paramArrayOfDouble1[(paramInt2 + k + 1)] - paramArrayOfDouble1[(paramInt2 + paramInt3)];
    d8 = paramArrayOfDouble1[(paramInt2 + paramInt1)] - paramArrayOfDouble1[(paramInt2 + i + 1)];
    d9 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] + paramArrayOfDouble1[(paramInt2 + i)];
    d3 = paramArrayOfDouble1[(paramInt2 + paramInt1)] + paramArrayOfDouble1[(paramInt2 + i + 1)];
    d4 = paramArrayOfDouble1[(paramInt2 + paramInt1 + 1)] - paramArrayOfDouble1[(paramInt2 + i)];
    d7 = d1 * d10 - d2 * d11;
    d10 = d10 * d2 + d11 * d1;
    d11 = d2 * d8 - d1 * d9;
    d8 = d8 * d1 + d9 * d2;
    paramArrayOfDouble1[(paramInt2 + k)] = (d7 + d11);
    paramArrayOfDouble1[(k + paramInt2 + 1)] = (d10 + d8);
    paramArrayOfDouble1[(paramInt2 + paramInt1)] = (d7 - d11);
    paramArrayOfDouble1[(paramInt1 + paramInt2 + 1)] = (d10 - d8);
    d7 = d2 * d5 - d1 * d6;
    d5 = d2 * d6 + d1 * d5;
    d6 = d1 * d3 - d2 * d4;
    d1 = d1 * d4 + d2 * d3;
    paramArrayOfDouble1[(paramInt2 + paramInt3)] = (d7 - d6);
    paramArrayOfDouble1[(paramInt3 + paramInt2 + 1)] = (d5 - d1);
    paramArrayOfDouble1[(paramInt2 + i)] = (d7 + d6);
    paramArrayOfDouble1[(paramInt2 + i + 1)] = (d1 + d5);
  }
  
  private final void b(int paramInt1, double[] paramArrayOfDouble1, double[] paramArrayOfDouble2, int paramInt2)
  {
    int j = paramInt1 >> 3;
    int k = j * 2;
    paramInt1 = k + k;
    int i = paramInt1 + k;
    double d1 = paramArrayOfDouble1[0] + paramArrayOfDouble1[paramInt1];
    double d2 = -paramArrayOfDouble1[1] - paramArrayOfDouble1[(paramInt1 + 1)];
    double d3 = paramArrayOfDouble1[0] - paramArrayOfDouble1[paramInt1];
    double d4 = -paramArrayOfDouble1[1] + paramArrayOfDouble1[(paramInt1 + 1)];
    double d5 = paramArrayOfDouble1[k] + paramArrayOfDouble1[i];
    double d6 = paramArrayOfDouble1[(k + 1)] + paramArrayOfDouble1[(i + 1)];
    double d7 = paramArrayOfDouble1[k] - paramArrayOfDouble1[i];
    double d8 = paramArrayOfDouble1[(k + 1)] - paramArrayOfDouble1[(i + 1)];
    paramArrayOfDouble1[0] = (d1 + d5);
    paramArrayOfDouble1[1] = (d2 - d6);
    paramArrayOfDouble1[k] = (d1 - d5);
    paramArrayOfDouble1[(k + 1)] = (d2 + d6);
    paramArrayOfDouble1[paramInt1] = (d3 + d8);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d4 + d7);
    paramArrayOfDouble1[i] = (d3 - d8);
    paramArrayOfDouble1[(i + 1)] = (d4 - d7);
    d5 = paramArrayOfDouble2[(paramInt2 + 1)];
    d7 = paramArrayOfDouble2[(paramInt2 + 2)];
    d6 = paramArrayOfDouble2[(paramInt2 + 3)];
    d4 = 1.0D;
    d3 = 0.0D;
    d2 = 1.0D;
    d1 = 0.0D;
    i = 0;
    paramInt1 = 2;
    while (paramInt1 < j - 2)
    {
      i += 4;
      d10 = d7 * (d4 + paramArrayOfDouble2[(paramInt2 + i)]);
      d11 = d7 * (d3 + paramArrayOfDouble2[(paramInt2 + i + 1)]);
      d8 = d6 * (d2 + paramArrayOfDouble2[(paramInt2 + i + 2)]);
      d9 = d6 * (d1 - paramArrayOfDouble2[(paramInt2 + i + 3)]);
      d4 = paramArrayOfDouble2[(paramInt2 + i)];
      d3 = paramArrayOfDouble2[(paramInt2 + i + 1)];
      d2 = paramArrayOfDouble2[(paramInt2 + i + 2)];
      d1 = -paramArrayOfDouble2[(paramInt2 + i + 3)];
      int m = paramInt1 + k;
      int n = m + k;
      int i1 = n + k;
      double d20 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[n];
      double d21 = -paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(n + 1)];
      double d18 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[n];
      double d16 = -paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(n + 1)];
      double d22 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(n + 2)];
      double d23 = -paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(n + 3)];
      double d14 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(n + 2)];
      d12 = -paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(n + 3)];
      double d24 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      double d25 = paramArrayOfDouble1[(m + 1)] + paramArrayOfDouble1[(i1 + 1)];
      double d17 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      double d19 = paramArrayOfDouble1[(m + 1)] - paramArrayOfDouble1[(i1 + 1)];
      double d26 = paramArrayOfDouble1[(m + 2)] + paramArrayOfDouble1[(i1 + 2)];
      double d27 = paramArrayOfDouble1[(m + 3)] + paramArrayOfDouble1[(i1 + 3)];
      d13 = paramArrayOfDouble1[(m + 2)] - paramArrayOfDouble1[(i1 + 2)];
      double d15 = paramArrayOfDouble1[(m + 3)] - paramArrayOfDouble1[(i1 + 3)];
      paramArrayOfDouble1[paramInt1] = (d20 + d24);
      paramArrayOfDouble1[(paramInt1 + 1)] = (d21 - d25);
      paramArrayOfDouble1[(paramInt1 + 2)] = (d22 + d26);
      paramArrayOfDouble1[(paramInt1 + 3)] = (d23 - d27);
      paramArrayOfDouble1[m] = (d20 - d24);
      paramArrayOfDouble1[(m + 1)] = (d21 + d25);
      paramArrayOfDouble1[(m + 2)] = (d22 - d26);
      paramArrayOfDouble1[(m + 3)] = (d23 + d27);
      d20 = d18 + d19;
      d21 = d16 + d17;
      paramArrayOfDouble1[n] = (d10 * d20 - d11 * d21);
      paramArrayOfDouble1[(n + 1)] = (d20 * d11 + d21 * d10);
      d20 = d14 + d15;
      d21 = d12 + d13;
      paramArrayOfDouble1[(n + 2)] = (d4 * d20 - d3 * d21);
      paramArrayOfDouble1[(n + 3)] = (d20 * d3 + d21 * d4);
      d18 -= d19;
      d16 -= d17;
      paramArrayOfDouble1[i1] = (d8 * d18 + d9 * d16);
      paramArrayOfDouble1[(i1 + 1)] = (d16 * d8 - d18 * d9);
      d14 -= d15;
      d12 -= d13;
      paramArrayOfDouble1[(i1 + 2)] = (d2 * d14 + d1 * d12);
      paramArrayOfDouble1[(i1 + 3)] = (d12 * d2 - d14 * d1);
      m = k - paramInt1;
      n = m + k;
      i1 = n + k;
      int i2 = i1 + k;
      d20 = paramArrayOfDouble1[m] + paramArrayOfDouble1[i1];
      d21 = -paramArrayOfDouble1[(m + 1)] - paramArrayOfDouble1[(i1 + 1)];
      d18 = paramArrayOfDouble1[m] - paramArrayOfDouble1[i1];
      d16 = -paramArrayOfDouble1[(m + 1)] + paramArrayOfDouble1[(i1 + 1)];
      d22 = paramArrayOfDouble1[(m - 2)] + paramArrayOfDouble1[(i1 - 2)];
      d23 = -paramArrayOfDouble1[(m - 1)] - paramArrayOfDouble1[(i1 - 1)];
      d14 = paramArrayOfDouble1[(m - 2)] - paramArrayOfDouble1[(i1 - 2)];
      d12 = -paramArrayOfDouble1[(m - 1)] + paramArrayOfDouble1[(i1 - 1)];
      d24 = paramArrayOfDouble1[n] + paramArrayOfDouble1[i2];
      d25 = paramArrayOfDouble1[(n + 1)] + paramArrayOfDouble1[(i2 + 1)];
      d17 = paramArrayOfDouble1[n] - paramArrayOfDouble1[i2];
      d19 = paramArrayOfDouble1[(n + 1)] - paramArrayOfDouble1[(i2 + 1)];
      d26 = paramArrayOfDouble1[(n - 2)] + paramArrayOfDouble1[(i2 - 2)];
      d27 = paramArrayOfDouble1[(n - 1)] + paramArrayOfDouble1[(i2 - 1)];
      d13 = paramArrayOfDouble1[(n - 2)] - paramArrayOfDouble1[(i2 - 2)];
      d15 = paramArrayOfDouble1[(n - 1)] - paramArrayOfDouble1[(i2 - 1)];
      paramArrayOfDouble1[m] = (d20 + d24);
      paramArrayOfDouble1[(m + 1)] = (d21 - d25);
      paramArrayOfDouble1[(m - 2)] = (d22 + d26);
      paramArrayOfDouble1[(m - 1)] = (d23 - d27);
      paramArrayOfDouble1[n] = (d20 - d24);
      paramArrayOfDouble1[(n + 1)] = (d21 + d25);
      paramArrayOfDouble1[(n - 2)] = (d22 - d26);
      paramArrayOfDouble1[(n - 1)] = (d23 + d27);
      d20 = d18 + d19;
      d21 = d16 + d17;
      paramArrayOfDouble1[i1] = (d11 * d20 - d10 * d21);
      paramArrayOfDouble1[(i1 + 1)] = (d10 * d20 + d11 * d21);
      d10 = d14 + d15;
      d11 = d12 + d13;
      paramArrayOfDouble1[(i1 - 2)] = (d3 * d10 - d4 * d11);
      paramArrayOfDouble1[(i1 - 1)] = (d10 * d4 + d11 * d3);
      d10 = d18 - d19;
      d11 = d16 - d17;
      paramArrayOfDouble1[i2] = (d9 * d10 + d8 * d11);
      paramArrayOfDouble1[(i2 + 1)] = (d11 * d9 - d10 * d8);
      d8 = d14 - d15;
      d9 = d12 - d13;
      paramArrayOfDouble1[(i2 - 2)] = (d1 * d8 + d2 * d9);
      paramArrayOfDouble1[(i2 - 1)] = (d9 * d1 - d8 * d2);
      paramInt1 += 4;
    }
    d4 = (d4 + d5) * d7;
    d3 = (d3 + d5) * d7;
    d2 = (d2 - d5) * d6;
    d1 = (d1 - d5) * d6;
    paramInt1 = j + k;
    paramInt2 = paramInt1 + k;
    i = k + paramInt2;
    double d10 = paramArrayOfDouble1[(j - 2)] + paramArrayOfDouble1[(paramInt2 - 2)];
    double d11 = -paramArrayOfDouble1[(j - 1)] - paramArrayOfDouble1[(paramInt2 - 1)];
    d8 = paramArrayOfDouble1[(j - 2)] - paramArrayOfDouble1[(paramInt2 - 2)];
    d6 = -paramArrayOfDouble1[(j - 1)] + paramArrayOfDouble1[(paramInt2 - 1)];
    double d12 = paramArrayOfDouble1[(paramInt1 - 2)] + paramArrayOfDouble1[(i - 2)];
    double d13 = paramArrayOfDouble1[(paramInt1 - 1)] + paramArrayOfDouble1[(i - 1)];
    d7 = paramArrayOfDouble1[(paramInt1 - 2)] - paramArrayOfDouble1[(i - 2)];
    double d9 = paramArrayOfDouble1[(paramInt1 - 1)] - paramArrayOfDouble1[(i - 1)];
    paramArrayOfDouble1[(j - 2)] = (d10 + d12);
    paramArrayOfDouble1[(j - 1)] = (d11 - d13);
    paramArrayOfDouble1[(paramInt1 - 2)] = (d10 - d12);
    paramArrayOfDouble1[(paramInt1 - 1)] = (d11 + d13);
    d10 = d8 + d9;
    d11 = d6 + d7;
    paramArrayOfDouble1[(paramInt2 - 2)] = (d4 * d10 - d3 * d11);
    paramArrayOfDouble1[(paramInt2 - 1)] = (d10 * d3 + d11 * d4);
    d8 -= d9;
    d6 -= d7;
    paramArrayOfDouble1[(i - 2)] = (d2 * d8 + d1 * d6);
    paramArrayOfDouble1[(i - 1)] = (d6 * d2 - d8 * d1);
    d10 = paramArrayOfDouble1[j] + paramArrayOfDouble1[paramInt2];
    d11 = -paramArrayOfDouble1[(j + 1)] - paramArrayOfDouble1[(paramInt2 + 1)];
    d8 = paramArrayOfDouble1[j] - paramArrayOfDouble1[paramInt2];
    d6 = -paramArrayOfDouble1[(j + 1)] + paramArrayOfDouble1[(paramInt2 + 1)];
    d12 = paramArrayOfDouble1[paramInt1] + paramArrayOfDouble1[i];
    d13 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(i + 1)];
    d7 = paramArrayOfDouble1[paramInt1] - paramArrayOfDouble1[i];
    d9 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(i + 1)];
    paramArrayOfDouble1[j] = (d10 + d12);
    paramArrayOfDouble1[(j + 1)] = (d11 - d13);
    paramArrayOfDouble1[paramInt1] = (d10 - d12);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d11 + d13);
    d10 = d8 + d9;
    d11 = d6 + d7;
    paramArrayOfDouble1[paramInt2] = ((d10 - d11) * d5);
    paramArrayOfDouble1[(paramInt2 + 1)] = ((d10 + d11) * d5);
    d8 -= d9;
    d6 -= d7;
    paramArrayOfDouble1[i] = (-d5 * (d8 + d6));
    paramArrayOfDouble1[(i + 1)] = (-d5 * (d6 - d8));
    d9 = paramArrayOfDouble1[(j + 2)] + paramArrayOfDouble1[(paramInt2 + 2)];
    d10 = -paramArrayOfDouble1[(j + 3)] - paramArrayOfDouble1[(paramInt2 + 3)];
    d7 = paramArrayOfDouble1[(j + 2)] - paramArrayOfDouble1[(paramInt2 + 2)];
    d5 = -paramArrayOfDouble1[(j + 3)] + paramArrayOfDouble1[(paramInt2 + 3)];
    d11 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(i + 2)];
    d12 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(i + 3)];
    d6 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(i + 2)];
    d8 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(i + 3)];
    paramArrayOfDouble1[(j + 2)] = (d9 + d11);
    paramArrayOfDouble1[(j + 3)] = (d10 - d12);
    paramArrayOfDouble1[(paramInt1 + 2)] = (d9 - d11);
    paramArrayOfDouble1[(paramInt1 + 3)] = (d10 + d12);
    d9 = d7 + d8;
    d10 = d5 + d6;
    paramArrayOfDouble1[(paramInt2 + 2)] = (d3 * d9 - d4 * d10);
    paramArrayOfDouble1[(paramInt2 + 3)] = (d3 * d10 + d4 * d9);
    d3 = d7 - d8;
    d4 = d5 - d6;
    paramArrayOfDouble1[(i + 2)] = (d1 * d3 + d2 * d4);
    paramArrayOfDouble1[(i + 3)] = (d1 * d4 - d2 * d3);
  }
  
  private void b(int paramInt1, double[] paramArrayOfDouble1, int[] paramArrayOfInt, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i;
    if (paramInt1 > 32)
    {
      i = paramInt1 >> 2;
      b(paramInt1, paramArrayOfDouble1, paramArrayOfDouble2, paramInt3 - i);
      if (paramInt1 > 512)
      {
        a(i, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        b(i, paramArrayOfDouble1, i, paramInt3, paramArrayOfDouble2);
        a(i, paramArrayOfDouble1, i * 2, paramInt3, paramArrayOfDouble2);
        a(i, paramArrayOfDouble1, i * 3, paramInt3, paramArrayOfDouble2);
        b(paramInt1, paramArrayOfInt, paramInt2, paramArrayOfDouble1);
      }
    }
    do
    {
      return;
      if (i > 32)
      {
        c(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
        break;
      }
      e(paramInt1, paramArrayOfDouble1, 0, paramInt3, paramArrayOfDouble2);
      break;
      if (paramInt1 > 8)
      {
        if (paramInt1 == 32)
        {
          a(paramArrayOfDouble1, 0, paramArrayOfDouble2, paramInt3 - 8);
          b(paramArrayOfDouble1);
          return;
        }
        c(paramArrayOfDouble1, 0, paramArrayOfDouble2, 0);
        d(paramArrayOfDouble1);
        return;
      }
      if (paramInt1 == 8)
      {
        f(paramArrayOfDouble1);
        return;
      }
    } while (paramInt1 != 4);
    g(paramArrayOfDouble1);
  }
  
  private final void b(int paramInt1, int[] paramArrayOfInt, int paramInt2, double[] paramArrayOfDouble)
  {
    paramArrayOfInt[(paramInt2 + 0)] = 0;
    int j = 1;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt1 << 3 < i)
    {
      j = i >> 1;
      i = 0;
      while (i < paramInt1)
      {
        paramArrayOfInt[(paramInt2 + paramInt1 + i)] = (paramArrayOfInt[(paramInt2 + i)] + j);
        i += 1;
      }
      paramInt1 <<= 1;
      i = j;
    }
    int k = paramInt1 * 2;
    int n;
    int m;
    double d1;
    double d2;
    double d3;
    double d4;
    if (paramInt1 << 3 == i)
    {
      i = 0;
      while (i < paramInt1)
      {
        j = 0;
        while (j < i)
        {
          n = j * 2 + paramArrayOfInt[(paramInt2 + i)];
          m = i * 2 + paramArrayOfInt[(paramInt2 + j)];
          d1 = paramArrayOfDouble[n];
          d2 = -paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = -paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          n += k;
          m += k * 2;
          d1 = paramArrayOfDouble[n];
          d2 = -paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = -paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          n += k;
          m -= k;
          d1 = paramArrayOfDouble[n];
          d2 = -paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = -paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          n += k;
          m += k * 2;
          d1 = paramArrayOfDouble[n];
          d2 = -paramArrayOfDouble[(n + 1)];
          d3 = paramArrayOfDouble[m];
          d4 = -paramArrayOfDouble[(m + 1)];
          paramArrayOfDouble[n] = d3;
          paramArrayOfDouble[(n + 1)] = d4;
          paramArrayOfDouble[m] = d1;
          paramArrayOfDouble[(m + 1)] = d2;
          j += 1;
        }
        j = i * 2 + paramArrayOfInt[(paramInt2 + i)];
        paramArrayOfDouble[(j + 1)] = (-paramArrayOfDouble[(j + 1)]);
        j += k;
        m = j + k;
        d1 = paramArrayOfDouble[j];
        d2 = -paramArrayOfDouble[(j + 1)];
        d3 = paramArrayOfDouble[m];
        d4 = -paramArrayOfDouble[(m + 1)];
        paramArrayOfDouble[j] = d3;
        paramArrayOfDouble[(j + 1)] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[(m + 1)] = d2;
        j = m + k;
        paramArrayOfDouble[(j + 1)] = (-paramArrayOfDouble[(j + 1)]);
        i += 1;
      }
    }
    paramArrayOfDouble[1] = (-paramArrayOfDouble[1]);
    paramArrayOfDouble[(k + 1)] = (-paramArrayOfDouble[(k + 1)]);
    i = 1;
    while (i < paramInt1)
    {
      j = 0;
      while (j < i)
      {
        n = j * 2 + paramArrayOfInt[(paramInt2 + i)];
        m = i * 2 + paramArrayOfInt[(paramInt2 + j)];
        d1 = paramArrayOfDouble[n];
        d2 = -paramArrayOfDouble[(n + 1)];
        d3 = paramArrayOfDouble[m];
        d4 = -paramArrayOfDouble[(m + 1)];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[(n + 1)] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[(m + 1)] = d2;
        n += k;
        m += k;
        d1 = paramArrayOfDouble[n];
        d2 = -paramArrayOfDouble[(n + 1)];
        d3 = paramArrayOfDouble[m];
        d4 = -paramArrayOfDouble[(m + 1)];
        paramArrayOfDouble[n] = d3;
        paramArrayOfDouble[(n + 1)] = d4;
        paramArrayOfDouble[m] = d1;
        paramArrayOfDouble[(m + 1)] = d2;
        j += 1;
      }
      j = i * 2 + paramArrayOfInt[(paramInt2 + i)];
      paramArrayOfDouble[(j + 1)] = (-paramArrayOfDouble[(j + 1)]);
      paramArrayOfDouble[(j + k + 1)] = (-paramArrayOfDouble[(j + k + 1)]);
      i += 1;
    }
  }
  
  private void b(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[8];
    double d8 = paramArrayOfDouble[9];
    double d9 = paramArrayOfDouble[10];
    double d10 = paramArrayOfDouble[11];
    double d11 = paramArrayOfDouble[12];
    double d12 = paramArrayOfDouble[13];
    double d13 = paramArrayOfDouble[14];
    double d14 = paramArrayOfDouble[15];
    double d15 = paramArrayOfDouble[16];
    double d16 = paramArrayOfDouble[17];
    double d17 = paramArrayOfDouble[18];
    double d18 = paramArrayOfDouble[19];
    double d19 = paramArrayOfDouble[20];
    double d20 = paramArrayOfDouble[21];
    double d21 = paramArrayOfDouble[22];
    double d22 = paramArrayOfDouble[23];
    double d23 = paramArrayOfDouble[24];
    double d24 = paramArrayOfDouble[25];
    double d25 = paramArrayOfDouble[26];
    double d26 = paramArrayOfDouble[27];
    double d27 = paramArrayOfDouble[28];
    double d28 = paramArrayOfDouble[29];
    double d29 = paramArrayOfDouble[30];
    double d30 = paramArrayOfDouble[31];
    paramArrayOfDouble[2] = d29;
    paramArrayOfDouble[3] = d30;
    paramArrayOfDouble[4] = d13;
    paramArrayOfDouble[5] = d14;
    paramArrayOfDouble[6] = d21;
    paramArrayOfDouble[7] = d22;
    paramArrayOfDouble[8] = d5;
    paramArrayOfDouble[9] = d6;
    paramArrayOfDouble[10] = d25;
    paramArrayOfDouble[11] = d26;
    paramArrayOfDouble[12] = d9;
    paramArrayOfDouble[13] = d10;
    paramArrayOfDouble[14] = d17;
    paramArrayOfDouble[15] = d18;
    paramArrayOfDouble[16] = d1;
    paramArrayOfDouble[17] = d2;
    paramArrayOfDouble[18] = d27;
    paramArrayOfDouble[19] = d28;
    paramArrayOfDouble[20] = d11;
    paramArrayOfDouble[21] = d12;
    paramArrayOfDouble[22] = d19;
    paramArrayOfDouble[23] = d20;
    paramArrayOfDouble[24] = d3;
    paramArrayOfDouble[25] = d4;
    paramArrayOfDouble[26] = d23;
    paramArrayOfDouble[27] = d24;
    paramArrayOfDouble[28] = d7;
    paramArrayOfDouble[29] = d8;
    paramArrayOfDouble[30] = d15;
    paramArrayOfDouble[31] = d16;
  }
  
  private void b(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d1 = paramArrayOfDouble2[(paramInt2 + 1)];
    double d18 = paramArrayOfDouble2[(paramInt2 + 4)];
    double d19 = paramArrayOfDouble2[(paramInt2 + 5)];
    double d16 = paramArrayOfDouble2[(paramInt2 + 6)];
    double d17 = paramArrayOfDouble2[(paramInt2 + 7)];
    double d21 = paramArrayOfDouble2[(paramInt2 + 8)];
    double d23 = paramArrayOfDouble2[(paramInt2 + 9)];
    double d3 = paramArrayOfDouble1[(paramInt1 + 0)] - paramArrayOfDouble1[(paramInt1 + 17)];
    double d2 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(paramInt1 + 16)];
    double d5 = paramArrayOfDouble1[(paramInt1 + 8)] - paramArrayOfDouble1[(paramInt1 + 25)];
    double d6 = paramArrayOfDouble1[(paramInt1 + 9)] + paramArrayOfDouble1[(paramInt1 + 24)];
    double d4 = (d5 - d6) * d1;
    d5 = (d5 + d6) * d1;
    double d12 = d3 + d4;
    double d10 = d2 + d5;
    d6 = d3 - d4;
    double d8 = d2 - d5;
    d2 = paramArrayOfDouble1[(paramInt1 + 0)] + paramArrayOfDouble1[(paramInt1 + 17)];
    d3 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(paramInt1 + 16)];
    d4 = paramArrayOfDouble1[(paramInt1 + 8)] + paramArrayOfDouble1[(paramInt1 + 25)];
    d5 = paramArrayOfDouble1[(paramInt1 + 9)] - paramArrayOfDouble1[(paramInt1 + 24)];
    double d7 = (d4 - d5) * d1;
    double d9 = (d4 + d5) * d1;
    d5 = d2 - d9;
    d4 = d3 + d7;
    d2 += d9;
    d3 -= d7;
    d9 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(paramInt1 + 19)];
    double d11 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(paramInt1 + 18)];
    d7 = d18 * d9 - d19 * d11;
    d9 = d9 * d19 + d11 * d18;
    double d13 = paramArrayOfDouble1[(paramInt1 + 10)] - paramArrayOfDouble1[(paramInt1 + 27)];
    double d14 = paramArrayOfDouble1[(paramInt1 + 11)] + paramArrayOfDouble1[(paramInt1 + 26)];
    d11 = d17 * d13 - d16 * d14;
    d13 = d13 * d16 + d14 * d17;
    double d22 = d7 + d11;
    double d20 = d9 + d13;
    d14 = d7 - d11;
    double d15 = d9 - d13;
    d9 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(paramInt1 + 19)];
    d11 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(paramInt1 + 18)];
    d7 = d16 * d9 - d17 * d11;
    d9 = d9 * d17 + d11 * d16;
    d11 = paramArrayOfDouble1[(paramInt1 + 10)] + paramArrayOfDouble1[(paramInt1 + 27)];
    d13 = paramArrayOfDouble1[(paramInt1 + 11)] - paramArrayOfDouble1[(paramInt1 + 26)];
    double d24 = d18 * d11 + d19 * d13;
    double d25 = d13 * d18 - d11 * d19;
    d13 = d7 - d24;
    d11 = d9 - d25;
    d7 += d24;
    d9 += d25;
    d25 = paramArrayOfDouble1[(paramInt1 + 4)] - paramArrayOfDouble1[(paramInt1 + 21)];
    double d26 = paramArrayOfDouble1[(paramInt1 + 5)] + paramArrayOfDouble1[(paramInt1 + 20)];
    d24 = d21 * d25 - d23 * d26;
    d25 = d25 * d23 + d26 * d21;
    double d27 = paramArrayOfDouble1[(paramInt1 + 12)] - paramArrayOfDouble1[(paramInt1 + 29)];
    double d28 = paramArrayOfDouble1[(paramInt1 + 13)] + paramArrayOfDouble1[(paramInt1 + 28)];
    d26 = d23 * d27 - d21 * d28;
    d27 = d27 * d21 + d28 * d23;
    double d29 = d24 + d26;
    d28 = d25 + d27;
    d26 = d24 - d26;
    d27 = d25 - d27;
    d24 = paramArrayOfDouble1[(paramInt1 + 4)] + paramArrayOfDouble1[(paramInt1 + 21)];
    d25 = paramArrayOfDouble1[(paramInt1 + 5)] - paramArrayOfDouble1[(paramInt1 + 20)];
    double d30 = d23 * d24 - d21 * d25;
    double d31 = d24 * d21 + d25 * d23;
    d24 = paramArrayOfDouble1[(paramInt1 + 12)] + paramArrayOfDouble1[(paramInt1 + 29)];
    d25 = paramArrayOfDouble1[(paramInt1 + 13)] - paramArrayOfDouble1[(paramInt1 + 28)];
    double d32 = d21 * d24 - d23 * d25;
    d23 = d21 * d25 + d23 * d24;
    d25 = d30 - d32;
    d24 = d31 - d23;
    d21 = d30 + d32;
    d23 += d31;
    d31 = paramArrayOfDouble1[(paramInt1 + 6)] - paramArrayOfDouble1[(paramInt1 + 23)];
    d32 = paramArrayOfDouble1[(paramInt1 + 7)] + paramArrayOfDouble1[(paramInt1 + 22)];
    d30 = d16 * d31 - d17 * d32;
    d31 = d31 * d17 + d32 * d16;
    d32 = paramArrayOfDouble1[(paramInt1 + 14)] - paramArrayOfDouble1[(paramInt1 + 31)];
    double d33 = paramArrayOfDouble1[(paramInt1 + 15)] + paramArrayOfDouble1[(paramInt1 + 30)];
    double d34 = d19 * d32 - d18 * d33;
    double d35 = d32 * d18 + d33 * d19;
    d33 = d30 + d34;
    d32 = d31 + d35;
    d30 -= d34;
    d31 -= d35;
    d35 = paramArrayOfDouble1[(paramInt1 + 6)] + paramArrayOfDouble1[(paramInt1 + 23)];
    double d36 = paramArrayOfDouble1[(paramInt1 + 7)] - paramArrayOfDouble1[(paramInt1 + 22)];
    d34 = d19 * d35 + d18 * d36;
    d35 = d19 * d36 - d18 * d35;
    d18 = paramArrayOfDouble1[(paramInt1 + 14)] + paramArrayOfDouble1[(paramInt1 + 31)];
    d19 = paramArrayOfDouble1[(paramInt1 + 15)] - paramArrayOfDouble1[(paramInt1 + 30)];
    d36 = d17 * d18 - d16 * d19;
    d17 = d18 * d16 + d17 * d19;
    d19 = d34 + d36;
    d18 = d35 + d17;
    d16 = d34 - d36;
    d17 = d35 - d17;
    d34 = d12 + d29;
    d35 = d10 + d28;
    d36 = d22 + d33;
    double d37 = d20 + d32;
    paramArrayOfDouble1[(paramInt1 + 0)] = (d34 + d36);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d35 + d37);
    paramArrayOfDouble1[(paramInt1 + 2)] = (d34 - d36);
    paramArrayOfDouble1[(paramInt1 + 3)] = (d35 - d37);
    d12 -= d29;
    d10 -= d28;
    d22 -= d33;
    d20 -= d32;
    paramArrayOfDouble1[(paramInt1 + 4)] = (d12 - d20);
    paramArrayOfDouble1[(paramInt1 + 5)] = (d10 + d22);
    paramArrayOfDouble1[(paramInt1 + 6)] = (d12 + d20);
    paramArrayOfDouble1[(paramInt1 + 7)] = (d10 - d22);
    d10 = d6 - d27;
    d12 = d8 + d26;
    d22 = d14 - d31;
    d28 = d15 + d30;
    d20 = (d22 - d28) * d1;
    d22 = (d22 + d28) * d1;
    paramArrayOfDouble1[(paramInt1 + 8)] = (d10 + d20);
    paramArrayOfDouble1[(paramInt1 + 9)] = (d12 + d22);
    paramArrayOfDouble1[(paramInt1 + 10)] = (d10 - d20);
    paramArrayOfDouble1[(paramInt1 + 11)] = (d12 - d22);
    d6 += d27;
    d8 -= d26;
    d10 = d14 + d31;
    d14 = d15 - d30;
    d12 = (d10 - d14) * d1;
    d10 = (d10 + d14) * d1;
    paramArrayOfDouble1[(paramInt1 + 12)] = (d6 - d10);
    paramArrayOfDouble1[(paramInt1 + 13)] = (d8 + d12);
    paramArrayOfDouble1[(paramInt1 + 14)] = (d6 + d10);
    paramArrayOfDouble1[(paramInt1 + 15)] = (d8 - d12);
    d6 = d5 + d25;
    d8 = d4 + d24;
    d10 = d13 - d19;
    d12 = d11 - d18;
    paramArrayOfDouble1[(paramInt1 + 16)] = (d6 + d10);
    paramArrayOfDouble1[(paramInt1 + 17)] = (d8 + d12);
    paramArrayOfDouble1[(paramInt1 + 18)] = (d6 - d10);
    paramArrayOfDouble1[(paramInt1 + 19)] = (d8 - d12);
    d5 -= d25;
    d4 -= d24;
    d6 = d19 + d13;
    d8 = d18 + d11;
    paramArrayOfDouble1[(paramInt1 + 20)] = (d5 - d8);
    paramArrayOfDouble1[(paramInt1 + 21)] = (d4 + d6);
    paramArrayOfDouble1[(paramInt1 + 22)] = (d5 + d8);
    paramArrayOfDouble1[(paramInt1 + 23)] = (d4 - d6);
    d4 = d2 - d23;
    d5 = d3 + d21;
    d8 = d7 + d17;
    d10 = d9 - d16;
    d6 = (d8 - d10) * d1;
    d8 = (d8 + d10) * d1;
    paramArrayOfDouble1[(paramInt1 + 24)] = (d4 + d6);
    paramArrayOfDouble1[(paramInt1 + 25)] = (d5 + d8);
    paramArrayOfDouble1[(paramInt1 + 26)] = (d4 - d6);
    paramArrayOfDouble1[(paramInt1 + 27)] = (d5 - d8);
    d2 += d23;
    d3 -= d21;
    d4 = d7 - d17;
    d6 = d9 + d16;
    d5 = (d4 - d6) * d1;
    d1 *= (d4 + d6);
    paramArrayOfDouble1[(paramInt1 + 28)] = (d2 - d1);
    paramArrayOfDouble1[(paramInt1 + 29)] = (d3 + d5);
    paramArrayOfDouble1[(paramInt1 + 30)] = (d1 + d2);
    paramArrayOfDouble1[(paramInt1 + 31)] = (d3 - d5);
  }
  
  private void c(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int i = paramInt1 >> 2;
    int k;
    while (i > 128)
    {
      j = i;
      while (j < paramInt1)
      {
        for (k = j - i; k < paramInt1; k = j * 4 + k)
        {
          a(i, paramArrayOfDouble1, paramInt2 + k, paramArrayOfDouble2, paramInt3 - (i >> 1));
          b(i, paramArrayOfDouble1, paramInt2 + j + k, paramArrayOfDouble2, paramInt3 - i);
          a(i, paramArrayOfDouble1, j * 2 + paramInt2 + k, paramArrayOfDouble2, paramInt3 - (i >> 1));
        }
        j <<= 2;
      }
      a(i, paramArrayOfDouble1, paramInt2 + paramInt1 - i, paramArrayOfDouble2, paramInt3 - (i >> 1));
      i >>= 2;
    }
    int j = i;
    while (j < paramInt1)
    {
      for (k = j - i; k < paramInt1; k = j * 4 + k)
      {
        a(i, paramArrayOfDouble1, paramInt2 + k, paramArrayOfDouble2, paramInt3 - (i >> 1));
        e(i, paramArrayOfDouble1, paramInt2 + k, paramInt3, paramArrayOfDouble2);
        b(i, paramArrayOfDouble1, paramInt2 + j + k, paramArrayOfDouble2, paramInt3 - i);
        f(i, paramArrayOfDouble1, paramInt2 + j + k, paramInt3, paramArrayOfDouble2);
        a(i, paramArrayOfDouble1, j * 2 + paramInt2 + k, paramArrayOfDouble2, paramInt3 - (i >> 1));
        e(i, paramArrayOfDouble1, j * 2 + paramInt2 + k, paramInt3, paramArrayOfDouble2);
      }
      j <<= 2;
    }
    a(i, paramArrayOfDouble1, paramInt2 + paramInt1 - i, paramArrayOfDouble2, paramInt3 - (i >> 1));
    e(i, paramArrayOfDouble1, paramInt2 + paramInt1 - i, paramInt3, paramArrayOfDouble2);
  }
  
  private void c(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 1;
    int m = paramInt2 * 2 / k;
    int j = 0;
    int i = 2;
    while (i < k)
    {
      int n = paramInt1 - i;
      j += m;
      double d2 = 0.5D - paramArrayOfDouble2[(paramInt3 + paramInt2 - j)];
      double d3 = paramArrayOfDouble2[(paramInt3 + j)];
      double d4 = paramArrayOfDouble1[i] - paramArrayOfDouble1[n];
      double d5 = paramArrayOfDouble1[(i + 1)] + paramArrayOfDouble1[(n + 1)];
      double d1 = d2 * d4 - d3 * d5;
      d2 = d2 * d5 + d3 * d4;
      paramArrayOfDouble1[i] -= d1;
      int i1 = i + 1;
      paramArrayOfDouble1[i1] -= d2;
      paramArrayOfDouble1[n] += d1;
      n += 1;
      paramArrayOfDouble1[n] -= d2;
      i += 2;
    }
  }
  
  private void c(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[6];
    double d4 = paramArrayOfDouble[7];
    double d5 = paramArrayOfDouble[8];
    double d6 = paramArrayOfDouble[9];
    double d7 = paramArrayOfDouble[12];
    double d8 = paramArrayOfDouble[13];
    paramArrayOfDouble[2] = d5;
    paramArrayOfDouble[3] = d6;
    paramArrayOfDouble[6] = d7;
    paramArrayOfDouble[7] = d8;
    paramArrayOfDouble[8] = d1;
    paramArrayOfDouble[9] = d2;
    paramArrayOfDouble[12] = d3;
    paramArrayOfDouble[13] = d4;
  }
  
  private void c(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d3 = paramArrayOfDouble2[(paramInt2 + 1)];
    double d4 = paramArrayOfDouble1[(paramInt1 + 0)] + paramArrayOfDouble1[(paramInt1 + 8)];
    double d5 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(paramInt1 + 9)];
    double d8 = paramArrayOfDouble1[(paramInt1 + 0)] - paramArrayOfDouble1[(paramInt1 + 8)];
    double d9 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(paramInt1 + 9)];
    double d7 = paramArrayOfDouble1[(paramInt1 + 4)] + paramArrayOfDouble1[(paramInt1 + 12)];
    double d6 = paramArrayOfDouble1[(paramInt1 + 5)] + paramArrayOfDouble1[(paramInt1 + 13)];
    double d10 = paramArrayOfDouble1[(paramInt1 + 4)] - paramArrayOfDouble1[(paramInt1 + 12)];
    double d11 = paramArrayOfDouble1[(paramInt1 + 5)] - paramArrayOfDouble1[(paramInt1 + 13)];
    double d1 = d4 + d7;
    double d2 = d5 + d6;
    d4 -= d7;
    d5 -= d6;
    d6 = d8 - d11;
    d7 = d9 + d10;
    d8 += d11;
    d9 -= d10;
    double d12 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(paramInt1 + 10)];
    double d13 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(paramInt1 + 11)];
    double d16 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(paramInt1 + 10)];
    double d14 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(paramInt1 + 11)];
    double d19 = paramArrayOfDouble1[(paramInt1 + 6)] + paramArrayOfDouble1[(paramInt1 + 14)];
    double d18 = paramArrayOfDouble1[(paramInt1 + 7)] + paramArrayOfDouble1[(paramInt1 + 15)];
    double d15 = paramArrayOfDouble1[(paramInt1 + 6)] - paramArrayOfDouble1[(paramInt1 + 14)];
    double d17 = paramArrayOfDouble1[(paramInt1 + 7)] - paramArrayOfDouble1[(paramInt1 + 15)];
    d10 = d12 + d19;
    d11 = d13 + d18;
    d12 -= d19;
    d13 -= d18;
    d18 = d16 - d17;
    d19 = d14 + d15;
    d16 += d17;
    d15 = d14 - d15;
    d14 = (d18 - d19) * d3;
    d17 = (d18 + d19) * d3;
    d18 = (d16 - d15) * d3;
    d3 *= (d16 + d15);
    paramArrayOfDouble1[(paramInt1 + 8)] = (d6 + d14);
    paramArrayOfDouble1[(paramInt1 + 9)] = (d7 + d17);
    paramArrayOfDouble1[(paramInt1 + 10)] = (d6 - d14);
    paramArrayOfDouble1[(paramInt1 + 11)] = (d7 - d17);
    paramArrayOfDouble1[(paramInt1 + 12)] = (d8 - d3);
    paramArrayOfDouble1[(paramInt1 + 13)] = (d9 + d18);
    paramArrayOfDouble1[(paramInt1 + 14)] = (d3 + d8);
    paramArrayOfDouble1[(paramInt1 + 15)] = (d9 - d18);
    paramArrayOfDouble1[(paramInt1 + 0)] = (d1 + d10);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d2 + d11);
    paramArrayOfDouble1[(paramInt1 + 2)] = (d1 - d10);
    paramArrayOfDouble1[(paramInt1 + 3)] = (d2 - d11);
    paramArrayOfDouble1[(paramInt1 + 4)] = (d4 - d13);
    paramArrayOfDouble1[(paramInt1 + 5)] = (d5 + d12);
    paramArrayOfDouble1[(paramInt1 + 6)] = (d4 + d13);
    paramArrayOfDouble1[(paramInt1 + 7)] = (d5 - d12);
  }
  
  private void d(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    int k = paramInt1 >> 1;
    paramInt1 >>= 2;
    int j;
    while (paramInt1 > 128)
    {
      i = paramInt1;
      while (i < k)
      {
        for (j = i - paramInt1; j < k; j = i * 2 + j)
        {
          a(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramArrayOfDouble2, paramInt3 - (paramInt1 >> 1));
          a(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramArrayOfDouble2, paramInt3 - (paramInt1 >> 1));
        }
        for (j = i * 2 - paramInt1; j < k; j = i * 4 + j)
        {
          b(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramArrayOfDouble2, paramInt3 - paramInt1);
          b(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramArrayOfDouble2, paramInt3 - paramInt1);
        }
        i <<= 2;
      }
      paramInt1 >>= 2;
    }
    int i = paramInt1;
    while (i < k)
    {
      for (j = i - paramInt1; j < k; j = i * 2 + j)
      {
        a(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramArrayOfDouble2, paramInt3 - (paramInt1 >> 1));
        e(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramInt3, paramArrayOfDouble2);
        a(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramArrayOfDouble2, paramInt3 - (paramInt1 >> 1));
        e(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramInt3, paramArrayOfDouble2);
      }
      for (j = i * 2 - paramInt1; j < k; j = i * 4 + j)
      {
        b(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramArrayOfDouble2, paramInt3 - paramInt1);
        f(paramInt1, paramArrayOfDouble1, paramInt2 + j, paramInt3, paramArrayOfDouble2);
        b(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramArrayOfDouble2, paramInt3 - paramInt1);
        f(paramInt1, paramArrayOfDouble1, paramInt2 + k + j, paramInt3, paramArrayOfDouble2);
      }
      i <<= 2;
    }
  }
  
  private void d(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, double[] paramArrayOfDouble2, int paramInt3)
  {
    int k = paramInt1 >> 1;
    int m = paramInt2 * 2 / k;
    int j = 0;
    int i = 2;
    while (i < k)
    {
      int n = paramInt1 - i;
      j += m;
      double d2 = 0.5D - paramArrayOfDouble2[(paramInt3 + paramInt2 - j)];
      double d3 = paramArrayOfDouble2[(paramInt3 + j)];
      double d4 = paramArrayOfDouble1[i] - paramArrayOfDouble1[n];
      double d5 = paramArrayOfDouble1[(i + 1)] + paramArrayOfDouble1[(n + 1)];
      double d1 = d2 * d4 + d3 * d5;
      d2 = d2 * d5 - d3 * d4;
      paramArrayOfDouble1[i] -= d1;
      int i1 = i + 1;
      paramArrayOfDouble1[i1] -= d2;
      paramArrayOfDouble1[n] += d1;
      n += 1;
      paramArrayOfDouble1[n] -= d2;
      i += 2;
    }
  }
  
  private void d(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[2];
    double d2 = paramArrayOfDouble[3];
    double d3 = paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[8];
    double d8 = paramArrayOfDouble[9];
    double d9 = paramArrayOfDouble[10];
    double d10 = paramArrayOfDouble[11];
    double d11 = paramArrayOfDouble[12];
    double d12 = paramArrayOfDouble[13];
    double d13 = paramArrayOfDouble[14];
    double d14 = paramArrayOfDouble[15];
    paramArrayOfDouble[2] = d13;
    paramArrayOfDouble[3] = d14;
    paramArrayOfDouble[4] = d5;
    paramArrayOfDouble[5] = d6;
    paramArrayOfDouble[6] = d9;
    paramArrayOfDouble[7] = d10;
    paramArrayOfDouble[8] = d1;
    paramArrayOfDouble[9] = d2;
    paramArrayOfDouble[10] = d11;
    paramArrayOfDouble[11] = d12;
    paramArrayOfDouble[12] = d3;
    paramArrayOfDouble[13] = d4;
    paramArrayOfDouble[14] = d7;
    paramArrayOfDouble[15] = d8;
  }
  
  private void d(double[] paramArrayOfDouble1, int paramInt1, double[] paramArrayOfDouble2, int paramInt2)
  {
    double d4 = paramArrayOfDouble2[(paramInt2 + 1)];
    double d14 = paramArrayOfDouble2[(paramInt2 + 4)];
    double d15 = paramArrayOfDouble2[(paramInt2 + 5)];
    double d8 = paramArrayOfDouble1[(paramInt1 + 0)] - paramArrayOfDouble1[(paramInt1 + 9)];
    double d7 = paramArrayOfDouble1[(paramInt1 + 1)] + paramArrayOfDouble1[(paramInt1 + 8)];
    double d2 = paramArrayOfDouble1[(paramInt1 + 0)] + paramArrayOfDouble1[(paramInt1 + 9)];
    double d1 = paramArrayOfDouble1[(paramInt1 + 1)] - paramArrayOfDouble1[(paramInt1 + 8)];
    double d3 = paramArrayOfDouble1[(paramInt1 + 4)] - paramArrayOfDouble1[(paramInt1 + 13)];
    double d5 = paramArrayOfDouble1[(paramInt1 + 5)] + paramArrayOfDouble1[(paramInt1 + 12)];
    double d9 = (d3 - d5) * d4;
    double d10 = (d3 + d5) * d4;
    d5 = paramArrayOfDouble1[(paramInt1 + 4)] + paramArrayOfDouble1[(paramInt1 + 13)];
    double d6 = paramArrayOfDouble1[(paramInt1 + 5)] - paramArrayOfDouble1[(paramInt1 + 12)];
    d3 = (d5 - d6) * d4;
    d4 *= (d5 + d6);
    d5 = paramArrayOfDouble1[(paramInt1 + 2)] - paramArrayOfDouble1[(paramInt1 + 11)];
    d6 = paramArrayOfDouble1[(paramInt1 + 3)] + paramArrayOfDouble1[(paramInt1 + 10)];
    double d12 = d14 * d5 - d15 * d6;
    double d13 = d5 * d15 + d6 * d14;
    d6 = paramArrayOfDouble1[(paramInt1 + 2)] + paramArrayOfDouble1[(paramInt1 + 11)];
    double d11 = paramArrayOfDouble1[(paramInt1 + 3)] - paramArrayOfDouble1[(paramInt1 + 10)];
    d5 = d15 * d6 - d14 * d11;
    d6 = d6 * d14 + d11 * d15;
    d11 = paramArrayOfDouble1[(paramInt1 + 6)] - paramArrayOfDouble1[(paramInt1 + 15)];
    double d17 = paramArrayOfDouble1[(paramInt1 + 7)] + paramArrayOfDouble1[(paramInt1 + 14)];
    double d16 = d15 * d11 - d14 * d17;
    d17 = d11 * d14 + d17 * d15;
    double d18 = paramArrayOfDouble1[(paramInt1 + 6)] + paramArrayOfDouble1[(paramInt1 + 15)];
    double d19 = paramArrayOfDouble1[(paramInt1 + 7)] - paramArrayOfDouble1[(paramInt1 + 14)];
    d11 = d14 * d18 - d15 * d19;
    d14 = d14 * d19 + d15 * d18;
    d15 = d8 + d9;
    d18 = d7 + d10;
    d19 = d12 + d16;
    double d20 = d13 + d17;
    paramArrayOfDouble1[(paramInt1 + 0)] = (d15 + d19);
    paramArrayOfDouble1[(paramInt1 + 1)] = (d18 + d20);
    paramArrayOfDouble1[(paramInt1 + 2)] = (d15 - d19);
    paramArrayOfDouble1[(paramInt1 + 3)] = (d18 - d20);
    d8 -= d9;
    d7 -= d10;
    d9 = d12 - d16;
    d10 = d13 - d17;
    paramArrayOfDouble1[(paramInt1 + 4)] = (d8 - d10);
    paramArrayOfDouble1[(paramInt1 + 5)] = (d7 + d9);
    paramArrayOfDouble1[(paramInt1 + 6)] = (d8 + d10);
    paramArrayOfDouble1[(paramInt1 + 7)] = (d7 - d9);
    d7 = d2 - d4;
    d8 = d1 + d3;
    d9 = d5 - d11;
    d10 = d6 - d14;
    paramArrayOfDouble1[(paramInt1 + 8)] = (d7 + d9);
    paramArrayOfDouble1[(paramInt1 + 9)] = (d8 + d10);
    paramArrayOfDouble1[(paramInt1 + 10)] = (d7 - d9);
    paramArrayOfDouble1[(paramInt1 + 11)] = (d8 - d10);
    d2 = d4 + d2;
    d1 -= d3;
    d3 = d5 + d11;
    d4 = d14 + d6;
    paramArrayOfDouble1[(paramInt1 + 12)] = (d2 - d4);
    paramArrayOfDouble1[(paramInt1 + 13)] = (d1 + d3);
    paramArrayOfDouble1[(paramInt1 + 14)] = (d2 + d4);
    paramArrayOfDouble1[(paramInt1 + 15)] = (d1 - d3);
  }
  
  private void e(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    if (paramInt1 == 128)
    {
      a(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - 8);
      b(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt3 - 32);
      a(paramArrayOfDouble1, paramInt2 + 64, paramArrayOfDouble2, paramInt3 - 8);
      a(paramArrayOfDouble1, paramInt2 + 96, paramArrayOfDouble2, paramInt3 - 8);
      return;
    }
    c(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - 16);
    d(paramArrayOfDouble1, paramInt2 + 16, paramArrayOfDouble2, paramInt3 - 16);
    c(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt3 - 16);
    c(paramArrayOfDouble1, paramInt2 + 48, paramArrayOfDouble2, paramInt3 - 16);
  }
  
  private void e(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0] + paramArrayOfDouble[4];
    double d2 = paramArrayOfDouble[1] + paramArrayOfDouble[5];
    double d3 = paramArrayOfDouble[0] - paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[1] - paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[2] + paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[3] + paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[2] - paramArrayOfDouble[6];
    double d8 = paramArrayOfDouble[3] - paramArrayOfDouble[7];
    paramArrayOfDouble[0] = (d1 + d5);
    paramArrayOfDouble[1] = (d2 + d6);
    paramArrayOfDouble[4] = (d1 - d5);
    paramArrayOfDouble[5] = (d2 - d6);
    paramArrayOfDouble[2] = (d3 - d8);
    paramArrayOfDouble[3] = (d4 + d7);
    paramArrayOfDouble[6] = (d3 + d8);
    paramArrayOfDouble[7] = (d4 - d7);
  }
  
  private void f(int paramInt1, double[] paramArrayOfDouble1, int paramInt2, int paramInt3, double[] paramArrayOfDouble2)
  {
    if (paramInt1 == 128)
    {
      a(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - 8);
      b(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt3 - 32);
      a(paramArrayOfDouble1, paramInt2 + 64, paramArrayOfDouble2, paramInt3 - 8);
      b(paramArrayOfDouble1, paramInt2 + 96, paramArrayOfDouble2, paramInt3 - 32);
      return;
    }
    c(paramArrayOfDouble1, paramInt2, paramArrayOfDouble2, paramInt3 - 16);
    d(paramArrayOfDouble1, paramInt2 + 16, paramArrayOfDouble2, paramInt3 - 16);
    c(paramArrayOfDouble1, paramInt2 + 32, paramArrayOfDouble2, paramInt3 - 16);
    d(paramArrayOfDouble1, paramInt2 + 48, paramArrayOfDouble2, paramInt3 - 16);
  }
  
  private void f(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0] + paramArrayOfDouble[4];
    double d2 = paramArrayOfDouble[1] + paramArrayOfDouble[5];
    double d3 = paramArrayOfDouble[0] - paramArrayOfDouble[4];
    double d4 = paramArrayOfDouble[1] - paramArrayOfDouble[5];
    double d5 = paramArrayOfDouble[2] + paramArrayOfDouble[6];
    double d6 = paramArrayOfDouble[3] + paramArrayOfDouble[7];
    double d7 = paramArrayOfDouble[2] - paramArrayOfDouble[6];
    double d8 = paramArrayOfDouble[3] - paramArrayOfDouble[7];
    paramArrayOfDouble[0] = (d1 + d5);
    paramArrayOfDouble[1] = (d2 + d6);
    paramArrayOfDouble[4] = (d1 - d5);
    paramArrayOfDouble[5] = (d2 - d6);
    paramArrayOfDouble[2] = (d3 + d8);
    paramArrayOfDouble[3] = (d4 - d7);
    paramArrayOfDouble[6] = (d3 - d8);
    paramArrayOfDouble[7] = (d4 + d7);
  }
  
  private void g(double[] paramArrayOfDouble)
  {
    double d1 = paramArrayOfDouble[0];
    double d2 = paramArrayOfDouble[2];
    double d3 = paramArrayOfDouble[1];
    double d4 = paramArrayOfDouble[3];
    paramArrayOfDouble[0] += paramArrayOfDouble[2];
    paramArrayOfDouble[1] += paramArrayOfDouble[3];
    paramArrayOfDouble[2] = (d1 - d2);
    paramArrayOfDouble[3] = (d3 - d4);
  }
  
  public void a(int paramInt1, int paramInt2, double[] paramArrayOfDouble1, int[] paramArrayOfInt, double[] paramArrayOfDouble2)
  {
    int j = paramArrayOfInt[0];
    int i = j;
    if (paramInt1 > j << 2)
    {
      i = paramInt1 >> 2;
      a(i, paramArrayOfInt, paramArrayOfDouble2);
    }
    int k = paramArrayOfInt[1];
    j = k;
    if (paramInt1 > k << 2)
    {
      j = paramInt1 >> 2;
      a(j, paramArrayOfInt, paramArrayOfDouble2, i);
    }
    if (paramInt2 >= 0) {
      if (paramInt1 > 4)
      {
        a(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
        c(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
      }
    }
    do
    {
      for (;;)
      {
        double d1 = paramArrayOfDouble1[0];
        double d2 = paramArrayOfDouble1[1];
        paramArrayOfDouble1[0] += paramArrayOfDouble1[1];
        paramArrayOfDouble1[1] = (d1 - d2);
        return;
        if (paramInt1 == 4) {
          a(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
        }
      }
      paramArrayOfDouble1[1] = (0.5D * (paramArrayOfDouble1[0] - paramArrayOfDouble1[1]));
      paramArrayOfDouble1[0] -= paramArrayOfDouble1[1];
      if (paramInt1 > 4)
      {
        d(paramInt1, paramArrayOfDouble1, j, paramArrayOfDouble2, i);
        b(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
        return;
      }
    } while (paramInt1 != 4);
    b(paramInt1, paramArrayOfDouble1, paramArrayOfInt, 2, i, paramArrayOfDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xue
 * JD-Core Version:    0.7.0.1
 */