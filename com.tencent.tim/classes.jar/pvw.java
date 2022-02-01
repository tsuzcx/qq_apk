import com.tencent.mobileqq.widget.QQToast;

class pvw
  extends pmd
{
  pvw(pvv parampvv) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    super.a(paramBoolean1, paramBoolean2, paramInt, paramString);
    if ((paramBoolean1) && (paramBoolean2)) {
      QQToast.a(this.this$0.a.mContext, 2, acfp.m(2131708535), 0).show();
    }
    do
    {
      return;
      if ((!paramBoolean1) && (paramBoolean2))
      {
        QQToast.a(this.this$0.a.mContext, 1, acfp.m(2131708540), 0).show();
        return;
      }
    } while ((paramBoolean1) || (paramBoolean2));
    QQToast.a(this.this$0.a.mContext, 1, acfp.m(2131708536), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pvw
 * JD-Core Version:    0.7.0.1
 */