import android.app.Activity;
import java.lang.ref.WeakReference;
import java.net.URLDecoder;
import org.json.JSONObject;

public class aobz
  implements acci
{
  public WeakReference<Activity> mActivityReference;
  
  public aobz(Activity paramActivity)
  {
    this.mActivityReference = new WeakReference(paramActivity);
  }
  
  public void RZ(int paramInt) {}
  
  public void aI(boolean paramBoolean, String paramString) {}
  
  public void dCc() {}
  
  public void gQ(String paramString1, String paramString2) {}
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    switch (paramInt)
    {
    }
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
              do
              {
                return;
              } while (paramObject == null);
              paramObject = (Object[])paramObject;
            } while (paramObject.length != 2);
            gQ((String)paramObject[0], (String)paramObject[1]);
            return;
            dCc();
            return;
          } while (paramObject == null);
          paramObject = (Object[])paramObject;
        } while (paramObject.length != 1);
        try
        {
          paramObject = (JSONObject)paramObject[0];
          String str = paramObject.optString("url");
          paramInt = paramObject.optInt("ret");
          paramObject = URLDecoder.decode(str, "UTF-8");
          if ((paramInt == 0) && (paramObject.length() > 0))
          {
            aI(paramBoolean, paramObject);
            return;
          }
        }
        catch (Exception paramObject)
        {
          paramObject.printStackTrace();
          gQ(paramObject.toString(), "");
          return;
        }
        gQ(paramInt + "", "");
        return;
      } while (paramObject == null);
      paramObject = (Object[])paramObject;
    } while (paramObject.length != 1);
    RZ(((Integer)paramObject[0]).intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aobz
 * JD-Core Version:    0.7.0.1
 */