package com.tencent.turingfd.sdk.base;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class cw
{
  public static final String[] a = { "px", "dp", "sp", "pt", "in", "mm" };
  public cg b;
  public Map<String, String> c = new HashMap();
  public byte[] d;
  public String[] e;
  public int[] f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  public final String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.g)) {
      return this.e[paramInt];
    }
    return null;
  }
  
  public Document a(InputStream paramInputStream)
  {
    cg localcg = new cg();
    this.b = localcg;
    this.d = new byte[paramInputStream.available()];
    paramInputStream.read(this.d);
    paramInputStream.close();
    for (;;)
    {
      int k = this.j;
      if (k >= this.d.length) {
        break;
      }
      k = b(k);
      if (k != -1)
      {
        if (k != 524291)
        {
          int m;
          if (k != 524672)
          {
            Object localObject1;
            int n;
            Object localObject2;
            int i1;
            int i2;
            int i3;
            int i4;
            if (k != 1835009)
            {
              switch (k)
              {
              default: 
                this.j += 4;
                break;
              case 1048836: 
                paramInputStream = a(b(this.j + 16));
                localObject1 = this.b;
                ((Node)((cg)localObject1).a.peek()).appendChild(((cg)localObject1).b.createCDATASection(paramInputStream));
                this.j += 28;
                break;
              case 1048835: 
                k = b(this.j + 16);
                a(b(this.j + 20));
                if (k != -1) {
                  a(k);
                }
                this.b.a.pop();
                this.j += 24;
                break;
              case 1048834: 
                k = b(this.j + 16);
                n = b(this.j + 20);
                m = this.j + 28;
                paramInputStream = this.d;
                m = 0xFF00 & paramInputStream[(m + 1)] << 8 | paramInputStream[(m + 0)] << 0 & 0xFF;
                localObject2 = a(n);
                String str;
                if (k == -1)
                {
                  str = "";
                  localObject1 = localObject2;
                }
                else
                {
                  str = a(k);
                  if (this.c.containsKey(str))
                  {
                    paramInputStream = new StringBuilder();
                    paramInputStream.append((String)this.c.get(str));
                    paramInputStream.append(':');
                    paramInputStream.append((String)localObject2);
                    localObject1 = paramInputStream.toString();
                  }
                  else
                  {
                    localObject1 = localObject2;
                  }
                }
                this.j += 36;
                cc[] arrayOfcc = new cc[m];
                k = 0;
                while (k < m)
                {
                  n = b(this.j);
                  i1 = b(this.j + 4);
                  i2 = b(this.j + 8);
                  i3 = b(this.j + 12);
                  i4 = b(this.j + 16);
                  cc localcc = new cc();
                  localcc.a = a(i1);
                  if (n == -1)
                  {
                    localcc.b(null);
                    localcc.a(null);
                  }
                  else
                  {
                    paramInputStream = a(n);
                    if (this.c.containsKey(paramInputStream))
                    {
                      localcc.b(paramInputStream);
                      localcc.a((String)this.c.get(paramInputStream));
                    }
                  }
                  if (i2 == -1)
                  {
                    switch (i3)
                    {
                    default: 
                      paramInputStream = String.format("%08X/0x%08X", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
                      break;
                    case 469762056: 
                    case 486539272: 
                      paramInputStream = String.format("#%08X", new Object[] { Integer.valueOf(i4) });
                      break;
                    case 301989896: 
                      boolean bool;
                      if (i4 != 0) {
                        bool = true;
                      } else {
                        bool = false;
                      }
                      paramInputStream = Boolean.toString(bool);
                      break;
                    case 268435464: 
                    case 285212680: 
                      paramInputStream = Integer.toString(i4);
                      break;
                    case 100663304: 
                      double d1 = i4;
                      Double.isNaN(d1);
                      d1 /= 2147483647.0D;
                      paramInputStream = new DecimalFormat("#.##%").format(d1);
                      break;
                    case 83886088: 
                      paramInputStream = new StringBuilder();
                      paramInputStream.append(Integer.toString(i4 >> 8));
                      paramInputStream.append(a[(i4 & 0xFF)]);
                      paramInputStream = paramInputStream.toString();
                      break;
                    case 67108872: 
                      paramInputStream = Float.toString(Float.intBitsToFloat(i4));
                      break;
                    case 50331656: 
                      paramInputStream = a(i4);
                      break;
                    case 33554440: 
                      paramInputStream = String.format("?id/0x%08X", new Object[] { Integer.valueOf(i4) });
                      break;
                    case 16777224: 
                      paramInputStream = String.format("@id/0x%08X", new Object[] { Integer.valueOf(i4) });
                    }
                    localcc.c(paramInputStream);
                  }
                  else
                  {
                    localcc.c(a(i2));
                  }
                  arrayOfcc[k] = localcc;
                  this.j += 20;
                  k += 1;
                }
                this.b.a(str, (String)localObject2, (String)localObject1, arrayOfcc);
                break;
              case 1048833: 
                a(false);
                break;
              case 1048832: 
                a(true);
                break;
              }
            }
            else
            {
              n = 0;
              i1 = b(this.j + 4);
              this.g = b(this.j + 8);
              this.h = b(this.j + 12);
              i2 = this.j;
              i3 = b(i2 + 20);
              i4 = b(this.j + 24);
              this.e = new String[this.g];
              k = 0;
              while (k < this.g)
              {
                int i5 = b((k + 7) * 4 + this.j) + (i3 + i2);
                localObject2 = this.e;
                paramInputStream = this.d;
                m = i5 + 1;
                if (paramInputStream[m] == paramInputStream[i5])
                {
                  i6 = paramInputStream[i5];
                  localObject1 = new byte[i6];
                  m = 0;
                  for (;;)
                  {
                    paramInputStream = (InputStream)localObject1;
                    if (m >= i6) {
                      break;
                    }
                    localObject1[m] = this.d[(i5 + 2 + m)];
                    m += 1;
                  }
                }
                m = paramInputStream[m];
                int i6 = paramInputStream[i5] & 0xFF | m << 8 & 0xFF00;
                localObject1 = new byte[i6];
                m = 0;
                for (;;)
                {
                  paramInputStream = (InputStream)localObject1;
                  if (m >= i6) {
                    break;
                  }
                  localObject1[m] = this.d[(m * 2 + (i5 + 2))];
                  m += 1;
                }
                localObject2[k] = new String(paramInputStream);
                k += 1;
              }
              if (i4 > 0)
              {
                k = n;
                while (k < this.h) {
                  k += 1;
                }
              }
              this.j += i1;
            }
          }
          else
          {
            k = 0;
            m = b(this.j + 4);
            this.i = (m / 4 - 2);
            this.f = new int[this.i];
            while (k < this.i)
            {
              this.f[k] = b((k + 2) * 4 + this.j);
              k += 1;
            }
            this.j += m;
          }
        }
        else
        {
          paramInputStream = this.b;
          paramInputStream.b = paramInputStream.c.newDocument();
          paramInputStream.a.push(paramInputStream.b);
          this.j += 8;
        }
      }
      else {
        this.b.a();
      }
    }
    this.b.a();
    return localcg.b;
  }
  
  public final void a(boolean paramBoolean)
  {
    int k = b(this.j + 16);
    String str1 = a(b(this.j + 20));
    String str2 = a(k);
    if (paramBoolean)
    {
      this.b.a(str2, str1);
      this.c.put(str1, str2);
    }
    else
    {
      this.b.b(str2, str1);
      this.c.remove(str1);
    }
    this.j += 24;
  }
  
  public final int b(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int k = arrayOfByte[(paramInt + 3)];
    int m = arrayOfByte[(paramInt + 2)];
    int n = arrayOfByte[(paramInt + 1)];
    return arrayOfByte[(paramInt + 0)] << 0 & 0xFF | k << 24 & 0xFF000000 | m << 16 & 0xFF0000 | n << 8 & 0xFF00;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.cw
 * JD-Core Version:    0.7.0.1
 */