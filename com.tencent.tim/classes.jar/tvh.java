import android.graphics.PointF;
import org.json.JSONObject;

public class tvh
  implements tvj
{
  private final tut jdField_a_of_type_Tut;
  private final tve<PointF, PointF> jdField_a_of_type_Tve;
  private final String name;
  
  private tvh(String paramString, tve<PointF, PointF> paramtve, tut paramtut)
  {
    this.name = paramString;
    this.jdField_a_of_type_Tve = paramtve;
    this.jdField_a_of_type_Tut = paramtut;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new tsr(paramtrz, paramtwe, this);
  }
  
  public tut a()
  {
    return this.jdField_a_of_type_Tut;
  }
  
  public tve<PointF, PointF> a()
  {
    return this.jdField_a_of_type_Tve;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  static class a
  {
    static tvh a(JSONObject paramJSONObject, trx paramtrx)
    {
      return new tvh(paramJSONObject.optString("nm"), tus.a(paramJSONObject.optJSONObject("p"), paramtrx), tut.a.a(paramJSONObject.optJSONObject("s"), paramtrx), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvh
 * JD-Core Version:    0.7.0.1
 */