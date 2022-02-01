import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class aujh
  extends accn
{
  aujh(aujf paramaujf) {}
  
  protected void onCardDownload(boolean paramBoolean, Object paramObject)
  {
    if ((paramBoolean) && (aujf.m(this.this$0) != null) && ((paramObject instanceof Card)) && (aqft.equalsWithNullCheck(((Card)paramObject).uin, aujf.n(this.this$0).getCurrentAccountUin()))) {
      aujf.a(this.this$0, (Card)paramObject);
    }
  }
  
  protected void onGetDetailInfo(boolean paramBoolean, String paramString, Card paramCard)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MePresenter", 2, "onGetDetailInfo, isSuccess = " + paramBoolean);
    }
    if ((paramBoolean) && (aujf.k(this.this$0) != null) && (aqft.equalsWithNullCheck(paramString, aujf.l(this.this$0).getCurrentAccountUin()))) {
      aujf.a(this.this$0, paramCard);
    }
  }
  
  protected void onSetDetailInfo(boolean paramBoolean, int paramInt, Card paramCard)
  {
    if ((paramBoolean) && (paramInt == 0)) {
      aujf.a(this.this$0, paramCard);
    }
  }
  
  protected void onUpdateAvatar(boolean paramBoolean, String paramString)
  {
    if ((this.this$0.isActive()) && (paramBoolean) && (aujf.i(this.this$0) != null) && (aqft.equalsWithNullCheck(paramString, aujf.j(this.this$0).getCurrentAccountUin()))) {
      aujf.a(this.this$0).wd(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aujh
 * JD-Core Version:    0.7.0.1
 */