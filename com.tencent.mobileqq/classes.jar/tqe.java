import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tqe
  extends tqj
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "&type=" + "onedaylist" + "&feedid=%s&identify=%d";
  private int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + sxp.a(2131699674);
  }
  
  public tqe(StoryVideoItem paramStoryVideoItem, String paramString, int paramInt)
  {
    Object localObject = ((uwa)tdc.a(11)).a(paramString);
    if (localObject == null) {
      return;
    }
    tdo localtdo = (tdo)tdc.a(2);
    localObject = (QQUserUIItem)((FeedItem)localObject).getOwner();
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.jdField_d_of_type_JavaLangString = (((QQUserUIItem)localObject).nickName + ajyc.a(2131704437) + ssi.jdField_a_of_type_JavaLangString);
    this.e = (((QQUserUIItem)localObject).nickName + ajyc.a(2131704436) + ssi.jdField_a_of_type_JavaLangString);
    this.f = localtdo.a(((QQUserUIItem)localObject).getUnionId(), false);
    int i;
    if (((QQUserUIItem)localObject).isMe())
    {
      i = 0;
      this.jdField_a_of_type_Int = i;
      this.h = paramString;
      this.jdField_d_of_type_Int = paramInt;
      this.jdField_c_of_type_JavaLangString = ((QQUserUIItem)localObject).nickName;
      this.g = ((QQUserUIItem)localObject).getUnionId();
      this.k = a(this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime);
      paramStoryVideoItem = new SimpleDateFormat("M月d日").format(Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime));
      this.i = (paramStoryVideoItem + " · " + this.jdField_d_of_type_Int + ajyc.a(2131704439));
      this.j = ("#" + ssi.jdField_a_of_type_JavaLangString + "# " + this.jdField_c_of_type_JavaLangString + ajyc.a(2131704438) + ssi.jdField_a_of_type_JavaLangString + "（" + this.i + "）");
      if (this.jdField_a_of_type_Int != 0) {
        break label400;
      }
    }
    label400:
    for (paramInt = 8;; paramInt = 9)
    {
      this.jdField_c_of_type_Int = paramInt;
      if (this.jdField_a_of_type_Int != 0) {
        break label406;
      }
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 81, 82, 83, 84, 85, 45 };
      return;
      i = 1;
      break;
    }
    label406:
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 69, 70, 71, 72, 73, 45 };
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&ptype=%d&type=onedaylist&feedid=%s&identify=%d&sharefromtype=%d", new Object[] { this.f, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.g, Integer.valueOf(5), this.h, Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]) });
    }
    return String.format(b, new Object[] { this.f, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.g, Integer.valueOf(5), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), this.h, Integer.valueOf(this.jdField_a_of_type_Int) });
  }
  
  public String a(String paramString, long paramLong)
  {
    String str = new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    return paramString + ajyc.a(2131704432) + str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqe
 * JD-Core Version:    0.7.0.1
 */