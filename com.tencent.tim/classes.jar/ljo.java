import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ljo
  implements ljh.e<BEAN>
{
  ljo(ljm paramljm) {}
  
  public void a(boolean paramBoolean, List<BEAN> paramList, int paramInt, String paramString)
  {
    if (ljm.a(this.a) != null)
    {
      if (!paramBoolean) {
        break label69;
      }
      ljm.a(this.a).setListData(paramList, true);
      if (ljm.a(this.a).Cz()) {
        ljm.a(this.a).setFooterHasMore();
      }
    }
    else
    {
      return;
    }
    ljm.a(this.a).setFooterNoMore();
    return;
    label69:
    QLog.i("ListPresenter", 2, "loadNextPage error, errorCode=" + paramInt + ", errorMsg= " + paramString);
    ljm.a(this.a).setFooterError(paramInt, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ljo
 * JD-Core Version:    0.7.0.1
 */