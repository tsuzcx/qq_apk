class zlo
  implements zlg
{
  zlo(zln paramzln) {}
  
  public void a(zll paramzll, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      zll[] arrayOfzll = this.a.a();
      j = arrayOfzll.length;
      i = 0;
      while (i < j)
      {
        zll localzll = arrayOfzll[i];
        if (localzll != paramzll) {
          localzll.b(false);
        }
        i += 1;
      }
    }
    paramzll = this.a.a();
    int j = paramzll.length;
    for (;;)
    {
      if ((i >= j) || (paramzll[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlo
 * JD-Core Version:    0.7.0.1
 */