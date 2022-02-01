import android.text.TextUtils;
import android.view.View;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqv
  extends amqg
{
  public amqv.a a;
  public amqv.b a;
  public boolean cDR;
  public boolean cEb;
  public ArrayList<amqv.c> zB;
  
  public amqv(String paramString, long paramLong, List<String> paramList, UnifySearchCommon.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public amqv(String paramString, long paramLong, List<String> paramList, DynamicSearch.ResultItem paramResultItem, int paramInt)
  {
    super(paramString, paramLong, paramList, paramResultItem, paramInt);
  }
  
  public void PS(String paramString)
  {
    for (;;)
    {
      int i;
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.optInt("needRightCenter") != 1) {
          break label509;
        }
        bool = true;
        this.cEb = bool;
        JSONObject localJSONObject = paramString.optJSONObject("imageInfo");
        if (localJSONObject != null) {
          bw(localJSONObject);
        }
        localJSONObject = paramString.optJSONObject("actionInfo");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_Amqv$a = new amqv.a();
          this.jdField_a_of_type_Amqv$a.type = localJSONObject.optInt("type");
          this.jdField_a_of_type_Amqv$a.ax = localJSONObject.optString("word");
          this.jdField_a_of_type_Amqv$a.url = localJSONObject.optString("jumpUrl");
        }
        localJSONObject = paramString.optJSONObject("headIconInfo");
        if (localJSONObject != null)
        {
          this.jdField_a_of_type_Amqv$b = new amqv.b();
          this.jdField_a_of_type_Amqv$b.type = localJSONObject.optInt("type");
          this.jdField_a_of_type_Amqv$b.iconUrl = localJSONObject.optString("iconUrl");
          this.jdField_a_of_type_Amqv$b.aOw = localJSONObject.optInt("iconWidth");
          this.jdField_a_of_type_Amqv$b.BT = localJSONObject.optInt("iconHeight");
          this.jdField_a_of_type_Amqv$b.ax = localJSONObject.optString("tagText");
          this.jdField_a_of_type_Amqv$b.cbX = localJSONObject.optString("tagBgColor");
        }
        paramString = paramString.optJSONArray("lineList");
        if ((paramString != null) && (paramString.length() > 0))
        {
          i = 0;
          if (i < paramString.length())
          {
            localJSONObject = paramString.getJSONObject(i);
            amqv.c localc;
            if (!TextUtils.isEmpty(localJSONObject.optString("word")))
            {
              if (this.zB == null) {
                this.zB = new ArrayList();
              }
              localc = new amqv.c();
              localc.ax = localJSONObject.optString("word");
              localc.fontType = localJSONObject.optString("fontType", "A");
              localc.maxLines = localJSONObject.optInt("maxLines");
              if (localJSONObject.optInt("needHighlight") != 1) {
                break label514;
              }
              bool = true;
              localc.needHighLight = bool;
              this.zB.add(localc);
            }
            else if (localJSONObject.optJSONArray("words") != null)
            {
              if (this.zB == null) {
                this.zB = new ArrayList();
              }
              localc = new amqv.c();
              localc.ax = amxk.a(localJSONObject.optJSONArray("words"));
              localc.fontType = localJSONObject.optString("fontType", "A");
              localc.maxLines = localJSONObject.optInt("maxLines");
              if (localJSONObject.optInt("needHighlight") == 1)
              {
                bool = true;
                localc.needHighLight = bool;
                this.zB.add(localc);
              }
            }
          }
        }
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 0, paramString.toString());
        }
      }
      return;
      boolean bool = false;
      continue;
      i += 1;
      continue;
      label509:
      bool = false;
      continue;
      label514:
      bool = false;
    }
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    QQAppInterface localQQAppInterface;
    if (this.ajO == 1003L)
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (getUin() == null) {
        break label93;
      }
    }
    label93:
    for (paramView = getUin();; paramView = "")
    {
      anot.a(localQQAppInterface, "dc00898", "", paramView, "auth_search", "clk_content", 0, 0, "", "", "", "");
      if (this.cDR) {
        anot.a(null, "dc00898", "", "", "0X800AC12", "0X800AC12", 0, 0, "", "", "", "");
      }
      return;
    }
  }
  
  public boolean isDataValid()
  {
    return true;
  }
  
  public int jg(int paramInt)
  {
    int i = paramInt;
    switch (paramInt)
    {
    default: 
      i = 1;
    }
    return i;
  }
  
  public class a
  {
    public CharSequence ax;
    public int type;
    public String url;
    
    public a() {}
  }
  
  public class b
  {
    public int BT;
    public int aOw;
    public CharSequence ax;
    public String cbX;
    public String iconUrl;
    public int type;
    
    public b() {}
  }
  
  public class c
  {
    public CharSequence ax;
    public String fontType;
    public int maxLines;
    public boolean needHighLight;
    
    public c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqv
 * JD-Core Version:    0.7.0.1
 */