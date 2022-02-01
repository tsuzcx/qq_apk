import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class wgv
{
  public int a;
  public long a;
  public bdvs a;
  public MessageForShortVideo a;
  public String a;
  public Map<String, Object> a;
  public wgo a;
  public wgu a;
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
  
  public wgv()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static wgv a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static wgv a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static wgv a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    wgv localwgv = new wgv();
    StoryVideoItem localStoryVideoItem = ((wpj)wpm.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localwgv.e = wgw.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localwgv.f = wgw.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localwgv.jdField_b_of_type_Int = 0;
      localwgv.jdField_b_of_type_JavaLangString = paramString1;
      localwgv.jdField_a_of_type_Int = paramInt;
      localwgv.jdField_a_of_type_JavaLangString = a(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localwgv.jdField_c_of_type_JavaLangString = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localwgv.jdField_d_of_type_JavaLangString = paramString2;
      localwgv.jdField_c_of_type_Boolean = paramBoolean;
      return localwgv;
      localwgv.e = wgw.a(paramString1, paramInt, false, false);
      localwgv.f = wgw.a(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof wgv))
    {
      paramObject = (wgv)paramObject;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileType=" + wes.a(this.jdField_a_of_type_Int) + ", status=" + this.jdField_b_of_type_Int + ", downloadUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", localPath='" + this.e + '\'' + ", localTmpPath='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wgv
 * JD-Core Version:    0.7.0.1
 */