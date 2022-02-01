import android.graphics.Point;
import android.graphics.Rect;
import android.text.TextUtils;
import com.tencent.av.business.manager.magicface.MagicfaceDataAudioJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataPendantJason;
import com.tencent.av.business.manager.magicface.MagicfaceDataVideoJason;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class ijz
{
  protected MagicfaceDataAudioJason a;
  protected MagicfaceDataVideoJason a;
  protected int anV;
  protected int anW;
  protected Map<String, MagicfaceDataPendantJason> cR;
  protected String mTaskId;
  protected String mType;
  protected Rect rect;
  
  public ijz(String paramString1, String paramString2, String paramString3)
  {
    igd.aJ("AVMagicfaceData", "init|config=" + paramString2 + "|" + paramString3 + "|" + paramString1);
    this.mTaskId = paramString2;
    this.mType = paramString3;
    try
    {
      paramString1 = new JSONObject(paramString1);
      paramString2 = paramString1.getJSONObject("video");
      this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason = ((MagicfaceDataVideoJason)aqec.convertFrom(paramString2, MagicfaceDataVideoJason.class));
      int i;
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason != null)
      {
        if (!"voicesticker".equals(paramString3))
        {
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_x > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.location_x *= 2;
          }
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_y > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.location_y *= 2;
          }
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.width *= 2;
          }
          if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height > 0)
          {
            paramString3 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason;
            paramString3.height *= 2;
          }
        }
        paramString2 = paramString2.optJSONArray("locations");
        if (paramString2 != null)
        {
          i = 0;
          while (i < paramString2.length())
          {
            paramString3 = (JSONObject)paramString2.get(i);
            this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.pointArrayList.add(new Point(paramString3.optInt("x"), paramString3.optInt("y")));
            i += 1;
          }
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.pointArrayList.add(new Point(this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_x, this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.location_y));
      }
      if (paramString1.has("audio")) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason = ((MagicfaceDataAudioJason)aqec.convertFrom(paramString1.getJSONObject("audio"), MagicfaceDataAudioJason.class));
      }
      this.cR = new HashMap();
      if (paramString1.has("pendant"))
      {
        paramString1 = paramString1.getJSONArray("pendant");
        i = j;
        while (i < paramString1.length())
        {
          paramString2 = (MagicfaceDataPendantJason)aqec.convertFrom((JSONObject)paramString1.get(i), MagicfaceDataPendantJason.class);
          if ((paramString2 != null) && (!TextUtils.isEmpty(paramString2.name)))
          {
            igd.aL("AVMagicfaceData", "Pendant: " + paramString2.toString());
            paramString2.duration *= 1000;
            this.cR.put(paramString2.name, paramString2);
          }
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString1)
    {
      paramString1.printStackTrace();
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason == null)
      {
        igd.aL("AVMagicfaceData", "MagicfaceData error!");
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason = new MagicfaceDataVideoJason();
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason == null) {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason = new MagicfaceDataAudioJason();
      }
      if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.persistent)
      {
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.repeat_count = 50000;
        if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count == 0) {
          this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count = 3;
        }
        this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataAudioJason.is_repeat = true;
      }
      igd.aL("AVMagicfaceData", "MagicfaceData:: " + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.toString());
      this.anV = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.frame_count;
      paramString1 = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.getLocation(-1);
      this.rect = new Rect(paramString1.x, paramString1.y, paramString1.x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width, paramString1.y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height);
    }
  }
  
  public boolean a(ijz paramijz)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramijz != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(this.mType)) {
        if ((!TextUtils.isEmpty(paramijz.mType)) && (!paramijz.mType.equalsIgnoreCase("face")))
        {
          bool1 = bool2;
          if (!paramijz.mType.equalsIgnoreCase("voicesticker")) {}
        }
        else
        {
          bool1 = bool2;
          if (this.mType.equalsIgnoreCase("pendant")) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  protected abstract String aI(int paramInt);
  
  protected abstract void bw(int paramInt1, int paramInt2);
  
  int cq(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason == null) {
      return paramInt;
    }
    Point localPoint = this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.getLocation(paramInt);
    this.rect = new Rect(localPoint.x, localPoint.y, localPoint.x + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.width, localPoint.y + this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.height);
    return this.jdField_a_of_type_ComTencentAvBusinessManagerMagicfaceMagicfaceDataVideoJason.lastLocationIndex;
  }
  
  public String getId()
  {
    return this.mTaskId;
  }
  
  public boolean isPersistent()
  {
    return this.mType.equalsIgnoreCase("pendant");
  }
  
  protected abstract int kR();
  
  protected abstract void start();
  
  public abstract void stop();
  
  public String toString()
  {
    return "Id[" + this.mTaskId + "], type[" + this.mType + "]";
  }
  
  public boolean ty()
  {
    return (this.mType.equalsIgnoreCase("face")) || (this.mType.equalsIgnoreCase("voicesticker"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ijz
 * JD-Core Version:    0.7.0.1
 */