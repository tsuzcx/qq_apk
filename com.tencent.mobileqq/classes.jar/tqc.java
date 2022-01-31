import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class tqc
  extends tqf
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
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + sxm.a(2131699685);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "http://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
  }
  
  public tqc(QQUserUIItem paramQQUserUIItem)
  {
    this.k = paramQQUserUIItem.qq;
    this.i = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.jdField_c_of_type_Int = i;
      this.l = paramQQUserUIItem.uid;
      this.d = (paramQQUserUIItem.nickName + ajya.a(2131705760) + ssf.jdField_a_of_type_JavaLangString);
      this.f = ("[" + ssf.jdField_a_of_type_JavaLangString + ajya.a(2131705763) + paramQQUserUIItem.nickName + ajya.a(2131705766) + ssf.jdField_a_of_type_JavaLangString);
      this.g = (paramQQUserUIItem.nickName + ajya.a(2131705765) + ssf.jdField_a_of_type_JavaLangString + ajya.a(2131705759) + ssf.jdField_a_of_type_JavaLangString + ajya.a(2131705762) + sxm.a(2131699682) + ajya.a(2131705761));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.e = "0个小视频";; this.e = (paramQQUserUIItem.videoCount + ajya.a(2131705764)))
    {
      this.j = ("#" + ssf.jdField_a_of_type_JavaLangString + "# " + this.d + "（" + this.e + "）");
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
  
  protected void a(trm paramtrm)
  {
    super.a(paramtrm);
    if ((paramtrm != null) && ((paramtrm instanceof trn))) {
      ((trn)paramtrm).jdField_a_of_type_JavaLangString = (trx.b(this.i) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tqc
 * JD-Core Version:    0.7.0.1
 */