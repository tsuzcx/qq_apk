import com.tencent.biz.qqstory.model.item.QQUserUIItem;

public class xgk
  extends xgn
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
    jdField_a_of_type_JavaLangString = "src_type=internal&version=1&uin=%s&usertype=%s&unionid=%s&fromId=%s&storysharefrom=%s" + wnu.a(2131698598);
    b = "mqqapi://qstory/infoCard?" + jdField_a_of_type_JavaLangString;
    jdField_c_of_type_JavaLangString = "https://story.now.qq.com/mobile/transfer.html?" + jdField_a_of_type_JavaLangString + "&actionnamekey=3&one_page=0";
  }
  
  public xgk(QQUserUIItem paramQQUserUIItem)
  {
    this.k = paramQQUserUIItem.qq;
    this.i = paramQQUserUIItem.headUrl;
    int i;
    if (paramQQUserUIItem.isVip)
    {
      i = 1;
      this.jdField_c_of_type_Int = i;
      this.l = paramQQUserUIItem.uid;
      this.d = (paramQQUserUIItem.nickName + anzj.a(2131704652) + win.jdField_a_of_type_JavaLangString);
      this.f = ("[" + win.jdField_a_of_type_JavaLangString + anzj.a(2131704655) + paramQQUserUIItem.nickName + anzj.a(2131704658) + win.jdField_a_of_type_JavaLangString);
      this.g = (paramQQUserUIItem.nickName + anzj.a(2131704657) + win.jdField_a_of_type_JavaLangString + anzj.a(2131704651) + win.jdField_a_of_type_JavaLangString + anzj.a(2131704654) + wnu.a(2131698595) + anzj.a(2131704653));
      if (paramQQUserUIItem.videoCount > 0) {
        break label331;
      }
    }
    label331:
    for (this.e = "0个小视频";; this.e = (paramQQUserUIItem.videoCount + anzj.a(2131704656)))
    {
      this.j = ("#" + win.jdField_a_of_type_JavaLangString + "# " + this.d + "（" + this.e + "）");
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
  
  protected void a(xhu paramxhu)
  {
    super.a(paramxhu);
    if ((paramxhu != null) && ((paramxhu instanceof xhv))) {
      ((xhv)paramxhu).jdField_a_of_type_JavaLangString = (xif.b(this.i) + "#private_share_cache");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xgk
 * JD-Core Version:    0.7.0.1
 */