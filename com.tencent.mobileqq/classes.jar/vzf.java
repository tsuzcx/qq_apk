class vzf
  implements vyx
{
  vzf(vze paramvze) {}
  
  public void a(vzc paramvzc, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      vzc[] arrayOfvzc = this.a.a();
      j = arrayOfvzc.length;
      i = 0;
      while (i < j)
      {
        vzc localvzc = arrayOfvzc[i];
        if (localvzc != paramvzc) {
          localvzc.b(false);
        }
        i += 1;
      }
    }
    paramvzc = this.a.a();
    int j = paramvzc.length;
    for (;;)
    {
      if ((i >= j) || (paramvzc[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzf
 * JD-Core Version:    0.7.0.1
 */