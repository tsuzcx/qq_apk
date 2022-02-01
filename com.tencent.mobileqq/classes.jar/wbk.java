import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class wbk
{
  public int a;
  public long a;
  public MessageForShortVideo a;
  public HttpNetReq a;
  public String a;
  public Map<String, Object> a;
  public wbd a;
  public wbj a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g = 1;
  
  public wbk()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static wbk a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static wbk a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static wbk a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    wbk localwbk = new wbk();
    StoryVideoItem localStoryVideoItem = ((wjp)wjs.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localwbk.e = wbl.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localwbk.f = wbl.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localwbk.jdField_b_of_type_Int = 0;
      localwbk.jdField_b_of_type_JavaLangString = paramString1;
      localwbk.jdField_a_of_type_Int = paramInt;
      localwbk.jdField_a_of_type_JavaLangString = a(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localwbk.jdField_c_of_type_JavaLangString = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localwbk.jdField_d_of_type_JavaLangString = paramString2;
      localwbk.jdField_c_of_type_Boolean = paramBoolean;
      return localwbk;
      localwbk.e = wbl.a(paramString1, paramInt, false, false);
      localwbk.f = wbl.a(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof wbk))
    {
      paramObject = (wbk)paramObject;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileType=" + vzh.a(this.jdField_a_of_type_Int) + ", status=" + this.jdField_b_of_type_Int + ", downloadUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", localPath='" + this.e + '\'' + ", localTmpPath='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wbk
 * JD-Core Version:    0.7.0.1
 */