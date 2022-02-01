package tmsdk.common.d.a.b;

import com.qq.taf.jce.JceStruct;
import com.tencent.token.eh;

class A
  implements eh
{
  int a = 0;
  final int b = 3;
  
  A(z paramz) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    paramJceStruct = new StringBuilder();
    paramJceStruct.append("_Cmd_SCHeartBeat : ");
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
    paramJceStruct = new StringBuilder();
    paramJceStruct.append("心跳包失败 ： ");
    paramJceStruct.append(this.a);
    paramJceStruct.toString();
    if (this.a < 3) {
      this.c.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.A
 * JD-Core Version:    0.7.0.1
 */