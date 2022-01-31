package tmsdk.common.d.a.b;

import com.qq.taf.jce.JceStruct;
import d.b.a;

class B
  implements a
{
  int a = 0;
  final int b = 3;
  
  B(z paramz) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    new StringBuilder().append("_Cmd_SCReconnect : ").append(paramInt2).append("  retCode : ").append(paramInt3).toString();
    if (paramInt3 == 0)
    {
      this.c.k();
      this.a = 0;
    }
    do
    {
      return;
      this.a += 1;
    } while ((this.a >= 3) || (!this.c.g()));
    this.a = 0;
    this.c.a(z.a(this.c), 998, null, null, z.b(this.c), 10000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.B
 * JD-Core Version:    0.7.0.1
 */