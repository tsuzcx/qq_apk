package com.tencent.token;

import com.qq.taf.jce.JceStruct;

final class asd
  implements aji
{
  int a = 0;
  final int b = 3;
  
  asd(atm paramatm) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    paramJceStruct = new StringBuilder("_Cmd_SCHeartBeat : ");
    paramJceStruct.append(paramInt2);
    paramJceStruct.append("  retCode : ");
    paramJceStruct.append(paramInt3);
    if (paramInt3 == 0)
    {
      this.c.c = 0;
      this.a = 0;
      return;
    }
    this.a += 1;
    new StringBuilder("心跳包失败 ： ").append(this.a);
    if (this.a < 3) {
      this.c.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.asd
 * JD-Core Version:    0.7.0.1
 */