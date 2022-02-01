import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.linker.LinkerObject.1;
import java.net.URLEncoder;
import mqq.app.AppRuntime;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.json.JSONObject;

public class aypi
  implements ThreadExcutor.IThreadListener
{
  aypi.a a;
  public String aue;
  public String auf;
  public int mResultCode = -1;
  public final String mUrl;
  public String zc;
  
  public aypi(String paramString)
  {
    this.mUrl = paramString;
  }
  
  public static aypi a(String paramString)
  {
    aypi localaypi = new aypi(paramString);
    for (;;)
    {
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("LinkerObject", 2, "parse Url:" + paramString);
        }
        localObject = String.format("https://cgi.connect.qq.com/qqconnectopen/get_urlinfoForQQV2?url=%2$s&uin=%1$s&req_from=riji", new Object[] { BaseApplicationImpl.getApplication().getRuntime().getAccount(), URLEncoder.encode(paramString) });
        localObject = jqc.a(BaseApplicationImpl.getApplication().getApplicationContext(), (String)localObject, null, "GET", null, null, 10000, 10000);
        int i;
        if ((localObject != null) && (((HttpResponse)localObject).getStatusLine().getStatusCode() == 200))
        {
          localObject = new JSONObject(jqc.a((HttpResponse)localObject));
          i = Integer.parseInt(((JSONObject)localObject).getString("ret"));
          if (i == 0)
          {
            str = ((JSONObject)localObject).getString("title");
            if (!TextUtils.isEmpty(str)) {
              localaypi.zc = str;
            }
            str = ((JSONObject)localObject).getString("abstract");
            if (!TextUtils.isEmpty(str)) {
              localaypi.aue = str;
            }
            localaypi.mResultCode = 0;
            if (!((JSONObject)localObject).has("errTypeCode")) {
              break label357;
            }
            str = "2";
            localObject = ((JSONObject)localObject).getString("errTypeCode");
            rar.a("video_edit", "url_rich", 0, 0, new String[] { str, localObject, paramString });
          }
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("LinkerObject", 2, "parse result,mResultCode:" + localaypi.mResultCode + ",mShareTitle:" + localaypi.zc + ",mShareDesc:" + localaypi.aue + ",mShareThumb:" + localaypi.auf);
          return localaypi;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.i("LinkerObject", 2, "parse fail,reportServerCode:" + i + ",json:" + localObject);
        continue;
        String str = "1";
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
        return localaypi;
      }
      label357:
      Object localObject = null;
    }
    return localaypi;
  }
  
  public void a(aypi.a parama)
  {
    this.a = parama;
  }
  
  public boolean jQ()
  {
    return (!TextUtils.isEmpty(this.mUrl)) && (!TextUtils.isEmpty(this.zc)) && (!TextUtils.isEmpty(this.aue));
  }
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    if (this.a != null)
    {
      if (this.mResultCode == 0) {
        this.a.b(this);
      }
    }
    else {
      return;
    }
    this.a.a(this, this.mResultCode);
  }
  
  public void onPreRun() {}
  
  public void parseUrl(String paramString)
  {
    ThreadManagerV2.excute(new LinkerObject.1(this, paramString), 128, this, true);
  }
  
  public static abstract interface a
  {
    public abstract void a(aypi paramaypi, int paramInt);
    
    public abstract void b(aypi paramaypi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aypi
 * JD-Core Version:    0.7.0.1
 */