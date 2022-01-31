package tmsdk.common.d.a.b;

import com.qq.taf.jce.JceStruct;
import com.tencent.token.fn;

class A
  implements fn
{
  int a = 0;
  final int b = 3;
  
  A(z paramz) {}
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    new StringBuilder().append("_Cmd_SCHeartBeat : ").append(paramInt2).append("  retCode : ").append(paramInt3).toString();
    if (paramInt3 == 0)
    {
      this.c.k();
      this.a = 0;
    }
    do
    {
      return;
      this.a += 1;
      new StringBuilder().append("心跳包失败 ： ").append(this.a).toString();
    } while (this.a >= 3);
    this.c.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     tmsdk.common.d.a.b.A
 * JD-Core Version:    0.7.0.1
 */