import com.tencent.qphone.base.util.QLog;

final class abtu
  extends aquy
{
  abtu(int paramInt, abto.d paramd) {}
  
  public void onDone(aquz paramaquz)
  {
    super.onDone(paramaquz);
    if (3 == paramaquz.getStatus())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio ok id" + this.val$audioId);
      }
      if (this.a != null) {
        this.a.aR(true, this.val$audioId);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ApolloResDownloader", 2, "downloadApolloAudio error id->" + this.val$audioId + " task.getStatus()->" + paramaquz.getStatus());
      }
    } while (this.a == null);
    this.a.aR(false, this.val$audioId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abtu
 * JD-Core Version:    0.7.0.1
 */