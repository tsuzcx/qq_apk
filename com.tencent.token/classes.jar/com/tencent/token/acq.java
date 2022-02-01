package com.tencent.token;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public final class acq
{
  public static final String[] a = { "px", "dp", "sp", "pt", "in", "mm" };
  public acp b;
  public Map<String, String> c = new HashMap();
  public byte[] d;
  public String[] e;
  public int[] f;
  public int g;
  public int h;
  public int i;
  public int j;
  
  private String a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.g)) {
      return this.e[paramInt];
    }
    return null;
  }
  
  private void a(boolean paramBoolean)
  {
    int k = b(this.j + 16);
    String str1 = a(b(this.j + 20));
    String str2 = a(k);
    if (paramBoolean)
    {
      this.b.getClass();
      this.c.put(str1, str2);
    }
    else
    {
      this.b.getClass();
      this.c.remove(str1);
    }
    this.j += 24;
  }
  
  private int b(int paramInt)
  {
    byte[] arrayOfByte = this.d;
    int k = arrayOfByte[(paramInt + 3)];
    int m = arrayOfByte[(paramInt + 2)];
    int n = arrayOfByte[(paramInt + 1)];
    return arrayOfByte[(paramInt + 0)] << 0 & 0xFF | k << 24 & 0xFF000000 | m << 16 & 0xFF0000 | n << 8 & 0xFF00;
  }
  
  public final Document a(InputStream paramInputStream)
  {
    acp localacp = new acp();
    this.b = localacp;
    Object localObject1 = new byte[paramInputStream.available()];
    this.d = ((byte[])localObject1);
    paramInputStream.read((byte[])localObject1);
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
          int n;
          if (k != 524672)
          {
            Object localObject2;
            label399:
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
                ((Node)((acp)localObject1).a.peek()).appendChild(((acp)localObject1).b.createCDATASection(paramInputStream));
                this.j += 28;
                break;
              case 1048835: 
                this.b.a.pop();
                this.j += 24;
                break;
              case 1048834: 
                k = b(this.j + 16);
                m = b(this.j + 20);
                n = this.j + 28;
                paramInputStream = this.d;
                n = 0xFF00 & paramInputStream[(n + 1)] << 8 | paramInputStream[(n + 0)] << 0 & 0xFF;
                Object localObject3 = a(m);
                if (k == -1)
                {
                  paramInputStream = "";
                }
                else
                {
                  localObject1 = a(k);
                  paramInputStream = (InputStream)localObject1;
                  if (this.c.containsKey(localObject1))
                  {
                    paramInputStream = new StringBuilder();
                    paramInputStream.append((String)this.c.get(localObject1));
                    paramInputStream.append(':');
                    paramInputStream.append((String)localObject3);
                    localObject2 = paramInputStream.toString();
                    break label399;
                  }
                }
                localObject2 = localObject3;
                localObject1 = paramInputStream;
                this.j += 36;
                aco[] arrayOfaco = new aco[n];
                k = 0;
                while (k < n)
                {
                  m = b(this.j);
                  i1 = b(this.j + 4);
                  i2 = b(this.j + 8);
                  i3 = b(this.j + 12);
                  i4 = b(this.j + 16);
                  localObject4 = new aco();
                  ((aco)localObject4).a = a(i1);
                  if (m == -1)
                  {
                    ((aco)localObject4).c = null;
                    ((aco)localObject4).b = null;
                  }
                  else
                  {
                    paramInputStream = a(m);
                    if (this.c.containsKey(paramInputStream))
                    {
                      ((aco)localObject4).c = paramInputStream;
                      ((aco)localObject4).b = ((String)this.c.get(paramInputStream));
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
                    ((aco)localObject4).d = paramInputStream;
                  }
                  else
                  {
                    ((aco)localObject4).d = a(i2);
                  }
                  arrayOfaco[k] = localObject4;
                  this.j += 20;
                  k += 1;
                }
                Object localObject4 = this.b;
                localObject4.getClass();
                if ((localObject1 != null) && (!"".equals(localObject1))) {
                  k = 0;
                } else {
                  k = 1;
                }
                if (k != 0) {
                  paramInputStream = ((acp)localObject4).b.createElement((String)localObject3);
                } else {
                  paramInputStream = ((acp)localObject4).b.createElementNS((String)localObject1, (String)localObject2);
                }
                k = 0;
                while (k < n)
                {
                  localObject1 = arrayOfaco[k];
                  localObject2 = ((aco)localObject1).c;
                  if ((localObject2 != null) && (!"".equals(localObject2))) {
                    m = 0;
                  } else {
                    m = 1;
                  }
                  if (m != 0)
                  {
                    paramInputStream.setAttribute(((aco)localObject1).a, ((aco)localObject1).d);
                  }
                  else
                  {
                    localObject2 = ((aco)localObject1).c;
                    localObject3 = new StringBuilder();
                    ((StringBuilder)localObject3).append(((aco)localObject1).b);
                    ((StringBuilder)localObject3).append(':');
                    ((StringBuilder)localObject3).append(((aco)localObject1).a);
                    paramInputStream.setAttributeNS((String)localObject2, ((StringBuilder)localObject3).toString(), ((aco)localObject1).d);
                  }
                  k += 1;
                }
                ((Node)((acp)localObject4).a.peek()).appendChild(paramInputStream);
                ((acp)localObject4).a.push(paramInputStream);
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
              n = b(this.j + 4);
              this.g = b(this.j + 8);
              this.h = b(this.j + 12);
              i1 = this.j;
              i2 = b(i1 + 20);
              this.e = new String[this.g];
              k = 0;
              while (k < this.g)
              {
                i3 = b(this.j + (k + 7) * 4) + (i1 + i2);
                localObject2 = this.e;
                paramInputStream = this.d;
                m = i3 + 1;
                if (paramInputStream[m] == paramInputStream[i3])
                {
                  i4 = paramInputStream[i3];
                  localObject1 = new byte[i4];
                  m = 0;
                  for (;;)
                  {
                    paramInputStream = (InputStream)localObject1;
                    if (m >= i4) {
                      break;
                    }
                    localObject1[m] = this.d[(i3 + 2 + m)];
                    m += 1;
                  }
                }
                m = paramInputStream[m];
                i4 = paramInputStream[i3] & 0xFF | m << 8 & 0xFF00;
                localObject1 = new byte[i4];
                m = 0;
                for (;;)
                {
                  paramInputStream = (InputStream)localObject1;
                  if (m >= i4) {
                    break;
                  }
                  localObject1[m] = this.d[(i3 + 2 + m * 2)];
                  m += 1;
                }
                localObject2[k] = new String(paramInputStream);
                k += 1;
              }
              this.j += n;
            }
          }
          else
          {
            k = 0;
            m = b(this.j + 4);
            n = m / 4 - 2;
            this.i = n;
            this.f = new int[n];
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
          localObject1 = paramInputStream.c.newDocument();
          paramInputStream.b = ((Document)localObject1);
          paramInputStream.a.push(localObject1);
          this.j += 8;
        }
      }
      else {
        this.b.getClass();
      }
    }
    this.b.getClass();
    return localacp.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.acq
 * JD-Core Version:    0.7.0.1
 */