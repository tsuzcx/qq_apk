import android.content.Context;
import android.os.AsyncTask;
import com.tencent.mobileqq.statistics.MainAcitivityReportHelper;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class gki
  extends AsyncTask
{
  public gki(Context paramContext, long paramLong, String paramString) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = MainAcitivityReportHelper.b(this.jdField_a_of_type_AndroidContentContext);
    HashMap localHashMap = new HashMap();
    int i;
    if (this.jdField_a_of_type_Long < 500L) {
      i = MainAcitivityReportHelper.a();
    }
    for (;;)
    {
      localHashMap.put("param_FailCode", String.valueOf(i));
      StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_a_of_type_JavaLangString, paramVarArgs, false, this.jdField_a_of_type_Long, 0L, localHashMap, "");
      return null;
      if (this.jdField_a_of_type_Long < 1000L) {
        i = MainAcitivityReportHelper.a() + 1;
      } else if (this.jdField_a_of_type_Long < 2000L) {
        i = MainAcitivityReportHelper.a() + 2;
      } else if (this.jdField_a_of_type_Long < 3000L) {
        i = MainAcitivityReportHelper.a() + 3;
      } else if (this.jdField_a_of_type_Long < 5000L) {
        i = MainAcitivityReportHelper.a() + 4;
      } else if (this.jdField_a_of_type_Long < 7000L) {
        i = MainAcitivityReportHelper.a() + 5;
      } else if (this.jdField_a_of_type_Long < 10000L) {
        i = MainAcitivityReportHelper.a() + 6;
      } else {
        i = MainAcitivityReportHelper.a() + 7;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gki
 * JD-Core Version:    0.7.0.1
 */