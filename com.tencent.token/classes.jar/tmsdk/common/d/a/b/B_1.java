package tmsdk.common.d.a.b;

import com.qq.taf.jce.JceStruct;
import com.tencent.token.eh;

class B
  implements eh
{
  int a = 0;
  final int b = 3;
  
  B(z paramz) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    paramJceStruct = new StringBuilder();
    paramJceStruct.append("_Cmd_SCReconnect : ");
    paramJceStruct.append(paramInt2);
    paramJceStruct.append("  retCode : ");
    paramJceStruct.append(paramInt3);
    paramJceStruct.toString();
    if (paramInt3 == 0)
    {
      this.c.k();
      this.a = 0;
      return;
    }
    this.a += 1;
    if ((this.a < 3) && (this.c.g()))
    {
      this.a = 0;
      paramJceStruct = this.c;
      paramJceStruct.a(z.a(paramJceStruct), 998, null, null, z.b(this.c), 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.B
 * JD-Core Version:    0.7.0.1
 */