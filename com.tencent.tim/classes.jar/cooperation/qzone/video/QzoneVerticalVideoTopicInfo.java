package cooperation.qzone.video;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.webkit.URLUtil;
import awec;
import cooperation.qzone.util.QZLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class QzoneVerticalVideoTopicInfo
  implements Parcelable
{
  public static final Parcelable.Creator<QzoneVerticalVideoTopicInfo> CREATOR = new awec();
  private String TAG = QzoneVerticalVideoTopicInfo.class.getSimpleName();
  private String cPu;
  private String feedId;
  private String fileId;
  private String musicId;
  private String musicUrl;
  private String thumbUrl;
  private String topicId;
  private String topicName;
  
  public String GS()
  {
    return this.cPu;
  }
  
  public String GT()
  {
    return this.musicUrl;
  }
  
  public String GU()
  {
    if (!TextUtils.isEmpty(this.topicName)) {
      return this.topicName;
    }
    return this.cPu;
  }
  
  public String GV()
  {
    Object localObject;
    if ((TextUtils.isEmpty(this.thumbUrl)) || (URLUtil.isHttpUrl(this.thumbUrl)) || (URLUtil.isHttpsUrl(this.thumbUrl))) {
      localObject = this.thumbUrl;
    }
    String str;
    do
    {
      do
      {
        return localObject;
        localObject = Pattern.compile("img:(.*?),").matcher(this.thumbUrl);
        if (!((Matcher)localObject).find()) {
          break;
        }
        str = ((Matcher)localObject).group().replace("img:", "").replace(",", "");
        localObject = str;
      } while (URLUtil.isHttpUrl(str));
      localObject = str;
    } while (URLUtil.isHttpsUrl(str));
    return null;
  }
  
  public QzoneVerticalVideoTopicInfo a(String paramString)
  {
    this.musicId = paramString;
    return this;
  }
  
  public boolean ags()
  {
    return (!TextUtils.isEmpty(this.musicUrl)) && (!TextUtils.isEmpty(this.cPu));
  }
  
  public QzoneVerticalVideoTopicInfo b(String paramString)
  {
    this.cPu = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo c(String paramString)
  {
    this.musicUrl = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo d(String paramString)
  {
    this.thumbUrl = paramString;
    return this;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public QzoneVerticalVideoTopicInfo e(String paramString)
  {
    this.topicId = paramString;
    return this;
  }
  
  public QzoneVerticalVideoTopicInfo f(String paramString)
  {
    this.topicName = paramString;
    return this;
  }
  
  public String getMusicId()
  {
    return this.musicId;
  }
  
  public String getTopicId()
  {
    return this.topicId;
  }
  
  public String toJSONString()
  {
    a locala = new a();
    locala.a("weishi_feedId", this.feedId).a("weishi_fileId", this.fileId).a("weishi_musicId", this.musicId).a("weishi_musicName", this.cPu).a("weishi_thumbUrl", this.thumbUrl).a("weishi_topicID", this.topicId).a("weishi_topicName", this.topicName);
    return locala.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.feedId);
    paramParcel.writeString(this.fileId);
    paramParcel.writeString(this.musicId);
    paramParcel.writeString(this.cPu);
    paramParcel.writeString(this.musicUrl);
    paramParcel.writeString(this.thumbUrl);
    paramParcel.writeString(this.topicId);
    paramParcel.writeString(this.topicName);
  }
  
  class a
    extends JSONObject
  {
    a() {}
    
    public a a(String paramString1, String paramString2)
    {
      if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
        return this;
      }
      try
      {
        put(paramString1, paramString2);
        return this;
      }
      catch (JSONException paramString1)
      {
        QZLog.d(QzoneVerticalVideoTopicInfo.a(QzoneVerticalVideoTopicInfo.this), 2, "put JSON error", paramString1);
      }
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.video.QzoneVerticalVideoTopicInfo
 * JD-Core Version:    0.7.0.1
 */