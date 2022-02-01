import com.tencent.qphone.base.util.QLog;

class abti
  implements abto.b
{
  abti(abtg paramabtg) {}
  
  public void onDownLoadFinish(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloGuestsPresenter", 2, "res download sucess roleId=" + paramInt1 + "dressIds=" + paramArrayOfInt);
      }
      if (abtg.a(this.a) != null) {
        abtg.a(this.a).cFf();
      }
      this.a.cEZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abti
 * JD-Core Version:    0.7.0.1
 */