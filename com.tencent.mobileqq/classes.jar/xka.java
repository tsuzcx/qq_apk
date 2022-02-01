import android.util.SparseArray;
import com.tencent.biz.qqstory.playvideo.player.StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.2;
import com.tencent.biz.qqstory.utils.JsonORM;
import com.tencent.biz.qqstory.utils.JsonORM.JsonParseException;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class xka
  extends xkd
{
  public static final SparseArray<String> a;
  public static String[] a;
  public static String[] b = { "UNKNOWN", "SYSTEM", "SELF" };
  private xjz jdField_a_of_type_Xjz;
  private xkd jdField_a_of_type_Xkd;
  
  static
  {
    jdField_a_of_type_AndroidUtilSparseArray = new xkb();
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "UNKNOWN", "SOFTWARE_DEC", "OMX_HW_DEC", "STAGEFRIGHT_HW_DEC", "MEDIACODEC_HW_DEC", "MEDIACODEC_GLRENDER_DEC" };
  }
  
  public xka(xjz paramxjz)
  {
    this.jdField_a_of_type_Xjz = paramxjz;
  }
  
  public void OnDownloadCallback(String paramString)
  {
    try
    {
      xkc localxkc = (xkc)JsonORM.a(new JSONObject(paramString), xkc.class);
      if (localxkc == null)
      {
        ykq.d("StoryPlayerTVKWrapper", "OnDownloadCallback. %s", new Object[] { paramString });
        if (this.jdField_a_of_type_Xkd != null) {
          this.jdField_a_of_type_Xkd.OnDownloadCallback(paramString);
        }
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
      for (;;)
      {
        localJSONException.printStackTrace();
        Object localObject2 = null;
        continue;
        switch (localObject2.d)
        {
        default: 
          ykq.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 未知. %s", new Object[] { paramString });
          break;
        case 1: 
          ykq.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 文件大小. %s", new Object[] { paramString });
          break;
        case 2: 
          ykq.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 下载 progress. offset = %d / %d, speedKBS = %d, clipNo = %d", new Object[] { Integer.valueOf(localObject2.c), Long.valueOf(localObject2.jdField_a_of_type_Long), Integer.valueOf(localObject2.b), Integer.valueOf(localObject2.jdField_a_of_type_Int) });
          this.jdField_a_of_type_Xjz.jdField_a_of_type_Long = localObject2.jdField_a_of_type_Long;
          this.jdField_a_of_type_Xjz.jdField_a_of_type_JavaUtilArrayList.add(Integer.valueOf(localObject2.b));
          break;
        case 3: 
          ykq.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 下载 DONE.");
          break;
        case 4: 
        case 5: 
        case 6: 
          ykq.e("StoryPlayerTVKWrapper", "OnDownloadCallback. 下载出错. errorCode=%d, errorDetailCode=%d, errorMsg=%s", new Object[] { Integer.valueOf(localObject2.e), Integer.valueOf(localObject2.f), localObject2.jdField_a_of_type_JavaLangString });
          break;
        case 7: 
          ykq.d("StoryPlayerTVKWrapper", "OnDownloadCallback. 存储文件完整下载完成.");
        }
      }
    }
  }
  
  public void onCompletion(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ykq.b("StoryPlayerTVKWrapper", "onCompletion");
    if (this.jdField_a_of_type_Xkd != null) {
      this.jdField_a_of_type_Xkd.onCompletion(paramTVK_IMediaPlayer);
    }
  }
  
  public boolean onError(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt1, int paramInt2, int paramInt3, String paramString, Object paramObject)
  {
    boolean bool = false;
    ykq.e("StoryPlayerTVKWrapper", "onError. model=%d, what=%d, position=%d, extra=%s, info=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), paramString, paramObject });
    if (this.jdField_a_of_type_Xkd != null) {
      bool = this.jdField_a_of_type_Xkd.onError(paramTVK_IMediaPlayer, paramInt1, paramInt2, paramInt3, paramString, paramObject);
    }
    return bool;
  }
  
  public boolean onInfo(TVK_IMediaPlayer paramTVK_IMediaPlayer, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      ykq.d("StoryPlayerTVKWrapper", "onInfo. what=%d (%s), extra=%s", new Object[] { Integer.valueOf(paramInt), jdField_a_of_type_AndroidUtilSparseArray.get(paramInt, "UNKNOWN"), paramObject });
    }
    while (this.jdField_a_of_type_Xkd != null)
    {
      return this.jdField_a_of_type_Xkd.onInfo(paramTVK_IMediaPlayer, paramInt, paramObject);
      int i = ((Integer)paramObject).intValue();
      if ((i >= 0) && (i <= b.length))
      {
        ykq.d("StoryPlayerTVKWrapper", "onInfo. playerType %s", new Object[] { b[i] });
      }
      else
      {
        ykq.d("StoryPlayerTVKWrapper", "onInfo. playerType %d", new Object[] { Integer.valueOf(i) });
        continue;
        ykq.d("StoryPlayerTVKWrapper", "onInfo. start buffering");
        continue;
        ykq.d("StoryPlayerTVKWrapper", "onInfo. end buffering");
        continue;
        i = ((Integer)paramObject).intValue();
        if ((i >= 0) && (i < jdField_a_of_type_ArrayOfJavaLangString.length)) {
          ykq.d("StoryPlayerTVKWrapper", "onInfo. set decoder. %s", new Object[] { jdField_a_of_type_ArrayOfJavaLangString[i] });
        } else {
          ykq.d("StoryPlayerTVKWrapper", "onInfo. set decoder. %d", new Object[] { Integer.valueOf(i) });
        }
      }
    }
    return false;
  }
  
  public void onVideoPrepared(TVK_IMediaPlayer paramTVK_IMediaPlayer)
  {
    ykq.d("StoryPlayerTVKWrapper", "onVideoPrepared");
    if (this.jdField_a_of_type_Xkd != null) {
      this.jdField_a_of_type_Xkd.onVideoPrepared(paramTVK_IMediaPlayer);
    }
    ThreadManager.executeOnSubThread(new StoryPlayerTVKWrapper.TVKSDKOnEventBaseListener.2(this, paramTVK_IMediaPlayer));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xka
 * JD-Core Version:    0.7.0.1
 */