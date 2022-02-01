import com.tencent.qphone.base.util.QLog;

class jhx
  implements jia.a
{
  jhx(jht paramjht) {}
  
  public void a(jia paramjia)
  {
    if (paramjia == this.this$0.jdField_a_of_type_Jia)
    {
      this.this$0.jdField_a_of_type_Jia = null;
      this.this$0.jdField_a_of_type_Jia$a = null;
      this.this$0.a("onGetRedBagResult", jht.d(this.this$0), paramjia.b);
      return;
    }
    QLog.w("AVRedBag", 1, "onGetRedBagResult,  GetRedBag不一致，callback[" + paramjia + "], src[" + this.this$0.jdField_a_of_type_Jia + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jhx
 * JD-Core Version:    0.7.0.1
 */