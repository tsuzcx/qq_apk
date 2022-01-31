import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class tqe
  extends tre
{
  public static final String a;
  public static final String b = jdField_a_of_type_JavaLangString + "&et=%d&time_zone=%d";
  protected int a;
  private final int[] a;
  
  static
  {
    jdField_a_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&actionnamekey=1&storysharefrom=%s&sharefromtype=%d&one_page=0" + sxm.a(2131699685);
  }
  
  public tqe(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt1, int paramInt2)
  {
    tdl localtdl = (tdl)tcz.a(2);
    this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = paramStoryVideoItem;
    this.h = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_e_of_type_Int = paramInt2;
    this.f = paramStoryVideoItem.mOwnerUid;
    this.jdField_e_of_type_JavaLangString = localtdl.a(this.f, false);
    this.c = bbkk.a(paramShareGroupItem.name, 0, 16, "...");
    this.g = paramStoryVideoItem.mDoodleText;
    this.jdField_d_of_type_JavaLangString = a();
    this.k = (ajya.a(2131713918) + this.c + ajya.a(2131713926) + ssf.jdField_a_of_type_JavaLangString);
    this.l = (this.c + "\n" + paramInt2 + ajya.a(2131713922));
    new SimpleDateFormat("M月d日").format(Long.valueOf(paramLong));
    this.i = b();
    this.j = ("#" + ssf.jdField_a_of_type_JavaLangString + "# " + a() + "（" + this.i + "）");
    this.jdField_d_of_type_Int = 11;
    this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 0, 97, 98, 99, 100, 101 };
  }
  
  public static tqe a(ShareGroupItem paramShareGroupItem, StoryVideoItem paramStoryVideoItem, String paramString, long paramLong, int paramInt)
  {
    return new tqe(paramShareGroupItem, paramStoryVideoItem, paramString, paramLong, 9, paramInt);
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format("mqqapi://qstory/openVideo?src_type=app&version=1&fromId=17&videoOwnerUin=%s&videoId=%s&unionid=%s&feedid=%s&ptype=%d&identify=1&type=onedaylist&et=%d&time_zone=%d", new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime / 1000L), Integer.valueOf(vzl.a()) });
    }
    return String.format(b, new Object[] { this.jdField_e_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mVid, this.f, this.h, Integer.valueOf(this.jdField_a_of_type_Int), b(paramInt), Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), Long.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem.mCreateTime / 1000L), Integer.valueOf(vzl.a()) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqe
 * JD-Core Version:    0.7.0.1
 */