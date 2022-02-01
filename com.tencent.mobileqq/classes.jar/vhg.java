public class vhg
{
  public static int a(vex paramvex1, vex paramvex2)
  {
    if (paramvex1 == paramvex2) {}
    do
    {
      return 0;
      if (paramvex1 == null) {
        return -1;
      }
      if (paramvex2 == null) {
        return 1;
      }
    } while (paramvex1.equals(paramvex2));
    long l = paramvex1.d() - paramvex2.d();
    if (l > 0L) {
      return 1;
    }
    if (l < 0L) {
      return -1;
    }
    int i = paramvex1.a() - paramvex2.a();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    i = paramvex1.i() - paramvex2.i();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    i = paramvex1.h() - paramvex2.h();
    if (i > 0) {
      return -1;
    }
    if (i < 0) {
      return 1;
    }
    l = paramvex1.c() - paramvex2.c();
    if (l > 0L) {
      return -1;
    }
    if (l < 0L) {
      return 1;
    }
    if (paramvex1.a() == null) {
      return -1;
    }
    if (paramvex2.a() == null) {
      return 1;
    }
    i = paramvex1.a() - paramvex2.a();
    if (i > 0) {
      return 1;
    }
    if (i < 0) {
      return -1;
    }
    return paramvex1.hashCode() - paramvex1.hashCode();
  }
  
  public static int a(vex paramvex1, vex paramvex2, long paramLong)
  {
    if (paramvex1.a() != paramvex2.a()) {}
    while ((paramvex1.c()) || (paramvex2.c())) {
      return -1;
    }
    float[] arrayOfFloat = paramvex1.a(paramvex1.d());
    int i = (int)((paramvex2.a(paramvex1.d())[0] - arrayOfFloat[2]) / paramvex2.a());
    arrayOfFloat = paramvex1.a(paramvex1.b());
    return Math.max(i, (int)((paramvex2.a(paramvex1.b())[0] - arrayOfFloat[2]) / paramvex2.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vhg
 * JD-Core Version:    0.7.0.1
 */