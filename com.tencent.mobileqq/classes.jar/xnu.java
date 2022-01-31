class xnu
  implements xnm
{
  xnu(xnt paramxnt) {}
  
  public void a(xnr paramxnr, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      xnr[] arrayOfxnr = this.a.a();
      j = arrayOfxnr.length;
      i = 0;
      while (i < j)
      {
        xnr localxnr = arrayOfxnr[i];
        if (localxnr != paramxnr) {
          localxnr.b(false);
        }
        i += 1;
      }
    }
    paramxnr = this.a.a();
    int j = paramxnr.length;
    for (;;)
    {
      if ((i >= j) || (paramxnr[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnu
 * JD-Core Version:    0.7.0.1
 */