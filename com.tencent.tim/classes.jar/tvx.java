import android.graphics.Path.FillType;
import android.support.annotation.Nullable;
import org.json.JSONObject;

public class tvx
  implements tvj
{
  @Nullable
  private final tuk jdField_a_of_type_Tuk;
  @Nullable
  private final tuq jdField_a_of_type_Tuq;
  private final boolean fillEnabled;
  private final Path.FillType fillType;
  private final String name;
  
  private tvx(String paramString, boolean paramBoolean, Path.FillType paramFillType, @Nullable tuk paramtuk, @Nullable tuq paramtuq)
  {
    this.name = paramString;
    this.fillEnabled = paramBoolean;
    this.fillType = paramFillType;
    this.jdField_a_of_type_Tuk = paramtuk;
    this.jdField_a_of_type_Tuq = paramtuq;
  }
  
  public tso a(trz paramtrz, twe paramtwe)
  {
    return new tss(paramtrz, paramtwe, this);
  }
  
  @Nullable
  public tuk a()
  {
    return this.jdField_a_of_type_Tuk;
  }
  
  @Nullable
  public tuq b()
  {
    return this.jdField_a_of_type_Tuq;
  }
  
  public Path.FillType getFillType()
  {
    return this.fillType;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("ShapeFill{color=");
    if (this.jdField_a_of_type_Tuk == null)
    {
      localObject = "null";
      localStringBuilder = localStringBuilder.append((String)localObject).append(", fillEnabled=").append(this.fillEnabled).append(", opacity=");
      if (this.jdField_a_of_type_Tuq != null) {
        break label90;
      }
    }
    label90:
    for (Object localObject = "null";; localObject = this.jdField_a_of_type_Tuq.e())
    {
      return localObject + '}';
      localObject = Integer.toHexString(((Integer)this.jdField_a_of_type_Tuk.K()).intValue());
      break;
    }
  }
  
  static class a
  {
    static tvx a(JSONObject paramJSONObject, trx paramtrx)
    {
      String str = paramJSONObject.optString("nm");
      Object localObject = paramJSONObject.optJSONObject("c");
      if (localObject != null) {}
      for (localObject = tuk.a.a((JSONObject)localObject, paramtrx);; localObject = null)
      {
        JSONObject localJSONObject = paramJSONObject.optJSONObject("o");
        if (localJSONObject != null) {}
        for (paramtrx = tuq.a.a(localJSONObject, paramtrx);; paramtrx = null)
        {
          boolean bool = paramJSONObject.optBoolean("fillEnabled");
          if (paramJSONObject.optInt("r", 1) == 1) {}
          for (paramJSONObject = Path.FillType.WINDING;; paramJSONObject = Path.FillType.EVEN_ODD) {
            return new tvx(str, bool, paramJSONObject, (tuk)localObject, paramtrx, null);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tvx
 * JD-Core Version:    0.7.0.1
 */