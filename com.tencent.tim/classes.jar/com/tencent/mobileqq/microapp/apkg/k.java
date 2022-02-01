package com.tencent.mobileqq.microapp.apkg;

final class k
  implements g.c
{
  k(g paramg, g.d paramd, long paramLong) {}
  
  public void a(f paramf)
  {
    if (paramf == null)
    {
      g.a(this.c, this.a, 1, null, "apkg info parse error");
      return;
    }
    g.a(this.c, this.a, 0, paramf, "Apkg init succ :" + (System.currentTimeMillis() - this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.apkg.k
 * JD-Core Version:    0.7.0.1
 */