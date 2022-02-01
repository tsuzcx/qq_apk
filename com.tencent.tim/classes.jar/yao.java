import com.tencent.qphone.base.util.QLog;

class yao
  implements acgk.a
{
  yao(yam paramyam) {}
  
  public boolean a(acgl.c paramc)
  {
    if (QLog.isDevelopLevel()) {
      ajrk.f(this.this$0.TAG, "onShowHotchatNote", new Object[] { paramc });
    }
    if (paramc == null)
    {
      if ((this.this$0.b.bHQ) && (this.this$0.jdField_a_of_type_Apmp != null)) {
        this.this$0.jdField_a_of_type_Apmp.f(this.this$0.app, this.this$0.mContext, null, null);
      }
      return false;
    }
    if (this.this$0.jdField_a_of_type_Apmp == null) {
      this.this$0.jdField_a_of_type_Apmp = new apmp(this.this$0.app, this.this$0.mActivity, this.this$0.sessionInfo, yam.a(this.this$0), yam.a(this.this$0), this.this$0.jdField_a_of_type_Apat, this.this$0.aaR, null);
    }
    this.this$0.jdField_a_of_type_Apmp.f(this.this$0.app, this.this$0.mContext, paramc.content, paramc.url);
    this.this$0.b.bHQ = true;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     yao
 * JD-Core Version:    0.7.0.1
 */