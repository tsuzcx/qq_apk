import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.richstatus.RichStatus;

class auji
  extends acfd
{
  auji(aujf paramaujf) {}
  
  protected void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.isActive()) && (paramBoolean) && (aujf.p(this.this$0) != null) && (aqft.equalsWithNullCheck(paramString, aujf.q(this.this$0).getCurrentAccountUin()))) {
      aujf.a(this.this$0).wd(paramString);
    }
  }
  
  protected void onUpdateFriendInfo(String paramString, boolean paramBoolean)
  {
    if ((paramBoolean) && (aujf.r(this.this$0) != null) && (aqft.equalsWithNullCheck(paramString, aujf.s(this.this$0).getCurrentAccountUin()))) {
      this.this$0.bTL();
    }
  }
  
  protected void onUpdateFriendList(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean2) && (paramBoolean1)) {
      this.this$0.bTL();
    }
  }
  
  protected void onUpdateSignature(boolean paramBoolean, String[] paramArrayOfString)
  {
    String str;
    int i;
    if ((paramBoolean) && (paramArrayOfString != null) && (paramArrayOfString.length > 0))
    {
      str = aujf.t(this.this$0).getCurrentAccountUin();
      i = 0;
    }
    for (;;)
    {
      if ((str != null) && (i < paramArrayOfString.length))
      {
        if (!str.equals(paramArrayOfString[i])) {
          break label116;
        }
        paramArrayOfString = ((acff)aujf.u(this.this$0).getManager(51)).a(str);
        if ((paramArrayOfString != null) && (paramArrayOfString.getRichStatus() != null))
        {
          aujf.b(this.this$0, paramArrayOfString.getRichStatus().getPlainText());
          aujf.a(this.this$0).Bm(aujf.b(this.this$0));
        }
      }
      return;
      label116:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auji
 * JD-Core Version:    0.7.0.1
 */