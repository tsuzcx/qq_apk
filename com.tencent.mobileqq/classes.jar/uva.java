import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;", "", "()V", "action", "", "from", "isSharing", "", "reportClick", "", "reportExp", "reportResult", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uva
{
  private static int jdField_a_of_type_Int;
  public static final uva a;
  private static boolean jdField_a_of_type_Boolean;
  private static int b;
  
  static
  {
    jdField_a_of_type_Uva = new uva();
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    pqg localpqg = new pqg();
    pkl.a(localpqg, "from", Integer.valueOf(paramInt));
    olh.a("0X800AD75", localpqg.a());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    pqg localpqg;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localpqg = new pqg();
      pkl.a(localpqg, "from", Integer.valueOf(jdField_a_of_type_Int));
      pkl.a(localpqg, "share_unit", Integer.valueOf(uuw.a.a(b)));
      if (!paramBoolean) {
        break label74;
      }
    }
    for (;;)
    {
      pkl.a(localpqg, "result", Integer.valueOf(i));
      olh.a("0X800AD77", localpqg.a());
      return;
      label74:
      i = 1;
    }
  }
  
  public final void b(int paramInt)
  {
    b = paramInt;
    jdField_a_of_type_Boolean = true;
    pqg localpqg = new pqg();
    pkl.a(localpqg, "from", Integer.valueOf(jdField_a_of_type_Int));
    pkl.a(localpqg, "share_unit", Integer.valueOf(uuw.a.a(paramInt)));
    olh.a("0X800AD76", localpqg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uva
 * JD-Core Version:    0.7.0.1
 */