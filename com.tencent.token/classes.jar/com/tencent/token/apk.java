package com.tencent.token;

import com.qq.taf.jce.JceStruct;

final class apk
  implements agx
{
  int a = 0;
  final int b = 3;
  
  apk(aqs paramaqs) {}
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, JceStruct paramJceStruct)
  {
    paramJceStruct = new StringBuilder("_Cmd_SCReconnect : ");
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
    if ((this.a < 3) && (this.c.d()))
    {
      this.a = 0;
      paramJceStruct = this.c;
      paramJceStruct.a(aqs.a(paramJceStruct), 998, aqs.b(this.c), 10000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.apk
 * JD-Core Version:    0.7.0.1
 */