import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class asyu
{
  private String cGf = "";
  private String cGg = "";
  private String cGh = "";
  private String cGi = "inc";
  
  public asyu(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {}
    try
    {
      this.cGf = paramJSONObject.getString("name");
      this.cGg = paramJSONObject.getString("op");
      this.cGh = paramJSONObject.getString("val");
      this.cGi = paramJSONObject.getString("act");
      return;
    }
    catch (JSONException paramJSONObject)
    {
      paramJSONObject.printStackTrace();
    }
  }
  
  public boolean f(Object paramObject)
  {
    boolean bool2 = true;
    for (;;)
    {
      try
      {
        paramObject = asyk.h(paramObject, this.cGf);
        if (paramObject == null) {
          break label668;
        }
        if ((paramObject.getClass() == Integer.TYPE) || (paramObject.getClass() == Integer.class) || (paramObject.getClass() == Long.TYPE) || (paramObject.getClass() == Long.class))
        {
          paramObject = (Integer)paramObject;
          if (this.cGg.equalsIgnoreCase("less"))
          {
            if (paramObject.intValue() >= Integer.parseInt(this.cGh)) {
              break label672;
            }
            bool1 = true;
            if (!this.cGi.equalsIgnoreCase("exc")) {
              break label660;
            }
            if (!bool1)
            {
              bool1 = bool2;
              break label670;
            }
          }
          else
          {
            if (this.cGg.equalsIgnoreCase("more"))
            {
              if (paramObject.intValue() <= Integer.parseInt(this.cGh)) {
                break label677;
              }
              bool1 = true;
              continue;
            }
            if (this.cGg.equalsIgnoreCase("is"))
            {
              if (paramObject.intValue() != Integer.parseInt(this.cGh)) {
                break label682;
              }
              bool1 = true;
              continue;
            }
            if (this.cGg.equalsIgnoreCase("not"))
            {
              if (paramObject.intValue() == Integer.parseInt(this.cGh)) {
                break label687;
              }
              bool1 = true;
              continue;
            }
            if (this.cGg.equalsIgnoreCase("and"))
            {
              if ((paramObject.intValue() & Integer.parseInt(this.cGh)) == 0) {
                break label692;
              }
              bool1 = true;
              continue;
            }
            if (this.cGg.equalsIgnoreCase("or"))
            {
              if ((paramObject.intValue() | Integer.parseInt(this.cGh)) == 0) {
                break label697;
              }
              bool1 = true;
              continue;
            }
            if (this.cGg.equalsIgnoreCase("xor"))
            {
              if ((paramObject.intValue() ^ Integer.parseInt(this.cGh)) == 0) {
                break label702;
              }
              bool1 = true;
              continue;
            }
            if (this.cGg.equalsIgnoreCase("begins"))
            {
              bool1 = String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }).startsWith(this.cGh);
              continue;
            }
            if (this.cGg.equalsIgnoreCase("ends"))
            {
              bool1 = String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }).endsWith(this.cGh);
              continue;
            }
            if (!this.cGg.equalsIgnoreCase("rem")) {
              break label663;
            }
            bool1 = Pattern.matches(this.cGh, String.format("%d", new Object[] { Integer.valueOf(paramObject.intValue()) }));
            continue;
          }
        }
        else
        {
          if ((paramObject.getClass() != String.class) && (paramObject.getClass() != CharSequence.class)) {
            break label663;
          }
          paramObject = (String)paramObject;
          if (this.cGg.equalsIgnoreCase("less"))
          {
            if (paramObject.compareToIgnoreCase(this.cGh) >= 0) {
              break label707;
            }
            bool1 = true;
            continue;
          }
          if (this.cGg.equalsIgnoreCase("more"))
          {
            if (paramObject.compareToIgnoreCase(this.cGh) <= 0) {
              break label712;
            }
            bool1 = true;
            continue;
          }
          if (this.cGg.equalsIgnoreCase("is"))
          {
            bool1 = paramObject.equalsIgnoreCase(this.cGh);
            continue;
          }
          if (this.cGg.equalsIgnoreCase("not"))
          {
            if (paramObject.equalsIgnoreCase(this.cGh)) {
              break label717;
            }
            bool1 = true;
            continue;
          }
          if (this.cGg.equalsIgnoreCase("has"))
          {
            bool1 = paramObject.contains(this.cGh);
            continue;
          }
          if (this.cGg.equalsIgnoreCase("begins"))
          {
            bool1 = paramObject.startsWith(this.cGh);
            continue;
          }
          if (this.cGg.equalsIgnoreCase("ends"))
          {
            bool1 = paramObject.endsWith(this.cGh);
            continue;
          }
          if (!this.cGg.equalsIgnoreCase("rem")) {
            break label663;
          }
          bool1 = Pattern.matches(this.cGh, paramObject);
          continue;
        }
        bool1 = false;
      }
      catch (Exception paramObject)
      {
        return false;
      }
      catch (IllegalArgumentException paramObject)
      {
        return false;
      }
      label660:
      break label670;
      label663:
      boolean bool1 = false;
      continue;
      label668:
      bool1 = false;
      label670:
      return bool1;
      label672:
      bool1 = false;
      continue;
      label677:
      bool1 = false;
      continue;
      label682:
      bool1 = false;
      continue;
      label687:
      bool1 = false;
      continue;
      label692:
      bool1 = false;
      continue;
      label697:
      bool1 = false;
      continue;
      label702:
      bool1 = false;
      continue;
      label707:
      bool1 = false;
      continue;
      label712:
      bool1 = false;
      continue;
      label717:
      bool1 = false;
    }
  }
  
  public boolean isValid()
  {
    return (!this.cGf.isEmpty()) && (!this.cGg.isEmpty()) && (!this.cGh.isEmpty());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     asyu
 * JD-Core Version:    0.7.0.1
 */