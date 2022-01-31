import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class tqf
  extends tqi
{
  public static final String a;
  public static final String b;
  public static final String c;
  private final int[] a;
  private int c;
  private String k;
  private String l;
  
  static
  {
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + sxp.a(2131699674);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
  }
  
  public tqf(QQUserUIItem paramQQUserUIItem)
  {
    this.k = paramQQUserUIItem.qq;
    this.i = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.jdField_c_of_type_Int = i;
      this.l = paramQQUserUIItem.uid;
      this.d = (paramQQUserUIItem.nickName + ajyc.a(2131705749) + ssi.jdField_a_of_type_JavaLangString);
      this.f = ("[" + ssi.jdField_a_of_type_JavaLangString + ajyc.a(2131705752) + paramQQUserUIItem.nickName + ajyc.a(2131705755) + ssi.jdField_a_of_type_JavaLangString);
      this.g = (paramQQUserUIItem.nickName + ajyc.a(2131705754) + ssi.jdField_a_of_type_JavaLangString + ajyc.a(2131705748) + ssi.jdField_a_of_type_JavaLangString + ajyc.a(2131705751) + sxp.a(2131699671) + ajyc.a(2131705750));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.e = "0个小视频";; this.e = (paramQQUserUIItem.videoCount + ajyc.a(2131705753)))
    {
      this.j = ("#" + ssi.jdField_a_of_type_JavaLangString + "# " + this.d + "（" + this.e + "）");
      this.jdField_a_of_type_Int = 102;
      this.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ArrayOfInt = new int[] { 0, 13, 14, 15, 16, 17, 18 };
      return;
      i = 0;
      break;
    }
  }
  
  protected String a(int paramInt)
  {
    if (paramInt == 1) {
      return String.format(b, new Object[] { this.k, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
    }
    return String.format(jdField_c_of_type_JavaLangString, new Object[] { this.k, Integer.valueOf(this.jdField_c_of_type_Int), this.l, Integer.valueOf(this.jdField_a_of_type_ArrayOfInt[paramInt]), b(paramInt) });
  }
  
  protected void a(trp paramtrp)
  {
    super.a(paramtrp);
    if ((paramtrp != null) && ((paramtrp instanceof trq))) {
      ((trq)paramtrp).jdField_a_of_type_JavaLangString = (tsa.b(this.i) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqf
 * JD-Core Version:    0.7.0.1
 */