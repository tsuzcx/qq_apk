class vzc
  implements vyu
{
  vzc(vzb paramvzb) {}
  
  public void a(vyz paramvyz, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      vyz[] arrayOfvyz = this.a.a();
      j = arrayOfvyz.length;
      i = 0;
      while (i < j)
      {
        vyz localvyz = arrayOfvyz[i];
        if (localvyz != paramvyz) {
          localvyz.b(false);
        }
        i += 1;
      }
    }
    paramvyz = this.a.a();
    int j = paramvyz.length;
    for (;;)
    {
      if ((i >= j) || (paramvyz[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vzc
 * JD-Core Version:    0.7.0.1
 */