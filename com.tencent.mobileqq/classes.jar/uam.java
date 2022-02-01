import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;", "", "()V", "action", "", "from", "isSharing", "", "reportClick", "", "reportExp", "reportResult", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uam
{
  private static int jdField_a_of_type_Int;
  public static final uam a;
  private static boolean jdField_a_of_type_Boolean;
  private static int b;
  
  static
  {
    jdField_a_of_type_Uam = new uam();
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    phi localphi = new phi();
    phm.a(localphi, "from", Integer.valueOf(paramInt));
    oat.a("0X800AD75", localphi.a());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    phi localphi;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localphi = new phi();
      phm.a(localphi, "from", Integer.valueOf(jdField_a_of_type_Int));
      phm.a(localphi, "share_unit", Integer.valueOf(uai.a.a(b)));
      if (!paramBoolean) {
        break label74;
      }
    }
    for (;;)
    {
      phm.a(localphi, "result", Integer.valueOf(i));
      oat.a("0X800AD77", localphi.a());
      return;
      label74:
      i = 1;
    }
  }
  
  public final void b(int paramInt)
  {
    b = paramInt;
    jdField_a_of_type_Boolean = true;
    phi localphi = new phi();
    phm.a(localphi, "from", Integer.valueOf(jdField_a_of_type_Int));
    phm.a(localphi, "share_unit", Integer.valueOf(uai.a.a(paramInt)));
    oat.a("0X800AD76", localphi.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     uam
 * JD-Core Version:    0.7.0.1
 */