import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/util/ReadInJoyShareHelperV2$ShareReport;", "", "()V", "action", "", "from", "isSharing", "", "reportClick", "", "reportExp", "reportResult", "success", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class uhd
{
  private static int jdField_a_of_type_Int;
  public static final uhd a;
  private static boolean jdField_a_of_type_Boolean;
  private static int b;
  
  static
  {
    jdField_a_of_type_Uhd = new uhd();
  }
  
  public final void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
    pbg localpbg = new pbg();
    pbk.a(localpbg, "from", Integer.valueOf(paramInt));
    odq.a("0X800AD75", localpbg.a());
  }
  
  public final void a(boolean paramBoolean)
  {
    int i = 0;
    pbg localpbg;
    if (jdField_a_of_type_Boolean)
    {
      jdField_a_of_type_Boolean = false;
      localpbg = new pbg();
      pbk.a(localpbg, "from", Integer.valueOf(jdField_a_of_type_Int));
      pbk.a(localpbg, "share_unit", Integer.valueOf(ugz.a.a(b)));
      if (!paramBoolean) {
        break label74;
      }
    }
    for (;;)
    {
      pbk.a(localpbg, "result", Integer.valueOf(i));
      odq.a("0X800AD77", localpbg.a());
      return;
      label74:
      i = 1;
    }
  }
  
  public final void b(int paramInt)
  {
    b = paramInt;
    jdField_a_of_type_Boolean = true;
    pbg localpbg = new pbg();
    pbk.a(localpbg, "from", Integer.valueOf(jdField_a_of_type_Int));
    pbk.a(localpbg, "share_unit", Integer.valueOf(ugz.a.a(paramInt)));
    odq.a("0X800AD76", localpbg.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uhd
 * JD-Core Version:    0.7.0.1
 */