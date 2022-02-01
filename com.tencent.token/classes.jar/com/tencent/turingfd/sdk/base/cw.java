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
            label381:
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
                if (k == -1) {}
                for (;;)
                {
                  this.b.a.pop();
                  this.j += 24;
                  break;
                  a(k);
                }
              case 1048834: 
                k = b(this.j + 16);
                n = b(this.j + 20);
                m = this.j + 28;
                paramInputStream = this.d;
                m = paramInputStream[(m + 1)] << 8 & 0xFF00 | paramInputStream[(m + 0)] << 0 & 0xFF;
                String str = a(n);
                cc[] arrayOfcc;
                cc localcc;
                if (k == -1)
                {
                  localObject1 = str;
                  localObject2 = "";
                  this.j += 36;
                  arrayOfcc = new cc[m];
                  k = 0;
                  if (k >= m) {
                    break label963;
                  }
                  n = b(this.j);
                  i1 = b(this.j + 4);
                  i2 = b(this.j + 8);
                  i3 = b(this.j + 12);
                  i4 = b(this.j + 16);
                  localcc = new cc();
                  localcc.a = a(i1);
                  if (n != -1) {
                    break label722;
                  }
                  localcc.b(null);
                  localcc.a(null);
                  if (i2 != -1) {
                    break label949;
                  }
                  switch (i3)
                  {
                  default: 
                    paramInputStream = String.format("%08X/0x%08X", new Object[] { Integer.valueOf(i3), Integer.valueOf(i4) });
                    localcc.c(paramInputStream);
                  }
                }
                for (;;)
                {
                  arrayOfcc[k] = localcc;
                  this.j += 20;
                  k += 1;
                  break label381;
                  localObject2 = a(k);
                  if (this.c.containsKey(localObject2))
                  {
                    localObject1 = (String)this.c.get(localObject2) + ':' + str;
                    break;
                  }
                  localObject1 = str;
                  break;
                  paramInputStream = a(n);
                  if (!this.c.containsKey(paramInputStream)) {
                    break label487;
                  }
                  localcc.b(paramInputStream);
                  localcc.a((String)this.c.get(paramInputStream));
                  break label487;
                  paramInputStream = String.format("#%08X", new Object[] { Integer.valueOf(i4) });
                  break label618;
                  if (i4 != 0) {}
                  for (boolean bool = true;; bool = false)
                  {
                    paramInputStream = Boolean.toString(bool);
                    break;
                  }
                  paramInputStream = Integer.toString(i4);
                  break label618;
                  double d1 = i4 / 2147483647.0D;
                  paramInputStream = new DecimalFormat("#.##%").format(d1);
                  break label618;
                  paramInputStream = Integer.toString(i4 >> 8) + a[(i4 & 0xFF)];
                  break label618;
                  paramInputStream = Float.toString(Float.intBitsToFloat(i4));
                  break label618;
                  paramInputStream = a(i4);
                  break label618;
                  paramInputStream = String.format("?id/0x%08X", new Object[] { Integer.valueOf(i4) });
                  break label618;
                  paramInputStream = String.format("@id/0x%08X", new Object[] { Integer.valueOf(i4) });
                  break label618;
                  localcc.c(a(i2));
                }
                this.b.a((String)localObject2, str, (String)localObject1, arrayOfcc);
                break;
              case 1048833: 
                label949:
                label963:
                a(false);
                break;
              case 1048832: 
                label487:
                label618:
                a(true);
                label722:
                break;
              }
            }
            else
            {
              n = b(this.j + 4);
              this.g = b(this.j + 8);
              this.h = b(this.j + 12);
              i1 = this.j;
              i2 = b(i1 + 20);
              i3 = b(this.j + 24);
              this.e = new String[this.g];
              k = 0;
              while (k < this.g)
              {
                i4 = b(this.j + (k + 7) * 4) + (i2 + i1);
                localObject2 = this.e;
                paramInputStream = this.d;
                m = i4 + 1;
                if (paramInputStream[m] == paramInputStream[i4])
                {
                  i5 = paramInputStream[i4];
                  localObject1 = new byte[i5];
                  m = 0;
                  for (;;)
                  {
                    paramInputStream = (InputStream)localObject1;
                    if (m >= i5) {
                      break;
                    }
                    localObject1[m] = this.d[(i4 + 2 + m)];
                    m += 1;
                  }
                }
                int i5 = paramInputStream[m] << 8 & 0xFF00 | paramInputStream[i4] & 0xFF;
                localObject1 = new byte[i5];
                m = 0;
                for (;;)
                {
                  paramInputStream = (InputStream)localObject1;
                  if (m >= i5) {
                    break;
                  }
                  localObject1[m] = this.d[(i4 + 2 + m * 2)];
                  m += 1;
                }
                localObject2[k] = new String(paramInputStream);
                k += 1;
              }
              if (i3 > 0)
              {
                k = 0;
                while (k < this.h) {
                  k += 1;
                }
              }
              this.j += n;
            }
          }
          else
          {
            m = b(this.j + 4);
            this.i = (m / 4 - 2);
            this.f = new int[this.i];
            k = 0;
            while (k < this.i)
            {
              this.f[k] = b(this.j + (k + 2) * 4);
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
    for (;;)
    {
      this.j += 24;
      return;
      this.b.b(str2, str1);
      this.c.remove(str1);
    }
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