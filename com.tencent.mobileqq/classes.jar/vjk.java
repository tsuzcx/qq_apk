public class vjk
{
  public static int a(vhb paramvhb1, vhb paramvhb2)
  {
    if (paramvhb1 == paramvhb2) {}
    do
    {
      return 0;
      if (paramvhb1 == null) {
        return -1;
      }
      if (paramvhb2 == null) {
        return 1;
      }
    } while (paramvhb1.equals(paramvhb2));
    long l = paramvhb1.d() - paramvhb2.d();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    int i = paramvhb1.a() - paramvhb2.a();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    i = paramvhb1.i() - paramvhb2.i();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    i = paramvhb1.h() - paramvhb2.h();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    l = paramvhb1.c() - paramvhb2.c();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    if (paramvhb1.a() == null) {
      return -1;
    }
    if (paramvhb2.a() == null) {
      return 1;
    }
    i = paramvhb1.a() - paramvhb2.a();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return paramvhb1.hashCode() - paramvhb1.hashCode();
  }
  
  public static int a(vhb paramvhb1, vhb paramvhb2, long paramLong)
  {
    if (paramvhb1.a() != paramvhb2.a()) {}
    while ((paramvhb1.c()) || (paramvhb2.c())) {
      return -1;
    }
    float[] arrayOfFloat = paramvhb1.a(paramvhb1.d());
    int i = (int)((paramvhb2.a(paramvhb1.d())[0] - arrayOfFloat[2]) / paramvhb2.a());
    arrayOfFloat = paramvhb1.a(paramvhb1.b());
    return Math.max(i, (int)((paramvhb2.a(paramvhb1.b())[0] - arrayOfFloat[2]) / paramvhb2.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjk
 * JD-Core Version:    0.7.0.1
 */