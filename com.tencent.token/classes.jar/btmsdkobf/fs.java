package btmsdkobf;

class fs
  implements ef.a
{
  fs(cr paramcr) {}
  
  public void c(boolean paramBoolean1, boolean paramBoolean2)
  {
    eh.f("NetworkDetector", "[detect_conn]detectSync(), network error? " + paramBoolean2);
    if (paramBoolean2)
    {
      cr.a(this.a, -3);
      return;
    }
    if (paramBoolean1)
    {
      cr.a(this.a, -2);
      return;
    }
    cr.a(this.a, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.fs
 * JD-Core Version:    0.7.0.1
 */