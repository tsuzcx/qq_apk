import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer.OnDownloadCallbackListener;
import java.io.File;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

class vtb
  implements TVK_IMediaPlayer.OnDownloadCallbackListener
{
  vtb(vsv paramvsv) {}
  
  public void OnDownloadCallback(String paramString)
  {
    wsv.a(this.a.jdField_a_of_type_JavaLangString, "on tvk download callback. %s", paramString);
    do
    {
      do
      {
        Object localObject2;
        try
        {
          vsh localvsh = (vsh)JsonORM.a(new JSONObject(paramString), vsh.class);
          if (localvsh == null)
          {
            wsv.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback fail. %s", new Object[] { paramString });
            return;
          }
        }
        catch (JsonORM.JsonParseException localJsonParseException)
        {
          for (;;)
          {
            localJsonParseException.printStackTrace();
            Object localObject1 = null;
          }
        }
        catch (JSONException localJSONException)
        {
          do
          {
            for (;;)
            {
              localJSONException.printStackTrace();
              localObject2 = null;
            }
            switch (localObject2.d)
            {
            default: 
              wsv.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 未知. %s", new Object[] { paramString });
              return;
            case 1: 
              wsv.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 文件大小. %s", new Object[] { paramString });
              return;
            case 2: 
              wsv.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载 progress. offset = %d / %d, speedKBS = %d, clipNo = %d", new Object[] { Integer.valueOf(localObject2.c), Long.valueOf(localObject2.jdField_a_of_type_Long), Integer.valueOf(localObject2.b), Integer.valueOf(localObject2.jdField_a_of_type_Int) });
              vsv.a(this.a).jdField_a_of_type_Long = localObject2.jdField_a_of_type_Long;
              vsv.a(this.a).jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localObject2.b));
            }
          } while ((TextUtils.isEmpty(this.a.c)) || (this.a.jdField_a_of_type_Vrt == null));
          this.a.jdField_a_of_type_Vrt.a(this.a.d, new File(this.a.c), localObject2.c, null);
          return;
          wsv.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载 DONE.");
          return;
        }
        wsv.e(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 下载出错. errorCode=%d, errorDetailCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(localObject2.e), Integer.valueOf(localObject2.f), localObject2.jdField_a_of_type_JavaLangString });
        this.a.jdField_a_of_type_Vrt.a(this.a.b, this.a.d, localObject2.e);
        return;
        wsv.d(this.a.jdField_a_of_type_JavaLangString, "OnDownloadCallback. 存储文件完整下载完成.");
        if (TextUtils.isEmpty(this.a.c)) {
          break;
        }
      } while (this.a.jdField_a_of_type_Vrt == null);
      this.a.jdField_a_of_type_Vrt.a(this.a.b, this.a.d, new File(this.a.c));
      return;
    } while (this.a.jdField_a_of_type_Vrt == null);
    this.a.jdField_a_of_type_Vrt.a(this.a.b, this.a.d, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vtb
 * JD-Core Version:    0.7.0.1
 */