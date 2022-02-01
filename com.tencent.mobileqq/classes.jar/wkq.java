import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class wkq
{
  public int a;
  public long a;
  public beum a;
  public MessageForShortVideo a;
  public String a;
  public Map<String, Object> a;
  public wkj a;
  public wkp a;
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
  
  public wkq()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static wkq a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static wkq a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static wkq a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    wkq localwkq = new wkq();
    StoryVideoItem localStoryVideoItem = ((wte)wth.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localwkq.e = wkr.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localwkq.f = wkr.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localwkq.jdField_b_of_type_Int = 0;
      localwkq.jdField_b_of_type_JavaLangString = paramString1;
      localwkq.jdField_a_of_type_Int = paramInt;
      localwkq.jdField_a_of_type_JavaLangString = a(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localwkq.jdField_c_of_type_JavaLangString = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localwkq.jdField_d_of_type_JavaLangString = paramString2;
      localwkq.jdField_c_of_type_Boolean = paramBoolean;
      return localwkq;
      localwkq.e = wkr.a(paramString1, paramInt, false, false);
      localwkq.f = wkr.a(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof wkq))
    {
      paramObject = (wkq)paramObject;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileType=" + win.a(this.jdField_a_of_type_Int) + ", status=" + this.jdField_b_of_type_Int + ", downloadUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", localPath='" + this.e + '\'' + ", localTmpPath='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wkq
 * JD-Core Version:    0.7.0.1
 */