import android.annotation.TargetApi;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.transfile.HttpNetReq;
import java.util.HashMap;
import java.util.Map;

@TargetApi(14)
public class vmp
{
  public int a;
  public long a;
  public MessageForShortVideo a;
  public HttpNetReq a;
  public String a;
  public Map<String, Object> a;
  public vmi a;
  public vmo a;
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
  
  public vmp()
  {
    this.jdField_d_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public static String a(String paramString, int paramInt)
  {
    return paramInt + "_" + paramString;
  }
  
  public static vmp a(String paramString, int paramInt)
  {
    return a(paramString, null, paramInt, false);
  }
  
  public static vmp a(String paramString, int paramInt, boolean paramBoolean)
  {
    return a(paramString, null, paramInt, paramBoolean);
  }
  
  private static vmp a(String paramString1, String paramString2, int paramInt, boolean paramBoolean)
  {
    vmp localvmp = new vmp();
    StoryVideoItem localStoryVideoItem = ((vuu)vux.a(5)).a(paramString1);
    if ((localStoryVideoItem != null) && (localStoryVideoItem.isMine()))
    {
      localvmp.e = vmq.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, false, false);
      localvmp.f = vmq.a(paramString1, localStoryVideoItem.mCreateTime, paramInt, true, false);
      localvmp.jdField_b_of_type_Int = 0;
      localvmp.jdField_b_of_type_JavaLangString = paramString1;
      localvmp.jdField_a_of_type_Int = paramInt;
      localvmp.jdField_a_of_type_JavaLangString = a(paramString1, paramInt);
      if (!paramBoolean) {
        break label159;
      }
    }
    label159:
    for (paramString1 = "";; paramString1 = paramString2)
    {
      localvmp.jdField_c_of_type_JavaLangString = paramString1;
      if (paramBoolean) {
        paramString2 = "";
      }
      localvmp.jdField_d_of_type_JavaLangString = paramString2;
      localvmp.jdField_c_of_type_Boolean = paramBoolean;
      return localvmp;
      localvmp.e = vmq.a(paramString1, paramInt, false, false);
      localvmp.f = vmq.a(paramString1, paramInt, true, false);
      break;
    }
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof vmp))
    {
      paramObject = (vmp)paramObject;
      if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) {
        return true;
      }
    }
    return false;
  }
  
  public String toString()
  {
    return "DownloadTask{vid='" + this.jdField_b_of_type_JavaLangString + '\'' + ", fileType=" + vkm.a(this.jdField_a_of_type_Int) + ", status=" + this.jdField_b_of_type_Int + ", downloadUrl='" + this.jdField_d_of_type_JavaLangString + '\'' + ", localPath='" + this.e + '\'' + ", localTmpPath='" + this.f + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vmp
 * JD-Core Version:    0.7.0.1
 */