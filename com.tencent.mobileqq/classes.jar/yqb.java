import com.tencent.mobileqq.apollo.store.ApolloGuestsPresenter;
import com.tencent.mobileqq.apollo.store.ApolloResDownloader.OnApolloDownLoadListener;
import com.tencent.mobileqq.apollo.store.IApolloGuestsView;
import com.tencent.qphone.base.util.QLog;

public class yqb
  implements ApolloResDownloader.OnApolloDownLoadListener
{
  public yqb(ApolloGuestsPresenter paramApolloGuestsPresenter) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "res download sucess roleId=" + paramInt1 + "dressIds=" + paramArrayOfInt);
      }
      if (ApolloGuestsPresenter.a(this.a) != null) {
        ApolloGuestsPresenter.a(this.a).e();
      }
      this.a.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     yqb
 * JD-Core Version:    0.7.0.1
 */