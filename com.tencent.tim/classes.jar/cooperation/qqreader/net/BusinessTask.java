package cooperation.qqreader.net;

import android.support.annotation.NonNull;
import com.tencent.util.Pair;
import java.util.HashMap;

public class BusinessTask
  extends BaseCgiTask
{
  private String bPP;
  private Pair<Integer, Integer> o;
  
  public BusinessTask(String paramString)
  {
    this.bPP = paramString;
  }
  
  public BusinessTask(String paramString, @NonNull Pair<Integer, Integer> paramPair)
  {
    this.bPP = paramString;
    this.o = paramPair;
  }
  
  protected BaseCgiTask.RequestType a()
  {
    return BaseCgiTask.RequestType.GET;
  }
  
  protected HashMap<String, String> getHeaders()
  {
    return f();
  }
  
  protected String getUrl()
  {
    if ("GetEnterShelfOnOffTask".equals(this.bPP)) {
      return "https://app.books.qq.com/webapp/json/reader_webapp_config/GetEnterShelfOnOff";
    }
    if ("QueryUserGrayUpdateStateTask".equals(this.bPP)) {
      return "https://app.books.qq.com/webapp/json/reader_webapp_update/IsUserGrayRelease";
    }
    if ("UpdateToQQBookstoreTask".equals(this.bPP)) {
      return "https://app.books.qq.com/webapp/json/reader_webapp_update/UpdateToQQBookstore";
    }
    if ("ZzConfigDataTask".equals(this.bPP)) {
      return "https://app.books.qq.com/webapp/meteor?flag1=" + this.o.first + "&flag2=" + this.o.second;
    }
    if ("ReaderShadowGray".endsWith(this.bPP)) {
      return "https://app.books.qq.com/webapp/meteor_is_gray_user?flag1=" + this.o.first + "&flag2=" + this.o.second;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.net.BusinessTask
 * JD-Core Version:    0.7.0.1
 */