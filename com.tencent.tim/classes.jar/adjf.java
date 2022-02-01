import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class adjf
  implements jox
{
  adjf(adjd paramadjd, adjd.a parama, ArrayList paramArrayList, adja.b paramb) {}
  
  public void loaded(String paramString, int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline package finish, code = " + paramInt + "param1" + paramString);
    if (paramInt == 0) {
      if (paramString == null) {
        if (this.a != null)
        {
          this.ux.remove(this.jdField_b_of_type_Adja$b);
          if (this.ux.size() == 0)
          {
            this.a.Gl(true);
            this.a.bs(4, true);
            this.jdField_b_of_type_Adjd.uo();
          }
        }
      }
    }
    label244:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              for (;;)
              {
                return;
                try
                {
                  paramString = new JSONObject(paramString);
                  if (!paramString.has("data")) {
                    break label244;
                  }
                  paramString = paramString.getJSONArray("data");
                  if (((paramString.length() == 0) || (!paramString.getJSONObject(0).has("bid"))) || (this.a != null))
                  {
                    this.ux.remove(this.jdField_b_of_type_Adja$b);
                    if (this.ux.size() == 0)
                    {
                      this.a.Gl(true);
                      this.a.bs(4, true);
                      this.jdField_b_of_type_Adjd.uo();
                      return;
                    }
                  }
                }
                catch (JSONException paramString)
                {
                  paramString.printStackTrace();
                }
              }
            } while (this.a == null);
            this.a.Gl(false);
            this.a.bs(4, false);
            this.jdField_b_of_type_Adjd.uo();
            return;
            paramString = this.a;
          } while (paramString == null);
          return;
          if (paramInt != 7) {
            break;
          }
        } while (this.a == null);
        this.ux.remove(this.jdField_b_of_type_Adja$b);
      } while (this.ux.size() != 0);
      this.a.Gl(true);
      this.a.bs(4, true);
      this.jdField_b_of_type_Adjd.uo();
      return;
    } while (this.a == null);
    this.a.Gl(false);
    this.a.bs(4, false);
    this.jdField_b_of_type_Adjd.uo();
  }
  
  public void progress(int paramInt)
  {
    QLog.d("AREngine_ARResourceManagerTools", 2, "Load offline progress  = " + paramInt);
    if (this.a != null) {
      this.a.KV(adjd.a(this.jdField_b_of_type_Adjd, 0L, paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjf
 * JD-Core Version:    0.7.0.1
 */