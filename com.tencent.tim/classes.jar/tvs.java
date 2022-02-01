import android.graphics.PointF;
import org.json.JSONObject;

public class tvs
  implements tvj
{
  private final tut jdField_a_of_type_Tut;
  private final tve<PointF, PointF> jdField_a_of_type_Tve;
  private final String name;
  private final tum q;
  
  private tvs(String paramString, tve<PointF, PointF> paramtve, tut paramtut, tum paramtum)
  {
    this.name = paramString;
    this.jdField_a_of_type_Tve = paramtve;
    this.jdField_a_of_type_Tut = paramtut;
    this.q = paramtum;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new ttb(paramtrz, paramtwe, this);
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
  
  public tum l()
  {
    return this.q;
  }
  
  public String toString()
  {
    return "RectangleShape{cornerRadius=" + this.q.a() + ", position=" + this.jdField_a_of_type_Tve + ", size=" + this.jdField_a_of_type_Tut + '}';
  }
  
  static class a
  {
    static tvs a(JSONObject paramJSONObject, trx paramtrx)
    {
      return new tvs(paramJSONObject.optString("nm"), tus.a(paramJSONObject.optJSONObject("p"), paramtrx), tut.a.a(paramJSONObject.optJSONObject("s"), paramtrx), tum.a.a(paramJSONObject.optJSONObject("r"), paramtrx), null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvs
 * JD-Core Version:    0.7.0.1
 */