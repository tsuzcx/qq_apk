import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.annotation.NonNull;
import com.tencent.biz.flatbuffers.FlatBuffersParser;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emoticon.EmojiStickerManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.UnsupportedEncodingException;
import org.json.JSONException;
import org.json.JSONObject;

public class aesg
  extends aeqp<aesf>
{
  @NonNull
  public aesf a()
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = ((QQAppInterface)localObject).getCurrentAccountUin();
    localObject = ((QQAppInterface)localObject).getApp().getSharedPreferences("sticker_pref", 0).edit();
    ((SharedPreferences.Editor)localObject).putInt("sticker_max_show_num_" + str, EmojiStickerManager.cRy);
    ((SharedPreferences.Editor)localObject).apply();
    ((SharedPreferences.Editor)localObject).putInt("sticker_max_send_num_" + str, EmojiStickerManager.cRy);
    ((SharedPreferences.Editor)localObject).commit();
    FlatBuffersParser.setEnable(true);
    return new aesf();
  }
  
  @NonNull
  public aesf a(aeic[] paramArrayOfaeic)
  {
    int j = -1;
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = localQQAppInterface.getCurrentAccountUin();
    int m = paramArrayOfaeic.length;
    int i = 0;
    if (i < m)
    {
      aeic localaeic = paramArrayOfaeic[i];
      int k = localaeic.taskId;
      if (k < j) {
        ram.e("QVipStickerProcessor", "received old task id " + k + ", latest task id: " + j);
      }
      for (;;)
      {
        i += 1;
        break;
        try
        {
          JSONObject localJSONObject = new JSONObject(new String(localaeic.content.getBytes("utf-8")));
          SharedPreferences.Editor localEditor = localQQAppInterface.getApp().getSharedPreferences("sticker_pref", 0).edit();
          if (localJSONObject.has("emojiMaxShowNum"))
          {
            EmojiStickerManager.cRB = localJSONObject.optInt("emojiMaxShowNum");
            if (EmojiStickerManager.cRB <= 0) {
              EmojiStickerManager.cRB = EmojiStickerManager.cRy;
            }
            localEditor.putInt("sticker_max_show_num_" + str, EmojiStickerManager.cRB);
            localEditor.apply();
          }
          if (localJSONObject.has("emojiMaxStickNum"))
          {
            EmojiStickerManager.cRA = localJSONObject.optInt("emojiMaxStickNum");
            if (EmojiStickerManager.cRA <= 0) {
              EmojiStickerManager.cRA = EmojiStickerManager.cRy;
            }
            localEditor.putInt("sticker_max_send_num_" + str, EmojiStickerManager.cRA);
            localEditor.commit();
          }
          if (localJSONObject.has("flatBufferEnable")) {
            if (localJSONObject.optInt("flatBufferEnable") != 1) {
              break label311;
            }
          }
          label311:
          for (boolean bool = true;; bool = false)
          {
            FlatBuffersParser.setEnable(bool);
            j = k;
            break;
          }
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          localUnsupportedEncodingException.printStackTrace();
          ram.e("QVipStickerProcessor", "item.content=" + localaeic.content + " e=" + localUnsupportedEncodingException);
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          ram.e("QVipStickerProcessor", "item.content=" + localaeic.content + " e=" + localJSONException);
        }
      }
    }
    return new aesf();
  }
  
  @NonNull
  public aesf b()
  {
    return new aesf();
  }
  
  public Class<aesf> clazz()
  {
    return aesf.class;
  }
  
  public int type()
  {
    return 189;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aesg
 * JD-Core Version:    0.7.0.1
 */