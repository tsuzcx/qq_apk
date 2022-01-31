class vmj
  implements vmb
{
  vmj(vmi paramvmi) {}
  
  public void a(vmg paramvmg, boolean paramBoolean)
  {
    int i = 0;
    if (paramBoolean)
    {
      vmg[] arrayOfvmg = this.a.a();
      j = arrayOfvmg.length;
      i = 0;
      while (i < j)
      {
        vmg localvmg = arrayOfvmg[i];
        if (localvmg != paramvmg) {
          localvmg.b(false);
        }
        i += 1;
      }
    }
    paramvmg = this.a.a();
    int j = paramvmg.length;
    for (;;)
    {
      if ((i >= j) || (paramvmg[i].a())) {
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vmj
 * JD-Core Version:    0.7.0.1
 */