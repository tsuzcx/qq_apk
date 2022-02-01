class yqf
  implements ypx
{
  yqf(yqe paramyqe) {}
  
  public void a(yqc paramyqc, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      yqc[] arrayOfyqc = this.a.a();
      j = arrayOfyqc.length;
      i = 0;
      while (i < j)
      {
        yqc localyqc = arrayOfyqc[i];
        if (localyqc != paramyqc) {
          localyqc.a(false);
        }
        i += 1;
      }
    }
    paramyqc = this.a.a();
    int j = paramyqc.length;
    for (;;)
    {
      if ((i >= j) || (paramyqc[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yqf
 * JD-Core Version:    0.7.0.1
 */