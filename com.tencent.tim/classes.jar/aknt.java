import android.text.TextUtils;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.OcrItem;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrDetail;
import com.tencent.mobileqq.ar.arcloud.pb.YoutuOcr.YoutuOcrRsp;
import com.tencent.mobileqq.ocr.data.OcrRecogResult;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class aknt
{
  public aknt.a a;
  
  private static String K(List<YoutuOcr.OcrItem> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0))
    {
      QLog.d("Q.ocr", 1, "typeSetting regoc items is null");
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      String str = ((YoutuOcr.OcrItem)paramList.next()).itemstring.get();
      if (!TextUtils.isEmpty(str)) {
        localStringBuilder.append(str).append("\n");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static aknt.a a(YoutuOcr.YoutuOcrRsp paramYoutuOcrRsp)
  {
    aknt.a locala = new aknt.a();
    int i;
    Object localObject;
    if (paramYoutuOcrRsp.youtu_ocr_errorcode.has())
    {
      i = paramYoutuOcrRsp.youtu_ocr_errorcode.get();
      locala.cGS = i;
      if (!paramYoutuOcrRsp.youtu_ocr_errormsg.has()) {
        break label215;
      }
      localObject = paramYoutuOcrRsp.youtu_ocr_errormsg.get();
      label49:
      locala.btk = ((String)localObject);
      if (paramYoutuOcrRsp.youtu_orc_detail.has())
      {
        localObject = (YoutuOcr.YoutuOcrDetail)paramYoutuOcrRsp.youtu_orc_detail.get();
        if (!((YoutuOcr.YoutuOcrDetail)localObject).errorcode.has()) {
          break label221;
        }
        i = ((YoutuOcr.YoutuOcrDetail)localObject).errorcode.get();
        label93:
        locala.errCode = i;
        if (!((YoutuOcr.YoutuOcrDetail)localObject).errormsg.has()) {
          break label226;
        }
        paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).errormsg.get();
        label116:
        locala.errMsg = paramYoutuOcrRsp;
        if (((YoutuOcr.YoutuOcrDetail)localObject).language.has()) {
          locala.language = ((YoutuOcr.YoutuOcrDetail)localObject).language.get();
        }
        if (((YoutuOcr.YoutuOcrDetail)localObject).ocr_language_list.has())
        {
          locala.yl = new ArrayList();
          locala.yl.addAll(((YoutuOcr.YoutuOcrDetail)localObject).ocr_language_list.get());
        }
        if (!((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.has()) {
          break label232;
        }
      }
    }
    label215:
    label221:
    label226:
    label232:
    for (paramYoutuOcrRsp = ((YoutuOcr.YoutuOcrDetail)localObject).ocr_item.get();; paramYoutuOcrRsp = null)
    {
      if (paramYoutuOcrRsp != null) {
        locala.content = K(paramYoutuOcrRsp);
      }
      return locala;
      i = 0;
      break;
      localObject = "";
      break label49;
      i = -1;
      break label93;
      paramYoutuOcrRsp = "";
      break label116;
    }
  }
  
  public OcrRecogResult a()
  {
    Object localObject;
    if ((this.a == null) || (TextUtils.isEmpty(this.a.content))) {
      localObject = null;
    }
    OcrRecogResult localOcrRecogResult;
    do
    {
      return localObject;
      localOcrRecogResult = new OcrRecogResult();
      if (this.a != null)
      {
        localOcrRecogResult.language = this.a.language;
        localOcrRecogResult.ocrContent = this.a.content;
        localOcrRecogResult.ocr_languages = this.a.yl;
      }
      localObject = localOcrRecogResult;
    } while (!QLog.isColorLevel());
    QLog.d("Q.ocr", 2, "getUIData " + localOcrRecogResult);
    return localOcrRecogResult;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("mOcrResult:").append(this.a);
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public String btk;
    public int cGS;
    public String content;
    public int errCode;
    public String errMsg;
    public String language;
    public String sessionId;
    public ArrayList<String> yl;
    
    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ssoErrCode:").append(this.cGS).append(",ssoErrMsg:").append(this.btk).append(",errCode:").append(this.errCode).append(",errMsg:").append(this.errMsg).append(",session_id:").append(this.sessionId).append(",content:").append(this.content).append(",language").append(this.language).append(",ocr_language_list").append(this.yl);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aknt
 * JD-Core Version:    0.7.0.1
 */