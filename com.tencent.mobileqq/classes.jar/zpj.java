class zpj
  implements zpb
{
  zpj(zpi paramzpi) {}
  
  public void a(zpg paramzpg, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      zpg[] arrayOfzpg = this.a.a();
      j = arrayOfzpg.length;
      i = 0;
      while (i < j)
      {
        zpg localzpg = arrayOfzpg[i];
        if (localzpg != paramzpg) {
          localzpg.b(false);
        }
        i += 1;
      }
    }
    paramzpg = this.a.a();
    int j = paramzpg.length;
    for (;;)
    {
      if ((i >= j) || (paramzpg[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zpj
 * JD-Core Version:    0.7.0.1
 */