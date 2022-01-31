import android.app.Activity;
import com.tencent.biz.qqstory.takevideo.slideshow.SlideItemInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class xnd
{
  private static String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "SlideShowUtils";
  }
  
  public static String a()
  {
    String str = "" + System.currentTimeMillis();
    str = alof.aX + "multipicset/" + str + "/" + str + ".mp4";
    File localFile = new File(str);
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    return str;
  }
  
  public static String a(long paramLong)
  {
    paramLong /= 1000L;
    int i = (int)paramLong % 60;
    int j = (int)paramLong / 60;
    String str1;
    if (i > 9)
    {
      str1 = String.valueOf(i);
      if (j <= 9) {
        break label102;
      }
    }
    label102:
    for (String str2 = String.valueOf(j);; str2 = "0" + String.valueOf(j))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str2).append(":").append(str1);
      return localStringBuilder.toString();
      str1 = "0" + String.valueOf(i);
      break;
    }
  }
  
  public static List<String> a(List<SlideItemInfo> paramList)
  {
    if (paramList == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      SlideItemInfo localSlideItemInfo = (SlideItemInfo)paramList.next();
      if (localSlideItemInfo != null) {
        localArrayList.add(localSlideItemInfo.jdField_b_of_type_JavaLangString);
      }
    }
    return localArrayList;
  }
  
  public static List<SlideItemInfo> a(List<String> paramList, HashMap<String, LocalMediaInfo> paramHashMap, List<SlideItemInfo> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramList.size())
    {
      localObject1 = (LocalMediaInfo)paramHashMap.get(paramList.get(i));
      if (localObject1 == null) {
        break label365;
      }
    }
    label60:
    label336:
    label356:
    label359:
    label365:
    for (Object localObject1 = new SlideItemInfo((LocalMediaInfo)localObject1);; localObject1 = null)
    {
      int j;
      SlideItemInfo localSlideItemInfo1;
      if (paramList1 != null)
      {
        j = 0;
        localObject2 = localObject1;
        if (j >= paramList1.size()) {
          break label336;
        }
        localSlideItemInfo1 = (SlideItemInfo)paramList1.get(j);
        if (localSlideItemInfo1 == null) {
          break label359;
        }
      }
      for (Object localObject2 = localSlideItemInfo1.jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo;; localObject2 = null)
      {
        if ((localObject2 != null) && (((String)paramList.get(i)).equals(((LocalMediaInfo)localObject2).path)))
        {
          SlideItemInfo localSlideItemInfo2 = (SlideItemInfo)paramList1.get(j);
          if ((localObject1 != null) && (localSlideItemInfo2 != null))
          {
            ((SlideItemInfo)localObject1).jdField_b_of_type_Long = localSlideItemInfo2.jdField_b_of_type_Long;
            ((SlideItemInfo)localObject1).jdField_c_of_type_Long = localSlideItemInfo2.jdField_c_of_type_Long;
            ((SlideItemInfo)localObject1).jdField_e_of_type_Int = localSlideItemInfo2.jdField_e_of_type_Int;
            ((SlideItemInfo)localObject1).f = localSlideItemInfo2.f;
            ((SlideItemInfo)localObject1).d = localSlideItemInfo2.d;
            ((SlideItemInfo)localObject1).jdField_b_of_type_Boolean = localSlideItemInfo2.jdField_b_of_type_Boolean;
            ((SlideItemInfo)localObject1).jdField_c_of_type_Int = localSlideItemInfo2.jdField_c_of_type_Int;
            ((SlideItemInfo)localObject1).jdField_a_of_type_Boolean = localSlideItemInfo2.jdField_a_of_type_Boolean;
            ((SlideItemInfo)localObject1).jdField_c_of_type_Boolean = localSlideItemInfo2.jdField_c_of_type_Boolean;
            ((SlideItemInfo)localObject1).jdField_e_of_type_JavaLangString = localSlideItemInfo2.jdField_e_of_type_JavaLangString;
            ((SlideItemInfo)localObject1).jdField_a_of_type_Int = localSlideItemInfo2.jdField_a_of_type_Int;
            ((SlideItemInfo)localObject1).jdField_a_of_type_JavaLangString = localSlideItemInfo2.jdField_a_of_type_JavaLangString;
            if (((SlideItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo == null) {
              break label356;
            }
            ((SlideItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaWidth = ((LocalMediaInfo)localObject2).mediaWidth;
            ((SlideItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.mediaHeight = ((LocalMediaInfo)localObject2).mediaHeight;
            ((SlideItemInfo)localObject1).jdField_a_of_type_ComTencentMobileqqActivityPhotoLocalMediaInfo.rotation = ((LocalMediaInfo)localObject2).rotation;
          }
        }
        for (;;)
        {
          j += 1;
          break label60;
          localObject1 = localSlideItemInfo1;
          continue;
          localObject2 = localObject1;
          localArrayList.add(localObject2);
          i += 1;
          break;
          return localArrayList;
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, List<String> paramList)
  {
    wxj.a("video_edit", "choose_slides", 0, 0, new String[] { String.valueOf(paramList.size()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xnd
 * JD-Core Version:    0.7.0.1
 */