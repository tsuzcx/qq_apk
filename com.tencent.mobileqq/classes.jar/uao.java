import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;", "", "()V", "action", "", "from", "isSharing", "", "reportClick", "", "reportExp", "reportResult", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uao
{
  private static int jdField_a_of_type_Int;
  public static final uao a;
  private static boolean jdField_a_of_type_Boolean;
  private static int b;
  
  static
  {
    jdField_a_of_type_Uao = new uao();
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    paa localpaa = new paa();
    pae.a(localpaa, "from", Integer.valueOf(paramInt));
    ocd.a("0X800AD75", localpaa.a());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    paa localpaa;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localpaa = new paa();
      pae.a(localpaa, "from", Integer.valueOf(jdField_a_of_type_Int));
      pae.a(localpaa, "share_unit", Integer.valueOf(uak.a.a(b)));
      if (!paramBoolean) {
        break label74;
      }
    }
    for (;;)
    {
      pae.a(localpaa, "result", Integer.valueOf(i));
      ocd.a("0X800AD77", localpaa.a());
      return;
      label74:
      i = 1;
    }
  }
  
  public final void b(int paramInt)
  {
    b = paramInt;
    jdField_a_of_type_Boolean = true;
    paa localpaa = new paa();
    pae.a(localpaa, "from", Integer.valueOf(jdField_a_of_type_Int));
    pae.a(localpaa, "share_unit", Integer.valueOf(uak.a.a(paramInt)));
    ocd.a("0X800AD76", localpaa.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uao
 * JD-Core Version:    0.7.0.1
 */