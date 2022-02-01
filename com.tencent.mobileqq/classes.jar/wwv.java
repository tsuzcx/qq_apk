import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class wwv
  extends wwy
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
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + weg.a(2131699184);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "https://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
  }
  
  public wwv(QQUserUIItem paramQQUserUIItem)
  {
    this.k = paramQQUserUIItem.qq;
    this.i = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.jdField_c_of_type_Int = i;
      this.l = paramQQUserUIItem.uid;
      this.d = (paramQQUserUIItem.nickName + anvx.a(2131705233) + vzh.jdField_a_of_type_JavaLangString);
      this.f = ("[" + vzh.jdField_a_of_type_JavaLangString + anvx.a(2131705236) + paramQQUserUIItem.nickName + anvx.a(2131705239) + vzh.jdField_a_of_type_JavaLangString);
      this.g = (paramQQUserUIItem.nickName + anvx.a(2131705238) + vzh.jdField_a_of_type_JavaLangString + anvx.a(2131705232) + vzh.jdField_a_of_type_JavaLangString + anvx.a(2131705235) + weg.a(2131699181) + anvx.a(2131705234));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.e = "0个小视频";; this.e = (paramQQUserUIItem.videoCount + anvx.a(2131705237)))
    {
      this.j = ("#" + vzh.jdField_a_of_type_JavaLangString + "# " + this.d + "（" + this.e + "）");
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
  
  protected void a(wyf paramwyf)
  {
    super.a(paramwyf);
    if ((paramwyf != null) && ((paramwyf instanceof wyg))) {
      ((wyg)paramwyf).jdField_a_of_type_JavaLangString = (wyq.b(this.i) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wwv
 * JD-Core Version:    0.7.0.1
 */